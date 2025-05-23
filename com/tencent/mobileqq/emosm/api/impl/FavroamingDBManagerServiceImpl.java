package com.tencent.mobileqq.emosm.api.impl;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DiyDoutuHelper;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.FunnyPicHelperConstant;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.f;
import com.tencent.mobileqq.emosm.favroaming.g;
import com.tencent.mobileqq.emosm.favroaming.m;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteLottieEmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ei;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import tencent.im.cs.faceroam_sso.faceroam_sso$EmojiItem;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FavroamingDBManagerServiceImpl extends CustomEmotionRoamingDBManagerBase<CustomEmotionData> implements IFavroamingDBManagerService<CustomEmotionData> {
    public static final String TAG = "FavroamingDBManager";
    private boolean hasReportProcessInterrupt;
    private List<jb1.a> updateListeners = new CopyOnWriteArrayList();

    private void checkAllEmoPath(List<CustomEmotionData> list, EntityManager entityManager) {
        int size;
        QLog.d("FavroamingDBManager", 1, "getEmoticonDataList from db checkAllEmoPath begin");
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            size = 0;
        } else {
            try {
                size = list.size();
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        for (int i3 = size - 1; i3 > -1; i3--) {
            CustomEmotionData customEmotionData = list.get(i3);
            String str = customEmotionData.emoPath;
            String str2 = AppConstants.SDCARD_IMG_FAVORITE;
            if (!str.startsWith(str2) && str.contains(AppConstants.SDCARD_IMG_FAVORITE_SUFFIX) && !customEmotionData.isMarkFace) {
                customEmotionData.emoPath = str.replaceFirst(".+/Tencent/QQ_Favorite/", str2);
                QLog.d("FavroamingDBManager", 2, "getEmoticonDataList from db checkEmoPath: convert err path:" + str + " -> " + customEmotionData.emoPath);
                arrayList.add(new UpdateTransaction(customEmotionData));
            }
        }
        if (!arrayList.isEmpty()) {
            entityManager.doMultiDBOperateByTransaction(arrayList);
        }
    }

    private CustomEmotionData createCustomEmotionDataByResId(faceroam_sso$EmojiItem faceroam_sso_emojiitem, String str, int i3, boolean z16) {
        BaseQQAppInterface baseQQAppInterface = this.app;
        if (baseQQAppInterface == null) {
            return null;
        }
        String currentAccountUin = baseQQAppInterface.getCurrentAccountUin();
        String str2 = faceroam_sso_emojiitem.file_id.get();
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        CustomEmotionData customEmotionData = new CustomEmotionData();
        if (faceroam_sso_emojiitem.flag.get() == 1) {
            customEmotionData.isMarkFace = true;
            customEmotionData.uin = currentAccountUin;
            customEmotionData.emoPath = String.valueOf(faceroam_sso_emojiitem.pkg_id.get());
            customEmotionData.eId = String.valueOf(faceroam_sso_emojiitem.pic_id.get());
            customEmotionData.resid = str2;
            customEmotionData.RomaingType = str;
            customEmotionData.url = faceroam_sso_emojiitem.download_url.get();
            customEmotionData.emoId = i3;
            customEmotionData.isAPNG = z16;
            customEmotionData.jumpId = faceroam_sso_emojiitem.jump_id.get();
            customEmotionData.checkMarketFace("createCustomEmotionDataByResId");
        } else if (faceroam_sso_emojiitem.flag.get() == 0) {
            String valueOf = String.valueOf(faceroam_sso_emojiitem.pic_id.get());
            if (!TextUtils.isEmpty(valueOf)) {
                if (valueOf.contains(FunnyPicHelperConstant.FUNYPIC_PREFIX_REPLACE)) {
                    String replace = valueOf.replace(FunnyPicHelperConstant.FUNYPIC_PREFIX_REPLACE, FunnyPicHelperConstant.FUNYPIC_PREFIX);
                    customEmotionData.eId = replace;
                    if (QLog.isColorLevel()) {
                        QLog.d("FavroamingDBManager", 2, "download funnyPic name.original->" + replace);
                    }
                } else if (valueOf.contains(DiyDoutuHelper.DIY_EMOJI_PREFIX)) {
                    customEmotionData.eId = String.valueOf(faceroam_sso_emojiitem.pkg_id.get());
                    if (QLog.isColorLevel()) {
                        QLog.d("FavroamingDBManager", 2, "download diyemoji name.original->" + str2);
                    }
                }
            }
            customEmotionData.isMarkFace = false;
            customEmotionData.uin = currentAccountUin;
            customEmotionData.emoPath = FavEmoConstant.getFavRoamingPath(str2);
            customEmotionData.resid = str2;
            customEmotionData.md5 = faceroam_sso_emojiitem.md5.get();
            customEmotionData.url = faceroam_sso_emojiitem.download_url.get();
            customEmotionData.RomaingType = str;
            customEmotionData.emoId = i3;
            customEmotionData.jumpId = faceroam_sso_emojiitem.jump_id.get();
        }
        if (QLog.isColorLevel()) {
            QLog.d("FavroamingDBManager", 2, "createCustomEmotionDataByResIdList : emotionData = " + customEmotionData + ", emotion name:" + str2);
        }
        return customEmotionData;
    }

    private int getMaxEmoId(List<CustomEmotionData> list) {
        int i3 = 1;
        if (list != null) {
            Iterator<CustomEmotionData> it = list.iterator();
            while (it.hasNext()) {
                int i16 = it.next().emoId;
                if (i3 < i16) {
                    i3 = i16;
                }
            }
        }
        return i3;
    }

    private int getUploadSize(List<CustomEmotionData> list, List<CustomEmotionData> list2) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                CustomEmotionData customEmotionData = list.get(size);
                if (customEmotionData != null && !list2.contains(customEmotionData)) {
                    list.remove(size);
                }
            }
            return list.size();
        }
        return 0;
    }

    private void removeMergeEmoticon(List<faceroam_sso$EmojiItem> list, int i3, List<CustomEmotionData> list2, List<CustomEmotionData> list3) {
        boolean z16;
        if (list != null) {
            List<CustomEmotionData> emoticonDataList = getEmoticonDataList();
            if (emoticonDataList != null) {
                QLog.d("FavroamingDBManager", 1, "rm emo data tempList: ", Integer.valueOf(emoticonDataList.size()));
            }
            for (int i16 = 0; i16 < list.size(); i16++) {
                faceroam_sso$EmojiItem faceroam_sso_emojiitem = list.get(i16);
                CustomEmotionData customEmotionDataBYResId = getCustomEmotionDataBYResId(emoticonDataList, faceroam_sso_emojiitem.file_id.get());
                if (customEmotionDataBYResId == null) {
                    QLog.d("FavroamingDBManager", 1, "rm emo data create.");
                    if (faceroam_sso_emojiitem.file_type.get() == 2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    i3++;
                    customEmotionDataBYResId = createCustomEmotionDataByResId(faceroam_sso_emojiitem, FavEmoConstant.ROAMING_TYPE_PANEL, i3, z16);
                } else if (list2 != null) {
                    if ("init".equals(customEmotionDataBYResId.RomaingType)) {
                        customEmotionDataBYResId.RomaingType = "isUpdate";
                    }
                    if (TextUtils.isEmpty(customEmotionDataBYResId.url) && this.app != null) {
                        customEmotionDataBYResId.url = faceroam_sso_emojiitem.download_url.get();
                        QLog.i("FavroamingDBManager", 1, "url is null because of old db data exception, fix it. data:" + customEmotionDataBYResId);
                    }
                    list2.remove(customEmotionDataBYResId);
                }
                list3.add(customEmotionDataBYResId);
            }
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("emoticon_fav_add_local_122078393", false);
        QLog.i("FavroamingDBManager", 1, "emoticon_fav_add_local_122078393:" + isSwitchOn);
        if (isSwitchOn && list2 != null && list2.size() > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("FavroamingDBManager", 1, "localNew=" + list2.size());
            }
            list3.addAll(list2);
        }
    }

    private void removeRedundancyEmoticonList(List<String> list) {
        if (list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            List<CustomEmotionData> emoticonDataList = getEmoticonDataList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                CustomEmotionData customEmotionDataBYResId = getCustomEmotionDataBYResId(emoticonDataList, it.next());
                if (customEmotionDataBYResId != null) {
                    arrayList.add(customEmotionDataBYResId);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("FavroamingDBManager", 1, "deleDatas=" + arrayList.size());
            }
            deleteCustomEmotionList(arrayList);
        }
    }

    private List<CustomEmotionData> updateCustomEmotionData(List<CustomEmotionData> list) {
        int size = list.size();
        int i3 = FavEmoConstant.FAV_ROAMING_MAX_COUNT;
        if (size > i3) {
            list = list.subList(0, i3);
        }
        for (int i16 = 0; i16 < list.size(); i16++) {
            CustomEmotionData customEmotionData = list.get(i16);
            if (i16 <= FavEmoConstant.FAV_LOCAL_MAX_COUNT) {
                String str = customEmotionData.RomaingType;
                if (str != null) {
                    if (str.equals(FavEmoConstant.ROAMING_TYPE_OVERFLOW_DOWNLOADED)) {
                        customEmotionData.RomaingType = "isUpdate";
                    } else if (!customEmotionData.RomaingType.equals("isUpdate") && !customEmotionData.RomaingType.equals("init") && !customEmotionData.RomaingType.equals("needUpload") && !customEmotionData.RomaingType.equals("failed")) {
                        customEmotionData.RomaingType = FavEmoConstant.ROAMING_TYPE_PANEL;
                    }
                } else {
                    customEmotionData.RomaingType = FavEmoConstant.ROAMING_TYPE_PANEL;
                }
            } else if (i16 <= FavEmoConstant.FAV_ROAMING_MAX_COUNT) {
                String str2 = customEmotionData.RomaingType;
                if (str2 != null) {
                    if (str2.equals("isUpdate")) {
                        customEmotionData.RomaingType = FavEmoConstant.ROAMING_TYPE_OVERFLOW_DOWNLOADED;
                    } else if (!customEmotionData.RomaingType.equals(FavEmoConstant.ROAMING_TYPE_OVERFLOW_DOWNLOADED) && !customEmotionData.RomaingType.equals("init") && !customEmotionData.RomaingType.equals("needUpload") && !customEmotionData.RomaingType.equals("failed")) {
                        customEmotionData.RomaingType = "overflow";
                    }
                } else {
                    customEmotionData.RomaingType = "overflow";
                }
            }
            if (!TextUtils.isEmpty(customEmotionData.url) && customEmotionData.url.startsWith("http://")) {
                customEmotionData.url = customEmotionData.url.replace("http://", "https://");
            }
        }
        return list;
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService
    public void addFavRoamingUpdateListener(jb1.a aVar) {
        if (!this.updateListeners.contains(aVar)) {
            this.updateListeners.add(aVar);
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService
    public void delOverflow(List<CustomEmotionData> list) {
        if (list == null) {
            return;
        }
        deleteCustomEmotionList(list);
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService
    public /* bridge */ /* synthetic */ void deleteCustomEmotion(CustomEmotionData customEmotionData) {
        super.deleteCustomEmotion((FavroamingDBManagerServiceImpl) customEmotionData);
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService
    public void deleteDB(List<String> list) {
        List<CustomEmotionData> emoticonDatasByType;
        if (list == null || (emoticonDatasByType = getEmoticonDatasByType("needDel")) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            String str = list.get(i3);
            for (int i16 = 0; i16 < emoticonDatasByType.size(); i16++) {
                CustomEmotionData customEmotionData = emoticonDatasByType.get(i16);
                String str2 = customEmotionData.resid;
                if (str2 != null && !"".equals(str2) && customEmotionData.resid.equals(str)) {
                    updateCache(customEmotionData, 4);
                    arrayList.add(customEmotionData);
                }
            }
        }
        updateCustomEmotionDataListInDB(arrayList, 4);
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase
    public Class getDBClass() {
        return CustomEmotionData.class;
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase, com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService
    public synchronized List<CustomEmotionData> getEmoticonDataList() {
        ArrayList arrayList = new ArrayList();
        if (this.customEmotionDbCache.size() > 0) {
            for (T t16 : this.customEmotionDbCache) {
                if (t16 != null) {
                    arrayList.add(t16);
                }
            }
            return arrayList;
        }
        return getEmoticonDataListFromDB();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
    
        if (r6 != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00da, code lost:
    
        com.tencent.mobileqq.app.utils.DiySecureFileHelper.commitVersion(com.tencent.mobileqq.app.utils.DiySecureFileHelper.KEY_QQFAVORITE_DB, r1.getCurrentUin(), 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d7, code lost:
    
        r3.end();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d5, code lost:
    
        if (r6 != false) goto L43;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<CustomEmotionData> getEmoticonDataListFromDB() {
        boolean z16;
        int size;
        List<CustomEmotionData> arrayList = new ArrayList();
        BaseQQAppInterface baseQQAppInterface = this.app;
        if (baseQQAppInterface == null) {
            return arrayList;
        }
        EntityManager createEntityManager = baseQQAppInterface.getEntityManagerFactory().createEntityManager();
        boolean z17 = false;
        if (createEntityManager != null) {
            arrayList = createEntityManager.query(getDBClass(), false, null, null, null, null, null, null);
            if (DiySecureFileHelper.getVersion(DiySecureFileHelper.KEY_QQFAVORITE_DB, baseQQAppInterface.getCurrentUin()) < 1) {
                EntityTransaction transaction = createEntityManager.getTransaction();
                try {
                    if (arrayList == null) {
                        size = 0;
                    } else {
                        try {
                            size = arrayList.size();
                        } catch (Exception e16) {
                            e = e16;
                            z16 = false;
                            e.printStackTrace();
                        } catch (Throwable th5) {
                            th = th5;
                            if (z17) {
                                transaction.end();
                            }
                            throw th;
                        }
                    }
                    z16 = false;
                    for (int i3 = size - 1; i3 > -1; i3--) {
                        try {
                            CustomEmotionData customEmotionData = (CustomEmotionData) arrayList.get(i3);
                            String str = customEmotionData.emoPath;
                            StringBuilder sb5 = new StringBuilder();
                            String str2 = AppConstants.SDCARD_IMG_FAVORITE;
                            sb5.append(str2);
                            sb5.append(customEmotionData.resid);
                            if (str.equals(sb5.toString())) {
                                customEmotionData.emoPath = str2 + DiySecureFileHelper.secureUin(customEmotionData.resid);
                                if (!z16) {
                                    transaction.begin();
                                    z16 = true;
                                }
                                createEntityManager.update(customEmotionData);
                            } else {
                                if (customEmotionData.emoPath.matches(str2 + customEmotionData.uin + ".*")) {
                                    String str3 = customEmotionData.uin;
                                    customEmotionData.emoPath = customEmotionData.emoPath.replace(str3, DiySecureFileHelper.secureUin(str3));
                                    if (!z16) {
                                        transaction.begin();
                                        z16 = true;
                                    }
                                    createEntityManager.update(customEmotionData);
                                } else if (i3 == 0) {
                                    break;
                                }
                            }
                        } catch (Exception e17) {
                            e = e17;
                            e.printStackTrace();
                        }
                    }
                    if (z16) {
                        transaction.commit();
                    }
                } catch (Throwable th6) {
                    th = th6;
                    z17 = false;
                }
            }
            checkAllEmoPath(arrayList, createEntityManager);
            createEntityManager.close();
        }
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            for (CustomEmotionData customEmotionData2 : arrayList) {
                if (TextUtils.isEmpty(customEmotionData2.RomaingType)) {
                    customEmotionData2.RomaingType = "init";
                    arrayList2.add(customEmotionData2);
                } else if (customEmotionData2.RomaingType.equals("needUpload")) {
                    customEmotionData2.RomaingType = "failed";
                    arrayList2.add(customEmotionData2);
                    reportProcessInterruptError();
                } else {
                    updateCache(customEmotionData2, 1);
                }
                z17 = true;
                updateCache(customEmotionData2, 1);
            }
        }
        trimCache();
        if (z17) {
            updateCustomEmotionDataListInDB(arrayList, 2);
        }
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        if (QLog.isColorLevel()) {
            QLog.d("FavroamingDBManager", 2, "getEmoticonDataList from db : data size = " + arrayList.size());
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase, com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService
    public /* bridge */ /* synthetic */ CustomEmotionData getEmotionDataByUrl(String str) {
        return (CustomEmotionData) super.getEmotionDataByUrl(str);
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService
    public List<String> getLocalFavDataNotInServer(List<String> list, List<faceroam_sso$EmojiItem> list2) {
        if (list == null && list2 == null) {
            return null;
        }
        if (list != null && list.size() < 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (list2 != null) {
            for (faceroam_sso$EmojiItem faceroam_sso_emojiitem : list2) {
                if (faceroam_sso_emojiitem != null && faceroam_sso_emojiitem.file_id.get() != null) {
                    arrayList.add(faceroam_sso_emojiitem.file_id.get());
                }
            }
        }
        List<String> customEmoticonResIdsByType = getCustomEmoticonResIdsByType(Arrays.asList("needUpload", "failed", "needDel"));
        ArrayList arrayList2 = new ArrayList();
        if (customEmoticonResIdsByType != null) {
            QLog.d("FavroamingDBManager", 2, "getLocalFavDataNotInServer: isUpdate size=" + customEmoticonResIdsByType.size());
            for (String str : customEmoticonResIdsByType) {
                if (!arrayList.contains(str)) {
                    arrayList2.add(str);
                }
            }
        }
        return arrayList2;
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase
    public CustomEmotionRoamingManagerBase<CustomEmotionData> getRoamingManager() {
        return (CustomEmotionRoamingManagerBase) this.app.getRuntimeService(IFavroamingManagerService.class);
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService
    public /* bridge */ /* synthetic */ void insertCustomEmotion(CustomEmotionData customEmotionData) {
        super.insertCustomEmotion((FavroamingDBManagerServiceImpl) customEmotionData);
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService
    public void notifyFavRoamingUpdate() {
        Iterator<jb1.a> it = this.updateListeners.iterator();
        while (it.hasNext()) {
            it.next().onUpdate();
        }
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase, mqq.app.api.IRuntimeService
    public void onDestroy() {
        super.onDestroy();
        f.f204345c.a();
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService
    public void removeFavRoamingUpdateListener(jb1.a aVar) {
        this.updateListeners.remove(aVar);
    }

    public void reportProcessInterruptError() {
        if (!this.hasReportProcessInterrupt) {
            this.hasReportProcessInterrupt = true;
            g.a(false, 8, 0);
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService
    public List<EmoticonInfo> syncGetCustomEmotionInfoShowedInAIOPanel() {
        List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel = syncGetCustomEmotionInfoShowedInPanel();
        BaseQQAppInterface baseQQAppInterface = this.app;
        if (baseQQAppInterface == null) {
            QLog.e("FavroamingDBManager", 1, "[syncGetCustomEmotionInfoShowedInAIOPanel] error, app is null!");
            return syncGetCustomEmotionInfoShowedInPanel;
        }
        List<CustomEmotionData> lottieEmoticonDataList = ((com.tencent.qqnt.emotion.api.IFavroamingDBManagerService) baseQQAppInterface.getRuntimeService(com.tencent.qqnt.emotion.api.IFavroamingDBManagerService.class)).getLottieEmoticonDataList();
        if (lottieEmoticonDataList != null) {
            for (CustomEmotionData customEmotionData : lottieEmoticonDataList) {
                FavoriteLottieEmoticonInfo favoriteLottieEmoticonInfo = new FavoriteLottieEmoticonInfo();
                favoriteLottieEmoticonInfo.type = 4;
                String str = customEmotionData.emoPath;
                favoriteLottieEmoticonInfo.path = str;
                favoriteLottieEmoticonInfo.srcType = 2;
                favoriteLottieEmoticonInfo.eId = customEmotionData.eId;
                favoriteLottieEmoticonInfo.url = customEmotionData.url;
                favoriteLottieEmoticonInfo.roamingType = customEmotionData.RomaingType;
                favoriteLottieEmoticonInfo.emoId = customEmotionData.emoId;
                favoriteLottieEmoticonInfo.resID = customEmotionData.resid;
                if (TextUtils.isEmpty(str) && TextUtils.isEmpty(favoriteLottieEmoticonInfo.url)) {
                    QLog.e("FavroamingDBManager", 1, "[syncGetCustomEmotionInfoShowedInPanel] handle lottieEmoticonDataList, path and url is null! info=", favoriteLottieEmoticonInfo);
                } else {
                    syncGetCustomEmotionInfoShowedInPanel.add(favoriteLottieEmoticonInfo);
                }
            }
        }
        return syncGetCustomEmotionInfoShowedInPanel;
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase, com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService
    public List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel() {
        ei.a("AIO_EmoticonPanel_Refresh", null);
        BaseQQAppInterface baseQQAppInterface = this.app;
        if (baseQQAppInterface == null) {
            QLog.i("FavroamingDBManager", 2, "[syncGetCustomEmotionInfoShowedInPanel] app runtime is null");
            return Collections.emptyList();
        }
        List<CustomEmotionData> emoticonDataList = getEmoticonDataList();
        ArrayList arrayList = new ArrayList();
        if (emoticonDataList != null) {
            try {
                for (int size = emoticonDataList.size() - 1; size >= 0; size--) {
                    CustomEmotionData customEmotionData = emoticonDataList.get(size);
                    if ("needDel".equals(customEmotionData.RomaingType)) {
                        QLog.d("FavroamingDBManager", 1, "data need delete, do not need display -> resId:" + customEmotionData.resid);
                    } else {
                        EmoticonInfo convertEmotionDataToInfo = convertEmotionDataToInfo(customEmotionData, baseQQAppInterface);
                        if (convertEmotionDataToInfo instanceof PicEmoticonInfo) {
                            PicEmoticonInfo picEmoticonInfo = (PicEmoticonInfo) convertEmotionDataToInfo;
                            if (picEmoticonInfo.emoticon != null) {
                                arrayList.add(picEmoticonInfo);
                            } else {
                                QLog.e("FavroamingDBManager", 1, "PicEmoticonInfo.emoticon is null, " + customEmotionData.toString());
                            }
                        } else if (convertEmotionDataToInfo instanceof FavoriteEmoticonInfo) {
                            FavoriteEmoticonInfo favoriteEmoticonInfo = (FavoriteEmoticonInfo) convertEmotionDataToInfo;
                            if (TextUtils.isEmpty(favoriteEmoticonInfo.path) && TextUtils.isEmpty(favoriteEmoticonInfo.url)) {
                                QLog.e("FavroamingDBManager", 1, "path and url is null! " + favoriteEmoticonInfo.toString());
                            } else {
                                arrayList.add(favoriteEmoticonInfo);
                            }
                        }
                    }
                }
            } catch (OutOfMemoryError unused) {
                QLog.e("FavroamingDBManager", 1, "syncGetCustomEmotionInfoShowedInPanel oom");
            }
            ei.a(null, "AIO_EmoticonPanel_Refresh");
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase
    public List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPreview() {
        Map<String, VipComicFavorEmoStructMsgInfo> comicStructInfoMap = ((IVipComicMqqManagerService) this.app.getRuntimeService(IVipComicMqqManagerService.class, "")).getComicStructInfoMap();
        if (QLog.isColorLevel()) {
            QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from syncGetCustomEmotionInfoShowedInPreview.");
        }
        List<CustomEmotionData> emoticonDataList = getEmoticonDataList();
        ArrayList arrayList = new ArrayList();
        if (emoticonDataList != null) {
            try {
                for (int size = emoticonDataList.size() - 1; size >= 0; size--) {
                    CustomEmotionData customEmotionData = emoticonDataList.get(size);
                    if (!"isUpdate".equals(customEmotionData.RomaingType)) {
                        QLog.d("FavroamingDBManager", 1, "data need hidden, do not need display -> resId:" + customEmotionData.resid);
                    } else if (customEmotionData.isMarkFace) {
                        PicEmoticonInfo picEmoticonInfo = new PicEmoticonInfo(this.app.getCurrentAccountUin());
                        picEmoticonInfo.type = 6;
                        String str = customEmotionData.eId;
                        String str2 = customEmotionData.emoPath;
                        picEmoticonInfo.isAPNG = customEmotionData.isAPNG;
                        Emoticon syncFindEmoticonById = ((IEmoticonManagerService) this.app.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonById(str2, str);
                        picEmoticonInfo.emoticon = syncFindEmoticonById;
                        picEmoticonInfo.srcType = 2;
                        if (syncFindEmoticonById != null) {
                            arrayList.add(picEmoticonInfo);
                        } else {
                            QLog.e("FavroamingDBManager", 1, "PicEmoticonInfo.emoticon is null, " + customEmotionData.toString());
                        }
                    } else {
                        FavoriteEmoticonInfo favoriteEmoticonInfo = new FavoriteEmoticonInfo();
                        favoriteEmoticonInfo.type = 4;
                        favoriteEmoticonInfo.path = getCustomEmoticonPath(customEmotionData);
                        favoriteEmoticonInfo.srcType = 2;
                        favoriteEmoticonInfo.eId = customEmotionData.eId;
                        favoriteEmoticonInfo.url = customEmotionData.url;
                        favoriteEmoticonInfo.actionData = lb1.c.a(comicStructInfoMap, customEmotionData.md5);
                        favoriteEmoticonInfo.roamingType = customEmotionData.RomaingType;
                        favoriteEmoticonInfo.emoId = customEmotionData.emoId;
                        favoriteEmoticonInfo.resID = customEmotionData.resid;
                        if (TextUtils.isEmpty(favoriteEmoticonInfo.path) && TextUtils.isEmpty(favoriteEmoticonInfo.url)) {
                            QLog.e("FavroamingDBManager", 1, "path and url is null! " + favoriteEmoticonInfo.toString());
                        } else {
                            arrayList.add(favoriteEmoticonInfo);
                        }
                    }
                }
            } catch (OutOfMemoryError unused) {
                QLog.e("FavroamingDBManager", 1, "syncGetCustomEmotionInfoShowedInPreview oom");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("FavroamingDBManager", 2, "syncGetCustomEmotionInfoShowedInPreview, display size:" + arrayList.size());
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService
    public /* bridge */ /* synthetic */ void updateCustomEmotion(CustomEmotionData customEmotionData) {
        super.updateCustomEmotion((FavroamingDBManagerServiceImpl) customEmotionData);
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase
    public void updateCustomEmotionDataListInDB(List<CustomEmotionData> list, int i3) {
        super.updateCustomEmotionDataListInDB(list, i3);
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService
    public boolean updateDeletedEmoticon(CustomEmotionData customEmotionData, int i3) {
        String str;
        if (customEmotionData == null || !"needDel".equals(customEmotionData.RomaingType)) {
            return false;
        }
        if (i3 <= FavEmoConstant.FAV_LOCAL_MAX_COUNT) {
            str = "isUpdate";
        } else {
            str = FavEmoConstant.ROAMING_TYPE_OVERFLOW_DOWNLOADED;
        }
        customEmotionData.RomaingType = str;
        updateCustomEmotion((FavroamingDBManagerServiceImpl) customEmotionData);
        IFavroamingManagerService iFavroamingManagerService = (IFavroamingManagerService) this.app.getRuntimeService(IFavroamingManagerService.class, "");
        if (iFavroamingManagerService != null) {
            iFavroamingManagerService.syncUpload(customEmotionData);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService
    public synchronized List<CustomEmotionData> updateFavEmotionsInLocalEx(List<String> list, List<faceroam_sso$EmojiItem> list2) {
        List<CustomEmotionData> emoticonDataList;
        ArrayList arrayList = new ArrayList();
        List<String> localFavDataNotInServer = getLocalFavDataNotInServer(list, list2);
        int i3 = 0;
        if (localFavDataNotInServer != null && localFavDataNotInServer.size() > 0) {
            arrayList.addAll(localFavDataNotInServer);
            QLog.d("FavroamingDBManager", 1, "localUpdatedNotInServerList= ", Integer.valueOf(localFavDataNotInServer.size()));
        }
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
        }
        if (QLog.isColorLevel()) {
            QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-1.");
        }
        removeRedundancyEmoticonList(arrayList);
        if (QLog.isColorLevel()) {
            QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-2.");
        }
        emoticonDataList = getEmoticonDataList();
        int maxEmoId = getMaxEmoId(emoticonDataList);
        if (QLog.isColorLevel()) {
            QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-3.");
        }
        ArrayList arrayList2 = new ArrayList();
        removeMergeEmoticon(list2, maxEmoId, emoticonDataList, arrayList2);
        QLog.d("FavroamingDBManager", 1, "mergeSize= ", Integer.valueOf(arrayList2.size()));
        List<CustomEmotionData> updateCustomEmotionData = updateCustomEmotionData(arrayList2);
        QLog.d("FavroamingDBManager", 1, "updateSize= ", Integer.valueOf(updateCustomEmotionData.size()));
        if (QLog.isColorLevel()) {
            QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-4.");
        }
        List<CustomEmotionData> emoticonDataList2 = getEmoticonDataList();
        if (emoticonDataList2 != null) {
            i3 = emoticonDataList2.size();
            deleteCustomEmotionList(emoticonDataList2);
        }
        this.customEmotionDbCache.clear();
        this.customEmotionDbCache.addAll(updateCustomEmotionData);
        updateCustomEmotionDataListInDB(updateCustomEmotionData, 1);
        if (QLog.isColorLevel()) {
            QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-4.");
        }
        FavEmoRoamingHandler favEmoRoamingHandler = (FavEmoRoamingHandler) this.app.getBusinessHandler(FavEmoRoamingHandler.f194632e);
        if (updateCustomEmotionData.size() > 0) {
            favEmoRoamingHandler.I2(updateCustomEmotionData, 2);
        }
        QLog.d("FavroamingDBManager", 1, "updateFavEmotionsInLocalEx final cache size: " + updateCustomEmotionData.size() + ",delete size:" + i3 + ",upload size:" + getUploadSize(emoticonDataList, updateCustomEmotionData));
        return emoticonDataList;
    }

    @Override // com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService
    public CustomEmotionData updateUpload(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateUpload.");
        }
        CustomEmotionData customEmotionDataBYResId = getCustomEmotionDataBYResId(getEmoticonDataList(), str);
        if (customEmotionDataBYResId != null) {
            customEmotionDataBYResId.resid = str;
            customEmotionDataBYResId.RomaingType = "isUpdate";
            updateCustomEmotion((FavroamingDBManagerServiceImpl) customEmotionDataBYResId);
        }
        return customEmotionDataBYResId;
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase
    public EmoticonInfo convertEmotionDataToInfo(CustomEmotionData customEmotionData, BaseQQAppInterface baseQQAppInterface) {
        if (customEmotionData.isMarkFace) {
            PicEmoticonInfo picEmoticonInfo = new PicEmoticonInfo(baseQQAppInterface.getCurrentAccountUin());
            picEmoticonInfo.type = 6;
            String str = customEmotionData.eId;
            String str2 = customEmotionData.emoPath;
            picEmoticonInfo.isAPNG = customEmotionData.isAPNG;
            picEmoticonInfo.emoticon = ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonById(str2, str);
            picEmoticonInfo.srcType = 2;
            picEmoticonInfo.roamingType = customEmotionData.RomaingType;
            picEmoticonInfo.emoId = customEmotionData.emoId;
            return picEmoticonInfo;
        }
        Map<String, VipComicFavorEmoStructMsgInfo> comicStructInfoMap = ((IVipComicMqqManagerService) baseQQAppInterface.getRuntimeService(IVipComicMqqManagerService.class)).getComicStructInfoMap();
        FavoriteEmoticonInfo favoriteEmoticonInfo = new FavoriteEmoticonInfo();
        favoriteEmoticonInfo.type = 4;
        favoriteEmoticonInfo.path = getCustomEmoticonPath(customEmotionData);
        favoriteEmoticonInfo.srcType = 2;
        favoriteEmoticonInfo.eId = customEmotionData.eId;
        favoriteEmoticonInfo.url = customEmotionData.url;
        if (comicStructInfoMap != null) {
            favoriteEmoticonInfo.actionData = lb1.c.a(comicStructInfoMap, customEmotionData.md5);
        }
        favoriteEmoticonInfo.roamingType = customEmotionData.RomaingType;
        favoriteEmoticonInfo.emoId = customEmotionData.emoId;
        favoriteEmoticonInfo.resID = customEmotionData.resid;
        favoriteEmoticonInfo.jumpId = customEmotionData.jumpId;
        favoriteEmoticonInfo.emojiMd5 = customEmotionData.md5;
        favoriteEmoticonInfo.remark = !TextUtils.isEmpty(customEmotionData.modifyWord) ? customEmotionData.modifyWord : customEmotionData.ocrWord;
        return favoriteEmoticonInfo;
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase
    public String getCustomEmoticonPath(CustomEmotionData customEmotionData) {
        if (customEmotionData == null) {
            return "";
        }
        if (!TextUtils.isEmpty(customEmotionData.emoPath)) {
            return customEmotionData.emoPath;
        }
        String str = AppConstants.SDCARD_IMG_FAVORITE;
        IVipComicMqqManagerService iVipComicMqqManagerService = (IVipComicMqqManagerService) this.app.getRuntimeService(IVipComicMqqManagerService.class, "");
        if (iVipComicMqqManagerService != null && iVipComicMqqManagerService.isComicEmoticon(customEmotionData)) {
            if (!TextUtils.isEmpty(customEmotionData.emoPath) && customEmotionData.emoPath.startsWith(str)) {
                return customEmotionData.emoPath;
            }
            if (!TextUtils.isEmpty(customEmotionData.md5)) {
                return iVipComicMqqManagerService.getFilePath(customEmotionData.md5);
            }
            if (!TextUtils.isEmpty(customEmotionData.resid)) {
                return str + DiySecureFileHelper.secureUin(customEmotionData.resid);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            String str2 = customEmotionData.url;
            sb5.append(str2.substring(str2.lastIndexOf("/") + 1));
            return sb5.toString();
        }
        String str3 = customEmotionData.url;
        if (str3 != null && str3.contains(FunnyPicHelperConstant.FUNYPIC_PREFIX)) {
            return str + FunnyPicHelperConstant.getFunnyPicName(customEmotionData.url);
        }
        if (!TextUtils.isEmpty(FunnyPicHelperConstant.getFunnyPicName(customEmotionData.eId))) {
            String str4 = str + customEmotionData.eId;
            if (QLog.isColorLevel()) {
                QLog.d("FavroamingDBManager", 2, "emotion is FunnyPic path download from server->" + customEmotionData.eId);
            }
            return str4;
        }
        return str + customEmotionData.resid;
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase
    public CustomEmotionData getCustomEmotionDataBYResId(List<CustomEmotionData> list, String str) {
        String str2;
        String str3;
        String bytes2HexStr;
        if (TextUtils.isEmpty(str)) {
            QLog.e("FavroamingDBManager", 1, "fav custom data resId is empty.");
            return null;
        }
        if (list == null || list.size() < 1) {
            return null;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            CustomEmotionData customEmotionData = list.get(i3);
            if (customEmotionData != null && (((str2 = customEmotionData.RomaingType) == null || !str2.equals("needUpload")) && ((str3 = customEmotionData.RomaingType) == null || !str3.equals("failed")))) {
                if (TextUtils.isEmpty(customEmotionData.resid) || !customEmotionData.resid.equals(str)) {
                    m mVar = new m(str);
                    if (!mVar.a()) {
                        QLog.e("FavroamingDBManager", 1, "res id is not valid:", str);
                        return null;
                    }
                    if (customEmotionData.isMarkFace) {
                        String str4 = mVar.f204357e;
                        String str5 = mVar.f204358f;
                        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
                            QLog.d("FavroamingDBManager", 1, "epId is: ", Boolean.valueOf(TextUtils.isEmpty(str4)), " eid is: ", Boolean.valueOf(TextUtils.isEmpty(str5)));
                        } else if (str4.equals(customEmotionData.emoPath) && str5.equals(customEmotionData.eId)) {
                            customEmotionData.resid = str;
                        }
                    } else {
                        String str6 = mVar.f204356d;
                        if (TextUtils.isEmpty(str6)) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("md5 id is empty. md5:");
                            sb5.append(str6 == null);
                            QLog.d("FavroamingDBManager", 1, sb5.toString());
                        } else {
                            if (!TextUtils.isEmpty(customEmotionData.md5)) {
                                bytes2HexStr = customEmotionData.md5;
                            } else {
                                bytes2HexStr = HexUtil.bytes2HexStr(MD5.getFileMd5(customEmotionData.emoPath));
                            }
                            customEmotionData.md5 = bytes2HexStr;
                            if (str6.equals(bytes2HexStr)) {
                                customEmotionData.resid = str;
                            }
                        }
                    }
                }
                return customEmotionData;
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("fav custom data emotionData: ");
            sb6.append(customEmotionData == null);
            QLog.d("FavroamingDBManager", 1, sb6.toString());
            if (customEmotionData != null) {
                QLog.d("FavroamingDBManager", 1, "fav custom data emotionData type: " + customEmotionData.RomaingType);
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase
    public void updateCache(CustomEmotionData customEmotionData, int i3) {
        super.updateCache((FavroamingDBManagerServiceImpl) customEmotionData, i3);
    }
}

package com.tencent.qqnt.emotion.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.api.IFavroamingDBManagerService;
import com.tencent.qqnt.emotion.emosm.CustomEmotionRoamingDBManagerBase;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes24.dex */
public class FavroamingDBManagerServiceImpl extends CustomEmotionRoamingDBManagerBase<CustomEmotionData> implements IFavroamingDBManagerService<CustomEmotionData> {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "FavroamingDBManager";
    private boolean hasReportProcessInterrupt;

    public FavroamingDBManagerServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.emotion.api.IFavroamingDBManagerService
    public String getCustomEmoticonPath(CustomEmotionData customEmotionData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) customEmotionData);
        }
        if (customEmotionData == null) {
            return "";
        }
        if (!TextUtils.isEmpty(customEmotionData.emoPath)) {
            return customEmotionData.emoPath;
        }
        return AppConstants.SDCARD_IMG_FAVORITE + customEmotionData.resid;
    }

    @Override // com.tencent.qqnt.emotion.emosm.CustomEmotionRoamingDBManagerBase
    public Class getDBClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return CustomEmotionData.class;
    }

    @Override // com.tencent.qqnt.emotion.api.IFavroamingDBManagerService
    public synchronized List<CustomEmotionData> getEmoticonDataList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
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

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00db, code lost:
    
        if (r6 != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ea, code lost:
    
        com.tencent.qqnt.emotion.utils.b.a(com.tencent.mobileqq.app.utils.DiySecureFileHelper.KEY_QQFAVORITE_DB, r1.getCurrentUin(), 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e7, code lost:
    
        r3.end();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e5, code lost:
    
        if (r6 != false) goto L49;
     */
    @Override // com.tencent.qqnt.emotion.api.IFavroamingDBManagerService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<CustomEmotionData> getEmoticonDataListFromDB() {
        boolean z16;
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        List<CustomEmotionData> arrayList = new ArrayList();
        BaseQQAppInterface baseQQAppInterface = this.app;
        if (baseQQAppInterface == null) {
            return arrayList;
        }
        com.tencent.qqnt.emotion.db.a a16 = com.tencent.qqnt.emotion.db.b.f356229a.a(baseQQAppInterface);
        boolean z17 = false;
        if (a16 != null) {
            arrayList = a16.i(getDBClass(), false, null, null, null, null, null, null);
            if (com.tencent.qqnt.emotion.utils.b.b(DiySecureFileHelper.KEY_QQFAVORITE_DB, baseQQAppInterface.getCurrentUin()) < 1) {
                EntityTransaction f16 = a16.f();
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
                                f16.end();
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
                                customEmotionData.emoPath = str2 + com.tencent.qqnt.emotion.utils.b.c(customEmotionData.resid);
                                if (!z16) {
                                    f16.begin();
                                    z16 = true;
                                }
                                a16.j(customEmotionData);
                            } else {
                                if (customEmotionData.emoPath.matches(str2 + customEmotionData.uin + ".*")) {
                                    String str3 = customEmotionData.uin;
                                    customEmotionData.emoPath = customEmotionData.emoPath.replace(str3, com.tencent.qqnt.emotion.utils.b.c(str3));
                                    if (!z16) {
                                        f16.begin();
                                        z16 = true;
                                    }
                                    a16.j(customEmotionData);
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
                        f16.commit();
                    }
                } catch (Throwable th6) {
                    th = th6;
                    z17 = false;
                }
            }
            a16.a();
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

    @Override // com.tencent.qqnt.emotion.api.IFavroamingDBManagerService
    public List<CustomEmotionData> getLottieEmoticonDataList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return uw3.a.a(QQSysFaceUtil.getFavoritePanelAniStickerOrderList());
    }

    @Override // com.tencent.qqnt.emotion.api.IFavroamingDBManagerService
    public /* bridge */ /* synthetic */ void insertCustomEmotion(CustomEmotionData customEmotionData) {
        super.insertCustomEmotion((FavroamingDBManagerServiceImpl) customEmotionData);
    }

    @Override // com.tencent.qqnt.emotion.api.IFavroamingDBManagerService
    public /* bridge */ /* synthetic */ void updateCustomEmotion(CustomEmotionData customEmotionData) {
        super.updateCustomEmotion((FavroamingDBManagerServiceImpl) customEmotionData);
    }
}

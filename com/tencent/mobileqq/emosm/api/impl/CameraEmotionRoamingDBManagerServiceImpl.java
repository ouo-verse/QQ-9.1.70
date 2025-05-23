package com.tencent.mobileqq.emosm.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.app.CameraEmoImg;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CameraEmotionRoamingDBManagerServiceImpl extends CustomEmotionRoamingDBManagerBase<CameraEmotionData> implements ICameraEmotionRoamingDBManagerService {
    public static final String TAG = "CameraEmotionRoamingDBManager";
    private boolean hasEmoCacheFlags;
    private boolean hasReportProcessInterrupt;

    private void addLocalList(List<CameraEmoImg> list, List<CameraEmoImg> list2) {
        boolean z16;
        if (list2.size() < list.size()) {
            Iterator<CameraEmoImg> it = list2.iterator();
            while (it.hasNext()) {
                list.remove(it.next());
            }
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            List<CameraEmotionData> emoticonDataList = getEmoticonDataList();
            int i3 = 1;
            if (emoticonDataList != null) {
                for (int i16 = 0; i16 < emoticonDataList.size(); i16++) {
                    int i17 = emoticonDataList.get(i16).emoId;
                    if (i3 < i17) {
                        i3 = i17;
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator<CameraEmoImg> it5 = list.iterator();
            while (it5.hasNext()) {
                i3++;
                CameraEmotionData createNewEmoByEmoImg = createNewEmoByEmoImg(it5.next(), i3);
                if (createNewEmoByEmoImg != null) {
                    createNewEmoByEmoImg.RomaingType = "normal";
                    updateCache(createNewEmoByEmoImg, 1);
                    arrayList.add(createNewEmoByEmoImg);
                }
            }
            updateCustomEmotionDataListInDB(arrayList, 1);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateLocalDBFromServer, needAdd = " + z16 + "| remoteImgList.size = " + list.size());
        }
    }

    private CameraEmotionData createNewEmoByEmoImg(CameraEmoImg cameraEmoImg, int i3) {
        if (cameraEmoImg != null && this.app != null) {
            CameraEmotionData cameraEmotionData = new CameraEmotionData();
            cameraEmotionData.uin = this.app.getCurrentAccountUin();
            cameraEmotionData.emoId = i3 + 1;
            cameraEmotionData.resid = cameraEmoImg.resID;
            cameraEmotionData.strContext = cameraEmoImg.content;
            cameraEmotionData.templateId = cameraEmoImg.templateId;
            if (StringUtil.isEmpty(cameraEmoImg.md5)) {
                cameraEmotionData.md5 = com.tencent.mobileqq.emosm.cameraemotionroaming.a.b(cameraEmoImg.resID);
            } else {
                cameraEmotionData.md5 = cameraEmoImg.md5;
            }
            cameraEmotionData.url = cameraEmoImg.url;
            return cameraEmotionData;
        }
        return null;
    }

    private void delLocalList(List<String> list, List<CameraEmotionData> list2, boolean z16) {
        List<CameraEmotionData> emoticonDatasByType = getEmoticonDatasByType("needDel");
        if (emoticonDatasByType == null) {
            emoticonDatasByType = new ArrayList<>();
        }
        if (list != null && list.size() > 0) {
            if (emoticonDatasByType.size() > 0) {
                Iterator<CameraEmotionData> it = emoticonDatasByType.iterator();
                while (it.hasNext()) {
                    if (!list.contains(it.next().resid)) {
                        it.remove();
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateLocalDBFromServer, locNeedDelList.size = " + emoticonDatasByType.size());
            }
        }
        if (z16) {
            emoticonDatasByType.addAll(list2);
        }
        if (emoticonDatasByType.size() > 0) {
            Iterator<CameraEmotionData> it5 = emoticonDatasByType.iterator();
            while (it5.hasNext()) {
                updateCache(it5.next(), 4);
            }
            updateCustomEmotionDataListInDB(emoticonDatasByType, 4);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateLocalDBFromServer, needDelete = " + z16 + "| localNotInServerList.size = " + list2.size());
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService
    public int getCatchDataCount() {
        List<T> list = this.customEmotionDbCache;
        int i3 = 0;
        if (list == 0) {
            return 0;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!"needDel".equals(((CameraEmotionData) it.next()).RomaingType)) {
                i3++;
            }
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase
    public Class getDBClass() {
        return CameraEmotionData.class;
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase, com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService
    public synchronized List<CameraEmotionData> getEmoticonDataList() {
        List<CameraEmotionData> arrayList = new ArrayList();
        if (this.customEmotionDbCache.size() > 0) {
            for (T t16 : this.customEmotionDbCache) {
                if (t16 != null) {
                    arrayList.add(t16);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getEmoticonDataList from cache: data size = " + arrayList.size());
            }
            return arrayList;
        }
        BaseQQAppInterface baseQQAppInterface = this.app;
        if (baseQQAppInterface == null) {
            return arrayList;
        }
        EntityManager createEntityManager = baseQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (createEntityManager != null) {
            arrayList = createEntityManager.query(getDBClass(), false, null, null, null, null, null, null);
            ArrayList arrayList2 = new ArrayList();
            boolean z16 = false;
            if (arrayList != null && arrayList.size() > 0) {
                for (CameraEmotionData cameraEmotionData : arrayList) {
                    if (TextUtils.isEmpty(cameraEmotionData.RomaingType)) {
                        cameraEmotionData.RomaingType = "init";
                        arrayList2.add(cameraEmotionData);
                    } else if (cameraEmotionData.RomaingType.equals("needUpload")) {
                        cameraEmotionData.RomaingType = "failed";
                        arrayList2.add(cameraEmotionData);
                        reportProcessInterruptError();
                    } else {
                        updateCache(cameraEmotionData, 1);
                    }
                    z16 = true;
                    updateCache(cameraEmotionData, 1);
                }
            }
            trimCache();
            if (z16) {
                updateCustomEmotionDataListInDB(arrayList2, 2);
            }
            if (arrayList != null) {
                QLog.d(TAG, 2, "getEmoticonDataList from db : data size = " + arrayList.size());
                this.hasEmoCacheFlags = true;
            } else {
                arrayList = new ArrayList();
                QLog.d(TAG, 2, "getEmoticonDataList from db : data size = null");
                if (this.hasEmoCacheFlags) {
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "CameraEmoDBError", true, 0L, 0L, null, "");
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase
    public CustomEmotionRoamingManagerBase<CameraEmotionData> getRoamingManager() {
        return (CameraEmoRoamingManagerServiceImpl) this.app.getRuntimeService(ICameraEmoRoamingManagerService.class);
    }

    @Override // com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService
    public /* bridge */ /* synthetic */ void insertCustomEmotion(CameraEmotionData cameraEmotionData) {
        super.insertCustomEmotion((CameraEmotionRoamingDBManagerServiceImpl) cameraEmotionData);
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase, mqq.app.api.IRuntimeService
    public void onDestroy() {
        super.onDestroy();
        com.tencent.mobileqq.emosm.cameraemotionroaming.b.b().f204256a.a();
    }

    public void reportProcessInterruptError() {
        if (!this.hasReportProcessInterrupt) {
            this.hasReportProcessInterrupt = true;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("sucFlag", "0");
            hashMap.put("retCode", String.valueOf(15));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "CamEmoUpload", false, 0L, 0L, hashMap, null);
        }
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase, com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService
    public List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "Call CameraEmotionRoamingDBManager syncGetCustomEmotionInfoShowedInPanel.");
        }
        List<CameraEmotionData> emoticonDataList = getEmoticonDataList();
        ArrayList arrayList = new ArrayList();
        if (emoticonDataList != null) {
            try {
                for (int size = emoticonDataList.size() - 1; size >= 0; size--) {
                    CameraEmotionData cameraEmotionData = emoticonDataList.get(size);
                    if ("needDel".equals(cameraEmotionData.RomaingType)) {
                        QLog.d(TAG, 1, "data need delete, do not need display -> resId:" + cameraEmotionData.resid);
                    } else {
                        arrayList.add(convertEmotionDataToInfo(cameraEmotionData, this.app));
                    }
                }
            } catch (OutOfMemoryError unused) {
                QLog.e(TAG, 1, "syncGetCustomEmotionInfoShowedInPanel oom");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "syncGetCustomEmotionInfoShowedInPanel, display size:" + arrayList.size());
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase
    protected List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPreview() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "Call CameraEmotionRoamingDBManager syncGetCustomEmotionInfoShowedInPreview.");
        }
        List<CameraEmotionData> emoticonDataList = getEmoticonDataList();
        ArrayList arrayList = new ArrayList();
        if (emoticonDataList != null) {
            try {
                for (int size = emoticonDataList.size() - 1; size >= 0; size--) {
                    CameraEmotionData cameraEmotionData = emoticonDataList.get(size);
                    if (!"normal".equals(cameraEmotionData.RomaingType)) {
                        QLog.d(TAG, 1, "data need hidden, do not need display -> resId:" + cameraEmotionData.resid);
                    } else {
                        CameraEmoticonInfo cameraEmoticonInfo = new CameraEmoticonInfo();
                        cameraEmoticonInfo.type = 11;
                        cameraEmoticonInfo.path = getCustomEmoticonPath(cameraEmotionData);
                        cameraEmoticonInfo.contextKey = cameraEmotionData.strContext;
                        cameraEmoticonInfo.templateId = cameraEmotionData.templateId;
                        cameraEmoticonInfo.url = cameraEmotionData.url;
                        cameraEmoticonInfo.emoId = cameraEmotionData.emoId;
                        String str = cameraEmotionData.resid;
                        cameraEmoticonInfo.eId = str;
                        cameraEmoticonInfo.roamingType = cameraEmotionData.RomaingType;
                        cameraEmoticonInfo.thumbPath = cameraEmotionData.thumbPath;
                        cameraEmoticonInfo.resID = str;
                        arrayList.add(cameraEmoticonInfo);
                    }
                }
            } catch (OutOfMemoryError unused) {
                QLog.e(TAG, 1, "syncGetCustomEmotionInfoShowedInPreview oom");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "syncGetCustomEmotionInfoShowedInPreview, display size:" + arrayList.size());
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService
    public /* bridge */ /* synthetic */ void updateCustomEmotion(CameraEmotionData cameraEmotionData) {
        super.updateCustomEmotion((CameraEmotionRoamingDBManagerServiceImpl) cameraEmotionData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase
    public void updateCustomEmotionDataListInDB(List<CameraEmotionData> list, int i3) {
        super.updateCustomEmotionDataListInDB(list, i3);
        BaseQQAppInterface baseQQAppInterface = this.app;
        if (baseQQAppInterface != null) {
            StickerRecManagerImpl.get(baseQQAppInterface).updateKeywordForCameraEmotion();
        }
    }

    @Override // com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService
    public void updateLocalDBFromServer(List<CameraEmoImg> list, List<String> list2, List<String> list3) {
        int size;
        if (list != null && list2 != null) {
            boolean z16 = false;
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("updateLocalDBFromServer, start remoteImgList.size = ");
                sb5.append(list.size());
                sb5.append("| deleteSize =");
                if (list3 == null) {
                    size = 0;
                } else {
                    size = list3.size();
                }
                sb5.append(size);
                QLog.d(TAG, 2, sb5.toString());
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<CameraEmotionData> emoticonDataList = getEmoticonDataList();
            if (emoticonDataList != null) {
                for (CameraEmotionData cameraEmotionData : emoticonDataList) {
                    if (!cameraEmotionData.RomaingType.equals("needDel") && !cameraEmotionData.RomaingType.equals("failed") && !cameraEmotionData.RomaingType.equals("needUpload")) {
                        int indexOf = list2.indexOf(cameraEmotionData.resid);
                        if (indexOf < 0) {
                            arrayList.add(cameraEmotionData);
                            z16 = true;
                        } else {
                            arrayList2.add(list.get(indexOf));
                        }
                    }
                }
            }
            delLocalList(list3, arrayList, z16);
            addLocalList(list, arrayList2);
            trimCache();
        }
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase
    public EmoticonInfo convertEmotionDataToInfo(CameraEmotionData cameraEmotionData, BaseQQAppInterface baseQQAppInterface) {
        CameraEmoticonInfo cameraEmoticonInfo = new CameraEmoticonInfo();
        cameraEmoticonInfo.type = 11;
        cameraEmoticonInfo.path = getCustomEmoticonPath(cameraEmotionData);
        cameraEmoticonInfo.contextKey = cameraEmotionData.strContext;
        cameraEmoticonInfo.templateId = cameraEmotionData.templateId;
        cameraEmoticonInfo.url = cameraEmotionData.url;
        cameraEmoticonInfo.emoId = cameraEmotionData.emoId;
        String str = cameraEmotionData.resid;
        cameraEmoticonInfo.eId = str;
        cameraEmoticonInfo.roamingType = cameraEmotionData.RomaingType;
        cameraEmoticonInfo.thumbPath = cameraEmotionData.thumbPath;
        cameraEmoticonInfo.resID = str;
        return cameraEmoticonInfo;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase
    public String getCustomEmoticonPath(CameraEmotionData cameraEmotionData) {
        if (cameraEmotionData == null || this.app == null) {
            return "";
        }
        if (!TextUtils.isEmpty(cameraEmotionData.emoPath)) {
            return cameraEmotionData.emoPath;
        }
        String str = cameraEmotionData.md5;
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(cameraEmotionData.resid)) {
                return "";
            }
            str = com.tencent.mobileqq.emosm.cameraemotionroaming.a.b(cameraEmotionData.resid);
        }
        return com.tencent.mobileqq.emosm.cameraemotionroaming.a.a(str, this.app.getCurrentUin());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase
    public CameraEmotionData getCustomEmotionDataBYResId(List<CameraEmotionData> list, String str) {
        if (TextUtils.isEmpty(str) || list == null || list.size() < 1) {
            return null;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            CameraEmotionData cameraEmotionData = list.get(i3);
            if (cameraEmotionData != null && !TextUtils.isEmpty(cameraEmotionData.resid) && cameraEmotionData.resid.equals(str)) {
                return cameraEmotionData;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase
    public void updateCustomEmotionDataInDB(CameraEmotionData cameraEmotionData, int i3) {
        super.updateCustomEmotionDataInDB((CameraEmotionRoamingDBManagerServiceImpl) cameraEmotionData, i3);
        BaseQQAppInterface baseQQAppInterface = this.app;
        if (baseQQAppInterface != null) {
            StickerRecManagerImpl.get(baseQQAppInterface).updateKeywordForCameraEmotion();
        }
    }
}

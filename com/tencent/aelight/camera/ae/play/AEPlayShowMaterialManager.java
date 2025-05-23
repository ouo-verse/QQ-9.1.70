package com.tencent.aelight.camera.ae.play;

import android.text.TextUtils;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetPlayShowCatMatTreeRsp;
import camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT.PSMetaCategory;
import camera.PLAYSHOW_MATERIALS_GENERAL_DATASTRUCT.PSMetaMaterial;
import com.tencent.aelight.camera.ae.config.CameraDataServiceHandler;
import com.tencent.aelight.camera.ae.control.AEQIMAsyncManager;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.g;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialCategory;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.GsonUtils;
import com.tencent.tuxmeterqui.config.TuxDialogBundleKey;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import yq2.c;

/* loaded from: classes32.dex */
public class AEPlayShowMaterialManager extends AEQIMAsyncManager {
    public static final int EVENT_MATERIAL_LIST_UPDATED = 1;
    private static final String TAG = "AEPlayShowMaterialManager";
    private AEMaterialManager mMaterialManager;
    private String preLoadUrl;
    private List<AEMaterialCategory> mPsCategoryList = new LinkedList();
    private final Object mPsCategoryListLock = new Object();
    private yq2.b mObservable = new yq2.b();

    private Map<String, AEMaterialMetaData> buildMaterialDataMap(List<AEMaterialCategory> list) {
        List<AEMaterialMetaData> list2;
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "buildMaterialDataMap");
        }
        if (list == null) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        for (AEMaterialCategory aEMaterialCategory : new LinkedList(list)) {
            if (aEMaterialCategory != null && (list2 = aEMaterialCategory.f69044d) != null && list2.size() != 0) {
                for (AEMaterialMetaData aEMaterialMetaData : new LinkedList(aEMaterialCategory.f69044d)) {
                    if (!TextUtils.isEmpty(aEMaterialMetaData.f69050id) && !TextUtils.isEmpty(aEMaterialMetaData.md5)) {
                        hashMap.put(aEMaterialMetaData.f69050id, aEMaterialMetaData);
                    }
                }
            }
        }
        return hashMap;
    }

    private void diffTwoListAndDeleteOutdatedMaterial(List<AEMaterialCategory> list, List<AEMaterialCategory> list2) {
        int i3;
        AEMaterialMetaData aEMaterialMetaData;
        int i16;
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "diffTwoListAndDeleteOutdatedMaterial");
        }
        Map<String, AEMaterialMetaData> buildMaterialDataMap = buildMaterialDataMap(list);
        Map<String, AEMaterialMetaData> buildMaterialDataMap2 = buildMaterialDataMap(list2);
        for (Map.Entry<String, AEMaterialMetaData> entry : buildMaterialDataMap.entrySet()) {
            String key = entry.getKey();
            AEMaterialMetaData value = entry.getValue();
            if (value != null) {
                if (buildMaterialDataMap2.containsKey(key) && ((aEMaterialMetaData = buildMaterialDataMap2.get(key)) == null || (((i16 = aEMaterialMetaData.playShowType) != 4 && i16 != 5 && i16 != 6 && i16 != 7) || aEMaterialMetaData.md5.equals(value.md5)))) {
                    value = null;
                }
                if (value != null && ((i3 = value.playShowType) == 4 || i3 == 5 || i3 == 6 || i3 == 7)) {
                    value.deleteAllOldFile();
                }
            }
        }
    }

    private AEMaterialManager getAEMaterialManager() {
        if (this.mMaterialManager == null) {
            this.mMaterialManager = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.b(1);
        }
        return this.mMaterialManager;
    }

    private List<AEMaterialCategory> getFilteredPsCategoryList(List<AEMaterialCategory> list) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "getFilteredPsCategoryList");
        }
        return reAssemblePsCategory(list, buildMaterialDataMap(new LinkedList(getAEMaterialManager().L())));
    }

    private boolean isNotOrdinaryMaterialUsable(AEMaterialMetaData aEMaterialMetaData) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "isNotOrdinaryMaterialUsable, AEMaterialMetaData.id=" + aEMaterialMetaData.f69050id);
        }
        switch (aEMaterialMetaData.playShowType) {
            case 2:
            case 3:
                return true;
            case 4:
            case 5:
            case 6:
            case 7:
                getAEMaterialManager();
                return AEMaterialManager.W(aEMaterialMetaData);
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyMaterialListUpdated() {
        ms.a.f(TAG, "notifyMaterialListUpdated");
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEPlayShowMaterialManager.2
            @Override // java.lang.Runnable
            public void run() {
                AEPlayShowMaterialManager.this.mObservable.c(1, new Object[0]);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0165  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<AEMaterialCategory> parsePsCategoryListFromConfig(String str) {
        ArrayList<PSMetaCategory> arrayList;
        ArrayList<PSMetaMaterial> arrayList2;
        AEMaterialMetaData aEMaterialMetaData;
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "parsePsCategoryListFromConfig");
        }
        if (TextUtils.isEmpty(str)) {
            return new LinkedList();
        }
        GetPlayShowCatMatTreeRsp getPlayShowCatMatTreeRsp = (GetPlayShowCatMatTreeRsp) GsonUtils.json2Obj(str, CameraDataServiceHandler.f63463f);
        if (getPlayShowCatMatTreeRsp != null && (arrayList = getPlayShowCatMatTreeRsp.Categories) != null && arrayList.size() != 0) {
            LinkedList linkedList = new LinkedList();
            HashMap hashMap = new HashMap();
            for (int i3 = 0; i3 < getPlayShowCatMatTreeRsp.Categories.size(); i3++) {
                PSMetaCategory pSMetaCategory = getPlayShowCatMatTreeRsp.Categories.get(i3);
                if (pSMetaCategory != null && (arrayList2 = pSMetaCategory.materials) != null && arrayList2.size() != 0) {
                    LinkedList linkedList2 = new LinkedList();
                    int i16 = 0;
                    while (true) {
                        if (i16 >= pSMetaCategory.materials.size()) {
                            break;
                        }
                        PSMetaMaterial pSMetaMaterial = pSMetaCategory.materials.get(i16);
                        if (pSMetaMaterial != null && !TextUtils.isEmpty(pSMetaMaterial.f30531id) && !TextUtils.isEmpty(pSMetaMaterial.thumbUrl)) {
                            if (hashMap.containsKey(pSMetaMaterial.f30531id)) {
                                aEMaterialMetaData = (AEMaterialMetaData) hashMap.get(pSMetaMaterial.f30531id);
                            } else {
                                aEMaterialMetaData = new AEMaterialMetaData();
                                String str2 = pSMetaMaterial.f30531id;
                                aEMaterialMetaData.f69050id = str2;
                                aEMaterialMetaData.name = str2;
                                aEMaterialMetaData.resurl = pSMetaMaterial.packageUrl;
                                aEMaterialMetaData.md5 = pSMetaMaterial.packageMd5;
                                aEMaterialMetaData.playShowType = pSMetaMaterial.type;
                                aEMaterialMetaData.playShowCoverImg = pSMetaMaterial.thumbUrl;
                                aEMaterialMetaData.tabId = pSMetaCategory.f30530id;
                                aEMaterialMetaData.playShowDisplayText = pSMetaMaterial.name;
                                Map<String, String> map = pSMetaMaterial.additionalFields;
                                if (map != null) {
                                    aEMaterialMetaData.webUrl = map.get(TuxDialogBundleKey.WEB_URL);
                                    aEMaterialMetaData.miniAppId = map.get("mini_app_id");
                                    aEMaterialMetaData.takeSameName = map.get("takeSameName");
                                    aEMaterialMetaData.minimumDeviceLevel = map.get("minimum_device_level");
                                    aEMaterialMetaData.shieldDevices = map.get("shield_devices");
                                }
                                aEMaterialMetaData.showStatus = shouldShowPlayMaterial(aEMaterialMetaData);
                            }
                            int i17 = aEMaterialMetaData.playShowType;
                            if (i17 == 4 || i17 == 5 || i17 == 6 || i17 == 7) {
                                if (!TextUtils.isEmpty(aEMaterialMetaData.resurl)) {
                                    if (TextUtils.isEmpty(aEMaterialMetaData.md5)) {
                                    }
                                    if (!aEMaterialMetaData.showStatus) {
                                        ms.a.a(TAG, "can not show play material id:" + aEMaterialMetaData.f69050id);
                                    } else {
                                        hashMap.put(pSMetaMaterial.f30531id, aEMaterialMetaData);
                                        linkedList2.add(aEMaterialMetaData);
                                    }
                                }
                            } else if (i17 == 2) {
                                if (TextUtils.isEmpty(aEMaterialMetaData.webUrl)) {
                                    ms.a.c(TAG, "can not show h5 play material, empty webUrl, id:" + aEMaterialMetaData.f69050id);
                                }
                                if (!aEMaterialMetaData.showStatus) {
                                }
                            } else {
                                if (i17 == 3 && !TextUtils.isEmpty(aEMaterialMetaData.miniAppId)) {
                                }
                                if (!aEMaterialMetaData.showStatus) {
                                }
                            }
                        }
                        i16++;
                    }
                    if (linkedList2.size() > 0) {
                        AEMaterialCategory aEMaterialCategory = new AEMaterialCategory();
                        aEMaterialCategory.f69047h = pSMetaCategory.name;
                        aEMaterialCategory.f69046f = pSMetaCategory.f30530id;
                        aEMaterialCategory.f69048i = pSMetaCategory.onlyFlag ? 1 : 2;
                        aEMaterialCategory.f69049m = pSMetaCategory.defaultFlag;
                        aEMaterialCategory.f69044d = linkedList2;
                        linkedList.add(aEMaterialCategory);
                    }
                }
            }
            return linkedList;
        }
        return new LinkedList();
    }

    private List<AEMaterialCategory> reAssemblePsCategory(List<AEMaterialCategory> list, Map<String, AEMaterialMetaData> map) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "reAssemblePsCategory");
        }
        this.preLoadUrl = null;
        LinkedList linkedList = new LinkedList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            AEMaterialCategory aEMaterialCategory = list.get(i3);
            LinkedList linkedList2 = new LinkedList();
            for (int i16 = 0; i16 < aEMaterialCategory.f69044d.size(); i16++) {
                AEMaterialMetaData aEMaterialMetaData = aEMaterialCategory.f69044d.get(i16);
                if (aEMaterialMetaData.playShowType != 0) {
                    aEMaterialMetaData.usable = isNotOrdinaryMaterialUsable(aEMaterialMetaData);
                    linkedList2.add(aEMaterialMetaData);
                    if (aEMaterialMetaData.playShowType == 2) {
                        this.preLoadUrl = aEMaterialMetaData.webUrl;
                    }
                } else if (map.containsKey(aEMaterialMetaData.f69050id)) {
                    AEMaterialMetaData aEMaterialMetaData2 = map.get(aEMaterialMetaData.f69050id);
                    aEMaterialMetaData2.playShowCoverImg = aEMaterialMetaData.playShowCoverImg;
                    aEMaterialMetaData2.tabId = aEMaterialCategory.f69046f;
                    aEMaterialMetaData2.playShowDisplayText = aEMaterialMetaData.playShowDisplayText;
                    if (TextUtils.isEmpty(aEMaterialMetaData2.takeSameName) && !TextUtils.isEmpty(aEMaterialMetaData.takeSameName)) {
                        aEMaterialMetaData2.takeSameName = aEMaterialMetaData.takeSameName;
                    }
                    linkedList2.add(aEMaterialMetaData2);
                }
            }
            if (linkedList2.size() > 0) {
                AEMaterialCategory aEMaterialCategory2 = new AEMaterialCategory();
                aEMaterialCategory2.f69047h = aEMaterialCategory.f69047h;
                aEMaterialCategory2.f69048i = aEMaterialCategory.f69048i;
                aEMaterialCategory2.f69046f = aEMaterialCategory.f69046f;
                aEMaterialCategory2.f69044d = linkedList2;
                linkedList.add(aEMaterialCategory2);
            }
        }
        return linkedList;
    }

    private void updatePsCategoryListAsync() {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "updatePsCategoryListAsync");
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.ae.play.AEPlayShowMaterialManager.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (AEPlayShowMaterialManager.this.mPsCategoryListLock) {
                    List updatePsCategoryListInternal = AEPlayShowMaterialManager.this.updatePsCategoryListInternal();
                    if (AEPlayShowMaterialManager.this.mPsCategoryList == null || AEPlayShowMaterialManager.this.mPsCategoryList.size() < 1 || updatePsCategoryListInternal.hashCode() != AEPlayShowMaterialManager.this.mPsCategoryList.hashCode()) {
                        if (AEPlayShowMaterialManager.this.mPsCategoryList != null) {
                            AEPlayShowMaterialManager.this.mPsCategoryList.clear();
                            AEPlayShowMaterialManager.this.mPsCategoryList.addAll(updatePsCategoryListInternal);
                        }
                        AEPlayShowMaterialManager.this.notifyMaterialListUpdated();
                    }
                }
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<AEMaterialCategory> updatePsCategoryListInternal() {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "updatePsCategoryListInternal");
        }
        File file = new File(g.c.f65281a);
        File file2 = new File(g.c.f65282b);
        if (!file2.exists()) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "updatePsCategoryListInternal, updatedConfig=null, thread=" + Thread.currentThread());
            }
            if (!file.exists()) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(TAG, 4, "updatePsCategoryListInternal, defaultConfig=null, thread=" + Thread.currentThread());
                }
                return new LinkedList();
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "updatePsCategoryListInternal, defaultConfig=" + file.getPath() + ", thread=" + Thread.currentThread());
            }
            return getFilteredPsCategoryList(parsePsCategoryListFromConfig(QIMPtvTemplateManager.z(file)));
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "updatePsCategoryListInternal, updatedConfig=" + file2.getPath() + ", thread=" + Thread.currentThread());
        }
        if (!file.exists()) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "updatePsCategoryListInternal, defaultConfig=null, thread=" + Thread.currentThread());
            }
            List<AEMaterialCategory> filteredPsCategoryList = getFilteredPsCategoryList(parsePsCategoryListFromConfig(QIMPtvTemplateManager.z(file2)));
            FileUtils.moveFile(file2.getPath(), file.getPath());
            return filteredPsCategoryList;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "updatePsCategoryListInternal, defaultConfig=" + file.getPath() + ", thread=" + Thread.currentThread());
        }
        List<AEMaterialCategory> parsePsCategoryListFromConfig = parsePsCategoryListFromConfig(QIMPtvTemplateManager.z(file));
        List<AEMaterialCategory> parsePsCategoryListFromConfig2 = parsePsCategoryListFromConfig(QIMPtvTemplateManager.z(file2));
        diffTwoListAndDeleteOutdatedMaterial(parsePsCategoryListFromConfig, parsePsCategoryListFromConfig2);
        List<AEMaterialCategory> filteredPsCategoryList2 = getFilteredPsCategoryList(parsePsCategoryListFromConfig2);
        FileUtils.deleteFile(file.getPath());
        FileUtils.moveFile(file2.getPath(), file.getPath());
        return filteredPsCategoryList2;
    }

    public void addObserver(c cVar, int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "addObserver, observer=" + cVar + ", eventId=" + i3);
        }
        this.mObservable.a(cVar, i3);
    }

    public void clearCategoryList() {
        synchronized (this.mPsCategoryListLock) {
            List<AEMaterialCategory> list = this.mPsCategoryList;
            if (list != null) {
                list.clear();
            }
        }
    }

    public String getPreLoadUrl() {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "getPreLoadUrl, preLoadUrl=" + this.preLoadUrl);
        }
        return this.preLoadUrl;
    }

    public List<AEMaterialCategory> getPsCategoryList() {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "getPsCategoryList");
        }
        return new LinkedList(this.mPsCategoryList);
    }

    @Override // com.tencent.aelight.camera.ae.control.AEQIMAsyncManager
    protected void initIndeed() {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "initIndeed");
        }
        updatePsCategoryListAsync();
    }

    public void refresh() {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "refresh");
        }
        updatePsCategoryListAsync();
    }

    public void removeObserver(int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "removeObserver, eventId=" + i3);
        }
        this.mObservable.d(i3);
    }

    private boolean shouldShowPlayMaterial(AEMaterialMetaData aEMaterialMetaData) {
        if (aEMaterialMetaData == null) {
            ms.a.a(TAG, " info is null ");
            return true;
        }
        if (dr.c.a(aEMaterialMetaData.minimumDeviceLevel) > dr.c.b()) {
            return false;
        }
        if (aEMaterialMetaData.shieldDevices != null) {
            if (aEMaterialMetaData.shieldDevices.contains(dr.c.c())) {
                return false;
            }
        }
        return true;
    }

    public void removeObserver(c cVar) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "removeObserver, observer=" + cVar);
        }
        this.mObservable.e(cVar);
    }
}

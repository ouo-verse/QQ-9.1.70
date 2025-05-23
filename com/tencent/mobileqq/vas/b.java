package com.tencent.mobileqq.vas;

import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.pendant.drawable.api.IPendantHelperApi;
import com.tencent.mobileqq.vas.pendant.drawable.bean.AvatarInPendantHeadportraitInfo;
import com.tencent.mobileqq.vas.pendant.drawable.bean.AvatarPendantShopSeriesInfo;
import com.tencent.mobileqq.vas.pendant.drawable.bean.DiyPendantEntity;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantInfo;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.LoadFinishCallback;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b implements Manager, IAvatarPendantManager {

    /* renamed from: d, reason: collision with root package name */
    private final IAvatarPendantManager f308821d = ((IPendantHelperApi) QRoute.api(IPendantHelperApi.class)).getAvatarPendantManager();

    public b(AppInterface appInterface) {
        ((IPendantHelperApi) QRoute.api(IPendantHelperApi.class)).getDiyPendantFetcher().setLoadFinishCallback(new LoadFinishCallback() { // from class: com.tencent.mobileqq.vas.a
            @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.LoadFinishCallback
            public final void notifyLoadFinish(AppInterface appInterface2, boolean z16, List list) {
                b.this.b(appInterface2, z16, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AppInterface appInterface, boolean z16, List<? extends DiyPendantEntity> list) {
        if (!z16) {
            return;
        }
        ArrayList<NTVasSimpleInfo> arrayList = new ArrayList<>();
        IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
        for (DiyPendantEntity diyPendantEntity : list) {
            appInterface.getEntityManagerFactory().createEntityManager().persistOrReplace(diyPendantEntity);
            String uidFromUin = iRelationNTUinAndUidApi.getUidFromUin(diyPendantEntity.uinAndDiyId.split("_")[0]);
            NTVasSimpleInfo vasSimpleInfoWithUid = iVasInfoService.getVasSimpleInfoWithUid(uidFromUin, "AvatarPendantManager");
            if (vasSimpleInfoWithUid != null && vasSimpleInfoWithUid.pendantDiyId != diyPendantEntity.diyId) {
                NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(uidFromUin, diyPendantEntity.uinAndDiyId.split("_")[0]);
                nTVasSimpleInfo.c();
                nTVasSimpleInfo.pendantDiyId = diyPendantEntity.diyId;
                arrayList.add(nTVasSimpleInfo);
            }
        }
        iVasInfoService.accurateUpdateVasSimpleInfo(arrayList, "AvatarPendantManager", (hx3.c<NTVasSimpleInfo>) null);
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public void clear() {
        this.f308821d.clear();
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public void deletePendants(HashMap<String, Integer> hashMap, ArrayList<String> arrayList) {
        this.f308821d.deletePendants(hashMap, arrayList);
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public File getAvatarPendantBaseResouceDir() {
        return this.f308821d.getAvatarPendantBaseResouceDir();
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public List<AvatarInPendantHeadportraitInfo> getFaceCache() {
        return this.f308821d.getFaceCache();
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public IPendantInfo getPendantInfo(long j3) {
        return this.f308821d.getPendantInfo(j3);
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public JSONArray getPendantLocalVersionInfo() {
        return this.f308821d.getPendantLocalVersionInfo();
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public List<AvatarPendantShopSeriesInfo> getPendantShopSeriesCache() {
        return this.f308821d.getPendantShopSeriesCache();
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public File getPendentBaseDir() {
        return this.f308821d.getPendentBaseDir();
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public boolean isShowPendant(long j3) {
        return this.f308821d.isShowPendant(j3);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        this.f308821d.onDestroy();
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public void setFaceCache(List<? extends AvatarInPendantHeadportraitInfo> list) {
        this.f308821d.setFaceCache(list);
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public void setPlayAnimatinDelay() {
        this.f308821d.setPlayAnimatinDelay();
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public void setPlayAnimatinImmediately() {
        this.f308821d.setPlayAnimatinImmediately();
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public void setUnShowMsgId(long j3) {
        this.f308821d.setUnShowMsgId(j3);
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    public JSONArray updateAllPendantLocalVersionInfo() {
        return this.f308821d.updateAllPendantLocalVersionInfo();
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IAvatarPendantManager
    @NonNull
    public IPendantInfo getPendantInfo(long j3, boolean z16) {
        return this.f308821d.getPendantInfo(j3, z16);
    }
}

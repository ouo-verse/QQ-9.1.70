package com.tencent.mobileqq.emosm.api;

import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.a;
import com.tencent.mobileqq.emosm.favroaming.n;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.transfile.TransferRequest;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes6.dex */
public interface IFavroamingManagerService extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface AddCustomEmotionsCallback {
        void onProgressChanged(float f16, List<Integer> list);

        void onUploadFinish(List<Integer> list);
    }

    void addCustomEmotions(List<String> list, AddCustomEmotionsCallback addCustomEmotionsCallback);

    void addSyncListener(n<CustomEmotionData> nVar);

    void asyncIncreaseEmotionClickNum(CustomEmotionData customEmotionData);

    void cacheAccessibilityEmotionData();

    void cancelAddCustomEmotions();

    void checkFavEmotionInit();

    String getAccessibilityDescription(Integer num);

    int getUploadProcessorID();

    boolean isInSyncing();

    void removeCacheAccessibilityEmotionData(Integer num);

    void removeSyncListener(n<CustomEmotionData> nVar);

    void resetSyncState();

    void setUpdateResultListener(a aVar);

    void syncIncreaseEmoticonExposeNum(CustomEmotionData customEmotionData);

    void syncLocalDel();

    void syncRoaming();

    TransferRequest syncUpload(CustomEmotionData customEmotionData, ad adVar);

    void syncUpload(CustomEmotionData customEmotionData);

    void syncUpload(List<CustomEmotionData> list);

    void updateCustomEmotionDataOCR(CustomEmotionData customEmotionData);

    void updateCustomEmotionDataOCRReq(CustomEmotionData customEmotionData, String str);
}

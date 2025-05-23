package com.tencent.mobileqq.wink.publish.api;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWinkDraft extends QRouteApi {
    void delete(long j3, List<String> list);

    void delete(long j3, String... strArr);

    void deleteAll();

    void deleteAll(long j3);

    void deleteByMissionId(long j3, String str);

    @WorkerThread
    List<DraftBean> getAllDataSync();

    @WorkerThread
    List<String> getAllDraftMissionIdsSync();

    List<DraftBean> getDataByUploadStatusSync(long j3, int... iArr);

    @WorkerThread
    DraftBean getLastDraftBeanSync(long j3);

    LiveData<List<DraftBean>> getLiveDataDrafts();

    void updateToastStatus(long j3, String str, int i3);

    void updateUploadStatus(long j3, String str, int i3);
}

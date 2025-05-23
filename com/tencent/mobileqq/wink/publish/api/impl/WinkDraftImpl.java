package com.tencent.mobileqq.wink.publish.api.impl;

import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.wink.publish.api.IWinkDraft;
import com.tencent.mobileqq.wink.publish.util.WinkDraftUtil;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkDraftImpl implements IWinkDraft {
    private static final String TAG = "[PublishUpload]WinkDraftImpl";

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkDraft
    public void delete(long j3, String... strArr) {
        WinkDraftUtil.g(j3, strArr);
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkDraft
    public void deleteAll() {
        WinkDraftUtil.d();
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkDraft
    public void deleteByMissionId(long j3, String str) {
        WinkDraftUtil.f(j3, str);
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkDraft
    public List<DraftBean> getAllDataSync() {
        return WinkDraftUtil.h();
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkDraft
    public List<String> getAllDraftMissionIdsSync() {
        return WinkDraftUtil.j();
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkDraft
    public List<DraftBean> getDataByUploadStatusSync(long j3, int... iArr) {
        return WinkDraftUtil.l(j3, iArr);
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkDraft
    public DraftBean getLastDraftBeanSync(long j3) {
        return WinkDraftUtil.m(j3);
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkDraft
    public LiveData<List<DraftBean>> getLiveDataDrafts() {
        return WinkDraftUtil.i();
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkDraft
    public void updateToastStatus(long j3, String str, int i3) {
        QLog.d(TAG, 1, "[updateToastStatus] uin: " + j3 + " missionId:" + str + ", status:" + i3);
        WinkDraftUtil.o(j3, str, i3);
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkDraft
    public void updateUploadStatus(long j3, String str, int i3) {
        QLog.d(TAG, 1, "[updateUploadStatus] uin: " + j3 + " missionId:" + str + ", status:" + i3);
        WinkDraftUtil.p(j3, str, i3);
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkDraft
    public void delete(long j3, List<String> list) {
        WinkDraftUtil.c(j3, list);
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkDraft
    public void deleteAll(long j3) {
        WinkDraftUtil.e(j3);
    }
}

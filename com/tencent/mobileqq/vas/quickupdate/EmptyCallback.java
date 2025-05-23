package com.tencent.mobileqq.vas.quickupdate;

import com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateListener;
import com.tencent.mobileqq.vas.updatesystem.callback.TagItemInfo;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class EmptyCallback extends BaseUpdateCallback {
    private void logError(String str, long j3, String str2) {
        QLog.e("EmptyCallback", 1, "call empty method:" + str + " with " + j3 + "_" + str2, new Exception());
    }

    @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback, com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback
    public boolean canUpdate(long j3, String str, String str2) {
        logError("canUpdate", j3, str);
        return false;
    }

    @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback, com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback
    public boolean deleteFiles(long j3, String str) {
        logError("deleteFiles", j3, str);
        return true;
    }

    @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback
    public void doOnCompleted(long j3, String str, String str2, String str3, int i3, int i16) {
        logError("_onCompleted", j3, str);
    }

    @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback
    public void doOnProgress(long j3, String str, String str2, long j16, long j17) {
        logError("_onProgress", j3, str);
    }

    @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback
    public void download(long j3, String str, QuickUpdateListener quickUpdateListener, boolean z16) {
        logError("download", j3, str);
    }

    @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback
    public long getBID() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback, com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback
    public TagItemInfo getItemInfo(long j3, String str) {
        logError("getItemInfo", j3, str);
        return null;
    }

    @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback, com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback
    public boolean isFileExists(long j3, String str) {
        logError("isFileExists", j3, str);
        return true;
    }
}

package com.tencent.mobileqq.zplan.servlet;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/servlet/ZPlanRequest$requestGetIsFriendByUserId$receiver$1", "Landroid/os/ResultReceiver;", "", QzoneIPCModule.RESULT_CODE, "Landroid/os/Bundle;", "resultData", "", "onReceiveResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanRequest$requestGetIsFriendByUserId$receiver$1 extends ResultReceiver {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ d f335379d;

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        boolean z16 = false;
        if (resultCode == 0) {
            Integer valueOf = resultData != null ? Integer.valueOf(resultData.getInt("friend_setting")) : null;
            d dVar = this.f335379d;
            if (valueOf != null && valueOf.intValue() == 101) {
                z16 = true;
            }
            dVar.a(true, Boolean.valueOf(z16));
            return;
        }
        QLog.e("[zplan]ZPlanRequest", 1, "[requestGetIsFriendByOpenId] fail");
        this.f335379d.a(false, null);
    }
}

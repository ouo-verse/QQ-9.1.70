package com.tencent.mobileqq.zplan.share.action;

import android.app.Activity;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.mobileqq.zplan.share.ZPlanShareParam;
import com.tencent.mobileqq.zplan.share.action.b;
import com.tencent.mobileqq.zplan.share.report.SameStyleShareReporter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001b\u0010\u001cJ*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J \u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J*\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0017\u0010\u001a\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/action/a;", "Lcom/tencent/mobileqq/zplan/share/action/b;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zplan/share/e;", "shareParams", "", "uinType", "", "uin", "", "d", "Lcom/tencent/mobileqq/zplan/share/ZPlanShareLaunchParam;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "f", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "listener", "", IProfileProtocolConst.PARAM_IS_FRIEND, "e", "Lcom/tencent/mobileqq/zplan/share/report/c;", "a", "b", "I", "getShareType", "()I", "shareType", "<init>", "(I)V", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class a implements b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int shareType;

    public a(int i3) {
        this.shareType = i3;
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public com.tencent.mobileqq.zplan.share.report.c a() {
        int i3 = this.shareType;
        if (i3 == 1) {
            return new com.tencent.mobileqq.zplan.share.report.g();
        }
        if (i3 == 2) {
            return new com.tencent.mobileqq.zplan.share.report.b();
        }
        if (i3 == 3) {
            return new com.tencent.mobileqq.zplan.share.report.h(0);
        }
        if (i3 != 7) {
            return new SameStyleShareReporter();
        }
        return new com.tencent.mobileqq.zplan.share.report.h(1);
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void b(Activity activity, ZPlanShareParam zPlanShareParam) {
        b.C9201b.e(this, activity, zPlanShareParam);
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void c(ZPlanShareLaunchParam zPlanShareLaunchParam) {
        b.C9201b.d(this, zPlanShareLaunchParam);
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void d(Activity activity, ZPlanShareParam shareParams, int uinType, String uin) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        QLog.i("CommonShareAction", 1, "send video to friend by select");
        com.tencent.mobileqq.zplan.share.d.f335534a.w(activity, uinType, uin, shareParams);
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void e(Activity activity, ZPlanShareParam shareParams, WXShareHelper.a listener, boolean isFriend) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        if (!b.INSTANCE.a()) {
            activity.finish();
            return;
        }
        QLog.i("CommonShareAction", 1, "share To WX: isFriend: " + isFriend + ", " + shareParams);
        com.tencent.mobileqq.zplan.share.d.f335534a.u(shareParams, isFriend, listener);
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void f(Activity activity, ZPlanShareParam shareParams, ZPlanShareLaunchParam launchParam) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        QLog.i("CommonShareAction", 1, "send video to qzone");
        com.tencent.mobileqq.zplan.share.d dVar = com.tencent.mobileqq.zplan.share.d.f335534a;
        dVar.e(activity, shareParams, launchParam);
        dVar.z(activity, shareParams);
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void onDestroy() {
        b.C9201b.a(this);
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void onFinish() {
        b.C9201b.b(this);
    }

    @Override // com.tencent.mobileqq.zplan.share.action.b
    public void onResume() {
        b.C9201b.c(this);
    }
}

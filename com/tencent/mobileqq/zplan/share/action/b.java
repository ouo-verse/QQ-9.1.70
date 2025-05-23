package com.tencent.mobileqq.zplan.share.action;

import android.app.Activity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.mobileqq.zplan.share.ZPlanShareParam;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J*\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&J*\u0010\u0017\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u0019H&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/action/b;", "", "Lcom/tencent/mobileqq/zplan/share/ZPlanShareLaunchParam;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "", "c", "onFinish", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zplan/share/e;", "shareParams", "", "uinType", "", "uin", "d", "f", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "listener", "", IProfileProtocolConst.PARAM_IS_FRIEND, "e", "b", "Lcom/tencent/mobileqq/zplan/share/report/c;", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = Companion.f335504a;

    com.tencent.mobileqq.zplan.share.report.c a();

    void b(Activity activity, ZPlanShareParam shareParams);

    void c(ZPlanShareLaunchParam launchParam);

    void d(Activity activity, ZPlanShareParam shareParams, int uinType, String uin);

    void e(Activity activity, ZPlanShareParam shareParams, WXShareHelper.a listener, boolean isFriend);

    void f(Activity activity, ZPlanShareParam shareParams, ZPlanShareLaunchParam launchParam);

    void onDestroy();

    void onFinish();

    void onResume();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004J\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/action/b$a;", "", "", "type", "", "", "extra", "Lcom/tencent/mobileqq/zplan/share/action/b;", "b", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.share.action.b$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f335504a = new Companion();

        Companion() {
        }

        public final boolean a() {
            if (!WXShareHelper.b0().e0()) {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.f173257ih1, 0).show();
                return false;
            }
            if (WXShareHelper.b0().f0()) {
                return true;
            }
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f173258ih2, 0).show();
            return false;
        }

        public final b b(int type, Map<String, ? extends Object> extra) {
            if (type == 4) {
                return new SmallHomeShotShareAction();
            }
            if (type == 5) {
                return new h(type, extra);
            }
            if (type == 6) {
                return new d();
            }
            if (type != 8) {
                return new a(type);
            }
            return new i(extra);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.zplan.share.action.b$b, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public static final class C9201b {
        public static void d(b bVar, ZPlanShareLaunchParam launchParam) {
            Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        }

        public static void e(b bVar, Activity activity, ZPlanShareParam shareParams) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        }

        public static void a(b bVar) {
        }

        public static void b(b bVar) {
        }

        public static void c(b bVar) {
        }
    }
}

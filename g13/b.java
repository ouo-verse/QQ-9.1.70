package g13;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J.\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\fJ\"\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lg13/b;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "peerUin", "", "fcId", "", "mute", "", "b", "d", "e", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "funCallView", "Landroid/app/Activity;", "mActivity", "f", "Landroid/view/ViewGroup;", "mParent", h.F, "Z", "muteState", "<init>", "()V", "i", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b implements com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g funCallView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Activity mActivity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup mParent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean muteState;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(b this$0, ViewGroup.LayoutParams params) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(params, "$params");
        Object obj = this$0.funCallView;
        if (obj != null && (viewGroup = this$0.mParent) != null) {
            viewGroup.addView((View) obj, 0, params);
        }
    }

    public final void b(@NotNull Activity activity, @NotNull ViewGroup parent, @NotNull String peerUin, int fcId, boolean mute) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        QLog.i("VasKuiklyFunCallManager", 1, "oncreate addKuiklyFunCallView");
        if (this.funCallView == null) {
            this.mActivity = activity;
            if (fcId != 0) {
                IQQKuiklyFactory iQQKuiklyFactory = (IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class);
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                this.funCallView = iQQKuiklyFactory.createKuiklyRenderView(context, this);
                final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                String kuiklySchema = VipFunCallUtil.getKuiklySchema();
                QLog.i("VasKuiklyFunCallManager", 1, "scheme: " + kuiklySchema + "&fun_call_id=" + fcId + "&is_call=0&peer_uin=" + peerUin);
                g gVar = this.funCallView;
                if (gVar != null) {
                    g.a.a(gVar, kuiklySchema + "&fun_call_id=" + fcId + "&is_call=0&peer_uin=" + peerUin + "&mute=" + mute, null, 2, null);
                }
                this.mParent = parent;
                if (parent != null) {
                    parent.post(new Runnable() { // from class: g13.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.c(b.this, layoutParams);
                        }
                    });
                }
            }
        }
    }

    public final void d() {
        QLog.i("VasKuiklyFunCallManager", 1, "sendEventOnConnect remove uiChange");
        g gVar = this.funCallView;
        if (gVar != null) {
            if (gVar != null) {
                gVar.onDetach();
            }
            ViewGroup viewGroup = this.mParent;
            if (viewGroup != null) {
                Object obj = this.funCallView;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
                viewGroup.removeView((View) obj);
            }
            this.funCallView = null;
        }
    }

    public final void e() {
        Map<String, ? extends Object> emptyMap;
        QLog.i("VasKuiklyFunCallManager", 1, "sentEventOnDestroy");
        g gVar = this.funCallView;
        if (gVar != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            gVar.sentEvent("onStopFunCall", emptyMap);
        }
        g gVar2 = this.funCallView;
        if (gVar2 != null) {
            gVar2.onDetach();
        }
        ViewGroup viewGroup = this.mParent;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        this.mParent = null;
        this.funCallView = null;
        this.mActivity = null;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
        h.a.a(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        h.a.b(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, @Nullable ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        QLog.i("VasKuiklyFunCallManager", 1, "onPageLoadComplete");
        QLog.i("VasKuiklyFunCallManager", 1, "sendEventPlay inner");
        g gVar = this.funCallView;
        if (gVar != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("mute", Boolean.valueOf(this.muteState)));
            gVar.sentEvent("play", mapOf);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
        h.a.c(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
        h.a.d(this);
    }
}

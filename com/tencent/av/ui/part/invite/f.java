package com.tencent.av.ui.part.invite;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import mw.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016J\"\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/av/ui/part/invite/f;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "", "A9", "", "z9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "mRootLayout", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "e", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "mFunCallView", "Lmw/m;", "f", "Lmw/m;", "mInfoIoc", "Lmqq/util/WeakReference;", "Lcom/tencent/av/ui/VideoInviteActivity;", tl.h.F, "Lmqq/util/WeakReference;", "mVIActivity", "<init>", "()V", "i", "a", "qqrtc_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class f extends Part implements com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mRootLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g mFunCallView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private m mInfoIoc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private WeakReference<VideoInviteActivity> mVIActivity;

    private final void A9() {
        if (this.mFunCallView == null) {
            QLog.e("VasInviteFunCallPart", 1, "null pending addKuiklyFunCallView");
            int z95 = z9();
            if (z95 != 0) {
                m mVar = this.mInfoIoc;
                SessionInfo sessionInfo = mVar != null ? mVar.getSessionInfo() : null;
                if (sessionInfo == null || sessionInfo.f73043k == 4) {
                    return;
                }
                int i3 = sessionInfo.f73035i;
                if ((i3 == 1 || i3 == 0) && this.mRootLayout != null) {
                    IQQKuiklyFactory iQQKuiklyFactory = (IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class);
                    BaseApplication context = BaseApplication.context;
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    this.mFunCallView = iQQKuiklyFactory.createKuiklyRenderView(context, this);
                    final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                    String kuiklySchema = VipFunCallUtil.getKuiklySchema();
                    QLog.i("VasInviteFunCallPart", 1, "scheme: " + kuiklySchema + "&fun_call_id=" + z95 + "&is_call=1&changed");
                    com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = this.mFunCallView;
                    if (gVar != null) {
                        g.a.a(gVar, kuiklySchema + "&fun_call_id=" + z95 + "&is_call=1", null, 2, null);
                    }
                    QLog.i("VasInviteFunCallPart", 1, "funCallId: " + z95);
                    RelativeLayout relativeLayout = this.mRootLayout;
                    if (relativeLayout != null) {
                        relativeLayout.post(new Runnable() { // from class: com.tencent.av.ui.part.invite.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                f.B9(f.this, layoutParams);
                            }
                        });
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(f this$0, ViewGroup.LayoutParams params) {
        RelativeLayout relativeLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(params, "$params");
        Object obj = this$0.mFunCallView;
        if (obj == null || (relativeLayout = this$0.mRootLayout) == null) {
            return;
        }
        relativeLayout.addView((View) obj, 0, params);
    }

    private final int z9() {
        if (getActivity() instanceof VideoInviteActivity) {
            Activity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.av.ui.VideoInviteActivity");
            WeakReference<VideoInviteActivity> weakReference = new WeakReference<>((VideoInviteActivity) activity);
            this.mVIActivity = weakReference;
            VideoInviteActivity videoInviteActivity = weakReference.get();
            m mVar = this.mInfoIoc;
            Intrinsics.checkNotNull(mVar);
            boolean f16 = mVar.f();
            AppRuntime appRuntime = videoInviteActivity != null ? videoInviteActivity.getAppRuntime() : null;
            m mVar2 = this.mInfoIoc;
            return kw.a.a(appRuntime, mVar2 != null ? mVar2.getPeerUin() : null, false, f16);
        }
        QLog.e("VasInviteFunCallPart", 1, "addVipCallVideo for get not VideoInviteActivity - " + getActivity());
        return 0;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
        h.a.a(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        h.a.b(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mRootLayout = (RelativeLayout) rootView.findViewById(R.id.root_layout);
        this.mInfoIoc = (m) RFWIocAbilityProvider.g().getIocInterface(m.class, rootView, null);
        A9();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, ErrorReason errorReason, KuiklyRenderCoreExecuteMode executeMode) {
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        QLog.i("VasInviteFunCallPart", 1, "onPageLoadComplete");
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        Map<String, ? extends Object> emptyMap;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        QLog.i("VasInviteFunCallPart", 1, "sentEventOnDestroy");
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar = this.mFunCallView;
        if (gVar != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            gVar.sentEvent(DKHippyEvent.EVENT_STOP, emptyMap);
        }
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g gVar2 = this.mFunCallView;
        if (gVar2 != null) {
            gVar2.onDetach();
        }
        this.mFunCallView = null;
        RelativeLayout relativeLayout = this.mRootLayout;
        if (relativeLayout != null) {
            Intrinsics.checkNotNull(relativeLayout);
            relativeLayout.removeAllViews();
            this.mRootLayout = null;
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

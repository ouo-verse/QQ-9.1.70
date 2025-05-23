package com.tencent.mobileqq.wxmini.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.e;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.mobileqq.wxmini.api.data.d;
import com.tencent.mobileqq.wxmini.ui.WxMiniTipUserInfoFragment;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.widget.RoundRectImageView;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wxmini/ui/WxMiniTipUserInfoFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/View;", "th", "", "dismiss", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "needStatusTrans", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "Lcom/tencent/mobileqq/wxmini/api/data/d;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wxmini/api/data/d;", "wh", "()Lcom/tencent/mobileqq/wxmini/api/data/d;", "info", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView;", "D", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView;", "floatingView", "<init>", "()V", "E", "a", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class WxMiniTipUserInfoFragment extends QPublicBaseFragment {

    /* renamed from: E, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static WeakReference<Activity> F;

    /* renamed from: C, reason: from kotlin metadata */
    private final d info = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).getBindingWeChatUserInfo();

    /* renamed from: D, reason: from kotlin metadata */
    private QUSBaseHalfScreenFloatingView floatingView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wxmini/ui/WxMiniTipUserInfoFragment$a;", "", "", "a", "", "DESKTOP_WX_BIND_SCHEMA", "Ljava/lang/String;", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "showingActivityRef", "Ljava/lang/ref/WeakReference;", "<init>", "()V", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wxmini.ui.WxMiniTipUserInfoFragment$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            WeakReference weakReference = WxMiniTipUserInfoFragment.F;
            Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            activity.finish();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wxmini/ui/WxMiniTipUserInfoFragment$c", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$o;", "", "a", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements QUSBaseHalfScreenFloatingView.o {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public void a() {
            WxMiniTipUserInfoFragment.this.dismiss();
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public boolean onClick(View v3) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismiss() {
        Map<String, String> mutableMapOf;
        Intent intent;
        QUSBaseHalfScreenFloatingView qUSBaseHalfScreenFloatingView = this.floatingView;
        if (qUSBaseHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSBaseHalfScreenFloatingView = null;
        }
        qUSBaseHalfScreenFloatingView.t();
        QUSBaseHalfScreenFloatingView qUSBaseHalfScreenFloatingView2 = this.floatingView;
        if (qUSBaseHalfScreenFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSBaseHalfScreenFloatingView2 = null;
        }
        qUSBaseHalfScreenFloatingView2.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: jb3.a
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                WxMiniTipUserInfoFragment.vh(WxMiniTipUserInfoFragment.this);
            }
        });
        IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
        Pair[] pairArr = new Pair[3];
        FragmentActivity activity = getActivity();
        pairArr[0] = TuplesKt.to("applet_appid", (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getStringExtra("applet_appid"));
        d dVar = this.info;
        pairArr[1] = TuplesKt.to(StartupReportKey.WX_OPENID, dVar != null ? dVar.f() : null);
        d dVar2 = this.info;
        pairArr[2] = TuplesKt.to(StartupReportKey.TID_USERID, dVar2 != null ? dVar2.g() : null);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        iMiniAppService.miniAppDesktopCommonReport("dt_pgout", "", mutableMapOf, "pg_applet_identity_notice");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(WxMiniTipUserInfoFragment this$0, View view) {
        Map<String, String> mutableMapOf;
        Intent intent;
        Intent intent2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("pgid", "pg_applet_identity_notice");
        FragmentActivity activity = this$0.getActivity();
        pairArr[1] = TuplesKt.to("applet_appid", (activity == null || (intent2 = activity.getIntent()) == null) ? null : intent2.getStringExtra("applet_appid"));
        FragmentActivity activity2 = this$0.getActivity();
        pairArr[2] = TuplesKt.to(StartupReportKey.TID_USERID, (activity2 == null || (intent = activity2.getIntent()) == null) ? null : intent.getStringExtra(StartupReportKey.TID_USERID));
        d dVar = this$0.info;
        pairArr[3] = TuplesKt.to(StartupReportKey.WX_OPENID, dVar != null ? dVar.f() : null);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        iMiniAppService.miniAppDesktopCommonPageReport("dt_clck", MiniAppDesktopDtReportHelper.MINI_APP_APPLET_CLOSE_BUTTON, mutableMapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(WxMiniTipUserInfoFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (activity instanceof QBaseActivity) {
            QBaseActivity qBaseActivity = (QBaseActivity) activity;
            Window window = qBaseActivity.getWindow();
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(1024);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            qBaseActivity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        QUSBaseHalfScreenFloatingView qUSBaseHalfScreenFloatingView = this.floatingView;
        if (qUSBaseHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSBaseHalfScreenFloatingView = null;
        }
        ViewParent parent = qUSBaseHalfScreenFloatingView.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        QUSBaseHalfScreenFloatingView qUSBaseHalfScreenFloatingView2 = this.floatingView;
        if (qUSBaseHalfScreenFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSBaseHalfScreenFloatingView2 = null;
        }
        viewGroup.removeView(qUSBaseHalfScreenFloatingView2);
        LayoutInflater from = LayoutInflater.from(getActivity());
        Intrinsics.checkNotNullExpressionValue(from, "from(activity)");
        viewGroup.addView(onCreateView(from, null, null));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        F = new WeakReference<>(getActivity());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        F = null;
    }

    /* renamed from: wh, reason: from getter */
    public final d getInfo() {
        return this.info;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wxmini/ui/WxMiniTipUserInfoFragment$b", "Lcom/tencent/mobileqq/widget/qus/e;", "", HippyTKDListViewAdapter.X, "y", "", "canScrollDown", "canScrollUp", "Landroid/view/View;", "createContentView", "", "initState", "defaultHeight", "showMode", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends e {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(WxMiniTipUserInfoFragment this$0, View view) {
            Map<String, String> mutableMapOf;
            Intent intent;
            Intent intent2;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.dismiss();
            IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
            Pair[] pairArr = new Pair[4];
            pairArr[0] = TuplesKt.to("pgid", "pg_applet_identity_notice");
            FragmentActivity activity = this$0.getActivity();
            String str = null;
            pairArr[1] = TuplesKt.to("applet_appid", (activity == null || (intent2 = activity.getIntent()) == null) ? null : intent2.getStringExtra("applet_appid"));
            FragmentActivity activity2 = this$0.getActivity();
            if (activity2 != null && (intent = activity2.getIntent()) != null) {
                str = intent.getStringExtra(StartupReportKey.TID_USERID);
            }
            pairArr[2] = TuplesKt.to(StartupReportKey.TID_USERID, str);
            pairArr[3] = TuplesKt.to(StartupReportKey.WX_OPENID, this$0.getInfo().f());
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            iMiniAppService.miniAppDesktopCommonPageReport("dt_clck", "em_applet_confirm_button", mutableMapOf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(TextView textView, WxMiniTipUserInfoFragment this$0, View view) {
            Map<String, String> mutableMapOf;
            Intent intent;
            Intent intent2;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).gotoSchemaUri(textView.getContext(), "mqqapi://miniapp/bindwx?page_type=desktop");
            IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
            Pair[] pairArr = new Pair[4];
            pairArr[0] = TuplesKt.to("pgid", "pg_applet_identity_notice");
            FragmentActivity activity = this$0.getActivity();
            String str = null;
            pairArr[1] = TuplesKt.to("applet_appid", (activity == null || (intent2 = activity.getIntent()) == null) ? null : intent2.getStringExtra("applet_appid"));
            FragmentActivity activity2 = this$0.getActivity();
            if (activity2 != null && (intent = activity2.getIntent()) != null) {
                str = intent.getStringExtra(StartupReportKey.TID_USERID);
            }
            pairArr[2] = TuplesKt.to(StartupReportKey.TID_USERID, str);
            pairArr[3] = TuplesKt.to(StartupReportKey.WX_OPENID, this$0.getInfo().f());
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            iMiniAppService.miniAppDesktopCommonPageReport("dt_clck", "em_applet_view_detail_button", mutableMapOf);
            this$0.dismiss();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float x16, float y16) {
            return false;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float x16, float y16) {
            return false;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF57419d() {
            View inflate = WxMiniTipUserInfoFragment.this.getLayoutInflater().inflate(R.layout.fg5, (ViewGroup) null);
            final WxMiniTipUserInfoFragment wxMiniTipUserInfoFragment = WxMiniTipUserInfoFragment.this;
            ((Button) inflate.findViewById(R.id.u19)).setOnClickListener(new View.OnClickListener() { // from class: jb3.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WxMiniTipUserInfoFragment.b.c(WxMiniTipUserInfoFragment.this, view);
                }
            });
            RoundRectImageView roundRectImageView = (RoundRectImageView) inflate.findViewById(R.id.f125577mf);
            roundRectImageView.setCornerRadiusAndMode(ViewUtils.dpToPx(8.0f), 1);
            QQPicLoader.f201806a.d().loadImage(Option.obtain().setUrl(wxMiniTipUserInfoFragment.getInfo().d()).setTargetView(roundRectImageView), null);
            ((TextView) inflate.findViewById(R.id.f125587mg)).setText(wxMiniTipUserInfoFragment.getInfo().e());
            final TextView textView = (TextView) inflate.findViewById(R.id.vrf);
            textView.setOnClickListener(new View.OnClickListener() { // from class: jb3.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WxMiniTipUserInfoFragment.b.d(textView, wxMiniTipUserInfoFragment, view);
                }
            });
            return inflate;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int initState() {
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        /* renamed from: defaultHeight */
        public int getF57420e() {
            return ViewUtils.dpToPx(311.0f);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Map<String, String> mutableMapOf;
        Map<String, String> mutableMapOf2;
        Intent intent;
        Intent intent2;
        Intent intent3;
        Intent intent4;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (this.info == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
            return null;
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = new QUSHalfScreenFloatingView(inflater.getContext());
        this.floatingView = qUSHalfScreenFloatingView;
        qUSHalfScreenFloatingView.setQUSDragFloatController(new b());
        View th5 = th(inflater);
        QUSBaseHalfScreenFloatingView qUSBaseHalfScreenFloatingView = this.floatingView;
        if (qUSBaseHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSBaseHalfScreenFloatingView = null;
        }
        qUSBaseHalfScreenFloatingView.setHeaderView(th5);
        QUSBaseHalfScreenFloatingView qUSBaseHalfScreenFloatingView2 = this.floatingView;
        if (qUSBaseHalfScreenFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSBaseHalfScreenFloatingView2 = null;
        }
        qUSBaseHalfScreenFloatingView2.setOutSideTouchEnable(true);
        QUSBaseHalfScreenFloatingView qUSBaseHalfScreenFloatingView3 = this.floatingView;
        if (qUSBaseHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSBaseHalfScreenFloatingView3 = null;
        }
        qUSBaseHalfScreenFloatingView3.setOnOutsideClickListener(new c());
        QUSBaseHalfScreenFloatingView qUSBaseHalfScreenFloatingView4 = this.floatingView;
        if (qUSBaseHalfScreenFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSBaseHalfScreenFloatingView4 = null;
        }
        qUSBaseHalfScreenFloatingView4.setDraggable(false);
        IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("pgid", "pg_applet_identity_notice");
        FragmentActivity activity2 = getActivity();
        pairArr[1] = TuplesKt.to("applet_appid", (activity2 == null || (intent4 = activity2.getIntent()) == null) ? null : intent4.getStringExtra("applet_appid"));
        FragmentActivity activity3 = getActivity();
        pairArr[2] = TuplesKt.to(StartupReportKey.TID_USERID, (activity3 == null || (intent3 = activity3.getIntent()) == null) ? null : intent3.getStringExtra(StartupReportKey.TID_USERID));
        pairArr[3] = TuplesKt.to(StartupReportKey.WX_OPENID, this.info.f());
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        iMiniAppService.miniAppDesktopCommonReport("dt_pgin", "", mutableMapOf, "pg_applet_identity_notice");
        IMiniAppService iMiniAppService2 = (IMiniAppService) QRoute.api(IMiniAppService.class);
        Pair[] pairArr2 = new Pair[4];
        pairArr2[0] = TuplesKt.to("pgid", "pg_applet_identity_notice");
        FragmentActivity activity4 = getActivity();
        pairArr2[1] = TuplesKt.to("applet_appid", (activity4 == null || (intent2 = activity4.getIntent()) == null) ? null : intent2.getStringExtra("applet_appid"));
        FragmentActivity activity5 = getActivity();
        pairArr2[2] = TuplesKt.to(StartupReportKey.TID_USERID, (activity5 == null || (intent = activity5.getIntent()) == null) ? null : intent.getStringExtra(StartupReportKey.TID_USERID));
        pairArr2[3] = TuplesKt.to(StartupReportKey.WX_OPENID, this.info.f());
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(pairArr2);
        iMiniAppService2.miniAppDesktopCommonPageReport("dt_imp", "em_applet_identity_notice_panel", mutableMapOf2);
        QUSBaseHalfScreenFloatingView qUSBaseHalfScreenFloatingView5 = this.floatingView;
        if (qUSBaseHalfScreenFloatingView5 != null) {
            return qUSBaseHalfScreenFloatingView5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("floatingView");
        return null;
    }

    private final View th(LayoutInflater inflater) {
        View title = inflater.inflate(R.layout.fg6, (ViewGroup) null);
        ((ImageView) title.findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() { // from class: jb3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WxMiniTipUserInfoFragment.uh(WxMiniTipUserInfoFragment.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(title, "title");
        return title;
    }
}

package com.tencent.gdtad.api.interstitial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.api.interstitial.GdtInterstitialAdViewWithKuikly;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityLandscape;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityReverseLandscapeForTool;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/gdtad/api/interstitial/GdtInterstitialFragmentWithKuikly;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/ViewGroup;", "containerView", "", "th", "", "getTraceId", "", NodeProps.VISIBLE, "uh", "needStatusTrans", "needImmersive", "onBackEvent", "Landroid/view/LayoutInflater;", "inflater", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onFinish", "Lcom/tencent/gdtad/api/interstitial/GdtInterstitialAdViewWithKuikly;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/gdtad/api/interstitial/GdtInterstitialAdViewWithKuikly;", "mInterstitialAdViewWithKuikly", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "D", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "mLoadingView", "<init>", "()V", "E", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GdtInterstitialFragmentWithKuikly extends QPublicBaseFragment {

    @Nullable
    private static GdtInterstitialParams F;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private GdtInterstitialAdViewWithKuikly mInterstitialAdViewWithKuikly;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private QQProgressDialog mLoadingView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Set<String> G = new HashSet();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/gdtad/api/interstitial/GdtInterstitialFragmentWithKuikly$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "a", "Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;", "interstitialParams", "b", "", "KEY_AD_INFO", "Ljava/lang/String;", "KEY_PARAMS", "KEY_TIME_START", "TAG", "", "displayedSet", "Ljava/util/Set;", "mInterstitialParams", "Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.gdtad.api.interstitial.GdtInterstitialFragmentWithKuikly$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int a(Activity activity) {
            int i3;
            if (activity.getWindowManager().getDefaultDisplay().getRotation() == 1) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            return i3 ^ 1;
        }

        public final int b(@Nullable Activity activity, @Nullable GdtInterstitialParams interstitialParams) {
            Class cls;
            boolean contains;
            Bundle bundle;
            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) || activity == null || interstitialParams == null || !interstitialParams.canShow()) {
                return 4;
            }
            int a16 = a(activity);
            interstitialParams.orientation = a16;
            if (a16 == 1) {
                cls = QPublicTransFragmentActivity.class;
            } else if (a16 == 0) {
                cls = QPublicTransFragmentActivityLandscape.class;
            } else if (a16 == 8) {
                cls = QPublicTransFragmentActivityReverseLandscapeForTool.class;
            } else {
                cls = null;
            }
            if (cls != null) {
                contains = CollectionsKt___CollectionsKt.contains(GdtInterstitialFragmentWithKuikly.G, interstitialParams.getTraceId());
                if (!contains) {
                    Set set = GdtInterstitialFragmentWithKuikly.G;
                    String traceId = interstitialParams.getTraceId();
                    if (traceId == null) {
                        traceId = "";
                    }
                    set.add(traceId);
                    Bundle bundle2 = new Bundle();
                    GdtHandler.Options options = interstitialParams.clickOptions;
                    if (options != null && (bundle = options.extra) != null && !bundle.isEmpty()) {
                        bundle2.putAll(bundle);
                    }
                    bundle2.putParcelable("interstitialParams", interstitialParams);
                    bundle2.putLong("interstitialStartToShowTimeMillis", System.currentTimeMillis());
                    bundle2.putString("interstitialAdInfo", interstitialParams.adInfoJson);
                    Intent intent = new Intent();
                    intent.putExtra("public_fragment_window_feature", 1);
                    intent.putExtras(bundle2);
                    GdtInterstitialFragmentWithKuikly.F = interstitialParams;
                    QPublicFragmentActivity.b.e(activity, intent, cls, GdtInterstitialFragmentWithKuikly.class, 10001);
                    QLog.d("GdtInterstitialFragmentWithKuikly", 1, "start errorCode:", 0);
                    return 0;
                }
                return 2;
            }
            return 4;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/gdtad/api/interstitial/GdtInterstitialFragmentWithKuikly$b", "Lcom/tencent/gdtad/api/interstitial/GdtInterstitialAdViewWithKuikly$a;", "", "a", "onAdClose", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements GdtInterstitialAdViewWithKuikly.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FrameLayout f108605b;

        b(FrameLayout frameLayout) {
            this.f108605b = frameLayout;
        }

        @Override // com.tencent.gdtad.api.interstitial.GdtInterstitialAdViewWithKuikly.a
        public void a() {
            QLog.d("GdtInterstitialFragmentWithKuikly", 1, "onAdShow");
            GdtInterstitialFragmentWithKuikly.this.uh(false);
        }

        @Override // com.tencent.gdtad.api.interstitial.GdtInterstitialAdViewWithKuikly.a
        public void onAdClose() {
            QLog.d("GdtInterstitialFragmentWithKuikly", 1, "onAdClose");
            GdtInterstitialFragmentWithKuikly.this.th(this.f108605b);
        }
    }

    private final String getTraceId() {
        GdtInterstitialParams gdtInterstitialParams;
        GdtInterstitialParams gdtInterstitialParams2 = F;
        boolean z16 = false;
        if (gdtInterstitialParams2 != null && gdtInterstitialParams2.canShow()) {
            z16 = true;
        }
        if (!z16 || (gdtInterstitialParams = F) == null) {
            return null;
        }
        return gdtInterstitialParams.getTraceId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void th(ViewGroup containerView) {
        uh(false);
        if (containerView != null) {
            containerView.removeAllViews();
        }
        if (containerView != null) {
            containerView.setVisibility(8);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uh(boolean visible) {
        int i3;
        boolean z16 = false;
        boolean z17 = true;
        QLog.d("GdtInterstitialFragmentWithKuikly", 1, "setLoading visible:", Boolean.valueOf(visible));
        if (visible) {
            QQProgressDialog qQProgressDialog = this.mLoadingView;
            if (qQProgressDialog == null || qQProgressDialog.isShowing()) {
                z17 = false;
            }
            if (z17) {
                FragmentActivity activity = getActivity();
                QBaseActivity qBaseActivity = getQBaseActivity();
                if (qBaseActivity != null) {
                    i3 = qBaseActivity.getTitleBarHeight();
                } else {
                    i3 = 0;
                }
                QQProgressDialog qQProgressDialog2 = new QQProgressDialog(activity, i3);
                this.mLoadingView = qQProgressDialog2;
                qQProgressDialog2.setCancelable(false);
                QQProgressDialog qQProgressDialog3 = this.mLoadingView;
                if (qQProgressDialog3 != null) {
                    qQProgressDialog3.setMessage("\u6b63\u5728\u52a0\u8f7d");
                }
                QQProgressDialog qQProgressDialog4 = this.mLoadingView;
                if (qQProgressDialog4 != null) {
                    qQProgressDialog4.show();
                    return;
                }
                return;
            }
            return;
        }
        QQProgressDialog qQProgressDialog5 = this.mLoadingView;
        if (qQProgressDialog5 != null) {
            if (qQProgressDialog5 != null && qQProgressDialog5.isShowing()) {
                z16 = true;
            }
            if (z16) {
                try {
                    QQProgressDialog qQProgressDialog6 = this.mLoadingView;
                    if (qQProgressDialog6 != null) {
                        qQProgressDialog6.dismiss();
                    }
                } catch (Throwable th5) {
                    QLog.e("GdtInterstitialFragmentWithKuikly", 1, "setLoading", th5);
                }
            }
            this.mLoadingView = null;
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String str;
        boolean z16;
        FragmentActivity activity;
        Window window;
        Intent intent;
        Bundle extras;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FrameLayout frameLayout = (FrameLayout) inflater.inflate(R.layout.ecl, container, false).findViewById(R.id.vmi);
        uh(true);
        FragmentActivity activity2 = getActivity();
        View view = null;
        if (activity2 != null && (intent = activity2.getIntent()) != null && (extras = intent.getExtras()) != null) {
            str = extras.getString("interstitialAdInfo", "");
        } else {
            str = null;
        }
        QLog.d("GdtInterstitialFragmentWithKuikly", 1, "onCreateView ad:", str);
        FragmentActivity activity3 = getActivity();
        if (activity3 != null) {
            this.mInterstitialAdViewWithKuikly = new GdtInterstitialAdViewWithKuikly(activity3, str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (frameLayout != null) {
                GdtInterstitialAdViewWithKuikly gdtInterstitialAdViewWithKuikly = this.mInterstitialAdViewWithKuikly;
                if (gdtInterstitialAdViewWithKuikly != null) {
                    view = gdtInterstitialAdViewWithKuikly.getView();
                }
                frameLayout.addView(view, layoutParams);
            }
            GdtInterstitialAdViewWithKuikly gdtInterstitialAdViewWithKuikly2 = this.mInterstitialAdViewWithKuikly;
            if (gdtInterstitialAdViewWithKuikly2 != null) {
                gdtInterstitialAdViewWithKuikly2.setAdCloseListener(new b(frameLayout));
            }
            GdtInterstitialParams gdtInterstitialParams = F;
            if (gdtInterstitialParams != null && !gdtInterstitialParams.windowTranslucentStatus) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && (activity = getActivity()) != null && (window = activity.getWindow()) != null) {
                window.addFlags(1024);
            }
            QLog.d("GdtInterstitialFragmentWithKuikly", 1, "onCreateView traceId:", getTraceId());
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, frameLayout);
        return frameLayout;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        GdtInterstitialAdViewWithKuikly gdtInterstitialAdViewWithKuikly = this.mInterstitialAdViewWithKuikly;
        if (gdtInterstitialAdViewWithKuikly != null) {
            gdtInterstitialAdViewWithKuikly.destroy(getContext());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        GdtInterstitialAdViewWithKuikly gdtInterstitialAdViewWithKuikly = this.mInterstitialAdViewWithKuikly;
        if (gdtInterstitialAdViewWithKuikly != null) {
            gdtInterstitialAdViewWithKuikly.pause(getContext());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        GdtInterstitialAdViewWithKuikly gdtInterstitialAdViewWithKuikly = this.mInterstitialAdViewWithKuikly;
        if (gdtInterstitialAdViewWithKuikly != null) {
            gdtInterstitialAdViewWithKuikly.resume(getContext());
        }
    }
}

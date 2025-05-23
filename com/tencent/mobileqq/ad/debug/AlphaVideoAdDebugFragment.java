package com.tencent.mobileqq.ad.debug;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.ad.alphavideo.MaskAdAlphaVideoView;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0014J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/ad/debug/AlphaVideoAdDebugFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initViews", "th", "sh", "", "url", "xh", "init", "", "getContentLayoutId", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/ad/alphavideo/MaskAdAlphaVideoView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/ad/alphavideo/MaskAdAlphaVideoView;", "mAlphaVideoView", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "mAlphaVideoClearResBtn", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "E", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "mAlphaVideoUrlInput", UserInfo.SEX_FEMALE, "mAlphaVideoShowBtn", "Landroid/widget/FrameLayout;", "G", "Landroid/widget/FrameLayout;", "mAlphaVideoContainer", "<init>", "()V", "H", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AlphaVideoAdDebugFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private MaskAdAlphaVideoView mAlphaVideoView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mAlphaVideoClearResBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private QUISingleLineInputView mAlphaVideoUrlInput;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mAlphaVideoShowBtn;

    /* renamed from: G, reason: from kotlin metadata */
    private FrameLayout mAlphaVideoContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/ad/debug/AlphaVideoAdDebugFragment$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "a", "", "TAG", "Ljava/lang/String;", "TITLE", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ad.debug.AlphaVideoAdDebugFragment$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@Nullable Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            } else if (activity == null) {
                QLog.e("AlphaVideoAdDebugFragment", 1, "start error");
            } else {
                QPublicFragmentActivity.start(activity, AlphaVideoAdDebugFragment.class);
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27770);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AlphaVideoAdDebugFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void init() {
        MaskAdAlphaVideoView maskAdAlphaVideoView;
        Context context = getContext();
        FrameLayout frameLayout = null;
        if (context != null) {
            maskAdAlphaVideoView = new MaskAdAlphaVideoView(context);
        } else {
            maskAdAlphaVideoView = null;
        }
        this.mAlphaVideoView = maskAdAlphaVideoView;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        FrameLayout frameLayout2 = this.mAlphaVideoContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlphaVideoContainer");
        } else {
            frameLayout = frameLayout2;
        }
        frameLayout.addView(this.mAlphaVideoView, layoutParams);
    }

    private final void initViews(View rootView) {
        View findViewById = rootView.findViewById(R.id.f58822r2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026qq_alpha_video_clean_res)");
        this.mAlphaVideoClearResBtn = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f58852r5);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026qq_alpha_video_url_input)");
        this.mAlphaVideoUrlInput = (QUISingleLineInputView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f58842r4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.qq_alpha_video_show)");
        this.mAlphaVideoShowBtn = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.f58832r3);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026qq_alpha_video_container)");
        this.mAlphaVideoContainer = (FrameLayout) findViewById4;
    }

    private final void sh() {
        QUISingleLineInputView qUISingleLineInputView = this.mAlphaVideoUrlInput;
        QUISingleLineInputView qUISingleLineInputView2 = null;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlphaVideoUrlInput");
            qUISingleLineInputView = null;
        }
        qUISingleLineInputView.setPromptText("\u8bf7\u8f93\u5165\u900f\u660e\u89c6\u9891url");
        QUISingleLineInputView qUISingleLineInputView3 = this.mAlphaVideoUrlInput;
        if (qUISingleLineInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlphaVideoUrlInput");
        } else {
            qUISingleLineInputView2 = qUISingleLineInputView3;
        }
        qUISingleLineInputView2.setShowWordCount(false);
    }

    private final void th() {
        TextView textView = this.mAlphaVideoClearResBtn;
        FrameLayout frameLayout = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlphaVideoClearResBtn");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.ad.debug.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlphaVideoAdDebugFragment.uh(view);
            }
        });
        TextView textView2 = this.mAlphaVideoShowBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlphaVideoShowBtn");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.ad.debug.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlphaVideoAdDebugFragment.vh(AlphaVideoAdDebugFragment.this, view);
            }
        });
        FrameLayout frameLayout2 = this.mAlphaVideoContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlphaVideoContainer");
        } else {
            frameLayout = frameLayout2;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.ad.debug.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlphaVideoAdDebugFragment.wh(AlphaVideoAdDebugFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.mobileqq.ad.alphavideo.b.f186687a.d();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(AlphaVideoAdDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QUISingleLineInputView qUISingleLineInputView = this$0.mAlphaVideoUrlInput;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlphaVideoUrlInput");
            qUISingleLineInputView = null;
        }
        String valueOf = String.valueOf(qUISingleLineInputView.d());
        if (!TextUtils.isEmpty(valueOf)) {
            this$0.xh(valueOf);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(AlphaVideoAdDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MaskAdAlphaVideoView maskAdAlphaVideoView = this$0.mAlphaVideoView;
        if (maskAdAlphaVideoView != null) {
            maskAdAlphaVideoView.l();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void xh(String url) {
        MaskAdAlphaVideoView maskAdAlphaVideoView = this.mAlphaVideoView;
        if (maskAdAlphaVideoView != null) {
            maskAdAlphaVideoView.l();
        }
        init();
        MaskAdAlphaVideoView maskAdAlphaVideoView2 = this.mAlphaVideoView;
        if (maskAdAlphaVideoView2 != null) {
            maskAdAlphaVideoView2.setResUrl(url);
        }
        MaskAdAlphaVideoView maskAdAlphaVideoView3 = this.mAlphaVideoView;
        if (maskAdAlphaVideoView3 != null) {
            maskAdAlphaVideoView3.e(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.gvx;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        MaskAdAlphaVideoView maskAdAlphaVideoView = this.mAlphaVideoView;
        if (maskAdAlphaVideoView != null) {
            maskAdAlphaVideoView.l();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle("\u900f\u660e\u89c6\u9891\u5e7f\u544a\u6d4b\u8bd5");
        initViews(view);
        th();
        sh();
    }
}

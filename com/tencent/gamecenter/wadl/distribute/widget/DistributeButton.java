package com.tencent.gamecenter.wadl.distribute.widget;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.distribute.contorller.DistributeButtonController;
import com.tencent.gamecenter.wadl.distribute.data.ButtonDataBuilder;
import com.tencent.gamecenter.wadl.distribute.data.ButtonStatus;
import com.tencent.gamecenter.wadl.distribute.data.ButtonUiBuilder;
import com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener;
import com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher;
import com.tencent.gamecenter.wadl.distribute.widget.DistributeButton;
import com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001U\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0001aB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\bY\u0010ZB\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\\\u001a\u0004\u0018\u00010[\u00a2\u0006\u0004\bY\u0010]B#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\\\u001a\u0004\u0018\u00010[\u0012\u0006\u0010^\u001a\u00020%\u00a2\u0006\u0004\bY\u0010_J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\u001a\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u001a\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u0017H\u0002J\u001a\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\u0018\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0016J\b\u0010)\u001a\u00020\u0011H\u0016J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*H\u0016J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*H\u0016J\b\u0010.\u001a\u00020\u0005H\u0016J\b\u00100\u001a\u00020/H\u0016J\b\u00102\u001a\u000201H\u0016J\b\u00103\u001a\u00020\bH\u0016J\b\u00104\u001a\u00020\bH\u0016J\b\u00105\u001a\u00020\u0005H\u0014J\b\u00106\u001a\u00020\u0005H\u0014R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010<R\u0016\u0010@\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010?R\u0016\u0010C\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010K\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010R\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010QR\u0014\u0010X\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010W\u00a8\u0006b"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/widget/DistributeButton;", "Landroid/widget/FrameLayout;", "Lcom/tencent/gamecenter/wadl/distribute/widget/IDistributeButton;", "Landroid/content/Context;", "context", "", "g", "f", "", "e", "Landroid/view/View;", "it", "i", "Ljava/lang/Runnable;", "runnable", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/gamecenter/wadl/distribute/data/ButtonStatus;", "status", ReportConstant.COSTREPORT_PREFIX, "p", "o", "enable", "", "tips", "k", "", "progress", "progressTips", "l", DomainData.DOMAIN_NAME, "Lcom/tencent/gamecenter/wadl/distribute/data/ButtonDataBuilder;", "builder", "setDataBuilder", "Lcom/tencent/gamecenter/wadl/distribute/data/ButtonUiBuilder;", "setUiBuilder", "update", "", "followStatus", "subscribeStatus", "updateWithInitStatus", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "Lcom/tencent/gamecenter/wadl/distribute/listener/IButtonEventListener;", "listener", "addEventListener", "removeEventListener", "removeEventListeners", "Landroid/view/ViewGroup;", "getBgView", "Landroid/widget/TextView;", "getTipsView", "isKuiklyWidget", "isKuiklyViewDetach", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/gamecenter/wadl/distribute/contorller/DistributeButtonController;", "d", "Lcom/tencent/gamecenter/wadl/distribute/contorller/DistributeButtonController;", "controller", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "rlBg", "Landroid/widget/ProgressBar;", "Landroid/widget/ProgressBar;", "vProgress", h.F, "Landroid/widget/TextView;", "tvTips", "Lcom/tencent/gamecenter/wadl/distribute/data/ButtonUiBuilder;", "uiBuilder", "Landroid/graphics/drawable/Drawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/drawable/Drawable;", "curFgDrawable", BdhLogUtil.LogTag.Tag_Conn, "curBgDrawable", "", "D", "J", "lastClickTime", "E", "Z", "isDetached", UserInfo.SEX_FEMALE, "isBtnAutoClicked", "com/tencent/gamecenter/wadl/distribute/widget/DistributeButton$b", "G", "Lcom/tencent/gamecenter/wadl/distribute/widget/DistributeButton$b;", "eventListener", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "H", "a", "qqgamedownloader-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class DistributeButton extends FrameLayout implements IDistributeButton {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Drawable curBgDrawable;

    /* renamed from: D, reason: from kotlin metadata */
    private long lastClickTime;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isDetached;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isBtnAutoClicked;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final b eventListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DistributeButtonController controller;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout rlBg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ProgressBar vProgress;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView tvTips;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ButtonUiBuilder uiBuilder;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable curFgDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/gamecenter/wadl/distribute/widget/DistributeButton$b", "Lcom/tencent/gamecenter/wadl/distribute/listener/IButtonEventListener;", "Landroid/view/View;", "view", "", NodeProps.ON_CLICK, "", "appId", "", "followStatus", "subscribeStatus", "onFollowOrSubscribeStatusChange", "", "progress", "taskStatus", "onDownloadTaskStatusChange", "qqgamedownloader-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements IButtonEventListener {
        b() {
        }

        @Override // com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener
        public void onClick(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ButtonStatus buttonStatus = DistributeButton.this.getButtonStatus();
            QLog.i("wadl_distribute_DistributeButton", 1, "[onClick] status:" + buttonStatus);
            if (buttonStatus.getFollowStatus() > 0) {
                if (buttonStatus.getFollowStatus() == 1) {
                    DistributeButton.this.controller.S0("1");
                    return;
                }
                return;
            }
            int subscribeStatus = buttonStatus.getSubscribeStatus();
            if (subscribeStatus != 1) {
                if (subscribeStatus == 3) {
                    DistributeButton.this.controller.n0(buttonStatus.getDownloadTaskStatus());
                    return;
                }
                return;
            }
            DistributeButton.this.controller.S0("0");
        }

        @Override // com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener
        public void onDownloadTaskStatusChange(@NotNull String appId, float progress, int taskStatus) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            if (DistributeButton.this.controller.e0(appId)) {
                DistributeButton.this.q();
            }
        }

        @Override // com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener
        public void onFollowOrSubscribeStatusChange(@NotNull String appId, int followStatus, int subscribeStatus) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            if (!DistributeButton.this.controller.e0(appId)) {
                return;
            }
            if (subscribeStatus == 3) {
                WadlProxyServiceUtil.getProxyService().doQueryAllTask();
            }
            DistributeButton.this.q();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/gamecenter/wadl/distribute/widget/DistributeButton$c", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qqgamedownloader-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ButtonUiBuilder f106917a;

        c(ButtonUiBuilder buttonUiBuilder) {
            this.f106917a = buttonUiBuilder;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f106917a.getBgCorner());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DistributeButton(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean e() {
        if (this.uiBuilder != null) {
            return true;
        }
        QLog.e("wadl_distribute_DistributeButton", 1, "uiBuilder has not set before update");
        return false;
    }

    private final void f() {
        addEventListener(this.eventListener);
    }

    private final void g(Context context) {
        View.inflate(context, R.layout.f167986eb3, this);
        View findViewById = findViewById(R.id.ibr);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.rl_bg)");
        this.rlBg = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R.id.g1f);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(com.tencent\u2026ileqq.qqui.R.id.progress)");
        this.vProgress = (ProgressBar) findViewById2;
        View findViewById3 = findViewById(R.id.kbr);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(com.tencent\u2026bileqq.qqui.R.id.tv_tips)");
        this.tvTips = (TextView) findViewById3;
        setOnClickListener(new View.OnClickListener() { // from class: pl0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DistributeButton.h(DistributeButton.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(DistributeButton this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Math.abs(System.currentTimeMillis() - this$0.lastClickTime) >= 300) {
            this$0.lastClickTime = System.currentTimeMillis();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.i(it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void i(View it) {
        this.controller.k0(it);
    }

    private final void j(Runnable runnable) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        }
    }

    private final void k(boolean enable, String tips) {
        ProgressBar progressBar = this.vProgress;
        ButtonUiBuilder buttonUiBuilder = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vProgress");
            progressBar = null;
        }
        progressBar.setVisibility(4);
        RelativeLayout relativeLayout = this.rlBg;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rlBg");
            relativeLayout = null;
        }
        ButtonUiBuilder buttonUiBuilder2 = this.uiBuilder;
        if (buttonUiBuilder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiBuilder");
        } else {
            buttonUiBuilder = buttonUiBuilder2;
        }
        relativeLayout.setBackgroundDrawable(buttonUiBuilder.getBgDrawable(enable));
        n(enable, tips);
    }

    private final void l(float progress, String progressTips) {
        ProgressBar progressBar = this.vProgress;
        ButtonUiBuilder buttonUiBuilder = null;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vProgress");
            progressBar = null;
        }
        boolean z16 = false;
        progressBar.setVisibility(0);
        if (this.curFgDrawable == null) {
            ButtonUiBuilder buttonUiBuilder2 = this.uiBuilder;
            if (buttonUiBuilder2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiBuilder");
                buttonUiBuilder2 = null;
            }
            this.curFgDrawable = buttonUiBuilder2.getProgressFgDrawable();
        }
        progressBar.setProgressDrawable(this.curFgDrawable);
        progressBar.setProgress((int) progress);
        if (this.curBgDrawable == null) {
            ButtonUiBuilder buttonUiBuilder3 = this.uiBuilder;
            if (buttonUiBuilder3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiBuilder");
                buttonUiBuilder3 = null;
            }
            this.curBgDrawable = buttonUiBuilder3.getProgressBgDrawable();
        }
        RelativeLayout relativeLayout = this.rlBg;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rlBg");
            relativeLayout = null;
        }
        relativeLayout.setBackgroundDrawable(this.curBgDrawable);
        ButtonUiBuilder buttonUiBuilder4 = this.uiBuilder;
        if (buttonUiBuilder4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiBuilder");
        } else {
            buttonUiBuilder = buttonUiBuilder4;
        }
        ITextContentFetcher textContentFetcher = buttonUiBuilder.getTextContentFetcher();
        if (progressTips.length() == 0) {
            z16 = true;
        }
        if (z16) {
            progressTips = StringsKt__StringsJVMKt.replace$default(textContentFetcher.fetchProgressContentWithPlaceHolder(), "$PRO", String.valueOf(progress), false, 4, (Object) null);
        }
        n(true, progressTips);
    }

    static /* synthetic */ void m(DistributeButton distributeButton, float f16, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        distributeButton.l(f16, str);
    }

    private final void n(boolean enable, String tips) {
        TextView textView = this.tvTips;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTips");
            textView = null;
        }
        ButtonUiBuilder buttonUiBuilder = this.uiBuilder;
        if (buttonUiBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiBuilder");
            buttonUiBuilder = null;
        }
        textView.setTextColor(buttonUiBuilder.getTextColor(enable));
        ButtonUiBuilder buttonUiBuilder2 = this.uiBuilder;
        if (buttonUiBuilder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiBuilder");
            buttonUiBuilder2 = null;
        }
        textView.setTextSize(0, buttonUiBuilder2.getTextSize());
        textView.setText(tips);
        if (enable) {
            ButtonUiBuilder buttonUiBuilder3 = this.uiBuilder;
            if (buttonUiBuilder3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uiBuilder");
                buttonUiBuilder3 = null;
            }
            if (buttonUiBuilder3.getAutoClickBtn() && !this.isBtnAutoClicked) {
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105565", false);
                QLog.i("wadl_distribute_DistributeButton", 1, "setTips autoClickSwitchOn:" + isSwitchOn);
                if (isSwitchOn) {
                    this.isBtnAutoClicked = true;
                    TextView textView3 = this.tvTips;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvTips");
                    } else {
                        textView2 = textView3;
                    }
                    i(textView2);
                }
            }
        }
    }

    private final void o() {
        ButtonUiBuilder buttonUiBuilder = this.uiBuilder;
        ButtonUiBuilder buttonUiBuilder2 = null;
        if (buttonUiBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiBuilder");
            buttonUiBuilder = null;
        }
        ITextContentFetcher textContentFetcher = buttonUiBuilder.getTextContentFetcher();
        int downloadTaskStatus = getButtonStatus().getDownloadTaskStatus();
        if (downloadTaskStatus != 0) {
            if (downloadTaskStatus != 2) {
                if (downloadTaskStatus != 9) {
                    if (downloadTaskStatus != 12) {
                        if (downloadTaskStatus != 100) {
                            if (downloadTaskStatus != 4) {
                                if (downloadTaskStatus != 5) {
                                    if (downloadTaskStatus != 6) {
                                        if (downloadTaskStatus != 7) {
                                            return;
                                        }
                                    } else {
                                        k(true, textContentFetcher.fetchDownloadedContent());
                                        return;
                                    }
                                } else {
                                    ButtonUiBuilder buttonUiBuilder3 = this.uiBuilder;
                                    if (buttonUiBuilder3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("uiBuilder");
                                    } else {
                                        buttonUiBuilder2 = buttonUiBuilder3;
                                    }
                                    if (buttonUiBuilder2.getIsShowProgressWhenPaused()) {
                                        l(this.controller.getProgress(), textContentFetcher.fetchPausedContent());
                                        return;
                                    } else {
                                        k(true, textContentFetcher.fetchPausedContent());
                                        return;
                                    }
                                }
                            }
                        } else {
                            k(true, textContentFetcher.fetchUpdateContent());
                            return;
                        }
                    }
                } else {
                    k(true, textContentFetcher.fetchInstalledContent());
                    return;
                }
            }
            m(this, this.controller.getProgress(), null, 2, null);
            return;
        }
        k(true, textContentFetcher.fetchCanDownloadContent());
    }

    private final void p(ButtonStatus status) {
        ButtonUiBuilder buttonUiBuilder = this.uiBuilder;
        if (buttonUiBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiBuilder");
            buttonUiBuilder = null;
        }
        ITextContentFetcher textContentFetcher = buttonUiBuilder.getTextContentFetcher();
        int followStatus = status.getFollowStatus();
        if (followStatus != 1) {
            if (followStatus == 2) {
                k(false, textContentFetcher.fetchFollowedContent());
                return;
            }
            return;
        }
        k(true, textContentFetcher.fetchWaitFollowContent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        j(new Runnable() { // from class: pl0.b
            @Override // java.lang.Runnable
            public final void run() {
                DistributeButton.r(DistributeButton.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(DistributeButton this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ButtonStatus buttonStatus = this$0.getButtonStatus();
        if (buttonStatus.getFollowStatus() > 0) {
            this$0.p(buttonStatus);
        } else {
            this$0.s(buttonStatus);
        }
    }

    private final void s(ButtonStatus status) {
        ButtonUiBuilder buttonUiBuilder = this.uiBuilder;
        if (buttonUiBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiBuilder");
            buttonUiBuilder = null;
        }
        ITextContentFetcher textContentFetcher = buttonUiBuilder.getTextContentFetcher();
        int subscribeStatus = status.getSubscribeStatus();
        if (subscribeStatus != 0) {
            if (subscribeStatus != 1) {
                if (subscribeStatus != 2) {
                    if (subscribeStatus != 3) {
                        if (subscribeStatus != 1995001) {
                            return;
                        }
                    } else {
                        o();
                        return;
                    }
                }
                k(false, textContentFetcher.fetchSubscribedContent());
                return;
            }
            k(true, textContentFetcher.fetchWaitSubscribeContent());
            return;
        }
        k(false, textContentFetcher.fetchInitContent());
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void addEventListener(@NotNull IButtonEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.controller.v(listener);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    @NotNull
    public ViewGroup getBgView() {
        RelativeLayout relativeLayout = this.rlBg;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rlBg");
            return null;
        }
        return relativeLayout;
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    @NotNull
    /* renamed from: getStatus */
    public ButtonStatus getButtonStatus() {
        return this.controller.getButtonStatus();
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    @NotNull
    public TextView getTipsView() {
        TextView textView = this.tvTips;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTips");
            return null;
        }
        return textView;
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public boolean isKuiklyViewDetach() {
        return false;
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public boolean isKuiklyWidget() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QLog.i("wadl_distribute_DistributeButton", 2, "[onAttachedToWindow]");
        if (this.isDetached) {
            this.isDetached = false;
            this.controller.l0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.i("wadl_distribute_DistributeButton", 2, "[onDetachedFromWindow]");
        this.controller.m0();
        this.curFgDrawable = null;
        this.curBgDrawable = null;
        this.isDetached = true;
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void onKuiklyDownloadTaskStatusChange(@NotNull String str, float f16, int i3) {
        IDistributeButton.a.a(this, str, f16, i3);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void onKuiklyFollowOrSubscribeStatusChange(@NotNull String str, int i3, int i16) {
        IDistributeButton.a.b(this, str, i3, i16);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void onKuiklyWidgetClick(@NotNull View view) {
        IDistributeButton.a.c(this, view);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void removeEventListener(@NotNull IButtonEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.controller.w0(listener);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void removeEventListeners() {
        this.controller.x0();
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void removeKuiklyView() {
        IDistributeButton.a.d(this);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void setDataBuilder(@NotNull ButtonDataBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.controller.M0(builder);
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void setUiBuilder(@NotNull ButtonUiBuilder builder) {
        ButtonUiBuilder buttonUiBuilder;
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.uiBuilder = builder;
        if (builder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("uiBuilder");
            buttonUiBuilder = null;
        } else {
            buttonUiBuilder = builder;
        }
        if (buttonUiBuilder.getIsWholeClipRound()) {
            setOutlineProvider(new c(builder));
            setClipToOutline(true);
        }
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void update() {
        if (!e()) {
            return;
        }
        f();
        this.controller.U0();
    }

    @Override // com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton
    public void updateWithInitStatus(int followStatus, int subscribeStatus) {
        if (!e()) {
            return;
        }
        f();
        this.controller.Y0(followStatus, subscribeStatus);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DistributeButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistributeButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.controller = new DistributeButtonController(context2);
        this.eventListener = new b();
        g(context);
    }
}

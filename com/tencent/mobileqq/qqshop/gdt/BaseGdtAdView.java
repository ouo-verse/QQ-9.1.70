package com.tencent.mobileqq.qqshop.gdt;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0002@AB1\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010;\u001a\u00020\u000b\u0012\b\b\u0002\u0010<\u001a\u00020\u000b\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0006\u0010\u0007\u001a\u00020\u0005J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0006\u0010\t\u001a\u00020\u0005J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\f\u001a\u00020\u000bH%J\b\u0010\r\u001a\u00020\u000bH%J\b\u0010\u000e\u001a\u00020\u000bH%J\b\u0010\u000f\u001a\u00020\u000bH%J\b\u0010\u0010\u001a\u00020\u000bH%J\b\u0010\u0011\u001a\u00020\u000bH%R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R$\u0010/\u001a\u0004\u0018\u00010(8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/qqshop/gdt/BaseGdtAdView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "onResume", "K0", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "J0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "E0", "F0", "H0", "G0", "C0", "D0", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "mediaImage", "Landroid/widget/RelativeLayout;", "e", "Landroid/widget/RelativeLayout;", "mediaContainer", "Landroid/view/View;", "f", "Landroid/view/View;", "negativeFeedback", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "description", "i", "jumpBtn", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "negativeFeedbackListener", "Lcom/tencent/mobileqq/qqshop/gdt/QQShopAdVideoView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqshop/gdt/QQShopAdVideoView;", "getGdtVideoWrapper", "()Lcom/tencent/mobileqq/qqshop/gdt/QQShopAdVideoView;", "setGdtVideoWrapper", "(Lcom/tencent/mobileqq/qqshop/gdt/QQShopAdVideoView;)V", "gdtVideoWrapper", "Lcom/tencent/mobileqq/qqshop/gdt/BaseGdtAdView$b;", "dismissCallback", "Lcom/tencent/mobileqq/qqshop/gdt/BaseGdtAdView$b;", "getDismissCallback", "()Lcom/tencent/mobileqq/qqshop/gdt/BaseGdtAdView$b;", "setDismissCallback", "(Lcom/tencent/mobileqq/qqshop/gdt/BaseGdtAdView$b;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "D", "a", "b", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public abstract class BaseGdtAdView extends ConstraintLayout implements LifecycleObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QQShopAdVideoView gdtVideoWrapper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView mediaImage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RelativeLayout mediaContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View negativeFeedback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView description;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView jumpBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AdFeedbackDialogFragment.Listener negativeFeedbackListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqshop/gdt/BaseGdtAdView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.gdt.BaseGdtAdView$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/qqshop/gdt/BaseGdtAdView$b;", "", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29480);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseGdtAdView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            return;
        }
        iPatchRedirector.redirect((short) 21, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(BaseGdtAdView this$0) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this$0);
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.addObserver(this$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(BaseGdtAdView this$0, AdFeedbackDialogFragment.Result result) {
        Integer num;
        QQShopAdVideoView qQShopAdVideoView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = false;
        if (result != null && result.action == 3) {
            z16 = true;
        }
        if (z16 && (qQShopAdVideoView = this$0.gdtVideoWrapper) != null) {
            qQShopAdVideoView.onDestroy();
        }
        if (result != null) {
            num = Integer.valueOf(result.action);
        } else {
            num = null;
        }
        QLog.d("BaseGdtAdView", 1, "negative button open result: " + num + " ");
    }

    @IdRes
    protected abstract int C0();

    @IdRes
    protected abstract int D0();

    @LayoutRes
    protected abstract int E0();

    @IdRes
    protected abstract int F0();

    @IdRes
    protected abstract int G0();

    @IdRes
    protected abstract int H0();

    public final void J0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        }
    }

    public final void K0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy(@NotNull LifecycleOwner owner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) owner);
            return;
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        QLog.d("BaseGdtAdView", 1, "onDestroy: ");
        QQShopAdVideoView qQShopAdVideoView = this.gdtVideoWrapper;
        if (qQShopAdVideoView != null) {
            qQShopAdVideoView.onDestroy();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause(@NotNull LifecycleOwner owner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) owner);
            return;
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        QLog.d("BaseGdtAdView", 1, "onPause: ");
        J0();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume(@NotNull LifecycleOwner owner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) owner);
            return;
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        QLog.d("BaseGdtAdView", 1, "onResume: ");
        K0();
    }

    public final void setDismissCallback(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseGdtAdView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            return;
        }
        iPatchRedirector.redirect((short) 20, (Object) this, (Object) context, (Object) attributeSet);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseGdtAdView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            return;
        }
        iPatchRedirector.redirect((short) 19, this, context, attributeSet, Integer.valueOf(i3));
    }

    public /* synthetic */ BaseGdtAdView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseGdtAdView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.negativeFeedbackListener = new AdFeedbackDialogFragment.Listener() { // from class: com.tencent.mobileqq.qqshop.gdt.a
            @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
            public final void onResult(AdFeedbackDialogFragment.Result result) {
                BaseGdtAdView.I0(BaseGdtAdView.this, result);
            }
        };
        View.inflate(context, E0(), this);
        View findViewById = findViewById(F0());
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(getMediaImageId())");
        this.mediaImage = (ImageView) findViewById;
        View findViewById2 = findViewById(H0());
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(getVideoContainerId())");
        this.mediaContainer = (RelativeLayout) findViewById2;
        View findViewById3 = findViewById(G0());
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(getNegativeFeedbackId())");
        this.negativeFeedback = findViewById3;
        View findViewById4 = findViewById(C0());
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(getDescriptionId())");
        TextView textView = (TextView) findViewById4;
        this.description = textView;
        View findViewById5 = findViewById(D0());
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(getJumpBtnId())");
        TextView textView2 = (TextView) findViewById5;
        this.jumpBtn = textView2;
        if (QQTheme.isNowThemeIsNight()) {
            textView2.setTextColor(-1);
            textView.setTextColor(-1);
            setBackgroundResource(R.color.black);
        }
        post(new Runnable() { // from class: com.tencent.mobileqq.qqshop.gdt.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseGdtAdView.B0(BaseGdtAdView.this);
            }
        });
    }
}

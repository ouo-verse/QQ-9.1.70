package com.tencent.mobileqq.qqlive.sail.ui.more.bottom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.mobileqq.vas.ui.IDynamicDrawable;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wi2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u001d\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\b\u0010\u000e\u001a\u00020\u0004H\u0014R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/bottom/ButtonLoadingView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "apngUrl", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/graphics/drawable/Drawable;", "o", "", "autoStop", "setAutoStop", "r", "stop", NodeProps.ON_DETACHED_FROM_WINDOW, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/drawable/Drawable;", "iconDrawable", BdhLogUtil.LogTag.Tag_Conn, "Z", "Ljava/lang/Runnable;", "D", "Ljava/lang/Runnable;", "autoStopRunnable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "E", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ButtonLoadingView extends AppCompatImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean autoStop;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Runnable autoStopRunnable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable iconDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/bottom/ButtonLoadingView$a;", "", "", "APNG_MARGIN", "I", "", "APNG_URL", "Ljava/lang/String;", "", "MAX_SHOW_DURATION_MS", "J", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.more.bottom.ButtonLoadingView$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52623);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ButtonLoadingView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ButtonLoadingView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q();
    }

    private final Drawable o(String apngUrl) {
        AegisLogger.INSTANCE.i("Bottom_Bar|ButtonLoadingView", "getOperateDrawable", "apngUrl=" + apngUrl);
        final APNGDrawable aPNGDrawable = new APNGDrawable("ButtonLoadingView", apngUrl);
        aPNGDrawable.setLoadedListener(new Function1<IDynamicDrawable, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.bottom.ButtonLoadingView$getOperateDrawable$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) APNGDrawable.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IDynamicDrawable iDynamicDrawable) {
                invoke2(iDynamicDrawable);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull IDynamicDrawable it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                Drawable currentDrawable = APNGDrawable.this.getCurrentDrawable();
                URLDrawable uRLDrawable = currentDrawable instanceof URLDrawable ? (URLDrawable) currentDrawable : null;
                Drawable currDrawable = uRLDrawable != null ? uRLDrawable.getCurrDrawable() : null;
                ApngDrawable apngDrawable = currDrawable instanceof ApngDrawable ? (ApngDrawable) currDrawable : null;
                ApngImage image = apngDrawable != null ? apngDrawable.getImage() : null;
                if (image == null) {
                    return;
                }
                image.apngLoop = 0;
            }
        });
        return aPNGDrawable;
    }

    private final void p(String apngUrl) {
        this.iconDrawable = o(apngUrl);
        wi2.b.c(this, c.b(0));
    }

    private final void q() {
        APNGDrawable aPNGDrawable;
        Drawable drawable = this.iconDrawable;
        if (drawable instanceof APNGDrawable) {
            aPNGDrawable = (APNGDrawable) drawable;
        } else {
            aPNGDrawable = null;
        }
        if (aPNGDrawable != null) {
            aPNGDrawable.pauseApng();
        }
        setVisibility(8);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onDetachedFromWindow();
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.autoStopRunnable);
        }
    }

    public final void r() {
        APNGDrawable aPNGDrawable;
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (getDrawable() == null && (drawable = this.iconDrawable) != null) {
            setImageDrawable(drawable);
        }
        Drawable drawable2 = this.iconDrawable;
        if (drawable2 instanceof APNGDrawable) {
            aPNGDrawable = (APNGDrawable) drawable2;
        } else {
            aPNGDrawable = null;
        }
        if (aPNGDrawable != null) {
            aPNGDrawable.resumeApng();
        }
        setVisibility(0);
        if (this.autoStop) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.autoStopRunnable, 5000L);
        }
    }

    public final void setAutoStop(boolean autoStop) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, autoStop);
        } else {
            this.autoStop = autoStop;
        }
    }

    public final void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.autoStopRunnable);
            q();
        }
    }

    public /* synthetic */ ButtonLoadingView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ButtonLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        setVisibility(8);
        setBackgroundResource(R.drawable.l1y);
        p("https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/xiaohonghua/qvideo_xiaohonghua_loading_icon.png");
        this.autoStopRunnable = new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.bottom.b
            @Override // java.lang.Runnable
            public final void run() {
                ButtonLoadingView.m(ButtonLoadingView.this);
            }
        };
    }
}

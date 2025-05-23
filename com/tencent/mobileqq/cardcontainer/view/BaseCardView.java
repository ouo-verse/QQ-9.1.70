package com.tencent.mobileqq.cardcontainer.view;

import android.content.Context;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.cardcontainer.d;
import com.tencent.mobileqq.cardcontainer.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b&\u0018\u0000 \b2\u00020\u00012\u00020\u0002:\u0001#B\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R$\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/view/BaseCardView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/cardcontainer/d;", "", "c", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "data", "Landroid/view/View;", "f", "i", "Landroid/widget/ImageView;", "close", "j", "Lcom/tencent/mobileqq/cardcontainer/e;", "host", "d", "getView", "", ZPlanPublishSource.FROM_SCHEME, h.F, "Lcom/tencent/mobileqq/cardcontainer/e;", "g", "()Lcom/tencent/mobileqq/cardcontainer/e;", "setCardViewHost", "(Lcom/tencent/mobileqq/cardcontainer/e;)V", "cardViewHost", "e", "Landroid/view/View;", "content", "Landroid/content/Context;", "context", "", "radius", "<init>", "(Landroid/content/Context;F)V", "b", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class BaseCardView extends FrameLayout implements d {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e cardViewHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View content;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/cardcontainer/view/BaseCardView$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a extends ViewOutlineProvider {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f201213a;

        a(float f16) {
            this.f201213a = f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Float.valueOf(f16));
            }
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) outline);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f201213a);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/view/BaseCardView$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cardcontainer_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.view.BaseCardView$b, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41674);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseCardView(@NotNull Context context, float f16) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Float.valueOf(f16));
            return;
        }
        setOutlineProvider(new a(f16));
        setClipToOutline(true);
        setLayoutParams(new ViewGroup.LayoutParams(ViewUtils.dpToPx(98.0f), -1));
        setBackground(context.getDrawable(R.drawable.jcb));
        c();
    }

    private final void c() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.jca);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewUtils.dpToPx(28.0f), ViewUtils.dpToPx(32.0f));
        layoutParams.gravity = 8388661;
        imageView.setLayoutParams(layoutParams);
        imageView.setPadding(ViewUtils.dpToPx(10.0f), ViewUtils.dpToPx(8.0f), ViewUtils.dpToPx(6.0f), ViewUtils.dpToPx(12.0f));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.cardcontainer.view.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseCardView.e(BaseCardView.this, view);
            }
        });
        AccessibilityUtil.s(imageView, "\u4e0d\u559c\u6b22");
        addView(imageView);
        j(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(BaseCardView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.cardcontainer.d
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            d.a.a(this);
        }
    }

    @Override // com.tencent.mobileqq.cardcontainer.d
    public void d(@NotNull com.tencent.mobileqq.cardcontainer.data.a data, @NotNull e host) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) data, (Object) host);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(host, "host");
        this.cardViewHost = host;
        View view = this.content;
        if (view != null) {
            removeView(view);
        }
        View f16 = f(data);
        this.content = f16;
        addView(f16, 0);
    }

    @NotNull
    public abstract View f(@NotNull com.tencent.mobileqq.cardcontainer.data.a data);

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final e g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.cardViewHost;
    }

    @Override // com.tencent.mobileqq.cardcontainer.d
    @NotNull
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this;
    }

    public void h(@Nullable String scheme) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) scheme);
            return;
        }
        if (scheme != null && scheme.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.d("BaseCardView", 1, "jumpToScheme exception:" + scheme);
            return;
        }
        e eVar = this.cardViewHost;
        if (eVar != null) {
            eVar.aa(scheme);
        }
    }

    public abstract void i();

    public void j(@NotNull ImageView close) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) close);
        } else {
            Intrinsics.checkNotNullParameter(close, "close");
        }
    }

    public /* synthetic */ BaseCardView(Context context, float f16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? ViewUtils.dpToPx(6.0f) : f16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, Float.valueOf(f16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}

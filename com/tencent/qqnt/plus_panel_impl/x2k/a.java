package com.tencent.qqnt.plus_panel_impl.x2k;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR$\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0006\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0010\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/plus_panel_impl/x2k/a;", "", "Landroid/content/Context;", "context", "Landroid/widget/FrameLayout;", "b", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/view/View;", "Landroid/view/View;", "()Landroid/view/View;", "d", "(Landroid/view/View;)V", "root", "c", "Landroid/widget/FrameLayout;", "getExtendPanel", "()Landroid/widget/FrameLayout;", "(Landroid/widget/FrameLayout;)V", "extendPanel", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public FrameLayout extendPanel;

    public a(@NotNull Context context, @Nullable Integer num) {
        FrameLayout b16;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) num);
            return;
        }
        this.context = context;
        if (num != null) {
            b16 = b(new ContextThemeWrapper(context, num.intValue()));
        } else {
            b16 = b(context);
        }
        d(b16);
    }

    @Nullable
    public View a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.root;
    }

    @NotNull
    public final FrameLayout b(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        int l3 = com.tencent.aio.view_dsl.dsl.b.l();
        if (frameLayout.getLayoutParams() == null) {
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(l3, 0));
        } else {
            frameLayout.getLayoutParams().width = l3;
        }
        int l16 = com.tencent.aio.view_dsl.dsl.b.l();
        if (frameLayout.getLayoutParams() == null) {
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(0, l16));
        } else {
            frameLayout.getLayoutParams().height = l16;
        }
        frameLayout.setId(R.id.uyp);
        c(frameLayout);
        return frameLayout;
    }

    public final void c(@NotNull FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) frameLayout);
        } else {
            Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
            this.extendPanel = frameLayout;
        }
    }

    public void d(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            this.root = view;
        }
    }

    public /* synthetic */ a(Context context, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, Integer.valueOf(i3), defaultConstructorMarker);
    }
}

package com.tencent.qqnt.plus_panel_impl.x2k;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.aio.view_dsl.dsl.f;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR$\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0006\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u0011\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/plus_panel_impl/x2k/b;", "", "Landroid/content/Context;", "context", "Landroid/widget/FrameLayout;", "b", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/view/View;", "Landroid/view/View;", "()Landroid/view/View;", "e", "(Landroid/view/View;)V", "root", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "getPlusPanelRv", "()Landroidx/recyclerview/widget/RecyclerView;", "d", "(Landroidx/recyclerview/widget/RecyclerView;)V", "plusPanelRv", "Landroid/widget/FrameLayout;", "getPanelPagerContainer", "()Landroid/widget/FrameLayout;", "(Landroid/widget/FrameLayout;)V", "panelPagerContainer", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public RecyclerView plusPanelRv;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public FrameLayout panelPagerContainer;

    public b(@NotNull Context context, @Nullable Integer num) {
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
        e(b16);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context);
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
        frameLayout.setId(R.id.f223603i);
        int l16 = com.tencent.aio.view_dsl.dsl.b.l();
        if (frameLayout.getLayoutParams() == null) {
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(0, l16));
        } else {
            frameLayout.getLayoutParams().height = l16;
        }
        frameLayout.setFocusable(true);
        frameLayout.setClickable(true);
        RecyclerView recyclerView = new RecyclerView(frameLayout.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(frameLayout, new Object[0]);
        if (invoke != null) {
            recyclerView.setLayoutParams((ViewGroup.LayoutParams) invoke);
            int l17 = com.tencent.aio.view_dsl.dsl.b.l();
            if (recyclerView.getLayoutParams() == null) {
                recyclerView.setLayoutParams(new ViewGroup.LayoutParams(l17, 0));
            } else {
                recyclerView.getLayoutParams().width = l17;
            }
            recyclerView.setId(R.id.f26070cj);
            int l18 = com.tencent.aio.view_dsl.dsl.b.l();
            if (recyclerView.getLayoutParams() == null) {
                recyclerView.setLayoutParams(new ViewGroup.LayoutParams(0, l18));
            } else {
                recyclerView.getLayoutParams().height = l18;
            }
            f.p(recyclerView, com.tencent.aio.view_dsl.dsl.b.e());
            d(recyclerView);
            frameLayout.addView(recyclerView);
            c(frameLayout);
            return frameLayout;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void c(@NotNull FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) frameLayout);
        } else {
            Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
            this.panelPagerContainer = frameLayout;
        }
    }

    public final void d(@NotNull RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) recyclerView);
        } else {
            Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
            this.plusPanelRv = recyclerView;
        }
    }

    public void e(@Nullable View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            this.root = view;
        }
    }

    public /* synthetic */ b(Context context, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, Integer.valueOf(i3), defaultConstructorMarker);
    }
}

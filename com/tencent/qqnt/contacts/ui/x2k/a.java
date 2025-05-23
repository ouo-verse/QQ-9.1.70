package com.tencent.qqnt.contacts.ui.x2k;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.aio.view_dsl.dsl.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b \u0010!J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0006\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00188\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u000b\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/contacts/ui/x2k/a;", "", "Landroid/content/Context;", "context", "Landroidx/constraintlayout/widget/ConstraintLayout;", "d", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/view/View;", "b", "Landroid/view/View;", "c", "()Landroid/view/View;", "g", "(Landroid/view/View;)V", "root", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "()Landroidx/recyclerview/widget/RecyclerView;", "e", "(Landroidx/recyclerview/widget/RecyclerView;)V", "contactsList", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "()Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "f", "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;)V", "contactsSwipeRefresh", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public RecyclerView contactsList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public SwipeRefreshLayout contactsSwipeRefresh;

    public a(@NotNull Context context, @Nullable Integer num) {
        ConstraintLayout d16;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) num);
            return;
        }
        this.context = context;
        if (num != null) {
            d16 = d(new ContextThemeWrapper(context, num.intValue()));
        } else {
            d16 = d(context);
        }
        g(d16);
    }

    @NotNull
    public final RecyclerView a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RecyclerView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        RecyclerView recyclerView = this.contactsList;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contactsList");
        return null;
    }

    @NotNull
    public final SwipeRefreshLayout b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (SwipeRefreshLayout) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        SwipeRefreshLayout swipeRefreshLayout = this.contactsSwipeRefresh;
        if (swipeRefreshLayout != null) {
            return swipeRefreshLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contactsSwipeRefresh");
        return null;
    }

    @Nullable
    public View c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.root;
    }

    @NotNull
    public final ConstraintLayout d(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ConstraintLayout) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        constraintLayout.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        int l3 = b.l();
        if (constraintLayout.getLayoutParams() == null) {
            constraintLayout.setLayoutParams(new ViewGroup.LayoutParams(l3, 0));
        } else {
            constraintLayout.getLayoutParams().width = l3;
        }
        int l16 = b.l();
        if (constraintLayout.getLayoutParams() == null) {
            constraintLayout.setLayoutParams(new ViewGroup.LayoutParams(0, l16));
        } else {
            constraintLayout.getLayoutParams().height = l16;
        }
        SwipeRefreshLayout swipeRefreshLayout = new SwipeRefreshLayout(constraintLayout.getContext());
        constraintLayout.addView(swipeRefreshLayout);
        int l17 = b.l();
        if (swipeRefreshLayout.getLayoutParams() == null) {
            swipeRefreshLayout.setLayoutParams(new ViewGroup.LayoutParams(l17, 0));
        } else {
            swipeRefreshLayout.getLayoutParams().width = l17;
        }
        swipeRefreshLayout.setId(R.id.f164894u62);
        int l18 = b.l();
        if (swipeRefreshLayout.getLayoutParams() == null) {
            swipeRefreshLayout.setLayoutParams(new ViewGroup.LayoutParams(0, l18));
        } else {
            swipeRefreshLayout.getLayoutParams().height = l18;
        }
        RecyclerView recyclerView = new RecyclerView(swipeRefreshLayout.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(swipeRefreshLayout, new Object[0]);
        if (invoke != null) {
            recyclerView.setLayoutParams((ViewGroup.LayoutParams) invoke);
            int l19 = b.l();
            if (recyclerView.getLayoutParams() == null) {
                recyclerView.setLayoutParams(new ViewGroup.LayoutParams(l19, 0));
            } else {
                recyclerView.getLayoutParams().width = l19;
            }
            recyclerView.setId(R.id.b8f);
            int l26 = b.l();
            if (recyclerView.getLayoutParams() == null) {
                recyclerView.setLayoutParams(new ViewGroup.LayoutParams(0, l26));
            } else {
                recyclerView.getLayoutParams().height = l26;
            }
            int n3 = b.n();
            if (n3 != 0) {
                if (n3 != 1) {
                    recyclerView.setHorizontalScrollBarEnabled(false);
                    recyclerView.setVerticalScrollBarEnabled(false);
                } else {
                    recyclerView.setVerticalScrollBarEnabled(true);
                }
            } else {
                recyclerView.setHorizontalScrollBarEnabled(true);
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            e(recyclerView);
            swipeRefreshLayout.addView(recyclerView);
            f(swipeRefreshLayout);
            return constraintLayout;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void e(@NotNull RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) recyclerView);
        } else {
            Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
            this.contactsList = recyclerView;
        }
    }

    public final void f(@NotNull SwipeRefreshLayout swipeRefreshLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) swipeRefreshLayout);
        } else {
            Intrinsics.checkNotNullParameter(swipeRefreshLayout, "<set-?>");
            this.contactsSwipeRefresh = swipeRefreshLayout;
        }
    }

    public void g(@Nullable View view) {
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

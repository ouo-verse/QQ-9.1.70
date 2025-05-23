package com.tencent.qqnt.chathistory.x2k;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.datepicker.view.DateWeekTabView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/chathistory/x2k/m;", "Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", "e", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Landroid/view/View;", "f", "()Landroid/view/View;", tl.h.F, "(Landroid/view/View;)V", "_root", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerviewDateContainer", "()Landroidx/recyclerview/widget/RecyclerView;", "g", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerviewDateContainer", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class m implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View _root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public RecyclerView recyclerviewDateContainer;

    public m(@NotNull Context context, @Nullable Integer num) {
        LinearLayout e16;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) num);
            return;
        }
        this.context = context;
        if (num != null) {
            e16 = e(new ContextThemeWrapper(context, num.intValue()));
        } else {
            e16 = e(context);
        }
        h(e16);
    }

    @NotNull
    public final LinearLayout e(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (LinearLayout) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        int l3 = com.tencent.aio.view_dsl.dsl.b.l();
        if (linearLayout.getLayoutParams() == null) {
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(l3, 0));
        } else {
            linearLayout.getLayoutParams().width = l3;
        }
        int l16 = com.tencent.aio.view_dsl.dsl.b.l();
        if (linearLayout.getLayoutParams() == null) {
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(0, l16));
        } else {
            linearLayout.getLayoutParams().height = l16;
        }
        linearLayout.setOrientation(1);
        Context context2 = linearLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        DateWeekTabView dateWeekTabView = new DateWeekTabView(context2, null, 2, null);
        linearLayout.addView(dateWeekTabView);
        int l17 = com.tencent.aio.view_dsl.dsl.b.l();
        if (dateWeekTabView.getLayoutParams() == null) {
            dateWeekTabView.setLayoutParams(new ViewGroup.LayoutParams(l17, 0));
        } else {
            dateWeekTabView.getLayoutParams().width = l17;
        }
        int p16 = com.tencent.aio.view_dsl.dsl.b.p();
        if (dateWeekTabView.getLayoutParams() == null) {
            dateWeekTabView.setLayoutParams(new ViewGroup.LayoutParams(0, p16));
        } else {
            dateWeekTabView.getLayoutParams().height = p16;
        }
        dateWeekTabView.setPadding(dateWeekTabView.getPaddingLeft(), dateWeekTabView.getPaddingTop(), dateWeekTabView.getPaddingRight(), ((Number) com.tencent.qqnt.chathistory.util.m.c(12)).intValue());
        dateWeekTabView.setTextColor(context.getColorStateList(R.color.qui_common_text_primary).getDefaultColor());
        dateWeekTabView.setTextSize(((Number) com.tencent.qqnt.chathistory.util.m.d(16)).floatValue());
        dateWeekTabView.setPadding(dateWeekTabView.getPaddingLeft(), ((Number) com.tencent.qqnt.chathistory.util.m.c(12)).intValue(), dateWeekTabView.getPaddingRight(), dateWeekTabView.getPaddingBottom());
        View view = new View(linearLayout.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
        if (invoke != null) {
            view.setLayoutParams((ViewGroup.LayoutParams) invoke);
            int l18 = com.tencent.aio.view_dsl.dsl.b.l();
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(l18, 0));
            } else {
                view.getLayoutParams().width = l18;
            }
            int intValue = ((Number) com.tencent.qqnt.chathistory.util.m.c(Double.valueOf(0.5d))).intValue();
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(0, intValue));
            } else {
                view.getLayoutParams().height = intValue;
            }
            view.setBackground(AppCompatResources.getDrawable(view.getContext(), R.drawable.qui_common_border_light_bg));
            linearLayout.addView(view);
            RecyclerView recyclerView = new RecyclerView(linearLayout.getContext());
            Object invoke2 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
            if (invoke2 != null) {
                recyclerView.setLayoutParams((ViewGroup.LayoutParams) invoke2);
                int l19 = com.tencent.aio.view_dsl.dsl.b.l();
                if (recyclerView.getLayoutParams() == null) {
                    recyclerView.setLayoutParams(new ViewGroup.LayoutParams(l19, 0));
                } else {
                    recyclerView.getLayoutParams().width = l19;
                }
                recyclerView.setId(R.id.f71903pe);
                int l26 = com.tencent.aio.view_dsl.dsl.b.l();
                if (recyclerView.getLayoutParams() == null) {
                    recyclerView.setLayoutParams(new ViewGroup.LayoutParams(0, l26));
                } else {
                    recyclerView.getLayoutParams().height = l26;
                }
                recyclerView.setHorizontalScrollBarEnabled(false);
                recyclerView.setVerticalScrollBarEnabled(false);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setPadding(recyclerView.getPaddingLeft(), ((Number) com.tencent.qqnt.chathistory.util.m.c(16)).intValue(), recyclerView.getPaddingRight(), recyclerView.getPaddingBottom());
                recyclerView.setPadding(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getPaddingRight(), com.tencent.qqnt.chathistory.util.m.a(108));
                recyclerView.setClipToPadding(false);
                g(recyclerView);
                linearLayout.addView(recyclerView);
                return linearLayout;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @NotNull
    public final View f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        View view = this._root;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_root");
        return null;
    }

    public final void g(@NotNull RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) recyclerView);
        } else {
            Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
            this.recyclerviewDateContainer = recyclerView;
        }
    }

    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    /* renamed from: getRoot */
    public View getMContainer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return f();
    }

    public final void h(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this._root = view;
        }
    }

    public /* synthetic */ m(Context context, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, Integer.valueOf(i3), defaultConstructorMarker);
    }
}

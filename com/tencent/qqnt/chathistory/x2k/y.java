package com.tencent.qqnt.chathistory.x2k;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.viewbinding.ViewBinding;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/chathistory/x2k/y;", "Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "attach", "Landroid/widget/LinearLayout;", "e", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Landroid/view/View;", "f", "()Landroid/view/View;", tl.h.F, "(Landroid/view/View;)V", "_root", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "g", "(Landroid/widget/TextView;)V", "textView", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;Landroid/view/ViewGroup;Z)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class y implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View _root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public TextView textView;

    public y(@NotNull Context context, @Nullable Integer num, @Nullable ViewGroup viewGroup, boolean z16) {
        LinearLayout e16;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, num, viewGroup, Boolean.valueOf(z16));
            return;
        }
        this.context = context;
        if (num != null) {
            e16 = e(new ContextThemeWrapper(context, num.intValue()), viewGroup, z16);
        } else {
            e16 = e(context, viewGroup, z16);
        }
        h(e16);
    }

    @NotNull
    public final LinearLayout e(@NotNull Context context, @Nullable ViewGroup parent, boolean attach) {
        int i3;
        int i16;
        ViewGroup.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (LinearLayout) iPatchRedirector.redirect((short) 9, this, context, parent, Boolean.valueOf(attach));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        ViewGroup viewGroup = parent;
        if (parent == null) {
            viewGroup = new FrameLayout(context);
        }
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(viewGroup, new Object[0]);
        if (invoke != null) {
            linearLayout.setLayoutParams((ViewGroup.LayoutParams) invoke);
            int l3 = com.tencent.aio.view_dsl.dsl.b.l();
            if (linearLayout.getLayoutParams() == null) {
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(l3, 0));
            } else {
                linearLayout.getLayoutParams().width = l3;
            }
            int p16 = com.tencent.aio.view_dsl.dsl.b.p();
            if (linearLayout.getLayoutParams() == null) {
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(0, p16));
            } else {
                linearLayout.getLayoutParams().height = p16;
            }
            linearLayout.setGravity(com.tencent.aio.view_dsl.dsl.b.e());
            linearLayout.setOrientation(0);
            linearLayout.setMinimumHeight(((Number) com.tencent.aio.view_dsl.dsl.c.e(40)).intValue());
            TextView textView = new TextView(linearLayout.getContext());
            Object invoke2 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
            if (invoke2 != null) {
                textView.setLayoutParams((ViewGroup.LayoutParams) invoke2);
                int p17 = com.tencent.aio.view_dsl.dsl.b.p();
                if (textView.getLayoutParams() == null) {
                    textView.setLayoutParams(new ViewGroup.LayoutParams(p17, 0));
                } else {
                    textView.getLayoutParams().width = p17;
                }
                textView.setId(R.id.jjc);
                int p18 = com.tencent.aio.view_dsl.dsl.b.p();
                if (textView.getLayoutParams() == null) {
                    textView.setLayoutParams(new ViewGroup.LayoutParams(0, p18));
                } else {
                    textView.getLayoutParams().height = p18;
                }
                int intValue = ((Number) com.tencent.aio.view_dsl.dsl.c.e(4)).intValue();
                ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
                if (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams2 = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                if (marginLayoutParams != null) {
                    MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, intValue);
                    layoutParams = marginLayoutParams;
                } else {
                    ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
                    if (layoutParams3 != null) {
                        i3 = layoutParams3.width;
                    } else {
                        i3 = 0;
                    }
                    ViewGroup.LayoutParams layoutParams4 = textView.getLayoutParams();
                    if (layoutParams4 != null) {
                        i16 = layoutParams4.height;
                    } else {
                        i16 = 0;
                    }
                    Object[] objArr = {new ViewGroup.LayoutParams(i3, i16)};
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(objArr[0].getClass());
                    Object[] array = arrayList.toArray(new Class[0]);
                    if (array != null) {
                        Class[] clsArr = (Class[]) array;
                        Constructor it = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        it.setAccessible(true);
                        Object newInstance = it.newInstance(Arrays.copyOf(objArr, 1));
                        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance, intValue);
                        layoutParams = (ViewGroup.LayoutParams) newInstance;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                textView.setLayoutParams(layoutParams);
                textView.setText(R.string.zkh);
                textView.setTextSize(0, ((Number) com.tencent.aio.view_dsl.dsl.c.e(12)).floatValue());
                com.tencent.aio.view_dsl.dsl.f.p(textView, com.tencent.aio.view_dsl.dsl.b.g());
                textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.qui_common_text_secondary));
                g(textView);
                linearLayout.addView(textView);
                if (attach) {
                    viewGroup.addView(linearLayout);
                }
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

    public final void g(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.textView = textView;
        }
    }

    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    public View getRoot() {
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

    public /* synthetic */ y(Context context, Integer num, ViewGroup viewGroup, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num, (i3 & 4) == 0 ? viewGroup : null, (i3 & 8) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, viewGroup, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}

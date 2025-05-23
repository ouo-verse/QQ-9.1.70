package com.tencent.qqnt.chathistory.x2k;

import android.content.Context;
import android.graphics.Color;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/chathistory/x2k/aa;", "Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", "e", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Landroid/view/View;", "f", "()Landroid/view/View;", tl.h.F, "(Landroid/view/View;)V", "_root", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getTv", "()Landroid/widget/TextView;", "g", "(Landroid/widget/TextView;)V", "tv", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class aa implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View _root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public TextView tv;

    public aa(@NotNull Context context, @Nullable Integer num) {
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
        int i3;
        int i16;
        ViewGroup.LayoutParams layoutParams;
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
        int p16 = com.tencent.aio.view_dsl.dsl.b.p();
        if (linearLayout.getLayoutParams() == null) {
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(0, p16));
        } else {
            linearLayout.getLayoutParams().height = p16;
        }
        linearLayout.setGravity(com.tencent.aio.view_dsl.dsl.b.f());
        linearLayout.setOrientation(0);
        linearLayout.setMinimumHeight(((Number) com.tencent.qqnt.chathistory.util.m.c(54)).intValue());
        TextView textView = new TextView(linearLayout.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
        if (invoke != null) {
            textView.setLayoutParams((ViewGroup.LayoutParams) invoke);
            int p17 = com.tencent.aio.view_dsl.dsl.b.p();
            if (textView.getLayoutParams() == null) {
                textView.setLayoutParams(new ViewGroup.LayoutParams(p17, 0));
            } else {
                textView.getLayoutParams().width = p17;
            }
            int p18 = com.tencent.aio.view_dsl.dsl.b.p();
            if (textView.getLayoutParams() == null) {
                textView.setLayoutParams(new ViewGroup.LayoutParams(0, p18));
            } else {
                textView.getLayoutParams().height = p18;
            }
            textView.setText(R.string.a1i);
            textView.setTextSize(0, ((Number) com.tencent.qqnt.chathistory.util.m.c(14)).floatValue());
            com.tencent.aio.view_dsl.dsl.f.p(textView, com.tencent.aio.view_dsl.dsl.b.g());
            int intValue = ((Number) com.tencent.qqnt.chathistory.util.m.c(20)).intValue();
            ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
            if (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams2 = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = intValue;
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
                    ((ViewGroup.MarginLayoutParams) newInstance).topMargin = intValue;
                    layoutParams = (ViewGroup.LayoutParams) newInstance;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            textView.setLayoutParams(layoutParams);
            textView.setTextColor(Color.parseColor("#777777"));
            g(textView);
            linearLayout.addView(textView);
            return linearLayout;
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
            this.tv = textView;
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

    public /* synthetic */ aa(Context context, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, Integer.valueOf(i3), defaultConstructorMarker);
    }
}

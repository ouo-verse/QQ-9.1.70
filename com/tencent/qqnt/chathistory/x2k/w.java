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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/chathistory/x2k/w;", "Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "attach", "Landroid/widget/LinearLayout;", "e", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Landroid/view/View;", "f", "()Landroid/view/View;", "i", "(Landroid/view/View;)V", "_root", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", tl.h.F, "(Landroid/widget/TextView;)V", "textView", "d", "Landroid/widget/LinearLayout;", "getShortVideoItemGroup", "()Landroid/widget/LinearLayout;", "g", "(Landroid/widget/LinearLayout;)V", "shortVideoItemGroup", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;Landroid/view/ViewGroup;Z)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class w implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View _root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public TextView textView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public LinearLayout shortVideoItemGroup;

    public w(@NotNull Context context, @Nullable Integer num, @Nullable ViewGroup viewGroup, boolean z16) {
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
        i(e16);
    }

    @NotNull
    public final LinearLayout e(@NotNull Context context, @Nullable ViewGroup parent, boolean attach) {
        int i3;
        int i16;
        ViewGroup.LayoutParams layoutParams;
        int i17;
        int i18;
        ViewGroup.LayoutParams layoutParams2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (LinearLayout) iPatchRedirector.redirect((short) 11, this, context, parent, Boolean.valueOf(attach));
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
            linearLayout.setId(R.id.f84754n4);
            int p16 = com.tencent.aio.view_dsl.dsl.b.p();
            if (linearLayout.getLayoutParams() == null) {
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(0, p16));
            } else {
                linearLayout.getLayoutParams().height = p16;
            }
            linearLayout.setOrientation(0);
            linearLayout.setMinimumHeight(((Number) com.tencent.aio.view_dsl.dsl.c.e(42)).intValue());
            TextView textView = new TextView(linearLayout.getContext());
            Object invoke2 = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
            if (invoke2 != null) {
                textView.setLayoutParams((ViewGroup.LayoutParams) invoke2);
                int l16 = com.tencent.aio.view_dsl.dsl.b.l();
                if (textView.getLayoutParams() == null) {
                    textView.setLayoutParams(new ViewGroup.LayoutParams(l16, 0));
                } else {
                    textView.getLayoutParams().width = l16;
                }
                textView.setId(R.id.jjc);
                int intValue = ((Number) com.tencent.aio.view_dsl.dsl.c.e(22)).intValue();
                if (textView.getLayoutParams() == null) {
                    textView.setLayoutParams(new ViewGroup.LayoutParams(0, intValue));
                } else {
                    textView.getLayoutParams().height = intValue;
                }
                textView.setText("time");
                int intValue2 = ((Number) com.tencent.aio.view_dsl.dsl.c.e(16)).intValue();
                ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
                ViewGroup.LayoutParams layoutParams4 = null;
                if (!(layoutParams3 instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams3 = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
                if (marginLayoutParams != null) {
                    MarginLayoutParamsCompat.setMarginStart(marginLayoutParams, intValue2);
                    layoutParams = marginLayoutParams;
                } else {
                    ViewGroup.LayoutParams layoutParams5 = textView.getLayoutParams();
                    if (layoutParams5 != null) {
                        i3 = layoutParams5.width;
                    } else {
                        i3 = 0;
                    }
                    ViewGroup.LayoutParams layoutParams6 = textView.getLayoutParams();
                    if (layoutParams6 != null) {
                        i16 = layoutParams6.height;
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
                        MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) newInstance, intValue2);
                        layoutParams = (ViewGroup.LayoutParams) newInstance;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                textView.setLayoutParams(layoutParams);
                textView.setTextSize(0, ((Number) com.tencent.aio.view_dsl.dsl.c.e(14)).floatValue());
                textView.setFocusable(true);
                int intValue3 = ((Number) com.tencent.aio.view_dsl.dsl.c.e(16)).intValue();
                ViewGroup.LayoutParams layoutParams7 = textView.getLayoutParams();
                if (layoutParams7 instanceof ViewGroup.MarginLayoutParams) {
                    layoutParams4 = layoutParams7;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams4;
                if (marginLayoutParams2 != null) {
                    marginLayoutParams2.topMargin = intValue3;
                    layoutParams2 = marginLayoutParams2;
                } else {
                    ViewGroup.LayoutParams layoutParams8 = textView.getLayoutParams();
                    if (layoutParams8 != null) {
                        i17 = layoutParams8.width;
                    } else {
                        i17 = 0;
                    }
                    ViewGroup.LayoutParams layoutParams9 = textView.getLayoutParams();
                    if (layoutParams9 != null) {
                        i18 = layoutParams9.height;
                    } else {
                        i18 = 0;
                    }
                    Object[] objArr2 = {new ViewGroup.LayoutParams(i17, i18)};
                    ArrayList arrayList2 = new ArrayList(1);
                    arrayList2.add(objArr2[0].getClass());
                    Object[] array2 = arrayList2.toArray(new Class[0]);
                    if (array2 != null) {
                        Class[] clsArr2 = (Class[]) array2;
                        Constructor it5 = ViewGroup.MarginLayoutParams.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr2, clsArr2.length));
                        Intrinsics.checkNotNullExpressionValue(it5, "it");
                        it5.setAccessible(true);
                        Object newInstance2 = it5.newInstance(Arrays.copyOf(objArr2, 1));
                        ((ViewGroup.MarginLayoutParams) newInstance2).topMargin = intValue3;
                        layoutParams2 = (ViewGroup.LayoutParams) newInstance2;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                textView.setLayoutParams(layoutParams2);
                textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.qui_common_text_primary));
                h(textView);
                linearLayout.addView(textView);
                g(linearLayout);
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

    public final void g(@NotNull LinearLayout linearLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) linearLayout);
        } else {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.shortVideoItemGroup = linearLayout;
        }
    }

    @Override // androidx.viewbinding.ViewBinding
    @NotNull
    public View getRoot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return f();
    }

    public final void h(@NotNull TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) textView);
        } else {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.textView = textView;
        }
    }

    public final void i(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this._root = view;
        }
    }

    public /* synthetic */ w(Context context, Integer num, ViewGroup viewGroup, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num, (i3 & 4) == 0 ? viewGroup : null, (i3 & 8) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, viewGroup, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}

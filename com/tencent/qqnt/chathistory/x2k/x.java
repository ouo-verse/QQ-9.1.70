package com.tencent.qqnt.chathistory.x2k;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.viewbinding.ViewBinding;
import com.tencent.aio.view_dsl.dsl.LayoutBuilderKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/qqnt/chathistory/x2k/x;", "Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", "e", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Landroid/view/View;", "f", "()Landroid/view/View;", "i", "(Landroid/view/View;)V", "_root", "Landroid/widget/CheckBox;", "c", "Landroid/widget/CheckBox;", "getIvFakeIndicator", "()Landroid/widget/CheckBox;", "g", "(Landroid/widget/CheckBox;)V", "ivFakeIndicator", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", tl.h.F, "(Landroid/widget/TextView;)V", "textView", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class x implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View _root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public CheckBox ivFakeIndicator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public TextView textView;

    public x(@NotNull Context context, @Nullable Integer num) {
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
        i(e16);
    }

    @NotNull
    public final LinearLayout e(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (LinearLayout) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context);
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
        linearLayout.setBackground(AppCompatResources.getDrawable(linearLayout.getContext(), R.drawable.qui_common_fill_light_secondary_bg));
        int intValue = ((Number) com.tencent.qqnt.chathistory.util.m.c(36)).intValue();
        if (linearLayout.getLayoutParams() == null) {
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(0, intValue));
        } else {
            linearLayout.getLayoutParams().height = intValue;
        }
        linearLayout.setGravity(com.tencent.aio.view_dsl.dsl.b.g());
        linearLayout.setOrientation(0);
        linearLayout.setMinimumHeight(((Number) com.tencent.qqnt.chathistory.util.m.c(40)).intValue());
        linearLayout.setPadding(((Number) com.tencent.qqnt.chathistory.util.m.c(14)).intValue(), linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
        CheckBox checkBox = new CheckBox(linearLayout.getContext());
        linearLayout.addView(checkBox);
        int intValue2 = ((Number) com.tencent.qqnt.chathistory.util.m.c(18)).intValue();
        if (checkBox.getLayoutParams() == null) {
            checkBox.setLayoutParams(new ViewGroup.LayoutParams(intValue2, 0));
        } else {
            checkBox.getLayoutParams().width = intValue2;
        }
        checkBox.setBackground(AppCompatResources.getDrawable(checkBox.getContext(), R.drawable.f160569kh));
        checkBox.setButtonDrawable((Drawable) null);
        checkBox.setId(R.id.dv_);
        int intValue3 = ((Number) com.tencent.qqnt.chathistory.util.m.c(18)).intValue();
        if (checkBox.getLayoutParams() == null) {
            checkBox.setLayoutParams(new ViewGroup.LayoutParams(0, intValue3));
        } else {
            checkBox.getLayoutParams().height = intValue3;
        }
        com.tencent.aio.view_dsl.dsl.f.p(checkBox, com.tencent.aio.view_dsl.dsl.b.g());
        checkBox.setClickable(false);
        checkBox.setVisibility(0);
        checkBox.setImportantForAccessibility(2);
        g(checkBox);
        TextView textView = new TextView(linearLayout.getContext());
        Object invoke = LayoutBuilderKt.b().invoke(linearLayout, new Object[0]);
        if (invoke != null) {
            textView.setLayoutParams((ViewGroup.LayoutParams) invoke);
            int l16 = com.tencent.aio.view_dsl.dsl.b.l();
            if (textView.getLayoutParams() == null) {
                textView.setLayoutParams(new ViewGroup.LayoutParams(l16, 0));
            } else {
                textView.getLayoutParams().width = l16;
            }
            textView.setId(R.id.jjc);
            int intValue4 = ((Number) com.tencent.qqnt.chathistory.util.m.c(20)).intValue();
            if (textView.getLayoutParams() == null) {
                textView.setLayoutParams(new ViewGroup.LayoutParams(0, intValue4));
            } else {
                textView.getLayoutParams().height = intValue4;
            }
            textView.setTextSize(0, ((Number) com.tencent.qqnt.chathistory.util.m.d(14)).floatValue());
            textView.setFocusable(true);
            com.tencent.aio.view_dsl.dsl.f.p(textView, com.tencent.aio.view_dsl.dsl.b.g());
            textView.setGravity(com.tencent.aio.view_dsl.dsl.b.g());
            textView.setTextColor(textView.getResources().getColorStateList(R.color.qui_common_text_secondary, null));
            h(textView);
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

    public final void g(@NotNull CheckBox checkBox) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) checkBox);
        } else {
            Intrinsics.checkNotNullParameter(checkBox, "<set-?>");
            this.ivFakeIndicator = checkBox;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) textView);
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

    public /* synthetic */ x(Context context, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, Integer.valueOf(i3), defaultConstructorMarker);
    }
}

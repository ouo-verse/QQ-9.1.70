package com.tencent.qqnt.chathistory.x2k;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.view.SquImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/qqnt/chathistory/x2k/u;", "Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "getRoot", "Landroid/content/Context;", "context", "Landroid/widget/RelativeLayout;", "e", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Landroid/view/View;", "f", "()Landroid/view/View;", "i", "(Landroid/view/View;)V", "_root", "Lcom/tencent/qqnt/view/SquImageView;", "c", "Lcom/tencent/qqnt/view/SquImageView;", "getIvThumb", "()Lcom/tencent/qqnt/view/SquImageView;", "g", "(Lcom/tencent/qqnt/view/SquImageView;)V", "ivThumb", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "d", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "getPhotoSelectItemSelectedIconIv", "()Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", tl.h.F, "(Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;)V", "photoSelectItemSelectedIconIv", "", "style", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class u implements ViewBinding {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public View _root;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public SquImageView ivThumb;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public QUICheckBox photoSelectItemSelectedIconIv;

    public u(@NotNull Context context, @Nullable Integer num) {
        RelativeLayout e16;
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
    public final RelativeLayout e(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        relativeLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg);
        int l3 = com.tencent.aio.view_dsl.dsl.b.l();
        if (relativeLayout.getLayoutParams() == null) {
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(l3, 0));
        } else {
            relativeLayout.getLayoutParams().width = l3;
        }
        int p16 = com.tencent.aio.view_dsl.dsl.b.p();
        if (relativeLayout.getLayoutParams() == null) {
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(0, p16));
        } else {
            relativeLayout.getLayoutParams().height = p16;
        }
        int intValue = ((Number) com.tencent.qqnt.chathistory.util.m.c(1)).intValue();
        relativeLayout.setPadding(intValue, intValue, intValue, intValue);
        SquImageView squImageView = new SquImageView(relativeLayout.getContext());
        relativeLayout.addView(squImageView);
        int l16 = com.tencent.aio.view_dsl.dsl.b.l();
        if (squImageView.getLayoutParams() == null) {
            squImageView.setLayoutParams(new ViewGroup.LayoutParams(l16, 0));
        } else {
            squImageView.getLayoutParams().width = l16;
        }
        squImageView.setId(R.id.y9u);
        int l17 = com.tencent.aio.view_dsl.dsl.b.l();
        if (squImageView.getLayoutParams() == null) {
            squImageView.setLayoutParams(new ViewGroup.LayoutParams(0, l17));
        } else {
            squImageView.getLayoutParams().height = l17;
        }
        squImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        g(squImageView);
        QUICheckBox qUICheckBox = new QUICheckBox(relativeLayout.getContext());
        relativeLayout.addView(qUICheckBox);
        qUICheckBox.setType(3);
        qUICheckBox.setId(R.id.fqa);
        int intValue2 = ((Number) com.tencent.qqnt.chathistory.util.m.c(24)).intValue();
        if (qUICheckBox.getLayoutParams() == null) {
            qUICheckBox.setLayoutParams(new ViewGroup.LayoutParams(intValue2, 0));
        } else {
            qUICheckBox.getLayoutParams().width = intValue2;
        }
        int intValue3 = ((Number) com.tencent.qqnt.chathistory.util.m.c(24)).intValue();
        if (qUICheckBox.getLayoutParams() == null) {
            qUICheckBox.setLayoutParams(new ViewGroup.LayoutParams(0, intValue3));
        } else {
            qUICheckBox.getLayoutParams().height = intValue3;
        }
        int intValue4 = ((Number) com.tencent.qqnt.chathistory.util.m.c(4)).intValue();
        qUICheckBox.setPadding(intValue4, intValue4, intValue4, intValue4);
        com.tencent.aio.view_dsl.dsl.f.f(qUICheckBox, true);
        qUICheckBox.setVisibility(8);
        com.tencent.aio.view_dsl.dsl.f.h(qUICheckBox, true);
        h(qUICheckBox);
        return relativeLayout;
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

    public final void g(@NotNull SquImageView squImageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) squImageView);
        } else {
            Intrinsics.checkNotNullParameter(squImageView, "<set-?>");
            this.ivThumb = squImageView;
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

    public final void h(@NotNull QUICheckBox qUICheckBox) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) qUICheckBox);
        } else {
            Intrinsics.checkNotNullParameter(qUICheckBox, "<set-?>");
            this.photoSelectItemSelectedIconIv = qUICheckBox;
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

    public /* synthetic */ u(Context context, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : num);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, num, Integer.valueOf(i3), defaultConstructorMarker);
    }
}

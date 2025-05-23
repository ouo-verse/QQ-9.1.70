package com.tencent.qqnt.aio.bottombar.sectionbar.viewholder;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.x;
import com.tencent.qqnt.aio.utils.l;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0006\u0010\u0006\u001a\u00020\u0004R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/viewholder/a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/a;", "model", "", "l", "o", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "icon", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "title", "Landroid/widget/LinearLayout;", "G", "Landroid/widget/LinearLayout;", "getItemBg", "()Landroid/widget/LinearLayout;", "itemBg", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "H", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ImageView icon;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView title;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout itemBg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/bottombar/sectionbar/viewholder/a$a;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "b", "Landroid/content/res/ColorStateList;", "normalColor", "pressColor", "Landroid/graphics/drawable/StateListDrawable;", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.bottombar.sectionbar.viewholder.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final StateListDrawable a(@Nullable ColorStateList normalColor, @Nullable ColorStateList pressColor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (StateListDrawable) iPatchRedirector.redirect((short) 3, (Object) this, (Object) normalColor, (Object) pressColor);
            }
            float b16 = l.b(8);
            StateListDrawable stateListDrawable = new StateListDrawable();
            GradientDrawable gradientDrawable = new GradientDrawable();
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            LayerDrawable layerDrawable = new LayerDrawable(new GradientDrawable[]{gradientDrawable, gradientDrawable2});
            gradientDrawable.setColor(pressColor);
            gradientDrawable.setCornerRadius(b16);
            gradientDrawable2.setColor(pressColor);
            gradientDrawable2.setCornerRadius(b16);
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, layerDrawable);
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setColor(normalColor);
            gradientDrawable3.setCornerRadius(b16);
            stateListDrawable.addState(new int[0], gradientDrawable3);
            return stateListDrawable;
        }

        @NotNull
        public final View b(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            ImageView imageView = new ImageView(context);
            imageView.setId(com.tencent.mobileqq.R.id.taa);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(x.a(16.0f), x.a(16.0f));
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
            TextView textView = new TextView(context);
            textView.setId(com.tencent.mobileqq.R.id.tac);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 16;
            layoutParams2.leftMargin = x.a(3.0f);
            textView.setLayoutParams(layoutParams2);
            textView.setTextSize(1, 13.0f);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextColor(ContextCompat.getColorStateList(context, com.tencent.mobileqq.R.color.qui_common_text_primary));
            textView.setMaxLines(1);
            RelativeLayout relativeLayout = new RelativeLayout(context);
            relativeLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -1));
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setId(com.tencent.mobileqq.R.id.tad);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, x.a(32.0f));
            layoutParams3.addRule(13);
            linearLayout.setLayoutParams(layoutParams3);
            linearLayout.setPadding(l.b(10), 0, l.b(10), 0);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            linearLayout.addView(imageView);
            linearLayout.addView(textView);
            relativeLayout.addView(linearLayout);
            return relativeLayout;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65549);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            return;
        }
        View findViewById = itemView.findViewById(com.tencent.mobileqq.R.id.taa);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026section_bar_default_icon)");
        this.icon = (ImageView) findViewById;
        View findViewById2 = itemView.findViewById(com.tencent.mobileqq.R.id.tac);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026ection_bar_default_title)");
        this.title = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(com.tencent.mobileqq.R.id.tad);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026ttom_section_bar_item_bg)");
        this.itemBg = (LinearLayout) findViewById3;
    }

    @NotNull
    public final ImageView getIcon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ImageView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.icon;
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void l(@NotNull com.tencent.qqnt.aio.bottombar.sectionbar.model.a model) {
        boolean z16;
        boolean startsWith$default;
        boolean startsWith$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) model);
            return;
        }
        Intrinsics.checkNotNullParameter(model, "model");
        if (model.b().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        Drawable drawable = null;
        if (!z16) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(model.b(), "http://", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(model.b(), "https://", false, 2, null);
                if (!startsWith$default2) {
                    drawable = this.itemView.getContext().getResources().getDrawable(this.itemView.getContext().getResources().getIdentifier(model.b(), "drawable", this.itemView.getContext().getPackageName()), null);
                }
            }
            URLDrawable drawable2 = URLDrawable.getDrawable(model.b(), URLDrawable.URLDrawableOptions.obtain());
            int status = drawable2.getStatus();
            drawable = drawable2;
            if (status == 2) {
                drawable2.restartDownload();
                drawable = drawable2;
            }
        }
        this.icon.setImageDrawable(drawable);
        this.title.setText(model.d());
        o();
    }

    @NotNull
    public final TextView m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TextView) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.title;
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.itemBg.setBackground(INSTANCE.a(ContextCompat.getColorStateList(this.itemView.getContext(), com.tencent.mobileqq.R.color.qui_common_fill_light_secondary), ContextCompat.getColorStateList(this.itemView.getContext(), com.tencent.mobileqq.R.color.qui_common_overlay_standard_primary)));
        }
    }
}

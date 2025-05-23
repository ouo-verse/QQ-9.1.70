package com.tencent.mobileqq.sharepanel.action;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tR\u001c\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\n \u000e*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/action/d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "context", "", "iconResId", "Landroid/graphics/drawable/Drawable;", "o", "p", "Lcom/tencent/mobileqq/sharepanel/action/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", DomainData.DOMAIN_NAME, "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "E", "Landroid/widget/ImageView;", "iconIv", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "labelTv", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "G", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class d extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int H;
    private static final int I;
    private static final int J;

    /* renamed from: E, reason: from kotlin metadata */
    private final ImageView iconIv;

    /* renamed from: F, reason: from kotlin metadata */
    private final TextView labelTv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/action/d$a;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "a", "", "ICON_BG_SIZE", "I", "ICON_SIZE", "ITEM_WIDTH", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.action.d$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final View a(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(d.H, -2));
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            ImageView imageView = new ImageView(context);
            imageView.setId(R.id.f84384m4);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(d.I, d.I));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            linearLayout.addView(imageView);
            TextView textView = new TextView(context);
            textView.setId(R.id.f84394m5);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = ViewUtils.dpToPx(6.0f);
            textView.setLayoutParams(layoutParams);
            textView.setMaxLines(2);
            textView.setTextColor(ContextCompat.getColorStateList(context, R.color.qui_common_text_primary_light));
            textView.setGravity(17);
            textView.setTextSize(10.0f);
            linearLayout.addView(textView);
            return linearLayout;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31576);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        H = ViewUtils.dpToPx(64.0f);
        I = ViewUtils.dpToPx(56.0f);
        J = ViewUtils.dpToPx(28.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
        } else {
            this.iconIv = (ImageView) itemView.findViewById(R.id.f84384m4);
            this.labelTv = (TextView) itemView.findViewById(R.id.f84394m5);
        }
    }

    private final Drawable o(Context context, int iconResId) {
        Drawable drawable;
        if (iconResId != 0) {
            drawable = ContextCompat.getDrawable(context, iconResId);
        } else {
            drawable = null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        int i3 = I;
        gradientDrawable.setSize(i3, i3);
        gradientDrawable.setCornerRadius(ViewUtils.dpToPx(13.0f));
        gradientDrawable.setColor(ContextCompat.getColorStateList(context, R.color.qui_common_fill_light_secondary));
        if (drawable != null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, drawable});
            int i16 = J;
            layerDrawable.setLayerSize(1, i16, i16);
            layerDrawable.setLayerGravity(1, 17);
            return layerDrawable;
        }
        return gradientDrawable;
    }

    private final Drawable p(Context context, int iconResId) {
        Drawable o16 = o(context, iconResId);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        int i3 = I;
        gradientDrawable.setSize(i3, i3);
        gradientDrawable.setCornerRadius(ViewUtils.dpToPx(13.0f));
        gradientDrawable.setColor(ContextCompat.getColorStateList(context, R.color.qui_common_overlay_standard_secondary));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{o16, gradientDrawable});
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, layerDrawable);
        stateListDrawable.addState(new int[0], o16);
        return stateListDrawable;
    }

    public final void n(@NotNull e item) {
        Drawable o16;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        ImageView imageView = this.iconIv;
        if (item.b()) {
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            o16 = p(context, item.c());
        } else {
            Context context2 = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
            o16 = o(context2, item.c());
        }
        imageView.setImageDrawable(o16);
        this.labelTv.setText(item.d());
        View view = this.itemView;
        if (item.b()) {
            f16 = 1.0f;
        } else {
            f16 = 0.3f;
        }
        view.setAlpha(f16);
    }
}

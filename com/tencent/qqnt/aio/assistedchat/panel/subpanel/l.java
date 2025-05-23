package com.tencent.qqnt.aio.assistedchat.panel.subpanel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quishimmer.view.QUIShimmerImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.httputils.ErrorString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/l;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/f;", "Landroid/graphics/drawable/Drawable;", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "l", "o", "Landroid/content/Context;", "E", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/biz/qui/quishimmer/view/QUIShimmerImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qui/quishimmer/view/QUIShimmerImageView;", "shimmerImageView", "<init>", "(Landroid/content/Context;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
final class l extends f {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final QUIShimmerImageView shimmerImageView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@NotNull Context context) {
        super(new FrameLayout(context));
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        QUIShimmerImageView qUIShimmerImageView = new QUIShimmerImageView(context);
        qUIShimmerImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        qUIShimmerImageView.setImageDrawable(p());
        qUIShimmerImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        qUIShimmerImageView.setAdjustViewBounds(true);
        this.shimmerImageView = qUIShimmerImageView;
        View view = this.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.FrameLayout");
        FrameLayout frameLayout = (FrameLayout) view;
        frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        frameLayout.setPadding(com.tencent.qqnt.aio.utils.l.b(16), 0, com.tencent.qqnt.aio.utils.l.b(16), 0);
        frameLayout.addView(qUIShimmerImageView);
    }

    private final Drawable p() {
        Drawable[] drawableArr = new Drawable[6];
        for (int i3 = 0; i3 < 6; i3++) {
            drawableArr[i3] = q();
        }
        LayerDrawable layerDrawable = new LayerDrawable(drawableArr);
        for (int i16 = 0; i16 < 6; i16++) {
            layerDrawable.setLayerHeight(i16, com.tencent.qqnt.aio.utils.l.b(56));
            layerDrawable.setLayerInsetTop(i16, (com.tencent.qqnt.aio.utils.l.b(64) * i16) + com.tencent.qqnt.aio.utils.l.b(8));
        }
        return layerDrawable;
    }

    private final Drawable q() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setSize(-1, com.tencent.qqnt.aio.utils.l.b(40));
        gradientDrawable.setCornerRadius(com.tencent.qqnt.aio.utils.l.a(8.0f));
        gradientDrawable.setColor(ContextCompat.getColorStateList(this.context, R.color.qui_common_fill_light_tertiary));
        gradientDrawable.setStroke((int) com.tencent.qqnt.aio.utils.l.a(0.5f), ContextCompat.getColorStateList(this.context, R.color.qui_common_border_light));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setSize(-1, com.tencent.qqnt.aio.utils.l.b(20));
        gradientDrawable2.setCornerRadius(com.tencent.qqnt.aio.utils.l.a(2.0f));
        gradientDrawable2.setColor(ColorUtils.setAlphaComponent(ContextCompat.getColor(this.context, R.color.qui_common_text_primary), 10));
        LayerDrawable layerDrawable = new LayerDrawable(new GradientDrawable[]{gradientDrawable, gradientDrawable2});
        layerDrawable.setLayerGravity(1, 17);
        layerDrawable.setLayerInset(1, com.tencent.qqnt.aio.utils.l.b(12), 0, com.tencent.qqnt.aio.utils.l.b(12), 0);
        return layerDrawable;
    }

    @Override // com.tencent.qqnt.aio.assistedchat.panel.subpanel.f
    public void l(@NotNull e item, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, position);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        this.shimmerImageView.updateColors(ErrorString.ERROR_DRAW_UNKNOWN, 218103808, 218103808, ErrorString.ERROR_DRAW_UNKNOWN);
        this.shimmerImageView.startShimming(null);
    }

    @Override // com.tencent.qqnt.aio.assistedchat.panel.subpanel.f
    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.o();
            this.shimmerImageView.stopShimming(null);
        }
    }
}

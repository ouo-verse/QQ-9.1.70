package com.tencent.mobileqq.matchfriend.reborn.content.signal.square.section;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.utils.ModelExtKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$SignalConfig;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014J(\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0014R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/section/d;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "data", "Landroid/graphics/drawable/Drawable;", "p", "", "r", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "signalBgView", "e", "signalIconView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "signalTitleView", h.F, "signalTypeView", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class d extends Section<SignalPlazaSvrPB$SignalInfo> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView signalBgView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView signalIconView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView signalTitleView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView signalTypeView;

    private final Drawable p(SignalPlazaSvrPB$SignalInfo data) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        SignalPB$SignalConfig signalPB$SignalConfig = data.signal_meta.config;
        Intrinsics.checkNotNullExpressionValue(signalPB$SignalConfig, "data.signal_meta.config");
        gradientDrawable.setColors(ModelExtKt.e(signalPB$SignalConfig));
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setCornerRadius(l.a(5.0f));
        return gradientDrawable;
    }

    private final boolean r() {
        return FontSettingManager.getFontLevel() > 17.0f || com.tencent.mobileqq.pad.c.d(QBaseActivity.sTopActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.opu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026er_square_item_signal_bg)");
        ImageView imageView = (ImageView) findViewById;
        this.signalBgView = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalBgView");
            imageView = null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        Unit unit = Unit.INSTANCE;
        imageView.setImageDrawable(URLDrawable.getDrawable("https://downv6.qq.com/extendfriend/kl_signal_list_card_bubble.png", obtain));
        View findViewById2 = containerView.findViewById(R.id.opy);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026er_square_item_type_icon)");
        this.signalIconView = (ImageView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.opw);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026ranger_square_item_title)");
        this.signalTitleView = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.opx);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026tranger_square_item_type)");
        this.signalTypeView = (TextView) findViewById4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindData(SignalPlazaSvrPB$SignalInfo data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        ImageView imageView = this.signalBgView;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalBgView");
            imageView = null;
        }
        imageView.setBackground(p(data));
        TextView textView2 = this.signalTitleView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTitleView");
            textView2 = null;
        }
        textView2.setText(textView2.getContext().getString(R.string.f169683x11, data.signal_meta.partner_adj.partner_adj_name.get()));
        textView2.setTextSize(r() ? 14.0f : 17.0f);
        ImageView imageView2 = this.signalIconView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalIconView");
            imageView2 = null;
        }
        int b16 = l.b(r() ? 19 : 24);
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = b16;
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = b16;
            imageView2.setLayoutParams(layoutParams2);
        }
        String str = data.signal_meta.config.icon.get();
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = b16;
        obtain.mRequestHeight = b16;
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        Unit unit = Unit.INSTANCE;
        imageView2.setImageDrawable(URLDrawable.getDrawable(str, obtain));
        TextView textView3 = this.signalTypeView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalTypeView");
        } else {
            textView = textView3;
        }
        textView.setText(data.signal_meta.partner_name.get());
        textView.setTextSize(r() ? 14.0f : 17.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }
}

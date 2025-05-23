package com.tencent.mobileqq.qwallet.pay;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.ad.AdEvent;
import com.tencent.mobileqq.qwallet.ad.BaseGdtAdView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010(\u001a\u00020'\u0012\b\b\u0002\u0010)\u001a\u00020'\u00a2\u0006\u0004\b*\u0010+J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000bR\u0014\u0010\u001a\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000bR$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pay/PaySuccessFinanceAdView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "picUrl", "", "E0", "Lcom/tencent/mobileqq/qwallet/pay/FinanceAdInfo;", "financeAdInfo", "C0", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "adTopTitle", "Landroid/widget/RelativeLayout;", "e", "Landroid/widget/RelativeLayout;", "mediaContainer", "f", "description", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "merchantLogo", "i", "merchantName", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "jumpBtn", "Lcom/tencent/mobileqq/qwallet/ad/BaseGdtAdView$a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qwallet/ad/BaseGdtAdView$a;", "getAdEventCallback", "()Lcom/tencent/mobileqq/qwallet/ad/BaseGdtAdView$a;", "setAdEventCallback", "(Lcom/tencent/mobileqq/qwallet/ad/BaseGdtAdView$a;)V", "adEventCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PaySuccessFinanceAdView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private BaseGdtAdView.a adEventCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView adTopTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RelativeLayout mediaContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView description;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView merchantLogo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView merchantName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView jumpBtn;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qwallet/pay/PaySuccessFinanceAdView$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@Nullable View view, @Nullable Outline outline) {
            if (view != null && outline != null) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 16.0f);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaySuccessFinanceAdView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(PaySuccessFinanceAdView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View findViewById = this$0.findViewById(R.id.f228604v);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.pay_su\u2026ess_finance_ad_container)");
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById;
        constraintLayout.setOutlineProvider(new a());
        constraintLayout.setClipToOutline(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(PaySuccessFinanceAdView this$0, FinanceAdInfo financeAdInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qwallet.utils.k.h(this$0.getContext(), financeAdInfo.getBtnUrl());
        BaseGdtAdView.a aVar = this$0.adEventCallback;
        if (aVar != null) {
            aVar.a(AdEvent.CLICK);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0010 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean E0(String picUrl) {
        boolean z16;
        boolean isBlank;
        if (picUrl != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(picUrl);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return false;
                }
                this.mediaContainer.removeAllViews();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(layoutParams);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.mediaContainer.addView(imageView);
                ColorDrawable colorDrawable = new ColorDrawable(0);
                imageView.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(picUrl, colorDrawable, colorDrawable));
                return true;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0016 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean C0(@Nullable final FinanceAdInfo financeAdInfo) {
        boolean z16;
        boolean isBlank;
        if (financeAdInfo == null) {
            return false;
        }
        String id5 = financeAdInfo.getId();
        if (id5 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(id5);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return false;
                }
                this.jumpBtn.setText(financeAdInfo.getBtnText());
                this.merchantLogo.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(financeAdInfo.getIcon()));
                this.merchantName.setText(financeAdInfo.getBrand());
                this.adTopTitle.setText(financeAdInfo.getTitle());
                this.description.setText(financeAdInfo.getSubTitle());
                setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.pay.j
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PaySuccessFinanceAdView.D0(PaySuccessFinanceAdView.this, financeAdInfo, view);
                    }
                });
                BaseGdtAdView.a aVar = this.adEventCallback;
                if (aVar != null) {
                    aVar.a(AdEvent.RENDERED);
                }
                return E0(financeAdInfo.getBanner());
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public final void setAdEventCallback(@Nullable BaseGdtAdView.a aVar) {
        this.adEventCallback = aVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaySuccessFinanceAdView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaySuccessFinanceAdView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PaySuccessFinanceAdView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaySuccessFinanceAdView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.hkf, this);
        View findViewById = findViewById(R.id.scd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.ad_top_title)");
        this.adTopTitle = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.yzt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.media_container)");
        this.mediaContainer = (RelativeLayout) findViewById2;
        View findViewById3 = findViewById(R.id.sbm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.ad_description)");
        this.description = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f163981fi);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.ad_logo)");
        this.merchantLogo = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.f163993fz);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.ad_title)");
        this.merchantName = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.sbv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.ad_jump_btn)");
        this.jumpBtn = (TextView) findViewById6;
        findViewById(R.id.sbn).setVisibility(8);
        post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.pay.i
            @Override // java.lang.Runnable
            public final void run() {
                PaySuccessFinanceAdView.B0(PaySuccessFinanceAdView.this);
            }
        });
    }
}

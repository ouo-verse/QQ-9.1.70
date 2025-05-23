package com.tencent.mobileqq.qwallet.home;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.ad.BaseGdtAdView;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0014J\b\u0010\t\u001a\u00020\u0004H\u0014J\b\u0010\n\u001a\u00020\u0004H\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0014J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/HomeAdView;", "Lcom/tencent/mobileqq/qwallet/ad/BaseGdtAdView;", "", "onFinishInflate", "", "Q0", "S0", "X0", "N0", "U0", "V0", "P0", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "k1", "l1", "Landroid/graphics/drawable/ColorDrawable;", "J", "Landroid/graphics/drawable/ColorDrawable;", "nightMask", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HomeAdView extends BaseGdtAdView {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final ColorDrawable nightMask;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomeAdView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.qwallet.ad.BaseGdtAdView
    protected int N0() {
        return R.id.sbm;
    }

    @Override // com.tencent.mobileqq.qwallet.ad.BaseGdtAdView
    protected int P0() {
        return R.id.sbv;
    }

    @Override // com.tencent.mobileqq.qwallet.ad.BaseGdtAdView
    protected int Q0() {
        return R.layout.hkd;
    }

    @Override // com.tencent.mobileqq.qwallet.ad.BaseGdtAdView
    protected int S0() {
        return R.id.yzt;
    }

    @Override // com.tencent.mobileqq.qwallet.ad.BaseGdtAdView
    protected int U0() {
        return R.id.f163981fi;
    }

    @Override // com.tencent.mobileqq.qwallet.ad.BaseGdtAdView
    protected int V0() {
        return R.id.f163993fz;
    }

    @Override // com.tencent.mobileqq.qwallet.ad.BaseGdtAdView
    protected int X0() {
        return R.id.sbn;
    }

    @Override // com.tencent.mobileqq.qwallet.ad.BaseGdtAdView
    public void k1(@NotNull GdtAd gdtAd) {
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        QWalletHomeAdvIPCModule qWalletHomeAdvIPCModule = QWalletHomeAdvIPCModule.f277953d;
        if (!qWalletHomeAdvIPCModule.g(gdtAd)) {
            qWalletHomeAdvIPCModule.k(gdtAd);
            super.k1(gdtAd);
            return;
        }
        QLog.w("BaseGdtAdView", 1, "ignored reportOriginalExposure, traceId=" + gdtAd.getTraceId());
    }

    @Override // com.tencent.mobileqq.qwallet.ad.BaseGdtAdView
    public void l1(@NotNull GdtAd gdtAd) {
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        QWalletHomeAdvIPCModule qWalletHomeAdvIPCModule = QWalletHomeAdvIPCModule.f277953d;
        if (!qWalletHomeAdvIPCModule.h(gdtAd)) {
            qWalletHomeAdvIPCModule.l(gdtAd);
            super.l1(gdtAd);
            return;
        }
        QLog.w("BaseGdtAdView", 1, "ignored reportStrictExposure, traceId=" + gdtAd.getTraceId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qwallet.ad.BaseGdtAdView, android.view.View
    public void onFinishInflate() {
        ColorDrawable colorDrawable;
        super.onFinishInflate();
        com.tencent.mobileqq.qwallet.k.b(R0(), ViewUtils.dpToPx(4.0f));
        com.tencent.mobileqq.qwallet.k.b(O0(), ViewUtils.dpToPx(4.0f));
        RelativeLayout R0 = R0();
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (QQTheme.isNowThemeIsNight()) {
            colorDrawable = this.nightMask;
        } else {
            colorDrawable = null;
        }
        R0.setForeground(colorDrawable);
        M0().setTextSize(0, BaseApplication.getContext().getResources().getDimension(R.dimen.dax));
        ViewGroup.LayoutParams layoutParams = O0().getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = com.tencent.mobileqq.util.x.c(getContext(), 5.0f);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomeAdView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomeAdView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ HomeAdView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HomeAdView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.nightMask = new ColorDrawable(Color.parseColor("#66000000"));
    }
}

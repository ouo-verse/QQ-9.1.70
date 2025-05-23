package com.tencent.sqshow.zootopia.card.view.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.model.MaintEntryType;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.aa;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import n74.dj;
import t74.m;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001$B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\u000b\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/widget/PortalStoreCurrencyView;", "Landroid/widget/LinearLayout;", "", "g", "Landroid/view/View$OnClickListener;", "listener", "setSilverListener", "setCoinListener", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/f;", "callback", "setPaySuccessCallback", "data", tl.h.F, "Ln74/dj;", "d", "Ln74/dj;", "mBinding", "", "e", "Z", "mIsMaintaining", "f", "Landroid/view/View$OnClickListener;", "coinClickListener", "Lcom/tencent/mobileqq/zootopia/api/e;", "paySuccessCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreCurrencyView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final dj mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean mIsMaintaining;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View.OnClickListener coinClickListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> paySuccessCallback;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/card/view/widget/PortalStoreCurrencyView$b", "Lcom/tencent/mobileqq/vas/pay/api/IVasNativePayManager$PayObserver;", "", "onOpenPayViewFail", "onOpenPayViewSuccess", "onPaySuccess", "", "code", "onPayError", "onPayViewClose", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements IVasNativePayManager.PayObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayError(int code) {
            QLog.d("PortalStoreCurrencyView", 1, "onPaySuccess, code: " + code);
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewFail() {
            QLog.d("PortalStoreCurrencyView", 1, "onOpenPayViewFail");
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewSuccess() {
            QLog.d("PortalStoreCurrencyView", 1, "onOpenPayViewSuccess");
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPaySuccess() {
            QLog.d("PortalStoreCurrencyView", 1, "onPaySuccess");
            if (PortalStoreCurrencyView.this.paySuccessCallback == null) {
                yb4.e.g(yb4.e.f450058a, "paySuccess", 0, 2, null);
                return;
            }
            yb4.e eVar = yb4.e.f450058a;
            com.tencent.mobileqq.zootopia.api.e eVar2 = PortalStoreCurrencyView.this.paySuccessCallback;
            Intrinsics.checkNotNull(eVar2);
            yb4.e.h(eVar, "paySuccess", eVar2, 0, 4, null);
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayViewClose() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreCurrencyView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final PortalStoreCurrencyView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        m mVar = m.f435564a;
        AssetManager assets = BaseApplication.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        final Typeface b16 = mVar.b(assets);
        AssetManager assets2 = BaseApplication.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets2, "context.assets");
        final Typeface b17 = mVar.b(assets2);
        t74.l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.PortalStoreCurrencyView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                dj djVar;
                dj djVar2;
                djVar = PortalStoreCurrencyView.this.mBinding;
                djVar.f419284h.setTypeface(b16);
                djVar2 = PortalStoreCurrencyView.this.mBinding;
                djVar2.f419280d.setTypeface(b17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(PortalStoreCurrencyView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("PortalStoreCurrencyView", 1, "addCoinButton");
        if (this$0.mIsMaintaining) {
            QLog.e("PortalStoreCurrencyView", 1, "addCoinButton error as rainting");
            return;
        }
        View.OnClickListener onClickListener = this$0.coinClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        this$0.g();
    }

    private final void g() {
        ((IVasNativePayManager) QRoute.api(IVasNativePayManager.class)).initAndShowPayPanel(Foreground.getTopActivity(), IVasNativePayManager.TITLE_RECHARGE, "\u8d85\u7ea7QQ\u79c0", new IVasNativePayManager.ReportData("1009", "0", "0", "0"), new b());
    }

    public final void h(final com.tencent.sqshow.zootopia.data.f data) {
        Intrinsics.checkNotNullParameter(data, "data");
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.card.view.widget.PortalStoreCurrencyView$updateCurrencyView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                dj djVar;
                dj djVar2;
                djVar = PortalStoreCurrencyView.this.mBinding;
                djVar.f419284h.setText(data.getSilverCoinRet() == 0 ? com.tencent.sqshow.zootopia.utils.e.f373267a.a(data.getSilverCoin()) : "--");
                djVar2 = PortalStoreCurrencyView.this.mBinding;
                djVar2.f419280d.setText(data.getGoldCoinRet() == 0 ? com.tencent.sqshow.zootopia.utils.e.f373267a.a(data.getGoldCoin()) : "--");
            }
        });
    }

    public final void setCoinListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.coinClickListener = listener;
    }

    public final void setPaySuccessCallback(com.tencent.mobileqq.zootopia.api.e<com.tencent.sqshow.zootopia.data.f> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.paySuccessCallback = callback;
    }

    public final void setSilverListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LinearLayout linearLayout = this.mBinding.f419282f;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.silverArea");
        aa.f(linearLayout, listener, 200L, "addSilverCoin");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreCurrencyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PortalStoreCurrencyView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStoreCurrencyView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        dj f16 = dj.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        this.mIsMaintaining = com.tencent.mobileqq.zplan.model.j.a(((IZPlanApi) QRoute.api(IZPlanApi.class)).getMaintenanceInfo(MaintEntryType.ALL), new Date());
        setGravity(16);
        setBackgroundResource(R.drawable.i6u);
        t74.l.f435563a.f(new Runnable() { // from class: com.tencent.sqshow.zootopia.card.view.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                PortalStoreCurrencyView.c(PortalStoreCurrencyView.this);
            }
        });
        View root = f16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        aa.f(root, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.card.view.widget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PortalStoreCurrencyView.d(PortalStoreCurrencyView.this, view);
            }
        }, 200L, "addGoldCoin");
    }
}

package com.tencent.sqshow.zootopia.card.view.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.model.MaintEntryType;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.aa;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import n74.di;
import t74.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/widget/CurrencyView;", "Landroid/widget/LinearLayout;", "", "c", "Landroid/view/View$OnClickListener;", "listener", "setSilverListener", "setCoinListener", "Lcom/tencent/sqshow/zootopia/data/f;", "data", "d", "Ln74/di;", "Ln74/di;", "mBinding", "", "e", "Z", "mIsMaintaining", "f", "Landroid/view/View$OnClickListener;", "coinClickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", tl.h.F, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class CurrencyView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final di mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean mIsMaintaining;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View.OnClickListener coinClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/card/view/widget/CurrencyView$b", "Lcom/tencent/mobileqq/vas/pay/api/IVasNativePayManager$PayObserver;", "", "onOpenPayViewFail", "onOpenPayViewSuccess", "onPaySuccess", "", "code", "onPayError", "onPayViewClose", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements IVasNativePayManager.PayObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayError(int code) {
            QLog.d("currencyView", 1, "onPaySuccess, code: " + code);
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewFail() {
            QLog.d("currencyView", 1, "onOpenPayViewFail");
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewSuccess() {
            QLog.d("currencyView", 1, "onOpenPayViewSuccess");
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPaySuccess() {
            QLog.d("currencyView", 1, "onPaySuccess");
            yb4.e.g(yb4.e.f450058a, "paySuccess", 0, 2, null);
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayViewClose() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CurrencyView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CurrencyView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("currencyView", 1, "addCoinButton");
        if (this$0.mIsMaintaining) {
            QLog.e("currencyView", 1, "addCoinButton error as rainting");
            return;
        }
        View.OnClickListener onClickListener = this$0.coinClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        this$0.c();
    }

    private final void c() {
        ((IVasNativePayManager) QRoute.api(IVasNativePayManager.class)).initAndShowPayPanel(Foreground.getTopActivity(), IVasNativePayManager.TITLE_RECHARGE, "\u8d85\u7ea7QQ\u79c0", new IVasNativePayManager.ReportData("1009", "0", "0", "0"), new b());
    }

    public final void d(com.tencent.sqshow.zootopia.data.f data) {
        String str;
        Intrinsics.checkNotNullParameter(data, "data");
        TextView textView = this.mBinding.f419276h;
        String str2 = "--";
        if (data.getSilverCoinRet() != 0) {
            str = "--";
        } else {
            str = com.tencent.sqshow.zootopia.utils.e.f373267a.a(data.getSilverCoin());
        }
        textView.setText(str);
        TextView textView2 = this.mBinding.f419273e;
        if (data.getGoldCoinRet() == 0) {
            str2 = com.tencent.sqshow.zootopia.utils.e.f373267a.a(data.getGoldCoin());
        }
        textView2.setText(str2);
    }

    public final void setCoinListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.coinClickListener = listener;
    }

    public final void setSilverListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LinearLayout linearLayout = this.mBinding.f419274f;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.silverArea");
        aa.f(linearLayout, listener, 200L, "addSilverCoin");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CurrencyView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CurrencyView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CurrencyView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        di f16 = di.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        this.mIsMaintaining = com.tencent.mobileqq.zplan.model.j.a(((IZPlanApi) QRoute.api(IZPlanApi.class)).getMaintenanceInfo(MaintEntryType.ALL), new Date());
        setOrientation(0);
        setGravity(16);
        setBackgroundResource(R.drawable.i6t);
        TextView textView = f16.f419276h;
        m mVar = m.f435564a;
        AssetManager assets = BaseApplication.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        textView.setTypeface(mVar.b(assets));
        TextView textView2 = f16.f419273e;
        AssetManager assets2 = BaseApplication.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets2, "context.assets");
        textView2.setTypeface(mVar.b(assets2));
        LinearLayout linearLayout = f16.f419271c;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.goldAndAddArea");
        aa.b(linearLayout, com.tencent.sqshow.zootopia.utils.i.b(10));
        LinearLayout linearLayout2 = f16.f419271c;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "mBinding.goldAndAddArea");
        aa.f(linearLayout2, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.card.view.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CurrencyView.b(CurrencyView.this, view);
            }
        }, 200L, "addGoldCoin");
    }
}

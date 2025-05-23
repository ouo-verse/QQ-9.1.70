package com.tencent.sqshow.zootopia.nativeui.view.detail.base;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.zootopia.utils.g;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.sqshow.zootopia.nativeui.view.detail.base.GoodsDetailPriceView;
import com.tencent.sqshow.zootopia.utils.t;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m84.b;
import n74.aj;
import org.slf4j.Marker;
import t74.m;
import uv4.az;
import uv4.ba;
import uv4.bc;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0014R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006*"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/detail/base/GoodsDetailPriceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Luv4/az;", "itemData", "", "D0", "E0", "L0", "F0", "J0", "C0", "Luv4/bc;", "price", "", "priceType", "M0", "N0", "", "K0", "I0", "", "timeMilliSecond", "", "H0", "intervalTime", "O0", "G0", NodeProps.ON_DETACHED_FROM_WINDOW, "Ln74/aj;", "d", "Ln74/aj;", "viewBinding", "Landroid/os/CountDownTimer;", "e", "Landroid/os/CountDownTimer;", "countDownTimer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class GoodsDetailPriceView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final aj viewBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private CountDownTimer countDownTimer;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/detail/base/GoodsDetailPriceView$a", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GoodsDetailPriceView f371650a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j3, GoodsDetailPriceView goodsDetailPriceView) {
            super(j3, 1000L);
            this.f371650a = goodsDetailPriceView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(GoodsDetailPriceView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.I0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(GoodsDetailPriceView this$0, long j3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            String H0 = this$0.H0(j3);
            ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = this$0.viewBinding.f418629d;
            Intrinsics.checkNotNullExpressionValue(zplanExcludeFontPaddingTextView, "viewBinding.tvDiscountHint");
            b.i(zplanExcludeFontPaddingTextView, H0, this$0.getContext().getResources().getColor(R.color.f8747s), 6, H0.length());
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            final GoodsDetailPriceView goodsDetailPriceView = this.f371650a;
            goodsDetailPriceView.post(new Runnable() { // from class: fa4.k
                @Override // java.lang.Runnable
                public final void run() {
                    GoodsDetailPriceView.a.c(GoodsDetailPriceView.this);
                }
            });
        }

        @Override // android.os.CountDownTimer
        public void onTick(final long millisUntilFinished) {
            final GoodsDetailPriceView goodsDetailPriceView = this.f371650a;
            goodsDetailPriceView.post(new Runnable() { // from class: fa4.l
                @Override // java.lang.Runnable
                public final void run() {
                    GoodsDetailPriceView.a.d(GoodsDetailPriceView.this, millisUntilFinished);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodsDetailPriceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        aj f16 = aj.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(\n            Lay\u2026(context), this\n        )");
        this.viewBinding = f16;
    }

    private final void C0(az itemData) {
        bc bcVar = itemData.f440287n;
        if (!K0(itemData) && bcVar.f440312a != 0) {
            long serverTimeMillis = (bcVar.f440317f * 1000) - NetConnInfoCenter.getServerTimeMillis();
            String H0 = H0(serverTimeMillis);
            ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = this.viewBinding.f418629d;
            Intrinsics.checkNotNullExpressionValue(zplanExcludeFontPaddingTextView, "viewBinding.tvDiscountHint");
            b.i(zplanExcludeFontPaddingTextView, H0, getContext().getResources().getColor(R.color.f8747s), 6, H0.length());
            O0(serverTimeMillis);
            int i3 = bcVar.f440312a;
            if (i3 == 1) {
                this.viewBinding.f418630e.setVisibility(8);
                this.viewBinding.f418631f.setText(String.valueOf(bcVar.f440313b));
                return;
            }
            if (i3 == 2) {
                this.viewBinding.f418630e.setVisibility(8);
                this.viewBinding.f418631f.setText(String.valueOf(bcVar.f440314c));
                return;
            } else {
                if (i3 == 3 || i3 == 4) {
                    this.viewBinding.f418630e.setVisibility(bcVar.f440315d >= bcVar.f440313b ? 8 : 0);
                    this.viewBinding.f418630e.setText(String.valueOf(bcVar.f440313b));
                    this.viewBinding.f418631f.setVisibility(bcVar.f440316e < bcVar.f440314c ? 0 : 8);
                    this.viewBinding.f418631f.setText(String.valueOf(bcVar.f440314c));
                    return;
                }
                return;
            }
        }
        I0();
    }

    private final void D0(az itemData) {
        if (com.tencent.sqshow.zootopia.nativeui.data.cart.b.e(itemData)) {
            this.viewBinding.f418632g.setVisibility(0);
            this.viewBinding.f418632g.setText(getContext().getString(R.string.xos, t.f373300a.f(itemData.A * 1000)));
        } else {
            this.viewBinding.f418632g.setVisibility(8);
        }
    }

    private final void E0(az itemData) {
        String string;
        this.viewBinding.f418633h.setVisibility(0);
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = this.viewBinding.f418633h;
        ba baVar = itemData.f440288o;
        if (baVar != null && g.f(baVar)) {
            if (r94.b.y(itemData)) {
                string = "\u4ec5\u901a\u8fc7\u89c2\u770b\u5e7f\u544a\u83b7\u53d6";
            } else {
                string = itemData.f440286m;
            }
        } else {
            string = getContext().getString(R.string.f169818xs0, t.f373300a.e(itemData.f440280g * 1000));
        }
        zplanExcludeFontPaddingTextView.setText(string);
    }

    private final void F0(az itemData) {
        bc price = itemData.f440287n;
        int i3 = price.f440312a;
        if (i3 == 1) {
            N0();
            this.viewBinding.f418636k.setText(String.valueOf(price.f440315d));
            this.viewBinding.f418628c.setImageResource(R.drawable.ilx);
        } else if (i3 == 2) {
            N0();
            this.viewBinding.f418636k.setText(String.valueOf(price.f440316e));
            this.viewBinding.f418628c.setImageResource(R.drawable.f159901im2);
        } else {
            if (i3 != 3 && i3 != 4) {
                if (TextUtils.isEmpty(itemData.f440286m)) {
                    return;
                }
                I0();
                J0();
                return;
            }
            Intrinsics.checkNotNullExpressionValue(price, "price");
            M0(price, price.f440312a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String H0(long timeMilliSecond) {
        String string = getContext().getString(R.string.xng, t.f373300a.c(timeMilliSecond / 1000));
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     \u2026iSecond / 1000)\n        )");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I0() {
        this.viewBinding.f418629d.setVisibility(8);
        this.viewBinding.f418630e.setVisibility(8);
        this.viewBinding.f418631f.setVisibility(8);
    }

    private final void J0() {
        this.viewBinding.f418635j.setVisibility(8);
        this.viewBinding.f418627b.setVisibility(8);
        this.viewBinding.f418636k.setVisibility(8);
        this.viewBinding.f418628c.setVisibility(8);
    }

    private final boolean K0(az itemData) {
        return TextUtils.isEmpty(itemData.f440287n.f440318g) || NetConnInfoCenter.getServerTimeMillis() > itemData.f440287n.f440317f * 1000;
    }

    private final void L0() {
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = this.viewBinding.f418636k;
        m mVar = m.f435564a;
        AssetManager assets = getContext().getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        zplanExcludeFontPaddingTextView.setTypeface(mVar.a(assets));
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2 = this.viewBinding.f418635j;
        AssetManager assets2 = getContext().getAssets();
        Intrinsics.checkNotNullExpressionValue(assets2, "context.assets");
        zplanExcludeFontPaddingTextView2.setTypeface(mVar.a(assets2));
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView3 = this.viewBinding.f418634i;
        AssetManager assets3 = getContext().getAssets();
        Intrinsics.checkNotNullExpressionValue(assets3, "context.assets");
        zplanExcludeFontPaddingTextView3.setTypeface(mVar.a(assets3));
        TextView textView = this.viewBinding.f418631f;
        AssetManager assets4 = getContext().getAssets();
        Intrinsics.checkNotNullExpressionValue(assets4, "context.assets");
        textView.setTypeface(mVar.a(assets4));
        TextView textView2 = this.viewBinding.f418630e;
        AssetManager assets5 = getContext().getAssets();
        Intrinsics.checkNotNullExpressionValue(assets5, "context.assets");
        textView2.setTypeface(mVar.a(assets5));
        this.viewBinding.f418630e.getPaint().setFlags(this.viewBinding.f418630e.getPaintFlags() | 16);
        this.viewBinding.f418631f.getPaint().setFlags(this.viewBinding.f418631f.getPaintFlags() | 16);
    }

    private final void N0() {
        this.viewBinding.f418634i.setVisibility(8);
        this.viewBinding.f418636k.setVisibility(0);
        this.viewBinding.f418628c.setVisibility(0);
    }

    private final void O0(long intervalTime) {
        if (this.countDownTimer == null) {
            this.countDownTimer = new a(intervalTime, this);
        }
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    public final void G0(az itemData) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        if (itemData.f440287n == null) {
            setVisibility(8);
            return;
        }
        L0();
        D0(itemData);
        E0(itemData);
        C0(itemData);
        F0(itemData);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private final void M0(bc price, int priceType) {
        if (priceType == 3) {
            this.viewBinding.f418634i.setVisibility(8);
            this.viewBinding.f418628c.setImageResource(R.drawable.f159901im2);
            this.viewBinding.f418636k.setText(String.valueOf(price.f440316e));
            this.viewBinding.f418627b.setVisibility(8);
            this.viewBinding.f418635j.setVisibility(8);
            return;
        }
        if (priceType != 4) {
            return;
        }
        this.viewBinding.f418634i.setVisibility(0);
        this.viewBinding.f418634i.setText(Marker.ANY_NON_NULL_MARKER);
        this.viewBinding.f418628c.setVisibility(0);
        this.viewBinding.f418636k.setVisibility(0);
        this.viewBinding.f418627b.setVisibility(0);
        this.viewBinding.f418635j.setVisibility(0);
        this.viewBinding.f418628c.setImageResource(R.drawable.f159901im2);
        this.viewBinding.f418636k.setText(String.valueOf(price.f440316e));
        this.viewBinding.f418627b.setImageResource(R.drawable.ilx);
        this.viewBinding.f418635j.setText(String.valueOf(price.f440315d));
    }
}

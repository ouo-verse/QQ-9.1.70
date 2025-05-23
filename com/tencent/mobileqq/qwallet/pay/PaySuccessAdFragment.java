package com.tencent.mobileqq.qwallet.pay;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qwallet.ad.AdEvent;
import com.tencent.mobileqq.qwallet.ad.BaseGdtAdView;
import com.tencent.mobileqq.qwallet.ad.PaySuccessAdView;
import com.tencent.mobileqq.qwallet.pay.FinanceAdInfo;
import com.tencent.mobileqq.qwallet.pay.recommend.PaySuccessRecommendAdRecyclerView;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.util.TenUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.qqwallet.PaySuccessAd$GetAdRsp;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pay/PaySuccessAdFragment;", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "", "yh", "xh", "Ah", "", "isStatusBarImmersive", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onResume", "onBackEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/qwallet/pay/PaySuccessAdViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Bh", "()Lcom/tencent/mobileqq/qwallet/pay/PaySuccessAdViewModel;", "viewModel", "D", "Landroid/view/View;", "noAdSpace", "E", "bottomAdContainer", "Lcom/tencent/mobileqq/qwallet/ad/PaySuccessAdView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qwallet/ad/PaySuccessAdView;", "gdtAdView", "Lcom/tencent/mobileqq/qwallet/pay/PaySuccessFinanceAdView;", "G", "Lcom/tencent/mobileqq/qwallet/pay/PaySuccessFinanceAdView;", "financeAdView", "Lcom/tencent/mobileqq/qwallet/pay/recommend/PaySuccessRecommendAdRecyclerView;", "H", "Lcom/tencent/mobileqq/qwallet/pay/recommend/PaySuccessRecommendAdRecyclerView;", "middleRecommendAdView", "<init>", "()V", "I", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PaySuccessAdFragment extends QWalletBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private View noAdSpace;

    /* renamed from: E, reason: from kotlin metadata */
    private View bottomAdContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private PaySuccessAdView gdtAdView;

    /* renamed from: G, reason: from kotlin metadata */
    private PaySuccessFinanceAdView financeAdView;

    /* renamed from: H, reason: from kotlin metadata */
    private PaySuccessRecommendAdRecyclerView middleRecommendAdView;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f278636a;

        static {
            int[] iArr = new int[EnumAdType.values().length];
            try {
                iArr[EnumAdType.AMS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumAdType.FINANCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumAdType.OP_RECOMMEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f278636a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qwallet/pay/PaySuccessAdFragment$c", "Lcom/tencent/mobileqq/qwallet/ad/BaseGdtAdView$a;", "Lcom/tencent/mobileqq/qwallet/ad/AdEvent;", "event", "", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements BaseGdtAdView.a {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes16.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f278638a;

            static {
                int[] iArr = new int[AdEvent.values().length];
                try {
                    iArr[AdEvent.CLICK.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AdEvent.RENDERED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f278638a = iArr;
            }
        }

        c() {
        }

        @Override // com.tencent.mobileqq.qwallet.ad.BaseGdtAdView.a
        public void a(@NotNull AdEvent event) {
            Integer num;
            String str;
            String str2;
            String str3;
            String str4;
            Intrinsics.checkNotNullParameter(event, "event");
            int i3 = a.f278638a[event.ordinal()];
            String str5 = null;
            if (i3 != 1) {
                if (i3 != 2) {
                    num = null;
                    str = null;
                } else {
                    num = 101;
                    str = "qqpay.success.adshow";
                }
            } else {
                num = 102;
                str = "qqpay.success.adclick";
            }
            if (str != null) {
                PaySuccessAdFragment paySuccessAdFragment = PaySuccessAdFragment.this;
                PaySuccessAdViewModel Bh = paySuccessAdFragment.Bh();
                FinanceAdInfo U1 = paySuccessAdFragment.Bh().U1();
                if (U1 != null) {
                    str3 = U1.getId();
                } else {
                    str3 = null;
                }
                String valueOf = String.valueOf(str3);
                FinanceAdInfo U12 = paySuccessAdFragment.Bh().U1();
                if (U12 != null) {
                    str4 = U12.getTitle();
                } else {
                    str4 = null;
                }
                Bh.h2(str, valueOf, str4, FinanceAdInfo.EnumAdType.FINANCE.ordinal());
            }
            if (num != null) {
                PaySuccessAdFragment paySuccessAdFragment2 = PaySuccessAdFragment.this;
                num.intValue();
                FinanceAdInfo U13 = paySuccessAdFragment2.Bh().U1();
                if (U13 != null) {
                    str2 = U13.getId();
                } else {
                    str2 = null;
                }
                FinanceAdInfo U14 = paySuccessAdFragment2.Bh().U1();
                if (U14 != null) {
                    str5 = U14.getTraceInfo();
                }
                com.tencent.mobileqq.qwallet.pay.a.c(str2, str5, num.intValue());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qwallet/pay/PaySuccessAdFragment$d", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d extends ViewOutlineProvider {
        d() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@Nullable View view, @Nullable Outline outline) {
            if (view != null && outline != null) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 16.0f);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qwallet/pay/PaySuccessAdFragment$e", "Lcom/tencent/mobileqq/qwallet/ad/BaseGdtAdView$a;", "Lcom/tencent/mobileqq/qwallet/ad/AdEvent;", "event", "", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class e implements BaseGdtAdView.a {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes16.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f278640a;

            static {
                int[] iArr = new int[AdEvent.values().length];
                try {
                    iArr[AdEvent.DISMISS.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AdEvent.CLICK.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AdEvent.RENDERED.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f278640a = iArr;
            }
        }

        e() {
        }

        @Override // com.tencent.mobileqq.qwallet.ad.BaseGdtAdView.a
        public void a(@NotNull AdEvent event) {
            String str;
            Long l3;
            Intrinsics.checkNotNullParameter(event, "event");
            int i3 = a.f278640a[event.ordinal()];
            String str2 = null;
            if (i3 == 1) {
                PaySuccessAdView paySuccessAdView = PaySuccessAdFragment.this.gdtAdView;
                if (paySuccessAdView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gdtAdView");
                    paySuccessAdView = null;
                }
                paySuccessAdView.setVisibility(8);
                PaySuccessFinanceAdView paySuccessFinanceAdView = PaySuccessAdFragment.this.financeAdView;
                if (paySuccessFinanceAdView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("financeAdView");
                    paySuccessFinanceAdView = null;
                }
                paySuccessFinanceAdView.setVisibility(8);
                str = "qqpay.success.unlike";
            } else if (i3 != 2) {
                if (i3 != 3) {
                    str = null;
                } else {
                    str = "qqpay.success.adshow";
                }
            } else {
                str = "qqpay.success.adclick";
            }
            if (str != null) {
                PaySuccessAdFragment paySuccessAdFragment = PaySuccessAdFragment.this;
                PaySuccessAdViewModel Bh = paySuccessAdFragment.Bh();
                GdtAd W1 = paySuccessAdFragment.Bh().W1();
                if (W1 != null) {
                    l3 = Long.valueOf(W1.getAId());
                } else {
                    l3 = null;
                }
                String valueOf = String.valueOf(l3);
                GdtAd W12 = paySuccessAdFragment.Bh().W1();
                if (W12 != null) {
                    str2 = W12.getText();
                }
                Bh.h2(str, valueOf, str2, FinanceAdInfo.EnumAdType.AMS.ordinal());
            }
        }
    }

    public PaySuccessAdFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<PaySuccessAdViewModel>() { // from class: com.tencent.mobileqq.qwallet.pay.PaySuccessAdFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PaySuccessAdViewModel invoke() {
                return (PaySuccessAdViewModel) new ViewModelProvider(PaySuccessAdFragment.this.getQBaseActivity()).get(PaySuccessAdViewModel.class);
            }
        });
        this.viewModel = lazy;
    }

    private final void Ah() {
        String str;
        Intent intent = getIntent();
        if (intent != null) {
            str = intent.getStringExtra("KEY_FINISH_SCHEME_URL");
        } else {
            str = null;
        }
        com.tencent.mobileqq.qwallet.utils.k.f279288a.a(str);
        Bh().P1();
        Bh().c2();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaySuccessAdViewModel Bh() {
        return (PaySuccessAdViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(PaySuccessAdFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = this$0.getIntent();
        long j3 = 0;
        if (intent != null) {
            j3 = intent.getLongExtra("prossesId", 0L);
        }
        TenUtils.notifyToExit(this$0.getContext(), j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(PaySuccessAdFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ah();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(PaySuccessAdFragment this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Bh().j2(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(CheckBox checkBox, PaySuccessAdFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("PaySuccessAdFragment", 1, "onViewCreated: paNamesLiveData new value " + str);
        checkBox.setVisibility(0);
        checkBox.setText(str);
        checkBox.setChecked(this$0.Bh().getIsUnfollowedManually());
    }

    private final void xh() {
        ConstraintLayout constraintLayout;
        float f16;
        View view = getView();
        View view2 = null;
        if (view instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout) view;
        } else {
            constraintLayout = null;
        }
        if (constraintLayout == null) {
            return;
        }
        if (com.tencent.mobileqq.qwallet.d.f277142a.c()) {
            f16 = 0.6f;
        } else {
            f16 = 1.0f;
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        View view3 = this.bottomAdContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomAdContainer");
        } else {
            view2 = view3;
        }
        constraintSet.constrainPercentWidth(view2.getId(), f16);
        constraintSet.applyTo(constraintLayout);
    }

    private final void yh() {
        Bh().R1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qwallet.pay.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PaySuccessAdFragment.zh(PaySuccessAdFragment.this, (PaySuccessAd$GetAdRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(PaySuccessAdFragment this$0, PaySuccessAd$GetAdRsp paySuccessAd$GetAdRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = null;
        if (paySuccessAd$GetAdRsp == null) {
            View view2 = this$0.noAdSpace;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noAdSpace");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            return;
        }
        int i3 = b.f278636a[EnumAdType.INSTANCE.a(paySuccessAd$GetAdRsp.ad_type.get()).ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    View view3 = this$0.bottomAdContainer;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bottomAdContainer");
                        view3 = null;
                    }
                    view3.setVisibility(8);
                    View view4 = this$0.noAdSpace;
                    if (view4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("noAdSpace");
                    } else {
                        view = view4;
                    }
                    view.setVisibility(0);
                    return;
                }
                View view5 = this$0.bottomAdContainer;
                if (view5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomAdContainer");
                    view5 = null;
                }
                view5.setVisibility(8);
                PaySuccessRecommendAdRecyclerView paySuccessRecommendAdRecyclerView = this$0.middleRecommendAdView;
                if (paySuccessRecommendAdRecyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("middleRecommendAdView");
                    paySuccessRecommendAdRecyclerView = null;
                }
                paySuccessRecommendAdRecyclerView.setVisibility(0);
                PaySuccessRecommendAdRecyclerView paySuccessRecommendAdRecyclerView2 = this$0.middleRecommendAdView;
                if (paySuccessRecommendAdRecyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("middleRecommendAdView");
                    paySuccessRecommendAdRecyclerView2 = null;
                }
                paySuccessRecommendAdRecyclerView2.z0(this$0, paySuccessAd$GetAdRsp.qpay_ads);
                View view6 = this$0.noAdSpace;
                if (view6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("noAdSpace");
                } else {
                    view = view6;
                }
                view.setVisibility(8);
                return;
            }
            FinanceAdInfo a16 = a.a(paySuccessAd$GetAdRsp);
            PaySuccessFinanceAdView paySuccessFinanceAdView = this$0.financeAdView;
            if (paySuccessFinanceAdView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("financeAdView");
                paySuccessFinanceAdView = null;
            }
            if (paySuccessFinanceAdView.C0(a16)) {
                View view7 = this$0.bottomAdContainer;
                if (view7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomAdContainer");
                    view7 = null;
                }
                view7.setVisibility(0);
                PaySuccessRecommendAdRecyclerView paySuccessRecommendAdRecyclerView3 = this$0.middleRecommendAdView;
                if (paySuccessRecommendAdRecyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("middleRecommendAdView");
                    paySuccessRecommendAdRecyclerView3 = null;
                }
                paySuccessRecommendAdRecyclerView3.setVisibility(8);
                PaySuccessAdView paySuccessAdView = this$0.gdtAdView;
                if (paySuccessAdView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gdtAdView");
                    paySuccessAdView = null;
                }
                paySuccessAdView.setVisibility(8);
                PaySuccessFinanceAdView paySuccessFinanceAdView2 = this$0.financeAdView;
                if (paySuccessFinanceAdView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("financeAdView");
                    paySuccessFinanceAdView2 = null;
                }
                paySuccessFinanceAdView2.setVisibility(0);
            } else {
                View view8 = this$0.bottomAdContainer;
                if (view8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomAdContainer");
                    view8 = null;
                }
                view8.setVisibility(8);
            }
            View view9 = this$0.noAdSpace;
            if (view9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noAdSpace");
            } else {
                view = view9;
            }
            view.setVisibility(8);
            return;
        }
        GdtAd b16 = a.b(paySuccessAd$GetAdRsp);
        PaySuccessAdView paySuccessAdView2 = this$0.gdtAdView;
        if (paySuccessAdView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gdtAdView");
            paySuccessAdView2 = null;
        }
        if (paySuccessAdView2.d1(b16, this$0.getActivity())) {
            View view10 = this$0.bottomAdContainer;
            if (view10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomAdContainer");
                view10 = null;
            }
            view10.setVisibility(0);
            PaySuccessRecommendAdRecyclerView paySuccessRecommendAdRecyclerView4 = this$0.middleRecommendAdView;
            if (paySuccessRecommendAdRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("middleRecommendAdView");
                paySuccessRecommendAdRecyclerView4 = null;
            }
            paySuccessRecommendAdRecyclerView4.setVisibility(8);
            PaySuccessAdView paySuccessAdView3 = this$0.gdtAdView;
            if (paySuccessAdView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gdtAdView");
                paySuccessAdView3 = null;
            }
            paySuccessAdView3.setVisibility(0);
            PaySuccessFinanceAdView paySuccessFinanceAdView3 = this$0.financeAdView;
            if (paySuccessFinanceAdView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("financeAdView");
                paySuccessFinanceAdView3 = null;
            }
            paySuccessFinanceAdView3.setVisibility(8);
            PaySuccessAdView paySuccessAdView4 = this$0.gdtAdView;
            if (paySuccessAdView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gdtAdView");
                paySuccessAdView4 = null;
            }
            BaseGdtAdView.I0(paySuccessAdView4, b16, null, 2, null);
        } else {
            View view11 = this$0.bottomAdContainer;
            if (view11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomAdContainer");
                view11 = null;
            }
            view11.setVisibility(8);
        }
        View view12 = this$0.noAdSpace;
        if (view12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noAdSpace");
        } else {
            view = view12;
        }
        view.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarImmersive() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Bh().P1();
        Bh().c2();
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        xh();
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pk2.a.c();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (Bh().d2()) {
            TenUtils.notifyToExit(getContext(), Bh().getProcessId());
            Bh().c2();
            finish();
        }
        if (!Bh().getIsShowSuccessPage()) {
            Bundle bundle = new Bundle();
            bundle.putString("data", Bh().getSuccessData());
            Intent intent = new Intent(Cgi.BROADCAST_INTENT_ACTION_PAYSUCC);
            intent.putExtra("retData", bundle);
            activity.sendBroadcast(intent);
            finish();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.hhp, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QLog.d("PaySuccessAdFragment", 1, "onDestroy: ");
        pk2.a.a();
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Bh().h2("qqpay.success.show", "", "", 0);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((TextView) view.findViewById(R.id.tzp)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.pay.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PaySuccessAdFragment.Dh(PaySuccessAdFragment.this, view2);
            }
        });
        View findViewById = view.findViewById(R.id.zrn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.no_ad_space)");
        this.noAdSpace = findViewById;
        View findViewById2 = view.findViewById(R.id.f228404t);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.pay_success_ad_container)");
        this.bottomAdContainer = findViewById2;
        xh();
        View findViewById3 = view.findViewById(R.id.f228704w);
        PaySuccessFinanceAdView paySuccessFinanceAdView = (PaySuccessFinanceAdView) findViewById3;
        paySuccessFinanceAdView.setAdEventCallback(new c());
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById<PaySuc\u2026}\n            }\n        }");
        this.financeAdView = paySuccessFinanceAdView;
        View findViewById4 = view.findViewById(R.id.f228504u);
        PaySuccessAdView paySuccessAdView = (PaySuccessAdView) findViewById4;
        paySuccessAdView.setOutlineProvider(new d());
        paySuccessAdView.setClipToOutline(true);
        paySuccessAdView.setAdEventCallback(new e());
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById<PaySuc\u2026}\n            }\n        }");
        this.gdtAdView = paySuccessAdView;
        View findViewById5 = view.findViewById(R.id.f228904y);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.p\u2026uccess_recommend_ad_view)");
        this.middleRecommendAdView = (PaySuccessRecommendAdRecyclerView) findViewById5;
        ((TextView) view.findViewById(R.id.z4w)).setText(Bh().getMerchandiseTitle());
        TextView textView = (TextView) view.findViewById(R.id.z4v);
        textView.setTypeface(Typeface.createFromAsset(getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH));
        textView.setText(Bh().T1());
        final CheckBox checkBox = (CheckBox) view.findViewById(R.id.vcv);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.qwallet.pay.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                PaySuccessAdFragment.Eh(PaySuccessAdFragment.this, compoundButton, z16);
            }
        });
        Bh().Z1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qwallet.pay.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PaySuccessAdFragment.Fh(checkBox, this, (String) obj);
            }
        });
        Bh().g2();
        view.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.pay.e
            @Override // java.lang.Runnable
            public final void run() {
                PaySuccessAdFragment.Ch(PaySuccessAdFragment.this);
            }
        });
        yh();
        Bh().initData();
    }
}

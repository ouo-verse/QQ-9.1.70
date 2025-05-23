package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.annotation.SuppressLint;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi;
import com.tencent.mobileqq.qwallet.hb.send.model.SendFestivalHbViewModel;
import com.tencent.mobileqq.qwallet.hb.view.FestivalHbPagView;
import com.tencent.mobileqq.qwallet.hb.view.RollNumberView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tk2.FestivalHbData;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 92\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\u0014\u0010\f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0014\u0010\u000e\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\r\u001a\u00020\nH\u0002J\f\u0010\u000f\u001a\u00020\u0004*\u00020\u0004H\u0002J\u0014\u0010\u0012\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0003J\u0014\u0010\u0015\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J$\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0017J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0002H\u0016R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u0010!\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/send/impl/SendFestivalHbFragment;", "Lcom/tencent/mobileqq/qwallet/hb/send/impl/BaseHbFragment;", "", "Lh", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initView", "", "fromUser", "close", "", "radius", "makeCorner", "scale", "adjustSize", "loadEnterAnim", "", "url", "Uh", "", "size", "expandTouch", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "onBackEvent", "onDestroyView", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "tvHbWish", "Lcom/tencent/mobileqq/qwallet/hb/view/RollNumberView;", "L", "Lcom/tencent/mobileqq/qwallet/hb/view/RollNumberView;", "rollHbAmount", "Lcom/tencent/mobileqq/qwallet/hb/view/FestivalHbPagView;", "M", "Lcom/tencent/mobileqq/qwallet/hb/view/FestivalHbPagView;", "animBgView", "N", "animFgView", "Lcom/tencent/mobileqq/qwallet/hb/send/model/SendFestivalHbViewModel;", "P", "Lcom/tencent/mobileqq/qwallet/hb/send/model/SendFestivalHbViewModel;", "hbVM", "Lcom/tencent/mobileqq/qwallet/hb/IQWalletFestivalHbApi;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/qwallet/hb/IQWalletFestivalHbApi;", "hbApi", BdhLogUtil.LogTag.Tag_Req, "tvAmountUnit", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class SendFestivalHbFragment extends BaseHbFragment {

    /* renamed from: K, reason: from kotlin metadata */
    private TextView tvHbWish;

    /* renamed from: L, reason: from kotlin metadata */
    private RollNumberView rollHbAmount;

    /* renamed from: M, reason: from kotlin metadata */
    private FestivalHbPagView animBgView;

    /* renamed from: N, reason: from kotlin metadata */
    private FestivalHbPagView animFgView;

    /* renamed from: P, reason: from kotlin metadata */
    private SendFestivalHbViewModel hbVM;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final IQWalletFestivalHbApi hbApi;

    /* renamed from: R, reason: from kotlin metadata */
    private TextView tvAmountUnit;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qwallet/hb/send/impl/SendFestivalHbFragment$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f277686a;

        b(float f16) {
            this.f277686a = f16;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f277686a);
        }
    }

    public SendFestivalHbFragment() {
        QRouteApi api = QRoute.api(IQWalletFestivalHbApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQWalletFestivalHbApi::class.java)");
        this.hbApi = (IQWalletFestivalHbApi) api;
    }

    private final void Lh() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        SendFestivalHbViewModel it = (SendFestivalHbViewModel) new ViewModelProvider(this).get(SendFestivalHbViewModel.class);
        LiveData<Float> amountLiveData = it.getAmountLiveData();
        final Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.SendFestivalHbFragment$initHbVM$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f16) {
                invoke2(f16);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Float f16) {
                TextView textView;
                RollNumberView rollNumberView;
                RollNumberView rollNumberView2;
                textView = SendFestivalHbFragment.this.tvAmountUnit;
                RollNumberView rollNumberView3 = null;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvAmountUnit");
                    textView = null;
                }
                textView.setVisibility(0);
                rollNumberView = SendFestivalHbFragment.this.rollHbAmount;
                if (rollNumberView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rollHbAmount");
                    rollNumberView = null;
                }
                rollNumberView.f(Double.parseDouble(String.valueOf(f16)));
                rollNumberView2 = SendFestivalHbFragment.this.rollHbAmount;
                if (rollNumberView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rollHbAmount");
                } else {
                    rollNumberView3 = rollNumberView2;
                }
                rollNumberView3.g();
            }
        };
        amountLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SendFestivalHbFragment.Mh(Function1.this, obj);
            }
        });
        LiveData<String> wishLiveData = it.getWishLiveData();
        final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.SendFestivalHbFragment$initHbVM$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str) {
                TextView textView;
                TextView textView2;
                TextView textView3;
                textView = SendFestivalHbFragment.this.tvHbWish;
                TextView textView4 = null;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvHbWish");
                    textView = null;
                }
                textView.setText(str);
                textView2 = SendFestivalHbFragment.this.tvHbWish;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvHbWish");
                    textView2 = null;
                }
                textView2.setAlpha(0.0f);
                textView3 = SendFestivalHbFragment.this.tvHbWish;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvHbWish");
                } else {
                    textView4 = textView3;
                }
                textView4.animate().alpha(1.0f).setDuration(1500L).start();
            }
        };
        wishLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.aa
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SendFestivalHbFragment.Nh(Function1.this, obj);
            }
        });
        LiveData<FestivalHbData.Anim> animLiveData = it.getAnimLiveData();
        final Function1<FestivalHbData.Anim, Unit> function13 = new Function1<FestivalHbData.Anim, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.SendFestivalHbFragment$initHbVM$1$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FestivalHbData.Anim anim) {
                invoke2(anim);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FestivalHbData.Anim it5) {
                IQWalletFestivalHbApi iQWalletFestivalHbApi;
                FestivalHbPagView festivalHbPagView;
                FestivalHbPagView festivalHbPagView2;
                iQWalletFestivalHbApi = SendFestivalHbFragment.this.hbApi;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                festivalHbPagView = SendFestivalHbFragment.this.animBgView;
                FestivalHbPagView festivalHbPagView3 = null;
                if (festivalHbPagView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("animBgView");
                    festivalHbPagView = null;
                }
                festivalHbPagView2 = SendFestivalHbFragment.this.animFgView;
                if (festivalHbPagView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("animFgView");
                } else {
                    festivalHbPagView3 = festivalHbPagView2;
                }
                iQWalletFestivalHbApi.playPagAnim(it5, festivalHbPagView, festivalHbPagView3);
            }
        };
        animLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SendFestivalHbFragment.Oh(Function1.this, obj);
            }
        });
        LiveData<Boolean> closeLiveData = it.getCloseLiveData();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.SendFestivalHbFragment$initHbVM$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it5) {
                SendFestivalHbFragment sendFestivalHbFragment = SendFestivalHbFragment.this;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                sendFestivalHbFragment.close(it5.booleanValue());
            }
        };
        closeLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.ac
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SendFestivalHbFragment.Ph(Function1.this, obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this.hbVM = it;
        if (it == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hbVM");
            it = null;
        }
        Bundle requireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
        it.init(requireArguments);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(SendFestivalHbFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SendFestivalHbViewModel sendFestivalHbViewModel = this$0.hbVM;
        if (sendFestivalHbViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hbVM");
            sendFestivalHbViewModel = null;
        }
        SendFestivalHbViewModel.U1(sendFestivalHbViewModel, false, 1, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(SendFestivalHbFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SendFestivalHbViewModel sendFestivalHbViewModel = this$0.hbVM;
        if (sendFestivalHbViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hbVM");
            sendFestivalHbViewModel = null;
        }
        SendFestivalHbViewModel.U1(sendFestivalHbViewModel, false, 1, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(SendFestivalHbFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SendFestivalHbViewModel sendFestivalHbViewModel = this$0.hbVM;
        if (sendFestivalHbViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hbVM");
            sendFestivalHbViewModel = null;
        }
        SendFestivalHbViewModel.U1(sendFestivalHbViewModel, false, 1, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final View Uh(View view, String str) {
        Drawable drawable = view.getResources().getDrawable(R.color.f157605ca0);
        view.setBackground(QWalletPicHelper.getNetDrawableForQWallet(str, drawable, drawable, new Bundle()));
        return view;
    }

    private final View adjustSize(View view, float f16) {
        int coerceAtMost;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.hbApi.getCurrentScreenWidth() - (ViewUtils.dpToPx(31.5f) * 2), ViewUtils.dpToPx(365.0f));
        layoutParams.width = coerceAtMost;
        layoutParams.height = (int) (coerceAtMost * f16);
        view.setLayoutParams(layoutParams);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void close(boolean fromUser) {
        if (!fromUser) {
            QQToast.makeText(getActivity(), R.string.taz, 0).show();
        }
        this.D.cancelCallBack();
        this.D.finish();
        this.D.overridePendingTransition(0, 0);
    }

    private final View expandTouch(View view, int i3) {
        BaseAIOUtils.g(view, i3);
        return view;
    }

    private final void initView(View rootView) {
        ImageView ivOutClose = (ImageView) rootView.findViewById(R.id.dum);
        ivOutClose.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendFestivalHbFragment.Th(SendFestivalHbFragment.this, view);
            }
        });
        ImageView ivInClose = (ImageView) rootView.findViewById(R.id.y1n);
        ivInClose.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendFestivalHbFragment.Qh(SendFestivalHbFragment.this, view);
            }
        });
        IQWalletFestivalHbApi iQWalletFestivalHbApi = this.hbApi;
        Intrinsics.checkNotNullExpressionValue(ivOutClose, "ivOutClose");
        Intrinsics.checkNotNullExpressionValue(ivInClose, "ivInClose");
        iQWalletFestivalHbApi.adjustClosePosition(ivOutClose, ivInClose);
        rootView.findViewById(R.id.idg).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendFestivalHbFragment.Rh(SendFestivalHbFragment.this, view);
            }
        });
        View findViewById = rootView.findViewById(R.id.f75353yq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(R.id.rl_bg_layout)");
        loadEnterAnim(findViewById);
        View findViewById2 = rootView.findViewById(R.id.f75383yt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<View>(R.id.rl_change_layout)");
        com.tencent.mobileqq.qwallet.k.d(expandTouch(findViewById2, ViewUtils.dpToPx(10.0f)), 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.SendFestivalHbFragment$initView$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
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
                SendFestivalHbViewModel sendFestivalHbViewModel;
                sendFestivalHbViewModel = SendFestivalHbFragment.this.hbVM;
                if (sendFestivalHbViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("hbVM");
                    sendFestivalHbViewModel = null;
                }
                sendFestivalHbViewModel.T1(false);
            }
        }, 1, null);
        View findViewById3 = rootView.findViewById(R.id.tgn);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<View>(R.id.btn_send_hb)");
        com.tencent.mobileqq.qwallet.k.c(makeCorner(findViewById3, ViewUtils.dpToPx(4.0f)), 2000L, new Function0<Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.SendFestivalHbFragment$initView$1$3
            /* JADX INFO: Access modifiers changed from: package-private */
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
                SendFestivalHbViewModel sendFestivalHbViewModel;
                sendFestivalHbViewModel = SendFestivalHbFragment.this.hbVM;
                if (sendFestivalHbViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("hbVM");
                    sendFestivalHbViewModel = null;
                }
                bl2.g mLogic = SendFestivalHbFragment.this.F;
                Intrinsics.checkNotNullExpressionValue(mLogic, "mLogic");
                Map<String, String> mapPacketExtra = SendFestivalHbFragment.this.D.getMapPacketExtra();
                Intrinsics.checkNotNullExpressionValue(mapPacketExtra, "mActivity.mapPacketExtra");
                sendFestivalHbViewModel.W1(mLogic, mapPacketExtra);
            }
        });
        View findViewById4 = rootView.findViewById(R.id.f75633zh);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById<View>(R.id.rl_hb_view)");
        Uh(adjustSize(makeCorner(findViewById4, ViewUtils.dpToPx(16.0f)), 1.75f), "https://i.qianbao.qq.com/act/hbImage/dist/bg.png").setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendFestivalHbFragment.Sh(view);
            }
        });
        View findViewById5 = rootView.findViewById(R.id.y46);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.iv_hb_anim_bg)");
        this.animBgView = (FestivalHbPagView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.y47);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.iv_hb_anim_fg)");
        this.animFgView = (FestivalHbPagView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.f167049md2);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.tv_hb_wish)");
        this.tvHbWish = (TextView) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.f779445q);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.roll_number_amount)");
        this.rollHbAmount = (RollNumberView) findViewById8;
        View findViewById9 = rootView.findViewById(R.id.f1059867h);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.tv_amount_unit)");
        this.tvAmountUnit = (TextView) findViewById9;
    }

    private final View loadEnterAnim(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.f154871sv));
        return view;
    }

    private final View makeCorner(View view, float f16) {
        view.setOutlineProvider(new b(f16));
        view.setClipToOutline(true);
        return view;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        super.onBackEvent();
        SendFestivalHbViewModel sendFestivalHbViewModel = this.hbVM;
        if (sendFestivalHbViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hbVM");
            sendFestivalHbViewModel = null;
        }
        SendFestivalHbViewModel.U1(sendFestivalHbViewModel, false, 1, null);
        return true;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.send.impl.BaseHbFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @SuppressLint({"InflateParams"})
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        View inflate = inflater.inflate(R.layout.hgp, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "this");
        initView(inflate);
        Lh();
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026     initHbVM()\n        }");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SendFestivalHbViewModel sendFestivalHbViewModel = this.hbVM;
        if (sendFestivalHbViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hbVM");
            sendFestivalHbViewModel = null;
        }
        sendFestivalHbViewModel.onDestroy();
    }
}

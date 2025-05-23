package com.tenpay.sdk.grab;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qwallet.hb.IQWalletFestivalHbApi;
import com.tencent.mobileqq.qwallet.hb.view.FestivalHbPagView;
import com.tencent.mobileqq.qwallet.hb.view.RollNumberView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tk2.FestivalHbData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 T2\u00020\u0001:\u0001TB\u0007\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0003J\u0014\u0010\u0013\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0014\u0010\u0015\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\f\u0010\u0016\u001a\u00020\u000e*\u00020\u000eH\u0002J\u001c\u0010\u001a\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0003J\u0014\u0010\u001d\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H\u0002J$\u0010,\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010+\u001a\u0004\u0018\u00010*H\u0017J\b\u0010-\u001a\u00020#H\u0016J\b\u0010.\u001a\u00020\u0002H\u0016J\b\u0010/\u001a\u00020#H\u0016R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010>R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010C\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u00108R\u0016\u0010D\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u00108R\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010GR\u0016\u0010I\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u00108R\u0016\u0010J\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010BR\u0016\u0010K\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010BR\u0018\u0010M\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0014\u0010P\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u00a8\u0006U"}, d2 = {"Lcom/tenpay/sdk/grab/GrabFestivalHbFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "initVM", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "initSenderVM", "intHbVM", "Ltk2/a$a;", EventKey.ACT, "updateActivity", "", "wish", "updateWish", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initView", "", "radius", "makeCorner", "scale", "adjustSize", "loadEnterAnim", "url", "Landroid/graphics/drawable/Drawable;", "loadingDrawable", "loadBg", "", "size", "expandTouch", "amount", "playTextAnim", "Lorg/json/JSONObject;", "sendObj", "updateUiOnOverdue", "", "fromUser", "close", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "onBackEvent", "onDestroyView", "needImmersive", "Lcom/tenpay/sdk/grab/GrabFestivalHbViewModel;", "hbVM", "Lcom/tenpay/sdk/grab/GrabFestivalHbViewModel;", "Lcom/tenpay/sdk/grab/HbSenderViewModel;", "senderVM", "Lcom/tenpay/sdk/grab/HbSenderViewModel;", "Landroid/widget/TextView;", "tvHbWish", "Landroid/widget/TextView;", "Lcom/tencent/mobileqq/qwallet/hb/view/RollNumberView;", "rollHbAmount", "Lcom/tencent/mobileqq/qwallet/hb/view/RollNumberView;", "Lcom/tencent/mobileqq/qwallet/hb/view/FestivalHbPagView;", "animBgView", "Lcom/tencent/mobileqq/qwallet/hb/view/FestivalHbPagView;", "animFgView", "Landroid/widget/ImageView;", "ivBottomLogo", "Landroid/widget/ImageView;", "tvBottomTip", "tvAmountUnit", "Landroid/widget/LinearLayout;", "llHbOverdue", "Landroid/widget/LinearLayout;", "llBottom", "tvSenderInfo", "ivSenderAvatar", "ivBottomArrow", "Ltk2/a$b;", "currentAnim", "Ltk2/a$b;", "Lcom/tencent/mobileqq/qwallet/hb/IQWalletFestivalHbApi;", "hbApi", "Lcom/tencent/mobileqq/qwallet/hb/IQWalletFestivalHbApi;", "<init>", "()V", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class GrabFestivalHbFragment extends QPublicBaseFragment {

    @NotNull
    private static final String TAG = "QWallet.Festival.GrabFestivalHbFragment";
    private FestivalHbPagView animBgView;
    private FestivalHbPagView animFgView;

    @Nullable
    private FestivalHbData.Anim currentAnim;

    @NotNull
    private final IQWalletFestivalHbApi hbApi;
    private GrabFestivalHbViewModel hbVM;
    private ImageView ivBottomArrow;
    private ImageView ivBottomLogo;
    private ImageView ivSenderAvatar;
    private LinearLayout llBottom;
    private LinearLayout llHbOverdue;
    private RollNumberView rollHbAmount;
    private HbSenderViewModel senderVM;
    private TextView tvAmountUnit;
    private TextView tvBottomTip;
    private TextView tvHbWish;
    private TextView tvSenderInfo;

    public GrabFestivalHbFragment() {
        QRouteApi api = QRoute.api(IQWalletFestivalHbApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQWalletFestivalHbApi::class.java)");
        this.hbApi = (IQWalletFestivalHbApi) api;
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
        String str;
        if (!fromUser) {
            FragmentActivity activity = getActivity();
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                str = activity2.getString(R.string.f17938398);
            } else {
                str = null;
            }
            QQToast.makeText(activity, str, 0).show();
        }
        FragmentActivity activity3 = getActivity();
        if (activity3 != null) {
            activity3.finish();
        }
        FragmentActivity activity4 = getActivity();
        if (activity4 != null) {
            activity4.overridePendingTransition(0, 0);
        }
    }

    private final View expandTouch(View view, int i3) {
        BaseAIOUtils.g(view, i3);
        return view;
    }

    private final void initSenderVM(LifecycleOwner lifecycleOwner) {
        HbSenderViewModel it = (HbSenderViewModel) new ViewModelProvider(this).get(HbSenderViewModel.class);
        LiveData<Bitmap> sendIconLiveData = it.getSendIconLiveData();
        final Function1<Bitmap, Unit> function1 = new Function1<Bitmap, Unit>() { // from class: com.tenpay.sdk.grab.GrabFestivalHbFragment$initSenderVM$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Bitmap bitmap) {
                ImageView imageView;
                ImageView imageView2;
                imageView = GrabFestivalHbFragment.this.ivSenderAvatar;
                ImageView imageView3 = null;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivSenderAvatar");
                    imageView = null;
                }
                imageView.setImageBitmap(bitmap);
                imageView2 = GrabFestivalHbFragment.this.ivSenderAvatar;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivSenderAvatar");
                } else {
                    imageView3 = imageView2;
                }
                imageView3.setVisibility(0);
            }
        };
        sendIconLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tenpay.sdk.grab.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GrabFestivalHbFragment.initSenderVM$lambda$3$lambda$1(Function1.this, obj);
            }
        });
        LiveData<String> sendTextLiveData = it.getSendTextLiveData();
        final Function1<String, Unit> function12 = new Function1<String, Unit>() { // from class: com.tenpay.sdk.grab.GrabFestivalHbFragment$initSenderVM$1$2
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
            public final void invoke2(String str) {
                TextView textView;
                if (str == null || str.length() == 0) {
                    return;
                }
                textView = GrabFestivalHbFragment.this.tvSenderInfo;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvSenderInfo");
                    textView = null;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = GrabFestivalHbFragment.this.getResources().getString(R.string.f212435ni);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026str_festival_sender_tips)");
                String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                textView.setText(format);
            }
        };
        sendTextLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tenpay.sdk.grab.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GrabFestivalHbFragment.initSenderVM$lambda$3$lambda$2(Function1.this, obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this.senderVM = it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSenderVM$lambda$3$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSenderVM$lambda$3$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initVM() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        intHbVM(viewLifecycleOwner);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        initSenderVM(viewLifecycleOwner2);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final void initView(View rootView) {
        ImageView ivOutClose = (ImageView) rootView.findViewById(R.id.dum);
        ivOutClose.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.grab.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GrabFestivalHbFragment.initView$lambda$20$lambda$15$lambda$14(GrabFestivalHbFragment.this, view);
            }
        });
        ImageView ivInClose = (ImageView) rootView.findViewById(R.id.y1n);
        ivInClose.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.grab.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GrabFestivalHbFragment.initView$lambda$20$lambda$17$lambda$16(GrabFestivalHbFragment.this, view);
            }
        });
        IQWalletFestivalHbApi iQWalletFestivalHbApi = this.hbApi;
        Intrinsics.checkNotNullExpressionValue(ivOutClose, "ivOutClose");
        Intrinsics.checkNotNullExpressionValue(ivInClose, "ivInClose");
        iQWalletFestivalHbApi.adjustClosePosition(ivOutClose, ivInClose);
        rootView.findViewById(R.id.idg).setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.grab.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GrabFestivalHbFragment.initView$lambda$20$lambda$18(GrabFestivalHbFragment.this, view);
            }
        });
        View findViewById = rootView.findViewById(R.id.f75353yq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(R.id.rl_bg_layout)");
        loadEnterAnim(findViewById);
        View findViewById2 = rootView.findViewById(R.id.f75633zh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<View>(R.id.rl_hb_view)");
        View adjustSize = adjustSize(makeCorner(findViewById2, ViewUtils.dpToPx(16.0f)), 1.75f);
        Drawable drawable = rootView.getContext().getDrawable(R.color.f157605ca0);
        Intrinsics.checkNotNull(drawable);
        loadBg(adjustSize, "https://i.qianbao.qq.com/act/hbImage/dist/bg.png", drawable).setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.grab.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GrabFestivalHbFragment.initView$lambda$20$lambda$19(view);
            }
        });
        View findViewById3 = rootView.findViewById(R.id.ecw);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.ll_bottom)");
        LinearLayout linearLayout = (LinearLayout) findViewById3;
        this.llBottom = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llBottom");
            linearLayout = null;
        }
        expandTouch(linearLayout, ViewUtils.dpToPx(10.0f));
        View findViewById4 = rootView.findViewById(R.id.y46);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.iv_hb_anim_bg)");
        this.animBgView = (FestivalHbPagView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.y47);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.iv_hb_anim_fg)");
        this.animFgView = (FestivalHbPagView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.f167049md2);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.tv_hb_wish)");
        this.tvHbWish = (TextView) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.f779445q);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.roll_number_amount)");
        this.rollHbAmount = (RollNumberView) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.y0x);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.iv_bottom_logo)");
        this.ivBottomLogo = (ImageView) findViewById8;
        View findViewById9 = rootView.findViewById(R.id.f1063368f);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.tv_bottom_tip)");
        this.tvBottomTip = (TextView) findViewById9;
        View findViewById10 = rootView.findViewById(R.id.f1059867h);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.tv_amount_unit)");
        this.tvAmountUnit = (TextView) findViewById10;
        View findViewById11 = rootView.findViewById(R.id.yoi);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.ll_hb_overdue)");
        this.llHbOverdue = (LinearLayout) findViewById11;
        View findViewById12 = rootView.findViewById(R.id.f111166kh);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.tv_sender_info)");
        this.tvSenderInfo = (TextView) findViewById12;
        View findViewById13 = rootView.findViewById(R.id.f165966y91);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(R.id.iv_sender_avatar)");
        this.ivSenderAvatar = (ImageView) findViewById13;
        View findViewById14 = rootView.findViewById(R.id.y0v);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(R.id.iv_bottom_arrow)");
        this.ivBottomArrow = (ImageView) findViewById14;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$20$lambda$15$lambda$14(GrabFestivalHbFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GrabFestivalHbViewModel grabFestivalHbViewModel = this$0.hbVM;
        if (grabFestivalHbViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hbVM");
            grabFestivalHbViewModel = null;
        }
        GrabFestivalHbViewModel.onClose$default(grabFestivalHbViewModel, false, 1, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$20$lambda$17$lambda$16(GrabFestivalHbFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GrabFestivalHbViewModel grabFestivalHbViewModel = this$0.hbVM;
        if (grabFestivalHbViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hbVM");
            grabFestivalHbViewModel = null;
        }
        GrabFestivalHbViewModel.onClose$default(grabFestivalHbViewModel, false, 1, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$20$lambda$18(GrabFestivalHbFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GrabFestivalHbViewModel grabFestivalHbViewModel = this$0.hbVM;
        if (grabFestivalHbViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hbVM");
            grabFestivalHbViewModel = null;
        }
        GrabFestivalHbViewModel.onClose$default(grabFestivalHbViewModel, false, 1, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$20$lambda$19(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void intHbVM(LifecycleOwner lifecycleOwner) {
        GrabFestivalHbViewModel it = (GrabFestivalHbViewModel) new ViewModelProvider(this).get(GrabFestivalHbViewModel.class);
        LiveData<String> wishLiveData = it.getWishLiveData();
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tenpay.sdk.grab.GrabFestivalHbFragment$intHbVM$1$1
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
            public final void invoke2(String it5) {
                GrabFestivalHbFragment grabFestivalHbFragment = GrabFestivalHbFragment.this;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                grabFestivalHbFragment.updateWish(it5);
            }
        };
        wishLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tenpay.sdk.grab.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GrabFestivalHbFragment.intHbVM$lambda$11$lambda$5(Function1.this, obj);
            }
        });
        LiveData<Float> amountLiveData = it.getAmountLiveData();
        final Function1<Float, Unit> function12 = new Function1<Float, Unit>() { // from class: com.tenpay.sdk.grab.GrabFestivalHbFragment$intHbVM$1$2
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
            public final void invoke2(Float it5) {
                GrabFestivalHbFragment grabFestivalHbFragment = GrabFestivalHbFragment.this;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                grabFestivalHbFragment.playTextAnim(it5.floatValue());
            }
        };
        amountLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tenpay.sdk.grab.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GrabFestivalHbFragment.intHbVM$lambda$11$lambda$6(Function1.this, obj);
            }
        });
        LiveData<FestivalHbData.Extra> activityLiveData = it.getActivityLiveData();
        final Function1<FestivalHbData.Extra, Unit> function13 = new Function1<FestivalHbData.Extra, Unit>() { // from class: com.tenpay.sdk.grab.GrabFestivalHbFragment$intHbVM$1$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FestivalHbData.Extra extra) {
                invoke2(extra);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FestivalHbData.Extra it5) {
                GrabFestivalHbFragment grabFestivalHbFragment = GrabFestivalHbFragment.this;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                grabFestivalHbFragment.updateActivity(it5);
            }
        };
        activityLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tenpay.sdk.grab.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GrabFestivalHbFragment.intHbVM$lambda$11$lambda$7(Function1.this, obj);
            }
        });
        LiveData<FestivalHbData.Anim> animLiveData = it.getAnimLiveData();
        final Function1<FestivalHbData.Anim, Unit> function14 = new Function1<FestivalHbData.Anim, Unit>() { // from class: com.tenpay.sdk.grab.GrabFestivalHbFragment$intHbVM$1$4
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
                iQWalletFestivalHbApi = GrabFestivalHbFragment.this.hbApi;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                festivalHbPagView = GrabFestivalHbFragment.this.animBgView;
                FestivalHbPagView festivalHbPagView3 = null;
                if (festivalHbPagView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("animBgView");
                    festivalHbPagView = null;
                }
                festivalHbPagView2 = GrabFestivalHbFragment.this.animFgView;
                if (festivalHbPagView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("animFgView");
                } else {
                    festivalHbPagView3 = festivalHbPagView2;
                }
                iQWalletFestivalHbApi.playPagAnim(it5, festivalHbPagView, festivalHbPagView3);
            }
        };
        animLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tenpay.sdk.grab.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GrabFestivalHbFragment.intHbVM$lambda$11$lambda$8(Function1.this, obj);
            }
        });
        LiveData<JSONObject> overdueLiveData = it.getOverdueLiveData();
        final Function1<JSONObject, Unit> function15 = new Function1<JSONObject, Unit>() { // from class: com.tenpay.sdk.grab.GrabFestivalHbFragment$intHbVM$1$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                invoke2(jSONObject);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JSONObject it5) {
                GrabFestivalHbFragment grabFestivalHbFragment = GrabFestivalHbFragment.this;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                grabFestivalHbFragment.updateUiOnOverdue(it5);
            }
        };
        overdueLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tenpay.sdk.grab.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GrabFestivalHbFragment.intHbVM$lambda$11$lambda$9(Function1.this, obj);
            }
        });
        LiveData<Boolean> closeLiveData = it.getCloseLiveData();
        final Function1<Boolean, Unit> function16 = new Function1<Boolean, Unit>() { // from class: com.tenpay.sdk.grab.GrabFestivalHbFragment$intHbVM$1$6
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
                GrabFestivalHbFragment grabFestivalHbFragment = GrabFestivalHbFragment.this;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                grabFestivalHbFragment.close(it5.booleanValue());
            }
        };
        closeLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tenpay.sdk.grab.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GrabFestivalHbFragment.intHbVM$lambda$11$lambda$10(Function1.this, obj);
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
    public static final void intHbVM$lambda$11$lambda$10(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void intHbVM$lambda$11$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void intHbVM$lambda$11$lambda$6(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void intHbVM$lambda$11$lambda$7(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void intHbVM$lambda$11$lambda$8(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void intHbVM$lambda$11$lambda$9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final View loadBg(View view, String str, Drawable drawable) {
        view.setBackground(QWalletPicHelper.getNetDrawableForQWallet(str, drawable, drawable));
        return view;
    }

    private final View loadEnterAnim(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.f154871sv));
        return view;
    }

    private final View makeCorner(View view, final float f16) {
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.tenpay.sdk.grab.GrabFestivalHbFragment$makeCorner$1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(@NotNull View view2, @NotNull Outline outline) {
                Intrinsics.checkNotNullParameter(view2, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f16);
            }
        });
        view.setClipToOutline(true);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playTextAnim(float amount) {
        RollNumberView rollNumberView = this.rollHbAmount;
        TextView textView = null;
        if (rollNumberView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rollHbAmount");
            rollNumberView = null;
        }
        if (amount > 0.0f) {
            rollNumberView.f(Double.parseDouble(String.valueOf(amount)));
            rollNumberView.g();
            TextView textView2 = this.tvAmountUnit;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvAmountUnit");
            } else {
                textView = textView2;
            }
            textView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateActivity(final FestivalHbData.Extra act) {
        boolean z16;
        boolean z17;
        String activityLogo = act.getActivityLogo();
        boolean z18 = true;
        if (activityLogo != null && activityLogo.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        LinearLayout linearLayout = null;
        if (!z16) {
            ImageView imageView = this.ivBottomLogo;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivBottomLogo");
                imageView = null;
            }
            String activityLogo2 = act.getActivityLogo();
            Intrinsics.checkNotNull(activityLogo2);
            Drawable TRANSPARENT = com.tencent.mobileqq.urldrawable.b.f306350a;
            Intrinsics.checkNotNullExpressionValue(TRANSPARENT, "TRANSPARENT");
            loadBg(imageView, activityLogo2, TRANSPARENT).setVisibility(0);
        }
        String activityName = act.getActivityName();
        if (activityName != null && activityName.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            TextView textView = this.tvBottomTip;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvBottomTip");
                textView = null;
            }
            textView.setVisibility(0);
            TextView textView2 = this.tvBottomTip;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvBottomTip");
                textView2 = null;
            }
            textView2.setText(act.getActivityName());
            String activityUrl = act.getActivityUrl();
            if (activityUrl != null && activityUrl.length() != 0) {
                z18 = false;
            }
            if (!z18) {
                ImageView imageView2 = this.ivBottomArrow;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ivBottomArrow");
                    imageView2 = null;
                }
                imageView2.setVisibility(0);
                LinearLayout linearLayout2 = this.llBottom;
                if (linearLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("llBottom");
                } else {
                    linearLayout = linearLayout2;
                }
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.grab.j
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GrabFestivalHbFragment.updateActivity$lambda$13(GrabFestivalHbFragment.this, act, view);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateActivity$lambda$13(GrabFestivalHbFragment this$0, FestivalHbData.Extra act, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(act, "$act");
        GrabFestivalHbViewModel grabFestivalHbViewModel = this$0.hbVM;
        if (grabFestivalHbViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hbVM");
            grabFestivalHbViewModel = null;
        }
        FragmentActivity activity = this$0.getActivity();
        String activityUrl = act.getActivityUrl();
        Intrinsics.checkNotNull(activityUrl);
        grabFestivalHbViewModel.onActivityClick(activity, activityUrl);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUiOnOverdue(JSONObject sendObj) {
        FestivalHbPagView festivalHbPagView = this.animBgView;
        HbSenderViewModel hbSenderViewModel = null;
        if (festivalHbPagView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animBgView");
            festivalHbPagView = null;
        }
        festivalHbPagView.setVisibility(4);
        FestivalHbPagView festivalHbPagView2 = this.animFgView;
        if (festivalHbPagView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("animFgView");
            festivalHbPagView2 = null;
        }
        festivalHbPagView2.setVisibility(4);
        TextView textView = this.tvHbWish;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvHbWish");
            textView = null;
        }
        textView.setVisibility(4);
        RollNumberView rollNumberView = this.rollHbAmount;
        if (rollNumberView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rollHbAmount");
            rollNumberView = null;
        }
        rollNumberView.setVisibility(4);
        LinearLayout linearLayout = this.llBottom;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llBottom");
            linearLayout = null;
        }
        linearLayout.setVisibility(4);
        LinearLayout linearLayout2 = this.llHbOverdue;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llHbOverdue");
            linearLayout2 = null;
        }
        linearLayout2.setVisibility(0);
        HbSenderViewModel hbSenderViewModel2 = this.senderVM;
        if (hbSenderViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("senderVM");
        } else {
            hbSenderViewModel = hbSenderViewModel2;
        }
        String string = requireArguments().getString("grab_group_id");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        hbSenderViewModel.update(sendObj, string, requireActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateWish(String wish) {
        TextView textView = this.tvHbWish;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvHbWish");
            textView = null;
        }
        textView.setText(wish);
        TextView textView3 = this.tvHbWish;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvHbWish");
            textView3 = null;
        }
        textView3.setAlpha(0.0f);
        TextView textView4 = this.tvHbWish;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvHbWish");
        } else {
            textView2 = textView4;
        }
        textView2.animate().alpha(1.0f).setDuration(1500L).start();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        super.onBackEvent();
        GrabFestivalHbViewModel grabFestivalHbViewModel = this.hbVM;
        if (grabFestivalHbViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hbVM");
            grabFestivalHbViewModel = null;
        }
        GrabFestivalHbViewModel.onClose$default(grabFestivalHbViewModel, false, 1, null);
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @SuppressLint({"InflateParams"})
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setBackgroundDrawableResource(R.color.ajr);
        }
        super.onCreateView(inflater, container, savedInstanceState);
        View inflate = inflater.inflate(R.layout.hgo, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "this");
        initView(inflate);
        initVM();
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026       initVM()\n        }");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.hbApi.releasePagAnim();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}

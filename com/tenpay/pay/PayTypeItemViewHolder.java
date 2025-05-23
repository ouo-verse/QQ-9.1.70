package com.tenpay.pay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.api.BankImageUtil;
import com.tenpay.pay.model.PayChannelBean;
import com.tenpay.util.Utils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 B2\u00020\u0001:\u0002BCB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020!H\u0003J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020#H\u0003J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020%H\u0003J\u001e\u0010&\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020-H\u0002J(\u0010.\u001a\u00020\u001d2\b\u0010/\u001a\u0004\u0018\u0001002\b\b\u0002\u00101\u001a\u00020)2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u00103\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u000206H\u0002J\u0010\u00107\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u000208H\u0002JI\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020'2\b\u00101\u001a\u0004\u0018\u00010+2\b\u0010;\u001a\u0004\u0018\u0001002\b\u0010<\u001a\u0004\u0018\u0001002\b\u0010=\u001a\u0004\u0018\u0001002\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?H\u0002\u00a2\u0006\u0002\u0010@J\u0010\u0010A\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0002R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \n*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \n*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n \n*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \n*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \n*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \n*\u0004\u0018\u00010\f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n \n*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \n*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006D"}, d2 = {"Lcom/tenpay/pay/PayTypeItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "fragment", "Landroidx/fragment/app/Fragment;", "contentView", "Landroid/view/View;", "listener", "Lcom/tenpay/pay/PayTypeItemViewHolder$IPayChannelItemClickListener;", "(Landroidx/fragment/app/Fragment;Landroid/view/View;Lcom/tenpay/pay/PayTypeItemViewHolder$IPayChannelItemClickListener;)V", "bottomDiv", "kotlin.jvm.PlatformType", "entryLayout", "Landroid/view/ViewGroup;", "entryLogoView", "Landroid/widget/ImageView;", "entryTitleView", "Landroid/widget/TextView;", "getFragment", "()Landroidx/fragment/app/Fragment;", "getListener", "()Lcom/tenpay/pay/PayTypeItemViewHolder$IPayChannelItemClickListener;", "logoView", "rightArrow", "rightCheckBox", "Landroid/widget/CheckBox;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "subTitleView", "titleView", "setAddMoreData", "", "data", "Lcom/tenpay/pay/model/PayChannelBean$AddMore;", "setAutoPayData", "Lcom/tenpay/pay/model/PayChannelBean$AutoPayCard;", "setBalance", "Lcom/tenpay/pay/model/PayChannelBean$Balance;", "setBankCard", "Lcom/tenpay/pay/model/PayChannelBean$Bank;", "setData", "Lcom/tenpay/pay/model/PayChannelBean;", "isSelected", "", "position", "", "setFriendPayData", "Lcom/tenpay/pay/model/PayChannelBean$FriendPay;", "setImageLogo", "imageId", "", "disable", "imageView", "setMoreData", "Lcom/tenpay/pay/model/PayChannelBean$More;", "setQQHeader", "Lcom/tenpay/pay/model/PayChannelBean$QQHeader;", "setWxData", "Lcom/tenpay/pay/model/PayChannelBean$Wx;", "updateDisableBrief", "payChannelBean", "disableComment", "disableUrl", "disableBrief", "miniApp", "Lcom/tenpay/pay/model/PayChannelBean$MiniApp;", "(Lcom/tenpay/pay/model/PayChannelBean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tenpay/pay/model/PayChannelBean$MiniApp;)Z", "updateSelected", "Companion", "IPayChannelItemClickListener", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PayTypeItemViewHolder extends RecyclerView.ViewHolder {

    @NotNull
    private static final String TAG = "CFT-sdk-PayTypeItemViewHolder";
    private final View bottomDiv;
    private final ViewGroup entryLayout;
    private final ImageView entryLogoView;
    private final TextView entryTitleView;

    @NotNull
    private final Fragment fragment;

    @Nullable
    private final IPayChannelItemClickListener listener;
    private final ImageView logoView;
    private final ImageView rightArrow;
    private final CheckBox rightCheckBox;
    private final ViewGroup rootView;
    private final TextView subTitleView;
    private final TextView titleView;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tenpay/pay/PayTypeItemViewHolder$IPayChannelItemClickListener;", "", "onItemClick", "", "payChannelBean", "Lcom/tenpay/pay/model/PayChannelBean;", "position", "", "onMiniAppClick", "miniApp", "Lcom/tenpay/pay/model/PayChannelBean$MiniApp;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public interface IPayChannelItemClickListener {
        void onItemClick(@NotNull PayChannelBean payChannelBean, int position);

        void onMiniAppClick(@NotNull PayChannelBean payChannelBean, @NotNull PayChannelBean.MiniApp miniApp);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayTypeItemViewHolder(@NotNull Fragment fragment, @NotNull View contentView, @Nullable IPayChannelItemClickListener iPayChannelItemClickListener) {
        super(contentView);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        this.fragment = fragment;
        this.listener = iPayChannelItemClickListener;
        this.rootView = (ViewGroup) contentView.findViewById(R.id.root_layout);
        this.logoView = (ImageView) contentView.findViewById(R.id.f166149eh4);
        this.titleView = (TextView) contentView.findViewById(R.id.title);
        this.entryLayout = (ViewGroup) contentView.findViewById(R.id.f165105by1);
        this.entryLogoView = (ImageView) contentView.findViewById(R.id.uw6);
        this.entryTitleView = (TextView) contentView.findViewById(R.id.uw7);
        this.rightArrow = (ImageView) contentView.findViewById(R.id.i_m);
        this.rightCheckBox = (CheckBox) contentView.findViewById(R.id.f74603wp);
        this.subTitleView = (TextView) contentView.findViewById(R.id.f166931j64);
        this.bottomDiv = contentView.findViewById(R.id.t_i);
        ((Barrier) contentView.findViewById(R.id.f74543wj)).setReferencedIds(new int[]{R.id.i_m, R.id.f74603wp});
    }

    private final void setAddMoreData(PayChannelBean.AddMore data) {
        ViewGroup rootView = this.rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        PayChannelUtils.updateBgRound$default(rootView, data.getBgRadiusEnum(), 0, 4, null);
        this.logoView.setImageResource(data.getLogoResId());
        this.titleView.setText(data.getTitle());
        this.rightArrow.setVisibility(0);
    }

    @SuppressLint({"SetTextI18n"})
    private final void setAutoPayData(final PayChannelBean.AutoPayCard data) {
        if (data.getUin() == null) {
            QLog.w(TAG, 1, "invalid auto pay data: " + data);
            this.itemView.setVisibility(8);
            return;
        }
        this.rightCheckBox.setVisibility(0);
        ((IQWalletNickNameApi) QRoute.api(IQWalletNickNameApi.class)).getNickName(null, data.getUin(), new Function1<String, Unit>() { // from class: com.tenpay.pay.PayTypeItemViewHolder$setAutoPayData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String nick) {
                TextView textView;
                TextView textView2;
                TextView textView3;
                Intrinsics.checkNotNullParameter(nick, "nick");
                if (PayTypeItemViewHolder.this.getFragment().isDetached()) {
                    return;
                }
                String uin = nick.length() == 0 ? data.getUin() : nick;
                Context context = PayTypeItemViewHolder.this.getFragment().getContext();
                float b16 = x.f(PayTypeItemViewHolder.this.getFragment().getContext()).b() / 2;
                textView = PayTypeItemViewHolder.this.titleView;
                String cutTextByPix = Utils.cutTextByPix(context, uin, b16, textView.getPaint());
                textView2 = PayTypeItemViewHolder.this.titleView;
                textView2.setText(cutTextByPix + "-" + data.getBusiName());
                PayTypeItemViewHolder.setImageLogo$default(PayTypeItemViewHolder.this, data.getLogoId(), false, null, 6, null);
                PayTypeItemViewHolder payTypeItemViewHolder = PayTypeItemViewHolder.this;
                PayChannelBean.AutoPayCard autoPayCard = data;
                if (PayTypeItemViewHolder.updateDisableBrief$default(payTypeItemViewHolder, autoPayCard, autoPayCard.getDisable(), data.getDisableComment(), data.getDisableUrl(), data.getDisableBrief(), null, 32, null)) {
                    return;
                }
                String spfaBalance = data.getSpfaBalance();
                if (spfaBalance == null || spfaBalance.length() == 0) {
                    return;
                }
                textView3 = PayTypeItemViewHolder.this.subTitleView;
                PayTypeItemViewHolder payTypeItemViewHolder2 = PayTypeItemViewHolder.this;
                PayChannelBean.AutoPayCard autoPayCard2 = data;
                textView3.setVisibility(0);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = payTypeItemViewHolder2.getFragment().getResources().getString(R.string.f1796639z);
                Intrinsics.checkNotNullExpressionValue(string, "fragment.resources.getSt\u2026.qb_tenpay_remain_amount)");
                Object[] objArr = new Object[1];
                String fen2Yuan = Utils.fen2Yuan(autoPayCard2.getSpfaBalance());
                if (fen2Yuan == null) {
                    fen2Yuan = "0";
                } else {
                    Intrinsics.checkNotNullExpressionValue(fen2Yuan, "Utils.fen2Yuan(data.spfaBalance) ?: \"0\"");
                }
                objArr[0] = fen2Yuan;
                String format = String.format(string, Arrays.copyOf(objArr, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                textView3.setText(format);
                textView3.setTextColor(-16777216);
            }
        });
    }

    @SuppressLint({"SetTextI18n"})
    private final void setBalance(PayChannelBean.Balance data) {
        float f16;
        PayChannelBean.MiniApp miniApp;
        ViewGroup rootView = this.rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        PayChannelUtils.updateBgRound$default(rootView, data.getBgRadiusEnum(), 0, 4, null);
        this.logoView.setImageResource(R.drawable.dvp);
        TextView textView = this.titleView;
        String string = textView.getResources().getString(R.string.f2180562o);
        Long balance = data.getBalance();
        if (balance != null) {
            f16 = (float) balance.longValue();
        } else {
            f16 = 0.0f;
        }
        textView.setText(string + " (" + (f16 / 100.0f) + "\u5143)");
        this.rightCheckBox.setVisibility(0);
        PayChannelBean.MiniApp miniApp2 = data.getMiniApp();
        if (!WXShareHelper.b0().e0()) {
            miniApp = null;
        } else {
            miniApp = miniApp2;
        }
        updateDisableBrief(data, data.getDisable(), data.getDisableComment(), data.getDisableUrl(), data.getDisableBrief(), miniApp);
        if (this.entryLayout.getVisibility() == 0) {
            Long balance2 = data.getBalance();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(balance2);
            String sb6 = sb5.toString();
            Long totalFee = data.getTotalFee();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(totalFee);
            com.tencent.mobileqq.qwallet.c.e("paysdk.wx2qq.show", sb6, sb7.toString(), "", "");
        }
    }

    @SuppressLint({"SetTextI18n"})
    private final void setBankCard(PayChannelBean.Bank data) {
        boolean z16;
        ViewGroup rootView = this.rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        PayChannelUtils.updateBgRound$default(rootView, data.getBgRadiusEnum(), 0, 4, null);
        String imageId = data.getImageId();
        Integer disable = data.getDisable();
        if (disable == null || disable.intValue() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        setImageLogo$default(this, imageId, z16, null, 4, null);
        this.titleView.setText(data.getBankName() + " (" + data.getCardTail() + ")");
        this.rightCheckBox.setVisibility(0);
        updateDisableBrief$default(this, data, data.getDisable(), data.getDisableComment(), data.getDisableUrl(), data.getDisableBrief(), null, 32, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setData$lambda$1(PayTypeItemViewHolder this$0, PayChannelBean data, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        IPayChannelItemClickListener iPayChannelItemClickListener = this$0.listener;
        if (iPayChannelItemClickListener != null) {
            iPayChannelItemClickListener.onItemClick(data, i3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void setFriendPayData(PayChannelBean.FriendPay data) {
        int i3 = 0;
        this.rightArrow.setVisibility(0);
        this.titleView.setText(this.fragment.getResources().getString(R.string.e6s));
        Integer flag = data.getFlag();
        if (flag == null || flag.intValue() != 1) {
            i3 = 1;
        }
        setImageLogo$default(this, data.getPfaLogoId(), updateDisableBrief$default(this, data, Integer.valueOf(i3), data.getReason(), null, null, null, 32, null), null, 4, null);
    }

    private final void setImageLogo(String imageId, boolean disable, ImageView imageView) {
        if (imageView == null) {
            imageView = this.logoView;
        }
        if (disable) {
            BankImageUtil.getInstance(this.fragment.getContext()).setBankCardDisableLogo(imageId, imageView);
        } else {
            BankImageUtil.getInstance(this.fragment.getContext()).setBankImage(imageId, imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void setImageLogo$default(PayTypeItemViewHolder payTypeItemViewHolder, String str, boolean z16, ImageView imageView, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            imageView = null;
        }
        payTypeItemViewHolder.setImageLogo(str, z16, imageView);
    }

    private final void setMoreData(PayChannelBean.More data) {
        View moreRootView = this.itemView.findViewById(R.id.zez);
        Intrinsics.checkNotNullExpressionValue(moreRootView, "moreRootView");
        PayChannelUtils.updateBgRound$default(moreRootView, data.getBgRadiusEnum(), 0, 4, null);
        ((TextView) this.itemView.findViewById(R.id.f166125ef1)).setText(data.getTitle());
        this.logoView.setImageResource(data.getLogoResId());
    }

    private final void setQQHeader(PayChannelBean.QQHeader data) {
        ViewGroup rootView = this.rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        PayChannelUtils.updateBgRound$default(rootView, data.getBgRadiusEnum(), 0, 4, null);
        ViewGroup.LayoutParams layoutParams = this.logoView.getLayoutParams();
        layoutParams.width = x.c(this.logoView.getContext(), 24.0f);
        layoutParams.height = x.c(this.logoView.getContext(), 24.0f);
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(x.c(this.logoView.getContext(), 16.0f));
        setImageLogo$default(this, data.getLogoId(), false, null, 6, null);
        this.titleView.setText(data.getTitle());
        ViewGroup.LayoutParams layoutParams2 = this.titleView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams2).setMarginStart(x.c(this.logoView.getContext(), 6.0f));
        this.bottomDiv.setVisibility(0);
        this.itemView.setClickable(false);
    }

    private final void setWxData(PayChannelBean.Wx data) {
        ViewGroup rootView = this.rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        PayChannelUtils.updateBgRound$default(rootView, data.getBgRadiusEnum(), 0, 4, null);
        ViewGroup.LayoutParams layoutParams = this.logoView.getLayoutParams();
        layoutParams.width = x.c(this.logoView.getContext(), 24.0f);
        layoutParams.height = x.c(this.logoView.getContext(), 24.0f);
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(x.c(this.logoView.getContext(), 16.0f));
        this.rootView.getLayoutParams().height = x.c(this.logoView.getContext(), 52.0f);
        setImageLogo$default(this, data.getLogoId(), false, null, 6, null);
        this.titleView.setText(data.getTitle());
        ViewGroup.LayoutParams layoutParams2 = this.titleView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams2).setMarginStart(x.c(this.logoView.getContext(), 6.0f));
        this.rightArrow.setVisibility(0);
    }

    private final boolean updateDisableBrief(final PayChannelBean payChannelBean, Integer disable, String disableComment, final String disableUrl, String disableBrief, final PayChannelBean.MiniApp miniApp) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (disable != null && disable.intValue() != 0) {
            this.titleView.setTextColor(this.fragment.getResources().getColor(R.color.f157592u3));
            this.subTitleView.setVisibility(0);
            if (disableComment != null && disableComment.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                this.subTitleView.setText(this.fragment.getResources().getString(R.string.f171354eb4));
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(disableComment);
                if (disableBrief != null && disableBrief.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    if (disableUrl != null && disableUrl.length() != 0) {
                        z18 = false;
                    } else {
                        z18 = true;
                    }
                    if (!z18) {
                        spannableStringBuilder.append((CharSequence) " ");
                        int length = spannableStringBuilder.length();
                        spannableStringBuilder.append((CharSequence) disableBrief);
                        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.tenpay.pay.PayTypeItemViewHolder$updateDisableBrief$clickableSpan$1
                            @Override // android.text.style.ClickableSpan
                            public void onClick(@NotNull View widget) {
                                Intrinsics.checkNotNullParameter(widget, "widget");
                                k.h(PayTypeItemViewHolder.this.getFragment().getContext(), disableUrl);
                            }

                            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                            public void updateDrawState(@NotNull TextPaint ds5) {
                                TextView textView;
                                Intrinsics.checkNotNullParameter(ds5, "ds");
                                ds5.setUnderlineText(false);
                                textView = PayTypeItemViewHolder.this.subTitleView;
                                ds5.setColor(textView.getContext().getColor(R.color.qui_common_text_link));
                            }
                        }, length, disableBrief.length() + length, 33);
                    }
                }
                this.subTitleView.setMovementMethod(LinkMovementMethod.getInstance());
                this.subTitleView.setText(spannableStringBuilder);
            }
            this.rightCheckBox.setVisibility(8);
            this.itemView.setClickable(false);
            if (miniApp != null) {
                String title = miniApp.getTitle();
                if (title != null && title.length() != 0) {
                    z19 = false;
                } else {
                    z19 = true;
                }
                if (!z19) {
                    this.rightArrow.setVisibility(0);
                    this.entryLayout.setVisibility(0);
                    this.entryTitleView.setText(miniApp.getTitle());
                    this.entryTitleView.setTextColor(Color.parseColor("#03081A"));
                    setImageLogo(miniApp.getLogoId(), false, this.entryLogoView);
                    this.entryLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.pay.g
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            PayTypeItemViewHolder.updateDisableBrief$lambda$2(PayTypeItemViewHolder.this, payChannelBean, miniApp, view);
                        }
                    });
                    return true;
                }
            }
            this.entryLayout.setVisibility(8);
            return true;
        }
        this.subTitleView.setVisibility(8);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean updateDisableBrief$default(PayTypeItemViewHolder payTypeItemViewHolder, PayChannelBean payChannelBean, Integer num, String str, String str2, String str3, PayChannelBean.MiniApp miniApp, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            miniApp = null;
        }
        return payTypeItemViewHolder.updateDisableBrief(payChannelBean, num, str, str2, str3, miniApp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateDisableBrief$lambda$2(PayTypeItemViewHolder this$0, PayChannelBean payChannelBean, PayChannelBean.MiniApp miniApp, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(payChannelBean, "$payChannelBean");
        IPayChannelItemClickListener iPayChannelItemClickListener = this$0.listener;
        if (iPayChannelItemClickListener != null) {
            iPayChannelItemClickListener.onMiniAppClick(payChannelBean, miniApp);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void updateSelected(boolean isSelected) {
        if (this.rightCheckBox.getVisibility() == 0) {
            this.rightCheckBox.setChecked(isSelected);
            this.rootView.setSelected(isSelected);
        }
    }

    @NotNull
    public final Fragment getFragment() {
        return this.fragment;
    }

    @Nullable
    public final IPayChannelItemClickListener getListener() {
        return this.listener;
    }

    public final void setData(@NotNull final PayChannelBean data, boolean isSelected, final int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.pay.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PayTypeItemViewHolder.setData$lambda$1(PayTypeItemViewHolder.this, data, position, view);
            }
        });
        if (data instanceof PayChannelBean.QQHeader) {
            setQQHeader((PayChannelBean.QQHeader) data);
        } else if (data instanceof PayChannelBean.Balance) {
            setBalance((PayChannelBean.Balance) data);
        } else if (data instanceof PayChannelBean.AddMore) {
            setAddMoreData((PayChannelBean.AddMore) data);
        } else if (data instanceof PayChannelBean.Wx) {
            setWxData((PayChannelBean.Wx) data);
        } else if (data instanceof PayChannelBean.More) {
            setMoreData((PayChannelBean.More) data);
        } else if (data instanceof PayChannelBean.Bank) {
            setBankCard((PayChannelBean.Bank) data);
        } else if (data instanceof PayChannelBean.AutoPayCard) {
            setAutoPayData((PayChannelBean.AutoPayCard) data);
        } else if (data instanceof PayChannelBean.FriendPay) {
            setFriendPayData((PayChannelBean.FriendPay) data);
        }
        updateSelected(isSelected);
    }
}

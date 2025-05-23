package com.tenpay.sdk.hbdetail;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.qwallet.utils.QWalletUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.hb.detail.g;
import com.tencent.mobileqq.qwallet.utils.f;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.sdk.hbdetail.HbDetailRsp;
import com.tenpay.sdk.hbdetail.HbReceiverRvAdapter;
import com.tenpay.sdk.util.HBUtil;
import cooperation.qwallet.plugin.QWalletPicHelper;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005+,-./B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b)\u0010*J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u0011\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010(\u00a8\u00060"}, d2 = {"Lcom/tenpay/sdk/hbdetail/HbReceiverRvAdapter;", "Lcom/tenpay/sdk/hbdetail/ListAdapterWithHeader;", "Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbReceiver;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "", "uin", "", "setClickAction", "", "position", "Lcom/tenpay/sdk/hbdetail/HbReceiverRvAdapter$ReceiverStyle;", "getReceiverStyle", "Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbSender;", "sender", "self", "updateHeader", "Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbOperationBubble;", "bubble", "updateOperationBubble", "", "isLoading", "updateFooter", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "viewHolder", "onBindViewHolder", "Lcom/tencent/mobileqq/qwallet/hb/detail/g;", "detailCardAction", "Lcom/tencent/mobileqq/qwallet/hb/detail/g;", "hbSender", "Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbSender;", "userSelf", "Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbReceiver;", "hbOperationBubble", "Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbOperationBubble;", "Z", "<init>", "(Lcom/tencent/mobileqq/qwallet/hb/detail/g;)V", "Companion", "HbReceiverFooterViewHolder", "HbReceiverHeaderViewHolder", "HbReceiverItemViewHolder", "ReceiverStyle", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class HbReceiverRvAdapter extends ListAdapterWithHeader<HbDetailRsp.HbReceiver, RecyclerView.ViewHolder> {

    @NotNull
    private static final String AMOUNT_FONT_NAME = "fonts/DIN-NextLT-Pro-Medium.ttf";
    private static final float FEN_TO_YUAN = 100.0f;

    @NotNull
    private static final String TAG = "HbReceiverRvAdapter";
    private static final int VIEW_TYPE_FOOTER = 3;
    private static final int VIEW_TYPE_HEADER = 1;
    private static final int VIEW_TYPE_RECEIVER = 2;

    @NotNull
    private final g detailCardAction;

    @Nullable
    private HbDetailRsp.HbOperationBubble hbOperationBubble;

    @Nullable
    private HbDetailRsp.HbSender hbSender;
    private boolean isLoading;

    @Nullable
    private HbDetailRsp.HbReceiver userSelf;

    @NotNull
    private static final HbReceiverRvAdapter$Companion$ITEM_CALLBACK$1 ITEM_CALLBACK = new DiffUtil.ItemCallback<HbDetailRsp.HbReceiver>() { // from class: com.tenpay.sdk.hbdetail.HbReceiverRvAdapter$Companion$ITEM_CALLBACK$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(@NotNull HbDetailRsp.HbReceiver p06, @NotNull HbDetailRsp.HbReceiver p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            return Intrinsics.areEqual(p06, p16) && Intrinsics.areEqual(p06.getUinAvatarPath(), p16.getUinAvatarPath()) && Intrinsics.areEqual(p06.getTinyAvatarUrl(), p16.getTinyAvatarUrl());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(@NotNull HbDetailRsp.HbReceiver p06, @NotNull HbDetailRsp.HbReceiver p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            return Intrinsics.areEqual(p06, p16);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tenpay/sdk/hbdetail/HbReceiverRvAdapter$HbReceiverFooterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "loadText", "Landroid/widget/TextView;", "progressBar", "Landroid/widget/ProgressBar;", "setLoadingStatus", "", "isLoading", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class HbReceiverFooterViewHolder extends RecyclerView.ViewHolder {

        @NotNull
        private final TextView loadText;

        @NotNull
        private final ProgressBar progressBar;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HbReceiverFooterViewHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.x6x);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026ers_loading_progress_bar)");
            this.progressBar = (ProgressBar) findViewById;
            View findViewById2 = itemView.findViewById(R.id.x6w);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026eivers_list_loading_text)");
            this.loadText = (TextView) findViewById2;
        }

        public final void setLoadingStatus(boolean isLoading) {
            int i3;
            View view = this.itemView;
            if (isLoading) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u001a\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tenpay/sdk/hbdetail/HbReceiverRvAdapter$HbReceiverHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "defaultIcon", "Landroid/graphics/drawable/Drawable;", "divider", "hbStatus", "Landroid/widget/TextView;", "hbTypeView", "popViewContainer", "Lcom/tenpay/sdk/hbdetail/HbDetailPopContainer;", "selfAmount", "selfAmountUnit", "senderAvatar", "Landroid/widget/ImageView;", "getSenderAvatar", "()Landroid/widget/ImageView;", "senderTitle", "senderWishText", "userWalletBalance", "bindBubbleData", "", "listId", "", "bubbleData", "Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbOperationBubble;", "bindData", "sender", "Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbSender;", "userSelf", "Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbReceiver;", "gotoQWalletActivity", WadlProxyConsts.CHANNEL, "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class HbReceiverHeaderViewHolder extends RecyclerView.ViewHolder {

        @Nullable
        private final Drawable defaultIcon;

        @NotNull
        private final View divider;

        @NotNull
        private final TextView hbStatus;

        @NotNull
        private final TextView hbTypeView;

        @NotNull
        private final HbDetailPopContainer popViewContainer;

        @NotNull
        private final TextView selfAmount;

        @NotNull
        private final TextView selfAmountUnit;

        @NotNull
        private final ImageView senderAvatar;

        @NotNull
        private final TextView senderTitle;

        @NotNull
        private final TextView senderWishText;

        @NotNull
        private final TextView userWalletBalance;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HbReceiverHeaderViewHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.f165665x72);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.hb_sender_avatar)");
            this.senderAvatar = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f165666x73);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.hb_sender_title)");
            this.senderTitle = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.x7i);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.hb_type_text)");
            this.hbTypeView = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.f83244j1);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.sender_wish_text)");
            this.senderWishText = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.f82854i0);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.self_amount)");
            TextView textView = (TextView) findViewById5;
            this.selfAmount = textView;
            View findViewById6 = itemView.findViewById(R.id.f82864i1);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.self_amount_unit)");
            TextView textView2 = (TextView) findViewById6;
            this.selfAmountUnit = textView2;
            View findViewById7 = itemView.findViewById(R.id.f70763mb);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.receive_status_tip)");
            this.hbStatus = (TextView) findViewById7;
            View findViewById8 = itemView.findViewById(R.id.f115826x3);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.\u2026er_wallet_balance_on_top)");
            this.userWalletBalance = (TextView) findViewById8;
            View findViewById9 = itemView.findViewById(R.id.ujr);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.\u2026above_receive_status_tip)");
            this.divider = findViewById9;
            this.defaultIcon = ContextCompat.getDrawable(itemView.getContext(), R.drawable.dxx);
            this.popViewContainer = new HbDetailPopContainer(itemView);
            Typeface createFromAsset = Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/DIN-NextLT-Pro-Medium.ttf");
            textView.setTypeface(createFromAsset);
            textView2.setTypeface(createFromAsset);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bindData$lambda$3(HbReceiverHeaderViewHolder this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.gotoQWalletActivity(4);
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void gotoQWalletActivity(int channel) {
            QWalletUtils.k(this.itemView.getContext(), "mqqapi://wallet/open?viewtype=0&version=1&src_type=web&view=0&channel=" + channel);
        }

        public final void bindBubbleData(@Nullable String listId, @Nullable HbDetailRsp.HbOperationBubble bubbleData) {
            this.popViewContainer.bindBubbleData(listId, bubbleData);
        }

        public final void bindData(@Nullable HbDetailRsp.HbSender sender, @Nullable HbDetailRsp.HbReceiver userSelf) {
            int i3;
            int i16;
            int i17;
            int i18;
            String hbStatusDesc;
            Drawable avatarDrawable;
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            if (sender != null) {
                this.senderTitle.setText(sender.getSendName());
                this.hbTypeView.setText(this.itemView.getContext().getString(R.string.f21786626, HBUtil.getHbTypeText(sender.getChannel(), sender.getBusiType())));
                this.senderWishText.setText(sender.getWishing());
                TextView textView = this.hbStatus;
                if (HBUtil.isHbForFaceToFace(sender.getChannel()) && !Intrinsics.areEqual(sender.getSendUin(), com.tencent.mobileqq.base.a.c())) {
                    hbStatusDesc = this.hbStatus.getResources().getString(R.string.f2184263o);
                } else {
                    hbStatusDesc = sender.getHbStatusDesc();
                }
                textView.setText(hbStatusDesc);
                QLog.i(HbReceiverRvAdapter.TAG, 1, "hbStatus.text=" + sender.getHbStatusDesc());
                if ((HBUtil.isHbForChunMing(sender.getChannel()) || HBUtil.isHbForEnterprise(sender.getChannel())) && !TextUtils.isEmpty(sender.getMchIcon())) {
                    String mchIcon = sender.getMchIcon();
                    Drawable drawable = this.defaultIcon;
                    this.senderAvatar.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(mchIcon, drawable, drawable));
                } else if (!TextUtils.isEmpty(sender.getUinAvatarPath())) {
                    URLDrawable drawableForQWallet = QWalletPicHelper.getDrawableForQWallet(sender.getUinAvatarPath(), this.defaultIcon, null);
                    if (drawableForQWallet.getStatus() == 2) {
                        drawableForQWallet.restartDownload();
                    }
                    drawableForQWallet.setDecodeHandler(com.tencent.mobileqq.Doraemon.ui.a.M);
                    this.senderAvatar.setImageDrawable(drawableForQWallet);
                } else if (!TextUtils.isEmpty(sender.getTinyIdAvatarUrl()) && (avatarDrawable = HBUtil.getAvatarDrawable(sender.getTinyIdAvatarUrl())) != null) {
                    Intrinsics.checkNotNullExpressionValue(avatarDrawable, "getAvatarDrawable(it.tinyIdAvatarUrl)");
                    this.senderAvatar.setImageDrawable(avatarDrawable);
                }
                this.senderAvatar.setContentDescription(sender.getSendName() + "\u7684\u5934\u50cf");
            }
            if (userSelf != null) {
                i3 = userSelf.getAmount();
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                i16 = 8;
            } else {
                i16 = 0;
            }
            this.selfAmount.setVisibility(i16);
            this.userWalletBalance.setVisibility(i16);
            this.selfAmountUnit.setVisibility(i16);
            this.divider.setVisibility(i16);
            TextView textView2 = this.hbStatus;
            if (i16 == 0) {
                i17 = 12;
            } else {
                i17 = 36;
            }
            int b16 = e83.a.b(i17);
            ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            }
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams2 = textView2.getLayoutParams();
                int i19 = -2;
                if (layoutParams2 != null) {
                    i18 = layoutParams2.width;
                } else {
                    i18 = -2;
                }
                ViewGroup.LayoutParams layoutParams3 = textView2.getLayoutParams();
                if (layoutParams3 != null) {
                    i19 = layoutParams3.height;
                }
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i18, i19);
            }
            if (b16 != marginLayoutParams.topMargin) {
                marginLayoutParams.topMargin = b16;
                textView2.setLayoutParams(marginLayoutParams);
            }
            TextView textView3 = this.selfAmount;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(i3 / 100.0f)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView3.setText(format);
            this.userWalletBalance.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.hbdetail.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HbReceiverRvAdapter.HbReceiverHeaderViewHolder.bindData$lambda$3(HbReceiverRvAdapter.HbReceiverHeaderViewHolder.this, view);
                }
            });
        }

        @NotNull
        public final ImageView getSenderAvatar() {
            return this.senderAvatar;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tenpay/sdk/hbdetail/HbReceiverRvAdapter$HbReceiverItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "defaultIcon", "Landroid/graphics/drawable/Drawable;", "receiverAmount", "Landroid/widget/TextView;", "receiverAvatar", "Landroid/widget/ImageView;", "receiverName", "receiverTag", "receiverTime", "setItem", "", "current", "Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbReceiver;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class HbReceiverItemViewHolder extends RecyclerView.ViewHolder {

        @Nullable
        private final Drawable defaultIcon;

        @NotNull
        private final TextView receiverAmount;

        @NotNull
        private final ImageView receiverAvatar;

        @NotNull
        private final TextView receiverName;

        @NotNull
        private final TextView receiverTag;

        @NotNull
        private final TextView receiverTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HbReceiverItemViewHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.f70783md);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.receiver_avatar)");
            this.receiverAvatar = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f70793me);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.receiver_name)");
            this.receiverName = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.f70773mc);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.receiver_amount)");
            TextView textView = (TextView) findViewById3;
            this.receiverAmount = textView;
            View findViewById4 = itemView.findViewById(R.id.f70843mj);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.receiver_time)");
            this.receiverTime = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.f70833mi);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.receiver_tag)");
            this.receiverTag = (TextView) findViewById5;
            this.defaultIcon = ContextCompat.getDrawable(itemView.getContext(), R.drawable.dxx);
            textView.setTypeface(Typeface.createFromAsset(itemView.getContext().getAssets(), "fonts/DIN-NextLT-Pro-Medium.ttf"));
        }

        public final void setItem(@NotNull HbDetailRsp.HbReceiver current) {
            int i3;
            boolean z16;
            boolean z17;
            boolean z18;
            Intrinsics.checkNotNullParameter(current, "current");
            this.receiverName.setText(current.getRecvName());
            TextView textView = this.receiverAmount;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            boolean z19 = false;
            String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(current.getAmount() / 100.0f)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
            this.receiverTime.setText(current.getCreateTime());
            TextView textView2 = this.receiverTag;
            if (current.getIsLuck()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView2.setVisibility(i3);
            String recvUin = current.getRecvUin();
            if (recvUin != null && recvUin.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            Unit unit = null;
            if (!z16) {
                String uinAvatarPath = current.getUinAvatarPath();
                if (uinAvatarPath != null && uinAvatarPath.length() != 0) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (!z18) {
                    URLDrawable drawableForQWallet = QWalletPicHelper.getDrawableForQWallet(current.getUinAvatarPath(), this.defaultIcon, null);
                    if (drawableForQWallet.getStatus() == 2) {
                        drawableForQWallet.restartDownload();
                    }
                    drawableForQWallet.setDecodeHandler(com.tencent.mobileqq.Doraemon.ui.a.M);
                    this.receiverAvatar.setImageDrawable(drawableForQWallet);
                    return;
                }
            }
            String recvTinyId = current.getRecvTinyId();
            if (recvTinyId != null && recvTinyId.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                String tinyAvatarUrl = current.getTinyAvatarUrl();
                if (tinyAvatarUrl == null || tinyAvatarUrl.length() == 0) {
                    z19 = true;
                }
                if (!z19) {
                    Drawable avatarDrawable = HBUtil.getAvatarDrawable(current.getTinyAvatarUrl());
                    if (avatarDrawable != null) {
                        this.receiverAvatar.setImageDrawable(avatarDrawable);
                        unit = Unit.INSTANCE;
                    }
                    if (unit == null) {
                        this.receiverAvatar.setImageDrawable(this.defaultIcon);
                        QLog.d(HbReceiverRvAdapter.TAG, 1, "load guild avatar failed, id:" + current.getRecvTinyId() + ", avatar url: " + current.getTinyAvatarUrl() + ".");
                        return;
                    }
                    return;
                }
            }
            this.receiverAvatar.setImageDrawable(this.defaultIcon);
            QLog.d(HbReceiverRvAdapter.TAG, 1, "use default avatar instead");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\u0006\u0010\n\u001a\u00020\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0006\u0010\u000e\u001a\u00020\u0003R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tenpay/sdk/hbdetail/HbReceiverRvAdapter$ReceiverStyle;", "", "level", "", "isBigPaddingTop", "", "isBigPaddingBottom", "(Ljava/lang/String;IIZZ)V", "getLevel", "()I", NodeProps.PADDING_BOTTOM, "paddingInDp", "", "bigPadding", NodeProps.PADDING_TOP, "CENTER", "FIRST", "LAST", "SINGLE", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public enum ReceiverStyle {
        CENTER(0, false, false),
        FIRST(1, true, false),
        LAST(2, false, true),
        SINGLE(3, true, true);

        private final boolean isBigPaddingBottom;
        private final boolean isBigPaddingTop;
        private final int level;

        ReceiverStyle(int i3, boolean z16, boolean z17) {
            this.level = i3;
            this.isBigPaddingTop = z16;
            this.isBigPaddingBottom = z17;
        }

        private final float paddingInDp(boolean bigPadding) {
            if (bigPadding) {
                return 22.0f;
            }
            return 10.0f;
        }

        public final int getLevel() {
            return this.level;
        }

        public final int paddingBottom() {
            return ViewUtils.dpToPx(paddingInDp(false));
        }

        public final int paddingTop() {
            return ViewUtils.dpToPx(paddingInDp(this.isBigPaddingTop));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HbReceiverRvAdapter(@NotNull g detailCardAction) {
        super(ITEM_CALLBACK, 0, 0, 6, null);
        Intrinsics.checkNotNullParameter(detailCardAction, "detailCardAction");
        this.detailCardAction = detailCardAction;
    }

    private final ReceiverStyle getReceiverStyle(int position) {
        if (getNUM_BACKGOURND_ICON() == 3) {
            return ReceiverStyle.SINGLE;
        }
        if (position == 1) {
            return ReceiverStyle.FIRST;
        }
        if (position == getNUM_BACKGOURND_ICON() - 2) {
            return ReceiverStyle.LAST;
        }
        return ReceiverStyle.CENTER;
    }

    private final void setClickAction(View itemView, final String uin) {
        if (!TextUtils.isEmpty(uin)) {
            itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.hbdetail.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HbReceiverRvAdapter.setClickAction$lambda$0(HbReceiverRvAdapter.this, uin, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setClickAction$lambda$0(HbReceiverRvAdapter this$0, String str, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.detailCardAction.go2DetailCard(str);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        }
        if (position == getNUM_BACKGOURND_ICON() - 1) {
            return 3;
        }
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int position) {
        String str;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (viewHolder instanceof HbReceiverHeaderViewHolder) {
            HbReceiverHeaderViewHolder hbReceiverHeaderViewHolder = (HbReceiverHeaderViewHolder) viewHolder;
            hbReceiverHeaderViewHolder.bindData(this.hbSender, this.userSelf);
            HbDetailRsp.HbSender hbSender = this.hbSender;
            String str2 = null;
            if (hbSender != null) {
                str = hbSender.getListId();
            } else {
                str = null;
            }
            hbReceiverHeaderViewHolder.bindBubbleData(str, this.hbOperationBubble);
            ImageView senderAvatar = hbReceiverHeaderViewHolder.getSenderAvatar();
            HbDetailRsp.HbSender hbSender2 = this.hbSender;
            if (hbSender2 != null) {
                str2 = hbSender2.getSendUin();
            }
            setClickAction(senderAvatar, str2);
            return;
        }
        if (viewHolder instanceof HbReceiverFooterViewHolder) {
            ((HbReceiverFooterViewHolder) viewHolder).setLoadingStatus(this.isLoading);
            return;
        }
        if (viewHolder instanceof HbReceiverItemViewHolder) {
            HbDetailRsp.HbReceiver item = getItem(position);
            if (item != null) {
                ((HbReceiverItemViewHolder) viewHolder).setItem(item);
                View view = viewHolder.itemView;
                Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
                setClickAction(view, item.getRecvUin());
                return;
            }
            return;
        }
        QLog.w(TAG, 1, "viewHolder: " + viewHolder.getClass().getCanonicalName() + ", position:" + position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            if (viewType != 3) {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.f168976hj0, parent, false);
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                return new HbReceiverItemViewHolder(itemView);
            }
            View footerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hiw, parent, false);
            Intrinsics.checkNotNullExpressionValue(footerView, "footerView");
            return new HbReceiverFooterViewHolder(footerView);
        }
        View headerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hiy, parent, false);
        Intrinsics.checkNotNullExpressionValue(headerView, "headerView");
        return new HbReceiverHeaderViewHolder(headerView);
    }

    public final void updateFooter(boolean isLoading) {
        if (this.isLoading == isLoading) {
            f.a(TAG, "loading footer status not changed, do nothing");
        } else {
            this.isLoading = isLoading;
            notifyItemChanged(getNUM_BACKGOURND_ICON() - 1);
        }
    }

    public final void updateHeader(@Nullable HbDetailRsp.HbSender sender, @Nullable HbDetailRsp.HbReceiver self) {
        this.hbSender = sender;
        this.userSelf = self;
        notifyItemChanged(0);
    }

    public final void updateOperationBubble(@Nullable HbDetailRsp.HbOperationBubble bubble) {
        this.hbOperationBubble = bubble;
        notifyItemChanged(0);
    }
}

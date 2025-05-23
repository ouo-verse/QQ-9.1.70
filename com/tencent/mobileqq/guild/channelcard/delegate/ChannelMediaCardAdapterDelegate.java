package com.tencent.mobileqq.guild.channelcard.delegate;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discovery.widget.detail.DetailMediaMusicDrawable;
import com.tencent.mobileqq.guild.discovery.widget.voiceavatar.MineVoiceAvatarLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.widget.ChannelStatusInfo;
import com.tencent.mobileqq.guild.widget.GuildChannelCommonStatusView;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.cw;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.photoplus.sticker.Sticker;
import dg1.ChannelMediaCardItemData;
import fh1.AvatarInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001d2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0003\u001e\u001f B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J&\u0010\u0016\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\nH\u0014R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/channelcard/delegate/ChannelMediaCardAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Ldg1/e;", "Ldg1/b;", "Lcom/tencent/mobileqq/guild/channelcard/delegate/ChannelMediaCardAdapterDelegate$a;", "Landroid/view/View;", "view", "", "p", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, ReportConstant.COSTREPORT_PREFIX, "holder", "", "payloads", "r", "Lcg1/b;", "d", "Lcg1/b;", "channelCardControl", "<init>", "(Lcg1/b;)V", "e", "a", "b", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ChannelMediaCardAdapterDelegate extends AbsListItemAdapterDelegate<ChannelMediaCardItemData, dg1.b, a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final cg1.b channelCardControl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010.\u001a\u00020(\u0012\u0006\u00100\u001a\u00020/\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\r\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0010R\u0014\u0010\u001d\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010*\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/channelcard/delegate/ChannelMediaCardAdapterDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/main/a;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ldg1/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "enableAnimate", "l", "d", "E", "Ldg1/e;", "itemData", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "bottomImage", "Lcom/tencent/mobileqq/guild/discovery/widget/voiceavatar/MineVoiceAvatarLayout;", "G", "Lcom/tencent/mobileqq/guild/discovery/widget/voiceavatar/MineVoiceAvatarLayout;", "avatarListView", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "channelNameView", "I", "memberIcon", "J", "bottomText", "Landroid/view/ViewStub;", "K", "Landroid/view/ViewStub;", "statusViewStub", "L", "lottieViewStub", "Lcom/tencent/mobileqq/guild/channelcard/delegate/ChannelMediaCardAdapterDelegate$c;", "M", "Lcom/tencent/mobileqq/guild/channelcard/delegate/ChannelMediaCardAdapterDelegate$c;", "statusWrapper", "Landroid/view/View;", "N", "Landroid/view/View;", "backgroundContainer", "P", "topMask", "view", "Lcg1/b;", "channelCardControl", "<init>", "(Landroid/view/View;Lcg1/b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends RecyclerView.ViewHolder implements com.tencent.mobileqq.guild.main.a {

        /* renamed from: E, reason: from kotlin metadata */
        private ChannelMediaCardItemData itemData;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final ImageView bottomImage;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final MineVoiceAvatarLayout avatarListView;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final TextView channelNameView;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final ImageView memberIcon;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final TextView bottomText;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private final ViewStub statusViewStub;

        /* renamed from: L, reason: from kotlin metadata */
        @NotNull
        private final ViewStub lottieViewStub;

        /* renamed from: M, reason: from kotlin metadata */
        @NotNull
        private final c statusWrapper;

        /* renamed from: N, reason: from kotlin metadata */
        @NotNull
        private final View backgroundContainer;

        /* renamed from: P, reason: from kotlin metadata */
        @NotNull
        private final View topMask;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View view, @NotNull cg1.b channelCardControl) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(channelCardControl, "channelCardControl");
            View findViewById = view.findViewById(R.id.t_r);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.bottom_image)");
            this.bottomImage = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.t1l);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.avatar_list)");
            MineVoiceAvatarLayout mineVoiceAvatarLayout = (MineVoiceAvatarLayout) findViewById2;
            this.avatarListView = mineVoiceAvatarLayout;
            View findViewById3 = view.findViewById(R.id.ato);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.channel_name)");
            this.channelNameView = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.z1x);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.member_icon)");
            this.memberIcon = (ImageView) findViewById4;
            View findViewById5 = view.findViewById(R.id.adg);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.bottom_text)");
            this.bottomText = (TextView) findViewById5;
            View findViewById6 = this.itemView.findViewById(R.id.f88334ws);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.status_viewstub)");
            ViewStub viewStub = (ViewStub) findViewById6;
            this.statusViewStub = viewStub;
            View findViewById7 = this.itemView.findViewById(R.id.f88104w6);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.\u2026ate_icon_lottie_viewstub)");
            ViewStub viewStub2 = (ViewStub) findViewById7;
            this.lottieViewStub = viewStub2;
            this.statusWrapper = new c(viewStub, viewStub2);
            View findViewById8 = view.findViewById(R.id.f164562t31);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.background_container)");
            this.backgroundContainer = findViewById8;
            View findViewById9 = view.findViewById(R.id.f99935r5);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.top_mask)");
            this.topMask = findViewById9;
            channelCardControl.r1(mineVoiceAvatarLayout);
        }

        private final void m() {
            ChannelMediaCardItemData channelMediaCardItemData = this.itemData;
            ChannelMediaCardItemData channelMediaCardItemData2 = null;
            if (channelMediaCardItemData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                channelMediaCardItemData = null;
            }
            int cardType = channelMediaCardItemData.getCardType();
            if (cardType != 3) {
                if (cardType != 5) {
                    this.bottomImage.setVisibility(8);
                    this.topMask.setVisibility(8);
                    View view = this.backgroundContainer;
                    DetailMediaMusicDrawable detailMediaMusicDrawable = new DetailMediaMusicDrawable();
                    ChannelMediaCardItemData channelMediaCardItemData3 = this.itemData;
                    if (channelMediaCardItemData3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("itemData");
                    } else {
                        channelMediaCardItemData2 = channelMediaCardItemData3;
                    }
                    detailMediaMusicDrawable.e(channelMediaCardItemData2.getCoverImageUrl());
                    view.setBackground(detailMediaMusicDrawable);
                    return;
                }
                this.bottomImage.setVisibility(8);
                this.topMask.setVisibility(8);
                this.backgroundContainer.setBackground(new com.tencent.mobileqq.guild.discovery.widget.detail.a(Color.parseColor("#9D92FF"), "https://group-pro-search-recommend-1251316161.cos.ap-guangzhou.myqcloud.com/xy%2Fqq_channel%2Frecommend_resources%2Fimages%2Fbg_smoba_797.png?imageMogr2/format/webp"));
                return;
            }
            this.topMask.setVisibility(0);
            this.topMask.setBackgroundResource(R.drawable.guild_mine_item_top_mask_bg_59000000);
            this.backgroundContainer.setBackgroundResource(R.drawable.guild_mine_item_mask_986ae3_748fff_radius_8);
            this.bottomImage.setVisibility(0);
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#9D92FF"));
            ChannelMediaCardItemData channelMediaCardItemData4 = this.itemData;
            if (channelMediaCardItemData4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                channelMediaCardItemData4 = null;
            }
            if (channelMediaCardItemData4.h().isEmpty()) {
                this.bottomImage.setImageDrawable(colorDrawable);
                return;
            }
            ChannelMediaCardItemData channelMediaCardItemData5 = this.itemData;
            if (channelMediaCardItemData5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
            } else {
                channelMediaCardItemData2 = channelMediaCardItemData5;
            }
            AvatarInfo avatarInfo = channelMediaCardItemData2.h().get(0);
            String fullAvatarUrl = ((IGPSService) ch.R0(IGPSService.class)).getFullAvatarUrl(new cw(avatarInfo.getTinyId(), avatarInfo.getAvatarUrl()), 0);
            com.tencent.mobileqq.guild.picload.e a16 = com.tencent.mobileqq.guild.picload.e.a();
            Option obtain = Option.obtain();
            obtain.setTargetView(this.bottomImage);
            obtain.setLoadingDrawable(colorDrawable);
            obtain.setFailedDrawable(colorDrawable);
            obtain.setUrl(fullAvatarUrl);
            obtain.setLoadingDrawableId(R.drawable.guild_mine_live_bg);
            a16.e(obtain);
        }

        @Override // com.tencent.mobileqq.guild.main.a
        public void d(boolean enableAnimate) {
            this.avatarListView.a(enableAnimate);
            if (enableAnimate) {
                this.statusWrapper.b();
            } else {
                this.statusWrapper.c();
            }
        }

        public final void l(@NotNull ChannelMediaCardItemData item, boolean enableAnimate) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.itemView.setTag(R.id.w1p, item);
            this.itemData = item;
            this.channelNameView.setText(item.getChannelName());
            ChannelMediaCardItemData channelMediaCardItemData = this.itemData;
            ChannelMediaCardItemData channelMediaCardItemData2 = null;
            if (channelMediaCardItemData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                channelMediaCardItemData = null;
            }
            if (channelMediaCardItemData.getHasBottomIcon()) {
                this.memberIcon.setVisibility(0);
            } else {
                this.memberIcon.setVisibility(8);
            }
            TextView textView = this.bottomText;
            ChannelMediaCardItemData channelMediaCardItemData3 = this.itemData;
            if (channelMediaCardItemData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                channelMediaCardItemData3 = null;
            }
            textView.setText(channelMediaCardItemData3.getBottomText());
            c cVar = this.statusWrapper;
            ChannelMediaCardItemData channelMediaCardItemData4 = this.itemData;
            if (channelMediaCardItemData4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                channelMediaCardItemData4 = null;
            }
            String stateAnimUrl = channelMediaCardItemData4.getStateAnimUrl();
            ChannelMediaCardItemData channelMediaCardItemData5 = this.itemData;
            if (channelMediaCardItemData5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                channelMediaCardItemData5 = null;
            }
            cVar.a(stateAnimUrl, channelMediaCardItemData5.getChannelStatusInfo(), enableAnimate);
            m();
            MineVoiceAvatarLayout mineVoiceAvatarLayout = this.avatarListView;
            ChannelMediaCardItemData channelMediaCardItemData6 = this.itemData;
            if (channelMediaCardItemData6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
            } else {
                channelMediaCardItemData2 = channelMediaCardItemData6;
            }
            mineVoiceAvatarLayout.setData(channelMediaCardItemData2.h(), 3, R.drawable.guild_mine_media_in_speech_invite);
            this.avatarListView.a(enableAnimate);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u001a\u0010\u001bJ \u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\rR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/channelcard/delegate/ChannelMediaCardAdapterDelegate$c;", "", "", "stateAnimUrl", "Lcom/tencent/mobileqq/guild/widget/e;", "channelStatusInfo", "", "animateEnable", "", "a", "c", "b", "Landroid/view/ViewStub;", "Landroid/view/ViewStub;", "statusViewStub", "lottieViewStub", "Lcom/tencent/mobileqq/guild/widget/GuildChannelCommonStatusView;", "Lcom/tencent/mobileqq/guild/widget/GuildChannelCommonStatusView;", "statusView", "Lcom/airbnb/lottie/LottieAnimationView;", "d", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieAnimationView", "e", "Z", "isLottieAnimation", "<init>", "(Landroid/view/ViewStub;Landroid/view/ViewStub;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ViewStub statusViewStub;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ViewStub lottieViewStub;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private GuildChannelCommonStatusView statusView;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private LottieAnimationView lottieAnimationView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean isLottieAnimation;

        public c(@NotNull ViewStub statusViewStub, @NotNull ViewStub lottieViewStub) {
            Intrinsics.checkNotNullParameter(statusViewStub, "statusViewStub");
            Intrinsics.checkNotNullParameter(lottieViewStub, "lottieViewStub");
            this.statusViewStub = statusViewStub;
            this.lottieViewStub = lottieViewStub;
        }

        public final void a(@Nullable String stateAnimUrl, @NotNull ChannelStatusInfo channelStatusInfo, boolean animateEnable) {
            boolean z16;
            boolean endsWith$default;
            Intrinsics.checkNotNullParameter(channelStatusInfo, "channelStatusInfo");
            if (stateAnimUrl != null && stateAnimUrl.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            View view = null;
            if (!z16) {
                endsWith$default = StringsKt__StringsJVMKt.endsWith$default(stateAnimUrl, Sticker.JSON_SUFFIX, false, 2, null);
                if (endsWith$default) {
                    this.isLottieAnimation = true;
                    if (this.lottieAnimationView == null) {
                        View inflate = this.lottieViewStub.inflate();
                        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
                        this.lottieAnimationView = (LottieAnimationView) inflate;
                    }
                    LottieAnimationView lottieAnimationView = this.lottieAnimationView;
                    if (lottieAnimationView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("lottieAnimationView");
                        lottieAnimationView = null;
                    }
                    lottieAnimationView.setVisibility(0);
                    LottieAnimationView lottieAnimationView2 = this.lottieAnimationView;
                    if (lottieAnimationView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("lottieAnimationView");
                        lottieAnimationView2 = null;
                    }
                    lottieAnimationView2.cancelAnimation();
                    LottieAnimationView lottieAnimationView3 = this.lottieAnimationView;
                    if (lottieAnimationView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("lottieAnimationView");
                        lottieAnimationView3 = null;
                    }
                    lottieAnimationView3.setAnimationFromUrl(stateAnimUrl);
                    if (animateEnable) {
                        LottieAnimationView lottieAnimationView4 = this.lottieAnimationView;
                        if (lottieAnimationView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("lottieAnimationView");
                            lottieAnimationView4 = null;
                        }
                        lottieAnimationView4.playAnimation();
                    }
                    GuildChannelCommonStatusView guildChannelCommonStatusView = this.statusView;
                    if (guildChannelCommonStatusView != null) {
                        if (guildChannelCommonStatusView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("statusView");
                            guildChannelCommonStatusView = null;
                        }
                        guildChannelCommonStatusView.setAnimateEnable(false);
                        GuildChannelCommonStatusView guildChannelCommonStatusView2 = this.statusView;
                        if (guildChannelCommonStatusView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("statusView");
                        } else {
                            view = guildChannelCommonStatusView2;
                        }
                        view.setVisibility(8);
                        return;
                    }
                    return;
                }
            }
            this.isLottieAnimation = false;
            if (this.statusView == null) {
                View inflate2 = this.statusViewStub.inflate();
                Intrinsics.checkNotNull(inflate2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.widget.GuildChannelCommonStatusView");
                this.statusView = (GuildChannelCommonStatusView) inflate2;
            }
            GuildChannelCommonStatusView guildChannelCommonStatusView3 = this.statusView;
            if (guildChannelCommonStatusView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusView");
                guildChannelCommonStatusView3 = null;
            }
            guildChannelCommonStatusView3.setVisibility(0);
            GuildChannelCommonStatusView guildChannelCommonStatusView4 = this.statusView;
            if (guildChannelCommonStatusView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusView");
                guildChannelCommonStatusView4 = null;
            }
            guildChannelCommonStatusView4.g(channelStatusInfo, animateEnable);
            LottieAnimationView lottieAnimationView5 = this.lottieAnimationView;
            if (lottieAnimationView5 != null) {
                if (lottieAnimationView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lottieAnimationView");
                    lottieAnimationView5 = null;
                }
                if (lottieAnimationView5.isAnimating()) {
                    LottieAnimationView lottieAnimationView6 = this.lottieAnimationView;
                    if (lottieAnimationView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("lottieAnimationView");
                        lottieAnimationView6 = null;
                    }
                    lottieAnimationView6.cancelAnimation();
                }
                LottieAnimationView lottieAnimationView7 = this.lottieAnimationView;
                if (lottieAnimationView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lottieAnimationView");
                } else {
                    view = lottieAnimationView7;
                }
                view.setVisibility(8);
            }
        }

        public final void b() {
            GuildChannelCommonStatusView guildChannelCommonStatusView = null;
            LottieAnimationView lottieAnimationView = null;
            if (this.isLottieAnimation) {
                LottieAnimationView lottieAnimationView2 = this.lottieAnimationView;
                if (lottieAnimationView2 != null) {
                    if (lottieAnimationView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("lottieAnimationView");
                        lottieAnimationView2 = null;
                    }
                    if (!lottieAnimationView2.isAnimating()) {
                        LottieAnimationView lottieAnimationView3 = this.lottieAnimationView;
                        if (lottieAnimationView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("lottieAnimationView");
                        } else {
                            lottieAnimationView = lottieAnimationView3;
                        }
                        lottieAnimationView.playAnimation();
                        return;
                    }
                    return;
                }
                return;
            }
            GuildChannelCommonStatusView guildChannelCommonStatusView2 = this.statusView;
            if (guildChannelCommonStatusView2 != null) {
                if (guildChannelCommonStatusView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("statusView");
                } else {
                    guildChannelCommonStatusView = guildChannelCommonStatusView2;
                }
                guildChannelCommonStatusView.setAnimateEnable(true);
            }
        }

        public final void c() {
            GuildChannelCommonStatusView guildChannelCommonStatusView = null;
            LottieAnimationView lottieAnimationView = null;
            if (this.isLottieAnimation) {
                LottieAnimationView lottieAnimationView2 = this.lottieAnimationView;
                if (lottieAnimationView2 != null) {
                    if (lottieAnimationView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("lottieAnimationView");
                        lottieAnimationView2 = null;
                    }
                    if (lottieAnimationView2.isAnimating()) {
                        LottieAnimationView lottieAnimationView3 = this.lottieAnimationView;
                        if (lottieAnimationView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("lottieAnimationView");
                        } else {
                            lottieAnimationView = lottieAnimationView3;
                        }
                        lottieAnimationView.cancelAnimation();
                        return;
                    }
                    return;
                }
                return;
            }
            GuildChannelCommonStatusView guildChannelCommonStatusView2 = this.statusView;
            if (guildChannelCommonStatusView2 != null) {
                if (guildChannelCommonStatusView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("statusView");
                } else {
                    guildChannelCommonStatusView = guildChannelCommonStatusView2;
                }
                guildChannelCommonStatusView.setAnimateEnable(false);
            }
        }
    }

    public ChannelMediaCardAdapterDelegate(@NotNull cg1.b channelCardControl) {
        Intrinsics.checkNotNullParameter(channelCardControl, "channelCardControl");
        this.channelCardControl = channelCardControl;
    }

    private final void p(View view) {
        if (!o.c("fastClickGuard")) {
            Object tag = view.getTag(R.id.w1p);
            if (!(tag instanceof ChannelMediaCardItemData)) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "onClick invalid, data:" + tag;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.featured.FeaturedGuildTextAdapterDelegate", 1, (String) it.next(), null);
                }
                return;
            }
            ChannelMediaCardItemData channelMediaCardItemData = (ChannelMediaCardItemData) tag;
            this.channelCardControl.z0(String.valueOf(channelMediaCardItemData.getChannelId()), channelMediaCardItemData.getChannelType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ChannelMediaCardAdapterDelegate this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.p(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull dg1.b item, @NotNull List<dg1.b> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof ChannelMediaCardItemData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull ChannelMediaCardItemData item, @NotNull a holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        cg1.b bVar = this.channelCardControl;
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        bVar.s1(view, holder.getAdapterPosition(), item);
        if (payloads.isEmpty()) {
            holder.l(item, this.channelCardControl.a());
            cg1.b bVar2 = this.channelCardControl;
            View view2 = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
            bVar2.A0(view2);
            return;
        }
        if (payloads.contains(1)) {
            cg1.b bVar3 = this.channelCardControl;
            View view3 = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view3, "holder.itemView");
            bVar3.A0(view3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public a d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.eic, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        com.tencent.mobileqq.guild.component.token.c.c(itemView, null, 2, null);
        itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channelcard.delegate.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChannelMediaCardAdapterDelegate.t(ChannelMediaCardAdapterDelegate.this, view);
            }
        });
        return new a(itemView, this.channelCardControl);
    }
}

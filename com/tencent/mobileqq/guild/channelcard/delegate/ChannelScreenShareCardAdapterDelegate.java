package com.tencent.mobileqq.guild.channelcard.delegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.channelcard.videoplay.GuildVideoPlayController;
import com.tencent.mobileqq.guild.discovery.widget.SmallUserAvatarList;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.widget.GuildChannelCommonStatusView;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dg1.ChannelScreenShareCardItemData;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001d2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J&\u0010\u0016\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\nH\u0014R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/channelcard/delegate/ChannelScreenShareCardAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Ldg1/f;", "Ldg1/b;", "Lcom/tencent/mobileqq/guild/channelcard/delegate/ChannelScreenShareCardAdapterDelegate$a;", "Landroid/view/View;", "view", "", "p", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, ReportConstant.COSTREPORT_PREFIX, "holder", "", "payloads", "r", "Lcg1/b;", "d", "Lcg1/b;", "channelCardControl", "<init>", "(Lcg1/b;)V", "e", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ChannelScreenShareCardAdapterDelegate extends AbsListItemAdapterDelegate<ChannelScreenShareCardItemData, dg1.b, a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final cg1.b channelCardControl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\f\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u0013R\u0014\u0010$\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001f\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/channelcard/delegate/ChannelScreenShareCardAdapterDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/channelcard/videoplay/a;", "Ldg1/f;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "l", "Lcom/tencent/mobileqq/guild/channelcard/videoplay/GuildVideoPlayController;", "playController", "j", "E", "Ldg1/f;", "itemData", "Lcom/tencent/mobileqq/guild/widget/GuildChannelCommonStatusView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/widget/GuildChannelCommonStatusView;", "statusView", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "coverImage", "Landroid/widget/FrameLayout;", "H", "Landroid/widget/FrameLayout;", "videoViewContainer", "Lcom/tencent/mobileqq/guild/discovery/widget/SmallUserAvatarList;", "I", "Lcom/tencent/mobileqq/guild/discovery/widget/SmallUserAvatarList;", "avatarListView", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "channelNameView", "K", "memberIcon", "L", "memberCount", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends RecyclerView.ViewHolder implements com.tencent.mobileqq.guild.channelcard.videoplay.a {

        /* renamed from: E, reason: from kotlin metadata */
        private ChannelScreenShareCardItemData itemData;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private GuildChannelCommonStatusView statusView;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final ImageView coverImage;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final FrameLayout videoViewContainer;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final SmallUserAvatarList avatarListView;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final TextView channelNameView;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private final ImageView memberIcon;

        /* renamed from: L, reason: from kotlin metadata */
        @NotNull
        private final TextView memberCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.f166909dx1);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.status_view)");
            this.statusView = (GuildChannelCommonStatusView) findViewById;
            View findViewById2 = view.findViewById(R.id.f164921bb4);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.cover_image)");
            this.coverImage = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.f167092kq3);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.video_container)");
            this.videoViewContainer = (FrameLayout) findViewById3;
            View findViewById4 = view.findViewById(R.id.t1l);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.avatar_list)");
            this.avatarListView = (SmallUserAvatarList) findViewById4;
            View findViewById5 = view.findViewById(R.id.ato);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.channel_name)");
            this.channelNameView = (TextView) findViewById5;
            View findViewById6 = view.findViewById(R.id.z1x);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.member_icon)");
            this.memberIcon = (ImageView) findViewById6;
            View findViewById7 = view.findViewById(R.id.eom);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.member_count)");
            this.memberCount = (TextView) findViewById7;
        }

        @Override // com.tencent.mobileqq.guild.channelcard.videoplay.a
        public void j(@NotNull GuildVideoPlayController playController) {
            boolean z16;
            Intrinsics.checkNotNullParameter(playController, "playController");
            ChannelScreenShareCardItemData channelScreenShareCardItemData = this.itemData;
            if (channelScreenShareCardItemData == null) {
                return;
            }
            ChannelScreenShareCardItemData channelScreenShareCardItemData2 = null;
            if (channelScreenShareCardItemData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                channelScreenShareCardItemData = null;
            }
            String streamUrl = channelScreenShareCardItemData.getStreamUrl();
            if (streamUrl != null && streamUrl.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return;
            }
            ChannelScreenShareCardItemData channelScreenShareCardItemData3 = this.itemData;
            if (channelScreenShareCardItemData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
            } else {
                channelScreenShareCardItemData2 = channelScreenShareCardItemData3;
            }
            String streamUrl2 = channelScreenShareCardItemData2.getStreamUrl();
            Intrinsics.checkNotNull(streamUrl2);
            playController.c(streamUrl2, this.videoViewContainer, this.coverImage);
        }

        public final void l(@NotNull ChannelScreenShareCardItemData item) {
            boolean z16;
            Intrinsics.checkNotNullParameter(item, "item");
            this.itemView.setTag(R.id.w1p, item);
            this.itemData = item;
            this.channelNameView.setText(item.getChannelName());
            if (item.h().isEmpty()) {
                this.avatarListView.setVisibility(8);
            } else {
                this.avatarListView.setVisibility(0);
                this.avatarListView.f(item.h());
            }
            if (item.getMemberCount().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.memberIcon.setVisibility(8);
                this.memberCount.setVisibility(8);
            } else {
                this.memberIcon.setVisibility(0);
                this.memberCount.setVisibility(0);
                this.memberCount.setText(item.getMemberCount());
            }
            com.tencent.mobileqq.guild.picload.e a16 = com.tencent.mobileqq.guild.picload.e.a();
            Option obtain = Option.obtain();
            obtain.setTargetView(this.coverImage);
            obtain.setUrl(item.getCoverImageUrl());
            obtain.setLoadingDrawableId(R.drawable.guild_mine_media_screen_share_bg);
            obtain.setFailedDrawableId(R.drawable.guild_mine_media_screen_share_bg);
            obtain.setNeedFilterUrl(false);
            a16.e(obtain);
        }
    }

    public ChannelScreenShareCardAdapterDelegate(@NotNull cg1.b channelCardControl) {
        Intrinsics.checkNotNullParameter(channelCardControl, "channelCardControl");
        this.channelCardControl = channelCardControl;
    }

    private final void p(View view) {
        if (!o.c("fastClickGuard")) {
            Object tag = view.getTag(R.id.w1p);
            if (!(tag instanceof ChannelScreenShareCardItemData)) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "onClick invalid, data:" + tag;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.userl.ChannelScreenShareCardAdapterDelegate", 1, (String) it.next(), null);
                }
                return;
            }
            ChannelScreenShareCardItemData channelScreenShareCardItemData = (ChannelScreenShareCardItemData) tag;
            this.channelCardControl.z0(String.valueOf(channelScreenShareCardItemData.getChannelId()), channelScreenShareCardItemData.getChannelType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ChannelScreenShareCardAdapterDelegate this$0, View it) {
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
        return item instanceof ChannelScreenShareCardItemData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull ChannelScreenShareCardItemData item, @NotNull a holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        cg1.b bVar = this.channelCardControl;
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        bVar.s1(view, holder.getAdapterPosition(), item);
        if (payloads.isEmpty()) {
            holder.l(item);
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
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.eik, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        com.tencent.mobileqq.guild.component.token.c.c(itemView, null, 2, null);
        itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channelcard.delegate.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChannelScreenShareCardAdapterDelegate.t(ChannelScreenShareCardAdapterDelegate.this, view);
            }
        });
        return new a(itemView);
    }
}

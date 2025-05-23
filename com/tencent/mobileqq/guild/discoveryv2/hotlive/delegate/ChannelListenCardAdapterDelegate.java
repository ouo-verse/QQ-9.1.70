package com.tencent.mobileqq.guild.discoveryv2.hotlive.delegate;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.guild.discoveryv2.hotlive.delegate.ChannelListenCardAdapterDelegate;
import com.tencent.mobileqq.guild.discoveryv2.hotlive.view.VoicingLinearLayout;
import com.tencent.mobileqq.guild.home.activechannel.view.GuildHomeActiveChannelMaskView;
import com.tencent.mobileqq.guild.util.GuildBannerPalette;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import gi1.ChannelListenCardItemData;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import vp1.bo;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002 !B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J&\u0010\u0016\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\nH\u0014J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0017H\u0014R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/delegate/ChannelListenCardAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lgi1/c;", "Lgi1/b;", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/delegate/ChannelListenCardAdapterDelegate$ChannelViewHolder;", "Landroid/view/View;", "view", "", "p", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, ReportConstant.COSTREPORT_PREFIX, "holder", "", "payloads", "r", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", tl.h.F, "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;", "d", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;", "channelCardControl", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;)V", "e", "ChannelViewHolder", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ChannelListenCardAdapterDelegate extends AbsListItemAdapterDelegate<ChannelListenCardItemData, gi1.b, ChannelViewHolder> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.discoveryv2.hotlive.d channelCardControl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b!\u0010\"J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0006\u0010\t\u001a\u00020\u0007J\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/delegate/ChannelListenCardAdapterDelegate$ChannelViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/main/a;", "", "coverUrl", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", ReportConstant.COSTREPORT_PREFIX, "u", "Lgi1/c;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "enableAnimate", "p", "d", "Lvp1/bo;", "E", "Lvp1/bo;", "binding", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;", "getChannelCardControl", "()Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;", "channelCardControl", "G", "Lgi1/c;", "itemData", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/h;", "H", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/h;", "statusWrapper", "<init>", "(Lvp1/bo;Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class ChannelViewHolder extends RecyclerView.ViewHolder implements com.tencent.mobileqq.guild.main.a {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final bo binding;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.guild.discoveryv2.hotlive.d channelCardControl;

        /* renamed from: G, reason: from kotlin metadata */
        private ChannelListenCardItemData itemData;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.guild.discoveryv2.hotlive.h statusWrapper;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelViewHolder(@NotNull bo binding, @NotNull com.tencent.mobileqq.guild.discoveryv2.hotlive.d channelCardControl) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(channelCardControl, "channelCardControl");
            this.binding = binding;
            this.channelCardControl = channelCardControl;
            LottieAnimationView lottieAnimationView = binding.f442532h;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.channelStatusAnim");
            TextView textView = binding.f442533i;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.channelStatusText");
            this.statusWrapper = new com.tencent.mobileqq.guild.discoveryv2.hotlive.h(lottieAnimationView, textView);
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            channelCardControl.A0(itemView);
            VoicingLinearLayout voicingLinearLayout = binding.f442527c;
            Intrinsics.checkNotNullExpressionValue(voicingLinearLayout, "binding.avatarList");
            channelCardControl.c(voicingLinearLayout);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(final ChannelViewHolder this$0, final ChannelListenCardItemData item, final Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            if (bitmap == null) {
                Logger.f235387a.d().w("ChannelNormalMediaCardAdapterDelegate", 1, "loadCommonPic error: " + item.getCoverImageUrl());
                this$0.binding.f442534j.setImageResource(R.drawable.guild_home_active_channel_audio_normal_bg);
                GuildHomeActiveChannelMaskView guildHomeActiveChannelMaskView = this$0.binding.f442526b;
                Intrinsics.checkNotNullExpressionValue(guildHomeActiveChannelMaskView, "binding.activeChannelBgMask");
                guildHomeActiveChannelMaskView.setVisibility(8);
                return;
            }
            this$0.binding.f442534j.setImageDrawable(new BitmapDrawable(bitmap));
            this$0.binding.f442534j.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.hotlive.delegate.c
                @Override // java.lang.Runnable
                public final void run() {
                    ChannelListenCardAdapterDelegate.ChannelViewHolder.r(ChannelListenCardAdapterDelegate.ChannelViewHolder.this, item, bitmap);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(ChannelViewHolder this$0, ChannelListenCardItemData item, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
            Intrinsics.checkNotNull(f16);
            CorountineFunKt.e(f16, "ChannelNormalMediaCardAdapterDelegate bindData", null, null, null, new ChannelListenCardAdapterDelegate$ChannelViewHolder$bindView$1$2$1(this$0, item, bitmap, null), 14, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void s(String coverUrl, Bitmap bitmap) {
            final int e16;
            int measuredWidth = this.binding.f442534j.getMeasuredWidth();
            int measuredHeight = this.binding.f442534j.getMeasuredHeight();
            if (measuredWidth > 0 && measuredHeight > 0) {
                Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                this.binding.f442534j.draw(new Canvas(createBitmap));
                e16 = GuildBannerPalette.e(createBitmap);
            } else {
                e16 = GuildBannerPalette.e(bitmap);
            }
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("ChannelNormalMediaCardAdapterDelegate", 1, "bindData mainColor:" + Util.toHexString(e16) + " url:" + coverUrl);
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.hotlive.delegate.d
                @Override // java.lang.Runnable
                public final void run() {
                    ChannelListenCardAdapterDelegate.ChannelViewHolder.t(ChannelListenCardAdapterDelegate.ChannelViewHolder.this, e16);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void t(ChannelViewHolder this$0, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.binding.f442526b.a(i3);
            GuildHomeActiveChannelMaskView guildHomeActiveChannelMaskView = this$0.binding.f442526b;
            Intrinsics.checkNotNullExpressionValue(guildHomeActiveChannelMaskView, "binding.activeChannelBgMask");
            guildHomeActiveChannelMaskView.setVisibility(0);
        }

        @Override // com.tencent.mobileqq.guild.main.a
        public void d(boolean enableAnimate) {
            if (enableAnimate) {
                this.binding.f442527c.b();
                this.statusWrapper.b();
            } else {
                this.binding.f442527c.c();
                this.statusWrapper.c();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x00bd A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00be  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void p(@NotNull final ChannelListenCardItemData item, boolean enableAnimate) {
            int i3;
            Intrinsics.checkNotNullParameter(item, "item");
            this.itemView.setTag(R.id.w1p, item);
            this.itemData = item;
            this.binding.f442531g.setText(item.getChannelName());
            ImageView imageView = this.binding.f442536l;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.memberIcon");
            if (item.getHasBottomIcon()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
            TextView textView = this.binding.f442529e;
            ChannelListenCardItemData channelListenCardItemData = this.itemData;
            ChannelListenCardItemData channelListenCardItemData2 = null;
            if (channelListenCardItemData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                channelListenCardItemData = null;
            }
            textView.setText(channelListenCardItemData.getBottomText());
            com.tencent.mobileqq.guild.discoveryv2.hotlive.h hVar = this.statusWrapper;
            ChannelListenCardItemData channelListenCardItemData3 = this.itemData;
            if (channelListenCardItemData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                channelListenCardItemData3 = null;
            }
            hVar.a(channelListenCardItemData3.getChannelStatusInfo(), enableAnimate);
            com.tencent.mobileqq.guild.discoveryv2.hotlive.e eVar = com.tencent.mobileqq.guild.discoveryv2.hotlive.e.f217491a;
            RoundImageView roundImageView = this.binding.f442535k;
            Intrinsics.checkNotNullExpressionValue(roundImageView, "binding.guildIcon");
            com.tencent.mobileqq.guild.discoveryv2.hotlive.e.b(eVar, roundImageView, item.getGuildIcon(), null, 4, null);
            VoicingLinearLayout voicingLinearLayout = this.binding.f442527c;
            ChannelListenCardItemData channelListenCardItemData4 = this.itemData;
            if (channelListenCardItemData4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                channelListenCardItemData4 = null;
            }
            voicingLinearLayout.setData(channelListenCardItemData4.g());
            if (enableAnimate) {
                ChannelListenCardItemData channelListenCardItemData5 = this.itemData;
                if (channelListenCardItemData5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemData");
                } else {
                    channelListenCardItemData2 = channelListenCardItemData5;
                }
                if (!channelListenCardItemData2.g().isEmpty()) {
                    this.binding.f442527c.b();
                    if (!Intrinsics.areEqual(this.binding.f442534j.getTag(), item.getCoverImageUrl())) {
                        return;
                    }
                    this.binding.f442534j.setTag(item.getCoverImageUrl());
                    v.f(item.getCoverImageUrl(), this.binding.f442534j.getMeasuredWidth(), this.binding.f442534j.getMeasuredHeight(), new GuildLevelRoleView.a() { // from class: com.tencent.mobileqq.guild.discoveryv2.hotlive.delegate.b
                        @Override // com.tencent.mobileqq.guild.widget.GuildLevelRoleView.a
                        public final void a(Bitmap bitmap) {
                            ChannelListenCardAdapterDelegate.ChannelViewHolder.q(ChannelListenCardAdapterDelegate.ChannelViewHolder.this, item, bitmap);
                        }
                    });
                    return;
                }
            }
            this.binding.f442527c.c();
            if (!Intrinsics.areEqual(this.binding.f442534j.getTag(), item.getCoverImageUrl())) {
            }
        }

        public final void u() {
            com.tencent.mobileqq.guild.discoveryv2.hotlive.d dVar = this.channelCardControl;
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            dVar.A0(itemView);
            com.tencent.mobileqq.guild.discoveryv2.hotlive.d dVar2 = this.channelCardControl;
            VoicingLinearLayout voicingLinearLayout = this.binding.f442527c;
            Intrinsics.checkNotNullExpressionValue(voicingLinearLayout, "binding.avatarList");
            dVar2.c(voicingLinearLayout);
        }
    }

    public ChannelListenCardAdapterDelegate(@NotNull com.tencent.mobileqq.guild.discoveryv2.hotlive.d channelCardControl) {
        Intrinsics.checkNotNullParameter(channelCardControl, "channelCardControl");
        this.channelCardControl = channelCardControl;
    }

    private final void p(View view) {
        if (!o.c("fastClickGuard")) {
            Object tag = view.getTag(R.id.w1p);
            if (!(tag instanceof ChannelListenCardItemData)) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "onClick invalid, data:" + tag;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("ChannelNormalMediaCardAdapterDelegate", 1, (String) it.next(), null);
                }
                return;
            }
            this.channelCardControl.d((gi1.a) tag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ChannelListenCardAdapterDelegate this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.p(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void h(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.h(holder);
        if (holder instanceof com.tencent.mobileqq.guild.main.a) {
            ((com.tencent.mobileqq.guild.main.a) holder).d(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull gi1.b item, @NotNull List<gi1.b> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof ChannelListenCardItemData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull ChannelListenCardItemData item, @NotNull ChannelViewHolder holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        com.tencent.mobileqq.guild.discoveryv2.hotlive.d dVar = this.channelCardControl;
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        dVar.e(view, holder.getAdapterPosition(), item);
        if (payloads.contains(1)) {
            holder.u();
        } else {
            holder.u();
            holder.p(item, this.channelCardControl.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public ChannelViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        bo g16 = bo.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        RadiusFrameLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        com.tencent.mobileqq.guild.component.token.c.c(root, null, 2, null);
        g16.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.hotlive.delegate.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChannelListenCardAdapterDelegate.t(ChannelListenCardAdapterDelegate.this, view);
            }
        });
        return new ChannelViewHolder(g16, this.channelCardControl);
    }
}

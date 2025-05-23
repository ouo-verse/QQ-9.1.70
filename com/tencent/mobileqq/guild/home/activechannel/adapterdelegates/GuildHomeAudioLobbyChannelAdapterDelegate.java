package com.tencent.mobileqq.guild.home.activechannel.adapterdelegates;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeAudioLobbyChannelAdapterDelegate;
import com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate;
import com.tencent.mobileqq.guild.home.activechannel.view.GuildHomeActiveChannelMaskView;
import com.tencent.mobileqq.guild.home.activechannel.view.GuildHomeActiveChannelMicAvatarView;
import com.tencent.mobileqq.guild.util.GuildBannerPalette;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import qo1.a;
import so1.GuildHomeAudioLobbyChannelUIData;
import so1.h;
import vp1.bb;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001c\u001dB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014J0\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00032\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u0006H\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeAudioLobbyChannelAdapterDelegate;", "Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeChannelBaseAdapterDelegate;", "Lso1/d;", "Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeAudioLobbyChannelAdapterDelegate$LiveViewHolder;", "Lso1/h;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "k", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "holder", "", "", "payloads", com.tencent.luggage.wxa.c8.c.G, "", DomainData.DOMAIN_NAME, "Lqo1/a$b;", "e", "Lqo1/a$b;", "callback", "<init>", "(Lqo1/a$b;)V", "f", "a", "LiveViewHolder", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeAudioLobbyChannelAdapterDelegate extends GuildHomeChannelBaseAdapterDelegate<GuildHomeAudioLobbyChannelUIData, LiveViewHolder> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a.b callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeAudioLobbyChannelAdapterDelegate$LiveViewHolder;", "Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeChannelBaseAdapterDelegate$a;", "", "coverUrl", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "H", "Lso1/d;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "B", ReportConstant.COSTREPORT_PREFIX, "t", "getTag", "Lvp1/bb;", "Lvp1/bb;", "binding", "Lqo1/a$b;", "I", "Lqo1/a$b;", "callback", "J", "Lso1/d;", "itemData", "", "Lcom/tencent/mobileqq/guild/home/activechannel/view/GuildHomeActiveChannelMicAvatarView;", "K", "Ljava/util/List;", "avatarList", "<init>", "(Lvp1/bb;Lqo1/a$b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class LiveViewHolder extends GuildHomeChannelBaseAdapterDelegate.a {

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final bb binding;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final a.b callback;

        /* renamed from: J, reason: from kotlin metadata */
        private GuildHomeAudioLobbyChannelUIData itemData;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private final List<GuildHomeActiveChannelMicAvatarView> avatarList;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public LiveViewHolder(@NotNull bb binding, @NotNull a.b callback) {
            super(r0);
            List<GuildHomeActiveChannelMicAvatarView> listOf;
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(callback, "callback");
            RadiusFrameLayout root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            this.binding = binding;
            this.callback = callback;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new GuildHomeActiveChannelMicAvatarView[]{binding.f442397d, binding.f442398e, binding.f442399f, binding.f442400g});
            this.avatarList = listOf;
            binding.getRoot().post(new Runnable() { // from class: com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.h
                @Override // java.lang.Runnable
                public final void run() {
                    GuildHomeAudioLobbyChannelAdapterDelegate.LiveViewHolder.z(GuildHomeAudioLobbyChannelAdapterDelegate.LiveViewHolder.this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void C(final LiveViewHolder this$0, final GuildHomeAudioLobbyChannelUIData item, final Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            if (bitmap != null) {
                this$0.binding.f442395b.setImageDrawable(new BitmapDrawable(bitmap));
                this$0.binding.f442395b.post(new Runnable() { // from class: com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildHomeAudioLobbyChannelAdapterDelegate.LiveViewHolder.D(GuildHomeAudioLobbyChannelAdapterDelegate.LiveViewHolder.this, item, bitmap);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D(LiveViewHolder this$0, GuildHomeAudioLobbyChannelUIData item, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
            Intrinsics.checkNotNull(f16);
            CorountineFunKt.e(f16, "Guild.NewHome.content.active.Delegate.AudioLobby bindData", null, null, null, new GuildHomeAudioLobbyChannelAdapterDelegate$LiveViewHolder$bindData$2$1$1$1(this$0, item, bitmap, null), 14, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void E(LiveViewHolder this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            a.b bVar = this$0.callback;
            GuildHomeAudioLobbyChannelUIData guildHomeAudioLobbyChannelUIData = this$0.itemData;
            if (guildHomeAudioLobbyChannelUIData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                guildHomeAudioLobbyChannelUIData = null;
            }
            bVar.a(guildHomeAudioLobbyChannelUIData);
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void H(String coverUrl, Bitmap bitmap) {
            final int e16;
            if (this.binding.f442395b.getMeasuredWidth() > 0 && this.binding.f442395b.getMeasuredHeight() > 0) {
                Bitmap createBitmap = Bitmap.createBitmap(this.binding.f442395b.getMeasuredWidth(), this.binding.f442395b.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                this.binding.f442395b.draw(new Canvas(createBitmap));
                e16 = GuildBannerPalette.e(createBitmap);
            } else {
                e16 = GuildBannerPalette.e(bitmap);
            }
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.NewHome.content.active.Delegate.AudioLobby", 1, "bindData mainColor:" + Util.toHexString(e16) + " url:" + coverUrl);
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.l
                @Override // java.lang.Runnable
                public final void run() {
                    GuildHomeAudioLobbyChannelAdapterDelegate.LiveViewHolder.I(GuildHomeAudioLobbyChannelAdapterDelegate.LiveViewHolder.this, e16);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void I(LiveViewHolder this$0, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.binding.f442396c.a(i3);
            GuildHomeActiveChannelMaskView guildHomeActiveChannelMaskView = this$0.binding.f442396c;
            Intrinsics.checkNotNullExpressionValue(guildHomeActiveChannelMaskView, "binding.activeChannelBgMask");
            guildHomeActiveChannelMaskView.setVisibility(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(final LiveViewHolder this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildHomeAudioLobbyChannelAdapterDelegate.LiveViewHolder.E(GuildHomeAudioLobbyChannelAdapterDelegate.LiveViewHolder.this, view);
                }
            });
            this$0.binding.f442401h.setAnimation(HardCodeUtil.qqStr(R.string.f1487210c));
            this$0.binding.f442402i.setBackgroundResource(R.drawable.guild_home_active_channel_status_icon_bg);
            RadiusFrameLayout root = this$0.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            com.tencent.mobileqq.guild.component.token.c.c(root, null, 2, null);
        }

        public final void B(@NotNull final GuildHomeAudioLobbyChannelUIData item) {
            Object orNull;
            boolean z16;
            int i3;
            Object orNull2;
            Intrinsics.checkNotNullParameter(item, "item");
            this.itemData = item;
            this.binding.f442406m.setText(item.getTitle());
            int noMemberMaxLimit = item.getNoMemberMaxLimit();
            int memberMax = item.getMemberMax();
            int memberCount = item.getMemberCount();
            TextView textView = this.binding.f442404k;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.homeActivePeopleNumber");
            r(noMemberMaxLimit, memberMax, memberCount, textView);
            int i16 = 0;
            for (Object obj : this.avatarList) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                GuildHomeActiveChannelMicAvatarView micAvatarView = (GuildHomeActiveChannelMicAvatarView) obj;
                Intrinsics.checkNotNullExpressionValue(micAvatarView, "micAvatarView");
                orNull = CollectionsKt___CollectionsKt.getOrNull(item.j(), i16);
                if (orNull != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                micAvatarView.setVisibility(i3);
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(item.j(), i16);
                h.MicUser micUser = (h.MicUser) orNull2;
                if (micUser != null) {
                    micAvatarView.g(new GuildHomeActiveChannelMicAvatarView.AvatarInfo(item.getGuildId(), micUser.getTinyId(), micUser.getAvatarMeta(), micUser.getIsMicOpening()));
                    if (q()) {
                        micAvatarView.e();
                    }
                }
                i16 = i17;
            }
            if (item.j().isEmpty()) {
                GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView = this.binding.f442397d;
                Intrinsics.checkNotNullExpressionValue(guildHomeActiveChannelMicAvatarView, "binding.activeChannelMemberAvatar1");
                guildHomeActiveChannelMicAvatarView.setVisibility(0);
                this.binding.f442397d.setDefaultImageView(R.drawable.guild_audio_user_default);
            }
            if (Intrinsics.areEqual(this.binding.f442395b.getTag(), item.getCoverUrl())) {
                return;
            }
            this.binding.f442395b.setTag(item.getCoverUrl());
            com.tencent.mobileqq.guild.util.v.f(item.getCoverUrl(), this.binding.f442395b.getMeasuredWidth(), this.binding.f442395b.getMeasuredHeight(), new GuildLevelRoleView.a() { // from class: com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.j
                @Override // com.tencent.mobileqq.guild.widget.GuildLevelRoleView.a
                public final void a(Bitmap bitmap) {
                    GuildHomeAudioLobbyChannelAdapterDelegate.LiveViewHolder.C(GuildHomeAudioLobbyChannelAdapterDelegate.LiveViewHolder.this, item, bitmap);
                }
            });
        }

        @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate.a
        @NotNull
        public String getTag() {
            return "Guild.NewHome.content.active.Delegate.AudioLobby";
        }

        @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate.a
        public void s() {
            this.binding.f442401h.playAnimation();
            Iterator<T> it = this.avatarList.iterator();
            while (it.hasNext()) {
                ((GuildHomeActiveChannelMicAvatarView) it.next()).e();
            }
        }

        @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate.a
        public void t() {
            this.binding.f442401h.cancelAnimation();
            Iterator<T> it = this.avatarList.iterator();
            while (it.hasNext()) {
                ((GuildHomeActiveChannelMicAvatarView) it.next()).b();
            }
        }
    }

    public GuildHomeAudioLobbyChannelAdapterDelegate(@NotNull a.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    public RecyclerView.ViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        bb g16 = bb.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026rent, false\n            )");
        return new LiveViewHolder(g16, this.callback);
    }

    @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate
    protected boolean k(@NotNull so1.h item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof GuildHomeAudioLobbyChannelUIData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void m(@NotNull GuildHomeAudioLobbyChannelUIData item, @NotNull LiveViewHolder holder, @NotNull List<? extends Object> payloads, int pos) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.content.active.Delegate.AudioLobby", 1, "onBindViewHolder item:" + item);
        }
        holder.B(item);
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        new ro1.b(view).c(item.getChannelId()).f(pos).g(item.getSessionId()).b(item.getCardType()).d(1).a().d();
    }
}

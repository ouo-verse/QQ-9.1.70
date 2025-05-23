package com.tencent.mobileqq.guild.home.activechannel.adapterdelegates;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeAudioPlayChannelAdapterDelegate;
import com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate;
import com.tencent.mobileqq.guild.home.activechannel.view.GuildHomeActiveChannelMicAvatarView;
import com.tencent.mobileqq.guild.util.Logger;
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
import org.jetbrains.annotations.NotNull;
import qo1.a;
import so1.GuildHomeAudioPlayChannelUIData;
import so1.h;
import vp1.bd;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001c\u001dB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014J0\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00032\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u0006H\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeAudioPlayChannelAdapterDelegate;", "Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeChannelBaseAdapterDelegate;", "Lso1/f;", "Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeAudioPlayChannelAdapterDelegate$b;", "Lso1/h;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "k", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "holder", "", "", "payloads", com.tencent.luggage.wxa.c8.c.G, "", DomainData.DOMAIN_NAME, "Lqo1/a$b;", "e", "Lqo1/a$b;", "callback", "<init>", "(Lqo1/a$b;)V", "f", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeAudioPlayChannelAdapterDelegate extends GuildHomeChannelBaseAdapterDelegate<GuildHomeAudioPlayChannelUIData, b> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a.b callback;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeAudioPlayChannelAdapterDelegate$b;", "Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeChannelBaseAdapterDelegate$a;", "Lso1/f;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", HippyTKDListViewAdapter.X, ReportConstant.COSTREPORT_PREFIX, "t", "", "getTag", "Lvp1/bd;", "H", "Lvp1/bd;", "binding", "Lqo1/a$b;", "I", "Lqo1/a$b;", "callback", "J", "Lso1/f;", "itemData", "", "Lcom/tencent/mobileqq/guild/home/activechannel/view/GuildHomeActiveChannelMicAvatarView;", "K", "Ljava/util/List;", "avatarList", "<init>", "(Lvp1/bd;Lqo1/a$b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GuildHomeChannelBaseAdapterDelegate.a {

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final bd binding;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final a.b callback;

        /* renamed from: J, reason: from kotlin metadata */
        private GuildHomeAudioPlayChannelUIData itemData;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private final List<GuildHomeActiveChannelMicAvatarView> avatarList;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b(@NotNull bd binding, @NotNull a.b callback) {
            super(r0);
            List<GuildHomeActiveChannelMicAvatarView> listOf;
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ConstraintLayout mContainer = binding.getMContainer();
            Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
            this.binding = binding;
            this.callback = callback;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new GuildHomeActiveChannelMicAvatarView[]{binding.f442422c, binding.f442423d, binding.f442424e, binding.f442425f});
            this.avatarList = listOf;
            binding.getMContainer().post(new Runnable() { // from class: com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.o
                @Override // java.lang.Runnable
                public final void run() {
                    GuildHomeAudioPlayChannelAdapterDelegate.b.w(GuildHomeAudioPlayChannelAdapterDelegate.b.this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void w(final b this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.binding.getMContainer().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildHomeAudioPlayChannelAdapterDelegate.b.y(GuildHomeAudioPlayChannelAdapterDelegate.b.this, view);
                }
            });
            this$0.binding.f442426g.setAnimation(HardCodeUtil.qqStr(R.string.f1487210c));
            this$0.binding.f442427h.setBackgroundResource(R.drawable.guild_home_active_channel_status_icon_bg);
            ConstraintLayout mContainer = this$0.binding.getMContainer();
            Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
            com.tencent.mobileqq.guild.component.token.c.c(mContainer, null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(b this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            a.b bVar = this$0.callback;
            GuildHomeAudioPlayChannelUIData guildHomeAudioPlayChannelUIData = this$0.itemData;
            if (guildHomeAudioPlayChannelUIData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                guildHomeAudioPlayChannelUIData = null;
            }
            bVar.a(guildHomeAudioPlayChannelUIData);
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate.a
        @NotNull
        public String getTag() {
            return "Guild.NewHome.content.active.Delegate.AudioPlay";
        }

        @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate.a
        public void s() {
            this.binding.f442426g.playAnimation();
            Iterator<T> it = this.avatarList.iterator();
            while (it.hasNext()) {
                ((GuildHomeActiveChannelMicAvatarView) it.next()).e();
            }
        }

        @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate.a
        public void t() {
            this.binding.f442426g.cancelAnimation();
            Iterator<T> it = this.avatarList.iterator();
            while (it.hasNext()) {
                ((GuildHomeActiveChannelMicAvatarView) it.next()).b();
            }
        }

        public final void x(@NotNull GuildHomeAudioPlayChannelUIData item) {
            Object orNull;
            boolean z16;
            int i3;
            Object orNull2;
            Intrinsics.checkNotNullParameter(item, "item");
            this.itemData = item;
            this.binding.f442431l.setText(item.getTitle());
            int noMemberMaxLimit = item.getNoMemberMaxLimit();
            int memberMax = item.getMemberMax();
            int memberCount = item.getMemberCount();
            TextView textView = this.binding.f442429j;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.homeActivePeopleNumber");
            r(noMemberMaxLimit, memberMax, memberCount, textView);
            String coverUrl = item.getCoverUrl();
            ImageView imageView = this.binding.f442421b;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.activeChannelBg");
            com.tencent.mobileqq.guild.util.v.k(coverUrl, imageView, com.tencent.mobileqq.urldrawable.b.f306350a);
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
                GuildHomeActiveChannelMicAvatarView guildHomeActiveChannelMicAvatarView = this.binding.f442422c;
                Intrinsics.checkNotNullExpressionValue(guildHomeActiveChannelMicAvatarView, "binding.activeChannelMemberAvatar1");
                guildHomeActiveChannelMicAvatarView.setVisibility(0);
                this.binding.f442422c.setDefaultImageView(R.drawable.guild_audio_user_default);
            }
        }
    }

    public GuildHomeAudioPlayChannelAdapterDelegate(@NotNull a.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    public RecyclerView.ViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        bd g16 = bd.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026rent, false\n            )");
        return new b(g16, this.callback);
    }

    @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate
    protected boolean k(@NotNull so1.h item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof GuildHomeAudioPlayChannelUIData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void m(@NotNull GuildHomeAudioPlayChannelUIData item, @NotNull b holder, @NotNull List<? extends Object> payloads, int pos) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.content.active.Delegate.AudioPlay", "onBindViewHolder item:" + item);
        }
        holder.x(item);
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        new ro1.b(view).c(item.getChannelId()).f(pos).g(item.getSessionId()).b(item.getCardType()).d(1).a().d();
    }
}

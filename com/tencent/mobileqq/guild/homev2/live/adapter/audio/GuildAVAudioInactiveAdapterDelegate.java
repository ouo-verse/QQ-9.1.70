package com.tencent.mobileqq.guild.homev2.live.adapter.audio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.homev2.live.adapter.GuildAVBaseAdapterDelegate;
import com.tencent.mobileqq.guild.homev2.live.adapter.audio.GuildAVAudioInactiveAdapterDelegate;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import np1.a;
import org.jetbrains.annotations.NotNull;
import pp1.GuildAVAudioInactiveUIData;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001c\u001dB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014J0\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00032\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u0006H\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/live/adapter/audio/GuildAVAudioInactiveAdapterDelegate;", "Lcom/tencent/mobileqq/guild/homev2/live/adapter/GuildAVBaseAdapterDelegate;", "Lpp1/e;", "Lcom/tencent/mobileqq/guild/homev2/live/adapter/audio/GuildAVAudioInactiveAdapterDelegate$a;", "Lpp1/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "k", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "holder", "", "", "payloads", com.tencent.luggage.wxa.c8.c.G, "", DomainData.DOMAIN_NAME, "Lnp1/a$b;", "e", "Lnp1/a$b;", "callback", "<init>", "(Lnp1/a$b;)V", "f", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildAVAudioInactiveAdapterDelegate extends GuildAVBaseAdapterDelegate<GuildAVAudioInactiveUIData, a> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a.b callback;

    public GuildAVAudioInactiveAdapterDelegate(@NotNull a.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    public RecyclerView.ViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        vp1.m g16 = vp1.m.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026rent, false\n            )");
        return new a(g16, this.callback);
    }

    @Override // com.tencent.mobileqq.guild.homev2.live.adapter.GuildAVBaseAdapterDelegate
    protected boolean k(@NotNull pp1.g item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof GuildAVAudioInactiveUIData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.homev2.live.adapter.GuildAVBaseAdapterDelegate
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void m(@NotNull GuildAVAudioInactiveUIData item, @NotNull a holder, @NotNull List<? extends Object> payloads, int pos) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.content.active.Delegate.AudioInactive", 1, "onBindViewHolder item:" + item);
        }
        holder.w(item);
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        new ro1.b(view).c(item.getChannelId()).f(pos).g(item.getSessionId()).b(item.getCardType()).d(0).a().d();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/live/adapter/audio/GuildAVAudioInactiveAdapterDelegate$a;", "Lcom/tencent/mobileqq/guild/homev2/live/adapter/GuildAVBaseAdapterDelegate$a;", "Lpp1/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "w", "r", ReportConstant.COSTREPORT_PREFIX, "", "getTag", "Lvp1/m;", "G", "Lvp1/m;", "binding", "Lnp1/a$b;", "H", "Lnp1/a$b;", "callback", "I", "Lpp1/e;", "itemData", "<init>", "(Lvp1/m;Lnp1/a$b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends GuildAVBaseAdapterDelegate.a {

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final vp1.m binding;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final a.b callback;

        /* renamed from: I, reason: from kotlin metadata */
        private GuildAVAudioInactiveUIData itemData;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a(@NotNull vp1.m binding, @NotNull a.b callback) {
            super(r0);
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(callback, "callback");
            RadiusFrameLayout root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            this.binding = binding;
            this.callback = callback;
            binding.getRoot().post(new Runnable() { // from class: com.tencent.mobileqq.guild.homev2.live.adapter.audio.p
                @Override // java.lang.Runnable
                public final void run() {
                    GuildAVAudioInactiveAdapterDelegate.a.v(GuildAVAudioInactiveAdapterDelegate.a.this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void v(final a this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.homev2.live.adapter.audio.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildAVAudioInactiveAdapterDelegate.a.x(GuildAVAudioInactiveAdapterDelegate.a.this, view);
                }
            });
            ImageView imageView = this$0.binding.f443036e;
            imageView.setImageResource(R.drawable.guild_audio_room_bg_icon);
            imageView.setAlpha(0.08f);
            RadiusFrameLayout root = this$0.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            com.tencent.mobileqq.guild.component.token.c.c(root, null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void x(a this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            a.b bVar = this$0.callback;
            GuildAVAudioInactiveUIData guildAVAudioInactiveUIData = this$0.itemData;
            if (guildAVAudioInactiveUIData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                guildAVAudioInactiveUIData = null;
            }
            bVar.a(guildAVAudioInactiveUIData);
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // com.tencent.mobileqq.guild.homev2.live.adapter.GuildAVBaseAdapterDelegate.a
        @NotNull
        public String getTag() {
            return "Guild.NewHome.content.active.Delegate.AudioInactive";
        }

        public final void w(@NotNull GuildAVAudioInactiveUIData item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.itemData = item;
            this.binding.f443035d.setText(item.getTitle());
        }

        @Override // com.tencent.mobileqq.guild.homev2.live.adapter.GuildAVBaseAdapterDelegate.a
        public void r() {
        }

        @Override // com.tencent.mobileqq.guild.homev2.live.adapter.GuildAVBaseAdapterDelegate.a
        public void s() {
        }
    }
}

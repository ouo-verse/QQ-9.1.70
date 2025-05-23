package com.tencent.mobileqq.guild.home.activechannel.adapterdelegates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeAudioInactiveAdapterDelegate;
import com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qo1.a;
import vp1.bg;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001c\u001dB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014J0\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00032\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u0006H\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeAudioInactiveAdapterDelegate;", "Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeChannelBaseAdapterDelegate;", "Lso1/b;", "Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeAudioInactiveAdapterDelegate$a;", "Lso1/h;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "k", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "holder", "", "", "payloads", com.tencent.luggage.wxa.c8.c.G, "", DomainData.DOMAIN_NAME, "Lqo1/a$b;", "e", "Lqo1/a$b;", "callback", "<init>", "(Lqo1/a$b;)V", "f", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeAudioInactiveAdapterDelegate extends GuildHomeChannelBaseAdapterDelegate<so1.b, a> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a.b callback;

    public GuildHomeAudioInactiveAdapterDelegate(@NotNull a.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    public RecyclerView.ViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        bg g16 = bg.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026, parent, false\n        )");
        return new a(g16, this.callback);
    }

    @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate
    protected boolean k(@NotNull so1.h item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof so1.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void m(@NotNull so1.b item, @NotNull a holder, @NotNull List<? extends Object> payloads, int pos) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.content.active.Delegate.AudioInactive", 1, "onBindViewHolder item:" + item);
        }
        holder.x(item);
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        new ro1.b(view).c(item.getChannelId()).f(pos).g(item.getSessionId()).b(item.getCardType()).d(0).a().d();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeAudioInactiveAdapterDelegate$a;", "Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeChannelBaseAdapterDelegate$a;", "Lso1/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", HippyTKDListViewAdapter.X, ReportConstant.COSTREPORT_PREFIX, "t", "", "getTag", "Lvp1/bg;", "H", "Lvp1/bg;", "binding", "Lqo1/a$b;", "I", "Lqo1/a$b;", "callback", "J", "Lso1/b;", "itemData", "<init>", "(Lvp1/bg;Lqo1/a$b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends GuildHomeChannelBaseAdapterDelegate.a {

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final bg binding;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final a.b callback;

        /* renamed from: J, reason: from kotlin metadata */
        private so1.b itemData;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a(@NotNull bg binding, @NotNull a.b callback) {
            super(r0);
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ConstraintLayout root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            this.binding = binding;
            this.callback = callback;
            binding.getRoot().post(new Runnable() { // from class: com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.a
                @Override // java.lang.Runnable
                public final void run() {
                    GuildHomeAudioInactiveAdapterDelegate.a.w(GuildHomeAudioInactiveAdapterDelegate.a.this);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void w(final a this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildHomeAudioInactiveAdapterDelegate.a.y(GuildHomeAudioInactiveAdapterDelegate.a.this, view);
                }
            });
            this$0.binding.f442452d.setImageDrawable(UIUtil.f112434a.x().getDrawable(R.drawable.qui_guild_audio_room_icon));
            ConstraintLayout root = this$0.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            com.tencent.mobileqq.guild.component.token.c.c(root, null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(a this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            a.b bVar = this$0.callback;
            so1.b bVar2 = this$0.itemData;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                bVar2 = null;
            }
            bVar.a(bVar2);
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate.a
        @NotNull
        public String getTag() {
            return "Guild.NewHome.content.active.Delegate.AudioInactive";
        }

        public final void x(@NotNull so1.b item) {
            float f16;
            Intrinsics.checkNotNullParameter(item, "item");
            this.itemData = item;
            this.binding.f442453e.setText(item.getTitle());
            ImageView imageView = this.binding.f442450b;
            if (QQTheme.isNowThemeIsNight()) {
                f16 = 0.05f;
            } else if (!QQTheme.isDefaultTheme() && !QQTheme.isThemeSimpleDayUI(QQTheme.getCurrentThemeId())) {
                f16 = 0.2f;
            } else {
                f16 = 0.45f;
            }
            imageView.setAlpha(f16);
            imageView.setImageDrawable(imageView.getResources().getDrawable(R.drawable.guild_audio_room_bg_icon));
        }

        @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate.a
        public void s() {
        }

        @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate.a
        public void t() {
        }
    }
}

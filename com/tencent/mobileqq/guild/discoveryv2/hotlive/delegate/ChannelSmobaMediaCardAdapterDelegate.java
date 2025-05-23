package com.tencent.mobileqq.guild.discoveryv2.hotlive.delegate;

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
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.guild.discoveryv2.hotlive.view.VoicingLinearLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import gi1.ChannelSmobaMediaCardItemData;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vp1.bs;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002 !B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J&\u0010\u0016\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\nH\u0014J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0017H\u0014R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/delegate/ChannelSmobaMediaCardAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lgi1/g;", "Lgi1/b;", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/delegate/ChannelSmobaMediaCardAdapterDelegate$a;", "Landroid/view/View;", "view", "", "p", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, ReportConstant.COSTREPORT_PREFIX, "holder", "", "payloads", "r", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", tl.h.F, "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;", "d", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;", "channelCardControl", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;)V", "e", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ChannelSmobaMediaCardAdapterDelegate extends AbsListItemAdapterDelegate<ChannelSmobaMediaCardItemData, gi1.b, a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.discoveryv2.hotlive.d channelCardControl;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/delegate/ChannelSmobaMediaCardAdapterDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/main/a;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lgi1/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "enableAnimate", "l", "d", "Lvp1/bs;", "E", "Lvp1/bs;", "binding", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;", "channelCardControl", "G", "Lgi1/g;", "itemData", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/h;", "H", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/h;", "statusWrapper", "<init>", "(Lvp1/bs;Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends RecyclerView.ViewHolder implements com.tencent.mobileqq.guild.main.a {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final bs binding;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.guild.discoveryv2.hotlive.d channelCardControl;

        /* renamed from: G, reason: from kotlin metadata */
        private ChannelSmobaMediaCardItemData itemData;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.guild.discoveryv2.hotlive.h statusWrapper;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull bs binding, @NotNull com.tencent.mobileqq.guild.discoveryv2.hotlive.d channelCardControl) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(channelCardControl, "channelCardControl");
            this.binding = binding;
            this.channelCardControl = channelCardControl;
            LottieAnimationView lottieAnimationView = binding.f442582g;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.channelStatusAnim");
            TextView textView = binding.f442583h;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.channelStatusText");
            this.statusWrapper = new com.tencent.mobileqq.guild.discoveryv2.hotlive.h(lottieAnimationView, textView);
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            channelCardControl.A0(itemView);
            VoicingLinearLayout voicingLinearLayout = binding.f442577b;
            Intrinsics.checkNotNullExpressionValue(voicingLinearLayout, "binding.avatarList");
            channelCardControl.c(voicingLinearLayout);
        }

        @Override // com.tencent.mobileqq.guild.main.a
        public void d(boolean enableAnimate) {
            if (enableAnimate) {
                this.binding.f442577b.b();
                this.statusWrapper.b();
            } else {
                this.binding.f442577b.c();
                this.statusWrapper.c();
            }
        }

        public final void l(@NotNull ChannelSmobaMediaCardItemData item, boolean enableAnimate) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.itemView.setTag(R.id.w1p, item);
            this.itemData = item;
            this.binding.f442581f.setText(item.getChannelName());
            TextView textView = this.binding.f442579d;
            ChannelSmobaMediaCardItemData channelSmobaMediaCardItemData = this.itemData;
            ChannelSmobaMediaCardItemData channelSmobaMediaCardItemData2 = null;
            if (channelSmobaMediaCardItemData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                channelSmobaMediaCardItemData = null;
            }
            textView.setText(channelSmobaMediaCardItemData.getBottomText());
            com.tencent.mobileqq.guild.discoveryv2.hotlive.h hVar = this.statusWrapper;
            ChannelSmobaMediaCardItemData channelSmobaMediaCardItemData3 = this.itemData;
            if (channelSmobaMediaCardItemData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                channelSmobaMediaCardItemData3 = null;
            }
            hVar.a(channelSmobaMediaCardItemData3.getChannelStatusInfo(), enableAnimate);
            com.tencent.mobileqq.guild.discoveryv2.hotlive.e eVar = com.tencent.mobileqq.guild.discoveryv2.hotlive.e.f217491a;
            RoundImageView roundImageView = this.binding.f442585j;
            Intrinsics.checkNotNullExpressionValue(roundImageView, "binding.guildIcon");
            com.tencent.mobileqq.guild.discoveryv2.hotlive.e.b(eVar, roundImageView, item.getGuildIcon(), null, 4, null);
            VoicingLinearLayout voicingLinearLayout = this.binding.f442577b;
            ChannelSmobaMediaCardItemData channelSmobaMediaCardItemData4 = this.itemData;
            if (channelSmobaMediaCardItemData4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                channelSmobaMediaCardItemData4 = null;
            }
            voicingLinearLayout.setData(channelSmobaMediaCardItemData4.g());
            if (enableAnimate) {
                ChannelSmobaMediaCardItemData channelSmobaMediaCardItemData5 = this.itemData;
                if (channelSmobaMediaCardItemData5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemData");
                } else {
                    channelSmobaMediaCardItemData2 = channelSmobaMediaCardItemData5;
                }
                if (!channelSmobaMediaCardItemData2.g().isEmpty()) {
                    this.binding.f442577b.b();
                    ImageView imageView = this.binding.f442584i;
                    Intrinsics.checkNotNullExpressionValue(imageView, "binding.coverView");
                    v.k("https://group-pro-search-recommend-1251316161.cos.ap-guangzhou.myqcloud.com/xy%2Fqq_channel%2Frecommend_resources%2Fimages%2Fbg_smoba_797.png?imageMogr2/format/webp", imageView, com.tencent.mobileqq.urldrawable.b.f306350a);
                }
            }
            this.binding.f442577b.c();
            ImageView imageView2 = this.binding.f442584i;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.coverView");
            v.k("https://group-pro-search-recommend-1251316161.cos.ap-guangzhou.myqcloud.com/xy%2Fqq_channel%2Frecommend_resources%2Fimages%2Fbg_smoba_797.png?imageMogr2/format/webp", imageView2, com.tencent.mobileqq.urldrawable.b.f306350a);
        }

        public final void m() {
            com.tencent.mobileqq.guild.discoveryv2.hotlive.d dVar = this.channelCardControl;
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            dVar.A0(itemView);
            com.tencent.mobileqq.guild.discoveryv2.hotlive.d dVar2 = this.channelCardControl;
            VoicingLinearLayout voicingLinearLayout = this.binding.f442577b;
            Intrinsics.checkNotNullExpressionValue(voicingLinearLayout, "binding.avatarList");
            dVar2.c(voicingLinearLayout);
        }
    }

    public ChannelSmobaMediaCardAdapterDelegate(@NotNull com.tencent.mobileqq.guild.discoveryv2.hotlive.d channelCardControl) {
        Intrinsics.checkNotNullParameter(channelCardControl, "channelCardControl");
        this.channelCardControl = channelCardControl;
    }

    private final void p(View view) {
        if (!o.c("fastClickGuard")) {
            Object tag = view.getTag(R.id.w1p);
            if (!(tag instanceof ChannelSmobaMediaCardItemData)) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "onClick invalid, data:" + tag;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("ChannelSmobaMediaCardAdapterDelegate", 1, (String) it.next(), null);
                }
                return;
            }
            this.channelCardControl.d((gi1.a) tag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ChannelSmobaMediaCardAdapterDelegate this$0, View it) {
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
        return item instanceof ChannelSmobaMediaCardItemData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull ChannelSmobaMediaCardItemData item, @NotNull a holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        com.tencent.mobileqq.guild.discoveryv2.hotlive.d dVar = this.channelCardControl;
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        dVar.e(view, holder.getAdapterPosition(), item);
        if (payloads.contains(1)) {
            holder.m();
        } else {
            holder.m();
            holder.l(item, this.channelCardControl.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public a d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        bs g16 = bs.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        RadiusFrameLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        com.tencent.mobileqq.guild.component.token.c.c(root, null, 2, null);
        g16.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.hotlive.delegate.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChannelSmobaMediaCardAdapterDelegate.t(ChannelSmobaMediaCardAdapterDelegate.this, view);
            }
        });
        return new a(g16, this.channelCardControl);
    }
}

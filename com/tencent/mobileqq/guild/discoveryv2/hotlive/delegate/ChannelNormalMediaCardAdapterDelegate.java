package com.tencent.mobileqq.guild.discoveryv2.hotlive.delegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import gi1.ChannelNormalMediaCardItemData;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vp1.bq;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002 !B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J&\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J&\u0010\u0016\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\nH\u0014J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0017H\u0014R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/delegate/ChannelNormalMediaCardAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lgi1/e;", "Lgi1/b;", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/delegate/ChannelNormalMediaCardAdapterDelegate$a;", "Landroid/view/View;", "view", "", "p", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, ReportConstant.COSTREPORT_PREFIX, "holder", "", "payloads", "r", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", tl.h.F, "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;", "d", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;", "channelCardControl", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;)V", "e", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ChannelNormalMediaCardAdapterDelegate extends AbsListItemAdapterDelegate<ChannelNormalMediaCardItemData, gi1.b, a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.discoveryv2.hotlive.d channelCardControl;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/delegate/ChannelNormalMediaCardAdapterDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/main/a;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lgi1/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "enableAnimate", "l", "d", "Lvp1/bq;", "E", "Lvp1/bq;", "binding", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;", "getChannelCardControl", "()Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;", "channelCardControl", "G", "Lgi1/e;", "itemData", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/h;", "H", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/h;", "statusWrapper", "<init>", "(Lvp1/bq;Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends RecyclerView.ViewHolder implements com.tencent.mobileqq.guild.main.a {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final bq binding;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.guild.discoveryv2.hotlive.d channelCardControl;

        /* renamed from: G, reason: from kotlin metadata */
        private ChannelNormalMediaCardItemData itemData;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.guild.discoveryv2.hotlive.h statusWrapper;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull bq binding, @NotNull com.tencent.mobileqq.guild.discoveryv2.hotlive.d channelCardControl) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(channelCardControl, "channelCardControl");
            this.binding = binding;
            this.channelCardControl = channelCardControl;
            LottieAnimationView lottieAnimationView = binding.f442558h;
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "binding.channelStatusAnim");
            TextView textView = binding.f442559i;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.channelStatusText");
            this.statusWrapper = new com.tencent.mobileqq.guild.discoveryv2.hotlive.h(lottieAnimationView, textView);
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            channelCardControl.A0(itemView);
            VoicingLinearLayout voicingLinearLayout = binding.f442552b;
            Intrinsics.checkNotNullExpressionValue(voicingLinearLayout, "binding.avatarList");
            channelCardControl.c(voicingLinearLayout);
        }

        @Override // com.tencent.mobileqq.guild.main.a
        public void d(boolean enableAnimate) {
            if (enableAnimate) {
                this.binding.f442552b.b();
                this.statusWrapper.b();
            } else {
                this.binding.f442552b.c();
                this.statusWrapper.c();
            }
        }

        public final void l(@NotNull ChannelNormalMediaCardItemData item, boolean enableAnimate) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.itemView.setTag(R.id.w1p, item);
            this.itemData = item;
            this.binding.f442557g.setText(item.getChannelName());
            TextView textView = this.binding.f442554d;
            ChannelNormalMediaCardItemData channelNormalMediaCardItemData = this.itemData;
            ChannelNormalMediaCardItemData channelNormalMediaCardItemData2 = null;
            if (channelNormalMediaCardItemData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                channelNormalMediaCardItemData = null;
            }
            textView.setText(channelNormalMediaCardItemData.getBottomText());
            com.tencent.mobileqq.guild.discoveryv2.hotlive.h hVar = this.statusWrapper;
            ChannelNormalMediaCardItemData channelNormalMediaCardItemData3 = this.itemData;
            if (channelNormalMediaCardItemData3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                channelNormalMediaCardItemData3 = null;
            }
            hVar.a(channelNormalMediaCardItemData3.getChannelStatusInfo(), enableAnimate);
            com.tencent.mobileqq.guild.discoveryv2.hotlive.e eVar = com.tencent.mobileqq.guild.discoveryv2.hotlive.e.f217491a;
            RoundImageView roundImageView = this.binding.f442560j;
            Intrinsics.checkNotNullExpressionValue(roundImageView, "binding.guildIcon");
            com.tencent.mobileqq.guild.discoveryv2.hotlive.e.b(eVar, roundImageView, item.getGuildIcon(), null, 4, null);
            VoicingLinearLayout voicingLinearLayout = this.binding.f442552b;
            ChannelNormalMediaCardItemData channelNormalMediaCardItemData4 = this.itemData;
            if (channelNormalMediaCardItemData4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                channelNormalMediaCardItemData4 = null;
            }
            voicingLinearLayout.setData(channelNormalMediaCardItemData4.g());
            if (enableAnimate) {
                ChannelNormalMediaCardItemData channelNormalMediaCardItemData5 = this.itemData;
                if (channelNormalMediaCardItemData5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemData");
                } else {
                    channelNormalMediaCardItemData2 = channelNormalMediaCardItemData5;
                }
                if (!channelNormalMediaCardItemData2.g().isEmpty()) {
                    this.binding.f442552b.b();
                    return;
                }
            }
            this.binding.f442552b.c();
        }

        public final void m() {
            com.tencent.mobileqq.guild.discoveryv2.hotlive.d dVar = this.channelCardControl;
            View itemView = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            dVar.A0(itemView);
            com.tencent.mobileqq.guild.discoveryv2.hotlive.d dVar2 = this.channelCardControl;
            VoicingLinearLayout voicingLinearLayout = this.binding.f442552b;
            Intrinsics.checkNotNullExpressionValue(voicingLinearLayout, "binding.avatarList");
            dVar2.c(voicingLinearLayout);
        }
    }

    public ChannelNormalMediaCardAdapterDelegate(@NotNull com.tencent.mobileqq.guild.discoveryv2.hotlive.d channelCardControl) {
        Intrinsics.checkNotNullParameter(channelCardControl, "channelCardControl");
        this.channelCardControl = channelCardControl;
    }

    private final void p(View view) {
        if (!o.c("fastClickGuard")) {
            Object tag = view.getTag(R.id.w1p);
            if (!(tag instanceof ChannelNormalMediaCardItemData)) {
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
    public static final void t(ChannelNormalMediaCardAdapterDelegate this$0, View it) {
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
        return item instanceof ChannelNormalMediaCardItemData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull ChannelNormalMediaCardItemData item, @NotNull a holder, @NotNull List<Object> payloads) {
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
        bq g16 = bq.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        RadiusFrameLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        com.tencent.mobileqq.guild.component.token.c.c(root, null, 2, null);
        g16.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.hotlive.delegate.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChannelNormalMediaCardAdapterDelegate.t(ChannelNormalMediaCardAdapterDelegate.this, view);
            }
        });
        return new a(g16, this.channelCardControl);
    }
}

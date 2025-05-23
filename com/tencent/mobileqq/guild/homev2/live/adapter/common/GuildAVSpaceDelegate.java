package com.tencent.mobileqq.guild.homev2.live.adapter.common;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.guild.homev2.live.adapter.GuildAVBaseAdapterDelegate;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import pp1.GuildLiveAudioSpaceUIData;
import pp1.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0018\u0019B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014J0\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00032\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u0006H\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/live/adapter/common/GuildAVSpaceDelegate;", "Lcom/tencent/mobileqq/guild/homev2/live/adapter/GuildAVBaseAdapterDelegate;", "Lpp1/l;", "Lcom/tencent/mobileqq/guild/homev2/live/adapter/common/GuildAVSpaceDelegate$b;", "Lpp1/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "k", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "holder", "", "", "payloads", c.G, "", DomainData.DOMAIN_NAME, "<init>", "()V", "e", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildAVSpaceDelegate extends GuildAVBaseAdapterDelegate<GuildLiveAudioSpaceUIData, b> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    public RecyclerView.ViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new b(new FrameLayout(parent.getContext()));
    }

    @Override // com.tencent.mobileqq.guild.homev2.live.adapter.GuildAVBaseAdapterDelegate
    protected boolean k(@NotNull g item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof GuildLiveAudioSpaceUIData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.homev2.live.adapter.GuildAVBaseAdapterDelegate
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void m(@NotNull GuildLiveAudioSpaceUIData item, @NotNull b holder, @NotNull List<? extends Object> payloads, int pos) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.content.active.Delegate.space", 1, "onBindViewHolder item:" + item);
        }
        holder.t(item);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/live/adapter/common/GuildAVSpaceDelegate$b;", "Lcom/tencent/mobileqq/guild/homev2/live/adapter/GuildAVBaseAdapterDelegate$a;", "Lpp1/l;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "t", "r", ReportConstant.COSTREPORT_PREFIX, "", "getTag", "Landroid/view/View;", "G", "Landroid/view/View;", "spaceView", "H", "Lpp1/l;", "itemData", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GuildAVBaseAdapterDelegate.a {

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final View spaceView;

        /* renamed from: H, reason: from kotlin metadata */
        private GuildLiveAudioSpaceUIData itemData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View spaceView) {
            super(spaceView);
            Intrinsics.checkNotNullParameter(spaceView, "spaceView");
            this.spaceView = spaceView;
        }

        @Override // com.tencent.mobileqq.guild.homev2.live.adapter.GuildAVBaseAdapterDelegate.a
        @NotNull
        public String getTag() {
            return "Guild.NewHome.content.active.Delegate.space";
        }

        public final void t(@NotNull GuildLiveAudioSpaceUIData item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.itemData = item;
            ViewGroup.LayoutParams layoutParams = this.spaceView.getLayoutParams();
            if (layoutParams == null) {
                this.spaceView.setLayoutParams(new ViewGroup.LayoutParams(-1, item.getDistance()));
            } else if (layoutParams.height != item.getDistance()) {
                layoutParams.height = item.getDistance();
                this.spaceView.setLayoutParams(layoutParams);
            }
        }

        @Override // com.tencent.mobileqq.guild.homev2.live.adapter.GuildAVBaseAdapterDelegate.a
        public void r() {
        }

        @Override // com.tencent.mobileqq.guild.homev2.live.adapter.GuildAVBaseAdapterDelegate.a
        public void s() {
        }
    }
}

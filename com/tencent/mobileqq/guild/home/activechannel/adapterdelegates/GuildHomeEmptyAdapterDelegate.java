package com.tencent.mobileqq.guild.home.activechannel.adapterdelegates;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qo1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001c\u001dB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014J0\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00032\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u0006H\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeEmptyAdapterDelegate;", "Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeChannelBaseAdapterDelegate;", "Lso1/j;", "Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeEmptyAdapterDelegate$b;", "Lso1/h;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "k", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "holder", "", "", "payloads", com.tencent.luggage.wxa.c8.c.G, "", DomainData.DOMAIN_NAME, "Lqo1/a$b;", "e", "Lqo1/a$b;", "callback", "<init>", "(Lqo1/a$b;)V", "f", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeEmptyAdapterDelegate extends GuildHomeChannelBaseAdapterDelegate<so1.j, b> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a.b callback;

    public GuildHomeEmptyAdapterDelegate(@NotNull a.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    public RecyclerView.ViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        GuildQUIEmptyState a16 = new GuildQUIEmptyState.a(parent.getContext()).s(3).u("\u6682\u65e0\u76f4\u64ad").r(false).n(false).o(0).a();
        a16.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        a16.setId(R.id.f165092uv0);
        a16.setGravity(17);
        LinearLayout linearLayout = new LinearLayout(parent.getContext());
        linearLayout.setId(R.id.uuy);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ViewExtKt.f(linearLayout, ViewUtils.dpToPx(150.0f));
        linearLayout.addView(a16);
        return new b(linearLayout, this.callback);
    }

    @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate
    protected boolean k(@NotNull so1.h item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof so1.j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void m(@NotNull so1.j item, @NotNull b holder, @NotNull List<? extends Object> payloads, int pos) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.content.active.Delegate.LiveEmpty", 1, "onBindViewHolder item:" + item);
        }
        holder.u(item);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeEmptyAdapterDelegate$b;", "Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeChannelBaseAdapterDelegate$a;", "Lso1/j;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "u", ReportConstant.COSTREPORT_PREFIX, "t", "", "getTag", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", "emptyContainer", "Lqo1/a$b;", "I", "Lqo1/a$b;", "callback", "J", "Lso1/j;", "itemData", "<init>", "(Landroid/widget/LinearLayout;Lqo1/a$b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GuildHomeChannelBaseAdapterDelegate.a {

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final LinearLayout emptyContainer;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final a.b callback;

        /* renamed from: J, reason: from kotlin metadata */
        private so1.j itemData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull LinearLayout emptyContainer, @NotNull a.b callback) {
            super(emptyContainer);
            Intrinsics.checkNotNullParameter(emptyContainer, "emptyContainer");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.emptyContainer = emptyContainer;
            this.callback = callback;
        }

        @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate.a
        @NotNull
        public String getTag() {
            return "Guild.NewHome.content.active.Delegate.LiveEmpty";
        }

        public final void u(@NotNull so1.j item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.itemData = item;
        }

        @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate.a
        public void s() {
        }

        @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate.a
        public void t() {
        }
    }
}

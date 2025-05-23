package com.tencent.mobileqq.guild.home.activechannel.adapterdelegates;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vp1.bk;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0018\u0019B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014J0\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00032\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u0006H\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeSpaceDelegate;", "Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeChannelBaseAdapterDelegate;", "Lso1/l;", "Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeSpaceDelegate$b;", "Lso1/h;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "k", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "holder", "", "", "payloads", com.tencent.luggage.wxa.c8.c.G, "", DomainData.DOMAIN_NAME, "<init>", "()V", "e", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeSpaceDelegate extends GuildHomeChannelBaseAdapterDelegate<so1.l, b> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    public RecyclerView.ViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        bk g16 = bk.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026rent, false\n            )");
        return new b(g16);
    }

    @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate
    protected boolean k(@NotNull so1.h item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof so1.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void m(@NotNull so1.l item, @NotNull b holder, @NotNull List<? extends Object> payloads, int pos) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.content.active.Delegate.space", 1, "onBindViewHolder item:" + item);
        }
        holder.u(item);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeSpaceDelegate$b;", "Lcom/tencent/mobileqq/guild/home/activechannel/adapterdelegates/GuildHomeChannelBaseAdapterDelegate$a;", "Lso1/l;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "u", ReportConstant.COSTREPORT_PREFIX, "t", "", "getTag", "Lvp1/bk;", "H", "Lvp1/bk;", "binding", "I", "Lso1/l;", "itemData", "<init>", "(Lvp1/bk;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GuildHomeChannelBaseAdapterDelegate.a {

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final bk binding;

        /* renamed from: I, reason: from kotlin metadata */
        private so1.l itemData;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b(@NotNull bk binding) {
            super(r0);
            Intrinsics.checkNotNullParameter(binding, "binding");
            ConstraintLayout root = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            this.binding = binding;
        }

        @Override // com.tencent.mobileqq.guild.home.activechannel.adapterdelegates.GuildHomeChannelBaseAdapterDelegate.a
        @NotNull
        public String getTag() {
            return "Guild.NewHome.content.active.Delegate.space";
        }

        public final void u(@NotNull so1.l item) {
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

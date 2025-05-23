package com.tencent.mobileqq.guild.channel.joinchannel.verifynew.delegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.channel.joinchannel.verifynew.a;
import com.tencent.mobileqq.guild.channel.joinchannel.verifynew.delegate.SubmitBtnAdapterDelegate;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vp1.dd;
import wf1.JoinGuildSubmitItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002\u001b\u001cB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/delegate/SubmitBtnAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lwf1/e;", "Lwf1/b;", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/delegate/SubmitBtnAdapterDelegate$b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "payloads", "", "p", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;", "d", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;", "delegateListener", "<init>", "(Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;)V", "e", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class SubmitBtnAdapterDelegate extends AbsListItemAdapterDelegate<JoinGuildSubmitItem, wf1.b, b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a.b delegateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/delegate/SubmitBtnAdapterDelegate$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lwf1/e;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "", "payloads", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lvp1/dd;", "E", "Lvp1/dd;", "getBinding", "()Lvp1/dd;", "binding", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;", "delegateListener", "<init>", "(Lvp1/dd;Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final dd binding;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final a.b delegateListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull dd binding, @NotNull a.b delegateListener) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(delegateListener, "delegateListener");
            this.binding = binding;
            this.delegateListener = delegateListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(b this$0, JoinGuildSubmitItem item, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(item, "$item");
            Logger.f235387a.d().i("Guild.join.verify.SubmitBtnAdapterDelegate", 1, "submit guildId:" + item.getGuildId());
            this$0.delegateListener.k();
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void m(@NotNull final JoinGuildSubmitItem item, @NotNull List<Object> payloads) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            this.binding.f442881b.setOnClickListener(new View.OnClickListener() { // from class: vf1.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubmitBtnAdapterDelegate.b.n(SubmitBtnAdapterDelegate.b.this, item, view);
                }
            });
            if (item.getEnable()) {
                this.binding.f442881b.o();
            } else {
                this.binding.f442881b.setBackgroundDisabled();
            }
        }
    }

    public SubmitBtnAdapterDelegate(@NotNull a.b delegateListener) {
        Intrinsics.checkNotNullParameter(delegateListener, "delegateListener");
        this.delegateListener = delegateListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull wf1.b item, @NotNull List<wf1.b> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof JoinGuildSubmitItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull JoinGuildSubmitItem item, @NotNull b holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.m(item, payloads);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public b d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        dd g16 = dd.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        return new b(g16, this.delegateListener);
    }
}

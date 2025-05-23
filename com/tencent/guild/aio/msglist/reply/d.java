package com.tencent.guild.aio.msglist.reply;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.util.SparseArrayKt;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.msglist.holder.state.MsgListItemState;
import com.tencent.guild.aio.msglist.text.util.GuildCombineUtil;
import com.tencent.guild.aio.util.t;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import com.tencent.qqnt.msg.MsgExtKt;
import dq0.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u0000 =2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001>B)\u0012\u0006\u0010#\u001a\u00020\b\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010+\u001a\u00020(\u0012\b\b\u0002\u00100\u001a\u00020\u0019\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J&\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u000e\u0012\u0006\b\u0001\u0012\u00020\u000f0\r0\f2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0016\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J$\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bR\u0017\u0010#\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0017\u00100\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0016\u00108\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00103R\u0016\u0010:\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00103\u00a8\u0006?"}, d2 = {"Lcom/tencent/guild/aio/msglist/reply/d;", "Lcom/tencent/aio/api/list/a;", "Lcom/tencent/guild/aio/factory/business/holder/msglist/a;", "Lcom/tencent/guild/aio/msglist/holder/state/MsgListItemState;", "", "h1", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "Landroid/view/View;", "view", "f1", "hostView", "", "Lcom/tencent/aio/base/mvvm/a;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/api/list/b;", "b1", "bindViewAndData", "state", "g1", "", "position", "", "", "payloads", "e1", "d", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "e", "Lcom/tencent/guild/aio/msglist/holder/config/d;", "componentProvider", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "f", "Lcom/tencent/guild/aio/msglist/holder/config/c;", "factoryProvider", tl.h.F, "I", "getViewType", "()I", "viewType", "", "i", "J", "msgId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "msgSeq", BdhLogUtil.LogTag.Tag_Conn, "replayMsgRootSeq", "D", "replayMsgSeq", "<init>", "(Landroid/view/View;Lcom/tencent/guild/aio/msglist/holder/config/d;Lcom/tencent/guild/aio/msglist/holder/config/c;I)V", "E", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends com.tencent.aio.api.list.a<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> {

    /* renamed from: C, reason: from kotlin metadata */
    private long replayMsgRootSeq;

    /* renamed from: D, reason: from kotlin metadata */
    private long replayMsgSeq;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View itemView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.msglist.holder.config.d componentProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.msglist.holder.config.c factoryProvider;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int viewType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long msgId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long msgSeq;

    public d(@NotNull View itemView, @NotNull com.tencent.guild.aio.msglist.holder.config.d componentProvider, @NotNull com.tencent.guild.aio.msglist.holder.config.c factoryProvider, int i3) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(componentProvider, "componentProvider");
        Intrinsics.checkNotNullParameter(factoryProvider, "factoryProvider");
        this.itemView = itemView;
        this.componentProvider = componentProvider;
        this.factoryProvider = factoryProvider;
        this.viewType = i3;
    }

    private final void f1(com.tencent.aio.data.msglist.a msgItem, View view) {
        b.Companion companion = dq0.b.INSTANCE;
        companion.b(view);
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        String selfTid = ((IGPSService) bz.b(IGPSService.class)).getSelfTinyId();
        MsgRecord msgRecord = ((GuildMsgItem) msgItem).getMsgRecord();
        Intrinsics.checkNotNullExpressionValue(selfTid, "selfTid");
        if (MsgExtKt.F(msgRecord, selfTid)) {
            b.Companion.d(companion, view, 0L, 0, null, 14, null);
        }
    }

    private final void h1() {
        View findViewById = this.itemView.findViewById(R.id.zgk);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.reply.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.i1(d.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(new a.k(this$0.replayMsgRootSeq, this$0.replayMsgSeq, this$0.msgSeq));
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aio.api.list.a
    @Nullable
    public com.tencent.aio.api.list.b<com.tencent.guild.aio.factory.business.holder.msglist.a, MsgListItemState> b1() {
        return this.factoryProvider.a(this.viewType).a();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        t.h(this.componentProvider, this);
        t.e(this.componentProvider, this);
        h1();
    }

    public final void e1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        ReplyElement replyElement;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Iterator valueIterator = SparseArrayKt.valueIterator(this.componentProvider.get());
        while (valueIterator.hasNext()) {
            com.tencent.guild.aio.msglist.holder.component.a aVar = (com.tencent.guild.aio.msglist.holder.component.a) valueIterator.next();
            if (aVar != null) {
                aVar.c1(position, msgItem, payloads);
            }
        }
        if (msgItem instanceof GuildMsgItem) {
            GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
            this.msgId = guildMsgItem.getMsgRecord().msgId;
            this.msgSeq = guildMsgItem.getMsgRecord().msgSeq;
            Iterator<MsgElement> it = guildMsgItem.getMsgRecord().elements.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MsgElement next = it.next();
                if (next.elementType == 7 && (replyElement = next.replyElement) != null) {
                    Long l3 = replyElement.replayMsgRootSeq;
                    Intrinsics.checkNotNullExpressionValue(l3, "element.replyElement.replayMsgRootSeq");
                    this.replayMsgRootSeq = l3.longValue();
                    Long l16 = next.replyElement.replayMsgSeq;
                    Intrinsics.checkNotNullExpressionValue(l16, "element.replyElement.replayMsgSeq");
                    this.replayMsgSeq = l16.longValue();
                    break;
                }
            }
        }
        dq0.b.INSTANCE.b(this.itemView);
        f1(msgItem, this.itemView);
        GuildCombineUtil.f111919a.u(this.itemView, (GuildMsgItem) msgItem);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull MsgListItemState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        e1(state.getPosition(), state.getData(), state.b());
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        View view;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        ArrayList arrayList = new ArrayList();
        Iterator valueIterator = SparseArrayKt.valueIterator(this.componentProvider.get());
        while (valueIterator.hasNext()) {
            com.tencent.guild.aio.msglist.holder.component.a aVar = (com.tencent.guild.aio.msglist.holder.component.a) valueIterator.next();
            if (aVar != null) {
                view = aVar.getContainerView();
            } else {
                view = null;
            }
            if (view != null) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        LinearLayout linearLayout = (LinearLayout) this.itemView.findViewById(R.id.zfv);
        if (linearLayout != null) {
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.width = -2;
            layoutParams2.topMargin = linearLayout.getContext().getResources().getDimensionPixelSize(R.dimen.ccw);
            linearLayout.setLayoutParams(layoutParams2);
        }
        ImageView imageView = (ImageView) this.itemView.findViewById(R.id.f73123sp);
        if (imageView != null) {
            imageView.setVisibility(0);
            if (this.viewType == 24) {
                imageView.setBackgroundColor(iq0.a.i(getMContext(), false, 2, null));
            } else {
                imageView.setBackgroundColor(iq0.a.e(getMContext(), false, 2, null));
            }
        }
        return this.itemView;
    }
}

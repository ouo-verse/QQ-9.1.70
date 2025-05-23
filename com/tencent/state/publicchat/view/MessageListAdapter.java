package com.tencent.state.publicchat.view;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.data.MsgHeader;
import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.template.data.RoomThemeData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$BJ\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001bH\u0016J\u0010\u0010#\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\tR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R)\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/tencent/state/publicchat/view/MessageListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/state/publicchat/view/MessageListAdapter$MessageItemViewHolder;", "conf", "Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", "items", "", "Lcom/tencent/state/publicchat/data/MsgInfo;", "themeData", "Lcom/tencent/state/template/data/RoomThemeData;", "dispatchAction", "Lkotlin/Function1;", "Lcom/tencent/state/publicchat/action/MsgAction;", "Lkotlin/ParameterName;", "name", "action", "", "(Lcom/tencent/state/publicchat/data/PublicChatConfInfo;Ljava/util/List;Lcom/tencent/state/template/data/RoomThemeData;Lkotlin/jvm/functions/Function1;)V", "getConf", "()Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", "setConf", "(Lcom/tencent/state/publicchat/data/PublicChatConfInfo;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "refreshThemeData", "MessageItemViewHolder", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MessageListAdapter extends RecyclerView.Adapter<MessageItemViewHolder> {
    private PublicChatConfInfo conf;
    private final Function1<MsgAction, Unit> dispatchAction;
    private List<MsgInfo> items;
    private RoomThemeData themeData;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/publicchat/view/MessageListAdapter$MessageItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Lcom/tencent/state/publicchat/view/MessageItemView;", "(Lcom/tencent/state/publicchat/view/MessageItemView;)V", "getView", "()Lcom/tencent/state/publicchat/view/MessageItemView;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class MessageItemViewHolder extends RecyclerView.ViewHolder {
        private final MessageItemView view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageItemViewHolder(MessageItemView view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
        }

        public final MessageItemView getView() {
            return this.view;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MessageListAdapter(PublicChatConfInfo conf, List<MsgInfo> items, RoomThemeData roomThemeData, Function1<? super MsgAction, Unit> dispatchAction) {
        Intrinsics.checkNotNullParameter(conf, "conf");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(dispatchAction, "dispatchAction");
        this.conf = conf;
        this.items = items;
        this.themeData = roomThemeData;
        this.dispatchAction = dispatchAction;
    }

    public final PublicChatConfInfo getConf() {
        return this.conf;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final List<MsgInfo> getItems() {
        return this.items;
    }

    public final void refreshThemeData(RoomThemeData themeData) {
        this.themeData = themeData;
    }

    public final void setConf(PublicChatConfInfo publicChatConfInfo) {
        Intrinsics.checkNotNullParameter(publicChatConfInfo, "<set-?>");
        this.conf = publicChatConfInfo;
    }

    public final void setItems(List<MsgInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MessageItemViewHolder holder, int position) {
        MsgHeader header;
        Intrinsics.checkNotNullParameter(holder, "holder");
        try {
            MsgInfo msgInfo = this.items.get(position);
            holder.getView().bind(msgInfo, this.conf.findMsgConf((msgInfo == null || (header = msgInfo.getHeader()) == null) ? null : header.getTemplateId()), this.themeData, position == 0);
        } catch (Throwable th5) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), MessageListView.TAG, "onBindViewHolder failed " + th5, null, 4, null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MessageItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new MessageItemViewHolder(new MessageItemView(context, this.dispatchAction));
    }
}

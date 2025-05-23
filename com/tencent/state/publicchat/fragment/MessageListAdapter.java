package com.tencent.state.publicchat.fragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.publicchat.data.MsgConfInfo;
import com.tencent.state.publicchat.data.MsgInfo;
import com.tencent.state.publicchat.data.MsgInfoChecked;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.publicchat.view.MessageSelectItemView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0016R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/state/publicchat/fragment/MessageListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/state/publicchat/fragment/MessageListAdapter$MessageItemViewHolder;", "conf", "Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", "items", "", "Lcom/tencent/state/publicchat/data/MsgInfoChecked;", "clickCallback", "Lkotlin/Function0;", "", "(Lcom/tencent/state/publicchat/data/PublicChatConfInfo;Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "getConf", "()Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", "setConf", "(Lcom/tencent/state/publicchat/data/PublicChatConfInfo;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "MessageItemViewHolder", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MessageListAdapter extends RecyclerView.Adapter<MessageItemViewHolder> {
    private final Function0<Unit> clickCallback;
    private PublicChatConfInfo conf;
    private List<MsgInfoChecked> items;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/publicchat/fragment/MessageListAdapter$MessageItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Lcom/tencent/state/publicchat/view/MessageSelectItemView;", "(Lcom/tencent/state/publicchat/view/MessageSelectItemView;)V", "getView", "()Lcom/tencent/state/publicchat/view/MessageSelectItemView;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class MessageItemViewHolder extends RecyclerView.ViewHolder {
        private final MessageSelectItemView view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageItemViewHolder(MessageSelectItemView view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.view = view;
        }

        public final MessageSelectItemView getView() {
            return this.view;
        }
    }

    public /* synthetic */ MessageListAdapter(PublicChatConfInfo publicChatConfInfo, List list, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(publicChatConfInfo, list, (i3 & 4) != 0 ? null : function0);
    }

    public final PublicChatConfInfo getConf() {
        return this.conf;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.items.size();
    }

    public final List<MsgInfoChecked> getItems() {
        return this.items;
    }

    public final void setConf(PublicChatConfInfo publicChatConfInfo) {
        Intrinsics.checkNotNullParameter(publicChatConfInfo, "<set-?>");
        this.conf = publicChatConfInfo;
    }

    public final void setItems(List<MsgInfoChecked> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.items = list;
    }

    public MessageListAdapter(PublicChatConfInfo conf, List<MsgInfoChecked> items, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(conf, "conf");
        Intrinsics.checkNotNullParameter(items, "items");
        this.conf = conf;
        this.items = items;
        this.clickCallback = function0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MessageItemViewHolder holder, final int position) {
        Object obj;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final MsgInfoChecked msgInfoChecked = this.items.get(position);
        MsgInfo msg2 = msgInfoChecked.getMsg();
        Iterator<T> it = this.conf.getConfInfos().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((MsgConfInfo) obj).getTemplateId(), msg2.getHeader().getTemplateId())) {
                    break;
                }
            }
        }
        holder.getView().bind(msgInfoChecked, (MsgConfInfo) obj, position == 0);
        holder.getView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.publicchat.fragment.MessageListAdapter$onBindViewHolder$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function0 function0;
                if (msgInfoChecked.getDefaultChecked()) {
                    return;
                }
                function0 = MessageListAdapter.this.clickCallback;
                if (function0 != null) {
                }
                msgInfoChecked.setChecked(!r2.getChecked());
                MessageListAdapter.this.notifyItemChanged(position);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MessageItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new MessageItemViewHolder(new MessageSelectItemView(context));
    }
}

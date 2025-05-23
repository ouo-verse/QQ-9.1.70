package com.tencent.state.square.chatland.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.square.Square;
import com.tencent.state.square.api.IFaceDecoder;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.chatland.view.ListAdapter;
import com.tencent.state.square.databinding.VasSquareChatLandRepeatListItemViewBinding;
import com.tencent.state.utils.FaceUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001cB.\u0012'\u0010\u0003\u001a#\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0002`\n\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\t2\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0007J\u0016\u0010\u0019\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0007R/\u0010\u0003\u001a#\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0002`\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/state/square/chatland/view/ListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/state/square/chatland/view/ListAdapter$ViewHolder;", "clickCallbackFun", "Lkotlin/Function1;", "Lcom/tencent/state/square/chatland/data/ChatLandAvatarItem;", "Lkotlin/ParameterName;", "name", "data", "", "Lcom/tencent/state/square/chatland/view/ClickCallback;", "(Lkotlin/jvm/functions/Function1;)V", "dataList", "", "addView", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/ViewGroup;", "viewType", "removeView", "setData", "list", "", "ViewHolder", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final Function1<ChatLandAvatarItem, Unit> clickCallbackFun;
    private final List<ChatLandAvatarItem> dataList = new ArrayList();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/square/chatland/view/ListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/tencent/state/square/databinding/VasSquareChatLandRepeatListItemViewBinding;", "(Lcom/tencent/state/square/chatland/view/ListAdapter;Lcom/tencent/state/square/databinding/VasSquareChatLandRepeatListItemViewBinding;)V", "avatarFaceDecoder", "Lcom/tencent/state/square/api/IFaceDecoder;", "getBinding", "()Lcom/tencent/state/square/databinding/VasSquareChatLandRepeatListItemViewBinding;", "doBindView", "", "data", "Lcom/tencent/state/square/chatland/data/ChatLandAvatarItem;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private final IFaceDecoder avatarFaceDecoder;
        private final VasSquareChatLandRepeatListItemViewBinding binding;
        final /* synthetic */ ListAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ListAdapter listAdapter, VasSquareChatLandRepeatListItemViewBinding binding) {
            super(binding.getMRv());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = listAdapter;
            this.binding = binding;
            this.avatarFaceDecoder = Square.INSTANCE.getConfig().getObtainInstanceHelper().getFaceDecoder();
        }

        public final void doBindView(final ChatLandAvatarItem data) {
            Intrinsics.checkNotNullParameter(data, "data");
            FaceUtils.INSTANCE.loadHeadIcon(this.avatarFaceDecoder, this.binding.headImage, data.getUin(), false, new Function1<String, Boolean>() { // from class: com.tencent.state.square.chatland.view.ListAdapter$ViewHolder$doBindView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(String str) {
                    return Boolean.valueOf(invoke2(str));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(String str) {
                    return TextUtils.equals(str, ChatLandAvatarItem.this.getUin());
                }
            });
            TextView textView = this.binding.nickName;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.nickName");
            textView.setText(data.getTroopName());
            this.binding.getMRv().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.view.ListAdapter$ViewHolder$doBindView$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1 function1;
                    function1 = ListAdapter.ViewHolder.this.this$0.clickCallbackFun;
                    if (function1 != null) {
                    }
                }
            });
        }

        public final VasSquareChatLandRepeatListItemViewBinding getBinding() {
            return this.binding;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ListAdapter(Function1<? super ChatLandAvatarItem, Unit> function1) {
        this.clickCallbackFun = function1;
    }

    public final void addView(ChatLandAvatarItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.dataList.add(data);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.dataList.size();
    }

    public final void removeView(ChatLandAvatarItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.dataList.remove(data);
        notifyDataSetChanged();
    }

    public final void setData(List<ChatLandAvatarItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.dataList.clear();
        this.dataList.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Object orNull;
        Intrinsics.checkNotNullParameter(holder, "holder");
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.dataList, position);
        ChatLandAvatarItem chatLandAvatarItem = (ChatLandAvatarItem) orNull;
        if (chatLandAvatarItem != null) {
            holder.doBindView(chatLandAvatarItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        VasSquareChatLandRepeatListItemViewBinding inflate = VasSquareChatLandRepeatListItemViewBinding.inflate(LayoutInflater.from(parent.getContext()));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareChatLandRepeatL\u2026ter.from(parent.context))");
        LinearLayout mRv = inflate.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "binding.root");
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-2, -2);
        LinearLayout mRv2 = inflate.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv2, "binding.root");
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = ViewExtensionsKt.dip((View) mRv2, 4);
        LinearLayout mRv3 = inflate.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv3, "binding.root");
        ((ViewGroup.MarginLayoutParams) layoutParams).height = ViewExtensionsKt.dip((View) mRv3, 36);
        Unit unit = Unit.INSTANCE;
        mRv.setLayoutParams(layoutParams);
        return new ViewHolder(this, inflate);
    }
}

package com.tencent.state.square.chatland.view;

import android.content.Context;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.databinding.VasSquareChatLandRepeatListViewBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\tJ$\u0010\u0019\u001a\u00020\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014J\u0014\u0010\u001f\u001a\u00020\r2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R;\u0010\u0007\u001a#\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bj\u0002`\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/square/chatland/view/ChatLandRepeatList;", "Landroid/widget/PopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "binding", "Lcom/tencent/state/square/databinding/VasSquareChatLandRepeatListViewBinding;", "clickListener", "Lkotlin/Function1;", "Lcom/tencent/state/square/chatland/data/ChatLandAvatarItem;", "Lkotlin/ParameterName;", "name", "data", "", "Lcom/tencent/state/square/chatland/view/ClickCallback;", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "setClickListener", "(Lkotlin/jvm/functions/Function1;)V", "currentRectF", "Landroid/graphics/RectF;", "listAdapter", "Lcom/tencent/state/square/chatland/view/ListAdapter;", "addView", "removeView", "showList", "list", "", ParseCommon.CONTAINER, "Landroid/widget/FrameLayout;", "rectF", "updateLocation", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandRepeatList extends PopupWindow {
    private static final String TAG = "ChatLandRepeatList";
    private final VasSquareChatLandRepeatListViewBinding binding;
    private Function1<? super ChatLandAvatarItem, Unit> clickListener;
    private final Context context;
    private RectF currentRectF;
    private final ListAdapter listAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandRepeatList(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        VasSquareChatLandRepeatListViewBinding inflate = VasSquareChatLandRepeatListViewBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareChatLandRepeatL\u2026utInflater.from(context))");
        this.binding = inflate;
        ListAdapter listAdapter = new ListAdapter(new Function1<ChatLandAvatarItem, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandRepeatList$listAdapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChatLandAvatarItem chatLandAvatarItem) {
                invoke2(chatLandAvatarItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ChatLandAvatarItem data) {
                Intrinsics.checkNotNullParameter(data, "data");
                Function1<ChatLandAvatarItem, Unit> clickListener = ChatLandRepeatList.this.getClickListener();
                if (clickListener != null) {
                    clickListener.invoke(data);
                }
            }
        });
        this.listAdapter = listAdapter;
        setContentView(inflate.getMRv());
        RecyclerView recyclerView = inflate.list;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setAdapter(listAdapter);
        setOutsideTouchable(true);
        setFocusable(true);
        setClippingEnabled(false);
        setBackgroundDrawable(null);
    }

    private final void updateLocation(FrameLayout container) {
        RectF rectF = this.currentRectF;
        if (rectF != null) {
            int width = (int) ((rectF.left + rectF.width()) - ViewExtensionsKt.dip(this.context, 20));
            int i3 = (int) rectF.top;
            int dip = ViewExtensionsKt.dip(this.context, 40) * (this.listAdapter.getNUM_BACKGOURND_ICON() < 5 ? this.listAdapter.getNUM_BACKGOURND_ICON() : 5);
            int height = i3 + ((((int) rectF.height()) - dip) / 2);
            setHeight(dip);
            if (container != null) {
                showAtLocation(container, 0, width, height);
            } else {
                update(width, height, getWidth(), dip);
            }
        }
    }

    public final void addView(ChatLandAvatarItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.listAdapter.addView(data);
        updateLocation$default(this, null, 1, null);
    }

    public final Function1<ChatLandAvatarItem, Unit> getClickListener() {
        return this.clickListener;
    }

    public final void removeView(ChatLandAvatarItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.listAdapter.removeView(data);
        SquareBaseKt.getSquareLog().i(TAG, "removeView:" + data.getUin() + ", " + this.listAdapter.getNUM_BACKGOURND_ICON());
        updateLocation$default(this, null, 1, null);
    }

    public final void setClickListener(Function1<? super ChatLandAvatarItem, Unit> function1) {
        this.clickListener = function1;
    }

    public final void showList(List<ChatLandAvatarItem> list, FrameLayout container, RectF rectF) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(rectF, "rectF");
        this.currentRectF = rectF;
        this.listAdapter.setData(list);
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("init: ");
        List<ChatLandAvatarItem> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((ChatLandAvatarItem) it.next()).getUin());
        }
        sb5.append(arrayList);
        squareLog.i(TAG, sb5.toString());
        updateLocation(container);
    }

    static /* synthetic */ void updateLocation$default(ChatLandRepeatList chatLandRepeatList, FrameLayout frameLayout, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            frameLayout = null;
        }
        chatLandRepeatList.updateLocation(frameLayout);
    }
}

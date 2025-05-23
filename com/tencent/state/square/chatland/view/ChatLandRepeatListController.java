package com.tencent.state.square.chatland.view;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.state.map.BaseMapView;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapContainer;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapPlayableViewHolder;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.avatar.SquareAvatarView;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.chatland.data.ChatLandTableItem;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.Table;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001!B8\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u000bJ\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u001c\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eJ\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00142\b\b\u0002\u0010 \u001a\u00020\u0012R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R)\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/square/chatland/view/ChatLandRepeatListController;", "", "getMapView", "Lkotlin/Function0;", "Lcom/tencent/state/square/SquareView;", "showItemMsgPanel", "Lkotlin/Function1;", "Lcom/tencent/state/square/chatland/data/ChatLandAvatarItem;", "Lkotlin/ParameterName;", "name", "data", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "currentList", "", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "Lcom/tencent/state/square/chatland/view/ChatLandRepeatList;", "checkAddAvatarRepeat", "", "current", "Lcom/tencent/state/map/MapItem;", "hide", "initPanel", "context", "Landroid/content/Context;", "removeItem", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "resetLocation", "Landroid/graphics/RectF;", "show", "list", "updateList", "isDelete", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandRepeatListController {
    private static final String TAG = "ChatLandRepeatListController";
    private List<ChatLandAvatarItem> currentList;
    private final Function0<SquareView> getMapView;
    private ChatLandRepeatList panel;
    private final Function1<ChatLandAvatarItem, Unit> showItemMsgPanel;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatLandRepeatListController(Function0<SquareView> getMapView, Function1<? super ChatLandAvatarItem, Unit> showItemMsgPanel) {
        Intrinsics.checkNotNullParameter(getMapView, "getMapView");
        Intrinsics.checkNotNullParameter(showItemMsgPanel, "showItemMsgPanel");
        this.getMapView = getMapView;
        this.showItemMsgPanel = showItemMsgPanel;
    }

    private final boolean checkAddAvatarRepeat(MapItem current) {
        boolean z16;
        boolean z17;
        int centerX = current.getLocation().getCenterX();
        int centerY = current.getLocation().getCenterY();
        List<ChatLandAvatarItem> list = this.currentList;
        if (list != null) {
            List<ChatLandAvatarItem> list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((ChatLandAvatarItem) it.next()).getUin(), current.getUin())) {
                        z17 = true;
                        break;
                    }
                }
            }
            z17 = false;
            if (z17) {
                return false;
            }
        }
        List<ChatLandAvatarItem> list3 = this.currentList;
        if (list3 != null) {
            List<ChatLandAvatarItem> list4 = list3;
            if (!(list4 instanceof Collection) || !list4.isEmpty()) {
                Iterator<T> it5 = list4.iterator();
                while (it5.hasNext()) {
                    if (((ChatLandAvatarItem) it5.next()).getItemViewLocation().contains(centerX, centerY)) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            if (z16) {
                return true;
            }
        }
        return false;
    }

    private final ChatLandRepeatList initPanel(Context context) {
        ChatLandRepeatList chatLandRepeatList = new ChatLandRepeatList(context);
        chatLandRepeatList.setClickListener(new Function1<ChatLandAvatarItem, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandRepeatListController$initPanel$$inlined$apply$lambda$1
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
                Function1 function1;
                Intrinsics.checkNotNullParameter(data, "data");
                ChatLandRepeatListController.this.hide();
                function1 = ChatLandRepeatListController.this.showItemMsgPanel;
                function1.invoke(data);
            }
        });
        return chatLandRepeatList;
    }

    private final void removeItem(ChatLandAvatarItem r36) {
        List<ChatLandAvatarItem> list = this.currentList;
        if (list != null) {
            list.remove(r36);
            if (list.size() <= 1) {
                hide();
            }
        }
        ChatLandRepeatList chatLandRepeatList = this.panel;
        if (chatLandRepeatList != null) {
            chatLandRepeatList.removeView(r36);
        }
    }

    private final RectF resetLocation() {
        List<ChatLandAvatarItem> list;
        Object firstOrNull;
        MapAdapter adapter;
        MapViewHolder<?> viewHolder;
        SquareAvatarView playerView;
        SquareView invoke = this.getMapView.invoke();
        if (invoke != null && (list = this.currentList) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            final ChatLandAvatarItem chatLandAvatarItem = (ChatLandAvatarItem) firstOrNull;
            if (chatLandAvatarItem != null && (adapter = invoke.getAdapter()) != null && (viewHolder = invoke.getViewHolder(adapter.indexOf(new Function1<MapItem, Boolean>() { // from class: com.tencent.state.square.chatland.view.ChatLandRepeatListController$resetLocation$index$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(MapItem mapItem) {
                    return Boolean.valueOf(invoke2(mapItem));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(MapItem it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Intrinsics.areEqual(it.getUin(), ChatLandAvatarItem.this.getUin()) && it.getType() == ChatLandAvatarItem.this.getType();
                }
            }))) != null) {
                MapPlayableViewHolder mapPlayableViewHolder = (MapPlayableViewHolder) (!(viewHolder instanceof MapPlayableViewHolder) ? null : viewHolder);
                if (mapPlayableViewHolder != null && (playerView = mapPlayableViewHolder.getPlayerView()) != null) {
                    View view = viewHolder.itemView;
                    Intrinsics.checkNotNullExpressionValue(view, "vh.itemView");
                    RectF viewLocation$default = BaseMapView.getViewLocation$default(invoke, view, null, 2, null);
                    viewLocation$default.top += viewLocation$default.height() - BaseMapView.getViewLocation$default(invoke, playerView, null, 2, null).height();
                    return viewLocation$default;
                }
            }
        }
        return null;
    }

    public final void show(Context context, List<ChatLandAvatarItem> list) {
        SquareView invoke;
        MapContainer container;
        ChatLandRepeatList chatLandRepeatList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "list");
        this.currentList = list;
        if (this.panel == null) {
            this.panel = initPanel(context);
        }
        RectF resetLocation = resetLocation();
        if (resetLocation == null || (invoke = this.getMapView.invoke()) == null || (container = invoke.getContainer()) == null || (chatLandRepeatList = this.panel) == null) {
            return;
        }
        chatLandRepeatList.showList(list, container, resetLocation);
    }

    public final void updateList(MapItem data, boolean isDelete) {
        Table table;
        Intrinsics.checkNotNullParameter(data, "data");
        List<ChatLandAvatarItem> list = this.currentList;
        if (list != null) {
            Object obj = null;
            if (!(data instanceof ChatLandAvatarItem)) {
                if (!(data instanceof ChatLandTableItem) || list == null) {
                    return;
                }
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    SitDownInfo sitDown = ((ChatLandAvatarItem) next).getUser().getSitDown();
                    if ((sitDown == null || (table = sitDown.getTable()) == null || table.getId() != ((ChatLandTableItem) data).getTable().getId()) ? false : true) {
                        obj = next;
                        break;
                    }
                }
                ChatLandAvatarItem chatLandAvatarItem = (ChatLandAvatarItem) obj;
                if (chatLandAvatarItem != null) {
                    removeItem(chatLandAvatarItem);
                    return;
                }
                return;
            }
            if (isDelete) {
                if (list != null) {
                    Iterator<T> it5 = list.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        Object next2 = it5.next();
                        if (Intrinsics.areEqual(((ChatLandAvatarItem) next2).getUin(), data.getUin())) {
                            obj = next2;
                            break;
                        }
                    }
                    ChatLandAvatarItem chatLandAvatarItem2 = (ChatLandAvatarItem) obj;
                    if (chatLandAvatarItem2 != null) {
                        removeItem(chatLandAvatarItem2);
                        return;
                    }
                    return;
                }
                return;
            }
            if (checkAddAvatarRepeat(data)) {
                List<ChatLandAvatarItem> list2 = this.currentList;
                if (list2 != null) {
                    Iterator<ChatLandAvatarItem> it6 = list2.iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it6.hasNext()) {
                            i3 = -1;
                            break;
                        } else {
                            if (it6.next().getLocation().getCenterY() <= data.getLocation().getCenterY()) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                    if (i3 != -1) {
                        list2.add(i3, data);
                    } else {
                        list2.add(data);
                    }
                }
                ChatLandRepeatList chatLandRepeatList = this.panel;
                if (chatLandRepeatList != null) {
                    chatLandRepeatList.addView((ChatLandAvatarItem) data);
                }
            }
        }
    }

    public final void hide() {
        this.currentList = null;
        ChatLandRepeatList chatLandRepeatList = this.panel;
        if (chatLandRepeatList != null) {
            chatLandRepeatList.dismiss();
        }
    }

    public static /* synthetic */ void updateList$default(ChatLandRepeatListController chatLandRepeatListController, MapItem mapItem, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        chatLandRepeatListController.updateList(mapItem, z16);
    }
}

package com.tencent.state.square.chatland.view;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.state.event.ChatAddUinToSquare;
import com.tencent.state.map.BaseMapView;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.chatland.view.ChatLandAvatarPanelController;
import com.tencent.state.square.chatland.viewholder.ChatLandAvatarViewHolder;
import com.tencent.state.square.detail.MainScene;
import com.tencent.state.template.data.InterReceiverInfo;
import com.tencent.state.template.data.InterResourceInfo;
import com.tencent.state.template.data.InterSenderInfo;
import com.tencent.state.template.data.User;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0001(B\u0093\u0001\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006\u00126\u0010\f\u001a2\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u000b0\r\u0012!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u001a\u001a\u00020\u000bJ\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020\u000bH\u0002J0\u0010!\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\"\u001a\n\u0012\u0002\b\u00030#j\u0002`$2\u0006\u0010%\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010\u0013J\u0018\u0010'\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010\u0013R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R)\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R>\u0010\f\u001a2\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/tencent/state/square/chatland/view/ChatLandAvatarPanelController;", "", "getMapView", "Lkotlin/Function0;", "Lcom/tencent/state/square/SquareView;", "mergeCallBack", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "uin", "", "sayHiCallback", "Lkotlin/Function2;", "", "nick", "viewProfileCallBack", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "currentItem", "Lcom/tencent/state/square/chatland/data/ChatLandAvatarItem;", "currentVh", "Lcom/tencent/state/square/chatland/viewholder/ChatLandAvatarViewHolder;", "meItem", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "Lcom/tencent/state/square/chatland/view/ChatLandAvatarPanelWindow;", "getCurrentUin", "hide", "initPanel", "context", "Landroid/content/Context;", "isShowing", "", "resetLocation", "show", "vh", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "data", "meData", "updateLocation", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandAvatarPanelController {
    private static final String TAG = "ChatLandAvatarPanelControllers";
    private ChatLandAvatarItem currentItem;
    private ChatLandAvatarViewHolder currentVh;
    private final Function0<SquareView> getMapView;
    private ChatLandAvatarItem meItem;
    private final Function1<Long, Unit> mergeCallBack;
    private ChatLandAvatarPanelWindow panel;
    private final Function2<String, String, Unit> sayHiCallback;
    private final Function1<String, Unit> viewProfileCallBack;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PanelClickType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[PanelClickType.Merge.ordinal()] = 1;
            iArr[PanelClickType.SayHi.ordinal()] = 2;
            iArr[PanelClickType.AddSquare.ordinal()] = 3;
            iArr[PanelClickType.ViewProfile.ordinal()] = 4;
            iArr[PanelClickType.SenderProfile.ordinal()] = 5;
            iArr[PanelClickType.ReceiverProfile.ordinal()] = 6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatLandAvatarPanelController(Function0<SquareView> getMapView, Function1<? super Long, Unit> mergeCallBack, Function2<? super String, ? super String, Unit> sayHiCallback, Function1<? super String, Unit> viewProfileCallBack) {
        Intrinsics.checkNotNullParameter(getMapView, "getMapView");
        Intrinsics.checkNotNullParameter(mergeCallBack, "mergeCallBack");
        Intrinsics.checkNotNullParameter(sayHiCallback, "sayHiCallback");
        Intrinsics.checkNotNullParameter(viewProfileCallBack, "viewProfileCallBack");
        this.getMapView = getMapView;
        this.mergeCallBack = mergeCallBack;
        this.sayHiCallback = sayHiCallback;
        this.viewProfileCallBack = viewProfileCallBack;
    }

    private final ChatLandAvatarPanelWindow initPanel(Context context) {
        ChatLandAvatarPanelWindow chatLandAvatarPanelWindow = new ChatLandAvatarPanelWindow(context);
        chatLandAvatarPanelWindow.setClickListener(new Function1<PanelClickType, Unit>() { // from class: com.tencent.state.square.chatland.view.ChatLandAvatarPanelController$initPanel$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PanelClickType panelClickType) {
                invoke2(panelClickType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PanelClickType type) {
                ChatLandAvatarItem chatLandAvatarItem;
                String uin;
                Function1 function1;
                ChatLandAvatarItem chatLandAvatarItem2;
                String uin2;
                Function2 function2;
                ChatLandAvatarItem chatLandAvatarItem3;
                String str;
                ChatLandAvatarItem chatLandAvatarItem4;
                ChatLandAvatarItem chatLandAvatarItem5;
                String uin3;
                Function1 function12;
                ChatLandAvatarItem chatLandAvatarItem6;
                User user;
                InterResourceInfo interaction;
                InterSenderInfo senderInfo;
                Function1 function13;
                ChatLandAvatarItem chatLandAvatarItem7;
                User user2;
                InterResourceInfo interaction2;
                InterReceiverInfo receiverInfo;
                Function1 function14;
                Intrinsics.checkNotNullParameter(type, "type");
                ChatLandAvatarPanelController.this.hide();
                switch (ChatLandAvatarPanelController.WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                    case 1:
                        chatLandAvatarItem = ChatLandAvatarPanelController.this.currentItem;
                        if (chatLandAvatarItem == null || (uin = chatLandAvatarItem.getUin()) == null) {
                            return;
                        }
                        function1 = ChatLandAvatarPanelController.this.mergeCallBack;
                        function1.invoke(Long.valueOf(Long.parseLong(uin)));
                        return;
                    case 2:
                        chatLandAvatarItem2 = ChatLandAvatarPanelController.this.currentItem;
                        if (chatLandAvatarItem2 == null || (uin2 = chatLandAvatarItem2.getUin()) == null) {
                            return;
                        }
                        function2 = ChatLandAvatarPanelController.this.sayHiCallback;
                        chatLandAvatarItem3 = ChatLandAvatarPanelController.this.currentItem;
                        if (chatLandAvatarItem3 == null || (str = chatLandAvatarItem3.getTroopName()) == null) {
                            str = "";
                        }
                        function2.invoke(uin2, str);
                        return;
                    case 3:
                        chatLandAvatarItem4 = ChatLandAvatarPanelController.this.currentItem;
                        if (chatLandAvatarItem4 != null) {
                            SimpleEventBus.getInstance().dispatchEvent(new ChatAddUinToSquare(chatLandAvatarItem4.getUin(), chatLandAvatarItem4.getUnitType(), MainScene.INSTANCE.parse(Integer.valueOf(chatLandAvatarItem4.getAppId())), true));
                            return;
                        }
                        return;
                    case 4:
                        chatLandAvatarItem5 = ChatLandAvatarPanelController.this.currentItem;
                        if (chatLandAvatarItem5 == null || (uin3 = chatLandAvatarItem5.getUin()) == null) {
                            return;
                        }
                        function12 = ChatLandAvatarPanelController.this.viewProfileCallBack;
                        function12.invoke(uin3);
                        return;
                    case 5:
                        chatLandAvatarItem6 = ChatLandAvatarPanelController.this.currentItem;
                        if (chatLandAvatarItem6 == null || (user = chatLandAvatarItem6.getUser()) == null || (interaction = user.getInteraction()) == null || (senderInfo = interaction.getSenderInfo()) == null) {
                            return;
                        }
                        long uin4 = senderInfo.getUin();
                        function13 = ChatLandAvatarPanelController.this.viewProfileCallBack;
                        function13.invoke(String.valueOf(uin4));
                        return;
                    case 6:
                        chatLandAvatarItem7 = ChatLandAvatarPanelController.this.currentItem;
                        if (chatLandAvatarItem7 == null || (user2 = chatLandAvatarItem7.getUser()) == null || (interaction2 = user2.getInteraction()) == null || (receiverInfo = interaction2.getReceiverInfo()) == null) {
                            return;
                        }
                        long uin5 = receiverInfo.getUin();
                        function14 = ChatLandAvatarPanelController.this.viewProfileCallBack;
                        function14.invoke(String.valueOf(uin5));
                        return;
                    default:
                        return;
                }
            }
        });
        return chatLandAvatarPanelWindow;
    }

    private final void resetLocation() {
        ChatLandAvatarViewHolder chatLandAvatarViewHolder;
        ChatLandAvatarPanelWindow chatLandAvatarPanelWindow;
        SquareView invoke = this.getMapView.invoke();
        if (invoke == null || (chatLandAvatarViewHolder = this.currentVh) == null) {
            return;
        }
        View view = chatLandAvatarViewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "vh.itemView");
        RectF viewLocation$default = BaseMapView.getViewLocation$default(invoke, view, null, 2, null);
        viewLocation$default.top += viewLocation$default.height() - BaseMapView.getViewLocation$default(invoke, chatLandAvatarViewHolder.getPlayerView(), null, 2, null).height();
        ChatLandAvatarItem chatLandAvatarItem = this.currentItem;
        if (chatLandAvatarItem == null || (chatLandAvatarPanelWindow = this.panel) == null) {
            return;
        }
        chatLandAvatarPanelWindow.updateItem(chatLandAvatarItem, this.meItem, invoke.getContainer(), viewLocation$default);
    }

    public final String getCurrentUin() {
        ChatLandAvatarItem chatLandAvatarItem = this.currentItem;
        if (chatLandAvatarItem != null) {
            return chatLandAvatarItem.getUin();
        }
        return null;
    }

    public final void hide() {
        ChatLandAvatarPanelWindow chatLandAvatarPanelWindow;
        ChatLandAvatarPanelWindow chatLandAvatarPanelWindow2 = this.panel;
        if (chatLandAvatarPanelWindow2 == null || !chatLandAvatarPanelWindow2.isShowing() || (chatLandAvatarPanelWindow = this.panel) == null) {
            return;
        }
        chatLandAvatarPanelWindow.dismiss();
    }

    public final boolean isShowing() {
        ChatLandAvatarPanelWindow chatLandAvatarPanelWindow = this.panel;
        return chatLandAvatarPanelWindow != null && chatLandAvatarPanelWindow.isShowing();
    }

    public final void show(Context context, MapViewHolder<?> vh5, ChatLandAvatarItem data, ChatLandAvatarItem meData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vh5, "vh");
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getUser().isReceiver()) {
            hide();
            return;
        }
        this.currentItem = data;
        if (!(vh5 instanceof ChatLandAvatarViewHolder)) {
            vh5 = null;
        }
        this.currentVh = (ChatLandAvatarViewHolder) vh5;
        this.meItem = meData;
        if (this.panel == null) {
            this.panel = initPanel(context);
        }
        resetLocation();
    }

    public final void updateLocation(ChatLandAvatarItem data, ChatLandAvatarItem meData) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getUser().isReceiver()) {
            hide();
            return;
        }
        this.currentItem = data;
        this.meItem = meData;
        ChatLandAvatarPanelWindow chatLandAvatarPanelWindow = this.panel;
        if (chatLandAvatarPanelWindow == null || !chatLandAvatarPanelWindow.isShowing()) {
            return;
        }
        resetLocation();
    }
}

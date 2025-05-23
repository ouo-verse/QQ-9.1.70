package com.tencent.state.square.chatland;

import android.content.Context;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.state.SquareRuntime;
import com.tencent.state.map.BaseMapView;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapContainer;
import com.tencent.state.map.MapFragment;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewModel;
import com.tencent.state.publicchat.PublicChatViewSlots;
import com.tencent.state.publicchat.action.MergeAction;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.action.MsgInputBoxHidden;
import com.tencent.state.publicchat.action.MsgInputBoxShown;
import com.tencent.state.publicchat.action.SayHiAction;
import com.tencent.state.publicchat.action.SendTextMsgSuccessAction;
import com.tencent.state.publicchat.action.ViewTaFocusAction;
import com.tencent.state.publicchat.data.MsgConfInfo;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.publicchat.data.Scene;
import com.tencent.state.publicchat.data.ShowMsgPanelParams;
import com.tencent.state.publicchat.service.SendMsgReq;
import com.tencent.state.publicchat.view.IMessageItemViewFactory;
import com.tencent.state.publicchat.view.msgPanel.IMessagePanelItemFactory;
import com.tencent.state.publicchat.view.msgPanel.MessagePanelItemViewFactoryKt;
import com.tencent.state.square.IRouter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.MessageRecordType;
import com.tencent.state.square.chatland.component.ChatLandInteractionMotionComponent;
import com.tencent.state.square.chatland.component.ChatLandPublicChatComponent;
import com.tencent.state.square.chatland.component.ChatLandSeatComponent;
import com.tencent.state.square.chatland.component.ChatLandSquareComponent;
import com.tencent.state.square.chatland.component.ChatLandUiComponent;
import com.tencent.state.square.chatland.component.IChatLandEventListener;
import com.tencent.state.square.chatland.component.IChatLandUIOwner;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.chatland.publicchat.ChatLandPublicChatViewFactoryKt;
import com.tencent.state.square.components.BasicServiceComponent;
import com.tencent.state.template.data.RoomThemeData;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.TableType;
import com.tencent.state.template.data.User;
import com.tencent.state.template.item.TemplateAvatarItem;
import com.tencent.state.template.map.component.TemplateRoomComponent;
import com.tencent.state.template.push.BubbleMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.httpcore.message.TokenParser;
import yr4.e;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 8*\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\b\b\u0001\u0010\u0004*\u00020\u00052\u00020\u0006:\u00018B!\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u000fH\u0002\u00a2\u0006\u0002\u0010\u001bJ\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000fH\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010,\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010-\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010.\u001a\u00020(2\u0006\u0010\"\u001a\u00020#H\u0016J\n\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u00101\u001a\u00020(2\u0006\u00102\u001a\u000203H\u0016J\u0018\u00104\u001a\u00020(2\u0006\u0010&\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u0011H\u0016J\u0010\u00106\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u00107\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00069"}, d2 = {"Lcom/tencent/state/square/chatland/ChatLandOwner;", "V", "Lcom/tencent/state/map/BaseMapView;", "Lcom/tencent/state/map/MapView;", "VM", "Lcom/tencent/state/map/MapViewModel;", "Lcom/tencent/state/square/chatland/component/IChatLandUIOwner;", "fragment", "Lcom/tencent/state/map/MapFragment;", "appId", "", "(Lcom/tencent/state/map/MapFragment;I)V", "createTextMsg", "Lcom/tencent/state/publicchat/service/SendMsgReq;", "channelId", "", "msgTxt", "", "getAppId", "getMsgItemViewFactories", "", "Lcom/tencent/state/publicchat/view/IMessageItemViewFactory;", "getMsgPanelItemView", "Lcom/tencent/state/publicchat/view/msgPanel/IMessagePanelItemFactory;", "params", "Lcom/tencent/state/publicchat/data/ShowMsgPanelParams;", "getMyTableId", "()Ljava/lang/Long;", "getPublicChatViewSlots", "Lcom/tencent/state/publicchat/PublicChatViewSlots;", "getRoomId", "getRoomThemeData", "Lcom/tencent/state/template/data/RoomThemeData;", "getTextMsgMaxLen", "conf", "Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", IProfileProtocolConst.PARAM_IS_FRIEND, "", "uin", "onAddBackgroundViewToMap", "", "view", "Landroid/view/View;", "onAddViewToMap", "onAddViewToParentFragment", "onAddViewToScreen", "onConfigLoaded", "onGetMapSize", "Landroid/util/Size;", "onMsgAction", "action", "Lcom/tencent/state/publicchat/action/MsgAction;", "onOpenAIO", "nickname", "onRemoveViewFromScreen", "removeViewFromMap", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandOwner<V extends BaseMapView<?>, VM extends MapViewModel> implements IChatLandUIOwner {
    private static final int DEFAULT_TEXT_MSG_MAX_LEN = 100;
    private static final String TAG = "ChatLandOwner";
    private final int appId;
    private final MapFragment<V, VM> fragment;

    public ChatLandOwner(MapFragment<V, VM> fragment, int i3) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
        this.appId = i3;
    }

    private final Long getMyTableId() {
        MapAdapter adapter;
        User user;
        SitDownInfo sitDown;
        V mapView = this.fragment.getMapView();
        if (mapView != null && (adapter = mapView.getAdapter()) != null) {
            MapItem itemData = adapter.getItemData(adapter.getMeIndex());
            if (!(itemData instanceof TemplateAvatarItem)) {
                itemData = null;
            }
            TemplateAvatarItem templateAvatarItem = (TemplateAvatarItem) itemData;
            Long valueOf = (templateAvatarItem == null || (user = templateAvatarItem.getUser()) == null || (sitDown = user.getSitDown()) == null) ? null : Long.valueOf(sitDown.getTableId());
            if (valueOf != null) {
                return valueOf;
            }
        }
        return null;
    }

    @Override // com.tencent.state.publicchat.IPublicChatOwner
    public int getAppId() {
        return this.appId;
    }

    @Override // com.tencent.state.publicchat.IPublicChatUIOwner
    public List<IMessagePanelItemFactory> getMsgPanelItemView(ShowMsgPanelParams params) {
        User user;
        SitDownInfo sitDown;
        Table table;
        User user2;
        SitDownInfo sitDown2;
        Table table2;
        Intrinsics.checkNotNullParameter(params, "params");
        ArrayList arrayList = new ArrayList();
        TableType tableType = null;
        ChatLandSeatComponent chatLandSeatComponent = (ChatLandSeatComponent) this.fragment.getComponent(ChatLandSeatComponent.class, null, Integer.valueOf(this.appId));
        ChatLandAvatarItem meAvatarItem = chatLandSeatComponent != null ? chatLandSeatComponent.getMeAvatarItem() : null;
        ChatLandSeatComponent chatLandSeatComponent2 = (ChatLandSeatComponent) this.fragment.getComponent(ChatLandSeatComponent.class, null, Integer.valueOf(this.appId));
        ChatLandAvatarItem findAvatarItemByUin = chatLandSeatComponent2 != null ? chatLandSeatComponent2.findAvatarItemByUin(String.valueOf(params.getUser().getUin())) : null;
        boolean z16 = meAvatarItem != null;
        boolean z17 = findAvatarItemByUin != null;
        if (z16 && z17) {
            TableType tableType2 = (meAvatarItem == null || (user2 = meAvatarItem.getUser()) == null || (sitDown2 = user2.getSitDown()) == null || (table2 = sitDown2.getTable()) == null) ? null : table2.getTableType();
            TableType tableType3 = TableType.TABLE_TYPE_FIXED;
            if (tableType2 != tableType3) {
                if (findAvatarItemByUin != null && (user = findAvatarItemByUin.getUser()) != null && (sitDown = user.getSitDown()) != null && (table = sitDown.getTable()) != null) {
                    tableType = table.getTableType();
                }
                if (tableType != tableType3) {
                    arrayList.add(MessagePanelItemViewFactoryKt.getItemViewMergeViewFactory());
                }
            }
        }
        arrayList.add(MessagePanelItemViewFactoryKt.getItemViewSayHiViewFactory());
        arrayList.add(MessagePanelItemViewFactoryKt.getItemViewProfileViewFactory());
        SquareRuntime squareRuntime = SquareRuntime.INSTANCE;
        if (!squareRuntime.hasNearbyMark()) {
            arrayList.add(MessagePanelItemViewFactoryKt.getItemViewAddToSquareViewFactory());
        }
        arrayList.add(MessagePanelItemViewFactoryKt.getItemViewFocusViewFactory());
        if (squareRuntime.hasNearbyMark()) {
            arrayList.add(MessagePanelItemViewFactoryKt.getItemViewReportViewFactory());
        } else {
            arrayList.add(MessagePanelItemViewFactoryKt.getItemViewOpenExtraMenuViewFactory());
        }
        return arrayList;
    }

    @Override // com.tencent.state.publicchat.IPublicChatUIOwner
    public PublicChatViewSlots getPublicChatViewSlots() {
        ChatLandUiComponent chatLandUiComponent = (ChatLandUiComponent) this.fragment.getComponent(ChatLandUiComponent.class, null, Integer.valueOf(this.appId));
        if (chatLandUiComponent != null) {
            return chatLandUiComponent.getPublicChatViewSlots();
        }
        return null;
    }

    @Override // com.tencent.state.publicchat.IPublicChatOwner
    public long getRoomId() {
        Long myRoomId;
        TemplateRoomComponent templateRoomComponent = (TemplateRoomComponent) this.fragment.getComponent(TemplateRoomComponent.class, null, Integer.valueOf(this.appId));
        if (templateRoomComponent == null || (myRoomId = templateRoomComponent.getMyRoomId()) == null) {
            return 0L;
        }
        return myRoomId.longValue();
    }

    @Override // com.tencent.state.publicchat.IPublicChatOwner
    public RoomThemeData getRoomThemeData() {
        TemplateRoomComponent templateRoomComponent = (TemplateRoomComponent) this.fragment.getComponent(TemplateRoomComponent.class, null, Integer.valueOf(this.appId));
        if (templateRoomComponent != null) {
            return templateRoomComponent.getRoomThemeInfo();
        }
        return null;
    }

    @Override // com.tencent.state.publicchat.IPublicChatOwner
    public Scene getScene() {
        return IChatLandUIOwner.DefaultImpls.getScene(this);
    }

    @Override // com.tencent.state.publicchat.IPublicChatUIOwner
    public int getTextMsgMaxLen(PublicChatConfInfo conf) {
        Object obj;
        Intrinsics.checkNotNullParameter(conf, "conf");
        Iterator<T> it = conf.getConfInfos().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((MsgConfInfo) obj).getTemplateId(), ChatLandPublicChatViewFactoryKt.getChatLandNormalChatMsgItemViewFactory().getTEMPLATE_ID())) {
                break;
            }
        }
        MsgConfInfo msgConfInfo = (MsgConfInfo) obj;
        if (msgConfInfo != null) {
            return msgConfInfo.getWordsLimit();
        }
        return 100;
    }

    @Override // com.tencent.state.publicchat.IPublicChatUIOwner
    public boolean isFriend(long uin) {
        BasicServiceComponent basicServiceComponent = (BasicServiceComponent) this.fragment.getComponent(BasicServiceComponent.class, null, null);
        ISquareBaseMessageService messageService = basicServiceComponent != null ? basicServiceComponent.getMessageService() : null;
        if (messageService != null) {
            return messageService.isFriend(String.valueOf(uin));
        }
        return false;
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandUIOwner
    public void onAddBackgroundViewToMap(View view) {
        MapContainer container;
        Intrinsics.checkNotNullParameter(view, "view");
        V mapView = this.fragment.getMapView();
        if (mapView == null || (container = mapView.getContainer()) == null) {
            return;
        }
        container.addBackgroundView(view);
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandUIOwner
    public void onAddViewToMap(View view) {
        MapContainer container;
        Intrinsics.checkNotNullParameter(view, "view");
        V mapView = this.fragment.getMapView();
        if (mapView == null || (container = mapView.getContainer()) == null) {
            return;
        }
        container.addView(view);
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandUIOwner
    public void onAddViewToParentFragment(View view) {
        Fragment parentFragment;
        Intrinsics.checkNotNullParameter(view, "view");
        Fragment parentFragment2 = this.fragment.getParentFragment();
        View view2 = (parentFragment2 == null || (parentFragment = parentFragment2.getParentFragment()) == null) ? null : parentFragment.getView();
        ViewGroup viewGroup = (ViewGroup) (view2 instanceof ViewGroup ? view2 : null);
        if (viewGroup != null) {
            viewGroup.addView(view);
        } else {
            onAddViewToScreen(view);
        }
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandUIOwner
    public void onAddViewToScreen(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewBinding binding = this.fragment.getBinding();
        View mContainer = binding != null ? binding.getMContainer() : null;
        ViewGroup viewGroup = (ViewGroup) (mContainer instanceof ViewGroup ? mContainer : null);
        if (viewGroup != null) {
            viewGroup.addView(view);
        }
    }

    @Override // com.tencent.state.publicchat.IPublicChatOwner
    public void onConfigLoaded(PublicChatConfInfo conf) {
        Intrinsics.checkNotNullParameter(conf, "conf");
        IChatLandEventListener iChatLandEventListener = (IChatLandEventListener) this.fragment.getComponent(IChatLandEventListener.class, null, Integer.valueOf(this.appId));
        if (iChatLandEventListener != null) {
            iChatLandEventListener.onPublicChatConfigLoaded(conf);
        }
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandUIOwner
    public Size onGetMapSize() {
        ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) this.fragment.getComponent(ChatLandSquareComponent.class, null, Integer.valueOf(this.appId));
        if (chatLandSquareComponent != null) {
            return chatLandSquareComponent.getMapSize();
        }
        return null;
    }

    @Override // com.tencent.state.publicchat.IPublicChatOwner
    public void onMsgAction(MsgAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        TemplateRoomComponent templateRoomComponent = (TemplateRoomComponent) this.fragment.getComponent(TemplateRoomComponent.class, null, Integer.valueOf(this.appId));
        Long myRoomId = templateRoomComponent != null ? templateRoomComponent.getMyRoomId() : null;
        SquareBaseKt.getSquareLog().d(TAG, "\u6211\u7684\u623f\u95f4 " + myRoomId);
        if (action instanceof ViewTaFocusAction) {
            ChatLandPublicChatComponent chatLandPublicChatComponent = (ChatLandPublicChatComponent) this.fragment.getComponent(ChatLandPublicChatComponent.class, null, Integer.valueOf(this.appId));
            if (chatLandPublicChatComponent != null) {
                chatLandPublicChatComponent.viewTaFocus(((ViewTaFocusAction) action).getUser().getUin());
                return;
            }
            return;
        }
        if (action instanceof MsgInputBoxHidden) {
            ChatLandUiComponent chatLandUiComponent = (ChatLandUiComponent) this.fragment.getComponent(ChatLandUiComponent.class, null, Integer.valueOf(this.appId));
            if (chatLandUiComponent != null) {
                chatLandUiComponent.setActionPanelButtonsVisibility(true);
                return;
            }
            return;
        }
        if (action instanceof MsgInputBoxShown) {
            ChatLandUiComponent chatLandUiComponent2 = (ChatLandUiComponent) this.fragment.getComponent(ChatLandUiComponent.class, null, Integer.valueOf(this.appId));
            if (chatLandUiComponent2 != null) {
                chatLandUiComponent2.setActionPanelButtonsVisibility(false);
                return;
            }
            return;
        }
        if (action instanceof MergeAction) {
            ChatLandInteractionMotionComponent chatLandInteractionMotionComponent = (ChatLandInteractionMotionComponent) this.fragment.getComponent(ChatLandInteractionMotionComponent.class, null, Integer.valueOf(this.appId));
            if (chatLandInteractionMotionComponent != null) {
                chatLandInteractionMotionComponent.openInviteDialog(Long.parseLong(((MergeAction) action).getUin()));
                return;
            }
            return;
        }
        if (action instanceof SendTextMsgSuccessAction) {
            ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) this.fragment.getComponent(ChatLandSquareComponent.class, null, Integer.valueOf(this.appId));
            if (chatLandSquareComponent != null) {
                chatLandSquareComponent.updateSpeakMessageBubble(new BubbleMessage(((SendTextMsgSuccessAction) action).getMsgTxt()));
                return;
            }
            return;
        }
        if (action instanceof SayHiAction) {
            SayHiAction sayHiAction = (SayHiAction) action;
            onOpenAIO(sayHiAction.getUin(), sayHiAction.getNickname());
        }
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandUIOwner
    public void onOpenAIO(String uin, String nickname) {
        ISquareBaseMessageService messageService;
        MessageRecordType messageRecordType;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        SquareBaseKt.getSquareLog().i(TAG, "\u6253\u5f00AIO " + this.appId + TokenParser.SP + uin + TokenParser.SP + nickname);
        if (SquareRuntime.INSTANCE.hasNearbyMark()) {
            Context context = this.fragment.getContext();
            if (context != null) {
                IRouter router = Square.INSTANCE.getConfig().getRouter();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                router.routeToNearbyAIO(context, uin, nickname, "");
                return;
            }
            return;
        }
        BasicServiceComponent basicServiceComponent = (BasicServiceComponent) this.fragment.getComponent(BasicServiceComponent.class, null, null);
        if (basicServiceComponent == null || (messageService = basicServiceComponent.getMessageService()) == null) {
            return;
        }
        boolean isFriend = messageService.isFriend(uin);
        MapFragment<V, VM> mapFragment = this.fragment;
        if (isFriend) {
            messageRecordType = MessageRecordType.RECORD_TYPE_FRIEND;
        } else {
            messageRecordType = MessageRecordType.RECORD_TYPE_SQUARE_TEMP;
        }
        ISquareBaseMessageService.DefaultImpls.openMiniMsgAio$default(messageService, mapFragment, 0, uin, messageRecordType, false, false, null, nickname, null, 320, null);
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandUIOwner
    public void onRemoveViewFromScreen(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewBinding binding = this.fragment.getBinding();
        View mContainer = binding != null ? binding.getMContainer() : null;
        ViewGroup viewGroup = (ViewGroup) (mContainer instanceof ViewGroup ? mContainer : null);
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandUIOwner
    public void removeViewFromMap(View view) {
        MapContainer container;
        Intrinsics.checkNotNullParameter(view, "view");
        V mapView = this.fragment.getMapView();
        if (mapView == null || (container = mapView.getContainer()) == null) {
            return;
        }
        container.removeView(view);
    }

    @Override // com.tencent.state.publicchat.IPublicChatUIOwner
    public List<IMessageItemViewFactory> getMsgItemViewFactories() {
        List<IMessageItemViewFactory> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new IMessageItemViewFactory[]{ChatLandPublicChatViewFactoryKt.getChatLandWelcomeAnnouncementMsgItemFactory(), ChatLandPublicChatViewFactoryKt.getChatLandNormalChatMsgItemViewFactory(), ChatLandPublicChatViewFactoryKt.getChatLandInteractionSuccessChatMsgItemViewFactory(), ChatLandPublicChatViewFactoryKt.getChatLandInteractionDoubleClickMsgItemViewFactory()});
        return listOf;
    }

    @Override // com.tencent.state.publicchat.IPublicChatUIOwner
    public SendMsgReq createTextMsg(long channelId, String msgTxt) {
        Long myRoomId;
        Intrinsics.checkNotNullParameter(msgTxt, "msgTxt");
        long parseLong = Long.parseLong(SquareBaseKt.getSquareCommon().getCurrentAccountUin());
        TemplateRoomComponent templateRoomComponent = (TemplateRoomComponent) this.fragment.getComponent(TemplateRoomComponent.class, null, Integer.valueOf(this.appId));
        long longValue = (templateRoomComponent == null || (myRoomId = templateRoomComponent.getMyRoomId()) == null) ? 0L : myRoomId.longValue();
        Long myTableId = getMyTableId();
        long longValue2 = myTableId != null ? myTableId.longValue() : 0L;
        String template_id = ChatLandPublicChatViewFactoryKt.getChatLandNormalChatMsgItemViewFactory().getTEMPLATE_ID();
        int i3 = this.appId;
        e eVar = new e();
        eVar.f451107a = parseLong;
        eVar.f451108b = longValue;
        eVar.f451109c = longValue2;
        byte[] bytes = msgTxt.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        eVar.f451110d = bytes;
        Unit unit = Unit.INSTANCE;
        return new SendMsgReq(template_id, i3, channelId, eVar, longValue);
    }
}

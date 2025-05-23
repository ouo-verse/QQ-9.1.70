package com.tencent.state.library.publicchat;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.library.LibraryFragment;
import com.tencent.state.library.LibraryMapView;
import com.tencent.state.library.components.fragments.LibraryPublicChatComponent;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapItem;
import com.tencent.state.publicchat.IPublicChatUIOwner;
import com.tencent.state.publicchat.PublicChatViewSlots;
import com.tencent.state.publicchat.action.MsgAction;
import com.tencent.state.publicchat.action.ViewTaFocusAction;
import com.tencent.state.publicchat.data.MsgConfInfo;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.publicchat.data.Scene;
import com.tencent.state.publicchat.data.ShowMsgPanelParams;
import com.tencent.state.publicchat.service.SendMsgReq;
import com.tencent.state.publicchat.view.IMessageItemViewFactory;
import com.tencent.state.publicchat.view.msgPanel.IMessagePanelItemFactory;
import com.tencent.state.publicchat.view.msgPanel.MessagePanelItemViewFactoryKt;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.components.BasicServiceComponent;
import com.tencent.state.square.databinding.VasSquareFragmentLibraryBinding;
import com.tencent.state.template.data.RoomThemeData;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.User;
import com.tencent.state.template.item.TemplateAvatarItem;
import com.tencent.state.template.map.component.TemplateRoomComponent;
import com.tencent.state.template.publicchat.action.ApplyCallGatherAction;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import yr4.e;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000f\u0010\u0016\u001a\u0004\u0018\u00010\nH\u0002\u00a2\u0006\u0002\u0010\u0017J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\nH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006&"}, d2 = {"Lcom/tencent/state/library/publicchat/LibPublicChatOwner;", "Lcom/tencent/state/publicchat/IPublicChatUIOwner;", "fragment", "Lcom/tencent/state/library/LibraryFragment;", "(Lcom/tencent/state/library/LibraryFragment;)V", "getFragment", "()Lcom/tencent/state/library/LibraryFragment;", "createTextMsg", "Lcom/tencent/state/publicchat/service/SendMsgReq;", "channelId", "", "msgTxt", "", "getAppId", "", "getMsgItemViewFactories", "", "Lcom/tencent/state/publicchat/view/IMessageItemViewFactory;", "getMsgPanelItemView", "Lcom/tencent/state/publicchat/view/msgPanel/IMessagePanelItemFactory;", "params", "Lcom/tencent/state/publicchat/data/ShowMsgPanelParams;", "getMyTableId", "()Ljava/lang/Long;", "getPublicChatViewSlots", "Lcom/tencent/state/publicchat/PublicChatViewSlots;", "getTextMsgMaxLen", "conf", "Lcom/tencent/state/publicchat/data/PublicChatConfInfo;", IProfileProtocolConst.PARAM_IS_FRIEND, "", "uin", "onConfigLoaded", "", "onMsgAction", "action", "Lcom/tencent/state/publicchat/action/MsgAction;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibPublicChatOwner implements IPublicChatUIOwner {
    private static final int DEFAULT_TEXT_MSG_MAX_LEN = 100;
    private static final String TAG = "LibPublicChatOwner";
    private final LibraryFragment fragment;

    public LibPublicChatOwner(LibraryFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
    }

    private final Long getMyTableId() {
        MapAdapter adapter;
        User user;
        SitDownInfo sitDown;
        LibraryMapView mapView = this.fragment.getMapView();
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
        return 1;
    }

    public final LibraryFragment getFragment() {
        return this.fragment;
    }

    @Override // com.tencent.state.publicchat.IPublicChatUIOwner
    public List<IMessagePanelItemFactory> getMsgPanelItemView(ShowMsgPanelParams params) {
        List<IMessagePanelItemFactory> listOf;
        Intrinsics.checkNotNullParameter(params, "params");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new IMessagePanelItemFactory[]{MessagePanelItemViewFactoryKt.getItemViewProfileViewFactory(), MessagePanelItemViewFactoryKt.getItemViewAddToSquareViewFactory(), MessagePanelItemViewFactoryKt.getItemViewFocusViewFactory(), MessagePanelItemViewFactoryKt.getItemViewOpenExtraMenuViewFactory()});
        return listOf;
    }

    @Override // com.tencent.state.publicchat.IPublicChatUIOwner
    public PublicChatViewSlots getPublicChatViewSlots() {
        if (this.fragment.getBinding() == null) {
            return null;
        }
        VasSquareFragmentLibraryBinding binding = this.fragment.getBinding();
        Intrinsics.checkNotNull(binding);
        FrameLayout frameLayout = binding.publicChatListContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "fragment.binding!!.publicChatListContainer");
        VasSquareFragmentLibraryBinding binding2 = this.fragment.getBinding();
        Intrinsics.checkNotNull(binding2);
        FrameLayout frameLayout2 = binding2.publicChatBtnContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "fragment.binding!!.publicChatBtnContainer");
        return new PublicChatViewSlots(frameLayout, frameLayout2, null, 4, null);
    }

    @Override // com.tencent.state.publicchat.IPublicChatOwner
    public long getRoomId() {
        return IPublicChatUIOwner.DefaultImpls.getRoomId(this);
    }

    @Override // com.tencent.state.publicchat.IPublicChatOwner
    public RoomThemeData getRoomThemeData() {
        return IPublicChatUIOwner.DefaultImpls.getRoomThemeData(this);
    }

    @Override // com.tencent.state.publicchat.IPublicChatOwner
    public Scene getScene() {
        return IPublicChatUIOwner.DefaultImpls.getScene(this);
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
            if (Intrinsics.areEqual(((MsgConfInfo) obj).getTemplateId(), LibPublicChatViewFactoryKt.getLibNormalChatMsgItemViewFactory().getTEMPLATE_ID())) {
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

    @Override // com.tencent.state.publicchat.IPublicChatOwner
    public void onConfigLoaded(PublicChatConfInfo conf) {
        FrameLayout frameLayout;
        LinearLayout it;
        LinearLayout linearLayout;
        VasSquareFragmentLibraryBinding binding;
        FrameLayout frameLayout2;
        Intrinsics.checkNotNullParameter(conf, "conf");
        if (conf.getShow()) {
            if (this.fragment.isTopFragment() && (binding = this.fragment.getBinding()) != null && (frameLayout2 = binding.publicChatBtnContainer) != null) {
                ViewExtensionsKt.setVisibility(frameLayout2, true);
            }
            VasSquareFragmentLibraryBinding binding2 = this.fragment.getBinding();
            if (binding2 != null && (linearLayout = binding2.seatButtonWrapper) != null) {
                linearLayout.setBackground(null);
            }
            VasSquareFragmentLibraryBinding binding3 = this.fragment.getBinding();
            if (binding3 == null || (it = binding3.seatButton) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(it, "it");
            it.setPadding(0, it.getPaddingTop(), 0, it.getPaddingBottom());
            ViewExtensionsKt.updateLayoutParams(it, new Function1<LinearLayout.LayoutParams, Unit>() { // from class: com.tencent.state.library.publicchat.LibPublicChatOwner$onConfigLoaded$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LinearLayout.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LinearLayout.LayoutParams receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    receiver.width = 0;
                    receiver.weight = 1.0f;
                }
            });
            return;
        }
        VasSquareFragmentLibraryBinding binding4 = this.fragment.getBinding();
        if (binding4 == null || (frameLayout = binding4.publicChatBtnContainer) == null) {
            return;
        }
        ViewExtensionsKt.setVisibility(frameLayout, false);
    }

    @Override // com.tencent.state.publicchat.IPublicChatOwner
    public void onMsgAction(MsgAction action) {
        LibraryPublicChatComponent libraryPublicChatComponent;
        Intrinsics.checkNotNullParameter(action, "action");
        TemplateRoomComponent templateRoomComponent = (TemplateRoomComponent) this.fragment.getComponent(TemplateRoomComponent.class, null, null);
        Long myRoomId = templateRoomComponent != null ? templateRoomComponent.getMyRoomId() : null;
        SquareBaseKt.getSquareLog().d(TAG, "\u6211\u7684\u623f\u95f4 " + myRoomId);
        if (action instanceof ApplyCallGatherAction) {
            LibraryPublicChatComponent libraryPublicChatComponent2 = (LibraryPublicChatComponent) this.fragment.getComponent(LibraryPublicChatComponent.class, null, null);
            if (libraryPublicChatComponent2 != null) {
                libraryPublicChatComponent2.applyCallGather(((ApplyCallGatherAction) action).getInfo());
                return;
            }
            return;
        }
        if (!(action instanceof ViewTaFocusAction) || (libraryPublicChatComponent = (LibraryPublicChatComponent) this.fragment.getComponent(LibraryPublicChatComponent.class, null, null)) == null) {
            return;
        }
        libraryPublicChatComponent.viewTaFocus(((ViewTaFocusAction) action).getUser().getUin());
    }

    @Override // com.tencent.state.publicchat.IPublicChatUIOwner
    public List<IMessageItemViewFactory> getMsgItemViewFactories() {
        List<IMessageItemViewFactory> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new IMessageItemViewFactory[]{LibPublicChatViewFactoryKt.getLibWelcomeAnnouncementMsgItemFactory(), LibPublicChatViewFactoryKt.getLibNormalChatMsgItemViewFactory(), LibPublicChatViewFactoryKt.getLibFocusKeepChatMsgItemViewFactory(), LibPublicChatViewFactoryKt.getLibInviteChatMsgItemViewFactory()});
        return listOf;
    }

    @Override // com.tencent.state.publicchat.IPublicChatUIOwner
    public SendMsgReq createTextMsg(long channelId, String msgTxt) {
        Long myRoomId;
        Intrinsics.checkNotNullParameter(msgTxt, "msgTxt");
        long parseLong = Long.parseLong(SquareBaseKt.getSquareCommon().getCurrentAccountUin());
        TemplateRoomComponent templateRoomComponent = (TemplateRoomComponent) this.fragment.getComponent(TemplateRoomComponent.class, null, null);
        long longValue = (templateRoomComponent == null || (myRoomId = templateRoomComponent.getMyRoomId()) == null) ? 0L : myRoomId.longValue();
        Long myTableId = getMyTableId();
        long longValue2 = myTableId != null ? myTableId.longValue() : 0L;
        String template_id = LibPublicChatViewFactoryKt.getLibNormalChatMsgItemViewFactory().getTEMPLATE_ID();
        int appId = getAppId();
        e eVar = new e();
        eVar.f451107a = parseLong;
        eVar.f451108b = longValue;
        eVar.f451109c = longValue2;
        byte[] bytes = msgTxt.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        eVar.f451110d = bytes;
        Unit unit = Unit.INSTANCE;
        return new SendMsgReq(template_id, appId, channelId, eVar, 0L, 16, null);
    }
}

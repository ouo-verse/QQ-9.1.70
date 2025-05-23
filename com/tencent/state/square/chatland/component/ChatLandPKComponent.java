package com.tencent.state.square.chatland.component;

import android.content.Context;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.publicchat.component.PublicChatUIComponent;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.chatland.component.IChatLandEventListener;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.chatland.view.ChatLandPKPanel;
import com.tencent.state.square.components.fragment.SquareMsgBoxComponent;
import com.tencent.state.square.databinding.ZtpSquareChatLandPkItemBinding;
import com.tencent.state.square.databinding.ZtpSquareChatLandPkPanelBinding;
import com.tencent.state.square.message.box.IMsgBoxManager;
import com.tencent.state.square.message.box.IMsgBoxViewDirector;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.PKResult;
import com.tencent.state.template.data.RoomThemeData;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.User;
import com.tencent.state.template.push.ChoosePKTagMessage;
import com.tencent.state.template.service.VasSquareRoomService;
import com.tencent.state.view.SquareImageView;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0006\u0010\u0012\u001a\u00020\rJ\b\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0006\u0010\u001b\u001a\u00020\rJ\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0012\u0010\u001f\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\u0012\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u0010\u0010%\u001a\u00020\r2\b\b\u0002\u0010&\u001a\u00020\u001eJ\u000e\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/tencent/state/square/chatland/component/ChatLandPKComponent;", "Lcom/tencent/state/square/chatland/component/ChatLandMapBaseComponent;", "Lcom/tencent/state/square/chatland/component/IChatLandEventListener;", "owner", "Lcom/tencent/state/square/chatland/component/IChatLandUIOwner;", "appId", "", "(Lcom/tencent/state/square/chatland/component/IChatLandUIOwner;I)V", "pkPanel", "Lcom/tencent/state/square/chatland/view/ChatLandPKPanel;", "service", "Lcom/tencent/state/template/service/VasSquareRoomService;", "bindPKReportElement", "", "clearPKItemSelection", "handleChooseAction", "id", "optionNum", "hidePKPanel", "initPKPanelView", "onEnterRoom", "info", "Lcom/tencent/state/template/data/EnterRoomInfo;", "onMeFocusEnd", "onMeFocusStart", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "refreshPKOption", "setOpposeIconVisible", NodeProps.VISIBLE, "", "setPKItemSelected", "setSupportIconVisible", "shouldShowPKPanel", "showPKPanel", "themeData", "Lcom/tencent/state/template/data/RoomThemeData;", "showPKPanelIfNeeded", FileReaderHelper.OPEN_FILE_FROM_FORCE, "updatePKTag", "pkTagMessage", "Lcom/tencent/state/template/push/ChoosePKTagMessage;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandPKComponent extends ChatLandMapBaseComponent implements IChatLandEventListener {
    private static final String TAG = "ChatLandPKComponent";
    private final IChatLandUIOwner owner;
    private ChatLandPKPanel pkPanel;
    private final VasSquareRoomService service;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandPKComponent(IChatLandUIOwner owner, int i3) {
        super(i3);
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.owner = owner;
        this.service = new VasSquareRoomService(i3, ChatLandRoomComponentKt.getChatLandRoomConfParser(), new Function0<Size>() { // from class: com.tencent.state.square.chatland.component.ChatLandPKComponent$service$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                WeakReference<VasBaseFragmentComponentGroup> parent;
                VasBaseFragment vasBaseFragment;
                FragmentComponent component$default;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                ChatLandPKComponent chatLandPKComponent = ChatLandPKComponent.this;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(chatLandPKComponent instanceof VasBaseFragmentComponentGroup) ? null : chatLandPKComponent);
                if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, null)) == null) && (((parent = chatLandPKComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) chatLandPKComponent).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSquareComponent.class, null, null, 2, null)) == null))) {
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) chatLandPKComponent).parentFragment;
                    component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 6, null) : null;
                }
                ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) component$default;
                if (chatLandSquareComponent != null) {
                    return chatLandSquareComponent.getMapSize();
                }
                return null;
            }
        });
    }

    private final void bindPKReportElement() {
        ZtpSquareChatLandPkPanelBinding binding;
        SquareImageView it;
        ZtpSquareChatLandPkPanelBinding binding2;
        ZtpSquareChatLandPkItemBinding it5;
        ZtpSquareChatLandPkPanelBinding binding3;
        ZtpSquareChatLandPkItemBinding it6;
        Function2<View, String, Unit> function2 = new Function2<View, String, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandPKComponent$bindPKReportElement$setElementBlock$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, String str) {
                invoke2(view, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view, String element) {
                IChatLandUIOwner iChatLandUIOwner;
                Map<String, Object> mutableMapOf;
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(element, "element");
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                iChatLandUIOwner = ChatLandPKComponent.this.owner;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_IS_ROOM_ID, String.valueOf(iChatLandUIOwner.getRoomId())));
                squareReporter.setElementInfo(view, element, mutableMapOf, false, false);
            }
        };
        ChatLandPKPanel chatLandPKPanel = this.pkPanel;
        if (chatLandPKPanel != null) {
            function2.invoke(chatLandPKPanel, SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_PK_TOAST);
        }
        ChatLandPKPanel chatLandPKPanel2 = this.pkPanel;
        if (chatLandPKPanel2 != null && (binding3 = chatLandPKPanel2.getBinding()) != null && (it6 = binding3.supportItem) != null) {
            Intrinsics.checkNotNullExpressionValue(it6, "it");
            RelativeLayout mContainer = it6.getMContainer();
            Intrinsics.checkNotNullExpressionValue(mContainer, "it.root");
            function2.invoke(mContainer, SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_PK_SUPPORT);
        }
        ChatLandPKPanel chatLandPKPanel3 = this.pkPanel;
        if (chatLandPKPanel3 != null && (binding2 = chatLandPKPanel3.getBinding()) != null && (it5 = binding2.opposeItem) != null) {
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            RelativeLayout mContainer2 = it5.getMContainer();
            Intrinsics.checkNotNullExpressionValue(mContainer2, "it.root");
            function2.invoke(mContainer2, SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_PK_OPPOSE);
        }
        ChatLandPKPanel chatLandPKPanel4 = this.pkPanel;
        if (chatLandPKPanel4 == null || (binding = chatLandPKPanel4.getBinding()) == null || (it = binding.closeBtn) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        function2.invoke(it, SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_PK_CLOSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleChooseAction(int id5, final int optionNum) {
        String str;
        ChatLandPKPanel chatLandPKPanel = this.pkPanel;
        if (chatLandPKPanel == null || !chatLandPKPanel.getIsPAGAnimating()) {
            ChatLandPKPanel chatLandPKPanel2 = this.pkPanel;
            if (chatLandPKPanel2 == null || !chatLandPKPanel2.getIsAnimating()) {
                setSupportIconVisible(R.id.qox == id5);
                setOpposeIconVisible(R.id.qaj == id5);
                ChatLandPKPanel chatLandPKPanel3 = this.pkPanel;
                if (chatLandPKPanel3 != null) {
                    chatLandPKPanel3.updatePAGViewLayoutParam(id5);
                }
                if (optionNum == 1) {
                    str = ChatLandPKPanel.PARTICLE_PAG_URL;
                } else {
                    str = ChatLandPKPanel.PARTICLE_PAG_OPPOSE_URL;
                }
                ChatLandPKPanel chatLandPKPanel4 = this.pkPanel;
                if (chatLandPKPanel4 != null) {
                    chatLandPKPanel4.playPAGWithURL(str);
                }
                this.service.choose(this.owner.getRoomId(), optionNum, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandPKComponent$handleChooseAction$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        WeakReference<VasBaseFragmentComponentGroup> parent;
                        VasBaseFragment vasBaseFragment;
                        FragmentComponent component$default;
                        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                        if (z16) {
                            ChatLandPKComponent chatLandPKComponent = ChatLandPKComponent.this;
                            Integer valueOf = Integer.valueOf(chatLandPKComponent.getAppId());
                            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(chatLandPKComponent instanceof VasBaseFragmentComponentGroup) ? null : chatLandPKComponent);
                            if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, valueOf)) == null) && (((parent = chatLandPKComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, valueOf)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) chatLandPKComponent).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSquareComponent.class, null, valueOf, 2, null)) == null))) {
                                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) chatLandPKComponent).parentFragment;
                                component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 6, null) : null;
                            }
                            ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) component$default;
                            if (chatLandSquareComponent != null) {
                                int indexByUinType$default = ChatLandSquareComponent.getIndexByUinType$default(chatLandSquareComponent, SquareBaseKt.getSquareCommon().getCurrentAccountUin(), 0, 2, null);
                                ChatLandAvatarItem meAvatarItemInLands = ChatLandPKComponent.this.getMeAvatarItemInLands();
                                if (meAvatarItemInLands == null || -1 == indexByUinType$default) {
                                    return;
                                }
                                SitDownInfo sitDown = meAvatarItemInLands.getUser().getSitDown();
                                if (sitDown != null) {
                                    sitDown.setOption(optionNum);
                                }
                                chatLandSquareComponent.updateByIndex(indexByUinType$default, meAvatarItemInLands);
                            }
                        }
                    }
                });
            }
        }
    }

    private final void initPKPanelView() {
        final Context context;
        Fragment parentFragment;
        Fragment parentFragment2;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        VasBaseFragment fragment2 = getFragment();
        View view = (fragment2 == null || (parentFragment = fragment2.getParentFragment()) == null || (parentFragment2 = parentFragment.getParentFragment()) == null) ? null : parentFragment2.getView();
        if (((ViewGroup) (view instanceof ViewGroup ? view : null)) != null) {
            ChatLandPKPanel chatLandPKPanel = new ChatLandPKPanel(context, null, 0, 6, null);
            this.owner.onAddViewToParentFragment(chatLandPKPanel);
            Unit unit = Unit.INSTANCE;
            this.pkPanel = chatLandPKPanel;
            ViewExtensionsKt.updateLayoutParams(chatLandPKPanel, new Function1<RelativeLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandPKComponent$initPKPanelView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(RelativeLayout.LayoutParams layoutParams) {
                    invoke2(layoutParams);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(RelativeLayout.LayoutParams receiver) {
                    Intrinsics.checkNotNullParameter(receiver, "$receiver");
                    receiver.width = -1;
                    receiver.height = com.tencent.state.square.common.ViewExtensionsKt.dip(context, 108);
                    receiver.setMargins(com.tencent.state.square.common.ViewExtensionsKt.dip(context, 16), com.tencent.state.square.common.ViewExtensionsKt.dip(context, 42), com.tencent.state.square.common.ViewExtensionsKt.dip(context, 16), 0);
                }
            });
            return;
        }
        ChatLandPKPanel chatLandPKPanel2 = new ChatLandPKPanel(context, null, 0, 6, null);
        this.owner.onAddViewToScreen(chatLandPKPanel2);
        Unit unit2 = Unit.INSTANCE;
        this.pkPanel = chatLandPKPanel2;
        ViewExtensionsKt.updateLayoutParams(chatLandPKPanel2, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandPKComponent$initPKPanelView$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FrameLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.width = -1;
                receiver.height = com.tencent.state.square.common.ViewExtensionsKt.dip(context, 108);
                receiver.setMargins(com.tencent.state.square.common.ViewExtensionsKt.dip(context, 16), com.tencent.state.square.common.ViewExtensionsKt.dip(context, 42), com.tencent.state.square.common.ViewExtensionsKt.dip(context, 16), 0);
            }
        });
    }

    private final void setOpposeIconVisible(boolean visible) {
        ZtpSquareChatLandPkPanelBinding binding;
        ZtpSquareChatLandPkItemBinding ztpSquareChatLandPkItemBinding;
        SquareImageView squareImageView;
        ZtpSquareChatLandPkPanelBinding binding2;
        ZtpSquareChatLandPkItemBinding ztpSquareChatLandPkItemBinding2;
        SquareImageView squareImageView2;
        ChatLandPKPanel chatLandPKPanel = this.pkPanel;
        if (chatLandPKPanel != null && (binding2 = chatLandPKPanel.getBinding()) != null && (ztpSquareChatLandPkItemBinding2 = binding2.opposeItem) != null && (squareImageView2 = ztpSquareChatLandPkItemBinding2.chooseSelectedIcon) != null) {
            ViewExtensionsKt.setVisibility(squareImageView2, visible);
        }
        ChatLandPKPanel chatLandPKPanel2 = this.pkPanel;
        if (chatLandPKPanel2 == null || (binding = chatLandPKPanel2.getBinding()) == null || (ztpSquareChatLandPkItemBinding = binding.opposeItem) == null || (squareImageView = ztpSquareChatLandPkItemBinding.chooseWatermark) == null) {
            return;
        }
        ViewExtensionsKt.setVisibility(squareImageView, visible);
    }

    private final void setPKItemSelected(User user) {
        SitDownInfo sitDown;
        SitDownInfo sitDown2;
        PKResult pKResult = null;
        if (PKResult.UNSELECTED == ((user == null || (sitDown2 = user.getSitDown()) == null) ? null : sitDown2.getPkResult())) {
            return;
        }
        PKResult pKResult2 = PKResult.SUPPORT;
        if (user != null && (sitDown = user.getSitDown()) != null) {
            pKResult = sitDown.getPkResult();
        }
        boolean z16 = pKResult2 == pKResult;
        setSupportIconVisible(z16);
        setOpposeIconVisible(true ^ z16);
    }

    private final void setSupportIconVisible(boolean visible) {
        ZtpSquareChatLandPkPanelBinding binding;
        ZtpSquareChatLandPkItemBinding ztpSquareChatLandPkItemBinding;
        SquareImageView squareImageView;
        ZtpSquareChatLandPkPanelBinding binding2;
        ZtpSquareChatLandPkItemBinding ztpSquareChatLandPkItemBinding2;
        SquareImageView squareImageView2;
        ChatLandPKPanel chatLandPKPanel = this.pkPanel;
        if (chatLandPKPanel != null && (binding2 = chatLandPKPanel.getBinding()) != null && (ztpSquareChatLandPkItemBinding2 = binding2.supportItem) != null && (squareImageView2 = ztpSquareChatLandPkItemBinding2.chooseSelectedIcon) != null) {
            ViewExtensionsKt.setVisibility(squareImageView2, visible);
        }
        ChatLandPKPanel chatLandPKPanel2 = this.pkPanel;
        if (chatLandPKPanel2 == null || (binding = chatLandPKPanel2.getBinding()) == null || (ztpSquareChatLandPkItemBinding = binding.supportItem) == null || (squareImageView = ztpSquareChatLandPkItemBinding.chooseWatermark) == null) {
            return;
        }
        ViewExtensionsKt.setVisibility(squareImageView, visible);
    }

    private final boolean shouldShowPKPanel() {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        User user;
        SitDownInfo sitDown;
        PKResult pKResult = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(ChatLandPKComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandPKComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandPKComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandPKComponent.class, null, null, 6, null) : null;
        }
        ChatLandPKComponent chatLandPKComponent = (ChatLandPKComponent) component$default;
        ChatLandAvatarItem meAvatarItemInLands = chatLandPKComponent != null ? chatLandPKComponent.getMeAvatarItemInLands() : null;
        PKResult pKResult2 = PKResult.UNSELECTED;
        if (meAvatarItemInLands != null && (user = meAvatarItemInLands.getUser()) != null && (sitDown = user.getSitDown()) != null) {
            pKResult = sitDown.getPkResult();
        }
        return pKResult2 == pKResult;
    }

    private final void showPKPanel(RoomThemeData themeData) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Map<String, Object> mutableMapOf;
        IMsgBoxManager msgBoxManager;
        ZtpSquareChatLandPkPanelBinding binding;
        ZtpSquareChatLandPkItemBinding ztpSquareChatLandPkItemBinding;
        TextView textView;
        ZtpSquareChatLandPkPanelBinding binding2;
        ZtpSquareChatLandPkItemBinding ztpSquareChatLandPkItemBinding2;
        TextView textView2;
        ZtpSquareChatLandPkPanelBinding binding3;
        TextView textView3;
        String text;
        ZtpSquareChatLandPkPanelBinding binding4;
        SquareImageView squareImageView;
        ZtpSquareChatLandPkPanelBinding binding5;
        ZtpSquareChatLandPkItemBinding ztpSquareChatLandPkItemBinding3;
        RelativeLayout mContainer;
        ZtpSquareChatLandPkPanelBinding binding6;
        ZtpSquareChatLandPkItemBinding ztpSquareChatLandPkItemBinding4;
        RelativeLayout mContainer2;
        SquareBaseKt.getSquareLog().d(TAG, "showPKPanel");
        VasBaseFragment fragment = getFragment();
        if (fragment == null || fragment.isVisible()) {
            String option1 = themeData != null ? themeData.getOption1() : null;
            if (option1 == null || option1.length() == 0) {
                return;
            }
            String option2 = themeData != null ? themeData.getOption2() : null;
            if (option2 == null || option2.length() == 0) {
                return;
            }
            if (this.pkPanel == null) {
                initPKPanelView();
                ChatLandPKPanel chatLandPKPanel = this.pkPanel;
                if (chatLandPKPanel != null && (binding6 = chatLandPKPanel.getBinding()) != null && (ztpSquareChatLandPkItemBinding4 = binding6.supportItem) != null && (mContainer2 = ztpSquareChatLandPkItemBinding4.getMContainer()) != null) {
                    mContainer2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.component.ChatLandPKComponent$showPKPanel$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View it) {
                            IChatLandUIOwner iChatLandUIOwner;
                            Map<String, Object> mutableMapOf2;
                            ChatLandPKComponent chatLandPKComponent = ChatLandPKComponent.this;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            chatLandPKComponent.handleChooseAction(it.getId(), 1);
                            IReporter squareReporter = SquareBaseKt.getSquareReporter();
                            iChatLandUIOwner = ChatLandPKComponent.this.owner;
                            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_IS_ROOM_ID, String.valueOf(iChatLandUIOwner.getRoomId())));
                            squareReporter.reportEvent("clck", it, mutableMapOf2);
                        }
                    });
                }
                ChatLandPKPanel chatLandPKPanel2 = this.pkPanel;
                if (chatLandPKPanel2 != null && (binding5 = chatLandPKPanel2.getBinding()) != null && (ztpSquareChatLandPkItemBinding3 = binding5.opposeItem) != null && (mContainer = ztpSquareChatLandPkItemBinding3.getMContainer()) != null) {
                    mContainer.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.component.ChatLandPKComponent$showPKPanel$2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View it) {
                            IChatLandUIOwner iChatLandUIOwner;
                            Map<String, Object> mutableMapOf2;
                            ChatLandPKComponent chatLandPKComponent = ChatLandPKComponent.this;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            chatLandPKComponent.handleChooseAction(it.getId(), 2);
                            IReporter squareReporter = SquareBaseKt.getSquareReporter();
                            iChatLandUIOwner = ChatLandPKComponent.this.owner;
                            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_IS_ROOM_ID, String.valueOf(iChatLandUIOwner.getRoomId())));
                            squareReporter.reportEvent("clck", it, mutableMapOf2);
                        }
                    });
                }
                ChatLandPKPanel chatLandPKPanel3 = this.pkPanel;
                if (chatLandPKPanel3 != null && (binding4 = chatLandPKPanel3.getBinding()) != null && (squareImageView = binding4.closeBtn) != null) {
                    squareImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.chatland.component.ChatLandPKComponent$showPKPanel$3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View it) {
                            IChatLandUIOwner iChatLandUIOwner;
                            Map<String, Object> mutableMapOf2;
                            ChatLandPKComponent.this.hidePKPanel();
                            IReporter squareReporter = SquareBaseKt.getSquareReporter();
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            iChatLandUIOwner = ChatLandPKComponent.this.owner;
                            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_IS_ROOM_ID, String.valueOf(iChatLandUIOwner.getRoomId())));
                            squareReporter.reportEvent("clck", it, mutableMapOf2);
                        }
                    });
                }
            }
            ChatLandPKPanel chatLandPKPanel4 = this.pkPanel;
            if (chatLandPKPanel4 != null && (binding3 = chatLandPKPanel4.getBinding()) != null && (textView3 = binding3.pkTitle) != null) {
                textView3.setText((themeData == null || (text = themeData.getText()) == null) ? null : StringsKt__StringsJVMKt.replace$default(text, RedTouch.NEWLINE_CHAR, "", false, 4, (Object) null));
            }
            ChatLandPKPanel chatLandPKPanel5 = this.pkPanel;
            if (chatLandPKPanel5 != null && (binding2 = chatLandPKPanel5.getBinding()) != null && (ztpSquareChatLandPkItemBinding2 = binding2.supportItem) != null && (textView2 = ztpSquareChatLandPkItemBinding2.chooseText) != null) {
                textView2.setText(themeData != null ? themeData.getOption1() : null);
            }
            ChatLandPKPanel chatLandPKPanel6 = this.pkPanel;
            if (chatLandPKPanel6 != null && (binding = chatLandPKPanel6.getBinding()) != null && (ztpSquareChatLandPkItemBinding = binding.opposeItem) != null && (textView = ztpSquareChatLandPkItemBinding.chooseText) != null) {
                textView.setText(themeData != null ? themeData.getOption2() : null);
            }
            ChatLandPKPanel chatLandPKPanel7 = this.pkPanel;
            if (chatLandPKPanel7 != null) {
                chatLandPKPanel7.show();
            }
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(SquareMsgBoxComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(SquareMsgBoxComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, SquareMsgBoxComponent.class, null, null, 2, null)) == null))) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, SquareMsgBoxComponent.class, null, null, 6, null) : null;
            }
            SquareMsgBoxComponent squareMsgBoxComponent = (SquareMsgBoxComponent) component$default;
            if (squareMsgBoxComponent != null && (msgBoxManager = squareMsgBoxComponent.getMsgBoxManager()) != null) {
                IMsgBoxViewDirector.DefaultImpls.enableNewMsgBubble$default(msgBoxManager, false, null, 2, null);
            }
            bindPKReportElement();
            ChatLandPKPanel chatLandPKPanel8 = this.pkPanel;
            if (chatLandPKPanel8 != null) {
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_IS_ROOM_ID, String.valueOf(this.owner.getRoomId())));
                squareReporter.reportEvent("imp", chatLandPKPanel8, mutableMapOf);
            }
        }
    }

    public final void hidePKPanel() {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        IMsgBoxManager msgBoxManager;
        ChatLandPKPanel chatLandPKPanel = this.pkPanel;
        if (chatLandPKPanel != null) {
            chatLandPKPanel.hide();
        }
        ChatLandPKPanel chatLandPKPanel2 = this.pkPanel;
        ViewParent parent2 = chatLandPKPanel2 != null ? chatLandPKPanel2.getParent() : null;
        if (!(parent2 instanceof ViewGroup)) {
            parent2 = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent2;
        if (viewGroup != null) {
            viewGroup.removeView(this.pkPanel);
        }
        this.pkPanel = null;
        clearPKItemSelection();
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(SquareMsgBoxComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(SquareMsgBoxComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, SquareMsgBoxComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, SquareMsgBoxComponent.class, null, null, 6, null) : null;
        }
        SquareMsgBoxComponent squareMsgBoxComponent = (SquareMsgBoxComponent) component$default;
        if (squareMsgBoxComponent == null || (msgBoxManager = squareMsgBoxComponent.getMsgBoxManager()) == null) {
            return;
        }
        IMsgBoxViewDirector.DefaultImpls.enableNewMsgBubble$default(msgBoxManager, true, null, 2, null);
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandEventListener
    public void onChatLandLeaveRoom() {
        IChatLandEventListener.DefaultImpls.onChatLandLeaveRoom(this);
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandEventListener
    public void onChatLandSeatAdded() {
        IChatLandEventListener.DefaultImpls.onChatLandSeatAdded(this);
    }

    @Override // com.tencent.state.square.chatland.component.ChatLandMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onEnterRoom(EnterRoomInfo info) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Intrinsics.checkNotNullParameter(info, "info");
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(PublicChatUIComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(PublicChatUIComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, PublicChatUIComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, PublicChatUIComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        PublicChatUIComponent publicChatUIComponent = (PublicChatUIComponent) fragmentComponent;
        if (publicChatUIComponent != null) {
            publicChatUIComponent.refreshThemeData();
        }
    }

    @Override // com.tencent.state.square.chatland.component.ChatLandMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onMeFocusEnd() {
        hidePKPanel();
    }

    @Override // com.tencent.state.square.chatland.component.ChatLandMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onMeFocusStart(User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        PKResult pKResult = PKResult.UNSELECTED;
        SitDownInfo sitDown = user.getSitDown();
        if (pKResult == (sitDown != null ? sitDown.getPkResult() : null)) {
            showPKPanel(this.owner.getRoomThemeData());
            setPKItemSelected(user);
        }
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandEventListener
    public void onPublicChatConfigLoaded(PublicChatConfInfo conf) {
        Intrinsics.checkNotNullParameter(conf, "conf");
        IChatLandEventListener.DefaultImpls.onPublicChatConfigLoaded(this, conf);
    }

    public final void refreshPKOption() {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ChatLandAvatarItem meAvatarItemInLands;
        WeakReference<VasBaseFragmentComponentGroup> parent2;
        VasBaseFragment vasBaseFragment2;
        FragmentComponent component$default2;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
        WeakReference<VasBaseFragmentComponentGroup> parent3;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default3;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3;
        boolean z16 = this instanceof VasBaseFragmentComponentGroup;
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
        if ((vasBaseFragmentComponentGroup4 == null || (component$default = vasBaseFragmentComponentGroup4.getComponent(ChatLandPKComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandPKComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandPKComponent.class, null, null, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment3 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, ChatLandPKComponent.class, null, null, 6, null) : null;
        }
        ChatLandPKComponent chatLandPKComponent = (ChatLandPKComponent) component$default;
        if (chatLandPKComponent == null || (meAvatarItemInLands = chatLandPKComponent.getMeAvatarItemInLands()) == null) {
            return;
        }
        RoomThemeData roomThemeData = this.owner.getRoomThemeData();
        String option1 = roomThemeData != null ? roomThemeData.getOption1() : null;
        boolean z17 = true;
        if (!(option1 == null || option1.length() == 0)) {
            Map<PKResult, String> pkOptionMap = meAvatarItemInLands.getPkOptionMap();
            PKResult pKResult = PKResult.SUPPORT;
            RoomThemeData roomThemeData2 = this.owner.getRoomThemeData();
            String option12 = roomThemeData2 != null ? roomThemeData2.getOption1() : null;
            Intrinsics.checkNotNull(option12);
            pkOptionMap.put(pKResult, option12);
        }
        RoomThemeData roomThemeData3 = this.owner.getRoomThemeData();
        String option2 = roomThemeData3 != null ? roomThemeData3.getOption2() : null;
        if (option2 != null && option2.length() != 0) {
            z17 = false;
        }
        if (!z17) {
            Map<PKResult, String> pkOptionMap2 = meAvatarItemInLands.getPkOptionMap();
            PKResult pKResult2 = PKResult.OPPOSE;
            RoomThemeData roomThemeData4 = this.owner.getRoomThemeData();
            String option22 = roomThemeData4 != null ? roomThemeData4.getOption2() : null;
            Intrinsics.checkNotNull(option22);
            pkOptionMap2.put(pKResult2, option22);
        }
        Integer valueOf = Integer.valueOf(getAppId());
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup5 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
        if ((vasBaseFragmentComponentGroup5 == null || (component$default2 = vasBaseFragmentComponentGroup5.getComponent(ChatLandSquareComponent.class, valueOf)) == null) && (((parent2 = getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (component$default2 = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, valueOf)) == null) && ((vasBaseFragment2 = ((VasBaseFragmentComponent) this).fragment) == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, valueOf, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default2 = vasBaseFragment4 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, ChatLandSquareComponent.class, null, null, 6, null) : null;
        }
        ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) component$default2;
        Integer valueOf2 = chatLandSquareComponent != null ? Integer.valueOf(ChatLandSquareComponent.getIndexByUinType$default(chatLandSquareComponent, SquareBaseKt.getSquareCommon().getCurrentAccountUin(), 0, 2, null)) : null;
        if (valueOf2 != null) {
            valueOf2.intValue();
            Integer valueOf3 = Integer.valueOf(getAppId());
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup6 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
            if ((vasBaseFragmentComponentGroup6 == null || (fragmentComponent = vasBaseFragmentComponentGroup6.getComponent(ChatLandSquareComponent.class, valueOf3)) == null) && ((parent3 = getParent()) == null || (vasBaseFragmentComponentGroup3 = parent3.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup3.getComponent(ChatLandSquareComponent.class, valueOf3)) == null)) {
                VasBaseFragment vasBaseFragment5 = ((VasBaseFragmentComponent) this).fragment;
                if (vasBaseFragment5 == null || (component$default3 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment5, ChatLandSquareComponent.class, null, valueOf3, 2, null)) == null) {
                    VasBaseFragment vasBaseFragment6 = ((VasBaseFragmentComponent) this).parentFragment;
                    if (vasBaseFragment6 != null) {
                        fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment6, ChatLandSquareComponent.class, null, null, 6, null);
                    }
                } else {
                    fragmentComponent2 = component$default3;
                }
                fragmentComponent = fragmentComponent2;
            }
            ChatLandSquareComponent chatLandSquareComponent2 = (ChatLandSquareComponent) fragmentComponent;
            if (chatLandSquareComponent2 != null) {
                chatLandSquareComponent2.updateByIndex(valueOf2.intValue(), meAvatarItemInLands);
            }
        }
    }

    public final void showPKPanelIfNeeded(boolean force) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ChatLandAvatarItem meAvatarItemInLands;
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandPKComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandPKComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandPKComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandPKComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        ChatLandPKComponent chatLandPKComponent = (ChatLandPKComponent) fragmentComponent;
        if (chatLandPKComponent == null || (meAvatarItemInLands = chatLandPKComponent.getMeAvatarItemInLands()) == null) {
            return;
        }
        if (force || shouldShowPKPanel()) {
            showPKPanel(this.owner.getRoomThemeData());
            setPKItemSelected(meAvatarItemInLands.getUser());
        }
    }

    public final void updatePKTag(ChoosePKTagMessage pkTagMessage) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ChatLandAvatarItem avatarItemDataByUin;
        Intrinsics.checkNotNullParameter(pkTagMessage, "pkTagMessage");
        if (pkTagMessage.getRoomId() != this.owner.getRoomId()) {
            return;
        }
        Integer valueOf = Integer.valueOf(getAppId());
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, valueOf)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, valueOf)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSquareComponent.class, null, valueOf, 2, null)) == null))) {
            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
            component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 6, null) : null;
        }
        ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) component$default;
        if (chatLandSquareComponent == null || (avatarItemDataByUin = chatLandSquareComponent.getAvatarItemDataByUin(pkTagMessage.getUin())) == null) {
            return;
        }
        SitDownInfo sitDown = avatarItemDataByUin.getUser().getSitDown();
        if (sitDown != null) {
            sitDown.setOption(pkTagMessage.getOption());
        }
        chatLandSquareComponent.updateByIndex(ChatLandSquareComponent.getIndexByUinType$default(chatLandSquareComponent, String.valueOf(pkTagMessage.getUin()), 0, 2, null), avatarItemDataByUin);
    }

    private final void clearPKItemSelection() {
        setSupportIconVisible(false);
        setOpposeIconVisible(false);
    }

    public static /* synthetic */ void showPKPanelIfNeeded$default(ChatLandPKComponent chatLandPKComponent, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        chatLandPKComponent.showPKPanelIfNeeded(z16);
    }
}

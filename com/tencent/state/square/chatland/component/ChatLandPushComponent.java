package com.tencent.state.square.chatland.component;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.state.FragmentComponent;
import com.tencent.state.PageType;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.common.push.BasePushManager;
import com.tencent.state.common.push.PushMessage;
import com.tencent.state.publicchat.component.PublicChatUIComponent;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.chatland.component.IChatLandEventListener;
import com.tencent.state.square.components.fragment.SquareFragComponent;
import com.tencent.state.square.data.Resource;
import com.tencent.state.template.data.CommonDataKt;
import com.tencent.state.template.data.InviteInfo;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.User;
import com.tencent.state.template.map.component.ITemplateMapEvent;
import com.tencent.state.template.map.component.TemplatePushComponent;
import com.tencent.state.template.map.component.TemplateRoomComponent;
import com.tencent.state.template.push.BubbleMessage;
import com.tencent.state.template.push.CancelPrayMessage;
import com.tencent.state.template.push.ChoosePKTagMessage;
import com.tencent.state.template.push.KickOutRoomMessage;
import com.tencent.state.template.push.ReenterRoomMessage;
import com.tencent.state.template.push.RoomInteractionAgreeInviteMessage;
import com.tencent.state.template.push.RoomInteractionCancelInviteMessage;
import com.tencent.state.template.push.RoomInteractionEndInteractionMessage;
import com.tencent.state.template.push.RoomInteractionReceiveInviteMessage;
import com.tencent.state.template.push.RoomInteractionUserRefreshMessage;
import com.tencent.state.template.push.RoomMessage;
import com.tencent.state.template.push.RoomRefreshThemeMessage;
import com.tencent.state.template.push.SwitchRoomMessage;
import com.tencent.state.template.push.SwitchTableMessage;
import com.tencent.state.template.push.TaskDoneMessage;
import com.tencent.state.template.push.UserRefreshMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\u0016\u0010\u0016\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010\u0017\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010\u0018\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010\u0019\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010\u001a\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010\u001b\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010\u001c\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010\u001d\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010\u001e\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010\u001f\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010 \u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010!\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010\"\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010#\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010$\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006&"}, d2 = {"Lcom/tencent/state/square/chatland/component/ChatLandPushComponent;", "Lcom/tencent/state/template/map/component/TemplatePushComponent;", "Lcom/tencent/state/square/chatland/component/IChatLandEventListener;", "appId", "", "(I)V", "getAppId", "()I", "getTargetPushManager", "Lcom/tencent/state/common/push/BasePushManager;", "onBackPressed", "", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onChatLandLeaveRoom", "", "onReceive", "messages", "", "Lcom/tencent/state/common/push/PushMessage;", "onReceiveChoosePKTagMessage", "onReceiveFocusMessage", "onReceiveInteractionAgreeInviteMessage", "onReceiveInteractionCancelInviteMessage", "onReceiveInteractionEndInteractionMessage", "onReceiveInteractionReceiveInviteMessage", "onReceiveInteractionUserRefreshMessage", "onReceiveKickOutMessage", "onReceiveReenterRoomMessage", "onReceiveSpeakBubbleMessage", "onReceiveSwitchRoomMessage", "onReceiveSwitchTableMessage", "onReceiveTaskDoneMessage", "onReceiveThemeRefreshMessage", "onReceiveUserRefreshMessage", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandPushComponent extends TemplatePushComponent implements IChatLandEventListener {
    private static final String TAG = "ChatLandPushComponent";
    private final int appId;

    public ChatLandPushComponent(int i3) {
        this.appId = i3;
    }

    private final void onReceiveChoosePKTagMessage(List<? extends PushMessage> messages) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ArrayList<ChoosePKTagMessage> arrayList = new ArrayList();
        for (Object obj : messages) {
            if (obj instanceof ChoosePKTagMessage) {
                arrayList.add(obj);
            }
        }
        for (ChoosePKTagMessage choosePKTagMessage : arrayList) {
            SquareBaseKt.getSquareLog().i(TAG, "onReceiveChoosePKTagMessage: " + choosePKTagMessage);
            if (!CommonDataKt.isMe(choosePKTagMessage.getUin())) {
                Integer valueOf = Integer.valueOf(getAppId());
                FragmentComponent fragmentComponent2 = null;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
                if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandPKComponent.class, valueOf)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandPKComponent.class, valueOf)) == null)) {
                    VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                    if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandPKComponent.class, null, valueOf, 2, null)) == null) {
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
                if (chatLandPKComponent != null) {
                    chatLandPKComponent.updatePKTag(choosePKTagMessage);
                }
            }
        }
    }

    private final void onReceiveInteractionAgreeInviteMessage(List<? extends PushMessage> messages) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ArrayList<RoomInteractionAgreeInviteMessage> arrayList = new ArrayList();
        for (Object obj : messages) {
            if (obj instanceof RoomInteractionAgreeInviteMessage) {
                arrayList.add(obj);
            }
        }
        for (RoomInteractionAgreeInviteMessage roomInteractionAgreeInviteMessage : arrayList) {
            SquareBaseKt.getSquareLog().i(TAG, "onReceiveInteractionAgreeInviteMessage: " + roomInteractionAgreeInviteMessage);
            Context context = null;
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(ChatLandInteractionMotionComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandInteractionMotionComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandInteractionMotionComponent.class, null, null, 2, null)) == null))) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandInteractionMotionComponent.class, null, null, 6, null) : null;
            }
            ChatLandInteractionMotionComponent chatLandInteractionMotionComponent = (ChatLandInteractionMotionComponent) component$default;
            if (chatLandInteractionMotionComponent != null) {
                chatLandInteractionMotionComponent.onInteractionStart(roomInteractionAgreeInviteMessage.getBillNo(), roomInteractionAgreeInviteMessage.getTips());
            }
            ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
            VasBaseFragment fragment = getFragment();
            if (fragment != null) {
                context = fragment.getContext();
            }
            squareCommon.showToastSafely(context, "\u5408\u4f53\u6210\u529f", 2);
        }
    }

    private final void onReceiveInteractionCancelInviteMessage(List<? extends PushMessage> messages) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ArrayList<RoomInteractionCancelInviteMessage> arrayList = new ArrayList();
        for (Object obj : messages) {
            if (obj instanceof RoomInteractionCancelInviteMessage) {
                arrayList.add(obj);
            }
        }
        for (RoomInteractionCancelInviteMessage roomInteractionCancelInviteMessage : arrayList) {
            SquareBaseKt.getSquareLog().i(TAG, "onReceiveInteractionCancelInviteMessage: " + roomInteractionCancelInviteMessage);
            FragmentComponent fragmentComponent2 = null;
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandInteractionMotionComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandInteractionMotionComponent.class, null)) == null)) {
                VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandInteractionMotionComponent.class, null, null, 2, null)) == null) {
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                    if (vasBaseFragment2 != null) {
                        fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandInteractionMotionComponent.class, null, null, 6, null);
                    }
                } else {
                    fragmentComponent2 = component$default;
                }
                fragmentComponent = fragmentComponent2;
            }
            ChatLandInteractionMotionComponent chatLandInteractionMotionComponent = (ChatLandInteractionMotionComponent) fragmentComponent;
            if (chatLandInteractionMotionComponent != null) {
                chatLandInteractionMotionComponent.onInteractionInviteCanceled(roomInteractionCancelInviteMessage.getBillNo(), roomInteractionCancelInviteMessage.getUin());
            }
        }
    }

    private final void onReceiveInteractionEndInteractionMessage(List<? extends PushMessage> messages) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ArrayList<RoomInteractionEndInteractionMessage> arrayList = new ArrayList();
        for (Object obj : messages) {
            if (obj instanceof RoomInteractionEndInteractionMessage) {
                arrayList.add(obj);
            }
        }
        for (final RoomInteractionEndInteractionMessage roomInteractionEndInteractionMessage : arrayList) {
            SquareBaseKt.getSquareLog().i(TAG, "onReceiveInteractionEndInteractionMessage: " + roomInteractionEndInteractionMessage);
            FragmentComponent fragmentComponent2 = null;
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandInteractionMotionComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandInteractionMotionComponent.class, null)) == null)) {
                VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandInteractionMotionComponent.class, null, null, 2, null)) == null) {
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                    if (vasBaseFragment2 != null) {
                        fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandInteractionMotionComponent.class, null, null, 6, null);
                    }
                } else {
                    fragmentComponent2 = component$default;
                }
                fragmentComponent = fragmentComponent2;
            }
            ChatLandInteractionMotionComponent chatLandInteractionMotionComponent = (ChatLandInteractionMotionComponent) fragmentComponent;
            if (chatLandInteractionMotionComponent != null) {
                chatLandInteractionMotionComponent.onInteractionEnd(roomInteractionEndInteractionMessage.getBillNo(), roomInteractionEndInteractionMessage.getUin());
            }
            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandPushComponent$onReceiveInteractionEndInteractionMessage$$inlined$forEach$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    VasBaseFragment fragment;
                    String valueOf = String.valueOf(RoomInteractionEndInteractionMessage.this.getProfile().getUin());
                    ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
                    String nick = RoomInteractionEndInteractionMessage.this.getProfile().getNick();
                    if (nick.length() == 0) {
                        nick = valueOf;
                    }
                    String friendRemarkName = commonUtils.getFriendRemarkName(valueOf, nick);
                    if (friendRemarkName.length() > 10) {
                        StringBuilder sb5 = new StringBuilder();
                        String substring = friendRemarkName.substring(0, 10);
                        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                        sb5.append(substring);
                        sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                        friendRemarkName = sb5.toString();
                    }
                    ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                    fragment = this.getFragment();
                    ICommonUtils.DefaultImpls.showToastSafely$default(squareCommon, fragment != null ? fragment.getContext() : null, friendRemarkName + "\u7ed3\u675f\u4e86\u5408\u4f53", 0, 4, null);
                }
            });
        }
    }

    private final void onReceiveInteractionReceiveInviteMessage(List<? extends PushMessage> messages) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ArrayList<RoomInteractionReceiveInviteMessage> arrayList = new ArrayList();
        for (Object obj : messages) {
            if (obj instanceof RoomInteractionReceiveInviteMessage) {
                arrayList.add(obj);
            }
        }
        for (RoomInteractionReceiveInviteMessage roomInteractionReceiveInviteMessage : arrayList) {
            SquareBaseKt.getSquareLog().i(TAG, "onReceiveInteractionReceiveInviteMessage: " + roomInteractionReceiveInviteMessage);
            InviteInfo inviteInfo = new InviteInfo(roomInteractionReceiveInviteMessage.getBillNo(), roomInteractionReceiveInviteMessage.getProfile(), roomInteractionReceiveInviteMessage.getExpireTs(), roomInteractionReceiveInviteMessage.getMotionName());
            FragmentComponent fragmentComponent2 = null;
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandInteractionMotionComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandInteractionMotionComponent.class, null)) == null)) {
                VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandInteractionMotionComponent.class, null, null, 2, null)) == null) {
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                    if (vasBaseFragment2 != null) {
                        fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandInteractionMotionComponent.class, null, null, 6, null);
                    }
                } else {
                    fragmentComponent2 = component$default;
                }
                fragmentComponent = fragmentComponent2;
            }
            ChatLandInteractionMotionComponent chatLandInteractionMotionComponent = (ChatLandInteractionMotionComponent) fragmentComponent;
            if (chatLandInteractionMotionComponent != null) {
                chatLandInteractionMotionComponent.onInteractionInviteReceived(inviteInfo);
            }
        }
    }

    private final void onReceiveInteractionUserRefreshMessage(List<? extends PushMessage> messages) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ArrayList<RoomInteractionUserRefreshMessage> arrayList = new ArrayList();
        for (Object obj : messages) {
            if (obj instanceof RoomInteractionUserRefreshMessage) {
                arrayList.add(obj);
            }
        }
        for (RoomInteractionUserRefreshMessage roomInteractionUserRefreshMessage : arrayList) {
            SquareBaseKt.getSquareLog().i(TAG, "onReceiveInteractionUserRefreshMessage: " + roomInteractionUserRefreshMessage);
            FragmentComponent fragmentComponent2 = null;
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandInteractionMotionComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandInteractionMotionComponent.class, null)) == null)) {
                VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandInteractionMotionComponent.class, null, null, 2, null)) == null) {
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                    if (vasBaseFragment2 != null) {
                        fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandInteractionMotionComponent.class, null, null, 6, null);
                    }
                } else {
                    fragmentComponent2 = component$default;
                }
                fragmentComponent = fragmentComponent2;
            }
            ChatLandInteractionMotionComponent chatLandInteractionMotionComponent = (ChatLandInteractionMotionComponent) fragmentComponent;
            if (chatLandInteractionMotionComponent != null) {
                chatLandInteractionMotionComponent.onInteractionUserRefresh(roomInteractionUserRefreshMessage.getBillNo(), roomInteractionUserRefreshMessage.getRefreshType(), roomInteractionUserRefreshMessage.getSender(), roomInteractionUserRefreshMessage.getReceiver());
            }
        }
    }

    private final void onReceiveKickOutMessage(List<? extends PushMessage> messages) {
        FragmentComponent fragmentComponent;
        Object obj;
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent2;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : messages) {
            if (obj2 instanceof KickOutRoomMessage) {
                arrayList.add(obj2);
            }
        }
        ListIterator listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            fragmentComponent = null;
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            KickOutRoomMessage kickOutRoomMessage = (KickOutRoomMessage) obj;
            if (kickOutRoomMessage.getRoomId() == getRoomId() && SquareBaseKt.getSquareCommon().isCurrentAccount(String.valueOf(kickOutRoomMessage.getUin()))) {
                break;
            }
        }
        if (((KickOutRoomMessage) obj) != null) {
            SquareBaseKt.getSquareLog().i(TAG, "onReceiveKickOutMessage and exit ChatLand.");
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent2 = vasBaseFragmentComponentGroup2.getComponent(TemplateRoomComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent2 = vasBaseFragmentComponentGroup.getComponent(TemplateRoomComponent.class, null)) == null)) {
                VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateRoomComponent.class, null, null, 2, null)) == null) {
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                    if (vasBaseFragment2 != null) {
                        fragmentComponent = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateRoomComponent.class, null, null, 6, null);
                    }
                } else {
                    fragmentComponent = component$default;
                }
                fragmentComponent2 = fragmentComponent;
            }
            TemplateRoomComponent templateRoomComponent = (TemplateRoomComponent) fragmentComponent2;
            if (templateRoomComponent != null) {
                templateRoomComponent.reenterRoom();
            }
        }
    }

    private final void onReceiveReenterRoomMessage(List<? extends PushMessage> messages) {
        boolean any;
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ArrayList arrayList = new ArrayList();
        for (Object obj : messages) {
            if (obj instanceof ReenterRoomMessage) {
                arrayList.add(obj);
            }
        }
        any = CollectionsKt___CollectionsKt.any(arrayList);
        if (any) {
            SquareBaseKt.getSquareLog().i(TAG, "onReceiveReenterRoomMessage.");
            FragmentComponent fragmentComponent2 = null;
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(TemplateRoomComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(TemplateRoomComponent.class, null)) == null)) {
                VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateRoomComponent.class, null, null, 2, null)) == null) {
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                    if (vasBaseFragment2 != null) {
                        fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateRoomComponent.class, null, null, 6, null);
                    }
                } else {
                    fragmentComponent2 = component$default;
                }
                fragmentComponent = fragmentComponent2;
            }
            TemplateRoomComponent templateRoomComponent = (TemplateRoomComponent) fragmentComponent;
            if (templateRoomComponent != null) {
                templateRoomComponent.reenterRoom();
            }
        }
    }

    private final void onReceiveSpeakBubbleMessage(List<? extends PushMessage> messages) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ArrayList<BubbleMessage> arrayList = new ArrayList();
        for (Object obj : messages) {
            if (obj instanceof BubbleMessage) {
                arrayList.add(obj);
            }
        }
        for (BubbleMessage bubbleMessage : arrayList) {
            SquareBaseKt.getSquareLog().i(TAG, "onReceiveSpeakBubbleMessage: " + bubbleMessage);
            if (!CommonDataKt.isMe(bubbleMessage.getUin())) {
                FragmentComponent fragmentComponent2 = null;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
                if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, null)) == null)) {
                    VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                    if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSquareComponent.class, null, null, 2, null)) == null) {
                        VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                        if (vasBaseFragment2 != null) {
                            fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 6, null);
                        }
                    } else {
                        fragmentComponent2 = component$default;
                    }
                    fragmentComponent = fragmentComponent2;
                }
                ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) fragmentComponent;
                if (chatLandSquareComponent != null) {
                    chatLandSquareComponent.updateSpeakMessageBubble(bubbleMessage);
                }
            }
        }
    }

    private final void onReceiveSwitchRoomMessage(List<? extends PushMessage> messages) {
        boolean any;
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ArrayList arrayList = new ArrayList();
        for (Object obj : messages) {
            if (obj instanceof SwitchRoomMessage) {
                arrayList.add(obj);
            }
        }
        any = CollectionsKt___CollectionsKt.any(arrayList);
        if (any) {
            SquareBaseKt.getSquareLog().i(TAG, "onReceiveSwitchRoomMessage.");
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(TemplateRoomComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(TemplateRoomComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateRoomComponent.class, null, null, 2, null)) == null))) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateRoomComponent.class, null, null, 6, null) : null;
            }
            TemplateRoomComponent templateRoomComponent = (TemplateRoomComponent) component$default;
            if (templateRoomComponent != null) {
                TemplateRoomComponent.switchRoom$default(templateRoomComponent, null, null, 3, null);
            }
        }
    }

    private final void onReceiveSwitchTableMessage(List<? extends PushMessage> messages) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ArrayList<SwitchTableMessage> arrayList = new ArrayList();
        for (Object obj : messages) {
            if (obj instanceof SwitchTableMessage) {
                arrayList.add(obj);
            }
        }
        for (SwitchTableMessage switchTableMessage : arrayList) {
            SquareBaseKt.getSquareLog().i(TAG, "onReceiveSwitchTableMessage: " + switchTableMessage);
            FragmentComponent fragmentComponent2 = null;
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandSeatComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandSeatComponent.class, null)) == null)) {
                VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSeatComponent.class, null, null, 2, null)) == null) {
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                    if (vasBaseFragment2 != null) {
                        fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSeatComponent.class, null, null, 6, null);
                    }
                } else {
                    fragmentComponent2 = component$default;
                }
                fragmentComponent = fragmentComponent2;
            }
            ChatLandSeatComponent chatLandSeatComponent = (ChatLandSeatComponent) fragmentComponent;
            if (chatLandSeatComponent != null) {
                chatLandSeatComponent.onTableSwitched(switchTableMessage.getRoomId(), switchTableMessage.getTableId(), switchTableMessage.getUser());
            } else {
                SquareBaseKt.getSquareLog().d(TAG, "onReceiveSwitchTableMessage: updater is null");
                return;
            }
        }
    }

    private final void onReceiveTaskDoneMessage(List<? extends PushMessage> messages) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        WeakReference<VasBaseFragmentComponentGroup> parent2;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default2;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
        ArrayList<TaskDoneMessage> arrayList = new ArrayList();
        for (Object obj : messages) {
            if (obj instanceof TaskDoneMessage) {
                arrayList.add(obj);
            }
        }
        for (TaskDoneMessage taskDoneMessage : arrayList) {
            SquareBaseKt.getSquareLog().i(TAG, "onReceiveTaskDoneMessage: " + taskDoneMessage);
            if (CommonDataKt.isMe(taskDoneMessage.getUin())) {
                boolean z16 = this instanceof VasBaseFragmentComponentGroup;
                FragmentComponent fragmentComponent2 = null;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
                if ((vasBaseFragmentComponentGroup3 == null || (component$default = vasBaseFragmentComponentGroup3.getComponent(SquareFragComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(SquareFragComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, SquareFragComponent.class, null, null, 2, null)) == null))) {
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                    component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, SquareFragComponent.class, null, null, 6, null) : null;
                }
                SquareFragComponent squareFragComponent = (SquareFragComponent) component$default;
                if (squareFragComponent != null) {
                    squareFragComponent.setTaskRedDotVisible(true);
                }
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
                if ((vasBaseFragmentComponentGroup4 == null || (fragmentComponent = vasBaseFragmentComponentGroup4.getComponent(ChatLandUiComponent.class, null)) == null) && ((parent2 = getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandUiComponent.class, null)) == null)) {
                    VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) this).fragment;
                    if (vasBaseFragment3 == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, ChatLandUiComponent.class, null, null, 2, null)) == null) {
                        VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) this).parentFragment;
                        if (vasBaseFragment4 != null) {
                            fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, ChatLandUiComponent.class, null, null, 6, null);
                        }
                    } else {
                        fragmentComponent2 = component$default2;
                    }
                    fragmentComponent = fragmentComponent2;
                }
                ChatLandUiComponent chatLandUiComponent = (ChatLandUiComponent) fragmentComponent;
                if (chatLandUiComponent != null) {
                    chatLandUiComponent.setTaskRedDotVisible(true);
                }
            }
        }
    }

    private final void onReceiveThemeRefreshMessage(List<? extends PushMessage> messages) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ArrayList<RoomRefreshThemeMessage> arrayList = new ArrayList();
        for (Object obj : messages) {
            if (obj instanceof RoomRefreshThemeMessage) {
                arrayList.add(obj);
            }
        }
        for (RoomRefreshThemeMessage roomRefreshThemeMessage : arrayList) {
            SquareBaseKt.getSquareLog().i(TAG, "onReceiveThemeRefreshMessage: " + roomRefreshThemeMessage);
            FragmentComponent fragmentComponent2 = null;
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandUiComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandUiComponent.class, null)) == null)) {
                VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandUiComponent.class, null, null, 2, null)) == null) {
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                    if (vasBaseFragment2 != null) {
                        fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandUiComponent.class, null, null, 6, null);
                    }
                } else {
                    fragmentComponent2 = component$default;
                }
                fragmentComponent = fragmentComponent2;
            }
            ChatLandUiComponent chatLandUiComponent = (ChatLandUiComponent) fragmentComponent;
            if (chatLandUiComponent != null) {
                chatLandUiComponent.refreshTheme(roomRefreshThemeMessage.getTheme());
            }
        }
    }

    private final void onReceiveUserRefreshMessage(List<? extends PushMessage> messages) {
        List filterIsInstance;
        Object last;
        Resource resource;
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        filterIsInstance = CollectionsKt___CollectionsJvmKt.filterIsInstance(messages, UserRefreshMessage.class);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : filterIsInstance) {
            String uin = ((UserRefreshMessage) obj).getUser().getUin();
            Object obj2 = linkedHashMap.get(uin);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(uin, obj2);
            }
            ((List) obj2).add(obj);
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) ((Map.Entry) it.next()).getValue());
            User user = ((UserRefreshMessage) last).getUser();
            SquareBaseKt.getSquareLog().i(TAG, "onReceiveUserRefreshMessage uin=" + user.getUin());
            SitDownInfo sitDown = user.getSitDown();
            if (sitDown != null && (resource = sitDown.getResource()) != null) {
                FragmentComponent fragmentComponent2 = null;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
                if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, null)) == null)) {
                    VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                    if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSquareComponent.class, null, null, 2, null)) == null) {
                        VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                        if (vasBaseFragment2 != null) {
                            fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 6, null);
                        }
                    } else {
                        fragmentComponent2 = component$default;
                    }
                    fragmentComponent = fragmentComponent2;
                }
                ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) fragmentComponent;
                if (chatLandSquareComponent != null) {
                    chatLandSquareComponent.updateTargetResource(user.getUin(), resource);
                }
            }
        }
    }

    @Override // com.tencent.state.template.fragment.TemplateBaseComponent
    public int getAppId() {
        return this.appId;
    }

    @Override // com.tencent.state.template.map.component.TemplatePushComponent
    public BasePushManager getTargetPushManager() {
        return new BasePushManager(PageType.INSTANCE.parse(Integer.valueOf(getAppId())), getAppId());
    }

    @Override // com.tencent.state.template.map.component.TemplatePushComponent, com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public boolean onBackPressed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        return false;
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandEventListener
    public void onChatLandLeaveRoom() {
        stopPush();
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandEventListener
    public void onChatLandSeatAdded() {
        IChatLandEventListener.DefaultImpls.onChatLandSeatAdded(this);
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandEventListener
    public void onPublicChatConfigLoaded(PublicChatConfInfo conf) {
        Intrinsics.checkNotNullParameter(conf, "conf");
        IChatLandEventListener.DefaultImpls.onPublicChatConfigLoaded(this, conf);
    }

    @Override // com.tencent.state.common.push.IPushListener
    public void onReceive(List<? extends PushMessage> messages) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        if (!messages.isEmpty()) {
            onReceiveFocusMessage(messages);
            onReceiveUserRefreshMessage(messages);
            onReceiveKickOutMessage(messages);
            onReceiveSwitchTableMessage(messages);
            onReceiveReenterRoomMessage(messages);
            onReceiveSwitchRoomMessage(messages);
            onReceiveInteractionReceiveInviteMessage(messages);
            onReceiveInteractionCancelInviteMessage(messages);
            onReceiveInteractionAgreeInviteMessage(messages);
            onReceiveInteractionUserRefreshMessage(messages);
            onReceiveInteractionEndInteractionMessage(messages);
            onReceiveThemeRefreshMessage(messages);
            onReceiveSpeakBubbleMessage(messages);
            onReceiveChoosePKTagMessage(messages);
            onReceiveTaskDoneMessage(messages);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void onReceiveFocusMessage(List<? extends PushMessage> messages) {
        Object last;
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        String skinLink;
        WeakReference<VasBaseFragmentComponentGroup> parent2;
        VasBaseFragment vasBaseFragment2;
        FragmentComponent component$default2;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
        Long l3;
        long roomId;
        RoomMessage roomMessage;
        long tableId;
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : messages) {
            PushMessage pushMessage = (PushMessage) obj2;
            if (pushMessage.getType() == 4 || pushMessage.getType() == 5) {
                arrayList.add(obj2);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = arrayList.iterator();
        while (true) {
            Long l16 = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            PushMessage pushMessage2 = (PushMessage) next;
            boolean z16 = pushMessage2 instanceof RoomMessage;
            RoomMessage roomMessage2 = (RoomMessage) (!z16 ? null : pushMessage2);
            if (roomMessage2 != null) {
                roomId = roomMessage2.getRoomId();
            } else {
                CancelPrayMessage cancelPrayMessage = (CancelPrayMessage) (!(pushMessage2 instanceof CancelPrayMessage) ? null : pushMessage2);
                if (cancelPrayMessage != null) {
                    roomId = cancelPrayMessage.getRoomId();
                } else {
                    l3 = null;
                    long longValue = l3 == null ? l3.longValue() : 0L;
                    roomMessage = (RoomMessage) (z16 ? null : pushMessage2);
                    if (roomMessage == null) {
                        tableId = roomMessage.getTableId();
                    } else {
                        CancelPrayMessage cancelPrayMessage2 = (CancelPrayMessage) (!(pushMessage2 instanceof CancelPrayMessage) ? null : pushMessage2);
                        if (cancelPrayMessage2 != null) {
                            tableId = cancelPrayMessage2.getTableId();
                        }
                        long longValue2 = l16 != null ? l16.longValue() : 0L;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(pushMessage2.getInfo().getTrigger());
                        sb5.append(util.base64_pad_url);
                        sb5.append(longValue);
                        sb5.append(util.base64_pad_url);
                        sb5.append(longValue2);
                        String sb6 = sb5.toString();
                        obj = linkedHashMap.get(sb6);
                        if (obj == null) {
                            obj = new ArrayList();
                            linkedHashMap.put(sb6, obj);
                        }
                        ((List) obj).add(next);
                    }
                    l16 = Long.valueOf(tableId);
                    if (l16 != null) {
                    }
                    StringBuilder sb52 = new StringBuilder();
                    sb52.append(pushMessage2.getInfo().getTrigger());
                    sb52.append(util.base64_pad_url);
                    sb52.append(longValue);
                    sb52.append(util.base64_pad_url);
                    sb52.append(longValue2);
                    String sb62 = sb52.toString();
                    obj = linkedHashMap.get(sb62);
                    if (obj == null) {
                    }
                    ((List) obj).add(next);
                }
            }
            l3 = Long.valueOf(roomId);
            if (l3 == null) {
            }
            roomMessage = (RoomMessage) (z16 ? null : pushMessage2);
            if (roomMessage == null) {
            }
            l16 = Long.valueOf(tableId);
            if (l16 != null) {
            }
            StringBuilder sb522 = new StringBuilder();
            sb522.append(pushMessage2.getInfo().getTrigger());
            sb522.append(util.base64_pad_url);
            sb522.append(longValue);
            sb522.append(util.base64_pad_url);
            sb522.append(longValue2);
            String sb622 = sb522.toString();
            obj = linkedHashMap.get(sb622);
            if (obj == null) {
            }
            ((List) obj).add(next);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) entry.getValue());
            final PushMessage pushMessage3 = (PushMessage) last;
            SquareBaseKt.getSquareLog().d(TAG, "onReceiveFocusMessage: " + ((List) entry.getValue()).size() + ", " + pushMessage3.getType() + ", " + pushMessage3);
            boolean z17 = this instanceof VasBaseFragmentComponentGroup;
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3 = (VasBaseFragmentComponentGroup) (!z17 ? null : this);
            if ((vasBaseFragmentComponentGroup3 == null || (component$default = vasBaseFragmentComponentGroup3.getComponent(ChatLandSeatComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandSeatComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSeatComponent.class, null, null, 2, null)) == null))) {
                VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) this).parentFragment;
                component$default = vasBaseFragment3 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, ChatLandSeatComponent.class, null, null, 6, null) : null;
            }
            ChatLandSeatComponent chatLandSeatComponent = (ChatLandSeatComponent) component$default;
            if (chatLandSeatComponent != null) {
                if (pushMessage3 instanceof RoomMessage) {
                    RoomMessage roomMessage3 = (RoomMessage) pushMessage3;
                    if (roomMessage3.getRoomId() == getRoomId()) {
                        SquareBaseKt.getSquareLog().d(TAG, "onReceiveFocusMessage: RoomFocusMessage");
                        chatLandSeatComponent.sitDown(roomMessage3.getUser());
                        SquareBubbleInfo focusBroadcastSkin = roomMessage3.getUser().getFocusBroadcastSkin();
                        if (focusBroadcastSkin != null && (skinLink = focusBroadcastSkin.getSkinLink()) != null) {
                            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!z17 ? null : this);
                            if ((vasBaseFragmentComponentGroup4 == null || (component$default2 = vasBaseFragmentComponentGroup4.getComponent(PublicChatUIComponent.class, null)) == null) && (((parent2 = getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (component$default2 = vasBaseFragmentComponentGroup2.getComponent(PublicChatUIComponent.class, null)) == null) && ((vasBaseFragment2 = ((VasBaseFragmentComponent) this).fragment) == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, PublicChatUIComponent.class, null, null, 2, null)) == null))) {
                                VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) this).parentFragment;
                                component$default2 = vasBaseFragment4 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, PublicChatUIComponent.class, null, null, 6, null) : null;
                            }
                            PublicChatUIComponent publicChatUIComponent = (PublicChatUIComponent) component$default2;
                            if (publicChatUIComponent != null) {
                                publicChatUIComponent.showBroadcastAnimation(skinLink, roomMessage3.getUser().getInfo().getNick());
                            }
                        }
                        if (roomMessage3.getUser().isMe()) {
                            SquareBaseKt.getSquareLog().d(TAG, "onReceiveFocusMessage: is me focus");
                            Function1<ITemplateMapEvent, Unit> function1 = new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandPushComponent$onReceiveFocusMessage$3$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(ITemplateMapEvent iTemplateMapEvent) {
                                    invoke2(iTemplateMapEvent);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ITemplateMapEvent component) {
                                    Intrinsics.checkNotNullParameter(component, "component");
                                    component.onMeFocusStart(((RoomMessage) PushMessage.this).getUser());
                                }
                            };
                            VasBaseFragment vasBaseFragment5 = ((VasBaseFragmentComponent) this).fragment;
                            if (vasBaseFragment5 != null) {
                                WeakReference<VasBaseFragmentComponentGroup> parent3 = getParent();
                                vasBaseFragment5.forEachComponent(ITemplateMapEvent.class, parent3 != null ? parent3.get() : null, null, function1);
                            }
                        }
                    }
                }
                if (pushMessage3 instanceof CancelPrayMessage) {
                    CancelPrayMessage cancelPrayMessage3 = (CancelPrayMessage) pushMessage3;
                    if (cancelPrayMessage3.getRoomId() == getRoomId()) {
                        SquareBaseKt.getSquareLog().d(TAG, "onReceiveFocusMessage: RoomCancelFocusMessage");
                        chatLandSeatComponent.standUp(cancelPrayMessage3.getTableId(), cancelPrayMessage3.getUin(), false);
                        if (CommonDataKt.isMe(cancelPrayMessage3.getUin())) {
                            SquareBaseKt.getSquareLog().d(TAG, "onReceiveFocusMessage: me cancel focus");
                            ChatLandPushComponent$onReceiveFocusMessage$3$3 chatLandPushComponent$onReceiveFocusMessage$3$3 = new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandPushComponent$onReceiveFocusMessage$3$3
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(ITemplateMapEvent iTemplateMapEvent) {
                                    invoke2(iTemplateMapEvent);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(ITemplateMapEvent component) {
                                    Intrinsics.checkNotNullParameter(component, "component");
                                    component.onMeFocusEnd();
                                }
                            };
                            VasBaseFragment vasBaseFragment6 = ((VasBaseFragmentComponent) this).fragment;
                            if (vasBaseFragment6 != null) {
                                WeakReference<VasBaseFragmentComponentGroup> parent4 = getParent();
                                vasBaseFragment6.forEachComponent(ITemplateMapEvent.class, parent4 != null ? parent4.get() : null, null, chatLandPushComponent$onReceiveFocusMessage$3$3);
                            }
                        }
                    }
                }
            } else {
                SquareBaseKt.getSquareLog().d(TAG, "onReceiveFocusMessage: updater is null");
                return;
            }
        }
    }
}

package com.tencent.state.square.chatland.component;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.map.BaseMapView;
import com.tencent.state.map.MapFragment;
import com.tencent.state.map.MapViewModel;
import com.tencent.state.publicchat.component.PublicChatCommonComponent;
import com.tencent.state.publicchat.component.PublicChatExtraActionMenuComponent;
import com.tencent.state.publicchat.component.PublicChatMsgComponent;
import com.tencent.state.publicchat.component.PublicChatUIComponent;
import com.tencent.state.square.chatland.ChatLandOwner;
import com.tencent.state.square.chatland.component.share.ChatLandShareEventCopyComponent;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\b\b\u0001\u0010\u0004*\u00020\u00052\u00020\u0006B7\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\u0006\u0010\u0019\u001a\u00020\u001aR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/square/chatland/component/ChatLandComponent;", "V", "Lcom/tencent/state/map/BaseMapView;", "Lcom/tencent/state/map/MapView;", "VM", "Lcom/tencent/state/map/MapViewModel;", "Lcom/tencent/state/VasBaseFragmentComponentGroup;", "fragment", "Lcom/tencent/state/map/MapFragment;", "appId", "", "roomId", "", WadlProxyConsts.KEY_JUMP_URL, "", "(Lcom/tencent/state/map/MapFragment;ILjava/lang/Long;Ljava/lang/String;)V", "getAppId", "()I", "chatLandOwner", "Lcom/tencent/state/square/chatland/ChatLandOwner;", "getJumpUrl", "()Ljava/lang/String;", "getRoomId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "initialize", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandComponent<V extends BaseMapView<?>, VM extends MapViewModel> extends VasBaseFragmentComponentGroup {
    private final int appId;
    private final ChatLandOwner<V, VM> chatLandOwner;
    private final String jumpUrl;
    private final Long roomId;

    public /* synthetic */ ChatLandComponent(MapFragment mapFragment, int i3, Long l3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(mapFragment, i3, (i16 & 4) != 0 ? null : l3, (i16 & 8) != 0 ? "" : str);
    }

    public final int getAppId() {
        return this.appId;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final Long getRoomId() {
        return this.roomId;
    }

    public final void initialize() {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        FragmentComponent fragmentComponent = null;
        FragmentComponent component = getComponent(ChatLandRoomComponent.class, null);
        if (component == null && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component = vasBaseFragmentComponentGroup.getComponent(ChatLandRoomComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandRoomComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandRoomComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent = component$default;
            }
            component = fragmentComponent;
        }
        ChatLandRoomComponent chatLandRoomComponent = (ChatLandRoomComponent) component;
        if (chatLandRoomComponent != null) {
            chatLandRoomComponent.initialize();
        }
    }

    public ChatLandComponent(MapFragment<V, VM> fragment, int i3, Long l3, String jumpUrl) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        this.appId = i3;
        this.roomId = l3;
        this.jumpUrl = jumpUrl;
        ChatLandOwner<V, VM> chatLandOwner = new ChatLandOwner<>(fragment, i3);
        this.chatLandOwner = chatLandOwner;
        addComponent(new ChatLandUiComponent(chatLandOwner, i3));
        addComponent(new ChatLandRoomComponent(chatLandOwner, i3, l3));
        addComponent(new ChatLandSeatComponent(i3, jumpUrl));
        addComponent(new ChatLandPushComponent(i3));
        addComponent(new ChatLandSquareComponent(chatLandOwner, i3));
        addComponent(new ChatLandPublicChatComponent(i3));
        addComponent(new ChatLandInteractionMotionComponent(i3));
        addComponent(new PublicChatCommonComponent(chatLandOwner, i3));
        addComponent(new PublicChatMsgComponent(chatLandOwner));
        addComponent(new PublicChatUIComponent(chatLandOwner));
        addComponent(new ChatLandPKComponent(chatLandOwner, i3));
        addComponent(new ChatLandShareEventCopyComponent());
        addComponent(new PublicChatExtraActionMenuComponent());
    }
}

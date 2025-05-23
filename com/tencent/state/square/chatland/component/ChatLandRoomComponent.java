package com.tencent.state.square.chatland.component;

import android.util.Size;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.publicchat.data.PublicChatConfInfo;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.chatland.component.IChatLandEventListener;
import com.tencent.state.square.chatland.viewmodel.ChatLandMapViewModel;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.map.TemplateMapViewModel;
import com.tencent.state.template.map.component.TemplateRoomComponent;
import com.tencent.state.template.service.ITemplateRoomService;
import com.tencent.state.template.service.VasSquareRoomService;
import com.tencent.state.utils.VMUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u0006\u0010\u0016\u001a\u00020\u000eJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0006J\u001a\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010 \u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\f\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/square/chatland/component/ChatLandRoomComponent;", "Lcom/tencent/state/template/map/component/TemplateRoomComponent;", "Lcom/tencent/state/square/chatland/component/IChatLandEventListener;", "owner", "Lcom/tencent/state/square/chatland/component/IChatLandUIOwner;", "appId", "", "roomId", "", "(Lcom/tencent/state/square/chatland/component/IChatLandUIOwner;ILjava/lang/Long;)V", "getAppId", "()I", "Ljava/lang/Long;", "dispatchLeaveEvent", "", "ensureLibraryTop", "getRoomFullTips", "", "getViewModel", "Lcom/tencent/state/template/map/TemplateMapViewModel;", "f", "Landroidx/fragment/app/Fragment;", "initialize", "needAbortStudyMood", "", "result", "Lcom/tencent/state/template/data/EnterRoomInfo;", "notifyRoomUserRefresh", "motionId", "onBackPressed", "fm", "Landroidx/fragment/app/FragmentManager;", "onChatLandLeaveRoom", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandRoomComponent extends TemplateRoomComponent implements IChatLandEventListener {
    private static final String TAG = "ChatLandRoomComponent";
    private final int appId;
    private final IChatLandUIOwner owner;
    private final Long roomId;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/util/Size;", "invoke"}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.tencent.state.square.chatland.component.ChatLandRoomComponent$1, reason: invalid class name */
    /* loaded from: classes38.dex */
    static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Size> {
        AnonymousClass1(IChatLandUIOwner iChatLandUIOwner) {
            super(0, iChatLandUIOwner, IChatLandUIOwner.class, "onGetMapSize", "onGetMapSize()Landroid/util/Size;", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Size invoke() {
            return ((IChatLandUIOwner) this.receiver).onGetMapSize();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandRoomComponent(IChatLandUIOwner owner, int i3, Long l3) {
        super(new VasSquareRoomService(i3, ChatLandRoomComponentKt.getChatLandRoomConfParser(), new AnonymousClass1(owner)));
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.owner = owner;
        this.appId = i3;
        this.roomId = l3;
    }

    @Override // com.tencent.state.template.fragment.TemplateBaseComponent
    public int getAppId() {
        return this.appId;
    }

    @Override // com.tencent.state.template.map.component.TemplateRoomComponent
    public String getRoomFullTips() {
        return "\u623f\u95f4\u7206\u6ee1\u5566\uff0c\u4e3a\u4f60\u9009\u4e86\u4e2a\u65b0\u623f\u95f4";
    }

    @Override // com.tencent.state.template.map.component.TemplateRoomComponent
    protected TemplateMapViewModel getViewModel(Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        return (TemplateMapViewModel) VMUtils.INSTANCE.safelyGet(f16, ChatLandMapViewModel.class, String.valueOf(getAppId()));
    }

    public final void initialize() {
        enterRoom(this.roomId, true);
    }

    @Override // com.tencent.state.template.map.component.TemplateRoomComponent
    public boolean needAbortStudyMood(EnterRoomInfo result) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Intrinsics.checkNotNullParameter(result, "result");
        if (!SquareBaseKt.getSquareCommon().getStudyMode()) {
            return false;
        }
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
            chatLandUiComponent.bindBackground(result.getRoom());
        }
        return true;
    }

    public final void notifyRoomUserRefresh(int motionId) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
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
        if (chatLandSeatComponent == null || !chatLandSeatComponent.isMeSeated()) {
            return;
        }
        getService().refreshUserInfo(motionId, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandRoomComponent$notifyRoomUserRefresh$1
            public final void invoke(boolean z16) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.state.template.map.component.TemplateRoomComponent, com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public boolean onBackPressed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        return false;
    }

    @Override // com.tencent.state.square.chatland.component.IChatLandEventListener
    public void onChatLandLeaveRoom() {
        ITemplateRoomService.DefaultImpls.leaveRoom$default(getService(), null, 1, null);
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

    @Override // com.tencent.state.template.map.component.TemplateRoomComponent
    protected void dispatchLeaveEvent() {
    }

    @Override // com.tencent.state.template.map.component.TemplateRoomComponent
    public void ensureLibraryTop() {
    }
}

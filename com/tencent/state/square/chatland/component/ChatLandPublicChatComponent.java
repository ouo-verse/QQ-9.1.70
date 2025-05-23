package com.tencent.state.square.chatland.component;

import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.publicchat.component.IPublicChatOwnerEventListener;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.VasSquareFocusService;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.chatland.view.ChatLandDialogTips;
import com.tencent.state.template.data.CommonDataKt;
import com.tencent.state.template.data.CommonDataParserKt;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.RoomConfig;
import com.tencent.state.template.data.User;
import com.tencent.state.template.data.UserStatus;
import com.tencent.state.view.SquareLoadingDialog;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import fs4.n;
import fs4.r;
import ft4.k;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\"\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/square/chatland/component/ChatLandPublicChatComponent;", "Lcom/tencent/state/square/chatland/component/ChatLandMapBaseComponent;", "", "uin", "", "doViewTaFocusOtherRoom", "Lfs4/n;", "room", "", "msgOffset", "handleViewTaFocusOtherRoomSuccess", "", "error", "", "prompt", "handleCommonError", "", "checkUinIsFocus", "Lcom/tencent/state/template/data/User;", QCircleAlphaUserReporter.KEY_USER, "onMeFocusStart", "onMeFocusEnd", "viewTaFocus", "Lcom/tencent/state/view/SquareLoadingDialog;", "loading$delegate", "Lkotlin/Lazy;", "getLoading", "()Lcom/tencent/state/view/SquareLoadingDialog;", ToastView.ICON_LOADING, "appId", "<init>", "(I)V", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandPublicChatComponent extends ChatLandMapBaseComponent {
    private static final String TAG = "ChatLandPublicChatComponent";

    /* renamed from: loading$delegate, reason: from kotlin metadata */
    private final Lazy loading;

    public ChatLandPublicChatComponent(int i3) {
        super(i3);
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SquareLoadingDialog>() { // from class: com.tencent.state.square.chatland.component.ChatLandPublicChatComponent$loading$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SquareLoadingDialog invoke() {
                QBaseActivity activity;
                activity = ChatLandPublicChatComponent.this.getActivity();
                if (activity != null) {
                    return new SquareLoadingDialog(activity, false);
                }
                return null;
            }
        });
        this.loading = lazy;
    }

    private final boolean checkUinIsFocus(long uin) {
        User user;
        ChatLandAvatarItem findAvatarItemByUin = findAvatarItemByUin(String.valueOf(uin));
        return ((findAvatarItemByUin == null || (user = findAvatarItemByUin.getUser()) == null) ? null : user.getStatus()) == UserStatus.SIT_DOWN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doViewTaFocusOtherRoom(final long uin) {
        SquareBaseKt.getSquareLog().d(TAG, "\u6267\u884c\u8de8\u623f\u95f4\u67e5\u770b\u7528\u6237\u4e13\u6ce8");
        SquareLoadingDialog loading = getLoading();
        if (loading != null) {
            loading.showSafely();
        }
        VasSquareFocusService.INSTANCE.watchUserRoom(getAppId(), uin, new ResultCallback<k>() { // from class: com.tencent.state.square.chatland.component.ChatLandPublicChatComponent$doViewTaFocusOtherRoom$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message, String prompt) {
                ResultCallback.DefaultImpls.onResultFailure(this, error, message, prompt);
                ChatLandPublicChatComponent.this.handleCommonError(error, prompt, uin);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(k result) {
                SquareLoadingDialog loading2;
                Intrinsics.checkNotNullParameter(result, "result");
                n room = n.c(result.f400623a);
                byte[] bArr = result.f400624b;
                if (bArr == null) {
                    bArr = new byte[0];
                }
                ChatLandPublicChatComponent chatLandPublicChatComponent = ChatLandPublicChatComponent.this;
                long j3 = uin;
                Intrinsics.checkNotNullExpressionValue(room, "room");
                chatLandPublicChatComponent.handleViewTaFocusOtherRoomSuccess(j3, room, bArr);
                loading2 = ChatLandPublicChatComponent.this.getLoading();
                if (loading2 != null) {
                    loading2.dismiss();
                }
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                SquareLoadingDialog loading2;
                loading2 = ChatLandPublicChatComponent.this.getLoading();
                if (loading2 != null) {
                    loading2.dismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SquareLoadingDialog getLoading() {
        return (SquareLoadingDialog) this.loading.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleCommonError(int error, String prompt, long uin) {
        Context context;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (context = fragment.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: return");
        SquareBaseKt.getSquareCommon().showToastSafely(context, prompt, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleViewTaFocusOtherRoomSuccess(final long uin, n room, byte[] msgOffset) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        WeakReference<VasBaseFragmentComponentGroup> parent2;
        VasBaseFragment vasBaseFragment2;
        FragmentComponent component$default2;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2;
        if (room.f400542a != 0) {
            boolean z16 = this instanceof VasBaseFragmentComponentGroup;
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
            if ((vasBaseFragmentComponentGroup3 == null || (component$default = vasBaseFragmentComponentGroup3.getComponent(ChatLandRoomComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(ChatLandRoomComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandRoomComponent.class, null, null, 2, null)) == null))) {
                VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) this).parentFragment;
                component$default = vasBaseFragment3 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, ChatLandRoomComponent.class, null, null, 6, null) : null;
            }
            ChatLandRoomComponent chatLandRoomComponent = (ChatLandRoomComponent) component$default;
            if (chatLandRoomComponent != null) {
                Function1<r[], RoomConfig> chatLandRoomConfParser = ChatLandRoomComponentKt.getChatLandRoomConfParser();
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!z16 ? null : this);
                if ((vasBaseFragmentComponentGroup4 == null || (component$default2 = vasBaseFragmentComponentGroup4.getComponent(ChatLandSquareComponent.class, null)) == null) && (((parent2 = getParent()) == null || (vasBaseFragmentComponentGroup2 = parent2.get()) == null || (component$default2 = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, null)) == null) && ((vasBaseFragment2 = ((VasBaseFragmentComponent) this).fragment) == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 2, null)) == null))) {
                    VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) this).parentFragment;
                    component$default2 = vasBaseFragment4 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, ChatLandSquareComponent.class, null, null, 6, null) : null;
                }
                ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) component$default2;
                EnterRoomInfo enterRoomInfo = new EnterRoomInfo(msgOffset, CommonDataParserKt.parse(room, chatLandRoomConfParser, chatLandSquareComponent != null ? chatLandSquareComponent.getMapSize() : null), false);
                enterRoomInfo.setReenter(true);
                Unit unit = Unit.INSTANCE;
                chatLandRoomComponent.handleRoomSwitched(enterRoomInfo);
            }
            SquareBaseKt.getSquareThread().postOnUiDelayed(1000L, new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandPublicChatComponent$handleViewTaFocusOtherRoomSuccess$2
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
                    WeakReference<VasBaseFragmentComponentGroup> parent3;
                    FragmentComponent fragmentComponent;
                    FragmentComponent component$default3;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup5;
                    ChatLandPublicChatComponent chatLandPublicChatComponent = ChatLandPublicChatComponent.this;
                    FragmentComponent fragmentComponent2 = null;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup6 = (VasBaseFragmentComponentGroup) (!(chatLandPublicChatComponent instanceof VasBaseFragmentComponentGroup) ? null : chatLandPublicChatComponent);
                    if ((vasBaseFragmentComponentGroup6 == null || (fragmentComponent = vasBaseFragmentComponentGroup6.getComponent(ChatLandSquareComponent.class, null)) == null) && ((parent3 = chatLandPublicChatComponent.getParent()) == null || (vasBaseFragmentComponentGroup5 = parent3.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup5.getComponent(ChatLandSquareComponent.class, null)) == null)) {
                        VasBaseFragment vasBaseFragment5 = ((VasBaseFragmentComponent) chatLandPublicChatComponent).fragment;
                        if (vasBaseFragment5 == null || (component$default3 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment5, ChatLandSquareComponent.class, null, null, 2, null)) == null) {
                            VasBaseFragment vasBaseFragment6 = ((VasBaseFragmentComponent) chatLandPublicChatComponent).parentFragment;
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
                        chatLandSquareComponent2.locateToUin(String.valueOf(uin));
                    }
                }
            });
            return;
        }
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandPublicChatComponent$handleViewTaFocusOtherRoomSuccess$3
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
                WeakReference<VasBaseFragmentComponentGroup> parent3;
                FragmentComponent fragmentComponent;
                FragmentComponent component$default3;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup5;
                ChatLandPublicChatComponent chatLandPublicChatComponent = ChatLandPublicChatComponent.this;
                FragmentComponent fragmentComponent2 = null;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup6 = (VasBaseFragmentComponentGroup) (!(chatLandPublicChatComponent instanceof VasBaseFragmentComponentGroup) ? null : chatLandPublicChatComponent);
                if ((vasBaseFragmentComponentGroup6 == null || (fragmentComponent = vasBaseFragmentComponentGroup6.getComponent(ChatLandSquareComponent.class, null)) == null) && ((parent3 = chatLandPublicChatComponent.getParent()) == null || (vasBaseFragmentComponentGroup5 = parent3.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup5.getComponent(ChatLandSquareComponent.class, null)) == null)) {
                    VasBaseFragment vasBaseFragment5 = ((VasBaseFragmentComponent) chatLandPublicChatComponent).fragment;
                    if (vasBaseFragment5 == null || (component$default3 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment5, ChatLandSquareComponent.class, null, null, 2, null)) == null) {
                        VasBaseFragment vasBaseFragment6 = ((VasBaseFragmentComponent) chatLandPublicChatComponent).parentFragment;
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
                    chatLandSquareComponent2.locateToUin(String.valueOf(uin));
                }
            }
        });
    }

    @Override // com.tencent.state.square.chatland.component.ChatLandMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onMeFocusEnd() {
        ChatLandPublicChatComponent$onMeFocusEnd$1 chatLandPublicChatComponent$onMeFocusEnd$1 = new Function1<IPublicChatOwnerEventListener, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandPublicChatComponent$onMeFocusEnd$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IPublicChatOwnerEventListener iPublicChatOwnerEventListener) {
                invoke2(iPublicChatOwnerEventListener);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IPublicChatOwnerEventListener it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onSceneExit();
            }
        };
        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
        if (vasBaseFragment != null) {
            WeakReference<VasBaseFragmentComponentGroup> parent = getParent();
            vasBaseFragment.forEachComponent(IPublicChatOwnerEventListener.class, parent != null ? parent.get() : null, null, chatLandPublicChatComponent$onMeFocusEnd$1);
        }
    }

    @Override // com.tencent.state.square.chatland.component.ChatLandMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onMeFocusStart(User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        ChatLandPublicChatComponent$onMeFocusStart$1 chatLandPublicChatComponent$onMeFocusStart$1 = new Function1<IPublicChatOwnerEventListener, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandPublicChatComponent$onMeFocusStart$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IPublicChatOwnerEventListener iPublicChatOwnerEventListener) {
                invoke2(iPublicChatOwnerEventListener);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IPublicChatOwnerEventListener it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onSceneReady(true);
            }
        };
        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
        if (vasBaseFragment != null) {
            WeakReference<VasBaseFragmentComponentGroup> parent = getParent();
            vasBaseFragment.forEachComponent(IPublicChatOwnerEventListener.class, parent != null ? parent.get() : null, null, chatLandPublicChatComponent$onMeFocusStart$1);
        }
    }

    public final void viewTaFocus(final long uin) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        boolean isMeSeated = isMeSeated();
        if (!CommonDataKt.isMe(uin) || isMeSeated) {
            boolean checkUinIsFocus = checkUinIsFocus(uin);
            SquareBaseKt.getSquareLog().d(TAG, "\u6253\u5f00\u7528\u6237\u4e13\u6ce8\u8be6\u60c5\u9875 sameRoom: " + checkUinIsFocus);
            FragmentComponent component$default2 = null;
            if (!checkUinIsFocus) {
                if (!isMeSeated) {
                    doViewTaFocusOtherRoom(uin);
                    return;
                }
                ChatLandDialogTips chatLandDialogTips = ChatLandDialogTips.INSTANCE;
                VasBaseFragment fragment = getFragment();
                chatLandDialogTips.showTAHaveLeaveTip(fragment != null ? fragment.getContext() : null, getAppId(), new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandPublicChatComponent$viewTaFocus$1
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
                        SquareBaseKt.getSquareLog().d("ChatLandPublicChatComponent", "\u6362\u623f\u9000\u51fa\u4e13\u6ce8\u63d0\u793a\uff0c\u786e\u8ba4: " + z16);
                        if (z16) {
                            ChatLandPublicChatComponent.this.doViewTaFocusOtherRoom(uin);
                        }
                    }
                });
                return;
            }
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandSquareComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandSquareComponent.class, null)) == null)) {
                VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSquareComponent.class, null, null, 2, null)) == null) {
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                    if (vasBaseFragment2 != null) {
                        component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, ChatLandSquareComponent.class, null, null, 6, null);
                    }
                } else {
                    component$default2 = component$default;
                }
                fragmentComponent = component$default2;
            }
            ChatLandSquareComponent chatLandSquareComponent = (ChatLandSquareComponent) fragmentComponent;
            if (chatLandSquareComponent != null) {
                chatLandSquareComponent.locateToUin(String.valueOf(uin));
            }
            SquareLoadingDialog loading = getLoading();
            if (loading != null) {
                loading.dismiss();
            }
        }
    }
}

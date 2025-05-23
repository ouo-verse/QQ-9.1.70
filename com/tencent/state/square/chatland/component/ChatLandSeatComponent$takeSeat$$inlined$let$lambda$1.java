package com.tencent.state.square.chatland.component;

import android.content.Context;
import android.graphics.Point;
import androidx.lifecycle.LiveData;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.publicchat.component.PublicChatUIComponent;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.bubblesetting.SquareBubbleInfo;
import com.tencent.state.square.chatland.viewmodel.ChatLandMapViewModel;
import com.tencent.state.square.components.SquareGroupFloatingComponent;
import com.tencent.state.template.data.CommonRoomInfo;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.SitDownTagParams;
import com.tencent.state.template.data.User;
import com.tencent.state.template.dialog.SceneCommonDialogs;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002\u00a8\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "com/tencent/state/square/chatland/component/ChatLandSeatComponent$takeSeat$1$sitDownActions$1"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandSeatComponent$takeSeat$$inlined$let$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $it;
    final /* synthetic */ Function2 $onFocusFailed$inlined;
    final /* synthetic */ Function1 $onFocusSuccess$inlined;
    final /* synthetic */ Point $sitLocation$inlined;
    final /* synthetic */ long $tableId$inlined;
    final /* synthetic */ ChatLandSeatComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandSeatComponent$takeSeat$$inlined$let$lambda$1(Context context, ChatLandSeatComponent chatLandSeatComponent, long j3, Point point, Function1 function1, Function2 function2) {
        super(0);
        this.$it = context;
        this.this$0 = chatLandSeatComponent;
        this.$tableId$inlined = j3;
        this.$sitLocation$inlined = point;
        this.$onFocusSuccess$inlined = function1;
        this.$onFocusFailed$inlined = function2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SceneCommonDialogs sceneCommonDialogs = SceneCommonDialogs.INSTANCE;
        Context it = this.$it;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        sceneCommonDialogs.checkSceneConflictDialog(it, new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$takeSeat$$inlined$let$lambda$1.1
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
                WeakReference<VasBaseFragmentComponentGroup> parent;
                FragmentComponent fragmentComponent;
                FragmentComponent component$default;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                ChatLandMapViewModel chatLandMapViewModel;
                LiveData<EnterRoomInfo> enterRoomInfo;
                EnterRoomInfo value;
                CommonRoomInfo room;
                ChatLandSeatComponent chatLandSeatComponent = ChatLandSeatComponent$takeSeat$$inlined$let$lambda$1.this.this$0;
                FragmentComponent fragmentComponent2 = null;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(chatLandSeatComponent instanceof VasBaseFragmentComponentGroup) ? null : chatLandSeatComponent);
                if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(SquareGroupFloatingComponent.class, null)) == null) && ((parent = chatLandSeatComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(SquareGroupFloatingComponent.class, null)) == null)) {
                    VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) chatLandSeatComponent).fragment;
                    if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, SquareGroupFloatingComponent.class, null, null, 2, null)) == null) {
                        VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) chatLandSeatComponent).parentFragment;
                        if (vasBaseFragment2 != null) {
                            fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, SquareGroupFloatingComponent.class, null, null, 6, null);
                        }
                    } else {
                        fragmentComponent2 = component$default;
                    }
                    fragmentComponent = fragmentComponent2;
                }
                SquareGroupFloatingComponent squareGroupFloatingComponent = (SquareGroupFloatingComponent) fragmentComponent;
                if (squareGroupFloatingComponent != null) {
                    squareGroupFloatingComponent.stopCountDown("ChatLandSit");
                }
                chatLandMapViewModel = ChatLandSeatComponent$takeSeat$$inlined$let$lambda$1.this.this$0.vmChatLandMap;
                if (chatLandMapViewModel == null || (enterRoomInfo = chatLandMapViewModel.getEnterRoomInfo()) == null || (value = enterRoomInfo.getValue()) == null || (room = value.getRoom()) == null) {
                    return;
                }
                ChatLandSeatComponent chatLandSeatComponent2 = ChatLandSeatComponent$takeSeat$$inlined$let$lambda$1.this.this$0;
                long id5 = room.getId();
                ChatLandSeatComponent$takeSeat$$inlined$let$lambda$1 chatLandSeatComponent$takeSeat$$inlined$let$lambda$1 = ChatLandSeatComponent$takeSeat$$inlined$let$lambda$1.this;
                chatLandSeatComponent2.doFocus(new SitDownTagParams(id5, chatLandSeatComponent$takeSeat$$inlined$let$lambda$1.$tableId$inlined, null, null, false, chatLandSeatComponent$takeSeat$$inlined$let$lambda$1.$sitLocation$inlined), new Function1<User, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$takeSeat$.inlined.let.lambda.1.1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(User user) {
                        invoke2(user);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(User user) {
                        String skinLink;
                        WeakReference<VasBaseFragmentComponentGroup> parent2;
                        FragmentComponent fragmentComponent3;
                        FragmentComponent component$default2;
                        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup3;
                        Intrinsics.checkNotNullParameter(user, "user");
                        SquareBubbleInfo focusBroadcastSkin = user.getFocusBroadcastSkin();
                        if (focusBroadcastSkin != null && (skinLink = focusBroadcastSkin.getSkinLink()) != null) {
                            ChatLandSeatComponent chatLandSeatComponent3 = ChatLandSeatComponent$takeSeat$$inlined$let$lambda$1.this.this$0;
                            FragmentComponent fragmentComponent4 = null;
                            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup4 = (VasBaseFragmentComponentGroup) (!(chatLandSeatComponent3 instanceof VasBaseFragmentComponentGroup) ? null : chatLandSeatComponent3);
                            if ((vasBaseFragmentComponentGroup4 == null || (fragmentComponent3 = vasBaseFragmentComponentGroup4.getComponent(PublicChatUIComponent.class, null)) == null) && ((parent2 = chatLandSeatComponent3.getParent()) == null || (vasBaseFragmentComponentGroup3 = parent2.get()) == null || (fragmentComponent3 = vasBaseFragmentComponentGroup3.getComponent(PublicChatUIComponent.class, null)) == null)) {
                                VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) chatLandSeatComponent3).fragment;
                                if (vasBaseFragment3 == null || (component$default2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment3, PublicChatUIComponent.class, null, null, 2, null)) == null) {
                                    VasBaseFragment vasBaseFragment4 = ((VasBaseFragmentComponent) chatLandSeatComponent3).parentFragment;
                                    if (vasBaseFragment4 != null) {
                                        fragmentComponent4 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment4, PublicChatUIComponent.class, null, null, 6, null);
                                    }
                                } else {
                                    fragmentComponent4 = component$default2;
                                }
                                fragmentComponent3 = fragmentComponent4;
                            }
                            PublicChatUIComponent publicChatUIComponent = (PublicChatUIComponent) fragmentComponent3;
                            if (publicChatUIComponent != null) {
                                publicChatUIComponent.showBroadcastAnimation(skinLink, user.getInfo().getNick());
                            }
                        }
                        Function1 function1 = ChatLandSeatComponent$takeSeat$$inlined$let$lambda$1.this.$onFocusSuccess$inlined;
                        if (function1 != null) {
                        }
                    }
                }, new Function2<Integer, String, Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$takeSeat$.inlined.let.lambda.1.1.2
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                        invoke(num.intValue(), str);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
                    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke(int i3, String str) {
                        boolean z16;
                        VasBaseFragment fragment;
                        boolean isBlank;
                        Function2 function2 = ChatLandSeatComponent$takeSeat$$inlined$let$lambda$1.this.$onFocusFailed$inlined;
                        if (function2 != null) {
                            function2.invoke(Integer.valueOf(i3), str);
                            return;
                        }
                        if (str != null) {
                            isBlank = StringsKt__StringsJVMKt.isBlank(str);
                            if (!isBlank) {
                                z16 = false;
                                if (z16) {
                                    ICommonUtils squareCommon = SquareBaseKt.getSquareCommon();
                                    fragment = ChatLandSeatComponent$takeSeat$$inlined$let$lambda$1.this.this$0.getFragment();
                                    squareCommon.showToastSafely(fragment != null ? fragment.requireContext() : null, str, 0);
                                    return;
                                }
                                return;
                            }
                        }
                        z16 = true;
                        if (z16) {
                        }
                    }
                });
            }
        }, new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSeatComponent$takeSeat$1$sitDownActions$1$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ChatLandSeatComponent.isSwitchingSeat = false;
            }
        });
    }
}

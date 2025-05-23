package com.tencent.state.square.chatland.component;

import android.content.Context;
import com.tencent.state.FragmentComponent;
import com.tencent.state.SquareRuntime;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.chatland.view.ChatLandRepeatListController;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/state/square/chatland/view/ChatLandRepeatListController;", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandSquareComponent$chatLandRepeatListController$2 extends Lambda implements Function0<ChatLandRepeatListController> {
    final /* synthetic */ ChatLandSquareComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "data", "Lcom/tencent/state/square/chatland/data/ChatLandAvatarItem;", "invoke"}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.tencent.state.square.chatland.component.ChatLandSquareComponent$chatLandRepeatListController$2$2, reason: invalid class name */
    /* loaded from: classes38.dex */
    public static final class AnonymousClass2 extends Lambda implements Function1<ChatLandAvatarItem, Unit> {
        AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChatLandAvatarItem chatLandAvatarItem) {
            invoke2(chatLandAvatarItem);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final ChatLandAvatarItem data) {
            VasBaseFragment fragment;
            Context context;
            Intrinsics.checkNotNullParameter(data, "data");
            if (!data.getUser().isReceiver() && (!data.isMe() || data.getUser().isSend())) {
                ChatLandSquareComponent$chatLandRepeatListController$2.this.this$0.panelShow(data);
                return;
            }
            if (SquareRuntime.INSTANCE.hasNearbyMark()) {
                fragment = ChatLandSquareComponent$chatLandRepeatListController$2.this.this$0.getFragment();
                if (fragment == null || (context = fragment.getContext()) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(context, "fragment?.context ?: ret\u2026tLandRepeatListController");
                Square.INSTANCE.getConfig().getRouter().routeToNearbyDetailPage(context, data.getUin());
                return;
            }
            ChatLandSquareComponent$chatLandRepeatListController$2.this.this$0.scaleToDetailAmin(data.getUin(), new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent.chatLandRepeatListController.2.2.1
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
                    SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent.chatLandRepeatListController.2.2.1.1
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
                            ChatLandSquareComponent chatLandSquareComponent = ChatLandSquareComponent$chatLandRepeatListController$2.this.this$0;
                            FragmentComponent fragmentComponent2 = null;
                            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(chatLandSquareComponent instanceof VasBaseFragmentComponentGroup) ? null : chatLandSquareComponent);
                            if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(ChatLandSeatComponent.class, null)) == null) && ((parent = chatLandSquareComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(ChatLandSeatComponent.class, null)) == null)) {
                                VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) chatLandSquareComponent).fragment;
                                if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, ChatLandSeatComponent.class, null, null, 2, null)) == null) {
                                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) chatLandSquareComponent).parentFragment;
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
                                chatLandSeatComponent.gotoDetail(data);
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatLandSquareComponent$chatLandRepeatListController$2(ChatLandSquareComponent chatLandSquareComponent) {
        super(0);
        this.this$0 = chatLandSquareComponent;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ChatLandRepeatListController invoke() {
        return new ChatLandRepeatListController(new Function0<SquareView>() { // from class: com.tencent.state.square.chatland.component.ChatLandSquareComponent$chatLandRepeatListController$2.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SquareView invoke() {
                SquareView mapView;
                mapView = ChatLandSquareComponent$chatLandRepeatListController$2.this.this$0.getMapView();
                return mapView;
            }
        }, new AnonymousClass2());
    }
}

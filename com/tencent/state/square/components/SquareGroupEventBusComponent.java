package com.tencent.state.square.components;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.event.AddSquareAsyncLocateTo;
import com.tencent.state.event.ChatAddUinToSquare;
import com.tencent.state.event.ChatCheckUinInSquare;
import com.tencent.state.event.EnterLibraryEvent;
import com.tencent.state.event.LeaveLibraryEvent;
import com.tencent.state.square.components.fragment.ChatAddUinComponent;
import com.tencent.state.square.components.fragment.SquareBaseComponent;
import com.tencent.state.square.detail.MainScene;
import com.tencent.state.utils.EventBusUtilsKt;
import com.tencent.state.utils.IEventHandler;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0011H\u0002J$\u0010\u0012\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00070\u0013j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007`\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0016H\u0002J\u001a\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J,\u0010\u001c\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\"H\u0002J\u0012\u0010#\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016R:\u0010\u0005\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/tencent/state/square/components/SquareGroupEventBusComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "eventMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lcom/tencent/state/utils/IEventHandler;", "Lkotlin/collections/HashMap;", "doAddSquareAsyncLocateTo", "", "event", "Lcom/tencent/state/event/AddSquareAsyncLocateTo;", "doAddUinListToSquare", "Lcom/tencent/state/event/ChatAddUinToSquare;", "doCheckUinInSquare", "Lcom/tencent/state/event/ChatCheckUinInSquare;", "getEventClass", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onEnterLibrary", "Lcom/tencent/state/event/EnterLibraryEvent;", "onFragmentDestroyed", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "onFragmentViewCreated", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onLeaveLibrary", "Lcom/tencent/state/event/LeaveLibraryEvent;", "onReceiveEvent", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareGroupEventBusComponent extends SquareBaseComponent implements SimpleEventReceiver<SimpleBaseEvent> {
    private final HashMap<Class<? extends SimpleBaseEvent>, IEventHandler> eventMap;

    public SquareGroupEventBusComponent() {
        HashMap<Class<? extends SimpleBaseEvent>, IEventHandler> hashMap = new HashMap<>();
        EventBusUtilsKt.register(hashMap, EnterLibraryEvent.class, new Function1<EnterLibraryEvent, Unit>() { // from class: com.tencent.state.square.components.SquareGroupEventBusComponent$$special$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(EnterLibraryEvent enterLibraryEvent) {
                invoke2(enterLibraryEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(EnterLibraryEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareGroupEventBusComponent.this.onEnterLibrary(it);
            }
        });
        EventBusUtilsKt.register(hashMap, LeaveLibraryEvent.class, new Function1<LeaveLibraryEvent, Unit>() { // from class: com.tencent.state.square.components.SquareGroupEventBusComponent$$special$$inlined$apply$lambda$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LeaveLibraryEvent leaveLibraryEvent) {
                invoke2(leaveLibraryEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LeaveLibraryEvent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareGroupEventBusComponent.this.onLeaveLibrary(it);
            }
        });
        EventBusUtilsKt.register(hashMap, ChatAddUinToSquare.class, new Function1<ChatAddUinToSquare, Unit>() { // from class: com.tencent.state.square.components.SquareGroupEventBusComponent$$special$$inlined$apply$lambda$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChatAddUinToSquare chatAddUinToSquare) {
                invoke2(chatAddUinToSquare);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ChatAddUinToSquare it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareGroupEventBusComponent.this.doAddUinListToSquare(it);
            }
        });
        EventBusUtilsKt.register(hashMap, ChatCheckUinInSquare.class, new Function1<ChatCheckUinInSquare, Unit>() { // from class: com.tencent.state.square.components.SquareGroupEventBusComponent$$special$$inlined$apply$lambda$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChatCheckUinInSquare chatCheckUinInSquare) {
                invoke2(chatCheckUinInSquare);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ChatCheckUinInSquare it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareGroupEventBusComponent.this.doCheckUinInSquare(it);
            }
        });
        EventBusUtilsKt.register(hashMap, AddSquareAsyncLocateTo.class, new Function1<AddSquareAsyncLocateTo, Unit>() { // from class: com.tencent.state.square.components.SquareGroupEventBusComponent$$special$$inlined$apply$lambda$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AddSquareAsyncLocateTo addSquareAsyncLocateTo) {
                invoke2(addSquareAsyncLocateTo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AddSquareAsyncLocateTo it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SquareGroupEventBusComponent.this.doAddSquareAsyncLocateTo(it);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.eventMap = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doAddSquareAsyncLocateTo(AddSquareAsyncLocateTo event) {
        ChatAddUinComponent chatAddUinComponent;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (chatAddUinComponent = (ChatAddUinComponent) VasBaseLifecycleFragment.getComponent$default(fragment, ChatAddUinComponent.class, null, null, 6, null)) == null) {
            return;
        }
        chatAddUinComponent.addSquareAsyncLocateTo(event.getUin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doAddUinListToSquare(ChatAddUinToSquare event) {
        ChatAddUinComponent chatAddUinComponent;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (chatAddUinComponent = (ChatAddUinComponent) VasBaseLifecycleFragment.getComponent$default(fragment, ChatAddUinComponent.class, null, null, 6, null)) == null) {
            return;
        }
        chatAddUinComponent.add(event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doCheckUinInSquare(ChatCheckUinInSquare event) {
        ChatAddUinComponent chatAddUinComponent;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || (chatAddUinComponent = (ChatAddUinComponent) VasBaseLifecycleFragment.getComponent$default(fragment, ChatAddUinComponent.class, null, null, 6, null)) == null) {
            return;
        }
        chatAddUinComponent.checkInSquare(event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLeaveLibrary(LeaveLibraryEvent event) {
        ChatAddUinComponent chatAddUinComponent;
        SquareGroupFloatingComponent squareGroupFloatingComponent;
        VasBaseFragment fragment = getFragment();
        if (fragment != null && (squareGroupFloatingComponent = (SquareGroupFloatingComponent) fragment.getComponent(SquareGroupFloatingComponent.class, null, null)) != null) {
            squareGroupFloatingComponent.onBackFromLibraryOrTemple(event.getIntent());
        }
        VasBaseFragment fragment2 = getFragment();
        if (fragment2 == null || (chatAddUinComponent = (ChatAddUinComponent) fragment2.getComponent(ChatAddUinComponent.class, null, null)) == null) {
            return;
        }
        chatAddUinComponent.addUinOrLocateTo(MainScene.LIBRARY);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.addAll(this.eventMap.keySet());
        return arrayList;
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        IEventHandler iEventHandler;
        if (event == null || (iEventHandler = this.eventMap.get(event.getClass())) == null) {
            return;
        }
        iEventHandler.handleEvent(event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onEnterLibrary(EnterLibraryEvent event) {
    }
}

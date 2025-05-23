package com.tencent.state.square.components.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.event.ChatAddUinToSquare;
import com.tencent.state.event.ChatCheckUinInSquare;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.MoveItem;
import com.tencent.state.square.MoveResult;
import com.tencent.state.square.MoveType;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.components.SquareGroupUiComponent;
import com.tencent.state.square.detail.DetailSelectGuestFragment;
import com.tencent.state.square.detail.MainScene;
import com.tencent.state.square.resource.ISquareViewManagerProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0014\u0010\u0017\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/state/square/components/fragment/ChatAddUinComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "add", "", "event", "Lcom/tencent/state/event/ChatAddUinToSquare;", "addSquareAsyncLocateTo", "uin", "", "addUinOrLocateTo", "mainScene", "Lcom/tencent/state/square/detail/MainScene;", "checkInSquare", "Lcom/tencent/state/event/ChatCheckUinInSquare;", "doCheckInSquare", "", "getUiComponent", "Lcom/tencent/state/square/components/SquareGroupUiComponent;", "locateTo", "onBackFromDetail", "bundle", "Landroid/os/Bundle;", "pendingAdd", "list", "", "Lcom/tencent/state/square/MoveItem;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatAddUinComponent extends SquareBaseComponent {
    private static final int ADD_ROLE_FROM = 7;
    private static final String TAG = "SquareAddUinComponent";

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean doCheckInSquare(String uin) {
        ISquareViewManagerProxy squareViewManagerProxy;
        ISquareViewUpdater squareViewUpdater;
        SquareGroupUiComponent uiComponent = getUiComponent();
        return (uiComponent == null || (squareViewManagerProxy = uiComponent.getSquareViewManagerProxy()) == null || (squareViewUpdater = squareViewManagerProxy.getSquareViewUpdater()) == null || squareViewUpdater.isNotInSquareUinItemType(uin, 1)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SquareGroupUiComponent getUiComponent() {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(SquareGroupUiComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(SquareGroupUiComponent.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, SquareGroupUiComponent.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, SquareGroupUiComponent.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        return (SquareGroupUiComponent) fragmentComponent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void locateTo() {
        SquareGroupUiComponent uiComponent = getUiComponent();
        if (uiComponent != null) {
            uiComponent.locateTo(ChatAddUinComponentKt.getLastAddNeedLocalTo(), new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.components.fragment.ChatAddUinComponent$locateTo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
                
                    r2 = r1.this$0.getUiComponent();
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke(boolean z16) {
                    SquareGroupUiComponent uiComponent2;
                    if (z16 && uiComponent2 != null) {
                        uiComponent2.playRing(ChatAddUinComponentKt.getLastAddNeedLocalTo());
                    }
                    ChatAddUinComponentKt.setLastAddNeedLocalTo("");
                }
            });
        } else {
            ChatAddUinComponentKt.setLastAddNeedLocalTo("");
        }
    }

    public final void addSquareAsyncLocateTo(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        ChatAddUinComponentKt.setLastAddNeedLocalTo(uin);
    }

    public final void addUinOrLocateTo(final MainScene mainScene) {
        Intrinsics.checkNotNullParameter(mainScene, "mainScene");
        SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.ChatAddUinComponent$addUinOrLocateTo$1
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
                List mutableList;
                SquareGroupUiComponent uiComponent;
                boolean doCheckInSquare;
                List<MoveItem> addToSquareList = ChatAddUinComponentKt.getAddToSquareList();
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = addToSquareList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    doCheckInSquare = ChatAddUinComponent.this.doCheckInSquare(((MoveItem) next).getUin());
                    if (true ^ doCheckInSquare) {
                        arrayList.add(next);
                    }
                }
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
                if (mutableList.size() > 0) {
                    uiComponent = ChatAddUinComponent.this.getUiComponent();
                    if (uiComponent != null) {
                        uiComponent.addMultiRoles(mutableList, 7, mainScene, (r18 & 8) != 0 ? null : null, false, true, (r18 & 64) != 0 ? null : new Function1<Map<MoveItem, ? extends MoveResult>, Unit>() { // from class: com.tencent.state.square.components.fragment.ChatAddUinComponent$addUinOrLocateTo$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Map<MoveItem, ? extends MoveResult> map) {
                                invoke2((Map<MoveItem, MoveResult>) map);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Map<MoveItem, MoveResult> it5) {
                                Intrinsics.checkNotNullParameter(it5, "it");
                                ChatAddUinComponentKt.getAddToSquareList().clear();
                            }
                        });
                        return;
                    }
                    return;
                }
                if (ChatAddUinComponentKt.getLastAddNeedLocalTo().length() > 0) {
                    ChatAddUinComponent.this.locateTo();
                }
            }
        });
    }

    public final void checkInSquare(ChatCheckUinInSquare event) {
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            Function1<Boolean, Unit> onDone = event.getOnDone();
            if (onDone != null) {
                onDone.invoke(Boolean.valueOf(doCheckInSquare(event.getUin())));
            }
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "checkInSquare.error: ", th5);
        }
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.square.components.fragment.ISquareEventListener
    public void onBackFromDetail(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        VasBaseFragment fragment = getFragment();
        Fragment topFragment = fragment != null ? fragment.getTopFragment() : null;
        DetailSelectGuestFragment detailSelectGuestFragment = (DetailSelectGuestFragment) (topFragment instanceof DetailSelectGuestFragment ? topFragment : null);
        if (detailSelectGuestFragment != null) {
            addUinOrLocateTo(detailSelectGuestFragment.getMainScene());
        }
    }

    public final void pendingAdd(List<MoveItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        for (MoveItem moveItem : list) {
            List<MoveItem> addToSquareList = ChatAddUinComponentKt.getAddToSquareList();
            boolean z16 = true;
            if (!(addToSquareList instanceof Collection) || !addToSquareList.isEmpty()) {
                Iterator<T> it = addToSquareList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (Intrinsics.areEqual(((MoveItem) it.next()).getUin(), moveItem.getUin())) {
                            z16 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z16) {
                ChatAddUinComponentKt.getAddToSquareList().add(new MoveItem(moveItem.getUin(), moveItem.getUnitType(), false, null, 12, null));
            }
        }
    }

    public final void add(final ChatAddUinToSquare event) {
        int relationType;
        List listOf;
        Intrinsics.checkNotNullParameter(event, "event");
        String uin = event.getUin();
        if (event.getRelationType() == -1) {
            SquareBaseKt.getSquareLog().i(TAG, "default relationType=" + event.getRelationType() + ", uin:" + event.getUin());
            relationType = 2;
        } else {
            relationType = event.getRelationType();
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new MoveItem(uin, relationType, false, null, 12, null));
        SquareGroupUiComponent uiComponent = getUiComponent();
        if (uiComponent != null) {
            uiComponent.addMultiRoles(listOf, 7, event.getMainScene(), (r18 & 8) != 0 ? null : null, true, event.getLocateTo(), (r18 & 64) != 0 ? null : new Function1<Map<MoveItem, ? extends MoveResult>, Unit>() { // from class: com.tencent.state.square.components.fragment.ChatAddUinComponent$add$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Map<MoveItem, ? extends MoveResult> map) {
                    invoke2((Map<MoveItem, MoveResult>) map);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Map<MoveItem, MoveResult> itemList) {
                    Intrinsics.checkNotNullParameter(itemList, "itemList");
                    if (event.getLocateTo()) {
                        return;
                    }
                    for (Map.Entry<MoveItem, MoveResult> entry : itemList.entrySet()) {
                        if (entry.getValue().getType() == MoveType.AddToSquare) {
                            ChatAddUinComponent.this.addSquareAsyncLocateTo(entry.getKey().getUin());
                        }
                    }
                }
            });
        }
    }
}

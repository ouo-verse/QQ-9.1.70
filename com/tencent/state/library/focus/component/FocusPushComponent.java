package com.tencent.state.library.focus.component;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.FragmentComponent;
import com.tencent.state.PageType;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.common.push.BasePushManager;
import com.tencent.state.common.push.IPushListener;
import com.tencent.state.common.push.PushMessage;
import com.tencent.state.common.tag.CommonTagInfo;
import com.tencent.state.library.components.LibraryGroupUiComponent;
import com.tencent.state.library.push.CancelFocusMessage;
import com.tencent.state.library.push.FocusMessage;
import com.tencent.state.library.push.LibraryPushMessagesKt;
import com.tencent.state.library.push.LikeMessage;
import com.tencent.state.library.push.UserRefreshMessage;
import com.tencent.state.square.data.Resource;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.User;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import oicq.wlogin_sdk.tools.util;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J$\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0016\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0016\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0016\u0010\u0019\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/state/library/focus/component/FocusPushComponent;", "Lcom/tencent/state/VasBaseFragmentComponent;", "Lcom/tencent/state/common/push/IPushListener;", "()V", "pushManager", "Lcom/tencent/state/common/push/BasePushManager;", "getPushManager", "()Lcom/tencent/state/common/push/BasePushManager;", "pushManager$delegate", "Lkotlin/Lazy;", "onFragmentCreated", "", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onFragmentDestroyed", "onReceive", "messages", "", "Lcom/tencent/state/common/push/PushMessage;", "onReceiveFocusMessage", "onReceiveLikeMessage", "onReceiveNewDressMessage", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class FocusPushComponent extends VasBaseFragmentComponent implements IPushListener {

    /* renamed from: pushManager$delegate, reason: from kotlin metadata */
    private final Lazy pushManager;

    public FocusPushComponent() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<BasePushManager>() { // from class: com.tencent.state.library.focus.component.FocusPushComponent$pushManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BasePushManager invoke() {
                VasBaseFragment fragment;
                BasePushManager pushManager;
                fragment = FocusPushComponent.this.getFragment();
                LibraryGroupUiComponent libraryGroupUiComponent = fragment != null ? (LibraryGroupUiComponent) VasBaseLifecycleFragment.getComponent$default(fragment, LibraryGroupUiComponent.class, null, null, 6, null) : null;
                return (libraryGroupUiComponent == null || (pushManager = libraryGroupUiComponent.getPushManager()) == null) ? new BasePushManager(PageType.Library, 0, 2, null) : pushManager;
            }
        });
        this.pushManager = lazy;
    }

    private final BasePushManager getPushManager() {
        return (BasePushManager) this.pushManager.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ce A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void onReceiveFocusMessage(List<? extends PushMessage> messages) {
        Object last;
        FocusUIComponent focusUIComponent;
        VasBaseFragment fragment;
        FocusUIComponent focusUIComponent2;
        Long l3;
        long roomId;
        FocusMessage focusMessage;
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
        for (Object obj3 : arrayList) {
            PushMessage pushMessage2 = (PushMessage) obj3;
            boolean z16 = pushMessage2 instanceof FocusMessage;
            Long l16 = null;
            FocusMessage focusMessage2 = (FocusMessage) (!z16 ? null : pushMessage2);
            if (focusMessage2 != null) {
                roomId = focusMessage2.getRoomId();
            } else {
                CancelFocusMessage cancelFocusMessage = (CancelFocusMessage) (!(pushMessage2 instanceof CancelFocusMessage) ? null : pushMessage2);
                if (cancelFocusMessage != null) {
                    roomId = cancelFocusMessage.getRoomId();
                } else {
                    l3 = null;
                    long longValue = l3 == null ? l3.longValue() : 0L;
                    focusMessage = (FocusMessage) (z16 ? null : pushMessage2);
                    if (focusMessage == null) {
                        tableId = focusMessage.getTableId();
                    } else {
                        CancelFocusMessage cancelFocusMessage2 = (CancelFocusMessage) (!(pushMessage2 instanceof CancelFocusMessage) ? null : pushMessage2);
                        if (cancelFocusMessage2 != null) {
                            tableId = cancelFocusMessage2.getTableId();
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
                        ((List) obj).add(obj3);
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
                    ((List) obj).add(obj3);
                }
            }
            l3 = Long.valueOf(roomId);
            if (l3 == null) {
            }
            focusMessage = (FocusMessage) (z16 ? null : pushMessage2);
            if (focusMessage == null) {
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
            ((List) obj).add(obj3);
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) ((Map.Entry) it.next()).getValue());
            PushMessage pushMessage3 = (PushMessage) last;
            if (pushMessage3 instanceof FocusMessage) {
                VasBaseFragment fragment2 = getFragment();
                if (fragment2 != null && (focusUIComponent = (FocusUIComponent) VasBaseLifecycleFragment.getComponent$default(fragment2, FocusUIComponent.class, null, null, 6, null)) != null) {
                    FocusMessage focusMessage3 = (FocusMessage) pushMessage3;
                    focusUIComponent.sitDown(focusMessage3.getTableId(), LibraryPushMessagesKt.getUser(focusMessage3));
                }
            } else if ((pushMessage3 instanceof CancelFocusMessage) && (fragment = getFragment()) != null && (focusUIComponent2 = (FocusUIComponent) VasBaseLifecycleFragment.getComponent$default(fragment, FocusUIComponent.class, null, null, 6, null)) != null) {
                CancelFocusMessage cancelFocusMessage3 = (CancelFocusMessage) pushMessage3;
                focusUIComponent2.standUp(cancelFocusMessage3.getTableId(), cancelFocusMessage3.getUin(), cancelFocusMessage3.isTimeOut());
            }
        }
    }

    private final void onReceiveLikeMessage(List<? extends PushMessage> messages) {
        FocusLikeReddotComponent focusLikeReddotComponent;
        FocusUIComponent focusUIComponent;
        ArrayList<PushMessage> arrayList = new ArrayList();
        for (Object obj : messages) {
            if (((PushMessage) obj).getType() == 6) {
                arrayList.add(obj);
            }
        }
        for (PushMessage pushMessage : arrayList) {
            if (pushMessage instanceof LikeMessage) {
                VasBaseFragment fragment = getFragment();
                if (fragment != null && (focusUIComponent = (FocusUIComponent) VasBaseLifecycleFragment.getComponent$default(fragment, FocusUIComponent.class, null, null, 6, null)) != null) {
                    focusUIComponent.updateLikeNum(((LikeMessage) pushMessage).getToUin(), r0.getLikeCount());
                }
                VasBaseFragment fragment2 = getFragment();
                if (fragment2 != null && (focusLikeReddotComponent = (FocusLikeReddotComponent) VasBaseLifecycleFragment.getComponent$default(fragment2, FocusLikeReddotComponent.class, null, null, 6, null)) != null) {
                    focusLikeReddotComponent.updateRedDotView();
                }
            }
        }
    }

    private final void onReceiveNewDressMessage(List<? extends PushMessage> messages) {
        List filterIsInstance;
        Object last;
        Resource resource;
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        CommonTagInfo subTag;
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
            SitDownInfo sitDown = user.getSitDown();
            if (sitDown != null && (resource = sitDown.getResource()) != null) {
                FragmentComponent fragmentComponent2 = null;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
                if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(FocusUIComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(FocusUIComponent.class, null)) == null)) {
                    VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                    if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, FocusUIComponent.class, null, null, 2, null)) == null) {
                        VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                        if (vasBaseFragment2 != null) {
                            fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, FocusUIComponent.class, null, null, 6, null);
                        }
                    } else {
                        fragmentComponent2 = component$default;
                    }
                    fragmentComponent = fragmentComponent2;
                }
                FocusUIComponent focusUIComponent = (FocusUIComponent) fragmentComponent;
                if (focusUIComponent != null) {
                    focusUIComponent.updateUserResource(user.getUin(), resource);
                    SitDownInfo sitDown2 = user.getSitDown();
                    if (sitDown2 != null && (subTag = sitDown2.getSubTag()) != null) {
                        focusUIComponent.updateDeskMateTag(user.getUin(), subTag);
                    }
                }
            }
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentCreated(FragmentManager fm5, Fragment f16, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        super.onFragmentCreated(fm5, f16, savedInstanceState);
        getPushManager().register(this);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentDestroyed(FragmentManager fm5, Fragment f16) {
        Intrinsics.checkNotNullParameter(f16, "f");
        super.onFragmentDestroyed(fm5, f16);
        getPushManager().unregister(this);
    }

    @Override // com.tencent.state.common.push.IPushListener
    public void onReceive(List<? extends PushMessage> messages) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        onReceiveFocusMessage(messages);
        onReceiveLikeMessage(messages);
        onReceiveNewDressMessage(messages);
    }
}

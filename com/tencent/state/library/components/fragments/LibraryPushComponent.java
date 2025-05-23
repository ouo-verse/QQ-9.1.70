package com.tencent.state.library.components.fragments;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.FragmentComponent;
import com.tencent.state.PageType;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.common.push.BasePushManager;
import com.tencent.state.common.push.PushMessage;
import com.tencent.state.common.tag.CommonTagInfo;
import com.tencent.state.library.components.LibraryGroupUiComponent;
import com.tencent.state.library.focus.FocusDialogTips;
import com.tencent.state.library.push.CancelFocusMessage;
import com.tencent.state.library.push.FocusMessage;
import com.tencent.state.library.push.KickOutRoomMessage;
import com.tencent.state.library.push.LibraryPushMessagesKt;
import com.tencent.state.library.push.LikeMessage;
import com.tencent.state.library.push.ReenterRoomMessage;
import com.tencent.state.library.push.SwitchRoomMessage;
import com.tencent.state.library.push.UserRefreshMessage;
import com.tencent.state.map.IMapViewUpdater;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.data.Resource;
import com.tencent.state.template.data.CommonDataKt;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.User;
import com.tencent.state.template.map.ITemplateViewUpdater;
import com.tencent.state.template.map.TemplateMapView;
import com.tencent.state.template.map.component.ITemplateMapEvent;
import com.tencent.state.template.map.component.TemplatePushComponent;
import com.tencent.state.template.map.component.TemplateRoomComponent;
import com.tencent.state.template.map.component.TemplateUiComponent;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0016\u0010\n\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\f\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\r\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\u000f\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/library/components/fragments/LibraryPushComponent;", "Lcom/tencent/state/template/map/component/TemplatePushComponent;", "()V", "getTargetPushManager", "Lcom/tencent/state/common/push/BasePushManager;", "onReceive", "", "messages", "", "Lcom/tencent/state/common/push/PushMessage;", "onReceiveFocusMessage", "onReceiveKickOutMessage", "onReceiveLikeMessage", "onReceiveReenterRoomMessage", "onReceiveSwitchRoomMessage", "onReceiveUserRefreshMessage", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class LibraryPushComponent extends TemplatePushComponent {
    private static final String TAG = "LibraryPushComponent";

    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void onReceiveFocusMessage(List<? extends PushMessage> messages) {
        Object last;
        WeakReference<VasBaseFragmentComponentGroup> parent;
        VasBaseFragment vasBaseFragment;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        Long l3;
        long roomId;
        FocusMessage focusMessage;
        long tableId;
        Object obj;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = messages.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            PushMessage pushMessage = (PushMessage) next;
            if (pushMessage.getType() == 4 || pushMessage.getType() == 5) {
                arrayList.add(next);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it5 = arrayList.iterator();
        while (true) {
            Long l16 = null;
            if (!it5.hasNext()) {
                break;
            }
            Object next2 = it5.next();
            PushMessage pushMessage2 = (PushMessage) next2;
            boolean z16 = pushMessage2 instanceof FocusMessage;
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
                        ((List) obj).add(next2);
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
                    ((List) obj).add(next2);
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
            ((List) obj).add(next2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) entry.getValue());
            PushMessage pushMessage3 = (PushMessage) last;
            SquareBaseKt.getSquareLog().d(TAG, "onReceiveFocusMessage: " + ((List) entry.getValue()).size() + ", " + pushMessage3.getType() + ", " + pushMessage3);
            VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
            if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(TemplateUiComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(TemplateUiComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateUiComponent.class, null, null, 2, null)) == null))) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateUiComponent.class, null, null, 6, null) : null;
            }
            TemplateUiComponent templateUiComponent = (TemplateUiComponent) component$default;
            if (templateUiComponent != null) {
                if (pushMessage3 instanceof FocusMessage) {
                    FocusMessage focusMessage3 = (FocusMessage) pushMessage3;
                    templateUiComponent.sitDown(focusMessage3.getTableId(), LibraryPushMessagesKt.getUser(focusMessage3));
                } else if (pushMessage3 instanceof CancelFocusMessage) {
                    CancelFocusMessage cancelFocusMessage3 = (CancelFocusMessage) pushMessage3;
                    if (Intrinsics.areEqual(String.valueOf(cancelFocusMessage3.getUin()), Square.INSTANCE.getConfig().getCommonUtils().getCurrentAccountUin())) {
                        SquareUtil.INSTANCE.setKeepScreen(getActivity(), false);
                    }
                    templateUiComponent.standUp(cancelFocusMessage3.getTableId(), cancelFocusMessage3.getUin());
                    if (CommonDataKt.isMe(cancelFocusMessage3.getUin()) && cancelFocusMessage3.isTimeOut()) {
                        VasBaseFragment fragment = getFragment();
                        if (fragment != null && fragment.isTopFragment()) {
                            FocusDialogTips.showMaxFocusTimeDialog$default(FocusDialogTips.INSTANCE, getActivity(), null, 2, null);
                        }
                        LibraryPushComponent$onReceiveFocusMessage$3$1 libraryPushComponent$onReceiveFocusMessage$3$1 = new Function1<ITemplateMapEvent, Unit>() { // from class: com.tencent.state.library.components.fragments.LibraryPushComponent$onReceiveFocusMessage$3$1
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
                        VasBaseFragment vasBaseFragment3 = ((VasBaseFragmentComponent) this).fragment;
                        if (vasBaseFragment3 != null) {
                            vasBaseFragment3.forEachComponent(ITemplateMapEvent.class, null, null, libraryPushComponent$onReceiveFocusMessage$3$1);
                        }
                    }
                }
            } else {
                SquareBaseKt.getSquareLog().d(TAG, "onReceiveFocusMessage: updater is null");
                return;
            }
        }
    }

    private final void onReceiveKickOutMessage(List<? extends PushMessage> messages) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : messages) {
            if (obj2 instanceof KickOutRoomMessage) {
                arrayList.add(obj2);
            }
        }
        ListIterator listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
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
            SquareBaseKt.getSquareLog().i(TAG, "onReceiveKickOutMessage and exit library.");
            QBaseActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    private final void onReceiveLikeMessage(List<? extends PushMessage> messages) {
        List filterIsInstance;
        Object last;
        ITemplateViewUpdater iTemplateViewUpdater;
        filterIsInstance = CollectionsKt___CollectionsJvmKt.filterIsInstance(messages, LikeMessage.class);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : filterIsInstance) {
            Long valueOf = Long.valueOf(((LikeMessage) obj).getToUin());
            Object obj2 = linkedHashMap.get(valueOf);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(valueOf, obj2);
            }
            ((List) obj2).add(obj);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) entry.getValue());
            LikeMessage likeMessage = (LikeMessage) last;
            TemplateMapView<?> mapView = getMapView();
            if (mapView != null && (iTemplateViewUpdater = (ITemplateViewUpdater) mapView.getComponent(ITemplateViewUpdater.class)) != null) {
                iTemplateViewUpdater.updateUserLikeCount(((Number) entry.getKey()).longValue(), likeMessage.getLikeCount());
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
            if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(LibraryRoomComponent.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(LibraryRoomComponent.class, null)) == null)) {
                VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
                if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, LibraryRoomComponent.class, null, null, 2, null)) == null) {
                    VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                    if (vasBaseFragment2 != null) {
                        fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, LibraryRoomComponent.class, null, null, 6, null);
                    }
                } else {
                    fragmentComponent2 = component$default;
                }
                fragmentComponent = fragmentComponent2;
            }
            LibraryRoomComponent libraryRoomComponent = (LibraryRoomComponent) fragmentComponent;
            if (libraryRoomComponent != null) {
                libraryRoomComponent.reenterRoom();
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
            if ((vasBaseFragmentComponentGroup2 == null || (component$default = vasBaseFragmentComponentGroup2.getComponent(LibraryRoomComponent.class, null)) == null) && (((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (component$default = vasBaseFragmentComponentGroup.getComponent(LibraryRoomComponent.class, null)) == null) && ((vasBaseFragment = ((VasBaseFragmentComponent) this).fragment) == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, LibraryRoomComponent.class, null, null, 2, null)) == null))) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                component$default = vasBaseFragment2 != null ? VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, LibraryRoomComponent.class, null, null, 6, null) : null;
            }
            LibraryRoomComponent libraryRoomComponent = (LibraryRoomComponent) component$default;
            if (libraryRoomComponent != null) {
                TemplateRoomComponent.switchRoom$default(libraryRoomComponent, null, null, 3, null);
            }
        }
    }

    private final void onReceiveUserRefreshMessage(List<? extends PushMessage> messages) {
        List filterIsInstance;
        Object last;
        Resource resource;
        CommonTagInfo subTag;
        VasBaseFragment fragment;
        LibraryUiComponent libraryUiComponent;
        IMapViewUpdater iMapViewUpdater;
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
                TemplateMapView<?> mapView = getMapView();
                if (mapView != null && (iMapViewUpdater = (IMapViewUpdater) mapView.getComponent(IMapViewUpdater.class)) != null) {
                    iMapViewUpdater.updateTargetResource(user.getUin(), resource, true);
                }
                SitDownInfo sitDown2 = user.getSitDown();
                if (sitDown2 != null && (subTag = sitDown2.getSubTag()) != null && (fragment = getFragment()) != null && (libraryUiComponent = (LibraryUiComponent) VasBaseLifecycleFragment.getComponent$default(fragment, LibraryUiComponent.class, null, null, 6, null)) != null) {
                    libraryUiComponent.updateDeskMateTag(user.getUin(), subTag);
                }
            }
        }
    }

    @Override // com.tencent.state.template.map.component.TemplatePushComponent
    public BasePushManager getTargetPushManager() {
        LibraryGroupUiComponent libraryGroupUiComponent;
        BasePushManager pushManager;
        VasBaseFragment fragment = getFragment();
        return (fragment == null || (libraryGroupUiComponent = (LibraryGroupUiComponent) VasBaseLifecycleFragment.getComponent$default(fragment, LibraryGroupUiComponent.class, null, null, 6, null)) == null || (pushManager = libraryGroupUiComponent.getPushManager()) == null) ? new BasePushManager(PageType.Library, 0, 2, null) : pushManager;
    }

    @Override // com.tencent.state.common.push.IPushListener
    public void onReceive(List<? extends PushMessage> messages) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        if (!messages.isEmpty()) {
            onReceiveLikeMessage(messages);
            onReceiveFocusMessage(messages);
            onReceiveUserRefreshMessage(messages);
            onReceiveReenterRoomMessage(messages);
            onReceiveSwitchRoomMessage(messages);
            onReceiveKickOutMessage(messages);
        }
    }
}

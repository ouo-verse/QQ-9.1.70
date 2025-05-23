package com.tencent.state.template.map.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.template.data.CommonRoomInfo;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.template.data.Table;
import com.tencent.state.template.data.User;
import com.tencent.state.template.map.TemplateMapView;
import com.tencent.state.template.map.TemplateMapViewKt;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0016J(\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012H&J\b\u0010\u0013\u001a\u00020\u0004H&J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/template/map/component/TemplateSchemeComponent;", "Lcom/tencent/state/template/map/component/TemplateMapBaseComponent;", "()V", "handleSchemeFromArk", "", "data", "Lcom/tencent/state/template/data/EnterRoomInfo;", "isReconnect", "", "handleSchemeFromSquare", "info", "onEnterRoom", "onShowUserHasLeaveDialog", "context", "Landroid/content/Context;", "friendName", "", "callback", "Lkotlin/Function0;", "reportDeskHavePeople", "showHasOwnerTips", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "showSitingTips", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class TemplateSchemeComponent extends TemplateMapBaseComponent {
    private static final String TAG = "TemplateSchemeComponent";

    /* JADX WARN: Code restructure failed: missing block: B:7:0x003e, code lost:
    
        r13 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r13);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleSchemeFromArk(EnterRoomInfo data, boolean isReconnect) {
        final List<User> sitUsers;
        Object obj;
        QBaseActivity activity;
        Object obj2;
        TemplateMapView<?> mapView;
        Table table;
        Table neighbor;
        User user;
        QBaseActivity activity2;
        Table table2;
        Table neighbor2;
        Table table3;
        Table neighbor3;
        Intent intent;
        Long longOrNull;
        SquareBaseKt.getSquareLog().d(TAG, "handleSchemeFromArk, " + data.getIsReenter() + ", " + isReconnect);
        QBaseActivity activity3 = getActivity();
        final long longValue = (activity3 == null || (intent = activity3.getIntent()) == null || (r13 = intent.getStringExtra("uin")) == null || longOrNull == null) ? 0L : longOrNull.longValue();
        CommonRoomInfo room = data.getRoom();
        if (room == null || (sitUsers = room.getSitUsers()) == null) {
            return;
        }
        List<User> list = sitUsers;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((User) obj).getUin(), String.valueOf(longValue))) {
                    break;
                }
            }
        }
        final User user2 = (User) obj;
        if (user2 != null) {
            SitDownInfo sitDown = user2.getSitDown();
            if (((sitDown == null || (table3 = sitDown.getTable()) == null || (neighbor3 = table3.getNeighbor()) == null) ? null : neighbor3.getUser()) == null) {
                SquareBaseKt.getSquareThread().postOnUiDelayed(300L, new Function0<Unit>() { // from class: com.tencent.state.template.map.component.TemplateSchemeComponent$handleSchemeFromArk$1
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
                        WeakReference<VasBaseFragmentComponentGroup> parent;
                        FragmentComponent fragmentComponent;
                        FragmentComponent component$default;
                        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                        TemplateSchemeComponent templateSchemeComponent = TemplateSchemeComponent.this;
                        FragmentComponent fragmentComponent2 = null;
                        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(templateSchemeComponent instanceof VasBaseFragmentComponentGroup) ? null : templateSchemeComponent);
                        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(TemplateUiComponent.class, null)) == null) && ((parent = templateSchemeComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(TemplateUiComponent.class, null)) == null)) {
                            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) templateSchemeComponent).fragment;
                            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateUiComponent.class, null, null, 2, null)) == null) {
                                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) templateSchemeComponent).parentFragment;
                                if (vasBaseFragment2 != null) {
                                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateUiComponent.class, null, null, 6, null);
                                }
                            } else {
                                fragmentComponent2 = component$default;
                            }
                            fragmentComponent = fragmentComponent2;
                        }
                        TemplateUiComponent templateUiComponent = (TemplateUiComponent) fragmentComponent;
                        if (templateUiComponent != null) {
                            templateUiComponent.locateToAndScale(String.valueOf(longValue));
                        }
                    }
                });
                return;
            }
        }
        if (user2 != null) {
            SitDownInfo sitDown2 = user2.getSitDown();
            if (((sitDown2 == null || (table2 = sitDown2.getTable()) == null || (neighbor2 = table2.getNeighbor()) == null) ? null : neighbor2.getUser()) != null) {
                SquareBaseKt.getSquareThread().postOnUiDelayed(300L, new Function0<Unit>() { // from class: com.tencent.state.template.map.component.TemplateSchemeComponent$handleSchemeFromArk$2
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
                        WeakReference<VasBaseFragmentComponentGroup> parent;
                        FragmentComponent fragmentComponent;
                        FragmentComponent component$default;
                        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                        TemplateSchemeComponent templateSchemeComponent = TemplateSchemeComponent.this;
                        FragmentComponent fragmentComponent2 = null;
                        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(templateSchemeComponent instanceof VasBaseFragmentComponentGroup) ? null : templateSchemeComponent);
                        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(TemplateUiComponent.class, null)) == null) && ((parent = templateSchemeComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(TemplateUiComponent.class, null)) == null)) {
                            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) templateSchemeComponent).fragment;
                            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateUiComponent.class, null, null, 2, null)) == null) {
                                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) templateSchemeComponent).parentFragment;
                                if (vasBaseFragment2 != null) {
                                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateUiComponent.class, null, null, 6, null);
                                }
                            } else {
                                fragmentComponent2 = component$default;
                            }
                            fragmentComponent = fragmentComponent2;
                        }
                        TemplateUiComponent templateUiComponent = (TemplateUiComponent) fragmentComponent;
                        if (templateUiComponent != null) {
                            templateUiComponent.locateToAndScale(String.valueOf(longValue));
                        }
                    }
                });
                SitDownInfo sitDown3 = user2.getSitDown();
                if (sitDown3 == null || (table = sitDown3.getTable()) == null || (neighbor = table.getNeighbor()) == null || (user = neighbor.getUser()) == null || user.isMe() || (activity2 = getActivity()) == null) {
                    return;
                }
                showHasOwnerTips(activity2);
                reportDeskHavePeople();
                return;
            }
        }
        if (user2 != null || (activity = getActivity()) == null) {
            return;
        }
        String currentAccountUin = SquareBaseKt.getSquareCommon().getCurrentAccountUin();
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        Iterator<T> it5 = list.iterator();
        while (true) {
            if (!it5.hasNext()) {
                obj2 = null;
                break;
            } else {
                obj2 = it5.next();
                if (Intrinsics.areEqual(((User) obj2).getUin(), currentAccountUin)) {
                    break;
                }
            }
        }
        User user3 = (User) obj2;
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleSchemeFromArk, sender is null, ");
        sb5.append(user3);
        sb5.append(", ");
        TemplateMapView<?> mapView2 = getMapView();
        sb5.append(mapView2 != null ? Boolean.valueOf(TemplateMapViewKt.isMeSeated(mapView2)) : null);
        squareLog.i(TAG, sb5.toString());
        if (user3 == null && ((mapView = getMapView()) == null || !TemplateMapViewKt.isMeSeated(mapView))) {
            onShowUserHasLeaveDialog(activity, "", null);
        } else {
            SquareBaseKt.getSquareThread().postOnUiDelayed(300L, new Function0<Unit>() { // from class: com.tencent.state.template.map.component.TemplateSchemeComponent$handleSchemeFromArk$$inlined$let$lambda$1
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
                    WeakReference<VasBaseFragmentComponentGroup> parent;
                    FragmentComponent fragmentComponent;
                    FragmentComponent component$default;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                    TemplateSchemeComponent templateSchemeComponent = TemplateSchemeComponent.this;
                    FragmentComponent fragmentComponent2 = null;
                    VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(templateSchemeComponent instanceof VasBaseFragmentComponentGroup) ? null : templateSchemeComponent);
                    if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(TemplateUiComponent.class, null)) == null) && ((parent = templateSchemeComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(TemplateUiComponent.class, null)) == null)) {
                        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) templateSchemeComponent).fragment;
                        if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateUiComponent.class, null, null, 2, null)) == null) {
                            VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) templateSchemeComponent).parentFragment;
                            if (vasBaseFragment2 != null) {
                                fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateUiComponent.class, null, null, 6, null);
                            }
                        } else {
                            fragmentComponent2 = component$default;
                        }
                        fragmentComponent = fragmentComponent2;
                    }
                    TemplateUiComponent templateUiComponent = (TemplateUiComponent) fragmentComponent;
                    if (templateUiComponent != null) {
                        templateUiComponent.backToMySeat();
                    }
                }
            });
            showSitingTips(activity);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0035, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleSchemeFromSquare(EnterRoomInfo info) {
        Intent intent;
        Long longOrNull;
        List<User> sitUsers;
        Object obj;
        SquareBaseKt.getSquareLog().d(TAG, "handleSchemeFromSquare, " + info.getIsReenter());
        QBaseActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (r0 = intent.getStringExtra("uin")) == null || longOrNull == null) {
            return;
        }
        long longValue = longOrNull.longValue();
        CommonRoomInfo room = info.getRoom();
        if (room == null || (sitUsers = room.getSitUsers()) == null) {
            return;
        }
        Iterator<T> it = sitUsers.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((User) obj).getUin(), String.valueOf(longValue))) {
                    break;
                }
            }
        }
        final User user = (User) obj;
        if (user == null) {
            QBaseActivity activity2 = getActivity();
            if (activity2 != null) {
                onShowUserHasLeaveDialog(activity2, "", new Function0<Unit>() { // from class: com.tencent.state.template.map.component.TemplateSchemeComponent$handleSchemeFromSquare$1$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            return;
        }
        SquareBaseKt.getSquareThread().postOnUiDelayed(300L, new Function0<Unit>() { // from class: com.tencent.state.template.map.component.TemplateSchemeComponent$handleSchemeFromSquare$2
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
                WeakReference<VasBaseFragmentComponentGroup> parent;
                FragmentComponent fragmentComponent;
                FragmentComponent component$default;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
                TemplateSchemeComponent templateSchemeComponent = TemplateSchemeComponent.this;
                FragmentComponent fragmentComponent2 = null;
                VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(templateSchemeComponent instanceof VasBaseFragmentComponentGroup) ? null : templateSchemeComponent);
                if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(TemplateUiComponent.class, null)) == null) && ((parent = templateSchemeComponent.getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(TemplateUiComponent.class, null)) == null)) {
                    VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) templateSchemeComponent).fragment;
                    if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, TemplateUiComponent.class, null, null, 2, null)) == null) {
                        VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) templateSchemeComponent).parentFragment;
                        if (vasBaseFragment2 != null) {
                            fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, TemplateUiComponent.class, null, null, 6, null);
                        }
                    } else {
                        fragmentComponent2 = component$default;
                    }
                    fragmentComponent = fragmentComponent2;
                }
                TemplateUiComponent templateUiComponent = (TemplateUiComponent) fragmentComponent;
                if (templateUiComponent != null) {
                    templateUiComponent.locateToAndScale(user.getUin());
                }
            }
        });
    }

    @Override // com.tencent.state.template.map.component.TemplateMapBaseComponent, com.tencent.state.template.map.component.ITemplateMapEvent
    public void onEnterRoom(EnterRoomInfo info) {
        String str;
        Intent intent;
        Intrinsics.checkNotNullParameter(info, "info");
        if (info.getIsReenter()) {
            return;
        }
        QBaseActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("source")) == null) {
            str = "";
        }
        switch (str.hashCode()) {
            case 49:
                if (!str.equals("1")) {
                    return;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    handleSchemeFromArk(info, info.getIsReconnect());
                    return;
                }
                return;
            case 51:
                if (!str.equals("3")) {
                    return;
                }
                break;
            default:
                return;
        }
        handleSchemeFromSquare(info);
    }

    public abstract void onShowUserHasLeaveDialog(Context context, String friendName, Function0<Unit> callback);

    public abstract void reportDeskHavePeople();

    public abstract void showHasOwnerTips(Activity activity);

    public abstract void showSitingTips(Activity activity);
}

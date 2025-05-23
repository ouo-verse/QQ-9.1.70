package com.tencent.state.square.components.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.FragmentComponent;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.VasBaseFragmentComponentGroup;
import com.tencent.state.VasBaseLifecycleFragment;
import com.tencent.state.map.IMapViewManipulator;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ISquareViewUpdater;
import com.tencent.state.square.MoveItem;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareConstants;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.api.ISquarePushService;
import com.tencent.state.square.chatland.data.ChatLandAvatarItem;
import com.tencent.state.square.chatland.data.ChatLandAvatarItemKt;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.RelationType;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.data.SquareAvatarItemKt;
import com.tencent.state.square.filamentmap.IFilamentMapController;
import com.tencent.state.square.interaction.InteractionActionDialog;
import com.tencent.state.square.interaction.InteractionManager;
import com.tencent.state.square.interaction.InteractionSettingsDialog;
import com.tencent.state.square.resource.ISquareRoleManager;
import com.tencent.state.template.data.CommonDataKt;
import com.tencent.state.template.data.InterReceiverInfo;
import com.tencent.state.template.data.InterResourceInfo;
import com.tencent.state.template.data.SitDownInfo;
import com.tencent.state.utils.SquareSwitchUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000bH\u0016J2\u0010\f\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0002\b\u00030\u000ej\u0002`\u000f2\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\tH\u0016J,\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u001a\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u001c\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareInteractionComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "cleanNewFlags", "", "data", "Lcom/tencent/state/map/MapItem;", "targetTypes", "", "", "onBackFromDetail", "Landroid/os/Bundle;", "onDoubleClick", "vh", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "index", "viewId", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "onFragmentViewDestroyed", "tryInteractionChatLand", "tryOpenInteractionDialog", "needToastEmpty", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareInteractionComponent extends SquareBaseComponent {
    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.square.components.fragment.ISquareEventListener
    public void onBackFromDetail(Bundle data) {
        Intrinsics.checkNotNullParameter(data, "data");
        final String string = data.getString(SquareConstants.LOCATE_TO_UIN);
        if (string == null) {
            string = "";
        }
        Intrinsics.checkNotNullExpressionValue(string, "data.getString(SquareCon\u2026ants.LOCATE_TO_UIN) ?: \"\"");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        final boolean z16 = data.getBoolean(SquareConstants.IS_IN_SQUARE);
        SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareInteractionComponent$onBackFromDetail$1
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
                List listOf;
                IMapViewManipulator manipulator;
                if (z16) {
                    SquareView mapView = SquareInteractionComponent.this.getMapView();
                    if (mapView == null || (manipulator = mapView.getManipulator()) == null) {
                        return;
                    }
                    manipulator.locateTo(string, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareInteractionComponent$onBackFromDetail$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z17) {
                            ISquareViewUpdater updater;
                            SquareView mapView2 = SquareInteractionComponent.this.getMapView();
                            if (mapView2 == null || (updater = mapView2.getUpdater()) == null) {
                                return;
                            }
                            updater.playRingAnim(string);
                        }
                    });
                    return;
                }
                SquareFragment squareFragment = SquareInteractionComponent.this.getSquareFragment();
                if (squareFragment != null) {
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(new MoveItem(string, 0, false, null, 12, null));
                    ISquareRoleManager.DefaultImpls.addMultiRoles$default(squareFragment, listOf, 3, squareFragment.getMainScene(), null, false, false, null, 120, null);
                }
            }
        });
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onDoubleClick(MapViewHolder<?> vh5, int index, MapItem data, int viewId) {
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (data != null) {
            if (viewId == 8) {
                tryOpenInteractionDialog$default(this, data, false, 2, null);
            } else {
                if (viewId != 18) {
                    return;
                }
                tryInteractionChatLand(data);
            }
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ISquarePushService pushService;
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(SquareServiceProvider.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(SquareServiceProvider.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, SquareServiceProvider.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, SquareServiceProvider.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        SquareServiceProvider squareServiceProvider = (SquareServiceProvider) fragmentComponent;
        if (squareServiceProvider == null || (pushService = squareServiceProvider.getPushService()) == null) {
            return;
        }
        InteractionManager.INSTANCE.initPush(pushService);
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewDestroyed(FragmentManager fm5, Fragment f16) {
        WeakReference<VasBaseFragmentComponentGroup> parent;
        FragmentComponent fragmentComponent;
        FragmentComponent component$default;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup;
        ISquarePushService pushService;
        Intrinsics.checkNotNullParameter(f16, "f");
        FragmentComponent fragmentComponent2 = null;
        VasBaseFragmentComponentGroup vasBaseFragmentComponentGroup2 = (VasBaseFragmentComponentGroup) (!(this instanceof VasBaseFragmentComponentGroup) ? null : this);
        if ((vasBaseFragmentComponentGroup2 == null || (fragmentComponent = vasBaseFragmentComponentGroup2.getComponent(SquareServiceProvider.class, null)) == null) && ((parent = getParent()) == null || (vasBaseFragmentComponentGroup = parent.get()) == null || (fragmentComponent = vasBaseFragmentComponentGroup.getComponent(SquareServiceProvider.class, null)) == null)) {
            VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
            if (vasBaseFragment == null || (component$default = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment, SquareServiceProvider.class, null, null, 2, null)) == null) {
                VasBaseFragment vasBaseFragment2 = ((VasBaseFragmentComponent) this).parentFragment;
                if (vasBaseFragment2 != null) {
                    fragmentComponent2 = VasBaseLifecycleFragment.getComponent$default(vasBaseFragment2, SquareServiceProvider.class, null, null, 6, null);
                }
            } else {
                fragmentComponent2 = component$default;
            }
            fragmentComponent = fragmentComponent2;
        }
        SquareServiceProvider squareServiceProvider = (SquareServiceProvider) fragmentComponent;
        if (squareServiceProvider == null || (pushService = squareServiceProvider.getPushService()) == null) {
            return;
        }
        InteractionManager.INSTANCE.destroyPush(pushService);
    }

    private final void cleanNewFlags(MapItem data, List<Integer> targetTypes) {
        ISquareViewUpdater updater;
        if (data == null || getMapView() == null) {
            return;
        }
        SquareView mapView = getMapView();
        if ((mapView != null ? mapView.getAdapter() : null) == null) {
            return;
        }
        SquareView mapView2 = getMapView();
        Intrinsics.checkNotNull(mapView2);
        MapAdapter adapter = mapView2.getAdapter();
        Intrinsics.checkNotNull(adapter);
        int indexOf = adapter.indexOf(data);
        SquareView mapView3 = getMapView();
        if (mapView3 == null || (updater = mapView3.getUpdater()) == null) {
            return;
        }
        updater.clearNewInfo(indexOf, targetTypes);
    }

    private final void tryInteractionChatLand(MapItem data) {
        Long longOrNull;
        FragmentActivity activity;
        long[] longArray;
        InterResourceInfo interaction;
        InterReceiverInfo receiverInfo;
        OnlineStatus onlineStatus;
        SquareView mapView;
        IFilamentMapController filamentMapController;
        SquareView mapView2 = getMapView();
        if ((mapView2 == null || !mapView2.isInDetailMode()) && (data instanceof ChatLandAvatarItem) && !((ChatLandAvatarItem) data).getUser().isReceiver()) {
            if (SquareSwitchUtils.INSTANCE.enableFilamentIndex() && (mapView = getMapView()) != null && (filamentMapController = mapView.getFilamentMapController()) != null) {
                SquareView mapView3 = getMapView();
                filamentMapController.interaction(data, mapView3 != null ? Integer.valueOf(mapView3.getCurrentZoomLevel()) : null);
            }
            Square.INSTANCE.getConfig().getCommonUtils().phoneVibrate(3, 100L);
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(data.getUin());
            long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(longValue));
            ChatLandAvatarItem chatLandAvatarItem = (ChatLandAvatarItem) data;
            SitDownInfo sitDown = chatLandAvatarItem.getUser().getSitDown();
            int topStatusId = (sitDown == null || (onlineStatus = sitDown.getOnlineStatus()) == null) ? 0 : onlineStatus.getTopStatusId();
            Integer richStatusId = ChatLandAvatarItemKt.getRichStatusId(chatLandAvatarItem);
            int intValue = richStatusId != null ? richStatusId.intValue() : 0;
            int appId = data.getAppId();
            if (chatLandAvatarItem.ingInteraction() && (interaction = chatLandAvatarItem.getUser().getInteraction()) != null && (receiverInfo = interaction.getReceiverInfo()) != null) {
                arrayList.add(Long.valueOf(receiverInfo.getUin()));
            }
            if (!CommonDataKt.isMe(Long.parseLong(data.getUin()))) {
                InteractionActionDialog.Companion companion = InteractionActionDialog.INSTANCE;
                longArray = CollectionsKt___CollectionsKt.toLongArray(arrayList);
                companion.interactionNew(new InteractionManager.InteractData(longValue, topStatusId, intValue, null, null, 1, appId, longArray, null));
            }
            VasBaseFragment fragment = getFragment();
            if (fragment == null || (activity = fragment.getActivity()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(activity, "fragment?.activity ?: return");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, SquareGroupReportComponentKt.getSourceFrom(activity));
            linkedHashMap.put(SquareReportConst.Key.KEY_STATE_ID, Integer.valueOf(topStatusId));
            linkedHashMap.put(SquareReportConst.Key.KEY_RICH_STATE_ID, Integer.valueOf(intValue));
            linkedHashMap.put("zplan_other_user_qq", Long.valueOf(longValue));
            linkedHashMap.put(SquareReportConst.Key.KEY_ZPLAN_DOUBLE_CLICK_AVATAR_PG, 4);
            linkedHashMap.put(SquareReportConst.Key.KEY_AVATAR_TYPE, Integer.valueOf(ChatLandAvatarItemKt.getAvatarType(chatLandAvatarItem)));
            linkedHashMap.put(SquareReportConst.Key.KEY_DETAIL_ENTRANCE_SOURCE, "");
            linkedHashMap.put(SquareReportConst.Key.KEY_IS_FRIEND, Integer.valueOf(chatLandAvatarItem.getUser().getRelationType() == RelationType.FRIEND ? 1 : 0));
            linkedHashMap.put(SquareReportConst.Key.KEY_IS_CLOSE_RELATION, 0);
            SquareBase.INSTANCE.getConfig().getReporter().reportEvent(SquareReportConst.CustomEventId.EVENT_ID_DOUBLE_CLICK_AVATAR_COVER, linkedHashMap);
        }
    }

    public final void tryOpenInteractionDialog(MapItem data, boolean needToastEmpty) {
        List<Integer> listOf;
        IFilamentMapController filamentMapController;
        if (data instanceof SquareAvatarItem) {
            SquareSwitchUtils squareSwitchUtils = SquareSwitchUtils.INSTANCE;
            if (squareSwitchUtils.enableFilamentDetail()) {
                SquareView mapView = getMapView();
                if (mapView != null && mapView.isInDetailMode()) {
                    return;
                } else {
                    Square.INSTANCE.getConfig().getCommonUtils().phoneVibrate(3, 100L);
                }
            }
            if (squareSwitchUtils.enableFilamentIndex()) {
                SquareView mapView2 = getMapView();
                if (mapView2 != null && mapView2.isInDetailMode()) {
                    return;
                }
                SquareView mapView3 = getMapView();
                if (mapView3 != null && (filamentMapController = mapView3.getFilamentMapController()) != null) {
                    SquareView mapView4 = getMapView();
                    filamentMapController.interaction(data, mapView4 != null ? Integer.valueOf(mapView4.getCurrentZoomLevel()) : null);
                }
            }
            SquareAvatarItem squareAvatarItem = (SquareAvatarItem) data;
            if (!squareAvatarItem.isMe()) {
                InteractionActionDialog.Companion.showActionDialog$default(InteractionActionDialog.INSTANCE, new WeakReference(getFragment()), SquareAvatarItemKt.copyAvatarItem(squareAvatarItem), needToastEmpty, new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareInteractionComponent$tryOpenInteractionDialog$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareInteractionComponent$tryOpenInteractionDialog$1.1
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
                                SquareView mapView5 = SquareInteractionComponent.this.getMapView();
                                if (mapView5 != null) {
                                    mapView5.pauseAll();
                                }
                            }
                        });
                    }
                }, new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareInteractionComponent$tryOpenInteractionDialog$2
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        SquareView mapView5 = SquareInteractionComponent.this.getMapView();
                        if (mapView5 != null) {
                            mapView5.resumeAll();
                        }
                    }
                }, 1, null, 64, null);
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{3, 2, 1});
                cleanNewFlags(data, listOf);
                return;
            }
            InteractionSettingsDialog.Companion.showDialog$default(InteractionSettingsDialog.INSTANCE, new WeakReference(getFragment()), SquareAvatarItemKt.copyAvatarItem(squareAvatarItem), new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareInteractionComponent$tryOpenInteractionDialog$3
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareInteractionComponent$tryOpenInteractionDialog$3.1
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
                            SquareView mapView5 = SquareInteractionComponent.this.getMapView();
                            if (mapView5 != null) {
                                mapView5.pauseAll();
                            }
                        }
                    });
                }
            }, new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareInteractionComponent$tryOpenInteractionDialog$4
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    SquareView mapView5 = SquareInteractionComponent.this.getMapView();
                    if (mapView5 != null) {
                        mapView5.resumeAll();
                    }
                }
            }, 1, null, 32, null);
        }
    }

    public static /* synthetic */ void tryOpenInteractionDialog$default(SquareInteractionComponent squareInteractionComponent, MapItem mapItem, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        squareInteractionComponent.tryOpenInteractionDialog(mapItem, z16);
    }
}

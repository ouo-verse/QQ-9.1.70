package com.tencent.state.square.chatland.component.share;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.map.MapItem;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.chatland.component.ChatLandSeatComponent;
import com.tencent.state.square.chatland.component.RoomSeatInfo;
import com.tencent.state.square.databinding.VasSquareFragmentSquareBinding;
import com.tencent.state.template.data.CommonRoomInfo;
import com.tencent.state.template.data.EnterRoomInfo;
import com.tencent.state.template.data.QuickSeatTable;
import com.tencent.state.template.data.RoomThemeData;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0002J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J,\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\nH\u0002J\n\u0010$\u001a\u0004\u0018\u00010%H\u0002J\b\u0010&\u001a\u00020\nH\u0002R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/tencent/state/square/chatland/component/share/ChatLandShareQuickSeatComponent;", "Lcom/tencent/state/square/chatland/component/share/ChatLandShareBaseComponent;", "Landroid/view/View$OnClickListener;", "()V", "quickSeatTables", "", "", "", "Lcom/tencent/state/template/data/QuickSeatTable;", "hideQuickSeatButton", "", "onCenterScaled", "isScaleToCenter", "", "view", "Landroid/view/View;", "index", "data", "Lcom/tencent/state/map/MapItem;", NodeProps.ON_CLICK, "v", "onEnterRoom", "info", "Lcom/tencent/state/template/data/EnterRoomInfo;", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onMeFocusEnd", "onMeFocusStart", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "quickTakeSeat", "selectRoom", "Lcom/tencent/state/square/chatland/component/RoomSeatInfo;", "showQuickSeatButton", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ChatLandShareQuickSeatComponent extends ChatLandShareBaseComponent implements View.OnClickListener {
    private static final String TAG = "ChatLandQuickSeatComponent";
    private final Map<Integer, List<QuickSeatTable>> quickSeatTables = new LinkedHashMap();

    private final void hideQuickSeatButton() {
        VasSquareFragmentSquareBinding binding;
        LinearLayout linearLayout;
        SquareFragment squareFragment = getSquareFragment();
        if (squareFragment == null || (binding = squareFragment.getBinding()) == null || (linearLayout = binding.quickSeatBtn) == null) {
            return;
        }
        ViewExtensionsKt.setVisibility(linearLayout, false);
    }

    private final void quickTakeSeat() {
        final RoomSeatInfo selectRoom = selectRoom();
        SquareBaseKt.getSquareLog().d(TAG, "\u5feb\u6377\u5165\u5ea7: room=" + selectRoom);
        Function1<ChatLandSeatComponent, Unit> function1 = new Function1<ChatLandSeatComponent, Unit>() { // from class: com.tencent.state.square.chatland.component.share.ChatLandShareQuickSeatComponent$quickTakeSeat$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChatLandSeatComponent chatLandSeatComponent) {
                invoke2(chatLandSeatComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ChatLandSeatComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                int appId = it.getAppId();
                RoomSeatInfo roomSeatInfo = RoomSeatInfo.this;
                if (roomSeatInfo == null || appId != roomSeatInfo.getAppId()) {
                    return;
                }
                it.quickTakeSeat(false);
            }
        };
        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
        if (vasBaseFragment != null) {
            vasBaseFragment.forEachComponent(ChatLandSeatComponent.class, null, null, function1);
        }
    }

    private final RoomSeatInfo selectRoom() {
        Object randomOrNull;
        Object randomOrNull2;
        Object randomOrNull3;
        Object randomOrNull4;
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        Function1<ChatLandSeatComponent, Unit> function1 = new Function1<ChatLandSeatComponent, Unit>() { // from class: com.tencent.state.square.chatland.component.share.ChatLandShareQuickSeatComponent$selectRoom$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ChatLandSeatComponent chatLandSeatComponent) {
                invoke2(chatLandSeatComponent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ChatLandSeatComponent it) {
                Intrinsics.checkNotNullParameter(it, "it");
                RoomSeatInfo currentRoomSeatInfo = it.getCurrentRoomSeatInfo();
                linkedHashMap.put(Integer.valueOf(currentRoomSeatInfo.getAppId()), currentRoomSeatInfo);
            }
        };
        VasBaseFragment vasBaseFragment = ((VasBaseFragmentComponent) this).fragment;
        Object obj = null;
        if (vasBaseFragment != null) {
            vasBaseFragment.forEachComponent(ChatLandSeatComponent.class, null, null, function1);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            ((Number) entry.getKey()).intValue();
            RoomSeatInfo roomSeatInfo = (RoomSeatInfo) entry.getValue();
            int userCapacity = roomSeatInfo.getUserCapacity() - 3;
            int currentUserCount = roomSeatInfo.getCurrentUserCount();
            if (10 <= currentUserCount && userCapacity >= currentUserCount) {
                arrayList.add(roomSeatInfo);
            }
        }
        if (!arrayList.isEmpty()) {
            SquareBaseKt.getSquareLog().d(TAG, "\u5339\u914d\u89c4\u52191: " + arrayList.size() + "\u4e2a\u5730\u5757\u7b26\u5408\u6761\u4ef6");
            randomOrNull4 = CollectionsKt___CollectionsKt.randomOrNull(arrayList, Random.INSTANCE);
            return (RoomSeatInfo) randomOrNull4;
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            ((Number) entry2.getKey()).intValue();
            RoomSeatInfo roomSeatInfo2 = (RoomSeatInfo) entry2.getValue();
            int min = Math.min(9, roomSeatInfo2.getUserCapacity() - 1);
            int currentUserCount2 = roomSeatInfo2.getCurrentUserCount();
            if (1 <= currentUserCount2 && min >= currentUserCount2) {
                arrayList.add(roomSeatInfo2);
            }
        }
        if (!arrayList.isEmpty()) {
            SquareBaseKt.getSquareLog().d(TAG, "\u5339\u914d\u89c4\u52192: " + arrayList.size() + "\u4e2a\u5730\u5757\u7b26\u5408\u6761\u4ef6");
            randomOrNull3 = CollectionsKt___CollectionsKt.randomOrNull(arrayList, Random.INSTANCE);
            return (RoomSeatInfo) randomOrNull3;
        }
        for (Map.Entry entry3 : linkedHashMap.entrySet()) {
            ((Number) entry3.getKey()).intValue();
            RoomSeatInfo roomSeatInfo3 = (RoomSeatInfo) entry3.getValue();
            int userCapacity2 = roomSeatInfo3.getUserCapacity() - 3;
            int userCapacity3 = roomSeatInfo3.getUserCapacity();
            int currentUserCount3 = roomSeatInfo3.getCurrentUserCount();
            if (userCapacity2 <= currentUserCount3 && userCapacity3 > currentUserCount3) {
                arrayList.add(roomSeatInfo3);
            }
        }
        if (!arrayList.isEmpty()) {
            SquareBaseKt.getSquareLog().d(TAG, "\u5339\u914d\u89c4\u52193: " + arrayList.size() + "\u4e2a\u5730\u5757\u7b26\u5408\u6761\u4ef6");
            randomOrNull2 = CollectionsKt___CollectionsKt.randomOrNull(arrayList, Random.INSTANCE);
            return (RoomSeatInfo) randomOrNull2;
        }
        for (Map.Entry entry4 : linkedHashMap.entrySet()) {
            ((Number) entry4.getKey()).intValue();
            RoomSeatInfo roomSeatInfo4 = (RoomSeatInfo) entry4.getValue();
            if (roomSeatInfo4.getCurrentUserCount() == 0) {
                arrayList.add(roomSeatInfo4);
            }
        }
        if (!arrayList.isEmpty()) {
            SquareBaseKt.getSquareLog().d(TAG, "\u5339\u914d\u89c4\u52194: " + arrayList.size() + "\u4e2a\u5730\u5757\u7b26\u5408\u6761\u4ef6");
            randomOrNull = CollectionsKt___CollectionsKt.randomOrNull(arrayList, Random.INSTANCE);
            return (RoomSeatInfo) randomOrNull;
        }
        SquareBaseKt.getSquareLog().d(TAG, "\u5339\u914d\u89c4\u52195: " + arrayList.size() + "\u4e2a\u5730\u5757\u7b26\u5408\u6761\u4ef6");
        Iterator it = linkedHashMap.values().iterator();
        if (it.hasNext()) {
            obj = it.next();
            if (it.hasNext()) {
                int appId = ((RoomSeatInfo) obj).getAppId();
                do {
                    Object next = it.next();
                    int appId2 = ((RoomSeatInfo) next).getAppId();
                    if (appId > appId2) {
                        obj = next;
                        appId = appId2;
                    }
                } while (it.hasNext());
            }
        }
        return (RoomSeatInfo) obj;
    }

    private final void showQuickSeatButton() {
        VasSquareFragmentSquareBinding binding;
        LinearLayout linearLayout;
        VasBaseFragment fragment = getFragment();
        if (fragment == null || !fragment.isTopFragment() || this.quickSeatTables.isEmpty()) {
            return;
        }
        SquareFragment squareFragment = getSquareFragment();
        if (squareFragment != null && (binding = squareFragment.getBinding()) != null && (linearLayout = binding.quickSeatBtn) != null) {
            ViewExtensionsKt.setVisibility(linearLayout, true);
        }
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.share.ChatLandShareQuickSeatComponent$showQuickSeatButton$1
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
                SquareFragment squareFragment2;
                VasSquareFragmentSquareBinding binding2;
                LinearLayout linearLayout2;
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                squareFragment2 = ChatLandShareQuickSeatComponent.this.getSquareFragment();
                if (squareFragment2 == null || (binding2 = squareFragment2.getBinding()) == null || (linearLayout2 = binding2.quickSeatBtn) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "squareFragment?.binding?\u2026eatBtn ?: return@postOnUi");
                squareReporter.reportEvent("imp", linearLayout2, new LinkedHashMap());
            }
        });
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onCenterScaled(boolean isScaleToCenter, View view, int index, MapItem data) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (isScaleToCenter) {
            hideQuickSeatButton();
        } else {
            showQuickSeatButton();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        quickTakeSeat();
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.chatland.component.share.ChatLandShareQuickSeatComponent$onClick$1
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
                SquareFragment squareFragment;
                VasSquareFragmentSquareBinding binding;
                LinearLayout linearLayout;
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                squareFragment = ChatLandShareQuickSeatComponent.this.getSquareFragment();
                if (squareFragment == null || (binding = squareFragment.getBinding()) == null || (linearLayout = binding.quickSeatBtn) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(linearLayout, "squareFragment?.binding?\u2026eatBtn ?: return@postOnUi");
                squareReporter.reportEvent("clck", linearLayout, new LinkedHashMap());
            }
        });
    }

    @Override // com.tencent.state.square.chatland.component.share.ChatLandShareBaseComponent
    public void onEnterRoom(EnterRoomInfo info) {
        List<QuickSeatTable> quickSeatTables;
        VasSquareFragmentSquareBinding binding;
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(info, "info");
        CommonRoomInfo room = info.getRoom();
        if (room != null) {
            int appId = room.getAppId();
            RoomThemeData theme = info.getRoom().getTheme();
            if (theme == null || (quickSeatTables = theme.getQuickSeatTables()) == null || quickSeatTables.isEmpty()) {
                return;
            }
            synchronized (this.quickSeatTables) {
                this.quickSeatTables.put(Integer.valueOf(appId), quickSeatTables);
                Unit unit = Unit.INSTANCE;
            }
            showQuickSeatButton();
            SquareFragment squareFragment = getSquareFragment();
            if (squareFragment == null || (binding = squareFragment.getBinding()) == null || (linearLayout = binding.quickSeatBtn) == null) {
                return;
            }
            linearLayout.setOnClickListener(this);
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        VasSquareFragmentSquareBinding binding;
        LinearLayout it;
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        super.onFragmentViewCreated(fm5, f16, v3, savedInstanceState);
        SquareFragment squareFragment = getSquareFragment();
        if (squareFragment == null || (binding = squareFragment.getBinding()) == null || (it = binding.quickSeatBtn) == null) {
            return;
        }
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        squareReporter.setElementInfo(it, SquareReportConst.ElementId.ELEMENT_ID_CHAT_LAND_ZPLAN_QUICK_SEAT_BTN, new LinkedHashMap(), false, false);
    }

    @Override // com.tencent.state.square.chatland.component.share.ChatLandShareBaseComponent
    public void onMeFocusEnd() {
        showQuickSeatButton();
    }

    @Override // com.tencent.state.square.chatland.component.share.ChatLandShareBaseComponent
    public void onMeFocusStart(User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        hideQuickSeatButton();
    }
}

package com.tencent.state.square.components.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.map.IMapViewListener;
import com.tencent.state.map.IMapViewManipulator;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapViewConfig;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.data.SquareAnchorEntrance;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\r\u0010\n\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u000bJ\r\u0010\f\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u000bJ\r\u0010\r\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u000bJ$\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015J,\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J<\u0010\u001f\u001a\u00020\t2\u000e\u0010 \u001a\n\u0012\u0002\b\u00030!j\u0002`\"2\u0006\u0010#\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00132\u0006\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010'H\u0016R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0005\u00a8\u0006)"}, d2 = {"Lcom/tencent/state/square/components/fragment/SquareStatusComponent;", "Lcom/tencent/state/square/components/fragment/SquareBaseComponent;", "()V", "actionId", "", "Ljava/lang/Integer;", "curRichStatusId", "curStatusId", "clearStatus", "", "getActionId", "()Ljava/lang/Integer;", "getRichStatusId", "getStatusId", "initialize", DownloadInfo.spKey_Config, "Lcom/tencent/state/map/MapViewConfig;", "dataList", "", "Lcom/tencent/state/map/MapItem;", "mapViewListener", "Lcom/tencent/state/map/IMapViewListener;", "onFragmentViewCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/Fragment;", "v", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onItemClicked", "vh", "Lcom/tencent/state/map/MapViewHolder;", "Lcom/tencent/state/map/ViewHolder;", "index", "data", "viewId", "extra", "", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareStatusComponent extends SquareBaseComponent {
    private static final String ACTION_ID = "actionId";
    private static final int NOT_FOUNT = -1;
    private static final String OLD_RICH_STATUS_ID = "rich_status_id";
    private static final String OLD_STATUS_ID = "status_id";
    private static final String RICH_STATUS_ID = "richStatusId";
    private static final String STATUS_ID = "statusId";
    private static final String TAG = "SquareStatusComponent";
    private Integer actionId;
    private Integer curRichStatusId;
    private Integer curStatusId;

    public final Integer getActionId() {
        return this.actionId;
    }

    /* renamed from: getRichStatusId, reason: from getter */
    public final Integer getCurRichStatusId() {
        return this.curRichStatusId;
    }

    /* renamed from: getStatusId, reason: from getter */
    public final Integer getCurStatusId() {
        return this.curStatusId;
    }

    public final void initialize(MapViewConfig config, List<? extends MapItem> dataList, IMapViewListener mapViewListener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(mapViewListener, "mapViewListener");
        Integer num = this.curStatusId;
        if (num != null) {
            final int intValue = num.intValue();
            Integer num2 = this.curRichStatusId;
            if (num2 != null) {
                final int intValue2 = num2.intValue();
                SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareStatusComponent$initialize$$inlined$let$lambda$1
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
                        SquareAnchorEntrance squareAnchorEntrance = new SquareAnchorEntrance(0.0f, 0.0f, 0.0f, 0.0f, null, 0, 0, false, null, 511, null);
                        squareAnchorEntrance.setStatus(intValue);
                        squareAnchorEntrance.setRichStatus(intValue2);
                        SquareView mapView = this.getMapView();
                        if (mapView != null) {
                            mapView.openMeDetail(8, squareAnchorEntrance);
                        }
                    }
                });
            }
        }
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intent intent;
        String stringExtra;
        Intent intent2;
        String stringExtra2;
        Intent intent3;
        String stringExtra3;
        Intent intent4;
        Intent intent5;
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        QBaseActivity activity = getActivity();
        Integer num = null;
        Integer valueOf = (activity == null || (intent5 = activity.getIntent()) == null) ? null : Integer.valueOf(intent5.getIntExtra("status_id", -1));
        QBaseActivity activity2 = getActivity();
        Integer valueOf2 = (activity2 == null || (intent4 = activity2.getIntent()) == null) ? null : Integer.valueOf(intent4.getIntExtra(OLD_RICH_STATUS_ID, -1));
        if (valueOf != null && valueOf.intValue() == -1 && valueOf2 != null && valueOf2.intValue() == -1) {
            QBaseActivity activity3 = getActivity();
            valueOf = (activity3 == null || (intent3 = activity3.getIntent()) == null || (stringExtra3 = intent3.getStringExtra("statusId")) == null) ? null : StringsKt__StringNumberConversionsKt.toIntOrNull(stringExtra3);
            QBaseActivity activity4 = getActivity();
            valueOf2 = (activity4 == null || (intent2 = activity4.getIntent()) == null || (stringExtra2 = intent2.getStringExtra("richStatusId")) == null) ? null : StringsKt__StringNumberConversionsKt.toIntOrNull(stringExtra2);
        }
        if (valueOf != null && valueOf.intValue() == -1) {
            return;
        }
        if (valueOf2 != null && valueOf2.intValue() == -1) {
            return;
        }
        this.curStatusId = valueOf;
        this.curRichStatusId = valueOf2;
        QBaseActivity activity5 = getActivity();
        if (activity5 != null && (intent = activity5.getIntent()) != null && (stringExtra = intent.getStringExtra("actionId")) != null) {
            num = StringsKt__StringNumberConversionsKt.toIntOrNull(stringExtra);
        }
        this.actionId = num;
    }

    @Override // com.tencent.state.square.components.fragment.SquareBaseComponent, com.tencent.state.map.IMapViewListener
    public void onItemClicked(MapViewHolder<?> vh5, int index, MapItem data, int viewId, final Object extra) {
        SquareView mapView;
        IMapViewManipulator manipulator;
        Intrinsics.checkNotNullParameter(vh5, "vh");
        if (viewId != 8) {
            if (viewId != 11 || (mapView = getMapView()) == null || (manipulator = mapView.getManipulator()) == null) {
                return;
            }
            IMapViewManipulator.DefaultImpls.locateToMe$default(manipulator, 0, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareStatusComponent$onItemClicked$1
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
                    SquareBaseKt.getSquareThread().postOnUiDelayed(300L, new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareStatusComponent$onItemClicked$1.1
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
                            SquareView mapView2 = SquareStatusComponent.this.getMapView();
                            if (mapView2 != null) {
                                mapView2.openMeDetail(8, extra);
                            }
                        }
                    });
                }
            }, 1, null);
            return;
        }
        if (extra instanceof SquareAnchorEntrance) {
            SquareAnchorEntrance squareAnchorEntrance = (SquareAnchorEntrance) extra;
            this.curStatusId = Integer.valueOf(squareAnchorEntrance.getStatus());
            this.curRichStatusId = Integer.valueOf(squareAnchorEntrance.getRichStatus());
        }
    }

    public final void clearStatus() {
        this.curStatusId = null;
        this.curRichStatusId = null;
    }
}

package com.tencent.state.square.components.fragment;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.library.focus.FocusDialogTips;
import com.tencent.state.map.MapAdapter;
import com.tencent.state.map.MapData;
import com.tencent.state.map.MapItem;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.data.SquareEntranceItem;
import com.tencent.state.square.mmkv.IMMKV;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareLibraryComponent$locateToLibraryAndShowWelcome$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MapData $data;
    final /* synthetic */ SquareLibraryComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareLibraryComponent$locateToLibraryAndShowWelcome$1(SquareLibraryComponent squareLibraryComponent, MapData mapData) {
        super(0);
        this.this$0 = squareLibraryComponent;
        this.$data = mapData;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        VasBaseFragment fragment;
        SquareView mapView;
        IReporter iReporter;
        Map<String, Object> mutableMapOf;
        fragment = this.this$0.getFragment();
        Object obj = null;
        if (!(fragment instanceof SquareFragment)) {
            fragment = null;
        }
        SquareFragment squareFragment = (SquareFragment) fragment;
        if (squareFragment == null || (mapView = squareFragment.getMapView()) == null) {
            return;
        }
        Iterator<T> it = this.$data.getDataList().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            MapItem mapItem = (MapItem) next;
            if ((mapItem instanceof SquareEntranceItem) && ((SquareEntranceItem) mapItem).getEntranceType() == 2) {
                obj = next;
                break;
            }
        }
        MapItem mapItem2 = (MapItem) obj;
        if (mapItem2 != null) {
            MapAdapter adapter = mapView.getAdapter();
            int indexOf = adapter != null ? adapter.indexOf(mapItem2) : -1;
            if (indexOf < 0) {
                return;
            }
            mapView.getManipulator().locateTo(indexOf, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareLibraryComponent$locateToLibraryAndShowWelcome$1.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    FocusDialogTips focusDialogTips;
                    QBaseActivity activity;
                    focusDialogTips = SquareLibraryComponent$locateToLibraryAndShowWelcome$1.this.this$0.focusDialog;
                    activity = SquareLibraryComponent$locateToLibraryAndShowWelcome$1.this.this$0.getActivity();
                    focusDialogTips.showLibraryWelcomeTip(activity, new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.components.fragment.SquareLibraryComponent.locateToLibraryAndShowWelcome.1.1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z17) {
                            IReporter iReporter2;
                            Map<String, Object> mutableMapOf2;
                            if (z17) {
                                SquareLibraryComponent.gotoLibrary$default(SquareLibraryComponent$locateToLibraryAndShowWelcome$1.this.this$0, null, 1, 1, null);
                            }
                            iReporter2 = SquareLibraryComponent$locateToLibraryAndShowWelcome$1.this.this$0.reporter;
                            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "click"), TuplesKt.to(SquareReportConst.Key.KEY_END_POP_WINDOW_BTN, Integer.valueOf(!z17 ? 1 : 0)), TuplesKt.to("zplan_event_source_parameters", 1));
                            iReporter2.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_LIBRARY_POPUP_WINDOW, mutableMapOf2);
                        }
                    });
                    IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Library.HAS_SHOW_LIBRARY_WELCOME_TIPS, true, null, false, 12, null);
                }
            });
            iReporter = this.this$0.reporter;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "imp"), TuplesKt.to("zplan_event_source_parameters", 1));
            iReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_LIBRARY_POPUP_WINDOW, mutableMapOf);
        }
    }
}

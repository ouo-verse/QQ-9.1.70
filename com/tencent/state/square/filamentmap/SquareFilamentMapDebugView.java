package com.tencent.state.square.filamentmap;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.state.SquareDebug;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.map.v2.IMapListener;
import com.tencent.state.map.v2.IMapObject;
import com.tencent.state.map.v2.ObjectState;
import com.tencent.state.map.v2.ViewportInfo;
import com.tencent.state.map.v2.filament.FilamentMap;
import com.tencent.state.square.SquareBaseKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0006\u0010\u000f\u001a\u00020\u000eR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/square/filamentmap/SquareFilamentMapDebugView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "filamentMap", "Lcom/tencent/state/map/v2/filament/FilamentMap;", "(Landroid/content/Context;Lcom/tencent/state/map/v2/filament/FilamentMap;)V", ParseCommon.CONTAINER, "Landroid/widget/LinearLayout;", "getContainer", "()Landroid/widget/LinearLayout;", "getFilamentMap", "()Lcom/tencent/state/map/v2/filament/FilamentMap;", NodeProps.ON_ATTACHED_TO_WINDOW, "", "refreshData", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareFilamentMapDebugView extends FrameLayout {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final LinearLayout container;
    private final FilamentMap filamentMap;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/square/filamentmap/SquareFilamentMapDebugView$Companion;", "", "()V", "init", "", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/widget/FrameLayout;", "filamentMap", "Lcom/tencent/state/map/v2/filament/FilamentMap;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final void init(FrameLayout parent, FilamentMap filamentMap) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(filamentMap, "filamentMap");
            if (SquareDebug.INSTANCE.getEnableFilamentIndexDebug()) {
                Context context = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                parent.addView(new SquareFilamentMapDebugView(context, filamentMap), new FrameLayout.LayoutParams(-2, -2));
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareFilamentMapDebugView(Context context, FilamentMap filamentMap) {
        super(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filamentMap, "filamentMap");
        this.filamentMap = filamentMap;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        Unit unit = Unit.INSTANCE;
        this.container = linearLayout;
        setBackgroundColor(251723520);
        addView(linearLayout, new FrameLayout.LayoutParams(-2, -2));
        filamentMap.addMapListener(new IMapListener() { // from class: com.tencent.state.square.filamentmap.SquareFilamentMapDebugView.1
            @Override // com.tencent.state.map.v2.IMapListener
            public void onMapReady() {
                SquareFilamentMapDebugView.this.refreshData();
            }

            @Override // com.tencent.state.map.v2.IMapListener
            public void onObjectStateChanged(String id5, ObjectState state) {
                Intrinsics.checkNotNullParameter(id5, "id");
                Intrinsics.checkNotNullParameter(state, "state");
                SquareFilamentMapDebugView.this.refreshData();
            }

            @Override // com.tencent.state.map.v2.IMapListener
            public void onViewportChanged(ViewportInfo info) {
                Intrinsics.checkNotNullParameter(info, "info");
            }

            @Override // com.tencent.state.map.v2.IMapListener
            public void onEngineRenderRecovered() {
            }
        });
    }

    public final LinearLayout getContainer() {
        return this.container;
    }

    public final FilamentMap getFilamentMap() {
        return this.filamentMap;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewExtensionsKt.updateLayoutParams(this, new Function1<FrameLayout.LayoutParams, Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentMapDebugView$onAttachedToWindow$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FrameLayout.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FrameLayout.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.topMargin = com.tencent.state.square.common.ViewExtensionsKt.dip(SquareFilamentMapDebugView.this.getContext(), 100);
            }
        });
    }

    public final void refreshData() {
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.filamentmap.SquareFilamentMapDebugView$refreshData$1
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
                SquareFilamentMapDebugView.this.getContainer().removeAllViews();
                List<IMapObject> allObjects = SquareFilamentMapDebugView.this.getFilamentMap().getAllObjects();
                TextView textView = new TextView(SquareFilamentMapDebugView.this.getContext());
                textView.setText("\u5171\u8ba1 " + allObjects.size() + " \u4e2a\u5bf9\u8c61");
                SquareFilamentMapDebugView.this.getContainer().addView(textView);
                for (IMapObject iMapObject : allObjects) {
                    TextView textView2 = new TextView(SquareFilamentMapDebugView.this.getContext());
                    textView2.setText(iMapObject.getObjectParams().getId() + " \u72b6\u6001:" + iMapObject.getState() + " \u64ad\u653e:" + iMapObject.getIsPlaying());
                    SquareFilamentMapDebugView.this.getContainer().addView(textView2);
                }
            }
        });
    }
}

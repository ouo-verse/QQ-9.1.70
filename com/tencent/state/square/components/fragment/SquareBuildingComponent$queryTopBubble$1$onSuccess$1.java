package com.tencent.state.square.components.fragment;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.state.map.IMapViewManipulator;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ImageService;
import com.tencent.state.service.VasSquareBuildingBubbleService;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.SquareView;
import com.tencent.state.square.data.SquareEntranceItem;
import com.tencent.state.square.databinding.VasSquareFragmentSquareBinding;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import st4.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareBuildingComponent$queryTopBubble$1$onSuccess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SquareEntranceItem $building;
    final /* synthetic */ int $buildingId;
    final /* synthetic */ a $tipsBubble;
    final /* synthetic */ SquareBuildingComponent$queryTopBubble$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareBuildingComponent$queryTopBubble$1$onSuccess$1(SquareBuildingComponent$queryTopBubble$1 squareBuildingComponent$queryTopBubble$1, SquareEntranceItem squareEntranceItem, a aVar, int i3) {
        super(0);
        this.this$0 = squareBuildingComponent$queryTopBubble$1;
        this.$building = squareEntranceItem;
        this.$tipsBubble = aVar;
        this.$buildingId = i3;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding;
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding2;
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding3;
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding4;
        LinearLayout it;
        Map<String, Object> mutableMapOf;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        TextView textView;
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding5;
        VasSquareFragmentSquareBinding vasSquareFragmentSquareBinding6;
        if (this.$building.getSmallIcon() != null) {
            ImageService.Companion companion = ImageService.INSTANCE;
            ImageLoader loader = companion.getLoader();
            if (loader != null) {
                vasSquareFragmentSquareBinding6 = this.this$0.this$0.binding;
                loader.cancelDisplayTask(vasSquareFragmentSquareBinding6 != null ? vasSquareFragmentSquareBinding6.topTipsBubbleIcon : null);
            }
            ImageLoader loader2 = companion.getLoader();
            if (loader2 != null) {
                String smallIcon = this.$building.getSmallIcon();
                vasSquareFragmentSquareBinding5 = this.this$0.this$0.binding;
                loader2.displayImage(smallIcon, vasSquareFragmentSquareBinding5 != null ? vasSquareFragmentSquareBinding5.topTipsBubbleIcon : null, companion.getUniqueImageOptions(this.$building.getSmallIcon()), new SimpleImageLoadingListener() { // from class: com.tencent.state.square.components.fragment.SquareBuildingComponent$queryTopBubble$1$onSuccess$1$1$1
                    @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        if (view != null) {
                            view.setVisibility(0);
                        }
                    }
                });
            }
        }
        vasSquareFragmentSquareBinding = this.this$0.this$0.binding;
        if (vasSquareFragmentSquareBinding != null && (textView = vasSquareFragmentSquareBinding.topTipsBubbleText) != null) {
            textView.setText(this.$tipsBubble.f434738d);
        }
        vasSquareFragmentSquareBinding2 = this.this$0.this$0.binding;
        if (vasSquareFragmentSquareBinding2 != null && (linearLayout2 = vasSquareFragmentSquareBinding2.topTipsBubble) != null) {
            linearLayout2.setVisibility(0);
        }
        vasSquareFragmentSquareBinding3 = this.this$0.this$0.binding;
        if (vasSquareFragmentSquareBinding3 != null && (linearLayout = vasSquareFragmentSquareBinding3.topTipsBubble) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.square.components.fragment.SquareBuildingComponent$queryTopBubble$1$onSuccess$1.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View it5) {
                    Map<String, Object> mutableMapOf2;
                    SquareView mapView;
                    IMapViewManipulator manipulator;
                    SquareFragment squareFragment = SquareBuildingComponent$queryTopBubble$1$onSuccess$1.this.this$0.this$0.getSquareFragment();
                    if (squareFragment != null && (mapView = squareFragment.getMapView()) != null && (manipulator = mapView.getManipulator()) != null) {
                        IMapViewManipulator.DefaultImpls.locateTo$default(manipulator, SquareBuildingComponent$queryTopBubble$1$onSuccess$1.this.$building.getUin(), null, 2, null);
                    }
                    SquareBuildingComponent$queryTopBubble$1$onSuccess$1.this.this$0.this$0.consumedTipsBubble();
                    VasSquareBuildingBubbleService vasSquareBuildingBubbleService = VasSquareBuildingBubbleService.INSTANCE;
                    SquareBuildingComponent$queryTopBubble$1$onSuccess$1 squareBuildingComponent$queryTopBubble$1$onSuccess$1 = SquareBuildingComponent$queryTopBubble$1$onSuccess$1.this;
                    int i3 = squareBuildingComponent$queryTopBubble$1$onSuccess$1.$buildingId;
                    a aVar = squareBuildingComponent$queryTopBubble$1$onSuccess$1.$tipsBubble;
                    int i16 = aVar.f434735a;
                    String str = aVar.f434736b;
                    Intrinsics.checkNotNullExpressionValue(str, "tipsBubble.bubbleId");
                    VasSquareBuildingBubbleService.delBuildingBubbles$default(vasSquareBuildingBubbleService, i3, i16, str, 1, null, 16, null);
                    SquareBaseKt.getSquareThread().postOnUiDelayed(500L, new Function0<Unit>() { // from class: com.tencent.state.square.components.fragment.SquareBuildingComponent.queryTopBubble.1.onSuccess.1.2.1
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
                            QBaseActivity activity;
                            QBaseActivity activity2;
                            boolean z16;
                            SquareFragment squareFragment2;
                            SquareView mapView2;
                            activity = SquareBuildingComponent$queryTopBubble$1$onSuccess$1.this.this$0.this$0.getActivity();
                            if (activity == null || !activity.isFinishing()) {
                                activity2 = SquareBuildingComponent$queryTopBubble$1$onSuccess$1.this.this$0.this$0.getActivity();
                                if (activity2 == null || !activity2.isDestroyed()) {
                                    z16 = SquareBuildingComponent$queryTopBubble$1$onSuccess$1.this.this$0.this$0.enable;
                                    if (!z16 || (squareFragment2 = SquareBuildingComponent$queryTopBubble$1$onSuccess$1.this.this$0.this$0.getSquareFragment()) == null || (mapView2 = squareFragment2.getMapView()) == null) {
                                        return;
                                    }
                                    mapView2.performItemViewClick(SquareBuildingComponent$queryTopBubble$1$onSuccess$1.this.$building.getUin(), Integer.valueOf(R.id.ps9));
                                }
                            }
                        }
                    });
                    int i17 = SquareBuildingComponent$queryTopBubble$1$onSuccess$1.this.$tipsBubble.f434735a;
                    int i18 = i17 != 1 ? i17 != 2 ? -1 : 0 : 1;
                    IReporter squareReporter = SquareBaseKt.getSquareReporter();
                    Intrinsics.checkNotNullExpressionValue(it5, "it");
                    mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_BUBBLE_TYPE, Integer.valueOf(i18)), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_BUILDING_ID, Integer.valueOf(SquareBuildingComponent$queryTopBubble$1$onSuccess$1.this.$buildingId)));
                    squareReporter.reportEvent("clck", it5, mutableMapOf2);
                }
            });
        }
        vasSquareFragmentSquareBinding4 = this.this$0.this$0.binding;
        if (vasSquareFragmentSquareBinding4 == null || (it = vasSquareFragmentSquareBinding4.topTipsBubble) == null) {
            return;
        }
        int i3 = this.$tipsBubble.f434735a;
        int i16 = i3 != 1 ? i3 != 2 ? -1 : 0 : 1;
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_BUBBLE_TYPE, Integer.valueOf(i16)), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_BUILDING_ID, Integer.valueOf(this.$buildingId)));
        squareReporter.reportEvent("imp", it, mutableMapOf);
    }
}

package com.tencent.mobileqq.nearbypro.map.debug;

import android.app.Activity;
import android.graphics.Point;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.map.part.i;
import com.tencent.mobileqq.nearbypro.part.e;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.collection.FPSCalculator;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import xa2.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u0011\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/nearbypro/map/debug/d;", "Lcom/tencent/mobileqq/nearbypro/part/e;", "Lcom/tencent/qqperf/collection/FPSCalculator$GetFPSListener;", "", "initView", "", "G9", "Lcom/tencent/tencentmap/mapsdk/maps/model/CameraPosition;", com.tencent.luggage.wxa.c8.c.G, "H9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartStop", "onPartDestroy", "Lxa2/g;", "f", "Lxa2/g;", "binding", h.F, "Z", "forceShow", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d extends e implements FPSCalculator.GetFPSListener {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g binding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean forceShow;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QPublicFragmentActivity.start(this$0.getActivity(), MainDebugFragment.class);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean G9() {
        if (!this.forceShow && !j.a().debug()) {
            return false;
        }
        return true;
    }

    private final void H9(CameraPosition pos) {
        TextView textView;
        TencentMap a16;
        TextView textView2;
        g gVar = this.binding;
        if (gVar != null && (textView2 = gVar.f447596d) != null) {
            textView2.setText("zoom:" + pos.zoom);
        }
        g gVar2 = this.binding;
        if (gVar2 != null && (textView = gVar2.f447595c) != null && (a16 = i.INSTANCE.a(this)) != null) {
            LatLng target = a16.getProjection().fromScreenLocation(new Point(0, ImmersiveUtils.getScreenHeight() / 2));
            ab2.a aVar = ab2.a.f25767a;
            Intrinsics.checkNotNullExpressionValue(target, "target");
            LatLng latLng = pos.target;
            Intrinsics.checkNotNullExpressionValue(latLng, "pos.target");
            textView.setText("dis(m):" + ((int) aVar.b(target, latLng)));
        }
    }

    private final void initView() {
        View view;
        TextView textView;
        ViewStub viewStub;
        if (this.binding == null && G9()) {
            View partRootView = getPartRootView();
            if (partRootView != null && (viewStub = (ViewStub) partRootView.findViewById(R.id.uew)) != null) {
                view = viewStub.inflate();
            } else {
                view = null;
            }
            Intrinsics.checkNotNull(view);
            g e16 = g.e(view);
            this.binding = e16;
            if (e16 != null && (textView = e16.f447594b) != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.map.debug.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        d.F9(d.this, view2);
                    }
                });
            }
            FPSCalculator.getInstance().addListener(this);
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "MSG_SHOW_FPS_ACTION")) {
            this.forceShow = true;
            initView();
        } else if (Intrinsics.areEqual(action, "MSG_ON_CAMERA_ZOOM_UPDATE")) {
            Intrinsics.checkNotNull(args, "null cannot be cast to non-null type com.tencent.tencentmap.mapsdk.maps.model.CameraPosition");
            H9((CameraPosition) args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        initView();
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        if (!G9()) {
            return;
        }
        FPSCalculator.getInstance().removeListener(this);
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        if (!G9()) {
            return;
        }
        FPSCalculator.getInstance().addListener(this);
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void onPartStop(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartStop(activity);
        if (!G9()) {
            return;
        }
        FPSCalculator.getInstance().removeListener(this);
    }
}

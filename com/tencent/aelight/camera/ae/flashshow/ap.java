package com.tencent.aelight.camera.ae.flashshow;

import android.app.Activity;
import android.view.View;
import com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraPreviewPart;
import com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraTipPart;
import com.tencent.aelight.camera.ae.flashshow.ui.multicamera.AECameraMultiCameraTopPart;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0007B\u001f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0014R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ap;", "Llq/b;", "", "", "e", "whichPart", "", "a", "Landroid/app/Activity;", "g", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", tl.h.F, "Landroid/view/View;", "getRootView", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/aelight/camera/ae/flashshow/LSBaseCameraUnit;", "i", "Lcom/tencent/aelight/camera/ae/flashshow/LSBaseCameraUnit;", "getUnit", "()Lcom/tencent/aelight/camera/ae/flashshow/LSBaseCameraUnit;", "unit", "<init>", "(Landroid/app/Activity;Landroid/view/View;Lcom/tencent/aelight/camera/ae/flashshow/LSBaseCameraUnit;)V", "j", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class ap extends lq.b {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final View rootView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final LSBaseCameraUnit unit;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(Activity activity, View rootView, LSBaseCameraUnit unit) {
        super(activity, rootView, unit);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.activity = activity;
        this.rootView = rootView;
        this.unit = unit;
    }

    @Override // lq.b
    protected void a(int whichPart) {
        lq.a aECameraMultiCameraTopPart;
        switch (whichPart) {
            case 917505:
                Activity mActivity = this.f415380a;
                Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
                View mRootView = this.f415382c;
                Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
                aECameraMultiCameraTopPart = new AECameraMultiCameraTopPart(mActivity, mRootView, this);
                break;
            case 917506:
                Activity mActivity2 = this.f415380a;
                Intrinsics.checkNotNullExpressionValue(mActivity2, "mActivity");
                View mRootView2 = this.f415382c;
                Intrinsics.checkNotNullExpressionValue(mRootView2, "mRootView");
                aECameraMultiCameraTopPart = new com.tencent.aelight.camera.ae.flashshow.ui.multicamera.i(mActivity2, mRootView2, this);
                break;
            case 917507:
                Activity mActivity3 = this.f415380a;
                Intrinsics.checkNotNullExpressionValue(mActivity3, "mActivity");
                View mRootView3 = this.f415382c;
                Intrinsics.checkNotNullExpressionValue(mRootView3, "mRootView");
                aECameraMultiCameraTopPart = new AECameraMultiCameraPreviewPart(mActivity3, mRootView3, this);
                break;
            case 917508:
                Activity mActivity4 = this.f415380a;
                Intrinsics.checkNotNullExpressionValue(mActivity4, "mActivity");
                View mRootView4 = this.f415382c;
                Intrinsics.checkNotNullExpressionValue(mRootView4, "mRootView");
                aECameraMultiCameraTopPart = new AECameraMultiCameraTipPart(mActivity4, mRootView4, this);
                break;
            default:
                aECameraMultiCameraTopPart = null;
                break;
        }
        if (aECameraMultiCameraTopPart != null) {
            Map<Integer, lq.a> mParts = this.f415383d;
            Intrinsics.checkNotNullExpressionValue(mParts, "mParts");
            mParts.put(Integer.valueOf(whichPart), aECameraMultiCameraTopPart);
        }
    }

    @Override // lq.b
    protected Set<Integer> e() {
        HashSet hashSet = new HashSet();
        hashSet.add(917505);
        hashSet.add(917506);
        hashSet.add(917508);
        hashSet.add(917507);
        return hashSet;
    }
}

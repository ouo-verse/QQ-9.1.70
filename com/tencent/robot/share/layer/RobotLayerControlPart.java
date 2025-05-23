package com.tencent.robot.share.layer;

import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicLoadState;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import com.tencent.robot.share.layer.RobotLayerControlPart;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/robot/share/layer/RobotLayerControlPart;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "updateLayerState", "", "d", "Z", "mIsAddObserver", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicLoadState;", "e", "Lkotlin/Lazy;", "x9", "()Landroidx/lifecycle/Observer;", "mObserver", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotLayerControlPart extends RFWLayerBasePart {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsAddObserver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mObserver;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/share/layer/RobotLayerControlPart$a;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicLoadState;", "layerPicLoadState", "", "a", "<init>", "(Lcom/tencent/robot/share/layer/RobotLayerControlPart;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public final class a implements Observer<RFWLayerPicLoadState> {
        public a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@NotNull RFWLayerPicLoadState layerPicLoadState) {
            String str;
            RFWLayerPicInfo layerPicInfo;
            Intrinsics.checkNotNullParameter(layerPicLoadState, "layerPicLoadState");
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = RobotLayerControlPart.this.mCurrentSelectedItem;
            if (rFWLayerItemMediaInfo != null && (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) != null) {
                str = layerPicInfo.getPicId();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(layerPicLoadState.getPicId(), str)) {
                if (layerPicLoadState.getPicLoadState().isFinishSuccess()) {
                    RobotLayerControlPart.this.broadcastMessage("robot_layer_pic_load_finish", Boolean.TRUE);
                }
                if (layerPicLoadState.getPicLoadState().isFinishError()) {
                    RobotLayerControlPart.this.broadcastMessage("robot_layer_pic_load_finish", Boolean.FALSE);
                }
            }
        }
    }

    public RobotLayerControlPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.robot.share.layer.RobotLayerControlPart$mObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RobotLayerControlPart.a invoke() {
                return new RobotLayerControlPart.a();
            }
        });
        this.mObserver = lazy;
    }

    private final Observer<RFWLayerPicLoadState> x9() {
        return (Observer) this.mObserver.getValue();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        RFWLayerIOCUtil.registerPicLoader(rootView, QQPicLoader.f201806a.d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart
    public void updateLayerState(@NotNull RFWLayerState layerState) {
        RFWLayerPicInfo layerPicInfo;
        String picId;
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.updateLayerState(layerState);
        if (!this.mIsAddObserver) {
            this.mIsAddObserver = true;
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
            if (rFWLayerItemMediaInfo != null && (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) != null && (picId = layerPicInfo.getPicId()) != null) {
                RFWLayerDataCenter.INSTANCE.observerGlobalState(RFWLayerPicLoadState.class, picId, x9());
            }
        }
    }
}

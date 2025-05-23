package com.tencent.hippy.qq.view.tkd.image;

import android.content.Context;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.views.image.HippyImageView;
import com.tencent.mtt.hippy.views.image.HippyImageViewController;

/* compiled from: P */
@HippyController(name = "Image")
/* loaded from: classes7.dex */
public class HippyTKDImageViewController extends HippyImageViewController {
    public static final String COMMAND_PAUSE = "pause";
    public static final String COMMAND_START_PLAY = "startPlay";
    private static final String TAG = "TKDImageViewController";

    @Override // com.tencent.mtt.hippy.views.image.HippyImageViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyTKDImageView(context);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "blurRadius")
    public void setBlurRadius(HippyImageView hippyImageView, int i3) {
        if (hippyImageView instanceof HippyTKDImageView) {
            ((HippyTKDImageView) hippyImageView).setBlurRadius(i3);
        }
    }

    @HippyControllerProps(defaultType = "map", name = "clipInfo")
    public void setClipInfo(HippyImageView hippyImageView, HippyMap hippyMap) {
        if (hippyImageView instanceof HippyTKDImageView) {
            ((HippyTKDImageView) hippyImageView).setClipInfo(hippyMap);
        }
    }

    @HippyControllerProps(name = "fitSystemRotation")
    public void setFitSystemRotation(HippyImageView hippyImageView, boolean z16) {
        if (hippyImageView instanceof HippyTKDImageView) {
            ((HippyTKDImageView) hippyImageView).setFitSystemRotation(z16);
        }
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = HippyTKDImageView.EXTRA_REQUEST_GIF_ENABLED)
    public void setGifEnabled(HippyImageView hippyImageView, boolean z16) {
        if (hippyImageView instanceof HippyTKDImageView) {
            ((HippyTKDImageView) hippyImageView).setGifEnabled(z16);
        }
    }

    @HippyControllerProps(name = "nightMode")
    public void setNightMode(HippyImageView hippyImageView, HippyMap hippyMap) {
        if (hippyImageView instanceof HippyTKDImageView) {
            ((HippyTKDImageView) hippyImageView).setNightModeOption(hippyMap);
        }
    }

    @HippyControllerProps(name = "noPicMode")
    public void setNoPicMode(HippyImageView hippyImageView, HippyMap hippyMap) {
        if (hippyImageView instanceof HippyTKDImageView) {
            ((HippyTKDImageView) hippyImageView).setNoPicModeOption(hippyMap);
        }
    }

    @HippyControllerProps(defaultType = "map", name = "reportData")
    public void setReportData(HippyImageView hippyImageView, HippyMap hippyMap) {
        if (hippyImageView instanceof HippyTKDImageView) {
            ((HippyTKDImageView) hippyImageView).setReportData(hippyMap);
        }
    }

    @HippyControllerProps(name = "srcs")
    public void setSrcs(HippyImageView hippyImageView, HippyArray hippyArray) {
        if (hippyImageView instanceof HippyTKDImageView) {
            ((HippyTKDImageView) hippyImageView).setSources(hippyArray);
        }
    }

    @HippyControllerProps(name = "tintColors")
    public void setTintColors(HippyImageView hippyImageView, HippyArray hippyArray) {
        if (hippyImageView instanceof HippyTKDImageView) {
            ((HippyTKDImageView) hippyImageView).setTintColors(hippyArray);
        }
    }

    @HippyControllerProps(defaultBoolean = false, defaultType = HippyControllerProps.BOOLEAN, name = HippyTKDImageView.EXTRA_REQUEST_USE_THUMBNAIL)
    public void setUseThumbnail(HippyImageView hippyImageView, boolean z16) {
        if (hippyImageView instanceof HippyTKDImageView) {
            ((HippyTKDImageView) hippyImageView).setUseThumbnail(z16);
        }
    }

    @HippyControllerProps(name = "pointsForCrop")
    public void setpointsForCrop(HippyImageView hippyImageView, HippyArray hippyArray) {
        if (hippyImageView instanceof HippyTKDImageView) {
            ((HippyTKDImageView) hippyImageView).setpointsForCrop(hippyArray);
        }
    }

    @Override // com.tencent.mtt.hippy.views.image.HippyImageViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        HippyTKDImageView hippyTKDImageView = new HippyTKDImageView(context);
        if (hippyMap != null) {
            hippyTKDImageView.setInitProps(hippyMap);
        }
        return hippyTKDImageView;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyImageView hippyImageView, String str, HippyArray hippyArray, Promise promise) {
        super.dispatchFunction((HippyTKDImageViewController) hippyImageView, str, hippyArray, promise);
        if ("startPlay".equals(str)) {
            hippyImageView.startPlay();
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushBoolean("result", true);
            promise.resolve(hippyMap);
            return;
        }
        if ("pause".equals(str)) {
            hippyImageView.pause();
            HippyMap hippyMap2 = new HippyMap();
            hippyMap2.pushBoolean("result", true);
            promise.resolve(hippyMap2);
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void setBackground(HippyImageView hippyImageView, int i3) {
        if (hippyImageView instanceof HippyTKDImageView) {
            HippyArray hippyArray = new HippyArray();
            hippyArray.pushInt(i3);
            ((HippyTKDImageView) hippyImageView).setBackgroundColors(hippyArray);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    @HippyControllerProps(name = NodeProps.CUSTOM_PROP)
    public void setCustomProp(HippyImageView hippyImageView, String str, Object obj) {
        if (hippyImageView instanceof HippyTKDCommonBorderHandler.HippyQBCommonBorder) {
            HippyTKDCommonBorderHandler.handleCommonBorderColor((HippyTKDCommonBorderHandler.HippyQBCommonBorder) hippyImageView, str, obj);
        }
    }
}

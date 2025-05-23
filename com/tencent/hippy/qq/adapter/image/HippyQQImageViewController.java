package com.tencent.hippy.qq.adapter.image;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.views.image.HippyImageView;
import com.tencent.mtt.hippy.views.image.HippyImageViewController;

/* compiled from: P */
@HippyController(name = "Image")
/* loaded from: classes7.dex */
public class HippyQQImageViewController extends HippyImageViewController {
    private static final String PROPS_BLUR_RADIUS = "blurRadius";
    private static final String TAG = "HippyQQImageViewControl";

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface FunctionName {
        public static final String PERFORMANCE_DATA_INFO = "performanceDataInfo";
    }

    private void handlePerformanceDataInfo(HippyImageView hippyImageView, Promise promise) {
        HippyImageInfo imageInfo;
        if (promise != null && (hippyImageView instanceof HippyQQImageView) && (imageInfo = ((HippyQQImageView) hippyImageView).getImageInfo()) != null) {
            promise.resolve(imageInfo.getPerformanceData().getData());
        }
    }

    @Override // com.tencent.mtt.hippy.views.image.HippyImageViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyQQImageView(context);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = PROPS_BLUR_RADIUS)
    public void setBlurRadius(HippyImageView hippyImageView, int i3) {
        if (hippyImageView instanceof HippyQQImageView) {
            ((HippyQQImageView) hippyImageView).setBlurRadius(i3);
        }
    }

    @Override // com.tencent.mtt.hippy.views.image.HippyImageViewController, com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        HippyQQImageView hippyQQImageView = new HippyQQImageView(context);
        if (hippyMap != null) {
            hippyQQImageView.setInitProps(hippyMap);
        }
        return hippyQQImageView;
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyImageView hippyImageView, String str, HippyArray hippyArray, Promise promise) {
        super.dispatchFunction((HippyQQImageViewController) hippyImageView, str, hippyArray, promise);
        if ("performanceDataInfo".equals(str)) {
            handlePerformanceDataInfo(hippyImageView, promise);
        }
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onViewDestroy(HippyImageView hippyImageView) {
        if (hippyImageView instanceof HippyQQImageView) {
            ((HippyQQImageView) hippyImageView).onViewDestroy();
        }
    }
}

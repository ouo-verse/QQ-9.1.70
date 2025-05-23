package com.tencent.mtt.hippy.views.image;

import android.content.Context;
import android.view.View;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.video.constants.HVideoConstants;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.ImageNode;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.views.image.HippyImageView;
import com.tencent.mtt.supportui.views.asyncimage.AsyncImageView;

/* compiled from: P */
@HippyController(name = "Image")
/* loaded from: classes20.dex */
public class HippyImageViewController extends HippyViewController<HippyImageView> {
    public static final String CLASS_NAME = "Image";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public StyleNode createNode(boolean z16) {
        return new ImageNode(z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyImageView(context);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "backgroundColor")
    public void setBackgroundColor(HippyImageView hippyImageView, int i3) {
        hippyImageView.setBackgroundColor(i3);
    }

    @HippyControllerProps(defaultType = "map", name = "capInsets")
    public void setCapInsets(HippyImageView hippyImageView, HippyMap hippyMap) {
        if (hippyMap == null) {
            hippyImageView.setNinePatchCoordinate(true, 0, 0, 0, 0);
            return;
        }
        int i3 = hippyMap.getInt("top");
        hippyImageView.setNinePatchCoordinate(false, hippyMap.getInt("left"), i3, hippyMap.getInt("right"), hippyMap.getInt("bottom"));
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "defaultSource")
    public void setDefaultSource(HippyImageView hippyImageView, String str) {
        hippyImageView.setHippyViewDefaultSource(getInnerPath((HippyInstanceContext) hippyImageView.getContext(), str));
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = NodeProps.CUSTOM_PROP_IMAGE_TYPE)
    public void setImageType(HippyImageView hippyImageView, String str) {
        hippyImageView.setImageType(str);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onError")
    public void setOnError(HippyImageView hippyImageView, boolean z16) {
        hippyImageView.setImageEventEnable(HippyImageView.ImageEvent.ONERROR.ordinal(), z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onLoad")
    public void setOnLoad(HippyImageView hippyImageView, boolean z16) {
        hippyImageView.setImageEventEnable(HippyImageView.ImageEvent.ONLOAD.ordinal(), z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = HippyQQPagView.EventName.ON_LOAD_END)
    public void setOnLoadEnd(HippyImageView hippyImageView, boolean z16) {
        hippyImageView.setImageEventEnable(HippyImageView.ImageEvent.ONLOAD_END.ordinal(), z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = HippyQQPagView.EventName.ON_LOAD_START)
    public void setOnLoadStart(HippyImageView hippyImageView, boolean z16) {
        hippyImageView.setImageEventEnable(HippyImageView.ImageEvent.ONLOAD_START.ordinal(), z16);
    }

    @HippyControllerProps(defaultString = "fitXY", defaultType = HippyControllerProps.STRING, name = NodeProps.RESIZE_MODE)
    public void setResizeMode(HippyImageView hippyImageView, String str) {
        AsyncImageView.ScaleType scaleType;
        if (HVideoConstants.ResizeType.RESIZE_CONTAIN.equals(str)) {
            scaleType = AsyncImageView.ScaleType.CENTER_INSIDE;
        } else if ("cover".equals(str)) {
            scaleType = AsyncImageView.ScaleType.CENTER_CROP;
        } else if ("center".equals(str)) {
            scaleType = AsyncImageView.ScaleType.CENTER;
        } else if (TtmlNode.ATTR_TTS_ORIGIN.equals(str)) {
            scaleType = AsyncImageView.ScaleType.ORIGIN;
        } else if ("repeat".equals(str)) {
            scaleType = AsyncImageView.ScaleType.REPEAT;
        } else {
            scaleType = AsyncImageView.ScaleType.FIT_XY;
        }
        hippyImageView.setScaleType(scaleType);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = "tintColor")
    public void setTintColor(HippyImageView hippyImageView, int i3) {
        hippyImageView.setTintColor(i3);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "src")
    public void setUrl(HippyImageView hippyImageView, String str) {
        hippyImageView.setUrl(getInnerPath((HippyInstanceContext) hippyImageView.getContext(), str));
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        HippyImageView hippyImageView = new HippyImageView(context);
        if (hippyMap != null) {
            hippyImageView.setInitProps(hippyMap);
        }
        return hippyImageView;
    }
}

package com.tencent.mtt.hippy.views.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.hippy.qq.view.video.constants.HVideoConstants;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.uimanager.HippyGroupController;
import com.tencent.mtt.hippy.uimanager.d;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.image.HippyImageView;
import com.tencent.mtt.supportui.views.asyncimage.AsyncImageView;
import java.util.WeakHashMap;

/* compiled from: P */
@HippyController(name = "View")
/* loaded from: classes20.dex */
public class HippyViewGroupController extends HippyGroupController<HippyViewGroup> {
    public static final String CLASS_NAME = "View";
    private static final String FUNC_SET_HOTSPOT = "setHotspot";
    private static final String FUNC_SET_PRESSED = "setPressed";
    private static final WeakHashMap<View, Integer> mZIndexHash = new WeakHashMap<>();

    public static Integer getViewZIndex(View view) {
        return mZIndexHash.get(view);
    }

    public static void removeViewZIndex(View view) {
        mZIndexHash.remove(view);
    }

    public static void setViewZIndex(View view, int i3) {
        mZIndexHash.put(view, Integer.valueOf(i3));
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyViewGroup(context);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "backgroundImage")
    public void setBackgroundImage(HippyViewGroup hippyViewGroup, String str) {
        hippyViewGroup.setUrl(getInnerPath((HippyInstanceContext) hippyViewGroup.getContext(), str));
    }

    @HippyControllerProps(defaultType = "number", name = NodeProps.BACKGROUND_POSITION_X)
    public void setBackgroundImagePositionX(HippyViewGroup hippyViewGroup, int i3) {
        hippyViewGroup.setImagePositionX((int) PixelUtil.dp2px(i3));
    }

    @HippyControllerProps(defaultType = "number", name = NodeProps.BACKGROUND_POSITION_Y)
    public void setBackgroundImagePositionY(HippyViewGroup hippyViewGroup, int i3) {
        hippyViewGroup.setImagePositionY((int) PixelUtil.dp2px(i3));
    }

    @HippyControllerProps(defaultString = TtmlNode.ATTR_TTS_ORIGIN, defaultType = HippyControllerProps.STRING, name = NodeProps.BACKGROUND_SIZE)
    public void setBackgroundImageSize(HippyImageView hippyImageView, String str) {
        AsyncImageView.ScaleType scaleType;
        if (HVideoConstants.ResizeType.RESIZE_CONTAIN.equals(str)) {
            scaleType = AsyncImageView.ScaleType.CENTER_INSIDE;
        } else if ("cover".equals(str)) {
            scaleType = AsyncImageView.ScaleType.CENTER_CROP;
        } else if ("center".equals(str)) {
            scaleType = AsyncImageView.ScaleType.CENTER;
        } else if (TtmlNode.ATTR_TTS_ORIGIN.equals(str)) {
            scaleType = AsyncImageView.ScaleType.ORIGIN;
        } else {
            scaleType = AsyncImageView.ScaleType.FIT_XY;
        }
        hippyImageView.setScaleType(scaleType);
    }

    @HippyControllerProps(defaultBoolean = true, defaultType = HippyControllerProps.BOOLEAN, name = "disallowInterceptTouchEvent")
    public void setDisallowIntercept(HippyViewGroup hippyViewGroup, boolean z16) {
        hippyViewGroup.setDisallowIntercept(z16);
    }

    @HippyControllerProps(defaultType = "map", name = NodeProps.BACKGROUND_RIPPLE)
    @RequiresApi(api = 23)
    public void setNativeBackground(HippyViewGroup hippyViewGroup, HippyMap hippyMap) {
        Drawable a16;
        if (hippyMap.size() > 0 && (a16 = d.a(d.a.DRAWABLE_TYPE_RIPPLE, hippyMap)) != null) {
            hippyViewGroup.setRippleDrawable(a16);
        }
    }

    @HippyControllerProps(defaultString = NodeProps.VISIBLE, defaultType = HippyControllerProps.STRING, name = "overflow")
    public void setOverflow(HippyViewGroup hippyViewGroup, String str) {
        hippyViewGroup.setOverflow(str);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(HippyViewGroup hippyViewGroup, String str, HippyArray hippyArray) {
        super.dispatchFunction((HippyViewGroupController) hippyViewGroup, str, hippyArray);
        str.hashCode();
        if (str.equals(FUNC_SET_PRESSED)) {
            hippyViewGroup.setPressed(hippyArray.getBoolean(0));
        } else if (str.equals(FUNC_SET_HOTSPOT)) {
            hippyViewGroup.drawableHotspotChanged(PixelUtil.dp2px(hippyArray.getDouble(0)), PixelUtil.dp2px(hippyArray.getDouble(1)));
        }
    }
}

package com.tencent.mtt.hippy.dom.node;

import com.tencent.mapsdk.internal.by;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.views.image.HippyImageView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ImageNode extends StyleNode {
    public static final String PROP_VERTICAL_ALIGNMENT = "verticalAlignment";
    private final boolean mIsVirtual;
    private c mImageSpan = null;
    private int mVerticalAlignment = 1;
    private ArrayList<String> mGestureTypes = null;
    private final boolean[] shouldSendImageEvent = new boolean[HippyImageView.ImageEvent.values().length];

    public ImageNode(boolean z16) {
        this.mIsVirtual = z16;
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.ON_CLICK)
    public void clickEnable(boolean z16) {
        if (z16) {
            if (this.mGestureTypes == null) {
                this.mGestureTypes = new ArrayList<>();
            }
            this.mGestureTypes.add(NodeProps.ON_CLICK);
        }
    }

    public ArrayList<String> getGestureTypes() {
        return this.mGestureTypes;
    }

    public int getVerticalAlignment() {
        return this.mVerticalAlignment;
    }

    public boolean isEnableImageEvent(HippyImageView.ImageEvent imageEvent) {
        return this.shouldSendImageEvent[imageEvent.ordinal()];
    }

    @Override // com.tencent.mtt.hippy.dom.node.b
    public boolean isVirtual() {
        return this.mIsVirtual;
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.ON_LONG_CLICK)
    public void longClickEnable(boolean z16) {
        if (z16) {
            if (this.mGestureTypes == null) {
                this.mGestureTypes = new ArrayList<>();
            }
            this.mGestureTypes.add(NodeProps.ON_LONG_CLICK);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.ON_PRESS_IN)
    public void pressInEnable(boolean z16) {
        if (z16) {
            if (this.mGestureTypes == null) {
                this.mGestureTypes = new ArrayList<>();
            }
            this.mGestureTypes.add(NodeProps.ON_PRESS_IN);
        }
    }

    @HippyControllerProps(name = NodeProps.ON_PRESS_OUT)
    public void pressOutEnable(boolean z16) {
        if (z16) {
            if (this.mGestureTypes == null) {
                this.mGestureTypes = new ArrayList<>();
            }
            this.mGestureTypes.add(NodeProps.ON_PRESS_OUT);
        }
    }

    public void setImageSpan(c cVar) {
        this.mImageSpan = cVar;
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onError")
    public void setOnError(boolean z16) {
        this.shouldSendImageEvent[HippyImageView.ImageEvent.ONERROR.ordinal()] = z16;
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onLoad")
    public void setOnLoadEnd(boolean z16) {
        this.shouldSendImageEvent[HippyImageView.ImageEvent.ONLOAD.ordinal()] = z16;
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "src")
    public void setUrl(String str) {
        c cVar = this.mImageSpan;
        if (cVar != null) {
            cVar.b(str);
        }
    }

    @HippyControllerProps(defaultNumber = by.f147964a, defaultType = "number", name = PROP_VERTICAL_ALIGNMENT)
    public void setVerticalAlignment(int i3) {
        this.mVerticalAlignment = i3;
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onTouchCancel")
    public void touchCancelable(boolean z16) {
        if (z16) {
            if (this.mGestureTypes == null) {
                this.mGestureTypes = new ArrayList<>();
            }
            this.mGestureTypes.add("onTouchCancel");
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = NodeProps.ON_TOUCH_DOWN)
    public void touchDownEnable(boolean z16) {
        if (z16) {
            if (this.mGestureTypes == null) {
                this.mGestureTypes = new ArrayList<>();
            }
            this.mGestureTypes.add(NodeProps.ON_TOUCH_DOWN);
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onTouchEnd")
    public void touchEndEnable(boolean z16) {
        if (z16) {
            if (this.mGestureTypes == null) {
                this.mGestureTypes = new ArrayList<>();
            }
            this.mGestureTypes.add("onTouchEnd");
        }
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onTouchMove")
    public void touchUpEnable(boolean z16) {
        if (z16) {
            if (this.mGestureTypes == null) {
                this.mGestureTypes = new ArrayList<>();
            }
            this.mGestureTypes.add("onTouchMove");
        }
    }
}

package com.tencent.tavsticker.model;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVStickerEditViewEventType {
    public static final int EVENT_TYPE_ALL = 15;
    public static final int EVENT_TYPE_CLICK = 8;
    public static final int EVENT_TYPE_DOUBLE_ZOOM_ROTATE = 2;
    public static final int EVENT_TYPE_DRAG = 1;
    public static final int EVENT_TYPE_NONE = 0;
    public static final int EVENT_TYPE_SINGLE_ZOOM_ROTATE = 4;

    public static boolean isHandleClick(int i3) {
        if (1 == ((i3 >> 3) & 1)) {
            return true;
        }
        return false;
    }

    public static boolean isHandleDoubleZoomRotate(int i3) {
        if (1 == ((i3 >> 1) & 1)) {
            return true;
        }
        return false;
    }

    public static boolean isHandleDrag(int i3) {
        if (1 == (i3 & 1)) {
            return true;
        }
        return false;
    }

    public static boolean isHandleSingleZoomRotate(int i3) {
        if (1 == ((i3 >> 2) & 1)) {
            return true;
        }
        return false;
    }
}

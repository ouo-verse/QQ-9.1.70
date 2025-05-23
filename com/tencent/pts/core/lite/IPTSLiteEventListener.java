package com.tencent.pts.core.lite;

import android.view.View;
import com.tencent.pts.core.PTSComposer;
import java.util.HashMap;

/* loaded from: classes22.dex */
public interface IPTSLiteEventListener {
    public static final int LITE_EVENT_TYPE_EXPOSURE = 2;
    public static final int LITE_EVENT_TYPE_SCROLL_ITEM_EXPOSURE = 5;
    public static final int LITE_EVENT_TYPE_SWIPER_DRAG = 4;
    public static final int LITE_EVENT_TYPE_SWIPER_ITEM_EXPOSURE = 3;
    public static final int LITE_EVENT_TYPE_TAP = 1;
    public static final int LITE_EVENT_TYPE_UNKNOWN = 0;

    void onExposureTriggered(String str, HashMap<String, String> hashMap, View view, PTSComposer pTSComposer);

    void onScrollViewItemExposureTriggered(String str, HashMap<String, String> hashMap, View view, PTSComposer pTSComposer);

    void onSwiperDragTriggered(String str, HashMap<String, String> hashMap, View view, PTSComposer pTSComposer);

    void onSwiperItemExposureTriggered(String str, HashMap<String, String> hashMap, View view, PTSComposer pTSComposer);

    void onTapEventTriggered(String str, HashMap<String, String> hashMap, View view, PTSComposer pTSComposer);
}

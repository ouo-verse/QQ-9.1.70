package com.tencent.ams.mosaic.jsengine.component.imagegallery;

import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.component.Component;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface ImageGalleryComponent extends Component {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface AnimationType {
        public static final String CENTER = "center";
        public static final String COVER_FLOW = "coverflow";
        public static final String FADE = "fade";
        public static final String FULL = "full";
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ScaleType {
        public static final String CENTER = "center";
        public static final String CENTER_CROP = "centerCrop";
        public static final String CENTER_INSIDE = "centerInside";
        public static final String FIT_CENTER = "fitCenter";
        public static final String FIT_END = "fitEnd";
        public static final String FIT_START = "fitStart";
        public static final String FIT_XY = "fitXY";
    }

    void scrollToPage(int i3, boolean z16);

    void setAnimationType(String str);

    void setAutoScroll(boolean z16);

    void setAutoScrollInterval(int i3);

    void setInfiniteLoop(boolean z16);

    void setPageClickListener(JSFunction jSFunction);

    void setPageMargin(float f16);

    void setPageSelectedListener(JSFunction jSFunction);

    void setScaleType(String str);

    void setSideExposeWidth(float f16);

    void setSrcList(String[] strArr);
}

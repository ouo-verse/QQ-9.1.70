package com.tencent.ams.mosaic.jsengine.component.image;

import androidx.annotation.RequiresApi;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.component.Component;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface ImageComponent extends Component, IAnimatableImageComponent {

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

    @RequiresApi(api = 17)
    void setBlurRadius(float f16);

    void setEnableFastDraw(boolean z16);

    @Deprecated
    void setImageData(String str);

    void setImageDataSequence(String[] strArr, int i3);

    void setImageLoaderCallback(JSFunction jSFunction, JSFunction jSFunction2);

    void setImageTintColor(String str);

    void setMaskColor(String str);

    void setScaleType(String str);

    void setSrc(String str);

    void setSrcSequence(String[] strArr, int i3);
}

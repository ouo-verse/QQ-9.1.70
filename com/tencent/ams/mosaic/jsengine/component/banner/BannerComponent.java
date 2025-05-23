package com.tencent.ams.mosaic.jsengine.component.banner;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.component.Component;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface BannerComponent extends Component {

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ActionType {
        public static final int TYPE_CLICK = 1;
        public static final int TYPE_SLIDE = 2;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface BackgroundAnimationType {
        public static final int TYPE_BREATHING_LIGHT = 2;
        public static final int TYPE_NONE = 1;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SlideIconShape {
        public static final int TYPE_HAND = 2;
        public static final int TYPE_NORMAL = 0;
    }

    RectF getBannerRect();

    void setActionType(int i3);

    void setBackgroundAnimationType(int i3);

    void setBackgroundHeight(float f16);

    void setBannerBackgroundColor(String str);

    void setBannerHighlightBackgroundColor(String str);

    void setBannerHighlightDelayTime(long j3);

    void setIconBitmapArray(Bitmap[] bitmapArr);

    void setIconVisible(boolean z16);

    void setMarginBottom(int i3);

    void setSlideIconShape(int i3);

    void setSubTitle(String str);

    void setSubTitleColor(String str);

    void setSubTitleTextSize(float f16);

    void setTitle(String str);

    void setTitleColor(String str);

    void setTitleTextSize(float f16);

    void setTouchAreaHeightFactor(float f16);

    void setTouchAreaWidthFactor(float f16);
}

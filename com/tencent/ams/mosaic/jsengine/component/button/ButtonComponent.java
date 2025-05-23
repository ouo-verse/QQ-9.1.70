package com.tencent.ams.mosaic.jsengine.component.button;

import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.component.Component;

/* compiled from: P */
@JSAgent
/* loaded from: classes3.dex */
public interface ButtonComponent extends Component {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface IconInfoKey {
        public static final String DATA = "data";
        public static final String HEIGHT = "height";
        public static final String ICON_SPACE = "iconspace";
        public static final String POSITION = "position";
        public static final String SRC = "src";
        public static final String TYPE = "type";
        public static final String WIDTH = "width";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface IconInfoPosition {
        public static final String LEFT = "left";
        public static final String RIGHT = "right";
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface IconInfoType {
        public static final int IMAGE = 0;
        public static final int LOADING = 1;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public @interface Status {
        public static final int DISABLE = 2;
        public static final int NORMAL = 0;
        public static final int PRESSED = 1;
    }

    void setEnable(boolean z16);

    void setIcon(String str);

    void setProgress(float f16);

    void setProgressBackgroundColor(String str);

    void setStatusBackgroundColor(@Status int i3, String str);

    void setText(String str);

    void setTextColor(String str);

    void setTextSize(float f16);

    void setTextTypeface(String str, String str2);
}

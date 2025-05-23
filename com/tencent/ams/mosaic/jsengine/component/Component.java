package com.tencent.ams.mosaic.jsengine.component;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.animation.Animation;
import com.tencent.ams.mosaic.jsengine.animation.AnimationProperty;
import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.annotation.JSMethod;
import com.tencent.ams.mosaic.jsengine.annotation.MethodScope;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
@JSAgent(methodScope = MethodScope.SPECIFIED)
/* loaded from: classes3.dex */
public interface Component extends AnimationProperty {
    public static final String BOTTOM = "bottom";
    public static final String CENTER = "center";
    public static final String CENTER_HORIZONTAL = "center_horizontal";
    public static final String CENTER_VERTICAL = "center_vertical";
    public static final String END = "end";
    public static final int FLEX_ALIGN_TYPE_AUTO = 0;
    public static final int FLEX_ALIGN_TYPE_BASE_LINE = 5;
    public static final int FLEX_ALIGN_TYPE_CENTER = 2;
    public static final int FLEX_ALIGN_TYPE_FLEX_END = 3;
    public static final int FLEX_ALIGN_TYPE_FLEX_START = 1;
    public static final int FLEX_ALIGN_TYPE_SPACE_AROUND = 7;
    public static final int FLEX_ALIGN_TYPE_SPACE_BETWEEN = 6;
    public static final int FLEX_ALIGN_TYPE_STRETCH = 4;
    public static final int FLEX_DIRECTION_COLUMN = 2;
    public static final int FLEX_DIRECTION_COLUMN_REVERSE = 3;
    public static final int FLEX_DIRECTION_ROW = 0;
    public static final int FLEX_DIRECTION_ROW_REVERSE = 1;
    public static final int FLEX_JUSTIFY_CONTENT_CENTER = 2;
    public static final int FLEX_JUSTIFY_CONTENT_FLEX_END = 1;
    public static final int FLEX_JUSTIFY_CONTENT_FLEX_START = 0;
    public static final int FLEX_JUSTIFY_CONTENT_SPACE_AROUND = 4;
    public static final int FLEX_JUSTIFY_CONTENT_SPACE_BETWEEN = 3;
    public static final int FLEX_JUSTIFY_CONTENT_SPACE_EVENLY = 5;
    public static final int FLEX_POSITION_ABSOLUTE = 1;
    public static final int FLEX_POSITION_FIXED = 3;
    public static final int FLEX_POSITION_RELATIVE = 2;
    public static final int FLEX_POSITION_STATIC = 0;
    public static final int FLEX_WRAP_NO_WRAP = 0;
    public static final int FLEX_WRAP_WRAP = 1;
    public static final int FLEX_WRAP_WRAP_REVERSE = 2;
    public static final String LEFT = "left";
    public static final String RIGHT = "right";
    public static final String START = "start";
    public static final String TOP = "top";

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface AlignParent {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface FlexAlignType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface FlexDirectionType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface FlexJustifyContentType {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface FlexPosition {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface FlexWrapType {
    }

    @JSMethod
    void addAnimation(Animation animation);

    @JSMethod
    void commit();

    Component findComponentById(String str);

    @JSMethod
    String focusSearch(int i3);

    @JSMethod
    float getHeight();

    @JSMethod
    String getId();

    @NonNull
    com.tencent.ams.mosaic.jsengine.a getJSEngine();

    Component getParent();

    @JSMethod
    float getRealHeight();

    @JSMethod
    float getRealWidth();

    @NonNull
    View getView();

    @JSMethod
    float getWidth();

    @JSMethod
    float getX();

    @JSMethod
    float getXInScreen();

    @JSMethod
    float getY();

    @JSMethod
    float getYInScreen();

    @JSMethod
    boolean isFocused();

    void onAddedToParent();

    void onRemovedFromParent();

    @JSMethod
    void removeAnimation();

    @JSMethod
    void requestFocus();

    @JSMethod
    void setAlignParent(String str);

    @JSMethod
    void setAlpha(float f16);

    @JSMethod
    void setAnchorPoint(float f16, float f17);

    @JSMethod
    void setBackgroundColor(String str);

    @JSMethod
    void setBackgroundDrawable(String str);

    @JSMethod
    void setBackgroundGradient(String str);

    @JSMethod
    void setBorder(float f16, String str);

    @JSMethod
    void setBoxShadow(float f16, float f17, float f18, String str);

    @JSMethod
    void setCornerRadii(float[] fArr);

    @JSMethod
    void setCornerRadius(float f16);

    @JSMethod
    void setFlexLayout(JSObject jSObject);

    @JSMethod
    void setFocusable(boolean z16);

    @JSMethod
    void setFocusableInTouchMode(boolean z16);

    void setJSEngine(com.tencent.ams.mosaic.jsengine.a aVar);

    @JSMethod
    void setMargin(float f16, float f17, float f18, float f19);

    @JSMethod
    void setNextFocusDownId(String str);

    @JSMethod
    void setNextFocusLeftId(String str);

    @JSMethod
    void setNextFocusRightId(String str);

    @JSMethod
    void setNextFocusUpId(String str);

    @JSMethod
    void setOnClickListener(JSFunction jSFunction);

    @JSMethod
    void setOnFocusChangeListener(JSFunction jSFunction);

    @JSMethod
    void setOnTouchListener(JSFunction jSFunction);

    @JSMethod
    void setPadding(float f16, float f17, float f18, float f19);

    void setParent(Component component);

    @JSMethod
    void setSize(float f16, float f17);

    @JSMethod
    void setVisible(boolean z16);

    @JSMethod
    void setZIndex(int i3);

    @JSMethod
    String toString();
}

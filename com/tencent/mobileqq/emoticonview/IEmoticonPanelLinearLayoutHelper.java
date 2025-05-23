package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes12.dex */
public interface IEmoticonPanelLinearLayoutHelper {
    public static final int PANEL_TYPE_AI_EMOTION = 7;
    public static final int PANEL_TYPE_BIG_EMOTION = 1;
    public static final int PANEL_TYPE_CAMERA_EMOTION = 5;
    public static final int PANEL_TYPE_FAV_EMOTION = 3;
    public static final int PANEL_TYPE_HOTPIC_EMOTION = 6;
    public static final int PANEL_TYPE_ROAM = 4;
    public static final int PANEL_TYPE_SMALL_EMOTION = 2;
    public static final int PANEL_TYPE_SYSTEM_AND_EMOJI = 0;
    public static final String TAG = "EmotionPanelLinearLayout";

    /* loaded from: classes12.dex */
    public interface OnClickListener {
        boolean shouldInterceptClickEvent(View view, EmoticonInfo emoticonInfo);
    }

    void attachCurrentView(EmoticonPanelLinearLayout emoticonPanelLinearLayout);

    Context getContext();

    void initHelper(Context context);

    void onAttachedToWindow();

    void onDetachedFromWindow();

    boolean onInterceptTouchEvent(MotionEvent motionEvent);

    boolean onTouchEvent(MotionEvent motionEvent);

    void setBusinessType(int i3);

    void setCallBack(EmoticonCallback emoticonCallback);

    void setInterceptListener(OnClickListener onClickListener);

    void setPanelType(int i3);

    void setReportCallback(EmoticonReportCallback emoticonReportCallback);

    void setShowDescribeInPreview(boolean z16);
}

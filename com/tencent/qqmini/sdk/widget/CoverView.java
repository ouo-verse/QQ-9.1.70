package com.tencent.qqmini.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class CoverView extends FrameLayout {
    public static final String TAG = "CoverView";
    private String data;
    private float density;
    private boolean enableGesture;
    private boolean fixed;
    private float mBorderRadius;
    protected boolean mIgnoreTouchEventToJS;
    private JsRuntimeListener mJsRuntimeListener;
    public int parentId;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface JsRuntimeListener {
        void onCallbackJsEventFail(String str, JSONObject jSONObject, int i3);

        void onCallbackJsEventOK(String str, JSONObject jSONObject, int i3);

        void onEvaluateSubscribeJS(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnPageChangeListener {
        void onAddColorNote();

        void onPageBackground();

        void onPageForeground();

        void onPageWebViewDestory();

        void onPageWebViewPause();

        void onPageWebViewResume();
    }

    public CoverView(Context context) {
        super(context);
        this.fixed = false;
        this.density = DisplayUtil.getDensity(context);
    }

    private void handleTouchCancel(MotionEvent motionEvent) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            int px2mpx = (int) DisplayUtil.px2mpx(motionEvent.getX());
            int px2mpx2 = (int) DisplayUtil.px2mpx(motionEvent.getY());
            jSONObject.put(HippyTKDListViewAdapter.X, px2mpx);
            jSONObject.put("y", px2mpx2);
            jSONObject.put("id", motionEvent.getPointerId(0));
            jSONArray.mo162put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", this.data);
            jSONObject2.put("touches", jSONArray);
            JsRuntimeListener jsRuntimeListener = this.mJsRuntimeListener;
            if (jsRuntimeListener != null) {
                jsRuntimeListener.onEvaluateSubscribeJS("onTouchCancel", jSONObject2.toString());
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void handleTouchDown(MotionEvent motionEvent) {
        try {
            JSONObject jSONObject = new JSONObject();
            int x16 = (int) (motionEvent.getX() / this.density);
            int y16 = (int) (motionEvent.getY() / this.density);
            jSONObject.put(HippyTKDListViewAdapter.X, x16);
            jSONObject.put("y", y16);
            jSONObject.put("id", motionEvent.getPointerId(0));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", this.data);
            jSONObject2.put(WebRTCSDK.PRIVILEGE_TOUCH, jSONObject);
            JsRuntimeListener jsRuntimeListener = this.mJsRuntimeListener;
            if (jsRuntimeListener != null) {
                jsRuntimeListener.onEvaluateSubscribeJS(e.c.NAME, jSONObject2.toString());
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void handleTouchMove(MotionEvent motionEvent) {
        try {
            JSONArray jSONArray = new JSONArray();
            int pointerCount = motionEvent.getPointerCount();
            for (int i3 = 0; i3 < pointerCount; i3++) {
                JSONObject jSONObject = new JSONObject();
                int x16 = (int) (motionEvent.getX(i3) / this.density);
                int y16 = (int) (motionEvent.getY(i3) / this.density);
                jSONObject.put(HippyTKDListViewAdapter.X, x16);
                jSONObject.put("y", y16);
                jSONObject.put("id", motionEvent.getPointerId(i3));
                jSONArray.mo162put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", this.data);
            jSONObject2.put("touches", jSONArray);
            JsRuntimeListener jsRuntimeListener = this.mJsRuntimeListener;
            if (jsRuntimeListener != null) {
                jsRuntimeListener.onEvaluateSubscribeJS("onTouchMove", jSONObject2.toString());
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void handleTouchPointerDown(MotionEvent motionEvent) {
        try {
            int actionIndex = motionEvent.getActionIndex();
            JSONObject jSONObject = new JSONObject();
            int x16 = (int) (motionEvent.getX(actionIndex) / this.density);
            int y16 = (int) (motionEvent.getY(actionIndex) / this.density);
            jSONObject.put(HippyTKDListViewAdapter.X, x16);
            jSONObject.put("y", y16);
            jSONObject.put("id", motionEvent.getPointerId(actionIndex));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", this.data);
            jSONObject2.put(WebRTCSDK.PRIVILEGE_TOUCH, jSONObject);
            JsRuntimeListener jsRuntimeListener = this.mJsRuntimeListener;
            if (jsRuntimeListener != null) {
                jsRuntimeListener.onEvaluateSubscribeJS(e.c.NAME, jSONObject2.toString());
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void handleTouchPointerUp(MotionEvent motionEvent) {
        try {
            int actionIndex = motionEvent.getActionIndex();
            JSONObject jSONObject = new JSONObject();
            int px2mpx = (int) DisplayUtil.px2mpx(motionEvent.getX(actionIndex));
            int px2mpx2 = (int) DisplayUtil.px2mpx(motionEvent.getY(actionIndex));
            jSONObject.put(HippyTKDListViewAdapter.X, px2mpx);
            jSONObject.put("y", px2mpx2);
            jSONObject.put("id", motionEvent.getPointerId(actionIndex));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", this.data);
            jSONObject2.put(WebRTCSDK.PRIVILEGE_TOUCH, jSONObject);
            JsRuntimeListener jsRuntimeListener = this.mJsRuntimeListener;
            if (jsRuntimeListener != null) {
                jsRuntimeListener.onEvaluateSubscribeJS("onTouchEnd", jSONObject2.toString());
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void handleTouchUp(MotionEvent motionEvent) {
        try {
            JSONObject jSONObject = new JSONObject();
            int px2mpx = (int) DisplayUtil.px2mpx(motionEvent.getX());
            int px2mpx2 = (int) DisplayUtil.px2mpx(motionEvent.getY());
            jSONObject.put(HippyTKDListViewAdapter.X, px2mpx);
            jSONObject.put("y", px2mpx2);
            jSONObject.put("id", motionEvent.getPointerId(0));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", this.data);
            jSONObject2.put(WebRTCSDK.PRIVILEGE_TOUCH, jSONObject);
            JsRuntimeListener jsRuntimeListener = this.mJsRuntimeListener;
            if (jsRuntimeListener != null) {
                jsRuntimeListener.onEvaluateSubscribeJS("onTouchEnd", jSONObject2.toString());
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.mBorderRadius > 0.0f) {
            Path path = new Path();
            RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + ((getWidth() - getPaddingLeft()) - getPaddingRight()), getPaddingTop() + ((getHeight() - getPaddingTop()) - getPaddingBottom()));
            float f16 = this.mBorderRadius;
            path.addRoundRect(rectF, f16, f16, Path.Direction.CCW);
            path.setFillType(Path.FillType.EVEN_ODD);
            canvas.clipPath(path);
        }
        super.draw(canvas);
    }

    public int getParentId() {
        return this.parentId;
    }

    public boolean isFixed() {
        return this.fixed;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mIgnoreTouchEventToJS) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked == 6) {
                                QMLog.d(TAG, "--ACTION_POINTER_UP--" + motionEvent.getPointerId(motionEvent.getActionIndex()));
                                handleTouchPointerUp(motionEvent);
                            }
                        } else {
                            QMLog.d(TAG, "--ACTION_POINTER_DOWN--" + motionEvent.getPointerCount() + "   " + motionEvent.getActionIndex() + "   " + motionEvent.getPointerId(motionEvent.getActionIndex()));
                            handleTouchPointerDown(motionEvent);
                        }
                    } else {
                        QMLog.d(TAG, "--ACTION_CANCEL--");
                        handleTouchCancel(motionEvent);
                    }
                } else {
                    handleTouchMove(motionEvent);
                }
            } else {
                QMLog.d(TAG, "--ACTION_UP--");
                handleTouchUp(motionEvent);
            }
        } else {
            QMLog.d(TAG, "--ACTION_DOWN--");
            handleTouchDown(motionEvent);
        }
        if (this.enableGesture) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBorderRadius(float f16) {
        this.mBorderRadius = f16;
    }

    public void setData(String str, boolean z16, JsRuntimeListener jsRuntimeListener) {
        this.data = str;
        this.enableGesture = z16;
        this.mJsRuntimeListener = jsRuntimeListener;
    }

    public void setFixed(boolean z16) {
        this.fixed = z16;
    }

    public void setIgnoreTouchEventToJS(boolean z16) {
        this.mIgnoreTouchEventToJS = z16;
    }

    public void setParentId(int i3) {
        this.parentId = i3;
    }
}

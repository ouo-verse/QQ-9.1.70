package com.tencent.ttpic.openapi.filter;

import android.opengl.GLSurfaceView;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes27.dex */
public final class GLGestureProxy {
    public static final String TAG = "GLGestureProxy";
    private int height;
    private List<GLGestureListener> mGLGestureList;
    private GLSurfaceView mGLSurfaceView;
    private boolean mIsRecorder;
    private View mRecorderView;
    private int width;

    /* loaded from: classes27.dex */
    private static class GLGestureProxyHolder {
        private static final GLGestureProxy INSTANCE = new GLGestureProxy();

        GLGestureProxyHolder() {
        }
    }

    public static final GLGestureProxy getInstance() {
        return GLGestureProxyHolder.INSTANCE;
    }

    public static String getPointAction(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action != 6) {
                                return "";
                            }
                            return "MotionEvent.ACTION_POINTER_UP";
                        }
                        return "MotionEvent.ACTION_POINTER_DOWN";
                    }
                    return "MotionEvent.ACTION_CANCEL";
                }
                return "MotionEvent.ACTION_MOVE";
            }
            return "MotionEvent.ACTION_UP";
        }
        return "MotionEvent.ACTION_DOWN";
    }

    public void addListener(GLGestureListener gLGestureListener) {
        if (gLGestureListener == null) {
            return;
        }
        int onGetPriority = gLGestureListener.onGetPriority();
        if (this.mGLGestureList.size() == 0) {
            this.mGLGestureList.add(gLGestureListener);
            return;
        }
        int size = this.mGLGestureList.size();
        int i3 = 0;
        int i16 = -1;
        while (i3 < size && onGetPriority >= this.mGLGestureList.get(i3).onGetPriority()) {
            i16 = i3 + 1;
            i3 = i16;
        }
        if (i16 == -1) {
            this.mGLGestureList.add(0, gLGestureListener);
        } else {
            this.mGLGestureList.add(i16, gLGestureListener);
        }
    }

    public boolean checkDownPointerInRecorderView(float f16, float f17) {
        View view = this.mRecorderView;
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (f16 >= iArr[0] && f16 <= r0 + this.mRecorderView.getWidth()) {
                if (f17 >= iArr[1] && f17 <= r0 + this.mRecorderView.getHeight()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSecendFinger(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (motionEvent.getPointerCount() == 2 && (action == 2 || action == 5 || action == 6)) {
            return true;
        }
        return false;
    }

    public GLSurfaceView getGLSurfaceView() {
        return this.mGLSurfaceView;
    }

    public int getHeight() {
        return this.height;
    }

    public View getRecordView() {
        return this.mRecorderView;
    }

    public float getScreenCoordinateX(float f16) {
        View view;
        if (this.mIsRecorder && (view = this.mRecorderView) != null) {
            view.getLocationOnScreen(new int[2]);
            return f16 + r1[0];
        }
        return f16;
    }

    public float getScreenCoordinateY(float f16) {
        View view;
        if (this.mIsRecorder && (view = this.mRecorderView) != null) {
            view.getLocationOnScreen(new int[2]);
            return f16 + r1[1];
        }
        return f16;
    }

    public MotionEvent getSecendFingerMotionEvent(MotionEvent motionEvent) {
        int i3;
        int i16 = 2;
        int[] iArr = new int[2];
        View view = this.mRecorderView;
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        int action = motionEvent.getAction() & 255;
        int x16 = (int) (iArr[0] + motionEvent.getX(1));
        int y16 = (int) (iArr[1] + motionEvent.getY(1));
        long uptimeMillis = SystemClock.uptimeMillis();
        if (action != 2) {
            if (action != 5) {
                if (action != 6) {
                    i16 = -1;
                } else {
                    i3 = 1;
                }
            } else {
                i3 = 0;
            }
            return MotionEvent.obtain(uptimeMillis, uptimeMillis, i3, x16, y16, 0);
        }
        i3 = i16;
        return MotionEvent.obtain(uptimeMillis, uptimeMillis, i3, x16, y16, 0);
    }

    public int getWidth() {
        return this.width;
    }

    public boolean hasListener(GLGestureListener gLGestureListener) {
        return this.mGLGestureList.contains(gLGestureListener);
    }

    public boolean onTouchEvent(MotionEvent motionEvent, boolean z16, View view, GLSurfaceView gLSurfaceView) {
        this.mGLSurfaceView = gLSurfaceView;
        if (gLSurfaceView != null) {
            this.width = gLSurfaceView.getWidth();
            this.height = this.mGLSurfaceView.getHeight();
        }
        this.mRecorderView = view;
        this.mIsRecorder = z16;
        for (int size = this.mGLGestureList.size() - 1; size >= 0; size--) {
            if (this.mGLGestureList.get(size).onTouchEvent(motionEvent, z16)) {
                return true;
            }
        }
        return false;
    }

    public void removeAllListener() {
        this.mGLGestureList.clear();
        this.mRecorderView = null;
        this.mGLSurfaceView = null;
    }

    public void removeListener(GLGestureListener gLGestureListener) {
        if (this.mGLGestureList.contains(gLGestureListener)) {
            this.mGLGestureList.remove(gLGestureListener);
        }
    }

    GLGestureProxy() {
        this.mGLGestureList = new CopyOnWriteArrayList();
    }
}

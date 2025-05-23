package com.tencent.qqmini.sdk.launcher.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VideoGestureRelativeLayout extends FrameLayout {
    private static final int BRIGHTNESS = 2;
    private static final int FF_REW = 3;
    private static final int NONE = 0;
    private static final String TAG = "gesturetest";
    private static final int VOLUME = 1;
    private boolean enablePageGesture;
    private boolean enablePlayGesture;
    private boolean enableProgressGesture;
    private boolean hasFFREW;
    private GestureDetector mGestureDetector;
    private VideoPlayerOnGestureListener mOnGestureListener;
    private int mScrollMode;
    private VideoGestureListener mVideoGestureListener;
    private int offsetX;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface VideoGestureListener {
        void onBrightnessGesture(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17);

        void onDoubleTapGesture(MotionEvent motionEvent);

        void onDown(MotionEvent motionEvent);

        void onEndFF_REW(MotionEvent motionEvent);

        void onProgressGesture(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17);

        void onSingleTapGesture(MotionEvent motionEvent);

        void onVolumeGesture(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class VideoPlayerOnGestureListener extends GestureDetector.SimpleOnGestureListener {
        private VideoGestureRelativeLayout videoGestureRelativeLayout;

        public VideoPlayerOnGestureListener(VideoGestureRelativeLayout videoGestureRelativeLayout) {
            this.videoGestureRelativeLayout = videoGestureRelativeLayout;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnContextClickListener
        public boolean onContextClick(MotionEvent motionEvent) {
            Log.d(VideoGestureRelativeLayout.TAG, "onContextClick: ");
            if (!VideoGestureRelativeLayout.this.enableProgressGesture && !VideoGestureRelativeLayout.this.enablePageGesture && !VideoGestureRelativeLayout.this.enablePlayGesture) {
                return false;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            Log.d(VideoGestureRelativeLayout.TAG, "onDoubleTap: ");
            if (VideoGestureRelativeLayout.this.enablePlayGesture) {
                if (VideoGestureRelativeLayout.this.mVideoGestureListener != null) {
                    VideoGestureRelativeLayout.this.mVideoGestureListener.onDoubleTapGesture(motionEvent);
                }
                return super.onDoubleTap(motionEvent);
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            Log.d(VideoGestureRelativeLayout.TAG, "onDoubleTapEvent: ");
            return super.onDoubleTapEvent(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            Log.d(VideoGestureRelativeLayout.TAG, "onDown: ");
            VideoGestureRelativeLayout.this.hasFFREW = false;
            VideoGestureRelativeLayout.this.mScrollMode = 0;
            if (!VideoGestureRelativeLayout.this.enableProgressGesture && !VideoGestureRelativeLayout.this.enablePageGesture) {
                return false;
            }
            if (VideoGestureRelativeLayout.this.mVideoGestureListener != null) {
                VideoGestureRelativeLayout.this.mVideoGestureListener.onDown(motionEvent);
                return true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            Log.d(VideoGestureRelativeLayout.TAG, "onFling: ");
            return super.onFling(motionEvent, motionEvent2, f16, f17);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Log.d(VideoGestureRelativeLayout.TAG, "onLongPress: ");
            super.onLongPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            Log.d(VideoGestureRelativeLayout.TAG, "onScroll: e1:" + motionEvent.getX() + "," + motionEvent.getY());
            Log.d(VideoGestureRelativeLayout.TAG, "onScroll: e2:" + motionEvent2.getX() + "," + motionEvent2.getY());
            Log.d(VideoGestureRelativeLayout.TAG, "onScroll: X:" + f16 + "  Y:" + f17);
            if (VideoGestureRelativeLayout.this.enableProgressGesture || VideoGestureRelativeLayout.this.enablePageGesture) {
                int i3 = VideoGestureRelativeLayout.this.mScrollMode;
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                if (VideoGestureRelativeLayout.this.mVideoGestureListener != null) {
                                    VideoGestureRelativeLayout.this.mVideoGestureListener.onProgressGesture(motionEvent, motionEvent2, f16, f17);
                                }
                                VideoGestureRelativeLayout.this.hasFFREW = true;
                                Log.d(VideoGestureRelativeLayout.TAG, "FF_REW: ");
                            }
                        } else {
                            if (VideoGestureRelativeLayout.this.mVideoGestureListener != null) {
                                VideoGestureRelativeLayout.this.mVideoGestureListener.onBrightnessGesture(motionEvent, motionEvent2, f16, f17);
                            }
                            Log.d(VideoGestureRelativeLayout.TAG, "BRIGHTNESS: ");
                        }
                    } else {
                        if (VideoGestureRelativeLayout.this.mVideoGestureListener != null) {
                            VideoGestureRelativeLayout.this.mVideoGestureListener.onVolumeGesture(motionEvent, motionEvent2, f16, f17);
                        }
                        Log.d(VideoGestureRelativeLayout.TAG, "VOLUME: ");
                    }
                } else {
                    Log.d(VideoGestureRelativeLayout.TAG, "NONE: ");
                    if (Math.abs(f16) - Math.abs(f17) > VideoGestureRelativeLayout.this.offsetX) {
                        VideoGestureRelativeLayout.this.mScrollMode = 3;
                    } else if (motionEvent.getX() < VideoGestureRelativeLayout.this.getWidth() / 2) {
                        VideoGestureRelativeLayout.this.mScrollMode = 2;
                    } else {
                        VideoGestureRelativeLayout.this.mScrollMode = 1;
                    }
                }
                return true;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            Log.d(VideoGestureRelativeLayout.TAG, "onShowPress: ");
            super.onShowPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            Log.d(VideoGestureRelativeLayout.TAG, "onSingleTapConfirmed: ");
            if (VideoGestureRelativeLayout.this.mVideoGestureListener != null) {
                VideoGestureRelativeLayout.this.mVideoGestureListener.onSingleTapGesture(motionEvent);
            }
            return super.onSingleTapConfirmed(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Log.d(VideoGestureRelativeLayout.TAG, "onSingleTapUp: ");
            return super.onSingleTapUp(motionEvent);
        }
    }

    public VideoGestureRelativeLayout(Context context) {
        super(context);
        this.mScrollMode = 0;
        this.offsetX = 1;
        this.hasFFREW = false;
        this.enablePageGesture = false;
        this.enableProgressGesture = true;
        this.enablePlayGesture = false;
        init(context);
    }

    private void init(Context context) {
        this.mOnGestureListener = new VideoPlayerOnGestureListener(this);
        GestureDetector gestureDetector = new GestureDetector(context, this.mOnGestureListener);
        this.mGestureDetector = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1 && VideoGestureRelativeLayout.this.hasFFREW) {
                    if (VideoGestureRelativeLayout.this.mVideoGestureListener != null) {
                        VideoGestureRelativeLayout.this.mVideoGestureListener.onEndFF_REW(motionEvent);
                    }
                    VideoGestureRelativeLayout.this.hasFFREW = false;
                }
                boolean onTouchEvent = VideoGestureRelativeLayout.this.mGestureDetector.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 1) {
                    QMLog.d(VideoGestureRelativeLayout.TAG, "mGestureDetector.onTouchEvent(event) return " + onTouchEvent);
                }
                return onTouchEvent;
            }
        });
    }

    public void setEnablePageGesture(boolean z16) {
        this.enablePageGesture = z16;
    }

    public void setEnablePlayGesture(boolean z16) {
        this.enablePlayGesture = z16;
    }

    public void setEnableProgressGesture(boolean z16) {
        this.enableProgressGesture = z16;
    }

    public void setVideoGestureListener(VideoGestureListener videoGestureListener) {
        this.mVideoGestureListener = videoGestureListener;
    }

    public VideoGestureRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScrollMode = 0;
        this.offsetX = 1;
        this.hasFFREW = false;
        this.enablePageGesture = false;
        this.enableProgressGesture = true;
        this.enablePlayGesture = false;
        init(context);
    }
}

package com.tencent.ams.fusion.widget.slideinteractive;

import android.content.Context;
import android.gesture.Gesture;
import android.gesture.GestureOverlayView;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NewSlideGestureView extends FrameLayout implements ISlideGestureView {
    static IPatchRedirector $redirector_;
    private Rect mDrawRect;
    private final Map<ISlideGestureView.OnGestureListener, GestureOverlayView.OnGestureListener> mGestureListenerMap;
    private final Map<ISlideGestureView.OnGesturePerformedListener, GestureOverlayView.OnGesturePerformedListener> mGesturePerformedListenerMap;

    @NonNull
    private final GestureOverlayView mGestureView;
    private final Map<ISlideGestureView.OnGesturingListener, GestureOverlayView.OnGesturingListener> mGesturingListenerMap;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class MyGestureOverlayView extends GestureOverlayView {
        static IPatchRedirector $redirector_;

        public MyGestureOverlayView(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewSlideGestureView.this, (Object) context);
            }
        }

        private void clipRect(Canvas canvas, Rect rect) {
            if (canvas != null && rect != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    canvas.clipRect(rect);
                } else {
                    canvas.clipRect(rect, Region.Op.INTERSECT);
                }
            }
        }

        @Override // android.gesture.GestureOverlayView, android.view.View
        public void draw(Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
                return;
            }
            if (NewSlideGestureView.this.mDrawRect != null) {
                clipRect(canvas, NewSlideGestureView.this.mDrawRect);
            }
            super.draw(canvas);
        }
    }

    public NewSlideGestureView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mGestureListenerMap = new HashMap();
        this.mGesturePerformedListenerMap = new HashMap();
        this.mGesturingListenerMap = new HashMap();
        MyGestureOverlayView myGestureOverlayView = new MyGestureOverlayView(context);
        this.mGestureView = myGestureOverlayView;
        addView(myGestureOverlayView, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void addOnGestureListener(ISlideGestureView.OnGestureListener onGestureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) onGestureListener);
        } else {
            if (onGestureListener == null) {
                return;
            }
            GestureOverlayView.OnGestureListener onGestureListener2 = new GestureOverlayView.OnGestureListener(onGestureListener) { // from class: com.tencent.ams.fusion.widget.slideinteractive.NewSlideGestureView.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ISlideGestureView.OnGestureListener val$listener;

                {
                    this.val$listener = onGestureListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NewSlideGestureView.this, (Object) onGestureListener);
                    }
                }

                @Override // android.gesture.GestureOverlayView.OnGestureListener
                public void onGesture(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) gestureOverlayView, (Object) motionEvent);
                    } else {
                        this.val$listener.onGesture(gestureOverlayView, motionEvent);
                    }
                }

                @Override // android.gesture.GestureOverlayView.OnGestureListener
                public void onGestureCancelled(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                        iPatchRedirector2.redirect((short) 5, (Object) this, (Object) gestureOverlayView, (Object) motionEvent);
                    } else {
                        this.val$listener.onGestureCancelled(gestureOverlayView, motionEvent);
                    }
                }

                @Override // android.gesture.GestureOverlayView.OnGestureListener
                public void onGestureEnded(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, (Object) gestureOverlayView, (Object) motionEvent);
                    } else {
                        this.val$listener.onGestureEnded(gestureOverlayView, motionEvent);
                    }
                }

                @Override // android.gesture.GestureOverlayView.OnGestureListener
                public void onGestureStarted(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) gestureOverlayView, (Object) motionEvent);
                    } else {
                        this.val$listener.onGestureStarted(gestureOverlayView, motionEvent);
                    }
                }
            };
            this.mGestureView.addOnGestureListener(onGestureListener2);
            this.mGestureListenerMap.put(onGestureListener, onGestureListener2);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void addOnGesturePerformedListener(ISlideGestureView.OnGesturePerformedListener onGesturePerformedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) onGesturePerformedListener);
        } else {
            if (onGesturePerformedListener == null) {
                return;
            }
            GestureOverlayView.OnGesturePerformedListener onGesturePerformedListener2 = new GestureOverlayView.OnGesturePerformedListener(onGesturePerformedListener) { // from class: com.tencent.ams.fusion.widget.slideinteractive.NewSlideGestureView.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ ISlideGestureView.OnGesturePerformedListener val$listener;

                {
                    this.val$listener = onGesturePerformedListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NewSlideGestureView.this, (Object) onGesturePerformedListener);
                    }
                }

                @Override // android.gesture.GestureOverlayView.OnGesturePerformedListener
                public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) gestureOverlayView, (Object) gesture);
                    } else {
                        this.val$listener.onGesturePerformed(gestureOverlayView, gesture);
                    }
                }
            };
            this.mGestureView.addOnGesturePerformedListener(onGesturePerformedListener2);
            this.mGesturePerformedListenerMap.put(onGesturePerformedListener, onGesturePerformedListener2);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void addOnGesturingListener(ISlideGestureView.OnGesturingListener onGesturingListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) onGesturingListener);
        } else {
            if (onGesturingListener == null) {
                return;
            }
            GestureOverlayView.OnGesturingListener onGesturingListener2 = new GestureOverlayView.OnGesturingListener(onGesturingListener) { // from class: com.tencent.ams.fusion.widget.slideinteractive.NewSlideGestureView.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ ISlideGestureView.OnGesturingListener val$listener;

                {
                    this.val$listener = onGesturingListener;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NewSlideGestureView.this, (Object) onGesturingListener);
                    }
                }

                @Override // android.gesture.GestureOverlayView.OnGesturingListener
                public void onGesturingEnded(GestureOverlayView gestureOverlayView) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) gestureOverlayView);
                    } else {
                        this.val$listener.onGesturingEnded(gestureOverlayView);
                    }
                }

                @Override // android.gesture.GestureOverlayView.OnGesturingListener
                public void onGesturingStarted(GestureOverlayView gestureOverlayView) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) gestureOverlayView);
                    } else {
                        this.val$listener.onGesturingStarted(gestureOverlayView);
                    }
                }
            };
            this.mGestureView.addOnGesturingListener(onGesturingListener2);
            this.mGesturingListenerMap.put(onGesturingListener, onGesturingListener2);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void cancelGestureEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) motionEvent);
        } else {
            this.mGestureView.cancelGesture();
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void clear(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            this.mGestureView.clear(z16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public boolean isGesturing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.mGestureView.isGesturing();
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void removeAllOnGestureListeners() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.mGestureListenerMap.clear();
            this.mGestureView.removeAllOnGestureListeners();
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void removeAllOnGesturePerformedListeners() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.mGesturePerformedListenerMap.clear();
            this.mGestureView.removeAllOnGesturePerformedListeners();
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void removeAllOnGesturingListeners() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.mGesturingListenerMap.clear();
            this.mGestureView.removeAllOnGesturingListeners();
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void removeOnGestureListener(ISlideGestureView.OnGestureListener onGestureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) onGestureListener);
        } else if (onGestureListener != null) {
            this.mGestureView.removeOnGestureListener(this.mGestureListenerMap.remove(onGestureListener));
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void removeOnGesturePerformedListener(ISlideGestureView.OnGesturePerformedListener onGesturePerformedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) onGesturePerformedListener);
        } else if (onGesturePerformedListener != null) {
            this.mGestureView.removeOnGesturePerformedListener(this.mGesturePerformedListenerMap.remove(onGesturePerformedListener));
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void removeOnGesturingListener(ISlideGestureView.OnGesturingListener onGesturingListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) onGesturingListener);
        } else if (onGesturingListener != null) {
            this.mGestureView.removeOnGesturingListener(this.mGesturingListenerMap.remove(onGesturingListener));
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void setDrawRect(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) rect);
        } else {
            this.mDrawRect = rect;
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void setFadeOffset(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        } else {
            this.mGestureView.setFadeOffset(j3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void setGestureColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.mGestureView.setGestureColor(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void setGestureStrokeType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.mGestureView.setGestureStrokeType(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void setGestureStrokeWidth(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.mGestureView.setGestureStrokeWidth(f16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void setGestureVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.mGestureView.setGestureVisible(z16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void setUncertainGestureColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.mGestureView.setUncertainGestureColor(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            this.mGestureView.cancelClearAnimation();
        }
    }
}

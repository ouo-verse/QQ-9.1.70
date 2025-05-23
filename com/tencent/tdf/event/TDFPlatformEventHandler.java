package com.tencent.tdf.event;

import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tdf.text.TDFKeyboardCharacterRecognizer;
import com.tencent.tdf.view.TDFViewportMetrics;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes26.dex */
public class TDFPlatformEventHandler {
    static IPatchRedirector $redirector_;
    private TDFKeyboardCharacterRecognizer characterRecognizer;
    private long objectId;

    /* loaded from: classes26.dex */
    private class EventDataType {
        static IPatchRedirector $redirector_ = null;
        public static final int KEY = 2;
        public static final int MOTION = 1;
        public static final int UNKNOWN = 0;
        public static final int VIEWPORT = 3;

        EventDataType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TDFPlatformEventHandler.this);
            }
        }
    }

    public TDFPlatformEventHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.objectId = 0L;
            this.characterRecognizer = new TDFKeyboardCharacterRecognizer();
        }
    }

    private native void handleEventData(long j3, long j16, int i3, ByteBuffer byteBuffer, int i16);

    private ByteBuffer serializeKeyEvent(KeyEvent keyEvent) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(32);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        allocateDirect.putLong(keyEvent.getAction());
        allocateDirect.putLong(keyEvent.getKeyCode());
        allocateDirect.putLong(keyEvent.getMetaState());
        allocateDirect.putLong(this.characterRecognizer.recognizer(keyEvent));
        return allocateDirect;
    }

    private ByteBuffer serializeMotionEvent(MotionEvent motionEvent) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 104);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        int actionIndex = motionEvent.getActionIndex();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0 && actionMasked != 5) {
            if (actionMasked != 1 && actionMasked != 6) {
                for (int i3 = 0; i3 < motionEvent.getPointerCount(); i3++) {
                    serializePointerData(motionEvent, i3, allocateDirect);
                }
            } else {
                serializePointerData(motionEvent, actionIndex, allocateDirect);
            }
        } else {
            serializePointerData(motionEvent, actionIndex, allocateDirect);
        }
        return allocateDirect;
    }

    private void serializePointerData(MotionEvent motionEvent, int i3, ByteBuffer byteBuffer) {
        double d16;
        double d17;
        double d18;
        InputDevice.MotionRange motionRange;
        byteBuffer.putLong(motionEvent.getEventTime());
        byteBuffer.putLong(motionEvent.getPointerId(i3));
        byteBuffer.putLong(motionEvent.getActionMasked());
        byteBuffer.putLong(motionEvent.getButtonState());
        byteBuffer.putLong(motionEvent.getToolType(i3));
        byteBuffer.putLong(motionEvent.getMetaState());
        byteBuffer.putDouble(motionEvent.getX(i3));
        byteBuffer.putDouble(motionEvent.getY(i3));
        byteBuffer.putDouble(motionEvent.getPressure(i3));
        double d19 = 0.0d;
        if (motionEvent.getDevice() != null && (motionRange = motionEvent.getDevice().getMotionRange(2)) != null) {
            d17 = motionRange.getMin();
            d16 = motionRange.getMax();
        } else {
            d16 = 1.0d;
            d17 = 0.0d;
        }
        byteBuffer.putDouble(d17);
        byteBuffer.putDouble(d16);
        if (motionEvent.getActionMasked() == 8) {
            d19 = -motionEvent.getAxisValue(10);
            d18 = -motionEvent.getAxisValue(9);
        } else {
            d18 = 0.0d;
        }
        byteBuffer.putDouble(d19);
        byteBuffer.putDouble(d18);
    }

    private ByteBuffer serializeViewportMetrics(TDFViewportMetrics tDFViewportMetrics) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(136);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        allocateDirect.putDouble(tDFViewportMetrics.devicePixelRatio);
        allocateDirect.putDouble(tDFViewportMetrics.width);
        allocateDirect.putDouble(tDFViewportMetrics.height);
        allocateDirect.putDouble(tDFViewportMetrics.viewInsetTop);
        allocateDirect.putDouble(tDFViewportMetrics.viewInsetRight);
        allocateDirect.putDouble(tDFViewportMetrics.viewInsetBottom);
        allocateDirect.putDouble(tDFViewportMetrics.viewInsetLeft);
        allocateDirect.putDouble(tDFViewportMetrics.viewPaddingTop);
        allocateDirect.putDouble(tDFViewportMetrics.viewPaddingRight);
        allocateDirect.putDouble(tDFViewportMetrics.viewPaddingBottom);
        allocateDirect.putDouble(tDFViewportMetrics.viewPaddingLeft);
        allocateDirect.putDouble(tDFViewportMetrics.systemGestureInsetTop);
        allocateDirect.putDouble(tDFViewportMetrics.systemGestureInsetRight);
        allocateDirect.putDouble(tDFViewportMetrics.systemGestureInsetBottom);
        allocateDirect.putDouble(tDFViewportMetrics.systemGestureInsetLeft);
        allocateDirect.putDouble(tDFViewportMetrics.leftFromWindow);
        allocateDirect.putDouble(tDFViewportMetrics.topFromWindow);
        return allocateDirect;
    }

    public void attach(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.objectId = j3;
        }
    }

    public void handleKeyEvent(long j3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(j3), keyEvent);
        } else {
            ByteBuffer serializeKeyEvent = serializeKeyEvent(keyEvent);
            handleEventData(this.objectId, j3, 2, serializeKeyEvent, serializeKeyEvent.position());
        }
    }

    public void handleMotionEvent(long j3, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), motionEvent);
        } else {
            ByteBuffer serializeMotionEvent = serializeMotionEvent(motionEvent);
            handleEventData(this.objectId, j3, 1, serializeMotionEvent, serializeMotionEvent.position());
        }
    }

    public void handleViewportEvent(long j3, TDFViewportMetrics tDFViewportMetrics) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), tDFViewportMetrics);
        } else {
            ByteBuffer serializeViewportMetrics = serializeViewportMetrics(tDFViewportMetrics);
            handleEventData(this.objectId, j3, 3, serializeViewportMetrics, serializeViewportMetrics.position());
        }
    }
}

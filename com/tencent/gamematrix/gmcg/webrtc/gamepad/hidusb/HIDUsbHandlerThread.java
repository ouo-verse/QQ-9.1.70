package com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public class HIDUsbHandlerThread extends BaseHandlerThread {
    private static final String TAG = "hidusb";
    private OnUsbHandlerListener mListener;
    private HIDUsbHandler mUsbHandler;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private static class HIDUsbHandler extends Handler {
        private WeakReference<OnUsbHandlerListener> mWeakOnListener;

        public HIDUsbHandler(Looper looper, OnUsbHandlerListener onUsbHandlerListener) {
            super(looper);
            this.mWeakOnListener = new WeakReference<>(onUsbHandlerListener);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            OnUsbHandlerListener onUsbHandlerListener;
            super.handleMessage(message);
            WeakReference<OnUsbHandlerListener> weakReference = this.mWeakOnListener;
            if (weakReference != null && (onUsbHandlerListener = weakReference.get()) != null) {
                onUsbHandlerListener.onMsg(message.what);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface OnUsbHandlerListener {
        boolean onMsg(int i3);
    }

    public HIDUsbHandlerThread(String str, OnUsbHandlerListener onUsbHandlerListener) {
        super(str);
        this.mListener = onUsbHandlerListener;
        this.mUsbHandler = null;
    }

    public void sendMessageDelayed(int i3, long j3) {
        HIDUsbHandler hIDUsbHandler = this.mUsbHandler;
        if (hIDUsbHandler != null) {
            hIDUsbHandler.sendEmptyMessageDelayed(i3, j3);
        }
    }

    public void startHandlerThread() {
        if (!isAlive()) {
            start();
        }
        if (this.mUsbHandler == null) {
            this.mUsbHandler = new HIDUsbHandler(getLooper(), this.mListener);
        }
    }
}

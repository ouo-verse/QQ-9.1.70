package com.tencent.ams.fusion.widget.animatorview.render;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.ams.fusion.widget.animatorview.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AnimatorRenderHandler {
    static IPatchRedirector $redirector_ = null;
    private static final int EVENT_POST_FRAME_CALLBACK = 1;
    private static final int EVENT_QUIT_THREAD = 3;
    private static final int EVENT_REMOVE_FRAME_CALLBACK = 2;
    private static final int QUIT_THREAD_DELAY = 3000;
    private static final String TAG = "AnimatorRenderHandler";
    private static final AnimatorRenderHandler instance;
    private final List<EventListener> mEventListeners;
    private RenderHandler mRenderHandler;
    private HandlerThread mRenderThread;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface EventListener {
        void onPostFrameCallback();

        void onRemoveFrameCallback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class RenderHandler extends Handler {
        static IPatchRedirector $redirector_;

        RenderHandler(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnimatorRenderHandler.this, (Object) looper);
            }
        }

        private void postFrameCallback() {
            Logger.i(AnimatorRenderHandler.TAG, "postFrameCallback");
            Iterator it = AnimatorRenderHandler.this.mEventListeners.iterator();
            while (it.hasNext()) {
                ((EventListener) it.next()).onPostFrameCallback();
            }
        }

        private void removeFrameCallback() {
            Logger.i(AnimatorRenderHandler.TAG, "removeFrameCallback");
            Iterator it = AnimatorRenderHandler.this.mEventListeners.iterator();
            while (it.hasNext()) {
                ((EventListener) it.next()).onRemoveFrameCallback();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        getLooper().quitSafely();
                        Logger.i(AnimatorRenderHandler.TAG, "quit looper");
                        return;
                    }
                    return;
                }
                removeFrameCallback();
                return;
            }
            postFrameCallback();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50086);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            instance = new AnimatorRenderHandler();
        }
    }

    AnimatorRenderHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mEventListeners = new CopyOnWriteArrayList();
        }
    }

    public static AnimatorRenderHandler getInstance() {
        return instance;
    }

    public void addEventListener(EventListener eventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) eventListener);
            return;
        }
        Logger.i(TAG, "addEventListener");
        if (eventListener != null && !this.mEventListeners.contains(eventListener)) {
            this.mEventListeners.add(eventListener);
        }
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Logger.i(TAG, "pause");
        RenderHandler renderHandler = this.mRenderHandler;
        if (renderHandler != null) {
            renderHandler.removeMessages(1);
        }
    }

    public void postTaskOnRenderThread(Runnable runnable, boolean z16) {
        HandlerThread handlerThread;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, runnable, Boolean.valueOf(z16));
            return;
        }
        if (runnable != null && this.mRenderHandler != null && (handlerThread = this.mRenderThread) != null && handlerThread.isAlive()) {
            if (z16) {
                this.mRenderHandler.postAtFrontOfQueue(runnable);
            } else {
                this.mRenderHandler.post(runnable);
            }
        }
    }

    public void removeEventListener(EventListener eventListener) {
        HandlerThread handlerThread;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) eventListener);
            return;
        }
        Logger.i(TAG, "removeEventListener");
        if (eventListener != null) {
            this.mEventListeners.remove(eventListener);
        }
        if (this.mEventListeners.size() == 0) {
            Logger.i(TAG, "removeEventListener, event listeners is empty");
            if (this.mRenderHandler != null && (handlerThread = this.mRenderThread) != null && handlerThread.isAlive()) {
                this.mRenderHandler.sendEmptyMessageDelayed(3, 3000L);
            }
        }
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            Logger.i(TAG, "resume");
            sendEventPostFrameCallback();
        }
    }

    public void sendEventPostFrameCallback() {
        HandlerThread handlerThread;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.mRenderHandler != null && (handlerThread = this.mRenderThread) != null && handlerThread.isAlive()) {
            Logger.i(TAG, "sendEventPostFrameCallback");
            this.mRenderHandler.removeMessages(3);
            this.mRenderHandler.removeMessages(2);
            this.mRenderHandler.sendEmptyMessage(1);
        }
    }

    public void sendEventRemoveFrameCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        HandlerThread handlerThread = this.mRenderThread;
        if (handlerThread != null && handlerThread.isAlive() && this.mRenderHandler != null) {
            Logger.i(TAG, "sendEventRemoveFrameCallback");
            this.mRenderHandler.sendEmptyMessage(2);
        }
    }

    public synchronized void startRenderThread() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        HandlerThread handlerThread = this.mRenderThread;
        if (handlerThread != null && handlerThread.isAlive()) {
            Logger.i(TAG, "startRenderThread, render thread is alive");
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Animator-Render-Thread", -19);
        baseHandlerThread.start();
        this.mRenderHandler = new RenderHandler(baseHandlerThread.getLooper());
        this.mRenderThread = baseHandlerThread;
        Logger.i(TAG, "startRenderThread, render thread: " + this.mRenderThread);
    }
}

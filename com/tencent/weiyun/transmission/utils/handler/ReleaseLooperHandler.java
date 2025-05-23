package com.tencent.weiyun.transmission.utils.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.transmission.utils.thread.ThreadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ReleaseLooperHandler implements DispatchCallback, Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final long DELAY_RELEASE = 10000;
    private List<Handler.Callback> mCallbackList;
    private Handler mQueueHandler;
    private Looper mQueueLooper;
    private String mThreadName;
    private List<Integer> mWhatList;

    public ReleaseLooperHandler(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.mThreadName = str;
            this.mCallbackList = new ArrayList();
        }
    }

    private void checkEnd() {
        List<Integer> list = this.mWhatList;
        if (list != null && list.size() == 0) {
            ThreadUtils.postDelayed(new Runnable() { // from class: com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReleaseLooperHandler.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        ReleaseLooperHandler.this.releaseInner();
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            }, 10000L);
        }
    }

    private synchronized void initIfNeed() {
        if (this.mQueueHandler == null) {
            TsLog.i("init queue " + this.mThreadName + " thread handler");
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread(this.mThreadName);
            baseHandlerThread.start();
            this.mQueueLooper = baseHandlerThread.getLooper();
            this.mWhatList = new ArrayList();
            this.mQueueHandler = new CntHandler(this.mQueueLooper, this, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void releaseInner() {
        List<Integer> list = this.mWhatList;
        if (list != null && list.size() == 0) {
            this.mQueueHandler = null;
            this.mWhatList.clear();
            this.mWhatList = null;
            this.mQueueLooper.quit();
            TsLog.i("end queue " + this.mThreadName + " thread handler");
        }
    }

    public synchronized void addCallback(Handler.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback);
        } else {
            this.mCallbackList.add(callback);
        }
    }

    @Override // com.tencent.weiyun.transmission.utils.handler.DispatchCallback
    public synchronized void dispatchMsgFinished(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) message);
        } else {
            this.mWhatList.remove(Integer.valueOf(message.what));
            checkEnd();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) message)).booleanValue();
        }
        List<Handler.Callback> list = this.mCallbackList;
        if (list != null) {
            Iterator<Handler.Callback> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().handleMessage(message)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public synchronized void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            checkEnd();
        }
    }

    public synchronized void removeCallback(Handler.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) callback);
        } else {
            this.mCallbackList.remove(callback);
        }
    }

    public synchronized void removeMessages(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        initIfNeed();
        Iterator<Integer> it = this.mWhatList.iterator();
        while (it.hasNext()) {
            if (it.next().intValue() == i3) {
                it.remove();
            }
        }
        this.mQueueHandler.removeMessages(i3);
        checkEnd();
    }

    public final synchronized boolean sendEmptyMessage(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
        }
        initIfNeed();
        this.mWhatList.add(Integer.valueOf(i3));
        return this.mQueueHandler.sendEmptyMessage(i3);
    }

    public final synchronized boolean sendEmptyMessageDelayed(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Long.valueOf(j3))).booleanValue();
        }
        initIfNeed();
        this.mWhatList.add(Integer.valueOf(i3));
        return this.mQueueHandler.sendEmptyMessageDelayed(i3, j3);
    }

    public final synchronized boolean sendMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message)).booleanValue();
        }
        initIfNeed();
        this.mWhatList.add(Integer.valueOf(message.what));
        return this.mQueueHandler.sendMessage(message);
    }

    public final synchronized boolean sendMessageDelayed(Message message, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, message, Long.valueOf(j3))).booleanValue();
        }
        initIfNeed();
        this.mWhatList.add(Integer.valueOf(message.what));
        return this.mQueueHandler.sendMessageDelayed(message, j3);
    }
}

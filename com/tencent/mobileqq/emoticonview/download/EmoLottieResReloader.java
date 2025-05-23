package com.tencent.mobileqq.emoticonview.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmoLottieResReloader implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    protected static final int MSG_RELOAD_DRAWABLE = 10002;
    public static final String TAG = "EmoLottieResReloader";
    private Handler mHandler;
    private final Lock mLoadingLock;
    private IResReloadListener mResReloadListener;
    protected ArrayList<String> mWaitingReloadList;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface IResReloadListener {
        void startReloadDrawable(String str);

        void triggerDownloadRes();
    }

    public EmoLottieResReloader(IResReloadListener iResReloadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iResReloadListener);
            return;
        }
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        this.mLoadingLock = new ReentrantLock();
        this.mResReloadListener = iResReloadListener;
    }

    public void addReloadList(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        this.mLoadingLock.lock();
        try {
            if (this.mWaitingReloadList == null) {
                this.mWaitingReloadList = new ArrayList<>();
                triggerDownloadRes();
            }
            if (!this.mWaitingReloadList.contains(str)) {
                this.mWaitingReloadList.add(0, str);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "addReloadLottieDrawable key:", str, " ,size:", Integer.valueOf(this.mWaitingReloadList.size()));
                }
            }
        } finally {
            this.mLoadingLock.unlock();
        }
    }

    public void clearReloadList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList<String> arrayList = this.mWaitingReloadList;
        if (arrayList != null && arrayList.size() > 0) {
            this.mLoadingLock.lock();
            try {
                if (this.mWaitingReloadList.size() > 0) {
                    this.mWaitingReloadList.clear();
                }
            } finally {
                this.mLoadingLock.unlock();
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ArrayList<String> arrayList;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 10002 && (arrayList = this.mWaitingReloadList) != null && arrayList.size() > 0) {
            this.mLoadingLock.lock();
            try {
                if (this.mWaitingReloadList.size() > 0) {
                    str = this.mWaitingReloadList.remove(0);
                } else {
                    str = null;
                }
                if (str != null) {
                    IResReloadListener iResReloadListener = this.mResReloadListener;
                    if (iResReloadListener != null) {
                        iResReloadListener.startReloadDrawable(str);
                    }
                    if (this.mWaitingReloadList.size() > 0) {
                        this.mHandler.sendEmptyMessageDelayed(10002, 300L);
                    } else if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "finish reloading");
                    }
                }
            } finally {
                this.mLoadingLock.unlock();
            }
        }
        return false;
    }

    public void nofityReloadList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mHandler.sendEmptyMessage(10002);
        }
    }

    protected void triggerDownloadRes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        IResReloadListener iResReloadListener = this.mResReloadListener;
        if (iResReloadListener != null) {
            iResReloadListener.triggerDownloadRes();
        }
    }
}

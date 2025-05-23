package com.tencent.mobileqq.emoticon;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQSysAndEmojiResReloader implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    protected static final int MSG_RELOAD_DRAWABLE = 10001;
    public static final String TAG = "NT_QQSysAndEmojiResReloader";
    private Handler mHandler;
    private final Lock mLoadingLock;
    private IResReloadListener mResReloadListener;
    protected ArrayList<Integer> mWaitingReloadList;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface IResReloadListener {
        void resDownloadFinish();

        void startReloadDrawable(int i3);
    }

    public QQSysAndEmojiResReloader(IResReloadListener iResReloadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iResReloadListener);
            return;
        }
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        this.mLoadingLock = new ReentrantLock();
        this.mResReloadListener = iResReloadListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$triggerDownloadRes$0() {
        if (QQSysAndEmojiResMgr.getInstance() != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "trigger downloadEmoticonRes");
            }
            QQSysAndEmojiResMgr.getInstance().downloadEmoticonRes(Arrays.asList(1, 2, 3, 6, 7));
        }
    }

    public void addReloadList(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        this.mLoadingLock.lock();
        try {
            if (this.mWaitingReloadList == null) {
                this.mWaitingReloadList = new ArrayList<>();
                triggerDownloadRes();
            }
            if (!this.mWaitingReloadList.contains(Integer.valueOf(i3))) {
                this.mWaitingReloadList.add(0, Integer.valueOf(i3));
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "addReloadDrawable idx:", Integer.valueOf(i3), " ,size:", Integer.valueOf(this.mWaitingReloadList.size()));
                }
            }
        } finally {
            this.mLoadingLock.unlock();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ArrayList<Integer> arrayList;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 10001 && (arrayList = this.mWaitingReloadList) != null && arrayList.size() > 0) {
            this.mLoadingLock.lock();
            try {
                if (this.mWaitingReloadList.size() > 0) {
                    i3 = this.mWaitingReloadList.remove(0).intValue();
                } else {
                    i3 = -1;
                }
                if (i3 > -1) {
                    IResReloadListener iResReloadListener = this.mResReloadListener;
                    if (iResReloadListener != null) {
                        iResReloadListener.startReloadDrawable(i3);
                    }
                    if (this.mWaitingReloadList.size() > 0) {
                        this.mHandler.sendEmptyMessageDelayed(10001, 300L);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mHandler.sendEmptyMessage(10001);
        }
    }

    protected void triggerDownloadRes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.emoticon.p
                @Override // java.lang.Runnable
                public final void run() {
                    QQSysAndEmojiResReloader.lambda$triggerDownloadRes$0();
                }
            });
        }
    }
}

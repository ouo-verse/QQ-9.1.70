package com.tencent.tmdownloader.notify;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class DownloadTaskNotifier {
    static IPatchRedirector $redirector_ = null;
    public static final int COMPLETED = 4;
    public static final int FAILED = 3;
    public static final int PAUSED = 2;
    public static final int STARTED = 1;
    private static final String TAG = "DownloadTaskNotifier_";
    private static volatile DownloadTaskNotifier sInstance;
    private final Object locker;
    private List<WeakReference<DownloadGlobalListener>> mListener;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11108);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    DownloadTaskNotifier() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.locker = new Object();
            this.mListener = new ArrayList();
        }
    }

    public static DownloadTaskNotifier get() {
        if (sInstance == null) {
            synchronized (DownloadTaskNotifier.class) {
                if (sInstance == null) {
                    sInstance = new DownloadTaskNotifier();
                }
            }
        }
        return sInstance;
    }

    public void addListener(DownloadGlobalListener downloadGlobalListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloadGlobalListener);
            return;
        }
        if (downloadGlobalListener == null) {
            return;
        }
        synchronized (this.locker) {
            Iterator it = new ArrayList(this.mListener).iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null && weakReference.get() == downloadGlobalListener) {
                    return;
                }
            }
            this.mListener.add(new WeakReference<>(downloadGlobalListener));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void notify(DownloadTaskInfo downloadTaskInfo, int i3) {
        DownloadGlobalListener downloadGlobalListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) downloadTaskInfo, i3);
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.locker) {
            List<WeakReference<DownloadGlobalListener>> list = this.mListener;
            if (list != null && list.size() > 0) {
                arrayList.addAll(list);
            }
        }
        if (arrayList.size() == 0) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference == null) {
                downloadGlobalListener = null;
            } else {
                downloadGlobalListener = (DownloadGlobalListener) weakReference.get();
            }
            if (downloadGlobalListener != null) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                try {
                                    downloadGlobalListener.onTaskCompleted(downloadTaskInfo);
                                } catch (Exception unused) {
                                }
                            }
                            while (it.hasNext()) {
                            }
                        } else {
                            downloadGlobalListener.onTaskFailed(downloadTaskInfo);
                        }
                    } else {
                        downloadGlobalListener.onTaskPaused(downloadTaskInfo);
                    }
                } else {
                    downloadGlobalListener.onTaskStarted(downloadTaskInfo);
                }
            }
        }
    }
}

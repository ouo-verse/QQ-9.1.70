package com.tencent.mobileqq.app.face;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.Thread;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class FaceDecodeTask {
    static IPatchRedirector $redirector_ = null;
    protected static int EVENT_TASK_COMPLETED = 0;
    protected static int MAX_THREAD_COUNT = 0;
    private static final String TAG = "Q.qqhead.FaceDecodeTask";
    protected static Handler handler;
    protected static Object initlock;
    protected static ArrayList<FaceDecodeTask> mDecodeQueue;
    protected static FaceDecodeRunnable[] mDecodeRunnables;
    protected static Thread[] mDecodeThreads;
    private static FaceDecodeThreadInfo mThreadInfo;
    protected static Looper mainLooper;
    public static ArrayList<FaceDecodeTask> sPendingResultList;
    protected Bitmap bitmap;
    protected FaceInfo faceInfo;
    protected SoftReference<DecodeCompletionListener> mDecodeCompletionListenerWrf;
    protected boolean needDownload;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class FaceDecodeThreadInfo {
        static IPatchRedirector $redirector_ = null;
        public static final int DEFATUL_VAL = Integer.MIN_VALUE;
        int maxThreadCount;
        int priority;

        public FaceDecodeThreadInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.maxThreadCount = Integer.MIN_VALUE;
                this.priority = Integer.MIN_VALUE;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18329);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        EVENT_TASK_COMPLETED = 111;
        MAX_THREAD_COUNT = 6;
        initlock = new Object();
        sPendingResultList = new ArrayList<>(100);
    }

    public FaceDecodeTask(AppInterface appInterface, FaceInfo faceInfo, DecodeCompletionListener decodeCompletionListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appInterface, faceInfo, decodeCompletionListener);
            return;
        }
        this.bitmap = null;
        this.faceInfo = faceInfo;
        this.mDecodeCompletionListenerWrf = new SoftReference<>(decodeCompletionListener);
        this.needDownload = false;
    }

    public static void closeFaceDecodeThread() {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "closeFaceDecodeThread");
        }
        synchronized (initlock) {
            ArrayList<FaceDecodeTask> arrayList = sPendingResultList;
            if (arrayList != null) {
                arrayList.clear();
            }
            Handler handler2 = handler;
            if (handler2 != null) {
                handler2.removeMessages(EVENT_TASK_COMPLETED);
            }
            if (mDecodeRunnables != null) {
                int i3 = 0;
                while (true) {
                    FaceDecodeRunnable[] faceDecodeRunnableArr = mDecodeRunnables;
                    if (i3 >= faceDecodeRunnableArr.length) {
                        break;
                    }
                    FaceDecodeRunnable faceDecodeRunnable = faceDecodeRunnableArr[i3];
                    if (faceDecodeRunnable != null) {
                        faceDecodeRunnable.close();
                    }
                    i3++;
                }
                mDecodeRunnables = null;
                mDecodeThreads = null;
            }
            ArrayList<FaceDecodeTask> arrayList2 = mDecodeQueue;
            if (arrayList2 != null) {
                synchronized (arrayList2) {
                    mDecodeQueue.clear();
                    mDecodeQueue.notifyAll();
                }
            }
            mDecodeQueue = null;
            mainLooper = null;
            handler = null;
        }
    }

    public static void execute(FaceDecodeTask faceDecodeTask) {
        String str;
        if (faceDecodeTask != null && !faceDecodeTask.isExpired()) {
            initFaceDecodeThread();
            synchronized (mDecodeQueue) {
                mDecodeQueue.add(faceDecodeTask);
                mDecodeQueue.notify();
            }
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("execute, decodeTaskInfo is expired, type=");
            if (faceDecodeTask != null) {
                str = faceDecodeTask.getClass().getSimpleName();
            } else {
                str = "";
            }
            sb5.append(str);
            QLog.w(TAG, 2, sb5.toString());
        }
    }

    public static void executeTask(AppInterface appInterface, FaceInfo faceInfo, DecodeCompletionListener decodeCompletionListener) {
        execute(getFaceDecodeTask(appInterface, faceInfo, decodeCompletionListener));
        faceInfo.markTime(FaceInfo.TIME_END_DOWNLOAD);
    }

    public static FaceDecodeTask getFaceDecodeTask(AppInterface appInterface, FaceInfo faceInfo, DecodeCompletionListener decodeCompletionListener) {
        if (appInterface == null) {
            return null;
        }
        if (FaceConstant.NEARBY_MODULAR_MODULE_ID.equals(appInterface.getModuleId())) {
            return new j(appInterface, faceInfo, decodeCompletionListener);
        }
        return new FaceDecodeTaskImpl(appInterface, faceInfo, decodeCompletionListener);
    }

    public static FaceDecodeThreadInfo getNearbyFaceDecodeThreadInfo() {
        FaceDecodeThreadInfo faceDecodeThreadInfo = new FaceDecodeThreadInfo();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "processor count:" + availableProcessors);
        }
        if (availableProcessors < 4) {
            faceDecodeThreadInfo.maxThreadCount = availableProcessors + 1;
            if (availableProcessors <= 2) {
                faceDecodeThreadInfo.priority = 10;
            }
        }
        return faceDecodeThreadInfo;
    }

    private static void initFaceDecodeThread() {
        boolean z16;
        if (mDecodeThreads == null) {
            synchronized (initlock) {
                if (mDecodeThreads == null) {
                    initHandler();
                    String str = BaseApplication.processName;
                    initFaceDecodeThreadInfo();
                    int i3 = mThreadInfo.maxThreadCount;
                    if (i3 != Integer.MIN_VALUE) {
                        MAX_THREAD_COUNT = i3;
                    }
                    if (!TextUtils.isEmpty(str) && str.equals(MobileQQ.PACKAGE_NAME)) {
                        MAX_THREAD_COUNT = 2;
                    }
                    mDecodeQueue = new ArrayList<>();
                    int i16 = MAX_THREAD_COUNT;
                    mDecodeThreads = new Thread[i16];
                    mDecodeRunnables = new FaceDecodeRunnable[i16];
                    for (int i17 = 0; i17 < mDecodeThreads.length; i17++) {
                        try {
                            mDecodeRunnables[i17] = new FaceDecodeRunnable(null);
                            mDecodeThreads[i17] = ThreadManagerV2.newFreeThread(mDecodeRunnables[i17], "FaceDecodeThread", 5);
                            if (com.tencent.qqperf.opt.threadpriority.a.c().e()) {
                                mDecodeThreads[i17].setPriority(1);
                            }
                            if (mDecodeThreads[i17].getState() == Thread.State.NEW) {
                                mDecodeThreads[i17].start();
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i(TAG, 2, "initFaceDecodeThread, thread isStatusNew=" + z16);
                            }
                        } catch (Throwable th5) {
                            QLog.e(TAG, 1, "initFaceDecodeThread", th5);
                            return;
                        }
                    }
                }
            }
        }
    }

    private static void initFaceDecodeThreadInfo() {
        if (TextUtils.isEmpty(BaseApplication.processName)) {
            return;
        }
        if (BaseApplication.processName.equals(MobileQQ.PACKAGE_NAME + ":tool")) {
            mThreadInfo = getNearbyFaceDecodeThreadInfo();
        } else {
            mThreadInfo = new FaceDecodeThreadInfo();
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "initFaceDecodeThreadInfo, maxThreadCount=" + mThreadInfo.maxThreadCount + ",priority=" + mThreadInfo.priority);
        }
    }

    private static void initHandler() {
        mainLooper = Looper.getMainLooper();
        handler = new Handler(mainLooper) { // from class: com.tencent.mobileqq.app.face.FaceDecodeTask.1
            static IPatchRedirector $redirector_;

            {
                super(r4);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                SoftReference<DecodeCompletionListener> softReference;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                    return;
                }
                if (message != null && message.what == FaceDecodeTask.EVENT_TASK_COMPLETED) {
                    if (FaceDecodeTask.sPendingResultList.size() > 0) {
                        for (int i3 = 0; i3 < FaceDecodeTask.sPendingResultList.size(); i3++) {
                            FaceDecodeTask faceDecodeTask = FaceDecodeTask.sPendingResultList.get(i3);
                            if (faceDecodeTask != null && faceDecodeTask.faceInfo != null && (softReference = faceDecodeTask.mDecodeCompletionListenerWrf) != null && softReference.get() != null) {
                                DecodeCompletionListener decodeCompletionListener = faceDecodeTask.mDecodeCompletionListenerWrf.get();
                                if (decodeCompletionListener == null) {
                                    return;
                                }
                                if (faceDecodeTask.needDownload) {
                                    FaceInfo faceInfo = faceDecodeTask.faceInfo;
                                    faceInfo.faceFileType = (byte) 2;
                                    decodeCompletionListener.onDecodeTaskCompletedNeedDownload(faceInfo);
                                } else {
                                    decodeCompletionListener.onDecodeTaskCompleted(faceDecodeTask.faceInfo, faceDecodeTask.bitmap);
                                }
                            }
                        }
                        FaceDecodeTask.sPendingResultList.clear();
                        return;
                    }
                    FaceDecodeTask faceDecodeTask2 = (FaceDecodeTask) message.obj;
                    if (faceDecodeTask2 != null && faceDecodeTask2.faceInfo != null) {
                        SoftReference<DecodeCompletionListener> softReference2 = faceDecodeTask2.mDecodeCompletionListenerWrf;
                        if (softReference2 == null) {
                            QLog.e(FaceDecodeTask.TAG, 1, "handleMessage wrf is null");
                            return;
                        }
                        DecodeCompletionListener decodeCompletionListener2 = softReference2.get();
                        if (decodeCompletionListener2 == null) {
                            QLog.e(FaceDecodeTask.TAG, 1, "handleMessage wrf ref null");
                            return;
                        }
                        if (faceDecodeTask2.needDownload) {
                            FaceInfo faceInfo2 = faceDecodeTask2.faceInfo;
                            faceInfo2.faceFileType = (byte) 2;
                            decodeCompletionListener2.onDecodeTaskCompletedNeedDownload(faceInfo2);
                            return;
                        } else {
                            faceDecodeTask2.faceInfo.markTime(FaceInfo.TIME_REQ_END);
                            decodeCompletionListener2.onDecodeTaskCompleted(faceDecodeTask2.faceInfo, faceDecodeTask2.bitmap);
                            return;
                        }
                    }
                    QLog.e(FaceDecodeTask.TAG, 1, "handleMessage : ");
                }
            }
        };
    }

    protected abstract void doDecodeBitmap();

    protected abstract boolean isExpired();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class FaceDecodeRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        private boolean isRunning;

        FaceDecodeRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.isRunning = true;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void close() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.isRunning = false;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            Thread currentThread = Thread.currentThread();
            currentThread.setName("FaceDecodeThread" + currentThread.getId());
            String str = BaseApplication.processName;
            if (!TextUtils.isEmpty(str) && str.equals(MobileQQ.PACKAGE_NAME)) {
                Process.setThreadPriority(-8);
            } else if (FaceDecodeTask.mThreadInfo.priority != Integer.MIN_VALUE) {
                Process.setThreadPriority(FaceDecodeTask.mThreadInfo.priority);
            }
            FaceDecodeTask faceDecodeTask = null;
            while (this.isRunning) {
                synchronized (FaceDecodeTask.mDecodeQueue) {
                    if (FaceDecodeTask.mDecodeQueue.size() == 0) {
                        try {
                            LockMethodProxy.wait(FaceDecodeTask.mDecodeQueue);
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        faceDecodeTask = FaceDecodeTask.mDecodeQueue.remove(0);
                    }
                }
                if (faceDecodeTask != null) {
                    faceDecodeTask.doDecodeBitmap();
                }
            }
        }

        /* synthetic */ FaceDecodeRunnable(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) anonymousClass1);
        }
    }
}

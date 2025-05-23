package com.tencent.mobileqq.scribble.impl;

import android.os.Handler;
import android.os.Message;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.scribble.IScribbleDownloader;
import com.tencent.mobileqq.scribble.IScribbleMsgUtils;
import com.tencent.mobileqq.scribble.d;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.DebugKt;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ScribbleDownloaderImpl implements IScribbleDownloader, Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    static final int MAX_HANDLING_DOWNLOADING = 2;
    static final int MSG_OPEN_PRE_DOWNLOADING = 111;
    public String TAG;
    AppRuntime mApp;
    AtomicBoolean mIsPreDownloaderOpen;
    public a mListManager;
    protected Handler subHandler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private PriorityBlockingQueue<d> f282569a;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<d> f282570b;

        /* renamed from: c, reason: collision with root package name */
        private Lock f282571c;

        /* renamed from: d, reason: collision with root package name */
        public final int f282572d;

        /* renamed from: e, reason: collision with root package name */
        public final int f282573e;

        /* renamed from: f, reason: collision with root package name */
        public final int f282574f;

        /* renamed from: g, reason: collision with root package name */
        public final int f282575g;

        /* renamed from: h, reason: collision with root package name */
        public final int f282576h;

        /* renamed from: i, reason: collision with root package name */
        public final int f282577i;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScribbleDownloaderImpl.this);
                return;
            }
            this.f282569a = new PriorityBlockingQueue<>();
            this.f282570b = new ArrayList<>();
            this.f282571c = new ReentrantLock();
            this.f282572d = -1;
            this.f282573e = 0;
            this.f282574f = 1;
            this.f282575g = 2;
            this.f282576h = 0;
            this.f282577i = -1;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x007f A[Catch: all -> 0x008c, TRY_LEAVE, TryCatch #0 {all -> 0x008c, blocks: (B:10:0x001b, B:13:0x0026, B:15:0x002e, B:21:0x004c, B:23:0x0054, B:24:0x005a, B:26:0x0060, B:29:0x0072, B:31:0x0078, B:33:0x007f, B:17:0x0045), top: B:9:0x001b }] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0085  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int a(d dVar) {
            int i3;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar)).intValue();
            }
            this.f282571c.lock();
            try {
                int i17 = 0;
                boolean z17 = true;
                if (this.f282570b.size() > 0) {
                    for (int i18 = 0; i18 < this.f282570b.size(); i18++) {
                        if (dVar.f282556d.uniseq == this.f282570b.get(i18).f282556d.uniseq) {
                            i3 = 1;
                            z16 = true;
                            break;
                        }
                    }
                }
                i3 = -1;
                z16 = false;
                if (!z16 && this.f282569a.size() > 0) {
                    Iterator<d> it = this.f282569a.iterator();
                    while (it.hasNext()) {
                        d next = it.next();
                        if (next.f282556d.uniseq == dVar.f282556d.uniseq) {
                            int i19 = next.f282557e;
                            int i26 = dVar.f282557e;
                            if (i19 < i26) {
                                next.f282557e = i26;
                            }
                            if (z17) {
                                this.f282569a.add(dVar);
                            } else {
                                i17 = i16;
                            }
                            return i17;
                        }
                    }
                }
                i16 = i3;
                z17 = z16;
                if (z17) {
                }
                return i17;
            } finally {
                this.f282571c.unlock();
            }
        }

        public int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            this.f282571c.lock();
            try {
                int size = this.f282570b.size();
                this.f282571c.unlock();
                ScribbleDownloaderImpl.this.log("getDownloadingSize", "downing size is " + size);
                return size;
            } catch (Throwable th5) {
                this.f282571c.unlock();
                throw th5;
            }
        }

        public int c(MessageForScribble messageForScribble) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageForScribble)).intValue();
            }
            this.f282571c.lock();
            try {
                if (this.f282570b.size() > 0) {
                    i3 = 0;
                    for (int i16 = 0; i16 < this.f282570b.size(); i16++) {
                        if (messageForScribble.uniseq == this.f282570b.get(i16).f282556d.uniseq) {
                            this.f282570b.remove(i16);
                            break;
                        }
                    }
                }
                i3 = -1;
                return i3;
            } finally {
                this.f282571c.unlock();
            }
        }

        public d d() {
            d dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (d) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            this.f282571c.lock();
            try {
                if (this.f282569a.size() > 0) {
                    dVar = this.f282569a.poll();
                    this.f282570b.add(dVar);
                } else {
                    dVar = null;
                }
                return dVar;
            } finally {
                this.f282571c.unlock();
            }
        }
    }

    public ScribbleDownloaderImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.TAG = "ScribbleDownloader";
        this.mIsPreDownloaderOpen = new AtomicBoolean(true);
        this.mListManager = new a();
    }

    private void addDownload(d dVar) {
        log("addDownload", "result is " + this.mListManager.a(dVar));
        consumeDownload();
    }

    private void consumeDownload() {
        if (this.mListManager.b() < 2) {
            d d16 = this.mListManager.d();
            if (d16 == null) {
                log("consumeDownload", "removeOneFromWaitToDowning is null");
                return;
            } else {
                doDownload(d16);
                return;
            }
        }
        log("consumeDownload", "donwloading is max threads");
    }

    private void doDownload(d dVar) {
        ThreadManagerV2.post(new Runnable(dVar) { // from class: com.tencent.mobileqq.scribble.impl.ScribbleDownloaderImpl.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ d f282568d;

            {
                this.f282568d = dVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ScribbleDownloaderImpl.this, (Object) dVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                ScribbleDownloaderImpl.this.log("dowmthreak", "start download ,uniseq:" + this.f282568d.f282556d.uniseq);
                ((IScribbleMsgUtils) QRoute.api(IScribbleMsgUtils.class)).downloadScribble(this.f282568d.f282556d);
            }
        }, 5, null, false);
    }

    private boolean isNeedPreDownload() {
        int a16 = com.tencent.mobileqq.pic.a.a();
        if (a16 != 0) {
            log("isNeedPreDownload", "Not Wifi, networkType=" + a16 + ", no need to predownload");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str, String str2) {
        if (QLog.isColorLevel()) {
            if (str2 == null) {
                str2 = "";
            }
            QLog.d(this.TAG, 2, str + "(): " + str2);
        }
    }

    private void logE(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        QLog.e(this.TAG, 2, str + "(): " + str2);
    }

    @Override // com.tencent.mobileqq.scribble.IScribbleDownloader
    public void DownloadFromAio(MessageForScribble messageForScribble) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageForScribble);
            return;
        }
        log("DownloadFromAio", "uniseq=" + messageForScribble.uniseq);
        addDownload(new d(messageForScribble, 201));
    }

    @Override // com.tencent.mobileqq.scribble.IScribbleDownloader
    public void PreDownloadFromMsg(MessageForScribble messageForScribble) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageForScribble);
            return;
        }
        log("PreDownloadFromMsg", "uniseq=" + messageForScribble.uniseq);
        if (isNeedPreDownload()) {
            addDownload(new d(messageForScribble, 200));
            return;
        }
        log("PreDownloadFromMsg", "no NeedPreDownload uniseq=" + messageForScribble.uniseq);
    }

    @Override // com.tencent.mobileqq.scribble.IScribbleDownloader
    public void checkBDHsessionkey() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        synchronized (SessionInfo.class) {
            if (SessionInfo.getInstance(this.mApp.getCurrentUin()).getHttpconn_sig_session() != null) {
                i3 = SessionInfo.getInstance(this.mApp.getCurrentUin()).getHttpconn_sig_session().length;
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                AppRuntime appRuntime = this.mApp;
                HwServlet.getConfig(appRuntime, appRuntime.getCurrentUin());
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 111) {
            if (!this.mIsPreDownloaderOpen.get()) {
                this.mIsPreDownloaderOpen.set(true);
                log("handleMessage", "MSG_OPEN_PRE_DOWNLOADING, mIsPreDownloaderOpen=" + this.mIsPreDownloaderOpen.get());
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.scribble.IScribbleDownloader
    public void off() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.mIsPreDownloaderOpen.set(false);
        log(DebugKt.DEBUG_PROPERTY_VALUE_OFF, "mIsPreDownloaderOpen=" + this.mIsPreDownloaderOpen.get());
        this.subHandler.sendEmptyMessageDelayed(111, 60000L);
    }

    @Override // com.tencent.mobileqq.scribble.IScribbleDownloader
    public void on() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.mIsPreDownloaderOpen.set(true);
        log("on", " mIsPreDownloaderOpen=" + this.mIsPreDownloaderOpen.get());
        consumeDownload();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = appRuntime;
            this.subHandler = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            log(MosaicConstants$JsFunction.FUNC_ON_DESTROY, null);
            this.mApp = null;
        }
    }

    @Override // com.tencent.mobileqq.scribble.IScribbleDownloader
    public int removeDownloadedMsg(MessageForScribble messageForScribble) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) messageForScribble)).intValue();
        }
        int c16 = this.mListManager.c(messageForScribble);
        log("removeDownloadedMsg", " result is " + c16);
        consumeDownload();
        return c16;
    }
}

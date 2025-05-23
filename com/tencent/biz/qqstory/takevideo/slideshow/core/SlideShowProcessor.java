package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.app.Activity;
import android.opengl.EGLContext;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglHandlerThread;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThrowablesUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes5.dex */
public class SlideShowProcessor {

    /* renamed from: e, reason: collision with root package name */
    public static final String f94331e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f94332f;

    /* renamed from: a, reason: collision with root package name */
    private EglHandlerThreadEx f94333a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f94334b = true;

    /* renamed from: c, reason: collision with root package name */
    private AtomicLong f94335c = new AtomicLong(0);

    /* renamed from: d, reason: collision with root package name */
    private Task f94336d;

    /* loaded from: classes5.dex */
    public static class EglHandlerThreadEx extends EglHandlerThread {
        private WeakReference<Object> G;

        public EglHandlerThreadEx(String str, EGLContext eGLContext, Object obj) {
            super(str, eGLContext);
            if (obj != null) {
                this.G = new WeakReference<>(obj);
            }
        }

        @Override // com.tencent.mobileqq.videocodec.mediacodec.encoder.EglHandlerThread, android.os.HandlerThread
        protected void onLooperPrepared() {
            Object obj;
            super.onLooperPrepared();
            WeakReference<Object> weakReference = this.G;
            if (weakReference != null && (obj = weakReference.get()) != null) {
                synchronized (obj) {
                    obj.notify();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class Task implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        long f94337d;

        /* renamed from: e, reason: collision with root package name */
        long f94338e;

        /* renamed from: m, reason: collision with root package name */
        public e f94342m;
        protected AtomicLong C = new AtomicLong(0);
        private Queue<e> E = new LinkedList();
        private boolean D = true;

        /* renamed from: h, reason: collision with root package name */
        private com.tencent.biz.qqstory.takevideo.slideshow.core.a f94340h = new com.tencent.biz.qqstory.takevideo.slideshow.core.a(true);

        /* renamed from: f, reason: collision with root package name */
        private com.tencent.biz.qqstory.takevideo.slideshow.core.c f94339f = new com.tencent.biz.qqstory.takevideo.slideshow.core.c();

        /* renamed from: i, reason: collision with root package name */
        private VideoMerger f94341i = new VideoMerger();

        private void c(Queue<e> queue, String str) {
            String str2;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("PendingTask : " + str);
            if (queue != null && queue.size() > 0) {
                for (e eVar : queue) {
                    sb5.append("\n");
                    if (eVar instanceof c) {
                        SlideItemInfo slideItemInfo = ((c) eVar).f94347h;
                        if (slideItemInfo != null && (str2 = slideItemInfo.f94291i) != null) {
                            sb5.append(str2);
                        } else {
                            sb5.append("null");
                        }
                    } else if (eVar instanceof VideoMerger.a) {
                        VideoMerger.a aVar = new VideoMerger.a();
                        sb5.append("merge task");
                        List<SlideItemInfo> list = aVar.f94365d;
                        if (list != null && list.size() > 0) {
                            sb5.append(ProgressTracer.SEPARATOR);
                            Iterator<SlideItemInfo> it = aVar.f94365d.iterator();
                            while (it.hasNext()) {
                                sb5.append(it.next().f94291i);
                                sb5.append("  ----  ");
                            }
                        }
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("SlideShowProcessorTask", 2, sb5.toString());
            }
        }

        private synchronized e e() {
            Queue<e> queue = this.E;
            if (queue == null) {
                return null;
            }
            if (queue.size() != 0) {
                c(this.E, "poll");
            }
            return this.E.poll();
        }

        public synchronized void a(e eVar) {
            this.E.add(eVar);
            if (QLog.isColorLevel()) {
                if (eVar instanceof VideoMerger.a) {
                    QLog.d("SlideShowProcessorTask", 2, "add merge context");
                } else if (eVar instanceof c) {
                    if (((c) eVar).f94347h == null) {
                        QLog.d("SlideShowProcessorTask", 2, "add convertContext itemInfo is null");
                    } else {
                        QLog.d("SlideShowProcessorTask", 2, "add convertContext : " + ((c) eVar).f94347h.f94291i);
                    }
                }
            }
        }

        public synchronized boolean b(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            e eVar = this.f94342m;
            if (eVar != null && (eVar instanceof c) && ((c) eVar).f94347h != null && str.equals(((c) eVar).f94347h.f94291i)) {
                return true;
            }
            for (e eVar2 : this.E) {
                if ((eVar2 instanceof c) && ((c) eVar2).f94347h.f94291i.equals(str)) {
                    return true;
                }
            }
            return false;
        }

        public synchronized void f() {
            for (e eVar : this.E) {
                com.tencent.biz.qqstory.takevideo.slideshow.d dVar = new com.tencent.biz.qqstory.takevideo.slideshow.d();
                dVar.f94392b = 2;
                dVar.f94391a = eVar.f94354b;
                dVar.f94397g = false;
                dVar.f94398h = 1;
                d dVar2 = eVar.f94355c;
                if (dVar2 != null) {
                    dVar2.c(dVar);
                } else if (QLog.isColorLevel()) {
                    QLog.d("SlideShowProcessorTask", 2, "listener is null, taskContext Type : " + eVar.getClass().getSimpleName());
                }
            }
            c(this.E, "stopAll");
            this.E.clear();
            h();
        }

        public synchronized void g(String str) {
            if (QLog.isColorLevel()) {
                QLog.d("SlideShowProcessorTask", 2, "stopByPath begin");
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            e eVar = this.f94342m;
            if (eVar != null && (eVar instanceof c) && ((c) eVar).f94347h.f94291i.equals(str)) {
                h();
            } else {
                Iterator<e> it = this.E.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    e next = it.next();
                    if ((next instanceof c) && ((c) next).f94347h.f94291i.equals(str)) {
                        this.E.remove(next);
                        break;
                    }
                }
            }
            c(this.E, "stopByPath");
        }

        public synchronized void h() {
            if (QLog.isColorLevel()) {
                QLog.d("SlideShowProcessorTask", 2, "stopPeek begin");
            }
            e eVar = this.f94342m;
            if (eVar != null && eVar.f94353a && this.D) {
                eVar.f94353a = false;
                com.tencent.biz.qqstory.takevideo.slideshow.d dVar = new com.tencent.biz.qqstory.takevideo.slideshow.d();
                dVar.f94391a = eVar.f94354b;
                dVar.f94397g = false;
                dVar.f94398h = 1;
                d dVar2 = eVar.f94355c;
                if (dVar2 != null) {
                    dVar2.c(dVar);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("SlideShowProcessorTask", 2, "stopPeek end");
            }
            c(this.E, "stopPeek");
        }

        @Override // java.lang.Runnable
        public void run() {
            e e16;
            if (QLog.isColorLevel()) {
                QLog.d("SlideShowProcessorTask", 2, "SlideShowProcessor is launching");
            }
            while (this.D) {
                synchronized (this) {
                    e16 = e();
                    this.f94342m = e16;
                }
                if (e16 != null) {
                    try {
                        try {
                            synchronized (this) {
                                this.f94342m.f94353a = true;
                            }
                            long addAndGet = this.C.addAndGet(1L);
                            this.f94342m.f94354b = addAndGet;
                            if (QLog.isColorLevel()) {
                                QLog.d("SlideShowProcessorTask", 2, "new Task run, id : " + addAndGet);
                            }
                            e eVar = this.f94342m;
                            if (eVar instanceof VideoMerger.a) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("SlideShowProcessorTask", 2, "new merge Task run");
                                }
                                this.f94341i.c((VideoMerger.a) this.f94342m);
                                if (QLog.isColorLevel()) {
                                    QLog.d("SlideShowProcessorTask", 2, "finish merge Task");
                                }
                            } else if (((c) eVar).f94347h.f94290h == 0) {
                                this.f94337d = System.currentTimeMillis();
                                if (QLog.isColorLevel()) {
                                    QLog.d("SlideShowProcessorTask", 2, "begin runImage2Video , id : " + addAndGet);
                                }
                                this.f94340h.q((c) this.f94342m);
                                if (QLog.isColorLevel()) {
                                    QLog.d("SlideShowProcessorTask", 2, "finish runImage2Video , id : " + addAndGet);
                                }
                            } else {
                                this.f94338e = System.currentTimeMillis();
                                if (QLog.isColorLevel()) {
                                    QLog.d("SlideShowProcessorTask", 2, "begin runLocalVideo2Video , id : " + addAndGet);
                                }
                                this.f94339f.i((c) this.f94342m);
                                if (QLog.isColorLevel()) {
                                    QLog.d("SlideShowProcessorTask", 2, "finish runLocalVideo2Video , id : " + addAndGet);
                                }
                            }
                            synchronized (this) {
                                this.f94342m.f94353a = false;
                                this.f94342m = null;
                            }
                        } catch (Exception e17) {
                            String stackTraceAsString = ThrowablesUtils.getStackTraceAsString(e17);
                            if (QLog.isColorLevel()) {
                                QLog.d("SlideShowProcessorTask", 2, "Task run error : " + stackTraceAsString);
                            }
                            synchronized (this) {
                                notifyAll();
                                e eVar2 = this.f94342m;
                                if (eVar2 != null) {
                                    eVar2.f94353a = false;
                                    this.f94342m = null;
                                }
                            }
                        }
                    } catch (Throwable th5) {
                        synchronized (this) {
                            notifyAll();
                            e eVar3 = this.f94342m;
                            if (eVar3 != null) {
                                eVar3.f94353a = false;
                                this.f94342m = null;
                            }
                            throw th5;
                        }
                    }
                }
                synchronized (this) {
                    notifyAll();
                }
                synchronized (this) {
                    notifyAll();
                    e eVar4 = this.f94342m;
                    if (eVar4 != null) {
                        eVar4.f94353a = false;
                        this.f94342m = null;
                    }
                }
                try {
                    LockMethodProxy.sleep(200L);
                } catch (InterruptedException e18) {
                    String stackTraceAsString2 = ThrowablesUtils.getStackTraceAsString(e18);
                    if (QLog.isColorLevel()) {
                        QLog.d("SlideShowProcessorTask", 2, stackTraceAsString2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            if (str.endsWith(".mp4")) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Comparator<File> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return -1;
            }
            if (lastModified == 0) {
                return 0;
            }
            return 1;
        }

        @Override // java.util.Comparator
        public boolean equals(Object obj) {
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void c(com.tencent.biz.qqstory.takevideo.slideshow.d dVar);
    }

    /* loaded from: classes5.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public boolean f94353a = false;

        /* renamed from: b, reason: collision with root package name */
        public long f94354b;

        /* renamed from: c, reason: collision with root package name */
        public d f94355c;
    }

    static {
        String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.tencent.mobileqq/qq/video/imagevideo/";
        f94331e = str;
        f94332f = str + "cache/";
    }

    public static void d() {
        if (QLog.isColorLevel()) {
            QLog.d("SlideShowProcessor", 2, "clearCache start");
        }
        File[] g16 = g(f94332f);
        if (g16 != null) {
            if (g16.length > 100) {
                if (QLog.isColorLevel()) {
                    QLog.d("SlideShowProcessor", 2, "clear cache delete file over 100");
                }
                for (int i3 = 100; i3 < g16.length; i3++) {
                    q.c(g16[i3]);
                    q.d(g16[i3] + ".dat");
                }
            }
        }
    }

    public static File[] g(String str) {
        File[] listFiles = new File(str).listFiles(new a());
        if (listFiles != null) {
            Arrays.sort(listFiles, new b());
        }
        return listFiles;
    }

    public com.tencent.biz.qqstory.takevideo.slideshow.d a(SlideItemInfo slideItemInfo, int i3, int i16, long j3, boolean z16, d dVar) {
        com.tencent.biz.qqstory.takevideo.slideshow.d dVar2 = new com.tencent.biz.qqstory.takevideo.slideshow.d();
        dVar2.f94391a = this.f94335c.addAndGet(1L);
        dVar2.f94393c = slideItemInfo.f94291i;
        if (QLog.isColorLevel()) {
            QLog.d("SlideShowProcessor", 2, "start, taskId:" + dVar2.f94391a + ", image:" + slideItemInfo.f94291i + ", widht:" + i3 + " height:" + i16 + " duration:" + j3);
        }
        if (this.f94333a == null) {
            if (QLog.isColorLevel()) {
                QLog.d("SlideShowProcessor", 2, "thread not init");
            }
            dVar2.f94392b = 3;
            if (dVar != null) {
                dVar.c(dVar2);
            }
            return dVar2;
        }
        if (TextUtils.isEmpty(slideItemInfo.f94291i)) {
            if (QLog.isColorLevel()) {
                QLog.d("SlideShowProcessor", 2, "strImage == null");
            }
            dVar2.f94392b = 4;
            if (dVar != null) {
                dVar.c(dVar2);
            }
            return dVar2;
        }
        dVar2.f94392b = 1;
        this.f94336d.a(new c(dVar2.f94391a, slideItemInfo, i3, i16, j3, dVar, z16));
        return dVar2;
    }

    public void b(SlideItemInfo slideItemInfo, d dVar) {
        a(slideItemInfo, 720, 1280, 2000L, this.f94334b, dVar);
    }

    public void c(List<SlideItemInfo> list, VideoMerger.b bVar, Activity activity, Handler handler, int i3, int i16, String str) {
        if (list != null && list.size() > 0) {
            VideoMerger.a aVar = new VideoMerger.a();
            aVar.f94365d = list;
            aVar.f94366e = bVar;
            aVar.f94367f = activity;
            aVar.f94368g = handler;
            aVar.f94369h = i3;
            aVar.f94370i = i16;
            aVar.f94371j = str;
            this.f94336d.a(aVar);
        }
    }

    public boolean e(String str) {
        return this.f94336d.b(str);
    }

    public boolean f() {
        if (QLog.isColorLevel()) {
            QLog.d("SlideShowProcessor", 2, "init begin..");
        }
        j();
        synchronized (this) {
            this.f94333a = new EglHandlerThreadEx("image2VideoThread", null, this);
            this.f94336d = new Task();
            this.f94333a.start();
            if (!this.f94333a.isInitSuccess()) {
                try {
                    wait(1000L);
                } catch (InterruptedException unused) {
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("SlideShowProcessor", 2, "init isInitSuccess=" + this.f94333a.isInitSuccess() + "getHandler=" + this.f94333a.getHandler());
            }
            if (this.f94333a.getHandler() != null) {
                this.f94333a.getHandler().post(this.f94336d);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("SlideShowProcessor", 2, "init end..");
            return true;
        }
        return true;
    }

    public void h() {
        if (QLog.isColorLevel()) {
            QLog.d("SlideShowProcessor", 2, "stopALl , " + ThrowablesUtils.getStackTraceAsString(new Throwable()));
        }
        this.f94336d.f();
    }

    public void i(String str) {
        this.f94336d.g(str);
    }

    public void j() {
        if (QLog.isColorLevel()) {
            QLog.d("SlideShowProcessor", 2, "uninit..");
        }
        synchronized (this) {
            EglHandlerThreadEx eglHandlerThreadEx = this.f94333a;
            if (eglHandlerThreadEx != null) {
                eglHandlerThreadEx.quitSafely();
                this.f94333a = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends e {

        /* renamed from: d, reason: collision with root package name */
        public String f94343d;

        /* renamed from: e, reason: collision with root package name */
        public int f94344e;

        /* renamed from: f, reason: collision with root package name */
        public int f94345f;

        /* renamed from: g, reason: collision with root package name */
        public long f94346g;

        /* renamed from: h, reason: collision with root package name */
        public SlideItemInfo f94347h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f94348i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f94349j = false;

        /* renamed from: k, reason: collision with root package name */
        public boolean f94350k = false;

        /* renamed from: l, reason: collision with root package name */
        public boolean f94351l = false;

        /* renamed from: m, reason: collision with root package name */
        public int f94352m = 0;

        public c(long j3, SlideItemInfo slideItemInfo, int i3, int i16, long j16, d dVar, boolean z16) {
            this.f94354b = j3;
            this.f94344e = i3;
            this.f94345f = i16;
            this.f94346g = j16;
            this.f94347h = slideItemInfo;
            this.f94343d = slideItemInfo.f94291i;
            this.f94355c = dVar;
            this.f94348i = z16;
        }

        public c() {
        }
    }
}

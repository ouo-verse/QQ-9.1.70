package com.tencent.open.base.img;

import android.text.TextUtils;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.open.appcommon.Common;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.base.c;
import com.tencent.open.base.f;
import com.tencent.qqmini.miniapp.widget.InnerWebView;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import qp3.a;
import qp3.b;
import qp3.d;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ImageCache {

    /* renamed from: a, reason: collision with root package name */
    public static final String f341025a;

    /* renamed from: b, reason: collision with root package name */
    protected static final String f341026b;

    /* renamed from: c, reason: collision with root package name */
    protected static a f341027c;

    /* renamed from: d, reason: collision with root package name */
    protected static ThreadPoolExecutor f341028d;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class UpdateTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        protected String f341029d;

        /* renamed from: e, reason: collision with root package name */
        protected String f341030e;

        /* renamed from: f, reason: collision with root package name */
        protected String f341031f;

        /* renamed from: h, reason: collision with root package name */
        protected b f341032h;

        public UpdateTask(String str, String str2, String str3, b bVar) {
            this.f341029d = str;
            this.f341030e = str2;
            this.f341031f = str3;
            this.f341032h = bVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof UpdateTask)) {
                return false;
            }
            return this.f341029d.equals(((UpdateTask) obj).f341029d);
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            b bVar2;
            try {
                if ((!Common.w() || !com.tencent.open.base.a.j(com.tencent.open.adapter.a.f().e())) && (bVar = this.f341032h) != null) {
                    bVar.a(this.f341029d, this.f341030e, this.f341031f);
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append(Common.l());
                String str = ImageCache.f341025a;
                sb5.append(str);
                sb5.append(this.f341030e);
                String str2 = File.separator;
                sb5.append(str2);
                sb5.append(c.c(this.f341031f));
                String sb6 = sb5.toString();
                f.a(InnerWebView.API_DOWNLOAD_IMAGE, "imgFilePath = " + sb6 + APLogFileUtil.SEPARATOR_LOG + this.f341030e + APLogFileUtil.SEPARATOR_LOG + c.c(this.f341031f) + " key=" + this.f341029d + " url=" + this.f341031f);
                if (new File(sb6).exists() && (bVar2 = this.f341032h) != null) {
                    bVar2.b(this.f341029d, this.f341030e, sb6);
                    this.f341032h = null;
                }
                d a16 = ImageCache.f341027c.a(this.f341029d);
                if (a16 == null) {
                    f.h(QZLog.IMAGE_CACHE_TAG, "image not in db. key=" + this.f341029d + " url=" + this.f341031f);
                    a16 = new d();
                    a16.f429190a = this.f341029d;
                    a16.f429191b = this.f341031f;
                    a16.f429194e = 0L;
                    a16.f429195f = this.f341030e;
                } else {
                    a16.f429191b = this.f341031f;
                    if (this.f341032h != null) {
                        f.h(QZLog.IMAGE_CACHE_TAG, "file is deleted." + this.f341031f + " key=" + this.f341029d);
                        a16.f429194e = 0L;
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        long j3 = a16.f429193d;
                        if (currentTimeMillis > j3 && currentTimeMillis < a16.f429192c + j3) {
                            f.h(QZLog.IMAGE_CACHE_TAG, "currenttime=" + System.currentTimeMillis() + "\nmaxage+updatetime=" + a16.f429192c + a16.f429193d + " key=" + this.f341029d + " url=" + this.f341031f);
                            return;
                        }
                    }
                }
                if (qp3.c.b(a16)) {
                    f.i(QZLog.IMAGE_CACHE_TAG, "download image succ. " + this.f341031f + " key=" + this.f341029d);
                    ImageCache.f341027c.b(a16);
                    b bVar3 = this.f341032h;
                    if (bVar3 != null) {
                        bVar3.b(this.f341029d, this.f341030e, Common.l() + str + this.f341030e + str2 + c.c(a16.f429191b));
                        return;
                    }
                    return;
                }
                f.i(QZLog.IMAGE_CACHE_TAG, "download failed." + this.f341031f + " key=" + this.f341029d);
                b bVar4 = this.f341032h;
                if (bVar4 != null) {
                    bVar4.a(this.f341029d, this.f341030e, this.f341031f);
                }
            } catch (Exception e16) {
                f.j(QZLog.IMAGE_CACHE_TAG, "Download img warning", e16);
            }
        }
    }

    static {
        StringBuilder sb5 = new StringBuilder();
        String str = File.separator;
        sb5.append(str);
        sb5.append("tencent");
        sb5.append(str);
        sb5.append("qzone");
        sb5.append(str);
        sb5.append(".AppCenterImgCache");
        sb5.append(str);
        String sb6 = sb5.toString();
        f341025a = sb6;
        String str2 = str + "tencent" + str + "qzone" + str + "ImgCache2" + str;
        f341026b = str2;
        try {
            File file = new File(Common.l() + str2);
            if (file.exists()) {
                file.renameTo(new File(Common.l() + sb6));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        f341027c = new a(com.tencent.open.adapter.a.f().e());
        f341028d = new BaseThreadPoolExecutor(3, 5, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
    }

    public static void a(String str) {
        try {
            new File(e("app", str)).delete();
        } catch (Exception e16) {
            f.d(QZLog.IMAGE_CACHE_TAG, "-->delete image file failed.", e16);
        }
    }

    protected static void b(String str, String str2, String str3, b bVar) {
        d(new UpdateTask(str, str2, str3, bVar));
    }

    public static void c(String str, String str2, b bVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            b(MD5Utils.encodeHexStr(str2), str, str2, bVar);
        }
    }

    protected static synchronized void d(UpdateTask updateTask) {
        synchronized (ImageCache.class) {
            try {
            } catch (Exception e16) {
                f.d(QZLog.IMAGE_CACHE_TAG, "execute>>> ", e16);
                b bVar = updateTask.f341032h;
                if (bVar != null) {
                    bVar.a(updateTask.f341029d, updateTask.f341030e, updateTask.f341031f);
                }
            }
            if (f341028d.getQueue().contains(updateTask)) {
                f.h(QZLog.IMAGE_CACHE_TAG, "download task already exist, return. key= " + updateTask.f341029d + " url=" + updateTask.f341031f);
                return;
            }
            f.h(QZLog.IMAGE_CACHE_TAG, "add download task to queue. key= " + updateTask.f341029d + " url=" + updateTask.f341031f);
            f341028d.execute(updateTask);
        }
    }

    public static String e(String str, String str2) {
        return Common.l() + f341025a + str + File.separator + c.c(str2);
    }
}

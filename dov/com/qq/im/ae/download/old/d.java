package dov.com.qq.im.ae.download.old;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.NetworkUtil;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager;
import dov.com.qq.im.ae.download.old.e;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d implements e.a {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f394486d;

    /* renamed from: e, reason: collision with root package name */
    private a f394487e;

    /* renamed from: f, reason: collision with root package name */
    boolean f394488f;

    /* renamed from: h, reason: collision with root package name */
    public int f394489h = f394484i.getAndIncrement();

    /* renamed from: i, reason: collision with root package name */
    private static AtomicInteger f394484i = new AtomicInteger(0);

    /* renamed from: m, reason: collision with root package name */
    private static String f394485m = "AEOldShortVideoResDownload_";
    private static ConcurrentHashMap<Integer, d> C = new ConcurrentHashMap<>(5);

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static class a implements AEOldShortVideoResManager.e {

        /* renamed from: a, reason: collision with root package name */
        private String f394490a;

        /* renamed from: b, reason: collision with root package name */
        boolean f394491b = true;

        /* renamed from: c, reason: collision with root package name */
        boolean f394492c = true;

        /* renamed from: d, reason: collision with root package name */
        boolean f394493d = true;

        /* renamed from: e, reason: collision with root package name */
        d f394494e;

        public a(String str, d dVar) {
            this.f394490a = str;
            this.f394494e = dVar;
        }

        public void a() {
            if (this.f394491b && this.f394492c) {
                d.c(this.f394494e);
            }
        }

        @Override // dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.e
        public void onDownloadFinish(String str, int i3, String str2) {
            VideoEnvironment.LogDownLoad(this.f394490a, "onDownloadFinish| name=" + str + ",result=" + i3 + ",filePath=" + str2, null);
            if (str.startsWith("new_qq_android_native_short_video_")) {
                this.f394491b = true;
            } else if (str.startsWith("new_qq_android_native_art_filter_")) {
                this.f394492c = true;
            } else if (str.startsWith("new_qq_android_native_portrait_filter_")) {
                this.f394493d = true;
            }
            a();
        }

        @Override // dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.e
        public void onNetWorkNone() {
            VideoEnvironment.LogDownLoad(this.f394490a, "onNetWorkNone...", null);
        }

        @Override // dov.com.qq.im.ae.download.old.AEOldShortVideoResManager.e
        public void onUpdateProgress(String str, long j3, long j16) {
            VideoEnvironment.LogDownLoad(this.f394490a, "name=" + str + ",totalLen=" + j16 + ",curOffset=" + j3 + ",localProgress=" + ((int) ((((float) j3) * 100.0f) / ((float) j16))), null);
        }
    }

    d(QQAppInterface qQAppInterface, boolean z16) {
        this.f394486d = qQAppInterface;
        String str = f394485m + this.f394489h;
        f394485m = str;
        this.f394487e = new a(str, this);
        this.f394488f = z16;
    }

    public static void b() {
        ConcurrentHashMap<Integer, d> concurrentHashMap = C;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(d dVar) {
        if (dVar != null) {
            C.remove(Integer.valueOf(dVar.f394489h));
        }
    }

    private boolean d() {
        boolean isNetworkAvailable = NetworkUtil.isNetworkAvailable(null);
        if (isNetworkAvailable) {
            VideoEnvironment.LogDownLoad(f394485m, HardCodeUtil.qqStr(R.string.tia), null);
            AEOldShortVideoResManager.P(this.f394486d, this);
        } else {
            VideoEnvironment.LogDownLoad(f394485m, HardCodeUtil.qqStr(R.string.tgn), null);
        }
        return isNetworkAvailable;
    }

    public static synchronized boolean e(QQAppInterface qQAppInterface, boolean z16) {
        synchronized (d.class) {
            if (!VideoEnvironment.supportShortVideoRecordAndPlay()) {
                C.clear();
                return false;
            }
            if (C.size() >= 3) {
                VideoEnvironment.LogDownLoad("ShortVideoResDownload", "reach to max session size=" + C.size(), null);
                return false;
            }
            d dVar = new d(qQAppInterface, z16);
            C.put(Integer.valueOf(dVar.f394489h), dVar);
            boolean d16 = dVar.d();
            if (!d16) {
                C.remove(Integer.valueOf(dVar.f394489h));
            }
            return d16;
        }
    }

    @Override // dov.com.qq.im.ae.download.old.e.a
    public void onConfigResult(int i3, int i16) {
        VideoEnvironment.LogDownLoad(f394485m, "onConfigResult | result=" + i3 + ",serverError=" + i16, null);
        if (i3 != 1 && i3 != 0) {
            VideoEnvironment.LogDownLoad(f394485m, "onConfigResult| result= RESULT_FAILED error=" + i16, null);
            c(this);
            return;
        }
        if (i16 != 0) {
            VideoEnvironment.LogDownLoad(f394485m, "onConfigResult| uncompress config error=" + i16, null);
            c(this);
            return;
        }
        ArrayList arrayList = new ArrayList(1);
        int f16 = AEOldShortVideoResManager.f(this.f394486d, arrayList);
        if (f16 == 0) {
            VideoEnvironment.LogDownLoad(f394485m, "onConfigResult| check config success...", null);
            a aVar = this.f394487e;
            aVar.f394491b = false;
            AEOldShortVideoResManager.o(this.f394486d, arrayList, aVar);
            VideoEnvironment.LogDownLoad(f394485m, "onConfigResult| mDownloadFilterSo=false", null);
            if (this.f394488f && com.tencent.mobileqq.shortvideo.util.f.l()) {
                a aVar2 = this.f394487e;
                aVar2.f394492c = false;
                AEOldShortVideoResManager.p(this.f394486d, arrayList, aVar2);
            }
            this.f394487e.a();
            return;
        }
        VideoEnvironment.LogDownLoad(f394485m, "onConfigResult| check config error=" + f16, null);
        c(this);
    }
}

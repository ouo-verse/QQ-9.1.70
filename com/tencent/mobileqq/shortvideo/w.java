package com.tencent.mobileqq.shortvideo;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.x;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes18.dex */
public class w implements x.a {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f288272d;

    /* renamed from: e, reason: collision with root package name */
    private a f288273e;

    /* renamed from: f, reason: collision with root package name */
    boolean f288274f;

    /* renamed from: h, reason: collision with root package name */
    public int f288275h = f288270i.getAndIncrement();

    /* renamed from: i, reason: collision with root package name */
    private static AtomicInteger f288270i = new AtomicInteger(0);

    /* renamed from: m, reason: collision with root package name */
    private static String f288271m = "ShortVideoResDownload_";
    private static ConcurrentHashMap<Integer, w> C = new ConcurrentHashMap<>(5);

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class a implements ShortVideoResourceManager.e {

        /* renamed from: d, reason: collision with root package name */
        private String f288276d;

        /* renamed from: e, reason: collision with root package name */
        boolean f288277e = true;

        /* renamed from: f, reason: collision with root package name */
        boolean f288278f = true;

        /* renamed from: h, reason: collision with root package name */
        boolean f288279h = true;

        /* renamed from: i, reason: collision with root package name */
        boolean f288280i = true;

        /* renamed from: m, reason: collision with root package name */
        w f288281m;

        public a(String str, w wVar) {
            this.f288276d = str;
            this.f288281m = wVar;
        }

        public void a() {
            if (this.f288277e && this.f288278f && this.f288280i) {
                w.c(this.f288281m);
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.e
        public void onDownloadFinish(String str, int i3, String str2) {
            VideoEnvironment.LogDownLoad(this.f288276d, "onDownloadFinish| name=" + str + ",result=" + i3 + ",filePath=" + str2, null);
            if (str.startsWith("new_qq_android_native_short_video_")) {
                this.f288277e = true;
            } else if (str.startsWith("new_qq_android_native_art_filter_")) {
                this.f288278f = true;
            } else if (str.startsWith("new_qq_android_native_portrait_filter_")) {
                this.f288279h = true;
            }
            a();
        }

        @Override // com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.e
        public void onNetWorkNone() {
            VideoEnvironment.LogDownLoad(this.f288276d, "onNetWorkNone...", null);
        }

        @Override // com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.e
        public void onUpdateProgress(String str, long j3, long j16) {
            VideoEnvironment.LogDownLoad(this.f288276d, "name=" + str + ",totalLen=" + j16 + ",curOffset=" + j3 + ",localProgress=" + ((int) ((((float) j3) * 100.0f) / ((float) j16))), null);
        }
    }

    w(QQAppInterface qQAppInterface, boolean z16) {
        this.f288272d = qQAppInterface;
        String str = f288271m + this.f288275h;
        f288271m = str;
        this.f288273e = new a(str, this);
        this.f288274f = z16;
    }

    public static void b() {
        ConcurrentHashMap<Integer, w> concurrentHashMap = C;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(w wVar) {
        if (wVar != null) {
            C.remove(Integer.valueOf(wVar.f288275h));
        }
    }

    private boolean d() {
        boolean isNetworkAvailable = NetworkUtil.isNetworkAvailable(null);
        if (isNetworkAvailable) {
            VideoEnvironment.LogDownLoad(f288271m, HardCodeUtil.qqStr(R.string.tia), null);
            ShortVideoResourceManager.M(this.f288272d, this);
        } else {
            VideoEnvironment.LogDownLoad(f288271m, HardCodeUtil.qqStr(R.string.tgn), null);
        }
        return isNetworkAvailable;
    }

    public static boolean e(BaseQQAppInterface baseQQAppInterface) {
        return g((QQAppInterface) baseQQAppInterface, true);
    }

    public static boolean f(QQAppInterface qQAppInterface) {
        return g(qQAppInterface, true);
    }

    public static synchronized boolean g(QQAppInterface qQAppInterface, boolean z16) {
        synchronized (w.class) {
            if (!VideoEnvironment.supportShortVideoRecordAndPlay()) {
                C.clear();
                return false;
            }
            if (C.size() >= 3) {
                VideoEnvironment.LogDownLoad("ShortVideoResDownload", "reach to max session size=" + C.size(), null);
                return false;
            }
            w wVar = new w(qQAppInterface, z16);
            C.put(Integer.valueOf(wVar.f288275h), wVar);
            boolean d16 = wVar.d();
            if (!d16) {
                C.remove(Integer.valueOf(wVar.f288275h));
            }
            return d16;
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.x.a
    public void onConfigResult(int i3, int i16) {
        VideoEnvironment.LogDownLoad(f288271m, "onConfigResult | result=" + i3 + ",serverError=" + i16, null);
        if (i3 != 1 && i3 != 0) {
            VideoEnvironment.LogDownLoad(f288271m, "onConfigResult| result= RESULT_FAILED error=" + i16, null);
            c(this);
            return;
        }
        if (i16 != 0) {
            VideoEnvironment.LogDownLoad(f288271m, "onConfigResult| uncompress config error=" + i16, null);
            c(this);
            return;
        }
        ArrayList arrayList = new ArrayList(1);
        int f16 = ShortVideoResourceManager.f(this.f288272d, arrayList);
        if (f16 == 0) {
            VideoEnvironment.LogDownLoad(f288271m, "onConfigResult| check config success...", null);
            a aVar = this.f288273e;
            aVar.f288277e = false;
            ShortVideoResourceManager.q(this.f288272d, arrayList, aVar);
            VideoEnvironment.LogDownLoad(f288271m, "onConfigResult| mDownloadFilterSo=false", null);
            if (this.f288274f && com.tencent.mobileqq.shortvideo.util.f.l()) {
                a aVar2 = this.f288273e;
                aVar2.f288278f = false;
                ShortVideoResourceManager.r(this.f288272d, arrayList, aVar2);
            }
            this.f288273e.a();
            return;
        }
        VideoEnvironment.LogDownLoad(f288271m, "onConfigResult| check config error=" + f16, null);
        c(this);
    }
}

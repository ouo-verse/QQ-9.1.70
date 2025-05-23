package com.tencent.mobileqq.vas.avatar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLState;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.avatar.m;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class NtVasFaceManager extends m<String> {

    /* renamed from: h, reason: collision with root package name */
    private static Bundle f308748h;

    /* renamed from: m, reason: collision with root package name */
    private static volatile NtVasFaceManager f308750m;

    /* renamed from: e, reason: collision with root package name */
    private LinkedHashMap<String, Object> f308751e = new LinkedHashMap<String, Object>(20, 0.75f, true) { // from class: com.tencent.mobileqq.vas.avatar.NtVasFaceManager.2
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, Object> entry) {
            if (size() > 20) {
                return true;
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public synchronized Object put(String str, Object obj) {
            return super.put((AnonymousClass2) str, (String) obj);
        }
    };

    /* renamed from: f, reason: collision with root package name */
    public static Handler f308747f = new Handler(Looper.getMainLooper());

    /* renamed from: i, reason: collision with root package name */
    private static final ArrayList<Replayer> f308749i = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class Replayer implements Runnable, ApngDrawable.OnPlayRepeatListener {

        /* renamed from: d, reason: collision with root package name */
        public WeakReference<ApngImage> f308754d;

        /* renamed from: e, reason: collision with root package name */
        private long f308755e;

        /* renamed from: f, reason: collision with root package name */
        private long f308756f;

        /* renamed from: h, reason: collision with root package name */
        private Handler f308757h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f308758i;

        /* renamed from: m, reason: collision with root package name */
        private String f308759m;

        public Replayer(String str, ApngDrawable apngDrawable, Handler handler) {
            this.f308754d = new WeakReference<>(apngDrawable.getImage());
            this.f308757h = handler;
            apngDrawable.setOnPlayRepeatListener(this);
            this.f308759m = str;
        }

        public void e() {
            this.f308757h.post(this);
        }

        @Override // com.tencent.image.ApngDrawable.OnPlayRepeatListener
        public void onPlayRepeat(int i3) {
            if (i3 == 3) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.qqhead.VasFaceManager", 1, "onPlayRepeat: " + this.f308759m + " image: " + this.f308754d.get());
                }
                this.f308755e = SystemClock.uptimeMillis();
                this.f308756f = 0L;
                this.f308758i = true;
                this.f308757h.postDelayed(this, 5000L);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f308758i = false;
            this.f308757h.removeCallbacks(this);
            ApngImage apngImage = this.f308754d.get();
            if (apngImage != null) {
                apngImage.replay();
                if (QLog.isColorLevel()) {
                    QLog.i("Q.qqhead.VasFaceManager", 2, "replay " + apngImage + " in " + this);
                }
            }
        }
    }

    public static Bundle g() {
        if (f308748h == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("key_loop", 3);
            bundle.putBoolean("key_double_bitmap", true);
            bundle.putBoolean("key_draw_round", true);
            bundle.putBoolean("key_get_reset_loop", false);
            bundle.putBoolean("key_stop_on_first", true);
            bundle.putIntArray("key_tagId_arr", new int[0]);
            bundle.putString("key_name", "-face-");
            f308748h = bundle;
        }
        return f308748h;
    }

    public static Bundle h(boolean z16) {
        Bundle g16 = g();
        if (z16) {
            Bundle bundle = new Bundle();
            bundle.putAll(g16);
            bundle.remove("key_loop");
            return bundle;
        }
        return g16;
    }

    private String i(String str) {
        return ((f) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 23L)).e(str);
    }

    public static NtVasFaceManager j() {
        if (f308750m == null) {
            synchronized (NtVasFaceManager.class) {
                if (f308750m == null) {
                    f308750m = new NtVasFaceManager();
                }
            }
        }
        return f308750m;
    }

    public static void n(final String str, final ApngDrawable apngDrawable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            for (int size = f308749i.size() - 1; size >= 0; size--) {
                ArrayList<Replayer> arrayList = f308749i;
                ApngImage apngImage = arrayList.get(size).f308754d.get();
                if (apngImage == null) {
                    arrayList.remove(size);
                } else if (apngImage == apngDrawable.getImage()) {
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("Q.qqhead.VasFaceManager", 2, "registerNewFace: " + apngDrawable.getImage());
            }
            f308749i.add(new Replayer(str, apngDrawable, f308747f));
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.k
            @Override // java.lang.Runnable
            public final void run() {
                NtVasFaceManager.n(str, apngDrawable);
            }
        });
    }

    public static void o(final ApngDrawable apngDrawable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            for (int size = f308749i.size() - 1; size >= 0; size--) {
                ArrayList<Replayer> arrayList = f308749i;
                Replayer replayer = arrayList.get(size);
                ApngImage apngImage = replayer.f308754d.get();
                if (apngImage == null) {
                    arrayList.remove(size);
                } else if (apngImage == apngDrawable.getImage()) {
                    replayer.e();
                    return;
                }
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.l
            @Override // java.lang.Runnable
            public final void run() {
                NtVasFaceManager.o(ApngDrawable.this);
            }
        });
    }

    public void e(URL url, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        this.f308751e.put(URLState.getMemoryCacheKey(url.toString(), uRLDrawableOptions), Boolean.TRUE);
    }

    public void f(int i3, String str, m.a<String> aVar, Object obj) {
        final String a16 = h.a(i3, str);
        b(a16, aVar, obj);
        final f fVar = (f) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 23L);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.NtVasFaceManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String e16 = fVar.e(a16);
                    if (new File(e16).exists()) {
                        QLog.d("Q.qqhead.VasFaceManager", 1, "getFace from sd card: " + a16);
                        NtVasFaceManager.this.a(a16, e16);
                    } else {
                        QLog.d("Q.qqhead.VasFaceManager", 1, "getFace need download: " + a16);
                        ((f) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(f.class)).startDownload(a16);
                    }
                } catch (Exception e17) {
                    QLog.e("Q.qqhead.VasFaceManager", 1, "getFace failed", e17);
                }
            }
        }, 128, null, true);
    }

    public void m(String str, int i3) {
        String str2;
        QLog.d("Q.qqhead.VasFaceManager", 1, "download store face scid: " + str + " errorCode: " + i3);
        if (i3 == 0) {
            str2 = i(str);
        } else {
            str2 = null;
        }
        a(str, str2);
    }
}

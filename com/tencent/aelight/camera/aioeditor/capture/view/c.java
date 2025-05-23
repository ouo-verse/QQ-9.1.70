package com.tencent.aelight.camera.aioeditor.capture.view;

import android.os.SystemClock;
import android.util.SparseArray;
import android.view.animation.AccelerateInterpolator;
import com.tencent.aelight.camera.aioeditor.capture.data.h;
import com.tencent.aelight.camera.aioeditor.capture.data.j;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import qs.f;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c {

    /* renamed from: g, reason: collision with root package name */
    public static final ConcurrentHashMap<String, c> f67347g = new ConcurrentHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    public static final SparseArray<ConcurrentHashMap<String, c>> f67348h = new SparseArray<>(3);

    /* renamed from: i, reason: collision with root package name */
    public static final AccelerateInterpolator f67349i = new AccelerateInterpolator();

    /* renamed from: b, reason: collision with root package name */
    long f67351b;

    /* renamed from: a, reason: collision with root package name */
    public byte f67350a = 1;

    /* renamed from: c, reason: collision with root package name */
    long f67352c = 0;

    /* renamed from: d, reason: collision with root package name */
    long f67353d = 0;

    /* renamed from: e, reason: collision with root package name */
    float f67354e = 1.0f;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<WeakReference<a>> f67355f = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void onUpdate();
    }

    static c b(int i3, String str) {
        SparseArray<ConcurrentHashMap<String, c>> sparseArray = f67348h;
        ConcurrentHashMap<String, c> concurrentHashMap = sparseArray.get(i3);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>(50);
            sparseArray.put(i3, concurrentHashMap);
        }
        c cVar = concurrentHashMap.get(str);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        concurrentHashMap.put(str, cVar2);
        return cVar2;
    }

    public static c c(Object obj) {
        if (obj instanceof h) {
            return b(1, ((h) obj).k());
        }
        if (obj instanceof f) {
            return b(3, ((f) obj).f429433a);
        }
        if (obj instanceof MusicItemInfo) {
            return b(2, ((MusicItemInfo) obj).mMusicName);
        }
        if (obj instanceof j) {
            return b(4, ((j) obj).k());
        }
        return null;
    }

    public void a(a aVar) {
        this.f67355f.add(new WeakReference<>(aVar));
    }

    public float d() {
        float f16;
        byte b16 = this.f67350a;
        if (b16 != 1) {
            if (b16 != 2) {
                if (b16 == 3) {
                    if (this.f67353d == 0) {
                        this.f67353d = SystemClock.elapsedRealtime();
                    } else {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f67353d;
                        if (elapsedRealtime > 1) {
                            this.f67354e = 0.0f;
                        }
                        this.f67354e *= 1.0f - ((((float) elapsedRealtime) * 1.0f) / 1.0f);
                    }
                }
            } else {
                if (this.f67351b == 0) {
                    return 0.0f;
                }
                float elapsedRealtime2 = (float) (SystemClock.elapsedRealtime() - this.f67351b);
                if (elapsedRealtime2 > 4250.0f) {
                    f16 = 0.85f;
                } else {
                    f16 = (elapsedRealtime2 * 1.0f) / 5000.0f;
                    if (f16 < 0.01f) {
                        f16 = 0.01f;
                    }
                }
                this.f67354e = f16;
            }
        } else if (this.f67352c == 0) {
            this.f67352c = SystemClock.elapsedRealtime();
        } else {
            long elapsedRealtime3 = SystemClock.elapsedRealtime() - this.f67352c;
            if (elapsedRealtime3 > 1) {
                this.f67354e = 1.0f;
            } else {
                float f17 = this.f67354e;
                this.f67354e = f17 + ((1.0f - f17) * f67349i.getInterpolation((((float) elapsedRealtime3) * 1.0f) / 1.0f));
            }
        }
        return this.f67354e;
    }

    public void e(float f16) {
        for (int size = this.f67355f.size() - 1; size >= 0; size--) {
            a aVar = this.f67355f.get(size).get();
            if (aVar == null) {
                this.f67355f.remove(size);
            } else {
                aVar.onUpdate();
            }
        }
    }

    public void f(a aVar) {
        for (int size = this.f67355f.size() - 1; size >= 0; size--) {
            a aVar2 = this.f67355f.get(size).get();
            if (aVar2 == null || aVar2 == aVar) {
                this.f67355f.remove(size);
            }
        }
    }

    public void g() {
        float f16 = this.f67354e;
        if (f16 == 0.0f || f16 == 1.0f) {
            this.f67350a = (byte) 2;
            this.f67351b = SystemClock.elapsedRealtime();
            this.f67352c = 0L;
            this.f67353d = 0L;
            this.f67354e = 0.01f;
            e(0.01f);
        }
    }

    public void h() {
        this.f67350a = (byte) 3;
    }

    public void i() {
        this.f67350a = (byte) 1;
    }
}

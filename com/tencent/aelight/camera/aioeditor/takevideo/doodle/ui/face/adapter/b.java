package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.widget.BaseAdapter;
import com.tencent.aelight.camera.aioeditor.capture.data.k;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage;
import com.tencent.qphone.base.util.QLog;
import hr.a;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class b<PACKAGE extends hr.a> extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    protected Context f68563d;

    /* renamed from: e, reason: collision with root package name */
    protected PACKAGE f68564e;

    /* renamed from: f, reason: collision with root package name */
    protected k f68565f;

    /* renamed from: h, reason: collision with root package name */
    public int f68566h;

    /* renamed from: i, reason: collision with root package name */
    protected FaceListPage f68567i;

    public b(Context context, FaceListPage faceListPage) {
        this.f68563d = context;
        this.f68567i = faceListPage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a() {
        return this.f68567i.S;
    }

    public void b(PACKAGE r16) {
        this.f68564e = r16;
    }

    public void c(k kVar) {
        this.f68565f = kVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        PACKAGE r06 = this.f68564e;
        if (r06 == null) {
            if (!QLog.isColorLevel()) {
                return 0;
            }
            QLog.d("FaceList", 2, "facePkg is null");
            return 0;
        }
        int b16 = r06.b();
        int a16 = this.f68564e.a();
        if (a16 >= 1) {
            if (QLog.isDevelopLevel() && b16 == 0) {
                QLog.d("FaceList", 2, "totalFaceCount = 0");
            }
            if (b16 % a16 == 0) {
                return b16 / a16;
            }
            return (b16 / a16) + 1;
        }
        throw new IllegalArgumentException("per item count < 1 :" + a16);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return Integer.valueOf(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a<K, V> {

        /* renamed from: b, reason: collision with root package name */
        private ReferenceQueue<V> f68569b = new ReferenceQueue<>();

        /* renamed from: a, reason: collision with root package name */
        private HashMap<K, a<K, V>.C0613a> f68568a = new HashMap<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes32.dex */
        public class C0613a extends SoftReference<V> {

            /* renamed from: a, reason: collision with root package name */
            private K f68570a;

            public C0613a(K k3, V v3, ReferenceQueue<? super V> referenceQueue) {
                super(v3, referenceQueue);
                this.f68570a = k3;
            }

            public K a() {
                return this.f68570a;
            }
        }

        public void b() {
            while (true) {
                Reference<? extends V> poll = this.f68569b.poll();
                if (poll == null) {
                    return;
                } else {
                    this.f68568a.remove(((C0613a) poll).a());
                }
            }
        }

        public V c(K k3) {
            if (!this.f68568a.containsKey(k3)) {
                return null;
            }
            a<K, V>.C0613a c0613a = this.f68568a.get(k3);
            if (c0613a.get() != null) {
                return c0613a.get();
            }
            return null;
        }

        public void a(K k3, V v3) {
            if (k3 != null && v3 != null) {
                if (!this.f68568a.containsKey(k3) || this.f68568a.get(k3).get() == null) {
                    this.f68568a.put(k3, new C0613a(k3, v3, this.f68569b));
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("key-value cannot be null");
        }
    }
}

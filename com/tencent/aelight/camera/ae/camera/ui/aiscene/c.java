package com.tencent.aelight.camera.ae.camera.ui.aiscene;

import android.graphics.Bitmap;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public interface c {

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f62435a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f62436b = 0;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void a(ps.c cVar);

        void onFail(String str);
    }

    void a(Bitmap bitmap, ArrayList<a> arrayList, b bVar);
}

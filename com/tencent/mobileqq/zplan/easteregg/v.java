package com.tencent.mobileqq.zplan.easteregg;

import android.graphics.Bitmap;
import android.view.View;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public interface v {

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface a {
        void onEnd();

        void onError();

        void onRelease();

        void onStart(long j3);
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f333094a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f333095b = 1;

        /* renamed from: c, reason: collision with root package name */
        public long f333096c = 0;

        /* renamed from: d, reason: collision with root package name */
        public long f333097d = 0;

        /* renamed from: e, reason: collision with root package name */
        public float f333098e = 1.0f;
    }

    boolean a(b bVar);

    void c(Map<Integer, Bitmap> map);

    View getPlayerView();

    boolean prepare(String str);

    void setStatusListener(a aVar);

    void stop();
}

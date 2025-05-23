package com.tencent.luggage.wxa.u1;

import android.content.Context;
import android.view.View;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface g extends com.tencent.luggage.wxa.eo.c {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        void setJavaScriptEnabled(boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public static String f142068a = "WAGameVConsole.html";

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public class a {

            /* renamed from: a, reason: collision with root package name */
            public String f142069a;

            /* renamed from: b, reason: collision with root package name */
            public String f142070b;

            /* renamed from: c, reason: collision with root package name */
            public InputStream f142071c;

            public a(String str, String str2, InputStream inputStream) {
                this.f142069a = str;
                this.f142070b = str2;
                this.f142071c = inputStream;
            }
        }

        public void a() {
        }

        public abstract InputStream b(String str);

        public abstract void b();

        public abstract boolean c(String str);

        public a a(String str) {
            InputStream b16 = b(str);
            if (b16 == null) {
                return null;
            }
            return new a(com.tencent.luggage.wxa.bo.e.d(str), "UTF-8", b16);
        }
    }

    void a(float f16);

    void a(b bVar);

    void d(Context context);

    void destroy();

    void g(String str);

    View getView();

    void loadUrl(String str);

    a o();

    void requestLayout();

    void setVisibility(int i3);
}

package com.tencent.luggage.wxa.hh;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface c extends com.tencent.luggage.wxa.h1.b {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void b();

        void onPause();

        void onStart();

        void onStop();
    }

    void a(b bVar);

    g b(String str);

    void b(b bVar);

    void onBackground();

    void onDestroy();

    void onForeground();

    g pause();

    g stop();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements b {
        @Override // com.tencent.luggage.wxa.hh.c.b
        public void onPause() {
        }

        @Override // com.tencent.luggage.wxa.hh.c.b
        public void onStart() {
        }

        @Override // com.tencent.luggage.wxa.hh.c.b
        public void onStop() {
        }
    }
}

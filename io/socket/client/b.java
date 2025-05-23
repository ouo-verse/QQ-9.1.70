package io.socket.client;

import io.socket.emitter.Emitter;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    static class a implements InterfaceC10546b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Emitter f408091a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f408092b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Emitter.Listener f408093c;

        a(Emitter emitter, String str, Emitter.Listener listener) {
            this.f408091a = emitter;
            this.f408092b = str;
            this.f408093c = listener;
        }

        @Override // io.socket.client.b.InterfaceC10546b
        public void destroy() {
            this.f408091a.off(this.f408092b, this.f408093c);
        }
    }

    /* compiled from: P */
    /* renamed from: io.socket.client.b$b, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public interface InterfaceC10546b {
        void destroy();
    }

    public static InterfaceC10546b a(Emitter emitter, String str, Emitter.Listener listener) {
        emitter.on(str, listener);
        return new a(emitter, str, listener);
    }
}

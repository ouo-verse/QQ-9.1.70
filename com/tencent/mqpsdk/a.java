package com.tencent.mqpsdk;

/* compiled from: P */
/* loaded from: classes21.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: com.tencent.mqpsdk.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC9207a {
        Object decode(Object obj);

        Object encode(Object obj);
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface b {
        void a(Object obj, Object obj2);
    }

    InterfaceC9207a getCodec(String str);

    int send(Object obj);

    void setNetTransportEventListener(String str, b bVar);
}

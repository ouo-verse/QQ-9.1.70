package com.tencent.luggage.wxa.s0;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.av;
import com.google.protobuf.bg;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends GeneratedMessageLite implements av {
    private static final d DEFAULT_INSTANCE;
    private static volatile bg<d> PARSER;
    private int bitField0_;
    private int friendflag_;
    private int opcode_;
    private int scene_;
    private byte memoizedIsInitialized = 2;
    private String ilinkimId_ = "";
    private String verifyuserticket_ = "";
    private String antispamticket_ = "";
    private String nickname_ = "";
    private String content_ = "";
    private String smallheadimgurl_ = "";
    private String bigheadimgurl_ = "";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends GeneratedMessageLite.a implements av {
        public /* synthetic */ a(com.tencent.luggage.wxa.s0.a aVar) {
            this();
        }

        public a() {
            super(d.DEFAULT_INSTANCE);
        }
    }

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        GeneratedMessageLite.registerDefaultInstance(d.class, dVar);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i3 = 1;
        com.tencent.luggage.wxa.s0.a aVar = null;
        switch (com.tencent.luggage.wxa.s0.a.f139988a[methodToInvoke.ordinal()]) {
            case 1:
                return new d();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0002\u0001\u0508\u0000\u0002\u0508\u0001\u0003\b\u0002\u0004\b\u0003\u0005\u000b\u0004\u0006\u000b\u0005\u0007\u000b\u0006\b\b\u0007\t\b\b\n\b\t", new Object[]{"bitField0_", "ilinkimId_", "verifyuserticket_", "antispamticket_", "nickname_", "friendflag_", "scene_", "opcode_", "content_", "smallheadimgurl_", "bigheadimgurl_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                bg<d> bgVar = PARSER;
                if (bgVar == null) {
                    synchronized (d.class) {
                        bgVar = PARSER;
                        if (bgVar == null) {
                            bgVar = new GeneratedMessageLite.b<>(DEFAULT_INSTANCE);
                            PARSER = bgVar;
                        }
                    }
                }
                return bgVar;
            case 6:
                return Byte.valueOf(this.memoizedIsInitialized);
            case 7:
                if (obj == null) {
                    i3 = 0;
                }
                this.memoizedIsInitialized = (byte) i3;
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static d a(byte[] bArr) {
        return (d) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }
}

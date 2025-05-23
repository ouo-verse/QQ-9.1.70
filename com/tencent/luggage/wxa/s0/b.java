package com.tencent.luggage.wxa.s0;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.av;
import com.google.protobuf.bg;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends GeneratedMessageLite implements av {
    private static final b DEFAULT_INSTANCE;
    private static volatile bg<b> PARSER;
    private int bindType_;
    private int bitField0_;
    private long contactId_;
    private int sex_;
    private int source_;
    private int type_;
    private byte memoizedIsInitialized = 2;
    private String ilinkimId_ = "";
    private String nickname_ = "";
    private String remark_ = "";
    private String bigHeadimg_ = "";
    private String smallHeadimg_ = "";
    private String nicknamePyinit_ = "";
    private String nicknameQuanpin_ = "";
    private String remarkPyinit_ = "";
    private String remarkQuanpin_ = "";
    private String antispamTicket_ = "";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends GeneratedMessageLite.a implements av {
        public /* synthetic */ a(com.tencent.luggage.wxa.s0.a aVar) {
            this();
        }

        public a() {
            super(b.DEFAULT_INSTANCE);
        }
    }

    static {
        b bVar = new b();
        DEFAULT_INSTANCE = bVar;
        GeneratedMessageLite.registerDefaultInstance(b.class, bVar);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i3 = 1;
        com.tencent.luggage.wxa.s0.a aVar = null;
        switch (com.tencent.luggage.wxa.s0.a.f139988a[methodToInvoke.ordinal()]) {
            case 1:
                return new b();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0000\u0001\u0001\u0003\u0000\u0002\u0508\u0001\u0003\b\u0002\u0004\u000b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\u000b\u0007\t\b\b\n\b\t\u000b\b\n\f\b\u000b\r\b\f\u000e\u000b\r\u000f\u000b\u000e", new Object[]{"bitField0_", "contactId_", "ilinkimId_", "nickname_", "type_", "remark_", "bigHeadimg_", "smallHeadimg_", "source_", "nicknamePyinit_", "nicknameQuanpin_", "remarkPyinit_", "remarkQuanpin_", "antispamTicket_", "sex_", "bindType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                bg<b> bgVar = PARSER;
                if (bgVar == null) {
                    synchronized (b.class) {
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

    public static b a(byte[] bArr) {
        return (b) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }
}

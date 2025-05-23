package com.tencent.luggage.wxa.s0;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.av;
import com.google.protobuf.bg;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends GeneratedMessageLite implements av {
    private static final c DEFAULT_INSTANCE;
    private static volatile bg<c> PARSER;
    private int bitField0_;
    private long uin_;
    private String ilinkimId_ = "";
    private String nickname_ = "";
    private String sex_ = "";
    private String province_ = "";
    private String city_ = "";
    private String smallheadurl_ = "";
    private String bigheadurl_ = "";
    private String qrcodepath_ = "";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends GeneratedMessageLite.a implements av {
        public /* synthetic */ a(com.tencent.luggage.wxa.s0.a aVar) {
            this();
        }

        public a() {
            super(c.DEFAULT_INSTANCE);
        }
    }

    static {
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        GeneratedMessageLite.registerDefaultInstance(c.class, cVar);
    }

    public String b() {
        return this.bigheadurl_;
    }

    public String c() {
        return this.city_;
    }

    public String d() {
        return this.ilinkimId_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        com.tencent.luggage.wxa.s0.a aVar = null;
        switch (com.tencent.luggage.wxa.s0.a.f139988a[methodToInvoke.ordinal()]) {
            case 1:
                return new c();
            case 2:
                return new a(aVar);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001\b\u0000\u0002\u0003\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b", new Object[]{"bitField0_", "ilinkimId_", "uin_", "nickname_", "sex_", "province_", "city_", "smallheadurl_", "bigheadurl_", "qrcodepath_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                bg<c> bgVar = PARSER;
                if (bgVar == null) {
                    synchronized (c.class) {
                        bgVar = PARSER;
                        if (bgVar == null) {
                            bgVar = new GeneratedMessageLite.b<>(DEFAULT_INSTANCE);
                            PARSER = bgVar;
                        }
                    }
                }
                return bgVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public String e() {
        return this.province_;
    }

    public String f() {
        return this.qrcodepath_;
    }

    public String g() {
        return this.sex_;
    }

    public String getNickname() {
        return this.nickname_;
    }

    public long getUin() {
        return this.uin_;
    }

    public String h() {
        return this.smallheadurl_;
    }

    public boolean hasNickname() {
        if ((this.bitField0_ & 4) != 0) {
            return true;
        }
        return false;
    }

    public boolean hasUin() {
        if ((this.bitField0_ & 2) != 0) {
            return true;
        }
        return false;
    }

    public boolean i() {
        if ((this.bitField0_ & 128) != 0) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if ((this.bitField0_ & 32) != 0) {
            return true;
        }
        return false;
    }

    public boolean k() {
        if ((this.bitField0_ & 1) != 0) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if ((this.bitField0_ & 16) != 0) {
            return true;
        }
        return false;
    }

    public boolean m() {
        if ((this.bitField0_ & 256) != 0) {
            return true;
        }
        return false;
    }

    public boolean n() {
        if ((this.bitField0_ & 8) != 0) {
            return true;
        }
        return false;
    }

    public boolean o() {
        if ((this.bitField0_ & 64) != 0) {
            return true;
        }
        return false;
    }

    public static c a(byte[] bArr) {
        return (c) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }
}

package com.tencent.mobileqq.icgame.sso;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qqlive.callback.sso.IBufferHeaderHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private FromServiceMsg f237775a;

    /* renamed from: b, reason: collision with root package name */
    private int f237776b;

    /* renamed from: c, reason: collision with root package name */
    private String f237777c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f237778d;

    /* renamed from: e, reason: collision with root package name */
    private int f237779e;

    /* renamed from: f, reason: collision with root package name */
    private int f237780f;

    /* renamed from: g, reason: collision with root package name */
    private int f237781g;

    /* renamed from: h, reason: collision with root package name */
    private String f237782h;

    /* renamed from: i, reason: collision with root package name */
    private String f237783i;

    /* renamed from: j, reason: collision with root package name */
    private String f237784j;

    public i(FromServiceMsg fromServiceMsg, String str, String str2) {
        this.f237775a = fromServiceMsg;
        this.f237783i = str;
        this.f237784j = str2;
    }

    public String a() {
        return this.f237783i;
    }

    public int b() {
        return this.f237781g;
    }

    public String c() {
        return this.f237782h;
    }

    public String d() {
        return this.f237784j;
    }

    public byte[] e() {
        return this.f237778d;
    }

    public String f() {
        return this.f237777c;
    }

    public int g() {
        return this.f237776b;
    }

    public FromServiceMsg h() {
        return this.f237775a;
    }

    public i(IBufferHeaderHandler iBufferHeaderHandler, FromServiceMsg fromServiceMsg, byte[] bArr, String str, String str2) {
        this.f237775a = fromServiceMsg;
        this.f237783i = str;
        this.f237784j = str2;
        try {
            if (iBufferHeaderHandler != null) {
                this.f237778d = iBufferHeaderHandler.unpackRspHeader(bArr);
                this.f237781g = fromServiceMsg.getBusinessFailCode();
                this.f237782h = fromServiceMsg.getBusinessFailMsg();
            } else {
                iz0.c c16 = iz0.c.c(bArr);
                this.f237776b = c16.f409018a;
                this.f237777c = c16.f409019b;
                this.f237778d = c16.f409020c;
                this.f237779e = c16.f409021d;
                this.f237780f = c16.f409022e;
                this.f237781g = c16.f409023f;
                this.f237782h = c16.f409024g;
                if (QLog.isColorLevel()) {
                    QLog.d("ICGameRspData", 2, "QQLiveRspData ProxyRsp:" + c16);
                }
            }
        } catch (InvalidProtocolBufferNanoException e16) {
            QLog.e("ICGameRspData", 1, "QQLiveRspData throw exception:" + e16.getMessage());
        }
    }
}

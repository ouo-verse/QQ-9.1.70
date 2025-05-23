package com.tencent.mobileqq.qqexpand.network;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import expand.network.gateway$SSOUpStream;
import expand.network.gateway$SSOUpStreamHead;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f263955a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f263956b;

    /* renamed from: c, reason: collision with root package name */
    private int f263957c;

    /* renamed from: d, reason: collision with root package name */
    private int f263958d;

    /* renamed from: e, reason: collision with root package name */
    private int f263959e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f263960f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f263961g;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqexpand.network.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C8321a {

        /* renamed from: a, reason: collision with root package name */
        private String f263962a;

        /* renamed from: b, reason: collision with root package name */
        private byte[] f263963b;

        /* renamed from: c, reason: collision with root package name */
        private int f263964c = 0;

        /* renamed from: d, reason: collision with root package name */
        private int f263965d = 0;

        /* renamed from: e, reason: collision with root package name */
        private int f263966e = 30;

        /* renamed from: f, reason: collision with root package name */
        private boolean f263967f = false;

        /* renamed from: g, reason: collision with root package name */
        private boolean f263968g = false;

        public a h() {
            return new a(this);
        }

        public C8321a i(byte[] bArr) {
            this.f263963b = bArr;
            return this;
        }

        public C8321a j(String str) {
            this.f263962a = str;
            return this;
        }

        public C8321a k(boolean z16) {
            this.f263968g = z16;
            return this;
        }

        public C8321a l(boolean z16) {
            this.f263967f = z16;
            return this;
        }
    }

    public a(C8321a c8321a) {
        this.f263957c = 0;
        this.f263958d = 0;
        this.f263959e = 30;
        this.f263960f = false;
        this.f263961g = false;
        this.f263961g = c8321a.f263967f;
        this.f263960f = c8321a.f263968g;
        this.f263955a = c8321a.f263962a;
        this.f263956b = c8321a.f263963b;
        this.f263957c = c8321a.f263964c;
        this.f263958d = c8321a.f263965d;
        this.f263959e = c8321a.f263966e;
    }

    protected byte[] a() {
        return this.f263956b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b() {
        return this.f263955a;
    }

    public int c() {
        return this.f263957c;
    }

    public int d() {
        return this.f263958d;
    }

    public long e() {
        return this.f263959e * 1000;
    }

    public byte[] f() {
        try {
            if (this.f263961g) {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.uint32_command.set(c());
                oidb_sso_oidbssopkg.uint32_service_type.set(d());
                oidb_sso_oidbssopkg.uint32_result.set(0);
                oidb_sso_oidbssopkg.str_client_version.set(AppSetting.n());
                oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(a()));
                return oidb_sso_oidbssopkg.toByteArray();
            }
            gateway$SSOUpStream gateway_ssoupstream = new gateway$SSOUpStream();
            gateway_ssoupstream.head = new gateway$SSOUpStreamHead();
            gateway_ssoupstream.body.set(ByteStringMicro.copyFrom(a()));
            return gateway_ssoupstream.toByteArray();
        } catch (Throwable th5) {
            QLog.e("ExpandReqInfo", 1, "getWupBuffer error.", th5);
            return new byte[0];
        }
    }

    public boolean g() {
        return this.f263960f;
    }

    public boolean h() {
        return this.f263961g;
    }
}

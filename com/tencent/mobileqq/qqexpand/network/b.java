package com.tencent.mobileqq.qqexpand.network;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import expand.network.gateway$SSODownStream;
import expand.network.gateway$SSODownStreamHead;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    protected int f263969a;

    /* renamed from: b, reason: collision with root package name */
    protected String f263970b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f263971c;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a extends b {
        public a(int i3, String str) {
            super(i3, str);
        }

        @Override // com.tencent.mobileqq.qqexpand.network.b
        public void a(byte[] bArr) {
            if (this.f263969a == 1000) {
                this.f263971c = bArr;
                return;
            }
            QLog.w("expand.cmd.ExpandDirectConnectSSOResponse", 1, "cmd error=" + this.f263969a + " msg=" + this.f263970b);
        }

        @Override // com.tencent.mobileqq.qqexpand.network.b
        @Nullable
        public byte[] b() {
            return this.f263971c;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqexpand.network.b$b, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C8322b extends b {

        /* renamed from: d, reason: collision with root package name */
        private oidb_sso$OIDBSSOPkg f263972d;

        public C8322b(int i3, String str) {
            super(i3, str);
        }

        @Override // com.tencent.mobileqq.qqexpand.network.b
        public void a(byte[] bArr) {
            this.f263972d = new oidb_sso$OIDBSSOPkg();
            if (this.f263969a == 1000) {
                StringBuilder sb5 = new StringBuilder();
                try {
                    this.f263972d.mergeFrom(bArr);
                    this.f263969a = this.f263972d.uint32_result.get();
                    this.f263970b = this.f263972d.str_error_msg.get();
                    sb5.append("parseOIDBPkg, errMsg: ");
                    sb5.append(this.f263970b);
                } catch (InvalidProtocolBufferMicroException e16) {
                    sb5.append("parseOIDBPkg, oidb_sso, parseFrom byte ");
                    sb5.append(e16.toString());
                    e16.printStackTrace();
                }
                if (sb5.length() > 0 && QLog.isDevelopLevel()) {
                    QLog.i("expand.cmd.ExpandOIDBResponse", 4, sb5.toString());
                    return;
                }
                return;
            }
            QLog.w("expand.cmd.ExpandOIDBResponse", 1, "cmd error=" + this.f263969a + " msg=" + this.f263970b);
        }

        @Override // com.tencent.mobileqq.qqexpand.network.b
        @Nullable
        public byte[] b() {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = this.f263972d;
            if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && this.f263972d.bytes_bodybuffer.get() != null) {
                return this.f263972d.bytes_bodybuffer.get().toByteArray();
            }
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class c extends b {

        /* renamed from: d, reason: collision with root package name */
        private gateway$SSODownStream f263973d;

        public c(int i3, String str) {
            super(i3, str);
        }

        @Override // com.tencent.mobileqq.qqexpand.network.b
        public void a(byte[] bArr) {
            if (this.f263969a == 1000) {
                try {
                    gateway$SSODownStream gateway_ssodownstream = new gateway$SSODownStream();
                    this.f263973d = gateway_ssodownstream;
                    gateway_ssodownstream.head = new gateway$SSODownStreamHead();
                    this.f263973d.mergeFrom(bArr);
                    if (this.f263973d.head.has()) {
                        this.f263969a = this.f263973d.head.code.get();
                        this.f263970b = this.f263973d.head.f397369msg.get();
                        return;
                    }
                    return;
                } catch (Throwable th5) {
                    QLog.e("expand.cmd.ExpandSSOResponse", 1, "decode error.", th5);
                    this.f263969a = 900000002;
                    return;
                }
            }
            QLog.w("expand.cmd.ExpandSSOResponse", 1, "cmd error=" + this.f263969a + " msg=" + this.f263970b);
        }

        @Override // com.tencent.mobileqq.qqexpand.network.b
        @Nullable
        public byte[] b() {
            gateway$SSODownStream gateway_ssodownstream = this.f263973d;
            if (gateway_ssodownstream != null && gateway_ssodownstream.body.has() && this.f263973d.body.get() != null) {
                return this.f263973d.body.get().toByteArray();
            }
            return null;
        }
    }

    public b(int i3, String str) {
        this.f263969a = i3;
        this.f263970b = str;
    }

    @Nullable
    public byte[] b() {
        return null;
    }

    public int c() {
        return this.f263969a;
    }

    public String d() {
        StringBuffer stringBuffer = new StringBuffer("ErrorInfo");
        stringBuffer.append(" errorCode:");
        stringBuffer.append(c());
        stringBuffer.append(" errorMsg:");
        stringBuffer.append(e());
        return stringBuffer.toString();
    }

    public String e() {
        return this.f263970b;
    }

    public void a(byte[] bArr) {
    }
}

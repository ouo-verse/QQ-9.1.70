package com.tencent.gamecenter.wadl.sdk.common.d.k.a.c;

import android.os.SystemClock;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
class f extends a {

    /* renamed from: j, reason: collision with root package name */
    private int f107165j;

    /* renamed from: k, reason: collision with root package name */
    private int f107166k;

    /* renamed from: l, reason: collision with root package name */
    private byte[] f107167l;

    /* JADX INFO: Access modifiers changed from: protected */
    public f(String str, byte b16, List<String> list) {
        super(str, b16, list);
    }

    private int i() {
        byte[] bArr;
        Map<String, byte[]> map = this.f107147d;
        if (map != null && map.containsKey("connect_timeout") && (bArr = this.f107147d.get("connect_timeout")) != null && bArr.length == 1) {
            return bArr[0] * 1000;
        }
        return 2000;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00c2 A[Catch: all -> 0x0131, TRY_LEAVE, TryCatch #1 {all -> 0x0131, blocks: (B:10:0x00ab, B:12:0x00c2), top: B:9:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0126 A[Catch: all -> 0x0147, TryCatch #2 {all -> 0x0147, blocks: (B:18:0x0121, B:20:0x0126, B:22:0x012b, B:31:0x0143, B:33:0x014b, B:35:0x0150), top: B:7:0x00a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x012b A[Catch: all -> 0x0147, TRY_LEAVE, TryCatch #2 {all -> 0x0147, blocks: (B:18:0x0121, B:20:0x0126, B:22:0x012b, B:31:0x0143, B:33:0x014b, B:35:0x0150), top: B:7:0x00a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0143 A[Catch: all -> 0x0147, TRY_ENTER, TryCatch #2 {all -> 0x0147, blocks: (B:18:0x0121, B:20:0x0126, B:22:0x012b, B:31:0x0143, B:33:0x014b, B:35:0x0150), top: B:7:0x00a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x014b A[Catch: all -> 0x0147, TryCatch #2 {all -> 0x0147, blocks: (B:18:0x0121, B:20:0x0126, B:22:0x012b, B:31:0x0143, B:33:0x014b, B:35:0x0150), top: B:7:0x00a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0150 A[Catch: all -> 0x0147, TRY_LEAVE, TryCatch #2 {all -> 0x0147, blocks: (B:18:0x0121, B:20:0x0126, B:22:0x012b, B:31:0x0143, B:33:0x014b, B:35:0x0150), top: B:7:0x00a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f6  */
    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean a(String str) {
        StringBuilder sb5;
        String str2;
        int i3;
        String str3;
        OutputStream outputStream;
        Throwable th5;
        InputStream inputStream;
        Socket socket;
        InputStream inputStream2;
        OutputStream outputStream2;
        byte[] bArr;
        long j3;
        long j16;
        com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-AbsDetectTask", "start detect ipTask:" + str);
        String[] split = str.trim().split(":");
        if (split.length == 2) {
            str3 = split[0];
            i3 = Integer.parseInt(split[1]);
            if (i3 < 0 || i3 > 65535) {
                sb5 = new StringBuilder();
                sb5.append("port is not correct.. when dest:");
            }
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str3, i3);
            Socket socket2 = null;
            InputStream inputStream3 = null;
            outputStream2 = null;
            outputStream2 = null;
            try {
                try {
                    this.f107152i += 128;
                    socket = new Socket();
                    try {
                        socket.setSoTimeout(this.f107166k);
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        socket.connect(inetSocketAddress, this.f107165j);
                        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                        bArr = this.f107167l;
                        if (bArr == null) {
                            this.f107152i += bArr.length;
                            long elapsedRealtime3 = SystemClock.elapsedRealtime();
                            OutputStream outputStream3 = socket.getOutputStream();
                            try {
                                outputStream3.write(this.f107167l);
                                outputStream3.flush();
                                j3 = SystemClock.elapsedRealtime() - elapsedRealtime3;
                                long elapsedRealtime4 = SystemClock.elapsedRealtime();
                                inputStream3 = socket.getInputStream();
                                inputStream3.read();
                                j16 = SystemClock.elapsedRealtime() - elapsedRealtime4;
                                outputStream2 = outputStream3;
                                inputStream2 = inputStream3;
                            } catch (Throwable th6) {
                                th = th6;
                                InputStream inputStream4 = inputStream3;
                                outputStream2 = outputStream3;
                                inputStream2 = inputStream4;
                                Throwable th7 = th;
                                inputStream = inputStream2;
                                outputStream = outputStream2;
                                socket2 = socket;
                                th5 = th7;
                                try {
                                    th5.printStackTrace();
                                    if (socket2 != null) {
                                        socket2.close();
                                    }
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    return true;
                                } catch (Throwable th8) {
                                    if (socket2 != null) {
                                        try {
                                            socket2.close();
                                        } catch (Throwable th9) {
                                            th9.printStackTrace();
                                            throw th8;
                                        }
                                    }
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    throw th8;
                                }
                            }
                        } else {
                            j3 = -1;
                            inputStream2 = null;
                            j16 = -1;
                        }
                        try {
                            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-AbsDetectTask", "ip detect time:" + elapsedRealtime2 + " write time:" + j3 + " read time:" + j16);
                            socket.close();
                            if (outputStream2 != null) {
                                outputStream2.close();
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            Throwable th72 = th;
                            inputStream = inputStream2;
                            outputStream = outputStream2;
                            socket2 = socket;
                            th5 = th72;
                            th5.printStackTrace();
                            if (socket2 != null) {
                            }
                            if (outputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            return true;
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        inputStream2 = null;
                    }
                } catch (Throwable th12) {
                    outputStream = null;
                    th5 = th12;
                    inputStream = null;
                }
            } catch (Throwable th13) {
                th13.printStackTrace();
            }
            return true;
        }
        if (split.length > 2) {
            int parseInt = Integer.parseInt(split[split.length - 1]);
            if (parseInt >= 0 && parseInt <= 65535) {
                str = str.substring(0, (str.length() - split[split.length - 1].length()) - 1);
                com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-AbsDetectTask", "after cut ipv6:" + str);
                if (!com.tencent.gamecenter.wadl.sdk.common.e.g.f(str)) {
                    sb5 = new StringBuilder();
                    str2 = "detect ip is not valid when ip:";
                } else {
                    i3 = parseInt;
                    str3 = str;
                    InetSocketAddress inetSocketAddress2 = new InetSocketAddress(str3, i3);
                    Socket socket22 = null;
                    InputStream inputStream32 = null;
                    outputStream2 = null;
                    outputStream2 = null;
                    this.f107152i += 128;
                    socket = new Socket();
                    socket.setSoTimeout(this.f107166k);
                    long elapsedRealtime5 = SystemClock.elapsedRealtime();
                    socket.connect(inetSocketAddress2, this.f107165j);
                    long elapsedRealtime22 = SystemClock.elapsedRealtime() - elapsedRealtime5;
                    bArr = this.f107167l;
                    if (bArr == null) {
                    }
                    com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-AbsDetectTask", "ip detect time:" + elapsedRealtime22 + " write time:" + j3 + " read time:" + j16);
                    socket.close();
                    if (outputStream2 != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    return true;
                }
            } else {
                sb5 = new StringBuilder();
                sb5.append("port is not correct.. when dest:");
            }
        } else {
            sb5 = new StringBuilder();
            str2 = "ipTask is abandoned because dest is invalid:";
        }
        sb5.append(str2);
        sb5.append(str);
        com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-cloud-AbsDetectTask", sb5.toString());
        return false;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.a
    protected void c() {
        this.f107165j = i();
        this.f107166k = e();
        this.f107167l = f();
    }
}

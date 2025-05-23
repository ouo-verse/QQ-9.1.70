package com.tencent.halley.common.d.b.a.a;

import android.net.http.Headers;
import android.os.SystemClock;
import com.tencent.halley.common.utils.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.report.UploadQualityReportBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.light.LightConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class f extends com.tencent.halley.common.d.b.a.a.a {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    private int f113451j;

    /* renamed from: k, reason: collision with root package name */
    private int f113452k;

    /* renamed from: l, reason: collision with root package name */
    private byte[] f113453l;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f113454a;

        /* renamed from: b, reason: collision with root package name */
        public String f113455b;

        /* renamed from: c, reason: collision with root package name */
        public long f113456c;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            } else {
                this.f113454a = 0;
                this.f113456c = -1L;
            }
        }

        /* synthetic */ a(f fVar, byte b16) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, fVar, Byte.valueOf(b16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(String str, byte b16, List<String> list) {
        super(str, b16, list);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Byte.valueOf(b16), list);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d3 A[Catch: all -> 0x0178, TRY_LEAVE, TryCatch #7 {all -> 0x0178, blocks: (B:17:0x00b6, B:19:0x00d3), top: B:16:0x00b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0160 A[Catch: all -> 0x016a, TryCatch #8 {all -> 0x016a, blocks: (B:38:0x015b, B:40:0x0160, B:42:0x0165), top: B:37:0x015b }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0165 A[Catch: all -> 0x016a, TRY_LEAVE, TryCatch #8 {all -> 0x016a, blocks: (B:38:0x015b, B:40:0x0160, B:42:0x0165), top: B:37:0x015b }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0196 A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:58:0x0189, B:60:0x0196, B:73:0x019c, B:75:0x01a2, B:76:0x01a8, B:78:0x01d9, B:80:0x01df, B:82:0x01ec, B:86:0x0200, B:87:0x0205, B:89:0x0209, B:91:0x020d, B:92:0x0211, B:94:0x0215, B:95:0x0219, B:97:0x021d, B:98:0x0221, B:100:0x0227, B:102:0x0234, B:105:0x023e, B:107:0x0247, B:109:0x0250, B:110:0x0255), top: B:57:0x0189 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0263 A[Catch: all -> 0x025f, TryCatch #10 {all -> 0x025f, blocks: (B:72:0x025b, B:63:0x0263, B:65:0x0268), top: B:71:0x025b }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0268 A[Catch: all -> 0x025f, TRY_LEAVE, TryCatch #10 {all -> 0x025f, blocks: (B:72:0x025b, B:63:0x0263, B:65:0x0268), top: B:71:0x025b }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x025b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x019c A[Catch: all -> 0x02f0, TryCatch #0 {all -> 0x02f0, blocks: (B:58:0x0189, B:60:0x0196, B:73:0x019c, B:75:0x01a2, B:76:0x01a8, B:78:0x01d9, B:80:0x01df, B:82:0x01ec, B:86:0x0200, B:87:0x0205, B:89:0x0209, B:91:0x020d, B:92:0x0211, B:94:0x0215, B:95:0x0219, B:97:0x021d, B:98:0x0221, B:100:0x0227, B:102:0x0234, B:105:0x023e, B:107:0x0247, B:109:0x0250, B:110:0x0255), top: B:57:0x0189 }] */
    @Override // com.tencent.halley.common.d.b.a.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final boolean a(String str) {
        String str2;
        int i3;
        String concat;
        a aVar;
        long j3;
        long j16;
        Socket socket;
        InputStream inputStream;
        long j17;
        OutputStream outputStream;
        boolean z16;
        long j18;
        boolean z17;
        String str3;
        Socket socket2;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.tencent.halley.common.utils.d.b("halley-cloud-AbsDetectTask", "start detect ipTask:".concat(String.valueOf(str)));
        String[] split = str.trim().split(":");
        byte b16 = 0;
        if (split.length == 2) {
            str2 = split[0];
            i3 = Integer.parseInt(split[1]);
            if (i3 < 0 || i3 > 65535) {
                concat = "port is not correct.. when dest:".concat(str);
                com.tencent.halley.common.utils.d.e("halley-cloud-AbsDetectTask", concat);
                return false;
            }
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str2, i3);
            aVar = new a(this, b16);
            try {
                this.f113424e += 128;
                socket2 = new Socket();
                try {
                    socket2.setSoTimeout(this.f113452k);
                    aVar.f113456c = SystemClock.elapsedRealtime();
                    socket2.connect(inetSocketAddress, this.f113451j);
                    aVar.f113456c = SystemClock.elapsedRealtime() - aVar.f113456c;
                    bArr = this.f113453l;
                    if (bArr == null) {
                        this.f113424e += bArr.length;
                        j18 = SystemClock.elapsedRealtime();
                        try {
                            OutputStream outputStream2 = socket2.getOutputStream();
                            try {
                                outputStream2.write(this.f113453l);
                                outputStream2.flush();
                                j18 = SystemClock.elapsedRealtime() - j18;
                                j17 = SystemClock.elapsedRealtime();
                                try {
                                    InputStream inputStream2 = socket2.getInputStream();
                                    try {
                                        inputStream2.read();
                                        j17 = SystemClock.elapsedRealtime() - j17;
                                        outputStream = outputStream2;
                                        inputStream = inputStream2;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        j3 = elapsedRealtime;
                                        j16 = j18;
                                        socket = socket2;
                                        outputStream = outputStream2;
                                        inputStream = inputStream2;
                                        try {
                                            th.printStackTrace();
                                            aVar.f113456c = -1L;
                                            if (!com.tencent.halley.common.a.c.j()) {
                                            }
                                            if (socket != null) {
                                            }
                                            if (outputStream != null) {
                                            }
                                            if (inputStream != null) {
                                            }
                                            j18 = j16;
                                            HashMap hashMap = new HashMap();
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append(aVar.f113456c);
                                            hashMap.put("D13", sb5.toString());
                                            hashMap.put("D12", str2);
                                            if (this.f113453l != null) {
                                            }
                                            StringBuilder sb6 = new StringBuilder();
                                            sb6.append(SystemClock.elapsedRealtime() - j3);
                                            hashMap.put("D18", sb6.toString());
                                            hashMap.put("D7", str);
                                            z17 = this.f113420a;
                                            if (!z17) {
                                            }
                                            a(str3, aVar.f113454a, aVar.f113455b, hashMap, z17);
                                            return true;
                                        } finally {
                                        }
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    j3 = elapsedRealtime;
                                    j16 = j18;
                                    outputStream = outputStream2;
                                    socket = socket2;
                                    inputStream = null;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                j3 = elapsedRealtime;
                                j16 = j18;
                                outputStream = outputStream2;
                                socket = socket2;
                                inputStream = null;
                                j17 = -1;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            j3 = elapsedRealtime;
                            j16 = j18;
                            socket = socket2;
                            inputStream = null;
                            j17 = -1;
                            outputStream = null;
                            th.printStackTrace();
                            aVar.f113456c = -1L;
                            if (!com.tencent.halley.common.a.c.j()) {
                            }
                            if (socket != null) {
                            }
                            if (outputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                            j18 = j16;
                            HashMap hashMap2 = new HashMap();
                            StringBuilder sb52 = new StringBuilder();
                            sb52.append(aVar.f113456c);
                            hashMap2.put("D13", sb52.toString());
                            hashMap2.put("D12", str2);
                            if (this.f113453l != null) {
                            }
                            StringBuilder sb62 = new StringBuilder();
                            sb62.append(SystemClock.elapsedRealtime() - j3);
                            hashMap2.put("D18", sb62.toString());
                            hashMap2.put("D7", str);
                            z17 = this.f113420a;
                            if (!z17) {
                            }
                            a(str3, aVar.f113454a, aVar.f113455b, hashMap2, z17);
                            return true;
                        }
                    } else {
                        j18 = -1;
                        inputStream = null;
                        j17 = -1;
                        outputStream = null;
                    }
                    try {
                        StringBuilder sb7 = new StringBuilder("ip detect time:");
                        j3 = elapsedRealtime;
                    } catch (Throwable th9) {
                        th = th9;
                        j3 = elapsedRealtime;
                    }
                } catch (Throwable th10) {
                    th = th10;
                    j3 = elapsedRealtime;
                    socket = socket2;
                    j16 = -1;
                }
            } catch (Throwable th11) {
                th = th11;
                j3 = elapsedRealtime;
                j16 = -1;
                socket = null;
            }
            try {
                sb7.append(aVar.f113456c);
                sb7.append(" write time:");
                sb7.append(j18);
                sb7.append(" read time:");
                sb7.append(j17);
                com.tencent.halley.common.utils.d.b("halley-cloud-AbsDetectTask", sb7.toString());
                try {
                    socket2.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th12) {
                    th12.printStackTrace();
                }
            } catch (Throwable th13) {
                th = th13;
                j16 = j18;
                socket = socket2;
                th.printStackTrace();
                aVar.f113456c = -1L;
                if (!com.tencent.halley.common.a.c.j()) {
                    aVar.f113454a = -505;
                } else if (g()) {
                    aVar.f113454a = LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT;
                } else {
                    aVar.f113454a = -515;
                    aVar.f113455b = th.getClass().getName() + "(" + th.getLocalizedMessage() + ")";
                    if (th instanceof SocketTimeoutException) {
                        String localizedMessage = th.getLocalizedMessage();
                        if (localizedMessage != null && (localizedMessage.toLowerCase().contains(UploadQualityReportBuilder.STATE_CONNECT) || localizedMessage.toLowerCase().contains(Headers.CONN_DIRECTIVE))) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            aVar.f113454a = -509;
                        } else {
                            aVar.f113454a = -510;
                        }
                    }
                    if (th instanceof ConnectException) {
                        aVar.f113454a = -511;
                    }
                    if (th instanceof SocketException) {
                        aVar.f113454a = -513;
                    }
                    if (th instanceof IOException) {
                        aVar.f113454a = -514;
                    }
                    if (th.getMessage() != null) {
                        String message = th.getMessage();
                        if (!message.contains("Permission denied") && !message.contains("ECONNREFUSED")) {
                            if (message.contains("EHOSTUNREACH") || message.contains("No route to host")) {
                                aVar.f113454a = -506;
                            }
                        }
                        aVar.f113454a = -507;
                    }
                }
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Throwable th14) {
                        th14.printStackTrace();
                        j18 = j16;
                        HashMap hashMap22 = new HashMap();
                        StringBuilder sb522 = new StringBuilder();
                        sb522.append(aVar.f113456c);
                        hashMap22.put("D13", sb522.toString());
                        hashMap22.put("D12", str2);
                        if (this.f113453l != null) {
                        }
                        StringBuilder sb622 = new StringBuilder();
                        sb622.append(SystemClock.elapsedRealtime() - j3);
                        hashMap22.put("D18", sb622.toString());
                        hashMap22.put("D7", str);
                        z17 = this.f113420a;
                        if (!z17) {
                        }
                        a(str3, aVar.f113454a, aVar.f113455b, hashMap22, z17);
                        return true;
                    }
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                j18 = j16;
                HashMap hashMap222 = new HashMap();
                StringBuilder sb5222 = new StringBuilder();
                sb5222.append(aVar.f113456c);
                hashMap222.put("D13", sb5222.toString());
                hashMap222.put("D12", str2);
                if (this.f113453l != null) {
                }
                StringBuilder sb6222 = new StringBuilder();
                sb6222.append(SystemClock.elapsedRealtime() - j3);
                hashMap222.put("D18", sb6222.toString());
                hashMap222.put("D7", str);
                z17 = this.f113420a;
                if (!z17) {
                }
                a(str3, aVar.f113454a, aVar.f113455b, hashMap222, z17);
                return true;
            }
            HashMap hashMap2222 = new HashMap();
            StringBuilder sb52222 = new StringBuilder();
            sb52222.append(aVar.f113456c);
            hashMap2222.put("D13", sb52222.toString());
            hashMap2222.put("D12", str2);
            if (this.f113453l != null) {
                hashMap2222.put("D17", String.valueOf(j17));
                hashMap2222.put("D16", String.valueOf(j18));
                StringBuilder sb8 = new StringBuilder();
                sb8.append(this.f113453l.length);
                hashMap2222.put("D20", sb8.toString());
            }
            StringBuilder sb62222 = new StringBuilder();
            sb62222.append(SystemClock.elapsedRealtime() - j3);
            hashMap2222.put("D18", sb62222.toString());
            hashMap2222.put("D7", str);
            z17 = this.f113420a;
            if (!z17) {
                str3 = "HLIpDetectEvent";
            } else {
                str3 = "HLNotRealIpDetectEvent";
            }
            a(str3, aVar.f113454a, aVar.f113455b, hashMap2222, z17);
            return true;
        }
        if (split.length > 2) {
            int parseInt = Integer.parseInt(split[split.length - 1]);
            if (parseInt >= 0 && parseInt <= 65535) {
                String substring = str.substring(0, (str.length() - split[split.length - 1].length()) - 1);
                com.tencent.halley.common.utils.d.b("halley-cloud-AbsDetectTask", "after cut ipv6:".concat(String.valueOf(substring)));
                if (!j.d(substring)) {
                    concat = "detect ip is not valid when ip:".concat(String.valueOf(substring));
                    com.tencent.halley.common.utils.d.e("halley-cloud-AbsDetectTask", concat);
                    return false;
                }
                str2 = substring;
                i3 = parseInt;
                InetSocketAddress inetSocketAddress2 = new InetSocketAddress(str2, i3);
                aVar = new a(this, b16);
                this.f113424e += 128;
                socket2 = new Socket();
                socket2.setSoTimeout(this.f113452k);
                aVar.f113456c = SystemClock.elapsedRealtime();
                socket2.connect(inetSocketAddress2, this.f113451j);
                aVar.f113456c = SystemClock.elapsedRealtime() - aVar.f113456c;
                bArr = this.f113453l;
                if (bArr == null) {
                }
                StringBuilder sb72 = new StringBuilder("ip detect time:");
                j3 = elapsedRealtime;
                sb72.append(aVar.f113456c);
                sb72.append(" write time:");
                sb72.append(j18);
                sb72.append(" read time:");
                sb72.append(j17);
                com.tencent.halley.common.utils.d.b("halley-cloud-AbsDetectTask", sb72.toString());
                socket2.close();
                if (outputStream != null) {
                }
                if (inputStream != null) {
                }
                HashMap hashMap22222 = new HashMap();
                StringBuilder sb522222 = new StringBuilder();
                sb522222.append(aVar.f113456c);
                hashMap22222.put("D13", sb522222.toString());
                hashMap22222.put("D12", str2);
                if (this.f113453l != null) {
                }
                StringBuilder sb622222 = new StringBuilder();
                sb622222.append(SystemClock.elapsedRealtime() - j3);
                hashMap22222.put("D18", sb622222.toString());
                hashMap22222.put("D7", str);
                z17 = this.f113420a;
                if (!z17) {
                }
                a(str3, aVar.f113454a, aVar.f113455b, hashMap22222, z17);
                return true;
            }
            com.tencent.halley.common.utils.d.e("halley-cloud-AbsDetectTask", "port is not correct.. when dest:".concat(str));
            return false;
        }
        com.tencent.halley.common.utils.d.e("halley-cloud-AbsDetectTask", "ipTask is abandoned because dest is invalid:".concat(str));
        return false;
    }

    @Override // com.tencent.halley.common.d.b.a.a.a
    protected final void c() {
        int i3;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        Map<String, byte[]> map = this.f113422c;
        if (map != null && map.containsKey("connect_timeout") && (bArr = this.f113422c.get("connect_timeout")) != null && bArr.length == 1) {
            i3 = bArr[0] * 1000;
        } else {
            i3 = 2000;
        }
        this.f113451j = i3;
        this.f113452k = f();
        this.f113453l = d();
    }
}

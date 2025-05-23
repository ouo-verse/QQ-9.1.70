package com.tencent.halley.common.d.b.a.a;

import android.net.ConnectivityManager;
import android.net.Network;
import android.os.SystemClock;
import com.tencent.halley.common.a.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.light.LightConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class d extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    private int f113449j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f113450k;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(String str, byte b16, List<String> list) {
        super(str, b16, list);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Byte.valueOf(b16), list);
        } else {
            this.f113450k = false;
        }
    }

    private static void a(StringBuffer stringBuffer) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) com.tencent.halley.common.a.a().getSystemService("connectivity");
            Network[] allNetworks = connectivityManager.getAllNetworks();
            int i3 = 0;
            while (true) {
                if (i3 >= allNetworks.length) {
                    break;
                }
                com.tencent.halley.common.utils.d.b("halley-cloud-AbsDetectTask", "length:" + allNetworks.length + " seqId:" + allNetworks[i3].toString());
                if (connectivityManager.getNetworkInfo(allNetworks[i3]).isConnected()) {
                    List<InetAddress> dnsServers = connectivityManager.getLinkProperties(allNetworks[i3]).getDnsServers();
                    for (int i16 = 0; i16 < dnsServers.size(); i16++) {
                        com.tencent.halley.common.utils.d.b("halley-cloud-AbsDetectTask", "inetAddressList[" + i16 + "]:" + dnsServers.get(i16).getHostAddress());
                        stringBuffer.append(dnsServers.get(i16).getHostAddress());
                        stringBuffer.append(",");
                    }
                } else {
                    i3++;
                }
            }
            if (stringBuffer.capacity() > 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.halley.common.d.b.a.a.a
    protected final void c() {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        boolean z16 = false;
        this.f113449j = h.a("detect_dns_costtime_abandon_limit", 0, 100, 0);
        Map<String, byte[]> map = this.f113422c;
        if (map != null && map.containsKey("is_dns_query_all") && (bArr = this.f113422c.get("is_dns_query_all")) != null && bArr.length == 1 && bArr[0] == 1) {
            z16 = true;
        }
        this.f113450k = z16;
    }

    private void a(StringBuffer stringBuffer, long j3, String[] strArr, int i3, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("D11", String.valueOf(j3));
        if (strArr == null || strArr.length == 0) {
            com.tencent.halley.common.utils.d.e("halley-cloud-AbsDetectTask", "queryIps is null");
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            for (String str3 : strArr) {
                stringBuffer2.append(str3);
                stringBuffer2.append(",");
            }
            stringBuffer2.deleteCharAt(stringBuffer2.length() - 1);
            hashMap.put("D12", stringBuffer2.toString());
        }
        if (stringBuffer.capacity() > 0) {
            hashMap.put("D10", stringBuffer.toString());
        }
        hashMap.put("D7", str2);
        boolean z16 = this.f113420a;
        a(z16 ? "HLDnsDetectEvent" : "HLNotRealDnsDetectEvent", i3, str, hashMap, z16);
    }

    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v7, types: [boolean] */
    @Override // com.tencent.halley.common.d.b.a.a.a
    protected final boolean a(String str) {
        ?? r56;
        int i3;
        String str2;
        long j3;
        String[] strArr;
        String[] strArr2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        StringBuffer stringBuffer = new StringBuffer();
        a(stringBuffer);
        String str3 = null;
        try {
            this.f113424e += 128;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            InetAddress[] allByName = InetAddress.getAllByName(str);
            j3 = SystemClock.elapsedRealtime() - elapsedRealtime;
            r56 = this.f113450k;
            try {
                if (r56 != 0 && allByName != null) {
                    strArr2 = new String[allByName.length];
                    for (int i16 = 0; i16 < allByName.length; i16++) {
                        strArr2[i16] = allByName[i16].getHostAddress();
                    }
                } else if (allByName == null || allByName.length == 0) {
                    strArr2 = null;
                } else {
                    strArr2 = new String[1];
                    strArr2[0] = allByName[0].getHostAddress();
                }
                str2 = null;
                i3 = 0;
                strArr = strArr2;
            } catch (Throwable th5) {
                th = th5;
                th.printStackTrace();
                if (!com.tencent.halley.common.a.c.j()) {
                    i3 = -505;
                } else if (g()) {
                    i3 = LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT;
                } else {
                    str3 = th.getClass().getSimpleName() + "(" + th.getLocalizedMessage() + ")";
                    i3 = th instanceof UnknownHostException ? -512 : -515;
                }
                str2 = str3;
                j3 = -1;
                strArr = r56;
                if (j3 != -1) {
                }
                a(stringBuffer, j3, strArr, i3, str2, str);
                return true;
            }
        } catch (Throwable th6) {
            th = th6;
            r56 = 0;
        }
        if (j3 != -1 || j3 >= this.f113449j) {
            a(stringBuffer, j3, strArr, i3, str2, str);
            return true;
        }
        com.tencent.halley.common.utils.d.b("halley-cloud-AbsDetectTask", "dnsCostTime is too small to abandon, dnsCostTime:" + j3 + " and limitTime:" + this.f113449j);
        return false;
    }
}

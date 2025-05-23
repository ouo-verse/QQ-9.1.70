package com.tencent.gamecenter.wadl.sdk.common.d.k.a.c;

import android.os.SystemClock;
import java.net.InetAddress;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
class d extends a {

    /* renamed from: j, reason: collision with root package name */
    private int f107163j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f107164k;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(String str, byte b16, List<String> list) {
        super(str, b16, list);
        this.f107164k = false;
    }

    private boolean i() {
        byte[] bArr;
        Map<String, byte[]> map = this.f107147d;
        if (map == null || !map.containsKey("is_dns_query_all") || (bArr = this.f107147d.get("is_dns_query_all")) == null || bArr.length != 1 || bArr[0] != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.a
    protected boolean a(String str) {
        long j3;
        String[] strArr = null;
        try {
            this.f107152i += 128;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            InetAddress[] allByName = InetAddress.getAllByName(str);
            j3 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (this.f107164k && allByName != null) {
                strArr = new String[allByName.length];
                for (int i3 = 0; i3 < allByName.length; i3++) {
                    strArr[i3] = allByName[i3].getHostAddress();
                }
            } else if (allByName != null && allByName.length != 0) {
                strArr = new String[]{allByName[0].getHostAddress()};
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            j3 = -1;
        }
        if (j3 != -1 && j3 < this.f107163j) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-AbsDetectTask", "dnsCostTime is too small to abandon, dnsCostTime:" + j3 + " and limitTime:" + this.f107163j);
            return false;
        }
        if (strArr != null && strArr.length != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : strArr) {
                stringBuffer.append(str2);
                stringBuffer.append(",");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        } else {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-cloud-AbsDetectTask", "queryIps is null");
        }
        return true;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.k.a.c.a
    protected void c() {
        this.f107163j = com.tencent.gamecenter.wadl.sdk.common.b.g.a("detect_dns_costtime_abandon_limit", 0, 100, 0);
        this.f107164k = i();
    }
}

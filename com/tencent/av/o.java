package com.tencent.av;

import com.qq.jce.wup.UniPacket;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.av.video.jce.QQService.strupbuff;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class o {

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f73855g = {"UNKNOWN", Global.TRACKING_WIFI, "CMWAP", "CMNET", "UNIWAP", "UNINET", "CTWAP", "CTNET", "3GWAP", "3GNET"};

    /* renamed from: h, reason: collision with root package name */
    private static o f73856h = null;

    /* renamed from: f, reason: collision with root package name */
    private int f73862f = 0;

    /* renamed from: a, reason: collision with root package name */
    private UniPacket f73857a = new UniPacket(true);

    /* renamed from: b, reason: collision with root package name */
    private Map<String, ArrayList<byte[]>> f73858b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private strupbuff f73859c = new strupbuff(this.f73858b);

    /* renamed from: d, reason: collision with root package name */
    private a f73860d = new a();

    /* renamed from: e, reason: collision with root package name */
    private byte[] f73861e = new byte[256];

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: c, reason: collision with root package name */
        String f73865c = null;

        /* renamed from: d, reason: collision with root package name */
        String f73866d = null;

        /* renamed from: e, reason: collision with root package name */
        String f73867e = null;

        /* renamed from: f, reason: collision with root package name */
        String f73868f = null;

        /* renamed from: g, reason: collision with root package name */
        long f73869g = 0;

        /* renamed from: h, reason: collision with root package name */
        long f73870h = 0;

        /* renamed from: i, reason: collision with root package name */
        long f73871i = 0;

        /* renamed from: j, reason: collision with root package name */
        int f73872j = 0;

        /* renamed from: a, reason: collision with root package name */
        String f73863a = "anroid";

        /* renamed from: b, reason: collision with root package name */
        String f73864b = "android";

        /* renamed from: k, reason: collision with root package name */
        int f73873k = 2;
    }

    o() {
    }

    private int a(int i3) {
        if (this.f73861e == null) {
            return -1;
        }
        c(this.f73860d.f73863a.length());
        int e16 = e(this.f73860d.f73863a);
        if (e16 < 0) {
            return e16;
        }
        c(this.f73860d.f73864b.length());
        int e17 = e(this.f73860d.f73864b);
        if (e17 < 0) {
            return e17;
        }
        c(this.f73860d.f73865c.length());
        int e18 = e(this.f73860d.f73865c);
        if (e18 < 0) {
            return e18;
        }
        c(this.f73860d.f73868f.length());
        int e19 = e(this.f73860d.f73868f);
        if (e19 < 0) {
            return e19;
        }
        c(this.f73860d.f73866d.length());
        int e26 = e(this.f73860d.f73866d);
        if (e26 < 0) {
            return e26;
        }
        c(this.f73860d.f73867e.length());
        int e27 = e(this.f73860d.f73867e);
        if (e27 < 0) {
            return e27;
        }
        d(this.f73860d.f73871i);
        d(this.f73860d.f73869g);
        b(this.f73860d.f73872j);
        d(this.f73860d.f73870h);
        b(this.f73860d.f73873k);
        b(i3);
        return 0;
    }

    private void b(int i3) {
        byte[] bArr = this.f73861e;
        int i16 = this.f73862f;
        bArr[i16] = (byte) (i3 & 255);
        this.f73862f = i16 + 1;
    }

    private void c(int i3) {
        byte[] bArr = this.f73861e;
        int i16 = this.f73862f;
        bArr[i16] = (byte) ((i3 >> 8) & 255);
        bArr[i16 + 1] = (byte) (i3 & 255);
        this.f73862f = i16 + 2;
    }

    private void d(long j3) {
        byte[] bArr = this.f73861e;
        int i3 = this.f73862f;
        bArr[i3] = (byte) ((j3 >> 56) & 255);
        bArr[i3 + 1] = (byte) ((j3 >> 48) & 255);
        bArr[i3 + 2] = (byte) ((j3 >> 40) & 255);
        bArr[i3 + 3] = (byte) ((j3 >> 32) & 255);
        bArr[i3 + 4] = (byte) ((j3 >> 24) & 255);
        bArr[i3 + 5] = (byte) ((j3 >> 16) & 255);
        bArr[i3 + 6] = (byte) ((j3 >> 8) & 255);
        bArr[i3 + 7] = (byte) (j3 & 255);
        this.f73862f = i3 + 8;
    }

    private int e(String str) {
        for (byte b16 : str.getBytes(StandardCharsets.UTF_8)) {
            byte[] bArr = this.f73861e;
            int i3 = this.f73862f;
            bArr[i3] = b16;
            this.f73862f = i3 + 1;
        }
        return 0;
    }

    private String f() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    private int g() {
        int i3;
        String apn = NetworkUtil.getApn(BaseApplication.getContext());
        if ("wifi".equals(apn)) {
            i3 = 1;
        } else if ("cmnet".equals(apn)) {
            i3 = 3;
        } else if ("cmwap".equals(apn)) {
            i3 = 2;
        } else if ("ctnet".equals(apn)) {
            i3 = 7;
        } else if ("ctwap".equals(apn)) {
            i3 = 6;
        } else if ("uninet".equals(apn)) {
            i3 = 5;
        } else if ("uniwap".equals(apn)) {
            i3 = 4;
        } else if ("3gnet".equals(apn)) {
            i3 = 9;
        } else if ("3gwap".equals(apn)) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SharpReport_OffLine", 2, "getApn: " + i3);
        }
        return i3;
    }

    public static o h() {
        if (f73856h == null) {
            f73856h = new o();
        }
        return f73856h;
    }

    private int i(long j3, byte[] bArr) {
        Map<String, ArrayList<byte[]>> map = this.f73858b;
        if (map != null && this.f73857a != null && this.f73859c != null) {
            map.clear();
            this.f73858b.put("617", new ArrayList<>());
            this.f73858b.get("617").add(bArr);
            this.f73857a.put("Data", this.f73859c);
            byte[] encode = this.f73857a.encode();
            ToServiceMsg toServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), String.valueOf(j3), BaseConstants.CMD_REPORTSTAT);
            toServiceMsg.setNeedCallback(false);
            toServiceMsg.putWupBuffer(encode);
            toServiceMsg.setNeedRemindSlowNetwork(false);
            try {
                if (MsfServiceSdk.get().sendMsg(toServiceMsg) < 0) {
                    return 0;
                }
                return 1;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return 0;
    }

    public static void k(long j3, long j16, int i3) {
        o h16 = h();
        h16.j(0L, j3, j16);
        h16.l(i3, 2, j16);
    }

    public void j(long j3, long j16, long j17) {
        a aVar = this.f73860d;
        if (aVar == null) {
            return;
        }
        aVar.f73870h = j17;
        aVar.f73869g = j16;
        aVar.f73871i = j3;
        aVar.f73865c = String.valueOf(AppSetting.f());
        this.f73860d.f73868f = AppSetting.i();
    }

    public int l(int i3, int i16, long j3) {
        int i17;
        if (this.f73860d == null) {
            return -1;
        }
        int g16 = g();
        a aVar = this.f73860d;
        aVar.f73867e = f73855g[g16];
        aVar.f73866d = f();
        a aVar2 = this.f73860d;
        aVar2.f73872j = 0;
        aVar2.f73873k = i16;
        if (j3 != 0) {
            aVar2.f73870h = j3;
        }
        this.f73862f = 0;
        if (a(i3) < 0 || (i17 = this.f73862f) <= 0) {
            return -1;
        }
        byte[] bArr = new byte[i17];
        System.arraycopy(this.f73861e, 0, bArr, 0, i17);
        i(this.f73860d.f73869g, bArr);
        this.f73862f = 0;
        if (QLog.isColorLevel()) {
            QLog.d("SharpReport_Node", 2, "report_node is" + i3);
        }
        return 0;
    }
}

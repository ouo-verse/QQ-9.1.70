package c.t.m.g;

import android.net.wifi.ScanResult;
import android.os.Looper;
import android.os.Message;
import android.util.Base64;
import c.t.m.g.e1;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class h extends f0 implements w, Runnable {

    /* renamed from: h, reason: collision with root package name */
    public volatile v f29712h;

    /* renamed from: i, reason: collision with root package name */
    public File f29713i;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f29709e = false;

    /* renamed from: j, reason: collision with root package name */
    public String f29714j = "wf4_bf";

    /* renamed from: k, reason: collision with root package name */
    public String f29715k = "wf4";

    /* renamed from: l, reason: collision with root package name */
    public StringBuilder f29716l = new StringBuilder(100);

    /* renamed from: g, reason: collision with root package name */
    public s f29711g = new s(8192, 5);

    /* renamed from: f, reason: collision with root package name */
    public List<String> f29710f = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements x {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f29717a;

        public a(h hVar, File file) {
            this.f29717a = file;
        }

        @Override // c.t.m.g.x
        public void a(String str) {
            if (c1.a()) {
                c1.a("WifiInfoPro", "upload failed:" + str);
            }
        }

        @Override // c.t.m.g.x
        public void b(String str) {
            this.f29717a.delete();
            if (c1.a()) {
                c1.a("WifiInfoPro", "upload suc & del:" + str);
            }
        }
    }

    public h(File file) {
        this.f29713i = file;
        if (c1.a()) {
            c1.a("WifiInfoPro", "data dir:" + this.f29713i.getAbsolutePath());
        }
    }

    @Override // c.t.m.g.i0
    public String a() {
        return "WifiInfoPro";
    }

    public final void b(List<String> list) throws IOException {
        if (!this.f29709e && !h1.a((Collection) list) && !h1.a(this.f29712h)) {
            long length = this.f29712h.b().length();
            if (c1.a()) {
                c1.a("WifiInfoPro", "wf file len:" + length);
            }
            if (length <= 51200) {
                StringBuilder sb5 = new StringBuilder(500);
                sb5.append("1|");
                sb5.append(list.size());
                for (String str : list) {
                    sb5.append(QbAddrData.DATA_SPLITER);
                    sb5.append(str);
                }
                this.f29712h.a(sb5.toString());
            }
            list.clear();
        }
    }

    @Override // c.t.m.g.i0
    public void c() {
        y0.b(d());
        a(101, 0L);
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        try {
            this.f29709e = true;
            if (this.f29712h != null) {
                this.f29712h.a();
                this.f29712h = null;
            }
            File file = new File(this.f29713i, this.f29715k);
            if (c1.a()) {
                c1.a("WifiInfoPro", "upload:" + file.getName() + "," + file.length());
            }
            byte[] a16 = p0.a(v0.a(file));
            if (j.f29776h) {
                str = "https://testdatalbs.sparta.html5.qq.com/tr?wf4";
            } else {
                str = "https://analytics.map.qq.com/?wf4";
            }
            if (!j.f29773e) {
                str = str.replace("https:", "http:");
            }
            j.f29779k.a(str, a16, new a(this, file));
            if (b()) {
                this.f29712h = new v(new File(this.f29713i, this.f29715k));
                this.f29712h.a(this);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public void a(List<ScanResult> list) {
        if (!b() || h1.a((Collection) list)) {
            return;
        }
        Message obtainMessage = d().obtainMessage(102);
        obtainMessage.obj = list;
        a(obtainMessage, 0L);
    }

    @Override // c.t.m.g.i0
    public int a(Looper looper) {
        a(100, 0L);
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0019. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0120  */
    @Override // c.t.m.g.f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Message message) throws Exception {
        e1.a a16;
        if (this.f29713i == null) {
            return;
        }
        boolean z16 = false;
        switch (message.what) {
            case 100:
                this.f29712h = new v(new File(this.f29713i, this.f29715k));
                this.f29712h.a(this);
                byte[] a17 = v0.a(new File(this.f29713i, this.f29714j));
                long longValue = ((Long) k1.a("LocationSDK", "log_fc_wf_bf_create_t_ms", (Object) 0L)).longValue();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - longValue < 2592000000L && !h1.a(a17)) {
                    this.f29711g.a(a17);
                    c1.a("WifiInfoPro", "bf init.");
                } else {
                    k1.b("LocationSDK", "log_fc_wf_bf_create_t_ms", Long.valueOf(currentTimeMillis));
                    c1.a("WifiInfoPro", "bf reset.");
                }
                a(103, MiniBoxNoticeInfo.MIN_5);
                v0.a(new File(this.f29713i, this.f29714j), this.f29711g.a(), false);
                a(104, MiniBoxNoticeInfo.MIN_5);
                return;
            case 101:
                b(this.f29710f);
                v0.a(new File(this.f29713i, this.f29714j), this.f29711g.a(), false);
                if (this.f29712h != null) {
                    this.f29712h.a();
                    this.f29712h = null;
                }
                y0.a(d(), 103);
                if (message.what != 101 && b()) {
                    a(103, 1800000L);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                long longValue2 = ((Long) k1.a("LocationSDK", "log_fc_wf_up_t_ms", (Object) 0L)).longValue();
                a16 = e1.a();
                if (a16 != e1.a.NETWORK_WIFI || (a16 == e1.a.NETWORK_MOBILE && (j.f29774f || j.f29775g))) {
                    z16 = true;
                }
                if (c1.a()) {
                    c1.a("WifiInfoPro", "lastUpT:" + longValue2 + ",deltaT:" + (currentTimeMillis2 - longValue2) + ",network status:" + a16 + ",isUpload:" + z16);
                }
                if (z16) {
                    return;
                }
                if (longValue2 != 0 && currentTimeMillis2 - longValue2 >= 86400000) {
                    w0.a("th_loc_task_t_consume", this);
                    k1.b("LocationSDK", "log_fc_wf_up_t_ms", Long.valueOf(currentTimeMillis2));
                    return;
                } else {
                    if (longValue2 == 0) {
                        k1.b("LocationSDK", "log_fc_wf_up_t_ms", Long.valueOf(currentTimeMillis2));
                        return;
                    }
                    return;
                }
            case 102:
                for (ScanResult scanResult : (List) message.obj) {
                    if (!this.f29711g.b(scanResult.BSSID)) {
                        this.f29711g.a(scanResult.BSSID);
                        this.f29710f.add(a(scanResult));
                    }
                }
                if (c1.a()) {
                    c1.a("WifiInfoPro", "wf list size:" + this.f29710f.size());
                }
                if (this.f29710f.size() >= 30) {
                    b(this.f29710f);
                    return;
                }
                return;
            case 103:
                y0.a(d(), 103);
                if (message.what != 101) {
                    a(103, 1800000L);
                    break;
                }
                long currentTimeMillis22 = System.currentTimeMillis();
                long longValue22 = ((Long) k1.a("LocationSDK", "log_fc_wf_up_t_ms", (Object) 0L)).longValue();
                a16 = e1.a();
                if (a16 != e1.a.NETWORK_WIFI) {
                    break;
                }
                z16 = true;
                if (c1.a()) {
                }
                if (z16) {
                }
                break;
            case 104:
                v0.a(new File(this.f29713i, this.f29714j), this.f29711g.a(), false);
                a(104, MiniBoxNoticeInfo.MIN_5);
                return;
            default:
                return;
        }
    }

    public final String a(ScanResult scanResult) {
        this.f29716l.setLength(0);
        try {
            StringBuilder sb5 = this.f29716l;
            sb5.append(scanResult.BSSID);
            sb5.append(',');
            StringBuilder sb6 = this.f29716l;
            sb6.append(Base64.encodeToString(scanResult.SSID.getBytes("UTF-8"), 2));
            sb6.append(',');
            StringBuilder sb7 = this.f29716l;
            sb7.append(scanResult.frequency);
            sb7.append(',');
            this.f29716l.append(Base64.encodeToString(scanResult.capabilities.getBytes("UTF-8"), 2));
        } catch (Throwable unused) {
            this.f29716l.setLength(0);
        }
        return this.f29716l.toString();
    }

    @Override // c.t.m.g.w
    public byte[] a(byte[] bArr) {
        byte[] a16 = s0.a(p0.a(bArr), s0.a("fc_wf_up"));
        if (!h1.a(a16)) {
            byte[] encode = Base64.encode(a16, 2);
            if (!h1.a(encode)) {
                try {
                    return (new String(encode) + '$').getBytes("UTF-8");
                } catch (Throwable unused) {
                }
            }
        }
        return new byte[0];
    }
}

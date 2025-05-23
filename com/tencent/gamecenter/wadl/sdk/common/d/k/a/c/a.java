package com.tencent.gamecenter.wadl.sdk.common.d.k.a.c;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected List<String> f107144a;

    /* renamed from: b, reason: collision with root package name */
    private int f107145b;

    /* renamed from: c, reason: collision with root package name */
    private int f107146c;

    /* renamed from: d, reason: collision with root package name */
    protected Map<String, byte[]> f107147d;

    /* renamed from: e, reason: collision with root package name */
    private long f107148e;

    /* renamed from: f, reason: collision with root package name */
    private int f107149f;

    /* renamed from: g, reason: collision with root package name */
    private int f107150g = 0;

    /* renamed from: h, reason: collision with root package name */
    protected int f107151h = 0;

    /* renamed from: i, reason: collision with root package name */
    protected int f107152i = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(String str, byte b16, List<String> list) {
        this.f107144a = list;
        this.f107149f = list.size();
    }

    public static a a(String str, byte b16, List<String> list) {
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-cloud-AbsDetectTask", "createDetectTask fail because targets is empty or taskId is empty");
            return null;
        }
        if (b16 != 1 && b16 != 2) {
            if (b16 != 3) {
                if (b16 != 4) {
                    switch (b16) {
                        case 12:
                            break;
                        case 13:
                            break;
                        case 14:
                            break;
                        default:
                            return null;
                    }
                }
                return new d(str, b16, list);
            }
            return new g(str, b16, list);
        }
        return new f(str, b16, list);
    }

    abstract boolean a(String str);

    public int b() {
        return this.f107149f;
    }

    abstract void c();

    protected boolean d() {
        if ((com.tencent.gamecenter.wadl.sdk.common.b.c.i() && c.f107154h != this.f107146c) || com.tencent.gamecenter.wadl.sdk.common.b.c.d() != this.f107145b) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e() {
        byte[] bArr;
        Map<String, byte[]> map = this.f107147d;
        if (map != null && map.containsKey("read_timeout") && (bArr = this.f107147d.get("read_timeout")) != null && bArr.length == 1) {
            return bArr[0] * 1000;
        }
        return 30000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] f() {
        byte[] bArr;
        Map<String, byte[]> map = this.f107147d;
        if (map == null || !map.containsKey("body") || (bArr = this.f107147d.get("body")) == null || bArr.length == 0) {
            return null;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte g() {
        byte[] bArr;
        Map<String, byte[]> map = this.f107147d;
        if (map == null || !map.containsKey("request_method") || (bArr = this.f107147d.get("request_method")) == null || bArr.length != 1) {
            return (byte) 0;
        }
        return bArr[0];
    }

    public int h() {
        return this.f107152i;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043 A[Catch: all -> 0x00ee, TryCatch #1 {all -> 0x00ee, blocks: (B:2:0x0000, B:5:0x000b, B:7:0x0011, B:9:0x0014, B:11:0x0024, B:13:0x0043, B:14:0x0047, B:16:0x004b, B:18:0x0051, B:20:0x00cd, B:21:0x006e, B:42:0x0074, B:33:0x0086, B:34:0x00ab, B:23:0x008e, B:32:0x0098, B:25:0x00af, B:27:0x00bd, B:28:0x00c8, B:30:0x00c3, B:36:0x00d3), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() {
        boolean z16;
        StringBuilder sb5;
        int i3;
        byte[] f16;
        try {
            if (com.tencent.gamecenter.wadl.sdk.common.b.c.i() && (f16 = f()) != null && f16.length != 0) {
                if (f16.length > (com.tencent.gamecenter.wadl.sdk.common.b.g.a("detect_send_traffic_limit", 1, 2048, 512) << 10)) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-cloud-AbsDetectTask", "request body is too large,abandon this request: length:" + f16.length);
                    this.f107150g = this.f107149f;
                    z16 = false;
                    if (z16) {
                        return;
                    }
                    c();
                    int i16 = 0;
                    for (int i17 = 0; i17 < this.f107149f; i17++) {
                        if (com.tencent.gamecenter.wadl.sdk.common.b.c.j()) {
                            if (d()) {
                                this.f107150g = this.f107149f - i17;
                                sb5 = new StringBuilder();
                                sb5.append("netType changed, abandonNum:");
                                i3 = this.f107150g;
                            } else if (this.f107148e < SystemClock.elapsedRealtime()) {
                                this.f107150g = this.f107149f - i17;
                                sb5 = new StringBuilder();
                                sb5.append("over due, abandon detect task\uff0c abandonNum:");
                                i3 = this.f107150g;
                            } else {
                                if (a(this.f107144a.get(i17))) {
                                    this.f107151h++;
                                } else {
                                    this.f107150g++;
                                }
                                SystemClock.sleep(100L);
                            }
                            sb5.append(i3);
                            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-cloud-AbsDetectTask", sb5.toString());
                            break;
                        }
                        i16++;
                        com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-cloud-AbsDetectTask", "NoNet: abandon one target...noNetNum:" + i16);
                        SystemClock.sleep(1000L);
                    }
                    if (i16 > 0) {
                        com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-cloud-AbsDetectTask", "NoNet: abandon num:" + i16);
                        this.f107150g = this.f107150g + i16;
                        return;
                    }
                    return;
                }
            }
            z16 = true;
            if (z16) {
            }
        } catch (Throwable unused) {
            this.f107150g = this.f107149f - this.f107151h;
        }
    }

    public void a(int i3) {
        this.f107150g = i3;
    }

    public void a(int i3, int i16) {
        this.f107145b = i3;
        this.f107146c = i16;
    }

    public void a(int i3, Map<String, byte[]> map) {
        this.f107147d = map;
        this.f107148e = SystemClock.elapsedRealtime() + (i3 * 1000);
    }
}

package com.tencent.halley.common.d.b.a.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.halley.common.a.h;
import com.tencent.halley.common.a.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.light.LightConstants;

/* compiled from: P */
/* loaded from: classes6.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected boolean f113420a;

    /* renamed from: b, reason: collision with root package name */
    protected List<String> f113421b;

    /* renamed from: c, reason: collision with root package name */
    protected Map<String, byte[]> f113422c;

    /* renamed from: d, reason: collision with root package name */
    protected int f113423d;

    /* renamed from: e, reason: collision with root package name */
    protected int f113424e;

    /* renamed from: f, reason: collision with root package name */
    int f113425f;

    /* renamed from: g, reason: collision with root package name */
    int f113426g;

    /* renamed from: h, reason: collision with root package name */
    int f113427h;

    /* renamed from: i, reason: collision with root package name */
    int f113428i;

    /* renamed from: j, reason: collision with root package name */
    private String f113429j;

    /* renamed from: k, reason: collision with root package name */
    private byte f113430k;

    /* renamed from: l, reason: collision with root package name */
    private Map<String, String> f113431l;

    /* renamed from: m, reason: collision with root package name */
    private Map<String, String> f113432m;

    /* renamed from: n, reason: collision with root package name */
    private long f113433n;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(String str, byte b16, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Byte.valueOf(b16), list);
            return;
        }
        this.f113420a = false;
        this.f113423d = 0;
        this.f113424e = 0;
        this.f113428i = 0;
        this.f113429j = str;
        this.f113430k = b16;
        this.f113421b = list;
        this.f113427h = list.size();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x001d. Please report as an issue. */
    public static a a(String str, byte b16, List<String> list) {
        a aVar = null;
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            com.tencent.halley.common.utils.d.e("halley-cloud-AbsDetectTask", "createDetectTask fail because targets is empty or taskId is empty");
            return null;
        }
        boolean z16 = true;
        if (b16 == 1 || b16 == 2) {
            aVar = new f(str, b16, list);
        } else if (b16 == 3) {
            aVar = new g(str, b16, list);
        } else {
            if (b16 != 4) {
                z16 = false;
                switch (b16) {
                    case 12:
                        aVar = new f(str, b16, list);
                        break;
                    case 13:
                        aVar = new g(str, b16, list);
                        break;
                    case 14:
                        aVar = new d(str, b16, list);
                        break;
                }
                return aVar;
            }
            aVar = new d(str, b16, list);
        }
        aVar.f113420a = z16;
        return aVar;
    }

    protected abstract boolean a(String str);

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f113424e;
    }

    protected abstract void c();

    /* JADX INFO: Access modifiers changed from: protected */
    public final byte[] d() {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (byte[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        Map<String, byte[]> map = this.f113422c;
        if (map == null || !map.containsKey("body") || (bArr = this.f113422c.get("body")) == null || bArr.length == 0) {
            return null;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final byte e() {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Byte) iPatchRedirector.redirect((short) 7, (Object) this)).byteValue();
        }
        Map<String, byte[]> map = this.f113422c;
        if (map == null || !map.containsKey("request_method") || (bArr = this.f113422c.get("request_method")) == null || bArr.length != 1) {
            return (byte) 0;
        }
        return bArr[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int f() {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        Map<String, byte[]> map = this.f113422c;
        if (map != null && map.containsKey("read_timeout") && (bArr = this.f113422c.get("read_timeout")) != null && bArr.length == 1) {
            return bArr[0] * 1000;
        }
        return 30000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if ((com.tencent.halley.common.a.c.g() && c.f113438a != this.f113426g) || com.tencent.halley.common.a.c.h() != this.f113425f) {
            return true;
        }
        return false;
    }

    private static final String a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (String str : map.keySet()) {
            String str2 = map.get(str);
            sb5.append(str);
            sb5.append(",");
            sb5.append(str2);
            sb5.append(";");
        }
        return sb5.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        String str;
        String str2;
        int i3;
        int i16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        HashMap hashMap = new HashMap();
        int i17 = 0;
        try {
        } catch (Throwable th5) {
            th = th5;
        }
        if (com.tencent.halley.common.a.c.g()) {
            byte[] d16 = d();
            if ((d16 == null || d16.length == 0) ? false : true) {
                if (d16.length > (h.a("detect_send_traffic_limit", 1, 2048, 512) << 10)) {
                    com.tencent.halley.common.utils.d.e("halley-cloud-AbsDetectTask", "request body is too large,abandon this request: length:" + d16.length);
                    this.f113428i = this.f113427h;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(d16.length);
                    hashMap.put("D33", sb5.toString());
                    i16 = -503;
                    z16 = false;
                    if (z16) {
                        str2 = "HLDetectEvent";
                        i3 = -503;
                    } else {
                        try {
                            c();
                            int i18 = 0;
                            while (true) {
                                if (i17 >= this.f113427h) {
                                    i17 = i16;
                                    break;
                                }
                                if (!com.tencent.halley.common.a.c.j()) {
                                    i18++;
                                    com.tencent.halley.common.utils.d.e("halley-cloud-AbsDetectTask", "NoNet: abandon one target...noNetNum:".concat(String.valueOf(i18)));
                                    SystemClock.sleep(1000L);
                                } else {
                                    if (g()) {
                                        this.f113428i = this.f113427h - i17;
                                        com.tencent.halley.common.utils.d.e("halley-cloud-AbsDetectTask", "netType changed, abandonNum:" + this.f113428i);
                                        i17 = LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT;
                                        break;
                                    }
                                    if (this.f113433n < SystemClock.elapsedRealtime()) {
                                        this.f113428i = this.f113427h - i17;
                                        com.tencent.halley.common.utils.d.e("halley-cloud-AbsDetectTask", "over due, abandon detect task\uff0c abandonNum:" + this.f113428i);
                                        i17 = -501;
                                        break;
                                    }
                                    if (a(this.f113421b.get(i17))) {
                                        this.f113423d++;
                                    } else {
                                        this.f113428i++;
                                    }
                                    SystemClock.sleep(100L);
                                }
                                i17++;
                            }
                            if (i18 > 0) {
                                com.tencent.halley.common.utils.d.e("halley-cloud-AbsDetectTask", "NoNet: abandon num:".concat(String.valueOf(i18)));
                                this.f113428i += i18;
                                if (i17 >= 0) {
                                    i17 = -505;
                                }
                            }
                            i3 = i17;
                            str2 = "HLDetectEvent";
                        } catch (Throwable th6) {
                            int i19 = i16;
                            th = th6;
                            i17 = i19;
                            try {
                                this.f113428i = this.f113427h - this.f113423d;
                                i17 = -515;
                                str = th.getClass().getSimpleName() + "(" + th.getLocalizedMessage() + ")";
                                str2 = "HLDetectEvent";
                                i3 = -515;
                                a(str2, i3, str, hashMap, false);
                            } catch (Throwable th7) {
                                a("HLDetectEvent", i17, null, hashMap, false);
                                throw th7;
                            }
                        }
                    }
                    str = null;
                    a(str2, i3, str, hashMap, false);
                }
            }
        }
        i16 = 0;
        z16 = true;
        if (z16) {
        }
        str = null;
        a(str2, i3, str, hashMap, false);
    }

    public final void a(String str, int i3, String str2, Map<String, String> map, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), str2, map, Boolean.valueOf(z16));
            return;
        }
        if (!z16 && str.equals("HLDetectEvent")) {
            if (!a(map, i3)) {
                return;
            }
            if (this.f113423d > 0) {
                com.tencent.halley.common.utils.d.b("halley-cloud-AbsDetectTask", "report executeNum:" + this.f113423d);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.f113423d);
                map.put("D36", sb5.toString());
            }
            if (this.f113428i > 0) {
                com.tencent.halley.common.utils.d.b("halley-cloud-AbsDetectTask", "report abandonNum:" + this.f113428i + " and error Code:" + i3);
                StringBuilder sb6 = new StringBuilder();
                sb6.append(this.f113428i);
                map.put("D34", sb6.toString());
            }
        }
        StringBuilder sb7 = new StringBuilder();
        sb7.append((int) this.f113430k);
        map.put(Constants.BASE_IN_HOTFIX, sb7.toString());
        String c16 = com.tencent.halley.common.a.c.c();
        if (!TextUtils.isEmpty(c16)) {
            map.put("D39", c16);
        }
        map.put(Constants.BASE_IN_PLUGIN_ID, this.f113429j);
        if (!TextUtils.isEmpty(a(this.f113431l))) {
            map.put(Constants.BASE_IN_PLUGIN_VERSION, a(this.f113431l));
        }
        if (!TextUtils.isEmpty(a(this.f113432m))) {
            map.put(Constants.BASE_IN_APP_NAME, a(this.f113432m));
        }
        map.put("D5", String.valueOf(i3));
        if (!TextUtils.isEmpty(str2)) {
            map.put("D6", str2);
        }
        StringBuilder sb8 = new StringBuilder();
        sb8.append((int) com.tencent.halley.common.a.c.i());
        map.put("D9", sb8.toString());
        map.put("D40", com.tencent.halley.common.a.e());
        if (!z16) {
            k.a(str, i3 >= 0, map, false);
            return;
        }
        map.put("D38", "1");
        map.put("D8", "client_report_time");
        k.a(str, i3 >= 0, map, true);
    }

    public final void a(Map<String, String> map, int i3, Map<String, String> map2, Map<String, byte[]> map3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, map, Integer.valueOf(i3), map2, map3);
            return;
        }
        this.f113431l = map;
        this.f113432m = map2;
        this.f113422c = map3;
        this.f113433n = SystemClock.elapsedRealtime() + (i3 * 1000);
    }

    private static boolean a(Map<String, String> map, int i3) {
        String str;
        int i16;
        if (i3 >= 0) {
            str = "report_detect_succ_denominator_value";
            i16 = 100;
        } else {
            str = "report_detect_fail_denominator_value";
            i16 = 1;
        }
        int a16 = com.tencent.halley.common.a.b.b.a(str, i16);
        map.put("D37", String.valueOf(a16));
        boolean a17 = com.tencent.halley.common.a.b.b.a(a16);
        com.tencent.halley.common.utils.d.b("halley-cloud-AbsDetectTask", "AbsDetectTask report sampling denominator:" + a16 + " canReport:" + a17);
        return a17;
    }
}

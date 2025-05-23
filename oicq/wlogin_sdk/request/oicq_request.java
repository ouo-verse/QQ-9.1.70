package oicq.wlogin_sdk.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.loginsecsdk.ProtocolDet;
import com.tencent.mobileqq.wink.storage.kv.MaskType;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Random;
import java.util.TreeMap;
import oicq.wlogin_sdk.report.event.EventConstant;
import oicq.wlogin_sdk.report.report_t3;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t102;
import oicq.wlogin_sdk.tlv_type.tlv_t103;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t105;
import oicq.wlogin_sdk.tlv_type.tlv_t106;
import oicq.wlogin_sdk.tlv_type.tlv_t108;
import oicq.wlogin_sdk.tlv_type.tlv_t10a;
import oicq.wlogin_sdk.tlv_type.tlv_t10b;
import oicq.wlogin_sdk.tlv_type.tlv_t10c;
import oicq.wlogin_sdk.tlv_type.tlv_t10d;
import oicq.wlogin_sdk.tlv_type.tlv_t10e;
import oicq.wlogin_sdk.tlv_type.tlv_t113;
import oicq.wlogin_sdk.tlv_type.tlv_t114;
import oicq.wlogin_sdk.tlv_type.tlv_t118;
import oicq.wlogin_sdk.tlv_type.tlv_t119;
import oicq.wlogin_sdk.tlv_type.tlv_t11a;
import oicq.wlogin_sdk.tlv_type.tlv_t11c;
import oicq.wlogin_sdk.tlv_type.tlv_t11d;
import oicq.wlogin_sdk.tlv_type.tlv_t11f;
import oicq.wlogin_sdk.tlv_type.tlv_t120;
import oicq.wlogin_sdk.tlv_type.tlv_t121;
import oicq.wlogin_sdk.tlv_type.tlv_t125;
import oicq.wlogin_sdk.tlv_type.tlv_t126;
import oicq.wlogin_sdk.tlv_type.tlv_t130;
import oicq.wlogin_sdk.tlv_type.tlv_t132;
import oicq.wlogin_sdk.tlv_type.tlv_t136;
import oicq.wlogin_sdk.tlv_type.tlv_t138;
import oicq.wlogin_sdk.tlv_type.tlv_t143;
import oicq.wlogin_sdk.tlv_type.tlv_t145;
import oicq.wlogin_sdk.tlv_type.tlv_t146;
import oicq.wlogin_sdk.tlv_type.tlv_t149;
import oicq.wlogin_sdk.tlv_type.tlv_t150;
import oicq.wlogin_sdk.tlv_type.tlv_t161;
import oicq.wlogin_sdk.tlv_type.tlv_t164;
import oicq.wlogin_sdk.tlv_type.tlv_t165;
import oicq.wlogin_sdk.tlv_type.tlv_t167;
import oicq.wlogin_sdk.tlv_type.tlv_t169;
import oicq.wlogin_sdk.tlv_type.tlv_t16a;
import oicq.wlogin_sdk.tlv_type.tlv_t16d;
import oicq.wlogin_sdk.tlv_type.tlv_t171;
import oicq.wlogin_sdk.tlv_type.tlv_t172;
import oicq.wlogin_sdk.tlv_type.tlv_t173;
import oicq.wlogin_sdk.tlv_type.tlv_t174;
import oicq.wlogin_sdk.tlv_type.tlv_t178;
import oicq.wlogin_sdk.tlv_type.tlv_t179;
import oicq.wlogin_sdk.tlv_type.tlv_t17d;
import oicq.wlogin_sdk.tlv_type.tlv_t17e;
import oicq.wlogin_sdk.tlv_type.tlv_t17f;
import oicq.wlogin_sdk.tlv_type.tlv_t182;
import oicq.wlogin_sdk.tlv_type.tlv_t183;
import oicq.wlogin_sdk.tlv_type.tlv_t186;
import oicq.wlogin_sdk.tlv_type.tlv_t192;
import oicq.wlogin_sdk.tlv_type.tlv_t196;
import oicq.wlogin_sdk.tlv_type.tlv_t199;
import oicq.wlogin_sdk.tlv_type.tlv_t200;
import oicq.wlogin_sdk.tlv_type.tlv_t204;
import oicq.wlogin_sdk.tlv_type.tlv_t305;
import oicq.wlogin_sdk.tlv_type.tlv_t322;
import oicq.wlogin_sdk.tlv_type.tlv_t402;
import oicq.wlogin_sdk.tlv_type.tlv_t403;
import oicq.wlogin_sdk.tlv_type.tlv_t508;
import oicq.wlogin_sdk.tlv_type.tlv_t52b;
import oicq.wlogin_sdk.tlv_type.tlv_t543;
import oicq.wlogin_sdk.tlv_type.tlv_t546;
import oicq.wlogin_sdk.tools.EcdhCrypt;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.InternationMsg;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.cryptor;
import oicq.wlogin_sdk.tools.util;
import org.java_websocket.WebSocketImpl;

/* compiled from: P */
/* loaded from: classes28.dex */
public class oicq_request {

    /* renamed from: s, reason: collision with root package name */
    public static int f422902s = 0;

    /* renamed from: t, reason: collision with root package name */
    public static String f422903t = "";

    /* renamed from: u, reason: collision with root package name */
    public static String f422904u = "";

    /* renamed from: a, reason: collision with root package name */
    public Context f422905a;

    /* renamed from: m, reason: collision with root package name */
    public u f422917m;

    /* renamed from: b, reason: collision with root package name */
    public int f422906b = 8192;

    /* renamed from: c, reason: collision with root package name */
    public int f422907c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f422908d = 0;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f422909e = new byte[8192];

    /* renamed from: f, reason: collision with root package name */
    public int f422910f = 0;

    /* renamed from: g, reason: collision with root package name */
    public InetSocketAddress f422911g = null;

    /* renamed from: h, reason: collision with root package name */
    public int f422912h = 0;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f422913i = new byte[6144];

    /* renamed from: j, reason: collision with root package name */
    public int f422914j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f422915k = 0;

    /* renamed from: l, reason: collision with root package name */
    public String f422916l = "";

    /* renamed from: n, reason: collision with root package name */
    public EncryptionMethod f422918n = EncryptionMethod.EM_ECDH;

    /* renamed from: o, reason: collision with root package name */
    public boolean f422919o = false;

    /* renamed from: p, reason: collision with root package name */
    public byte[] f422920p = new byte[0];

    /* renamed from: q, reason: collision with root package name */
    public byte[] f422921q = new byte[0];

    /* renamed from: r, reason: collision with root package name */
    public int f422922r = 0;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public enum EncryptionMethod {
        EM_ECDH,
        EM_ST
    }

    public int a(int i3) {
        u.b(this.f422917m.f422959f)._last_flowid = i3;
        return i3;
    }

    public int b(boolean z16) {
        return WebSocketImpl.DEFAULT_WSS_PORT;
    }

    public int c() {
        return u.b(this.f422917m.f422959f)._last_flowid;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x006b, code lost:
    
        if (r0 < 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x007a, code lost:
    
        oicq.wlogin_sdk.tools.util.LOGI("use kc decrypt_body failed", "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0078, code lost:
    
        if (r0 < 0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int d() {
        int i3;
        String str;
        String str2;
        int i16 = this.f422907c;
        if (i16 <= 17) {
            return -1009;
        }
        this.f422908d = (i16 - 15) - 2;
        int buf_to_int16 = util.buf_to_int16(this.f422909e, 13);
        util.LOGI("enrypt method " + this.f422918n + " rsp flag " + buf_to_int16, "");
        EncryptionMethod encryptionMethod = this.f422918n;
        EncryptionMethod encryptionMethod2 = EncryptionMethod.EM_ECDH;
        if (encryptionMethod == encryptionMethod2 && buf_to_int16 == 0) {
            u uVar = this.f422917m;
            if (uVar.f422964k == 0) {
                i3 = a(this.f422909e, 16, this.f422908d, uVar.f422966m);
                if (i3 < 0) {
                    util.LOGI("use ecdh decrypt_body failed", "");
                    i3 = a(this.f422909e, 16, this.f422908d, this.f422917m.f422955b);
                }
            } else {
                i3 = a(this.f422909e, 16, this.f422908d, uVar.f422955b);
            }
        } else {
            int i17 = 0;
            if (encryptionMethod == EncryptionMethod.EM_ST && 3 == buf_to_int16) {
                i3 = a(this.f422909e, 16, this.f422908d, this.f422921q);
                if (i3 < 0) {
                    u.f422936m0.attr_api(2494911);
                    async_context b16 = u.b(this.f422917m.f422959f);
                    if (b16 != null) {
                        u uVar2 = this.f422917m;
                        long j3 = uVar2.f422957d;
                        long j16 = b16._sappid;
                        synchronized (uVar2) {
                            c cVar = u.f422934k0;
                            synchronized (cVar) {
                                util.LOGI("start clearNewST " + j16, "" + j3);
                                if (cVar.f422875a != null) {
                                    synchronized (c.f422871e) {
                                        TreeMap<Long, WloginAllSigInfo> a16 = c.a(cVar.f422875a, "tk_file", j3);
                                        if (a16 != null) {
                                            WloginAllSigInfo wloginAllSigInfo = a16.get(Long.valueOf(j3));
                                            if (wloginAllSigInfo != null) {
                                                util.LOGI("clearNewST clear newST in file", "" + j3);
                                                wloginAllSigInfo.putNewST(j16, new byte[0], new byte[0]);
                                                int a17 = cVar.a(a16, "tk_file");
                                                cVar.f422876b = a16;
                                                i17 = a17;
                                            }
                                        }
                                    }
                                }
                                util.LOGI("end clearNewST ret " + i17, "" + j3);
                            }
                        }
                    }
                    util.LOGI("use session key decrypt_body failed", "");
                    i3 = -1025;
                }
            } else {
                if (encryptionMethod == encryptionMethod2 && true == this.f422919o && 4 == buf_to_int16) {
                    byte[] decrypt = cryptor.decrypt(this.f422909e, 16, this.f422908d, this.f422917m.f422966m);
                    if (decrypt == null) {
                        str = "" + this.f422917m.f422957d;
                        str2 = "decrypted outer body failed";
                    } else {
                        int buf_to_int162 = util.buf_to_int16(decrypt, 0);
                        if (buf_to_int162 > decrypt.length - 2) {
                            util.LOGI("peer public key len wrong " + buf_to_int162, "" + this.f422917m.f422957d);
                            return -1009;
                        }
                        byte[] bArr = new byte[buf_to_int162];
                        System.arraycopy(decrypt, 2, bArr, 0, buf_to_int162);
                        byte[] calShareKeyMd5ByPeerPublicKey = new EcdhCrypt(this.f422905a).calShareKeyMd5ByPeerPublicKey(bArr);
                        if (calShareKeyMd5ByPeerPublicKey == null || calShareKeyMd5ByPeerPublicKey.length == 0) {
                            return -1002;
                        }
                        byte[] decrypt2 = cryptor.decrypt(decrypt, buf_to_int162 + 2, (decrypt.length - 2) - buf_to_int162, calShareKeyMd5ByPeerPublicKey);
                        if (decrypt2 == null) {
                            u.f422936m0.attr_api(2461266);
                            str = "" + this.f422917m.f422957d;
                            str2 = "use share key md5 decrypt failed";
                        } else {
                            byte[] bArr2 = this.f422909e;
                            if (bArr2.length < decrypt2.length + 17) {
                                int length = decrypt2.length + 17;
                                this.f422906b = length;
                                byte[] bArr3 = new byte[length];
                                System.arraycopy(bArr2, 0, bArr3, 0, 16);
                                this.f422909e = bArr3;
                            }
                            System.arraycopy(decrypt2, 0, this.f422909e, 16, decrypt2.length);
                            this.f422907c = 17 + decrypt2.length;
                            i3 = 0;
                        }
                    }
                    util.LOGI(str2, str);
                    return -1002;
                }
                util.LOGI("unknown encryption method " + this.f422918n, "");
                i3 = -1024;
            }
        }
        if (i3 < 0) {
            return i3;
        }
        return c(this.f422909e, 16, this.f422908d);
    }

    public Socket e() {
        return this.f422917m.f422970q;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x0693, code lost:
    
        if (r5 == false) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x074d, code lost:
    
        if (r15 < 6) goto L226;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0751, code lost:
    
        if ((-1026) == r8) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0753, code lost:
    
        r8 = -1000;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0757, code lost:
    
        if (r8 != 0) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0759, code lost:
    
        c(r25.f422913i, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x075e, code lost:
    
        if (r8 != 0) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0762, code lost:
    
        if (r25.f422914j == r1) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0764, code lost:
    
        r1 = new oicq.wlogin_sdk.report.report_t3();
        r1._cmd = r25.f422914j;
        r1._sub = r25.f422915k;
        r1._rst2 = r8;
        r1._used = (int) (java.lang.System.currentTimeMillis() - r3);
        r1._try = r15;
        r3 = oicq.wlogin_sdk.request.oicq_request.f422904u;
        r1._host = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0781, code lost:
    
        if (r3 != null) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0783, code lost:
    
        r1._host = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0785, code lost:
    
        r3 = r25.f422911g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0787, code lost:
    
        if (r3 != null) goto L238;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0789, code lost:
    
        r1._ip = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0796, code lost:
    
        r1._port = r25.f422912h;
        r1._conn = r2;
        r1._net = oicq.wlogin_sdk.request.u.F;
        r1._str = "";
        r1._slen = r12.length;
        r1._rlen = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x07a7, code lost:
    
        if (r0 == false) goto L244;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x07a9, code lost:
    
        if (r17 == false) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x07ab, code lost:
    
        r1._wap = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x07b4, code lost:
    
        oicq.wlogin_sdk.request.u.f422936m0.add_t3(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x07af, code lost:
    
        r2 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x07b2, code lost:
    
        r1._wap = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x07b1, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x078c, code lost:
    
        r1._ip = r3.getAddress().getHostAddress();
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x07b9, code lost:
    
        oicq.wlogin_sdk.tools.util.LOGI(getClass().getName() + ":snd_rcv_req_tcp ret=" + r8, "" + r25.f422917m.f422957d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x07ec, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0756, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0634, code lost:
    
        if (r5 == false) goto L173;
     */
    /* JADX WARN: Removed duplicated region for block: B:219:0x021e A[Catch: Exception -> 0x0323, ConnectException -> 0x0328, TryCatch #15 {ConnectException -> 0x0328, blocks: (B:215:0x01d6, B:219:0x021e, B:220:0x0224, B:222:0x0239, B:224:0x0259, B:249:0x027d, B:227:0x02a3, B:229:0x02c9, B:235:0x02f5, B:232:0x0312, B:210:0x0196), top: B:214:0x01d6 }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x027a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x05eb A[Catch: all -> 0x06ae, TryCatch #11 {all -> 0x06ae, blocks: (B:56:0x05ca, B:59:0x05dc, B:61:0x05e7, B:65:0x05eb, B:67:0x0604, B:69:0x0696, B:87:0x060a), top: B:55:0x05ca }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x06d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x060a A[Catch: all -> 0x06ae, TRY_LEAVE, TryCatch #11 {all -> 0x06ae, blocks: (B:56:0x05ca, B:59:0x05dc, B:61:0x05e7, B:65:0x05eb, B:67:0x0604, B:69:0x0696, B:87:0x060a), top: B:55:0x05ca }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int f() {
        int i3;
        int i16;
        int i17;
        boolean z16;
        String str;
        String str2;
        String str3;
        int i18;
        long j3;
        boolean z17;
        String str4;
        int i19;
        URL url;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        String str5;
        String str6;
        String str7;
        String str8;
        int i26;
        int i27;
        int i28;
        int i29;
        String str9;
        String str10;
        Socket socket;
        String str11;
        StringBuilder sb5;
        String str12;
        String str13 = "tcp connect to ";
        util.LOGI(getClass().getName() + ":snd_rcv_req_tcp ...", "" + this.f422917m.f422957d);
        byte[] b16 = b();
        Socket e16 = e();
        long j16 = 0L;
        String str14 = "";
        String str15 = str14;
        boolean z18 = false;
        int i36 = 0;
        int i37 = 0;
        int i38 = 0;
        boolean z19 = false;
        int i39 = 0;
        while (true) {
            if (i37 < 10) {
                if (i37 != 0) {
                    util.chg_retry_type(u.f422949w);
                }
                boolean is_wap_retry = util.is_wap_retry(u.f422949w);
                this.f422911g = null;
                if (i37 != 0 && this.f422914j != 2066) {
                    z16 = is_wap_retry;
                    str = str14;
                    str3 = str13;
                    str2 = str15;
                    i18 = i36;
                    a(i36, j16, i38, i37, z16, z19);
                } else {
                    z16 = is_wap_retry;
                    str = str14;
                    str2 = str15;
                    str3 = str13;
                    i18 = i36;
                }
                long currentTimeMillis = System.currentTimeMillis();
                boolean z26 = z16;
                if (z26) {
                    util.LOGI("try http connect " + i37 + " ...", "" + this.f422917m.f422957d);
                    String a16 = a(i37, z26);
                    try {
                        z19 = util.is_wap_proxy_retry(u.f422949w);
                        if (z19) {
                            str4 = util.get_proxy_ip();
                            i19 = util.get_proxy_port();
                            if (str4 != null && str4.length() > 0 && i19 != -1) {
                                j3 = currentTimeMillis;
                                z17 = z19;
                            } else {
                                try {
                                    String str16 = "proxy_ip=" + str4 + ",proxy_port=" + i19 + ",set is_wap_proxy_retry=false";
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append("");
                                    j3 = currentTimeMillis;
                                    try {
                                        sb6.append(this.f422917m.f422957d);
                                        util.LOGI(str16, sb6.toString());
                                        z17 = false;
                                    } catch (ConnectException e17) {
                                        e = e17;
                                        str14 = str;
                                        z19 = false;
                                        util.LOGI("http request connect exception" + e.toString(), "");
                                        i37++;
                                        z18 = z26;
                                        str13 = str3;
                                        str15 = str2;
                                        j16 = j3;
                                        i36 = -1026;
                                    } catch (Exception e18) {
                                        e = e18;
                                        i36 = i18;
                                        str14 = str;
                                        z19 = false;
                                        z17 = z19;
                                        util.LOGI("http request exception" + e.toString(), "");
                                        if (-1026 == i36) {
                                        }
                                        z19 = z17;
                                        i36 = -1000;
                                        i37++;
                                        z18 = z26;
                                        str13 = str3;
                                        str15 = str2;
                                        j16 = j3;
                                    }
                                } catch (ConnectException e19) {
                                    e = e19;
                                    j3 = currentTimeMillis;
                                } catch (Exception e26) {
                                    e = e26;
                                    j3 = currentTimeMillis;
                                }
                            }
                        } else {
                            j3 = currentTimeMillis;
                            z17 = z19;
                            str4 = null;
                            i19 = -1;
                        }
                    } catch (ConnectException e27) {
                        e = e27;
                        j3 = currentTimeMillis;
                    } catch (Exception e28) {
                        e = e28;
                        j3 = currentTimeMillis;
                    }
                    if (z17) {
                        try {
                            url = new URL("http://" + str4 + ":" + i19 + util.HTTPS_WLOGIN_PATH);
                            str14 = str;
                        } catch (ConnectException e29) {
                            e = e29;
                            z19 = z17;
                            str14 = str;
                            util.LOGI("http request connect exception" + e.toString(), "");
                            i37++;
                            z18 = z26;
                            str13 = str3;
                            str15 = str2;
                            j16 = j3;
                            i36 = -1026;
                        } catch (Exception e36) {
                            e = e36;
                            z19 = z17;
                            i36 = i18;
                            str14 = str;
                            z17 = z19;
                            util.LOGI("http request exception" + e.toString(), "");
                            if (-1026 == i36) {
                            }
                            z19 = z17;
                            i36 = -1000;
                            i37++;
                            z18 = z26;
                            str13 = str3;
                            str15 = str2;
                            j16 = j3;
                        }
                        try {
                            try {
                                util.LOGI("try http proxy=" + z17 + " connect to " + url + " host " + a16, "" + this.f422917m.f422957d);
                                httpURLConnection = (HttpURLConnection) url.openConnection();
                                httpURLConnection.setRequestMethod("POST");
                                if (z17) {
                                    httpURLConnection.setRequestProperty("X-Online-Host", a16);
                                }
                                httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                                httpURLConnection.setRequestProperty(HttpHeader.RSP.CONTENT_DISPOSITION, "attachment; filename=micromsgresp.dat");
                                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(b16.length));
                                httpURLConnection.setConnectTimeout(this.f422917m.f422963j);
                                httpURLConnection.setReadTimeout(this.f422917m.f422963j);
                                httpURLConnection.setDoOutput(true);
                                httpURLConnection.setDoInput(true);
                                util.LOGI("http request connect ...", "" + this.f422917m.f422957d);
                            } catch (Exception e37) {
                                e = e37;
                                z19 = z17;
                                i36 = i18;
                            }
                            if (h.a(httpURLConnection, this.f422917m.f422963j)) {
                                util.LOGI("http request connect failed", "" + this.f422917m.f422957d);
                                if (-1026 == i18) {
                                    z19 = z17;
                                    i36 = i18;
                                    i37++;
                                    z18 = z26;
                                    str13 = str3;
                                    str15 = str2;
                                    j16 = j3;
                                }
                                z19 = z17;
                                i36 = -1000;
                                i37++;
                                z18 = z26;
                                str13 = str3;
                                str15 = str2;
                                j16 = j3;
                            } else {
                                util.LOGI("http request write ...", "" + this.f422917m.f422957d);
                                OutputStream outputStream = httpURLConnection.getOutputStream();
                                outputStream.write(b16, 0, b16.length);
                                outputStream.flush();
                                int responseCode = httpURLConnection.getResponseCode();
                                try {
                                    util.LOGI("http request response code=" + responseCode, "" + this.f422917m.f422957d);
                                } catch (Exception e38) {
                                    e = e38;
                                    i36 = responseCode;
                                    z19 = z17;
                                    z17 = z19;
                                    util.LOGI("http request exception" + e.toString(), "");
                                    if (-1026 == i36) {
                                        z19 = z17;
                                        i37++;
                                        z18 = z26;
                                        str13 = str3;
                                        str15 = str2;
                                        j16 = j3;
                                    }
                                    z19 = z17;
                                    i36 = -1000;
                                    i37++;
                                    z18 = z26;
                                    str13 = str3;
                                    str15 = str2;
                                    j16 = j3;
                                }
                                if (200 != responseCode) {
                                    util.LOGI("http request error ret:" + responseCode, "");
                                    i37++;
                                    z19 = z17;
                                    z18 = z26;
                                    i36 = -1000;
                                    str13 = str3;
                                    str15 = str2;
                                    j16 = j3;
                                } else {
                                    inputStream = httpURLConnection.getInputStream();
                                    z19 = z17;
                                    str5 = str3;
                                    str6 = str2;
                                    try {
                                        StringBuilder sb7 = new StringBuilder();
                                        sb7.append("");
                                        str7 = str14;
                                        str8 = str6;
                                        try {
                                            sb7.append(this.f422917m.f422957d);
                                            util.LOGI("recv data from server ...", sb7.toString());
                                            i26 = 0;
                                            i27 = 0;
                                            while (true) {
                                                i28 = 16;
                                                if (i26 < 16 || (i27 = inputStream.read(this.f422913i, i26, 16 - i26)) < 0) {
                                                    break;
                                                }
                                                i26 += i27;
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        str7 = str14;
                                        str8 = str6;
                                    }
                                    if (i27 >= 0) {
                                        util.LOGI("recv from server with ret:" + i27, "");
                                        i37++;
                                        if (!z26) {
                                            e16.close();
                                            this.f422911g = null;
                                            try {
                                                a((Socket) null);
                                            } catch (Throwable th7) {
                                                th = th7;
                                                e16 = null;
                                                util.LOGI("recv from server throw:" + Log.getStackTraceString(th), "");
                                                i37++;
                                                if (!z26) {
                                                }
                                                z18 = z26;
                                                str14 = str7;
                                                str15 = str8;
                                                i36 = -1000;
                                                j16 = j3;
                                                str13 = str5;
                                            }
                                            e16 = null;
                                        }
                                    } else {
                                        int b17 = b(this.f422913i);
                                        if (b17 <= 16) {
                                            try {
                                                util.LOGI("recv from server with all_len:" + b17 + " head_len:15", "");
                                                i37++;
                                            } catch (Throwable th8) {
                                                th = th8;
                                                i39 = b17;
                                                util.LOGI("recv from server throw:" + Log.getStackTraceString(th), "");
                                                i37++;
                                                if (!z26) {
                                                    try {
                                                        if (e16.isConnected()) {
                                                            e16.close();
                                                        }
                                                    } catch (Exception unused) {
                                                    }
                                                    this.f422911g = null;
                                                    a((Socket) null);
                                                    e16 = null;
                                                }
                                                z18 = z26;
                                                str14 = str7;
                                                str15 = str8;
                                                i36 = -1000;
                                                j16 = j3;
                                                str13 = str5;
                                            }
                                        } else if (b17 >= this.f422913i.length) {
                                            util.LOGI("recv from server with all_len:" + b17 + " buf_len:" + this.f422913i.length, "");
                                            i37++;
                                            if (!z26) {
                                                e16.close();
                                                i39 = b17;
                                                this.f422911g = null;
                                                a((Socket) null);
                                                e16 = null;
                                            }
                                            i39 = b17;
                                        } else {
                                            int i46 = b17 - 16;
                                            while (true) {
                                                if (i46 > 0) {
                                                    i27 = inputStream.read(this.f422913i, i28, i46);
                                                    i29 = -1;
                                                    if (i27 == -1) {
                                                        break;
                                                    }
                                                    i28 += i27;
                                                    i46 -= i27;
                                                } else {
                                                    i29 = -1;
                                                    break;
                                                }
                                            }
                                            if (i27 == i29) {
                                                util.LOGI("recv from server in loop with ret:" + i27, "");
                                                i37++;
                                            } else {
                                                i36 = i27;
                                                z18 = z26;
                                                i16 = i38;
                                                j16 = j3;
                                                i17 = b17;
                                                i3 = 2066;
                                                break;
                                            }
                                        }
                                    }
                                    z18 = z26;
                                    str14 = str7;
                                    str15 = str8;
                                    i36 = -1000;
                                    j16 = j3;
                                    str13 = str5;
                                }
                            }
                        } catch (ConnectException e39) {
                            e = e39;
                            z19 = z17;
                            util.LOGI("http request connect exception" + e.toString(), "");
                            i37++;
                            z18 = z26;
                            str13 = str3;
                            str15 = str2;
                            j16 = j3;
                            i36 = -1026;
                        }
                    } else {
                        InetSocketAddress a17 = a.a(a16, 0, this.f422917m.f422963j);
                        this.f422911g = a17;
                        if (a17 != null) {
                            str14 = a17.getAddress().getHostAddress();
                            if (!str.equals(str14)) {
                                try {
                                    this.f422911g = null;
                                    str = str14;
                                } catch (Exception e46) {
                                    e = e46;
                                    i36 = i18;
                                    util.LOGI("http request exception" + e.toString(), "");
                                    if (-1026 == i36) {
                                    }
                                    z19 = z17;
                                    i36 = -1000;
                                    i37++;
                                    z18 = z26;
                                    str13 = str3;
                                    str15 = str2;
                                    j16 = j3;
                                }
                            } else {
                                throw new Exception("repeated failed http ip " + str);
                                break;
                            }
                        } else {
                            str14 = a16;
                        }
                        url = new URL("https://" + str14 + util.HTTPS_WLOGIN_PATH);
                        str14 = str;
                        util.LOGI("try http proxy=" + z17 + " connect to " + url + " host " + a16, "" + this.f422917m.f422957d);
                        httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        if (z17) {
                        }
                        httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
                        httpURLConnection.setRequestProperty(HttpHeader.RSP.CONTENT_DISPOSITION, "attachment; filename=micromsgresp.dat");
                        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(b16.length));
                        httpURLConnection.setConnectTimeout(this.f422917m.f422963j);
                        httpURLConnection.setReadTimeout(this.f422917m.f422963j);
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        util.LOGI("http request connect ...", "" + this.f422917m.f422957d);
                        if (h.a(httpURLConnection, this.f422917m.f422963j)) {
                        }
                    }
                } else {
                    j3 = currentTimeMillis;
                    util.LOGI("try bin connect " + i37 + " ...", "" + this.f422917m.f422957d);
                    if (e16 == null) {
                        if (this.f422911g != null) {
                            str12 = "";
                        } else {
                            str12 = a(i37, z26);
                            util.LOGI("DNS for " + str12 + " request ...", "" + this.f422917m.f422957d);
                            try {
                                int b18 = b(z26);
                                this.f422912h = b18;
                                this.f422911g = a.a(str12, b18, this.f422917m.f422963j);
                            } catch (Exception unused2) {
                            }
                        }
                        InetSocketAddress inetSocketAddress = this.f422911g;
                        i36 = -1007;
                        if (inetSocketAddress != null && inetSocketAddress.getAddress() == null) {
                            if (this.f422911g.getAddress() == null) {
                                util.LOGI("_server_ip get address failed", "" + this.f422917m.f422957d);
                            }
                            i37++;
                            this.f422911g = null;
                            a((Socket) null);
                            z18 = z26;
                            str14 = str;
                            str13 = str3;
                            str15 = str2;
                            j16 = j3;
                            e16 = null;
                            i38 = 1;
                        } else {
                            InetSocketAddress inetSocketAddress2 = this.f422911g;
                            if (inetSocketAddress2 == null) {
                                if (inetSocketAddress2 == null) {
                                    util.LOGI("DNS for " + str12 + " request failed", "" + this.f422917m.f422957d);
                                    str5 = str3;
                                    str15 = str2;
                                } else {
                                    StringBuilder sb8 = new StringBuilder();
                                    sb8.append("repeated failed bin ip ");
                                    String str17 = str2;
                                    sb8.append(str17);
                                    util.LOGI(sb8.toString(), "" + this.f422917m.f422957d);
                                    str15 = str17;
                                    if (-1026 != i18) {
                                        str5 = str3;
                                        i38 = 1;
                                        i36 = -1000;
                                        i37++;
                                        this.f422911g = null;
                                        a((Socket) null);
                                        str13 = str5;
                                        z18 = z26;
                                        str14 = str;
                                        j16 = j3;
                                        e16 = null;
                                    } else {
                                        i36 = i18;
                                        str5 = str3;
                                    }
                                }
                                i38 = 1;
                                i37++;
                                this.f422911g = null;
                                a((Socket) null);
                                str13 = str5;
                                z18 = z26;
                                str14 = str;
                                j16 = j3;
                                e16 = null;
                            } else {
                                str9 = inetSocketAddress2.getAddress().getHostAddress();
                                util.LOGI("DNS for " + str12 + "(" + this.f422911g.toString() + ") request OK", "" + this.f422917m.f422957d);
                                i38 = 1;
                            }
                        }
                    } else {
                        str9 = str2;
                    }
                    if (e16 == null) {
                        try {
                            StringBuilder sb9 = new StringBuilder();
                            str5 = str3;
                            try {
                                sb9.append(str5);
                                sb9.append(this.f422911g);
                                sb9.append(" request ...");
                                util.LOGI(sb9.toString(), "" + this.f422917m.f422957d);
                                socket = new Socket();
                                a(socket);
                                socket.connect(this.f422911g, this.f422917m.f422963j);
                                socket.setSoTimeout(this.f422917m.f422963j);
                                socket.setReceiveBufferSize(this.f422913i.length);
                                str11 = str5 + this.f422911g + " OK";
                                sb5 = new StringBuilder();
                                sb5.append("");
                                str10 = str9;
                            } catch (ConnectException e47) {
                                e = e47;
                                str10 = str9;
                            } catch (Throwable th9) {
                                th = th9;
                                str10 = str9;
                            }
                        } catch (ConnectException e48) {
                            e = e48;
                            str10 = str9;
                            str5 = str3;
                        } catch (Throwable th10) {
                            th = th10;
                            str10 = str9;
                            str5 = str3;
                        }
                        try {
                            sb5.append(this.f422917m.f422957d);
                            util.LOGI(str11, sb5.toString());
                            e16 = socket;
                        } catch (ConnectException e49) {
                            e = e49;
                            util.LOGI("tcp request connect exception" + e.toString(), "");
                            i37++;
                            this.f422911g = null;
                            a((Socket) null);
                            e16 = null;
                            str13 = str5;
                            z18 = z26;
                            str15 = str10;
                            str14 = str;
                            j16 = j3;
                            i36 = -1026;
                        } catch (Throwable th11) {
                            th = th11;
                            util.LOGI("tcp request throw" + Log.getStackTraceString(th), "");
                            str15 = str10;
                            if (-1026 == i18) {
                                i36 = i18;
                                i37++;
                                this.f422911g = null;
                                a((Socket) null);
                                str13 = str5;
                                z18 = z26;
                                str14 = str;
                                j16 = j3;
                                e16 = null;
                            }
                            i36 = -1000;
                            i37++;
                            this.f422911g = null;
                            a((Socket) null);
                            str13 = str5;
                            z18 = z26;
                            str14 = str;
                            j16 = j3;
                            e16 = null;
                        }
                    } else {
                        str10 = str9;
                        str5 = str3;
                    }
                    util.LOGI("tcp request write ...", "" + this.f422917m.f422957d);
                    OutputStream outputStream2 = e16.getOutputStream();
                    outputStream2.write(b16, 0, b16.length);
                    outputStream2.flush();
                    inputStream = e16.getInputStream();
                    str6 = str10;
                    str14 = str;
                    StringBuilder sb72 = new StringBuilder();
                    sb72.append("");
                    str7 = str14;
                    str8 = str6;
                    sb72.append(this.f422917m.f422957d);
                    util.LOGI("recv data from server ...", sb72.toString());
                    i26 = 0;
                    i27 = 0;
                    while (true) {
                        i28 = 16;
                        if (i26 < 16) {
                            break;
                            break;
                        }
                        i26 += i27;
                    }
                    if (i27 >= 0) {
                    }
                    z18 = z26;
                    str14 = str7;
                    str15 = str8;
                    i36 = -1000;
                    j16 = j3;
                    str13 = str5;
                }
            } else {
                i3 = 2066;
                i16 = i38;
                i17 = i39;
                break;
            }
        }
    }

    public int a(byte[] bArr, int i3, int i16, byte[] bArr2) {
        byte[] decrypt = cryptor.decrypt(bArr, i3, i16, bArr2);
        if (decrypt == null) {
            return -1002;
        }
        this.f422908d = decrypt.length;
        if (decrypt.length + 15 + 2 > this.f422906b) {
            int length = decrypt.length + 15 + 2;
            this.f422906b = length;
            byte[] bArr3 = new byte[length];
            System.arraycopy(this.f422909e, 0, bArr3, 0, this.f422907c);
            this.f422909e = bArr3;
        }
        System.arraycopy(decrypt, 0, this.f422909e, i3, decrypt.length);
        this.f422907c = decrypt.length + 17;
        return 0;
    }

    public int b(byte[] bArr) {
        return util.buf_to_int16(bArr, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:468:0x06e1, code lost:
    
        if (r0.get_tlv(r124, r12, (r123.f422907c - r12) - 1) >= 0) goto L191;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0628  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0761  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0bc6  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0bf8  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0c1d A[LOOP:0: B:277:0x0c1a->B:279:0x0c1d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0c34 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0c95  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0cc5  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0d8f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x14e5  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0d99  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0dc1 A[LOOP:1: B:303:0x0dbf->B:304:0x0dc1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0dd1  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0ddf  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0df4  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0e02  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0e11  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0e1f  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0e2e  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0e3d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x151f  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0e4f  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0e6d  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0e89  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0ea9  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0ec2  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0ef2  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0f18  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x1555  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x10e6  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x110f  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x11b8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:422:0x10f3  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x0efb  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x0ecb  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x0eb0  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0e95  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x0e5e  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x0dae  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x0d78  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x15a3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x157b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x1524  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x14fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int c(byte[] bArr, int i3, int i16) {
        int i17;
        int b16;
        int i18;
        String str;
        int i19;
        long j3;
        tlv_t119 tlv_t119Var;
        int i26;
        async_context async_contextVar;
        byte[] bArr2;
        int i27;
        int i28;
        int i29;
        int i36;
        tlv_t403 tlv_t403Var;
        tlv_t108 tlv_t108Var;
        byte[] bArr3;
        tlv_t10b tlv_t10bVar;
        byte[] bArr4;
        tlv_t11c tlv_t11cVar;
        byte[] bArr5;
        tlv_t120 tlv_t120Var;
        byte[] bArr6;
        tlv_t121 tlv_t121Var;
        byte[] bArr7;
        tlv_t125 tlv_t125Var;
        byte[] bArr8;
        tlv_t186 tlv_t186Var;
        byte[] bArr9;
        byte[] bArr10;
        tlv_t10e tlv_t10eVar;
        async_context async_contextVar2;
        tlv_t11a tlv_t11aVar;
        tlv_t543 tlv_t543Var;
        tlv_t118 tlv_t118Var;
        tlv_t543 tlv_t543Var2;
        tlv_t11a tlv_t11aVar2;
        int i37;
        int i38;
        int i39;
        int i46;
        tlv_t10d tlv_t10dVar;
        tlv_t10a tlv_t10aVar;
        tlv_t114 tlv_t114Var;
        byte[] bArr11;
        tlv_t403 tlv_t403Var2;
        byte[] bArr12;
        byte[] bArr13;
        long j16;
        int i47;
        int i48;
        tlv_t199 tlv_t199Var;
        byte[] bArr14;
        tlv_t200 tlv_t200Var;
        tlv_t tlv_tVar;
        String str2;
        tlv_t tlv_tVar2;
        tlv_t tlv_tVar3;
        tlv_t tlv_tVar4;
        long j17;
        int i49;
        int i56;
        String str3;
        StringBuilder sb5;
        long j18;
        int i57;
        byte[] bArr15;
        String str4;
        byte[] bArr16;
        tlv_t11a tlv_t11aVar3;
        int i58;
        int i59;
        int i65;
        int i66;
        ErrMsg errMsg;
        int i67;
        int i68;
        int i69;
        int i75;
        int i76;
        char c16;
        int i77;
        int i78;
        if (i16 < 5) {
            return -1009;
        }
        tlv_t104 tlv_t104Var = new tlv_t104();
        tlv_t105 tlv_t105Var = new tlv_t105();
        tlv_t113 tlv_t113Var = new tlv_t113();
        tlv_t119 tlv_t119Var2 = new tlv_t119();
        tlv_t10d tlv_t10dVar2 = new tlv_t10d();
        tlv_t10e tlv_t10eVar2 = new tlv_t10e();
        tlv_t10a tlv_t10aVar2 = new tlv_t10a();
        tlv_t114 tlv_t114Var2 = new tlv_t114();
        tlv_t103 tlv_t103Var = new tlv_t103();
        tlv_t11a tlv_t11aVar4 = new tlv_t11a();
        tlv_t102 tlv_t102Var = new tlv_t102();
        tlv_t10b tlv_t10bVar2 = new tlv_t10b();
        tlv_t11c tlv_t11cVar2 = new tlv_t11c();
        tlv_t11d tlv_t11dVar = new tlv_t11d();
        tlv_t120 tlv_t120Var2 = new tlv_t120();
        tlv_t121 tlv_t121Var2 = new tlv_t121();
        tlv_t130 tlv_t130Var = new tlv_t130();
        tlv_t108 tlv_t108Var2 = new tlv_t108();
        tlv_t106 tlv_t106Var = new tlv_t106();
        tlv_t10c tlv_t10cVar = new tlv_t10c();
        tlv_t125 tlv_t125Var2 = new tlv_t125();
        tlv_t11f tlv_t11fVar = new tlv_t11f();
        tlv_t138 tlv_t138Var = new tlv_t138();
        tlv_t132 tlv_t132Var = new tlv_t132();
        tlv_t149 tlv_t149Var = new tlv_t149();
        tlv_t150 tlv_t150Var = new tlv_t150();
        tlv_t143 tlv_t143Var = new tlv_t143();
        tlv_t305 tlv_t305Var = new tlv_t305();
        tlv_t164 tlv_t164Var = new tlv_t164();
        tlv_t165 tlv_t165Var = new tlv_t165();
        tlv_t167 tlv_t167Var = new tlv_t167();
        tlv_t16a tlv_t16aVar = new tlv_t16a();
        tlv_t169 tlv_t169Var = new tlv_t169();
        tlv_t161 tlv_t161Var = new tlv_t161();
        tlv_t171 tlv_t171Var = new tlv_t171();
        tlv_t tlv_tVar5 = new tlv_t(1298);
        tlv_t16d tlv_t16dVar = new tlv_t16d();
        tlv_t174 tlv_t174Var = new tlv_t174();
        tlv_t178 tlv_t178Var = new tlv_t178();
        tlv_t179 tlv_t179Var = new tlv_t179();
        tlv_t17d tlv_t17dVar = new tlv_t17d();
        tlv_t17e tlv_t17eVar = new tlv_t17e();
        tlv_t126 tlv_t126Var = new tlv_t126();
        tlv_t182 tlv_t182Var = new tlv_t182();
        tlv_t183 tlv_t183Var = new tlv_t183();
        tlv_t186 tlv_t186Var2 = new tlv_t186();
        tlv_t402 tlv_t402Var = new tlv_t402();
        tlv_t403 tlv_t403Var3 = new tlv_t403();
        tlv_t546 tlv_t546Var = new tlv_t546();
        tlv_t136 tlv_t136Var = new tlv_t136();
        tlv_t118 tlv_t118Var2 = new tlv_t118();
        async_context b17 = u.b(this.f422917m.f422959f);
        long j19 = b17._sappid;
        long j26 = b17._appid;
        if (this.f422914j == 2064) {
            switch (this.f422915k) {
                case 2:
                    i17 = 2;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 12:
                case 14:
                case 16:
                case 21:
                default:
                    return -1012;
                case 4:
                    i17 = 3;
                    break;
                case 7:
                    i17 = 6;
                    break;
                case 9:
                case 17:
                case 19:
                case 20:
                case 22:
                    break;
                case 10:
                case 11:
                    i17 = 1;
                    break;
                case 13:
                    i17 = 4;
                    break;
                case 15:
                    i17 = 5;
                    break;
                case 18:
                    i17 = 7;
                    break;
            }
            b16 = b(bArr, i3 + 2);
            int i79 = i3 + 5;
            int i85 = i17;
            u uVar = this.f422917m;
            uVar.f422956c = null;
            if (b16 == 0) {
                if (b16 != 1) {
                    if (b16 == 2) {
                        i65 = i85;
                        str = "";
                        i29 = tlv_t104Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1);
                        if (i29 >= 0) {
                            b17.set_t104(tlv_t104Var);
                            tlv_t192 tlv_t192Var = new tlv_t192();
                            if (tlv_t192Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1) >= 0) {
                                util.LOGI("return 0x192", str);
                                int i86 = tlv_t546Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1);
                                if (i86 >= 0) {
                                    util.LOGI("get tlv546 success len:" + tlv_t546Var.get_data_len(), str);
                                    b17._t546 = tlv_t546Var;
                                } else {
                                    util.LOGI("get tlv546 fail ret:" + i86, str);
                                    b17._t546 = new tlv_t546();
                                }
                                oicq.wlogin_sdk.pow.b.a(tlv_t546Var.get_data());
                                errMsg = new ErrMsg(0, b16, "", "", tlv_t192Var.getUrl());
                            } else {
                                i66 = tlv_t105Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1);
                                if (i66 >= 0) {
                                    b17._t105 = tlv_t105Var;
                                    if (tlv_t165Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1) >= 0) {
                                        b17._t165 = tlv_t165Var;
                                    } else {
                                        b17._t165 = new tlv_t165();
                                    }
                                    int i87 = tlv_t546Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1);
                                    if (i87 >= 0) {
                                        util.LOGI("get tlv546 success len:" + tlv_t546Var.get_data_len(), str);
                                        b17._t546 = tlv_t546Var;
                                    } else {
                                        util.LOGI("get tlv546 fail ret:" + i87, str);
                                        b17._t546 = new tlv_t546();
                                    }
                                    oicq.wlogin_sdk.pow.b.a(tlv_t546Var.get_data());
                                    errMsg = null;
                                }
                                i29 = i66;
                            }
                            a(errMsg);
                            i28 = b16;
                            i18 = i28;
                            bArr2 = bArr;
                            i26 = i65;
                            i27 = i79;
                        }
                        i18 = b16;
                        i19 = i65;
                        i28 = i29;
                    } else if (b16 != 15) {
                        if (b16 != 16) {
                            switch (b16) {
                                case 20:
                                    i65 = i85;
                                    str = "";
                                    util.LOGI("cmd " + Integer.toHexString(this.f422914j) + " subcmd " + Integer.toHexString(this.f422915k) + " result " + b16 + " seq error uin " + this.f422917m.f422957d + " appid " + j19, str);
                                    i67 = (this.f422907c - i79) - 1;
                                    break;
                                case 41:
                                case 116:
                                    i68 = b16;
                                    i65 = i85;
                                    i69 = 1;
                                    tlv_t tlv_tVar6 = new tlv_t(405);
                                    i29 = tlv_tVar6.get_tlv(bArr, i79, (this.f422907c - i79) - 1);
                                    if (i29 < 0) {
                                        i18 = i68;
                                        i19 = i65;
                                        str = "";
                                        i28 = i29;
                                        break;
                                    } else {
                                        WloginSigInfo._LHSig = tlv_tVar6.get_data();
                                        i75 = this.f422907c - i79;
                                        i78 = i75 - i69;
                                        b(bArr, i79, i78);
                                        b16 = i68;
                                        str = "";
                                        i28 = b16;
                                        i18 = i28;
                                        bArr2 = bArr;
                                        i26 = i65;
                                        i27 = i79;
                                        break;
                                    }
                                case 160:
                                case 239:
                                    i68 = b16;
                                    i76 = i85;
                                    c16 = 7;
                                    if (tlv_t113Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1) >= 0) {
                                        this.f422917m.f422957d = tlv_t113Var.get_uin();
                                        u uVar2 = this.f422917m;
                                        long j27 = uVar2.f422957d;
                                        b17._uin = j27;
                                        uVar2.a(uVar2.f422958e, Long.valueOf(j27));
                                    }
                                    int i88 = tlv_t104Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1);
                                    if (i88 < 0) {
                                        i29 = i88;
                                        i19 = i76;
                                        i18 = i68;
                                        str = "";
                                        i28 = i29;
                                        break;
                                    } else {
                                        b17.set_t104(tlv_t104Var);
                                        i77 = tlv_t174Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1);
                                        if (i77 >= 0) {
                                            b17._t174 = tlv_t174Var;
                                            i65 = i76;
                                            a(bArr, i79, tlv_t178Var, tlv_t179Var, tlv_t17dVar, b17);
                                            if (tlv_t17eVar.get_tlv(bArr, i79, (this.f422907c - i79) - 1) >= 0) {
                                                b17._devlock_info.VerifyReason = new String(tlv_t17eVar.get_data());
                                            }
                                            i69 = 1;
                                            if (tlv_t402Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1) >= 0) {
                                                b17._t402 = tlv_t402Var;
                                            } else {
                                                b17._t402 = new tlv_t402();
                                            }
                                            if (tlv_t403Var3.get_tlv(bArr, i79, (this.f422907c - i79) - 1) >= 0) {
                                                b17._t403 = tlv_t403Var3;
                                            } else {
                                                b17._t403 = new tlv_t403();
                                            }
                                            i75 = this.f422907c - i79;
                                            i78 = i75 - i69;
                                            b(bArr, i79, i78);
                                            b16 = i68;
                                            str = "";
                                            i28 = b16;
                                            i18 = i28;
                                            bArr2 = bArr;
                                            i26 = i65;
                                            i27 = i79;
                                            break;
                                        }
                                        i29 = i77;
                                        i19 = i76;
                                        i18 = i68;
                                        str = "";
                                        i28 = i29;
                                    }
                                case 176:
                                    i68 = b16;
                                    i76 = i85;
                                    b(bArr, i79, (this.f422907c - i79) - 1);
                                    u uVar3 = this.f422917m;
                                    uVar3.c(uVar3.f422958e);
                                    i65 = i76;
                                    b16 = i68;
                                    str = "";
                                    i28 = b16;
                                    i18 = i28;
                                    bArr2 = bArr;
                                    i26 = i65;
                                    i27 = i79;
                                    break;
                                case 180:
                                    i68 = b16;
                                    i76 = i85;
                                    c16 = 7;
                                    i77 = tlv_t161Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1);
                                    if (i77 >= 0) {
                                        a(tlv_t161Var);
                                        b(bArr, i79, (this.f422907c - i79) - 1);
                                        i65 = i76;
                                        b16 = i68;
                                        str = "";
                                        i28 = b16;
                                        i18 = i28;
                                        bArr2 = bArr;
                                        i26 = i65;
                                        i27 = i79;
                                        break;
                                    }
                                    i29 = i77;
                                    i19 = i76;
                                    i18 = i68;
                                    str = "";
                                    i28 = i29;
                                    break;
                                case 204:
                                    i68 = b16;
                                    i65 = i85;
                                    if (tlv_t113Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1) >= 0) {
                                        this.f422917m.f422957d = tlv_t113Var.get_uin();
                                        u uVar4 = this.f422917m;
                                        uVar4.a(uVar4.f422958e, Long.valueOf(uVar4.f422957d));
                                    }
                                    int i89 = tlv_t104Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1);
                                    if (i89 < 0) {
                                        i29 = i89;
                                    } else {
                                        b17.set_t104(tlv_t104Var);
                                        int i95 = tlv_t402Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1);
                                        if (i95 >= 0) {
                                            b17._t402 = tlv_t402Var;
                                            i95 = tlv_t403Var3.get_tlv(bArr, i79, (this.f422907c - i79) - 1);
                                            if (i95 >= 0) {
                                                b17._t403 = tlv_t403Var3;
                                                i78 = (this.f422907c - i79) - 1;
                                                b(bArr, i79, i78);
                                                b16 = i68;
                                                str = "";
                                                i28 = b16;
                                                i18 = i28;
                                                bArr2 = bArr;
                                                i26 = i65;
                                                i27 = i79;
                                                break;
                                            }
                                        }
                                        i29 = i95;
                                    }
                                    i18 = i68;
                                    i19 = i65;
                                    str = "";
                                    i28 = i29;
                                    break;
                                case 208:
                                    i29 = tlv_t104Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1);
                                    if (i29 >= 0) {
                                        b17.set_t104(tlv_t104Var);
                                        int i96 = tlv_t126Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1);
                                        if (i96 >= 0) {
                                            b17._t126 = tlv_t126Var;
                                            i96 = tlv_t182Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1);
                                            if (i96 >= 0) {
                                                b17._smslogin_msgcnt = tlv_t182Var.getMsgCnt();
                                                b17._smslogin_timelimit = tlv_t182Var.getTimeLimit();
                                                i96 = tlv_t183Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1);
                                                if (i96 >= 0) {
                                                    b17._msalt = tlv_t183Var.getMsalt();
                                                    bArr2 = bArr;
                                                    i18 = b16;
                                                    i26 = i85;
                                                    i27 = i79;
                                                    async_contextVar = b17;
                                                    str = "";
                                                    i28 = 0;
                                                    break;
                                                }
                                            }
                                        }
                                        i29 = i96;
                                    }
                                    i18 = b16;
                                    i19 = i85;
                                    str = "";
                                    i28 = i29;
                                    break;
                                case 224:
                                    util.LOGI("phone login go to dev verify");
                                    i68 = b16;
                                    i65 = i85;
                                    a(bArr, i79, tlv_t178Var, tlv_t179Var, tlv_t17dVar, b17);
                                    i75 = this.f422907c - i79;
                                    i69 = 1;
                                    i78 = i75 - i69;
                                    b(bArr, i79, i78);
                                    b16 = i68;
                                    str = "";
                                    i28 = b16;
                                    i18 = i28;
                                    bArr2 = bArr;
                                    i26 = i65;
                                    i27 = i79;
                                    break;
                                case 232:
                                    int i97 = tlv_t104Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1);
                                    if (i97 < 0) {
                                        i18 = b16;
                                        i28 = i97;
                                        bArr2 = bArr;
                                        i27 = i79;
                                        async_contextVar = b17;
                                        i26 = i85;
                                        str = "";
                                        break;
                                    } else {
                                        tlv_t52b tlv_t52bVar = new tlv_t52b();
                                        i29 = tlv_t52bVar.get_tlv(bArr, i79, (this.f422907c - i79) - 1);
                                        if (i29 < 0) {
                                            i18 = b16;
                                            i19 = i85;
                                            str = "";
                                            i28 = i29;
                                            break;
                                        } else {
                                            u.f422931h0 = tlv_t104Var.get_data();
                                            b17._smslogin_zone = tlv_t52bVar.get_zone();
                                            b17._smslogin_hint_mobile = tlv_t52bVar.get_mobile();
                                            i18 = b16;
                                            bArr2 = bArr;
                                            i27 = i79;
                                            async_contextVar = b17;
                                            i26 = i85;
                                            str = "";
                                            i28 = 0;
                                            break;
                                        }
                                    }
                                default:
                                    b(bArr, i79, (this.f422907c - i79) - 1);
                                    i65 = i85;
                                    str = "";
                                    i28 = b16;
                                    i18 = i28;
                                    bArr2 = bArr;
                                    i26 = i65;
                                    i27 = i79;
                                    break;
                            }
                            tlv_t543 tlv_t543Var3 = new tlv_t543();
                            int i98 = tlv_t543Var3.get_tlv(bArr2, i27, (this.f422907c - i27) - 1);
                            async_contextVar._t543 = tlv_t543Var3;
                            util.LOGI("tlv543_ret:" + i98, str);
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("get_response_body cmd= 0x");
                            sb6.append(Integer.toHexString(this.f422914j));
                            sb6.append(" subCmd= 0x");
                            sb6.append(Integer.toHexString(this.f422915k));
                            sb6.append(" type:");
                            sb6.append(i18);
                            sb6.append(" ret:");
                            sb6.append(i28 > 0 ? RelationNTPushServiceImpl.PRE_HEX_STRING + Integer.toHexString(i28) : Integer.valueOf(i28));
                            util.LOGI(sb6.toString(), str + this.f422917m.f422957d);
                            if (i28 == 0) {
                                a((ErrMsg) null);
                            } else {
                                new tlv_t508().get_tlv(bArr2, i27, (this.f422907c - i27) - 1);
                                if (tlv_t508.doFetch) {
                                    ErrMsg errMsg2 = new ErrMsg();
                                    int b18 = new g(this.f422917m, this.f422914j, this.f422915k, errMsg2).b(i28);
                                    if (b18 != -1000) {
                                        a(errMsg2);
                                        i28 = b18;
                                    }
                                }
                            }
                            if (i28 != 10 || i28 == 161 || i28 == 162 || i28 == 164 || i28 == 165 || i28 == 166 || i28 == 154 || (i28 >= 128 && i28 <= 143)) {
                                i58 = this.f422915k;
                                if (i58 != 15 || i58 == 10 || i58 == 11 || i58 == 20) {
                                    oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_CHANGE_TICKET_TIMEOUT, String.valueOf(i58), String.valueOf(i28)), 10000);
                                }
                                i28 = -1000;
                            }
                            i59 = i26;
                            if (i59 != 2 && i59 != 6 && i59 != 7) {
                                a(i59);
                            }
                            return i28;
                        }
                        i65 = i85;
                        str = "";
                        uVar.c(uVar.f422957d, j19);
                        oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_ALL_SIG_CLEAR, String.valueOf(b16), String.valueOf(this.f422915k)).a("appid", String.valueOf(j19)).a(String.valueOf(this.f422917m.f422957d)));
                        i66 = tlv_t130Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1);
                        if (i66 >= 0) {
                            this.f422917m.a(tlv_t130Var.get_time(), tlv_t130Var.get_ipaddr());
                            i67 = (this.f422907c - i79) - 1;
                        }
                        i29 = i66;
                        i18 = b16;
                        i19 = i65;
                        i28 = i29;
                        b(bArr, i79, i67);
                        i28 = b16;
                        i18 = i28;
                        bArr2 = bArr;
                        i26 = i65;
                        i27 = i79;
                    }
                    bArr2 = bArr;
                    i27 = i79;
                    i26 = i19;
                }
                i65 = i85;
                str = "";
                util.LOGI("cmd " + Integer.toHexString(this.f422914j) + " subcmd " + Integer.toHexString(this.f422915k) + " result " + b16 + " will clean sig for uin " + this.f422917m.f422957d + " appid " + j19, str);
                u uVar5 = this.f422917m;
                uVar5.c(uVar5.f422957d, j19);
                b(bArr, i79, (this.f422907c - i79) - 1);
                oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_ALL_SIG_CLEAR, String.valueOf(b16), String.valueOf(this.f422915k)).a("appid", String.valueOf(j19)).a(String.valueOf(this.f422917m.f422957d)));
                i28 = b16;
                i18 = i28;
                bArr2 = bArr;
                i26 = i65;
                i27 = i79;
            } else {
                i18 = b16;
                str = "";
                i19 = i85;
                if (i19 != 1) {
                    j3 = j19;
                    tlv_t119Var = tlv_t119Var2;
                    if (i19 == 2) {
                        if (tlv_t183Var.get_tlv(bArr, i79, this.f422907c - i79) >= 0) {
                            b17._msalt = tlv_t183Var.getMsalt();
                        }
                        if (c() == 3) {
                            int i99 = tlv_t113Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1);
                            if (i99 >= 0) {
                                this.f422917m.f422957d = tlv_t113Var.get_uin();
                                b17._uin = this.f422917m.f422957d;
                                if (!b17.ifQQLoginInQim(u.f422942s0)) {
                                    u uVar6 = this.f422917m;
                                    uVar6.a(uVar6.f422958e, Long.valueOf(uVar6.f422957d));
                                }
                            }
                            util.LOGI("flowid == 2 t113 = " + i99, String.valueOf(this.f422917m.f422957d));
                        } else {
                            if (tlv_t150Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1) >= 0) {
                                this.f422917m.f422956c = tlv_t150Var;
                            }
                            if (tlv_t161Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1) >= 0) {
                                a(tlv_t161Var);
                            }
                            i28 = tlv_t119Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1, b17._tgtgt_key);
                        }
                    } else {
                        if (i19 == 3 || i19 == 7) {
                            i26 = i19;
                            async_contextVar = b17;
                            bArr2 = bArr;
                            i27 = i79;
                            if (tlv_t183Var.get_tlv(bArr2, i27, this.f422907c - i79) >= 0) {
                                async_contextVar._msalt = tlv_t183Var.getMsalt();
                            }
                            int i100 = tlv_t113Var.get_tlv(bArr2, i27, this.f422907c - i27);
                            if (i100 >= 0) {
                                this.f422917m.f422957d = tlv_t113Var.get_uin();
                                u uVar7 = this.f422917m;
                                uVar7.a(uVar7.f422958e, Long.valueOf(uVar7.f422957d));
                            }
                            util.LOGI("flowid == 3 || flowid == 7 t113 = " + i100, String.valueOf(this.f422917m.f422957d));
                            int i101 = tlv_t104Var.get_tlv(bArr2, i27, this.f422907c - i27);
                            if (i101 < 0) {
                                i28 = i101;
                            } else {
                                async_contextVar.set_t104(tlv_t104Var);
                                i28 = 0;
                            }
                            tlv_t543 tlv_t543Var32 = new tlv_t543();
                            int i982 = tlv_t543Var32.get_tlv(bArr2, i27, (this.f422907c - i27) - 1);
                            async_contextVar._t543 = tlv_t543Var32;
                            util.LOGI("tlv543_ret:" + i982, str);
                            StringBuilder sb62 = new StringBuilder();
                            sb62.append("get_response_body cmd= 0x");
                            sb62.append(Integer.toHexString(this.f422914j));
                            sb62.append(" subCmd= 0x");
                            sb62.append(Integer.toHexString(this.f422915k));
                            sb62.append(" type:");
                            sb62.append(i18);
                            sb62.append(" ret:");
                            if (i28 > 0) {
                            }
                            sb62.append(i28 > 0 ? RelationNTPushServiceImpl.PRE_HEX_STRING + Integer.toHexString(i28) : Integer.valueOf(i28));
                            util.LOGI(sb62.toString(), str + this.f422917m.f422957d);
                            if (i28 == 0) {
                            }
                            if (i28 != 10) {
                            }
                            i58 = this.f422915k;
                            if (i58 != 15) {
                            }
                            oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_CHANGE_TICKET_TIMEOUT, String.valueOf(i58), String.valueOf(i28)), 10000);
                            i28 = -1000;
                            i59 = i26;
                            if (i59 != 2) {
                                a(i59);
                            }
                            return i28;
                        }
                        if (22 == this.f422915k) {
                            int i102 = tlv_t104Var.get_tlv(bArr, i79, this.f422907c - i79);
                            if (i102 < 0) {
                                i29 = i102;
                                i28 = i29;
                                bArr2 = bArr;
                                i27 = i79;
                                i26 = i19;
                            }
                        } else {
                            if (tlv_t150Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1) >= 0) {
                                this.f422917m.f422956c = tlv_t150Var;
                            }
                            if (tlv_t161Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1) >= 0) {
                                a(tlv_t161Var);
                            }
                            i28 = tlv_t119Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1, b17._tgtgt_key);
                            r.f422923v = 0;
                            if (i28 >= 0) {
                                byte[] bArr17 = tlv_t119Var.get_data();
                                int length = bArr17.length;
                                if (tlv_t149Var.get_tlv(bArr17, 2, length) > 0) {
                                    a(tlv_t149Var);
                                }
                                tlv_t543 tlv_t543Var4 = new tlv_t543();
                                int i103 = tlv_t543Var4.get_tlv(bArr17, 2, length);
                                b17.tlv543In119 = tlv_t543Var4;
                                if (tlv_t130Var.get_tlv(bArr17, 2, length) > 0) {
                                    this.f422917m.a(tlv_t130Var.get_time(), tlv_t130Var.get_ipaddr());
                                }
                                int i104 = tlv_t113Var.get_tlv(bArr17, 2, length);
                                util.LOGI("t113 ret = " + i104, str);
                                if (i104 >= 0 && tlv_t113Var.get_uin() != 0) {
                                    util.LOGI("t113.get_uin() = " + tlv_t113Var.get_uin(), str);
                                    this.f422917m.f422957d = tlv_t113Var.get_uin();
                                    b17._uin = this.f422917m.f422957d;
                                    if (!b17.ifQQLoginInQim(u.f422942s0)) {
                                        u uVar8 = this.f422917m;
                                        uVar8.a(uVar8.f422958e, Long.valueOf(uVar8.f422957d));
                                    }
                                }
                                util.LOGI("quickLoginByGateway retTlv543In119:" + i103 + " ,rett113=" + i104);
                                tlv_t tlv_tVar7 = new tlv_t(gdt_analysis_event.EVENT_QUERY_URL_BY_CGI_FAILED);
                                if (tlv_tVar7.get_tlv(bArr17, 2, length) > 0) {
                                    util.LOGI("get tlv528 and put into context from seq " + this.f422917m.f422959f, str + this.f422917m.f422957d);
                                    b17.tlv528 = tlv_tVar7;
                                }
                                tlv_t tlv_tVar8 = new tlv_t(1328);
                                if (tlv_tVar8.get_tlv(bArr17, 2, length) > 0) {
                                    util.LOGI("get tlv530 and put into context from seq " + this.f422917m.f422959f, str + this.f422917m.f422957d);
                                    b17.tlv530 = tlv_tVar8;
                                }
                                tlv_t10dVar2.get_tlv(bArr17, 2, length);
                                tlv_t10eVar2.get_tlv(bArr17, 2, length);
                                tlv_t10aVar2.get_tlv(bArr17, 2, length);
                                tlv_t114Var2.get_tlv(bArr17, 2, length);
                                i26 = i19;
                                i28 = tlv_t11aVar4.get_tlv(bArr17, 2, length);
                                if (i28 < 0) {
                                    bArr2 = bArr;
                                    i27 = i79;
                                } else {
                                    if (tlv_t118Var2.get_tlv(bArr17, 2, length) < 0) {
                                        StringBuilder sb7 = new StringBuilder();
                                        sb7.append(str);
                                        i36 = i79;
                                        tlv_t403Var = tlv_t403Var3;
                                        sb7.append(this.f422917m.f422957d);
                                        util.LOGI("t118 get failed", sb7.toString());
                                    } else {
                                        i36 = i79;
                                        tlv_t403Var = tlv_t403Var3;
                                    }
                                    if (tlv_t103Var.get_tlv(bArr17, 2, length) >= 0) {
                                        bArr3 = tlv_t103Var.get_data();
                                        tlv_t108Var = tlv_t108Var2;
                                    } else {
                                        tlv_t108Var = tlv_t108Var2;
                                        bArr3 = null;
                                    }
                                    if (tlv_t108Var.get_tlv(bArr17, 2, length) >= 0) {
                                        util.set_ksid(u.f422949w, tlv_t108Var.get_data());
                                    }
                                    if (tlv_t102Var.get_tlv(bArr17, 2, length) >= 0) {
                                        bArr4 = tlv_t102Var.get_data();
                                        tlv_t10bVar = tlv_t10bVar2;
                                    } else {
                                        tlv_t10bVar = tlv_t10bVar2;
                                        bArr4 = null;
                                    }
                                    if (tlv_t10bVar.get_tlv(bArr17, 2, length) >= 0) {
                                        bArr5 = tlv_t10bVar.get_data();
                                        tlv_t11cVar = tlv_t11cVar2;
                                    } else {
                                        tlv_t11cVar = tlv_t11cVar2;
                                        bArr5 = null;
                                    }
                                    if (tlv_t11cVar.get_tlv(bArr17, 2, length) >= 0) {
                                        bArr6 = tlv_t11cVar.get_data();
                                        tlv_t120Var = tlv_t120Var2;
                                    } else {
                                        tlv_t120Var = tlv_t120Var2;
                                        bArr6 = null;
                                    }
                                    if (tlv_t120Var.get_tlv(bArr17, 2, length) >= 0) {
                                        bArr7 = tlv_t120Var.get_data();
                                        tlv_t121Var = tlv_t121Var2;
                                    } else {
                                        tlv_t121Var = tlv_t121Var2;
                                        bArr7 = null;
                                    }
                                    if (tlv_t121Var.get_tlv(bArr17, 2, length) >= 0) {
                                        bArr8 = tlv_t121Var.get_data();
                                        tlv_t125Var = tlv_t125Var2;
                                    } else {
                                        tlv_t125Var = tlv_t125Var2;
                                        bArr8 = null;
                                    }
                                    if (tlv_t125Var.get_tlv(bArr17, 2, length) >= 0) {
                                        bArr9 = tlv_t125Var.get_openid();
                                        bArr10 = tlv_t125Var.get_openkey();
                                        tlv_t186Var = tlv_t186Var2;
                                    } else {
                                        tlv_t186Var = tlv_t186Var2;
                                        bArr9 = null;
                                        bArr10 = null;
                                    }
                                    if (tlv_t186Var.get_tlv(bArr17, 2, length) >= 0) {
                                        String str5 = this.f422917m.f422958e;
                                        if (util.check_uin_account(str5).booleanValue()) {
                                            u uVar9 = this.f422917m;
                                            tlv_t11aVar3 = tlv_t11aVar4;
                                            async_contextVar2 = b17;
                                            str5 = uVar9.d(uVar9.f422957d);
                                            if (str5 == null || str5.length() <= 0) {
                                                tlv_t11aVar = tlv_t11aVar3;
                                                tlv_t10eVar = tlv_t10eVar2;
                                                StringBuilder sb8 = new StringBuilder();
                                                sb8.append("put t186: name: ");
                                                sb8.append(str5);
                                                sb8.append(" uin: ");
                                                tlv_t543Var = tlv_t543Var4;
                                                sb8.append(this.f422917m.f422957d);
                                                sb8.append(" pwd=");
                                                sb8.append(tlv_t186Var.getPwdflag());
                                                util.LOGI(sb8.toString(), str);
                                            }
                                        } else {
                                            tlv_t11aVar3 = tlv_t11aVar4;
                                            async_contextVar2 = b17;
                                        }
                                        u uVar10 = this.f422917m;
                                        tlv_t11aVar = tlv_t11aVar3;
                                        tlv_t10eVar = tlv_t10eVar2;
                                        uVar10.a(str5, Long.valueOf(uVar10.f422957d), tlv_t186Var.getPwdflag());
                                        StringBuilder sb82 = new StringBuilder();
                                        sb82.append("put t186: name: ");
                                        sb82.append(str5);
                                        sb82.append(" uin: ");
                                        tlv_t543Var = tlv_t543Var4;
                                        sb82.append(this.f422917m.f422957d);
                                        sb82.append(" pwd=");
                                        sb82.append(tlv_t186Var.getPwdflag());
                                        util.LOGI(sb82.toString(), str);
                                    } else {
                                        tlv_t10eVar = tlv_t10eVar2;
                                        async_contextVar2 = b17;
                                        tlv_t11aVar = tlv_t11aVar4;
                                        tlv_t543Var = tlv_t543Var4;
                                    }
                                    try {
                                        tlv_t tlv_tVar9 = new tlv_t(1335);
                                        int i105 = tlv_tVar9.get_tlv(bArr17, 2, length);
                                        if (i105 < 0 || (bArr16 = tlv_tVar9.get_data()) == null || bArr16.length <= 0) {
                                            tlv_t118Var = tlv_t118Var2;
                                            tlv_t543Var2 = tlv_t543Var;
                                            tlv_t11aVar2 = tlv_t11aVar;
                                        } else {
                                            int length2 = bArr16.length - 2;
                                            byte[] bArr18 = new byte[length2];
                                            tlv_t543Var2 = tlv_t543Var;
                                            try {
                                                tlv_t118Var = tlv_t118Var2;
                                                tlv_t11aVar2 = tlv_t11aVar;
                                                try {
                                                    System.arraycopy(bArr16, 2, bArr18, 0, bArr16.length - 2);
                                                    util.LOGI("0x537 resp:" + i105 + ":" + bArr16.length + " setRes:" + ProtocolDet.setLoginExtraData(u.f422949w, bArr18) + " tuple:" + length2, str + this.f422917m.f422957d);
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    util.LOGI("tlv537 error " + Log.getStackTraceString(th), str);
                                                    StringBuilder sb9 = new StringBuilder();
                                                    sb9.append("tgt = " + util.buf_to_string(tlv_t10aVar2.get_data(), 2) + "  ");
                                                    sb9.append("tgt_key = " + util.buf_to_string(tlv_t10dVar2.get_data(), 2) + "  ");
                                                    util.LOGI(sb9.toString(), str + this.f422917m.f422957d);
                                                    util.LOGI("tgt len:" + util.buf_len(tlv_t10aVar2.get_data()) + " tgt_key len:" + util.buf_len(tlv_t10dVar2.get_data()) + " st len:" + util.buf_len(tlv_t114Var2.get_data()) + " st_key len:" + util.buf_len(tlv_t10eVar.get_data()) + " stwx_web len:" + util.buf_len(bArr3) + " lskey len:" + util.buf_len(bArr6) + " skey len:" + util.buf_len(bArr7) + " sig64 len:" + util.buf_len(bArr8) + " openid len:" + util.buf_len(bArr9) + " openkey len:" + util.buf_len(bArr10) + " pwdflag: " + tlv_t186Var.get_data_len() + " " + tlv_t186Var.getPwdflag(), str + this.f422917m.f422957d);
                                                    if (tlv_t169Var.get_tlv(bArr17, 2, length) >= 0) {
                                                    }
                                                    byte[][] bArr19 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 3, 0);
                                                    if (tlv_t167Var.get_tlv(bArr17, 2, length) >= 0) {
                                                    }
                                                    byte[][] bArr20 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 5, 0);
                                                    while (i37 < 5) {
                                                    }
                                                    i38 = tlv_t10cVar.get_tlv(bArr17, 2, length);
                                                    i39 = tlv_t106Var.get_tlv(bArr17, 2, length);
                                                    if (i38 >= 0) {
                                                    }
                                                    util.LOGI("A1SigChecker get null a1 from backend, a1EncryptKeyRet = " + i38 + " ret = " + i39, String.valueOf(this.f422917m.f422957d));
                                                    oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_A1_SIG_LOSE, "3", str).a(String.valueOf(this.f422917m.f422957d)));
                                                    if (tlv_t16aVar.get_tlv(bArr17, 2, length) >= 0) {
                                                    }
                                                    tlv_t tlv_tVar10 = new tlv_t(1329);
                                                    i46 = tlv_tVar10.get_tlv(bArr17, 2, length);
                                                    util.LOGI("retT531: " + i46 + this.f422917m.f422957d);
                                                    if (i46 >= 0) {
                                                    }
                                                    tlv_t403Var2 = tlv_t403Var;
                                                    bArr12 = null;
                                                    bArr13 = null;
                                                    j16 = 0;
                                                    if (tlv_t403Var2.get_tlv(bArr17, 2, length) >= 0) {
                                                    }
                                                    if (async_contextVar._sec_guid_flag) {
                                                    }
                                                    byte[][] bArr21 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 16, 0);
                                                    while (i48 < 16) {
                                                    }
                                                    if (tlv_t136Var.get_tlv(bArr17, 2, length) >= 0) {
                                                    }
                                                    if (tlv_t132Var.get_tlv(bArr17, 2, length) >= 0) {
                                                    }
                                                    if (tlv_t143Var.get_tlv(bArr17, 2, length) >= 0) {
                                                    }
                                                    if (tlv_t305Var.get_tlv(bArr17, 2, length) >= 0) {
                                                    }
                                                    if (tlv_t164Var.get_tlv(bArr17, 2, length) >= 0) {
                                                    }
                                                    if (tlv_t171Var.get_tlv(bArr17, 2, length) >= 0) {
                                                    }
                                                    if (tlv_tVar5.get_tlv(bArr17, 2, length) >= 0) {
                                                    }
                                                    if (tlv_t16dVar.get_tlv(bArr17, 2, length) >= 0) {
                                                    }
                                                    tlv_t199Var = new tlv_t199();
                                                    if (tlv_t199Var.get_tlv(bArr17, 2, length) < 0) {
                                                    }
                                                    tlv_t200Var = new tlv_t200();
                                                    if (tlv_t200Var.get_tlv(bArr17, 2, length) >= 0) {
                                                    }
                                                    tlv_tVar = new tlv_t(515);
                                                    if (tlv_tVar.get_tlv(bArr17, 2, length) < 0) {
                                                    }
                                                    util.LOGI(str2, str);
                                                    tlv_tVar2 = new tlv_t(com.tencent.luggage.wxa.uf.i.CTRL_INDEX);
                                                    if (tlv_tVar2.get_tlv(bArr17, 2, length) < 0) {
                                                    }
                                                    tlv_tVar3 = new tlv_t(307);
                                                    if (tlv_tVar3.get_tlv(bArr17, 2, length) < 0) {
                                                    }
                                                    tlv_tVar4 = new tlv_t(308);
                                                    if (tlv_tVar4.get_tlv(bArr17, 2, length) < 0) {
                                                    }
                                                    if (u.Z) {
                                                    }
                                                    util.LOGI("encrypt_a1 len:" + util.buf_len(bArr20[0]) + " no_pic_sig len:" + util.buf_len(bArr20[1]) + " G len:" + util.buf_len(bArr20[2]) + " dpwd len:" + util.buf_len(bArr20[3]) + " randseed len:" + util.buf_len(bArr20[4]) + " vkey len:" + util.buf_len(bArr21[0]) + " openid len:" + util.buf_len(bArr14) + " access_token len:" + util.buf_len(bArr21[1]) + " d2 len:" + util.buf_len(bArr21[2]) + " d2_key len:" + util.buf_len(bArr21[3]) + " sid len:" + util.buf_len(bArr21[4]) + " aq_sig len:" + util.buf_len(bArr21[5]) + " pskey len:" + util.buf_len(bArr21[6]) + " super_key len:" + util.buf_len(bArr21[7]) + " paytoken len:" + util.buf_len(bArr21[8]) + " pf len:" + util.buf_len(bArr21[9]) + " pfkey len:" + util.buf_len(bArr21[10]) + " da2 len:" + util.buf_len(bArr21[11]) + " wt session ticket:" + util.buf_len(bArr21[13]) + " wt session ticket key:" + util.buf_len(bArr21[14]) + " device_token len:" + util.buf_len(bArr21[15]), str + this.f422917m.f422957d);
                                                    if (tlv_t11fVar.get_tlv(bArr17, 2, length) < 0) {
                                                    }
                                                    long[] jArr = new long[7];
                                                    byte[] bArr22 = bArr13;
                                                    long j28 = j16;
                                                    j17 = 2160000;
                                                    i49 = 2;
                                                    while (true) {
                                                        i49 = tlv_t138Var.get_tlv(bArr17, i49, length);
                                                        if (i49 >= 0) {
                                                        }
                                                        j17 = j18;
                                                    }
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                tlv_t118Var = tlv_t118Var2;
                                                tlv_t11aVar2 = tlv_t11aVar;
                                                util.LOGI("tlv537 error " + Log.getStackTraceString(th), str);
                                                StringBuilder sb92 = new StringBuilder();
                                                sb92.append("tgt = " + util.buf_to_string(tlv_t10aVar2.get_data(), 2) + "  ");
                                                sb92.append("tgt_key = " + util.buf_to_string(tlv_t10dVar2.get_data(), 2) + "  ");
                                                util.LOGI(sb92.toString(), str + this.f422917m.f422957d);
                                                util.LOGI("tgt len:" + util.buf_len(tlv_t10aVar2.get_data()) + " tgt_key len:" + util.buf_len(tlv_t10dVar2.get_data()) + " st len:" + util.buf_len(tlv_t114Var2.get_data()) + " st_key len:" + util.buf_len(tlv_t10eVar.get_data()) + " stwx_web len:" + util.buf_len(bArr3) + " lskey len:" + util.buf_len(bArr6) + " skey len:" + util.buf_len(bArr7) + " sig64 len:" + util.buf_len(bArr8) + " openid len:" + util.buf_len(bArr9) + " openkey len:" + util.buf_len(bArr10) + " pwdflag: " + tlv_t186Var.get_data_len() + " " + tlv_t186Var.getPwdflag(), str + this.f422917m.f422957d);
                                                if (tlv_t169Var.get_tlv(bArr17, 2, length) >= 0) {
                                                }
                                                byte[][] bArr192 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 3, 0);
                                                if (tlv_t167Var.get_tlv(bArr17, 2, length) >= 0) {
                                                }
                                                byte[][] bArr202 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 5, 0);
                                                while (i37 < 5) {
                                                }
                                                i38 = tlv_t10cVar.get_tlv(bArr17, 2, length);
                                                i39 = tlv_t106Var.get_tlv(bArr17, 2, length);
                                                if (i38 >= 0) {
                                                }
                                                util.LOGI("A1SigChecker get null a1 from backend, a1EncryptKeyRet = " + i38 + " ret = " + i39, String.valueOf(this.f422917m.f422957d));
                                                oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_A1_SIG_LOSE, "3", str).a(String.valueOf(this.f422917m.f422957d)));
                                                if (tlv_t16aVar.get_tlv(bArr17, 2, length) >= 0) {
                                                }
                                                tlv_t tlv_tVar102 = new tlv_t(1329);
                                                i46 = tlv_tVar102.get_tlv(bArr17, 2, length);
                                                util.LOGI("retT531: " + i46 + this.f422917m.f422957d);
                                                if (i46 >= 0) {
                                                }
                                                tlv_t403Var2 = tlv_t403Var;
                                                bArr12 = null;
                                                bArr13 = null;
                                                j16 = 0;
                                                if (tlv_t403Var2.get_tlv(bArr17, 2, length) >= 0) {
                                                }
                                                if (async_contextVar._sec_guid_flag) {
                                                }
                                                byte[][] bArr212 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 16, 0);
                                                while (i48 < 16) {
                                                }
                                                if (tlv_t136Var.get_tlv(bArr17, 2, length) >= 0) {
                                                }
                                                if (tlv_t132Var.get_tlv(bArr17, 2, length) >= 0) {
                                                }
                                                if (tlv_t143Var.get_tlv(bArr17, 2, length) >= 0) {
                                                }
                                                if (tlv_t305Var.get_tlv(bArr17, 2, length) >= 0) {
                                                }
                                                if (tlv_t164Var.get_tlv(bArr17, 2, length) >= 0) {
                                                }
                                                if (tlv_t171Var.get_tlv(bArr17, 2, length) >= 0) {
                                                }
                                                if (tlv_tVar5.get_tlv(bArr17, 2, length) >= 0) {
                                                }
                                                if (tlv_t16dVar.get_tlv(bArr17, 2, length) >= 0) {
                                                }
                                                tlv_t199Var = new tlv_t199();
                                                if (tlv_t199Var.get_tlv(bArr17, 2, length) < 0) {
                                                }
                                                tlv_t200Var = new tlv_t200();
                                                if (tlv_t200Var.get_tlv(bArr17, 2, length) >= 0) {
                                                }
                                                tlv_tVar = new tlv_t(515);
                                                if (tlv_tVar.get_tlv(bArr17, 2, length) < 0) {
                                                }
                                                util.LOGI(str2, str);
                                                tlv_tVar2 = new tlv_t(com.tencent.luggage.wxa.uf.i.CTRL_INDEX);
                                                if (tlv_tVar2.get_tlv(bArr17, 2, length) < 0) {
                                                }
                                                tlv_tVar3 = new tlv_t(307);
                                                if (tlv_tVar3.get_tlv(bArr17, 2, length) < 0) {
                                                }
                                                tlv_tVar4 = new tlv_t(308);
                                                if (tlv_tVar4.get_tlv(bArr17, 2, length) < 0) {
                                                }
                                                if (u.Z) {
                                                }
                                                util.LOGI("encrypt_a1 len:" + util.buf_len(bArr202[0]) + " no_pic_sig len:" + util.buf_len(bArr202[1]) + " G len:" + util.buf_len(bArr202[2]) + " dpwd len:" + util.buf_len(bArr202[3]) + " randseed len:" + util.buf_len(bArr202[4]) + " vkey len:" + util.buf_len(bArr212[0]) + " openid len:" + util.buf_len(bArr14) + " access_token len:" + util.buf_len(bArr212[1]) + " d2 len:" + util.buf_len(bArr212[2]) + " d2_key len:" + util.buf_len(bArr212[3]) + " sid len:" + util.buf_len(bArr212[4]) + " aq_sig len:" + util.buf_len(bArr212[5]) + " pskey len:" + util.buf_len(bArr212[6]) + " super_key len:" + util.buf_len(bArr212[7]) + " paytoken len:" + util.buf_len(bArr212[8]) + " pf len:" + util.buf_len(bArr212[9]) + " pfkey len:" + util.buf_len(bArr212[10]) + " da2 len:" + util.buf_len(bArr212[11]) + " wt session ticket:" + util.buf_len(bArr212[13]) + " wt session ticket key:" + util.buf_len(bArr212[14]) + " device_token len:" + util.buf_len(bArr212[15]), str + this.f422917m.f422957d);
                                                if (tlv_t11fVar.get_tlv(bArr17, 2, length) < 0) {
                                                }
                                                long[] jArr2 = new long[7];
                                                byte[] bArr222 = bArr13;
                                                long j282 = j16;
                                                j17 = 2160000;
                                                i49 = 2;
                                                while (true) {
                                                    i49 = tlv_t138Var.get_tlv(bArr17, i49, length);
                                                    if (i49 >= 0) {
                                                    }
                                                    j17 = j18;
                                                }
                                            }
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                        tlv_t118Var = tlv_t118Var2;
                                        tlv_t543Var2 = tlv_t543Var;
                                    }
                                    StringBuilder sb922 = new StringBuilder();
                                    sb922.append("tgt = " + util.buf_to_string(tlv_t10aVar2.get_data(), 2) + "  ");
                                    sb922.append("tgt_key = " + util.buf_to_string(tlv_t10dVar2.get_data(), 2) + "  ");
                                    util.LOGI(sb922.toString(), str + this.f422917m.f422957d);
                                    util.LOGI("tgt len:" + util.buf_len(tlv_t10aVar2.get_data()) + " tgt_key len:" + util.buf_len(tlv_t10dVar2.get_data()) + " st len:" + util.buf_len(tlv_t114Var2.get_data()) + " st_key len:" + util.buf_len(tlv_t10eVar.get_data()) + " stwx_web len:" + util.buf_len(bArr3) + " lskey len:" + util.buf_len(bArr6) + " skey len:" + util.buf_len(bArr7) + " sig64 len:" + util.buf_len(bArr8) + " openid len:" + util.buf_len(bArr9) + " openkey len:" + util.buf_len(bArr10) + " pwdflag: " + tlv_t186Var.get_data_len() + " " + tlv_t186Var.getPwdflag(), str + this.f422917m.f422957d);
                                    if (tlv_t169Var.get_tlv(bArr17, 2, length) >= 0) {
                                        byte[] a16 = a(tlv_t169Var);
                                        if (a16 == null || a16.length <= 0) {
                                            this.f422917m.f422961h = new WFastLoginInfo();
                                        } else {
                                            this.f422917m.f422961h = new WFastLoginInfo(a16);
                                        }
                                    }
                                    byte[][] bArr1922 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 3, 0);
                                    if (tlv_t167Var.get_tlv(bArr17, 2, length) >= 0) {
                                        bArr1922[0] = tlv_t167Var.get_img_type();
                                        bArr1922[1] = tlv_t167Var.get_img_format();
                                        bArr1922[2] = tlv_t167Var.get_img_url();
                                    }
                                    byte[][] bArr2022 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 5, 0);
                                    for (i37 = 0; i37 < 5; i37++) {
                                        bArr2022[i37] = new byte[0];
                                    }
                                    i38 = tlv_t10cVar.get_tlv(bArr17, 2, length);
                                    i39 = tlv_t106Var.get_tlv(bArr17, 2, length);
                                    if (i38 >= 0 || i39 < 0) {
                                        util.LOGI("A1SigChecker get null a1 from backend, a1EncryptKeyRet = " + i38 + " ret = " + i39, String.valueOf(this.f422917m.f422957d));
                                        oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_A1_SIG_LOSE, "3", str).a(String.valueOf(this.f422917m.f422957d)));
                                    } else {
                                        bArr2022[0] = (byte[]) a(tlv_t106Var.get_data(), tlv_t10cVar.get_data()).clone();
                                    }
                                    if (tlv_t16aVar.get_tlv(bArr17, 2, length) >= 0) {
                                        bArr2022[1] = tlv_t16aVar.get_data();
                                    }
                                    tlv_t tlv_tVar1022 = new tlv_t(1329);
                                    i46 = tlv_tVar1022.get_tlv(bArr17, 2, length);
                                    util.LOGI("retT531: " + i46 + this.f422917m.f422957d);
                                    if (i46 >= 0) {
                                        tlv_t106 tlv_t106Var2 = new tlv_t106();
                                        tlv_t10c tlv_t10cVar2 = new tlv_t10c();
                                        tlv_t16a tlv_t16aVar2 = new tlv_t16a();
                                        tlv_t113 tlv_t113Var2 = new tlv_t113();
                                        bArr11 = bArr9;
                                        tlv_t114Var = tlv_t114Var2;
                                        int i106 = tlv_t106Var2.get_tlv(tlv_tVar1022.get_data(), 2, tlv_tVar1022.get_data_len());
                                        tlv_t10dVar = tlv_t10dVar2;
                                        int i107 = tlv_t10cVar2.get_tlv(tlv_tVar1022.get_data(), 2, tlv_tVar1022.get_data_len());
                                        tlv_t10aVar = tlv_t10aVar2;
                                        int i108 = tlv_t16aVar2.get_tlv(tlv_tVar1022.get_data(), 2, tlv_tVar1022.get_data_len());
                                        int i109 = tlv_t113Var2.get_tlv(tlv_tVar1022.get_data(), 2, tlv_tVar1022.get_data_len());
                                        if (i106 < 0 || i107 < 0 || i108 < 0 || i109 < 0) {
                                            async_contextVar = async_contextVar2;
                                            util.LOGI("Get data from 0x531 failed: " + i106 + ";" + i107 + ";" + i108 + ";" + i109 + ";" + this.f422917m.f422957d);
                                        } else {
                                            bArr12 = a(tlv_t106Var2.get_data(), tlv_t10cVar2.get_data());
                                            bArr13 = tlv_t16aVar2.get_data();
                                            j16 = util.buf_to_int32(tlv_t113Var2.get_data(), 0) & 4294967295L;
                                            async_contextVar = async_contextVar2;
                                            async_contextVar.tlv113 = tlv_t113Var2;
                                            tlv_t403Var2 = tlv_t403Var;
                                            if (tlv_t403Var2.get_tlv(bArr17, 2, length) >= 0) {
                                                bArr2022[4] = tlv_t403Var2.get_data();
                                            }
                                            if (async_contextVar._sec_guid_flag) {
                                                i47 = 0;
                                            } else {
                                                bArr2022[2] = async_contextVar._G;
                                                bArr2022[3] = async_contextVar._dpwd;
                                                bArr2022[4] = async_contextVar._t403.get_data();
                                                i47 = 0;
                                                async_contextVar._sec_guid_flag = false;
                                            }
                                            byte[][] bArr2122 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 16, 0);
                                            for (i48 = i47; i48 < 16; i48++) {
                                                bArr2122[i48] = new byte[i47];
                                            }
                                            if (tlv_t136Var.get_tlv(bArr17, 2, length) >= 0) {
                                                bArr2122[i47] = tlv_t136Var.get_data();
                                            }
                                            if (tlv_t132Var.get_tlv(bArr17, 2, length) >= 0) {
                                                bArr2122[1] = tlv_t132Var.get_access_token();
                                                bArr11 = tlv_t132Var.get_openid();
                                            }
                                            if (tlv_t143Var.get_tlv(bArr17, 2, length) >= 0) {
                                                bArr2122[2] = tlv_t143Var.get_data();
                                            }
                                            if (tlv_t305Var.get_tlv(bArr17, 2, length) >= 0) {
                                                bArr2122[3] = tlv_t305Var.get_data();
                                            }
                                            if (tlv_t164Var.get_tlv(bArr17, 2, length) >= 0) {
                                                bArr2122[4] = tlv_t164Var.get_data();
                                            }
                                            if (tlv_t171Var.get_tlv(bArr17, 2, length) >= 0) {
                                                bArr2122[5] = tlv_t171Var.get_data();
                                            }
                                            if (tlv_tVar5.get_tlv(bArr17, 2, length) >= 0) {
                                                bArr2122[6] = tlv_tVar5.get_data();
                                            }
                                            if (tlv_t16dVar.get_tlv(bArr17, 2, length) >= 0) {
                                                bArr2122[7] = tlv_t16dVar.get_data();
                                            }
                                            tlv_t199Var = new tlv_t199();
                                            if (tlv_t199Var.get_tlv(bArr17, 2, length) < 0) {
                                                bArr2122[8] = tlv_t199Var.getPayToken();
                                                bArr14 = tlv_t199Var.getOpenId();
                                            } else {
                                                bArr14 = bArr11;
                                            }
                                            tlv_t200Var = new tlv_t200();
                                            if (tlv_t200Var.get_tlv(bArr17, 2, length) >= 0) {
                                                bArr2122[9] = tlv_t200Var.getPf();
                                                bArr2122[10] = tlv_t200Var.getPfKey();
                                            }
                                            tlv_tVar = new tlv_t(515);
                                            if (tlv_tVar.get_tlv(bArr17, 2, length) < 0) {
                                                bArr2122[11] = tlv_tVar.get_data();
                                                str2 = "get DA2 in rsp";
                                            } else {
                                                str2 = "no DA2 in rsp";
                                            }
                                            util.LOGI(str2, str);
                                            tlv_tVar2 = new tlv_t(com.tencent.luggage.wxa.uf.i.CTRL_INDEX);
                                            if (tlv_tVar2.get_tlv(bArr17, 2, length) < 0) {
                                                WloginSigInfo._QRPUSHSig = tlv_tVar2.get_data();
                                            } else {
                                                WloginSigInfo._QRPUSHSig = new byte[0];
                                            }
                                            tlv_tVar3 = new tlv_t(307);
                                            if (tlv_tVar3.get_tlv(bArr17, 2, length) < 0) {
                                                bArr2122[13] = tlv_tVar3.get_data();
                                            } else {
                                                util.LOGW("get t133 failed", str + this.f422917m.f422957d);
                                            }
                                            tlv_tVar4 = new tlv_t(308);
                                            if (tlv_tVar4.get_tlv(bArr17, 2, length) < 0) {
                                                bArr2122[14] = tlv_tVar4.get_data();
                                            } else {
                                                util.LOGW("get t134 failed", str + this.f422917m.f422957d);
                                            }
                                            if (u.Z && ((i57 = this.f422915k) == 9 || i57 == 15 || i57 == 20)) {
                                                tlv_t322 tlv_t322Var = new tlv_t322();
                                                tlv_t322Var.get_tlv(bArr17, 2, length);
                                                bArr15 = tlv_t322Var.get_data();
                                                if (bArr15 != null || bArr15.length <= 0) {
                                                    str4 = "null";
                                                } else {
                                                    bArr2122[15] = bArr15;
                                                    str4 = util.buf_to_string(bArr15);
                                                }
                                                util.LOGI("get t322, value=" + str4, str + this.f422917m.f422957d);
                                            }
                                            util.LOGI("encrypt_a1 len:" + util.buf_len(bArr2022[0]) + " no_pic_sig len:" + util.buf_len(bArr2022[1]) + " G len:" + util.buf_len(bArr2022[2]) + " dpwd len:" + util.buf_len(bArr2022[3]) + " randseed len:" + util.buf_len(bArr2022[4]) + " vkey len:" + util.buf_len(bArr2122[0]) + " openid len:" + util.buf_len(bArr14) + " access_token len:" + util.buf_len(bArr2122[1]) + " d2 len:" + util.buf_len(bArr2122[2]) + " d2_key len:" + util.buf_len(bArr2122[3]) + " sid len:" + util.buf_len(bArr2122[4]) + " aq_sig len:" + util.buf_len(bArr2122[5]) + " pskey len:" + util.buf_len(bArr2122[6]) + " super_key len:" + util.buf_len(bArr2122[7]) + " paytoken len:" + util.buf_len(bArr2122[8]) + " pf len:" + util.buf_len(bArr2122[9]) + " pfkey len:" + util.buf_len(bArr2122[10]) + " da2 len:" + util.buf_len(bArr2122[11]) + " wt session ticket:" + util.buf_len(bArr2122[13]) + " wt session ticket key:" + util.buf_len(bArr2122[14]) + " device_token len:" + util.buf_len(bArr2122[15]), str + this.f422917m.f422957d);
                                            long j29 = tlv_t11fVar.get_tlv(bArr17, 2, length) < 0 ? tlv_t11fVar.get_tk_pri() & 4294967295L : 4294967295L;
                                            long[] jArr22 = new long[7];
                                            byte[] bArr2222 = bArr13;
                                            long j2822 = j16;
                                            j17 = 2160000;
                                            i49 = 2;
                                            while (true) {
                                                i49 = tlv_t138Var.get_tlv(bArr17, i49, length);
                                                if (i49 >= 0) {
                                                    StringBuilder sb10 = new StringBuilder();
                                                    sb10.append("sappid:");
                                                    sb10.append(j3);
                                                    sb10.append(" appid:");
                                                    sb10.append(j26);
                                                    byte[] bArr23 = bArr12;
                                                    sb10.append(" app_pri:");
                                                    sb10.append(j29);
                                                    sb10.append(" login_bitmap:");
                                                    sb10.append(async_contextVar._login_bitmap);
                                                    sb10.append(" tk_valid:");
                                                    long j36 = j29;
                                                    sb10.append(0L);
                                                    sb10.append(" a2_valid:");
                                                    sb10.append(j17);
                                                    sb10.append(" lskey_valid:");
                                                    sb10.append(jArr22[0]);
                                                    sb10.append(" skey_valid:");
                                                    sb10.append(jArr22[1]);
                                                    sb10.append(" vkey_valid:");
                                                    sb10.append(jArr22[2]);
                                                    sb10.append(" a8_valid:");
                                                    sb10.append(jArr22[3]);
                                                    sb10.append(" stweb_valid:");
                                                    sb10.append(jArr22[4]);
                                                    sb10.append(" d2_valid:");
                                                    sb10.append(jArr22[5]);
                                                    sb10.append(" sid_valid:");
                                                    sb10.append(jArr22[6]);
                                                    util.LOGI(sb10.toString(), str + this.f422917m.f422957d);
                                                    WloginSimpleInfo wloginSimpleInfo = new WloginSimpleInfo();
                                                    wloginSimpleInfo.setUin(this.f422917m.f422957d);
                                                    wloginSimpleInfo.setFace(tlv_t11aVar2.get_face());
                                                    wloginSimpleInfo.setAge(tlv_t11aVar2.get_age());
                                                    wloginSimpleInfo.setGender(tlv_t11aVar2.get_gender());
                                                    wloginSimpleInfo.setNick(tlv_t11aVar2.get_nick());
                                                    wloginSimpleInfo.setReserveUinInfo(bArr1922);
                                                    wloginSimpleInfo.setMainDisplayName(tlv_t118Var.get_data());
                                                    util.LOGI("setNick = " + new String(tlv_t11aVar2.get_nick()), str);
                                                    u uVar11 = this.f422917m;
                                                    uVar11.f422972s = async_contextVar._main_sigmap;
                                                    i28 = uVar11.a(uVar11.f422957d, j3, bArr2022, j26, j36, u.e(), u.e() + 0, u.e() + j17, wloginSimpleInfo, tlv_t10aVar.get_data(), tlv_t10dVar.get_data(), tlv_t114Var.get_data(), tlv_t10eVar.get_data(), bArr3, bArr5, bArr4, bArr6, bArr7, bArr8, bArr14, bArr10, bArr2122, jArr22, async_contextVar._login_bitmap, tlv_t543Var2.get_data());
                                                    if (i28 != 0) {
                                                        ErrMsg errMsg3 = new ErrMsg();
                                                        errMsg3.setMessage(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_2));
                                                        a(errMsg3);
                                                        str3 = "put_siginfo fail,ret=" + i28;
                                                        sb5 = new StringBuilder();
                                                        sb5.append(str);
                                                        sb5.append(this.f422917m.f422957d);
                                                    } else {
                                                        if (bArr23 == null || 0 == j2822) {
                                                            i56 = 0;
                                                        } else {
                                                            i56 = 0;
                                                            byte[][] bArr24 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, bArr2022.length, 0);
                                                            bArr24[0] = bArr23;
                                                            bArr24[1] = bArr2222;
                                                            i28 = this.f422917m.a(j2822, 16L, bArr24, 16L, j36, u.e(), u.e() + 0, u.e() + j17, wloginSimpleInfo, null, null, null, null, null, null, null, null, null, null, null, null, (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, bArr2122.length, 0), jArr22, async_contextVar._login_bitmap, null);
                                                            if (i28 != 0) {
                                                                ErrMsg errMsg4 = new ErrMsg();
                                                                errMsg4.setMessage(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_2));
                                                                a(errMsg4);
                                                                str3 = "put_siginfo fail " + i28;
                                                                sb5 = new StringBuilder();
                                                                sb5.append(str);
                                                                sb5.append(j2822);
                                                            }
                                                        }
                                                        int i110 = 2;
                                                        while (true) {
                                                            i110 = tlv_t11dVar.get_tlv(bArr17, i110, length);
                                                            if (i110 >= 0) {
                                                                u uVar12 = this.f422917m;
                                                                uVar12.a(uVar12.f422957d, tlv_t11dVar.get_appid(), u.e(), u.e() + 0, tlv_t11dVar.get_st(), tlv_t11dVar.get_stkey());
                                                            } else {
                                                                bArr2 = bArr;
                                                                i28 = i56;
                                                                i27 = i36;
                                                                tlv_t543 tlv_t543Var322 = new tlv_t543();
                                                                int i9822 = tlv_t543Var322.get_tlv(bArr2, i27, (this.f422907c - i27) - 1);
                                                                async_contextVar._t543 = tlv_t543Var322;
                                                                util.LOGI("tlv543_ret:" + i9822, str);
                                                                StringBuilder sb622 = new StringBuilder();
                                                                sb622.append("get_response_body cmd= 0x");
                                                                sb622.append(Integer.toHexString(this.f422914j));
                                                                sb622.append(" subCmd= 0x");
                                                                sb622.append(Integer.toHexString(this.f422915k));
                                                                sb622.append(" type:");
                                                                sb622.append(i18);
                                                                sb622.append(" ret:");
                                                                if (i28 > 0) {
                                                                }
                                                                sb622.append(i28 > 0 ? RelationNTPushServiceImpl.PRE_HEX_STRING + Integer.toHexString(i28) : Integer.valueOf(i28));
                                                                util.LOGI(sb622.toString(), str + this.f422917m.f422957d);
                                                                if (i28 == 0) {
                                                                }
                                                                if (i28 != 10) {
                                                                }
                                                                i58 = this.f422915k;
                                                                if (i58 != 15) {
                                                                }
                                                                oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_CHANGE_TICKET_TIMEOUT, String.valueOf(i58), String.valueOf(i28)), 10000);
                                                                i28 = -1000;
                                                                i59 = i26;
                                                                if (i59 != 2) {
                                                                }
                                                                return i28;
                                                            }
                                                        }
                                                    }
                                                    util.LOGI(str3, sb5.toString());
                                                    bArr2 = bArr;
                                                    i27 = i36;
                                                    tlv_t543 tlv_t543Var3222 = new tlv_t543();
                                                    int i98222 = tlv_t543Var3222.get_tlv(bArr2, i27, (this.f422907c - i27) - 1);
                                                    async_contextVar._t543 = tlv_t543Var3222;
                                                    util.LOGI("tlv543_ret:" + i98222, str);
                                                    StringBuilder sb6222 = new StringBuilder();
                                                    sb6222.append("get_response_body cmd= 0x");
                                                    sb6222.append(Integer.toHexString(this.f422914j));
                                                    sb6222.append(" subCmd= 0x");
                                                    sb6222.append(Integer.toHexString(this.f422915k));
                                                    sb6222.append(" type:");
                                                    sb6222.append(i18);
                                                    sb6222.append(" ret:");
                                                    if (i28 > 0) {
                                                    }
                                                    sb6222.append(i28 > 0 ? RelationNTPushServiceImpl.PRE_HEX_STRING + Integer.toHexString(i28) : Integer.valueOf(i28));
                                                    util.LOGI(sb6222.toString(), str + this.f422917m.f422957d);
                                                    if (i28 == 0) {
                                                    }
                                                    if (i28 != 10) {
                                                    }
                                                    i58 = this.f422915k;
                                                    if (i58 != 15) {
                                                    }
                                                    oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_CHANGE_TICKET_TIMEOUT, String.valueOf(i58), String.valueOf(i28)), 10000);
                                                    i28 = -1000;
                                                    i59 = i26;
                                                    if (i59 != 2) {
                                                    }
                                                    return i28;
                                                }
                                                if (tlv_t138Var.get_a2_chg_time() != 0) {
                                                    j17 = tlv_t138Var.get_a2_chg_time();
                                                }
                                                if (tlv_t138Var.get_lskey_chg_time() != 0) {
                                                    j18 = j17;
                                                    jArr22[0] = tlv_t138Var.get_lskey_chg_time();
                                                } else {
                                                    j18 = j17;
                                                    jArr22[0] = 1641600;
                                                }
                                                if (tlv_t138Var.get_skey_chg_time() != 0) {
                                                    jArr22[1] = tlv_t138Var.get_skey_chg_time();
                                                } else {
                                                    jArr22[1] = 86400;
                                                }
                                                if (tlv_t138Var.get_vkey_chg_time() != 0) {
                                                    jArr22[2] = tlv_t138Var.get_vkey_chg_time();
                                                } else {
                                                    jArr22[2] = 1728000;
                                                }
                                                if (tlv_t138Var.get_a8_chg_time() != 0) {
                                                    jArr22[3] = tlv_t138Var.get_a8_chg_time();
                                                } else {
                                                    jArr22[3] = 72000;
                                                }
                                                if (tlv_t138Var.get_stweb_chg_time() != 0) {
                                                    jArr22[4] = tlv_t138Var.get_stweb_chg_time();
                                                } else {
                                                    jArr22[4] = 6000;
                                                }
                                                if (tlv_t138Var.get_d2_chg_time() != 0) {
                                                    jArr22[5] = tlv_t138Var.get_d2_chg_time();
                                                } else {
                                                    jArr22[5] = 1728000;
                                                }
                                                if (tlv_t138Var.get_sid_chg_time() != 0) {
                                                    jArr22[6] = tlv_t138Var.get_sid_chg_time();
                                                } else {
                                                    jArr22[6] = 1728000;
                                                }
                                                j17 = j18;
                                            }
                                        }
                                    } else {
                                        tlv_t10dVar = tlv_t10dVar2;
                                        tlv_t10aVar = tlv_t10aVar2;
                                        tlv_t114Var = tlv_t114Var2;
                                        bArr11 = bArr9;
                                        async_contextVar = async_contextVar2;
                                    }
                                    tlv_t403Var2 = tlv_t403Var;
                                    bArr12 = null;
                                    bArr13 = null;
                                    j16 = 0;
                                    if (tlv_t403Var2.get_tlv(bArr17, 2, length) >= 0) {
                                    }
                                    if (async_contextVar._sec_guid_flag) {
                                    }
                                    byte[][] bArr21222 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 16, 0);
                                    while (i48 < 16) {
                                    }
                                    if (tlv_t136Var.get_tlv(bArr17, 2, length) >= 0) {
                                    }
                                    if (tlv_t132Var.get_tlv(bArr17, 2, length) >= 0) {
                                    }
                                    if (tlv_t143Var.get_tlv(bArr17, 2, length) >= 0) {
                                    }
                                    if (tlv_t305Var.get_tlv(bArr17, 2, length) >= 0) {
                                    }
                                    if (tlv_t164Var.get_tlv(bArr17, 2, length) >= 0) {
                                    }
                                    if (tlv_t171Var.get_tlv(bArr17, 2, length) >= 0) {
                                    }
                                    if (tlv_tVar5.get_tlv(bArr17, 2, length) >= 0) {
                                    }
                                    if (tlv_t16dVar.get_tlv(bArr17, 2, length) >= 0) {
                                    }
                                    tlv_t199Var = new tlv_t199();
                                    if (tlv_t199Var.get_tlv(bArr17, 2, length) < 0) {
                                    }
                                    tlv_t200Var = new tlv_t200();
                                    if (tlv_t200Var.get_tlv(bArr17, 2, length) >= 0) {
                                    }
                                    tlv_tVar = new tlv_t(515);
                                    if (tlv_tVar.get_tlv(bArr17, 2, length) < 0) {
                                    }
                                    util.LOGI(str2, str);
                                    tlv_tVar2 = new tlv_t(com.tencent.luggage.wxa.uf.i.CTRL_INDEX);
                                    if (tlv_tVar2.get_tlv(bArr17, 2, length) < 0) {
                                    }
                                    tlv_tVar3 = new tlv_t(307);
                                    if (tlv_tVar3.get_tlv(bArr17, 2, length) < 0) {
                                    }
                                    tlv_tVar4 = new tlv_t(308);
                                    if (tlv_tVar4.get_tlv(bArr17, 2, length) < 0) {
                                    }
                                    if (u.Z) {
                                        tlv_t322 tlv_t322Var2 = new tlv_t322();
                                        tlv_t322Var2.get_tlv(bArr17, 2, length);
                                        bArr15 = tlv_t322Var2.get_data();
                                        if (bArr15 != null) {
                                        }
                                        str4 = "null";
                                        util.LOGI("get t322, value=" + str4, str + this.f422917m.f422957d);
                                    }
                                    util.LOGI("encrypt_a1 len:" + util.buf_len(bArr2022[0]) + " no_pic_sig len:" + util.buf_len(bArr2022[1]) + " G len:" + util.buf_len(bArr2022[2]) + " dpwd len:" + util.buf_len(bArr2022[3]) + " randseed len:" + util.buf_len(bArr2022[4]) + " vkey len:" + util.buf_len(bArr21222[0]) + " openid len:" + util.buf_len(bArr14) + " access_token len:" + util.buf_len(bArr21222[1]) + " d2 len:" + util.buf_len(bArr21222[2]) + " d2_key len:" + util.buf_len(bArr21222[3]) + " sid len:" + util.buf_len(bArr21222[4]) + " aq_sig len:" + util.buf_len(bArr21222[5]) + " pskey len:" + util.buf_len(bArr21222[6]) + " super_key len:" + util.buf_len(bArr21222[7]) + " paytoken len:" + util.buf_len(bArr21222[8]) + " pf len:" + util.buf_len(bArr21222[9]) + " pfkey len:" + util.buf_len(bArr21222[10]) + " da2 len:" + util.buf_len(bArr21222[11]) + " wt session ticket:" + util.buf_len(bArr21222[13]) + " wt session ticket key:" + util.buf_len(bArr21222[14]) + " device_token len:" + util.buf_len(bArr21222[15]), str + this.f422917m.f422957d);
                                    if (tlv_t11fVar.get_tlv(bArr17, 2, length) < 0) {
                                    }
                                    long[] jArr222 = new long[7];
                                    byte[] bArr22222 = bArr13;
                                    long j28222 = j16;
                                    j17 = 2160000;
                                    i49 = 2;
                                    while (true) {
                                        i49 = tlv_t138Var.get_tlv(bArr17, i49, length);
                                        if (i49 >= 0) {
                                        }
                                        j17 = j18;
                                    }
                                }
                            }
                            bArr2 = bArr;
                            i27 = i79;
                            i26 = i19;
                        }
                    }
                    b17.set_t104(tlv_t104Var);
                    bArr2 = bArr;
                    i27 = i79;
                    i26 = i19;
                    async_contextVar = b17;
                    i28 = 0;
                    tlv_t543 tlv_t543Var32222 = new tlv_t543();
                    int i982222 = tlv_t543Var32222.get_tlv(bArr2, i27, (this.f422907c - i27) - 1);
                    async_contextVar._t543 = tlv_t543Var32222;
                    util.LOGI("tlv543_ret:" + i982222, str);
                    StringBuilder sb62222 = new StringBuilder();
                    sb62222.append("get_response_body cmd= 0x");
                    sb62222.append(Integer.toHexString(this.f422914j));
                    sb62222.append(" subCmd= 0x");
                    sb62222.append(Integer.toHexString(this.f422915k));
                    sb62222.append(" type:");
                    sb62222.append(i18);
                    sb62222.append(" ret:");
                    if (i28 > 0) {
                    }
                    sb62222.append(i28 > 0 ? RelationNTPushServiceImpl.PRE_HEX_STRING + Integer.toHexString(i28) : Integer.valueOf(i28));
                    util.LOGI(sb62222.toString(), str + this.f422917m.f422957d);
                    if (i28 == 0) {
                    }
                    if (i28 != 10) {
                    }
                    i58 = this.f422915k;
                    if (i58 != 15) {
                    }
                    oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_CHANGE_TICKET_TIMEOUT, String.valueOf(i58), String.valueOf(i28)), 10000);
                    i28 = -1000;
                    i59 = i26;
                    if (i59 != 2) {
                    }
                    return i28;
                }
                if (uVar.f422954a == null) {
                    return -1006;
                }
                if (tlv_t150Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1) >= 0) {
                    this.f422917m.f422956c = tlv_t150Var;
                }
                if (tlv_t161Var.get_tlv(bArr, i79, (this.f422907c - i79) - 1) >= 0) {
                    a(tlv_t161Var);
                }
                i28 = tlv_t119Var2.get_tlv(bArr, i79, (this.f422907c - i79) - 1, this.f422917m.f422954a);
                tlv_t119Var = tlv_t119Var2;
                j3 = j19;
                if (i28 >= 0) {
                }
                bArr2 = bArr;
                i27 = i79;
                i26 = i19;
            }
            async_contextVar = b17;
            tlv_t543 tlv_t543Var322222 = new tlv_t543();
            int i9822222 = tlv_t543Var322222.get_tlv(bArr2, i27, (this.f422907c - i27) - 1);
            async_contextVar._t543 = tlv_t543Var322222;
            util.LOGI("tlv543_ret:" + i9822222, str);
            StringBuilder sb622222 = new StringBuilder();
            sb622222.append("get_response_body cmd= 0x");
            sb622222.append(Integer.toHexString(this.f422914j));
            sb622222.append(" subCmd= 0x");
            sb622222.append(Integer.toHexString(this.f422915k));
            sb622222.append(" type:");
            sb622222.append(i18);
            sb622222.append(" ret:");
            if (i28 > 0) {
            }
            sb622222.append(i28 > 0 ? RelationNTPushServiceImpl.PRE_HEX_STRING + Integer.toHexString(i28) : Integer.valueOf(i28));
            util.LOGI(sb622222.toString(), str + this.f422917m.f422957d);
            if (i28 == 0) {
            }
            if (i28 != 10) {
            }
            i58 = this.f422915k;
            if (i58 != 15) {
            }
            oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_CHANGE_TICKET_TIMEOUT, String.valueOf(i58), String.valueOf(i28)), 10000);
            i28 = -1000;
            i59 = i26;
            if (i59 != 2) {
            }
            return i28;
        }
        i17 = 0;
        b16 = b(bArr, i3 + 2);
        int i792 = i3 + 5;
        int i852 = i17;
        u uVar13 = this.f422917m;
        uVar13.f422956c = null;
        if (b16 == 0) {
        }
        async_contextVar = b17;
        tlv_t543 tlv_t543Var3222222 = new tlv_t543();
        int i98222222 = tlv_t543Var3222222.get_tlv(bArr2, i27, (this.f422907c - i27) - 1);
        async_contextVar._t543 = tlv_t543Var3222222;
        util.LOGI("tlv543_ret:" + i98222222, str);
        StringBuilder sb6222222 = new StringBuilder();
        sb6222222.append("get_response_body cmd= 0x");
        sb6222222.append(Integer.toHexString(this.f422914j));
        sb6222222.append(" subCmd= 0x");
        sb6222222.append(Integer.toHexString(this.f422915k));
        sb6222222.append(" type:");
        sb6222222.append(i18);
        sb6222222.append(" ret:");
        if (i28 > 0) {
        }
        sb6222222.append(i28 > 0 ? RelationNTPushServiceImpl.PRE_HEX_STRING + Integer.toHexString(i28) : Integer.valueOf(i28));
        util.LOGI(sb6222222.toString(), str + this.f422917m.f422957d);
        if (i28 == 0) {
        }
        if (i28 != 10) {
        }
        i58 = this.f422915k;
        if (i58 != 15) {
        }
        oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_CHANGE_TICKET_TIMEOUT, String.valueOf(i58), String.valueOf(i28)), 10000);
        i28 = -1000;
        i59 = i26;
        if (i59 != 2) {
        }
        return i28;
    }

    public String a(boolean z16) {
        String[] strArr = new String[2];
        if (z16) {
            strArr[0] = "wlogin.qq.com";
            strArr[1] = "wlogin1.qq.com";
        } else {
            strArr[0] = "wtlogin.qq.com";
            strArr[1] = "wtlogin1.qq.com";
        }
        return strArr[Math.abs(new Random().nextInt() % 2)];
    }

    public int b(byte[] bArr, int i3) {
        return bArr[i3] & 255;
    }

    public void c(byte[] bArr, int i3) {
        if (i3 > this.f422906b) {
            int i16 = i3 + 128;
            this.f422906b = i16;
            this.f422909e = new byte[i16];
        }
        this.f422907c = i3;
        System.arraycopy(bArr, 0, this.f422909e, 0, i3);
    }

    public void a() {
        util.int8_to_buf(this.f422909e, this.f422907c, 3);
        this.f422907c++;
    }

    public void b(byte[] bArr, int i3, int i16) {
        tlv_t146 tlv_t146Var = new tlv_t146();
        int i17 = tlv_t146Var.get_tlv(bArr, i3, i16);
        async_context b16 = u.b(this.f422917m.f422959f);
        if (i17 >= 0) {
            b16._last_err_msg.setVersion(tlv_t146Var.get_ver());
            b16._last_err_msg.setTitle(new String(tlv_t146Var.get_title()));
            b16._last_err_msg.setMessage(new String(tlv_t146Var.get_msg()));
            b16._last_err_msg.setType(tlv_t146Var.get_type());
            b16._last_err_msg.setOtherinfo(new String(tlv_t146Var.get_errorinfo()));
        }
    }

    public byte[] c(byte[] bArr) {
        u uVar = this.f422917m;
        return uVar.f422964k == 0 ? a(bArr, uVar.f422955b, uVar.f422965l, uVar.f422966m, uVar.f422967n) : b(bArr, uVar.f422955b);
    }

    public final void a(int i3, int i16, long j3, int i17, int i18, int i19, int i26, int i27) {
        int i28 = this.f422910f + 1;
        this.f422910f = i28;
        this.f422907c = 0;
        util.int8_to_buf(this.f422909e, 0, 2);
        int i29 = this.f422907c + 1;
        this.f422907c = i29;
        util.int16_to_buf(this.f422909e, i29, i27 + 29);
        int i36 = this.f422907c + 2;
        this.f422907c = i36;
        util.int16_to_buf(this.f422909e, i36, i3);
        int i37 = this.f422907c + 2;
        this.f422907c = i37;
        util.int16_to_buf(this.f422909e, i37, i16);
        int i38 = this.f422907c + 2;
        this.f422907c = i38;
        util.int16_to_buf(this.f422909e, i38, i28);
        int i39 = this.f422907c + 2;
        this.f422907c = i39;
        util.int32_to_buf(this.f422909e, i39, (int) j3);
        int i46 = this.f422907c + 4;
        this.f422907c = i46;
        util.int8_to_buf(this.f422909e, i46, 3);
        int i47 = this.f422907c + 1;
        this.f422907c = i47;
        util.int8_to_buf(this.f422909e, i47, i17);
        int i48 = this.f422907c + 1;
        this.f422907c = i48;
        util.int8_to_buf(this.f422909e, i48, i18);
        int i49 = this.f422907c + 1;
        this.f422907c = i49;
        util.int32_to_buf(this.f422909e, i49, 2);
        int i56 = this.f422907c + 4;
        this.f422907c = i56;
        util.int32_to_buf(this.f422909e, i56, i19);
        int i57 = this.f422907c + 4;
        this.f422907c = i57;
        util.int32_to_buf(this.f422909e, i57, i26);
        this.f422907c += 4;
    }

    public byte[] b() {
        int i3 = this.f422907c;
        byte[] bArr = new byte[i3];
        System.arraycopy(this.f422909e, 0, bArr, 0, i3);
        return bArr;
    }

    public final void a(int i3, long j3, int i16, int i17, boolean z16, boolean z17) {
        report_t3 report_t3Var = new report_t3();
        report_t3Var._cmd = this.f422914j;
        report_t3Var._sub = this.f422915k;
        report_t3Var._rst2 = i3;
        report_t3Var._used = (int) (System.currentTimeMillis() - j3);
        report_t3Var._try = i17;
        String str = f422904u;
        report_t3Var._host = str;
        if (str == null) {
            report_t3Var._host = "";
        }
        InetSocketAddress inetSocketAddress = this.f422911g;
        if (inetSocketAddress == null) {
            report_t3Var._ip = "";
        } else {
            report_t3Var._ip = inetSocketAddress.getAddress().getHostAddress();
        }
        report_t3Var._port = b(z16);
        report_t3Var._conn = i16;
        report_t3Var._net = u.F;
        report_t3Var._str = "";
        report_t3Var._slen = 0;
        report_t3Var._rlen = 0;
        report_t3Var._wap = z16 ? z17 ? 2 : 1 : 0;
        u.f422936m0.add_t3(report_t3Var);
    }

    public byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return new byte[0];
        }
        int i3 = this.f422917m.f422964k == 2 ? 3 : 2;
        byte[] encrypt = cryptor.encrypt(bArr, 0, bArr.length, bArr2);
        byte[] bArr3 = new byte[bArr2.length + 2 + 2 + 2 + encrypt.length];
        util.int8_to_buf(bArr3, 0, 1);
        util.int8_to_buf(bArr3, 1, i3);
        System.arraycopy(bArr2, 0, bArr3, 2, bArr2.length);
        int length = bArr2.length + 2;
        util.int16_to_buf(bArr3, length, 258);
        int i16 = length + 2;
        util.int16_to_buf(bArr3, i16, 0);
        System.arraycopy(encrypt, 0, bArr3, i16 + 2, encrypt.length);
        return bArr3;
    }

    public void a(Socket socket) {
        this.f422917m.f422970q = socket;
    }

    public void a(tlv_t149 tlv_t149Var) {
        try {
            ErrMsg errMsg = new ErrMsg();
            errMsg.setType(tlv_t149Var.get_type());
            errMsg.setTitle(new String(tlv_t149Var.get_title()));
            errMsg.setMessage(new String(tlv_t149Var.get_content()));
            errMsg.setOtherinfo(new String(tlv_t149Var.get_otherinfo()));
            new e(u.f422949w, errMsg).start();
        } catch (Exception unused) {
        }
    }

    public void a(ErrMsg errMsg) {
        async_context b16 = u.b(this.f422917m.f422959f);
        b16._last_err_msg = new ErrMsg(0, 0, "", "", "");
        if (errMsg != null) {
            try {
                b16._last_err_msg = (ErrMsg) errMsg.clone();
            } catch (CloneNotSupportedException unused) {
                b16._last_err_msg = new ErrMsg(0, 0, "", "", "");
            }
        }
    }

    public void a(byte[] bArr, int i3) {
        int i16 = this.f422907c;
        int i17 = i3 + i16 + 1;
        if (i17 > this.f422906b) {
            int i18 = i17 + 128;
            this.f422906b = i18;
            byte[] bArr2 = new byte[i18];
            System.arraycopy(this.f422909e, 0, bArr2, 0, i16);
            this.f422909e = bArr2;
        }
        System.arraycopy(bArr, 0, this.f422909e, this.f422907c, i3);
        this.f422907c += i3;
    }

    public void a(byte[] bArr, int i3, tlv_t178 tlv_t178Var, tlv_t179 tlv_t179Var, tlv_t17d tlv_t17dVar, async_context async_contextVar) {
        StringBuffer stringBuffer = new StringBuffer("handleDevlockInfo");
        int i16 = tlv_t178Var.get_tlv(bArr, i3, (this.f422907c - i3) - 1);
        stringBuffer.append(",t178 = ");
        stringBuffer.append(i16);
        if (i16 >= 0) {
            async_contextVar._devlock_info.CountryCode = new String(tlv_t178Var.get_country_code());
            async_contextVar._devlock_info.Mobile = new String(tlv_t178Var.get_mobile());
            async_contextVar._devlock_info.MbItemSmsCodeStatus = tlv_t178Var.get_smscode_status();
            async_contextVar._devlock_info.AvailableMsgCount = tlv_t178Var.get_available_msg_cnt();
            async_contextVar._devlock_info.TimeLimit = tlv_t178Var.get_time_limit();
        }
        tlv_t196 tlv_t196Var = new tlv_t196();
        int i17 = tlv_t196Var.get_tlv(bArr, i3, (this.f422907c - i3) - 1);
        stringBuffer.append(",t196 = ");
        stringBuffer.append(i17);
        if (i17 >= 0) {
            async_contextVar._devlock_info.BakCountryCode = tlv_t196Var.getCountryCode();
            async_contextVar._devlock_info.BakMobile = tlv_t196Var.getBakMobile();
            async_contextVar._devlock_info.BakMobileState = tlv_t196Var.getBakMobileState();
        }
        tlv_t204 tlv_t204Var = new tlv_t204();
        int i18 = tlv_t204Var.get_tlv(bArr, i3, (this.f422907c - i3) - 1);
        stringBuffer.append(",t204 = ");
        stringBuffer.append(i18);
        if (i18 > 0) {
            async_contextVar._devlock_info.OtherDevLockVerifyUrl = new String(tlv_t204Var.get_data());
        }
        int i19 = tlv_t179Var.get_tlv(bArr, i3, (this.f422907c - i3) - 1);
        stringBuffer.append(",t179 = ");
        stringBuffer.append(i19);
        if (i19 >= 0) {
            async_contextVar._devlock_info.UnionVerifyUrl = new String(tlv_t179Var.get_verify_url());
        }
        int i26 = tlv_t17dVar.get_tlv(bArr, i3, (this.f422907c - i3) - 1);
        stringBuffer.append(",t17d = ");
        stringBuffer.append(i26);
        if (i26 >= 0) {
            async_contextVar._devlock_info.MbGuideType = tlv_t17dVar.get_mb_guide_type();
            async_contextVar._devlock_info.MbGuideMsg = new String(tlv_t17dVar.get_mb_guide_msg());
            async_contextVar._devlock_info.MbGuideInfoType = tlv_t17dVar.get_mb_guide_info_type();
            async_contextVar._devlock_info.MbGuideInfo = new String(tlv_t17dVar.get_mb_guide_info());
        }
        util.LOGI(stringBuffer.toString(), "");
    }

    public byte[] a(tlv_t169 tlv_t169Var) {
        tlv_t106 tlv_t106Var = new tlv_t106();
        tlv_t10c tlv_t10cVar = new tlv_t10c();
        tlv_t16a tlv_t16aVar = new tlv_t16a();
        tlv_t145 tlv_t145Var = new tlv_t145();
        byte[] bArr = tlv_t169Var.get_data();
        int length = bArr.length;
        if (tlv_t106Var.get_tlv(bArr, 2, length) < 0 || tlv_t10cVar.get_tlv(bArr, 2, length) < 0 || tlv_t16aVar.get_tlv(bArr, 2, length) < 0) {
            return null;
        }
        byte[] bArr2 = tlv_t106Var.get_buf();
        byte[] bArr3 = tlv_t10cVar.get_buf();
        byte[] bArr4 = tlv_t16aVar.get_buf();
        byte[] bArr5 = tlv_t145Var.get_tlv_145(u.D);
        byte[] bArr6 = new byte[bArr2.length + 3 + bArr3.length + bArr4.length + bArr5.length];
        bArr6[0] = MaskType.MASK_TYPE_EXTERNAL;
        util.int16_to_buf(bArr6, 1, 4);
        System.arraycopy(bArr2, 0, bArr6, 3, bArr2.length);
        int length2 = bArr2.length + 3;
        System.arraycopy(bArr3, 0, bArr6, length2, bArr3.length);
        int length3 = length2 + bArr3.length;
        System.arraycopy(bArr4, 0, bArr6, length3, bArr4.length);
        System.arraycopy(bArr5, 0, bArr6, length3 + bArr4.length, bArr5.length);
        return bArr6;
    }

    public byte[] a(byte[] bArr) {
        byte[] decrypt;
        byte[] bArr2 = u.E;
        if (bArr2 == null || bArr2.length <= 0) {
            decrypt = cryptor.decrypt(bArr, 0, bArr.length, "%4;7t>;28<fc.5*6".getBytes());
        } else {
            byte[] bArr3 = new byte[16];
            if (bArr2.length > 16) {
                System.arraycopy(bArr2, 0, bArr3, 0, 16);
            } else {
                System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
                int length = u.E.length;
                while (length < 16) {
                    int i3 = length + 1;
                    bArr3[length] = (byte) i3;
                    length = i3;
                }
            }
            decrypt = cryptor.decrypt(bArr, 0, bArr.length, bArr3);
            if (decrypt == null || decrypt.length <= 0) {
                decrypt = cryptor.decrypt(bArr, 0, bArr.length, "%4;7t>;28<fc.5*6".getBytes());
            }
        }
        if (decrypt == null) {
            decrypt = (byte[]) bArr.clone();
        }
        if (decrypt.length < 16) {
            return null;
        }
        int length2 = decrypt.length - 16;
        byte[] bArr4 = new byte[length2];
        System.arraycopy(decrypt, 0, bArr4, 0, length2);
        byte[] bArr5 = new byte[16];
        System.arraycopy(decrypt, length2, bArr5, 0, 16);
        u.b(this.f422917m.f422959f)._tgtgt_key = bArr5;
        return bArr4;
    }

    public byte[] a(byte[] bArr, int i3, int i16) {
        byte[] bArr2 = new byte[bArr.length + 4];
        util.int16_to_buf(bArr2, 0, i3);
        util.int16_to_buf(bArr2, 2, i16);
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        u uVar = this.f422917m;
        return uVar.f422964k == 0 ? a(bArr2, uVar.f422955b, uVar.f422965l, uVar.f422966m, uVar.f422967n) : b(bArr2, uVar.f422955b);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr2 == null || bArr3 == null) {
            return new byte[16];
        }
        byte[] bArr4 = new byte[bArr.length + bArr2.length + bArr3.length];
        System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        int length = bArr.length + 0;
        System.arraycopy(bArr2, 0, bArr4, length, bArr2.length);
        System.arraycopy(bArr3, 0, bArr4, length + bArr2.length, bArr3.length);
        return MD5.toMD5Byte(bArr4);
    }

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i3) {
        if (bArr == null || bArr2 == null || bArr3 == null || bArr4 == null) {
            return new byte[0];
        }
        try {
            byte[] encrypt = cryptor.encrypt(bArr, 0, bArr.length, bArr4);
            byte[] bArr5 = new byte[bArr2.length + 2 + 2 + 2 + 2 + bArr3.length + encrypt.length];
            util.int8_to_buf(bArr5, 0, 2);
            util.int8_to_buf(bArr5, 1, 1);
            System.arraycopy(bArr2, 0, bArr5, 2, bArr2.length);
            int length = bArr2.length + 2;
            util.int16_to_buf(bArr5, length, 305);
            int i16 = length + 2;
            util.int16_to_buf(bArr5, i16, i3);
            int i17 = i16 + 2;
            util.int16_to_buf(bArr5, i17, bArr3.length);
            int i18 = i17 + 2;
            System.arraycopy(bArr3, 0, bArr5, i18, bArr3.length);
            System.arraycopy(encrypt, 0, bArr5, i18 + bArr3.length, encrypt.length);
            return bArr5;
        } catch (Throwable th5) {
            util.printThrowable(th5, "ecdh_encrypt_body");
            return new byte[0];
        }
    }

    public byte[] a(byte[] bArr, EncryptionMethod encryptionMethod, byte[] bArr2, byte[] bArr3) {
        if (EncryptionMethod.EM_ST == encryptionMethod) {
            byte[] encrypt = cryptor.encrypt(bArr, 0, bArr.length, bArr3);
            byte[] bArr4 = new byte[bArr2.length + 2 + encrypt.length];
            util.int16_to_buf(bArr4, 0, bArr2.length);
            System.arraycopy(bArr2, 0, bArr4, 2, bArr2.length);
            System.arraycopy(encrypt, 0, bArr4, bArr2.length + 2, encrypt.length);
            return bArr4;
        }
        if (EncryptionMethod.EM_ECDH == encryptionMethod) {
            return c(bArr);
        }
        util.LOGI("encryptBody unknown encryption method " + encryptionMethod, "");
        return null;
    }

    public void a(long j3, byte[] bArr, EncryptionMethod encryptionMethod) {
        if (encryptionMethod == EncryptionMethod.EM_ST) {
            a(8001, this.f422914j, j3, 69, 0, u.f422953z, 0, bArr.length);
            a(bArr, bArr.length);
            a();
            return;
        }
        if (encryptionMethod == EncryptionMethod.EM_ECDH) {
            a(8001, this.f422914j, j3, !this.f422919o ? 7 : 135, 0, u.f422953z, 0, bArr.length);
            a(bArr, bArr.length);
            a();
            return;
        }
        util.LOGI("getRequestEncrptedPackage unknown encryption method " + encryptionMethod, "" + j3);
    }

    public void a(int i3, int i16, int i17, long j3, int i18, int i19, int i26, int i27, byte[] bArr) {
        int length = bArr.length;
        int i28 = this.f422910f + 1;
        this.f422910f = i28;
        this.f422907c = 0;
        util.int8_to_buf(this.f422909e, 0, 2);
        int i29 = this.f422907c + 1;
        this.f422907c = i29;
        util.int16_to_buf(this.f422909e, i29, length + 29);
        int i36 = this.f422907c + 2;
        this.f422907c = i36;
        util.int16_to_buf(this.f422909e, i36, i3);
        int i37 = this.f422907c + 2;
        this.f422907c = i37;
        util.int16_to_buf(this.f422909e, i37, i16);
        int i38 = this.f422907c + 2;
        this.f422907c = i38;
        util.int16_to_buf(this.f422909e, i38, i28);
        int i39 = this.f422907c + 2;
        this.f422907c = i39;
        util.int32_to_buf(this.f422909e, i39, (int) j3);
        int i46 = this.f422907c + 4;
        this.f422907c = i46;
        util.int8_to_buf(this.f422909e, i46, 3);
        int i47 = this.f422907c + 1;
        this.f422907c = i47;
        util.int8_to_buf(this.f422909e, i47, 7);
        int i48 = this.f422907c + 1;
        this.f422907c = i48;
        util.int8_to_buf(this.f422909e, i48, i18);
        int i49 = this.f422907c + 1;
        this.f422907c = i49;
        util.int32_to_buf(this.f422909e, i49, i19);
        int i56 = this.f422907c + 4;
        this.f422907c = i56;
        util.int32_to_buf(this.f422909e, i56, i26);
        int i57 = this.f422907c + 4;
        this.f422907c = i57;
        util.int32_to_buf(this.f422909e, i57, i27);
        this.f422907c += 4;
        a(bArr, length);
        a();
    }

    public int a(tlv_t161 tlv_t161Var) {
        tlv_t172 tlv_t172Var;
        int i3;
        tlv_t172 tlv_t172Var2;
        byte[] bArr;
        int buf_to_int16;
        int buf_to_int162;
        byte[] bArr2;
        tlv_t173 tlv_t173Var = new tlv_t173();
        tlv_t172 tlv_t172Var3 = new tlv_t172();
        tlv_t17f tlv_t17fVar = new tlv_t17f();
        byte[] bArr3 = tlv_t161Var.get_data();
        int length = bArr3.length;
        int i16 = 2;
        if (tlv_t17fVar.get_tlv(bArr3, 2, length) > 0 && (bArr2 = tlv_t17fVar.get_data()) != null && bArr2.length > 2) {
            int buf_to_int8 = util.buf_to_int8(bArr2, 1);
            int i17 = 2;
            int i18 = 0;
            while (i18 < buf_to_int8) {
                int i19 = i17 + 1;
                if (bArr2.length >= i19) {
                    int buf_to_int82 = util.buf_to_int8(bArr2, i17);
                    int i26 = i19 + 2;
                    if (bArr2.length >= i26) {
                        int buf_to_int163 = util.buf_to_int16(bArr2, i19);
                        int i27 = buf_to_int8;
                        int i28 = i26 + buf_to_int163;
                        if (bArr2.length >= i28) {
                            byte[] bArr4 = new byte[buf_to_int163];
                            tlv_t172Var = tlv_t172Var3;
                            System.arraycopy(bArr2, i26, bArr4, 0, buf_to_int163);
                            int i29 = i28 + 2;
                            if (bArr2.length < i29) {
                                i3 = 2;
                                break;
                            }
                            int buf_to_int164 = util.buf_to_int16(bArr2, i28);
                            if (buf_to_int163 <= 0) {
                                i17 = i29;
                            } else {
                                if (buf_to_int82 == 1) {
                                    int i36 = u.F;
                                    if (i36 == 1) {
                                        util.set_server_ipv6_host1(u.f422949w, bArr4);
                                    } else if (i36 == 2) {
                                        util.set_server_ipv6_host2(u.f422949w, bArr4);
                                    }
                                } else if (buf_to_int82 == 2) {
                                    int i37 = u.F;
                                    if (i37 == 1) {
                                        util.set_wap_server_ipv6_host1(u.f422949w, bArr4);
                                    } else if (i37 == 2) {
                                        util.set_wap_server_ipv6_host2(u.f422949w, bArr4);
                                    }
                                }
                                String str = "ipv6 net type:" + u.F + " type:" + buf_to_int82 + " host:" + new String(bArr4) + " port:" + buf_to_int164;
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("");
                                i17 = i29;
                                sb5.append(this.f422917m.f422957d);
                                util.LOGI(str, sb5.toString());
                            }
                            i18++;
                            buf_to_int8 = i27;
                            tlv_t172Var3 = tlv_t172Var;
                            i16 = 2;
                        }
                    }
                }
                tlv_t172Var = tlv_t172Var3;
                i3 = 2;
                break;
            }
        }
        tlv_t172Var = tlv_t172Var3;
        i3 = i16;
        if (tlv_t173Var.get_tlv(bArr3, i3, length) <= 0 || (bArr = tlv_t173Var.get_data()) == null || bArr.length <= i3) {
            tlv_t172Var2 = tlv_t172Var;
        } else {
            int buf_to_int83 = util.buf_to_int8(bArr, 1);
            int i38 = 2;
            int i39 = 0;
            while (i39 < buf_to_int83) {
                int i46 = i38 + 1;
                if (bArr.length >= i46) {
                    int buf_to_int84 = util.buf_to_int8(bArr, i38);
                    int i47 = i46 + 2;
                    if (bArr.length < i47 || bArr.length < (buf_to_int162 = i47 + (buf_to_int16 = util.buf_to_int16(bArr, i46)))) {
                        break;
                    }
                    byte[] bArr5 = new byte[buf_to_int16];
                    System.arraycopy(bArr, i47, bArr5, 0, buf_to_int16);
                    int i48 = buf_to_int162 + 2;
                    if (bArr.length < i48) {
                        break;
                    }
                    int buf_to_int165 = util.buf_to_int16(bArr, buf_to_int162);
                    if (buf_to_int16 > 0) {
                        if (buf_to_int84 == 1) {
                            int i49 = u.F;
                            if (i49 == 1) {
                                util.set_server_host1(u.f422949w, bArr5);
                            } else if (i49 == 2) {
                                util.set_server_host2(u.f422949w, bArr5);
                            }
                        } else if (buf_to_int84 == 2) {
                            int i56 = u.F;
                            if (i56 == 1) {
                                util.set_wap_server_host1(u.f422949w, bArr5);
                            } else if (i56 == 2) {
                                util.set_wap_server_host2(u.f422949w, bArr5);
                            }
                        }
                        util.LOGI("net type:" + u.F + " type:" + buf_to_int84 + " host:" + new String(bArr5) + " port:" + buf_to_int165, "" + this.f422917m.f422957d);
                    }
                    i39++;
                    i38 = i48;
                } else {
                    break;
                }
            }
            tlv_t172Var2 = tlv_t172Var;
            i3 = 2;
        }
        if (tlv_t172Var2.get_tlv(bArr3, i3, length) <= 0) {
            return 0;
        }
        u uVar = this.f422917m;
        uVar.f422964k = 1;
        uVar.f422968o = tlv_t172Var2.get_data();
        util.LOGI("get rollback sig", "");
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a8, code lost:
    
        if (r5.length() > 0) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(int i3, boolean z16) {
        String str;
        String str2;
        String str3;
        int i16 = i3 / 2;
        if (f422902s != 0 && (str3 = f422903t) != null && str3.length() > 0) {
            str = f422903t;
        } else if (i16 < 1) {
            str2 = "";
            int i17 = u.F;
            if (z16) {
                if (i17 == 1) {
                    str2 = i3 == 0 ? new String(util.get_wap_server_ipv6_host1(u.f422949w)) : "";
                    if (TextUtils.isEmpty(str2)) {
                        str = new String(util.get_wap_server_host1(u.f422949w));
                    }
                    str = str2;
                } else {
                    if (i17 == 2) {
                        str2 = i3 == 0 ? new String(util.get_wap_server_ipv6_host2(u.f422949w)) : "";
                        if (TextUtils.isEmpty(str2)) {
                            str = new String(util.get_wap_server_host2(u.f422949w));
                        }
                    }
                    str = str2;
                }
            } else if (i17 == 1) {
                str2 = i3 == 0 ? new String(util.get_server_ipv6_host1(u.f422949w)) : "";
                if (TextUtils.isEmpty(str2)) {
                    str = new String(util.get_server_host1(u.f422949w));
                }
                str = str2;
            } else {
                if (i17 == 2) {
                    str2 = i3 == 0 ? new String(util.get_server_ipv6_host2(u.f422949w)) : "";
                    if (TextUtils.isEmpty(str2)) {
                        str = new String(util.get_server_host2(u.f422949w));
                    }
                }
                str = str2;
            }
        } else {
            if (i16 >= 2) {
                new String();
                str = z16 ? "sslv6.wlogin.qq.com" : "wlogin-v6.qq.com";
            }
            str = a(z16);
        }
        f422904u = str;
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(String str, boolean z16, WUserSigInfo wUserSigInfo) {
        int f16;
        int i3;
        int i16;
        byte[] bArr;
        WtloginMsfListener wtloginMsfListener;
        int i17 = 0;
        if (this.f422917m.f422962i != 0) {
            util.LOGI(getClass().getName() + ":snd_rcv_req_msf ...", "" + this.f422917m.f422957d);
            int i18 = this.f422917m.f422963j;
            int i19 = this.f422907c;
            byte[] bArr2 = new byte[i19];
            System.arraycopy(this.f422909e, 0, bArr2, 0, i19);
            long currentTimeMillis = System.currentTimeMillis();
            byte[] bArr3 = null;
            try {
                String str2 = "WtloginMsfListener uin:" + str + " service_cmd:" + this.f422916l + " timeout:" + i18 + " flag:" + z16;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                i3 = i19;
                try {
                    sb5.append(this.f422917m.f422957d);
                    util.LOGI(str2, sb5.toString());
                    i16 = 10000;
                    try {
                        wtloginMsfListener = new WtloginMsfListener(str, this.f422916l, bArr2, i18, z16, wUserSigInfo);
                        BaseThread baseThread = new BaseThread(wtloginMsfListener, "Wtlogin_msf");
                        baseThread.start();
                        baseThread.join(i18);
                        bArr = wtloginMsfListener.getRetData();
                    } catch (Exception e16) {
                        e = e16;
                    }
                } catch (Exception e17) {
                    e = e17;
                    i16 = 10000;
                    util.printException(e, "" + this.f422917m.f422957d);
                    oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_CHANGE_TICKET_TIMEOUT, String.valueOf(this.f422915k), "2"), i16);
                    bArr = bArr3;
                    f16 = -1000;
                    if (this.f422914j != 2066) {
                    }
                    util.LOGI(getClass().getName() + ":snd_rcv_req_msf ret=" + f16, "" + this.f422917m.f422957d);
                    if (f16 == -1000) {
                    }
                    return f16;
                }
            } catch (Exception e18) {
                e = e18;
                i3 = i19;
            }
            try {
            } catch (Exception e19) {
                e = e19;
                bArr3 = bArr;
                util.printException(e, "" + this.f422917m.f422957d);
                oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_CHANGE_TICKET_TIMEOUT, String.valueOf(this.f422915k), "2"), i16);
                bArr = bArr3;
                f16 = -1000;
                if (this.f422914j != 2066) {
                }
                util.LOGI(getClass().getName() + ":snd_rcv_req_msf ret=" + f16, "" + this.f422917m.f422957d);
                if (f16 == -1000) {
                }
                return f16;
            }
            if (bArr == null) {
                util.LOGI("recv data from server failed, ret=" + wtloginMsfListener.getRet(), "" + this.f422917m.f422957d);
                oicq.wlogin_sdk.report.c.b.a(new oicq.wlogin_sdk.report.c.a(EventConstant.EventType.EVENT_WT_CHANGE_TICKET_TIMEOUT, String.valueOf(this.f422915k), "1"), 10000);
                f16 = -1000;
                if (this.f422914j != 2066) {
                    report_t3 report_t3Var = new report_t3();
                    report_t3Var._cmd = this.f422914j;
                    report_t3Var._sub = this.f422915k;
                    report_t3Var._rst2 = f16;
                    report_t3Var._used = (int) (System.currentTimeMillis() - currentTimeMillis);
                    report_t3Var._try = 0;
                    report_t3Var._host = "";
                    report_t3Var._ip = "";
                    report_t3Var._port = 0;
                    report_t3Var._conn = 0;
                    report_t3Var._net = 0;
                    report_t3Var._str = "";
                    if (f16 == 0) {
                        report_t3Var._slen = i3;
                        i17 = bArr.length;
                    } else {
                        report_t3Var._slen = 0;
                    }
                    report_t3Var._rlen = i17;
                    report_t3Var._wap = 3;
                    u.f422936m0.add_t3(report_t3Var);
                }
                util.LOGI(getClass().getName() + ":snd_rcv_req_msf ret=" + f16, "" + this.f422917m.f422957d);
            } else {
                c(bArr, bArr.length);
                f16 = 0;
                if (this.f422914j != 2066) {
                }
                util.LOGI(getClass().getName() + ":snd_rcv_req_msf ret=" + f16, "" + this.f422917m.f422957d);
            }
        } else {
            f16 = f();
        }
        if (f16 == -1000) {
            ErrMsg errMsg = new ErrMsg();
            errMsg.setMessage(InternationMsg.a(InternationMsg.MSG_TYPE.MSG_4));
            a(errMsg);
        }
        return f16;
    }
}

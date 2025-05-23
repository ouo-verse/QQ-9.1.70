package com.tencent.mobileqq.msgbackup.transport;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.data.h;
import com.tencent.mobileqq.msgbackup.data.i;
import com.tencent.mobileqq.msgbackup.util.StartWrapperResult;
import com.tencent.mobileqq.msgbackup.util.c;
import com.tencent.mobileqq.msgbackup.util.f;
import com.tencent.mobileqq.persistence.backup.impl.DBBackupServiceImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes15.dex */
public class MsgBackupTransportProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: r, reason: collision with root package name */
    private static MsgBackupTransportProcessor f251330r;

    /* renamed from: a, reason: collision with root package name */
    protected MsgBackupJniProxy f251331a;

    /* renamed from: b, reason: collision with root package name */
    protected MsgBackupNotifier f251332b;

    /* renamed from: c, reason: collision with root package name */
    protected int f251333c;

    /* renamed from: d, reason: collision with root package name */
    protected StartWrapperResult f251334d;

    /* renamed from: e, reason: collision with root package name */
    protected StartWrapperResult f251335e;

    /* renamed from: f, reason: collision with root package name */
    protected String f251336f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f251337g;

    /* renamed from: h, reason: collision with root package name */
    private long f251338h;

    /* renamed from: i, reason: collision with root package name */
    private long f251339i;

    /* renamed from: j, reason: collision with root package name */
    protected long f251340j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f251341k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f251342l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f251343m;

    /* renamed from: n, reason: collision with root package name */
    protected boolean f251344n;

    /* renamed from: o, reason: collision with root package name */
    private final Object f251345o;

    /* renamed from: p, reason: collision with root package name */
    private final Handler f251346p;

    /* renamed from: q, reason: collision with root package name */
    private com.tencent.mobileqq.msgbackup.controller.e f251347q;

    public MsgBackupTransportProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f251334d = new StartWrapperResult();
        this.f251335e = new StartWrapperResult();
        this.f251337g = false;
        this.f251338h = 0L;
        this.f251339i = 0L;
        this.f251340j = 0L;
        this.f251341k = false;
        this.f251342l = false;
        this.f251343m = false;
        this.f251344n = false;
        this.f251345o = new Object();
        this.f251346p = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
    }

    private void A0(String str, int i3, int i16, String str2, long j3) {
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "recvMessageUdp udpdetected = " + this.f251341k + ", ip = " + str + ", port = " + i3 + ", cmd = " + i16 + ", cookie = " + j3 + ", data = " + str2);
        if (i16 != 256) {
            if (i16 == 257) {
                y0(str2);
            } else if (i16 == 258) {
                d0(str2);
            } else if (i16 == 259) {
                x0(str2);
            }
        }
    }

    private void B0(long j3, String str, int i3, boolean z16) {
        String str2;
        String str3;
        String str4;
        if (f()) {
            f.C("requestFromFile called------> operator is closed! please clear handler msg!........", new Object[0]);
            return;
        }
        if (this.f251331a != null) {
            long y16 = f.y();
            String str5 = f.z(y(), z()) + f.n("getmsg?fid=" + y16 + "&chatUin=" + str + "&chatType=" + f.q(i3), this.f251336f);
            String s16 = f.s(str, f.q(i3), null);
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestFromFile fid = " + y16 + ", url = " + str5 + ", path = " + s16);
            }
            i iVar = new i();
            iVar.f251155c = true;
            iVar.f251159g = (short) 0;
            iVar.f251157e = s16;
            iVar.f251158f = str5;
            String t16 = f.t(str, f.q(i3));
            ConcurrentHashMap<String, h> concurrentHashMap = MsgBackupManager.x().f251039c;
            com.tencent.mobileqq.msgbackup.util.d.b();
            com.tencent.mobileqq.msgbackup.util.d.f251402a.f251388r++;
            h hVar = concurrentHashMap.get(t16);
            if (hVar == null) {
                str2 = "requestFromFile fid = ";
                str3 = str5;
                str4 = s16;
            } else {
                hVar.a().put(Long.valueOf(y16), iVar);
                long j16 = hVar.f251145d;
                iVar.f251161i = j16;
                iVar.f251160h = f.A(j16);
                str2 = "requestFromFile fid = ";
                str3 = str5;
                str4 = s16;
                com.tencent.mobileqq.msgbackup.util.d.f251402a.f251381k += iVar.f251161i;
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestFromFile , sessionInfo.dbMList = " + hVar.a() + ". sessionInfo.hashcode = " + hVar.hashCode() + ", task.isSmallerFile = " + iVar.f251160h);
                }
            }
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, str2 + y16 + ", mClientCanRecvMList = " + concurrentHashMap + ", keyFromUin = " + t16 + ", task.isSmallerFile = " + iVar.f251160h);
            this.f251331a.b(j3, y16, str3, str4, iVar.f251160h, iVar.f251161i, false);
            Object[] objArr = new Object[2];
            boolean z17 = false;
            objArr[0] = Boolean.valueOf(this.f251344n);
            if (this.f251347q != null) {
                z17 = true;
            }
            objArr[1] = Boolean.valueOf(z17);
            f.B("MsgBackup_MsgBackupTransportProcessor", "requestFromFile isTransportStart = %b, mCallBack is not null = %b", objArr);
            com.tencent.mobileqq.msgbackup.controller.e eVar = this.f251347q;
            if (eVar != null && !this.f251344n) {
                this.f251344n = true;
                eVar.cb(true);
            }
        }
    }

    private String C(long j3, int i3) {
        int i16;
        com.tencent.mobileqq.msgbackup.controller.e eVar;
        int i17 = MsgBackupManager.K;
        ConcurrentHashMap<String, h> concurrentHashMap = MsgBackupManager.x().f251038b;
        concurrentHashMap.size();
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "getSessionJsonRsp, fid = " + j3 + ", mServerReadyMList.size = " + concurrentHashMap.size() + ", mDataCache = " + i17 + ", from = " + i3);
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            if (concurrentHashMap.size() > 0) {
                jSONObject.put("cmd", "chat_list_count");
                jSONObject.put("listCount", i17);
                jSONArray.mo162put(jSONObject);
                synchronized (this.f251345o) {
                    i16 = 0;
                    for (h hVar : concurrentHashMap.values()) {
                        if (hVar.f251148g) {
                            i16++;
                        }
                        if (!hVar.f251146e) {
                            JSONObject jSONObject2 = new JSONObject();
                            String str = hVar.f251142a;
                            int i18 = hVar.f251143b;
                            jSONObject2.put("cmd", "chat_ready");
                            jSONObject2.put("chatUin", str);
                            jSONObject2.put("chatType", f.q(i18));
                            jSONObject2.put("dbSize", hVar.f251145d);
                            jSONArray.mo162put(jSONObject2);
                            hVar.f251146e = true;
                        }
                    }
                }
                if (3 == i3 && (eVar = this.f251347q) != null) {
                    eVar.hd(i16, MsgBackupManager.K);
                }
            }
            return jSONArray.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    private void D(long j3, String str, int i3, String str2) {
        if (f.f251422b) {
            str2 = f.f(str2, this.f251336f);
        }
        String str3 = str2;
        com.tencent.mobileqq.msgbackup.util.d.b();
        ConcurrentHashMap<Long, i> concurrentHashMap = MsgBackupManager.x().f251044h;
        ConcurrentHashMap<String, h> concurrentHashMap2 = MsgBackupManager.x().f251038b;
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, MsgBackupManager.curDealType = " + MsgBackupManager.L + ", MsgBackupManager.curDealType = " + MsgBackupManager.M);
        }
        if (this.f251331a != null && str3 != null) {
            if (str3.contains("/postinfo?")) {
                m0(j3, str3, concurrentHashMap, concurrentHashMap2);
                return;
            }
            if (str3.contains("/getmsg?")) {
                j0(j3, str3, concurrentHashMap, concurrentHashMap2);
            } else if (str3.contains("/getres?")) {
                k0(j3, str3, concurrentHashMap);
            } else {
                l0(j3, str3);
            }
        }
    }

    private void E(long j3, ConcurrentHashMap<Long, i> concurrentHashMap, ConcurrentHashMap<String, h> concurrentHashMap2, Map<String, String> map) {
        if (map.size() >= 3) {
            int i3 = 0;
            if (f()) {
                f.C("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
                return;
            }
            long parseLong = Long.parseLong(map.get(Utils.KEY_BUSINESS_ID));
            String str = map.get("chatUin");
            int parseInt = Integer.parseInt(map.get("chatType"));
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached: client report \u4f1a\u8bdd uin =" + str + " \u63a5\u6536\u5b8c\u6210, chatType = " + parseInt + "\uff1amServerReadyMList.size = " + concurrentHashMap2.size());
            }
            h hVar = concurrentHashMap2.get(f.t(str, parseInt));
            if (hVar != null) {
                hVar.f251148g = true;
                if (this.f251347q != null) {
                    synchronized (this.f251345o) {
                        Iterator<h> it = concurrentHashMap2.values().iterator();
                        while (it.hasNext()) {
                            if (it.next().f251148g) {
                                i3++;
                            }
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached: client report session completed! hasCompletedCount = " + i3);
                    }
                    com.tencent.mobileqq.msgbackup.controller.e eVar = this.f251347q;
                    if (eVar != null) {
                        eVar.hd(i3, MsgBackupManager.K);
                    }
                    boolean z16 = MsgBackupManager.C;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, client report session transport completed! fid = " + parseLong + ", msg = []");
            }
            K0(j3, concurrentHashMap, parseLong, C(parseLong, 3));
        }
    }

    private boolean E0(ConcurrentHashMap<String, h> concurrentHashMap, boolean z16) {
        boolean z17;
        Iterator<h> it = concurrentHashMap.values().iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            h next = it.next();
            if (!next.f251147f) {
                z17 = true;
                if (next.f251145d <= 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, curDealUin is not null! dbsize \u7b49\u4e8e 0 \uff01\u5ba2\u6237\u7aef\u4e0d\u4f1a\u53bb\u8bf7\u6c42\u4e86\uff0c\u53ea\u662f\u901a\u77e5server\u7aef\uff0c\u8be5\u4f1a\u8bdd\u5df2\u7ecf\u63a5\u53d7\u5b8c\u6210\u4e86\uff01uin = " + next.f251142a + ", uintype = " + next.f251143b + ", dbsize = " + next.f251145d);
                    }
                    next.f251148g = true;
                    next.f251147f = true;
                    N(next);
                    if (this.f251347q != null) {
                        i3 = s(concurrentHashMap);
                        com.tencent.mobileqq.msgbackup.controller.e eVar = this.f251347q;
                        if (eVar != null) {
                            eVar.hd(i3, MsgBackupManager.K);
                        }
                        if (i3 == MsgBackupManager.K) {
                            f.B("MsgBackup_MsgBackupTransportProcessor", "curDealUin is not null! session transport completed! dbSize is 0!------------->", new Object[0]);
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    int s16 = s(concurrentHashMap);
                    com.tencent.mobileqq.msgbackup.controller.e eVar2 = this.f251347q;
                    if (eVar2 != null) {
                        eVar2.hd(s16, MsgBackupManager.K);
                    }
                    if (s16 == MsgBackupManager.K) {
                        f.B("MsgBackup_MsgBackupTransportProcessor", "curDealUin is not null! session transport completed!------------->", new Object[0]);
                        z17 = z16;
                    } else {
                        next.f251147f = true;
                        MsgBackupManager.L = next.f251142a;
                        MsgBackupManager.M = next.f251143b;
                        if (QLog.isColorLevel()) {
                            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, current uin = " + MsgBackupManager.L + ", uintype = " + MsgBackupManager.M + ", dbsize = " + next.f251145d);
                        }
                        B0(this.f251340j, next.f251142a, next.f251143b, false);
                    }
                    i3 = s16;
                }
            }
        }
        z17 = z16;
        if (!z17 && i3 != MsgBackupManager.K) {
            I0(5);
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNextSessionDb called with warning step2 , , hasFinishedC = " + i3);
            }
        }
        return z17;
    }

    private void F(long j3, ConcurrentHashMap<Long, i> concurrentHashMap, Map<String, String> map) {
        com.tencent.mobileqq.msgbackup.controller.e eVar;
        if (f()) {
            f.C("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
            return;
        }
        long parseLong = Long.parseLong(map.get(Utils.KEY_BUSINESS_ID));
        if (!TextUtils.isEmpty(map.get("exit")) && (eVar = this.f251347q) != null) {
            eVar.C8(true);
        }
        i iVar = new i();
        iVar.f251159g = (short) 0;
        iVar.f251155c = false;
        iVar.f251153a = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        iVar.f251156d = j3;
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, notify has exit!, fid = " + parseLong + ", msg = " + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        concurrentHashMap.put(Long.valueOf(parseLong), iVar);
        this.f251331a.d(this.f251340j, j3, parseLong, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
    }

    private void G(long j3, ConcurrentHashMap<Long, i> concurrentHashMap, Map<String, String> map) {
        if (f()) {
            f.C("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
        } else {
            long parseLong = Long.parseLong(map.get(Utils.KEY_BUSINESS_ID));
            K0(j3, concurrentHashMap, parseLong, C(parseLong, 1));
        }
    }

    private boolean H(long j3, ConcurrentHashMap<Long, i> concurrentHashMap, Map<String, String> map) {
        if (MsgBackupManager.Q) {
            return false;
        }
        long parseLong = Long.parseLong(map.get(Utils.KEY_BUSINESS_ID));
        i iVar = new i();
        iVar.f251159g = (short) 0;
        iVar.f251155c = false;
        iVar.f251153a = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        iVar.f251156d = j3;
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, postinfo ui is not ready!" + parseLong + ", msg = " + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        concurrentHashMap.put(Long.valueOf(parseLong), iVar);
        this.f251331a.d(this.f251340j, j3, parseLong, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        return true;
    }

    private void I(long j3, ConcurrentHashMap<Long, i> concurrentHashMap, Map<String, String> map) {
        if (f()) {
            f.C("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
            return;
        }
        long parseLong = Long.parseLong(map.get(Utils.KEY_BUSINESS_ID));
        if (r() != 0) {
            L0(map.get("ip"));
            N0(Integer.parseInt(map.get("udpport")));
        }
        if (q() != 0) {
            L0(map.get("ip"));
            M0(Integer.parseInt(map.get("tcpport")));
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, client report its port and ipv4, fid = " + parseLong + ", msg = []");
        }
        K0(j3, concurrentHashMap, parseLong, C(parseLong, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit K(String str, long j3, int i3, ConcurrentHashMap concurrentHashMap) {
        h hVar = new h();
        hVar.f251147f = false;
        hVar.f251142a = str;
        hVar.f251145d = j3;
        hVar.f251143b = f.x(i3);
        concurrentHashMap.put(f.t(hVar.f251142a, i3), hVar);
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted  \u4f1a\u8bdd uin =" + str + ", uintype = " + hVar.f251143b + "\uff1amClientCanRecvMList.size = " + concurrentHashMap.size());
            return null;
        }
        return null;
    }

    private void K0(long j3, ConcurrentHashMap<Long, i> concurrentHashMap, long j16, String str) {
        i iVar = new i();
        iVar.f251159g = (short) 0;
        iVar.f251155c = false;
        iVar.f251153a = str;
        iVar.f251156d = j3;
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "sendPreparedSession  postinfo httpGetReached, client request server's already session, fid = " + j16 + ", msg = " + str);
        }
        concurrentHashMap.put(Long.valueOf(j16), iVar);
        this.f251331a.d(this.f251340j, j3, j16, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit L(String str, int i3, long j3, ConcurrentHashMap concurrentHashMap) {
        h hVar = new h();
        hVar.f251147f = false;
        hVar.f251142a = str;
        hVar.f251143b = f.x(i3);
        hVar.f251145d = j3;
        String t16 = f.t(hVar.f251142a, i3);
        if (concurrentHashMap.get(t16) == null) {
            concurrentHashMap.put(t16, hVar);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted  \u4f1a\u8bdd uin =" + str + ", uintype = " + hVar.f251143b + "\uff1amClientCanRecvMList= " + concurrentHashMap);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit M(String str, int i3, long j3, ConcurrentHashMap concurrentHashMap) {
        h hVar = new h();
        hVar.f251148g = false;
        hVar.f251147f = false;
        hVar.f251142a = str;
        hVar.f251143b = f.x(i3);
        hVar.f251145d = j3;
        String t16 = f.t(hVar.f251142a, i3);
        if (concurrentHashMap.get(t16) == null) {
            concurrentHashMap.put(t16, hVar);
            return null;
        }
        return null;
    }

    private void N(h hVar) {
        if (this.f251341k) {
            J0(258);
        } else {
            H0(this.f251340j, false, hVar.f251142a, hVar.f251143b);
        }
    }

    private void d0(String str) {
        try {
            ConcurrentHashMap<String, h> concurrentHashMap = MsgBackupManager.x().f251038b;
            JSONArray jSONArray = new JSONArray(str);
            int i3 = 0;
            if (jSONArray.length() >= 1) {
                for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i16);
                    jSONObject.optString("cmd");
                    String optString = jSONObject.optString("chatUin");
                    int optInt = jSONObject.optInt("chatType");
                    String t16 = f.t(optString, optInt);
                    h hVar = concurrentHashMap.get(t16);
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "client notify this session has received success! keyFromUin = " + t16 + ", mMList = " + concurrentHashMap);
                    }
                    if (hVar != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "udp \u901a\u77e5 \u6b64\u4f1a\u8bdd\u63a5\u53d7\u5b8c\u6210 chatUin = " + optString + ", uinType = " + f.x(optInt));
                        }
                        hVar.f251148g = true;
                    } else if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "client notify this session has received success! chatUin = " + optString + ", chatType = " + optInt);
                    }
                }
            }
            synchronized (this.f251345o) {
                Iterator<h> it = concurrentHashMap.values().iterator();
                while (it.hasNext()) {
                    if (it.next().f251148g) {
                        i3++;
                    }
                }
            }
            com.tencent.mobileqq.msgbackup.controller.e eVar = this.f251347q;
            if (eVar != null) {
                eVar.hd(i3, MsgBackupManager.K);
            }
        } catch (JSONException e16) {
            QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "MBR_UDP_CMD_SYNC_RECV_DONE parse json error!", e16);
        }
    }

    private void e0(long j3, i iVar, ConcurrentHashMap<String, h> concurrentHashMap, h hVar, ConcurrentHashMap<Long, i> concurrentHashMap2) {
        if (iVar.f251159g > 3 && this.f251342l) {
            f0(j3, iVar, concurrentHashMap, hVar, concurrentHashMap2);
        } else if (f()) {
            f.C("recvFile panic error! dbMList receivedCompleted", new Object[0]);
        } else {
            iVar.f251159g = (short) (iVar.f251159g + 1);
            this.f251331a.b(this.f251340j, j3, iVar.f251158f, iVar.f251157e, iVar.f251160h, iVar.f251161i, false);
        }
    }

    private void f0(long j3, i iVar, ConcurrentHashMap<String, h> concurrentHashMap, h hVar, ConcurrentHashMap<Long, i> concurrentHashMap2) {
        int i3;
        MsgBackupManager.I++;
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "MsgBackup_Manager skipSessionCount = " + MsgBackupManager.I);
        concurrentHashMap2.remove(Long.valueOf(j3));
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "isTcpDetected = " + this.f251342l + ", \u6b64\u4f1a\u8bdddb\u4e00\u76f4\u5931\u8d25\uff0c\u6254\u6389\uff0c\u901a\u77e5\u5bf9\u7aefdbMList receivedCompleted retry over time task = " + iVar);
        hVar.f251148g = true;
        N(hVar);
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup", 2, "getdb failed !  mclient will get db mClientCanRecvMList.size = " + concurrentHashMap.size());
        }
        synchronized (this.f251345o) {
            Iterator<h> it = concurrentHashMap.values().iterator();
            i3 = 0;
            while (it.hasNext()) {
                if (it.next().f251148g) {
                    i3++;
                }
            }
        }
        com.tencent.mobileqq.msgbackup.controller.e eVar = this.f251347q;
        if (eVar != null) {
            eVar.hd(i3, MsgBackupManager.K);
        }
        if (i3 != MsgBackupManager.K && !G0(2)) {
            f.C("this session db has received error! so get next session!", new Object[0]);
            I0(3);
        }
    }

    private void g0(long j3, int i3, String str, i iVar, ConcurrentHashMap<String, h> concurrentHashMap, h hVar, ConcurrentHashMap<Long, i> concurrentHashMap2, ConcurrentHashMap<Long, i> concurrentHashMap3) {
        if (i3 == 0) {
            i0(j3, str, concurrentHashMap2, concurrentHashMap3);
        } else {
            h0(j3, i3, iVar, concurrentHashMap, hVar, concurrentHashMap2);
        }
    }

    private void h0(long j3, int i3, i iVar, ConcurrentHashMap<String, h> concurrentHashMap, h hVar, ConcurrentHashMap<Long, i> concurrentHashMap2) {
        if (iVar.f251155c) {
            com.tencent.mobileqq.msgbackup.util.d.b();
            com.tencent.mobileqq.msgbackup.util.c cVar = com.tencent.mobileqq.msgbackup.util.d.f251402a;
            cVar.f251389s++;
            cVar.f251395y++;
            c.a aVar = new c.a();
            aVar.f251398b = 1;
            aVar.f251399c = 0;
            aVar.f251397a = i3;
            com.tencent.mobileqq.msgbackup.util.d.f251402a.f251396z.add(aVar);
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "dbMList receivedCompleted  called not success, so again task = " + iVar);
            if (!TextUtils.isEmpty(iVar.f251157e) && !TextUtils.isEmpty(iVar.f251158f)) {
                e0(j3, iVar, concurrentHashMap, hVar, concurrentHashMap2);
            }
        }
    }

    private void i0(long j3, String str, ConcurrentHashMap<Long, i> concurrentHashMap, ConcurrentHashMap<Long, i> concurrentHashMap2) {
        concurrentHashMap.remove(Long.valueOf(j3));
        if (str.endsWith(DBBackupServiceImpl.DB_FILE_SUFFIX)) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "receivedCompleted db success, path = " + str + ", dbMList.size = " + concurrentHashMap.size() + ", resMList.size = " + concurrentHashMap2.size());
            String substring = str.substring(str.lastIndexOf("/") + 1);
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted db success, dbName = " + substring);
            }
            com.tencent.mobileqq.msgbackup.controller.i iVar = new com.tencent.mobileqq.msgbackup.controller.i();
            iVar.f251074b = 1;
            iVar.f251081i = str;
            MsgBackupManager.x().V(iVar);
        }
    }

    private void j0(long j3, String str, ConcurrentHashMap<Long, i> concurrentHashMap, ConcurrentHashMap<String, h> concurrentHashMap2) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached success, url = " + str);
        }
        int i3 = 0;
        if (f()) {
            f.C("getmsg onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.f251344n);
        if (this.f251347q != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        objArr[1] = Boolean.valueOf(z16);
        f.B("MsgBackup_MsgBackupTransportProcessor", "getmsg isTransportStart = %b, mCallBack is not null = %b", objArr);
        com.tencent.mobileqq.msgbackup.controller.e eVar = this.f251347q;
        if (eVar != null && !this.f251344n) {
            this.f251344n = true;
            eVar.cb(true);
        }
        Map<String, String> F = f.F(str);
        long parseLong = Long.parseLong(F.get(Utils.KEY_BUSINESS_ID));
        if (!MsgBackupManager.Q) {
            i iVar = new i();
            iVar.f251159g = (short) 0;
            iVar.f251155c = false;
            iVar.f251153a = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            iVar.f251156d = j3;
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached, getmsg ui is not ready!" + parseLong + ", msg = " + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            concurrentHashMap.put(Long.valueOf(parseLong), iVar);
            this.f251331a.d(this.f251340j, j3, parseLong, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        c.b bVar = new c.b();
        bVar.f251400a = false;
        bVar.f251401b = 0L;
        MsgBackupManager.x().f251041e.put(Long.valueOf(parseLong), bVar);
        String str2 = F.get("chatUin");
        int parseInt = Integer.parseInt(F.get("chatType"));
        String s16 = f.s(str2, parseInt, null);
        i iVar2 = new i();
        iVar2.f251159g = (short) 0;
        iVar2.f251155c = true;
        iVar2.f251156d = j3;
        iVar2.f251157e = s16;
        concurrentHashMap.put(Long.valueOf(parseLong), iVar2);
        synchronized (this.f251345o) {
            Iterator<h> it = concurrentHashMap2.values().iterator();
            while (it.hasNext()) {
                if (it.next().f251148g) {
                    i3++;
                }
            }
        }
        com.tencent.mobileqq.msgbackup.controller.e eVar2 = this.f251347q;
        if (eVar2 != null) {
            eVar2.hd(i3, MsgBackupManager.K);
        }
        this.f251331a.e(this.f251340j, j3, parseLong, s16);
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onHttpRequest, send db uin = " + str2 + ", uinType = " + f.x(parseInt) + ", dbpath = " + s16 + ", fid = " + parseLong + ", mFidMList.size = " + concurrentHashMap.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f251331a.stop(this.f251340j);
        this.f251331a.destroySession(this.f251340j);
        this.f251340j = 0L;
        a.b().c();
    }

    private void k0(long j3, String str, ConcurrentHashMap<Long, i> concurrentHashMap) {
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached success, url = " + str);
        }
        if (f()) {
            f.C("getres onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
            return;
        }
        com.tencent.mobileqq.msgbackup.util.c cVar = com.tencent.mobileqq.msgbackup.util.d.f251402a;
        cVar.f251379i++;
        cVar.f251382l++;
        Map<String, String> F = f.F(str);
        long parseLong = Long.parseLong(F.get(Utils.KEY_BUSINESS_ID));
        String str2 = F.get("filepath");
        f.C("res url parse fid = %d,filepath = %s", Long.valueOf(parseLong), str2);
        if (f.f251423c) {
            str2 = Uri.decode(str2);
        }
        f.C("res url parse fid = %d,filepath = %s", Long.valueOf(parseLong), str2);
        c.b bVar = new c.b();
        bVar.f251400a = false;
        bVar.f251401b = 0L;
        MsgBackupManager.x().f251042f.put(Long.valueOf(parseLong), bVar);
        i iVar = new i();
        iVar.f251159g = (short) 0;
        iVar.f251155c = true;
        iVar.f251157e = f.w(str2);
        iVar.f251156d = j3;
        concurrentHashMap.put(Long.valueOf(parseLong), iVar);
        this.f251331a.e(this.f251340j, j3, parseLong, iVar.f251157e);
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onHttpRequest, send res file, fileRes path = " + iVar.f251157e + ", mFidMList.size = " + concurrentHashMap.size());
        }
    }

    private void l0(long j3, String str) {
        if (f()) {
            f.C("http get reached! but can not understand this request! session is valid........", new Object[0]);
            return;
        }
        String str2 = f.F(str).get(Utils.KEY_BUSINESS_ID);
        if (!TextUtils.isEmpty(str2)) {
            long parseLong = Long.parseLong(str2);
            f.C("http get reached! but can not understand this request! session is valid........", new Object[0]);
            this.f251331a.refuseFileRequest(this.f251340j, j3, parseLong, "404");
        }
    }

    private void m0(long j3, String str, ConcurrentHashMap<Long, i> concurrentHashMap, ConcurrentHashMap<String, h> concurrentHashMap2) {
        if (f()) {
            f.C("httpGetReached postinfo operator is closed! please clear handler msg!........", new Object[0]);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "httpGetReached success, url = " + str);
        }
        Map<String, String> F = f.F(str);
        if (H(j3, concurrentHashMap, F)) {
            return;
        }
        if (F.size() == 1) {
            G(j3, concurrentHashMap, F);
            return;
        }
        if (!TextUtils.isEmpty(F.get("exit"))) {
            F(j3, concurrentHashMap, F);
        } else if (F.size() == 4) {
            I(j3, concurrentHashMap, F);
        } else {
            E(j3, concurrentHashMap, concurrentHashMap2, F);
        }
    }

    private void n0(long j3, ConcurrentHashMap<Long, i> concurrentHashMap, i iVar) {
        if (iVar.f251155c) {
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "mfidMlist fileTask receivedCompleted  called not success, so again task = " + iVar);
            }
            if (!TextUtils.isEmpty(iVar.f251157e) && !TextUtils.isEmpty(iVar.f251158f)) {
                if (iVar.f251159g > 3) {
                    concurrentHashMap.remove(Long.valueOf(j3));
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " mfidMlist fileTask receivedCompleted retry over time task = " + iVar);
                    return;
                }
                if (f()) {
                    f.C("recvFile panic error! mfidMlist fileTask receivedCompleted", new Object[0]);
                    return;
                } else {
                    iVar.f251159g = (short) (iVar.f251159g + 1);
                    this.f251331a.b(this.f251340j, j3, iVar.f251158f, iVar.f251157e, iVar.f251160h, iVar.f251161i, true);
                    return;
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted mfidMlist called not success, so again task = " + iVar);
        }
        if (!TextUtils.isEmpty(iVar.f251158f)) {
            if (iVar.f251159g > 3) {
                concurrentHashMap.remove(Long.valueOf(j3));
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted mfidMlist retry over time task = " + iVar);
                return;
            }
            if (f()) {
                f.C("receivedCompleted mfidMlist  operator is closed! please clear handler msg!........", new Object[0]);
            } else {
                iVar.f251159g = (short) (iVar.f251159g + 1);
                this.f251331a.c(this.f251340j, j3, iVar.f251158f);
            }
        }
    }

    private void o0(long j3, String str, int i3, String str2, byte[] bArr, long j16, ConcurrentHashMap<Long, i> concurrentHashMap, ConcurrentHashMap<String, h> concurrentHashMap2) {
        concurrentHashMap.remove(Long.valueOf(j3));
        if (this.f251331a != null && TextUtils.isEmpty(str2)) {
            if (f()) {
                f.C("getRecvBuffer called operator is closed! please clear handler msg!........", new Object[0]);
                return;
            }
            String w3 = w(bArr);
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "processNormalRsp recvBuf is " + w3);
            r0(j3, str, i3, j16, concurrentHashMap2, w3);
        }
    }

    private void p0(final ConcurrentHashMap<String, h> concurrentHashMap, JSONArray jSONArray) throws JSONException {
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
            if ("chat_ready".equals(jSONObject.optString("cmd"))) {
                final String optString = jSONObject.optString("chatUin");
                final int optInt = jSONObject.optInt("chatType");
                final long optLong = jSONObject.optLong("dbSize");
                e.a(optString, optInt, concurrentHashMap, new Function0() { // from class: com.tencent.mobileqq.msgbackup.transport.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit K;
                        K = MsgBackupTransportProcessor.K(optString, optLong, optInt, concurrentHashMap);
                        return K;
                    }
                });
            }
        }
        G0(4);
    }

    private void q0(final ConcurrentHashMap<String, h> concurrentHashMap, JSONArray jSONArray, JSONObject jSONObject) throws JSONException {
        MsgBackupManager.K = jSONObject.optInt("listCount");
        com.tencent.mobileqq.msgbackup.util.d.b();
        com.tencent.mobileqq.msgbackup.util.d.f251402a.f251377g = MsgBackupManager.K;
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted, \u4f1a\u8bdd\u603b\u4e2a\u6570\uff1aMsgBackupManager.sessionCount = " + MsgBackupManager.K);
        }
        for (int i3 = 1; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
            if ("chat_ready".equals(jSONObject2.optString("cmd"))) {
                final String optString = jSONObject2.optString("chatUin");
                final int optInt = jSONObject2.optInt("chatType");
                final long optLong = jSONObject2.optLong("dbSize");
                e.a(optString, optInt, concurrentHashMap, new Function0() { // from class: com.tencent.mobileqq.msgbackup.transport.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit L;
                        L = MsgBackupTransportProcessor.L(optString, optInt, optLong, concurrentHashMap);
                        return L;
                    }
                });
            }
        }
        G0(4);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x008b -> B:12:0x0091). Please report as a decompilation issue!!! */
    private void r0(long j3, String str, int i3, long j16, ConcurrentHashMap<String, h> concurrentHashMap, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted, fid = " + j3 + ", url = " + str + ", errCode = " + i3 + ", context = " + j16 + ", recvBuf = " + str2);
            }
            try {
                JSONArray jSONArray = new JSONArray(str2);
                if (jSONArray.length() > 0) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(0);
                    if ("chat_list_count".equals(jSONObject.optString("cmd"))) {
                        q0(concurrentHashMap, jSONArray, jSONObject);
                    } else {
                        p0(concurrentHashMap, jSONArray);
                    }
                } else {
                    int size = concurrentHashMap.size();
                    int i16 = MsgBackupManager.K;
                    if (size < i16 || i16 <= 0) {
                        f.C("client cache is deal completedly! so get next session!", new Object[0]);
                        I0(3);
                    }
                }
            } catch (JSONException e16) {
                QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted parse json error!", e16);
            }
        }
    }

    private int s(ConcurrentHashMap<String, h> concurrentHashMap) {
        Iterator<h> it = concurrentHashMap.values().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next().f251148g) {
                i3++;
            }
        }
        return i3;
    }

    private void s0(long j3, int i3, ConcurrentHashMap<String, h> concurrentHashMap, h hVar, ConcurrentHashMap<Long, i> concurrentHashMap2, ConcurrentHashMap<Long, i> concurrentHashMap3, i iVar) {
        if (iVar.f251155c) {
            com.tencent.mobileqq.msgbackup.util.d.b();
            com.tencent.mobileqq.msgbackup.util.c cVar = com.tencent.mobileqq.msgbackup.util.d.f251402a;
            cVar.f251383m++;
            cVar.f251395y++;
            c.a aVar = new c.a();
            if (MsgBackupManager.x().f251040d.contains(Long.valueOf(j3))) {
                com.tencent.mobileqq.msgbackup.util.d.f251402a.f251386p++;
                MsgBackupManager.x().f251040d.remove(Long.valueOf(j3));
                aVar.f251399c = 2;
            } else {
                aVar.f251399c = 1;
            }
            aVar.f251398b = 2;
            aVar.f251397a = i3;
            com.tencent.mobileqq.msgbackup.util.d.f251402a.f251396z.add(aVar);
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "resReq fileTask receivedCompleted  called not success, so again task retryTimes = " + ((int) iVar.f251159g) + " ,task.path = " + iVar.f251157e + " ,task.isFileTask = " + iVar.f251155c);
            if (!TextUtils.isEmpty(iVar.f251157e) && !TextUtils.isEmpty(iVar.f251158f)) {
                if (iVar.f251159g > 3 && this.f251342l) {
                    t0(j3, concurrentHashMap, hVar, concurrentHashMap2, concurrentHashMap3, iVar);
                } else if (f()) {
                    f.C("recvFile panic error! resReq fileTask receivedCompleted", new Object[0]);
                } else {
                    iVar.f251159g = (short) (iVar.f251159g + 1);
                    this.f251331a.b(this.f251340j, j3, iVar.f251158f, iVar.f251157e, iVar.f251160h, iVar.f251161i, true);
                }
            }
        }
    }

    private String t() {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", "exit");
            jSONObject.put(PreloadTRTCPlayerParams.KEY_SIG, com.tencent.mobileqq.msgbackup.authentication.a.d().f());
            jSONArray.mo162put(jSONObject);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONArray.toString();
    }

    private void t0(long j3, ConcurrentHashMap<String, h> concurrentHashMap, h hVar, ConcurrentHashMap<Long, i> concurrentHashMap2, ConcurrentHashMap<Long, i> concurrentHashMap3, i iVar) {
        int i3;
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "isTcpDetected = " + this.f251342l + ", isResRequestAllFinished" + hVar.f251149h.get() + ", resReq fileTask receivedCompleted retry over time task.path = " + iVar.f251157e + " ,task.isFileTask = " + iVar.f251155c + " ,task.retryTimes = " + ((int) iVar.f251159g));
        concurrentHashMap3.remove(Long.valueOf(j3));
        int size = concurrentHashMap3.size();
        int size2 = concurrentHashMap2.size();
        if (size == 0 && size2 == 0 && hVar.f251149h.get()) {
            hVar.f251148g = true;
            N(hVar);
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "last session transport completed!, uin = " + MsgBackupManager.L + ", uintype = " + MsgBackupManager.M + ", task = " + iVar);
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "mclient will get db mClientCanRecvMList.size = " + concurrentHashMap.size());
            }
            synchronized (this.f251345o) {
                Iterator<h> it = concurrentHashMap.values().iterator();
                i3 = 0;
                while (it.hasNext()) {
                    if (it.next().f251148g) {
                        i3++;
                    }
                }
            }
            com.tencent.mobileqq.msgbackup.controller.e eVar = this.f251347q;
            if (eVar != null) {
                eVar.hd(i3, MsgBackupManager.K);
            }
            if (i3 != MsgBackupManager.K && !G0(2)) {
                f.C("this session res has received! over time  so get next session!", new Object[0]);
                I0(3);
            }
        }
    }

    public static MsgBackupTransportProcessor u() {
        if (f251330r == null) {
            synchronized (MsgBackupTransportProcessor.class) {
                if (f251330r == null) {
                    f251330r = new MsgBackupTransportProcessor();
                }
            }
        }
        return f251330r;
    }

    private void u0(long j3, int i3, ConcurrentHashMap<String, h> concurrentHashMap, h hVar, ConcurrentHashMap<Long, i> concurrentHashMap2, ConcurrentHashMap<Long, i> concurrentHashMap3) {
        i iVar = concurrentHashMap3.get(Long.valueOf(j3));
        if (iVar != null) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "ResReq receivedCompleted  called  task.path = " + iVar.f251157e + " ,task.isFileTask = " + iVar.f251155c + " ,task.retryTimes = " + ((int) iVar.f251159g) + ", resMList.size = " + concurrentHashMap3.size() + ", errCode = " + i3);
            v0(j3, i3, concurrentHashMap, hVar, concurrentHashMap2, concurrentHashMap3, iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MsgBackupJniProxy v(Context context) {
        if (this.f251331a == null) {
            this.f251331a = new MsgBackupJniProxy(context);
        }
        return this.f251331a;
    }

    private void v0(long j3, int i3, ConcurrentHashMap<String, h> concurrentHashMap, h hVar, ConcurrentHashMap<Long, i> concurrentHashMap2, ConcurrentHashMap<Long, i> concurrentHashMap3, i iVar) {
        if (i3 == 0) {
            w0(j3, concurrentHashMap, hVar, concurrentHashMap2, concurrentHashMap3, iVar);
        } else {
            s0(j3, i3, concurrentHashMap, hVar, concurrentHashMap2, concurrentHashMap3, iVar);
        }
    }

    private String w(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            return new String(bArr, "utf-8");
        } catch (Exception unused) {
            f.B("MsgBackup", "receivedCompleted String byte transport string error!!!", new Object[0]);
            return "";
        }
    }

    private void w0(long j3, ConcurrentHashMap<String, h> concurrentHashMap, h hVar, ConcurrentHashMap<Long, i> concurrentHashMap2, ConcurrentHashMap<Long, i> concurrentHashMap3, i iVar) {
        int i3;
        concurrentHashMap3.remove(Long.valueOf(j3));
        int size = concurrentHashMap3.size();
        int size2 = concurrentHashMap2.size();
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "ResReq receivedCompleted  called success, isResRequestAllFinished " + hVar.f251149h.get() + ", task = " + iVar + ", resMList.size = " + size);
        }
        if (size == 0 && size2 == 0 && hVar.f251149h.get()) {
            hVar.f251148g = true;
            N(hVar);
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "last session transport completed!, uin = " + MsgBackupManager.L + ", uintype = " + MsgBackupManager.M + ", task = " + iVar);
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup", 2, "mclient will get db mClientCanRecvMList.size = " + concurrentHashMap.size());
            }
            synchronized (this.f251345o) {
                Iterator<h> it = concurrentHashMap.values().iterator();
                i3 = 0;
                while (it.hasNext()) {
                    if (it.next().f251148g) {
                        i3++;
                    }
                }
            }
            com.tencent.mobileqq.msgbackup.controller.e eVar = this.f251347q;
            if (eVar != null) {
                eVar.hd(i3, MsgBackupManager.K);
            }
            if (i3 != MsgBackupManager.K && !G0(2)) {
                f.C("this session res has received! so get next session!", new Object[0]);
                I0(3);
            }
        }
    }

    private void x0(String str) {
        com.tencent.mobileqq.msgbackup.controller.e eVar;
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 1) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(0);
                if ("exit".equals(jSONObject.optString("cmd"))) {
                    String optString = jSONObject.optString(PreloadTRTCPlayerParams.KEY_SIG);
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "-------------------exit-------------------");
                    }
                    if (TextUtils.equals(optString, com.tencent.mobileqq.msgbackup.authentication.a.d().f()) && (eVar = this.f251347q) != null) {
                        eVar.C8(true);
                    }
                }
            }
        } catch (JSONException e16) {
            QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "MBR_UDP_CMD_EXIT parse json error!", e16);
        }
    }

    private void y0(String str) {
        try {
            final ConcurrentHashMap<String, h> concurrentHashMap = MsgBackupManager.x().f251039c;
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() >= 1) {
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                    String optString = jSONObject.optString("cmd");
                    if ("chat_list_count".equals(optString)) {
                        MsgBackupManager.K = jSONObject.optInt("listCount");
                        com.tencent.mobileqq.msgbackup.util.d.b();
                        com.tencent.mobileqq.msgbackup.util.d.f251402a.f251377g = MsgBackupManager.K;
                    }
                    if ("chat_ready".equals(optString)) {
                        final String optString2 = jSONObject.optString("chatUin");
                        final int optInt = jSONObject.optInt("chatType");
                        final long optLong = jSONObject.optLong("dbSize");
                        e.a(optString2, optInt, concurrentHashMap, new Function0() { // from class: com.tencent.mobileqq.msgbackup.transport.c
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit M;
                                M = MsgBackupTransportProcessor.M(optString2, optInt, optLong, concurrentHashMap);
                                return M;
                            }
                        });
                    }
                }
                G0(3);
            }
        } catch (JSONException e16) {
            QLog.e("MsgBackup_MsgBackupTransportProcessor", 2, "MBR_UDP_CMD_SYNC_RECV_DONE parse json error!", e16);
        }
    }

    private void z0(long j3, String str, int i3, String str2, byte[] bArr, int i16, int i17, long j16) {
        String str3;
        if (f.f251422b) {
            str3 = f.g(str, y(), z(), this.f251336f);
        } else {
            str3 = str;
        }
        ConcurrentHashMap<Long, i> concurrentHashMap = MsgBackupManager.x().f251044h;
        i iVar = concurrentHashMap.get(Long.valueOf(j3));
        ConcurrentHashMap<String, h> concurrentHashMap2 = MsgBackupManager.x().f251039c;
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "receivedCompleted called! mfidMlist.size = " + concurrentHashMap.size() + ", mClientCanRecvMList.size = " + concurrentHashMap2.size() + ", path = " + str2 + ",url = " + str3 + ", fid = " + j3 + ",errorCode = " + i3 + ", task = " + iVar + "\uff0cmFidMList " + concurrentHashMap.toString() + ", MsgBackupManager.sessionCount = " + MsgBackupManager.K);
        if (iVar != null) {
            if (i3 == 0) {
                o0(j3, str3, i3, str2, bArr, j16, concurrentHashMap, concurrentHashMap2);
                return;
            } else {
                n0(j3, concurrentHashMap, iVar);
                return;
            }
        }
        String t16 = f.t(MsgBackupManager.L, f.q(MsgBackupManager.M));
        h hVar = concurrentHashMap2.get(t16);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "receivedCompleted key = " + t16 + ", mClientCanRecvMList = " + concurrentHashMap2 + ", sessionInfo = " + hVar + ", errCode = " + i3);
        if (hVar != null) {
            ConcurrentHashMap<Long, i> a16 = hVar.a();
            ConcurrentHashMap<Long, i> b16 = hVar.b();
            i iVar2 = a16.get(Long.valueOf(j3));
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "receivedCompleted  dbMList task = " + iVar2 + ", dbMList = " + a16.toString() + ". sessionInfo.hashcode = " + hVar.hashCode());
            }
            if (iVar2 != null) {
                g0(j3, i3, str2, iVar2, concurrentHashMap2, hVar, a16, b16);
            } else {
                u0(j3, i3, concurrentHashMap2, hVar, a16, b16);
            }
        }
    }

    public int A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "getServerUdpPort: " + this.f251335e.getUdpPort());
        return this.f251335e.getUdpPort();
    }

    public String B(int i3, long j3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (String) iPatchRedirector.redirect((short) 46, this, Integer.valueOf(i3), Long.valueOf(j3));
        }
        JSONArray jSONArray = new JSONArray();
        try {
            if (i3 != 256) {
                if (i3 == 257) {
                    if (!MsgBackupManager.Q) {
                        String jSONArray2 = jSONArray.toString();
                        ConcurrentHashMap<Long, i> concurrentHashMap = MsgBackupManager.x().f251043g;
                        i iVar = new i();
                        iVar.f251153a = jSONArray2;
                        iVar.f251154b = i3;
                        iVar.f251159g = (short) 0;
                        concurrentHashMap.put(Long.valueOf(j3), iVar);
                        if (QLog.isColorLevel()) {
                            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "MsgBackupManager.sUIReady = " + MsgBackupManager.Q + ", getSessionJson is called! cookie = " + j3 + ", msg = " + jSONArray2);
                        }
                        return jSONArray2;
                    }
                    ConcurrentHashMap<String, h> concurrentHashMap2 = MsgBackupManager.x().f251038b;
                    int i17 = MsgBackupManager.K;
                    if (concurrentHashMap2.size() > 0) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("cmd", "chat_list_count");
                        jSONObject.put("listCount", i17);
                        jSONArray.mo162put(jSONObject);
                        synchronized (this.f251345o) {
                            i16 = 0;
                            for (h hVar : concurrentHashMap2.values()) {
                                if (hVar.f251148g) {
                                    i16++;
                                }
                                if (!hVar.f251146e) {
                                    String str = hVar.f251142a;
                                    int i18 = hVar.f251143b;
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("cmd", "chat_ready");
                                    jSONObject2.put("chatUin", str);
                                    jSONObject2.put("chatType", f.q(i18));
                                    jSONObject2.put("dbSize", hVar.f251145d);
                                    jSONArray.mo162put(jSONObject2);
                                    hVar.f251146e = true;
                                }
                            }
                        }
                        com.tencent.mobileqq.msgbackup.controller.e eVar = this.f251347q;
                        if (eVar != null) {
                            eVar.hd(i16, MsgBackupManager.K);
                        }
                    }
                } else if (i3 == 258) {
                    for (h hVar2 : MsgBackupManager.x().f251039c.values()) {
                        if (!hVar2.f251150i && hVar2.f251148g) {
                            String str2 = hVar2.f251142a;
                            int i19 = hVar2.f251143b;
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("cmd", "chat_transfer_complete");
                            jSONObject3.put("chatUin", str2);
                            jSONObject3.put("chatType", f.q(i19));
                            jSONArray.mo162put(jSONObject3);
                            hVar2.f251150i = true;
                        }
                    }
                } else if (i3 == 259) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("cmd", "exit");
                    jSONObject4.put(PreloadTRTCPlayerParams.KEY_SIG, com.tencent.mobileqq.msgbackup.authentication.a.d().f());
                    jSONArray.mo162put(jSONObject4);
                }
            }
            String jSONArray3 = jSONArray.toString();
            ConcurrentHashMap<Long, i> concurrentHashMap3 = MsgBackupManager.x().f251043g;
            i iVar2 = new i();
            iVar2.f251153a = jSONArray3;
            iVar2.f251154b = i3;
            iVar2.f251159g = (short) 0;
            concurrentHashMap3.put(Long.valueOf(j3), iVar2);
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "getSessionJson, cookie = " + j3 + ", msg = " + jSONArray3);
            }
            return jSONArray3;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    protected void C0(ConcurrentHashMap<String, h> concurrentHashMap) {
        h hVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, (Object) concurrentHashMap);
            return;
        }
        if (!TextUtils.isEmpty(MsgBackupManager.L) && (hVar = concurrentHashMap.get(f.t(MsgBackupManager.L, f.q(MsgBackupManager.M)))) != null) {
            hVar.f251148g = true;
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "requestNextDb requestNextSessionDb MsgBackupController MsgBackupManager.curDealUin = " + MsgBackupManager.L + ", MsgBackupManager.curDealType = " + MsgBackupManager.M);
            N(hVar);
            if (this.f251347q != null) {
                int s16 = s(concurrentHashMap);
                com.tencent.mobileqq.msgbackup.controller.e eVar = this.f251347q;
                if (eVar != null) {
                    eVar.hd(s16, MsgBackupManager.K);
                }
                boolean z16 = MsgBackupManager.C;
            }
        }
    }

    protected boolean D0(ConcurrentHashMap<String, h> concurrentHashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return ((Boolean) iPatchRedirector.redirect((short) 56, (Object) this, (Object) concurrentHashMap)).booleanValue();
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, " requestNextDbBegin requestNextSessionDb !, last uin = " + MsgBackupManager.L + ", uintype = " + MsgBackupManager.M);
        Iterator<h> it = concurrentHashMap.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            h next = it.next();
            if (!next.f251147f) {
                if (next.f251145d <= 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextDbBegin !,  curDealUin  null! dbsize \u7b49\u4e8e 0 \uff01\u5ba2\u6237\u7aef\u4e0d\u4f1a\u53bb\u8bf7\u6c42\u4e86\uff0c\u53ea\u662f\u901a\u77e5server\u7aef\uff0c\u8be5\u4f1a\u8bdd\u5df2\u7ecf\u63a5\u53d7\u5b8c\u6210\u4e86\uff01uin = " + next.f251142a + ", uintype = " + next.f251143b + ", dbSize = " + next.f251145d);
                    }
                    next.f251148g = true;
                    next.f251147f = true;
                    N(next);
                    if (this.f251347q != null) {
                        int s16 = s(concurrentHashMap);
                        com.tencent.mobileqq.msgbackup.controller.e eVar = this.f251347q;
                        if (eVar != null && !this.f251344n) {
                            this.f251344n = true;
                            eVar.cb(true);
                        }
                        com.tencent.mobileqq.msgbackup.controller.e eVar2 = this.f251347q;
                        if (eVar2 != null) {
                            eVar2.hd(s16, MsgBackupManager.K);
                        }
                        if (s16 == MsgBackupManager.K && this.f251347q != null) {
                            f.B("MsgBackup_MsgBackupTransportProcessor", "session transport completed! dbSize is 0------------->", new Object[0]);
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    next.f251147f = true;
                    MsgBackupManager.L = next.f251142a;
                    MsgBackupManager.M = next.f251143b;
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextDbBegin !, uin = " + MsgBackupManager.L + ", uintype = " + MsgBackupManager.M + ", dbsize = " + next.f251145d);
                    }
                    int s17 = s(concurrentHashMap);
                    com.tencent.mobileqq.msgbackup.controller.e eVar3 = this.f251347q;
                    if (eVar3 != null && !this.f251344n) {
                        this.f251344n = true;
                        eVar3.cb(true);
                    }
                    com.tencent.mobileqq.msgbackup.controller.e eVar4 = this.f251347q;
                    if (eVar4 != null) {
                        eVar4.hd(s17, MsgBackupManager.K);
                    }
                    if (s17 == MsgBackupManager.K) {
                        f.B("MsgBackup_MsgBackupTransportProcessor", "session transport completed!------------->", new Object[0]);
                    } else {
                        B0(this.f251340j, next.f251142a, next.f251143b, false);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    protected boolean F0(ConcurrentHashMap<String, h> concurrentHashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Boolean) iPatchRedirector.redirect((short) 55, (Object) this, (Object) concurrentHashMap)).booleanValue();
        }
        h hVar = concurrentHashMap.get(f.t(MsgBackupManager.L, f.q(MsgBackupManager.M)));
        if (hVar == null) {
            return false;
        }
        if (hVar.f251148g) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, " requestNextDbTry requestNextSessionDb !, last uin = " + MsgBackupManager.L + ", uintype = " + MsgBackupManager.M);
            return E0(concurrentHashMap, false);
        }
        if (!QLog.isColorLevel()) {
            return false;
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "current session not completed! requestNextSessionDb !, current uin = " + MsgBackupManager.L + ", uintype = " + MsgBackupManager.M);
        return false;
    }

    public synchronized boolean G0(int i3) {
        boolean D0;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Boolean) iPatchRedirector.redirect((short) 54, (Object) this, i3)).booleanValue();
        }
        if (!this.f251342l && i3 == 3) {
            this.f251343m = true;
            f.B("MsgBackup_MsgBackupTransportProcessor", "requestNextSessionDb tcp is disconnect!", new Object[0]);
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " requestNextSessionDb !, from = " + i3);
        }
        ConcurrentHashMap<String, h> concurrentHashMap = MsgBackupManager.x().f251039c;
        if (i3 == 1 || i3 == 6) {
            C0(concurrentHashMap);
        }
        if (!TextUtils.isEmpty(MsgBackupManager.L)) {
            D0 = F0(concurrentHashMap);
        } else {
            D0 = D0(concurrentHashMap);
        }
        if (concurrentHashMap.size() == 0 || TextUtils.isEmpty(MsgBackupManager.L)) {
            I0(5);
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNextSessionDb called with warning step1");
            }
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "requestNextSessionDb called with from = " + i3 + ", ret = " + D0 + ", sessionCount = " + MsgBackupManager.K);
        return D0;
    }

    public void H0(long j3, boolean z16, String str, int i3) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, this, Long.valueOf(j3), Boolean.valueOf(z16), str, Integer.valueOf(i3));
            return;
        }
        if (z() != 0 && A() != 0) {
            if (this.f251333c == 1 && this.f251342l) {
                if (f()) {
                    f.C("requestNotifyServer called------>MBRROLE_CLIENT  operator is closed! please clear handler msg!........", new Object[0]);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNotifyServer, isTcpDetected = " + this.f251342l);
                }
                long y16 = f.y();
                if (!TextUtils.isEmpty(str)) {
                    String str3 = "postinfo?fid=" + y16 + "&chatUin=" + str + "&chatType=" + f.q(i3);
                    f.B("MsgBackup_MsgBackupTransportProcessor", str3, new Object[0]);
                    str2 = f.z(y(), z()) + f.n(str3, this.f251336f);
                } else if (z16) {
                    String str4 = "postinfo?fid=" + y16 + "&ip=" + p() + "&tcpport=" + q() + "&udpport=" + r();
                    f.B("MsgBackup_MsgBackupTransportProcessor", str4, new Object[0]);
                    str2 = f.z(y(), z()) + f.n(str4, this.f251336f);
                } else {
                    String str5 = "postinfo?fid=" + y16;
                    f.B("MsgBackup_MsgBackupTransportProcessor", str5, new Object[0]);
                    str2 = f.z(y(), z()) + f.n(str5, this.f251336f);
                }
                String str6 = str2;
                if (!TextUtils.isEmpty(str6) && this.f251331a != null) {
                    i iVar = new i();
                    iVar.f251159g = (short) 0;
                    iVar.f251155c = false;
                    iVar.f251158f = str6;
                    MsgBackupManager.x().f251044h.put(Long.valueOf(y16), iVar);
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "requestNotifyServer fid = " + y16 + ", url = " + str6);
                    this.f251331a.c(j3, y16, str6);
                    return;
                }
                return;
            }
            f.B("MsgBackup_MsgBackupTransportProcessor", "requestNotifyServer is called error!", new Object[0]);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNotifyServer server ip and port is not set! this method will be called in processConfirmRsp!");
        }
    }

    public void I0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, i3);
            return;
        }
        if (z() != 0 && A() != 0) {
            if (this.f251333c == 1 && this.f251342l) {
                if (f()) {
                    f.C("requestSessionList called------>MBRROLE_CLIENT  operator is closed! please clear handler msg!........", new Object[0]);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestSessionList is called! isTcpDetected = " + this.f251342l + ", from = " + i3);
                }
                if (!this.f251337g) {
                    this.f251337g = true;
                    H0(this.f251340j, true, "", 0);
                }
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "requestSessionList, isTcpDetected = " + this.f251342l + ", client will get ready session list from server------>");
                long y16 = f.y();
                String z16 = f.z(y(), z());
                String str = "postinfo?fid=" + y16;
                f.B("MsgBackup_MsgBackupTransportProcessor", str, new Object[0]);
                String str2 = z16 + f.n(str, this.f251336f);
                if (!TextUtils.isEmpty(str2) && this.f251331a != null) {
                    i iVar = new i();
                    iVar.f251155c = false;
                    iVar.f251159g = (short) 0;
                    iVar.f251158f = str2;
                    MsgBackupManager.x().f251044h.put(Long.valueOf(y16), iVar);
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestSessionList fid = " + y16 + ", url = " + str2);
                    }
                    this.f251331a.c(this.f251340j, y16, str2);
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "requestNotifyServer server ip and port is not set! this method will be called in processConfirmRsp!");
        }
    }

    public boolean J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        return this.f251342l;
    }

    public void J0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, i3);
            return;
        }
        if (this.f251331a != null) {
            if (this.f251341k) {
                if (f()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "sendMessageUdp panic error!");
                        return;
                    }
                    return;
                }
                long y16 = f.y();
                this.f251331a.f(this.f251340j, i3, B(i3, y16), y16);
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "sendMessageUdp udpdetected = " + this.f251341k + ", cmd = " + i3 + ", cookieIndex = " + y16);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "sendMessageUdp is error! please use tcp get! udpdetected = " + this.f251341k + ", cmd = " + i3);
            }
        }
    }

    public void L0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "setClientIP " + this.f251334d.getIpArray());
        if (this.f251334d.getIpArray() != null) {
            List<String> ipArray = this.f251334d.getIpArray();
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "tempList.size: " + ipArray.size());
            if (ipArray.size() > 0) {
                ipArray.set(0, str);
            } else {
                ipArray.add(str);
            }
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "setClientIP: " + ipArray.get(0));
        }
    }

    public void M0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
            return;
        }
        this.f251334d.setTcpPort(i3);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "setClientTcpPort: " + this.f251334d.getTcpPort());
    }

    public void N0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        this.f251334d.setUdpPort(i3);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "setClientUdpPort: " + this.f251334d.getUdpPort());
    }

    public void O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onDestroy called! operator = " + this.f251340j);
        }
        g();
        this.f251334d.getIpArray().clear();
        this.f251335e.getIpArray().clear();
        X0(2);
    }

    public void O0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
            return;
        }
        if (f()) {
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setEncryptKey panic error!");
                return;
            }
            return;
        }
        if (this.f251331a != null) {
            if (i3 == 2) {
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setEncryptKey start for MBRROLE_SERVER");
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setEncryptKey start for MBRROLE_CLIENT");
            }
            this.f251331a.g(this.f251340j, this.f251336f);
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setEncryptKey end\uff0c session = " + this.f251340j + ", encryptkey = " + this.f251336f);
            }
        }
    }

    public void P(long j3, String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, Long.valueOf(j3), str, Integer.valueOf(i3), str2);
        } else if (this.f251333c == 2) {
            D(j3, str, i3, str2);
        }
    }

    public void P0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        } else {
            this.f251336f = str;
        }
    }

    public void Q(long j3, String str, int i3, String str2, byte[] bArr, int i16, int i17, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, Long.valueOf(j3), str, Integer.valueOf(i3), str2, bArr, Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "onRecvComplete from jni fid = " + j3 + ",url = " + str + ",errcode = " + i3 + ",path = " + str2);
        }
        com.tencent.mobileqq.msgbackup.util.e.a(j3);
        z0(j3, str, i3, str2, bArr, i16, i17, j16);
    }

    public void Q0(com.tencent.mobileqq.msgbackup.controller.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) eVar);
        } else {
            this.f251347q = eVar;
        }
    }

    public void R(String str, int i3, int i16, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, Long.valueOf(j3));
        } else {
            A0(str, i3, i16, str2, j3);
        }
    }

    public void R0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
            return;
        }
        if (f()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint start panic error!");
            return;
        }
        if (this.f251331a != null) {
            int i16 = 0;
            if (i3 == 2) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint start for MBRROLE_SERVER");
                if (this.f251334d.getIpArray() != null && this.f251334d.getIpArray().size() > 0) {
                    String[] strArr = new String[this.f251334d.getIpArray().toArray().length];
                    while (i16 < this.f251334d.getIpArray().toArray().length) {
                        strArr[i16] = (String) this.f251334d.getIpArray().toArray()[i16];
                        i16++;
                    }
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint clientIP = " + p() + ", clientUdpPort = " + r() + ", clientTcpPort = " + q() + ", operator" + this.f251340j);
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint serverIP = " + y() + ", serverUdpPort = " + A() + ", serverTcpPort = " + z() + ", operator" + this.f251340j);
                    this.f251331a.setPeerEndpoint(this.f251340j, strArr, r(), q());
                } else {
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "setPeekPoint clientStartWrapperResult failed");
                }
            } else {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint start for MBRROLE_CLIENT");
                if (this.f251335e.getIpArray() != null && this.f251335e.getIpArray().size() > 0) {
                    String[] strArr2 = new String[this.f251335e.getIpArray().toArray().length];
                    while (i16 < this.f251335e.getIpArray().toArray().length) {
                        strArr2[i16] = (String) this.f251335e.getIpArray().toArray()[i16];
                        i16++;
                    }
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint clientIP = " + p() + ", clientUdpPort = " + r() + ", clientTcpPort = " + q() + ", operator" + this.f251340j);
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint serverIP = " + y() + ", serverUdpPort = " + A() + ", serverTcpPort = " + z() + ", operator" + this.f251340j);
                    this.f251331a.setPeerEndpoint(this.f251340j, strArr2, A(), z());
                } else {
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "setPeekPoint serverStartWrapperResult failed");
                }
            }
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "setPeekPoint end\uff0c operator = " + this.f251340j);
        }
    }

    public void S(long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            return;
        }
        com.tencent.mobileqq.msgbackup.util.e.h(j3, j16);
        if (this.f251338h > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f251338h;
            if (elapsedRealtime > 1500) {
                long j18 = j17 + this.f251339i;
                com.tencent.mobileqq.msgbackup.controller.e eVar = this.f251347q;
                if (eVar != null) {
                    long j19 = (j18 * 1000) / elapsedRealtime;
                    eVar.K8(j19);
                    com.tencent.mobileqq.msgbackup.util.e.i(j3, j19);
                }
                this.f251339i = 0L;
                this.f251338h = SystemClock.elapsedRealtime();
                return;
            }
            this.f251339i += j17;
            return;
        }
        this.f251338h = SystemClock.elapsedRealtime();
        this.f251339i += j17;
    }

    public void S0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "setServerIP " + this.f251335e.getIpArray());
        if (this.f251335e.getIpArray() != null) {
            List<String> ipArray = this.f251335e.getIpArray();
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "tempList.size: " + ipArray.size());
            if (ipArray.size() > 0) {
                ipArray.set(0, str);
            } else {
                ipArray.add(str);
            }
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "setServerIP: " + ipArray.get(0));
        }
    }

    public void T(long j3, String str, long j16, long j17, long j18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, Long.valueOf(j3), str, Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18));
        }
    }

    public void T0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        this.f251335e.setTcpPort(i3);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "setServerTcpPort: " + this.f251335e.getTcpPort());
    }

    public void U(long j3, boolean z16, int i3, String str, int i16, int i17, long j16) {
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, this, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j16));
            return;
        }
        com.tencent.mobileqq.msgbackup.util.e.a(j3);
        com.tencent.mobileqq.msgbackup.util.d.b();
        if (MsgBackupManager.x().f251042f.containsKey(Long.valueOf(j3))) {
            c.b bVar = MsgBackupManager.x().f251042f.get(Long.valueOf(j3));
            if (bVar != null) {
                boolean A = f.A(bVar.f251401b);
                if (A) {
                    com.tencent.mobileqq.msgbackup.util.d.f251402a.f251385o++;
                }
                if (!z16) {
                    com.tencent.mobileqq.msgbackup.util.d.f251402a.f251395y++;
                    c.a aVar = new c.a();
                    aVar.f251398b = 2;
                    if (A) {
                        i18 = 2;
                    } else {
                        i18 = 1;
                    }
                    aVar.f251399c = i18;
                    aVar.f251397a = i3;
                    com.tencent.mobileqq.msgbackup.util.d.f251402a.f251396z.add(aVar);
                    if (A) {
                        com.tencent.mobileqq.msgbackup.util.d.f251402a.f251386p++;
                    }
                }
            }
            MsgBackupManager.x().f251042f.remove(Long.valueOf(j3));
        } else if (MsgBackupManager.x().f251041e.containsKey(Long.valueOf(j3))) {
            if (MsgBackupManager.x().f251041e.get(Long.valueOf(j3)) != null) {
                com.tencent.mobileqq.msgbackup.util.c cVar = com.tencent.mobileqq.msgbackup.util.d.f251402a;
                cVar.f251388r++;
                if (!z16) {
                    cVar.f251389s++;
                    cVar.f251395y++;
                    c.a aVar2 = new c.a();
                    aVar2.f251398b = 1;
                    aVar2.f251399c = 0;
                    aVar2.f251397a = i3;
                    com.tencent.mobileqq.msgbackup.util.d.f251402a.f251396z.add(aVar2);
                }
            }
            MsgBackupManager.x().f251041e.remove(Long.valueOf(j3));
        }
        ConcurrentHashMap<Long, i> concurrentHashMap = MsgBackupManager.x().f251044h;
        i iVar = concurrentHashMap.get(Long.valueOf(j3));
        if (iVar != null) {
            if (z16) {
                concurrentHashMap.remove(Long.valueOf(j3));
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete  task = " + iVar + ", mFidMList.size = " + concurrentHashMap.size());
                    return;
                }
                return;
            }
            if (iVar.f251155c) {
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "fileTask onSendComplete  called not success, so again  task = " + iVar);
                }
                if (!TextUtils.isEmpty(iVar.f251157e)) {
                    if (iVar.f251159g > 3) {
                        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete fileTask  retry over time task = " + iVar);
                        concurrentHashMap.remove(Long.valueOf(j3));
                        return;
                    }
                    if (f()) {
                        f.C("fileTask onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
                        return;
                    } else {
                        iVar.f251159g = (short) (iVar.f251159g + 1);
                        this.f251331a.e(this.f251340j, iVar.f251156d, j3, iVar.f251157e);
                        return;
                    }
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete  called not success, so again task = " + iVar);
            }
            if (!TextUtils.isEmpty(iVar.f251153a)) {
                if (iVar.f251159g > 3) {
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete retry over time task = " + iVar);
                    concurrentHashMap.remove(Long.valueOf(j3));
                    return;
                }
                if (f()) {
                    f.C("onSendComplete operator is closed! please clear handler msg!........", new Object[0]);
                    return;
                } else {
                    iVar.f251159g = (short) (iVar.f251159g + 1);
                    this.f251331a.d(this.f251340j, iVar.f251156d, j3, iVar.f251153a);
                    return;
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendComplete  called, please check your mFidMList whether contains this task, before execute, should add in mFidMList!, path = " + str + ", fid = " + j3);
        }
    }

    public void U0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
            return;
        }
        this.f251335e.setUdpPort(i3);
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "setServerUdpPort: " + this.f251335e.getUdpPort());
    }

    public void V(boolean z16, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        int i3 = this.f251333c;
        if (2 == i3) {
            ConcurrentHashMap<Long, i> concurrentHashMap = MsgBackupManager.x().f251043g;
            i iVar = concurrentHashMap.get(Long.valueOf(j3));
            if (iVar != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage, success = " + z16 + ", cookie = " + j3 + ", role = MBRROLE_SERVER");
                }
                if (z16) {
                    concurrentHashMap.remove(Long.valueOf(j3));
                    return;
                }
                if (f()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage role = MBRROLE_CLIENT: panic error!");
                        return;
                    }
                    return;
                }
                short s16 = iVar.f251159g;
                if (s16 > 3) {
                    concurrentHashMap.remove(Long.valueOf(j3));
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " mfidMlist fileTask receivedCompleted retry over time task = " + iVar);
                    return;
                }
                iVar.f251159g = (short) (s16 + 1);
                String str = iVar.f251153a;
                int i16 = iVar.f251154b;
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage role = MBRROLE_CLIENT: " + iVar);
                }
                if (!TextUtils.isEmpty(str)) {
                    this.f251331a.f(this.f251340j, i16, str, j3);
                    return;
                }
                return;
            }
            return;
        }
        if (1 == i3) {
            ConcurrentHashMap<Long, i> concurrentHashMap2 = MsgBackupManager.x().f251043g;
            i iVar2 = concurrentHashMap2.get(Long.valueOf(j3));
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage, success = " + z16 + ", cookie = " + j3 + ", role = MBRROLE_CLIENT");
            }
            if (iVar2 != null) {
                if (z16) {
                    concurrentHashMap2.remove(Long.valueOf(j3));
                    return;
                }
                if (f()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage role = MBRROLE_CLIENT: panic error!");
                        return;
                    }
                    return;
                }
                if (iVar2.f251159g > 3) {
                    concurrentHashMap2.remove(Long.valueOf(j3));
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, " mfidMlist fileTask receivedCompleted retry over time task = " + iVar2);
                    return;
                }
                String str2 = iVar2.f251153a;
                int i17 = iVar2.f251154b;
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "onSendMessage  role = MBRROLE_CLIENT: " + iVar2);
                }
                if (!TextUtils.isEmpty(str2)) {
                    this.f251331a.f(this.f251340j, i17, str2, j3);
                }
            }
        }
    }

    public void V0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            MsgBackupManager.x().o();
            f.b();
            if (this.f251332b == null) {
                this.f251332b = new MsgBackupNotifier();
            }
            MsgBackupManager.x().f251039c.clear();
            X0(1);
            MsgBackupManager.x().f251039c.clear();
            l(new Runnable(str) { // from class: com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f251348d;

                {
                    this.f251348d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgBackupTransportProcessor.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        MsgBackupTransportProcessor.this.v(BaseApplication.getContext());
                        MsgBackupTransportProcessor.this.f251333c = 1;
                        int activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(true);
                        MsgBackupTransportProcessor msgBackupTransportProcessor = MsgBackupTransportProcessor.this;
                        msgBackupTransportProcessor.f251340j = msgBackupTransportProcessor.f251331a.createSession(1, Long.parseLong(this.f251348d), activeNetIpFamily, MsgBackupTransportProcessor.this.f251332b);
                        if (MsgBackupTransportProcessor.this.f()) {
                            if (QLog.isColorLevel()) {
                                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "startAsClient session is invalidate panic error!");
                                return;
                            }
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("MsgBackup", 2, "createSession end, operator = " + MsgBackupTransportProcessor.this.f251340j);
                        }
                        MsgBackupTransportProcessor.this.f251334d.getIpArray().clear();
                        MsgBackupTransportProcessor msgBackupTransportProcessor2 = MsgBackupTransportProcessor.this;
                        int start = msgBackupTransportProcessor2.f251331a.start(msgBackupTransportProcessor2.f251340j, msgBackupTransportProcessor2.f251334d);
                        if (QLog.isColorLevel()) {
                            QLog.d("MsgBackup", 2, "start ret = " + start + ", ip = " + MsgBackupTransportProcessor.this.p() + ", udpport = " + MsgBackupTransportProcessor.this.r() + ", tcpport = " + MsgBackupTransportProcessor.this.q());
                        }
                        com.tencent.mobileqq.msgbackup.authentication.a.d().a();
                    } catch (Exception e16) {
                        QLog.e("MsgBackup", 1, "startAsClient occur error", e16);
                    }
                }
            });
        }
    }

    public void W(long j3, String str, long j16, long j17, int i3, long j18, int i16, int i17, long j19) {
        c.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, Long.valueOf(j3), str, Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i3), Long.valueOf(j18), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j19));
            return;
        }
        com.tencent.mobileqq.msgbackup.util.e.h(j3, j17);
        com.tencent.mobileqq.msgbackup.util.d.b();
        if (MsgBackupManager.x().f251042f.containsKey(Long.valueOf(j3))) {
            c.b bVar2 = MsgBackupManager.x().f251042f.get(Long.valueOf(j3));
            if (bVar2 != null && !bVar2.f251400a) {
                bVar2.f251400a = true;
                bVar2.f251401b = j17;
                com.tencent.mobileqq.msgbackup.util.d.f251402a.f251380j += j17;
            }
        } else if (MsgBackupManager.x().f251041e.containsKey(Long.valueOf(j3)) && (bVar = MsgBackupManager.x().f251041e.get(Long.valueOf(j3))) != null && !bVar.f251400a) {
            bVar.f251400a = true;
            bVar.f251401b = j17;
            com.tencent.mobileqq.msgbackup.util.d.f251402a.f251381k += j17;
        }
        if (this.f251338h > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f251338h;
            if (elapsedRealtime > 1500) {
                long j26 = j18 + this.f251339i;
                com.tencent.mobileqq.msgbackup.controller.e eVar = this.f251347q;
                if (eVar != null) {
                    long j27 = (j26 * 1000) / elapsedRealtime;
                    eVar.K8(j27);
                    com.tencent.mobileqq.msgbackup.util.e.i(j3, j27);
                }
                this.f251339i = 0L;
                this.f251338h = SystemClock.elapsedRealtime();
                return;
            }
            this.f251339i += j18;
            return;
        }
        this.f251338h = SystemClock.elapsedRealtime();
        this.f251339i += j18;
    }

    public void W0(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16));
            return;
        }
        MsgBackupManager.x().o();
        f.b();
        if (this.f251332b == null) {
            this.f251332b = new MsgBackupNotifier();
        }
        X0(1);
        l(new Runnable(str, z16) { // from class: com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f251349d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f251350e;

            {
                this.f251349d = str;
                this.f251350e = z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MsgBackupTransportProcessor.this, str, Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                MsgBackupManager.x().T();
                MsgBackupTransportProcessor.this.v(BaseApplication.getContext());
                MsgBackupTransportProcessor.this.f251333c = 2;
                int activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(true);
                MsgBackupTransportProcessor msgBackupTransportProcessor = MsgBackupTransportProcessor.this;
                msgBackupTransportProcessor.f251340j = msgBackupTransportProcessor.f251331a.createSession(2, Long.parseLong(this.f251349d), activeNetIpFamily, MsgBackupTransportProcessor.this.f251332b);
                if (MsgBackupTransportProcessor.this.f()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "startAsServer session is invalidate panic error!");
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "createSession end, session = " + MsgBackupTransportProcessor.this.f251340j);
                }
                MsgBackupTransportProcessor.this.f251335e.getIpArray().clear();
                MsgBackupTransportProcessor msgBackupTransportProcessor2 = MsgBackupTransportProcessor.this;
                int start = msgBackupTransportProcessor2.f251331a.start(msgBackupTransportProcessor2.f251340j, msgBackupTransportProcessor2.f251335e);
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "start ret = " + start + ", ip = " + MsgBackupTransportProcessor.this.y() + ", udpport = " + MsgBackupTransportProcessor.this.A() + ", tcpport = " + MsgBackupTransportProcessor.this.z());
                }
                com.tencent.mobileqq.msgbackup.authentication.a.d().g(this.f251350e);
            }
        });
    }

    public void X(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) str, i3);
        }
    }

    public void X0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
            return;
        }
        if (this.f251331a != null && !f()) {
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "stop called! operator = " + this.f251340j + ". from = " + i3);
            }
            MsgBackupManager.x().p();
            if (Looper.getMainLooper() == Looper.myLooper()) {
                l(new Runnable() { // from class: com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.5
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgBackupTransportProcessor.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            MsgBackupTransportProcessor.this.k();
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
            } else {
                k();
            }
        }
    }

    public void Y(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, i3);
            return;
        }
        if (i3 != 0) {
            this.f251342l = true;
        } else {
            this.f251342l = false;
        }
        if (this.f251342l) {
            com.tencent.mobileqq.msgbackup.util.e.j("cost_connect_total", null);
        }
        com.tencent.mobileqq.msgbackup.util.d.b();
        com.tencent.mobileqq.msgbackup.util.d.f251402a.f251392v = i3;
        com.tencent.mobileqq.msgbackup.controller.e eVar = this.f251347q;
        if (eVar != null) {
            eVar.qc(this.f251342l);
        }
        if (this.f251342l && this.f251343m) {
            this.f251343m = false;
            f.B("MsgBackup_MsgBackupTransportProcessor", "tcp is disconnect!, before has cached this request msg, so request again!", new Object[0]);
            G0(3);
        }
        I0(2);
    }

    public void Z(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, z16);
            return;
        }
        this.f251341k = z16;
        com.tencent.mobileqq.msgbackup.util.d.b();
        com.tencent.mobileqq.msgbackup.util.d.f251402a.f251391u = this.f251341k;
    }

    public void a0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str, i3);
            return;
        }
        int i16 = this.f251333c;
        if (i16 == 1) {
            if (r() != 0) {
                N0(i3);
            }
        } else if (i16 == 2 && A() != 0) {
            U0(i3);
        }
    }

    public void b0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) str, i3);
        }
    }

    public void c0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) str, i3);
        }
    }

    protected boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        if (this.f251340j == 0) {
            return true;
        }
        return false;
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f251341k = false;
        this.f251342l = false;
        this.f251338h = 0L;
        this.f251339i = 0L;
        this.f251344n = false;
        this.f251337g = false;
    }

    public void h(String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, this, str, str2, Long.valueOf(j3));
            return;
        }
        if (f()) {
            f.C("clientGetResFile called---> operator is closed! please clear handler msg!........", new Object[0]);
            return;
        }
        com.tencent.mobileqq.msgbackup.util.d.b();
        com.tencent.mobileqq.msgbackup.util.d.f251402a.f251382l++;
        ConcurrentHashMap<String, h> concurrentHashMap = MsgBackupManager.x().f251039c;
        if (str == null && str2 == null) {
            f.B("MsgBackup_MsgBackupTransportProcessor", "clientGetResFile MsgBackupManager.curDealUin = %s, MsgBackupManager.curDealType = %d", MsgBackupManager.L, Integer.valueOf(MsgBackupManager.M));
            h hVar = concurrentHashMap.get(f.t(MsgBackupManager.L, f.q(MsgBackupManager.M)));
            if (hVar != null) {
                f.B("MsgBackup_MsgBackupTransportProcessor", "clientGetResFile sessionInfo is not null reslist size = %d, dbsize = %d", Integer.valueOf(hVar.b().size()), Integer.valueOf(hVar.a().size()));
                if (hVar.b().size() == 0 && hVar.a().size() == 0) {
                    G0(6);
                }
                hVar.f251149h.set(true);
                return;
            }
            return;
        }
        new File(str2).getParentFile().mkdirs();
        long y16 = f.y();
        String str3 = f.z(y(), z()) + f.n(String.format("getres?fid=%d&filepath=%s", Long.valueOf(y16), str), this.f251336f);
        i iVar = new i();
        iVar.f251159g = (short) 0;
        iVar.f251155c = true;
        iVar.f251157e = str2;
        iVar.f251158f = str3;
        iVar.f251160h = f.A(j3);
        iVar.f251161i = j3;
        com.tencent.mobileqq.msgbackup.util.d.f251402a.f251380j += j3;
        h hVar2 = concurrentHashMap.get(f.t(MsgBackupManager.L, f.q(MsgBackupManager.M)));
        if (hVar2 != null) {
            hVar2.b().put(Long.valueOf(y16), iVar);
        }
        this.f251331a.b(this.f251340j, y16, str3, str2, iVar.f251160h, iVar.f251161i, true);
    }

    public void i(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), str2);
            return;
        }
        MsgBackupManager.x().o();
        f.b();
        MsgBackupManager.x().y().h(i3);
        MsgBackupManager.x().y().i(str2);
        MsgBackupManager.x().f251039c.clear();
        X0(1);
        if (i3 == 1) {
            if (this.f251332b == null) {
                this.f251332b = new MsgBackupNotifier();
            }
            l(new Runnable(str) { // from class: com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f251351d;

                {
                    this.f251351d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgBackupTransportProcessor.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    MsgBackupManager.x().T();
                    MsgBackupTransportProcessor.this.v(BaseApplication.getContext());
                    MsgBackupTransportProcessor.this.f251333c = 2;
                    int activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(true);
                    MsgBackupTransportProcessor msgBackupTransportProcessor = MsgBackupTransportProcessor.this;
                    msgBackupTransportProcessor.f251340j = msgBackupTransportProcessor.f251331a.createSession(2, Long.parseLong(this.f251351d), activeNetIpFamily, MsgBackupTransportProcessor.this.f251332b);
                    if (MsgBackupTransportProcessor.this.f()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "confirmOnlinePush11b: backup session is invalidate panic error!");
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "confirmOnlinePush11b: backup createSession = " + MsgBackupTransportProcessor.this.f251340j);
                    }
                    MsgBackupTransportProcessor.this.f251335e.getIpArray().clear();
                    MsgBackupTransportProcessor msgBackupTransportProcessor2 = MsgBackupTransportProcessor.this;
                    int start = msgBackupTransportProcessor2.f251331a.start(msgBackupTransportProcessor2.f251340j, msgBackupTransportProcessor2.f251335e);
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "confirmOnlinePush11b: backup start ret = " + start + ", ip = " + MsgBackupTransportProcessor.this.y() + ", udpport = " + MsgBackupTransportProcessor.this.A() + ", tcpport = " + MsgBackupTransportProcessor.this.z());
                    }
                    com.tencent.mobileqq.msgbackup.authentication.a.d().a();
                }
            });
        }
        if (i3 == 2) {
            if (this.f251332b == null) {
                this.f251332b = new MsgBackupNotifier();
            }
            l(new Runnable(str) { // from class: com.tencent.mobileqq.msgbackup.transport.MsgBackupTransportProcessor.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f251352d;

                {
                    this.f251352d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgBackupTransportProcessor.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    MsgBackupTransportProcessor.this.v(BaseApplication.getContext());
                    MsgBackupTransportProcessor.this.f251333c = 1;
                    int activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(true);
                    MsgBackupTransportProcessor msgBackupTransportProcessor = MsgBackupTransportProcessor.this;
                    msgBackupTransportProcessor.f251340j = msgBackupTransportProcessor.f251331a.createSession(1, Long.parseLong(this.f251352d), activeNetIpFamily, MsgBackupTransportProcessor.this.f251332b);
                    if (MsgBackupTransportProcessor.this.f()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "confirmOnlinePush11b: restore session is invalidate panic error!");
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "confirmOnlinePush11b: restore createSession = " + MsgBackupTransportProcessor.this.f251340j);
                    }
                    MsgBackupTransportProcessor.this.f251334d.getIpArray().clear();
                    MsgBackupTransportProcessor msgBackupTransportProcessor2 = MsgBackupTransportProcessor.this;
                    int start = msgBackupTransportProcessor2.f251331a.start(msgBackupTransportProcessor2.f251340j, msgBackupTransportProcessor2.f251334d);
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "confirmOnlinePush11b: restore start ret = " + start + ", ip = " + MsgBackupTransportProcessor.this.p() + ", udpport = " + MsgBackupTransportProcessor.this.r() + ", tcpport = " + MsgBackupTransportProcessor.this.q());
                    }
                    com.tencent.mobileqq.msgbackup.authentication.a.d().a();
                }
            });
        }
    }

    public String j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (String) iPatchRedirector.redirect((short) 61, (Object) this, (Object) str);
        }
        return f.d(str, y(), z(), this.f251336f);
    }

    public void l(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) runnable);
            return;
        }
        QLog.i("MsgBackup_MsgBackupTransportProcessor", 1, "excuteTask " + f.f251425e);
        if (f.f251425e) {
            this.f251346p.post(runnable);
        } else {
            ThreadManagerV2.excute(runnable, 160, null, true);
        }
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this);
            return;
        }
        String t16 = t();
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "exitUdpNotify create exit : " + t16 + ", isUdpDetected = " + this.f251341k);
        }
        if (this.f251341k) {
            J0(259);
            return;
        }
        if (this.f251333c == 1) {
            if (z() != 0 && A() != 0) {
                if (this.f251342l) {
                    if (f()) {
                        f.C("exiNotifyForTransfer called------> operator is closed! please clear handler msg!........", new Object[0]);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitForTcp, isTcpDetected = " + this.f251342l);
                    }
                    long y16 = f.y();
                    String z16 = f.z(y(), z());
                    String str = "postinfo?fid=" + y16 + "&exit=1";
                    f.B("MsgBackup_MsgBackupTransportProcessor", str, new Object[0]);
                    String str2 = z16 + f.n(str, this.f251336f);
                    if (!TextUtils.isEmpty(str2) && this.f251331a != null) {
                        i iVar = new i();
                        iVar.f251159g = (short) 0;
                        iVar.f251155c = false;
                        iVar.f251158f = str2;
                        MsgBackupManager.x().f251044h.put(Long.valueOf(y16), iVar);
                        if (QLog.isColorLevel()) {
                            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitForTcp fid = " + y16 + ", url = " + str2);
                        }
                        this.f251331a.c(this.f251340j, y16, str2);
                        return;
                    }
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitForTcp called- for client-------------->>>");
            }
        }
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this);
            return;
        }
        int b16 = com.tencent.mobileqq.msgbackup.authentication.a.d().b();
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exit ---------> bizType = " + b16);
        }
        if (b16 == 3) {
            m();
        } else if (b16 == 1) {
            o();
        } else {
            o();
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this);
            return;
        }
        String t16 = t();
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 2, "exitUdpNotify create exit : " + t16);
        }
        if (this.f251341k) {
            J0(259);
            return;
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cmd", "exit");
            jSONObject.put(PreloadTRTCPlayerParams.KEY_SIG, com.tencent.mobileqq.msgbackup.authentication.a.d().f());
            jSONArray.mo162put(jSONObject);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        com.tencent.mobileqq.msgbackup.authentication.c.b().e(jSONArray.toString());
    }

    public String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.f251334d.getIpArray() != null && this.f251334d.getIpArray().size() > 0) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "getClientIP: " + this.f251334d.getIpArray().get(0));
            return this.f251334d.getIpArray().get(0);
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "clientStartWrapperResult from native get ip is null or 0");
        return "";
    }

    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "getClientTcpPort: " + this.f251334d.getTcpPort());
        return this.f251334d.getTcpPort();
    }

    public int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "getClientUdpPort: " + this.f251334d.getUdpPort());
        return this.f251334d.getUdpPort();
    }

    public int x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.f251333c;
    }

    public String y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        if (this.f251335e.getIpArray() != null && this.f251335e.getIpArray().size() > 0) {
            QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "getServerIP: " + this.f251335e.getIpArray().get(0));
            return this.f251335e.getIpArray().get(0);
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "serverStartWrapperResult from native get ip is null or 0");
        return "";
    }

    public int z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        QLog.d("MsgBackup_MsgBackupTransportProcessor", 1, "getServerTcpPort: " + this.f251335e.getTcpPort());
        return this.f251335e.getTcpPort();
    }
}

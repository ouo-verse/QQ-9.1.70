package com.tencent.mobileqq.stt.shard;

import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stt.shard.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush$TransPttShardRsp;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush$textRsp;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private volatile int f290744b;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f290745c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f290746d;

    /* renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, b.a> f290747e;

    /* renamed from: f, reason: collision with root package name */
    private volatile long f290748f;

    public d(a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f290744b = 0;
        this.f290745c = -1;
        this.f290746d = false;
        this.f290748f = 0L;
        this.f290747e = new ConcurrentHashMap<>();
    }

    private void b() {
        g();
    }

    private b.a e(int i3) {
        if (this.f290747e.containsKey(Integer.valueOf(i3))) {
            return this.f290747e.get(Integer.valueOf(i3));
        }
        b.a aVar = new b.a();
        this.f290747e.put(Integer.valueOf(i3), aVar);
        return aVar;
    }

    private void f(int i3) {
        if (this.f290748f != 0 && i3 != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.f290748f;
            this.f290748f = 0L;
            long j3 = currentTimeMillis / i3;
            if (QLog.isColorLevel()) {
                QLog.d("Q.stt_ShardSttRcv", 2, "PttSttReport reportPackageTimeInterval timeInterval = " + j3);
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, j3 + "");
            hashMap.put("ntimeInterval", j3 + "");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.PTT_STT_PART_TIME_INTERVAL, true, 0L, 0L, hashMap, null);
        }
    }

    private synchronized void g() {
        this.f290744b = 0;
        this.f290745c = -1;
        this.f290746d = false;
        this.f290747e.clear();
        this.f290748f = 0L;
    }

    private String h() {
        b.a aVar;
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("Q.stt_ShardSttRcv", 2, "tryGetContinuouslyString start Start = " + this.f290744b + " | Current = " + this.f290745c);
        }
        if (this.f290745c < this.f290744b) {
            return null;
        }
        String str2 = "";
        for (int i3 = this.f290744b; i3 <= this.f290745c; i3++) {
            if (this.f290747e.containsKey(Integer.valueOf(i3))) {
                aVar = this.f290747e.get(Integer.valueOf(i3));
            } else {
                aVar = null;
            }
            if (aVar != null && aVar.f290742d) {
                str2 = str2 + new String(aVar.f290741c.array());
            } else {
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("tryGetContinuouslyString return null index = ");
                    sb5.append(i3);
                    sb5.append(" | tempPacket is ");
                    if (aVar == null) {
                        str = "null";
                    } else {
                        str = "not end";
                    }
                    sb5.append(str);
                    QLog.d("Q.stt_ShardSttRcv", 2, sb5.toString());
                }
                return null;
            }
        }
        return str2;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        synchronized (this.f290747e) {
            g();
        }
    }

    public int d(SttResultPush$MsgBody sttResultPush$MsgBody) {
        SttResultPush$textRsp sttResultPush$textRsp;
        boolean z16;
        boolean z17;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) sttResultPush$MsgBody)).intValue();
        }
        synchronized (this.f290747e) {
            if (sttResultPush$MsgBody == null) {
                return 4001;
            }
            SttResultPush$TransPttShardRsp sttResultPush$TransPttShardRsp = sttResultPush$MsgBody.msg_ptt_shard_resp;
            if (!sttResultPush$TransPttShardRsp.has()) {
                b();
                this.f290738a.f(4, 2007);
                return 4001;
            }
            Long valueOf = Long.valueOf(sttResultPush$TransPttShardRsp.uint64_sessionid.get());
            int i16 = sttResultPush$TransPttShardRsp.uint32_error_code.get();
            QLog.i("Q.stt_ShardSttRcv", 1, "onSttResultPush with: " + i16 + ", " + valueOf);
            if (i16 != 0) {
                b();
                this.f290738a.f(4, i16);
                return 4002;
            }
            if (this.f290747e.size() == 0 && this.f290748f == 0) {
                this.f290748f = System.currentTimeMillis();
            }
            int i17 = sttResultPush$TransPttShardRsp.uint32_total_seq.get();
            if (i17 < this.f290744b) {
                return 0;
            }
            if (this.f290745c < i17) {
                this.f290745c = i17;
            }
            b.a e16 = e(i17);
            if (sttResultPush$TransPttShardRsp.all_text_rsp.has()) {
                sttResultPush$textRsp = sttResultPush$TransPttShardRsp.all_text_rsp;
                z16 = true;
            } else {
                if (!sttResultPush$TransPttShardRsp.cur_text_rsp.has()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.stt_ShardSttRcv", 2, "onSttResultPush all_text_rsp and cur_text_rsp all null: " + valueOf);
                    }
                    b();
                    this.f290738a.f(4, 2007);
                    return 4001;
                }
                sttResultPush$textRsp = sttResultPush$TransPttShardRsp.cur_text_rsp;
                z16 = false;
            }
            int i18 = sttResultPush$textRsp.uint32_pos.get();
            int i19 = sttResultPush$textRsp.uint32_len.get();
            int i26 = sttResultPush$textRsp.uint32_total_len.get();
            boolean z18 = z16;
            a(e16, i18, i19, i26, 1 << sttResultPush$textRsp.uint32_seq.get(), sttResultPush$textRsp.bytes_text.get().toByteArray());
            if (QLog.isColorLevel()) {
                QLog.d("Q.stt_ShardSttRcv", 2, "onSttResultPush updatePacketData with: " + valueOf + ", " + i18 + ", " + i19 + ", " + i26);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onSttResultPush updatePacketData end partIndex = ");
                sb5.append(i17);
                sb5.append(" | isFixPart = ");
                z17 = z18;
                sb5.append(z17);
                sb5.append(" | isPacketEnd = ");
                sb5.append(e16.f290742d);
                QLog.d("Q.stt_ShardSttRcv", 2, sb5.toString());
            } else {
                z17 = z18;
            }
            if (e16.f290742d) {
                if (z17) {
                    this.f290744b = i17;
                    for (int i27 = this.f290744b; i27 < i17; i27++) {
                        this.f290747e.remove(Integer.valueOf(i27));
                    }
                }
                String h16 = h();
                if (h16 != null) {
                    boolean z19 = sttResultPush$TransPttShardRsp.bool_is_total_end.get();
                    this.f290738a.h(h16, z19);
                    if (!z19) {
                        i3 = -10001;
                    } else {
                        i3 = 0;
                    }
                    if (!this.f290746d) {
                        this.f290746d = true;
                        i3 = -10002;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.stt_ShardSttRcv", 2, "onSttResultPush end : currentText = " + new String(e16.f290741c.array()) + " | isTotalEnd = " + z19 + "  | parsedString = " + h16);
                    }
                    if (z19) {
                        f(this.f290745c);
                    }
                    this.f290738a.e(true);
                    return i3;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("Q.stt_ShardSttRcv", 2, "onSttResultPush end : tryGetContinuouslyString return null!");
                }
            }
            i3 = 0;
            this.f290738a.e(true);
            return i3;
        }
    }
}

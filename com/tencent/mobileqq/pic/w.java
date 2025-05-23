package com.tencent.mobileqq.pic;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.business.PicRefreshChatHandler;
import com.tencent.mobileqq.config.business.GifPreDownloadConfProcessor;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.TroopStatisticsInfo;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.guild.media.pic.config.api.IGuildPicPreDownLoadApi;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.impl.PicHelperImpl;
import com.tencent.mobileqq.pic.api.impl.PicPreDownloadImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes16.dex */
public class w extends b implements com.tencent.mobileqq.pic.operator.g {
    static IPatchRedirector $redirector_;

    /* renamed from: e0, reason: collision with root package name */
    public static String f258844e0;
    public long A;
    public long B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public long I;
    public long J;
    public long K;
    public long L;
    public long M;
    public long N;
    public long O;
    public long P;
    public long Q;
    public long R;
    public long S;
    public long T;
    public long U;
    public AtomicBoolean V;
    public com.tencent.mobileqq.app.asyncdb.cache.b W;
    public boolean X;
    public long[] Y;
    public long Z;

    /* renamed from: a0, reason: collision with root package name */
    public Long f258845a0;

    /* renamed from: b0, reason: collision with root package name */
    public s f258846b0;

    /* renamed from: c0, reason: collision with root package name */
    private d f258847c0;

    /* renamed from: d0, reason: collision with root package name */
    public IGuildPicPreDownLoadApi f258848d0;

    /* renamed from: k, reason: collision with root package name */
    public long f258849k;

    /* renamed from: l, reason: collision with root package name */
    public long f258850l;

    /* renamed from: m, reason: collision with root package name */
    public long f258851m;

    /* renamed from: n, reason: collision with root package name */
    public long f258852n;

    /* renamed from: o, reason: collision with root package name */
    public long f258853o;

    /* renamed from: p, reason: collision with root package name */
    public long f258854p;

    /* renamed from: q, reason: collision with root package name */
    public long f258855q;

    /* renamed from: r, reason: collision with root package name */
    public long f258856r;

    /* renamed from: s, reason: collision with root package name */
    public long f258857s;

    /* renamed from: t, reason: collision with root package name */
    public long f258858t;

    /* renamed from: u, reason: collision with root package name */
    public long f258859u;

    /* renamed from: v, reason: collision with root package name */
    public long f258860v;

    /* renamed from: w, reason: collision with root package name */
    public long f258861w;

    /* renamed from: x, reason: collision with root package name */
    public long f258862x;

    /* renamed from: y, reason: collision with root package name */
    public long f258863y;

    /* renamed from: z, reason: collision with root package name */
    public long f258864z;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17693);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            f258844e0 = "PRE_DOWNLOAD_TROOP_STATISTICS_TIME";
        }
    }

    public w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.E = -1L;
        this.Q = 0L;
        this.R = TTL.MAX_VALUE;
        this.S = TTL.MAX_VALUE;
        this.T = TTL.MAX_VALUE;
        this.U = TTL.MAX_VALUE;
        this.V = new AtomicBoolean(false);
        this.f258845a0 = 100L;
    }

    private void A(MessageForPic messageForPic, long j3, int i3, int i16) {
        this.f258846b0.g(i3, i16);
        messageForPic.preDownState = 6;
        F(messageForPic);
        if (i3 == 0) {
            if (QLog.isColorLevel()) {
                f.b("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payNotSupport", "networkType:" + i3 + ",wifiHitCount:" + this.N + ",uniseq:" + messageForPic.uniseq);
                return;
            }
            return;
        }
        E(i3, this.f258852n, 0L, true);
        if (QLog.isColorLevel()) {
            f.b("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payNotSupport", "networkType:" + i3 + ",xgHitCount:" + this.J + ", uniseq:" + messageForPic.uniseq);
        }
    }

    private void E(int i3, long j3, long j16, boolean z16) {
        long j17;
        long j18;
        long j19;
        long j26;
        if (i3 == 1) {
            j17 = this.C;
            j18 = this.D;
            j26 = j17 + j3;
            this.C = j26;
            long j27 = j18 + j16;
            this.D = j27;
            long j28 = this.f258859u;
            if (j26 > j28) {
                j26 = j28;
            }
            this.C = j26;
            if (j26 < 0) {
                j26 = 0;
            }
            this.C = j26;
            if (j27 < 0) {
                j19 = 0;
            } else {
                j19 = j27;
            }
            this.D = j19;
            a.f("4gFlowPre", j26, false);
            a.f("4gFlowWaste", this.D, z16);
        } else {
            j17 = this.E;
            j18 = this.F;
            long j29 = j17 + j3;
            this.E = j29;
            long j36 = j18 + j16;
            this.F = j36;
            long j37 = this.A;
            if (j29 <= j37) {
                j37 = j29;
            }
            this.E = j37;
            if (j37 < 0) {
                j37 = 0;
            }
            this.E = j37;
            if (j36 < 0) {
                j19 = 0;
            } else {
                j19 = j36;
            }
            this.F = j19;
            a.f(IPicPreDownload.KEY_XG_FLOW_PRE, j37, false);
            a.f(IPicPreDownload.KEY_XG_FLOW_WASTE, this.F, z16);
            j26 = j37;
        }
        if (QLog.isColorLevel()) {
            f.b("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "updateFlow", "networkType=" + i3 + ", preFlowPre=" + j17 + " preFlowWaste=" + j18 + "flowPre=" + j26 + ", flowWaste:" + j19);
        }
    }

    private boolean m(String str) {
        if (this.W == null) {
            return true;
        }
        if (!this.V.get()) {
            if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "DPC has not been initialized");
            }
            return true;
        }
        TroopStatisticsInfo a16 = this.W.a(str);
        if (a16 == null || a16.count >= 1) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "don't preDownload because troopRemainCount = 0");
            return false;
        }
        return false;
    }

    private long o(long j3) {
        if (j3 == 0) {
            j3 = this.f258853o;
            if (QLog.isColorLevel()) {
                f.b("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "picSize==0,fix by pisSizeAvg");
            }
        }
        return j3;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01e1 A[Catch: Exception -> 0x01e8, TRY_LEAVE, TryCatch #0 {Exception -> 0x01e8, blocks: (B:45:0x01a1, B:47:0x01aa, B:50:0x01b2, B:16:0x01db, B:18:0x01e1), top: B:44:0x01a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void v() {
        String d16;
        String str;
        String d17 = a.d("flowCombination", IDPCApiConstant.PIC_PREDOWNLOAD_FLOW_DEFAULT);
        if (QLog.isColorLevel()) {
            QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initConfig(): PicPreDownloadFlow=" + d17);
        }
        if (d17 != null) {
            if (d17.split("\\|").length == 8) {
                this.f258855q = Integer.valueOf(r0[0]).intValue() * 1024;
                this.f258857s = Integer.valueOf(r0[1]).intValue() * 1024;
                this.f258856r = Integer.valueOf(r0[2]).intValue() * 1024;
                this.f258858t = Integer.valueOf(r0[3]).intValue() * 1024;
                this.f258861w = Integer.valueOf(r0[4]).intValue() * 1024;
                this.f258863y = Integer.valueOf(r0[5]).intValue() * 1024;
                this.f258862x = Integer.valueOf(r0[6]).intValue() * 1024;
                this.f258864z = Integer.valueOf(r0[7]).intValue() * 1024;
                this.f258859u = this.f258855q + this.f258857s;
                this.f258860v = this.f258856r + this.f258858t;
                this.A = this.f258861w + this.f258863y;
                this.B = this.f258862x + this.f258864z;
                if (QLog.isColorLevel()) {
                    QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initConfig():_4gFlowPreLimit=" + this.f258855q + " _4gFlowWasteLimit=" + this.f258856r + " _4gFlowPreFloatLimit" + this.f258857s + " _4gFlowWasteFloatLimit=" + this.f258858t + " xgFlowPreLimit=" + this.f258861w + " xgFlowWasteLimit=" + this.f258862x + " xgFlowPreFloatLimit=" + this.f258863y + " xgFlowWasteFloatLimit=" + this.f258864z);
                }
                d16 = a.d("troopCombination", IDPCApiConstant.PIC_PREDOWNLOAD_TROOP_DEFAULT);
                if (QLog.isColorLevel()) {
                    QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "initConfig(): PicPredownloadConfig=" + d16);
                }
                if (d16 != null) {
                    try {
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, e16.getMessage());
                        }
                    }
                    if (!"".equals(d16)) {
                        String[] split = d16.split("\\|");
                        if (split.length >= 4) {
                            this.R = Long.parseLong(split[0]);
                            this.S = Long.parseLong(split[1]);
                            this.T = Long.parseLong(split[2]);
                            this.U = Long.parseLong(split[3]) * 1024;
                            this.V.set(true);
                            if (QLog.isColorLevel()) {
                                QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "initConfig(): troopDefaultCount=" + this.R + ", troopIncreaseCountEnterAIO=" + this.S + ", troopMaxCount=" + this.T + ", troopMinPicSize=" + this.U);
                            }
                            this.f258845a0 = Long.valueOf(a.b("maxRequest", 100L));
                            this.f258849k = a.b("xGPreDownPolicy", 1374942199L);
                            this.f258850l = a.b("AFBFlowHitXG", 150L);
                            long b16 = a.b("AFBFlowMissXG", 40960L);
                            this.f258851m = b16;
                            this.f258852n = b16;
                            this.f258853o = a.b("APicAvgSize", 71680L);
                            this.f258854p = a.b("APicMaxSize", 204800L);
                            this.X = a.c("enablePeakFlow", Boolean.TRUE).booleanValue();
                            this.Y = n.l();
                            this.Z = a.b("PeakFlowMaxPicSize", 921600L);
                            if (QLog.isColorLevel()) {
                                int length = this.Y.length;
                                if (length != 0 && (length & 1) == 0) {
                                    StringBuilder sb5 = new StringBuilder();
                                    for (int i3 = 0; i3 < length; i3 += 2) {
                                        sb5.append(String.valueOf(this.Y[i3]));
                                        sb5.append("-");
                                        sb5.append(String.valueOf(this.Y[i3 + 1]));
                                        sb5.append(" ");
                                    }
                                    str = sb5.toString();
                                } else {
                                    str = "Error(Length=" + length + ")";
                                }
                                QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initConfig(): xGPreDownPolicy=" + this.f258849k + " xgFlowHitFeedback=" + this.f258850l + " XgFlowMissFeedback=" + this.f258851m + " XgFlowLeftRightFeddback=" + this.f258852n + " pisSizeAvg=" + this.f258853o + " pisSizeMax=" + this.f258854p + " mEnablePeakFlow=" + this.X + " mPeakFlowTimePeriod=" + str + " mPeakFlowMaxPicSize=" + this.Z + ", mRequestListMaxSize=" + this.f258845a0);
                                return;
                            }
                            return;
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initConfig(): PicPredownloadConfig Error, use default config");
                }
                if (QLog.isColorLevel()) {
                }
                this.f258845a0 = Long.valueOf(a.b("maxRequest", 100L));
                this.f258849k = a.b("xGPreDownPolicy", 1374942199L);
                this.f258850l = a.b("AFBFlowHitXG", 150L);
                long b162 = a.b("AFBFlowMissXG", 40960L);
                this.f258851m = b162;
                this.f258852n = b162;
                this.f258853o = a.b("APicAvgSize", 71680L);
                this.f258854p = a.b("APicMaxSize", 204800L);
                this.X = a.c("enablePeakFlow", Boolean.TRUE).booleanValue();
                this.Y = n.l();
                this.Z = a.b("PeakFlowMaxPicSize", 921600L);
                if (QLog.isColorLevel()) {
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "initConfig(): Error, use Server config");
        }
        this.f258861w = n.k(this.f258639a, "AMaxPDFlow3G", 614400L);
        long k3 = n.k(this.f258639a, "AMaxWFlow3G", 716800L);
        this.f258862x = k3;
        this.f258863y = 0L;
        this.f258864z = 0L;
        this.f258855q = this.f258861w;
        this.f258857s = 0L;
        this.f258856r = k3;
        this.f258858t = 0L;
        this.f258859u = this.f258855q + this.f258857s;
        this.f258860v = this.f258856r + this.f258858t;
        this.A = this.f258861w + this.f258863y;
        this.B = this.f258862x + this.f258864z;
        if (QLog.isColorLevel()) {
        }
        d16 = a.d("troopCombination", IDPCApiConstant.PIC_PREDOWNLOAD_TROOP_DEFAULT);
        if (QLog.isColorLevel()) {
        }
        if (d16 != null) {
        }
        if (QLog.isColorLevel()) {
        }
        if (QLog.isColorLevel()) {
        }
        this.f258845a0 = Long.valueOf(a.b("maxRequest", 100L));
        this.f258849k = a.b("xGPreDownPolicy", 1374942199L);
        this.f258850l = a.b("AFBFlowHitXG", 150L);
        long b1622 = a.b("AFBFlowMissXG", 40960L);
        this.f258851m = b1622;
        this.f258852n = b1622;
        this.f258853o = a.b("APicAvgSize", 71680L);
        this.f258854p = a.b("APicMaxSize", 204800L);
        this.X = a.c("enablePeakFlow", Boolean.TRUE).booleanValue();
        this.Y = n.l();
        this.Z = a.b("PeakFlowMaxPicSize", 921600L);
        if (QLog.isColorLevel()) {
        }
    }

    private synchronized void w() {
        if (this.f258847c0 == null) {
            this.f258847c0 = new d();
        }
    }

    private void x(MessageForPic messageForPic, long j3, int i3, int i16) {
        this.f258846b0.e(i3, i16, messageForPic.mNotPredownloadReason);
        messageForPic.preDownState = 2;
        F(messageForPic);
        if (i3 == 0) {
            long j16 = this.N + 1;
            this.N = j16;
            a.f(IPicPreDownload.KEY_WIFI_HIT_COUNT, j16, true);
            if (QLog.isColorLevel()) {
                f.b("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "networkType:" + i3 + ",wifiHitCount:" + this.N + ",uniseq:" + messageForPic.uniseq);
                return;
            }
            return;
        }
        long o16 = o(j3);
        E(i3, (this.f258850l * o16) / 100, -o16, false);
        this.J++;
        long j17 = this.H - o16;
        this.H = j17;
        a.f("accFlowWasteTotal", j17, false);
        a.f(IPicPreDownload.KEY_XG_HIT_COUNT, this.J, true);
        if (QLog.isColorLevel()) {
            f.b("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", "networkType:" + i3 + ",xgHitCount:" + this.J + ",uniseq:" + messageForPic.uniseq);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("accFlowPreTotal:");
            sb5.append(this.G);
            sb5.append(",accFlowWasteTotal:");
            sb5.append(this.H);
            f.b("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payHit", sb5.toString());
        }
    }

    private void y(MessageForPic messageForPic, long j3, int i3, int i16) {
        messageForPic.preDownState = 5;
        F(messageForPic);
        if (i3 == 0) {
            if (QLog.isColorLevel()) {
                f.b("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payLeftRight", "networkType:" + i3 + ",wifiHitCount:" + this.N + ",uniseq:" + messageForPic.uniseq);
                return;
            }
            return;
        }
        E(i3, this.f258852n, 0L, true);
        if (QLog.isColorLevel()) {
            f.b("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payLeftRight", "networkType:" + i3 + ",xgHitCount:" + this.J + ",uniseq:" + messageForPic.uniseq);
        }
    }

    private void z(MessageForPic messageForPic, long j3, int i3, int i16) {
        AppInterface appInterface = this.f258639a;
        if (appInterface != null && !TextUtils.isEmpty(appInterface.getAccount())) {
            PicPreDownloader picPreDownloader = ((PicPreDownloadImpl) this.f258639a.getRuntimeService(IPicPreDownload.class, "")).picPreDownloader;
            int i17 = messageForPic.mNotPredownloadReason;
            if (i17 != 0 && i17 != 1) {
                this.f258846b0.m(messageForPic.preDownNetworkType, i17);
                if (messageForPic.mNotPredownloadReason != -1) {
                    this.f258846b0.f(i3, i16);
                }
            } else {
                int r16 = picPreDownloader.r(messageForPic);
                this.f258846b0.i(i3, r16);
                this.f258846b0.m(i3, r16);
                this.f258846b0.f(i3, i16);
            }
        }
        messageForPic.preDownState = 3;
        F(messageForPic);
        if (i3 == 0) {
            long j16 = this.O + 1;
            this.O = j16;
            a.f(IPicPreDownload.KEY_WIFI_MISS_COUNT, j16, true);
            f.b("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payMiss", "networkType:" + i3 + ",wifiMissCount:" + this.O + ",uniseq:" + messageForPic.uniseq);
            return;
        }
        E(i3, this.f258851m, 0L, false);
        long j17 = this.K + 1;
        this.K = j17;
        a.f(IPicPreDownload.KEY_XG_MISS_COUNT, j17, true);
        if (QLog.isColorLevel()) {
            f.b("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "payMiss", "networkType:" + i3 + ", xgMissCount:" + this.K + ", uniseq:" + messageForPic.uniseq);
        }
    }

    public void B(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
            return;
        }
        if (this.W == null) {
            return;
        }
        if (!this.V.get()) {
            if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "DPC has not been initialized");
                return;
            }
            return;
        }
        TroopStatisticsInfo a16 = this.W.a(str);
        if (a16 != null) {
            Long valueOf = Long.valueOf(a16.count - 1);
            if (valueOf.longValue() < 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "payPreDownloadTroopPicCount troopRemainCount = 0");
                    return;
                }
                return;
            }
            a16.count = valueOf.longValue();
        } else {
            a16 = new TroopStatisticsInfo();
            a16.troopUin = str;
            a16.count = this.R - 1;
        }
        this.W.addCache(a16);
        if (QLog.isColorLevel()) {
            QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "payPreDownloadTroopPicCount troopRemainCount = " + a16.count);
        }
    }

    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            AppInterface appInterface = this.f258639a;
            if (appInterface == null) {
                return;
            }
            int i3 = ChatActivity.f175053a0;
            MqqHandler handler = appInterface.getHandler(ChatActivity.class);
            if (handler != null) {
                handler.sendEmptyMessage(39);
            }
            PicRefreshChatHandler picRefreshChatHandler = (PicRefreshChatHandler) this.f258639a.getBusinessHandler(PicRefreshChatHandler.class.getName());
            if (picRefreshChatHandler != null) {
                picRefreshChatHandler.D2();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void D(IPicPreDownload.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) aVar);
            return;
        }
        long j3 = aVar.f258626a;
        if (j3 != -1) {
            this.f258862x = j3;
        }
        long j16 = aVar.f258627b;
        if (j16 != -1) {
            this.f258861w = j16;
        }
        long j17 = aVar.f258629d;
        if (j17 != -1) {
            this.E = j17;
            a.f(IPicPreDownload.KEY_XG_FLOW_PRE, j17, true);
        }
        long j18 = aVar.f258628c;
        if (j18 != -1) {
            this.F = j18;
            a.f(IPicPreDownload.KEY_XG_FLOW_WASTE, j18, true);
        }
        long j19 = aVar.f258630e;
        if (j19 != -1) {
            this.f258850l = j19;
        }
        long j26 = aVar.f258631f;
        if (j26 != -1) {
            this.f258851m = j26;
        }
    }

    public void F(MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) messageForPic);
        } else {
            n.o(this.f258639a, messageForPic);
        }
    }

    @Override // com.tencent.mobileqq.pic.operator.g
    public void a(MessageForPic messageForPic, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, messageForPic, Long.valueOf(j3));
            return;
        }
        if (this.f258846b0 == null || messageForPic.isSendFromLocal() || messageForPic.subVersion < 5 || d.d(messageForPic)) {
            return;
        }
        int i3 = n.i(this.f258639a, messageForPic.istroop, messageForPic.frienduin);
        int i16 = messageForPic.preDownState;
        if (i16 == 1) {
            x(messageForPic, j3, messageForPic.preDownNetworkType, i3);
            return;
        }
        if (i16 == 0) {
            if (!d(i3, messageForPic.preDownNetworkType)[1]) {
                A(messageForPic, j3, messageForPic.preDownNetworkType, i3);
                return;
            } else {
                z(messageForPic, j3, messageForPic.preDownNetworkType, i3);
                return;
            }
        }
        if (i16 == 4) {
            y(messageForPic, j3, messageForPic.preDownNetworkType, i3);
        }
    }

    @Override // com.tencent.mobileqq.pic.operator.g
    public void b(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 == 0) {
            long j16 = this.M + 1;
            this.M = j16;
            a.f(IPicPreDownload.KEY_WIFI_PRE_DOWN_COUT, j16, true);
            return;
        }
        long o16 = o(j3);
        E(i3, -o16, o16, false);
        long j17 = this.G + o16;
        this.G = j17;
        this.H += o16;
        this.I++;
        a.f(IPicPreDownload.KEY_ACC_FLOW_PRE_TOTAL, j17, false);
        a.f("accFlowWasteTotal", this.H, false);
        a.f(IPicPreDownload.KEY_XG_PRE_DOWN_COUNT, this.I, true);
        if (QLog.isColorLevel()) {
            f.b("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", "networkType:" + i3 + ",wifiPreDownCount:" + this.M + ",xgPreDownCount:" + this.I);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("accFlowPreTotal:");
            sb5.append(this.G);
            sb5.append(",accFlowWasteTotal:");
            sb5.append(this.H);
            f.b("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "calcFlowConsume", sb5.toString());
        }
    }

    @Override // com.tencent.mobileqq.pic.b, com.tencent.mobileqq.pic.operator.g
    public int c(long j3, int i3, int i16, boolean z16, int i17) {
        long j16;
        long j17;
        long j18;
        long j19;
        long j26;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 0;
        boolean z17 = false;
        i18 = 0;
        i18 = 0;
        i18 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17))).intValue();
        }
        int c16 = super.c(j3, i3, i16, z16, i17);
        if (c16 != 0) {
            return c16;
        }
        if (d.e(null, z16, i17)) {
            if (this.f258847c0 == null) {
                w();
            }
            if (i16 == 0) {
                z17 = true;
            }
            if (!this.f258847c0.b(z17, j3)) {
                return 2;
            }
            return -11;
        }
        boolean l3 = l();
        if (QLog.isColorLevel()) {
            f.b("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit()", "NetworkType:" + i16 + " isInDPCWhiteList:" + l3);
        }
        if (i16 == 0) {
            if (QLog.isColorLevel()) {
                f.b("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit()", "Wifi, result=0");
            }
        } else if (l3 && i16 != 3) {
            if (QLog.isColorLevel()) {
                f.b("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit()", "InDPCWhiteList, result=0");
            }
        } else {
            long o16 = o(j3);
            if (z16) {
                if (i16 == 1) {
                    j16 = this.f258856r;
                } else {
                    j16 = this.f258862x;
                }
                if (i16 == 1) {
                    j19 = this.C;
                    j26 = this.f258857s;
                } else {
                    j19 = this.E;
                    j26 = this.f258863y;
                }
                j17 = j19 - j26;
                if (i16 == 1) {
                    j18 = this.D;
                } else {
                    j18 = this.F;
                }
            } else {
                if (i16 == 1) {
                    j16 = this.f258860v;
                } else {
                    j16 = this.B;
                }
                if (i16 == 1) {
                    j17 = this.C;
                } else {
                    j17 = this.E;
                }
                if (i16 == 1) {
                    j18 = this.D;
                } else {
                    j18 = this.F;
                }
            }
            if (j17 >= o16 && j18 + o16 < j16) {
                if (!z16 && j17 - o16 < this.f258857s) {
                    i18 = 1;
                } else {
                    i18 = 0;
                }
            } else if (j17 < o16) {
                i18 = -9;
            } else {
                i18 = -10;
            }
            if (QLog.isColorLevel()) {
                f.b("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "isOverLimit", "result:" + i18 + ",FlowWaste +picSize=" + (j18 + o16) + ",FlowWasteLimit\uff1a" + j16 + ",FlowPre:" + j17 + ",picSize:" + o16 + ",FlowWaste:" + j18 + ",uinType:" + i3 + ",networkType:" + i16 + ",isDynamic:" + z16);
            }
        }
        return i18;
    }

    @Override // com.tencent.mobileqq.pic.operator.g
    public boolean[] d(int i3, int i16) {
        int j3;
        int j16;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (boolean[]) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (l() && i16 != 3) {
            j3 = n.j(0, i3, 0);
            j16 = n.j(0, i3, 1);
        } else {
            j3 = n.j(i16, i3, 0);
            j16 = n.j(i16, i3, 1);
        }
        long j17 = this.f258849k;
        if (((j17 >> j3) & 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (((j17 >> j16) & 1) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            f.b("PIC_TAG_PRELOAD", "isPreDownload", "netWorkType:" + i16 + ",uinType:" + i3 + ",preDownThumb:" + z16 + ",preDownBig:" + z17 + ",xGPreDownPolicy:" + this.f258849k);
        }
        return new boolean[]{z16, z17};
    }

    @Override // com.tencent.mobileqq.pic.operator.g
    public void e(MessageForPic messageForPic, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, messageForPic, Long.valueOf(j3));
            return;
        }
        if (messageForPic != null && messageForPic.size == 0) {
            int i3 = messageForPic.preDownState;
            if (i3 == 1 || i3 == 2 || i3 == 3) {
                messageForPic.size = j3;
                F(messageForPic);
                int i16 = messageForPic.preDownNetworkType;
                if (i16 == 0) {
                    return;
                }
                long j16 = this.f258853o - j3;
                E(i16, j16, -j16, false);
                long j17 = this.G - j16;
                this.G = j17;
                this.H -= j16;
                a.f(IPicPreDownload.KEY_ACC_FLOW_PRE_TOTAL, j17, false);
                a.f("accFlowWasteTotal", this.H, true);
                if (QLog.isColorLevel()) {
                    f.b("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "fixPicSizeAfter", "accFlowPreTotal:" + this.G + ",accFlowWasteTotal:" + this.H);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.pic.operator.g
    public boolean f(MessageForPic messageForPic) {
        int length;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageForPic)).booleanValue();
        }
        AppInterface appInterface = this.f258639a;
        boolean z16 = false;
        if (appInterface == null) {
            return false;
        }
        int i3 = n.i(appInterface, messageForPic.istroop, messageForPic.frienduin);
        if (GifPreDownloadConfProcessor.d().b() == 1 && messageForPic.checkGif()) {
            long j3 = messageForPic.size / 1024;
            if (NetworkUtil.isWifiEnabled(this.f258639a.getApp())) {
                if (j3 < r2.c()) {
                    z16 = true;
                }
                if (!z16) {
                    messageForPic.isDownStatusReady = true;
                    C();
                }
                return z16;
            }
            if (NetworkUtil.isMobileNetWork(this.f258639a.getApp())) {
                if (j3 < r2.a()) {
                    z16 = true;
                }
                if (!z16) {
                    messageForPic.isDownStatusReady = true;
                    C();
                }
                return z16;
            }
        }
        if (i3 != 0) {
            QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "cur is not UIN_TYPE_GROUP\uff0ccanPreDownloadInPeakFlowTime[true] - uniseq:" + messageForPic.uniseq);
            return true;
        }
        if (!this.X) {
            if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "canPreDownloadInPeakFlowTime(): Peek Flow is disable[true] - uniseq:" + messageForPic.uniseq);
            }
            return true;
        }
        long[] jArr = this.Y;
        if (jArr == null) {
            length = 0;
        } else {
            length = jArr.length;
        }
        if (length != 0 && (length & 1) == 0) {
            int i16 = Calendar.getInstance().get(11);
            for (int i17 = 0; i17 < length; i17 += 2) {
                long j16 = i16;
                long[] jArr2 = this.Y;
                if (j16 >= jArr2[i17] && j16 < jArr2[i17 + 1]) {
                    long j17 = messageForPic.size;
                    if (j17 > this.Z) {
                        if (QLog.isColorLevel()) {
                            QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "picSize=" + messageForPic.size + " is larger than PeakFlowMaxPicSize(" + this.Z + ")[false] - uniseq:" + messageForPic.uniseq);
                        }
                        return false;
                    }
                    if (j17 > this.U && r() == 0) {
                        if (!m(messageForPic.frienduin)) {
                            QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but cur troop can not pre download in peak time[false] - uniseq:" + messageForPic.uniseq);
                            return false;
                        }
                        if (!PicHelperImpl.hasBigFile(messageForPic)) {
                            B(messageForPic.frienduin);
                            QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but PicHelperImpl hasBigFile[true] - uniseq:" + messageForPic.uniseq);
                            return true;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download, but the big picture already exists[true] - uniseq:" + messageForPic.uniseq);
                        }
                        return true;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "try to download because the pic.size=" + messageForPic.size + " < troopMinPicSize=" + this.U + "[true] - uniseq:" + messageForPic.uniseq);
                    }
                }
            }
            QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "canPreDownloadInPeakFlowTime finally return[true] - uniseq:" + messageForPic.uniseq);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "canPreDownloadInPeakFlowTime():  The length(" + length + ") of PeakFlowTimePeriod is error![false] - uniseq:" + messageForPic.uniseq);
        }
        return false;
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.Q = 0L;
        this.N = 0L;
        this.O = 0L;
        this.P = 0L;
        this.M = 0L;
        this.D = 0L;
        this.F = 0L;
        this.J = 0L;
        this.K = 0L;
        this.L = 0L;
        this.I = 0L;
        a.f("requestListOverLimitCount", 0L, false);
        a.f(IPicPreDownload.KEY_WIFI_HIT_COUNT, this.N, false);
        a.f(IPicPreDownload.KEY_WIFI_MISS_COUNT, this.O, false);
        a.f(IPicPreDownload.KEY_WIFI_MANUL_CLICK_COUNT, this.P, false);
        a.f(IPicPreDownload.KEY_WIFI_PRE_DOWN_COUT, this.M, false);
        a.f("4gFlowWaste", this.D, false);
        a.f(IPicPreDownload.KEY_XG_FLOW_WASTE, this.F, false);
        a.f(IPicPreDownload.KEY_XG_HIT_COUNT, this.J, false);
        a.f(IPicPreDownload.KEY_XG_MISS_COUNT, this.K, false);
        a.f(IPicPreDownload.KEY_XG_MANUL_CLICK_COUNT, this.L, false);
        a.f(IPicPreDownload.KEY_XG_PRE_DOWN_COUNT, this.I, true);
    }

    public IPicPreDownload.a p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (IPicPreDownload.a) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        IPicPreDownload.a aVar = new IPicPreDownload.a();
        aVar.f258626a = this.f258862x;
        aVar.f258627b = this.f258861w;
        aVar.f258629d = this.E;
        aVar.f258628c = this.F;
        aVar.f258630e = this.f258850l;
        aVar.f258631f = this.f258851m;
        return aVar;
    }

    void q() {
        this.C = a.b("4gFlowPre", this.f258859u);
        this.D = a.b("4gFlowWaste", 0L);
        this.E = a.b(IPicPreDownload.KEY_XG_FLOW_PRE, this.A);
        this.F = a.b(IPicPreDownload.KEY_XG_FLOW_WASTE, 0L);
        this.N = a.b(IPicPreDownload.KEY_WIFI_HIT_COUNT, this.N);
        this.O = a.b(IPicPreDownload.KEY_WIFI_MISS_COUNT, this.O);
        this.P = a.b(IPicPreDownload.KEY_WIFI_MANUL_CLICK_COUNT, this.P);
        this.M = a.b(IPicPreDownload.KEY_WIFI_PRE_DOWN_COUT, this.M);
        this.J = a.b(IPicPreDownload.KEY_XG_HIT_COUNT, this.J);
        this.K = a.b(IPicPreDownload.KEY_XG_MISS_COUNT, this.K);
        this.L = a.b(IPicPreDownload.KEY_XG_MANUL_CLICK_COUNT, this.L);
        this.I = a.b(IPicPreDownload.KEY_XG_PRE_DOWN_COUNT, this.I);
        this.G = a.b(IPicPreDownload.KEY_ACC_FLOW_PRE_TOTAL, this.G);
        this.H = a.b("accFlowWasteTotal", this.H);
        this.Q = a.b("requestListOverLimitCount", this.Q);
        if (QLog.isColorLevel()) {
            QLog.d("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", 2, "getLocalConfig(): wifiHitCount=" + this.N + " wifiMissCount=" + this.O + " wifiManualClickCount=" + this.P + " wifiPreDownCount=" + this.M + " _4gFlowPre=" + this.C + " _4gFlowWaste=" + this.D + " xgFlowPre=" + this.E + " xgFlowWaste=" + this.F + " xgHitCount=" + this.J + " xgMissCount=" + this.K + " xgManualClickCount=" + this.L + " xgPreDownCount=" + this.I + " accFlowPreTotal=" + this.G + " accFlowWasteTotal=" + this.H + " requestOverLimitCount=" + this.Q);
        }
    }

    public int r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return a.a();
    }

    public HashMap<String, String> s() {
        long j3;
        String str;
        long j16;
        w wVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (HashMap) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        long b16 = a.b("4gFlowPre", this.C);
        long b17 = a.b("4gFlowWaste", this.D);
        long b18 = a.b(IPicPreDownload.KEY_XG_FLOW_PRE, this.E);
        long b19 = a.b(IPicPreDownload.KEY_XG_FLOW_WASTE, this.F);
        long b26 = a.b(IPicPreDownload.KEY_ACC_FLOW_PRE_TOTAL, this.G);
        long b27 = a.b(IPicPreDownload.KEY_XG_PRE_DOWN_COUNT, this.I);
        long b28 = a.b(IPicPreDownload.KEY_XG_HIT_COUNT, this.J);
        long b29 = a.b(IPicPreDownload.KEY_XG_MISS_COUNT, this.K);
        long b36 = a.b(IPicPreDownload.KEY_WIFI_PRE_DOWN_COUT, this.M);
        long b37 = a.b(IPicPreDownload.KEY_WIFI_HIT_COUNT, this.N);
        long b38 = a.b(IPicPreDownload.KEY_WIFI_MISS_COUNT, this.O);
        long b39 = a.b(IPicPreDownload.KEY_XG_MANUL_CLICK_COUNT, this.L);
        long b46 = a.b(IPicPreDownload.KEY_WIFI_MANUL_CLICK_COUNT, this.P);
        long b47 = a.b("requestListOverLimitCount", this.Q);
        if (QLog.isColorLevel()) {
            str = "requestListOverLimitCount";
            StringBuilder sb5 = new StringBuilder();
            sb5.append("\n|- sp4gFlowPre:");
            sb5.append(b16);
            sb5.append("\n|- sp4gFlowWaste:");
            sb5.append(b17);
            sb5.append("\n|- spXgFlowPre:");
            sb5.append(b18);
            sb5.append("\n|-  spXgFlowWaste\uff1a");
            sb5.append(b19);
            sb5.append("\n|-  spFlowPreTotal:");
            j3 = b19;
            sb5.append(b26);
            sb5.append("\n|-  spXgPreDownCount\uff1a");
            sb5.append(b27);
            sb5.append("\n|-  spXgHitCount:");
            sb5.append(b28);
            sb5.append("\n|-  spXgMissCount\uff1a");
            sb5.append(b29);
            sb5.append("\n|-  spWifiPreDownCount:");
            sb5.append(b36);
            sb5.append("\n|-  spWifiHitCount\uff1a");
            sb5.append(b37);
            sb5.append("\n|-  spWifiMissCount:");
            sb5.append(b38);
            sb5.append("\n|-  spXgManulClickCount\uff1a");
            sb5.append(b39);
            sb5.append("\n|-  spWifiManulClickCount:");
            j16 = b46;
            sb5.append(j16);
            sb5.append("\n|-  spRequestOverLimitCount:");
            sb5.append(b47);
            f.b("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "getReportInfo", sb5.toString());
        } else {
            j3 = b19;
            str = "requestListOverLimitCount";
            j16 = b46;
        }
        hashMap.put("4gFlowPre", String.valueOf(b16));
        hashMap.put("4gFlowWaste", String.valueOf(b17));
        hashMap.put(IPicPreDownload.KEY_XG_FLOW_PRE, String.valueOf(b18));
        hashMap.put(IPicPreDownload.KEY_XG_FLOW_WASTE, String.valueOf(j3));
        if (b28 == 0 && b29 == 0 && b27 == 0) {
            wVar = this;
        } else {
            hashMap.put(IPicPreDownload.KEY_ACC_FLOW_PRE_TOTAL, String.valueOf(b26));
            hashMap.put(IPicPreDownload.KEY_XG_PRE_DOWN_COUNT, String.valueOf(b27));
            hashMap.put(IPicPreDownload.KEY_XG_HIT_COUNT, String.valueOf(b28));
            hashMap.put(IPicPreDownload.KEY_XG_MISS_COUNT, String.valueOf(b27 - b28));
            hashMap.put(IPicPreDownload.KEY_XG_MANUL_CLICK_COUNT, String.valueOf(b39));
            wVar = this;
            hashMap.put(IPicPreDownload.KEY_XG_FLOW_WASTE_BALANCE, String.valueOf(wVar.f258862x - j3));
        }
        hashMap.put(IPicPreDownload.KEY_WIFI_PRE_DOWN_COUT, String.valueOf(b36));
        hashMap.put(IPicPreDownload.KEY_WIFI_HIT_COUNT, String.valueOf(b37));
        hashMap.put(IPicPreDownload.KEY_WIFI_MISS_COUNT, String.valueOf(b38));
        hashMap.put(IPicPreDownload.KEY_WIFI_MANUL_CLICK_COUNT, String.valueOf(j16));
        hashMap.put(str, String.valueOf(wVar.Q));
        return hashMap;
    }

    public void t(String str) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
            return;
        }
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.w("PIC_TAG_PRELOAD_TROOP", 2, "increaseTroopCountWhenEnterAIO() troopId is null");
                return;
            }
            return;
        }
        if (this.W == null) {
            return;
        }
        if (!this.V.get()) {
            if (QLog.isColorLevel()) {
                QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "DPC has not been initialized");
                return;
            }
            return;
        }
        TroopStatisticsInfo a16 = this.W.a(str);
        if (a16 != null) {
            j3 = a16.count + this.S;
            long j16 = this.T;
            if (j3 > j16) {
                j3 = j16;
            }
            a16.count = j3;
        } else {
            j3 = this.R + this.S;
            a16 = new TroopStatisticsInfo();
            a16.troopUin = str;
            a16.count = j3;
        }
        this.W.updateCache(a16);
        if (QLog.isColorLevel()) {
            QLog.d("PIC_TAG_PRELOAD_TROOP", 2, "increaseTroopCountWhenEnterAIO troopRemainCount=" + j3);
        }
    }

    public void u(AppInterface appInterface, s sVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) sVar);
            return;
        }
        super.k(appInterface);
        this.f258639a = appInterface;
        this.f258846b0 = sVar;
        this.W = (com.tencent.mobileqq.app.asyncdb.cache.b) appInterface.getCacheManagerInner().getCache(3);
        w();
        v();
        q();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a.b("lastDayTime", 0L) > 86400000) {
            String currentAccountUin = appInterface.getCurrentAccountUin();
            a.f("lastDayTime", currentTimeMillis, true);
            o.b(currentAccountUin, s());
            n();
            this.f258846b0.l();
        }
        if (QLog.isColorLevel()) {
            f.b("PIC_TAG_PRELOAD.PreDownloadStrategyBeta", "init", "");
        }
        this.f258848d0 = (IGuildPicPreDownLoadApi) this.f258639a.getRuntimeService(IGuildPicPreDownLoadApi.class, "");
    }
}

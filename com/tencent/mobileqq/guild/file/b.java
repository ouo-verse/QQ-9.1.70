package com.tencent.mobileqq.guild.file;

import com.tencent.gamematrix.gmcg.api.GmCgKingsHonorMidGameErrorCode;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloaderFirstPkgRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryTask;
import com.tencent.mobileqq.guild.performance.report.r;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.cu;
import com.tencent.weiyun.transmission.ErrorCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b extends wb1.a {

    /* renamed from: b, reason: collision with root package name */
    public final wb1.b f224386b;

    /* renamed from: c, reason: collision with root package name */
    private ExcitingTransferDownloaderFirstPkgRp f224387c;

    /* renamed from: d, reason: collision with root package name */
    private ExcitingTransferDownloadCompletedInfo f224388d;

    /* renamed from: e, reason: collision with root package name */
    private long f224389e;

    /* renamed from: f, reason: collision with root package name */
    private long f224390f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f224391g;

    /* renamed from: h, reason: collision with root package name */
    int f224392h;

    /* renamed from: i, reason: collision with root package name */
    int f224393i;

    /* renamed from: j, reason: collision with root package name */
    int f224394j;

    /* renamed from: k, reason: collision with root package name */
    List<Integer> f224395k;

    /* renamed from: l, reason: collision with root package name */
    Map<Integer, Integer> f224396l;

    /* renamed from: m, reason: collision with root package name */
    String f224397m;

    /* renamed from: n, reason: collision with root package name */
    String f224398n;

    public b(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.f224386b = new wb1.b();
        this.f224387c = null;
        this.f224388d = null;
        this.f224389e = 0L;
        this.f224390f = 0L;
        this.f224391g = false;
        this.f224392h = 0;
        this.f224393i = 0;
        this.f224394j = 0;
        this.f224395k = null;
        this.f224396l = null;
    }

    private boolean k() {
        long c16;
        if (cu.e()) {
            c16 = cu.b();
        } else {
            c16 = cu.c();
        }
        return this.f224386b.f445365g > c16 * 1024;
    }

    @Override // wb1.a
    protected HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        ExcitingTransferDownloadCompletedInfo excitingTransferDownloadCompletedInfo = this.f224388d;
        if (excitingTransferDownloadCompletedInfo != null) {
            hashMap.put("serverip", String.valueOf(excitingTransferDownloadCompletedInfo.mstrLastServerHost));
            hashMap.put(ReportConstant.KEY_OLD_SERVER_IP, String.valueOf(this.f224388d.mstrLastServerHost));
            hashMap.put("param_ftnIP", String.valueOf(this.f224388d.mstrLastServerHost));
            hashMap.put("param_retry", String.valueOf(this.f224388d.muRetryTimes));
            hashMap.put("param_FailCode", String.valueOf(j(this.f224386b.f445360b, this.f224388d.mnSrvReturnCode)));
            hashMap.put("param_fsized", String.valueOf(this.f224388d.muDownloadedSize));
            hashMap.put("param_ipStackType", String.valueOf(QFileUtils.O()));
            hashMap.put("param_realTransferType", String.valueOf(this.f224388d.muProxyType));
            ExcitingTransferDownloadCompletedInfo excitingTransferDownloadCompletedInfo2 = this.f224388d;
            long j3 = excitingTransferDownloadCompletedInfo2.muTotalTimes;
            if (j3 != 0) {
                hashMap.put("param_speed", String.valueOf(((float) (excitingTransferDownloadCompletedInfo2.muDownloadedSize / 1048576)) / ((float) j3)));
            } else {
                hashMap.put("param_speed", "0");
            }
        } else {
            hashMap.put("param_FailCode", String.valueOf(this.f224386b.f445360b));
        }
        hashMap.put(ReportConstant.KEY_UUID, "");
        hashMap.put("param_MD5", "");
        hashMap.put("param_fsizeo", String.valueOf(this.f224386b.f445365g));
        hashMap.put("param_PeerUin", String.valueOf(this.f224386b.f445363e));
        hashMap.put("param_url", "");
        hashMap.put("param_rspHeader", "");
        hashMap.put("param_nSessionId", "");
        hashMap.put("param_fromType", "1");
        hashMap.put("param_V6SelectType", String.valueOf(this.f224392h));
        hashMap.put("param_ipAddrType", String.valueOf(this.f224393i));
        hashMap.put("param_stackType", String.valueOf(QFileUtils.T()));
        hashMap.put("param_loginType", String.valueOf(QFileUtils.U()));
        hashMap.put("param_ishttps", String.valueOf(this.f224394j));
        return hashMap;
    }

    @Override // wb1.a
    protected HashMap<String, String> c() {
        HashMap<String, String> hashMap = new HashMap<>();
        wb1.b bVar = this.f224386b;
        if (bVar != null) {
            hashMap.putAll(bVar.a());
        }
        hashMap.put("param_SubReason", String.valueOf(this.f224389e));
        ExcitingTransferDownloaderFirstPkgRp excitingTransferDownloaderFirstPkgRp = this.f224387c;
        if (excitingTransferDownloaderFirstPkgRp != null) {
            hashMap.putAll(excitingTransferDownloaderFirstPkgRp.getReportData());
        }
        ExcitingTransferDownloadCompletedInfo excitingTransferDownloadCompletedInfo = this.f224388d;
        if (excitingTransferDownloadCompletedInfo != null) {
            hashMap.putAll(excitingTransferDownloadCompletedInfo.getReportData());
        }
        long j3 = this.f224390f;
        if (j3 != 0) {
            hashMap.put("param_SrvRetCode", String.valueOf(j3));
        }
        hashMap.put("param_V6SelectType", String.valueOf(this.f224392h));
        hashMap.put("param_ipAddrType", String.valueOf(this.f224393i));
        hashMap.put("param_stackType", String.valueOf(QFileUtils.T()));
        hashMap.put("param_loginType", String.valueOf(QFileUtils.U()));
        hashMap.put("param_ishttps", String.valueOf(this.f224394j));
        return hashMap;
    }

    @Override // wb1.a
    public void d(boolean z16) {
        long j3;
        long j16;
        String str;
        if (g()) {
            f(z16);
        }
        ExcitingTransferDownloadCompletedInfo excitingTransferDownloadCompletedInfo = this.f224388d;
        long j17 = 0;
        float f16 = 0.0f;
        if (excitingTransferDownloadCompletedInfo != null) {
            j3 = excitingTransferDownloadCompletedInfo.muStartTime;
            j16 = excitingTransferDownloadCompletedInfo.muTotalTimes;
            long j18 = excitingTransferDownloadCompletedInfo.muDownloadedSize;
            if (j16 > 0 && j18 > 0) {
                f16 = ((((float) j18) * 1.0f) / ((float) j16)) * 1000.0f;
            }
            j17 = j18;
        } else {
            j3 = 0;
            j16 = 0;
        }
        r.a aVar = new r.a();
        aVar.f231044a = "2";
        aVar.f231045b = this.f224397m;
        aVar.f231046c = String.valueOf(j17);
        aVar.f231047d = this.f224398n;
        aVar.f231048e = "0";
        aVar.f231049f = String.valueOf(j3);
        aVar.f231050g = String.valueOf(j16);
        if (z16) {
            aVar.f231051h = "0";
        } else {
            ExcitingTransferDownloadCompletedInfo excitingTransferDownloadCompletedInfo2 = this.f224388d;
            if (excitingTransferDownloadCompletedInfo2 != null) {
                str = String.valueOf(excitingTransferDownloadCompletedInfo2.mnSrvReturnCode);
            } else {
                str = "-1";
            }
            aVar.f231051h = str;
        }
        String str2 = "";
        aVar.f231052i = "";
        aVar.f231053j = f16 + "B/s";
        ExcitingTransferDownloadCompletedInfo excitingTransferDownloadCompletedInfo3 = this.f224388d;
        if (excitingTransferDownloadCompletedInfo3 != null) {
            str2 = excitingTransferDownloadCompletedInfo3.mstrFileSavePath;
        }
        aVar.f231054k = str2;
        com.tencent.mobileqq.guild.performance.report.r.c(GuildTelemetryTask.DOWNLOAD_FILE, aVar);
    }

    @Override // wb1.a
    public void e() {
        wb1.b bVar = this.f224386b;
        bVar.f445359a = 5L;
        this.f224389e = 3L;
        bVar.f445360b = 9004L;
        d(false);
    }

    @Override // wb1.a
    protected boolean g() {
        return true;
    }

    @Override // wb1.a
    public void i() {
        wb1.b bVar = this.f224386b;
        bVar.f445359a = 1L;
        if (this.f224391g) {
            this.f224389e = 3L;
        } else {
            this.f224389e = 2L;
        }
        bVar.f445360b = 9037L;
        d(false);
    }

    protected void l() {
        if (this.f224396l != null) {
            return;
        }
        HashMap hashMap = new HashMap();
        this.f224396l = hashMap;
        hashMap.put(300, 9052);
        this.f224396l.put(301, 9052);
        this.f224396l.put(302, 9052);
        this.f224396l.put(303, 9052);
        this.f224396l.put(400, 9052);
        this.f224396l.put(304, 304);
        this.f224396l.put(305, 305);
        this.f224396l.put(306, 306);
        this.f224396l.put(307, 307);
        this.f224396l.put(308, 308);
        this.f224396l.put(401, Integer.valueOf(AppConstants.RichMediaErrorCode.ERROR_DECODE_EXP));
        this.f224396l.put(402, Integer.valueOf(AppConstants.RichMediaErrorCode.ERROR_HTTP_CODE_OTHER));
        this.f224396l.put(403, Integer.valueOf(AppConstants.RichMediaErrorCode.ERROR_NET_CONNECT_TIMEOUT));
        this.f224396l.put(405, Integer.valueOf(AppConstants.RichMediaErrorCode.ERROR_EXP_DECODER));
        this.f224396l.put(406, Integer.valueOf(AppConstants.RichMediaErrorCode.ERROR_EXP_DECODER));
        this.f224396l.put(407, 9009);
        this.f224396l.put(408, Integer.valueOf(AppConstants.RichMediaErrorCode.ERROR_SERVER_BAD_RETCODE));
        this.f224396l.put(404, Integer.valueOf(AppConstants.RichMediaErrorCode.ERROR_EXP_EOF));
    }

    protected void m() {
        if (this.f224395k != null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.f224395k = arrayList;
        arrayList.add(-29120);
        this.f224395k.add(-29120);
        this.f224395k.add(Integer.valueOf(ErrorCode.FTN_DOWN_KEY_TOO_MANY));
        this.f224395k.add(-21122);
        this.f224395k.add(-28123);
        this.f224395k.add(-25081);
        this.f224395k.add(-28126);
        this.f224395k.add(-6101);
        this.f224395k.add(Integer.valueOf(MessageRecord.MSG_TYPE_HR_INFO));
        this.f224395k.add(Integer.valueOf(com.qq.wx.voice.util.ErrorCode.WX_TTS_ERROR_TEXT_OVER_LENGTH));
        this.f224395k.add(Integer.valueOf(GmCgKingsHonorMidGameErrorCode.AgentGameBeginFail));
        this.f224395k.add(Integer.valueOf(GmCgKingsHonorMidGameErrorCode.AgentStepRopFail));
        this.f224395k.add(-9017);
        this.f224395k.add(-2813);
    }

    public void n() {
        this.f224387c.mCSEndTime = com.tencent.mobileqq.service.message.e.K0();
    }

    public void o() {
        if (this.f224387c != null) {
            return;
        }
        ExcitingTransferDownloaderFirstPkgRp excitingTransferDownloaderFirstPkgRp = new ExcitingTransferDownloaderFirstPkgRp();
        this.f224387c = excitingTransferDownloaderFirstPkgRp;
        excitingTransferDownloaderFirstPkgRp.mCSStartTime = com.tencent.mobileqq.service.message.e.K0();
    }

    public void p(long j3) {
        ExcitingTransferDownloaderFirstPkgRp excitingTransferDownloaderFirstPkgRp = this.f224387c;
        if (excitingTransferDownloaderFirstPkgRp.mHtpFirstDataSize != -1) {
            return;
        }
        excitingTransferDownloaderFirstPkgRp.mHtpFirstDataSize = j3;
    }

    public void r(long j3) {
        wb1.b bVar = this.f224386b;
        bVar.f445359a = 2L;
        this.f224389e = 2L;
        bVar.f445360b = j3;
        d(false);
    }

    public void s(long j3) {
        wb1.b bVar = this.f224386b;
        bVar.f445359a = 2L;
        this.f224389e = 7L;
        this.f224390f = j3;
        bVar.f445360b = j3;
        d(false);
    }

    public void t(int i3, int i16, ExcitingTransferOneSlotComplete excitingTransferOneSlotComplete) {
        wb1.b bVar = new wb1.b();
        wb1.b bVar2 = this.f224386b;
        bVar.f445364f = bVar2.f445364f;
        bVar.f445361c = bVar2.f445361c;
        bVar.f445363e = bVar2.f445363e;
        bVar.f445362d = bVar2.f445362d;
        bVar.f445365g = bVar2.f445365g;
        bVar.f445359a = i3;
        bVar.f445360b = i16;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_V6SelectType", String.valueOf(this.f224392h));
        if (excitingTransferOneSlotComplete != null) {
            hashMap.put("param_ipAddrType", String.valueOf(QFileUtils.P(excitingTransferOneSlotComplete.mstrIp)));
        } else {
            hashMap.put("param_ipAddrType", String.valueOf(0));
        }
        hashMap.put("param_stackType", String.valueOf(QFileUtils.T()));
        hashMap.put("param_loginType", String.valueOf(QFileUtils.U()));
        hashMap.put("param_ishttps", String.valueOf(this.f224394j));
        super.h(bVar, excitingTransferOneSlotComplete, hashMap);
    }

    public void u(ExcitingTransferDownloadCompletedInfo excitingTransferDownloadCompletedInfo) {
        ExcitingTransferDownloaderFirstPkgRp excitingTransferDownloaderFirstPkgRp = this.f224387c;
        excitingTransferDownloaderFirstPkgRp.mHttpFirstTime = excitingTransferDownloadCompletedInfo.muFirstRecvDataTime - excitingTransferDownloadCompletedInfo.muStartTime;
        excitingTransferDownloaderFirstPkgRp.mHtpFirstDataSize = excitingTransferDownloadCompletedInfo.muFirstRecvDataSize;
        this.f224388d = excitingTransferDownloadCompletedInfo;
    }

    public void v(int i3) {
        this.f224393i = i3;
    }

    public void w(boolean z16) {
        this.f224394j = z16 ? 1 : 0;
    }

    public void y(int i3) {
        this.f224392h = i3;
    }

    public void q() {
        this.f224391g = true;
    }

    public void x(int i3) {
        this.f224389e = i3;
    }

    @Override // wb1.a
    protected String a(boolean z16) {
        if (z16) {
            return "actFileDown";
        }
        return "actPDFileDownload";
    }

    private long j(long j3, int i3) {
        if (j3 == 9004) {
            return j3;
        }
        if (j3 != 0 && i3 != 0) {
            m();
            if (this.f224395k.indexOf(Integer.valueOf(i3)) >= 0) {
                return 9042L;
            }
            return i3;
        }
        l();
        if (j3 < 300) {
            int i16 = (int) j3;
            if (i16 == 0) {
                return 0L;
            }
            if (i16 == 101) {
                return 9037L;
            }
            if (i16 == 201) {
                return 9001L;
            }
        }
        if (!AppNetConnInfo.isNetSupport() || this.f445358a.isLogin()) {
            return 9004L;
        }
        l();
        if (this.f224396l.containsKey(Long.valueOf(j3))) {
            return this.f224396l.get(Long.valueOf(j3)).intValue();
        }
        switch ((int) j3) {
            case 501:
            case 502:
            case 503:
            case 505:
                return k() ? 9040L : 9003L;
            case 504:
                return 9082L;
            case 506:
                return 9040L;
            default:
                return j3;
        }
    }
}

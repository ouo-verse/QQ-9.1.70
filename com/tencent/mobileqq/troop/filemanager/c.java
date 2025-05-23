package com.tencent.mobileqq.troop.filemanager;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.util.HashMap;
import org.light.LightConstants;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f295752a;

        /* renamed from: b, reason: collision with root package name */
        public String f295753b;

        /* renamed from: c, reason: collision with root package name */
        public int f295754c;

        /* renamed from: d, reason: collision with root package name */
        public int f295755d;

        /* renamed from: e, reason: collision with root package name */
        public long f295756e;

        /* renamed from: f, reason: collision with root package name */
        public long f295757f;

        /* renamed from: g, reason: collision with root package name */
        public long f295758g;

        /* renamed from: h, reason: collision with root package name */
        public long f295759h;

        /* renamed from: i, reason: collision with root package name */
        public long f295760i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f295761j;

        /* renamed from: k, reason: collision with root package name */
        public int f295762k;

        /* renamed from: l, reason: collision with root package name */
        public int f295763l;

        /* renamed from: m, reason: collision with root package name */
        public int f295764m;

        /* renamed from: n, reason: collision with root package name */
        public int f295765n;

        /* renamed from: o, reason: collision with root package name */
        public long f295766o;

        /* renamed from: p, reason: collision with root package name */
        public long f295767p;

        /* renamed from: q, reason: collision with root package name */
        public String f295768q;

        /* renamed from: r, reason: collision with root package name */
        public String f295769r;

        /* renamed from: s, reason: collision with root package name */
        public long f295770s;

        /* renamed from: t, reason: collision with root package name */
        public int f295771t;

        /* renamed from: u, reason: collision with root package name */
        public int f295772u;

        /* renamed from: v, reason: collision with root package name */
        public int f295773v;

        /* renamed from: w, reason: collision with root package name */
        public int f295774w;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f295772u = 0;
            this.f295773v = 0;
            this.f295774w = 0;
            a();
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f295754c = 0;
            this.f295755d = 0;
            this.f295756e = 0L;
            this.f295757f = 0L;
            this.f295758g = 0L;
            this.f295759h = 0L;
            this.f295760i = 0L;
            this.f295761j = false;
            this.f295762k = -1;
            this.f295763l = 0;
            this.f295764m = 0;
            this.f295765n = 0;
            this.f295766o = 0L;
            this.f295767p = 0L;
            this.f295752a = "";
            this.f295753b = "";
            this.f295768q = "";
            this.f295769r = "";
            this.f295770s = 0L;
            this.f295771t = 0;
            this.f295772u = 0;
            this.f295773v = 0;
            this.f295774w = 0;
        }
    }

    public static int a(int i3, int i16) {
        if (i16 == 404) {
            return 303;
        }
        int i17 = i16 + LightConstants.ErrorCode.TEMPLATE_JSON_EMPTY;
        if (i17 >= 0 && i17 < 100) {
            return 304;
        }
        int i18 = i16 + LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT;
        if (i18 >= 0 && i18 < 100) {
            return 305;
        }
        if (i3 == 9024) {
            return 303;
        }
        if (i3 == 9060) {
            return 304;
        }
        if (i3 == 9061) {
            return 305;
        }
        if (i3 != 9052 && i3 != 9055 && i3 != 9053 && i3 != 9054) {
            return i3;
        }
        return 307;
    }

    public static void b(long j3, TroopFileTransferManager.Item item, String str, a aVar) {
        QQAppInterface b16;
        long j16;
        if (item == null || aVar == null || (b16 = e.b()) == null) {
            return;
        }
        String currentAccountUin = b16.getCurrentAccountUin();
        String d16 = e.d();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_group_code", String.valueOf(j3));
        hashMap.put("param_self_uin", currentAccountUin);
        hashMap.put("param_file_name", item.FileName);
        hashMap.put("param_suffix", q.j(item.FileName));
        hashMap.put("param_file_size", String.valueOf(item.ProgressTotal));
        hashMap.put(ReportConstant.KEY_UUID, item.FilePath);
        hashMap.put("param_store_type", String.valueOf(item.BusId));
        hashMap.put("param_life_left_second", String.valueOf(aVar.f295770s));
        hashMap.put("param_result", String.valueOf(aVar.f295762k));
        hashMap.put("param_sub_reason", String.valueOf(aVar.f295763l));
        hashMap.put("param_http_status_code", String.valueOf(aVar.f295764m));
        hashMap.put("param_server_return_code", String.valueOf(aVar.f295765n));
        hashMap.put("param_err_msg", aVar.f295768q);
        hashMap.put("param_retry_count", String.valueOf(item.retryTimes));
        hashMap.put("param_proxy_type", String.valueOf(aVar.f295755d));
        hashMap.put("param_net_type", d16);
        hashMap.put("param_security_time", String.valueOf(aVar.f295766o));
        hashMap.put("param_server_ip", String.valueOf(aVar.f295753b));
        hashMap.put("param_server_port", String.valueOf(aVar.f295754c));
        hashMap.put("param_file_url", aVar.f295752a);
        hashMap.put("param_start_size", String.valueOf(aVar.f295756e));
        hashMap.put("param_transfer_size", String.valueOf(aVar.f295757f));
        hashMap.put("param_transfer_time", String.valueOf(aVar.f295758g));
        hashMap.put("param_transfer_speed", String.valueOf(aVar.f295760i));
        hashMap.put("param_fromType", String.valueOf(aVar.f295771t));
        hashMap.put("param_V6SelectType", String.valueOf(aVar.f295772u));
        hashMap.put("param_ipAddrType", String.valueOf(aVar.f295773v));
        hashMap.put("param_stackType", String.valueOf(QFileUtils.T()));
        hashMap.put("param_loginType", String.valueOf(QFileUtils.U()));
        hashMap.put("param_ishttps", String.valueOf(aVar.f295774w));
        long j17 = aVar.f295759h;
        long currentTimeMillis = System.currentTimeMillis();
        long j18 = 0;
        if (aVar.f295759h == 0) {
            j17 = currentTimeMillis;
        }
        if (j17 < 1) {
            j16 = 0;
        } else {
            j16 = currentTimeMillis - j17;
        }
        if (j16 >= 0) {
            j18 = j16;
        }
        e.b.c("TroopFileDataReporter", e.b.f295938b, "[GroupDownload]reportDownloadFailInfo. reportType:" + str + " params:" + hashMap.toString());
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(currentAccountUin, str, false, j18, (long) 1, hashMap, "");
    }

    public static void c(long j3, TroopFileTransferManager.Item item, a aVar, String str) {
        QQAppInterface b16;
        long j16;
        long j17;
        if (item == null || aVar == null || (b16 = e.b()) == null) {
            return;
        }
        String currentAccountUin = b16.getCurrentAccountUin();
        String d16 = e.d();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_group_code", String.valueOf(j3));
        hashMap.put("param_self_uin", currentAccountUin);
        hashMap.put("param_file_name", item.FileName);
        hashMap.put("param_suffix", q.j(item.FileName));
        hashMap.put("param_file_size", String.valueOf(item.ProgressTotal));
        hashMap.put(ReportConstant.KEY_UUID, item.FilePath);
        hashMap.put("param_store_type", String.valueOf(item.BusId));
        hashMap.put("param_life_left_second", String.valueOf(aVar.f295770s));
        hashMap.put("param_result", String.valueOf(0));
        hashMap.put("param_sub_reason", String.valueOf(0));
        hashMap.put("param_http_status_code", String.valueOf(aVar.f295764m));
        hashMap.put("param_err_msg", "");
        hashMap.put("param_retry_count", String.valueOf(item.retryTimes));
        hashMap.put("param_proxy_type", String.valueOf(aVar.f295755d));
        hashMap.put("param_net_type", d16);
        hashMap.put("param_security_time", String.valueOf(aVar.f295766o));
        hashMap.put("param_server_ip", String.valueOf(aVar.f295753b));
        hashMap.put("param_server_port", String.valueOf(aVar.f295754c));
        hashMap.put("param_file_url", aVar.f295752a);
        hashMap.put("param_start_size", String.valueOf(aVar.f295756e));
        hashMap.put("param_transfer_size", String.valueOf(aVar.f295757f));
        hashMap.put("param_transfer_time", String.valueOf(aVar.f295758g));
        hashMap.put("param_transfer_speed", String.valueOf(aVar.f295760i));
        hashMap.put("param_fromType", String.valueOf(aVar.f295771t));
        hashMap.put("param_V6SelectType", String.valueOf(aVar.f295772u));
        hashMap.put("param_ipAddrType", String.valueOf(aVar.f295773v));
        hashMap.put("param_stackType", String.valueOf(QFileUtils.T()));
        hashMap.put("param_loginType", String.valueOf(QFileUtils.U()));
        hashMap.put("param_ishttps", String.valueOf(aVar.f295774w));
        long j18 = aVar.f295759h;
        long currentTimeMillis = System.currentTimeMillis();
        if (aVar.f295759h == 0) {
            j18 = currentTimeMillis;
        }
        if (j18 < 1) {
            j16 = 0;
        } else {
            j16 = currentTimeMillis - j18;
        }
        if (j16 < 0) {
            j17 = 0;
        } else {
            j17 = j16;
        }
        e.b.c("TroopFileDataReporter", e.b.f295938b, "[GroupDownload]reportDownloadSucInfo. reportType:" + str + " params:" + hashMap.toString());
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(currentAccountUin, str, true, j17, (long) 1, hashMap, "");
    }

    @Deprecated
    public static void d(long j3, TroopFileTransferManager.Item item, int i3, int i16) {
        if (item == null) {
            return;
        }
        QQAppInterface b16 = e.b();
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 6) {
                    switch (i3) {
                        case 9:
                        case 11:
                            TroopFileUtils.b(b16, "download", true, item.transferBeginTime, item.DownloadIp, j3 + "", q.j(item.FileName), item.FilePath, i16, item.transferedSize, item.ProgressTotal, item.downUrlStr4Report, item.rspHeadStr, item.retryTimes);
                            return;
                        case 10:
                            TroopFileUtils.b(b16, "download", false, item.transferBeginTime, item.DownloadIp, j3 + "", q.j(item.FileName), item.FilePath, i16, item.transferedSize, item.ProgressTotal, item.downUrlStr4Report, item.rspHeadStr, item.retryTimes);
                            return;
                        default:
                            return;
                    }
                }
            } else {
                TroopFileUtils.b(b16, JobDbManager.TBL_UPLOAD, false, item.transferBeginTime, item.UploadIp, j3 + "", q.j(item.FileName), item.FilePath, i16, item.transferedSize, item.ProgressTotal, item.uploadUrl, item.rspHeadStr, item.retryTimes);
                return;
            }
        }
        TroopFileUtils.b(b16, JobDbManager.TBL_UPLOAD, true, item.transferBeginTime, item.UploadIp, j3 + "", q.j(item.FileName), item.FilePath, i16, item.transferedSize, item.ProgressTotal, item.uploadUrl, item.rspHeadStr, item.retryTimes);
    }
}

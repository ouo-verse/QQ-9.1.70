package com.tencent.av.app;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.av.ManageConfig.AVTestforEncDecConfig;
import com.tencent.av.app.h;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.av.config.api.IVideoEffectConfigParser;
import com.tencent.av.mediacodec.api.IAndroidCodecHelperApi;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.videoeffect.VideoEffectTest;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.jni.codec.AndroidCodecUtil;
import com.tencent.avcore.jni.codec.NativeCodec;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IOldHttpEngineProcessor;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import mqq.app.AppRuntime;
import uw.b;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DeviceCapabilityExamination {

    /* renamed from: b, reason: collision with root package name */
    static c f72913b;

    /* renamed from: a, reason: collision with root package name */
    VideoAppInterface f72914a;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class MyTestRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        VideoAppInterface f72919d;

        MyTestRunnable(VideoAppInterface videoAppInterface) {
            this.f72919d = videoAppInterface;
        }

        @Override // java.lang.Runnable
        public void run() {
            QLog.d("DeviceCapabilityExamination", 1, "MyTestRunnable, start");
            DeviceCapabilityExamination deviceCapabilityExamination = this.f72919d.f73114e;
            if (deviceCapabilityExamination != null) {
                deviceCapabilityExamination.A();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements h.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f72920a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f72921b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ h.a.C0733a f72922c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AVTestforEncDecConfig.b f72923d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ VideoAppInterface f72924e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f72925f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f72926g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f72927h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ h.a f72928i;

        /* compiled from: P */
        /* renamed from: com.tencent.av.app.DeviceCapabilityExamination$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0730a implements b.InterfaceC11369b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ f f72929a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f72930b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f72931c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f72932d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f72933e;

            C0730a(f fVar, int i3, String str, int i16, int i17) {
                this.f72929a = fVar;
                this.f72930b = i3;
                this.f72931c = str;
                this.f72932d = i16;
                this.f72933e = i17;
            }

            @Override // uw.b.InterfaceC11369b
            public void a(int i3, String str, String str2, String str3) {
                boolean z16;
                f fVar = this.f72929a;
                fVar.f72958s = i3;
                fVar.f72959t = str2;
                a aVar = a.this;
                d dVar = aVar.f72926g;
                if (dVar != null) {
                    dVar.b(aVar.f72927h);
                    z16 = a.this.f72926g.a();
                } else {
                    z16 = true;
                }
                f fVar2 = this.f72929a;
                a aVar2 = a.this;
                DeviceCapabilityExamination.s(fVar2, aVar2.f72921b, this.f72930b, aVar2.f72927h, z16);
                h.a aVar3 = a.this.f72928i;
                if (aVar3 != null) {
                    aVar3.a(this.f72930b, this.f72931c, this.f72932d, this.f72933e, String.valueOf(i3));
                }
            }
        }

        a(long j3, int i3, h.a.C0733a c0733a, AVTestforEncDecConfig.b bVar, VideoAppInterface videoAppInterface, long j16, d dVar, int i16, h.a aVar) {
            this.f72920a = j3;
            this.f72921b = i3;
            this.f72922c = c0733a;
            this.f72923d = bVar;
            this.f72924e = videoAppInterface;
            this.f72925f = j16;
            this.f72926g = dVar;
            this.f72927h = i16;
            this.f72928i = aVar;
        }

        @Override // com.tencent.av.app.h.a
        public void a(int i3, String str, int i16, int i17, String str2) {
            f f16 = DeviceCapabilityExamination.f(this.f72921b, i3, i17, this.f72922c.f73160b, str, i16, System.currentTimeMillis() - this.f72920a);
            AVTestforEncDecConfig.b bVar = this.f72923d;
            f16.f72954o = bVar.f72800d;
            f16.f72955p = bVar.f72801e;
            f16.f72956q = bVar.f72803g;
            f16.f72957r = bVar.f72804h;
            boolean z16 = true;
            if (i3 == 1 && this.f72922c.c() && this.f72923d.f72802f) {
                new uw.a(this.f72924e, this.f72925f).d(this.f72922c.f73165g, new C0730a(f16, i3, str, i16, i17));
            } else {
                if (this.f72926g != null && this.f72922c.c()) {
                    this.f72926g.b(this.f72927h);
                    z16 = this.f72926g.a();
                }
                f16.f72958s = -10000;
                DeviceCapabilityExamination.s(f16, this.f72921b, i3, this.f72927h, z16);
                h.a aVar = this.f72928i;
                if (aVar != null) {
                    aVar.a(i3, str, i16, i17, null);
                }
            }
            NativeCodec.printLog = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements VideoEffectTest.a {
        b() {
        }

        @Override // com.tencent.av.videoeffect.VideoEffectTest.a
        public void a(int i3, long j3, String str, String str2) {
            if (com.tencent.av.utils.e.k()) {
                QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed onFinish result: " + i3 + ", timeConsuming: " + j3 + ", gpuVendor: " + str + ", gpuModel: " + str2);
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("cpu", Build.HARDWARE);
            hashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
            hashMap.put("manufacturer", Build.MANUFACTURER);
            hashMap.put("model", DeviceInfoMonitor.getModel());
            hashMap.put("product", Build.PRODUCT);
            hashMap.put("fingerprint", Build.FINGERPRINT);
            hashMap.put("gpu_vendor", str);
            hashMap.put("gpu_model", str2);
            hashMap.put("result", String.valueOf(i3));
            hashMap.put(VRReportDefine$ReportParam.TIME_CONSUMING, String.valueOf(j3));
            if (QLog.isColorLevel()) {
                QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed reportByRoomId " + hashMap);
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(DeviceCapabilityExamination.this.f72914a.getCurrentAccountUin(), "QAV_REPORT_VIDEO_EFFECT_TEST", true, 0L, 0L, hashMap, "", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        HashMap<String, String> f72936a = new HashMap<>();

        /* renamed from: b, reason: collision with root package name */
        HashMap<String, Long> f72937b = new HashMap<>();

        c() {
        }

        boolean a(String str, String str2) {
            if (this.f72936a.get(str) != null) {
                QLog.d("DeviceCapabilityExamination", 1, "isDownloading, md5[" + str + "], time[" + this.f72937b.get(str) + "]");
                return true;
            }
            this.f72936a.put(str, str2);
            this.f72937b.put(str, Long.valueOf(System.currentTimeMillis()));
            return false;
        }

        boolean b() {
            return this.f72936a.isEmpty();
        }

        void c(String str, boolean z16) {
            QLog.d("DeviceCapabilityExamination", 1, "setDownloadFinish, md5[" + str + "], suc[" + z16 + "], time[" + this.f72937b.get(str) + "]");
            StringBuilder sb5 = new StringBuilder();
            sb5.append(HardCodeUtil.qqStr(R.string.f171865lj0));
            sb5.append(z16);
            com.tencent.av.utils.e.u(sb5.toString());
            this.f72936a.remove(str);
            this.f72937b.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final int f72938a;

        /* renamed from: b, reason: collision with root package name */
        private final Boolean[] f72939b;

        public d(int i3) {
            this.f72938a = i3;
            this.f72939b = new Boolean[i3];
        }

        public boolean a() {
            for (int i3 = 0; i3 < this.f72938a; i3++) {
                if (this.f72939b[i3] == null) {
                    return false;
                }
            }
            return true;
        }

        public void b(int i3) {
            this.f72939b[i3] = Boolean.TRUE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public String f72940a = Build.HARDWARE;

        /* renamed from: b, reason: collision with root package name */
        public String f72941b = Build.MANUFACTURER;

        /* renamed from: c, reason: collision with root package name */
        public String f72942c = DeviceInfoMonitor.getModel();

        /* renamed from: d, reason: collision with root package name */
        public String f72943d = Build.PRODUCT;

        /* renamed from: e, reason: collision with root package name */
        public String f72944e = Build.FINGERPRINT;

        /* renamed from: f, reason: collision with root package name */
        public String f72945f = AVCoreSystemInfo.getCpuModel();

        /* renamed from: g, reason: collision with root package name */
        public int f72946g = Build.VERSION.SDK_INT;

        /* renamed from: h, reason: collision with root package name */
        public long f72947h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f72948i = 0;

        /* renamed from: j, reason: collision with root package name */
        public String f72949j = "";

        /* renamed from: k, reason: collision with root package name */
        public String f72950k = "";

        /* renamed from: l, reason: collision with root package name */
        public int f72951l = 0;

        /* renamed from: m, reason: collision with root package name */
        public int f72952m = 0;

        /* renamed from: n, reason: collision with root package name */
        public int f72953n = 0;

        /* renamed from: o, reason: collision with root package name */
        public int f72954o = 0;

        /* renamed from: p, reason: collision with root package name */
        public int f72955p = 0;

        /* renamed from: q, reason: collision with root package name */
        public int f72956q = 0;

        /* renamed from: r, reason: collision with root package name */
        public int f72957r = 0;

        /* renamed from: s, reason: collision with root package name */
        public int f72958s = 0;

        /* renamed from: t, reason: collision with root package name */
        public String f72959t = "";

        /* renamed from: u, reason: collision with root package name */
        public int f72960u = 0;

        /* renamed from: v, reason: collision with root package name */
        public long f72961v = 0;

        /* renamed from: w, reason: collision with root package name */
        public long f72962w = 0;

        /* renamed from: x, reason: collision with root package name */
        public int f72963x = 0;

        /* renamed from: y, reason: collision with root package name */
        public int f72964y = 0;

        /* renamed from: z, reason: collision with root package name */
        public int f72965z = 0;
        public int A = 0;
        public int B = 0;
        public int C = 0;
        public int D = 0;

        public String a() {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f72940a);
            sb5.append("|");
            sb5.append(this.f72941b);
            sb5.append("|");
            sb5.append(this.f72942c);
            sb5.append("|");
            sb5.append(this.f72943d);
            sb5.append("|");
            sb5.append(this.f72944e);
            sb5.append("|");
            sb5.append(this.f72945f);
            sb5.append("|");
            sb5.append(this.f72946g);
            sb5.append("|");
            sb5.append(this.f72947h);
            sb5.append("|");
            sb5.append(this.f72948i);
            sb5.append("|");
            sb5.append(this.f72949j);
            sb5.append("|");
            sb5.append(this.f72950k);
            sb5.append("|");
            sb5.append(this.f72951l);
            sb5.append("|");
            sb5.append(this.f72952m);
            sb5.append("|");
            sb5.append(this.f72953n);
            sb5.append("|");
            sb5.append(this.f72954o);
            sb5.append("|");
            sb5.append(this.f72955p);
            sb5.append("|");
            sb5.append(this.f72956q);
            sb5.append("|");
            sb5.append(this.f72957r);
            sb5.append("|");
            sb5.append(this.f72958s);
            sb5.append("|");
            sb5.append(this.f72959t);
            sb5.append("|");
            this.f72960u = AVCoreSystemInfo.getNumCores();
            this.f72961v = AVCoreSystemInfo.getMaxCpuFreq() / 1024;
            this.f72962w = AVCoreSystemInfo.getMemoryTotal() / 1024;
            this.f72963x = ((IAndroidCodecHelperApi) QRoute.api(IAndroidCodecHelperApi.class)).getHwDetectOutputFormatForReport();
            this.f72964y = AndroidCodecUtil.mH264EncBaseLineLevel;
            this.f72965z = AndroidCodecUtil.mH264DecBaseLineLevel;
            this.A = AndroidCodecUtil.mH264EncHighProfileLevel;
            this.B = AndroidCodecUtil.mH264DecHighProfileLevel;
            this.C = AndroidCodecUtil.mH265EncLevel;
            this.D = AndroidCodecUtil.mH265DecLevel;
            sb5.append(this.f72960u);
            sb5.append("|");
            sb5.append(this.f72961v);
            sb5.append("|");
            sb5.append(this.f72962w);
            sb5.append("|");
            sb5.append(this.f72963x);
            sb5.append("|");
            sb5.append(this.f72964y);
            sb5.append("|");
            sb5.append(this.f72965z);
            sb5.append("|");
            sb5.append(this.A);
            sb5.append("|");
            sb5.append(this.B);
            sb5.append("|");
            sb5.append(this.C);
            sb5.append("|");
            sb5.append(this.D);
            sb5.append("|");
            QLog.i("DeviceCapabilityExamination", 1, "ReportData:" + sb5.toString());
            return sb5.toString();
        }
    }

    public DeviceCapabilityExamination(VideoAppInterface videoAppInterface) {
        this.f72914a = videoAppInterface;
        this.f72914a.M().postDelayed(new MyTestRunnable(videoAppInterface), 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        QLog.d("DeviceCapabilityExamination", 1, "startExamination");
        B(this.f72914a);
        C();
    }

    public static void B(VideoAppInterface videoAppInterface) {
        QLog.d("DeviceCapabilityExamination", 1, "testHWCodecIfNeed, begin");
        if (u(1)) {
            x(1, videoAppInterface);
            return;
        }
        if (u(4)) {
            x(4, videoAppInterface);
            return;
        }
        if (u(2)) {
            z(2, videoAppInterface);
        } else if (u(8)) {
            z(8, videoAppInterface);
        } else if (QLog.isColorLevel()) {
            QLog.d("DeviceCapabilityExamination", 1, "testHWCodecIfNeed, no");
        }
    }

    private void C() {
        QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed");
        String h16 = pu.c.h(this.f72914a.getApp());
        if (!TextUtils.isEmpty(h16)) {
            QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed test config: \n" + h16);
            IConfigParser iConfigParser = (IConfigParser) QRoute.api(IConfigParser.class);
            iConfigParser.setData(h16);
            if (((IVideoEffectConfigParser) QRoute.api(IVideoEffectConfigParser.class)).getVideoEffectTestFlag(iConfigParser) == 1) {
                SharedPreferences sharedPreferences = this.f72914a.getApp().getSharedPreferences("qav_sp_video_effect", 0);
                if (!sharedPreferences.getBoolean("qav_key_test_executed", false)) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putBoolean("qav_key_test_executed", true);
                    edit.commit();
                    new VideoEffectTest(new b()).g();
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed test executed.");
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DeviceCapabilityExamination", 1, "testVideoEffectIfNeed do not need test.");
        }
    }

    public static boolean d(AVTestforEncDecConfig.c cVar, boolean z16) {
        if (cVar == null || uu.a.b(cVar) == 0) {
            return false;
        }
        AVTestforEncDecConfig.b n3 = n(cVar);
        if (n3 == null) {
            QLog.d("DeviceCapabilityExamination", 1, "checkCondition, \u65e0\u6837\u672c, codec[" + cVar.f72806b + "]");
            return false;
        }
        String q16 = q(n3.f72797a);
        if (new File(q16).exists()) {
            return true;
        }
        QLog.d("DeviceCapabilityExamination", 1, "checkCondition, \u6837\u672c\u672a\u4e0b\u8f7d, codec[" + cVar.f72806b + "], path[" + q16 + "], downloadRes[" + z16 + "]");
        if (z16) {
            y(cVar, n3.f72797a, n3.f72798b);
        }
        return false;
    }

    private static void e(int i3, int i16) {
        SharedPreferences m3 = m();
        int i17 = m3.getInt(l(i3, "test_ver"), 0);
        if (i17 == i16) {
            return;
        }
        long j3 = m3.getLong(l(i3, "doneTime"), 0L);
        long j16 = m3.getLong(l(i3, "finishTime"), 0L);
        String string = m3.getString(l(i3, "md5"), null);
        SharedPreferences.Editor edit = m3.edit();
        edit.remove(l(i3, "md5"));
        edit.remove(l(i3, "doneTime"));
        edit.remove(l(i3, "finishTime"));
        edit.remove(l(i3, "result"));
        edit.putInt(l(i3, "test_ver"), i16);
        edit.commit();
        QLog.d("DeviceCapabilityExamination", 1, "checkSPVer, codec[" + i3 + "], ver[" + i17 + "->" + i16 + "], doneFlagTime[" + j3 + "], finishFlagTime[" + j16 + "], md5[" + string + "]");
    }

    public static f f(int i3, int i16, long j3, String str, String str2, int i17, long j16) {
        f fVar = new f();
        fVar.f72947h = Long.parseLong(VideoAppInterface.N().getCurrentAccountUin());
        fVar.f72948i = i3;
        fVar.f72949j = str2;
        fVar.f72950k = str;
        fVar.f72951l = i16;
        fVar.f72952m = (int) j16;
        fVar.f72953n = (int) j3;
        return fVar;
    }

    static void g(int i3, String str) {
        if (com.tencent.av.utils.e.j()) {
            QLog.d("DeviceCapabilityExamination", 1, "delSampleFile, \u6d4b\u8bd5\u7248\u672c\u4e0d\u5220\u9664\u6837\u672c, codec[" + i3 + "], md5[" + str + "]");
            return;
        }
        t(i3, str);
    }

    public static void h(long j3, int i3, d dVar, VideoAppInterface videoAppInterface, int i16, AVTestforEncDecConfig.b bVar, h.a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        h.a.C0733a c0733a = new h.a.C0733a();
        c0733a.f73159a = i16;
        String str = bVar.f72797a;
        c0733a.f73160b = str;
        c0733a.f73161c = q(str);
        c0733a.f73165g = k(i16, bVar);
        c0733a.f73164f = bVar.f72803g;
        c0733a.f73163e = bVar.f72804h;
        c0733a.f73162d = bVar.f72799c;
        h.a(j3, c0733a, new a(currentTimeMillis, i16, c0733a, bVar, videoAppInterface, j3, dVar, i3, aVar));
    }

    static ArrayList<Integer[]> i(TreeMap<Integer, Integer[]> treeMap, String str, int i3, int i16) {
        return j(treeMap, str, i3, i16);
    }

    public static ArrayList<Integer[]> j(TreeMap<Integer, Integer[]> treeMap, String str, int i3, int i16) {
        Iterator<Integer> it = treeMap.keySet().iterator();
        ArrayList<Integer[]> arrayList = new ArrayList<>();
        while (it.hasNext()) {
            Integer[] numArr = treeMap.get(Integer.valueOf(it.next().intValue()));
            if (numArr[2].intValue() == i3 && numArr[3].intValue() == i16) {
                arrayList.add(numArr);
                if (QLog.isDevelopLevel()) {
                    QLog.d("DeviceCapabilityExamination", 1, "getBitRateTable, md5[" + str + "], w[" + i3 + "], h[" + i16 + "], bitrate[" + numArr[1] + "], fps[" + numArr[4] + "]");
                }
            }
        }
        if (arrayList.size() == 0) {
            QLog.d("DeviceCapabilityExamination", 1, "getBitRateTable, \u6ca1\u627e\u5230\u5bf9\u5e94\u7684\u7801\u8868, md5[" + str + "], w[" + i3 + "], h[" + i16 + "]");
            arrayList.add(new Integer[]{32, 2000, Integer.valueOf(i3), Integer.valueOf(i16), 15, 1, 20, 5});
        }
        return arrayList;
    }

    public static String k(int i3, AVTestforEncDecConfig.b bVar) {
        String str = p(bVar.f72797a) + ("enc_[w" + bVar.f72800d + tl.h.F + bVar.f72801e + "fYUV420]_") + bVar.f72803g + "_" + bVar.f72804h + "_" + bVar.f72800d + HippyTKDListViewAdapter.X + bVar.f72801e;
        if (i3 != 1 && i3 != 2) {
            return str + ".265";
        }
        return str + ".264";
    }

    public static String l(int i3, String str) {
        return "DT_" + i3 + "_" + str;
    }

    public static SharedPreferences m() {
        return BaseApplication.getContext().getSharedPreferences("DeviceCapabilityExamination", 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AVTestforEncDecConfig.b n(AVTestforEncDecConfig.c cVar) {
        HashMap<String, AVTestforEncDecConfig.b> hashMap = cVar.f72812h;
        AVTestforEncDecConfig.b bVar = null;
        if (hashMap == null || hashMap.size() == 0) {
            return null;
        }
        SharedPreferences m3 = m();
        String string = m3.getString(l(cVar.f72806b, "md5"), null);
        if (!TextUtils.isEmpty(string)) {
            bVar = cVar.f72812h.get(string);
        }
        if (bVar == null || TextUtils.isEmpty(bVar.f72798b)) {
            String str = (String) cVar.f72812h.keySet().toArray()[(int) (System.currentTimeMillis() % cVar.f72812h.size())];
            AVTestforEncDecConfig.b bVar2 = cVar.f72812h.get(str);
            SharedPreferences.Editor edit = m3.edit();
            edit.putString(l(cVar.f72806b, "md5"), str);
            edit.commit();
            return bVar2;
        }
        return bVar;
    }

    public static String o() {
        File filesDir = BaseApplicationImpl.sApplication.getFilesDir();
        if (filesDir == null) {
            return "";
        }
        return filesDir.getParent() + "/qav/sample/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String p(String str) {
        return o() + str + "/";
    }

    public static String q(String str) {
        return p(str) + "sample";
    }

    public static TreeMap<Integer, Integer[]> r() {
        TreeMap<Integer, Integer[]> treeMap = new TreeMap<>();
        treeMap.put(1, new Integer[]{1, 450, 640, 360, 15, 1, 15, 5});
        treeMap.put(2, new Integer[]{2, 550, 640, 360, 15, 1, 15, 5});
        treeMap.put(3, new Integer[]{3, 650, 640, 360, 15, 1, 15, 5});
        treeMap.put(4, new Integer[]{4, 750, 640, 360, 15, 1, 20, 5});
        treeMap.put(5, new Integer[]{10, 700, 960, 540, 15, 1, 15, 5});
        treeMap.put(6, new Integer[]{11, 800, 960, 540, 15, 1, 15, 5});
        treeMap.put(7, new Integer[]{12, 900, 960, 540, 15, 1, 15, 5});
        treeMap.put(8, new Integer[]{13, 1000, 960, 540, 15, 1, 15, 5});
        treeMap.put(9, new Integer[]{18, 1200, 1280, 720, 20, 1, 15, 5});
        treeMap.put(10, new Integer[]{19, 1400, 1280, 720, 20, 1, 15, 5});
        treeMap.put(11, new Integer[]{20, 1600, 1280, 720, 20, 1, 15, 5});
        treeMap.put(12, new Integer[]{21, Integer.valueOf(TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC), 1280, 720, 20, 1, 15, 5});
        treeMap.put(13, new Integer[]{31, 1500, 1920, 1080, 20, 1, 20, 5});
        treeMap.put(14, new Integer[]{32, 2000, 1920, 1080, 20, 1, 20, 5});
        treeMap.put(15, new Integer[]{33, 2500, 1920, 1080, 20, 1, 20, 5});
        treeMap.put(16, new Integer[]{34, 3000, 1920, 1080, 20, 1, 20, 5});
        return treeMap;
    }

    public static void s(f fVar, int i3, int i16, int i17, boolean z16) {
        QLog.d("DeviceCapabilityExamination", 1, "onTestFinish, codec[" + i3 + "], resultCode[" + i16 + "], curIndex[" + i17 + "], shouldDeleteSample[" + z16 + "]");
        ClientLogReport.instance().sendLog(fVar.f72947h, ClientLogReport.HW_CODEC_CAPABILITY_TEST_TOPIC_ID, fVar.a().getBytes(), false);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(HardCodeUtil.qqStr(R.string.liz));
        sb5.append(i3);
        sb5.append("], resultCode:");
        sb5.append(i16);
        com.tencent.av.utils.e.u(sb5.toString());
        v(i3, i16);
        if (z16) {
            g(i3, fVar.f72950k);
        }
    }

    public static void t(int i3, String str) {
        try {
            String p16 = p(str);
            File file = new File(p16);
            boolean exists = file.exists();
            FileUtils.deleteDirectory(p16);
            QLog.d("DeviceCapabilityExamination", 1, "delSampleFile, codec[" + i3 + "], md5[" + str + "], exists[" + exists + "->" + file.exists() + "]");
        } catch (Exception unused) {
        }
    }

    static boolean u(int i3) {
        AVTestforEncDecConfig.c e16 = AVTestforEncDecConfig.e(i3);
        if (e16 == null || System.currentTimeMillis() > e16.f72814j) {
            return false;
        }
        e(e16.f72806b, e16.f72811g);
        SharedPreferences m3 = m();
        long j3 = m3.getLong(l(i3, "doneTime"), 0L);
        if (j3 == 0) {
            if (d(e16, true)) {
                if ((i3 == 8 || i3 == 2) && TextUtils.isEmpty(AVSoUtils.p())) {
                    QLog.d("DeviceCapabilityExamination", 1, "runTest, cannot find libTcHevcDec2.so for hardware encode detect!!");
                    return false;
                }
                w(e16.f72806b);
                return true;
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("DeviceCapabilityExamination", 1, "runTest, done, codec[" + i3 + "], result[" + m3.getInt(l(i3, "result"), -99) + "], doneFlagTime[" + j3 + "], finishFlagTime[" + m3.getLong(l(i3, "finishTime"), 0L) + "]");
        }
        return false;
    }

    static void v(int i3, int i16) {
        SharedPreferences.Editor edit = m().edit();
        edit.putInt(l(i3, "result"), i16);
        edit.putLong(l(i3, "finishTime"), System.currentTimeMillis());
        edit.commit();
    }

    private static void w(int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        QLog.d("DeviceCapabilityExamination", 1, "setTestDone, codec[" + i3 + "], doneFlagTime[" + currentTimeMillis + "]");
        SharedPreferences.Editor edit = m().edit();
        edit.putLong(l(i3, "doneTime"), currentTimeMillis);
        edit.commit();
        int g16 = am.s().g(431, "");
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof VideoAppInterface) {
            HashMap hashMap = new HashMap();
            hashMap.put("uin", ((VideoAppInterface) runtime).getCurrentAccountUin());
            hashMap.put("ver", g16 + "");
            hashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
            AVTestforEncDecConfig.c e16 = AVTestforEncDecConfig.e(i3);
            if (e16 != null) {
                int b16 = uu.a.b(e16);
                hashMap.put("test" + i3, "1");
                hashMap.put("test" + i3 + "_ver", e16.f72811g + "");
                hashMap.put("test" + i3 + "_flag", b16 + "");
            }
            UserAction.onUserAction("qav_codec_done", true, -1L, -1L, hashMap, true, true);
        }
    }

    public static void x(final int i3, final VideoAppInterface videoAppInterface) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.app.DeviceCapabilityExamination.3
            @Override // java.lang.Runnable
            public void run() {
                AVTestforEncDecConfig.c e16 = AVTestforEncDecConfig.e(i3);
                if (e16 == null) {
                    QLog.d("DeviceCapabilityExamination", 1, "startDecoderTest, error", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
                    return;
                }
                NativeCodec.printLog = true;
                AVTestforEncDecConfig.b n3 = DeviceCapabilityExamination.n(e16);
                if (n3 == null) {
                    QLog.d("DeviceCapabilityExamination", 1, "startDecoderTest, \u65e0\u6837\u672c, codec[" + e16.f72806b + "]");
                    return;
                }
                String q16 = DeviceCapabilityExamination.q(n3.f72797a);
                if (!new File(q16).exists()) {
                    QLog.d("DeviceCapabilityExamination", 1, "startDecoderTest, error, filePath[" + q16, new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
                    return;
                }
                DeviceCapabilityExamination.h(com.tencent.av.utils.e.d(), 0, null, videoAppInterface, i3, n3, null);
            }
        }, 16, null, true);
    }

    public static void y(AVTestforEncDecConfig.c cVar, String str, String str2) {
        if (!NetworkUtil.isWifiConnected(null)) {
            QLog.d("DeviceCapabilityExamination", 1, "startDownloadTestResource, no wifi");
            return;
        }
        synchronized (c.class) {
            if (f72913b == null) {
                f72913b = new c();
            }
            if (f72913b.a(str, str2)) {
                QLog.d("DeviceCapabilityExamination", 1, "startDownloadTestResource, \u4e0b\u8f7d\u4e2d , md5[" + str + "]");
                return;
            }
            QLog.d("DeviceCapabilityExamination", 1, "startDownloadTestResource, md5[" + str + "]");
            HttpNetReq httpNetReq = new HttpNetReq();
            httpNetReq.mCallback = new e();
            httpNetReq.mReqUrl = str2;
            httpNetReq.mHttpMethod = 0;
            httpNetReq.mOutPath = p(str) + "sample.zip";
            httpNetReq.mMsgId = str;
            httpNetReq.setUserData(str);
            ((IOldHttpEngineProcessor) QRoute.api(IOldHttpEngineProcessor.class)).sendReq(httpNetReq);
        }
    }

    public static void z(final int i3, final VideoAppInterface videoAppInterface) {
        uw.b.b(videoAppInterface);
        uw.b.a("DeviceCapabilityExamination", videoAppInterface);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.app.DeviceCapabilityExamination.1
            @Override // java.lang.Runnable
            public void run() {
                AVTestforEncDecConfig.c e16 = AVTestforEncDecConfig.e(i3);
                if (e16 == null) {
                    QLog.d("DeviceCapabilityExamination", 1, "startEncoderTest, error", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
                    return;
                }
                NativeCodec.printLog = true;
                AVTestforEncDecConfig.b n3 = DeviceCapabilityExamination.n(e16);
                if (n3 == null) {
                    QLog.d("DeviceCapabilityExamination", 1, "startEncoderTest, \u65e0\u6837\u672c, codec[" + e16.f72806b + "]");
                    return;
                }
                String q16 = DeviceCapabilityExamination.q(n3.f72797a);
                if (!new File(q16).exists()) {
                    QLog.d("DeviceCapabilityExamination", 1, "startEncoderTest, error, filePath[" + q16, new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
                    return;
                }
                ArrayList<Integer[]> i16 = DeviceCapabilityExamination.i(DeviceCapabilityExamination.r(), n3.f72797a, n3.f72800d, n3.f72801e);
                d dVar = new d(i16.size());
                Iterator<Integer[]> it = i16.iterator();
                int i17 = 0;
                while (it.hasNext()) {
                    Integer[] next = it.next();
                    n3.f72803g = next[1].intValue();
                    n3.f72804h = next[4].intValue();
                    DeviceCapabilityExamination.h(com.tencent.av.utils.e.d(), i17, dVar, videoAppInterface, i3, n3, null);
                    i17++;
                }
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class e implements INetEngineListener {
        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            boolean z16;
            String str = (String) netResp.mReq.getUserData();
            if (netResp.mResult == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            synchronized (c.class) {
                c cVar = DeviceCapabilityExamination.f72913b;
                if (cVar != null) {
                    cVar.c(str, z16);
                    if (DeviceCapabilityExamination.f72913b.b()) {
                        DeviceCapabilityExamination.f72913b = null;
                    }
                }
            }
            if (z16) {
                try {
                    FileUtils.uncompressZip(netResp.mReq.mOutPath, DeviceCapabilityExamination.p(str), false);
                    FileUtils.deleteFile(netResp.mReq.mOutPath);
                    QLog.d("DeviceCapabilityExamination", 1, "DownloadTestResource, suc, md5[" + str + "], exists[" + new File(DeviceCapabilityExamination.q(str)).exists() + "]");
                    return;
                } catch (Exception unused) {
                    QLog.d("DeviceCapabilityExamination", 1, "DownloadTestResource Exception, md5[" + str + "]");
                    return;
                }
            }
            QLog.d("DeviceCapabilityExamination", 1, "DownloadTestResource fail, md5[" + str + "], resp.mResult[" + netResp.mResult + "]");
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    }
}

package lb0;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.avbiz.Constants;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.video.rfw.player.report.RFWVideoUrlBean;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.config.impl.QCircleDynamicNameApiImpl;
import com.tencent.mobileqq.qcircle.api.utils.QCircleVideoDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqnt.kernel.nativeinterface.DigestErrCode;
import com.tencent.richframework.data.idata.IDataConverter;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReporter;
import cooperation.qzone.QUA;
import feedcloud.FeedCloudMeta$StUser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<SimpleDateFormat> f414270a = new ThreadLocal<>();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Map<String, String> f414271a;

        /* renamed from: b, reason: collision with root package name */
        public int f414272b = -1;

        /* renamed from: c, reason: collision with root package name */
        public FeedCloudMeta$StUser f414273c;

        /* renamed from: d, reason: collision with root package name */
        public RFWVideoUrlBean f414274d;

        /* renamed from: e, reason: collision with root package name */
        public RFWVideoUrlBean f414275e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f414276f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f414277g;

        /* renamed from: h, reason: collision with root package name */
        private String f414278h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f414279i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f414280j;

        /* renamed from: k, reason: collision with root package name */
        private float f414281k;

        /* renamed from: l, reason: collision with root package name */
        private float f414282l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f414283m;

        /* renamed from: n, reason: collision with root package name */
        private long f414284n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f414285o;

        /* renamed from: p, reason: collision with root package name */
        private String f414286p;

        public a(String str) {
            HashMap hashMap = new HashMap();
            this.f414271a = hashMap;
            hashMap.put("plateform", "android");
            hashMap.put("mobile_type", DeviceInfoMonitor.getModel());
            hashMap.put("network_type", String.valueOf(b.g()));
            hashMap.put("unique_id", str);
            hashMap.put("event_code", "play");
            hashMap.put("event_time", b.b().format(new Date()));
            hashMap.put("qua", QUA.getQUA3());
            hashMap.put("version", ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getSubVersion());
            hashMap.put("host_uin", HostDataTransUtils.getAccount());
            hashMap.put("ext2", String.valueOf(Build.VERSION.SDK_INT));
        }

        private String u() {
            long j3 = this.f414284n;
            if (j3 == 101) {
                return "\u8f6f\u89e3";
            }
            if (j3 == 102) {
                return "\u786c\u89e3";
            }
            return "\u672a\u77e5";
        }

        public void A(long j3) {
            this.f414284n = j3;
        }

        public a B(String str) {
            this.f414271a.put("ext1", str);
            return this;
        }

        public a C(RFWVideoUrlBean rFWVideoUrlBean, RFWVideoUrlBean rFWVideoUrlBean2) {
            this.f414274d = rFWVideoUrlBean;
            this.f414275e = rFWVideoUrlBean2;
            return this;
        }

        public a D(int i3) {
            this.f414271a.put("video_encode_type", String.valueOf(i3));
            return this;
        }

        public a E(String str, String str2) {
            this.f414271a.put("feed_id", str);
            this.f414271a.put("orig_uin", str2);
            return this;
        }

        public a F(boolean z16) {
            this.f414276f = z16;
            return this;
        }

        public a G(boolean z16) {
            this.f414280j = z16;
            return this;
        }

        public a H(boolean z16) {
            String str;
            Map<String, String> map = this.f414271a;
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            map.put("client_down_level", str);
            return this;
        }

        public void I(boolean z16) {
            this.f414283m = z16;
        }

        public a J(boolean z16) {
            this.f414277g = z16;
            return this;
        }

        public a K(boolean z16) {
            String str;
            Map<String, String> map = this.f414271a;
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            map.put("server_down_level", str);
            return this;
        }

        public a L(boolean z16) {
            this.f414285o = z16;
            return this;
        }

        public a M(String str) {
            this.f414278h = str;
            return this;
        }

        public a N(int i3, int i16) {
            int min = Math.min(i3, i16);
            int max = Math.max(i3, i16);
            this.f414271a.put("video_width", String.valueOf(min));
            this.f414271a.put("video_height", String.valueOf(max));
            this.f414271a.put(AEEditorConstants.VIDEO_RESOLUTION, min + HippyTKDListViewAdapter.X + max);
            return this;
        }

        public a O(int i3, int i16) {
            int min = Math.min(i3, i16);
            int max = Math.max(i3, i16);
            this.f414271a.put("video_player_width", String.valueOf(min));
            this.f414271a.put("video_player_height", String.valueOf(max));
            return this;
        }

        public a P(FeedCloudMeta$StUser feedCloudMeta$StUser) {
            this.f414273c = feedCloudMeta$StUser;
            return this;
        }

        public a Q(int i3) {
            this.f414272b = i3;
            return this;
        }

        public a R(String str) {
            this.f414271a.put("video_play_host", str);
            return this;
        }

        public a S(int i3) {
            this.f414271a.put("video_real_format_id", String.valueOf(i3));
            return this;
        }

        public a T(int i3) {
            this.f414271a.put("video_play_level", String.valueOf(i3));
            return this;
        }

        public a U(int i3) {
            this.f414271a.put("video_play_encode", String.valueOf(i3));
            return this;
        }

        public a V(boolean z16) {
            this.f414279i = z16;
            return this;
        }

        public a W(int i3) {
            this.f414271a.put("video_play_rate", String.valueOf(i3));
            return this;
        }

        public a X(int i3) {
            this.f414271a.put("video_play_format_id", String.valueOf(i3));
            return this;
        }

        public a Y(String str) {
            this.f414271a.put("video_f0_host", str);
            return this;
        }

        public a Z(int i3) {
            this.f414271a.put("video_f0_rate", String.valueOf(i3));
            return this;
        }

        public a a0(int i3) {
            this.f414271a.put("video_f0_level", String.valueOf(i3));
            return this;
        }

        public a b0(int i3, int i16) {
            this.f414271a.put("video_f0_width", String.valueOf(i3));
            this.f414271a.put("video_f0_height", String.valueOf(i16));
            return this;
        }

        public a c0(String str) {
            this.f414271a.put("video_id", str);
            return this;
        }

        public a d0(String str) {
            this.f414271a.put("video_score", str);
            return this;
        }

        public a e0(int i3) {
            this.f414271a.put("pgc", String.valueOf(i3));
            return this;
        }

        public String f0() {
            String str;
            String str2;
            StringBuilder sb5 = new StringBuilder();
            if (this.f414274d != null) {
                sb5.append("f0\u6863\uff1a\n");
                sb5.append(this.f414274d.toString());
            } else {
                sb5.append("\u672a\u4e0b\u53d1f0\u6863\u4f4d\u4fe1\u606f");
            }
            sb5.append("\n");
            sb5.append("\u5f53\u524d\u64ad\u653e\u6863 \u6e05\u6670\u5ea6\u6253\u5206 ");
            sb5.append(this.f414275e.mScore);
            sb5.append("\n");
            sb5.append(this.f414275e.toString());
            sb5.append("\n");
            sb5.append("AV1\u4e0b\u53d1\uff1a");
            sb5.append(this.f414286p);
            sb5.append("\n");
            sb5.append("\u64ad\u653e\u5668\uff1a\u5206\u8fa8\u7387 ");
            sb5.append(this.f414271a.get("video_player_width"));
            sb5.append(HippyTKDListViewAdapter.X);
            sb5.append(this.f414271a.get("video_player_height"));
            sb5.append("|tag:");
            sb5.append(this.f414278h);
            sb5.append(" ");
            sb5.append(" |\u9009\u6863\u7f51\u901f:");
            sb5.append(this.f414272b);
            sb5.append("KB/S ");
            sb5.append(" |\u9009\u6863\u7f13\u5b58:");
            sb5.append(this.f414279i);
            sb5.append(" |\u9884\u52a0\u8f7d:");
            sb5.append(this.f414280j);
            sb5.append(" |\u9884\u6e32\u67d3:");
            sb5.append(this.f414277g);
            sb5.append(" |\u673a\u5668level:");
            sb5.append(QCircleVideoDeviceInfoUtils.getVideoDeviceLevel());
            sb5.append(" |Ip\u76f4\u51fa");
            sb5.append(this.f414283m);
            sb5.append(" |\u8d85\u5206\uff1a");
            sb5.append(this.f414276f);
            sb5.append(" |\u7f13\u5b58\u65f6\u95f4:");
            sb5.append(this.f414281k);
            sb5.append("_");
            sb5.append(this.f414282l);
            sb5.append("\u79d2");
            sb5.append(" |\u64ad\u653e\u683c\u5f0f:");
            if (this.f414271a.get("video_play_encode") == null) {
                str = "0";
            } else {
                str = this.f414271a.get("video_play_encode");
            }
            sb5.append(RFWVideoUrlBean.getEncodeDesc(Integer.parseInt(str)));
            sb5.append(" |\u89e3\u7801\u65b9\u5f0f:");
            sb5.append(u());
            sb5.append(" |\u7cfb\u7edf\u64ad\u653e\u5668\uff1a");
            sb5.append(this.f414285o);
            sb5.append(" |tpCore:");
            sb5.append(SuperPlayerSDKMgr.getTPCoreVersionInt());
            sb5.append(" |tpDownload:");
            sb5.append(TPDownloadProxyHelper.getNativeLibVersion());
            sb5.append("\n");
            sb5.append("\u5ba2\u6237\u7aef\u964d\u6863\uff1a");
            String str3 = "yes";
            if ("1".equals(this.f414271a.get("client_down_level"))) {
                str2 = "yes";
            } else {
                str2 = "no";
            }
            sb5.append(str2);
            sb5.append(" \u540e\u53f0\u964d\u6863\uff1a");
            if (!"1".equals(this.f414271a.get("server_down_level"))) {
                str3 = "no";
            }
            sb5.append(str3);
            sb5.append(" \u89c6\u9891\u6765\u6e90\uff1a");
            sb5.append(b.d(this.f414271a.get("pgc")));
            sb5.append("\nplayFormatId ");
            sb5.append(this.f414271a.get("video_play_format_id"));
            sb5.append("   realFormatId ");
            sb5.append(this.f414275e.mFormatId);
            sb5.append("\n\n");
            if (!TextUtils.isEmpty(this.f414275e.mTraceId)) {
                sb5.append("traceId ");
                sb5.append(this.f414275e.mTraceId);
                sb5.append("\n");
            }
            sb5.append("uin ");
            sb5.append(this.f414273c.f398463id.get());
            sb5.append(" name: ");
            sb5.append(this.f414273c.nick.get());
            sb5.append("\n");
            sb5.append("feedId ");
            sb5.append(this.f414271a.get("feed_id"));
            sb5.append("\n");
            sb5.append("videoId ");
            sb5.append(this.f414271a.get("video_id"));
            sb5.append("\n");
            return sb5.toString();
        }

        public void v() {
            b.c(this);
        }

        public a w(String str) {
            this.f414286p = str;
            return this;
        }

        public a x(String str) {
            this.f414271a.put("attach_info", str);
            return this;
        }

        public a y(float f16) {
            this.f414281k = f16;
            return this;
        }

        public a z(float f16) {
            this.f414282l = f16;
            return this;
        }
    }

    static /* bridge */ /* synthetic */ SimpleDateFormat b() {
        return e();
    }

    public static void c(a aVar) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : aVar.f414271a.entrySet()) {
            arrayList.add(QCircleReportHelper.newEntry(entry.getKey(), entry.getValue()));
        }
        QCircleReporter.getInstance().addQualityReportData(QCircleReportHelper.newSingleDcData(f(), arrayList, null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "\u672a\u77e5";
        }
        switch (Integer.parseInt(str)) {
            case 1:
                return QCircleDynamicNameApiImpl.ORIGIN_OLD_NAME;
            case 2:
                return "\u7206\u6b3e";
            case 3:
                return Constants.Business.READINJOY;
            case 4:
                return "\u5fae\u89c6";
            case 5:
                return "\u65b0\u95fb";
            case 6:
            default:
                return "\u672a\u77e5";
            case 7:
                return "\u4eba\u4eba";
            case 8:
                return "\u4f01\u9e45\u53f7";
            case 9:
                return "\u817e\u8baf\u89c6\u9891";
            case 10:
                return "\u5916\u90e8";
        }
    }

    @SuppressLint({"SimpleDateFormat"})
    private static SimpleDateFormat e() {
        ThreadLocal<SimpleDateFormat> threadLocal = f414270a;
        SimpleDateFormat simpleDateFormat = threadLocal.get();
        if (simpleDateFormat == null) {
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            threadLocal.set(simpleDateFormat2);
            return simpleDateFormat2;
        }
        return simpleDateFormat;
    }

    private static int f() {
        return DigestErrCode.MSG_PARTIAL_SUCCESS_OF_BATCH;
    }

    public static int g() {
        return NetworkUtil.getNetworkType(RFWApplication.getApplication());
    }

    /* compiled from: P */
    /* renamed from: lb0.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C10716b implements IDataConverter<a> {
        @Override // com.tencent.richframework.data.idata.IDataConverter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String getObserverKey(a aVar) {
            return "QFSClarityReportHelper";
        }

        @Override // com.tencent.richframework.data.idata.IDataConverter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void update(a aVar, a aVar2) {
            aVar.f414271a.clear();
            aVar.f414271a.putAll(aVar2.f414271a);
            aVar.C(aVar2.f414274d, aVar2.f414275e);
            aVar.f414273c = aVar2.f414273c;
            aVar.f414272b = aVar2.f414272b;
            aVar.f414277g = aVar2.f414277g;
            aVar.f414278h = aVar2.f414278h;
            aVar.f414279i = aVar2.f414279i;
            aVar.f414280j = aVar2.f414280j;
            aVar.f414281k = aVar2.f414281k;
            aVar.f414282l = aVar2.f414282l;
            aVar.f414283m = aVar2.f414283m;
            aVar.f414276f = aVar2.f414276f;
            aVar.f414284n = aVar2.f414284n;
            aVar.f414285o = aVar2.f414285o;
            aVar.f414286p = aVar2.f414286p;
        }

        @Override // com.tencent.richframework.data.idata.IDataConverter
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a cloneConvertData(a aVar) {
            return aVar;
        }
    }
}

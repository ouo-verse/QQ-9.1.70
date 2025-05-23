package cooperation.qzone.report.lp;

import android.os.Build;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_dc01500 implements LpReportInfo {
    public static final int DC00321_ACTION_TYPE = 8;
    public static final int DC00321_RESERVE_DOWNLOAD = 2;
    public static final int DC00321_RESERVE_FETCH_CONFIG = 1;
    public static final int DC00321_RESERVE_INSTALL = 3;
    public static final int DC00321_RESERVE_LAUNCH = 4;
    public static final int DC00321_SUB_ACTION_TYPE = 137;
    public static final int ERR_DOWNLOAD_CANCEL = 3;
    public static final int ERR_DOWNLOAD_CANCELED = 1;
    public static final int ERR_DOWNLOAD_FAILED = 2;
    public static final int ERR_INSTALL_EXTRACTLIBS = 3;
    public static final int ERR_INSTALL_EXTRACT_LIBS_TIME_COST = 101;
    public static final int ERR_INSTALL_FILE_NOT_EXIST = 1;
    public static final int ERR_INSTALL_LZMA_TIME_COST = 100;
    public static final int ERR_INSTALL_MD5_NOT_MATCH = 4;
    public static final int ERR_INSTALL_RENAME = 2;
    public static final int ERR_INSTALL_UNCOMPRESS_LZMA = 5;
    public static final int ERR_LAUNCH_NO_ACCOUNT = 6;
    public static final int ERR_LAUNCH_NO_INSTALLED = 7;
    public static final int ERR_LAUNCH_NO_NETWORK = 4;
    public static final int ERR_LAUNCH_PARAMS = 3;
    public static final int ERR_LAUNCH_PLUGIN_UPDATING = 5;
    public static final int ERR_LAUNCH_QQ_PHONE = 2;
    public static final int ERR_LAUNCH_SDK = 1;
    public static final int ERR_OK = 0;
    public static final String EVENT_DOWNLOAD = "event_download";
    public static final String EVENT_FETCH_CONFIG = "event_fetch_config";
    public static final String EVENT_INSTALL = "event_install";
    public static final String EVENT_LAUNCH = "event_launch";
    private static int S_EVENT_INDEX;
    public int download_type;
    public int event_index;
    public int ret_code;
    public double time_cost;
    public String uin = "";
    public String qua = "";
    public String plugin_id = "";
    public String plugin_version = "";
    public String plugin_version2 = "";
    public String event_id = "";
    public String client_time = "";
    public String network_type = "";
    public String download_id = "";
    public String network_type2 = "";
    public String attach_info = "";

    public static String getClientTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(System.currentTimeMillis()));
    }

    public static void reportConfig(String str, String str2, String str3, int i3) {
        LpReportInfo_dc01500 lpReportInfo_dc01500 = new LpReportInfo_dc01500();
        lpReportInfo_dc01500.uin = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount();
        lpReportInfo_dc01500.qua = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3();
        lpReportInfo_dc01500.plugin_id = str;
        lpReportInfo_dc01500.event_id = EVENT_FETCH_CONFIG;
        int i16 = S_EVENT_INDEX;
        S_EVENT_INDEX = i16 + 1;
        lpReportInfo_dc01500.event_index = i16;
        lpReportInfo_dc01500.plugin_version = str2;
        lpReportInfo_dc01500.plugin_version2 = str3;
        LpReportManager.getInstance().reportToDC01500(lpReportInfo_dc01500, false, true);
    }

    public static void reportDownload(String str, String str2, String str3, String str4, String str5, int i3, double d16, int i16, int i17, String str6) {
        LpReportInfo_dc01500 lpReportInfo_dc01500 = new LpReportInfo_dc01500();
        lpReportInfo_dc01500.uin = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount();
        lpReportInfo_dc01500.qua = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3();
        lpReportInfo_dc01500.plugin_id = str;
        lpReportInfo_dc01500.event_id = EVENT_DOWNLOAD;
        int i18 = S_EVENT_INDEX;
        S_EVENT_INDEX = i18 + 1;
        lpReportInfo_dc01500.event_index = i18;
        lpReportInfo_dc01500.plugin_version = str2;
        lpReportInfo_dc01500.plugin_version2 = str3;
        lpReportInfo_dc01500.download_id = str4;
        lpReportInfo_dc01500.download_type = i3;
        lpReportInfo_dc01500.client_time = getClientTime();
        lpReportInfo_dc01500.time_cost = d16;
        lpReportInfo_dc01500.network_type = str5;
        lpReportInfo_dc01500.attach_info = str6;
        lpReportInfo_dc01500.ret_code = i16;
        LpReportManager.getInstance().reportToDC01500(lpReportInfo_dc01500, false, true);
    }

    public static void reportInstall(String str, String str2, String str3, double d16, int i3) {
        LpReportInfo_dc01500 lpReportInfo_dc01500 = new LpReportInfo_dc01500();
        lpReportInfo_dc01500.uin = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount();
        lpReportInfo_dc01500.qua = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3();
        lpReportInfo_dc01500.plugin_id = str;
        lpReportInfo_dc01500.event_id = EVENT_INSTALL;
        int i16 = S_EVENT_INDEX;
        S_EVENT_INDEX = i16 + 1;
        lpReportInfo_dc01500.event_index = i16;
        lpReportInfo_dc01500.plugin_version = str2;
        lpReportInfo_dc01500.plugin_version2 = str3;
        lpReportInfo_dc01500.client_time = getClientTime();
        lpReportInfo_dc01500.time_cost = d16;
        lpReportInfo_dc01500.ret_code = i3;
        LpReportManager.getInstance().reportToDC01500(lpReportInfo_dc01500, false, true);
    }

    public static void reportLaunch(String str, String str2, double d16, int i3, String str3) {
        LpReportInfo_dc01500 lpReportInfo_dc01500 = new LpReportInfo_dc01500();
        lpReportInfo_dc01500.uin = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount();
        lpReportInfo_dc01500.qua = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3();
        lpReportInfo_dc01500.plugin_id = str;
        lpReportInfo_dc01500.event_id = EVENT_LAUNCH;
        int i16 = S_EVENT_INDEX;
        S_EVENT_INDEX = i16 + 1;
        lpReportInfo_dc01500.event_index = i16;
        lpReportInfo_dc01500.plugin_version = str2;
        lpReportInfo_dc01500.client_time = getClientTime();
        lpReportInfo_dc01500.time_cost = d16 / 1000.0d;
        lpReportInfo_dc01500.ret_code = i3;
        lpReportInfo_dc01500.attach_info = str3;
        LpReportManager.getInstance().reportToDC01500(lpReportInfo_dc01500, false, true);
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "dc01500: plugin_id:" + this.plugin_id + " event_id:" + this.event_id + " ret_code:" + this.ret_code;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("host_uin", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount());
        LpReportUtils.safePut(hashMap, "qua", this.qua);
        LpReportUtils.safePut(hashMap, "plugin_id", this.plugin_id);
        LpReportUtils.safePut(hashMap, "plugin_ver", this.plugin_version);
        LpReportUtils.safePut(hashMap, "plugin_ver2", this.plugin_version2);
        LpReportUtils.safePut(hashMap, "event_id", this.event_id);
        hashMap.put("event_index", String.valueOf(this.event_index));
        hashMap.put("client_time", String.valueOf(this.client_time));
        LpReportUtils.safePut(hashMap, "time_cost", String.format("%.2f", Double.valueOf(this.time_cost)));
        hashMap.put("ret_code", String.valueOf(this.ret_code));
        LpReportUtils.safePut(hashMap, "network_type", this.network_type);
        LpReportUtils.safePut(hashMap, "download_id", this.download_id);
        hashMap.put(VRReportDefine$ReportParam.DOWNLOAD_TYPE, String.valueOf(this.download_type));
        LpReportUtils.safePut(hashMap, "network_type2", this.network_type2);
        LpReportUtils.safePut(hashMap, "attach_info", this.attach_info);
        hashMap.put("device_model", DeviceInfoMonitor.getModel());
        hashMap.put("device_os_ver", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("appid", String.valueOf(1000027));
        return hashMap;
    }

    public static void reportInstall(String str, String str2, String str3, double d16, int i3, String str4) {
        LpReportInfo_dc01500 lpReportInfo_dc01500 = new LpReportInfo_dc01500();
        lpReportInfo_dc01500.uin = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount();
        lpReportInfo_dc01500.qua = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3();
        lpReportInfo_dc01500.plugin_id = str;
        lpReportInfo_dc01500.event_id = EVENT_INSTALL;
        int i16 = S_EVENT_INDEX;
        S_EVENT_INDEX = i16 + 1;
        lpReportInfo_dc01500.event_index = i16;
        lpReportInfo_dc01500.plugin_version = str2;
        lpReportInfo_dc01500.plugin_version2 = str3;
        lpReportInfo_dc01500.client_time = getClientTime();
        lpReportInfo_dc01500.time_cost = d16;
        lpReportInfo_dc01500.ret_code = i3;
        lpReportInfo_dc01500.attach_info = str4;
        LpReportManager.getInstance().reportToDC01500(lpReportInfo_dc01500, false, true);
    }

    public static void reportDownload(String str, String str2, String str3, String str4, String str5, int i3, double d16, int i16, int i17, String str6, String str7) {
        LpReportInfo_dc01500 lpReportInfo_dc01500 = new LpReportInfo_dc01500();
        lpReportInfo_dc01500.uin = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount();
        lpReportInfo_dc01500.qua = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3();
        lpReportInfo_dc01500.plugin_id = str;
        lpReportInfo_dc01500.event_id = EVENT_DOWNLOAD;
        int i18 = S_EVENT_INDEX;
        S_EVENT_INDEX = i18 + 1;
        lpReportInfo_dc01500.event_index = i18;
        lpReportInfo_dc01500.plugin_version = str2;
        lpReportInfo_dc01500.plugin_version2 = str3;
        lpReportInfo_dc01500.download_id = str4;
        lpReportInfo_dc01500.download_type = i3;
        lpReportInfo_dc01500.client_time = getClientTime();
        lpReportInfo_dc01500.time_cost = d16;
        lpReportInfo_dc01500.network_type = str5;
        lpReportInfo_dc01500.attach_info = str6;
        lpReportInfo_dc01500.network_type2 = str7;
        lpReportInfo_dc01500.ret_code = i16;
        LpReportManager.getInstance().reportToDC01500(lpReportInfo_dc01500, false, true);
    }
}

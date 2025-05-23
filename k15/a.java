package k15;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.statistics.l;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import cooperation.vip.pb.TianShuReport;
import cooperation.vip.tianshu.TianShuManager;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f411422a = "";

    /* renamed from: b, reason: collision with root package name */
    private static String f411423b = "";

    /* renamed from: c, reason: collision with root package name */
    private static String f411424c = "";

    public static TianShuReport.UserActionReport a(TianShuReportData tianShuReportData) {
        TianShuReport.UserActionReport userActionReport = new TianShuReport.UserActionReport();
        b(userActionReport, tianShuReportData);
        userActionReport.appid.set(String.valueOf(tianShuReportData.mAppId));
        userActionReport.to_uid.set(String.valueOf(tianShuReportData.mToUid));
        userActionReport.trace_detail.set(String.valueOf(tianShuReportData.mTraceDetail));
        userActionReport.trace_index.set(String.valueOf(tianShuReportData.mTraceIndex));
        userActionReport.page_id.set(String.valueOf(tianShuReportData.mPageId));
        userActionReport.item_id.set(String.valueOf(tianShuReportData.mItemId));
        userActionReport.sub_item_id.set(String.valueOf(tianShuReportData.mSubItemId));
        userActionReport.module_id.set(String.valueOf(tianShuReportData.mModuleId));
        userActionReport.sub_module_id.set(String.valueOf(tianShuReportData.mSubModuleId));
        userActionReport.position_id.set(String.valueOf(tianShuReportData.mPositionId));
        userActionReport.test_id.set(tianShuReportData.mTestId);
        userActionReport.rule_id.set(tianShuReportData.mRuleId);
        userActionReport.oper_time.set(tianShuReportData.mOperTime);
        userActionReport.action_id.set(tianShuReportData.mActionId);
        userActionReport.action_value.set(tianShuReportData.mActionValue);
        userActionReport.action_attr.set(tianShuReportData.mActionAttr);
        userActionReport.busi_info.set(String.valueOf(tianShuReportData.mBusiInfo));
        userActionReport.item_type.set(String.valueOf(tianShuReportData.mItemType));
        return userActionReport;
    }

    private static void b(TianShuReport.UserActionReport userActionReport, TianShuReportData tianShuReportData) {
        String str;
        String str2 = tianShuReportData.mTraceId;
        if (TextUtils.isEmpty(str2)) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime != null) {
                str = runtime.getAccount();
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                userActionReport.trace_id.set(str + "_" + NetConnInfoCenter.getServerTime());
            }
        } else {
            userActionReport.trace_id.set(String.valueOf(str2));
        }
        String valueOf = String.valueOf(tianShuReportData.mTriggerInfo);
        if (TextUtils.isEmpty(valueOf)) {
            String traceInfoFromCache = TianShuManager.getInstance().getTraceInfoFromCache(String.valueOf(tianShuReportData.mItemId));
            if (!TextUtils.isEmpty(traceInfoFromCache)) {
                userActionReport.trigger_info.set(traceInfoFromCache);
            }
        } else {
            userActionReport.trigger_info.set(valueOf);
        }
        int i3 = tianShuReportData.mTraceNum;
        if (i3 == -1) {
            i3 = 1;
        }
        userActionReport.trace_num.set(i3);
    }

    public static String c() {
        if (TextUtils.isEmpty(f411423b)) {
            f411423b = l.f(BaseApplication.getContext()).l();
        }
        if (!TextUtils.isEmpty(f411423b)) {
            return f411423b;
        }
        return "";
    }

    public static String d() {
        String str = f411422a;
        if (str != null && str.length() != 0) {
            return f411422a;
        }
        try {
            f411422a = o.c();
        } catch (Exception unused) {
        }
        return f411422a;
    }

    public static String e() {
        int networkType = NetworkUtil.getNetworkType(BaseApplication.getContext());
        if (networkType != 1) {
            if (networkType != 2) {
                if (networkType != 3) {
                    if (networkType != 4) {
                        return "UNKNOW";
                    }
                    return "4G";
                }
                return "3G";
            }
            return "2G";
        }
        return Global.TRACKING_WIFI;
    }

    public static String f() {
        MobileQQ mobileQQ;
        String str;
        if (TextUtils.isEmpty(f411424c) && (mobileQQ = MobileQQ.sMobileQQ) != null) {
            if (AppSetting.t(mobileQQ.getApplicationContext())) {
                str = "1";
            } else {
                str = "0";
            }
            f411424c = str;
        }
        return f411424c;
    }

    public static TianShuReport.UserCommReport g(String str) {
        TianShuReport.UserCommReport userCommReport = new TianShuReport.UserCommReport();
        if (TextUtils.isEmpty(str)) {
            str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        }
        userCommReport.uid.set(String.valueOf(str));
        userCommReport.guid.set(String.valueOf(c()));
        userCommReport.city_code.set(String.valueOf(((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCityCode()));
        userCommReport.platform.set("AND");
        userCommReport.client_type.set("SQ");
        userCommReport.app_version.set(AppSetting.n());
        userCommReport.qua.set(String.valueOf(QUA.getQUA3()));
        userCommReport.network_type.set(e());
        if (PrivacyPolicyHelper.isUserAllow()) {
            userCommReport.mobile_type.set(String.valueOf(DeviceInfoMonitor.getModel()));
            userCommReport.os_version.set(String.valueOf(ah.t()));
        } else {
            userCommReport.mobile_type.set("");
            userCommReport.os_version.set("");
        }
        userCommReport.qimei.set(String.valueOf(d()));
        userCommReport.brand.set(Build.BRAND);
        userCommReport.sub_platform.set(f());
        userCommReport.appid.set(AppSetting.f());
        return userCommReport;
    }

    public static Bundle h(String str) {
        int i3;
        Bundle bundle = new Bundle();
        if (str == null) {
            return bundle;
        }
        int indexOf = str.indexOf(63);
        if (indexOf >= 0 && (i3 = indexOf + 1) < str.length()) {
            String substring = str.substring(i3);
            if (TextUtils.isEmpty(substring)) {
                return bundle;
            }
            String[] split = substring.split(ContainerUtils.FIELD_DELIMITER);
            if (split != null) {
                for (String str2 : split) {
                    String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split2 != null && split2.length == 2) {
                        try {
                            bundle.putString(split2[0], URLDecoder.decode(split2[1], "UTF-8"));
                        } catch (UnsupportedEncodingException e16) {
                            e16.printStackTrace();
                        } catch (IllegalArgumentException e17) {
                            QLog.e("tools", 1, "parseUrlParams", e17);
                        }
                    }
                }
            }
        }
        return bundle;
    }
}

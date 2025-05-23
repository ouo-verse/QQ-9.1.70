package com.tencent.mobileqq.intervideo.groupvideo;

import android.os.Build;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.intervideo.IAppSettingUtil;
import com.tencent.mobileqq.intervideo.IBaseApplicationImplUtil;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes33.dex */
public class IVPluginDataReporter implements IVPluginReportInterface {
    public static final String REPORT_TAG = "dc03445";
    private static final String TAG = "IVPluginDataReporter";
    private String mDepartment;
    private int mFrameVersion;
    private String mLastOpName;
    private int mOpIn;
    private int mOpResult;
    private String mRoomType;
    private String mRoomid;
    private String mSource;
    private String mTimeLong;
    private String networktype = "";
    private String mOpType = "";
    private String mOpName = "";
    private String mToUin = "";

    /* renamed from: d1, reason: collision with root package name */
    private String f238172d1 = "";

    /* renamed from: d2, reason: collision with root package name */
    private String f238173d2 = "";

    /* renamed from: d3, reason: collision with root package name */
    private String f238174d3 = "";

    /* renamed from: d4, reason: collision with root package name */
    private String f238175d4 = "";
    private int mPlatform = 2;
    private String mSysVersion = Build.VERSION.RELEASE;
    private String mMacVersion = DeviceInfoMonitor.getModel();
    private String mQQVersion = ((IAppSettingUtil) QRoute.api(IAppSettingUtil.class)).getSubVersion();
    private String mSdkversion = String.valueOf(com.tencent.mobileqq.cooperation.a.a(((IBaseApplicationImplUtil) QRoute.api(IBaseApplicationImplUtil.class)).getContext()));

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface
    public void report() {
        String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_14).format(new Date(System.currentTimeMillis()));
        this.networktype = HttpUtil.getNetWorkType() + "";
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "IVPluginDataReporter: department = " + this.mDepartment + " op_type = " + this.mOpType + " op_name = " + this.mOpName + " op_in = " + this.mOpIn + " d1= " + this.f238172d1 + " d2=" + this.f238173d2 + " d3=" + this.f238174d3 + " d4=" + this.f238175d4 + " timelong=" + this.mTimeLong + " op_result = " + this.mOpResult + " qq_version = " + this.mQQVersion);
        }
        if (!TextUtils.isEmpty(this.mDepartment) && !TextUtils.isEmpty(this.mOpName) && !TextUtils.isEmpty(this.mOpType)) {
            ReportController.n(null, REPORT_TAG, this.mDepartment, this.mToUin, this.mOpType, this.mOpName, this.mOpIn, 1, this.mOpResult, this.f238172d1, this.f238173d2, this.f238174d3, this.f238175d4 + "|" + this.mTimeLong + "|" + this.mRoomid + "|" + this.mRoomType + "|" + this.mSource + "|" + this.networktype + "|" + this.mPlatform + "|" + this.mMacVersion + "|" + this.mSysVersion + "|" + this.mFrameVersion + "|" + this.mSdkversion + "|" + this.mQQVersion + "|" + format + "|" + this.mLastOpName);
            return;
        }
        QLog.e(TAG, 1, "has null str ,stop report");
    }

    public IVPluginDataReporter toUin(String str) {
        this.mToUin = str;
        return this;
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface
    public IVPluginDataReporter d1(String str) {
        this.f238172d1 = str;
        return this;
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface
    public IVPluginDataReporter d2(String str) {
        this.f238173d2 = str;
        return this;
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface
    public IVPluginDataReporter d3(String str) {
        this.f238174d3 = str;
        return this;
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface
    public IVPluginDataReporter d4(String str) {
        this.f238175d4 = str;
        return this;
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface
    public IVPluginDataReporter opDepartment(String str) {
        this.mDepartment = str;
        return this;
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface
    public IVPluginDataReporter opIn(int i3) {
        this.mOpIn = i3;
        return this;
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface
    public IVPluginDataReporter opName(String str) {
        this.mOpName = str;
        return this;
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface
    public IVPluginDataReporter opResult(int i3) {
        this.mOpResult = i3;
        return this;
    }

    @Override // com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVPluginReportInterface
    public IVPluginDataReporter opType(String str) {
        this.mOpType = str;
        return this;
    }
}

package com.tencent.mobileqq.nearby.report.impl;

import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ads.data.AdParam;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.nearby.report.IODReportTask;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.xweb.internal.ConstValue;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import w92.a;
import w92.b;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ODReportTaskImpl implements IODReportTask {
    private static final String REPORT_BID_NAME = "b_sng_im_personal_live";
    private static final String REPORT_TABLE_NAME = "personal_live_base";
    private Application mApplication;
    private final Bundle mBundle;
    private String mQQVersion;

    public ODReportTaskImpl() {
        this(BaseApplication.getContext());
    }

    private Bundle createBaseReportBundle(Application application) {
        Bundle bundle = new Bundle();
        bundle.putString("platform", "Android");
        bundle.putString(IPublicAccountBrowser.KEY_UIN_TYPE, "0");
        String str = Build.MANUFACTURER;
        bundle.putString("manufacturer", str);
        String str2 = Build.VERSION.RELEASE;
        bundle.putString(AdParam.OSVERSION, str2);
        bundle.putString("osVersion", str2);
        bundle.putString("rom", str);
        bundle.putString("device", ah.S());
        bundle.putString("qqversion", this.mQQVersion);
        bundle.putString(ConstValue.INIT_CONFIG_KEY_CLIENT_VERSION, this.mQQVersion);
        bundle.putString("actiontime", String.valueOf(System.currentTimeMillis() / 1000));
        bundle.putString("network", String.valueOf(b.a(application)));
        bundle.putString(QzoneWebMusicJsPlugin.EVENT_GET_NETWORKE_TYPE, String.valueOf(b.a(application)));
        bundle.putString("timestr", String.valueOf(System.currentTimeMillis() / 1000));
        bundle.putString("reporttime", String.valueOf(System.currentTimeMillis() / 1000));
        return bundle;
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public IODReportTask obj1(int i3) {
        return addKeyValue("obj1", i3);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public IODReportTask obj2(String str) {
        return addKeyValue("obj2", str);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public IODReportTask obj3(int i3) {
        return addKeyValue("obj3", i3);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public void report() {
        a.f445082b.c(this.mBundle);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public IODReportTask setAnchor(long j3) {
        return addKeyValue("anchor", j3);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public IODReportTask setAnchorId(long j3) {
        return addKeyValue("anchorid", j3);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public IODReportTask setInstallSrc(String str) {
        return addKeyValue("installsrc", str);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public IODReportTask setReferId(String str) {
        return addKeyValue("referer_id", str);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public IODReportTask setUserId(String str) {
        return addKeyValue("userid", str);
    }

    public ODReportTaskImpl(Application application) {
        this.mApplication = application;
        this.mQQVersion = ah.P();
        Bundle createBaseReportBundle = createBaseReportBundle(this.mApplication);
        this.mBundle = createBaseReportBundle;
        createBaseReportBundle.putString("tid", REPORT_TABLE_NAME);
        createBaseReportBundle.putString("bid", REPORT_BID_NAME);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setAction(String str) {
        this.mBundle.putString("action", str);
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setBid(String str) {
        this.mBundle.putString("bid", str);
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setExtCol1(String str) {
        return addKeyValue("extcol1", str);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setExtCol2(String str) {
        return addKeyValue("extcol2", str);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setExtCol3(String str) {
        return addKeyValue("extcol3", str);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setExtCol4(String str) {
        return addKeyValue("extcol4", str);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setExtCol5(String str) {
        return addKeyValue("extcol5", str);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setModule(String str) {
        this.mBundle.putString("module", str);
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setOperName(String str) {
        this.mBundle.putString("opername", str);
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setRoomId(int i3) {
        this.mBundle.putInt("roomId", i3);
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setSource(String str) {
        this.mBundle.putString("source", str);
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setTDBankImpDate(String str) {
        this.mBundle.putString("tdbank_imp_date", str);
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setTid(String str) {
        this.mBundle.putString("tid", str);
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setType(String str) {
        this.mBundle.putString("type", str);
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setUin(String str) {
        this.mBundle.putString("uin", str);
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setIntCol1(int i3) {
        return addKeyValue("int1", i3);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setIntCol2(int i3) {
        return addKeyValue("int2", i3);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setRes1(double d16) {
        return addKeyValue("res1", d16);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setRes2(double d16) {
        return addKeyValue("res2", d16);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setRes3(double d16) {
        return addKeyValue("res3", d16);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setIntCol1(long j3) {
        return addKeyValue("int1", j3);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setIntCol2(long j3) {
        return addKeyValue("int2", j3);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setRes1(String str) {
        return addKeyValue("res1", str);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setRes2(String str) {
        return addKeyValue("res2", str);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl setRes3(String str) {
        return addKeyValue("res3", str);
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl addKeyValue(String str, int i3) {
        this.mBundle.putString(str, String.valueOf(i3));
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl addKeyValue(String str, double d16) {
        this.mBundle.putString(str, String.valueOf(d16));
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl addKeyValue(String str, long j3) {
        this.mBundle.putString(str, String.valueOf(j3));
        return this;
    }

    @Override // com.tencent.mobileqq.nearby.report.IODReportTask
    public ODReportTaskImpl addKeyValue(String str, String str2) {
        if (str2 == null) {
            str2 = "null";
        }
        this.mBundle.putString(str, str2.replace(ContainerUtils.FIELD_DELIMITER, "_"));
        return this;
    }
}

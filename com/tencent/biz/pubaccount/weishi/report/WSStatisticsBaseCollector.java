package com.tencent.biz.pubaccount.weishi.report;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.util.ai;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.p;
import com.tencent.biz.pubaccount.weishi.util.t;
import com.tencent.biz.pubaccount.weishi.util.y;
import com.tencent.biz.qqstory.utils.l;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.tmassistantbase.util.GlobalUtil;
import cooperation.qzone.QUA;
import cooperation.qzone.remote.ServiceConst;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSStatisticsBaseCollector {
    public static final String KEY_REF_PAGE_ID = "key_ref_page_id";
    private String mEventName;
    private String mExtendInfo;
    private String mOperationId;
    private String mPushId;
    private String mSopName;
    private String mSubSession;
    private String mTestId;
    private static final String SCREEN_RES = y.c();
    private static final String UI_VERSION = y.b();
    private static final String APP_VERSION = y.a();

    private String getExtendInfo() {
        return this.mExtendInfo;
    }

    private String getLocalIpAddress() {
        try {
            return p.d();
        } catch (NullPointerException e16) {
            com.tencent.qqperf.monitor.crash.catchedexception.a.b(e16);
            return "";
        }
    }

    private String getOperationId() {
        return this.mOperationId;
    }

    private String getPushId() {
        return this.mPushId;
    }

    private String getRefPageId() {
        if (TextUtils.isEmpty(e.f81527b)) {
            return ai.i(KEY_REF_PAGE_ID, "");
        }
        return e.f81527b;
    }

    private String getTestId() {
        return f.h(this.mTestId);
    }

    public Map<String, String> getBaseParams() {
        String str;
        HashMap hashMap = new HashMap(38);
        hashMap.put(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, p.j());
        hashMap.put("qimei36", p.k());
        hashMap.put("mac", "");
        hashMap.put("dev_brand", GlobalUtil.getInstance().getBrand());
        hashMap.put("dev_model", DeviceInfoMonitor.getModel());
        hashMap.put("os", "Android");
        hashMap.put("screen_res", SCREEN_RES);
        hashMap.put("operating_system_version", Build.VERSION.RELEASE);
        hashMap.put("ui_version", UI_VERSION);
        hashMap.put("app_ver", APP_VERSION);
        hashMap.put("wifiBssid", p.p());
        hashMap.put("push_id", getPushId());
        hashMap.put("ip", getLocalIpAddress());
        hashMap.put(ServiceConst.PARA_SESSION_ID, WSPublicAccReport.getInstance().getSessionId());
        hashMap.put("session_stamp", WSPublicAccReport.getInstance().getSessionStamp());
        hashMap.put("sop_name", getSopName());
        hashMap.put("qua", QUA.getQUA3());
        hashMap.put("qq", bb.y());
        if (l.c(BaseApplicationImpl.getApplication())) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("if_install_weishi", str);
        hashMap.put("person_id", bb.q());
        hashMap.put("time", String.valueOf(System.currentTimeMillis()));
        hashMap.put("network_type", p.g());
        hashMap.put("extended_fields", getExtendInfo());
        hashMap.put("scenes_from", f.f());
        hashMap.put("operation_id", getOperationId());
        hashMap.put("test_id", getTestId());
        hashMap.put("ref_page_id", getRefPageId());
        hashMap.put("sub_session_id", getSubSession());
        hashMap.put("hardware_info", t.g(BaseApplication.getContext()));
        hashMap.put("hardware_level", String.valueOf(t.m(BaseApplication.getContext())));
        hashMap.put("device_type", p.c());
        hashMap.put("device_screen_inches", String.valueOf(p.l()));
        return hashMap;
    }

    public String getSopName() {
        return this.mSopName;
    }

    public String getSubSession() {
        if (TextUtils.equals(this.mEventName, "gzh_pageview") && TextUtils.equals(getSopName(), "feeds")) {
            return "";
        }
        return this.mSubSession;
    }

    public void setEventName(String str) {
        this.mEventName = str;
    }

    public void setExtendInfo(String str) {
        this.mExtendInfo = str;
    }

    public void setOperationId(String str) {
        this.mOperationId = str;
    }

    public void setPushId(String str) {
        this.mPushId = str;
    }

    public void setSopName(String str) {
        this.mSopName = str;
    }

    public void setSubSession(String str) {
        this.mSubSession = str;
    }

    public void setTestId(String str) {
        this.mTestId = str;
    }
}

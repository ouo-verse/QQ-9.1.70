package com.tencent.biz.pubaccount.weishi.report;

import UserGrowth.stWeishiDengtaReportRsp;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.qzone.widget.u;
import com.tencent.beacon.event.UserAction;
import com.tencent.biz.pubaccount.weishi.net.common.j;
import com.tencent.biz.pubaccount.weishi.request.newreq.WSBeaconSendRequest;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSStatisticsReporter {
    public static final String BEACON_REALTIME_DEBUG_KEY = "0M000A1RC72MXXRH";
    public static final int REPORT_REQUEST_ERROR_TYPE_CLIENT = 1;
    public static final int REPORT_REQUEST_ERROR_TYPE_PARSE_DATA = 3;
    public static final int REPORT_REQUEST_ERROR_TYPE_SERVER = 2;
    private static final String TAG = "WSStatisticsReporter";
    private static final String TAG_VIDEO_SESSION = "reportVideoSession";
    private WSStatisticsBaseCollector mBaseCollector;
    private Builder mBuilder;
    private String mEventName;
    private boolean mFlush;
    private boolean mIsSendServer;
    private HashMap<String, String> mReportParams = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends com.tencent.biz.pubaccount.weishi.net.common.b<stWeishiDengtaReportRsp, Object> {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        protected void a(j jVar) {
            x.f("beaconData2Server", "BeaconSendRequest onTaskResponse failed code:" + jVar.a() + ", msg:" + jVar.b());
            WSStatisticsReporter.this.reportRequestFailure(String.valueOf(1), String.valueOf(jVar.a()), jVar.b());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Object c(com.tencent.biz.pubaccount.weishi.net.common.g<stWeishiDengtaReportRsp> gVar, stWeishiDengtaReportRsp stweishidengtareportrsp, com.tencent.biz.pubaccount.weishi.net.d dVar) {
            x.b("beaconData2Server", "BeaconSendRequest onTaskResponse succeed: " + stweishidengtareportrsp.code + " , " + stweishidengtareportrsp.f25134msg);
            if (stweishidengtareportrsp.code == 0) {
                return null;
            }
            WSStatisticsReporter.this.reportRequestFailure(String.valueOf(2), String.valueOf(stweishidengtareportrsp.code), stweishidengtareportrsp.f25134msg);
            return null;
        }
    }

    WSStatisticsReporter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGeneralExtParams(Map<String, String> map) {
        map.put("scenes_channel_from", getEnterPublicAccFrom());
        map.put("last_test_id", WSPublicAccReport.getInstance().getLocalTestId());
        map.put("teen", String.valueOf(com.tencent.biz.pubaccount.weishi.net.common.f.b()));
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_QQ_MODE, String.valueOf(com.tencent.biz.pubaccount.weishi.net.common.f.a()));
        if (uy.a.f440578a.f()) {
            map.put("bottom_tab_id", uy.b.f440579a.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beaconData2Server() {
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new WSBeaconSendRequest(this.mEventName, this.mReportParams)).b(new a());
    }

    private static String getEnterPublicAccFrom() {
        String enterPublicAccFrom = WSPublicAccReport.getInstance().getEnterPublicAccFrom();
        enterPublicAccFrom.hashCode();
        char c16 = '\uffff';
        switch (enterPublicAccFrom.hashCode()) {
            case -1167970904:
                if (enterPublicAccFrom.equals("from_float_window")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1142266013:
                if (enterPublicAccFrom.equals("from_search_trends_ws")) {
                    c16 = 1;
                    break;
                }
                break;
            case -314972999:
                if (enterPublicAccFrom.equals("from_open_home_then_video")) {
                    c16 = 2;
                    break;
                }
                break;
            case 15659634:
                if (enterPublicAccFrom.equals("from_user_contacts")) {
                    c16 = 3;
                    break;
                }
                break;
            case 403146370:
                if (enterPublicAccFrom.equals("from_qq_chat")) {
                    c16 = 4;
                    break;
                }
                break;
            case 712893722:
                if (enterPublicAccFrom.equals("from_operation_h5")) {
                    c16 = 5;
                    break;
                }
                break;
            case 1312853792:
                if (enterPublicAccFrom.equals("from_audio_assistant")) {
                    c16 = 6;
                    break;
                }
                break;
            case 1330251343:
                if (enterPublicAccFrom.equals("from_qq_scheme")) {
                    c16 = 7;
                    break;
                }
                break;
            case 1949083137:
                if (enterPublicAccFrom.equals("from_trends_tab")) {
                    c16 = '\b';
                    break;
                }
                break;
            case 1977485053:
                if (enterPublicAccFrom.equals("from_search_rzh_ws")) {
                    c16 = '\t';
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return "15";
            case 1:
                return "10";
            case 2:
            case 5:
            case 7:
                return WSPublicAccReport.getInstance().getScenesChannelFrom();
            case 3:
                return "3";
            case 4:
                return "6";
            case 6:
                return "5";
            case '\b':
                return "1";
            case '\t':
                return "2";
            default:
                return "0";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleObjectParams(Map<String, Object> map) {
        Object obj = map.get("feed_pass_key");
        if (obj instanceof Map) {
            this.mBuilder.params.put("feed_pass_key", new Gson().toJson((Map) obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printReportLog() {
        if (QLog.isColorLevel()) {
            HashMap hashMap = new HashMap(this.mBuilder.params);
            x.b("WSReportFeedPassGlobalKey", "[EventReport] mEventNameKey:" + this.mEventName + ", feedPassKey:" + ((String) hashMap.get("feed_pass_key")) + ", globalKey:" + ((String) hashMap.get("global_key")));
            hashMap.remove("feed_pass_key");
            hashMap.remove("global_key");
            x.j(TAG, "[EventReport] mSceneFrom:" + this.mReportParams.get("scenes_from") + ", mEventName:" + this.mEventName + ", mSopName:" + this.mReportParams.get("sop_name") + ", mPosition:" + this.mReportParams.get("position") + ", mSubSessionId:" + this.mReportParams.get("sub_session_id") + ", mTabId:" + ((String) this.mBuilder.extParams.get(u.COLUMN_TAB_ID)) + ", mCustomParams:" + hashMap.toString() + ", mBaseParams:" + this.mBaseCollector.getBaseParams().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportRequestFailure(String str, String str2, String str3) {
        String str4;
        String str5;
        HashMap<String, String> hashMap = new HashMap<>();
        String str6 = this.mEventName;
        HashMap<String, String> hashMap2 = this.mReportParams;
        if (hashMap2 == null) {
            str4 = "";
            str5 = str4;
        } else {
            str4 = hashMap2.get("position");
            str5 = this.mReportParams.get("sop_name");
        }
        hashMap.put("event_name", str6);
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        hashMap.put("position", str4);
        hashMap.put("sop_name", TextUtils.isEmpty(str5) ? "" : str5);
        hashMap.put("err_type", str);
        hashMap.put(CheckForwardServlet.KEY_ERR_CODE, str2);
        hashMap.put("err_msg", str3);
        WSReportDc00898.v(hashMap);
        g.d().o(hashMap);
    }

    public void report() {
        final String j3 = f.j();
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.report.WSStatisticsReporter.1
            @Override // java.lang.Runnable
            public void run() {
                if (WSStatisticsReporter.this.mBaseCollector == null) {
                    return;
                }
                WSStatisticsReporter.this.mBaseCollector.setEventName(WSStatisticsReporter.this.mEventName);
                WSStatisticsReporter wSStatisticsReporter = WSStatisticsReporter.this;
                wSStatisticsReporter.addGeneralExtParams(wSStatisticsReporter.mBuilder.extParams);
                WSStatisticsReporter.this.mBaseCollector.setExtendInfo(new Gson().toJson(WSStatisticsReporter.this.mBuilder.extParams));
                WSStatisticsReporter wSStatisticsReporter2 = WSStatisticsReporter.this;
                wSStatisticsReporter2.handleObjectParams(wSStatisticsReporter2.mBuilder.objectParams);
                WSStatisticsReporter.this.mReportParams.putAll(WSStatisticsReporter.this.mBuilder.params);
                WSStatisticsReporter.this.mBaseCollector.setSubSession(j3);
                WSStatisticsReporter.this.mReportParams.putAll(WSStatisticsReporter.this.mBaseCollector.getBaseParams());
                UserAction.onUserAction(WSStatisticsReporter.this.mEventName, true, -1L, -1L, WSStatisticsReporter.this.mReportParams, true);
                if (WSStatisticsReporter.this.mIsSendServer) {
                    WSStatisticsReporter.this.beaconData2Server();
                }
                x.b(WSStatisticsReporter.TAG_VIDEO_SESSION, "mEventName :" + WSStatisticsReporter.this.mEventName + ", position: " + ((String) WSStatisticsReporter.this.mReportParams.get("position")) + ", sopName: " + ((String) WSStatisticsReporter.this.mReportParams.get("sop_name")) + ", videoPageSession: " + ((String) WSStatisticsReporter.this.mReportParams.get("sub_session_id")));
                WSStatisticsReporter.this.printReportLog();
            }
        });
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class Builder {
        private boolean flush;
        private Map<String, String> params = new HashMap();
        private Map<String, String> extParams = new HashMap();
        private Map<String, Object> objectParams = new HashMap();
        private String eventName = "";
        private boolean isSendServer = true;
        private WSStatisticsBaseCollector baseCollector = new WSStatisticsBaseCollector();

        public Builder addObjectParams(String str, Object obj) {
            if (!TextUtils.isEmpty(str)) {
                this.objectParams.put(str, obj);
            }
            return this;
        }

        public Builder addParams(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                Map<String, String> map = this.params;
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                map.put(str, str2);
            }
            return this;
        }

        public WSStatisticsReporter build(String str) {
            this.eventName = str;
            if (TextUtils.equals(str, "gzh_click")) {
                e.f81528c = true;
            }
            return new WSStatisticsReporter(this);
        }

        public Map<String, String> getExtParams() {
            return this.extParams;
        }

        public Map<String, String> getParams() {
            return this.params;
        }

        public String getSopName() {
            WSStatisticsBaseCollector wSStatisticsBaseCollector = this.baseCollector;
            if (wSStatisticsBaseCollector != null) {
                return wSStatisticsBaseCollector.getSopName();
            }
            return "";
        }

        public Builder setFlush(boolean z16) {
            this.flush = z16;
            return this;
        }

        public Builder setOperationId(String str) {
            WSStatisticsBaseCollector wSStatisticsBaseCollector = this.baseCollector;
            if (wSStatisticsBaseCollector != null) {
                wSStatisticsBaseCollector.setOperationId(str);
            }
            return this;
        }

        public Builder setPushId(String str) {
            WSStatisticsBaseCollector wSStatisticsBaseCollector = this.baseCollector;
            if (wSStatisticsBaseCollector != null) {
                wSStatisticsBaseCollector.setPushId(str);
            }
            return this;
        }

        public Builder setSendWeSeeServer(boolean z16) {
            this.isSendServer = z16;
            return this;
        }

        public Builder setSopName(String str) {
            WSStatisticsBaseCollector wSStatisticsBaseCollector = this.baseCollector;
            if (wSStatisticsBaseCollector != null) {
                wSStatisticsBaseCollector.setSopName(str);
            }
            return this;
        }

        public Builder setTabId(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.extParams.put(u.COLUMN_TAB_ID, str);
            }
            return this;
        }

        public Builder setTestId(String str) {
            WSStatisticsBaseCollector wSStatisticsBaseCollector = this.baseCollector;
            if (wSStatisticsBaseCollector != null) {
                wSStatisticsBaseCollector.setTestId(str);
            }
            return this;
        }

        public Builder addExtParams(Map<String, String> map) {
            if (map != null) {
                this.extParams.putAll(map);
            }
            return this;
        }

        public Builder addParams(Map<String, String> map) {
            if (map != null) {
                this.params.putAll(map);
            }
            return this;
        }
    }

    WSStatisticsReporter(Builder builder) {
        this.mEventName = builder.eventName;
        this.mFlush = builder.flush;
        this.mIsSendServer = builder.isSendServer;
        this.mBaseCollector = builder.baseCollector;
        this.mBuilder = builder;
    }
}

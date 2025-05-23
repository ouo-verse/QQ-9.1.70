package cooperation.qzone.report;

import android.text.TextUtils;
import com.tencent.open.adapter.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.utils.JsonUtils;
import cooperation.qzone.report.datong.QZoneDTParamBuilder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes28.dex */
public class QZonePushReporter {
    public static final String APP_VERSION = "app_version";
    public static final String EVENT_CODE = "event_code";
    public static final String EVENT_CODE_TYPE1 = "event_code_type1";
    public static final String EVENT_CODE_TYPE1_PUSH = "ev_qz_push";
    public static final String EVENT_CODE_TYPE2 = "event_code_type2";
    public static final String EVENT_CODE_TYPE2_PUSH_ARRIVE = "arrive";
    public static final String EVENT_CODE_TYPE2_PUSH_CLICK = "click";
    public static final String EVENT_CODE_TYPE2_PUSH_EXPOSURE = "exposure";
    public static final String EVENT_CODE_TYPE3 = "event_code_type3";
    public static final String EVENT_TIME = "event_time";
    public static final String EVENT_VALUE = "event_value";
    public static final String QUA = "qua";
    private static final String TAG = "QZonePushReporter";
    public static final String UIN = "uin";

    /* loaded from: classes28.dex */
    public static class QZonePushEventValueBuilder {
        private static final String KEY_DISPLAY_TYPE = "display_type";
        private static final String KEY_PUSH_CHANNEL = "push_channel";
        private static final String KEY_PUSH_CONTENT = "push_content";
        private static final String KEY_PUSH_TYPE = "push_type";
        public static final String PUSH_DISPLAY_TYPE_BACKGROUND = "2";
        public static final String PUSH_DISPLAY_TYPE_DEFAULT = "0";
        public static final String PUSH_DISPLAY_TYPE_FOREGROUND = "1";
        public static final String PUSH_TYPE_DEFAULT = "0";
        public static final String PUSH_TYPE_OFFLINE = "2";
        public static final String PUSH_TYPE_ONLINE = "1";
        String eventCode = "";
        String eventCodeType1 = "";
        String eventCodeType2 = "";
        String eventCodeType3 = "";
        String pushChannel = "0";
        String pushContent = "";
        String pushType = "";
        String displayType = "0";

        public String convertToJson() {
            HashMap hashMap = new HashMap();
            hashMap.put(KEY_PUSH_CONTENT, this.pushContent);
            hashMap.put("push_type", this.pushType);
            hashMap.put(KEY_PUSH_CHANNEL, this.pushChannel);
            hashMap.put("display_type", this.displayType);
            return JsonUtils.getJsonFromMap(hashMap);
        }

        public Map<String, Object> generateCustomParamsMap() {
            this.eventCode = this.eventCodeType1;
            if (!TextUtils.isEmpty(this.eventCodeType2)) {
                this.eventCode += "_";
                this.eventCode += this.eventCodeType2;
            }
            if (!TextUtils.isEmpty(this.eventCodeType3)) {
                this.eventCode += "_";
                this.eventCode += this.eventCodeType3;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("event_code", this.eventCode);
            hashMap.put(QZonePushReporter.EVENT_CODE_TYPE1, this.eventCodeType1);
            hashMap.put(QZonePushReporter.EVENT_CODE_TYPE2, this.eventCodeType2);
            hashMap.put(QZonePushReporter.EVENT_CODE_TYPE3, this.eventCodeType3);
            hashMap.put(QZonePushReporter.EVENT_VALUE, convertToJson());
            return hashMap;
        }

        public QZonePushEventValueBuilder setDisplayType(String str) {
            this.displayType = str;
            return this;
        }

        public QZonePushEventValueBuilder setEventCodeType1(String str) {
            this.eventCodeType1 = str;
            return this;
        }

        public QZonePushEventValueBuilder setEventCodeType2(String str) {
            this.eventCodeType2 = str;
            return this;
        }

        public QZonePushEventValueBuilder setEventCodeType3(String str) {
            this.eventCodeType3 = str;
            return this;
        }

        public QZonePushEventValueBuilder setPushChannel(String str) {
            this.pushChannel = str;
            return this;
        }

        public QZonePushEventValueBuilder setPushContent(String str) {
            this.pushContent = str;
            return this;
        }

        public QZonePushEventValueBuilder setPushType(String str) {
            this.pushType = str;
            return this;
        }
    }

    public static Map<String, Object> buildCommonElementParams() {
        Map<String, Object> buildElementParams = new QZoneDTParamBuilder().buildElementParams();
        buildElementParams.put("uin", Long.valueOf(a.f().l()));
        buildElementParams.put("qua", a.f().i());
        buildElementParams.put("event_time", Long.valueOf(System.currentTimeMillis()));
        buildElementParams.put("app_version", a.f().d());
        return buildElementParams;
    }

    public static void reportPushEvent(QZonePushEventValueBuilder qZonePushEventValueBuilder) {
        Map<String, Object> buildCommonElementParams = buildCommonElementParams();
        buildCommonElementParams.putAll(qZonePushEventValueBuilder.generateCustomParamsMap());
        QLog.d(TAG, 4, "reportPushEvent action:", qZonePushEventValueBuilder.eventCode, ",map:", buildCommonElementParams.toString());
        VideoReport.reportEvent(qZonePushEventValueBuilder.eventCode, buildCommonElementParams);
    }
}

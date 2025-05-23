package com.tencent.mobileqq.profilecard.utils;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class SpecialPersonalityLabelResourceUtil {
    public static String BG_BORDER_COLOR = "bgBorderColor";
    public static String BG_BORDER_WIDTH = "bgBorderWidth";
    public static String ID = "id";
    public static String REPORT_APP_KEY = "report_app_key";
    public static String REPORT_PARAM_ID_CLICK = "report_event_id_click";
    public static String REPORT_PARAM_ID_IMP = "report_event_id_imp";
    public static String REPORT_PARAM_KEY = "report_param_key";
    public static String REPORT_PARAM_VALUE = "report_param_value";
    public static String RES_NAME = "official_tags_info";
    public static String TAG = "SpecialPersonalityLabelResourceUtil";
    public static String TEXT_COLOR = "textColor";
    public static String URL = "url";
    private Map<Long, TagResource> map = Collections.synchronizedMap(new HashMap());

    /* loaded from: classes35.dex */
    private static class SingletonHolder {
        private static final SpecialPersonalityLabelResourceUtil sInstance = new SpecialPersonalityLabelResourceUtil();

        SingletonHolder() {
        }
    }

    /* loaded from: classes35.dex */
    public class TagResource {
        public String bgBorderColor;
        public int bgBorderWidth;

        /* renamed from: id, reason: collision with root package name */
        public Long f260800id;
        public String reportAppKey;
        public String reportEventClick;
        public String reportEventImp;
        public String reportParamKey;
        public String reportParamValue;
        public String textColor;
        public String url;

        public TagResource() {
        }
    }

    SpecialPersonalityLabelResourceUtil() {
        init();
    }

    public static SpecialPersonalityLabelResourceUtil getInstance() {
        return SingletonHolder.sInstance;
    }

    private void init() {
        String d16 = com.tencent.relation.common.config.toggle.c.f364706s.d(RES_NAME, "");
        if (TextUtils.isEmpty(d16)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(d16);
            this.map.clear();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                TagResource tagResource = new TagResource();
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject.has(ID)) {
                    tagResource.f260800id = Long.valueOf(jSONObject.getString(ID));
                    if (jSONObject.has(TEXT_COLOR)) {
                        tagResource.textColor = jSONObject.getString(TEXT_COLOR);
                    }
                    if (jSONObject.has(BG_BORDER_WIDTH)) {
                        tagResource.bgBorderWidth = jSONObject.getInt(BG_BORDER_WIDTH);
                    } else {
                        tagResource.bgBorderWidth = 1;
                    }
                    if (jSONObject.has(BG_BORDER_COLOR)) {
                        tagResource.bgBorderColor = jSONObject.getString(BG_BORDER_COLOR);
                    }
                    if (jSONObject.has(URL)) {
                        tagResource.url = jSONObject.getString(URL);
                    } else {
                        tagResource.url = "";
                    }
                    if (jSONObject.has(REPORT_PARAM_VALUE)) {
                        tagResource.reportParamValue = jSONObject.getString(REPORT_PARAM_VALUE);
                    }
                    if (jSONObject.has(REPORT_PARAM_KEY)) {
                        tagResource.reportParamKey = jSONObject.getString(REPORT_PARAM_KEY);
                    }
                    if (jSONObject.has(REPORT_PARAM_ID_IMP)) {
                        tagResource.reportEventImp = jSONObject.getString(REPORT_PARAM_ID_IMP);
                    }
                    if (jSONObject.has(REPORT_PARAM_ID_CLICK)) {
                        tagResource.reportEventClick = jSONObject.getString(REPORT_PARAM_ID_CLICK);
                    }
                    if (jSONObject.has(REPORT_APP_KEY)) {
                        tagResource.reportAppKey = jSONObject.getString(REPORT_APP_KEY);
                    }
                    this.map.put(tagResource.f260800id, tagResource);
                }
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    public String getJumpUrl(long j3) {
        if (this.map.containsKey(Long.valueOf(j3))) {
            return this.map.get(Long.valueOf(j3)).url;
        }
        return "";
    }

    public String getReport(long j3) {
        if (this.map.containsKey(Long.valueOf(j3))) {
            return this.map.get(Long.valueOf(j3)).reportParamValue;
        }
        return "";
    }

    public TagResource getTagResource(long j3) {
        if (this.map.containsKey(Long.valueOf(j3))) {
            return this.map.get(Long.valueOf(j3));
        }
        return null;
    }

    public int getTextColorById(long j3) {
        return this.map.containsKey(Long.valueOf(j3)) ? Color.parseColor(this.map.get(Long.valueOf(j3)).textColor) : R.color.qui_common_text_primary;
    }

    public boolean isSpecialLabel(long j3) {
        return this.map.containsKey(Long.valueOf(j3));
    }
}

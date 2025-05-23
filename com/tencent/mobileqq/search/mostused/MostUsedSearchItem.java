package com.tencent.mobileqq.search.mostused;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import cooperation.qqcircle.report.QCircleQualityReporter;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MostUsedSearchItem implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    private static String f283555d = "MostUsedSearchItem";
    public int businessType;
    public String identify;
    public int identifyType;
    public String searchKey;
    public long timeStamp;

    public MostUsedSearchItem(String str, long j3, String str2, int i3, int i16) {
        this.searchKey = str;
        this.timeStamp = j3;
        this.identify = str2;
        this.identifyType = i3;
        this.businessType = i16;
    }

    public static MostUsedSearchItem fromJson(String str) {
        String str2;
        String str3 = f283555d;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        QLog.d(str3, 2, str2);
        MostUsedSearchItem mostUsedSearchItem = new MostUsedSearchItem();
        if (str == null) {
            return mostUsedSearchItem;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("searchKey")) {
                mostUsedSearchItem.searchKey = jSONObject.getString("searchKey");
            }
            if (jSONObject.has(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY)) {
                mostUsedSearchItem.timeStamp = jSONObject.getLong(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY);
            }
            if (jSONObject.has(QCircleQualityReporter.KEY_ID)) {
                mostUsedSearchItem.identify = jSONObject.getString(QCircleQualityReporter.KEY_ID);
            }
            if (jSONObject.has("businessType")) {
                mostUsedSearchItem.businessType = jSONObject.getInt("businessType");
            }
            if (jSONObject.has("identifyType")) {
                mostUsedSearchItem.identifyType = jSONObject.getInt("identifyType");
            }
        } catch (JSONException e16) {
            QLog.e(f283555d, 2, "MostUsedSearchItem fromJson ERR;" + e16.toString());
        }
        return mostUsedSearchItem;
    }

    public static boolean isSameIdentityItem(MostUsedSearchItem mostUsedSearchItem, MostUsedSearchItem mostUsedSearchItem2) {
        if (mostUsedSearchItem != null && mostUsedSearchItem2 != null && mostUsedSearchItem.businessType == mostUsedSearchItem2.businessType && mostUsedSearchItem.identify.equals(mostUsedSearchItem2.identify) && mostUsedSearchItem.identifyType == mostUsedSearchItem2.identifyType) {
            return true;
        }
        return false;
    }

    public static JSONObject toJson(MostUsedSearchItem mostUsedSearchItem) {
        JSONObject jSONObject = new JSONObject();
        if (mostUsedSearchItem != null) {
            try {
                jSONObject.put("searchKey", mostUsedSearchItem.searchKey);
                jSONObject.put(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, mostUsedSearchItem.timeStamp);
                jSONObject.put(QCircleQualityReporter.KEY_ID, mostUsedSearchItem.identify);
                jSONObject.put("businessType", mostUsedSearchItem.businessType);
                jSONObject.put("identifyType", mostUsedSearchItem.identifyType);
            } catch (JSONException e16) {
                QLog.e(f283555d, 2, "MostUsedSearchItem toJson ERR;" + e16.toString());
            }
        }
        return jSONObject;
    }

    public static String toJsonString(MostUsedSearchItem mostUsedSearchItem) {
        String str;
        String str2;
        JSONObject json;
        if (mostUsedSearchItem != null && (json = toJson(mostUsedSearchItem)) != null) {
            str = json.toString();
        } else {
            str = null;
        }
        String str3 = f283555d;
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        QLog.d(str3, 2, str2);
        return str;
    }

    public MostUsedSearchItem(MostUsedSearchItem mostUsedSearchItem) {
        this.searchKey = "";
        this.timeStamp = -1L;
        this.identify = "";
        this.identifyType = 0;
        this.businessType = 0;
        if (mostUsedSearchItem == null) {
            return;
        }
        this.searchKey = mostUsedSearchItem.searchKey;
        this.timeStamp = mostUsedSearchItem.timeStamp;
        this.identify = mostUsedSearchItem.identify;
        this.businessType = mostUsedSearchItem.businessType;
        this.identifyType = mostUsedSearchItem.identifyType;
    }

    public MostUsedSearchItem() {
        this.searchKey = "";
        this.timeStamp = -1L;
        this.identify = "";
        this.identifyType = 0;
        this.businessType = 0;
    }
}

package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.message.RecordForTest;
import com.tencent.mobileqq.ark.d;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import com.tenpay.realname.RealNameSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.utils.GsonUtils;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ArkAppMessage {
    public String appDesc;
    public String appId;
    public String appMinVersion;
    public String appName;
    public String appView;
    public String bizSrc;
    public String compatibleText;
    public String config;

    @RecordForTest
    public MessageForStructing containStructMsg;
    public int forwardID;
    public int from;
    public boolean isShow;
    public List<ArkAppMessage> mAppList;
    public String mExtra;
    public String mSourceActionData;
    public String mSourceAd;
    public String mSourceName;
    public String mSourceUrl;
    public String mSource_A_ActionData;
    public String mText;
    public String mType;
    public String metaList;
    public String promptText;
    public String resId;
    public long uniSeq;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class Config {
        public Integer autoSize;
        public Integer fitWidthAndCentered;
        public Integer forward;
        public Integer height;
        public Integer hintHeight;
        public Integer hintWidth;
        public Integer menuMode;
        public Integer round;
        public Integer showSender;
        public Integer showTime;
        public String type;
        public Integer width;

        public boolean fromJson(JSONObject jSONObject) {
            if (jSONObject == null || jSONObject.length() == 0) {
                return false;
            }
            int optInt = jSONObject.optInt("round", -1);
            if (optInt != -1) {
                this.round = new Integer(optInt);
            } else if (jSONObject.optBoolean("round")) {
                this.round = new Integer(1);
            }
            int optInt2 = jSONObject.optInt("forward", -1);
            if (optInt2 != -1) {
                this.forward = new Integer(optInt2);
            } else if (jSONObject.optBoolean("forward")) {
                this.forward = new Integer(1);
            }
            int optInt3 = jSONObject.optInt("autosize", -1);
            if (optInt3 != -1) {
                this.autoSize = new Integer(optInt3);
            } else if (jSONObject.optBoolean("autosize")) {
                this.autoSize = new Integer(1);
            }
            this.type = jSONObject.optString("type", null);
            if (jSONObject.has("width") && jSONObject.has("height")) {
                this.width = Integer.valueOf(jSONObject.optInt("width", -1));
                this.height = Integer.valueOf(jSONObject.optInt("height", -1));
            }
            int optInt4 = jSONObject.optInt("showSender", -1);
            if (optInt4 != -1) {
                this.showSender = new Integer(optInt4);
            } else if (jSONObject.optBoolean("showSender", true)) {
                this.showSender = new Integer(1);
            } else {
                this.showSender = new Integer(0);
            }
            this.fitWidthAndCentered = Integer.valueOf(jSONObject.optInt("fitWidthAndCentered", 0));
            if (jSONObject.has("hintWidth") && jSONObject.has("hintHeight")) {
                this.hintWidth = Integer.valueOf(jSONObject.optInt("hintWidth", -1));
                this.hintHeight = Integer.valueOf(jSONObject.optInt("hintHeight", -1));
            }
            if (jSONObject.has(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME)) {
                this.showTime = Integer.valueOf(jSONObject.optInt(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, 1));
            }
            if (jSONObject.has("menuMode")) {
                this.menuMode = Integer.valueOf(jSONObject.optInt("menuMode", -1));
            }
            return true;
        }

        public boolean fromString(String str) {
            if (str != null && str.length() != 0) {
                try {
                    return fromJson(new JSONObject(str));
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                Integer num = this.round;
                if (num != null) {
                    jSONObject.put("round", num.intValue());
                }
                Integer num2 = this.forward;
                if (num2 != null) {
                    jSONObject.put("forward", num2.intValue());
                }
                Integer num3 = this.autoSize;
                if (num3 != null) {
                    jSONObject.put("autosize", num3.intValue());
                }
                String str = this.type;
                if (str != null) {
                    jSONObject.put("type", str);
                }
                Integer num4 = this.width;
                if (num4 != null) {
                    jSONObject.put("width", num4.intValue());
                }
                Integer num5 = this.height;
                if (num5 != null) {
                    jSONObject.put("height", num5.intValue());
                }
                Integer num6 = this.showSender;
                if (num6 != null) {
                    jSONObject.put("showSender", num6.intValue());
                }
                Integer num7 = this.fitWidthAndCentered;
                if (num7 != null) {
                    jSONObject.put("fitWidthAndCentered", num7.intValue());
                }
                Integer num8 = this.hintWidth;
                if (num8 != null) {
                    jSONObject.put("hintWidth", num8.intValue());
                }
                Integer num9 = this.hintHeight;
                if (num9 != null) {
                    jSONObject.put("hintHeight", num9.intValue());
                }
                Integer num10 = this.showTime;
                if (num10 != null) {
                    jSONObject.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, num10.intValue());
                }
                Integer num11 = this.menuMode;
                if (num11 != null) {
                    jSONObject.put("menuMode", num11.intValue());
                    return jSONObject;
                }
                return jSONObject;
            } catch (Exception unused) {
                return null;
            }
        }

        public String toString() {
            JSONObject json = toJson();
            if (json == null) {
                return null;
            }
            return json.toString();
        }
    }

    public ArkAppMessage() {
        this.isShow = false;
        reset();
    }

    public static String msgDataToString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            return (String) new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
        } catch (Exception e16) {
            QLog.w("ArkApp.Message", 1, "msg data to string fail, " + e16);
            return "";
        }
    }

    public boolean fromAppXml(String str) {
        boolean z16;
        reset();
        if (str != null && str.length() != 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.appName = jSONObject.optString("app");
                this.appView = jSONObject.optString("view");
                this.bizSrc = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC);
                this.appDesc = jSONObject.optString("desc");
                this.appMinVersion = jSONObject.optString("ver");
                this.promptText = jSONObject.optString("prompt");
                this.metaList = jSONObject.optString(PublicAccountMessageUtilImpl.META_NAME);
                this.config = jSONObject.optString(DownloadInfo.spKey_Config);
                this.from = jSONObject.optInt("from");
                this.appId = jSONObject.optString("appID");
                this.mSourceName = jSONObject.optString(RealNameSource.EXTRA_KEY_SOURCE_NAME);
                this.mSourceActionData = jSONObject.optString(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA);
                this.mSource_A_ActionData = jSONObject.optString("actionData_A");
                this.mSourceUrl = jSONObject.optString("sourceUrl");
                this.mAppList = new ArrayList();
                this.mText = jSONObject.optString("text");
                this.mExtra = jSONObject.optString("extra");
                JSONObject optJSONObject = jSONObject.optJSONObject(this.config);
                if (optJSONObject != null && optJSONObject.optInt("isshow", 0) != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.isShow = z16;
                JSONArray optJSONArray = jSONObject.optJSONArray("extraApps");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                        if (optJSONObject2 != null) {
                            ArkAppMessage arkAppMessage = new ArkAppMessage();
                            if (arkAppMessage.fromAppXml(optJSONObject2.toString())) {
                                this.mAppList.add(arkAppMessage);
                            }
                        }
                    }
                }
                this.mSourceAd = jSONObject.optString("sourceAd");
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    public boolean fromBytes(byte[] bArr) {
        return fromAppXml(msgDataToString(bArr));
    }

    public String getAppIdFromMeta() {
        if (TextUtils.isEmpty(this.metaList)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(this.metaList);
            Iterator keys = jSONObject.keys();
            if (keys == null) {
                return "";
            }
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if ("appid".equals(str)) {
                    return jSONObject.optString("appid", "");
                }
                Object opt = jSONObject.opt(str);
                if ((opt instanceof JSONObject) && ((JSONObject) opt).has("appid")) {
                    return ((JSONObject) opt).optString("appid", "");
                }
            }
            return "";
        } catch (Exception e16) {
            QLog.e("ArkApp.Message", 1, "arkMessage getAppIdFromMeta error : " + e16.getMessage());
            return "";
        }
    }

    public String getFilterExtra() {
        String str;
        try {
            if (TextUtils.isEmpty(this.mExtra)) {
                str = "";
            } else {
                str = this.mExtra;
            }
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.remove("msg_seq");
            jSONObject.remove("filename");
            return jSONObject.toString();
        } catch (JSONException e16) {
            QLog.e("ArkApp.Message", 1, "JSONException", e16);
            return new JSONObject().toString();
        }
    }

    public String getSummery() {
        if (!TextUtils.isEmpty(this.promptText)) {
            return this.promptText;
        }
        return BaseApplicationImpl.getApplication().getString(R.string.f170467s2);
    }

    public String optFilename() {
        if (TextUtils.isEmpty(this.mExtra)) {
            return "";
        }
        try {
            return new JSONObject(this.mExtra).optString("filename", "");
        } catch (JSONException e16) {
            QLog.e("ArkApp.Message", 1, "optFilename: JSONException, e=", e16);
            return "";
        }
    }

    public long optMsgSeq() {
        if (TextUtils.isEmpty(this.mExtra)) {
            return -1L;
        }
        try {
            return new JSONObject(this.mExtra).optLong("msg_seq", -1L);
        } catch (JSONException e16) {
            QLog.e("ArkApp.Message", 1, "JSONException", e16);
            return -1L;
        }
    }

    public int optTSum() {
        if (TextUtils.isEmpty(this.mExtra)) {
            return 0;
        }
        try {
            return new JSONObject(this.mExtra).optInt("tsum", 0);
        } catch (JSONException e16) {
            QLog.e("ArkApp.Message", 1, "optTSum: JSONException, e=", e16);
            return 0;
        }
    }

    public void reset() {
        this.promptText = null;
        this.appName = null;
        this.appDesc = null;
        this.appView = null;
        this.bizSrc = null;
        this.appMinVersion = null;
        this.metaList = null;
        this.config = null;
        this.compatibleText = null;
    }

    public String toAppXml() {
        String appXml;
        try {
            JSONObject jSONObject = new JSONObject();
            String str = this.appName;
            if (str != null) {
                jSONObject.put("app", str);
            }
            String str2 = this.appDesc;
            if (str2 != null) {
                jSONObject.put("desc", str2);
            }
            String str3 = this.bizSrc;
            if (str3 != null) {
                jSONObject.put(QQCustomArkDialogUtil.BIZ_SRC, str3);
            }
            String str4 = this.appView;
            if (str4 != null) {
                jSONObject.put("view", str4);
            }
            String str5 = this.appMinVersion;
            if (str5 != null) {
                jSONObject.put("ver", str5);
            }
            String str6 = this.promptText;
            if (str6 != null) {
                jSONObject.put("prompt", str6);
            }
            int i3 = this.from;
            if (i3 != 0) {
                jSONObject.put("from", i3);
            }
            String str7 = this.appId;
            if (str7 != null) {
                jSONObject.put("appID", str7);
            }
            String str8 = this.mSourceName;
            if (str8 != null) {
                jSONObject.put(RealNameSource.EXTRA_KEY_SOURCE_NAME, str8);
            }
            String str9 = this.mSourceActionData;
            if (str9 != null) {
                jSONObject.put(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA, str9);
            }
            String str10 = this.mSource_A_ActionData;
            if (str10 != null) {
                jSONObject.put("actionData_A", str10);
            }
            String str11 = this.mSourceUrl;
            if (str11 != null) {
                jSONObject.put("sourceUrl", str11);
            }
            if (this.metaList != null) {
                try {
                    jSONObject.put(PublicAccountMessageUtilImpl.META_NAME, new JSONObject(this.metaList));
                } catch (Exception unused) {
                }
            }
            if (this.config != null) {
                try {
                    jSONObject.put(DownloadInfo.spKey_Config, new JSONObject(this.config));
                } catch (Exception unused2) {
                }
            }
            String str12 = this.mText;
            if (str12 != null) {
                jSONObject.put("text", str12);
            }
            if (this.mAppList != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (ArkAppMessage arkAppMessage : this.mAppList) {
                        if (arkAppMessage != null && (appXml = arkAppMessage.toAppXml()) != null) {
                            jSONArray.mo162put(new JSONObject(appXml));
                        }
                    }
                    jSONObject.put("extraApps", jSONArray);
                } catch (Exception e16) {
                    d.d("ArkApp.Message", "toAppXml fail, config, err=" + e16.getMessage());
                }
            }
            String str13 = this.mSourceAd;
            if (str13 != null) {
                jSONObject.put("sourceAd", str13);
            }
            String str14 = this.mExtra;
            if (str14 != null) {
                jSONObject.put("extra", str14);
            }
            return jSONObject.toString();
        } catch (JSONException e17) {
            e17.printStackTrace();
            return null;
        } catch (Exception e18) {
            e18.printStackTrace();
            return null;
        }
    }

    public byte[] toBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(toAppXml());
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public byte[] toPbData() {
        String appXml = toAppXml();
        if (appXml == null) {
            return null;
        }
        try {
            return appXml.getBytes("utf-8");
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public JSONObject toShareMsgJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.appName;
            if (str != null) {
                jSONObject.put("forward_ark_app_name", str);
            }
            String str2 = this.appDesc;
            if (str2 != null) {
                jSONObject.put(AppConstants.Key.FORWARD_ARK_APP_DESC, str2);
            }
            String str3 = this.appView;
            if (str3 != null) {
                jSONObject.put("forward_ark_app_view", str3);
            }
            String str4 = this.bizSrc;
            if (str4 != null) {
                jSONObject.put("forward_ark_biz_src", str4);
            }
            String str5 = this.appMinVersion;
            if (str5 != null) {
                jSONObject.put("forward_ark_app_ver", str5);
            }
            String str6 = this.promptText;
            if (str6 != null) {
                jSONObject.put("forward_ark_app_prompt", str6);
            }
            if (this.metaList != null) {
                try {
                    jSONObject.put("forward_ark_app_meta", new JSONObject(this.metaList));
                } catch (Exception e16) {
                    QLog.e("ArkApp.Message", 1, "toShareMsgJSONObject fail, metaList, err=", e16);
                }
            }
            if (this.config != null) {
                try {
                    jSONObject.put(AppConstants.Key.FORWARD_ARK_APP_CONFIG, new JSONObject(this.config));
                } catch (Exception e17) {
                    QLog.e("ArkApp.Message", 1, "toShareMsgJSONObject fail, config, err=", e17);
                }
            }
        } catch (JSONException e18) {
            QLog.e("ArkApp.Message", 1, "toShareMsgJSONObject fail, err=", e18);
        }
        return jSONObject;
    }

    public String toString() {
        return "ArkAppMessage{appName='" + this.appName + "', bizSrc='" + this.bizSrc + "', appView='" + this.appView + "', metaList='" + this.metaList + "', config='" + this.config + "'}";
    }

    public void updateFilename(String str) {
        JSONObject jSONObject;
        try {
            if (TextUtils.isEmpty(this.mExtra)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(this.mExtra);
            }
            jSONObject.put("filename", str);
            this.mExtra = jSONObject.toString();
        } catch (JSONException e16) {
            QLog.e("ArkApp.Message", 1, "updateFilename, JSONException, e", e16);
        }
    }

    public void updateMultiInfo(String str, long j3) {
        if (ArkMsgUtils.isMultiMsg(this)) {
            if (j3 != 0 || !TextUtils.isEmpty(str)) {
                cb1.c cVar = (cb1.c) GsonUtils.json2Obj(this.metaList, cb1.c.class);
                if (cVar == null) {
                    if (QLog.isColorLevel()) {
                        QLog.w("ArkApp.Message", 2, "updateMultiInfo meet exception when metalist is null. metalist = " + this.metaList);
                    }
                    cVar = new cb1.c();
                }
                if (cVar.detail == null) {
                    cVar.detail = new cb1.a();
                }
                if (!TextUtils.isEmpty(str)) {
                    cVar.detail.resid = str;
                    this.resId = str;
                }
                if (j3 != 0) {
                    cVar.detail.uniseq = String.valueOf(j3);
                }
                this.uniSeq = j3;
                this.metaList = GsonUtils.obj2Json(cVar);
            }
        }
    }

    public void updateTSum(int i3) {
        JSONObject jSONObject;
        try {
            if (TextUtils.isEmpty(this.mExtra)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(this.mExtra);
            }
            jSONObject.put("tsum", i3);
            this.mExtra = jSONObject.toString();
        } catch (JSONException e16) {
            QLog.e("ArkApp.Message", 1, "updateTSum: JSONException, e=", e16);
        }
    }

    public ArkAppMessage(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this(str, str2, "", str3, str4, str5, str6, str7, str8);
    }

    public ArkAppMessage(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.isShow = false;
        this.promptText = str;
        this.appDesc = str4;
        this.appName = str2;
        this.appView = str5;
        this.bizSrc = str3;
        this.appMinVersion = str6;
        this.metaList = str7;
        this.config = str8;
        this.compatibleText = str9;
    }
}

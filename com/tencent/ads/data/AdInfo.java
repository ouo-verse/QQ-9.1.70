package com.tencent.ads.data;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.ads.monitor.b;
import com.tencent.ads.utility.Utils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AdInfo {

    /* renamed from: a, reason: collision with root package name */
    private static final String f61597a = "";

    /* renamed from: b, reason: collision with root package name */
    private AdItem[] f61598b;

    /* renamed from: c, reason: collision with root package name */
    private List f61599c;

    /* renamed from: d, reason: collision with root package name */
    private String f61600d;

    /* renamed from: e, reason: collision with root package name */
    private String f61601e;

    /* renamed from: f, reason: collision with root package name */
    private String f61602f;

    /* renamed from: g, reason: collision with root package name */
    private String f61603g;

    /* renamed from: h, reason: collision with root package name */
    private String f61604h;

    /* renamed from: i, reason: collision with root package name */
    private String f61605i;

    /* renamed from: j, reason: collision with root package name */
    private String f61606j;

    /* renamed from: k, reason: collision with root package name */
    private int f61607k;

    /* renamed from: l, reason: collision with root package name */
    private SimpleDateFormat f61608l = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);

    public AdInfo() {
    }

    private static void a(AdItem adItem, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String valueFromLink = Utils.getValueFromLink(str, "richdata");
        if (TextUtils.isEmpty(valueFromLink)) {
            return;
        }
        try {
            String decode = URLDecoder.decode(valueFromLink, "utf-8");
            Log.v("", "richData: " + decode);
            JSONObject jSONObject = new JSONObject(decode);
            if (jSONObject.has("plugins")) {
                JSONObject jSONObject2 = new JSONObject(jSONObject.getString("plugins"));
                if (jSONObject2.has("open_url_type")) {
                    adItem.setOpenUrlType(jSONObject2.getString("open_url_type"));
                }
                if (jSONObject2.has("click_text_desc")) {
                    adItem.setClickTextDesc(jSONObject2.getString("click_text_desc"));
                }
                if (jSONObject2.has("fullscreen_click") && "Y".equals(jSONObject2.getString("fullscreen_click"))) {
                    adItem.setFullScreenClickable(true);
                }
                if (jSONObject2.has("trueview") && "Y".equalsIgnoreCase(jSONObject2.getString("trueview"))) {
                    adItem.setTrueview(true);
                }
            }
        } catch (Exception unused) {
        }
    }

    private static ReportClickItem[] b(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("reportitem");
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                String optString = optJSONObject.optString("url");
                String optString2 = optJSONObject.optString("reporttype");
                String optString3 = optJSONObject.optString("clicktype");
                if (!TextUtils.isEmpty(optString) && Utils.isNumeric(optString2) && Utils.isNumeric(optString3)) {
                    arrayList.add(new ReportClickItem(optString, Integer.parseInt(optString2), Integer.parseInt(optString3)));
                }
            }
        }
        return (ReportClickItem[]) arrayList.toArray(new ReportClickItem[arrayList.size()]);
    }

    private void c(JSONObject jSONObject) {
        this.f61600d = String.valueOf(jSONObject.optInt("duration"));
        this.f61601e = String.valueOf(jSONObject.optInt("isvip"));
        this.f61602f = String.valueOf(jSONObject.optInt("adFlag"));
        this.f61603g = jSONObject.optString("aid", "0");
        this.f61604h = jSONObject.optString("oaid", "0");
        this.f61605i = jSONObject.optString("vid2aid", "0");
        this.f61606j = String.valueOf(jSONObject.optLong(AdParam.TPID));
    }

    public List getAdEmptyItemList() {
        return this.f61599c;
    }

    public String getAdFlag() {
        return this.f61602f;
    }

    public AdItem[] getAdItemArray() {
        return this.f61598b;
    }

    public String getAid() {
        return this.f61603g;
    }

    public int getErrorCode() {
        return this.f61607k;
    }

    public String getOaid() {
        return this.f61604h;
    }

    public String getTpid() {
        return this.f61606j;
    }

    public String getVid2aid() {
        return this.f61605i;
    }

    public String getVideoDuration() {
        return this.f61600d;
    }

    public String isVip() {
        return this.f61601e;
    }

    public AdItem[] parse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        JSONObject optJSONObject = jSONObject.optJSONObject("adList");
        if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME)) != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                if (optJSONObject2 != null) {
                    AdItem parseAdItem = parseAdItem(optJSONObject2);
                    parseAdItem.setLcount(i3);
                    arrayList.add(parseAdItem);
                }
            }
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("adLoc");
        this.f61600d = String.valueOf(optJSONObject3.optInt("duration"));
        this.f61601e = String.valueOf(optJSONObject3.optInt("isvip"));
        this.f61602f = String.valueOf(optJSONObject3.optInt("adFlag"));
        this.f61603g = optJSONObject3.optString("aid", "0");
        this.f61604h = optJSONObject3.optString("oaid", "0");
        this.f61605i = optJSONObject3.optString("vid2aid", "0");
        this.f61606j = String.valueOf(optJSONObject3.optLong(AdParam.TPID));
        return (AdItem[]) arrayList.toArray(new AdItem[arrayList.size()]);
    }

    public AdInfo(String str) {
        try {
            this.f61598b = a(parse(new JSONObject(str)));
        } catch (Exception e16) {
            Log.e("", "adinfo parse failed", e16);
            b.a(e16, "adinfo parse failed");
        }
    }

    private static void a(AdItem adItem, String str, SimpleDateFormat simpleDateFormat) {
        String[] split;
        String[] split2;
        if (simpleDateFormat == null || (split = str.split(";")) == null || split.length == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (String str2 : split) {
            if (!TextUtils.isEmpty(str2) && (split2 = str2.split("~")) != null && split2.length == 2) {
                try {
                    Date parse = simpleDateFormat.parse(split2[0]);
                    long time = simpleDateFormat.parse(split2[1]).getTime() + 86400000;
                    if (time > parse.getTime() && time > currentTimeMillis) {
                        adItem.addTimeList(parse.getTime());
                        adItem.addTimeList(time);
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
    }

    private static void a(AdItem adItem, JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("image");
        if (optJSONArray == null) {
            return;
        }
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                adItem.setVid(optJSONObject.optString("vid", ""));
                String optString = optJSONObject.optString("cs", "0");
                if (Utils.isNumeric(optString)) {
                    adItem.setFileSize(Long.parseLong(optString));
                }
                String optString2 = optJSONObject.optString("url");
                if (!TextUtils.isEmpty(optString2)) {
                    adItem.addUrl(optString2);
                }
                String optString3 = optJSONObject.optString("width");
                if (Utils.isNumeric(optString3)) {
                    adItem.setWidth(Integer.parseInt(optString3));
                }
                String optString4 = optJSONObject.optString("height");
                if (Utils.isNumeric(optString4)) {
                    adItem.setHeight(Integer.parseInt(optString4));
                }
                adItem.setMd5(optJSONObject.optString("md5", ""));
            }
        }
    }

    public AdItem parseAdItem(JSONObject jSONObject) {
        SimpleDateFormat simpleDateFormat;
        String[] split;
        int i3;
        int i16;
        SimpleDateFormat simpleDateFormat2;
        String[] split2;
        Date parse;
        long time;
        AdItem adItem = new AdItem();
        adItem.setOid(jSONObject.optString("order_id", "0"));
        adItem.setType(jSONObject.optString("type", ""));
        String optString = jSONObject.optString("duration");
        if (Utils.isNumeric(optString)) {
            adItem.setDuration(Integer.parseInt(optString));
        }
        String optString2 = jSONObject.optString("time_list");
        if (!TextUtils.isEmpty(optString2) && (simpleDateFormat = this.f61608l) != null && (split = optString2.split(";")) != null && split.length != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            int length = split.length;
            int i17 = 0;
            while (i17 < length) {
                String str = split[i17];
                if (TextUtils.isEmpty(str) || (split2 = str.split("~")) == null) {
                    i3 = i17;
                    i16 = length;
                } else {
                    i16 = length;
                    if (split2.length == 2) {
                        try {
                            parse = simpleDateFormat.parse(split2[0]);
                            i3 = i17;
                            time = simpleDateFormat.parse(split2[1]).getTime() + 86400000;
                        } catch (Throwable th5) {
                            th = th5;
                            i3 = i17;
                        }
                        try {
                        } catch (Throwable th6) {
                            th = th6;
                            simpleDateFormat2 = simpleDateFormat;
                            th.printStackTrace();
                            i17 = i3 + 1;
                            length = i16;
                            simpleDateFormat = simpleDateFormat2;
                        }
                        if (time > parse.getTime() && time > currentTimeMillis) {
                            simpleDateFormat2 = simpleDateFormat;
                            try {
                                adItem.addTimeList(parse.getTime());
                                adItem.addTimeList(time);
                            } catch (Throwable th7) {
                                th = th7;
                                th.printStackTrace();
                                i17 = i3 + 1;
                                length = i16;
                                simpleDateFormat = simpleDateFormat2;
                            }
                            i17 = i3 + 1;
                            length = i16;
                            simpleDateFormat = simpleDateFormat2;
                        }
                    } else {
                        i3 = i17;
                    }
                }
                simpleDateFormat2 = simpleDateFormat;
                i17 = i3 + 1;
                length = i16;
                simpleDateFormat = simpleDateFormat2;
            }
        }
        adItem.setReportItem(new ReportItem(jSONObject.optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_URL, ""), Integer.parseInt(jSONObject.optString("ReportTime", "0"))));
        adItem.setClickUrl(jSONObject.optString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, ""));
        adItem.setReportUrlOther(a(jSONObject.optJSONObject("reportUrlOther")));
        adItem.setReportSdkItem(a(jSONObject.optJSONObject("reportUrlSDK")));
        JSONObject optJSONObject = jSONObject.optJSONObject("clickReportUrlOther");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = optJSONObject.optJSONArray("reportitem");
        if (optJSONArray != null) {
            for (int i18 = 0; i18 < optJSONArray.length(); i18++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i18);
                String optString3 = optJSONObject2.optString("url");
                String optString4 = optJSONObject2.optString("reporttype");
                String optString5 = optJSONObject2.optString("clicktype");
                if (!TextUtils.isEmpty(optString3) && Utils.isNumeric(optString4) && Utils.isNumeric(optString5)) {
                    arrayList.add(new ReportClickItem(optString3, Integer.parseInt(optString4), Integer.parseInt(optString5)));
                }
            }
        }
        adItem.setReportClickItems((ReportClickItem[]) arrayList.toArray(new ReportClickItem[arrayList.size()]));
        adItem.setNoClick(jSONObject.optString("no_click", ""));
        adItem.setControlParams(jSONObject.optString("params", ""));
        a(adItem, jSONObject);
        String optString6 = jSONObject.optString("params", "");
        adItem.setControlParams(optString6);
        if (!TextUtils.isEmpty(optString6)) {
            String valueFromLink = Utils.getValueFromLink(optString6, "richdata");
            if (!TextUtils.isEmpty(valueFromLink)) {
                try {
                    String decode = URLDecoder.decode(valueFromLink, "utf-8");
                    Log.v("", "richData: " + decode);
                    JSONObject jSONObject2 = new JSONObject(decode);
                    if (jSONObject2.has("plugins")) {
                        JSONObject jSONObject3 = new JSONObject(jSONObject2.getString("plugins"));
                        if (jSONObject3.has("open_url_type")) {
                            adItem.setOpenUrlType(jSONObject3.getString("open_url_type"));
                        }
                        if (jSONObject3.has("click_text_desc")) {
                            adItem.setClickTextDesc(jSONObject3.getString("click_text_desc"));
                        }
                        if (jSONObject3.has("fullscreen_click") && "Y".equals(jSONObject3.getString("fullscreen_click"))) {
                            adItem.setFullScreenClickable(true);
                        }
                        if (jSONObject3.has("trueview") && "Y".equalsIgnoreCase(jSONObject3.getString("trueview"))) {
                            adItem.setTrueview(true);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        return adItem;
    }

    private AdItem[] a(AdItem[] adItemArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.f61599c = new ArrayList();
        int i3 = 1;
        int i16 = 1;
        for (AdItem adItem : adItemArr) {
            if (AdParam.AD_TYPE_SPONSOR_VALUE.equals(adItem.getType())) {
                adItem.setLcount(i16);
                i16++;
            } else {
                adItem.setLcount(i3);
                i3++;
            }
            if ("1".equals(adItem.getOid()) || TextUtils.isEmpty(adItem.getVid())) {
                this.f61599c.add(adItem);
            } else if (AdParam.AD_TYPE_SPONSOR_VALUE.equals(adItem.getType())) {
                arrayList2.add(adItem);
            } else {
                arrayList.add(adItem);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.addAll(arrayList2);
        }
        return (AdItem[]) arrayList.toArray(new AdItem[arrayList.size()]);
    }

    private static ReportItem[] a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("reportitem");
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                String optString = optJSONObject.optString("url");
                String optString2 = optJSONObject.optString("reporttime");
                if (!TextUtils.isEmpty(optString) && Utils.isNumeric(optString2)) {
                    arrayList.add(new ReportItem(optString, Integer.parseInt(optString2)));
                }
            }
        }
        return (ReportItem[]) arrayList.toArray(new ReportItem[arrayList.size()]);
    }
}

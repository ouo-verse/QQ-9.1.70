package com.tencent.mobileqq.richmedia.capture.data;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FilterDesc {
    public Bundle bundle;
    public String display;
    public String iconMD5;
    public String iconurl;

    /* renamed from: id, reason: collision with root package name */
    public int f281357id;
    public String name;
    public int predownload;
    public String resMD5;
    public ArrayList<String> resNameList;
    public String resRootPath;
    public String respicname;
    public String resurl;
    public int subId;
    public int type;
    public int version;

    public FilterDesc() {
    }

    public static ArrayList<FilterDesc> parse(JSONArray jSONArray) {
        int i3;
        int filterType;
        int i16;
        ArrayList<FilterDesc> arrayList = new ArrayList<>();
        for (int i17 = 0; i17 < jSONArray.length(); i17++) {
            try {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i17);
                    try {
                        if (jSONObject.has(QCircleSchemeAttr.Polymerize.FILTER_ID)) {
                            i3 = Integer.valueOf(jSONObject.getString(QCircleSchemeAttr.Polymerize.FILTER_ID)).intValue();
                        } else {
                            i3 = 0;
                        }
                        if (jSONObject.has("type")) {
                            filterType = Integer.valueOf(jSONObject.getString("type")).intValue();
                        } else {
                            filterType = QQAVImageFilterConstants.getFilterType(i3);
                        }
                        int i18 = filterType;
                        if (jSONObject.has("predownload")) {
                            i16 = Integer.valueOf(jSONObject.optString("predownload", "0")).intValue();
                        } else {
                            i16 = 0;
                        }
                        String optString = jSONObject.optString("resurl", "");
                        String optString2 = jSONObject.optString("md5", "");
                        if (jSONObject.has("resurl_android")) {
                            optString = jSONObject.optString("resurl_android", "");
                            optString2 = jSONObject.optString("md5_android", "");
                        }
                        String str = optString;
                        String str2 = optString2;
                        String optString3 = jSONObject.optString("iconUrl");
                        String optString4 = jSONObject.optString("iconmd5");
                        String optString5 = jSONObject.optString("name");
                        if (jSONObject.has("name_android")) {
                            optString5 = jSONObject.optString("name_android", "");
                        }
                        String str3 = optString5;
                        String optString6 = jSONObject.optString("display", "");
                        if (TextUtils.isEmpty(optString6)) {
                            optString6 = str3;
                        }
                        FilterDesc filterDesc = new FilterDesc(i3, i16, str, str2, optString3, optString4, str3, i18, jSONObject.optInt("version", 0), jSONObject.optString("respicname", ""));
                        filterDesc.display = optString6;
                        arrayList.add(filterDesc);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                } catch (JSONException e17) {
                    e17.printStackTrace();
                }
            } catch (Exception e18) {
                e18.printStackTrace();
            }
        }
        return arrayList;
    }

    public String getFileNameWithoutExtension(String str) {
        if (str != null && !str.equals("")) {
            int lastIndexOf = str.lastIndexOf(".");
            int lastIndexOf2 = str.lastIndexOf(File.separator);
            if (lastIndexOf2 == -1) {
                if (lastIndexOf != -1) {
                    return str.substring(0, lastIndexOf);
                }
                return str;
            }
            if (lastIndexOf == -1) {
                return str.substring(lastIndexOf2 + 1);
            }
            if (lastIndexOf2 < lastIndexOf) {
                return str.substring(lastIndexOf2 + 1, lastIndexOf);
            }
            return str.substring(lastIndexOf2 + 1);
        }
        return str;
    }

    public String getIconFile(String str) {
        return str + this.name + ".png";
    }

    public String getResFold(String str) {
        String str2 = this.resurl;
        if (str2 == null || str2.equals("")) {
            return "";
        }
        return str + getFileNameWithoutExtension(this.resurl) + File.separator;
    }

    public boolean isEmptyFilter() {
        int i3 = this.f281357id;
        if (i3 != -1 && i3 != 0) {
            return false;
        }
        return true;
    }

    public FilterDesc(int i3, int i16, int i17, String str, String str2, String str3, String str4, String str5, int i18) {
        this.f281357id = i3;
        this.subId = i16;
        this.predownload = i17;
        this.resurl = str;
        this.resMD5 = str2;
        this.iconurl = str3;
        this.iconMD5 = str4;
        this.name = str5;
        this.type = i18;
    }

    public FilterDesc(int i3, int i16, String str, String str2, String str3, String str4, String str5, int i17, String str6) {
        this(i3, i16, str, str2, str3, str4, str5, i17);
        this.resRootPath = str6;
    }

    public FilterDesc(int i3, int i16, String str, String str2, String str3, String str4, String str5, int i17) {
        this.f281357id = i3;
        this.predownload = i16;
        this.resurl = str;
        this.resMD5 = str2;
        this.iconurl = str3;
        this.iconMD5 = str4;
        this.name = str5;
        this.type = i17;
    }

    public FilterDesc(int i3, int i16, String str, String str2, String str3, String str4, String str5) {
        this.f281357id = i3;
        this.predownload = i16;
        this.resurl = str;
        this.resMD5 = str2;
        this.iconurl = str3;
        this.iconMD5 = str4;
        this.name = str5;
    }

    public FilterDesc(int i3, int i16, String str, String str2, String str3, String str4, String str5, int i17, int i18) {
        this.f281357id = i3;
        this.predownload = i16;
        this.resurl = str;
        this.resMD5 = str2;
        this.iconurl = str3;
        this.iconMD5 = str4;
        this.name = str5;
        this.type = i17;
        this.version = i18;
    }

    public FilterDesc(int i3, int i16, String str, String str2, String str3, String str4, String str5, int i17, int i18, String str6) {
        this.f281357id = i3;
        this.predownload = i16;
        this.resurl = str;
        this.resMD5 = str2;
        this.iconurl = str3;
        this.iconMD5 = str4;
        this.name = str5;
        this.type = i17;
        this.version = i18;
        this.respicname = str6;
    }
}

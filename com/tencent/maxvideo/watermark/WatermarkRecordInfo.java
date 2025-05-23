package com.tencent.maxvideo.watermark;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class WatermarkRecordInfo extends WatermarkInfo {
    static IPatchRedirector $redirector_;
    public int mEndIndex;
    public int mStartIndex;

    public WatermarkRecordInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getJson(List<WatermarkRecordInfo> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                WatermarkRecordInfo watermarkRecordInfo = list.get(i3);
                if (i3 == 0) {
                    stringBuffer.append("[");
                    stringBuffer.append(watermarkRecordInfo.toJson());
                } else {
                    stringBuffer.append(",");
                    stringBuffer.append(watermarkRecordInfo.toJson());
                }
            }
            stringBuffer.append("]");
        }
        return stringBuffer.toString();
    }

    public static WatermarkRecordInfo getWatermarkRecordInfo4Json(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                WatermarkRecordInfo watermarkRecordInfo = new WatermarkRecordInfo();
                watermarkRecordInfo.mStartIndex = jSONObject.getInt("start_index");
                watermarkRecordInfo.mEndIndex = jSONObject.getInt("end_index");
                watermarkRecordInfo.mDir = jSONObject.getString("root_path");
                return watermarkRecordInfo;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static List<WatermarkRecordInfo> getWatermarkRecordInfo4Jsons(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    if (jSONObject != null) {
                        WatermarkRecordInfo watermarkRecordInfo = new WatermarkRecordInfo();
                        watermarkRecordInfo.mStartIndex = jSONObject.getInt("start_index");
                        watermarkRecordInfo.mEndIndex = jSONObject.getInt("end_index");
                        watermarkRecordInfo.mDir = jSONObject.getString("root_path");
                        arrayList.add(watermarkRecordInfo);
                    }
                }
                return arrayList;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.tencent.maxvideo.watermark.WatermarkInfo
    public String toJson() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "{\"start_index\":" + this.mStartIndex + ",\"end_index\":" + this.mEndIndex + ",\"root_path\":\"" + this.mDir + "\"}";
    }

    @Override // com.tencent.maxvideo.watermark.WatermarkInfo
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "WatermarkRecordInfo [mStartIndex=" + this.mStartIndex + ", mEndIndex=" + this.mEndIndex + ", mType=" + this.mType + ", mDir=" + this.mDir + ", mJsonFilePath=" + this.mJsonFilePath + ", mDesc=" + this.mDesc + "]";
    }
}

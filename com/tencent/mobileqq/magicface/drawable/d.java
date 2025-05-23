package com.tencent.mobileqq.magicface.drawable;

import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.data.MarketFaceConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("PngFrameUtil", 2, "func checkRandomPngExist, file NOT exist.[" + file.getAbsolutePath() + "].");
            }
            return false;
        }
        File file2 = new File(file, "config.json");
        if (!file2.exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("PngFrameUtil", 2, "func checkRandomPngExist, file NOT exist.[" + file2.getAbsolutePath() + "].");
            }
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(FileUtils.readFileContent(file2));
            JSONObject jSONObject2 = jSONObject.getJSONObject("process_frame");
            if (jSONObject2.has("seq_array")) {
                JSONArray jSONArray = jSONObject2.getJSONArray("seq_array");
                if (jSONArray.length() > 0) {
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        File file3 = new File(file, (String) jSONArray.get(i3));
                        if (!file3.exists()) {
                            if (QLog.isColorLevel()) {
                                QLog.d("PngFrameUtil", 2, "func checkRandomPngExist, file NOT exist.[" + file3.getAbsolutePath() + "].");
                            }
                            return false;
                        }
                    }
                }
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray("result_frame");
            if (jSONArray2.length() > 0) {
                for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                    File file4 = new File(file, (String) jSONArray2.get(i16));
                    if (!file4.exists()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("PngFrameUtil", 2, "func checkRandomPngExist, file NOT exist.[" + file4.getAbsolutePath() + "].");
                        }
                        return false;
                    }
                }
                return true;
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("PngFrameUtil", 2, "func checkRandomPngExist, exception:" + e16.getMessage());
            }
            return false;
        }
    }

    private String b(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(MarketFaceConstants.pngFramePath.replace("[epId]", str));
        stringBuffer.append("config.json");
        File file = new File(stringBuffer.toString());
        if (!file.exists()) {
            return null;
        }
        return FileUtils.readFileContent(file);
    }

    public static int d(int i3) {
        if (i3 <= 0) {
            return 0;
        }
        return Math.abs(new Random().nextInt(i3));
    }

    public static int e(String str) {
        int indexOf;
        if (!TextUtils.isEmpty(str) && str.contains("value") && (indexOf = str.indexOf("value") + 5 + 1) < str.length()) {
            try {
                return Integer.parseInt(str.substring(indexOf));
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        }
        return 0;
    }

    public static int g(String str) {
        int indexOf;
        int indexOf2;
        if (!TextUtils.isEmpty(str) && str.contains(EmoticonPackage.EMOTION_RSC_TYPE) && (indexOf2 = (indexOf = str.indexOf(EmoticonPackage.EMOTION_RSC_TYPE) + 7 + 1) + 1) < str.length()) {
            try {
                return Integer.parseInt(str.substring(indexOf, indexOf2));
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        }
        return -1;
    }

    private e h(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e eVar = new e();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(WidgetCacheConstellationData.NUM)) {
                eVar.f243323a = jSONObject.getInt(WidgetCacheConstellationData.NUM);
            }
            if (jSONObject.has("process_frame")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("process_frame");
                if (jSONObject2.has("repeat")) {
                    eVar.f243324b = jSONObject2.getInt("repeat");
                }
                if (jSONObject2.has("frame_delay")) {
                    eVar.f243325c = jSONObject2.getInt("frame_delay");
                }
                JSONArray jSONArray = jSONObject2.getJSONArray("seq_array");
                if (jSONArray != null && jSONArray.length() > 0) {
                    eVar.f243327e = new String[jSONArray.length()];
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        eVar.f243327e[i3] = MarketFaceConstants.pngFramePath.replace("[epId]", str2) + jSONArray.getString(i3);
                    }
                }
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray("result_frame");
            if (jSONArray2 != null && jSONArray2.length() > 0) {
                eVar.f243328f = new String[jSONArray2.length()];
                for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                    eVar.f243328f[i16] = MarketFaceConstants.pngFramePath.replace("[epId]", str2) + jSONArray2.getString(i16);
                }
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return eVar;
    }

    public e c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (e) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return h(b(str), str);
    }

    public int f(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) file)).intValue();
        }
        String readFileContent = FileUtils.readFileContent(file);
        if (!TextUtils.isEmpty(readFileContent)) {
            try {
                JSONObject jSONObject = new JSONObject(readFileContent);
                if (!jSONObject.has(EmoticonPackage.EMOTION_RSC_TYPE)) {
                    return 0;
                }
                int i3 = jSONObject.getInt(EmoticonPackage.EMOTION_RSC_TYPE);
                if (QLog.isColorLevel()) {
                    QLog.d("PngFrameUtil", 2, "func getRscType(from local json file),type:" + i3);
                }
                return i3;
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return 0;
    }
}

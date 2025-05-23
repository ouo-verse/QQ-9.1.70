package com.tencent.av.zplan.avatar.resmgr;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f77317a = "FACE_AGENT";

    /* renamed from: b, reason: collision with root package name */
    public static String f77318b = "k3D_MM_AGENT";

    public static String a(String str) {
        if ("LightFaceModelLowVersion".equalsIgnoreCase(str)) {
            return f77317a;
        }
        return f77318b;
    }

    private static String b(Context context, String str) {
        StringBuilder sb5 = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str), "utf-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb5.append(readLine);
            }
            bufferedReader.close();
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        return sb5.toString();
    }

    public static ArrayList<AVAvatarResInfo> c() {
        return d();
    }

    private static ArrayList<AVAvatarResInfo> d() {
        String str;
        String str2;
        String str3;
        String str4;
        ArrayList<AVAvatarResInfo> arrayList = new ArrayList<>();
        String b16 = b(BaseApplication.context, "artifact_info_android.json");
        try {
        } catch (Exception e16) {
            QLog.e("AVAvatarRes_AVAvatarAIModelResJsonConfig", 1, "loadResInfoListFromJsonConfig failed. err: " + e16);
        }
        if (TextUtils.isEmpty(b16)) {
            QLog.e("AVAvatarRes_AVAvatarAIModelResJsonConfig", 1, "loadResInfoListFromJsonConfig failed. config is empty.");
            return arrayList;
        }
        JSONObject jSONObject = new JSONObject(b16);
        if (jSONObject.has(AECameraConstants.BUNDLE_LIST)) {
            JSONArray jSONArray = jSONObject.getJSONArray(AECameraConstants.BUNDLE_LIST);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                String str5 = "";
                if (!jSONObject2.has("agent_type")) {
                    str = "";
                } else {
                    str = jSONObject2.getString("agent_type");
                }
                if (!jSONObject2.has("bundle_name")) {
                    str2 = "";
                } else {
                    str2 = jSONObject2.getString("bundle_name");
                }
                if (str2.equalsIgnoreCase("LightFaceModel") || str2.equalsIgnoreCase("AEKit3DMM")) {
                    if (jSONObject2.has(HippyImageInfo.QUALITY_LOW)) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject(HippyImageInfo.QUALITY_LOW);
                        if (!jSONObject3.has("md5")) {
                            str3 = "";
                        } else {
                            str3 = jSONObject3.getString("md5");
                        }
                        if (jSONObject3.has("url")) {
                            str5 = jSONObject3.getString("url");
                        }
                        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str5)) {
                            if (str2.equalsIgnoreCase("LightFaceModel")) {
                                str4 = "LightFaceModelLowVersion";
                            } else {
                                str4 = "AEKit3DMMLowVersion";
                            }
                            AVAvatarResInfo aVAvatarResInfo = new AVAvatarResInfo(str4, str5, str3);
                            aVAvatarResInfo.dir = AVAvatarResMgr.u(str4, str3) + File.separator + str2 + AECameraConstants.BUNDLE;
                            arrayList.add(aVAvatarResInfo);
                        }
                    }
                    if (str2.equalsIgnoreCase("LightFaceModel")) {
                        f77317a = str;
                    } else {
                        f77318b = str;
                    }
                }
            }
        }
        QLog.i("AVAvatarRes_AVAvatarAIModelResJsonConfig", 1, "loadResInfoListFromJsonConfig successfully.");
        return arrayList;
    }
}

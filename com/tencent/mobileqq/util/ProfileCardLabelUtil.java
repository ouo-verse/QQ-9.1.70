package com.tencent.mobileqq.util;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profile.ProfileLabelTypeInfo;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class ProfileCardLabelUtil {
    public static void a(final AppRuntime appRuntime) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.util.ProfileCardLabelUtil.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                if (AppRuntime.this == null) {
                    return;
                }
                String decodeString = VipMMKV.getCommon().decodeString("profile_card_label_config_url", "");
                String stringData = VasToggle.FEATURE_PROFILE_CARD_LABEL_CONFIG.getStringData("https://imgcache.qq.com/club/mobile/profile/summary_card/summary_card_lable_1418204880.json");
                QLog.d("ProfileCardLabelUtil", 2, "ProfileCardCheckUpdate start downloadLabelConfigJson url=" + stringData);
                if (!decodeString.equals(stringData)) {
                    try {
                        File file = new File(ProfileCardTemplateUtil.f(AppRuntime.this.getApplication()) + ".tmp");
                        com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(stringData, file);
                        gVar.S = "profileCardDownload";
                        gVar.R = "VIP_profilecard";
                        gVar.V = (byte) 1;
                        gVar.Q = true;
                        int o16 = DownloaderFactory.o(gVar, AppRuntime.this);
                        if (o16 == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        QLog.d("ProfileCardLabelUtil", 2, "ProfileCardCheckUpdate downloadLabelConfigJson result code=" + o16);
                        if (z16) {
                            QLog.d("ProfileCardLabelUtil", 2, "ProfileCardCheckUpdate downloadLabelConfigJson update label config  success");
                            VipMMKV.getCommon().encodeString("profile_card_label_config_url", stringData);
                            ProfileCardLabelUtil.c(file);
                        }
                    } catch (Exception e16) {
                        QLog.e("ProfileCardLabelUtil", 1, e16, new Object[0]);
                    }
                }
            }
        }, 128, null, false);
    }

    private static void b(String str) throws Exception {
        List<ProfileLabelTypeInfo> d16 = d(str);
        if (d16 != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(d16);
            objectOutputStream.flush();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            FileUtils.pushData2File(new File(BaseApplicationImpl.getApplication().getFilesDir(), "labelList").getAbsolutePath(), byteArrayOutputStream.toByteArray(), false);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x008c -> B:22:0x009b). Please report as a decompilation issue!!! */
    public static void c(File file) {
        FileInputStream fileInputStream;
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCardLabelUtil", 2, "ProfileCardCheckUpdate downloadLabelConfigJson labelConfigTempFile is exist :" + file.exists());
        }
        if (file.exists()) {
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Exception e16) {
                    e = e16;
                }
            } catch (Exception e17) {
                QLog.e("ProfileCardLabelUtil", 1, "parseDownLoadDataFromFile error: ", e17);
            }
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 4096);
                        if (read == -1) {
                            break;
                        } else {
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                    }
                    fileInputStream.close();
                    try {
                        file.renameTo(new File(ProfileCardTemplateUtil.f(BaseApplication.getContext())));
                    } catch (Exception e18) {
                        e18.printStackTrace();
                    }
                    String str = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                    if (str.length() > 0) {
                        b(str);
                    }
                    fileInputStream.close();
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e19) {
                            QLog.e("ProfileCardLabelUtil", 1, "parseDownLoadDataFromFile error: ", e19);
                        }
                    }
                    throw th;
                }
            } catch (Exception e26) {
                e = e26;
                fileInputStream2 = fileInputStream;
                QLog.e("ProfileCardLabelUtil", 1, "parseDownLoadDataFromFile error: ", e);
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
            }
        }
    }

    private static List<ProfileLabelTypeInfo> d(String str) throws JSONException {
        if (str != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCardLabelUtil", 2, "ProfileCardCheckUpdate downloadLabelConfigJson labelConfigJsonData length is :" + str.length());
            }
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                ProfileLabelTypeInfo profileLabelTypeInfo = new ProfileLabelTypeInfo();
                profileLabelTypeInfo.typeId = optJSONObject.optString("id");
                profileLabelTypeInfo.typeName = optJSONObject.optString("name");
                profileLabelTypeInfo.typeInfo = optJSONObject.optString("classinfo");
                JSONArray optJSONArray = optJSONObject.optJSONArray("taglist");
                int length2 = optJSONArray.length();
                for (int i16 = 0; i16 < length2; i16++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i16);
                    ProfileLabelInfo profileLabelInfo = new ProfileLabelInfo();
                    profileLabelInfo.labelId = Long.valueOf(jSONObject.optLong("id"));
                    profileLabelInfo.labelName = jSONObject.optString("name");
                    profileLabelInfo.typeId = profileLabelTypeInfo.typeId;
                    profileLabelTypeInfo.labels.add(profileLabelInfo);
                }
                arrayList.add(profileLabelTypeInfo);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ProfileCardLabelUtil", 2, "downloadLabelConfigJson the new typeList size =" + arrayList.size());
                return arrayList;
            }
            return arrayList;
        }
        return null;
    }
}

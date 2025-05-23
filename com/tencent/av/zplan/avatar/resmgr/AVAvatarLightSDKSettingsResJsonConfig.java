package com.tencent.av.zplan.avatar.resmgr;

import android.text.TextUtils;
import com.tencent.av.business.handler.EffectMaterialHandler;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.light.device.OfflineConfig;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVAvatarLightSDKSettingsResJsonConfig {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f77298a = false;

    /* renamed from: b, reason: collision with root package name */
    private static Runnable f77299b = new Runnable() { // from class: com.tencent.av.zplan.avatar.resmgr.AVAvatarLightSDKSettingsResJsonConfig.1
        @Override // java.lang.Runnable
        public void run() {
            AVAvatarLightSDKSettingsResJsonConfig.c(3);
        }
    };

    public static boolean a() {
        return f77298a;
    }

    public static ArrayList<AVAvatarResInfo> b() {
        String str;
        String str2;
        List<PendantItem> i3 = new com.tencent.av.business.processor.b(BaseApplicationImpl.getApplication().getRuntime()).i(com.tencent.av.b.j(), "pendant_update_template.json", "pendant_default_template.json");
        ArrayList<AVAvatarResInfo> arrayList = new ArrayList<>();
        if (i3.size() == 0) {
            QLog.e("AVAvatarRes_AVAvatarLightSDKSettingsResJsonConfig", 1, "loadResInfoList failed. materialList.size() == 0.");
            return arrayList;
        }
        for (int i16 = 0; i16 < i3.size(); i16++) {
            if (i3.get(i16).getId().equalsIgnoreCase("video_zplan_filament_ysp")) {
                PendantItem pendantItem = i3.get(i16);
                int phonePerfLevel = OfflineConfig.getPhonePerfLevel(BaseApplication.getContext());
                if (phonePerfLevel == 5) {
                    str2 = pendantItem.getResUrl();
                    str = pendantItem.getMd5();
                } else {
                    if (pendantItem.getAdditionalPackage() != null) {
                        PendantItem.a additionalPackage = pendantItem.getAdditionalPackage();
                        if (phonePerfLevel == 4) {
                            str2 = additionalPackage.f73405a;
                            str = additionalPackage.f73406b;
                        } else if (phonePerfLevel == 3) {
                            str2 = additionalPackage.f73407c;
                            str = additionalPackage.f73408d;
                        } else if (phonePerfLevel == 2) {
                            str2 = additionalPackage.f73409e;
                            str = additionalPackage.f73410f;
                        } else if (phonePerfLevel == 1) {
                            str2 = additionalPackage.f73411g;
                            str = additionalPackage.f73412h;
                        }
                    } else {
                        QLog.e("AVAvatarRes_AVAvatarLightSDKSettingsResJsonConfig", 1, "loadResInfoList failed. meterial.getAdditionalPackage() == null.");
                    }
                    str = "";
                    str2 = str;
                }
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    AVAvatarResInfo aVAvatarResInfo = new AVAvatarResInfo("LightSDKSettings", str2, str);
                    aVAvatarResInfo.dir = AVAvatarResMgr.u("LightSDKSettings", str) + File.separator + i3.get(i16).getId();
                    arrayList.add(aVAvatarResInfo);
                } else {
                    QLog.e("AVAvatarRes_AVAvatarLightSDKSettingsResJsonConfig", 1, "loadResInfoList failed. resUrl: " + str2 + ", resMd5: " + str + ", phonePerfLevel: " + phonePerfLevel);
                }
            }
        }
        if (arrayList.size() == 0) {
            QLog.e("AVAvatarRes_AVAvatarLightSDKSettingsResJsonConfig", 1, "loadResInfoList failed. resInfoList.size() == 0.");
        }
        return arrayList;
    }

    public static void c(int i3) {
        if (!f77298a) {
            return;
        }
        f77298a = false;
        if (i3 != 3) {
            ThreadManagerV2.removeJob(f77299b, 16);
        }
        QLog.i("AVAvatarRes_AVAvatarLightSDKSettingsResJsonConfig", 1, "onUpdateJsonConfig. retCode: " + i3);
        AVAvatarResMgr.v().D(i3);
    }

    public static void d() {
        QLog.i("AVAvatarRes_AVAvatarLightSDKSettingsResJsonConfig", 1, "requestUpdateJsonConfig.");
        ((EffectMaterialHandler) ((AppInterface) BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(EffectMaterialHandler.class.getName())).F2("QQAVSinglePendantV2", "9");
        f77298a = true;
        ThreadManagerV2.executeDelay(f77299b, 16, null, true, 30000L);
    }
}

package com.tencent.av;

import android.content.Context;
import android.os.Environment;
import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    public static String a() {
        return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "av_image_data" + File.separator);
    }

    public static String b() {
        return c(BaseApplication.getContext()) + "/tencent/msflogs/com/tencent/mobileqq/";
    }

    public static String c(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            return externalFilesDir.getPath();
        }
        return Environment.getExternalStorageDirectory().getPath();
    }

    public static String d() {
        return i() + "beauty" + File.separator;
    }

    public static String e() {
        return i() + QQWinkConstants.TAB_EFFECT;
    }

    public static String f() {
        return i() + "effect_material_config" + File.separator;
    }

    public static String g() {
        return f() + PreDetect.FACE_DETECT + File.separator;
    }

    public static String h() {
        return g() + "face_update_template.json";
    }

    public static String i() {
        return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "qav" + File.separator);
    }

    public static String j() {
        return f() + IndividuationUrlHelper.UrlId.PENDANT_HOME + File.separator;
    }

    public static String k() {
        return j() + "pendant_update_template.json";
    }

    public static String l() {
        return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "ptv_template" + File.separator);
    }

    public static String m() {
        return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "new_ptv_template" + File.separator);
    }

    public static String n() {
        return m() + "new_ptv_template_usable" + File.separator;
    }

    public static String o() {
        return f() + "zplan_avatar" + File.separator;
    }

    public static String p() {
        return o() + "zplan_avatar_update_template.json";
    }

    public static String q() {
        return VFSAssistantUtils.getSDKPrivatePath(i() + "zplan_avatar" + File.separator);
    }

    public static String r() {
        return q() + "zplan_avatar_usable" + File.separator;
    }

    public static String s() {
        return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "av_report_record_dir");
    }
}

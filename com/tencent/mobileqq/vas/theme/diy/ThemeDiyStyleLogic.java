package com.tencent.mobileqq.vas.theme.diy;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vas.VasConstant;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThemeDiyStyleLogic {
    static final String BUNDLE_OPERATE_NEXT = "nextOperate";
    static final String BUNDLE_OPERATE_NOW = "nowOperate";
    public static final int OPERATE_CODE_GO_ERROR = 8;
    public static final int OPERATE_CODE_GO_ON = 4;
    public static final int OPERATE_KEY_SAVE = 10;
    public static final int OPERATE_KEY_SAVE_SERVER = 16;
    public static final int OPERATE_KEY_UPDATE_PAGE = 18;
    AppRuntime app;
    Context mContext;
    public HashMap<Integer, String> reportMap = new HashMap<>();
    public static boolean isNewCustomBackground = VasNormalToggle.BUG_CUSTOM_BACKGROUND_OPT.isEnable(false);
    private static String DIR_DIY = null;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface StyleCallBack {
        int callback(int i3, int i16, Bundle bundle, ResData resData);
    }

    public ThemeDiyStyleLogic(AppRuntime appRuntime, Context context) {
        this.app = appRuntime;
        this.mContext = context;
    }

    public static String getDataDIYDir() {
        if (DIR_DIY == null) {
            String absolutePath = BaseApplication.getContext().getFilesDir().getAbsolutePath();
            String str = File.separator;
            if (absolutePath.endsWith(str)) {
                DIR_DIY = absolutePath + "custom_background/";
            } else {
                DIR_DIY = absolutePath + str + "custom_background/";
            }
        }
        return DIR_DIY;
    }

    public static String getDiyVFSPath(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith(AppConstants.SDCARD_PATH + "custom_background/")) {
                String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(str);
                VasCommonReporter.getHistoryFeature().setValue1("chat_backgroud_sp_move").setValue2("vfs").reportEveryDay();
                return sDKPrivatePath;
            }
            return str;
        }
        return str;
    }

    public static String getNewCustomBackgroundPath() {
        long currentTimeMillis = System.currentTimeMillis();
        String str = VasConstant.INTERNAL_CUSTOM_BG_DIR + currentTimeMillis + ".jpg";
        while (new File(str).exists()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(VasConstant.INTERNAL_CUSTOM_BG_DIR);
            currentTimeMillis++;
            sb5.append(currentTimeMillis);
            sb5.append(".jpg");
            str = sb5.toString();
        }
        return str;
    }
}

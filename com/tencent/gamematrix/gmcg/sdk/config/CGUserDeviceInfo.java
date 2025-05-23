package com.tencent.gamematrix.gmcg.sdk.config;

import android.os.Build;
import android.util.Base64;
import com.tencent.gamematrix.gmcg.base.utils.CGAppUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGFileUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import com.tencent.gamematrix.gmcg.sdk.env.CGClientEnvHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGUserDeviceInfo {
    public String androidVersion;
    public String anid;
    public String appBizNo;
    public String appChannel;
    public String appPackage;
    public String appVersion;
    public String board;
    public String brand;
    public String cloudAppBizInfo;
    public String full_screen;
    public String iiid;
    public String leftMemory;
    public String model;
    public String net;
    public String oaid;
    public String qiiid;
    public String qiiid36;
    public int screenType;
    public String soc;
    public String source;
    public String xid;

    public static CGUserDeviceInfo create() {
        CGUserDeviceInfo cGUserDeviceInfo = new CGUserDeviceInfo();
        cGUserDeviceInfo.iiid = CGClientEnvHelper.get().getDeviceIMEI();
        cGUserDeviceInfo.qiiid = CGClientEnvHelper.get().getDeviceQIMEI();
        cGUserDeviceInfo.qiiid36 = CGClientEnvHelper.get().getDeviceQIMEI36();
        cGUserDeviceInfo.anid = CGClientEnvHelper.get().getDeviceAndroidID();
        cGUserDeviceInfo.source = CGClientEnvHelper.get().getDeviceSource();
        cGUserDeviceInfo.oaid = CGClientEnvHelper.get().getDeviceOAID();
        cGUserDeviceInfo.xid = CGClientEnvHelper.get().getDeviceXID();
        cGUserDeviceInfo.net = CGClientEnvHelper.get().getNetworkType();
        cGUserDeviceInfo.appChannel = CGGlbConfig.getAppChannel();
        cGUserDeviceInfo.appPackage = CGAppUtil.getSelfPackageName();
        cGUserDeviceInfo.appVersion = CGAppUtil.getCurrentVersion(CGGlbConfig.getAppContext());
        cGUserDeviceInfo.appBizNo = CGGlbConfig.getAppBizNo();
        cGUserDeviceInfo.screenType = 0;
        cGUserDeviceInfo.soc = CGGlbConfig.getSoc();
        cGUserDeviceInfo.brand = CGGlbConfig.getBuildBrand();
        cGUserDeviceInfo.model = CGGlbConfig.getBuildModel();
        cGUserDeviceInfo.board = CGGlbConfig.getBuildBoard();
        cGUserDeviceInfo.androidVersion = String.valueOf(Build.VERSION.SDK_INT);
        cGUserDeviceInfo.leftMemory = String.valueOf(CGFileUtil.getAvailableInternalMemorySize());
        return cGUserDeviceInfo;
    }

    public static String encodeToString(String str) {
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 0);
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public boolean isMatch(CGUserDeviceInfo cGUserDeviceInfo) {
        if (cGUserDeviceInfo != null && this.source.equalsIgnoreCase(cGUserDeviceInfo.source) && this.qiiid.equalsIgnoreCase(cGUserDeviceInfo.qiiid)) {
            return true;
        }
        return false;
    }

    public boolean isValid() {
        if (CGStringUtil.notEmpty(this.source) && CGStringUtil.notEmpty(this.qiiid)) {
            return true;
        }
        return false;
    }

    public void setCloudAppBizInfo(String str) {
        if (CGStringUtil.notEmpty(str)) {
            try {
                this.cloudAppBizInfo = encodeToString(URLEncoder.encode(str, "utf-8"));
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        }
    }

    public static CGUserDeviceInfo create(int i3) {
        CGUserDeviceInfo create = create();
        create.screenType = i3;
        return create;
    }
}

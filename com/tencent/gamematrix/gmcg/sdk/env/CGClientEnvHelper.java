package com.tencent.gamematrix.gmcg.sdk.env;

import com.tencent.gamematrix.gmcg.base.helper.CGSingletonHelper;
import com.tencent.gamematrix.gmcg.base.utils.CGNetworkUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import com.tencent.gamematrix.gmcg.sdk.config.CGGlbConfig;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGClientEnvHelper {
    public static final String DEFAULT_BASE_DOMAIN = "cloud.tgpa.qq.com";
    public static final String TGPA_APP_ID = "100204";
    private static final CGSingletonHelper<CGClientEnvHelper> sInstance = new CGSingletonHelper<CGClientEnvHelper>() { // from class: com.tencent.gamematrix.gmcg.sdk.env.CGClientEnvHelper.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.gamematrix.gmcg.base.helper.CGSingletonHelper
        public CGClientEnvHelper create() {
            return new CGClientEnvHelper();
        }
    };
    private String mBaseDomainUrl;
    private String mDeviceAndroidID;
    private String mDeviceIMEI;
    private String mDeviceOAID;
    private String mDeviceQIMEI;
    private String mDeviceQIMEI36;
    private String mDeviceSource;
    private String mDeviceXID;
    private String mNetworkType;

    public static CGClientEnvHelper get() {
        return sInstance.get();
    }

    public String getDeviceAndroidID() {
        return this.mDeviceAndroidID;
    }

    public String getDeviceIMEI() {
        return this.mDeviceIMEI;
    }

    public String getDeviceOAID() {
        return this.mDeviceOAID;
    }

    public String getDeviceQIMEI() {
        return this.mDeviceQIMEI;
    }

    public String getDeviceQIMEI36() {
        return this.mDeviceQIMEI36;
    }

    public String getDeviceSource() {
        return this.mDeviceSource;
    }

    public String getDeviceXID() {
        return this.mDeviceXID;
    }

    public String getNetworkType() {
        return this.mNetworkType;
    }

    public void init(Map<String, String> map) {
        if (map != null) {
            String str = map.get("cloud.tgpa.qq.com");
            if (CGStringUtil.notEmpty(str)) {
                this.mBaseDomainUrl = str;
            }
        }
        refresh();
    }

    public void refresh() {
        this.mDeviceOAID = CGGlbConfig.getOAID();
        this.mDeviceIMEI = CGGlbConfig.getIMEI();
        this.mDeviceQIMEI = CGGlbConfig.getQIMEI();
        this.mDeviceQIMEI36 = CGGlbConfig.getQIMEI36();
        this.mDeviceAndroidID = CGGlbConfig.getAndroidId();
        String appBizNo = CGGlbConfig.getAppBizNo();
        appBizNo.hashCode();
        char c16 = '\uffff';
        switch (appBizNo.hashCode()) {
            case 50:
                if (appBizNo.equals("2")) {
                    c16 = 0;
                    break;
                }
                break;
            case 56:
                if (appBizNo.equals("8")) {
                    c16 = 1;
                    break;
                }
                break;
            case 1571:
                if (appBizNo.equals("14")) {
                    c16 = 2;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                this.mDeviceSource = "tv_android";
                break;
            case 1:
                this.mDeviceSource = "tv_android_launcher";
                break;
            case 2:
                this.mDeviceSource = "qqminigame";
                break;
            default:
                this.mDeviceSource = "app_android";
                break;
        }
        this.mDeviceXID = CGGlbConfig.getXID();
        this.mNetworkType = CGNetworkUtil.getNetworkTypeSymbol(CGGlbConfig.getAppContext());
    }

    CGClientEnvHelper() {
        this.mDeviceIMEI = "unknown";
        this.mDeviceQIMEI = "unknown";
        this.mDeviceQIMEI36 = "unknown";
        this.mDeviceAndroidID = "unknown";
        this.mDeviceSource = "unknown";
        this.mDeviceOAID = "unknown";
        this.mDeviceXID = "unknown";
        this.mNetworkType = "unknown";
        this.mBaseDomainUrl = "cloud.tgpa.qq.com";
    }
}

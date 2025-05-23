package com.tencent.mobileqq.webview.injector;

import com.tencent.aelight.camera.pref.api.IPhoneConfig;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.injector.v;
import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes35.dex */
public class p implements v {
    @Override // com.tencent.mobileqq.webview.swift.injector.v
    public String a(boolean z16) {
        if (WebpSoLoader.d()) {
            return " WebP/0.3.1";
        }
        int[] b16 = WebpSoLoader.b();
        if (z16) {
            return AbsWebView.WEBP_DECODER_VERSION_OF_X5;
        }
        if (b16 != null) {
            return String.format(" WebP/%d.%d.%d", Integer.valueOf(b16[0]), Integer.valueOf(b16[1]), Integer.valueOf(b16[2]));
        }
        return "";
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.v
    public int getDeviceLevel() {
        boolean z16;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        int decodeInt = from.decodeInt("sp_key_device_level", Integer.MIN_VALUE);
        if (decodeInt == Integer.MIN_VALUE) {
            decodeInt = ((IPhoneConfig) QRoute.api(IPhoneConfig.class)).getPhoneLevel();
            from.encodeInt("sp_key_device_level", decodeInt);
            from.commitAsync();
            z16 = false;
        } else {
            z16 = true;
        }
        QLog.d("UtilInjector", 1, "deviceLevel=" + decodeInt + ", fromSp=" + z16);
        return decodeInt;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.v
    public boolean patch(String str, String str2, String str3) {
        return BspatchUtil.a(str, str2, str3);
    }
}

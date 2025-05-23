package com.tencent.mobileqq.webview.injector;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a implements com.tencent.mobileqq.webview.swift.injector.b {
    @Override // com.tencent.mobileqq.webview.swift.injector.b
    public boolean a(Context context) {
        String account = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        return !TextUtils.isEmpty(account) && BaseGesturePWDUtil.getGesturePWDState(context, account) == 2 && BaseGesturePWDUtil.getGesturePWDMode(context, account) == 21;
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.b
    public String b(String str, String... strArr) {
        return com.tencent.biz.common.util.k.e(str, strArr);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.b
    public void beginTimeTrack(String str) {
        if (QLog.isDevelopLevel()) {
            com.tencent.biz.common.util.k.a(str);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.b
    public int c(Context context, String str, String str2) {
        return LzmaUtils.lzmaDecode(context, str, str2);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.b
    public int d(String str, String str2) {
        return ZipUtils.unZipFolder(str, str2);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.b
    public String e(String str, String... strArr) {
        return com.tencent.biz.common.util.k.f(str, strArr);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.b
    public void endTimeTrack(String str) {
        if (QLog.isDevelopLevel()) {
            com.tencent.biz.common.util.k.d(str);
        }
    }
}

package com.tencent.gdtad.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.toast.AdToast;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class y {
    @NonNull
    public static AdError a(Context context, String str, int i3) {
        Context context2;
        boolean z16;
        boolean z17;
        IWXAPI iwxapi = null;
        if (context != null) {
            context2 = context.getApplicationContext();
        } else {
            context2 = null;
        }
        if (context2 != null && !TextUtils.isEmpty(str)) {
            try {
                iwxapi = WXAPIFactory.createWXAPI(context2, str);
            } catch (Throwable th5) {
                QLog.e("GdtWXUtil", 1, "[checkWeChatApp] createWXAPI", th5);
            }
            if (iwxapi == null) {
                QLog.e("GdtWXUtil", 1, "[checkWeChatApp] error, api is null");
                return new AdError(1);
            }
            try {
                z16 = iwxapi.isWXAppInstalled();
            } catch (Throwable th6) {
                QLog.e("GdtWXUtil", 1, "[checkWeChatApp] isWXAppInstalled", th6);
                z16 = false;
            }
            QLog.i("GdtWXUtil", 1, "[checkWeChatApp] isWXAppInstalled:" + z16);
            if (!z16) {
                AdToast.getInstance().show(context2, 0, HardCodeUtil.qqStr(R.string.f170986w14), 0);
                return new AdError(12);
            }
            if (GdtDeviceInfoHelper.getWeChatAPIVer(context) >= i3) {
                z17 = true;
            } else {
                z17 = false;
            }
            QLog.i("GdtWXUtil", 1, "[checkWeChatApp] isWxAppSupported:" + z17);
            if (!z17) {
                AdToast.getInstance().show(context2, 0, HardCodeUtil.qqStr(R.string.f170987w15), 0);
                return new AdError(14);
            }
            return new AdError(0);
        }
        return new AdError(4);
    }
}

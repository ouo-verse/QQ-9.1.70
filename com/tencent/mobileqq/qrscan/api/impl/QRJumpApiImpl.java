package com.tencent.mobileqq.qrscan.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qrscan.activity.DispatchScanResultActivity;
import com.tencent.mobileqq.qrscan.activity.QRJumpActivity;
import com.tencent.mobileqq.qrscan.activity.ScannerActivity;
import com.tencent.mobileqq.qrscan.api.IQRJumpApi;
import com.tencent.mobileqq.qrscan.jumpaction.b;
import com.tencent.mobileqq.qrscan.m;
import com.tencent.mobileqq.qrscan.r;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QRJumpApiImpl implements IQRJumpApi {
    static IPatchRedirector $redirector_;

    public QRJumpApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRJumpApi
    public void displayQRCard(AppRuntime appRuntime, Activity activity, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, activity, str, Integer.valueOf(i3));
        } else {
            r.a(appRuntime, activity, str, i3);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRJumpApi
    public Class<?> getDispatchScanResultActivityCls() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return DispatchScanResultActivity.class;
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRJumpApi
    public Class<?> getScannerActivityCls() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return ScannerActivity.class;
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRJumpApi
    public Class<?> getScannerJumpParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return b.class;
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRJumpApi
    public int handleResult(AppRuntime appRuntime, Activity activity, m mVar, String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, appRuntime, activity, mVar, str, bundle)).intValue();
        }
        return r.c(appRuntime, activity, mVar, str, bundle);
    }

    @Override // com.tencent.mobileqq.qrscan.api.IQRJumpApi
    public void startQRJumpActivity(Context context, String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, str, str2, Boolean.valueOf(z16));
            return;
        }
        Intent intent = new Intent(context, (Class<?>) QRJumpActivity.class);
        intent.putExtra("url", str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("attr_original_url", str2);
        }
        intent.putExtra("fromQrcode", z16);
        context.startActivity(intent);
    }
}

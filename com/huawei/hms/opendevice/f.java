package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

/* compiled from: P */
/* loaded from: classes2.dex */
public class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public Context f37344a;

    public f(Context context) {
        this.f37344a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        Bundle bundle;
        try {
            int internalCode = ErrorEnum.SUCCESS.getInternalCode();
            ApiException apiException = null;
            try {
                str = HmsInstanceId.getInstance(this.f37344a).getToken(Util.getAppId(this.f37344a), null);
                try {
                    HMSLog.i("AutoInit", "Push init succeed");
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                } catch (ApiException e16) {
                    e = e16;
                    apiException = e;
                    internalCode = apiException.getStatusCode();
                    HMSLog.e("AutoInit", "new Push init failed");
                    bundle = this.f37344a.getPackageManager().getApplicationInfo(this.f37344a.getPackageName(), 128).metaData;
                    if (bundle == null) {
                    }
                    HMSLog.i("AutoInit", "push kit sdk not exists");
                }
            } catch (ApiException e17) {
                e = e17;
                str = null;
            }
            try {
                bundle = this.f37344a.getPackageManager().getApplicationInfo(this.f37344a.getPackageName(), 128).metaData;
                if (bundle == null && bundle.getString("com.huawei.hms.client.service.name:push") != null) {
                    Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
                    intent.setPackage(this.f37344a.getPackageName());
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(RemoteMessageConst.MSGTYPE, "new_token");
                    bundle2.putString(RemoteMessageConst.DEVICE_TOKEN, str);
                    bundle2.putInt("error", internalCode);
                    if (apiException != null) {
                        bundle2.putSerializable("exception_key", apiException);
                    }
                    if (!new h().a(this.f37344a, bundle2, intent)) {
                        HMSLog.e("AutoInit", "start service failed");
                        return;
                    }
                    return;
                }
                HMSLog.i("AutoInit", "push kit sdk not exists");
            } catch (PackageManager.NameNotFoundException unused) {
                HMSLog.i("AutoInit", "push kit sdk not exists");
            }
        } catch (Exception e18) {
            HMSLog.e("AutoInit", "Push init failed", e18);
        }
    }
}

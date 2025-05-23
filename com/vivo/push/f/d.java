package com.vivo.push.f;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class d extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d(com.vivo.push.v vVar) {
        super(vVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e9 A[Catch: Exception -> 0x01c1, TryCatch #0 {Exception -> 0x01c1, blocks: (B:19:0x00bc, B:21:0x00c3, B:23:0x00cd, B:25:0x00da, B:30:0x00e9, B:31:0x01b4, B:34:0x00fc, B:36:0x010f, B:38:0x0119, B:39:0x0129, B:42:0x013a, B:44:0x0140, B:46:0x014c, B:48:0x016e, B:50:0x0174, B:51:0x017b, B:53:0x019a, B:55:0x019e, B:56:0x0132), top: B:18:0x00bc }] */
    @Override // com.vivo.push.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.vivo.push.v vVar) {
        Intent intent;
        String packageName;
        boolean z16;
        com.vivo.push.b.p pVar = (com.vivo.push.b.p) vVar;
        if (pVar == null) {
            com.vivo.push.util.u.d("NotifyInnerClientTask", "current onNotifyArrivedCommand is null");
            return;
        }
        InsideNotificationItem f16 = pVar.f();
        if (f16 == null) {
            com.vivo.push.util.u.d("NotifyInnerClientTask", "current notification item is null");
            return;
        }
        UPSNotificationMessage a16 = com.vivo.push.util.v.a(f16);
        boolean equals = this.f387838a.getPackageName().equals(pVar.d());
        if (equals) {
            NotifyAdapterUtil.cancelNotify(this.f387838a);
        }
        if (equals) {
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(1030L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("type", "2");
            hashMap.put(com.heytap.mcssdk.a.a.f36093c, String.valueOf(pVar.e()));
            hashMap.put("platform", this.f387838a.getPackageName());
            String a17 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a17)) {
                hashMap.put("remoteAppId", a17);
            }
            xVar.a(hashMap);
            com.vivo.push.m.a().a(xVar);
            com.vivo.push.util.u.d("NotifyInnerClientTask", "notification is clicked by skip type[" + a16.getSkipType() + "]");
            com.vivo.push.util.u.d("NotifyInnerClientTask", "notification is clicked by skip content[" + a16.getSkipContent() + "]");
            try {
                if (a16.getSkipType() == 2) {
                    String skipContent = a16.getSkipContent();
                    if (!TextUtils.isEmpty(skipContent)) {
                        String lowerCase = skipContent.toLowerCase();
                        if (lowerCase.startsWith("http://") || lowerCase.startsWith("https://")) {
                            z16 = true;
                            if (z16) {
                                return;
                            }
                            intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(skipContent));
                            intent.setFlags(268435456);
                        }
                    }
                    z16 = false;
                    if (z16) {
                    }
                } else {
                    intent = new Intent(pVar.g());
                    if (!TextUtils.isEmpty(pVar.h()) && !TextUtils.isEmpty(pVar.i())) {
                        intent.setComponent(new ComponentName(pVar.h(), pVar.i()));
                    }
                    if (intent.getComponent() == null) {
                        packageName = null;
                    } else {
                        packageName = intent.getComponent().getPackageName();
                    }
                    if (!TextUtils.isEmpty(packageName) && !this.f387838a.getPackageName().equals(packageName)) {
                        com.vivo.push.util.u.a("NotifyInnerClientTask", "inner activity component error : local pkgName is " + this.f387838a.getPackageName() + "; but remote pkgName is " + packageName);
                        return;
                    }
                    if (pVar.j() != null) {
                        intent.setData(pVar.j());
                    }
                    intent.setSelector(null);
                    intent.setPackage(this.f387838a.getPackageName());
                    intent.addFlags(335544320);
                    ActivityInfo resolveActivityInfo = intent.resolveActivityInfo(this.f387838a.getPackageManager(), 65536);
                    if (resolveActivityInfo != null && !resolveActivityInfo.exported) {
                        com.vivo.push.util.u.d("NotifyInnerClientTask", "activity is not exported : " + resolveActivityInfo.toString());
                    }
                }
                intent.putExtras(pVar.k());
                this.f387838a.startActivity(intent);
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        com.vivo.push.util.u.a("NotifyInnerClientTask", "notify is " + a16 + " ; isMatch is " + equals);
    }
}

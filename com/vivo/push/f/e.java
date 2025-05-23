package com.vivo.push.f;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class e extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.vivo.push.v vVar) {
        super(vVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Intent b(Intent intent, Map<String, String> map) {
        if (map != null && map.entrySet() != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v vVar) {
        Intent parseUri;
        String str;
        com.vivo.push.b.p pVar = (com.vivo.push.b.p) vVar;
        InsideNotificationItem f16 = pVar.f();
        if (f16 == null) {
            com.vivo.push.util.u.d("NotifyOpenClientTask", "current notification item is null");
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
            com.vivo.push.util.u.d("NotifyOpenClientTask", "notification is clicked by skip type[" + a16.getSkipType() + "]");
            int skipType = a16.getSkipType();
            boolean z16 = true;
            if (skipType == 1) {
                new BaseThread(new f(this, this.f387838a, a16.getParams())).start();
                a(a16);
                return;
            }
            if (skipType == 2) {
                String skipContent = a16.getSkipContent();
                if (!skipContent.startsWith("http://") && !skipContent.startsWith("https://")) {
                    z16 = false;
                }
                if (z16) {
                    Uri parse = Uri.parse(skipContent);
                    Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, parse);
                    intent.setFlags(268435456);
                    b(intent, a16.getParams());
                    try {
                        this.f387838a.startActivity(intent);
                    } catch (Exception unused) {
                        com.vivo.push.util.u.a("NotifyOpenClientTask", "startActivity error : ".concat(String.valueOf(parse)));
                    }
                } else {
                    com.vivo.push.util.u.a("NotifyOpenClientTask", "url not legal");
                }
                a(a16);
                return;
            }
            if (skipType == 3) {
                a(a16);
                return;
            }
            if (skipType != 4) {
                com.vivo.push.util.u.a("NotifyOpenClientTask", "illegitmacy skip type error : " + a16.getSkipType());
                return;
            }
            String skipContent2 = a16.getSkipContent();
            try {
                parseUri = Intent.parseUri(skipContent2, 1);
                str = parseUri.getPackage();
            } catch (Exception e16) {
                com.vivo.push.util.u.a("NotifyOpenClientTask", "open activity error : ".concat(String.valueOf(skipContent2)), e16);
            }
            if (!TextUtils.isEmpty(str) && !this.f387838a.getPackageName().equals(str)) {
                com.vivo.push.util.u.a("NotifyOpenClientTask", "open activity error : local pkgName is " + this.f387838a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                return;
            }
            String packageName = parseUri.getComponent() == null ? null : parseUri.getComponent().getPackageName();
            if (!TextUtils.isEmpty(packageName) && !this.f387838a.getPackageName().equals(packageName)) {
                com.vivo.push.util.u.a("NotifyOpenClientTask", "open activity component error : local pkgName is " + this.f387838a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
                return;
            }
            parseUri.setSelector(null);
            parseUri.setPackage(this.f387838a.getPackageName());
            parseUri.addFlags(335544320);
            b(parseUri, a16.getParams());
            ActivityInfo resolveActivityInfo = parseUri.resolveActivityInfo(this.f387838a.getPackageManager(), 65536);
            if (resolveActivityInfo != null && !resolveActivityInfo.exported) {
                com.vivo.push.util.u.a("NotifyOpenClientTask", "activity is not exported : " + resolveActivityInfo.toString());
                return;
            } else {
                this.f387838a.startActivity(parseUri);
                a(a16);
                return;
            }
        }
        com.vivo.push.util.u.a("NotifyOpenClientTask", "notify is " + a16 + " ; isMatch is " + equals);
    }

    private void a(UPSNotificationMessage uPSNotificationMessage) {
        com.vivo.push.t.c(new g(this, uPSNotificationMessage));
    }
}

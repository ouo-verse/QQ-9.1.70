package com.huawei.hms.health;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;

/* compiled from: P */
/* loaded from: classes2.dex */
public class aabj extends HuaweiApi<aabl> implements aabn {
    private static final aabi aaba = new aabi();
    private static final Api<aabl> aabb = new Api<>("HuaweiHealth.API");
    private Context aab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aabj(Activity activity, aabl aablVar) {
        super(activity, aabb, aablVar, (AbstractClientBuilder) aaba);
        this.aab = activity.getApplicationContext();
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getApiLevel() {
        String str;
        Bundle bundle;
        Context context = this.aab;
        if (context != null) {
            try {
                if (context.getPackageManager() != null && (bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData) != null) {
                    return bundle.getInt("com.huawei.hms.min_api_level:hihealth-base:hihealth");
                }
            } catch (PackageManager.NameNotFoundException unused) {
                StringBuilder aab = aab.aab("can not find the app, package name:");
                aab.append(context.getPackageName());
                str = aab.toString();
                aabz.aab("PackageManagerUtil", str);
                return 1;
            } catch (RuntimeException unused2) {
                str = "getApplicationInfo exists exception!";
                aabz.aab("PackageManagerUtil", str);
                return 1;
            }
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aabj(Context context, aabl aablVar) {
        super(context, aabb, aablVar, aaba);
        this.aab = context.getApplicationContext();
    }
}

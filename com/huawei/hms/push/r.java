package com.huawei.hms.push;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public class r {
    public static int a(Context context, String str, String str2) {
        try {
            int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
            if (identifier == 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(context.getPackageName());
                sb5.append(".R$");
                sb5.append(str);
                Field field = Class.forName(sb5.toString()).getField(str2);
                identifier = Integer.parseInt(field.get(field.getName()).toString());
                if (identifier == 0) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Error-resourceType=");
                    sb6.append(str);
                    sb6.append("--resourceName=");
                    sb6.append(str2);
                    sb6.append("--resourceId =");
                    sb6.append(identifier);
                    HMSLog.i("ResourceLoader", sb6.toString());
                }
            }
            return identifier;
        } catch (ClassNotFoundException e16) {
            HMSLog.e("ResourceLoader", "!!!! ResourceLoader: ClassNotFoundException-resourceType=" + str + "--resourceName=" + str2, e16);
            return 0;
        } catch (IllegalAccessException e17) {
            HMSLog.e("ResourceLoader", "!!!! ResourceLoader: IllegalAccessException-resourceType=" + str + "--resourceName=" + str2, e17);
            return 0;
        } catch (IllegalArgumentException e18) {
            HMSLog.e("ResourceLoader", "!!!! ResourceLoader: IllegalArgumentException-resourceType=" + str + "--resourceName=" + str2, e18);
            return 0;
        } catch (NoSuchFieldException e19) {
            HMSLog.e("ResourceLoader", "!!!! ResourceLoader: NoSuchFieldException-resourceType=" + str + "--resourceName=" + str2, e19);
            return 0;
        } catch (NumberFormatException e26) {
            HMSLog.e("ResourceLoader", "!!!! ResourceLoader: NumberFormatException-resourceType=" + str + "--resourceName=" + str2, e26);
            return 0;
        }
    }

    public static int a(Context context, String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return 0;
            }
            return bundle.getInt(str);
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.w("ResourceLoader", "load meta data resource failed.");
            return 0;
        }
    }
}

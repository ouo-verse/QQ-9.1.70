package com.tencent.libra.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.util.LibraLogUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public final class LibraManifestParser {
    private static final String LIBRA_MODULE_VALUE = "LibraModule";
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("LibraManifestParser");
    private final Context context;

    public LibraManifestParser(Context context) {
        this.context = context;
    }

    private static LibraModule parseModule(String str) {
        Object obj;
        try {
            Class<?> cls = Class.forName(str);
            try {
                obj = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e16) {
                throwInstantiateLibraModuleException(cls, e16);
                obj = null;
            }
            if (obj instanceof LibraModule) {
                return (LibraModule) obj;
            }
            throw new RuntimeException("Expected instanceof LibraModule, but found: " + obj);
        } catch (ClassNotFoundException e17) {
            throw new IllegalArgumentException("Unable to find LibraModule implementation", e17);
        }
    }

    private static void throwInstantiateLibraModuleException(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate LibraModule implementation for " + cls, exc);
    }

    public List<LibraModule> parse() {
        String str = TAG;
        RFWLog.i(str, RFWLog.USR, "Loading Libra modules");
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                RFWLog.i(str, RFWLog.USR, "Got null app info metadata");
                return arrayList;
            }
            RFWLog.i(str, RFWLog.USR, "Got app info metadata: " + applicationInfo.metaData);
            for (String str2 : applicationInfo.metaData.keySet()) {
                if (LIBRA_MODULE_VALUE.equals(applicationInfo.metaData.get(str2))) {
                    arrayList.add(parseModule(str2));
                    RFWLog.i(TAG, RFWLog.USR, "Loaded Libra module: " + str2);
                }
            }
            RFWLog.i(TAG, RFWLog.USR, "Finished loading Libra modules");
            return arrayList;
        } catch (PackageManager.NameNotFoundException e16) {
            throw new RuntimeException("Unable to find metadata to parse LibraModules", e16);
        }
    }
}

package com.tencent.qqmini.sdk.runtime;

import android.util.AndroidRuntimeException;
import com.tencent.qqmini.sdk.annotation.RuntimeLoaderConfig;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.runtime.BaseRuntimeLoader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class RuntimeLoaderConfiguration {
    private final List<RuntimeLoaderInfo> loaderInfoList = new ArrayList();
    Comparator comparator = new Comparator<RuntimeLoaderInfo>() { // from class: com.tencent.qqmini.sdk.runtime.RuntimeLoaderConfiguration.1
        @Override // java.util.Comparator
        public int compare(RuntimeLoaderInfo runtimeLoaderInfo, RuntimeLoaderInfo runtimeLoaderInfo2) {
            if (runtimeLoaderInfo == null || runtimeLoaderInfo2 == null) {
                return 0;
            }
            return runtimeLoaderInfo.type - runtimeLoaderInfo2.type;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class RuntimeLoaderInfo {
        BaseRuntimeLoader.Creator<?> creator;
        Class<BaseRuntimeLoader> runtimeLoaderClass;
        int type;

        RuntimeLoaderInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RuntimeLoaderConfiguration(AppRuntimeLoaderManager appRuntimeLoaderManager) {
        com.tencent.qqmini.sdk.annotation.RuntimeLoaderInfo[] loaders;
        RuntimeLoaderInfo runtimeLoaderInfo;
        Class cls;
        RuntimeLoaderConfig runtimeLoaderConfig = (RuntimeLoaderConfig) appRuntimeLoaderManager.getClass().getAnnotation(RuntimeLoaderConfig.class);
        if (runtimeLoaderConfig != null && (loaders = runtimeLoaderConfig.loaders()) != null) {
            for (com.tencent.qqmini.sdk.annotation.RuntimeLoaderInfo runtimeLoaderInfo2 : loaders) {
                try {
                    runtimeLoaderInfo = new RuntimeLoaderInfo();
                    cls = Class.forName(runtimeLoaderInfo2.className());
                } catch (Throwable th5) {
                    QMLog.w("RuntimeLoaderConfiguration", "", th5);
                }
                if (BaseRuntimeLoader.class.isAssignableFrom(cls)) {
                    runtimeLoaderInfo.runtimeLoaderClass = cls;
                    runtimeLoaderInfo.type = runtimeLoaderInfo2.type();
                    Field field = runtimeLoaderInfo.runtimeLoaderClass.getField("CREATOR");
                    if ((field.getModifiers() & 8) != 0) {
                        if (BaseRuntimeLoader.Creator.class.isAssignableFrom(field.getType())) {
                            runtimeLoaderInfo.creator = (BaseRuntimeLoader.Creator) field.get(null);
                            this.loaderInfoList.add(runtimeLoaderInfo);
                        } else {
                            throw new AndroidRuntimeException("RuntimeLoader requires a BaseAppRuntimeLoader.Creator object called CREATOR on class " + runtimeLoaderInfo2.className());
                        }
                    } else {
                        throw new AndroidRuntimeException("RuntimeLoader protocol requires the CREATOR object to be static on class " + runtimeLoaderInfo2.className());
                    }
                } else {
                    throw new AndroidRuntimeException("RuntimeLoaderConfig requires child class of BaseAppRuntimeLoader, current class is " + runtimeLoaderInfo2.className());
                }
            }
        }
    }

    public List<RuntimeLoaderInfo> getLoaderInfoList() {
        return this.loaderInfoList;
    }

    public List<RuntimeLoaderInfo> getLoaderInfoListForPreload() {
        return new ArrayList(this.loaderInfoList);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{");
        for (RuntimeLoaderInfo runtimeLoaderInfo : this.loaderInfoList) {
            if (runtimeLoaderInfo != null) {
                sb5.append("***Loader:");
                sb5.append(runtimeLoaderInfo.runtimeLoaderClass.getName());
                sb5.append(", Creator:");
                sb5.append(runtimeLoaderInfo.creator.getClass().getName());
                sb5.append("***");
            }
        }
        sb5.append("}");
        return sb5.toString();
    }
}

package com.tencent.qqlive.module.videoreport.utils;

import android.os.SystemProperties;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SystemUtils {
    private static final String TAG = "SystemUtils";
    private static volatile String sSystemUI;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static abstract class AbstractUIVersionGetter implements IUIVersionGetter {
        String mUIPrefix;

        AbstractUIVersionGetter(String str) {
            this.mUIPrefix = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class DefaultVersionGetter extends UIVersionGetterBySystemProperty {
        DefaultVersionGetter() {
            super(null, "ro.build.display.id");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class EMUIVersionGetter extends UIVersionGetterBySystemProperty {
        EMUIVersionGetter() {
            super("EMUI", "ro.build.version.emui");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface IUIVersionGetter {
        String getUIVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class MIUIVersionGetter extends UIVersionGetterBySystemProperty {
        MIUIVersionGetter() {
            super("MIUI", "ro.miui.ui.version.name");
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class UIVersionGetterBySystemProperty extends AbstractUIVersionGetter {
        private String mPropertyName;

        UIVersionGetterBySystemProperty(String str, @NonNull String str2) {
            super(str);
            this.mPropertyName = str2;
        }

        @Override // com.tencent.qqlive.module.videoreport.utils.SystemUtils.IUIVersionGetter
        public String getUIVersion() {
            String systemProperty = SystemUtils.getSystemProperty(this.mPropertyName);
            if (TextUtils.isEmpty(systemProperty)) {
                return null;
            }
            if (!TextUtils.isEmpty(this.mUIPrefix)) {
                return this.mUIPrefix + " " + systemProperty;
            }
            return systemProperty;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getSystemProperty(String str) {
        try {
            return (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class, str, null);
        } catch (Exception e16) {
            Log.e(TAG, "getSystemProperty " + e16);
            return null;
        }
    }

    public static String getSystemUI() {
        if (sSystemUI == null) {
            sSystemUI = getSystemUIVersion();
        }
        return sSystemUI;
    }

    private static String getSystemUIVersion() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MIUIVersionGetter());
        arrayList.add(new EMUIVersionGetter());
        arrayList.add(new DefaultVersionGetter());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String uIVersion = ((IUIVersionGetter) it.next()).getUIVersion();
            if (!TextUtils.isEmpty(uIVersion)) {
                return uIVersion;
            }
        }
        return "";
    }
}

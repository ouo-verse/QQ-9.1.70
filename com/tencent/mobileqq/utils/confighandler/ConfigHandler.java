package com.tencent.mobileqq.utils.confighandler;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import ty2.b;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class ConfigHandler<T extends ConfigInfo> {
    protected final String TAG;
    private final Class<T> mConfigInfoClass;
    protected final String mUin;

    public ConfigHandler(String str, String str2) {
        String str3;
        str = str == null ? getClass().getSimpleName() : str;
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass != null) {
            if (genericSuperclass instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                if (actualTypeArguments != null) {
                    if (actualTypeArguments.length > 0) {
                        Class<T> cls = (Class) actualTypeArguments[0];
                        this.mConfigInfoClass = cls;
                        str3 = "ConfigInfoClass[" + cls + "]";
                    } else {
                        this.mConfigInfoClass = null;
                        str3 = "ActualTypeArguments\u957f\u5ea6\u4e3a0";
                    }
                } else {
                    this.mConfigInfoClass = null;
                    str3 = "getActualTypeArguments\u4e3a\u7a7a";
                }
            } else {
                this.mConfigInfoClass = null;
                str3 = "type[" + genericSuperclass.getClass().getName() + "]";
            }
        } else {
            this.mConfigInfoClass = null;
            str3 = "getGenericSuperclass\u4e3a\u7a7a";
        }
        this.TAG = str;
        this.mUin = str2;
        if (this.mConfigInfoClass == null) {
            QLog.w(str, 1, "ConfigHandler, get ConfigInfoClassType\u5931\u8d25, " + str3);
        } else if (QQAudioHelper.f()) {
            QLog.w(str, 1, "ConfigHandler, get ConfigInfoClassType\u6210\u529f, " + this.mConfigInfoClass);
        }
        if (this.mConfigInfoClass == null && QQAudioHelper.f()) {
            throw new IllegalArgumentException(str + " get ConfigInfoClassType\u5931\u8d25, " + str3);
        }
    }

    public static void checkUin(String str, String str2) {
        if (QQAudioHelper.f() && TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException(str + " \u914d\u7f6e\u9700\u8981UIN");
        }
    }

    public static <T extends ConfigInfo> T getConfigInfo(String str, String str2, int i3, Class<T> cls, String str3, String str4, String str5, String str6) {
        T t16;
        String str7 = null;
        int i16 = 0;
        if (TextUtils.isEmpty(str2)) {
            SharedPreferences a16 = b.a(str, str3, str4);
            if (a16 != null) {
                str2 = a16.getString(str5, null);
                i3 = a16.getInt(str6, 0);
                i16 = 1;
            } else {
                i16 = 2;
            }
        }
        QLog.w(str, 1, "ConfigInfo.get, step[" + i16 + "], configText[" + str2 + "], version[" + i3 + "]");
        try {
            String name = cls.getName();
            try {
                t16 = cls.newInstance();
                try {
                    t16.setUin(str3);
                    t16.serverVer = i3;
                    t16.tryParse(str, str2);
                } catch (Exception e16) {
                    e = e16;
                    str7 = name;
                    QLog.w(str, 1, "getConfigInfo \u5b9e\u4f8b\u5931\u8d251, cls[" + str7 + "]", e);
                    return t16;
                }
            } catch (Exception e17) {
                e = e17;
                t16 = null;
            }
        } catch (Exception e18) {
            e = e18;
            t16 = null;
        }
        return t16;
    }

    public static <T extends ConfigInfo> T getConfigInfoNew(String str, String str2, int i3, Class<T> cls, String str3) {
        T t16;
        if (TextUtils.isEmpty(str2)) {
            str2 = QAVConfig.e(i3).f448490b;
        } else {
            QLog.w(str, 1, "ConfigInfo.get, configText[" + str2 + "]");
        }
        String str4 = null;
        try {
            String name = cls.getName();
            try {
                t16 = cls.newInstance();
                try {
                    t16.setUin(str3);
                    t16.serverVer = QAVConfig.d(i3);
                    t16.tryParse(str, str2);
                } catch (Exception e16) {
                    e = e16;
                    str4 = name;
                    QLog.w(str, 1, "getConfigInfo \u5b9e\u4f8b\u5931\u8d251, cls[" + str4 + "]", e);
                    return t16;
                }
            } catch (Exception e17) {
                e = e17;
                t16 = null;
            }
        } catch (Exception e18) {
            e = e18;
            t16 = null;
        }
        return t16;
    }

    public static int getConfigVer(SharedPreferences sharedPreferences, String str, String str2) {
        if (sharedPreferences == null || TextUtils.isEmpty(sharedPreferences.getString(str, null))) {
            return 0;
        }
        return sharedPreferences.getInt(str2, 0);
    }

    public static void saveConfigSP(String str, SharedPreferences sharedPreferences, String str2, int i3, String str3, String str4) {
        if (sharedPreferences != null) {
            if (TextUtils.isEmpty(str2)) {
                sharedPreferences.edit().remove(str3);
            } else {
                sharedPreferences.edit().putString(str3, str2);
            }
            sharedPreferences.edit().putInt(str4, i3);
            sharedPreferences.edit().commit();
            return;
        }
        QLog.w(str, 1, "saveConfig, sp\u4e3anull");
    }

    public final Class<T> getConfigInfoClass() {
        return this.mConfigInfoClass;
    }

    public abstract int getConfigVer();

    public final String getTag() {
        return this.TAG;
    }

    public abstract void onGetConfigFinish(QQAppInterface qQAppInterface, String str, T t16);

    public abstract void saveConfig(String str, int i3);

    public void doOnReconnect(QQAppInterface qQAppInterface) {
    }
}

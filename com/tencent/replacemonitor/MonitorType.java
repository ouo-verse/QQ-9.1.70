package com.tencent.replacemonitor;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes25.dex */
public final class MonitorType {
    private static final /* synthetic */ MonitorType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final MonitorType BY_APP_NAME;
    public static final MonitorType BY_CHANNEL_ID;
    public static final MonitorType BY_COMMON;
    public static final MonitorType BY_FILE_MD5;
    public static final MonitorType BY_FILE_SIZE;
    public static final MonitorType BY_MODIFY_TIME;
    public static final MonitorType BY_VERSION_CODE;
    public static final MonitorType UNKNOW;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12599);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        MonitorType monitorType = new MonitorType("UNKNOW", 0);
        UNKNOW = monitorType;
        MonitorType monitorType2 = new MonitorType("BY_FILE_SIZE", 1);
        BY_FILE_SIZE = monitorType2;
        MonitorType monitorType3 = new MonitorType("BY_FILE_MD5", 2);
        BY_FILE_MD5 = monitorType3;
        MonitorType monitorType4 = new MonitorType("BY_APP_NAME", 3);
        BY_APP_NAME = monitorType4;
        MonitorType monitorType5 = new MonitorType("BY_VERSION_CODE", 4);
        BY_VERSION_CODE = monitorType5;
        MonitorType monitorType6 = new MonitorType("BY_CHANNEL_ID", 5);
        BY_CHANNEL_ID = monitorType6;
        MonitorType monitorType7 = new MonitorType("BY_COMMON", 6);
        BY_COMMON = monitorType7;
        MonitorType monitorType8 = new MonitorType("BY_MODIFY_TIME", 7);
        BY_MODIFY_TIME = monitorType8;
        $VALUES = new MonitorType[]{monitorType, monitorType2, monitorType3, monitorType4, monitorType5, monitorType6, monitorType7, monitorType8};
    }

    MonitorType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static MonitorType valueOf(String str) {
        return (MonitorType) Enum.valueOf(MonitorType.class, str);
    }

    public static MonitorType[] values() {
        return (MonitorType[]) $VALUES.clone();
    }
}

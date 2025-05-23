package com.tencent.common.config.pad;

import com.tencent.mobileqq.gamecenter.api.IYunGameConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
/* loaded from: classes5.dex */
public final class DeviceType {
    private static final /* synthetic */ DeviceType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final DeviceType FOLD;
    public static final DeviceType PHONE;
    public static final DeviceType TABLET;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36787);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        DeviceType deviceType = new DeviceType(IYunGameConstant.MIDAS_FLATFORM_TYPE, 0);
        PHONE = deviceType;
        DeviceType deviceType2 = new DeviceType("TABLET", 1);
        TABLET = deviceType2;
        DeviceType deviceType3 = new DeviceType("FOLD", 2);
        FOLD = deviceType3;
        $VALUES = new DeviceType[]{deviceType, deviceType2, deviceType3};
    }

    DeviceType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static DeviceType valueOf(String str) {
        return (DeviceType) Enum.valueOf(DeviceType.class, str);
    }

    public static DeviceType[] values() {
        return (DeviceType[]) $VALUES.clone();
    }
}

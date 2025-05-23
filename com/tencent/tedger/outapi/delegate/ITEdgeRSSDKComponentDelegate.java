package com.tencent.tedger.outapi.delegate;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rdelivery.reshub.api.i;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface ITEdgeRSSDKComponentDelegate {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class DeviceLevel {
        private static final /* synthetic */ DeviceLevel[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final DeviceLevel HIGH_LEVEL;
        public static final DeviceLevel LOW_LEVEL;
        public static final DeviceLevel UNKNOWN;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10131);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            DeviceLevel deviceLevel = new DeviceLevel("HIGH_LEVEL", 0);
            HIGH_LEVEL = deviceLevel;
            DeviceLevel deviceLevel2 = new DeviceLevel("LOW_LEVEL", 1);
            LOW_LEVEL = deviceLevel2;
            DeviceLevel deviceLevel3 = new DeviceLevel("UNKNOWN", 2);
            UNKNOWN = deviceLevel3;
            $VALUES = new DeviceLevel[]{deviceLevel, deviceLevel2, deviceLevel3};
        }

        DeviceLevel(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static DeviceLevel valueOf(String str) {
            return (DeviceLevel) Enum.valueOf(DeviceLevel.class, str);
        }

        public static DeviceLevel[] values() {
            return (DeviceLevel[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface a {
        void complete();
    }

    long a();

    DeviceLevel b();

    void c(Map<String, Object> map);

    void d(String str, a aVar);

    Map<String, String> e(String str);

    boolean f(String str);

    i g();

    int h();
}

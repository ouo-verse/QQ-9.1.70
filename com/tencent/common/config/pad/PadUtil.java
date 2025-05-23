package com.tencent.common.config.pad;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public class PadUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f99567a;

    /* renamed from: b, reason: collision with root package name */
    private static DeviceType f99568b;

    /* renamed from: c, reason: collision with root package name */
    private static FoldSwitch f99569c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class FoldSwitch {
        private static final /* synthetic */ FoldSwitch[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final FoldSwitch CLOSE;
        public static final FoldSwitch NOT_INIT;
        public static final FoldSwitch OPEN;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36851);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            FoldSwitch foldSwitch = new FoldSwitch("NOT_INIT", 0);
            NOT_INIT = foldSwitch;
            FoldSwitch foldSwitch2 = new FoldSwitch("OPEN", 1);
            OPEN = foldSwitch2;
            FoldSwitch foldSwitch3 = new FoldSwitch("CLOSE", 2);
            CLOSE = foldSwitch3;
            $VALUES = new FoldSwitch[]{foldSwitch, foldSwitch2, foldSwitch3};
        }

        FoldSwitch(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static FoldSwitch valueOf(String str) {
            return (FoldSwitch) Enum.valueOf(FoldSwitch.class, str);
        }

        public static FoldSwitch[] values() {
            return (FoldSwitch[]) $VALUES.clone();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36853);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f99567a = new AtomicBoolean(false);
        f99568b = DeviceType.PHONE;
        f99569c = FoldSwitch.NOT_INIT;
    }

    public PadUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static DeviceType a(Context context) {
        if (context == null) {
            context = BaseApplication.getContext();
        }
        if (context == null) {
            QLog.e("PadUtil", 1, "context is null");
            return f99568b;
        }
        AtomicBoolean atomicBoolean = f99567a;
        if (!atomicBoolean.get()) {
            synchronized (PadUtil.class) {
                if (!atomicBoolean.get()) {
                    d(context);
                    atomicBoolean.set(true);
                }
            }
        }
        return f99568b;
    }

    public static boolean b(Context context) {
        FoldSwitch foldSwitch;
        if (f99569c != FoldSwitch.NOT_INIT) {
            if (f99569c != FoldSwitch.OPEN) {
                return false;
            }
            return true;
        }
        if (context == null) {
            return false;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101487", true);
        if (isSwitchOn) {
            foldSwitch = FoldSwitch.OPEN;
        } else {
            foldSwitch = FoldSwitch.CLOSE;
        }
        f99569c = foldSwitch;
        return isSwitchOn;
    }

    public static boolean c(Context context) {
        boolean decodeBool = QMMKV.from(context, "common_mmkv_configurations").decodeBool("key_common_split_switch", true);
        QLog.d("PadUtil", 1, "isSplitSwitchOn = " + decodeBool);
        return decodeBool;
    }

    private static void d(Context context) {
        DeviceType b16;
        if (c(context)) {
            if (j.g()) {
                b16 = j.b();
            } else if (i.b()) {
                b16 = i.a();
            } else if (d.d()) {
                b16 = d.a(context);
            } else if (g.d()) {
                b16 = g.a();
            } else if (e.b()) {
                b16 = e.a();
            } else if (h.e()) {
                b16 = h.a(context);
            } else if (c.c()) {
                b16 = c.a(context);
            } else if (a.b()) {
                b16 = a.a(context);
            } else {
                b16 = b.b(context);
            }
            QLog.d("PadUtil", 1, "initDeviceType type = " + b16);
            if (b16 != null) {
                f99568b = b16;
            }
        }
    }

    public static boolean e(Context context) {
        if (j.g()) {
            return j.d();
        }
        if (h.e()) {
            return h.c();
        }
        return false;
    }
}

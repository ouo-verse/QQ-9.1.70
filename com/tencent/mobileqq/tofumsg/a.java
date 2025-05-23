package com.tencent.mobileqq.tofumsg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Map<Integer, Object> f293240a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75907);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f293240a = new HashMap();
            a();
        }
    }

    private static void a() {
        f293240a.put(14, new com.tencent.mobileqq.business.c());
        f293240a.put(15, new com.tencent.mobileqq.business.a());
    }

    public static boolean b() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_super_tofu_915", true);
    }

    public static boolean c() {
        if (!b()) {
            return false;
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_aio_cubes_v1");
        expEntity.reportExpExposure();
        if (!expEntity.isExperiment("exp_aio_cubes_v1_B") && !expEntity.isExperiment("exp_aio_cubes_v1_C")) {
            return false;
        }
        return true;
    }

    public static boolean d() {
        if (!b()) {
            return false;
        }
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_aio_cubes_v1");
        expEntity.reportExpExposure();
        return expEntity.isExperiment("exp_aio_cubes_v1_C");
    }
}

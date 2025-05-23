package com.tencent.rmonitor.launch;

import android.text.TextUtils;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes25.dex */
public class LandingPageTracer {

    /* renamed from: a, reason: collision with root package name */
    private boolean f365625a = false;

    /* renamed from: b, reason: collision with root package name */
    private final Set<String> f365626b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    private final Set<String> f365627c = new HashSet();

    /* loaded from: classes25.dex */
    public enum CheckResult {
        INVALID,
        HIT_LANDING_PAGE,
        WAIT_TO_HIT
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f365626b.add(str);
        }
        Logger.f365497g.w("RMonitor_launch_landingPage", "addActivityNameBeforeLanding, activityName: ", str);
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f365627c.add(str);
        }
        Logger.f365497g.w("RMonitor_launch_landingPage", "addLandingActivityName, activityName: ", str);
    }

    public CheckResult c(String str) {
        CheckResult checkResult = CheckResult.WAIT_TO_HIT;
        if (!this.f365627c.isEmpty() && !this.f365627c.contains(str)) {
            if (this.f365625a && !this.f365626b.contains(str)) {
                return CheckResult.INVALID;
            }
            return checkResult;
        }
        return CheckResult.HIT_LANDING_PAGE;
    }

    public void d(boolean z16) {
        this.f365625a = z16;
        Logger.f365497g.w("RMonitor_launch_landingPage", "enableCheckActivityBeforeLanding, enable: ", String.valueOf(z16));
    }
}

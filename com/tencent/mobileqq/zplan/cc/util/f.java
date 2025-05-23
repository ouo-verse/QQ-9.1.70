package com.tencent.mobileqq.zplan.cc.util;

import com.gyailib.library.SDKDeviceConfig;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007R$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/util/f;", "", "", "b", "", "c", "<set-?>", "Z", "a", "()Z", "initialized", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f332559a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean initialized;

    f() {
    }

    public final boolean a() {
        return initialized;
    }

    public final void b() {
        if (!initialized && c()) {
            try {
                if (q.f(new SDKDeviceConfig()) == 0) {
                    initialized = true;
                }
            } catch (Exception e16) {
                QLog.e("ZPlanCamera", 1, e16, new Object[0]);
            }
        }
    }

    public final boolean c() {
        if (!e.e(e.f332557a, 0, 1, null)) {
            return false;
        }
        try {
            ((IAEResUtil) QRoute.api(IAEResUtil.class)).loadLightSdk();
            return true;
        } catch (Exception e16) {
            QLog.e("ZPlanCamera", 1, e16, new Object[0]);
            return false;
        }
    }
}

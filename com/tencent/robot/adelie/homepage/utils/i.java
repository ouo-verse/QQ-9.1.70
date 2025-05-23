package com.tencent.robot.adelie.homepage.utils;

import com.tencent.mobileqq.qmmkv.QMMKV;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0004R\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/adelie/homepage/utils/i;", "", "", "c", "", "d", "f", "", "a", "b", "e", "Z", "guideToAio", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f366662a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean guideToAio;

    i() {
    }

    private final String c() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        return str + "key_robot_guide_expo";
    }

    public final boolean a() {
        return guideToAio;
    }

    public final boolean b() {
        return QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").getBoolean(c(), false);
    }

    public final void d() {
        guideToAio = true;
    }

    public final void e() {
        QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations").putBoolean(c(), true);
    }

    public final void f() {
        guideToAio = false;
    }
}

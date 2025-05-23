package com.tencent.robot.adelie.homepage.create;

import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/ae;", "", "", "a", "", "d", "", "c", "b", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class ae {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ae f366120a = new ae();

    ae() {
    }

    private final String a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = "";
        if (peekAppRuntime == null) {
            return "";
        }
        String currentUin = peekAppRuntime.getCurrentUin();
        if (currentUin != null) {
            str = currentUin;
        }
        return str + "_adelie_privacy_user_key";
    }

    @NotNull
    public final String b() {
        return "https://rule.tencent.com/rule/202404080001";
    }

    public final void c() {
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeBool(a(), false);
    }

    public final boolean d() {
        if (QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool(a(), true)) {
            if (QLog.isColorLevel()) {
                QLog.d("AdeliePrivacyConfig", 2, "showPrivacy return has already shown");
            }
            return true;
        }
        return false;
    }
}

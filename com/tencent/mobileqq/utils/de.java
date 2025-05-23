package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.lite.IZPlanFilamentSwitch;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u001c\u0010\b\u001a\u00020\u00028B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R$\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00028F@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/utils/de;", "", "", "a", "b", "Z", "d", "()Z", "isSupportZPlan", "<set-?>", "isShowZPlan", "c", "<init>", "()V", "drawer-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class de {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final de f307628a = new de();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isSupportZPlan = true;

    de() {
    }

    private final boolean d() {
        boolean h16 = QQSettingMeABTestHelper.e().h();
        boolean enableZPlanFilamentBase = ((IZPlanFilamentSwitch) QRoute.api(IZPlanFilamentSwitch.class)).enableZPlanFilamentBase();
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        if (h16 && enableZPlanFilamentBase && !studyModeSwitch) {
            return true;
        }
        return false;
    }

    public final boolean a() {
        return true;
    }

    public final boolean b() {
        return false;
    }

    public final boolean c() {
        boolean isDrawerEntranceSwitchOpen = ((IZPlanApi) QRoute.api(IZPlanApi.class)).isDrawerEntranceSwitchOpen();
        if (d() && isDrawerEntranceSwitchOpen) {
            return true;
        }
        return false;
    }
}

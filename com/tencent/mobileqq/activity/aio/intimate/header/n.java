package com.tencent.mobileqq.activity.aio.intimate.header;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0002H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/header/n;", "", "", "a", "b", "c", "d", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f179064a = new n();

    n() {
    }

    @JvmStatic
    public static final boolean a() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qq_intimate_ui_upgrade_8970_switch", false);
    }

    @JvmStatic
    public static final boolean b() {
        if (!a() || !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("intimate_game_partner_8970_switch", false)) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean c() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("intimate_relation_refactor_revert", false);
    }

    @JvmStatic
    public static final boolean d() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("intimate_refactor_revert", false);
    }
}

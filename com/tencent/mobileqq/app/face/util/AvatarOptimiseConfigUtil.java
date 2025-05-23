package com.tencent.mobileqq.app.face.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u0007R!\u0010\b\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\u0005R!\u0010\f\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u0012\u0004\b\u000b\u0010\u0007\u001a\u0004\b\n\u0010\u0005\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/app/face/util/AvatarOptimiseConfigUtil;", "", "", "b", "Lkotlin/Lazy;", "()Z", "getOldAvatarLoadOptimiseSwitch$annotations", "()V", "oldAvatarLoadOptimiseSwitch", "c", "a", "getOldAvatarGetPathOptimiseSwitch$annotations", "oldAvatarGetPathOptimiseSwitch", "<init>", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AvatarOptimiseConfigUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AvatarOptimiseConfigUtil f195602a = new AvatarOptimiseConfigUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy oldAvatarLoadOptimiseSwitch;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy oldAvatarGetPathOptimiseSwitch;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.app.face.util.AvatarOptimiseConfigUtil$oldAvatarLoadOptimiseSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("proavatar_old_avatar_load_optimise_switch", false);
                QLog.i("AvatarOptimiseConfigUtil", 1, "oldAvatarRefactorSwitch: " + isSwitchOn);
                return Boolean.valueOf(isSwitchOn);
            }
        });
        oldAvatarLoadOptimiseSwitch = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.app.face.util.AvatarOptimiseConfigUtil$oldAvatarGetPathOptimiseSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("proavatar_old_avatar_get_face_path_optimise_switch", false);
                QLog.i("AvatarOptimiseConfigUtil", 1, "getFacePathOptimiseSwitch: " + isSwitchOn);
                return Boolean.valueOf(isSwitchOn);
            }
        });
        oldAvatarGetPathOptimiseSwitch = lazy2;
    }

    AvatarOptimiseConfigUtil() {
    }

    public static final boolean a() {
        return ((Boolean) oldAvatarGetPathOptimiseSwitch.getValue()).booleanValue();
    }

    public static final boolean b() {
        return ((Boolean) oldAvatarLoadOptimiseSwitch.getValue()).booleanValue();
    }
}

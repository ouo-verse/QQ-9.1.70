package com.tencent.mobileqq.qqvideoedit;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u001b\u0010\u0004\u001a\u00020\u00008FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"", "a", "Lkotlin/Lazy;", "()Z", "isOptToggle", "qqvideoedit_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class VideoEditorResourceManagerExtKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Lazy f274806a;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.qqvideoedit.VideoEditorResourceManagerExtKt$isOptToggle$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                Boolean valueOf = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106121", false));
                QLog.d("VideoEditorResourceManagerExt", 1, "config[106121] is Open -> " + valueOf.booleanValue());
                return valueOf;
            }
        });
        f274806a = lazy;
    }

    public static final boolean a() {
        return ((Boolean) f274806a.getValue()).booleanValue();
    }
}

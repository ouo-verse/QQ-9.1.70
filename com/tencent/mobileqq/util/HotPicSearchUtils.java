package com.tencent.mobileqq.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/util/HotPicSearchUtils;", "", "", "b", "Lkotlin/Lazy;", "a", "()Z", "hotPicSearchUseLibra", "c", "plusHotPicUseLibra", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class HotPicSearchUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final HotPicSearchUtils f306386a = new HotPicSearchUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy hotPicSearchUseLibra;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy plusHotPicUseLibra;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.util.HotPicSearchUtils$hotPicSearchUseLibra$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("emoticon_hot_pic_search_use_libra_115851509", true);
                QLog.i("HotPicSearchUtils", 1, "emoticon_hot_pic_search_use_libra_115851509:" + isSwitchOn);
                return Boolean.valueOf(isSwitchOn);
            }
        });
        hotPicSearchUseLibra = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.util.HotPicSearchUtils$plusHotPicUseLibra$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("emoticon_plus_hot_pic_use_libra_115851509", true);
                QLog.i("HotPicSearchUtils", 1, "emoticon_plus_hot_pic_use_libra_115851509:" + isSwitchOn);
                return Boolean.valueOf(isSwitchOn);
            }
        });
        plusHotPicUseLibra = lazy2;
    }

    HotPicSearchUtils() {
    }

    public final boolean a() {
        return ((Boolean) hotPicSearchUseLibra.getValue()).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) plusHotPicUseLibra.getValue()).booleanValue();
    }
}

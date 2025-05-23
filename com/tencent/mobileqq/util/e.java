package com.tencent.mobileqq.util;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/util/e;", "", "a", "qqaddfriend-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static boolean f306752b = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102611", false);

    /* renamed from: c, reason: collision with root package name */
    private static boolean f306753c = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102688", false);

    /* renamed from: d, reason: collision with root package name */
    private static boolean f306754d = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102698", false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/util/e$a;", "", "", "a", "b", "addFriendNTSwitch", "Z", "delFriendNTSwitch", "newFriendSwitch", "<init>", "()V", "qqaddfriend-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.util.e$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean a() {
            return e.f306752b;
        }

        @JvmStatic
        public final boolean b() {
            return e.f306753c;
        }

        Companion() {
        }
    }

    @JvmStatic
    public static final boolean c() {
        return INSTANCE.a();
    }

    @JvmStatic
    public static final boolean d() {
        return INSTANCE.b();
    }
}

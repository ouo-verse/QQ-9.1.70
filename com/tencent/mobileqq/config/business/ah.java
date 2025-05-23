package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/config/business/ah;", "", "", "b", "Lcom/tencent/mobileqq/config/business/af;", "a", "Lcom/tencent/mobileqq/config/business/af;", "getConfig", "()Lcom/tencent/mobileqq/config/business/af;", "c", "(Lcom/tencent/mobileqq/config/business/af;)V", DownloadInfo.spKey_Config, "", "Z", "hasConfigInit", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class ah {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ah f202497a = new ah();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static af config = new af();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean hasConfigInit;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/config/business/ah$a", "Lpy2/a;", "Lcom/tencent/mobileqq/config/business/af;", DownloadInfo.spKey_Config, "", "b", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements py2.a<af> {
        a() {
        }

        @Override // py2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable af config) {
            if (config != null) {
                ah.f202497a.c(config);
            }
        }
    }

    ah() {
    }

    @NotNull
    public final af a() {
        if (!hasConfigInit) {
            b();
            hasConfigInit = true;
        }
        return config;
    }

    public final void b() {
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsync("101325", new a());
    }

    public final void c(@NotNull af afVar) {
        Intrinsics.checkNotNullParameter(afVar, "<set-?>");
        config = afVar;
    }
}

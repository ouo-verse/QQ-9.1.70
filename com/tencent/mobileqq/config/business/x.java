package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/config/business/x;", "", "", "b", "Lcom/tencent/mobileqq/config/business/w;", "a", "Lcom/tencent/mobileqq/config/business/w;", "getConfig", "()Lcom/tencent/mobileqq/config/business/w;", "c", "(Lcom/tencent/mobileqq/config/business/w;)V", DownloadInfo.spKey_Config, "", "Z", "hasConfigInit", "<init>", "()V", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final x f202849a = new x();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static w config = new w();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean hasConfigInit;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/config/business/x$a", "Lpy2/a;", "Lcom/tencent/mobileqq/config/business/w;", DownloadInfo.spKey_Config, "", "b", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a implements py2.a<w> {
        a() {
        }

        @Override // py2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable w config) {
            if (config != null) {
                x.f202849a.c(config);
            }
        }
    }

    x() {
    }

    @NotNull
    public final w a() {
        if (!hasConfigInit) {
            b();
            hasConfigInit = true;
        }
        return config;
    }

    public final void b() {
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsync("101009", new a());
    }

    public final void c(@NotNull w wVar) {
        Intrinsics.checkNotNullParameter(wVar, "<set-?>");
        config = wVar;
    }
}

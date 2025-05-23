package com.tencent.qqnt.aio.api.impl;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qqnt.aio.api.IAIOUniteConfigApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\t\u001a\u00020\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016J#\u0010\n\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/api/impl/AIOUniteConfigApiImpl;", "Lcom/tencent/qqnt/aio/api/IAIOUniteConfigApi;", "Lcom/tencent/freesia/IConfigData;", "T", "", VipFunCallConstants.KEY_GROUP, "Lcom/tencent/qqnt/aio/api/a;", "callback", "", "loadLargeConfigAsync", "loadConfig", "(Ljava/lang/String;)Lcom/tencent/freesia/IConfigData;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOUniteConfigApiImpl implements IAIOUniteConfigApi {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/api/impl/AIOUniteConfigApiImpl$a", "Lpy2/a;", DownloadInfo.spKey_Config, "", "b", "(Lcom/tencent/freesia/IConfigData;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a<T> implements py2.a<T> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.aio.api.a<T> f348894a;

        a(com.tencent.qqnt.aio.api.a<T> aVar) {
            this.f348894a = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)V */
        @Override // py2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable IConfigData config) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) config);
            } else {
                this.f348894a.a(config);
            }
        }
    }

    public AIOUniteConfigApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.IAIOUniteConfigApi
    @Nullable
    public <T extends IConfigData> T loadConfig(@NotNull String group) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) group);
        }
        Intrinsics.checkNotNullParameter(group, "group");
        return (T) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(group);
    }

    @Override // com.tencent.qqnt.aio.api.IAIOUniteConfigApi
    public <T extends IConfigData> void loadLargeConfigAsync(@NotNull String group, @NotNull com.tencent.qqnt.aio.api.a<T> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) group, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsync(group, new a(callback));
    }
}

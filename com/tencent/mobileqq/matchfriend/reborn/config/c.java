package com.tencent.mobileqq.matchfriend.reborn.config;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0006\u0010\u0005\u001a\u00020\u0004J)\u0010\f\u001a\u00020\u00022!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/config/c;", "", "", "g", "Lcom/tencent/mobileqq/matchfriend/reborn/config/b;", "c", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "cb", "d", "", "url", "e", "b", "Lcom/tencent/mobileqq/matchfriend/reborn/config/b;", "()Lcom/tencent/mobileqq/matchfriend/reborn/config/b;", "f", "(Lcom/tencent/mobileqq/matchfriend/reborn/config/b;)V", DownloadInfo.spKey_Config, "Z", "hasInitConfig", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f244198a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static b config = new b();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean hasInitConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/config/c$a", "Lpy2/a;", "Lcom/tencent/mobileqq/matchfriend/reborn/config/b;", DownloadInfo.spKey_Config, "", "b", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a implements py2.a<b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f244201a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Boolean, Unit> function1) {
            this.f244201a = function1;
        }

        @Override // py2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(b config) {
            if (config != null) {
                Function1<Boolean, Unit> function1 = this.f244201a;
                if (!config.i()) {
                    QLog.i("QQStrangerConfigMgr", 1, "[initConfigFirst]onLoad, data invalid.");
                    function1.invoke(Boolean.FALSE);
                    return;
                } else {
                    c.f244198a.f(config);
                    c.hasInitConfig = true;
                    function1.invoke(Boolean.TRUE);
                    return;
                }
            }
            QLog.i("QQStrangerConfigMgr", 1, "[initConfigFirst]onLoad, data is null.");
            this.f244201a.invoke(Boolean.FALSE);
        }
    }

    c() {
    }

    @JvmStatic
    public static final void g() {
        b.INSTANCE.d(config);
    }

    public final b b() {
        return config;
    }

    public final b c() {
        return config;
    }

    public final void d(Function1<? super Boolean, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        if (hasInitConfig) {
            cb5.invoke(Boolean.TRUE);
        } else {
            ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsync("qq_stranger_config", new a(cb5));
        }
    }

    public final boolean e(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return Intrinsics.areEqual(config.getUserZplanAvatarUrl(), url);
    }

    public final void f(b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        config = bVar;
    }
}

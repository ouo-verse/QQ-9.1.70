package com.tencent.mobileqq.matchfriend.reborn.mark.config;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\t\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rJ\u001e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\rJ\u001e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\rR\"\u0010\u0019\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/mark/config/b;", "", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "cb", "f", "", "resBaseUrl", "markId", "", "count", "d", "level", "b", "e", "Lcom/tencent/mobileqq/matchfriend/reborn/mark/config/a;", "Lcom/tencent/mobileqq/matchfriend/reborn/mark/config/a;", "c", "()Lcom/tencent/mobileqq/matchfriend/reborn/mark/config/a;", "g", "(Lcom/tencent/mobileqq/matchfriend/reborn/mark/config/a;)V", DownloadInfo.spKey_Config, "Z", "hasInitConfig", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f245190a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static com.tencent.mobileqq.matchfriend.reborn.mark.config.a config = new com.tencent.mobileqq.matchfriend.reborn.mark.config.a();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean hasInitConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/mark/config/b$a", "Lpy2/a;", "Lcom/tencent/mobileqq/matchfriend/reborn/mark/config/a;", DownloadInfo.spKey_Config, "", "b", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a implements py2.a<com.tencent.mobileqq.matchfriend.reborn.mark.config.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f245193a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Boolean, Unit> function1) {
            this.f245193a = function1;
        }

        @Override // py2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.tencent.mobileqq.matchfriend.reborn.mark.config.a config) {
            if (config != null) {
                Function1<Boolean, Unit> function1 = this.f245193a;
                if (!config.c()) {
                    QLog.i("QQStrangerMarkConfigMgr", 1, "[initConfig]onLoad, data invalid.");
                    function1.invoke(Boolean.FALSE);
                    return;
                } else {
                    b.f245190a.g(config);
                    b.hasInitConfig = true;
                    function1.invoke(Boolean.TRUE);
                    return;
                }
            }
            QLog.i("QQStrangerMarkConfigMgr", 1, "[initConfig]onLoad, data is null.");
            this.f245193a.invoke(Boolean.FALSE);
        }
    }

    b() {
    }

    public final String b(String resBaseUrl, String markId, long level) {
        Intrinsics.checkNotNullParameter(resBaseUrl, "resBaseUrl");
        Intrinsics.checkNotNullParameter(markId, "markId");
        return resBaseUrl + "/icon/" + markId + "_" + level + "_big.png";
    }

    public final com.tencent.mobileqq.matchfriend.reborn.mark.config.a c() {
        return config;
    }

    public final String d(String resBaseUrl, String markId, long count) {
        Intrinsics.checkNotNullParameter(resBaseUrl, "resBaseUrl");
        Intrinsics.checkNotNullParameter(markId, "markId");
        return resBaseUrl + "/pag/stranger_mark_" + markId + "_state_" + count + ".pag";
    }

    public final String e(String resBaseUrl, String markId, long level) {
        Intrinsics.checkNotNullParameter(resBaseUrl, "resBaseUrl");
        Intrinsics.checkNotNullParameter(markId, "markId");
        return resBaseUrl + "/icon/" + markId + "_" + level + "_small.png";
    }

    public final void f(Function1<? super Boolean, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        if (hasInitConfig) {
            cb5.invoke(Boolean.TRUE);
        } else {
            ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsync("stranger_mark_resource", new a(cb5));
        }
    }

    public final void g(com.tencent.mobileqq.matchfriend.reborn.mark.config.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        config = aVar;
    }
}

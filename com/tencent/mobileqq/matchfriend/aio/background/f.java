package com.tencent.mobileqq.matchfriend.aio.background;

import com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.b;
import com.tencent.qqnt.http.api.m;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/f;", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$e;", "", "srcPath", "Ljava/io/File;", "c", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$f;", "state", "", "a", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$c;", "callback", "", "b", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class f implements BaseMutualMarkAIOBackgroundProxy.e {

    /* renamed from: b, reason: collision with root package name */
    private static final String f243827b = com.tencent.mobileqq.matchfriend.aio.utils.a.f243984a.c() + "/temp/";

    private final File c(String srcPath) {
        File file = new File(f243827b, System.currentTimeMillis() + "_temp");
        if (QLog.isColorLevel()) {
            QLog.i("PagResourceLoader", 2, "getTempFile srcPath: " + srcPath + ", tempPath: " + file.getAbsolutePath());
        }
        return file;
    }

    @Override // com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy.e
    public boolean a(BaseMutualMarkAIOBackgroundProxy.f state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state.b().length() == 0) {
            e eVar = e.f243823a;
            boolean a16 = eVar.a(state.d());
            String absolutePath = eVar.d(state.d()).getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "PagFilePathCache.getSave\u2026h(state.url).absolutePath");
            state.e(absolutePath);
            return a16;
        }
        File file = new File(state.b());
        return file.isFile() && file.exists();
    }

    @Override // com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy.e
    public void b(BaseMutualMarkAIOBackgroundProxy.f state, BaseMutualMarkAIOBackgroundProxy.c callback) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (state.b().length() == 0) {
            String absolutePath = e.f243823a.d(state.d()).getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "PagFilePathCache.getSave\u2026h(state.url).absolutePath");
            state.e(absolutePath);
        }
        if (a(state)) {
            callback.b(state, state.b());
            return;
        }
        File c16 = c(state.b());
        m syncExecute = ((IHttpService) QRoute.api(IHttpService.class)).syncExecute(new b.a("relationship_pag_downloader", state.d(), c16).S(BaseMutualMarkAIOBackgroundProxy.f.class, state).c());
        if (syncExecute.e()) {
            com.tencent.qqnt.aio.utils.m.k(c16.getAbsolutePath(), state.b(), QLog.isColorLevel());
            callback.b(state, state.b());
            return;
        }
        com.tencent.qqnt.aio.utils.m.f352305a.d(c16.getAbsolutePath());
        String b16 = syncExecute.b();
        if (b16 == null) {
            b16 = "unknown err";
        }
        callback.a(state, b16);
    }
}

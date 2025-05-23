package com.tencent.localedit.fakenative.localserver;

import android.content.Context;
import com.tencent.localedit.LocalEditSDK;
import com.tencent.localedit.fakenative.localserver.b;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import j11.e;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/localedit/fakenative/localserver/c;", "Lcom/tencent/localedit/fakenative/localserver/b;", "Landroid/content/Context;", "context", "", "host", "", "o", "", DomainData.DOMAIN_NAME, "Lcom/tencent/localedit/fakenative/localserver/b$a;", "serverListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "d", "Lj11/e;", "Lj11/e;", "server", "<init>", "()V", "e", "a", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class c extends com.tencent.localedit.fakenative.localserver.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j11.e server;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u000e\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/localedit/fakenative/localserver/c$b", "Lj11/e$b;", "", "onStarted", "onStopped", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "onException", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes7.dex */
    public static final class b implements e.b {
        b() {
        }

        @Override // j11.e.b
        public void onException(@Nullable Exception e16) {
            String obj;
            com.tencent.localedit.fakenative.localserver.b localServer = LocalEditSDK.INSTANCE.getLocalServer();
            if (e16 == null) {
                obj = null;
            } else {
                obj = e16.toString();
            }
            localServer.g(obj);
        }

        @Override // j11.e.b
        public void onStarted() {
            LocalEditSDK.INSTANCE.getLocalServer().h(c.this.getLocalhost() + ':' + c.this.getPort());
        }

        @Override // j11.e.b
        public void onStopped() {
            LocalEditSDK.INSTANCE.getLocalServer().i();
        }
    }

    private final int n() {
        int i3 = 1024;
        while (true) {
            int i16 = i3 + 1;
            try {
                Result.Companion companion = Result.INSTANCE;
                new ServerSocket(i3).close();
                return i3;
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(Result.m476constructorimpl(ResultKt.createFailure(th5)));
                if (m479exceptionOrNullimpl != null) {
                    x11.b.f446855a.b("LocalServerManagerImpl", "port:" + i3 + " is not available, error:" + m479exceptionOrNullimpl);
                }
                if (i16 > 49151) {
                    return -1;
                }
                i3 = i16;
            }
        }
    }

    private final void o(Context context, String host) {
        Object m476constructorimpl;
        k(host);
        l(n());
        try {
            Result.Companion companion = Result.INSTANCE;
            e.a a16 = j11.a.a(context);
            a16.b(InetAddress.getByName(getLocalhost()));
            a16.a(getPort());
            a16.c(10, TimeUnit.SECONDS);
            a16.d(new b());
            m476constructorimpl = Result.m476constructorimpl(a16.build());
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            x11.b.f446855a.b("LocalServerManagerImpl", Intrinsics.stringPlus("initServer error: ", m479exceptionOrNullimpl));
            Unit unit = Unit.INSTANCE;
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        this.server = (j11.e) m476constructorimpl;
    }

    @Override // com.tencent.localedit.fakenative.localserver.b
    public boolean d() {
        j11.e eVar = this.server;
        if (eVar == null || !eVar.isRunning()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.localedit.fakenative.localserver.b
    public void m(@NotNull Context context, @NotNull String host, @Nullable b.a serverListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(host, "host");
        o(context, host);
        j11.e eVar = this.server;
        if (eVar != null) {
            if (!(!eVar.isRunning())) {
                eVar = null;
            }
            if (eVar != null) {
                eVar.a();
            }
        }
        j(serverListener);
    }
}

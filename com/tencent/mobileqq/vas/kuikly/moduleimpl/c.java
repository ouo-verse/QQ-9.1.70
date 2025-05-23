package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasTempConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.b;
import java.io.File;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J=\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005j\u0004\u0018\u0001`\nH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/c;", "", "", "url", "c", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "a", "b", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/kuikly/moduleimpl/c$a", "Lcom/tencent/qqnt/http/api/l;", "Lcom/tencent/qqnt/http/api/b;", "task", "Lcom/tencent/qqnt/http/api/m;", "result", "", "onSuccess", "onFailed", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements com.tencent.qqnt.http.api.l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f309827a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f309828b;

        a(Function1<Object, Unit> function1, String str) {
            this.f309827a = function1;
            this.f309828b = str;
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onFailed(@NotNull com.tencent.qqnt.http.api.b task, @NotNull com.tencent.qqnt.http.api.m result) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(result, "result");
            Function1<Object, Unit> function1 = this.f309827a;
            if (function1 != null) {
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("result", "failed"), TuplesKt.to("msg", String.valueOf(result.b())));
                function1.invoke(mapOf);
            }
        }

        @Override // com.tencent.qqnt.http.api.l
        public void onSuccess(@NotNull com.tencent.qqnt.http.api.b task, @NotNull com.tencent.qqnt.http.api.m result) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(result, "result");
            Function1<Object, Unit> function1 = this.f309827a;
            if (function1 != null) {
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("result", "success"), TuplesKt.to("path", this.f309828b));
                function1.invoke(mapOf);
            }
        }
    }

    private final String c(String url) {
        return VasTempConstant.External.DYNAMIC_DRAWABLE_DIR + new URL(url).getHost() + "-" + com.tencent.open.base.g.d(url);
    }

    public void a(@NotNull String url, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        String c16 = c(url);
        QLog.i("DownloaderImpl", 1, "download " + url + " to " + c16);
        ((IHttpService) QRoute.api(IHttpService.class)).asyncExecute(new b.a("vas_kuikly_download", url, new File(c16)).T(new a(callback, c16)).c());
    }

    @NotNull
    public String b(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        File file = new File(c(url));
        if (file.exists()) {
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "{\n            f.absolutePath\n        }");
            return absolutePath;
        }
        return "";
    }
}

package com.tencent.mobileqq.vas.social;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasSquareApi;
import com.tencent.mobileqq.vas.api.IVasZplanApi;
import com.tencent.state.square.SimpleHttpDownloader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/social/b;", "Lcom/tencent/state/square/SimpleHttpDownloader;", "Lkotlin/Function0;", "", "task", "executeTask", "", "getIp", "", "needIpConnect", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b extends SimpleHttpDownloader {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    @Override // com.tencent.state.square.SimpleHttpDownloader
    public void executeTask(final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.mobileqq.vas.social.a
            @Override // java.lang.Runnable
            public final void run() {
                b.b(Function0.this);
            }
        });
    }

    @Override // com.tencent.state.square.SimpleHttpDownloader, com.tencent.state.square.IHttpDownloader
    public String getIp() {
        return ((IVasSquareApi) QRoute.api(IVasSquareApi.class)).getDnsIp();
    }

    @Override // com.tencent.state.square.SimpleHttpDownloader, com.tencent.state.square.IHttpDownloader
    public boolean needIpConnect() {
        return ((IVasZplanApi) QRoute.api(IVasZplanApi.class)).getConfig().d().e();
    }
}

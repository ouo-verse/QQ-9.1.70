package com.tencent.mobileqq.pendant.downloader;

import com.tencent.cachedrawable.dynamicdrawable.business.download.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ2\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0005H\u0016J:\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0005H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/pendant/downloader/a;", "Lcom/tencent/cachedrawable/dynamicdrawable/business/download/c;", "", "url", "filePath", "Lkotlin/Function2;", "", "", "loadCallback", "a", "", "bid", "scid", "b", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f257503a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/pendant/downloader/a$a", "Lcom/tencent/mobileqq/vip/f;", "Lcom/tencent/mobileqq/vip/g;", "task", "", "onDone", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.pendant.downloader.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8197a extends f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, String, Unit> f257504a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f257505b;

        /* JADX WARN: Multi-variable type inference failed */
        C8197a(Function2<? super Integer, ? super String, Unit> function2, String str) {
            this.f257504a = function2;
            this.f257505b = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function2, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(@NotNull g task) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) task);
                return;
            }
            Intrinsics.checkNotNullParameter(task, "task");
            int i3 = task.f313006d;
            if (i3 == 0) {
                this.f257504a.invoke(Integer.valueOf(i3), this.f257505b);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24698);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f257503a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.business.download.c
    public void a(@NotNull String url, @NotNull String filePath, @NotNull Function2<? super Integer, ? super String, Unit> loadCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, url, filePath, loadCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(loadCallback, "loadCallback");
        g gVar = new g(url, new File(filePath));
        gVar.u(new C8197a(loadCallback, filePath));
        gVar.b("Accept", "image/avif, image/jpeg, image/png, */*");
        ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).download(gVar, MobileQQ.sMobileQQ.peekAppRuntime());
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.business.download.c
    public void b(long bid, @NotNull String scid, @NotNull String filePath, @NotNull Function2<? super Integer, ? super String, Unit> loadCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(bid), scid, filePath, loadCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(scid, "scid");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(loadCallback, "loadCallback");
    }
}

package com.tencent.cachedrawable.dynamicdrawable.business.download;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0007J2\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u0007H\u0016J:\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u0007H\u0016R$\u0010\u0014\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/business/download/a;", "Lcom/tencent/cachedrawable/dynamicdrawable/business/download/c;", "", "c", "", "url", "filePath", "Lkotlin/Function2;", "", "loadCallback", "a", "", "bid", "scid", "b", "Lcom/tencent/cachedrawable/dynamicdrawable/business/download/c;", "getSInstance", "()Lcom/tencent/cachedrawable/dynamicdrawable/business/download/c;", "setSInstance", "(Lcom/tencent/cachedrawable/dynamicdrawable/business/download/c;)V", "sInstance", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class a implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f98858a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/DynamicDrawable/Inject_DynamicDownLoader.yml", version = 1)
    @Nullable
    private static c sInstance;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList f98860c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7873);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f98860c = arrayList;
        arrayList.add(u03.c.class);
        a aVar = new a();
        f98858a = aVar;
        aVar.c();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, url, filePath, loadCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(loadCallback, "loadCallback");
        c cVar = sInstance;
        if (cVar != null) {
            cVar.a(url, filePath, loadCallback);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.business.download.c
    public void b(long bid, @NotNull String scid, @NotNull String filePath, @NotNull Function2<? super Integer, ? super String, Unit> loadCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(bid), scid, filePath, loadCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(scid, "scid");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(loadCallback, "loadCallback");
        c cVar = sInstance;
        if (cVar != null) {
            cVar.b(bid, scid, filePath, loadCallback);
        }
    }

    @QAutoInitMethod
    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            sInstance = (c) com.tencent.mobileqq.qroute.utils.b.a(f98860c);
        }
    }
}

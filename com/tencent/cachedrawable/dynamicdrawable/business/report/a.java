package com.tencent.cachedrawable.dynamicdrawable.business.report;

import com.tencent.cachedrawable.dynamicdrawable.report.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u03.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/business/report/a;", "Lcom/tencent/cachedrawable/dynamicdrawable/business/report/b;", "", "b", "Lcom/tencent/cachedrawable/dynamicdrawable/report/a$a;", "data", "a", "Lcom/tencent/cachedrawable/dynamicdrawable/business/report/b;", "getSInstance", "()Lcom/tencent/cachedrawable/dynamicdrawable/business/report/b;", "setSInstance", "(Lcom/tencent/cachedrawable/dynamicdrawable/business/report/b;)V", "sInstance", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f98865a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInject(configPath = "AutoInjectYml/Business/DynamicDrawable/Inject_DynamicReporter.yml", version = 1)
    @Nullable
    private static b sInstance;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList f98867c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8069);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f98867c = arrayList;
        arrayList.add(e.class);
        a aVar = new a();
        f98865a = aVar;
        aVar.b();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.business.report.b
    public void a(@NotNull a.C1007a data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        b bVar = sInstance;
        if (bVar != null) {
            bVar.a(data);
        }
    }

    @QAutoInitMethod
    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            sInstance = (b) com.tencent.mobileqq.qroute.utils.b.a(f98867c);
        }
    }
}

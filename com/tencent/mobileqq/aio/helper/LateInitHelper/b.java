package com.tencent.mobileqq.aio.helper.LateInitHelper;

import com.tencent.aio.main.businesshelper.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/LateInitHelper/b;", "Lcom/tencent/aio/main/businesshelper/e;", "", "a", h.F, "g", "b", "Lcom/tencent/aio/main/businesshelper/b;", "d", "Lcom/tencent/aio/main/businesshelper/b;", "c", "()Lcom/tencent/aio/main/businesshelper/b;", "helperParam", "Lcom/tencent/mvi/base/route/MsgIntent;", "e", "Lcom/tencent/mvi/base/route/MsgIntent;", "()Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "<init>", "(Lcom/tencent/aio/main/businesshelper/b;Lcom/tencent/mvi/base/route/MsgIntent;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public abstract class b implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.main.businesshelper.b helperParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final MsgIntent msgIntent;

    public b(@NotNull com.tencent.aio.main.businesshelper.b helperParam, @Nullable MsgIntent msgIntent) {
        Intrinsics.checkNotNullParameter(helperParam, "helperParam");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) helperParam, (Object) msgIntent);
        } else {
            this.helperParam = helperParam;
            this.msgIntent = msgIntent;
        }
    }

    public abstract void a();

    public abstract void b();

    @NotNull
    public final com.tencent.aio.main.businesshelper.b c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.main.businesshelper.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.helperParam;
    }

    @Nullable
    public final MsgIntent e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MsgIntent) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.msgIntent;
    }

    public abstract void g();

    public abstract void h();

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
        } else {
            e.a.a(this, bVar);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            e.a.b(this);
        }
    }
}

package com.tencent.mobileqq.sharepanel.ioc;

import android.view.View;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.ioc.callback.OnPromiseResolved;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ.\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006J.\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006J.\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/ioc/f;", "", "Landroid/view/View;", "itemView", "", "elemId", "", "elemParams", "", "j", "g", "d", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f287347a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37408);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f287347a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(f fVar, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        fVar.d(view, str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String elemId, Map elemParams, b bVar) {
        Intrinsics.checkNotNullParameter(elemId, "$elemId");
        Intrinsics.checkNotNullParameter(elemParams, "$elemParams");
        bVar.X8(elemId, elemParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void h(f fVar, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        fVar.g(view, str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String elemId, Map elemParams, b bVar) {
        Intrinsics.checkNotNullParameter(elemId, "$elemId");
        Intrinsics.checkNotNullParameter(elemParams, "$elemParams");
        bVar.K1(elemId, elemParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void k(f fVar, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        fVar.j(view, str, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(String elemId, Map elemParams, b bVar) {
        Intrinsics.checkNotNullParameter(elemId, "$elemId");
        Intrinsics.checkNotNullParameter(elemParams, "$elemParams");
        bVar.j2(elemId, elemParams);
    }

    public final void d(@Nullable View itemView, @NotNull final String elemId, @NotNull final Map<String, ? extends Object> elemParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, itemView, elemId, elemParams);
            return;
        }
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        Intrinsics.checkNotNullParameter(elemParams, "elemParams");
        RFWIocAbilityProvider.g().getIoc(b.class).originView(itemView).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.sharepanel.ioc.e
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                f.f(elemId, elemParams, (b) obj);
            }
        }).run();
    }

    public final void g(@Nullable View itemView, @NotNull final String elemId, @NotNull final Map<String, ? extends Object> elemParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, itemView, elemId, elemParams);
            return;
        }
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        Intrinsics.checkNotNullParameter(elemParams, "elemParams");
        RFWIocAbilityProvider.g().getIoc(b.class).originView(itemView).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.sharepanel.ioc.d
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                f.i(elemId, elemParams, (b) obj);
            }
        }).run();
    }

    public final void j(@Nullable View itemView, @NotNull final String elemId, @NotNull final Map<String, ? extends Object> elemParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, itemView, elemId, elemParams);
            return;
        }
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        Intrinsics.checkNotNullParameter(elemParams, "elemParams");
        RFWIocAbilityProvider.g().getIoc(b.class).originView(itemView).done(new OnPromiseResolved() { // from class: com.tencent.mobileqq.sharepanel.ioc.c
            @Override // com.tencent.biz.richframework.ioc.callback.OnPromiseResolved
            public final void onDone(Object obj) {
                f.l(elemId, elemParams, (b) obj);
            }
        }).run();
    }
}

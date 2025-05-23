package com.tencent.aio.widget.textView.api;

import android.os.Build;
import android.text.StaticLayout;
import com.tencent.aio.widget.textView.creator.LayoutCreatorManager;
import com.tencent.aio.widget.textView.exception.SimpleException;
import com.tencent.aio.widget.textView.view.AioTextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/aio/widget/textView/api/a;", "", "b", "a", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static boolean f69995a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/aio/widget/textView/api/a$a;", "", "Lcom/tencent/aio/widget/textView/api/d;", "dispatcher", "Lcom/tencent/aio/widget/textView/api/e;", "creatorOwner", "", "c", "Lcom/tencent/aio/widget/textView/param/b;", "param", "Landroid/text/StaticLayout;", "staticLayout", "a", "", "init", "Z", "b", "()Z", "e", "(Z)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.widget.textView.api.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this);
        }

        public static /* synthetic */ void d(Companion companion, d dVar, e eVar, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                eVar = new b();
            }
            companion.c(dVar, eVar);
        }

        public final void a(@NotNull com.tencent.aio.widget.textView.param.b param, @NotNull StaticLayout staticLayout) {
            StaticLayout staticLayout2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) param, (Object) staticLayout);
                return;
            }
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(staticLayout, "staticLayout");
            LayoutCreatorManager layoutCreatorManager = LayoutCreatorManager.f70013k;
            com.tencent.aio.widget.textView.cache.a f16 = layoutCreatorManager.f(param);
            if (f16 != null) {
                staticLayout2 = f16.b();
            } else {
                staticLayout2 = null;
            }
            if (!Intrinsics.areEqual(staticLayout2, staticLayout)) {
                layoutCreatorManager.n(param, staticLayout);
            }
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return a.f69995a;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }

        public final void c(@NotNull d dispatcher, @NotNull e creatorOwner) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) dispatcher, (Object) creatorOwner);
                return;
            }
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            Intrinsics.checkNotNullParameter(creatorOwner, "creatorOwner");
            if (b()) {
                com.tencent.aio.widget.textView.log.a.f70035a.a("AIOTextViewFacade", "\u5df2\u7ecf\u521d\u59cb\u5316\u4e86");
                return;
            }
            e(true);
            LayoutCreatorManager t16 = LayoutCreatorManager.f70013k.t(dispatcher);
            AioTextView.INSTANCE.a(t16);
            boolean z16 = false;
            for (com.tencent.aio.widget.textView.creator.a aVar : creatorOwner.a()) {
                if (aVar.e(Build.VERSION.SDK_INT)) {
                    aVar.f(t16);
                    Unit unit = Unit.INSTANCE;
                    t16.w(aVar);
                    z16 = true;
                }
            }
            if (z16) {
                return;
            }
            throw new SimpleException("please suit SdK " + Build.VERSION.SDK_INT + " staticLayout");
        }

        public final void e(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a.f69995a = z16;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7680);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }
}

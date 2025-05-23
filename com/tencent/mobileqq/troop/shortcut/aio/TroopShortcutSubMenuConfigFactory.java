package com.tencent.mobileqq.troop.shortcut.aio;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.shortcut.data.TroopShortcutMenu;
import com.tencent.mobileqq.troop.utils.ay;
import com.tencent.mobileqq.widget.listitem.c;
import com.tencent.mobileqq.widget.listitem.x;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u0012\u0006\u0010 \u001a\u00020\u001e\u0012\u0006\u0010#\u001a\u00020!\u00a2\u0006\u0004\b$\u0010%J\"\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bJ\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\bJ\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bJ\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\bJ\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010J\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00120\u0010J\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00160\u0010J\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00160\u0010J\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00190\bR\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001fR\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/aio/TroopShortcutSubMenuConfigFactory;", "", "", "tag", "Lkotlin/Function2;", "Landroid/widget/ImageView;", "", "b", "Lcom/tencent/mobileqq/troop/shortcut/ui/b;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "e", "Lcom/tencent/mobileqq/widget/listitem/x$b$c;", "d", "f", "c", "Lcom/tencent/mobileqq/troop/shortcut/ui/a;", "Lcom/tencent/mobileqq/widget/listitem/c$a$g;", "Lcom/tencent/mobileqq/widget/listitem/c$b$a;", "i", "Lcom/tencent/mobileqq/widget/listitem/c$a$d;", "g", "Lcom/tencent/mobileqq/widget/listitem/c$b$c;", "j", tl.h.F, "Lcom/tencent/mobileqq/widget/listitem/x$c$c;", "a", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutMenu;", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutMenu;", "menu", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "clickListener", "Lcom/tencent/mobileqq/widget/listitem/g;", "Lcom/tencent/mobileqq/widget/listitem/g;", "bindViewListener", "<init>", "(Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutMenu;Landroid/view/View$OnClickListener;Lcom/tencent/mobileqq/widget/listitem/g;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopShortcutSubMenuConfigFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopShortcutMenu menu;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener clickListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.widget.listitem.g bindViewListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/aio/TroopShortcutSubMenuConfigFactory$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.shortcut.aio.TroopShortcutSubMenuConfigFactory$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55083);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopShortcutSubMenuConfigFactory(@NotNull TroopShortcutMenu menu, @NotNull View.OnClickListener clickListener, @NotNull com.tencent.mobileqq.widget.listitem.g bindViewListener) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        Intrinsics.checkNotNullParameter(bindViewListener, "bindViewListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, menu, clickListener, bindViewListener);
            return;
        }
        this.menu = menu;
        this.clickListener = clickListener;
        this.bindViewListener = bindViewListener;
    }

    private final Function2<ImageView, String, Unit> b(final String tag) {
        return new Function2<ImageView, String, Unit>(tag) { // from class: com.tencent.mobileqq.troop.shortcut.aio.TroopShortcutSubMenuConfigFactory$createLoadImageFunction$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $tag;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$tag = tag;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) tag);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView, String str) {
                invoke2(imageView, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ImageView imageView, @NotNull String url) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) imageView, (Object) url);
                    return;
                }
                Intrinsics.checkNotNullParameter(imageView, "imageView");
                Intrinsics.checkNotNullParameter(url, "url");
                if (url.length() == 0) {
                    com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("TroopShortcutSubMenuConfigFactory", this.$tag + " img url is empty");
                    imageView.setImageDrawable(null);
                    imageView.setVisibility(8);
                    return;
                }
                ay.f302095a.a(url, imageView);
            }
        };
    }

    @NotNull
    public final com.tencent.mobileqq.troop.shortcut.ui.b<x.b.d, x.c.C8997c> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.mobileqq.troop.shortcut.ui.b) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        com.tencent.mobileqq.troop.shortcut.ui.b<x.b.d, x.c.C8997c> bVar = new com.tencent.mobileqq.troop.shortcut.ui.b<>(new x.b.d(this.menu.h()), x.c.C8997c.f317072b);
        bVar.x(this.clickListener);
        bVar.w(this.bindViewListener);
        return bVar;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.shortcut.ui.b<x.b.c, x.c.g> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.troop.shortcut.ui.b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        com.tencent.mobileqq.troop.shortcut.ui.b<x.b.c, x.c.g> bVar = new com.tencent.mobileqq.troop.shortcut.ui.b<>(new x.b.c(this.menu.h(), this.menu.c()), new x.c.g("", false, false, 6, null));
        bVar.T(b("[SINGLE_LINE_ICON_ICON]"));
        bVar.x(this.clickListener);
        bVar.w(this.bindViewListener);
        return bVar;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.shortcut.ui.b<x.b.c, x.c.g> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.troop.shortcut.ui.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        com.tencent.mobileqq.troop.shortcut.ui.b<x.b.c, x.c.g> bVar = new com.tencent.mobileqq.troop.shortcut.ui.b<>(new x.b.c(this.menu.h(), this.menu.c()), new x.c.g(this.menu.e(), false, false, 4, null));
        bVar.T(b("[SINGLE_LINE_ICON_TEXT]"));
        bVar.x(this.clickListener);
        bVar.w(this.bindViewListener);
        return bVar;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.shortcut.ui.b<x.b.d, x.c.g> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.shortcut.ui.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.mobileqq.troop.shortcut.ui.b<x.b.d, x.c.g> bVar = new com.tencent.mobileqq.troop.shortcut.ui.b<>(new x.b.d(this.menu.h()), new x.c.g(this.menu.e(), false, false, 4, null));
        bVar.x(this.clickListener);
        bVar.w(this.bindViewListener);
        return bVar;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.shortcut.ui.b<x.b.d, x.c.g> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.troop.shortcut.ui.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        com.tencent.mobileqq.troop.shortcut.ui.b<x.b.d, x.c.g> bVar = new com.tencent.mobileqq.troop.shortcut.ui.b<>(new x.b.d(this.menu.h()), new x.c.g("", false, false, 6, null));
        bVar.x(this.clickListener);
        bVar.w(this.bindViewListener);
        return bVar;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.shortcut.ui.a<c.a.d, c.b.a> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.troop.shortcut.ui.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        com.tencent.mobileqq.troop.shortcut.ui.a<c.a.d, c.b.a> aVar = new com.tencent.mobileqq.troop.shortcut.ui.a<>(new c.a.d(this.menu.h(), this.menu.b(), this.menu.c()), new c.b.a(this.menu.g(), this.clickListener, false, null, 12, null));
        aVar.R(b("[TWO_LINE_ICON_BTN]"));
        aVar.w(this.bindViewListener);
        aVar.x(this.clickListener);
        return aVar;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.shortcut.ui.a<c.a.d, c.b.C8995c> h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.troop.shortcut.ui.a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        com.tencent.mobileqq.troop.shortcut.ui.a<c.a.d, c.b.C8995c> aVar = new com.tencent.mobileqq.troop.shortcut.ui.a<>(new c.a.d(this.menu.h(), this.menu.b(), this.menu.c()), new c.b.C8995c("", false, false, 6, null));
        aVar.R(b("[TWO_LINE_ICON_ICON]"));
        aVar.x(this.clickListener);
        aVar.w(this.bindViewListener);
        return aVar;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.shortcut.ui.a<c.a.g, c.b.a> i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.troop.shortcut.ui.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        com.tencent.mobileqq.troop.shortcut.ui.a<c.a.g, c.b.a> aVar = new com.tencent.mobileqq.troop.shortcut.ui.a<>(new c.a.g(this.menu.h(), this.menu.b()), new c.b.a(this.menu.g(), this.clickListener, false, null, 12, null));
        aVar.x(this.clickListener);
        aVar.w(this.bindViewListener);
        return aVar;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.shortcut.ui.a<c.a.g, c.b.C8995c> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.mobileqq.troop.shortcut.ui.a) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        com.tencent.mobileqq.troop.shortcut.ui.a<c.a.g, c.b.C8995c> aVar = new com.tencent.mobileqq.troop.shortcut.ui.a<>(new c.a.g(this.menu.h(), this.menu.b()), new c.b.C8995c("", false, false, 6, null));
        aVar.x(this.clickListener);
        aVar.w(this.bindViewListener);
        return aVar;
    }
}

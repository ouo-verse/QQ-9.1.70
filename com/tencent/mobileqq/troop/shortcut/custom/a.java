package com.tencent.mobileqq.troop.shortcut.custom;

import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.troop.shortcut.aio.TroopShortcutVB;
import et2.b;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import ts2.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0006\u0010\u000e\u001a\u00020\u0002R\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0014R0\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0016j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0006`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R.\u0010\"\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0013\u0010%\u001a\u0004\u0018\u00010#8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/custom/a;", "Let2/b;", "", "f", "", "d", "Let2/a;", "customShortcutBar", "", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "a", "e", "b", "close", "g", "Lcom/tencent/mobileqq/troop/shortcut/aio/TroopShortcutVB;", "Lcom/tencent/mobileqq/troop/shortcut/aio/TroopShortcutVB;", "getShortcutVB", "()Lcom/tencent/mobileqq/troop/shortcut/aio/TroopShortcutVB;", "shortcutVB", "Ljava/lang/String;", "currentCustomBusiness", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "businessMap", "Lcom/tencent/aio/api/runtime/a;", "value", "Lcom/tencent/aio/api/runtime/a;", "getAioContext", "()Lcom/tencent/aio/api/runtime/a;", h.F, "(Lcom/tencent/aio/api/runtime/a;)V", "aioContext", "Lts2/f;", "()Lts2/f;", "binding", "<init>", "(Lcom/tencent/mobileqq/troop/shortcut/aio/TroopShortcutVB;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopShortcutVB shortcutVB;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String currentCustomBusiness;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, et2.a> businessMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.api.runtime.a aioContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/custom/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.shortcut.custom.a$a, reason: collision with other inner class name and from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55259);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull TroopShortcutVB shortcutVB) {
        Intrinsics.checkNotNullParameter(shortcutVB, "shortcutVB");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) shortcutVB);
            return;
        }
        this.shortcutVB = shortcutVB;
        this.currentCustomBusiness = "";
        this.businessMap = new HashMap<>();
    }

    private final boolean d() {
        if (c() != null && this.aioContext != null) {
            return true;
        }
        return false;
    }

    private final void f() {
        Iterator<et2.a> it = this.businessMap.values().iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    @Override // et2.b
    public void a(@NotNull et2.a customShortcutBar, @NotNull String businessName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) customShortcutBar, (Object) businessName);
            return;
        }
        Intrinsics.checkNotNullParameter(customShortcutBar, "customShortcutBar");
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        this.businessMap.put(businessName, customShortcutBar);
    }

    @Override // et2.b
    public boolean b(@NotNull String businessName) {
        boolean z16;
        boolean z17;
        ConstraintLayout constraintLayout;
        FrameLayout frameLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) businessName)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        boolean z18 = true;
        if (this.currentCustomBusiness.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.d("TroopShortcutContainerImpl", "requestShow " + businessName + ", but current is " + this.currentCustomBusiness);
            return false;
        }
        et2.a aVar = this.businessMap.get(businessName);
        if (aVar == null) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.d("TroopShortcutContainerImpl", "requestShow but " + businessName + " is not register yet");
            return false;
        }
        if (c() == null) {
            this.shortcutVB.K();
        }
        if (c() != null && this.aioContext != null) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("TroopShortcutContainerImpl", "requestShow " + businessName + " success");
            f c16 = c();
            Intrinsics.checkNotNull(c16);
            FrameLayout frameLayout2 = c16.f437385b;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding!!.customShortcutContainer");
            aVar.b(frameLayout2, this);
            f c17 = c();
            if (c17 != null && (frameLayout = c17.f437385b) != null) {
                frameLayout.setVisibility(0);
            }
            f c18 = c();
            if (c18 != null && (constraintLayout = c18.f437387d) != null) {
                constraintLayout.setVisibility(8);
            }
            this.currentCustomBusiness = businessName;
            return true;
        }
        com.tencent.mobileqq.troop.teamup.home.common.a aVar2 = com.tencent.mobileqq.troop.teamup.home.common.a.f298968a;
        if (c() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (this.aioContext != null) {
            z18 = false;
        }
        aVar2.d("TroopShortcutContainerImpl", "requestShow " + businessName + " but containerView is null:" + z17 + ",aioContext is null:" + z18);
        return false;
    }

    @Nullable
    public final f c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.shortcutVB.p();
    }

    @Override // et2.b
    public void close(@NotNull String businessName) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) businessName);
            return;
        }
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        if (!Intrinsics.areEqual(businessName, this.currentCustomBusiness)) {
            com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.d("TroopShortcutContainerImpl", businessName + " closeCustomShortcut failed for current is " + this.currentCustomBusiness);
            return;
        }
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("TroopShortcutContainerImpl", businessName + " closed");
        f c16 = c();
        if (c16 != null && (frameLayout2 = c16.f437385b) != null) {
            frameLayout2.removeAllViews();
        }
        f c17 = c();
        if (c17 != null && (frameLayout = c17.f437385b) != null) {
            frameLayout.setVisibility(8);
        }
        this.shortcutVB.D();
        this.currentCustomBusiness = "";
    }

    public final boolean e() {
        FrameLayout frameLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        f c16 = c();
        if (c16 == null || (frameLayout = c16.f437385b) == null || frameLayout.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else if (d()) {
            f();
        }
    }

    public final void h(@Nullable com.tencent.aio.api.runtime.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            this.aioContext = aVar;
            g();
        }
    }
}

package com.tencent.mobileqq.troop.shortcut.repo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.q;
import com.tencent.qqnt.avatar.meta.refresh.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b \u0010!J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R0\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0010j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R0\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0010j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R0\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0010j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R0\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0010j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0013R0\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0010j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0013R)\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001c0\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u0017\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/repo/TroopShortcutSettingCache;", "", "", "troopUin", "", "g", "", "disableCapsule", h.F, "disableCapsuleSwitch", "i", "useNewSwitch", "j", "d", "e", "f", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "disableCapsuleCache", "b", "disableCapsuleSwitchCache", "c", "newDisableCapsuleCache", "newDisableCapsuleSwitchCache", "useNewSwitchCache", "", "Lkotlin/Function1;", "Ljava/util/List;", "()Ljava/util/List;", "capsuleSwitchListeners", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopShortcutSettingCache {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private static c<TroopShortcutSettingCache> f298542h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Long, Boolean> disableCapsuleCache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Long, Boolean> disableCapsuleSwitchCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Long, Boolean> newDisableCapsuleCache;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Long, Boolean> newDisableCapsuleSwitchCache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Long, Boolean> useNewSwitchCache;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Function1<Long, Unit>> capsuleSwitchListeners;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/repo/TroopShortcutSettingCache$a;", "", "Lcom/tencent/mobileqq/troop/shortcut/repo/TroopShortcutSettingCache;", "a", "", "TAG", "Ljava/lang/String;", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "cacheWeakRef", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.shortcut.repo.TroopShortcutSettingCache$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final TroopShortcutSettingCache a() {
            TroopShortcutSettingCache troopShortcutSettingCache;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                c cVar = TroopShortcutSettingCache.f298542h;
                if (cVar == null || (troopShortcutSettingCache = (TroopShortcutSettingCache) cVar.get()) == null) {
                    TroopShortcutSettingCache troopShortcutSettingCache2 = new TroopShortcutSettingCache();
                    com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("TroopShortcutSettingCache", "create cache" + troopShortcutSettingCache2.hashCode());
                    TroopShortcutSettingCache.f298542h = new c(troopShortcutSettingCache2);
                    return troopShortcutSettingCache2;
                }
                return troopShortcutSettingCache;
            }
            return (TroopShortcutSettingCache) iPatchRedirector.redirect((short) 2, (Object) this);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55287);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopShortcutSettingCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.disableCapsuleCache = new HashMap<>();
        this.disableCapsuleSwitchCache = new HashMap<>();
        this.newDisableCapsuleCache = new HashMap<>();
        this.newDisableCapsuleSwitchCache = new HashMap<>();
        this.useNewSwitchCache = new HashMap<>();
        this.capsuleSwitchListeners = new ArrayList();
    }

    @NotNull
    public final List<Function1<Long, Unit>> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.capsuleSwitchListeners;
    }

    public final boolean d(final long troopUin) {
        HashMap<Long, Boolean> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, troopUin)).booleanValue();
        }
        final boolean f16 = f(troopUin);
        if (f16) {
            hashMap = this.newDisableCapsuleCache;
        } else {
            hashMap = this.disableCapsuleCache;
        }
        Boolean bool = hashMap.get(Long.valueOf(troopUin));
        if (bool == null) {
            q.b("TroopShortcutSettingCache", new Function0<String>(troopUin, f16) { // from class: com.tencent.mobileqq.troop.shortcut.repo.TroopShortcutSettingCache$getDisableCapsule$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $troopUin;
                final /* synthetic */ boolean $useNewSwitch;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$troopUin = troopUin;
                    this.$useNewSwitch = f16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, Long.valueOf(troopUin), Boolean.valueOf(f16));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "[getDisableCapsule],Cache miss for " + this.$troopUin + ", " + this.$useNewSwitch;
                }
            });
            return true;
        }
        return bool.booleanValue();
    }

    public final boolean e(final long troopUin) {
        HashMap<Long, Boolean> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, troopUin)).booleanValue();
        }
        final boolean f16 = f(troopUin);
        if (f16) {
            hashMap = this.newDisableCapsuleSwitchCache;
        } else {
            hashMap = this.disableCapsuleSwitchCache;
        }
        Boolean bool = hashMap.get(Long.valueOf(troopUin));
        if (bool == null) {
            q.b("TroopShortcutSettingCache", new Function0<String>(troopUin, f16) { // from class: com.tencent.mobileqq.troop.shortcut.repo.TroopShortcutSettingCache$getDisableCapsuleSwitch$1$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $troopUin;
                final /* synthetic */ boolean $useNewSwitch;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$troopUin = troopUin;
                    this.$useNewSwitch = f16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, Long.valueOf(troopUin), Boolean.valueOf(f16));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "[getDisableCapsuleSwitch],Cache miss for " + this.$troopUin + ", " + this.$useNewSwitch;
                }
            });
            return true;
        }
        return bool.booleanValue();
    }

    public final boolean f(long troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, troopUin)).booleanValue();
        }
        Boolean bool = this.useNewSwitchCache.get(Long.valueOf(troopUin));
        if (bool == null) {
            QLog.e("TroopShortcutSettingCache", 1, "[getUseNewSwitch],Cache miss for " + troopUin);
            return false;
        }
        return bool.booleanValue();
    }

    public final void g(long troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, troopUin);
            return;
        }
        Iterator<T> it = this.capsuleSwitchListeners.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(Long.valueOf(troopUin));
        }
    }

    public final void h(long troopUin, boolean disableCapsule) {
        HashMap<Long, Boolean> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(troopUin), Boolean.valueOf(disableCapsule));
            return;
        }
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("TroopShortcutSettingCache", "[setDisableCapsule]," + troopUin + "," + disableCapsule);
        if (f(troopUin)) {
            hashMap = this.newDisableCapsuleCache;
        } else {
            hashMap = this.disableCapsuleCache;
        }
        hashMap.put(Long.valueOf(troopUin), Boolean.valueOf(disableCapsule));
        g(troopUin);
    }

    public final void i(long troopUin, boolean disableCapsuleSwitch) {
        HashMap<Long, Boolean> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(troopUin), Boolean.valueOf(disableCapsuleSwitch));
            return;
        }
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("TroopShortcutSettingCache", "[setDisableCapsuleSwitch]," + troopUin + "," + disableCapsuleSwitch);
        if (f(troopUin)) {
            hashMap = this.newDisableCapsuleSwitchCache;
        } else {
            hashMap = this.disableCapsuleSwitchCache;
        }
        hashMap.put(Long.valueOf(troopUin), Boolean.valueOf(disableCapsuleSwitch));
        g(troopUin);
    }

    public final void j(long troopUin, boolean useNewSwitch) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(troopUin), Boolean.valueOf(useNewSwitch));
            return;
        }
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("TroopShortcutSettingCache", "[setUseNewSwitch]," + troopUin + "," + useNewSwitch);
        this.useNewSwitchCache.put(Long.valueOf(troopUin), Boolean.valueOf(useNewSwitch));
    }
}

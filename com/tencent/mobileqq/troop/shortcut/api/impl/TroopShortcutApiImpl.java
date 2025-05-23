package com.tencent.mobileqq.troop.shortcut.api.impl;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.shortcut.aio.TroopShortcutVB;
import com.tencent.mobileqq.troop.shortcut.api.ITroopShortcutApi;
import com.tencent.mobileqq.troop.shortcut.repo.TroopShortcutSettingCache;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import et2.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u0000 \u00152\u00020\u0001:\u0002\u0016\u0017B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0019\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/api/impl/TroopShortcutApiImpl;", "Lcom/tencent/mobileqq/troop/shortcut/api/ITroopShortcutApi;", "Let2/c;", "createShortcutVB", "", "troopUin", "", "useNewShortcut", "", "", "notifyDataExpired", "(Ljava/lang/Long;)V", "getDisableCapsule", "getDisableCapsuleSwitch", "getUseNewSwitch", "disableCapsule", "setDisableCapsule", "disableCapsuleSwitch", "setDisableCapsuleSwitch", "<init>", "()V", "Companion", "a", "ShortcutUpdateEvent", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopShortcutApiImpl implements ITroopShortcutApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "TroopShortcutApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/api/impl/TroopShortcutApiImpl$ShortcutUpdateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "troopUin", "", "(Ljava/lang/Long;)V", "getTroopUin", "()Ljava/lang/Long;", "Ljava/lang/Long;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class ShortcutUpdateEvent extends SimpleBaseEvent {
        static IPatchRedirector $redirector_;

        @Nullable
        private final Long troopUin;

        public ShortcutUpdateEvent(@Nullable Long l3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) l3);
            } else {
                this.troopUin = l3;
            }
        }

        @Nullable
        public final Long getTroopUin() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Long) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.troopUin;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/api/impl/TroopShortcutApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.shortcut.api.impl.TroopShortcutApiImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55253);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopShortcutApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcut.api.ITroopShortcutApi
    @NotNull
    public c createShortcutVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new TroopShortcutVB();
    }

    @Override // com.tencent.mobileqq.troop.shortcut.api.ITroopShortcutApi
    public boolean getDisableCapsule(long troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, troopUin)).booleanValue();
        }
        return TroopShortcutSettingCache.INSTANCE.a().d(troopUin);
    }

    @Override // com.tencent.mobileqq.troop.shortcut.api.ITroopShortcutApi
    public boolean getDisableCapsuleSwitch(long troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, troopUin)).booleanValue();
        }
        return TroopShortcutSettingCache.INSTANCE.a().e(troopUin);
    }

    @Override // com.tencent.mobileqq.troop.shortcut.api.ITroopShortcutApi
    public boolean getUseNewSwitch(long troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, troopUin)).booleanValue();
        }
        return TroopShortcutSettingCache.INSTANCE.a().f(troopUin);
    }

    @Override // com.tencent.mobileqq.troop.shortcut.api.ITroopShortcutApi
    public void notifyDataExpired(@Nullable Long troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopUin);
        } else {
            SimpleEventBus.getInstance().dispatchEvent(new ShortcutUpdateEvent(troopUin));
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcut.api.ITroopShortcutApi
    public void setDisableCapsule(long troopUin, boolean disableCapsule) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(troopUin), Boolean.valueOf(disableCapsule));
        } else {
            TroopShortcutSettingCache.INSTANCE.a().h(troopUin, disableCapsule);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcut.api.ITroopShortcutApi
    public void setDisableCapsuleSwitch(long troopUin, boolean disableCapsuleSwitch) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Long.valueOf(troopUin), Boolean.valueOf(disableCapsuleSwitch));
        } else {
            TroopShortcutSettingCache.INSTANCE.a().i(troopUin, disableCapsuleSwitch);
        }
    }

    @Override // com.tencent.mobileqq.troop.shortcut.api.ITroopShortcutApi
    public boolean useNewShortcut(@Nullable String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin)).booleanValue();
        }
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(troopUin);
        if (troopInfoFromCache != null && !troopInfoFromCache.isExited()) {
            return true;
        }
        return false;
    }
}

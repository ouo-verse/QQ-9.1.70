package com.tencent.mobileqq.troop.addcontact.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.addcontact.api.IAddContactSessionRepo;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import com.tencent.mobileqq.troop.config.a;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000bH\u0016R\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/addcontact/api/impl/AddContactSessionRepoImpl;", "Lcom/tencent/mobileqq/troop/addcontact/api/IAddContactSessionRepo;", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "type", "", "getLastSessionTime", "", "resetSession", "", "getStorageKey", "getLastTimeKey", "", "getSession", "latestSession", "setSession", "emptySession", "[B", "", "refreshPeriodMs", "I", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class AddContactSessionRepoImpl implements IAddContactSessionRepo {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final String CONFIG_ID_SESSION_REFRESH_PERIOD = "101068";

    @NotNull
    private static final String CONFIG_KEY_SESSION_REFRESH_PERIOD = "session_info_expire_time";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int DEFAULT_REFRESH_PERIOD_S = 7200;

    @NotNull
    private static final String TAG = "AddContactSessionRepo";

    @NotNull
    private final byte[] emptySession;
    private int refreshPeriodMs;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/addcontact/api/impl/AddContactSessionRepoImpl$a;", "", "", "CONFIG_ID_SESSION_REFRESH_PERIOD", "Ljava/lang/String;", "CONFIG_KEY_SESSION_REFRESH_PERIOD", "", "DEFAULT_REFRESH_PERIOD_S", "I", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.addcontact.api.impl.AddContactSessionRepoImpl$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f293811a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23485);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[AddContactDataType.values().length];
            try {
                iArr[AddContactDataType.f293812GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AddContactDataType.PERSON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AddContactDataType.GUILD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AddContactDataType.FLOCK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f293811a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23488);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AddContactSessionRepoImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.emptySession = new byte[0];
        this.refreshPeriodMs = 7200000;
        this.refreshPeriodMs = com.tencent.mobileqq.troop.config.b.f294691a.d(CONFIG_ID_SESSION_REFRESH_PERIOD, CONFIG_KEY_SESSION_REFRESH_PERIOD, 7200) * 1000;
    }

    private final long getLastSessionTime(AddContactDataType type) {
        return a.f294689a.k(getLastTimeKey(type), 0L, true);
    }

    private final String getLastTimeKey(AddContactDataType type) {
        String str;
        int i3 = b.f293811a[type.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        str = "peer";
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    str = "guild";
                }
            } else {
                str = "person";
            }
        } else {
            str = VipFunCallConstants.KEY_GROUP;
        }
        return "add_contact_last_session_time_" + str;
    }

    private final String getStorageKey(AddContactDataType type) {
        String str;
        int i3 = b.f293811a[type.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        str = "peer";
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    str = "guild";
                }
            } else {
                str = "person";
            }
        } else {
            str = VipFunCallConstants.KEY_GROUP;
        }
        return "add_contact_session_" + str;
    }

    private final void resetSession(AddContactDataType type) {
        QLog.i(TAG, 1, "resetAllSession type: " + type);
        setSession(type, this.emptySession);
    }

    @Override // com.tencent.mobileqq.troop.addcontact.api.IAddContactSessionRepo
    @NotNull
    public byte[] getSession(@NotNull AddContactDataType type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this, (Object) type);
        }
        Intrinsics.checkNotNullParameter(type, "type");
        if (System.currentTimeMillis() - getLastSessionTime(type) > this.refreshPeriodMs) {
            resetSession(type);
            return this.emptySession;
        }
        return a.g(a.f294689a, getStorageKey(type), this.emptySession, false, 4, null);
    }

    @Override // com.tencent.mobileqq.troop.addcontact.api.IAddContactSessionRepo
    public void setSession(@NotNull AddContactDataType type, @NotNull byte[] latestSession) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) type, (Object) latestSession);
            return;
        }
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(latestSession, "latestSession");
        a aVar = a.f294689a;
        a.t(aVar, getStorageKey(type), latestSession, false, 4, null);
        a.x(aVar, getLastTimeKey(type), System.currentTimeMillis(), false, 4, null);
    }
}

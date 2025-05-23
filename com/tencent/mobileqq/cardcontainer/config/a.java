package com.tencent.mobileqq.cardcontainer.config;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.cardcontainer.data.CardType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0017\u0018B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002R$\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR0\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R0\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00120\r8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\b\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/config/a;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "busiName", "", "f", "<set-?>", "d", "Z", "e", "()Z", "mainSwitch", "", "Ljava/util/List;", "getBusinessBlacklist", "()Ljava/util/List;", "businessBlacklist", "Lcom/tencent/mobileqq/cardcontainer/data/CardType;", "cardTypeBlacklist", "<init>", "()V", h.F, "a", "b", "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mainSwitch;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> businessBlacklist;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends CardType> cardTypeBlacklist;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\b\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0014\u0010\u000b\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005J\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/config/a$a;", "", "", "mainSwitch", "c", "", "", "businessBlacklist", "b", "Lcom/tencent/mobileqq/cardcontainer/data/CardType;", "cardTypeBlacklist", "d", "Lcom/tencent/mobileqq/cardcontainer/config/a;", "a", "Lcom/tencent/mobileqq/cardcontainer/config/a;", "cardContainerConfig", "<init>", "()V", "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.config.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C7444a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a cardContainerConfig;

        public C7444a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.cardContainerConfig = new a();
            }
        }

        @NotNull
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.cardContainerConfig;
        }

        @NotNull
        public final C7444a b(@NotNull List<String> businessBlacklist) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (C7444a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) businessBlacklist);
            }
            Intrinsics.checkNotNullParameter(businessBlacklist, "businessBlacklist");
            this.cardContainerConfig.businessBlacklist = businessBlacklist;
            return this;
        }

        @NotNull
        public final C7444a c(boolean mainSwitch) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.cardContainerConfig.mainSwitch = mainSwitch;
                return this;
            }
            return (C7444a) iPatchRedirector.redirect((short) 2, (Object) this, mainSwitch);
        }

        @NotNull
        public final C7444a d(@NotNull List<? extends CardType> cardTypeBlacklist) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (C7444a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cardTypeBlacklist);
            }
            Intrinsics.checkNotNullParameter(cardTypeBlacklist, "cardTypeBlacklist");
            this.cardContainerConfig.cardTypeBlacklist = cardTypeBlacklist;
            return this;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/config/a$b;", "", "Lcom/tencent/mobileqq/cardcontainer/config/a;", "a", "", "CONFIG_ID", "Ljava/lang/String;", "<init>", "()V", "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.cardcontainer.config.a$b, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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

        @JvmStatic
        @NotNull
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            a aVar = (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("chat_list_card_container_config");
            if (aVar == null) {
                return new a();
            }
            return aVar;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36236);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        List<String> emptyList;
        List<? extends CardType> emptyList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mainSwitch = true;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.businessBlacklist = emptyList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.cardTypeBlacklist = emptyList2;
    }

    @NotNull
    public final List<CardType> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.cardTypeBlacklist;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.mainSwitch;
    }

    public final boolean f(@NotNull String busiName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) busiName)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(busiName, "busiName");
        return this.businessBlacklist.contains(busiName);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "CardContainerConfig(mainSwitch=" + this.mainSwitch + ", businessBlacklist=" + this.businessBlacklist + "), cardTypeBlacklist=" + this.cardTypeBlacklist + ")";
    }
}

package com.tencent.mobileqq.troop.troopnotification.render.parser;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.api.ITroopNotificationService;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.TroopInfoRepo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0016J6\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J6\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u0003\u001a\u00020\u0006H\u0016JO\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f2!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00040\u0012JO\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f2!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0019\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00040\u0012J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\nR\u001a\u0010\"\u001a\u00020\r8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/render/parser/TroopNotificationTagParser;", "Lcom/tencent/mobileqq/troop/troopnotification/render/parser/a;", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/list/a;", "viewHolder", "", "d", "Lcom/tencent/mobileqq/troop/troopnotification/render/vh/detail/a;", "b", "Lcom/tencent/qqnt/notification/f;", "msg", "", "wildcardValue", "", "", "data", "", "c", "a", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/data/troop/d;", "Lkotlin/ParameterName;", "name", "tagInfo", "callback", "g", "Lcom/tencent/mobileqq/troop/troopcatalog/a;", "bean", "e", "wildcard", tl.h.F, "f", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "key", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopNotificationTagParser implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TroopNotificationTagParser f300743a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String key;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59514);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f300743a = new TroopNotificationTagParser();
            key = "tag";
        }
    }

    TroopNotificationTagParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public boolean a(@NotNull com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull final com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, msg2, wildcardValue, data, viewHolder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (g(msg2, wildcardValue, data, new Function1<com.tencent.mobileqq.data.troop.d, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.render.parser.TroopNotificationTagParser$parse$parseMemberResult$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.data.troop.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.mobileqq.data.troop.d it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a.this.C(it);
                }
            }
        })) {
            return true;
        }
        return e(msg2, wildcardValue, data, new Function1<com.tencent.mobileqq.troop.troopcatalog.a, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.render.parser.TroopNotificationTagParser$parse$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.troop.troopcatalog.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.mobileqq.troop.troopcatalog.a it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a.this.D(it);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public void b(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.detail.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder);
        } else {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            viewHolder.v();
        }
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public boolean c(@NotNull com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull final com.tencent.mobileqq.troop.troopnotification.render.vh.list.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, msg2, wildcardValue, data, viewHolder)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return g(msg2, wildcardValue, data, new Function1<com.tencent.mobileqq.data.troop.d, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.render.parser.TroopNotificationTagParser$parse$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.troop.troopnotification.render.vh.list.a.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.data.troop.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.mobileqq.data.troop.d it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    com.tencent.mobileqq.troop.troopnotification.render.vh.list.a.this.C(it);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    public void d(@NotNull com.tencent.mobileqq.troop.troopnotification.render.vh.list.a viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewHolder);
        } else {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            viewHolder.x();
        }
    }

    public final boolean e(@NotNull com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull Function1<? super com.tencent.mobileqq.troop.troopcatalog.a, Unit> callback) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, msg2, wildcardValue, data, callback)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String f16 = f(wildcardValue);
        if (f16 != null && f16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("TroopNotificationTagParser", 1, "parseGroupTag: no find level tag data, wildcardValue=" + wildcardValue);
            return false;
        }
        TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(f16);
        if (troopInfoFromCache != null) {
            com.tencent.mobileqq.troop.troopcatalog.a c16 = com.tencent.mobileqq.troop.troopcatalog.b.g().c(String.valueOf(troopInfoFromCache.dwGroupClassExt));
            if (c16 != null) {
                callback.invoke(c16);
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopNotificationTagParser", 2, "parseGroupTag: bean=null");
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationTagParser", 2, "parseGroupTag: troopInfo=null");
        }
        return false;
    }

    @Nullable
    public final String f(@Nullable Object wildcard) {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, wildcard);
        }
        if (wildcard instanceof Map) {
            Map map = (Map) wildcard;
            if (Intrinsics.areEqual(map.get("type"), (Object) 2)) {
                Object obj = map.get("uin");
                if (obj != null) {
                    str = obj.toString();
                } else {
                    str = null;
                }
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    return str;
                }
            }
        }
        return null;
    }

    public final boolean g(@NotNull com.tencent.qqnt.notification.f msg2, @Nullable Object wildcardValue, @NotNull Map<String, ? extends Object> data, @NotNull Function1<? super com.tencent.mobileqq.data.troop.d, Unit> callback) {
        boolean z16;
        com.tencent.mobileqq.data.troop.d dVar;
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, msg2, wildcardValue, data, callback)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String h16 = h(wildcardValue);
        if (h16 != null && h16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"name", "uin"});
            QLog.e("TroopNotificationTagParser", 1, "parseMemberTag: no find level tag data, wildcardValue=" + com.tencent.util.k.f(wildcardValue, listOf));
            return false;
        }
        ITroopNotificationService iTroopNotificationService = (ITroopNotificationService) bg.l(ITroopNotificationService.class);
        if (iTroopNotificationService != null) {
            dVar = iTroopNotificationService.getApplicantInfo(Long.valueOf(Util.toLongOrDefault(h16, 0L)));
        } else {
            dVar = null;
        }
        if (dVar == null) {
            return false;
        }
        callback.invoke(dVar);
        return true;
    }

    @Override // com.tencent.mobileqq.troop.troopnotification.render.parser.a
    @NotNull
    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return key;
    }

    @Nullable
    public final String h(@Nullable Object wildcard) {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, wildcard);
        }
        if (!(wildcard instanceof Map)) {
            return null;
        }
        Map map = (Map) wildcard;
        boolean z17 = true;
        if (!Intrinsics.areEqual(map.get("type"), (Object) 1)) {
            return null;
        }
        Object obj = map.get("uin");
        if (obj != null) {
            str = obj.toString();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        ITroopRobotService iTroopRobotService = (ITroopRobotService) bg.l(ITroopRobotService.class);
        if (iTroopRobotService == null || !iTroopRobotService.isRobotUin(str)) {
            z17 = false;
        }
        if (z17) {
            return null;
        }
        return str;
    }
}

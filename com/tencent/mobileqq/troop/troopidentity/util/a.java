package com.tencent.mobileqq.troop.troopidentity.util;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0006B#\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\f\u00a2\u0006\u0004\b\u0017\u0010\u0018J,\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001`\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J$\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\fJ$\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\fR#\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/util/a;", "", "", "elementId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "", "isPgIn", "", "f", "emId", "", "emParams", "b", "d", "Ljava/util/Map;", "getPageParams", "()Ljava/util/Map;", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "", "pgParams", "pgId", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "c", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Object> pageParams;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, Object> pgParams;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/util/a$a;", "", "", "troopUin", "", "isHost", "", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopidentity.util.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.troop.troopidentity.util.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        public /* synthetic */ class C8812a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f300416a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57851);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 1)) {
                    redirector.redirect((short) 1);
                    return;
                }
                int[] iArr = new int[MemberRole.values().length];
                try {
                    iArr[MemberRole.OWNER.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MemberRole.ADMIN.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[MemberRole.MEMBER.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f300416a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final Map<String, Object> a(@NotNull String troopUin, boolean isHost) {
            String str;
            int i3;
            int i16;
            Long longOrNull;
            long j3;
            Map<String, Object> mapOf;
            AppRuntime peekAppRuntime;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Map) iPatchRedirector.redirect((short) 2, this, troopUin, Boolean.valueOf(isHost));
            }
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            MemberRole memberRole = null;
            if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
                str = peekAppRuntime.getCurrentAccountUin();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            TroopMemberInfo troopMemberFromCache = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberFromCache(troopUin, str, null, "TroopAllInteractiveTagsVM");
            if (troopMemberFromCache != null) {
                memberRole = troopMemberFromCache.role;
            }
            if (memberRole == null) {
                i3 = -1;
            } else {
                i3 = C8812a.f300416a[memberRole.ordinal()];
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        i16 = 0;
                    } else {
                        i16 = 3;
                    }
                } else {
                    i16 = 2;
                }
            } else {
                i16 = 1;
            }
            Pair[] pairArr = new Pair[3];
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            pairArr[0] = TuplesKt.to("group_id", Long.valueOf(j3));
            pairArr[1] = TuplesKt.to("group_uin_type", Integer.valueOf(i16));
            pairArr[2] = TuplesKt.to("group_user_master", Integer.valueOf(!isHost ? 1 : 0));
            mapOf = MapsKt__MapsKt.mapOf(pairArr);
            return mapOf;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57854);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull String pgId, @NotNull Map<String, ? extends Object> pageParams) {
        Intrinsics.checkNotNullParameter(pgId, "pgId");
        Intrinsics.checkNotNullParameter(pageParams, "pageParams");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pgId, (Object) pageParams);
            return;
        }
        this.pageParams = pageParams;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.pgParams = linkedHashMap;
        linkedHashMap.put("dt_pgid", pgId);
        this.pgParams.put("pgid", pgId);
        this.pgParams.putAll(pageParams);
    }

    private final HashMap<String, Object> a(String elementId) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.putAll(this.pgParams);
        hashMap.put("dt_eid", elementId);
        hashMap.put("eid", elementId);
        hashMap.put("cur_pg", this.pgParams);
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(a aVar, String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        aVar.b(str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(a aVar, String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        aVar.d(str, map);
    }

    public final void b(@NotNull String emId, @NotNull Map<String, ? extends Object> emParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) emId, (Object) emParams);
            return;
        }
        Intrinsics.checkNotNullParameter(emId, "emId");
        Intrinsics.checkNotNullParameter(emParams, "emParams");
        HashMap<String, Object> a16 = a(emId);
        a16.putAll(emParams);
        VideoReport.reportEvent("dt_clck", a16);
    }

    public final void d(@NotNull String emId, @NotNull Map<String, ? extends Object> emParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) emId, (Object) emParams);
            return;
        }
        Intrinsics.checkNotNullParameter(emId, "emId");
        Intrinsics.checkNotNullParameter(emParams, "emParams");
        HashMap<String, Object> a16 = a(emId);
        a16.putAll(emParams);
        VideoReport.reportEvent("dt_imp", a16);
    }

    public final void f(boolean isPgIn) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, isPgIn);
            return;
        }
        if (isPgIn) {
            str = "dt_pgin";
        } else {
            str = "dt_pgout";
        }
        VideoReport.reportEvent(str, this.pgParams);
    }
}

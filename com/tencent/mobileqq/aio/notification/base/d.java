package com.tencent.mobileqq.aio.notification.base;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.notification.AIONotificationBusiId;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/base/d;", "", "", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", "Lcom/tencent/mobileqq/aio/notification/base/d$a;", "b", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "infoMap", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f192838a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<AIONotificationBusiId, a> infoMap;

    static {
        Map<AIONotificationBusiId, a> mapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53557);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f192838a = new d();
        AIONotificationBusiId aIONotificationBusiId = AIONotificationBusiId.DEBUG_LIVE;
        com.tencent.mobileqq.aio.notification.render.b bVar = com.tencent.mobileqq.aio.notification.render.b.f193007a;
        AIONotificationBusiId aIONotificationBusiId2 = AIONotificationBusiId.DEBUG_TODO;
        com.tencent.mobileqq.aio.notification.render.c cVar = com.tencent.mobileqq.aio.notification.render.c.f193008a;
        AIONotificationBusiId aIONotificationBusiId3 = AIONotificationBusiId.DEBUG_APPLICATION;
        AIONotificationBusiId aIONotificationBusiId4 = AIONotificationBusiId.AIO_MONITOR;
        com.tencent.mobileqq.aio.notification.render.a aVar = new com.tencent.mobileqq.aio.notification.render.a(R.drawable.f160152mm3, 0);
        DefaultConstructorMarker defaultConstructorMarker = null;
        AIONotificationBusiId aIONotificationBusiId5 = AIONotificationBusiId.TROOP_ANNOUNCEMENT;
        int i3 = 2;
        int i16 = 0;
        boolean z16 = false;
        int i17 = 48;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        AIONotificationBusiId aIONotificationBusiId6 = AIONotificationBusiId.AUDIO_VIDEO_CHAT;
        int i18 = 1;
        AIONotificationBusiId aIONotificationBusiId7 = AIONotificationBusiId.TROOP_CLASS;
        int i19 = 2;
        boolean z17 = false;
        int i26 = 32;
        AIONotificationBusiId aIONotificationBusiId8 = AIONotificationBusiId.SHARE_SCREEN;
        AIONotificationBusiId aIONotificationBusiId9 = AIONotificationBusiId.SHARE_LOCATION;
        AIONotificationBusiId aIONotificationBusiId10 = AIONotificationBusiId.TROOP_LIVE;
        AIONotificationBusiId aIONotificationBusiId11 = AIONotificationBusiId.LISTEN_MUSIC_TOGETHER;
        int i27 = 0;
        boolean z18 = true;
        int i28 = 16;
        AIONotificationBusiId aIONotificationBusiId12 = AIONotificationBusiId.FRAUD;
        int i29 = 3;
        AIONotificationBusiId aIONotificationBusiId13 = AIONotificationBusiId.TROOP_OWNER_TASK;
        boolean z19 = false;
        int i36 = 48;
        AIONotificationBusiId aIONotificationBusiId14 = AIONotificationBusiId.TROOP_OWNER_MSG;
        AIONotificationBusiId aIONotificationBusiId15 = AIONotificationBusiId.HOMEWORK_TROOP_MSG;
        AIONotificationBusiId aIONotificationBusiId16 = AIONotificationBusiId.HOMEWORK_TROOP_IDENTIFY_GUIDE;
        AIONotificationBusiId aIONotificationBusiId17 = AIONotificationBusiId.HOMEWORK_TROOP_CLASSINFO;
        AIONotificationBusiId aIONotificationBusiId18 = AIONotificationBusiId.TROOP_ASSIST_TIPS;
        AIONotificationBusiId aIONotificationBusiId19 = AIONotificationBusiId.TROOP_TODO;
        AIONotificationBusiId aIONotificationBusiId20 = AIONotificationBusiId.TROOP_HW_NOTICE;
        AIONotificationBusiId aIONotificationBusiId21 = AIONotificationBusiId.TROOP_HW_CLOCK_IN;
        AIONotificationBusiId aIONotificationBusiId22 = AIONotificationBusiId.UPGRADE_BIG_TROOP;
        boolean z26 = true;
        int i37 = 16;
        AIONotificationBusiId aIONotificationBusiId23 = AIONotificationBusiId.UPGRADE_BIG_TROOP_EXPIRED;
        AIONotificationBusiId aIONotificationBusiId24 = AIONotificationBusiId.TROOP_JOIN_GUILD;
        boolean z27 = false;
        int i38 = 48;
        AIONotificationBusiId aIONotificationBusiId25 = AIONotificationBusiId.NEARBY_ADD_FRIEND;
        AIONotificationBusiId aIONotificationBusiId26 = AIONotificationBusiId.GAME_MSG;
        AIONotificationBusiId aIONotificationBusiId27 = AIONotificationBusiId.ARK_TIP;
        AIONotificationBusiId aIONotificationBusiId28 = AIONotificationBusiId.TROOP_GROUP_ALBUM;
        AIONotificationBusiId aIONotificationBusiId29 = AIONotificationBusiId.TROOP_GAME_TEAM;
        int i39 = 1;
        AIONotificationBusiId aIONotificationBusiId30 = AIONotificationBusiId.TROOP_GAME_JOIN;
        int i46 = 2;
        int i47 = 32;
        AIONotificationBusiId aIONotificationBusiId31 = AIONotificationBusiId.TROOP_META_DREAM_TEAM;
        AIONotificationBusiId aIONotificationBusiId32 = AIONotificationBusiId.TROOP_META_DREAM_FARM;
        int i48 = 3;
        AIONotificationBusiId aIONotificationBusiId33 = AIONotificationBusiId.TROOP_ASSIGN_HW_NOTIFY_BAR;
        AIONotificationBusiId aIONotificationBusiId34 = AIONotificationBusiId.TROOP_WANGZHE_REPORT;
        int i49 = 0;
        int i56 = 48;
        AIONotificationBusiId aIONotificationBusiId35 = AIONotificationBusiId.TROOP_TEAM_UP;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(aIONotificationBusiId, new a(aIONotificationBusiId, 1, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.f160152mm3, 0), 0, true)), TuplesKt.to(aIONotificationBusiId2, new a(aIONotificationBusiId2, 2, cVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.f160152mm3, 0), 0, true)), TuplesKt.to(aIONotificationBusiId3, new a(aIONotificationBusiId3, 3, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.f160152mm3, 0), 0, true)), TuplesKt.to(aIONotificationBusiId4, new a(aIONotificationBusiId4, 3, bVar, aVar, 0, false, 48, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId5, new a(aIONotificationBusiId5, i3, cVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.mlr, R.drawable.mls), i16, z16, i17, defaultConstructorMarker2)), TuplesKt.to(aIONotificationBusiId6, new a(aIONotificationBusiId6, 1, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.mmg, R.drawable.mmh), 1, true)), TuplesKt.to(aIONotificationBusiId7, new a(aIONotificationBusiId7, i18, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.mlw, R.drawable.mlx), i19, z17, i26, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId8, new a(aIONotificationBusiId8, i18, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.mmg, R.drawable.mmh), i19, z17, i26, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId9, new a(aIONotificationBusiId9, 1, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.mma, R.drawable.mmb), 1, true)), TuplesKt.to(aIONotificationBusiId10, new a(aIONotificationBusiId10, i18, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.mm5, R.drawable.mm6), 2, false, i26, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId11, new a(aIONotificationBusiId11, i18, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.mmd, R.drawable.mme), i27, z18, i28, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId12, new a(aIONotificationBusiId12, i29, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.f160149mm0, 0), i27, z18, i28, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId13, new a(aIONotificationBusiId13, i29, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.mmk, R.drawable.mml), i27, z19, i36, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId14, new a(aIONotificationBusiId14, i29, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.mmk, R.drawable.mml), i27, z19, i36, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId15, new a(aIONotificationBusiId15, i29, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.f160152mm3, 0), i27, z19, i36, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId16, new a(aIONotificationBusiId16, i29, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.f160152mm3, 0), i27, z19, i36, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId17, new a(aIONotificationBusiId17, i29, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.f160152mm3, 0), i27, z19, i36, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId18, new a(aIONotificationBusiId18, i29, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.f160152mm3, 0), i27, z19, i36, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId19, new a(aIONotificationBusiId19, i3, cVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.mmi, R.drawable.mmj), i16, z16, i17, defaultConstructorMarker2)), TuplesKt.to(aIONotificationBusiId20, new a(aIONotificationBusiId20, i3, cVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.m8a, 0), i16, z16, i17, defaultConstructorMarker2)), TuplesKt.to(aIONotificationBusiId21, new a(aIONotificationBusiId21, i3, cVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.m89, R.drawable.m8_), i16, z16, i17, defaultConstructorMarker2)), TuplesKt.to(aIONotificationBusiId22, new a(aIONotificationBusiId22, i29, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.mlu, R.drawable.mlv), i27, z26, i37, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId23, new a(aIONotificationBusiId23, i29, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.f160152mm3, 0), i27, z26, i37, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId24, new a(aIONotificationBusiId24, i29, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.f160152mm3, 0), i27, z27, i38, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId25, new a(aIONotificationBusiId25, i29, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.f160152mm3, 0), i27, z27, i38, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId26, new a(aIONotificationBusiId26, i29, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.f160150mm1, R.drawable.f160151mm2), i27, z27, i38, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId27, new a(aIONotificationBusiId27, i29, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.f160152mm3, 0), i27, z27, i38, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId28, new a(aIONotificationBusiId28, i29, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.mm7, R.drawable.mm8), i27, z27, i38, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId29, new a(aIONotificationBusiId29, i39, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.mmm, R.drawable.mmp), i27, z27, i38, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId30, new a(aIONotificationBusiId30, i39, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.mm9, R.drawable.mm_), i46, z27, i47, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId31, new a(aIONotificationBusiId31, i39, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.n9w, R.drawable.n9x), i46, z27, i47, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId32, new a(aIONotificationBusiId32, i48, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.n9w, R.drawable.n9x), 1, z27, i47, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId33, new a(aIONotificationBusiId33, i48, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.n9u, R.drawable.n9v), 2, z27, i47, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId34, new a(aIONotificationBusiId34, i48, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.mmn, R.drawable.mmo), i49, z27, i56, defaultConstructorMarker)), TuplesKt.to(aIONotificationBusiId35, new a(aIONotificationBusiId35, i48, bVar, new com.tencent.mobileqq.aio.notification.render.a(R.drawable.n9y, R.drawable.n9z), i49, z27, i56, defaultConstructorMarker)));
        infoMap = mapOf;
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final Map<AIONotificationBusiId, a> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return infoMap;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\"\u001a\u00020\u0007\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001b\u001a\u0004\b\u000f\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\"\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\n\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/base/d$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", "a", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", "getId", "()Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", "id", "b", "I", "e", "()I", "type", "Lcom/tencent/mobileqq/aio/notification/render/d;", "c", "Lcom/tencent/mobileqq/aio/notification/render/d;", "d", "()Lcom/tencent/mobileqq/aio/notification/render/d;", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "Lcom/tencent/mobileqq/aio/notification/render/a;", "Lcom/tencent/mobileqq/aio/notification/render/a;", "()Lcom/tencent/mobileqq/aio/notification/render/a;", "icon", "priority", "f", "Z", "()Z", "canReceiveCreateEvent", "<init>", "(Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;ILcom/tencent/mobileqq/aio/notification/render/d;Lcom/tencent/mobileqq/aio/notification/render/a;IZ)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final AIONotificationBusiId id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int type;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.aio.notification.render.d render;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final com.tencent.mobileqq.aio.notification.render.a icon;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int priority;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean canReceiveCreateEvent;

        public a(@NotNull AIONotificationBusiId id5, int i3, @NotNull com.tencent.mobileqq.aio.notification.render.d render, @Nullable com.tencent.mobileqq.aio.notification.render.a aVar, int i16, boolean z16) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(render, "render");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, id5, Integer.valueOf(i3), render, aVar, Integer.valueOf(i16), Boolean.valueOf(z16));
                return;
            }
            this.id = id5;
            this.type = i3;
            this.render = render;
            this.icon = aVar;
            this.priority = i16;
            this.canReceiveCreateEvent = z16;
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            return this.canReceiveCreateEvent;
        }

        @Nullable
        public final com.tencent.mobileqq.aio.notification.render.a b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (com.tencent.mobileqq.aio.notification.render.a) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.icon;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.priority;
        }

        @NotNull
        public final com.tencent.mobileqq.aio.notification.render.d d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (com.tencent.mobileqq.aio.notification.render.d) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.render;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (this.id == aVar.id && this.type == aVar.type && Intrinsics.areEqual(this.render, aVar.render) && Intrinsics.areEqual(this.icon, aVar.icon) && this.priority == aVar.priority && this.canReceiveCreateEvent == aVar.canReceiveCreateEvent) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
            }
            int hashCode2 = ((((this.id.hashCode() * 31) + this.type) * 31) + this.render.hashCode()) * 31;
            com.tencent.mobileqq.aio.notification.render.a aVar = this.icon;
            if (aVar == null) {
                hashCode = 0;
            } else {
                hashCode = aVar.hashCode();
            }
            int i3 = (((hashCode2 + hashCode) * 31) + this.priority) * 31;
            boolean z16 = this.canReceiveCreateEvent;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return i3 + i16;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (String) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return "Info(id=" + this.id + ", type=" + this.type + ", render=" + this.render + ", icon=" + this.icon + ", priority=" + this.priority + ", canReceiveCreateEvent=" + this.canReceiveCreateEvent + ")";
        }

        public /* synthetic */ a(AIONotificationBusiId aIONotificationBusiId, int i3, com.tencent.mobileqq.aio.notification.render.d dVar, com.tencent.mobileqq.aio.notification.render.a aVar, int i16, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(aIONotificationBusiId, i3, dVar, (i17 & 8) != 0 ? null : aVar, (i17 & 16) != 0 ? Integer.MAX_VALUE : i16, (i17 & 32) != 0 ? false : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, aIONotificationBusiId, Integer.valueOf(i3), dVar, aVar, Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17), defaultConstructorMarker);
        }
    }
}

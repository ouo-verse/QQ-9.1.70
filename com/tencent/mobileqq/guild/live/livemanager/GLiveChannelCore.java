package com.tencent.mobileqq.guild.live.livemanager;

import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.tencent.avbiz.Constants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.live.danmu.LiveDanmuManager;
import com.tencent.mobileqq.guild.live.livemanager.anchor.GameLiveAnchorMgr;
import com.tencent.mobileqq.guild.live.livemanager.gift.GuildLiveGiftService;
import com.tencent.mobileqq.guild.live.livemanager.player.GuildLivePlayerTag;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sq1.GLiveOutPlayerInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bb\u0010cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ&\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\tH\u0007J'\u0010\u0013\u001a\u00028\u0000\"\b\b\u0000\u0010\u0010*\u00020\u000f2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014R+\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00058F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010'\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010-\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u00102\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\b%\u0010/\u001a\u0004\b0\u00101R\u0017\u00108\u001a\u0002038\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0017\u0010=\u001a\u0002098\u0006\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b4\u0010<R\u0017\u0010C\u001a\u00020>8\u0006\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0017\u0010I\u001a\u00020D8\u0006\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001b\u0010N\u001a\u00020J8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010L\u001a\u0004\b:\u0010MR(\u0010Q\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0011\u0012\u0004\u0012\u00020\u000f0O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010PR\u0017\u0010U\u001a\u00020R8\u0006\u00a2\u0006\f\n\u0004\b6\u0010S\u001a\u0004\bE\u0010TR\u0017\u0010Y\u001a\u00020V8\u0006\u00a2\u0006\f\n\u0004\b0\u0010W\u001a\u0004\b?\u0010XR\u0017\u0010]\u001a\u00020Z8\u0006\u00a2\u0006\f\n\u0004\b+\u0010[\u001a\u0004\bK\u0010\\R$\u0010a\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0013\u0010^\u001a\u0004\b_\u0010`\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/GLiveChannelCore;", "", "", "u", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/guild/live/model/GLiveChannelStartParams;", "startParams", "", "a", "", "reason", "b", "needEndLiveInfo", "programId", "e", "Lcom/tencent/mobileqq/guild/live/viewmodel/a;", "T", "Ljava/lang/Class;", "clz", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/Class;)Lcom/tencent/mobileqq/guild/live/viewmodel/a;", "<set-?>", "c", "Luq1/a;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/mobileqq/guild/live/model/GLiveChannelStartParams;", "w", "(Lcom/tencent/mobileqq/guild/live/model/GLiveChannelStartParams;)V", "startParamsInfo", "Ltq1/b;", "d", "Ltq1/b;", "t", "()Ltq1/b;", "uiData", "Lcom/tencent/mobileqq/guild/live/livemanager/q;", "Lcom/tencent/mobileqq/guild/live/livemanager/q;", "g", "()Lcom/tencent/mobileqq/guild/live/livemanager/q;", "eventHelper", "Lcom/tencent/mobileqq/guild/live/livemanager/g;", "f", "Lcom/tencent/mobileqq/guild/live/livemanager/g;", "p", "()Lcom/tencent/mobileqq/guild/live/livemanager/g;", "liveSdkCommMgr", "Lqq1/a;", "Lqq1/a;", "o", "()Lqq1/a;", "liveSdkAudienceMgr", "Lcom/tencent/mobileqq/guild/live/livemanager/anchor/g;", tl.h.F, "Lcom/tencent/mobileqq/guild/live/livemanager/anchor/g;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/guild/live/livemanager/anchor/g;", "liveSdkAnchorMgr", "Lcom/tencent/mobileqq/guild/live/livemanager/anchor/e;", "i", "Lcom/tencent/mobileqq/guild/live/livemanager/anchor/e;", "()Lcom/tencent/mobileqq/guild/live/livemanager/anchor/e;", "gameAnchorMgr", "Lcom/tencent/mobileqq/guild/live/livemanager/player/l;", "j", "Lcom/tencent/mobileqq/guild/live/livemanager/player/l;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/guild/live/livemanager/player/l;", "livePlayerMgr", "Lcom/tencent/mobileqq/guild/live/livemanager/f;", "k", "Lcom/tencent/mobileqq/guild/live/livemanager/f;", "r", "()Lcom/tencent/mobileqq/guild/live/livemanager/f;", "roomTypeMgr", "Lcom/tencent/mobileqq/guild/live/livemanager/gift/h;", "l", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/guild/live/livemanager/gift/h;", "giftService", "Landroid/util/ArrayMap;", "Landroid/util/ArrayMap;", "logicVmMap", "Lcom/tencent/mobileqq/guild/live/livemanager/QQGuildLiveGuestHelper;", "Lcom/tencent/mobileqq/guild/live/livemanager/QQGuildLiveGuestHelper;", "()Lcom/tencent/mobileqq/guild/live/livemanager/QQGuildLiveGuestHelper;", "liveGuestHelper", "Lcom/tencent/mobileqq/guild/live/danmu/a;", "Lcom/tencent/mobileqq/guild/live/danmu/a;", "()Lcom/tencent/mobileqq/guild/live/danmu/a;", "liveDanmuManager", "Lhq1/a;", "Lhq1/a;", "()Lhq1/a;", "liveMsgHandler", "Z", "v", "()Z", "isInChannel", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GLiveChannelCore {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GLiveChannelCore f226698a;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f226699b = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(GLiveChannelCore.class, "startParamsInfo", "getStartParamsInfo()Lcom/tencent/mobileqq/guild/live/model/GLiveChannelStartParams;", 0))};

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final uq1.a startParamsInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final tq1.b uiData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final q eventHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final g liveSdkCommMgr;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final qq1.a liveSdkAudienceMgr;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.guild.live.livemanager.anchor.g liveSdkAnchorMgr;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.guild.live.livemanager.anchor.e gameAnchorMgr;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.guild.live.livemanager.player.l livePlayerMgr;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final f roomTypeMgr;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy giftService;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayMap<Class<? extends com.tencent.mobileqq.guild.live.viewmodel.a>, com.tencent.mobileqq.guild.live.viewmodel.a> logicVmMap;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final QQGuildLiveGuestHelper liveGuestHelper;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.guild.live.danmu.a liveDanmuManager;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final hq1.a liveMsgHandler;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private static boolean isInChannel;

    static {
        Lazy lazy;
        GLiveChannelCore gLiveChannelCore = new GLiveChannelCore();
        f226698a = gLiveChannelCore;
        startParamsInfo = new uq1.a();
        uiData = new tq1.b();
        eventHelper = new q(gLiveChannelCore);
        liveSdkCommMgr = new QQGuildLiveRoomCommMgr(gLiveChannelCore);
        liveSdkAudienceMgr = new qq1.b(gLiveChannelCore);
        liveSdkAnchorMgr = new com.tencent.mobileqq.guild.live.livemanager.anchor.g(gLiveChannelCore);
        gameAnchorMgr = new GameLiveAnchorMgr();
        livePlayerMgr = new com.tencent.mobileqq.guild.live.livemanager.player.h();
        roomTypeMgr = new a(gLiveChannelCore);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildLiveGiftService>() { // from class: com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore$giftService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildLiveGiftService invoke() {
                return new GuildLiveGiftService(GLiveChannelCore.f226698a);
            }
        });
        giftService = lazy;
        logicVmMap = new ArrayMap<>(2);
        liveGuestHelper = new QQGuildLiveGuestHelper(gLiveChannelCore);
        liveDanmuManager = new LiveDanmuManager();
        liveMsgHandler = new hq1.a();
    }

    GLiveChannelCore() {
    }

    public static /* synthetic */ void f(GLiveChannelCore gLiveChannelCore, String str, boolean z16, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        gLiveChannelCore.e(str, z16, str2);
    }

    private final boolean u() {
        String str;
        Map<String, String> reportInfoMap;
        GuildAppReportSourceInfo guildAppReportSourceInfo = (GuildAppReportSourceInfo) s().getBundle().getParcelable("GuildAppReportSourceInfo");
        if (guildAppReportSourceInfo != null && (reportInfoMap = guildAppReportSourceInfo.getReportInfoMap()) != null) {
            str = reportInfoMap.get("sgrp_stream_pgin_source_name");
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, "functional_qq_little_world_feed");
    }

    public final void a(@NonNull @NotNull GLiveChannelStartParams startParams) {
        com.tencent.mobileqq.guild.live.viewmodel.h hVar;
        Intrinsics.checkNotNullParameter(startParams, "startParams");
        QLog.i("QGL.GLiveChannelCore", 1, "enterChannel start with " + startParams);
        w(startParams);
        if (!eventHelper.m0(startParams.getGuildId(), startParams.getChannelId())) {
            return;
        }
        if (isInChannel) {
            QLog.i("QGL.GLiveChannelCore", 1, "enterChannel switch channel.");
            com.tencent.mobileqq.guild.live.viewmodel.a aVar = logicVmMap.get(com.tencent.mobileqq.guild.live.viewmodel.h.class);
            if (aVar instanceof com.tencent.mobileqq.guild.live.viewmodel.h) {
                hVar = (com.tencent.mobileqq.guild.live.viewmodel.h) aVar;
            } else {
                hVar = null;
            }
            if (hVar != null) {
                hVar.destroy();
            }
        }
        QLog.i("QGL.GLiveChannelCore", 1, "enterChannel suc.");
        ArrayMap<Class<? extends com.tencent.mobileqq.guild.live.viewmodel.a>, com.tencent.mobileqq.guild.live.viewmodel.a> arrayMap = logicVmMap;
        com.tencent.mobileqq.guild.live.viewmodel.h hVar2 = new com.tencent.mobileqq.guild.live.viewmodel.h();
        hVar2.init();
        arrayMap.put(com.tencent.mobileqq.guild.live.viewmodel.h.class, hVar2);
        com.tencent.mobileqq.guild.live.viewmodel.d dVar = new com.tencent.mobileqq.guild.live.viewmodel.d();
        dVar.init();
        arrayMap.put(com.tencent.mobileqq.guild.live.viewmodel.d.class, dVar);
        isInChannel = true;
        liveGuestHelper.f(startParams.getGuildId(), startParams.getChannelId());
        i().init();
    }

    public final void b(@NotNull String reason) {
        Long longOrNull;
        long j3;
        Long longOrNull2;
        Map mapOf;
        Map mapOf2;
        Intrinsics.checkNotNullParameter(reason, "reason");
        QLog.i("QGL.GLiveChannelCore", 1, "exitChannel start. reason:" + reason);
        if (!isInChannel) {
            return;
        }
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(s().getGuildId());
        long j16 = 0;
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(s().getChannelId());
        if (longOrNull2 != null) {
            j16 = longOrNull2.longValue();
        }
        iGPSService.setEnteredChannelState(j3, j16, false);
        mapOf = MapsKt__MapsJVMKt.mapOf(new Pair("exit_channel_reason", reason));
        com.tencent.mobileqq.guild.performance.report.l.i("live_channel_exit", mapOf, 0, null, 12, null);
        com.tencent.mobileqq.guild.performance.report.l.j();
        com.tencent.mobileqq.guild.performance.report.k.c();
        Collection<com.tencent.mobileqq.guild.live.viewmodel.a> values = logicVmMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "logicVmMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.live.viewmodel.a) it.next()).destroy();
        }
        mapOf2 = MapsKt__MapsJVMKt.mapOf(new Pair("exit_room_reason", reason));
        com.tencent.mobileqq.guild.performance.report.l.i("exit_room", mapOf2, 0, null, 12, null);
        eventHelper.V();
        liveSdkAnchorMgr.w();
        liveSdkAudienceMgr.d();
        liveSdkCommMgr.i();
        com.tencent.mobileqq.guild.live.helper.c.INSTANCE.b();
        livePlayerMgr.e();
        logicVmMap.clear();
        uiData.b();
        w(GLiveChannelStartParams.INSTANCE.g());
        liveGuestHelper.g();
        i().destroy();
        com.tencent.mobileqq.guild.util.h.b(Constants.Business.QQ_GUILD_LIVE_AUTHOR);
        com.tencent.mobileqq.guild.util.h.b(Constants.Business.QQ_GUILD_LIVE_VIEWER);
        liveMsgHandler.a();
        isInChannel = false;
        QLog.i("QGL.GLiveChannelCore", 1, "exitChannel end.");
    }

    @JvmOverloads
    public final void c(@NotNull String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        f(this, reason, false, null, 6, null);
    }

    @JvmOverloads
    public final void d(@NotNull String reason, boolean z16) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        f(this, reason, z16, null, 4, null);
    }

    @JvmOverloads
    public final void e(@NotNull String reason, boolean needEndLiveInfo, @Nullable String programId) {
        String str;
        boolean z16;
        Map mapOf;
        LiveChannelRoomInfo value;
        Intrinsics.checkNotNullParameter(reason, "reason");
        tq1.b bVar = uiData;
        LiveChannelRoomInfo value2 = bVar.p().getValue();
        if (value2 != null) {
            str = value2.getProgramId();
        } else {
            str = null;
        }
        QLog.i("QGL.GLiveChannelCore", 1, "exitLiveRoom. reason:" + reason + ", programId:" + programId + ", cur programId:" + str);
        com.tencent.mobileqq.guild.live.livemanager.anchor.g gVar = liveSdkAnchorMgr;
        String G = gVar.G();
        qq1.a aVar = liveSdkAudienceMgr;
        String c16 = aVar.c();
        if (programId != null && programId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !Intrinsics.areEqual(programId, G) && !Intrinsics.areEqual(programId, c16)) {
            QLog.e("QGL.GLiveChannelCore", 1, "programId is invalid, anchor:" + G + ",audience:" + c16);
            livePlayerMgr.b(GuildLivePlayerTag.LIVE);
            return;
        }
        LiveData<Boolean> n3 = bVar.n();
        int liveType = s().getLiveType();
        Boolean value3 = bVar.D().getValue();
        Boolean bool = Boolean.TRUE;
        mapOf = MapsKt__MapsJVMKt.mapOf(new Pair("exit_room_reason", reason + " isEnterRoomSuc:" + n3 + " liveType:" + liveType + " isAnchor:" + Intrinsics.areEqual(value3, bool)));
        com.tencent.mobileqq.guild.performance.report.l.i("exit_room", mapOf, 0, null, 12, null);
        if (Intrinsics.areEqual(bVar.n().getValue(), bool)) {
            if (s().getLiveType() == 0 && Intrinsics.areEqual(bVar.D().getValue(), bool) && !roomTypeMgr.b()) {
                gVar.w();
            } else {
                aVar.d();
            }
            if (needEndLiveInfo && (value = bVar.p().getValue()) != null) {
                liveSdkCommMgr.j(value.getRoomId(), value.getProgramId());
            }
        } else {
            gVar.w();
            aVar.d();
        }
        livePlayerMgr.b(GuildLivePlayerTag.LIVE);
        bVar.c();
    }

    @NotNull
    public final q g() {
        return eventHelper;
    }

    @NotNull
    public final com.tencent.mobileqq.guild.live.livemanager.anchor.e h() {
        return gameAnchorMgr;
    }

    @NotNull
    public final com.tencent.mobileqq.guild.live.livemanager.gift.h i() {
        return (com.tencent.mobileqq.guild.live.livemanager.gift.h) giftService.getValue();
    }

    @NotNull
    public final com.tencent.mobileqq.guild.live.danmu.a j() {
        return liveDanmuManager;
    }

    @NotNull
    public final QQGuildLiveGuestHelper k() {
        return liveGuestHelper;
    }

    @NotNull
    public final hq1.a l() {
        return liveMsgHandler;
    }

    @NotNull
    public final com.tencent.mobileqq.guild.live.livemanager.player.l m() {
        return livePlayerMgr;
    }

    @NotNull
    public final com.tencent.mobileqq.guild.live.livemanager.anchor.g n() {
        return liveSdkAnchorMgr;
    }

    @NotNull
    public final qq1.a o() {
        return liveSdkAudienceMgr;
    }

    @NotNull
    public final g p() {
        return liveSdkCommMgr;
    }

    @NotNull
    public final <T extends com.tencent.mobileqq.guild.live.viewmodel.a> T q(@NotNull Class<? extends T> clz) {
        Intrinsics.checkNotNullParameter(clz, "clz");
        ArrayMap<Class<? extends com.tencent.mobileqq.guild.live.viewmodel.a>, com.tencent.mobileqq.guild.live.viewmodel.a> arrayMap = logicVmMap;
        if (arrayMap.get(clz) == null) {
            arrayMap.put(clz, clz.newInstance());
        }
        com.tencent.mobileqq.guild.live.viewmodel.a aVar = arrayMap.get(clz);
        Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type T of com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore.getLogicVM");
        return (T) aVar;
    }

    @NotNull
    public final f r() {
        return roomTypeMgr;
    }

    @NotNull
    public final GLiveChannelStartParams s() {
        return startParamsInfo.a(this, f226699b[0]);
    }

    @NotNull
    public final tq1.b t() {
        return uiData;
    }

    public final boolean v() {
        return isInChannel;
    }

    public final void w(@NotNull GLiveChannelStartParams gLiveChannelStartParams) {
        Intrinsics.checkNotNullParameter(gLiveChannelStartParams, "<set-?>");
        startParamsInfo.b(this, f226699b[0], gLiveChannelStartParams);
    }

    public final boolean x() {
        boolean z16;
        boolean z17;
        tq1.b bVar = uiData;
        GLiveOutPlayerInfo q16 = bVar.q();
        if (q16 != null) {
            String channelId = q16.getChannelId();
            GLiveChannelCore gLiveChannelCore = f226698a;
            if (Intrinsics.areEqual(channelId, gLiveChannelCore.s().getChannelId()) && Intrinsics.areEqual(q16.getGuildId(), gLiveChannelCore.s().getGuildId())) {
                z16 = true;
                if (!z16 && u()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                bVar.d0(z17);
                if (!z16 && u()) {
                    return true;
                }
                return false;
            }
        }
        z16 = false;
        if (!z16) {
        }
        z17 = false;
        bVar.d0(z17);
        if (!z16) {
        }
        return false;
    }
}

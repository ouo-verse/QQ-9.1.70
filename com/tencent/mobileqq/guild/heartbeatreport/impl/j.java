package com.tencent.mobileqq.guild.heartbeatreport.impl;

import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildOnlineReportRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.cf;
import com.tencent.mobileqq.qqguildsdk.data.genc.cm;
import com.tencent.mobileqq.qqguildsdk.data.genc.cn;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.es;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019Jp\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\f\u001a\u00020\u00062(\b\u0002\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u000eH\u0002Jh\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062&\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u000eH\u0002Jn\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\f\u001a\u00020\u00062(\b\u0002\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/heartbeatreport/impl/j;", "", "", "guildId", "channelId", "logTag", "", "scene", "Lkotlin/Function1;", "", "", Method.POST, "fromPageId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "reportMap", "c", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "service", "", "isGuest", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/cn;", "e", "f", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f224700a = new j();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/heartbeatreport/impl/j$a;", "", "", JumpGuildParam.EXTRA_KEY_CHANNEL_OPEN_SOURCE, "", "fromGuildTab", "a", "(Ljava/lang/Integer;Z)I", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f224701a = new a();

        a() {
        }

        public final int a(@Nullable Integer channelOpenSource, boolean fromGuildTab) {
            if (channelOpenSource != null && channelOpenSource.intValue() == 1) {
                return 1;
            }
            if (channelOpenSource != null && channelOpenSource.intValue() == 2) {
                return 1;
            }
            return 0;
        }
    }

    j() {
    }

    private final void c(final String guildId, final String channelId, final String logTag, int scene, final Function1<? super Long, Unit> post, final int fromPageId, HashMap<String, String> reportMap) {
        try {
            final boolean j06 = ch.j0(guildId);
            IGPSService service = (IGPSService) ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(service, "service");
            service.userOnlineReport(e(service, Long.parseLong(guildId), Long.parseLong(channelId), j06, logTag, scene, fromPageId, reportMap), new es() { // from class: com.tencent.mobileqq.guild.heartbeatreport.impl.i
                @Override // wh2.es
                public final void a(int i3, String str, IGProGuildOnlineReportRsp iGProGuildOnlineReportRsp) {
                    j.d(Function1.this, logTag, guildId, channelId, fromPageId, j06, i3, str, iGProGuildOnlineReportRsp);
                }
            });
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "[reportInternal] exception:" + e16.getStackTrace();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(logTag, 1, (String) it.next(), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 post, String logTag, String guildId, String channelId, int i3, boolean z16, int i16, String str, IGProGuildOnlineReportRsp iGProGuildOnlineReportRsp) {
        Intrinsics.checkNotNullParameter(post, "$post");
        Intrinsics.checkNotNullParameter(logTag, "$logTag");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        if (iGProGuildOnlineReportRsp.getNextReportInterval() <= 0) {
            post.invoke(600L);
        } else {
            post.invoke(Long.valueOf(iGProGuildOnlineReportRsp.getNextReportInterval()));
        }
        Logger.f235387a.d().i(logTag, 1, "[reportInternal] succ guildId:" + guildId + ", channelId:" + channelId + " fromPageId\uff1a" + i3 + ", isGuest:" + z16);
        if (i16 != 0) {
            Logger.b bVar = new Logger.b();
            String str2 = "[reportInternal] failed, result:" + i16 + ", errMsg:" + str + ", guildId:" + guildId + ", channelId:" + channelId;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(logTag, 1, (String) it.next(), null);
            }
        }
    }

    private final cn e(IGPSService service, long guildId, long channelId, boolean isGuest, String logTag, int scene, int fromPageId, HashMap<String, String> reportMap) {
        String str;
        Set<String> keySet;
        FrameFragment.d dVar;
        cn cnVar = new cn();
        String selfTinyId = service.getSelfTinyId();
        Intrinsics.checkNotNullExpressionValue(selfTinyId, "service.selfTinyId");
        cnVar.o(Long.parseLong(selfTinyId));
        cnVar.m(scene);
        cnVar.k(fromPageId);
        FrameFragment mainFragment = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getMainFragment(QBaseActivity.sTopActivity);
        String name = ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getGuildMainFrameClass().getName();
        if (mainFragment != null && (dVar = mainFragment.mTabIndicator) != null) {
            str = dVar.getCurrentTabTag();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(name, str)) {
            cnVar.i(1);
        } else {
            cnVar.i(0);
        }
        ArrayList<cf> arrayList = new ArrayList<>();
        cf cfVar = new cf();
        cfVar.d(guildId);
        if (channelId != 0) {
            ArrayList<Long> arrayList2 = new ArrayList<>();
            arrayList2.add(Long.valueOf(channelId));
            cfVar.c(arrayList2);
        }
        arrayList.add(cfVar);
        cnVar.j(arrayList);
        cnVar.l(isGuest);
        cnVar.n(0);
        Logger.f235387a.d().i(logTag, 1, "[getReq] tinyId:" + cnVar.h() + ", scene:" + cnVar.f() + ", activeTab:" + cnVar.a() + ", isGuest:" + cnVar.e() + ", sourceType:" + cnVar.g() + " fromPageId:" + cnVar.d());
        if (reportMap != null && (keySet = reportMap.keySet()) != null) {
            for (String str2 : keySet) {
                ArrayList<cm> c16 = cnVar.c();
                cm cmVar = new cm();
                cmVar.c(str2);
                cmVar.d(reportMap.get(str2));
                c16.add(cmVar);
            }
        }
        return cnVar;
    }

    public static /* synthetic */ void g(j jVar, String str, String str2, String str3, int i3, Function1 function1, int i16, HashMap hashMap, int i17, Object obj) {
        int i18;
        HashMap hashMap2;
        if ((i17 & 32) != 0) {
            i18 = 0;
        } else {
            i18 = i16;
        }
        if ((i17 & 64) != 0) {
            hashMap2 = null;
        } else {
            hashMap2 = hashMap;
        }
        jVar.f(str, str2, str3, i3, function1, i18, hashMap2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(String guildId, String channelId, String logTag, int i3, Function1 post, int i16, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        Intrinsics.checkNotNullParameter(logTag, "$logTag");
        Intrinsics.checkNotNullParameter(post, "$post");
        f224700a.c(guildId, channelId, logTag, i3, post, i16, hashMap);
    }

    public final void f(@NotNull final String guildId, @NotNull final String channelId, @NotNull final String logTag, final int scene, @NotNull final Function1<? super Long, Unit> post, final int fromPageId, @Nullable final HashMap<String, String> reportMap) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        Intrinsics.checkNotNullParameter(post, "post");
        if (fromPageId == 1) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.heartbeatreport.impl.h
                @Override // java.lang.Runnable
                public final void run() {
                    j.h(guildId, channelId, logTag, scene, post, fromPageId, reportMap);
                }
            }, 50L);
        } else {
            c(guildId, channelId, logTag, scene, post, fromPageId, reportMap);
        }
    }
}

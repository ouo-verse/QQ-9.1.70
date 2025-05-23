package com.tencent.mobileqq.guild.heartbeatreport.impl;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildOnlineReportRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.cn;
import com.tencent.util.UiThreadUtil;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.es;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010\u001eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u001e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ#\u0010\u0014\u001a\u00020\u0004\"\f\b\u0000\u0010\u0012*\u00020\u0010*\u00020\u00112\u0006\u0010\u0013\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u00020\u0004\"\f\b\u0000\u0010\u0012*\u00020\u0010*\u00020\u00112\u0006\u0010\u0013\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0015R*\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0017\u0010\u0018\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\"\u0010)\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/heartbeatreport/impl/FacadeFragmentOnlineReportHelper;", "", "", "guildId", "", "j", "d", tl.h.F, "", "nextReportInterval", "i", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gproService", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/cn;", "req", "l", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/tencent/mobileqq/guild/homev2/misc/d;", "T", "receiver", "f", "(Landroidx/lifecycle/LifecycleOwner;)V", "g", "b", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "getGuildId$annotations", "()V", "Lkotlin/Pair;", "c", "Lkotlin/Pair;", "guildIdToNextReportInterval", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "getReportRunnable", "()Ljava/lang/Runnable;", "setReportRunnable", "(Ljava/lang/Runnable;)V", "reportRunnable", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FacadeFragmentOnlineReportHelper {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String guildId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Pair<String, Long> guildIdToNextReportInterval;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FacadeFragmentOnlineReportHelper f224676a = new FacadeFragmentOnlineReportHelper();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Runnable reportRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.heartbeatreport.impl.b
        @Override // java.lang.Runnable
        public final void run() {
            FacadeFragmentOnlineReportHelper.k();
        }
    };

    FacadeFragmentOnlineReportHelper() {
    }

    @JvmStatic
    public static final void d(@Nullable String guildId2) {
        boolean z16;
        UiThreadUtil.remove(reportRunnable);
        guildId = guildId2;
        if (guildId2 != null && guildId2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        String str = null;
        if (z16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "[delayReportResume] param invalid guildId:" + guildId2;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.report.online.FacadeFragmentOnlineReportHelper", 1, (String) it.next(), null);
            }
            return;
        }
        Logger.f235387a.d().i("Guild.report.online.FacadeFragmentOnlineReportHelper", 1, "[delayReportResume] guildId:" + guildId2);
        Pair<String, Long> pair = guildIdToNextReportInterval;
        if (pair != null) {
            str = pair.getFirst();
        }
        if (Intrinsics.areEqual(str, guildId2)) {
            Pair<String, Long> pair2 = guildIdToNextReportInterval;
            Intrinsics.checkNotNull(pair2);
            if (pair2.getSecond().longValue() > 0) {
                FacadeFragmentOnlineReportHelper facadeFragmentOnlineReportHelper = f224676a;
                Pair<String, Long> pair3 = guildIdToNextReportInterval;
                Intrinsics.checkNotNull(pair3);
                facadeFragmentOnlineReportHelper.i(pair3.getSecond().longValue());
                return;
            }
        }
        f224676a.i(600L);
    }

    @Nullable
    public static final String e() {
        return guildId;
    }

    @JvmStatic
    public static final void h() {
        Logger.f235387a.d().d("Guild.report.online.FacadeFragmentOnlineReportHelper", 1, "pause guildId:" + e());
        UiThreadUtil.remove(reportRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(long nextReportInterval) {
        Logger.f235387a.d().d("Guild.report.online.FacadeFragmentOnlineReportHelper", 1, "[postDelay] guildId:" + e() + ", nextReportInterval:" + nextReportInterval);
        UiThreadUtil.runOnUiThread(reportRunnable, nextReportInterval * ((long) 1000));
    }

    @JvmStatic
    public static final void j(@Nullable String guildId2) {
        boolean z16;
        UiThreadUtil.remove(reportRunnable);
        guildId = guildId2;
        Logger.f235387a.d().i("Guild.report.online.FacadeFragmentOnlineReportHelper", 1, "[reportResume] guildId:" + guildId2);
        if (guildId2 != null && guildId2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Logger.b bVar = new Logger.b();
            String str = "[reportResume] param invalid guildId:" + guildId2;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.report.online.FacadeFragmentOnlineReportHelper", 1, (String) it.next(), null);
            }
            return;
        }
        j.g(j.f224700a, guildId2, "0", "Guild.report.online.FacadeFragmentOnlineReportHelper", 1, new FacadeFragmentOnlineReportHelper$reportResume$3(f224676a), 0, null, 96, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k() {
        boolean z16;
        String str = guildId;
        Logger.f235387a.d().i("Guild.report.online.FacadeFragmentOnlineReportHelper", 1, "[postDelay] guildId:" + str);
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Logger.b bVar = new Logger.b();
            String str2 = "[postDelay] param invalid guildId:" + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.report.online.FacadeFragmentOnlineReportHelper", 1, (String) it.next(), null);
            }
            return;
        }
        j.g(j.f224700a, str, "0", "Guild.report.online.FacadeFragmentOnlineReportHelper", 1, new FacadeFragmentOnlineReportHelper$reportRunnable$1$3(f224676a), 0, null, 96, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(String guildId2, int i3, String str, IGProGuildOnlineReportRsp iGProGuildOnlineReportRsp) {
        Intrinsics.checkNotNullParameter(guildId2, "$guildId");
        Logger.f235387a.d().i("Guild.report.online.FacadeFragmentOnlineReportHelper", 1, "userOnlineReport result:" + i3 + " errMsg:" + str + " nextReportInterval:" + iGProGuildOnlineReportRsp.getNextReportInterval());
        guildIdToNextReportInterval = new Pair<>(guildId2, Long.valueOf(iGProGuildOnlineReportRsp.getNextReportInterval()));
    }

    public final <T extends LifecycleOwner & com.tencent.mobileqq.guild.homev2.misc.d> void f(@NotNull final T receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        receiver.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.heartbeatreport.impl.FacadeFragmentOnlineReportHelper$install$1

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes13.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f224681a;

                static {
                    int[] iArr = new int[Lifecycle.Event.values().length];
                    try {
                        iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f224681a = iArr;
                }
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                int i3 = a.f224681a[event.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            source.getLifecycle().removeObserver(this);
                            return;
                        }
                        return;
                    }
                    FacadeFragmentOnlineReportHelper.h();
                    return;
                }
                FacadeFragmentOnlineReportHelper.j(((com.tencent.mobileqq.guild.homev2.misc.d) LifecycleOwner.this).getGuildId());
            }
        });
    }

    public final <T extends LifecycleOwner & com.tencent.mobileqq.guild.homev2.misc.d> void g(@NotNull T receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        h();
        j(receiver.getGuildId());
    }

    public final void l(@NotNull IGPSService gproService, @NotNull final String guildId2, @NotNull cn req) {
        Intrinsics.checkNotNullParameter(gproService, "gproService");
        Intrinsics.checkNotNullParameter(guildId2, "guildId");
        Intrinsics.checkNotNullParameter(req, "req");
        gproService.userOnlineReport(req, new es() { // from class: com.tencent.mobileqq.guild.heartbeatreport.impl.c
            @Override // wh2.es
            public final void a(int i3, String str, IGProGuildOnlineReportRsp iGProGuildOnlineReportRsp) {
                FacadeFragmentOnlineReportHelper.m(guildId2, i3, str, iGProGuildOnlineReportRsp);
            }
        });
    }
}

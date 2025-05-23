package ap0;

import androidx.core.util.Consumer;
import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildConfigApi;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPlusPanelFeature;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPlusPanelReq;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPlusPanelRsp;
import com.tencent.qqnt.kernel.nativeinterface.IFetchGuildRobotPlusPanelCallback;
import com.tencent.rmonitor.base.config.data.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0014\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005H\u0002J\u0010\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ4\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005J\u0006\u0010\u0011\u001a\u00020\t\u00a8\u0006\u0015"}, d2 = {"Lap0/e;", "", "", "guildId", "channelId", "Landroidx/core/util/Consumer;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotPlusPanelFeature;", "consumer", "", "d", "Lcom/tencent/aio/data/AIOParam;", "aioParam", h.F, "", "fromCacheOnly", "g", "i", "<init>", "()V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static List<GProGuildRobotPlusPanelFeature> f26659b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R*\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lap0/e$a;", "", "", "guildId", "", "b", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotPlusPanelFeature;", k.FEATURES_KEY, "Ljava/util/List;", "a", "()Ljava/util/List;", "setFeatures", "(Ljava/util/List;)V", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ap0.e$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final List<GProGuildRobotPlusPanelFeature> a() {
            return e.f26659b;
        }

        public final boolean b(@NotNull String guildId) {
            boolean z16;
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            boolean showRobotButtonInAddPanel = ((IGuildConfigApi) QRoute.api(IGuildConfigApi.class)).getShowRobotButtonInAddPanel();
            Set<String> showRobotCommandGuildList = ((IGuildConfigApi) QRoute.api(IGuildConfigApi.class)).getShowRobotCommandGuildList();
            if (!showRobotCommandGuildList.isEmpty() && !showRobotCommandGuildList.contains(guildId)) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!showRobotButtonInAddPanel || !z16) {
                return false;
            }
            return true;
        }

        Companion() {
        }
    }

    private final void d(String guildId, String channelId, final Consumer<List<GProGuildRobotPlusPanelFeature>> consumer) {
        AppInterface appInterface;
        ac robotService;
        Long longOrNull;
        long j3;
        Long longOrNull2;
        long j16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IKernelService.class, "");
        }
        IKernelService iKernelService = (IKernelService) iRuntimeService;
        if (iKernelService != null && (robotService = iKernelService.getRobotService()) != null) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(guildId);
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(channelId);
            if (longOrNull2 != null) {
                j16 = longOrNull2.longValue();
            } else {
                j16 = 0;
            }
            robotService.fetchGuildRobotPlusPanel(new GProGuildRobotPlusPanelReq(j3, j16, 0, 0, ((IGuildRobotUtilApi) QRoute.api(IGuildRobotUtilApi.class)).getGuildRobotClientInfo(), 0), new IFetchGuildRobotPlusPanelCallback() { // from class: ap0.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IFetchGuildRobotPlusPanelCallback
                public final void onResult(int i3, String str, GProGuildRobotPlusPanelRsp gProGuildRobotPlusPanelRsp) {
                    e.e(Consumer.this, i3, str, gProGuildRobotPlusPanelRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final Consumer consumer, final int i3, final String str, final GProGuildRobotPlusPanelRsp gProGuildRobotPlusPanelRsp) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ap0.d
            @Override // java.lang.Runnable
            public final void run() {
                e.f(i3, gProGuildRobotPlusPanelRsp, str, consumer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(int i3, GProGuildRobotPlusPanelRsp gProGuildRobotPlusPanelRsp, String str, Consumer consumer) {
        List emptyList;
        if (i3 == 0 && gProGuildRobotPlusPanelRsp != null) {
            ArrayList<GProGuildRobotPlusPanelFeature> arrayList = gProGuildRobotPlusPanelRsp.plusPanelFeatures;
            f26659b = arrayList;
            if (consumer != null) {
                consumer.accept(arrayList);
                return;
            }
            return;
        }
        QLog.e("PlusPanelRobotDataHelper", 1, "fetchGuildRobotPlusPanel|result=" + i3 + ", errMsg=" + str);
        if (consumer != null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            consumer.accept(emptyList);
        }
    }

    public final void g(@NotNull String guildId, @NotNull String channelId, boolean fromCacheOnly, @Nullable Consumer<List<GProGuildRobotPlusPanelFeature>> consumer) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        List<GProGuildRobotPlusPanelFeature> list = f26659b;
        if (list != null && consumer != null) {
            consumer.accept(list);
        }
        if (!fromCacheOnly) {
            d(guildId, channelId, consumer);
        }
    }

    public final void h(@Nullable AIOParam aioParam) {
        if (aioParam != null && !com.tencent.guild.aio.util.a.j(aioParam)) {
            Integer d16 = com.tencent.guild.aio.util.a.d(aioParam);
            if (d16 == null || d16.intValue() != 2) {
                d(com.tencent.guild.aio.util.a.g(aioParam), com.tencent.guild.aio.util.a.b(aioParam), null);
            }
        }
    }

    public final void i() {
        f26659b = null;
    }
}

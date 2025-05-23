package com.tencent.mobileqq.guild.message.unread.api.impl;

import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.message.unread.api.IGuildTotalUnreadService;
import com.tencent.mobileqq.guild.message.unread.api.Source;
import com.tencent.mobileqq.guild.message.unread.api.TotalUnreadCount;
import com.tencent.mobileqq.guild.message.unread.api.impl.GuildTotalUnreadServiceImpl;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.EnumMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Function0;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001b\u001cB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/message/unread/api/impl/GuildTotalUnreadServiceImpl;", "Lcom/tencent/mobileqq/guild/message/unread/api/IGuildTotalUnreadService;", "Lmqq/app/AppRuntime;", "appRuntime", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/message/unread/api/d;", "callback", "registerGuildTabUnreadCallback", "unRegisterGuildTabUnreadCallback", "Lcom/tencent/mobileqq/guild/message/unread/api/g;", "getTotalCount", "Lcom/tencent/mobileqq/guild/message/unread/api/Source;", "source", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "getUnreadCount", "getGuildTabUnreadCount", "Ljava/util/concurrent/CopyOnWriteArrayList;", "guildTabUnreadCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/guild/message/unread/api/impl/GuildTotalUnreadServiceImpl$InnerUnreadStore;", "innerUnreadStore", "Lcom/tencent/mobileqq/guild/message/unread/api/impl/GuildTotalUnreadServiceImpl$InnerUnreadStore;", "<init>", "()V", "Companion", "a", "InnerUnreadStore", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildTotalUnreadServiceImpl implements IGuildTotalUnreadService {

    @NotNull
    private static final String TAG = "Guild.GSC.GuildTotalUnreadServiceImpl";

    @NotNull
    private final CopyOnWriteArrayList<com.tencent.mobileqq.guild.message.unread.api.d> guildTabUnreadCallbacks = new CopyOnWriteArrayList<>();

    @NotNull
    private final InnerUnreadStore innerUnreadStore = new InnerUnreadStore();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\t\u001a\u00020\bH\u0016R,\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/message/unread/api/impl/GuildTotalUnreadServiceImpl$InnerUnreadStore;", "", "Lcom/tencent/mobileqq/guild/message/unread/api/g;", "d", "Lcom/tencent/mobileqq/guild/message/unread/api/Source;", "source", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "c", "", "toString", "Ljava/util/EnumMap;", "Lkotlin/Pair;", "", "a", "Ljava/util/EnumMap;", "counts", "b", "Lcom/tencent/mobileqq/guild/message/unread/api/g;", "totalUnreadCount", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "changed", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class InnerUnreadStore {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final EnumMap<Source, Pair<Integer, Integer>> counts = new EnumMap<>(Source.class);

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private TotalUnreadCount totalUnreadCount = new TotalUnreadCount(new UnreadInfo.a(false, 0, 0, 7, null), new UnreadInfo.a(false, 0, 0, 7, null));

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private AtomicBoolean changed = new AtomicBoolean(false);

        @NotNull
        public final UnreadInfo.a c(@NotNull Source source) {
            Intrinsics.checkNotNullParameter(source, "source");
            Pair<Integer, Integer> pair = this.counts.get(source);
            if (pair == null) {
                pair = TuplesKt.to(0, 0);
            }
            Intrinsics.checkNotNullExpressionValue(pair, "counts[source] ?: (0 to 0)");
            return UnreadInfo.a.INSTANCE.a(pair);
        }

        @NotNull
        public final TotalUnreadCount d() {
            if (this.changed.get()) {
                synchronized (this) {
                    if (this.changed.compareAndSet(true, false)) {
                        this.totalUnreadCount = new TotalUnreadCount(new UnreadInfo.a(false, 0, 0, 7, null), new UnreadInfo.a(false, 0, 0, 7, null));
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d(GuildTotalUnreadServiceImpl.TAG, "getTotalCount totalUnreadCount:" + this.totalUnreadCount);
            }
            return this.totalUnreadCount;
        }

        @NotNull
        public String toString() {
            String joinToString$default;
            joinToString$default = ArraysKt___ArraysKt.joinToString$default(Source.values(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<Source, CharSequence>() { // from class: com.tencent.mobileqq.guild.message.unread.api.impl.GuildTotalUnreadServiceImpl$InnerUnreadStore$toString$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull Source it) {
                    EnumMap enumMap;
                    Intrinsics.checkNotNullParameter(it, "it");
                    String name = it.name();
                    enumMap = GuildTotalUnreadServiceImpl.InnerUnreadStore.this.counts;
                    return name + ContainerUtils.KEY_VALUE_DELIMITER + enumMap.get(it);
                }
            }, 31, (Object) null);
            return joinToString$default;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2() {
        yr1.c cVar = yr1.c.f451055d;
        com.tencent.mobileqq.guild.report.d.f232012a.e("GuildTotalUnreadServiceImpl onCreate");
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildTotalUnreadService
    @NotNull
    public UnreadInfo.a getGuildTabUnreadCount() {
        TotalUnreadCount totalCount = getTotalCount();
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d(TAG, "getGuildTabUnreadCount totalCnt:" + totalCount);
        }
        return totalCount.getTab();
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildTotalUnreadService
    @NotNull
    public TotalUnreadCount getTotalCount() {
        return this.innerUnreadStore.d();
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildTotalUnreadService
    @NotNull
    public UnreadInfo.a getUnreadCount(@NotNull Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return this.innerUnreadStore.c(source);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d(TAG, 1, "onCreate");
        }
        Function0.b(5000, new Runnable() { // from class: com.tencent.mobileqq.guild.message.unread.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildTotalUnreadServiceImpl.onCreate$lambda$2();
            }
        });
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.guildTabUnreadCallbacks.clear();
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildTotalUnreadService
    public void registerGuildTabUnreadCallback(@NotNull com.tencent.mobileqq.guild.message.unread.api.d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.guildTabUnreadCallbacks.addIfAbsent(callback);
    }

    @Override // com.tencent.mobileqq.guild.message.unread.api.IGuildTotalUnreadService
    public void unRegisterGuildTabUnreadCallback(@NotNull com.tencent.mobileqq.guild.message.unread.api.d callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.guildTabUnreadCallbacks.remove(callback);
    }
}

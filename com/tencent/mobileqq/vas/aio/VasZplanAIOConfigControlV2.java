package com.tencent.mobileqq.vas.aio;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.lyric.common.TimerTaskManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\n\u0018\u0000 \u00192\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\u000f\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\"\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/aio/VasZplanAIOConfigControlV2;", "Lcom/tencent/mobileqq/vas/aio/b;", "", "friendUin", "", "c", "uin", "Lcom/tencent/mobileqq/vas/data/h;", "data", "", "d", "a", "Lcom/tencent/mobileqq/lyric/common/TimerTaskManager;", "kotlin.jvm.PlatformType", "Lcom/tencent/mobileqq/lyric/common/TimerTaskManager;", "taskManager", "", "b", "Ljava/util/Map;", "configMap", "J", "curFriendUin", "timeMap", "<init>", "()V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class VasZplanAIOConfigControlV2 implements b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Lazy<VasZplanAIOConfigControlV2> f308351f;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long curFriendUin;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final TimerTaskManager taskManager = com.tencent.mobileqq.lyric.util.a.b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<Long, com.tencent.mobileqq.vas.data.h> configMap = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Map<Long, Long> timeMap = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/aio/VasZplanAIOConfigControlV2$a;", "", "Lcom/tencent/mobileqq/vas/aio/VasZplanAIOConfigControlV2;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/vas/aio/VasZplanAIOConfigControlV2;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.aio.VasZplanAIOConfigControlV2$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VasZplanAIOConfigControlV2 a() {
            return (VasZplanAIOConfigControlV2) VasZplanAIOConfigControlV2.f308351f.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<VasZplanAIOConfigControlV2> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<VasZplanAIOConfigControlV2>() { // from class: com.tencent.mobileqq.vas.aio.VasZplanAIOConfigControlV2$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VasZplanAIOConfigControlV2 invoke() {
                return new VasZplanAIOConfigControlV2();
            }
        });
        f308351f = lazy;
    }

    @Override // com.tencent.mobileqq.vas.aio.b
    public com.tencent.mobileqq.vas.data.h a(long friendUin) {
        return this.configMap.get(Long.valueOf(friendUin));
    }

    public boolean c(long friendUin) {
        Long l3;
        com.tencent.mobileqq.vas.data.h hVar = this.configMap.get(Long.valueOf(friendUin));
        if (hVar == null) {
            return true;
        }
        Long l16 = this.timeMap.get(Long.valueOf(friendUin));
        if (l16 != null) {
            l3 = Long.valueOf(NetConnInfoCenter.getServerTime() - l16.longValue());
        } else {
            l3 = null;
        }
        if (l3 != null) {
            l3.longValue();
            if (l3.longValue() < hVar.getCom.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData.INTERVAL java.lang.String() || hVar.getCom.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData.INTERVAL java.lang.String() == 0) {
                QLog.i("VasZplanAIOConfigControlV2", 1, " aio stay time: " + l3);
                return false;
            }
        }
        return true;
    }

    public void d(long uin, com.tencent.mobileqq.vas.data.h data) {
        this.curFriendUin = uin;
        this.configMap.put(Long.valueOf(uin), data);
        if (data != null) {
            this.timeMap.put(Long.valueOf(uin), Long.valueOf(NetConnInfoCenter.getServerTime()));
        }
    }
}

package com.tencent.qqperf.monitor.message.config;

import com.google.gson.Gson;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qqperf.monitor.message.SyncBarrierLeakFix;
import com.tencent.qqperf.monitor.message.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqperf/monitor/message/config/BarrierConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/qqperf/monitor/message/SyncBarrierLeakFix$SyncBarrierLeakFixConfig;", "b", "", "content", "c", "", "success", "", "onReceive", "<init>", "()V", "d", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class BarrierConfigParser extends BaseConfigParser<SyncBarrierLeakFix.SyncBarrierLeakFixConfig> {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f363283e = "105898";

    /* renamed from: f, reason: collision with root package name */
    private static final int f363284f = 50000;

    /* renamed from: h, reason: collision with root package name */
    private static final int f363285h = 2500;

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SyncBarrierLeakFix.SyncBarrierLeakFixConfig defaultConfig() {
        return new SyncBarrierLeakFix.SyncBarrierLeakFixConfig();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public SyncBarrierLeakFix.SyncBarrierLeakFixConfig parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        SyncBarrierLeakFix.SyncBarrierLeakFixConfig config = (SyncBarrierLeakFix.SyncBarrierLeakFixConfig) new Gson().fromJson(new String(content, Charsets.UTF_8), SyncBarrierLeakFix.SyncBarrierLeakFixConfig.class);
        int i3 = config.timeout;
        int i16 = f363284f;
        if (i3 < i16) {
            config.timeout = i16;
        }
        int i17 = config.checkTick;
        int i18 = f363285h;
        if (i17 < i18) {
            config.checkTick = i18;
        }
        Intrinsics.checkNotNullExpressionValue(config, "config");
        return config;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onReceive(boolean success) {
        SyncBarrierLeakFix.SyncBarrierLeakFixConfig syncBarrierLeakFixConfig;
        if (!Utils.K() && (syncBarrierLeakFixConfig = (SyncBarrierLeakFix.SyncBarrierLeakFixConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(f363283e)) != null && syncBarrierLeakFixConfig.enable) {
            b.a().b(syncBarrierLeakFixConfig);
        }
    }
}

package com.tencent.mobileqq.qqguildsdk.manager;

import com.tencent.mobileqq.qqguildsdk.data.bg;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/manager/f;", "", "", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/bg;", "c", "categoryId", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", "a", "channelId", "b", "Lcom/tencent/mobileqq/qqguildsdk/engine/GPSManagerEngine;", "Lcom/tencent/mobileqq/qqguildsdk/engine/GPSManagerEngine;", "mEngine", "Ljava/lang/String;", "TAG", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/engine/GPSManagerEngine;)V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GPSManagerEngine mEngine;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    public f(@NotNull GPSManagerEngine mEngine) {
        Intrinsics.checkNotNullParameter(mEngine, "mEngine");
        this.mEngine = mEngine;
        this.TAG = "PermissionMgr";
    }

    @NotNull
    public final dx a(@NotNull String guildId, @NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        bg Se = this.mEngine.Se(guildId, categoryId);
        Intrinsics.checkNotNullExpressionValue(Se, "mEngine.getCategoryPermission(guildId, categoryId)");
        return Se;
    }

    @NotNull
    public final dx b(@NotNull String guildId, @NotNull String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        bg Xe = this.mEngine.Xe(guildId, channelId);
        Intrinsics.checkNotNullExpressionValue(Xe, "mEngine.getChannelPermission(guildId, channelId)");
        return Xe;
    }

    @NotNull
    public final bg c(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        bg nf5 = this.mEngine.nf(guildId);
        Intrinsics.checkNotNullExpressionValue(nf5, "mEngine.getGuildPermission(guildId)");
        return nf5;
    }
}

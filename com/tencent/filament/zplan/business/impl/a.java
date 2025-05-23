package com.tencent.filament.zplan.business.impl;

import com.tencent.filament.zplan.animation.ZPlanAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u0003\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\f\u0010\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/filament/zplan/business/impl/a;", "", "", "a", "Ljava/lang/String;", "getBootString", "()Ljava/lang/String;", "bootString", "b", "avatarString", "", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "c", "[Lcom/tencent/filament/zplan/animation/ZPlanAction;", "()[Lcom/tencent/filament/zplan/animation/ZPlanAction;", "actionArray", "d", "indirectLightPath", "<init>", "(Ljava/lang/String;Ljava/lang/String;[Lcom/tencent/filament/zplan/animation/ZPlanAction;Ljava/lang/String;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String bootString;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String avatarString;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ZPlanAction[] actionArray;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String indirectLightPath;

    public a(@NotNull String bootString, @NotNull String avatarString, @NotNull ZPlanAction[] actionArray, @NotNull String indirectLightPath) {
        Intrinsics.checkNotNullParameter(bootString, "bootString");
        Intrinsics.checkNotNullParameter(avatarString, "avatarString");
        Intrinsics.checkNotNullParameter(actionArray, "actionArray");
        Intrinsics.checkNotNullParameter(indirectLightPath, "indirectLightPath");
        this.bootString = bootString;
        this.avatarString = avatarString;
        this.actionArray = actionArray;
        this.indirectLightPath = indirectLightPath;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final ZPlanAction[] getActionArray() {
        return this.actionArray;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getAvatarString() {
        return this.avatarString;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getIndirectLightPath() {
        return this.indirectLightPath;
    }
}

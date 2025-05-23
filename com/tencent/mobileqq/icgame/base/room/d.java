package com.tencent.mobileqq.icgame.base.room;

import com.tencent.mapsdk.internal.ky;
import com.tencent.mobileqq.icgame.framework.component.e;
import g32.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00028\u0000\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0017\u0010\f\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/room/d;", "Lcom/tencent/mobileqq/icgame/framework/component/e;", ky.f149103i, "", "Lg32/g;", "a", "Lg32/g;", "()Lg32/g;", "register", "b", "Lcom/tencent/mobileqq/icgame/framework/component/e;", "()Lcom/tencent/mobileqq/icgame/framework/component/e;", "toC", "<init>", "(Lg32/g;Lcom/tencent/mobileqq/icgame/framework/component/e;)V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class d<TO extends com.tencent.mobileqq.icgame.framework.component.e> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g register;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TO toC;

    public d(@NotNull g register, @NotNull TO toC) {
        Intrinsics.checkNotNullParameter(register, "register");
        Intrinsics.checkNotNullParameter(toC, "toC");
        this.register = register;
        this.toC = toC;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final g getRegister() {
        return this.register;
    }

    @NotNull
    public final TO b() {
        return this.toC;
    }
}

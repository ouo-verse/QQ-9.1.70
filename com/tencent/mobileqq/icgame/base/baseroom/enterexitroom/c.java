package com.tencent.mobileqq.icgame.base.baseroom.enterexitroom;

import com.tencent.mapsdk.internal.ky;
import com.tencent.mobileqq.icgame.framework.component.e;
import com.tencent.mobileqq.mini.api.MiniConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\r\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u0017\u0010\r\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/baseroom/enterexitroom/c;", "Lcom/tencent/mobileqq/icgame/framework/component/e;", ky.f149103i, "", "Lcom/tencent/mobileqq/icgame/framework/component/d;", "Lcom/tencent/mobileqq/icgame/base/baseroom/enterexitroom/EnterExitRoomComponent;", "a", "Lcom/tencent/mobileqq/icgame/framework/component/d;", "()Lcom/tencent/mobileqq/icgame/framework/component/d;", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "b", "Lcom/tencent/mobileqq/icgame/framework/component/e;", "()Lcom/tencent/mobileqq/icgame/framework/component/e;", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "<init>", "(Lcom/tencent/mobileqq/icgame/framework/component/d;Lcom/tencent/mobileqq/icgame/framework/component/e;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c<TO extends com.tencent.mobileqq.icgame.framework.component.e> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.icgame.framework.component.d<EnterExitRoomComponent> first;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TO second;

    public c(@NotNull com.tencent.mobileqq.icgame.framework.component.d<EnterExitRoomComponent> first, @NotNull TO second) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        this.first = first;
        this.second = second;
    }

    @NotNull
    public final com.tencent.mobileqq.icgame.framework.component.d<EnterExitRoomComponent> a() {
        return this.first;
    }

    @NotNull
    public final TO b() {
        return this.second;
    }
}

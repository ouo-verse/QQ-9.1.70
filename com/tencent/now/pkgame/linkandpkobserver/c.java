package com.tencent.now.pkgame.linkandpkobserver;

import android.content.Context;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/now/pkgame/linkandpkobserver/c;", "", "Landroid/content/Context;", "context", "", "isSelfLive", "", "roomId", VasLiveIPCModule.KEY_ANCHOR_UIN, "Lcom/tencent/now/pkgame/linkandpkobserver/audience/b;", "seiInfoSubscriber", "Lcom/tencent/now/pkgame/linkandpkobserver/b;", "a", "<init>", "()V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c {
    @NotNull
    public final b a(@NotNull Context context, boolean isSelfLive, long roomId, long anchorUin, @NotNull com.tencent.now.pkgame.linkandpkobserver.audience.b seiInfoSubscriber) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(seiInfoSubscriber, "seiInfoSubscriber");
        if (isSelfLive) {
            return new co3.b(roomId, anchorUin, context);
        }
        return new com.tencent.now.pkgame.linkandpkobserver.audience.a(roomId, anchorUin, seiInfoSubscriber);
    }
}

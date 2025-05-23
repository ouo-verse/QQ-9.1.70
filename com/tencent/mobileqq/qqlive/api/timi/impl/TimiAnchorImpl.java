package com.tencent.mobileqq.qqlive.api.timi.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qqlive.api.timi.ITimiAnchor;
import com.tencent.mobileqq.qqlive.sail.c;
import com.tencent.timi.game.liveroom.impl.room.anchor.TimiAnchorActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/timi/impl/TimiAnchorImpl;", "Lcom/tencent/mobileqq/qqlive/api/timi/ITimiAnchor;", "()V", "getAnchorRecordType", "", "insertJumpDestination", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "intent", "openTimiAnchorActivity", "", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class TimiAnchorImpl implements ITimiAnchor {
    @Override // com.tencent.mobileqq.qqlive.api.timi.ITimiAnchor
    public int getAnchorRecordType() {
        return c.f272176a.d().r();
    }

    @Override // com.tencent.mobileqq.qqlive.api.timi.ITimiAnchor
    @NotNull
    public Intent insertJumpDestination(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intent insertJumpDestination = TimiAnchorActivity.insertJumpDestination(context, intent);
        Intrinsics.checkNotNullExpressionValue(insertJumpDestination, "insertJumpDestination(context, intent)");
        return insertJumpDestination;
    }

    @Override // com.tencent.mobileqq.qqlive.api.timi.ITimiAnchor
    public void openTimiAnchorActivity(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        TimiAnchorActivity.G2(context, intent);
    }
}

package com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive;

import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/i;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/BottomInteractivePart;", "", "action", "", "args", "", "handleBroadcastMessage", "Lwk1/d;", "provider", "<init>", "(Lwk1/d;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class i extends BottomInteractivePart {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull wk1.d provider) {
        super(provider);
        Intrinsics.checkNotNullParameter(provider, "provider");
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.BottomInteractivePart, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "message_on_speak_permission_changed")) {
            F9().lh("message_on_do_visibility_change", new a.BottomInteractiveVisibilityChangeMessage(4, 8));
        }
    }
}

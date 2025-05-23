package com.tencent.mobileqq.guild.feed.feedsquare.widget;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
final class GuildFeedSquareFeedItemView$longPressRunnable$2 extends Lambda implements Function0<Runnable> {
    final /* synthetic */ GuildFeedSquareFeedItemView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedSquareFeedItemView$longPressRunnable$2(GuildFeedSquareFeedItemView guildFeedSquareFeedItemView) {
        super(0);
        this.this$0 = guildFeedSquareFeedItemView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final GuildFeedSquareFeedItemView this$0) {
        boolean z16;
        MotionEvent motionEvent;
        MotionEvent motionEvent2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isLongPress = true;
        z16 = this$0.isReleased;
        if (!z16) {
            this$0.isReleased = true;
            this$0.shouldTriggerClick = false;
            this$0.u("trigger long press");
            motionEvent = this$0.longClickEvent;
            if (motionEvent != null) {
                motionEvent2 = this$0.longClickEvent;
                Intrinsics.checkNotNull(motionEvent2);
                if (this$0.v(motionEvent2)) {
                    return;
                }
            }
            this$0.getHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.e
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedSquareFeedItemView$longPressRunnable$2.d(GuildFeedSquareFeedItemView.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(GuildFeedSquareFeedItemView this$0) {
        com.tencent.mobileqq.guild.feed.util.c cVar;
        Function1<View, Unit> d16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.performHapticFeedback(0);
        this$0.performAccessibilityAction(32, null);
        cVar = this$0.longPressListener;
        if (cVar != null && (d16 = cVar.d()) != null) {
            d16.invoke(this$0);
        }
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Runnable invoke() {
        final GuildFeedSquareFeedItemView guildFeedSquareFeedItemView = this.this$0;
        return new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.d
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedSquareFeedItemView$longPressRunnable$2.c(GuildFeedSquareFeedItemView.this);
            }
        };
    }
}

package com.tencent.timi.game.liveroom.impl.room.message.stack;

import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.timi.game.liveroom.impl.room.message.stack.g;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0002J\u0016\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/message/stack/f;", "", "", "d", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/f;", "message", "f", "", "e", "Lcom/tencent/timi/game/liveroom/impl/room/message/stack/g$b;", "callback", "i", "j", "", "priority", "c", "", "a", "I", "maxSize", "b", "J", "dispatchInternalMs", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "Lcom/tencent/timi/game/liveroom/impl/room/message/stack/g$b;", "Z", "isAnimationPlaying", "dispatchIndex", "Ljava/lang/Runnable;", "g", "Ljava/lang/Runnable;", "nextDispatchRunnable", "<init>", "(IJ)V", h.F, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int maxSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long dispatchInternalMs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g.b callback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isAnimationPlaying;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int dispatchIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedList<com.tencent.mobileqq.qqlive.widget.chat.message.f> queue = new LinkedList<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable nextDispatchRunnable = new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.message.stack.d
        @Override // java.lang.Runnable
        public final void run() {
            f.h(f.this);
        }
    };

    public f(int i3, long j3) {
        this.maxSize = i3;
        this.dispatchInternalMs = j3;
    }

    private final void d() {
        if (this.isAnimationPlaying) {
            return;
        }
        if (this.queue.isEmpty()) {
            this.dispatchIndex = 0;
            return;
        }
        this.isAnimationPlaying = true;
        com.tencent.mobileqq.qqlive.widget.chat.message.f message = this.queue.pollFirst();
        Intrinsics.checkNotNullExpressionValue(message, "message");
        f(message);
    }

    private final long e() {
        if (this.dispatchIndex == 1) {
            return this.dispatchInternalMs + 200;
        }
        return this.dispatchInternalMs;
    }

    private final void f(final com.tencent.mobileqq.qqlive.widget.chat.message.f message) {
        this.dispatchIndex++;
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.message.stack.e
            @Override // java.lang.Runnable
            public final void run() {
                f.g(f.this, message);
            }
        });
        RFWThreadManager.getUIHandler().postDelayed(this.nextDispatchRunnable, e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(f this$0, com.tencent.mobileqq.qqlive.widget.chat.message.f message) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(message, "$message");
        g.b bVar = this$0.callback;
        if (bVar != null) {
            bVar.a(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isAnimationPlaying = false;
        this$0.d();
    }

    public final void c(@NotNull com.tencent.mobileqq.qqlive.widget.chat.message.f message, boolean priority) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (priority) {
            if (this.queue.size() >= this.maxSize) {
                this.queue.pollLast();
            }
            this.queue.addFirst(message);
        } else if (this.queue.size() < this.maxSize) {
            this.queue.addLast(message);
        }
        d();
    }

    public final void i(@NotNull g.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    public final void j() {
        this.queue.clear();
        this.isAnimationPlaying = false;
        RFWThreadManager.getUIHandler().removeCallbacks(this.nextDispatchRunnable);
    }
}

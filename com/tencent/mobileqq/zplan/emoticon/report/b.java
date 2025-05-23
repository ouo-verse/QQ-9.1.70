package com.tencent.mobileqq.zplan.emoticon.report;

import com.tencent.image.SharpDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zplan.message.MessageForZPlan;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\b\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\n\u001a\u00020\u0005R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010'\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u001e\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/report/b;", "Lcom/tencent/image/SharpDrawable$OnFreshListener;", "", "currentFrame", "frameCount", "", "refresh", "", "costTime", "decodeFrame", "b", "Lcom/tencent/image/SharpDrawable;", "a", "Lcom/tencent/image/SharpDrawable;", "getSharpDrawable", "()Lcom/tencent/image/SharpDrawable;", "sharpDrawable", "Lcom/tencent/mobileqq/zplan/message/MessageForZPlan;", "Lcom/tencent/mobileqq/zplan/message/MessageForZPlan;", "getMessage", "()Lcom/tencent/mobileqq/zplan/message/MessageForZPlan;", "message", "c", "I", "lastFrame", "d", "J", "lastFrameRefreshTime", "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isReporting", "", "f", "Ljava/util/List;", "drawDurationList", "g", "decodeDurationList", h.F, "paused", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b implements SharpDrawable.OnFreshListener {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final SharpDrawable sharpDrawable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final MessageForZPlan message;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int lastFrame;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long lastFrameRefreshTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean isReporting;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final List<Integer> drawDurationList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final List<Integer> decodeDurationList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean paused;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(b this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZPlanEmoticonReport.f333324a.o(this$0.message, this$0.drawDurationList, this$0.decodeDurationList, i3, this$0.sharpDrawable.getImage().getWidth(), this$0.sharpDrawable.getImage().getHeight());
    }

    public final void b() {
        this.paused.set(true);
    }

    @Override // com.tencent.image.SharpDrawable.OnFreshListener
    public void decodeFrame(int currentFrame, long costTime) {
        if (this.isReporting.get()) {
            this.decodeDurationList.add(Integer.valueOf((int) costTime));
        }
    }

    @Override // com.tencent.image.SharpDrawable.OnFreshListener
    public void refresh(int currentFrame, final int frameCount) {
        if (!this.isReporting.get() || this.lastFrame == currentFrame) {
            return;
        }
        this.lastFrame = currentFrame;
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.paused.getAndSet(false)) {
            long j3 = this.lastFrameRefreshTime;
            if (j3 > 0) {
                this.drawDurationList.add(Integer.valueOf((int) (currentTimeMillis - j3)));
            }
        }
        this.lastFrameRefreshTime = currentTimeMillis;
        if (this.drawDurationList.size() >= frameCount) {
            this.isReporting.set(false);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.report.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.c(b.this, frameCount);
                }
            }, 16, null, false);
        }
    }
}

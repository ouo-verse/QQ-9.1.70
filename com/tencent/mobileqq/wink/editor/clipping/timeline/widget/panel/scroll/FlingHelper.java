package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll;

import android.os.Handler;
import android.os.Looper;
import android.widget.OverScroller;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000b*\u0001\u0016\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b#\u0010$J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000f\u0010\u000b\u001a\u00020\nH\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\r\u001a\u00020\bR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper;", "", "", "velocityX", "startValue", "maxValue", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper$a;", "listener", "", "f", "", "d", "()Z", "g", "Landroid/widget/OverScroller;", "a", "Landroid/widget/OverScroller;", "scroller", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "handler", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper$handlerRunnable$1", "c", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper$handlerRunnable$1;", "handlerRunnable", "", UserInfo.SEX_FEMALE, "getFlingFactor", "()F", "e", "(F)V", "flingFactor", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper$a;", "flingListener", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class FlingHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final OverScroller scroller = new OverScroller(BaseApplication.getContext());

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FlingHelper$handlerRunnable$1 handlerRunnable = new Runnable() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper$handlerRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            FlingHelper.a aVar;
            FlingHelper.a aVar2;
            Handler handler;
            OverScroller overScroller2;
            OverScroller overScroller3;
            FlingHelper.a aVar3;
            Handler handler2;
            OverScroller overScroller4;
            overScroller = FlingHelper.this.scroller;
            if (overScroller.computeScrollOffset()) {
                aVar3 = FlingHelper.this.flingListener;
                if (aVar3 != null) {
                    overScroller4 = FlingHelper.this.scroller;
                    aVar3.b(overScroller4.getCurrX());
                }
                handler2 = FlingHelper.this.handler;
                handler2.post(this);
                return;
            }
            aVar = FlingHelper.this.flingListener;
            if (aVar != null) {
                overScroller3 = FlingHelper.this.scroller;
                aVar.b(overScroller3.getCurrX());
            }
            aVar2 = FlingHelper.this.flingListener;
            if (aVar2 != null) {
                overScroller2 = FlingHelper.this.scroller;
                aVar2.a(overScroller2.getCurrX(), false);
            }
            handler = FlingHelper.this.handler;
            handler.removeCallbacks(this);
        }
    };

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float flingFactor = 1.0f;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a flingListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper$a;", "", "", "xPos", "", "b", "", "cancel", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void a(int xPos, boolean cancel);

        void b(int xPos);
    }

    public final boolean d() {
        return this.scroller.computeScrollOffset();
    }

    public final void e(float f16) {
        this.flingFactor = f16;
    }

    public final void f(int velocityX, int startValue, int maxValue, @Nullable a listener) {
        g();
        this.flingListener = listener;
        this.scroller.fling(startValue, 0, velocityX, 0, 0, maxValue, 0, 0);
        this.handler.post(this.handlerRunnable);
    }

    public final void g() {
        this.handler.removeCallbacks(this.handlerRunnable);
        if (this.scroller.computeScrollOffset()) {
            this.scroller.abortAnimation();
            a aVar = this.flingListener;
            if (aVar != null) {
                aVar.a(this.scroller.getCurrX(), true);
            }
        }
        this.flingListener = null;
    }
}

package com.tencent.mobileqq.zplan.emoticon.panel.view.util;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u000b\u001cB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/view/util/DelayedLongClickHelper;", "", "Landroid/view/View;", "parentView", "", "delayMillis", "", "b", "", "e", "Lcom/tencent/mobileqq/zplan/emoticon/panel/view/util/DelayedLongClickHelper$a;", "a", "Lcom/tencent/mobileqq/zplan/emoticon/panel/view/util/DelayedLongClickHelper$a;", "getOnLongClickListener", "()Lcom/tencent/mobileqq/zplan/emoticon/panel/view/util/DelayedLongClickHelper$a;", "c", "(Lcom/tencent/mobileqq/zplan/emoticon/panel/view/util/DelayedLongClickHelper$a;)V", "onLongClickListener", "Landroid/view/View;", "Lcom/tencent/mobileqq/zplan/emoticon/panel/view/util/DelayedLongClickHelper$State;", "Lcom/tencent/mobileqq/zplan/emoticon/panel/view/util/DelayedLongClickHelper$State;", "state", "Ljava/lang/Runnable;", "d", "Ljava/lang/Runnable;", "timingOverCallback", "<init>", "()V", "State", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class DelayedLongClickHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private a onLongClickListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private View parentView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private State state = State.RELEASED;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Runnable timingOverCallback = new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.view.util.a
        @Override // java.lang.Runnable
        public final void run() {
            DelayedLongClickHelper.d(DelayedLongClickHelper.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/view/util/DelayedLongClickHelper$State;", "", "(Ljava/lang/String;I)V", "RELEASED", "PRESSING", "TRIGGERED", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public enum State {
        RELEASED,
        PRESSING,
        TRIGGERED
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/view/util/DelayedLongClickHelper$a;", "", "", "a", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface a {
        void a();

        void d();
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f333310a;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.PRESSING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.TRIGGERED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f333310a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(DelayedLongClickHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (this$0.state) {
            if (this$0.state == State.PRESSING) {
                this$0.state = State.TRIGGERED;
                a aVar = this$0.onLongClickListener;
                if (aVar != null) {
                    aVar.a();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void b(View parentView, long delayMillis) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        synchronized (this.state) {
            if (this.state == State.RELEASED) {
                this.state = State.PRESSING;
                parentView.postDelayed(this.timingOverCallback, delayMillis);
                this.parentView = parentView;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void c(a aVar) {
        this.onLongClickListener = aVar;
    }

    public final boolean e() {
        boolean z16;
        a aVar;
        synchronized (this.state) {
            int i3 = b.f333310a[this.state.ordinal()];
            z16 = true;
            if (i3 != 1) {
                if (i3 == 2 && (aVar = this.onLongClickListener) != null) {
                    aVar.d();
                }
                z16 = false;
            } else {
                View view = this.parentView;
                if (view != null) {
                    view.removeCallbacks(this.timingOverCallback);
                }
                this.parentView = null;
            }
            this.state = State.RELEASED;
        }
        return z16;
    }
}

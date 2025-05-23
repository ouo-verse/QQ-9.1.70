package kr3;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.qmethod.pandoraex.monitor.SilentCallMonitor;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lkr3/c;", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "d", "Landroid/view/View$OnTouchListener;", "getListener", "()Landroid/view/View$OnTouchListener;", "listener", "<init>", "(Landroid/view/View$OnTouchListener;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class c implements View.OnTouchListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View.OnTouchListener listener;

    public c(@Nullable View.OnTouchListener onTouchListener) {
        this.listener = onTouchListener;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(@Nullable View v3, @Nullable MotionEvent event) {
        SilentCallMonitor.onUserInteraction();
        View.OnTouchListener onTouchListener = this.listener;
        if (onTouchListener != null) {
            return onTouchListener.onTouch(v3, event);
        }
        return false;
    }
}

package com.tencent.mobileqq.wink.view;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\tR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\fR\u0016\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R$\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u000b\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/view/p;", "", "Landroid/view/MotionEvent;", "event", "", "a", "", "c", "Lcom/tencent/mobileqq/wink/view/p$a;", "Lcom/tencent/mobileqq/wink/view/p$a;", "listener", "b", "D", "initialAngle", "currentAngle", "d", "Z", "isRotating", "<set-?>", "e", "()Z", "isInProgress", "<init>", "(Lcom/tencent/mobileqq/wink/view/p$a;)V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a listener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private double initialAngle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private double currentAngle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isRotating;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isInProgress;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/view/p$a;", "", "", "rotationDegreesDelta", "", "a", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void a(float rotationDegreesDelta);
    }

    public p(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    private final double a(MotionEvent event) {
        return Math.toDegrees(Math.atan2(event.getY(1) - event.getY(0), event.getX(1) - event.getX(0)));
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsInProgress() {
        return this.isInProgress;
    }

    public final boolean c(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getPointerCount() != 2) {
            this.isRotating = false;
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked != 2) {
            if (actionMasked != 5) {
                if (actionMasked == 6) {
                    this.isInProgress = false;
                    this.isRotating = false;
                }
            } else {
                double a16 = a(event);
                this.initialAngle = a16;
                this.currentAngle = a16;
                this.isRotating = true;
                this.isInProgress = true;
            }
        } else if (this.isRotating) {
            double a17 = a(event);
            float f16 = (float) (a17 - this.currentAngle);
            this.currentAngle = a17;
            this.listener.a(f16);
        }
        return true;
    }
}

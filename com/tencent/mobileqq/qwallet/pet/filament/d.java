package com.tencent.mobileqq.qwallet.pet.filament;

import com.google.android.filament.gltfio.Animator;
import com.heytap.databaseengine.model.UserInfo;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 '2\u00020\u0001:\u0002\u0014\bB\u0007\u00a2\u0006\u0004\b%\u0010&J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001eR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0016\u0010!\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0018\u0010$\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/filament/d;", "", "Lcom/google/android/filament/gltfio/Animator;", "animator", "", "c", h.F, "", "b", "", "repeatCount", "f", "d", "Lcom/tencent/mobileqq/qwallet/pet/filament/d$a;", "callback", "e", "", "startRender", "g", "realAnimTime", "a", "Lcom/google/android/filament/gltfio/Animator;", "Z", "hasAnimation", UserInfo.SEX_FEMALE, "animTotalTime", "I", "targetRepeatCount", "currentRepeatCount", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasCallbackStart", "hasCallbackEnd", "hasStartRender", "i", "Lcom/tencent/mobileqq/qwallet/pet/filament/d$a;", "animationCallback", "<init>", "()V", "j", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Animator animator;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean hasAnimation;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float animTotalTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int currentRepeatCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasStartRender;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a animationCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int targetRepeatCount = -1;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean hasCallbackStart = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean hasCallbackEnd = new AtomicBoolean(false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0002H&J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/filament/d$a;", "", "", "onAnimationStart", "", "progress", "a", "onAnimationEnd", "", "repeatCount", "onAnimationRepeat", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface a {
        void a(float progress);

        void onAnimationEnd();

        void onAnimationRepeat(int repeatCount);

        void onAnimationStart();
    }

    public final void a(float realAnimTime, int repeatCount) {
        a aVar;
        if (this.hasAnimation && this.hasStartRender) {
            if (this.hasCallbackStart.compareAndSet(false, true) && (aVar = this.animationCallback) != null) {
                aVar.onAnimationStart();
            }
            int i3 = this.targetRepeatCount;
            if (i3 != -1 && repeatCount >= i3 && this.hasCallbackEnd.compareAndSet(false, true)) {
                a aVar2 = this.animationCallback;
                if (aVar2 != null) {
                    aVar2.onAnimationEnd();
                    return;
                }
                return;
            }
            if (this.currentRepeatCount != repeatCount) {
                this.currentRepeatCount = repeatCount;
                a aVar3 = this.animationCallback;
                if (aVar3 != null) {
                    aVar3.onAnimationRepeat(repeatCount);
                }
            }
            a aVar4 = this.animationCallback;
            if (aVar4 != null) {
                aVar4.a(realAnimTime / this.animTotalTime);
            }
            Animator animator = this.animator;
            if (animator != null) {
                animator.applyAnimation(0, realAnimTime);
                animator.updateBoneMatrices();
            }
        }
    }

    /* renamed from: b, reason: from getter */
    public final float getAnimTotalTime() {
        return this.animTotalTime;
    }

    public final void c(@NotNull Animator animator) {
        boolean z16;
        Intrinsics.checkNotNullParameter(animator, "animator");
        this.animator = animator;
        boolean z17 = true;
        if (animator.getAnimationCount() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.hasAnimation = z16;
        float f16 = this.animTotalTime;
        if (f16 != 0.0f) {
            z17 = false;
        }
        if (z17) {
            f16 = animator.getAnimationDuration(0);
        }
        this.animTotalTime = f16;
    }

    public final void d() {
        this.animator = null;
    }

    public final void e(@NotNull a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.animationCallback = callback;
    }

    public final void f(int repeatCount) {
        this.targetRepeatCount = repeatCount;
    }

    public final void g(boolean startRender) {
        this.hasStartRender = startRender;
    }

    public final void h() {
        if (!this.hasAnimation) {
            return;
        }
        this.currentRepeatCount = 0;
    }
}

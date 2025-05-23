package com.tencent.biz.qqcircle.immersive.views;

import androidx.annotation.CallSuper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGImageView;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u0005B\u0011\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/ae;", "Lorg/libpag/PAGImageView$PAGImageViewListener;", "Lorg/libpag/PAGImageView;", "pagView", "", "a", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "c", "", "d", "Ljava/lang/String;", "getLogTag", "()Ljava/lang/String;", "logTag", "", "e", "Z", "isFirstFrameAvailable", "<init>", "(Ljava/lang/String;)V", "f", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public class ae implements PAGImageView.PAGImageViewListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isFirstFrameAvailable;

    public ae(@NotNull String logTag) {
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        this.logTag = logTag;
    }

    private final void a(PAGImageView pagView) {
        boolean z16;
        if (!this.isFirstFrameAvailable) {
            if (pagView.currentImage() != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.isFirstFrameAvailable = z16;
            QLog.d(this.logTag, 1, "checkFirstFrameAvailable, isFirstFrameAvailable:" + this.isFirstFrameAvailable + ", pagView:" + pagView);
            if (this.isFirstFrameAvailable) {
                c(pagView);
            }
        }
    }

    @CallSuper
    public void c(@NotNull PAGImageView pagView) {
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        QLog.d(this.logTag, 1, "onFirstFrameAvailable, pagView:" + pagView);
    }

    @Override // org.libpag.PAGImageView.PAGImageViewListener
    @CallSuper
    public void onAnimationCancel(@NotNull PAGImageView pagView) {
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        QLog.d(this.logTag, 1, "onAnimationCancel, pagView:" + pagView);
    }

    @Override // org.libpag.PAGImageView.PAGImageViewListener
    @CallSuper
    public void onAnimationEnd(@NotNull PAGImageView pagView) {
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        QLog.d(this.logTag, 1, "onAnimationEnd, pagView:" + pagView);
        this.isFirstFrameAvailable = false;
        pagView.removeListener(this);
    }

    @Override // org.libpag.PAGImageView.PAGImageViewListener
    public void onAnimationRepeat(@NotNull PAGImageView pagView) {
        Intrinsics.checkNotNullParameter(pagView, "pagView");
    }

    @Override // org.libpag.PAGImageView.PAGImageViewListener
    @CallSuper
    public void onAnimationStart(@NotNull PAGImageView pagView) {
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        QLog.d(this.logTag, 1, "onAnimationStart, pagView:" + pagView + " ");
        a(pagView);
    }

    @Override // org.libpag.PAGImageView.PAGImageViewListener
    @CallSuper
    public void onAnimationUpdate(@NotNull PAGImageView pagView) {
        Intrinsics.checkNotNullParameter(pagView, "pagView");
        a(pagView);
    }
}

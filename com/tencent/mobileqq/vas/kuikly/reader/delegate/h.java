package com.tencent.mobileqq.vas.kuikly.reader.delegate;

import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.vas.kuikly.reader.VasBookTransitionView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/h;", "Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/j;", "", "left", "Landroid/graphics/Canvas;", PM.CANVAS, "", ExifInterface.LATITUDE_SOUTH, "y", BdhLogUtil.LogTag.Tag_Req, "", "width", "height", "I", "v", "animationSpeed", "u", "Landroid/graphics/drawable/GradientDrawable;", "o", "Landroid/graphics/drawable/GradientDrawable;", "shadowDrawableR", "Lcom/tencent/mobileqq/vas/kuikly/reader/VasBookTransitionView;", "readView", "<init>", "(Lcom/tencent/mobileqq/vas/kuikly/reader/VasBookTransitionView;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class h extends j {

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GradientDrawable shadowDrawableR;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f309925a;

        static {
            int[] iArr = new int[PageDirection.values().length];
            try {
                iArr[PageDirection.PREV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageDirection.NEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f309925a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull VasBookTransitionView readView) {
        super(readView);
        Intrinsics.checkNotNullParameter(readView, "readView");
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{1712394513, 0});
        this.shadowDrawableR = gradientDrawable;
        gradientDrawable.setGradientType(0);
    }

    private final void S(float left, Canvas canvas) {
        boolean z16;
        if (left == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        if (left < 0.0f) {
            left += getViewWidth();
        }
        int save = canvas.save();
        canvas.translate(left, 0.0f);
        try {
            this.shadowDrawableR.draw(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.PageDelegate
    public void I(int width, int height) {
        super.I(width, height);
        this.shadowDrawableR.setBounds(0, 0, 30, getViewHeight());
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.j
    public void R() {
        int i3 = a.f309925a[getMDirection().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                View e16 = e();
                if (e16 != null) {
                    l.b(e16, getNextRecorder());
                }
                View b16 = b();
                if (b16 != null) {
                    l.b(b16, getCurRecorder());
                    return;
                }
                return;
            }
            return;
        }
        View f16 = f();
        if (f16 != null) {
            l.b(f16, getPrevRecorder());
        }
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.PageDelegate
    public void u(int animationSpeed) {
        float viewWidth;
        float f16;
        if (a.f309925a[getMDirection().ordinal()] == 2) {
            if (getIsCancel()) {
                float viewWidth2 = (getViewWidth() - i()) + k();
                if (viewWidth2 > getViewWidth()) {
                    viewWidth2 = getViewWidth();
                }
                f16 = getViewWidth() - viewWidth2;
            } else {
                f16 = -(k() + (getViewWidth() - i()));
            }
        } else {
            if (getIsCancel()) {
                viewWidth = -(k() - i());
            } else {
                viewWidth = getViewWidth() - (k() - i());
            }
            f16 = viewWidth;
        }
        J((int) k(), 0, (int) f16, 0, animationSpeed);
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.PageDelegate
    public void v() {
        if (!getIsCancel()) {
            getReadView().a(getMDirection());
        }
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.PageDelegate
    public void y(@NotNull Canvas canvas) {
        float viewWidth;
        int save;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!getIsRunning()) {
            return;
        }
        float k3 = k() - i();
        PageDirection mDirection = getMDirection();
        PageDirection pageDirection = PageDirection.NEXT;
        if (mDirection != pageDirection || k3 <= 0.0f) {
            PageDirection mDirection2 = getMDirection();
            PageDirection pageDirection2 = PageDirection.PREV;
            if (mDirection2 == pageDirection2 && k3 < 0.0f) {
                return;
            }
            if (k3 > 0.0f) {
                viewWidth = k3 - getViewWidth();
            } else {
                viewWidth = getViewWidth() + k3;
            }
            if (getMDirection() == pageDirection2) {
                if (k3 <= getViewWidth()) {
                    save = canvas.save();
                    canvas.translate(viewWidth, 0.0f);
                    try {
                        getPrevRecorder().draw(canvas);
                        canvas.restoreToCount(save);
                        S(viewWidth, canvas);
                        return;
                    } finally {
                    }
                }
                getPrevRecorder().draw(canvas);
                return;
            }
            if (getMDirection() == pageDirection) {
                float width = getNextRecorder().getWidth();
                float height = getNextRecorder().getHeight();
                save = canvas.save();
                canvas.clipRect(k3 + width, 0.0f, width, height);
                try {
                    getNextRecorder().draw(canvas);
                    canvas.restoreToCount(save);
                    save = canvas.save();
                    canvas.translate(viewWidth - getViewWidth(), 0.0f);
                    try {
                        getCurRecorder().draw(canvas);
                        canvas.restoreToCount(save);
                        S(viewWidth, canvas);
                    } finally {
                    }
                } finally {
                }
            }
        }
    }
}

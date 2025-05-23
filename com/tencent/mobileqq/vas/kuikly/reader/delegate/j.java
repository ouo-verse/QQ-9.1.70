package com.tencent.mobileqq.vas.kuikly.reader.delegate;

import android.view.MotionEvent;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.kuikly.reader.VasBookTransitionView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\"\u0010\u0018\u001a\u00020\u00118\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00118\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\"\u0010 \u001a\u00020\u00118\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u0014\u0010#\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/j;", "Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/PageDelegate;", "Landroid/view/MotionEvent;", "event", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/PageDirection;", "direction", "D", BdhLogUtil.LogTag.Tag_Req, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "L", "", "animationSpeed", "t", "B", "w", "Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/e;", "l", "Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/e;", "M", "()Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/e;", "setCurRecorder", "(Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/e;)V", "curRecorder", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "O", "setPrevRecorder", "prevRecorder", DomainData.DOMAIN_NAME, "N", "setNextRecorder", "nextRecorder", "P", "()I", "slopSquare", "Lcom/tencent/mobileqq/vas/kuikly/reader/VasBookTransitionView;", "readView", "<init>", "(Lcom/tencent/mobileqq/vas/kuikly/reader/VasBookTransitionView;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class j extends PageDelegate {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private e curRecorder;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private e prevRecorder;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private e nextRecorder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull VasBookTransitionView readView) {
        super(readView);
        Intrinsics.checkNotNullParameter(readView, "readView");
        f fVar = f.f309919a;
        this.curRecorder = f.b(fVar, false, 1, null);
        this.prevRecorder = f.b(fVar, false, 1, null);
        this.nextRecorder = f.b(fVar, false, 1, null);
    }

    private final int P() {
        return getReadView().getPageSlopSquare2();
    }

    private final void Q(MotionEvent event) {
        boolean z16;
        int i3;
        boolean z17;
        boolean z18 = false;
        if ((event.getAction() & 255) == 6) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = event.getActionIndex();
        } else {
            i3 = -1;
        }
        int pointerCount = event.getPointerCount();
        float f16 = 0.0f;
        float f17 = 0.0f;
        for (int i16 = 0; i16 < pointerCount; i16++) {
            if (i3 != i16) {
                f16 += event.getX(i16);
                f17 += event.getY(i16);
            }
        }
        if (z16) {
            pointerCount--;
        }
        float f18 = pointerCount;
        float f19 = f16 / f18;
        float f26 = f17 / f18;
        if (!getIsMoved()) {
            int i17 = (int) (f19 - i());
            int j3 = (int) (f26 - j());
            if ((i17 * i17) + (j3 * j3) > P()) {
                z17 = true;
            } else {
                z17 = false;
            }
            E(z17);
            if (getIsMoved()) {
                if (f16 - i() > 0.0f) {
                    if (!p()) {
                        F(true);
                        return;
                    }
                    D(PageDirection.PREV);
                } else {
                    if (!o()) {
                        F(true);
                        return;
                    }
                    D(PageDirection.NEXT);
                }
                getReadView().setStartPoint(event.getX(), event.getY(), false);
            }
        }
        if (getIsMoved()) {
            if (getMDirection() != PageDirection.NEXT ? f16 < c() : f16 > c()) {
                z18 = true;
            }
            C(z18);
            G(true);
            VasBookTransitionView.setTouchPoint$default(getReadView(), f16, f17, false, 4, null);
        }
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.PageDelegate
    public void A(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return;
                    }
                } else {
                    Q(event);
                    return;
                }
            }
            u(getReadView().getDefaultAnimSpeed());
            return;
        }
        L();
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.PageDelegate
    public void B(int animationSpeed) {
        L();
        if (!p()) {
            return;
        }
        D(PageDirection.PREV);
        getReadView().setStartPoint(0.0f, getViewHeight(), false);
        u(animationSpeed);
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.PageDelegate
    public void D(@NotNull PageDirection direction) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        super.D(direction);
        R();
    }

    public void L() {
        H(false);
        E(false);
        G(false);
        if (!h().isFinished()) {
            getReadView().setAbortAnim(true);
            h().abortAnimation();
            if (!getIsCancel()) {
                getReadView().a(getMDirection());
                getReadView().invalidate();
                return;
            }
            return;
        }
        getReadView().setAbortAnim(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: M, reason: from getter */
    public final e getCurRecorder() {
        return this.curRecorder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: N, reason: from getter */
    public final e getNextRecorder() {
        return this.nextRecorder;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: O, reason: from getter */
    public final e getPrevRecorder() {
        return this.prevRecorder;
    }

    public abstract void R();

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.PageDelegate
    public void t(int animationSpeed) {
        float f16;
        L();
        if (!o()) {
            return;
        }
        D(PageDirection.NEXT);
        if (j() > getViewHeight() / 2) {
            f16 = getViewHeight() * 0.9f;
        } else {
            f16 = 1.0f;
        }
        getReadView().setStartPoint(getViewWidth() * 0.9f, f16, false);
        u(animationSpeed);
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.PageDelegate
    public void w() {
        super.w();
        this.prevRecorder.recycle();
        this.curRecorder.recycle();
        this.nextRecorder.recycle();
    }
}

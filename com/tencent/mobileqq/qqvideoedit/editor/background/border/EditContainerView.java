package com.tencent.mobileqq.qqvideoedit.editor.background.border;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.videocut.utils.s;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 =2\u00020\u0001:\u0002>?B'\b\u0007\u0012\u0006\u00106\u001a\u000205\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107\u0012\b\b\u0002\u0010:\u001a\u000209\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\u0010\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018R\"\u0010!\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u001cR\u0016\u0010,\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u001cR\u0016\u0010/\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0018\u00104\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditContainerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "F0", "K0", "", "E0", "D0", "", "centerX", "J0", "centerY", "I0", "G0", "H0", "onDraw", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditContainerView$b;", "listener", "setDispatchTouchEventListener", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/c;", "view", "setCurBorderView", "d", "Z", "getNeedDrawRefLine", "()Z", "setNeedDrawRefLine", "(Z)V", "needDrawRefLine", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "refPaint", "f", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/c;", "curBorderView", h.F, "needVVibrate", "i", "needHVibrate", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, "lastCenterX", BdhLogUtil.LogTag.Tag_Conn, "lastCenterY", "D", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditContainerView$b;", "touchEventListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "E", "a", "b", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class EditContainerView extends ConstraintLayout {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final float F;
    private static final float G;
    private static final float H;
    private static final float I;

    /* renamed from: C, reason: from kotlin metadata */
    private float lastCenterY;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private b touchEventListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean needDrawRefLine;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint refPaint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c curBorderView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean needVVibrate;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean needHVibrate;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float lastCenterX;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditContainerView$a;", "", "", "DRAG_ADSORPTION_THRESHOLD", UserInfo.SEX_FEMALE, "b", "()F", "DEFAULT_REF_LINE_WIDTH", "a", "H_REF_LINE_LENGTH", "c", "V_REF_LINE_LENGTH", "d", "ROTATE_ADSORPTION_THRESHOLD", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqvideoedit.editor.background.border.EditContainerView$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a() {
            return EditContainerView.G;
        }

        public final float b() {
            return EditContainerView.F;
        }

        public final float c() {
            return EditContainerView.H;
        }

        public final float d() {
            return EditContainerView.I;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditContainerView$b;", "", "Landroid/view/MotionEvent;", "event", "", "onDispatchTouchEvent", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        boolean onDispatchTouchEvent(@NotNull MotionEvent event);
    }

    static {
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        F = eVar.a(2.0f) * 4.0f;
        G = eVar.a(1.0f);
        H = eVar.a(45.0f);
        I = eVar.a(45.0f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EditContainerView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean D0() {
        if (this.needHVibrate) {
            return !J0(this.lastCenterX);
        }
        return false;
    }

    private final boolean E0() {
        if (this.needVVibrate) {
            return !I0(this.lastCenterY);
        }
        return false;
    }

    private final void F0(Canvas canvas) {
        e eVar;
        c cVar = this.curBorderView;
        if (cVar != null) {
            eVar = cVar.b();
        } else {
            eVar = null;
        }
        if (eVar != null) {
            this.refPaint.setColor(eVar.getLineColor());
            float vLineWidth = eVar.getVLineWidth();
            float vLineLength = eVar.getVLineLength();
            float hLineWidth = eVar.getHLineWidth();
            float hLineLength = eVar.getHLineLength();
            float G0 = G0();
            float H0 = H0();
            if (J0(G0)) {
                this.needHVibrate = true;
                canvas.drawRect((getWidth() - vLineWidth) / 2.0f, 0.0f, (getWidth() + vLineWidth) / 2.0f, vLineLength, this.refPaint);
                canvas.drawRect((getWidth() - vLineWidth) / 2.0f, getHeight() - vLineLength, (getWidth() + vLineWidth) / 2.0f, getHeight(), this.refPaint);
            }
            if (I0(H0)) {
                this.needVVibrate = true;
                canvas.drawRect(0.0f, (getHeight() - hLineWidth) / 2.0f, hLineLength, (getHeight() + hLineWidth) / 2.0f, this.refPaint);
                canvas.drawRect(getWidth() - hLineLength, (getHeight() - hLineWidth) / 2.0f, getWidth(), (getHeight() + hLineWidth) / 2.0f, this.refPaint);
            }
            K0();
            this.lastCenterX = G0;
            this.lastCenterY = H0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final float G0() {
        c cVar = this.curBorderView;
        if (cVar != 0) {
            return cVar.getCenterPointF().x + ((View) cVar).getX();
        }
        return 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final float H0() {
        c cVar = this.curBorderView;
        if (cVar != 0) {
            return cVar.getCenterPointF().y + ((View) cVar).getY();
        }
        return 0.0f;
    }

    private final boolean I0(float centerY) {
        if (Math.abs((getHeight() / 2.0f) - centerY) < F) {
            return true;
        }
        return false;
    }

    private final boolean J0(float centerX) {
        if (Math.abs((getWidth() / 2.0f) - centerX) < F) {
            return true;
        }
        return false;
    }

    private final void K0() {
        if (this.needHVibrate || this.needVVibrate) {
            if (D0() || E0()) {
                s.f384267a.a(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        b bVar = this.touchEventListener;
        if (bVar != null) {
            return bVar.onDispatchTouchEvent(event);
        }
        return super.dispatchTouchEvent(event);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        c cVar;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        this.needHVibrate = false;
        this.needVVibrate = false;
        if (this.needDrawRefLine && (cVar = this.curBorderView) != 0 && cVar.getIsActived() && ((View) cVar).getVisibility() == 0) {
            F0(canvas);
        }
    }

    public final void setCurBorderView(@Nullable c view) {
        this.curBorderView = view;
    }

    public final void setDispatchTouchEventListener(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.touchEventListener = listener;
    }

    public final void setNeedDrawRefLine(boolean z16) {
        this.needDrawRefLine = z16;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EditContainerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ EditContainerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EditContainerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.refPaint = new Paint();
        setWillNotDraw(false);
    }
}

package com.tencent.mobileqq.wink.dailysign;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0002\n\u0006B\u001d\b\u0007\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0017\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010'\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/wink/dailysign/DailySignBorderView;", "Landroid/widget/FrameLayout;", "Landroid/view/MotionEvent;", "event", "", "d", "b", "f", "e", "", "a", "onTouchEvent", "Lcom/tencent/mobileqq/wink/dailysign/DailySignBorderView$b;", "clickListener", "", "setonTouchClickCallBack", "c", "", "J", "getCountMove", "()J", "setCountMove", "(J)V", "countMove", "getCountScale", "setCountScale", "countScale", "Lcom/tencent/mobileqq/wink/dailysign/DailySignBorderView$b;", "Landroid/graphics/PointF;", tl.h.F, "Landroid/graphics/PointF;", "movieDownPoint", "i", "Z", "isScaling", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isMoveing", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "oriDis", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "D", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class DailySignBorderView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private float oriDis;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long countMove;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long countScale;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b clickListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF movieDownPoint;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isScaling;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isMoveing;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/dailysign/DailySignBorderView$b;", "", "", "deltaX", "deltay", "", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void a(float deltaX, float deltay);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DailySignBorderView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final float a(MotionEvent event) {
        float x16 = event.getX(0) - event.getX(1);
        float y16 = event.getY(0) - event.getY(1);
        return (float) Math.sqrt((x16 * x16) + (y16 * y16));
    }

    private final boolean b(MotionEvent event) {
        this.movieDownPoint.x = event.getX();
        this.movieDownPoint.y = event.getY();
        this.isScaling = false;
        this.isMoveing = false;
        b bVar = this.clickListener;
        if (bVar != null) {
            bVar.a(event.getX(), event.getY());
            return true;
        }
        return true;
    }

    private final boolean d(MotionEvent event) {
        if (event.getPointerCount() == 2) {
            this.oriDis = a(event);
            return true;
        }
        return true;
    }

    private final boolean e(MotionEvent event) {
        return true;
    }

    private final boolean f(MotionEvent event) {
        return true;
    }

    public final boolean c(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action != 6) {
                                return false;
                            }
                            return e(event);
                        }
                        return d(event);
                    }
                } else {
                    return c(event);
                }
            }
            return f(event);
        }
        return b(event);
    }

    public final void setCountMove(long j3) {
        this.countMove = j3;
    }

    public final void setCountScale(long j3) {
        this.countScale = j3;
    }

    public final void setonTouchClickCallBack(@NotNull b clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.clickListener = clickListener;
    }

    public /* synthetic */ DailySignBorderView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DailySignBorderView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.movieDownPoint = new PointF();
        this.oriDis = 1.0f;
    }
}

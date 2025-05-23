package com.tencent.mobileqq.wink.editor.view;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.view.a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u00017B\u001d\b\u0007\u0012\u0006\u00101\u001a\u000200\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u0016\u0010\u001c\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001bR\u0016\u0010$\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001bR$\u0010,\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/BorderCoverView;", "Lcom/tencent/mobileqq/wink/editor/view/BorderView;", "Landroid/view/MotionEvent;", "event", "", "N", "M", "", "L", "", "r", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "", "r0", "J", "getCountMove", "()J", "setCountMove", "(J)V", "countMove", "s0", "getCountScale", "setCountScale", "countScale", "t0", "Z", "currentIsBackground", "Landroid/graphics/PointF;", "u0", "Landroid/graphics/PointF;", "movieDownPoint", "v0", "isScaling", "w0", "isMoveing", "Lcom/tencent/mobileqq/wink/editor/view/a;", "x0", "Lcom/tencent/mobileqq/wink/editor/view/a;", "getMovieOperationCallBack", "()Lcom/tencent/mobileqq/wink/editor/view/a;", "setMovieOperationCallBack", "(Lcom/tencent/mobileqq/wink/editor/view/a;)V", "movieOperationCallBack", "y0", UserInfo.SEX_FEMALE, "oriDis", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "A0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class BorderCoverView extends BorderView {

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private long countMove;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private long countScale;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private boolean currentIsBackground;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF movieDownPoint;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private boolean isScaling;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private boolean isMoveing;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a movieOperationCallBack;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private float oriDis;

    /* renamed from: z0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f322663z0;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BorderCoverView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final float L(MotionEvent event) {
        float x16 = event.getX(0) - event.getX(1);
        float y16 = event.getY(0) - event.getY(1);
        return (float) Math.sqrt((x16 * x16) + (y16 * y16));
    }

    private final void M(MotionEvent event) {
        float x16 = event.getX() - this.movieDownPoint.x;
        float y16 = event.getY();
        PointF pointF = this.movieDownPoint;
        float f16 = y16 - pointF.y;
        long j3 = this.countMove;
        this.countMove = 1 + j3;
        if (j3 % 7 != 0) {
            return;
        }
        this.isMoveing = true;
        pointF.y = event.getY();
        this.movieDownPoint.x = event.getX();
        a aVar = this.movieOperationCallBack;
        if (aVar != null) {
            aVar.c(x16, f16);
        }
    }

    private final void N(MotionEvent event) {
        if (this.oriDis < 12.0f) {
            return;
        }
        long j3 = this.countScale;
        this.countScale = 1 + j3;
        if (j3 % 7 != 0) {
            return;
        }
        float sqrt = (float) Math.sqrt(L(event) / this.oriDis);
        this.isScaling = true;
        a aVar = this.movieOperationCallBack;
        if (aVar != null) {
            a.C9048a.b(aVar, sqrt, sqrt, false, false, 12, null);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView
    public boolean q(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.movieDownPoint.x = event.getX();
        this.movieDownPoint.y = event.getY();
        this.isScaling = false;
        this.isMoveing = false;
        return super.q(event);
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView
    public boolean r(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (getCurStickerModel() != null && getIsStickerActive() && !this.currentIsBackground) {
            return super.r(event);
        }
        if (event.getPointerCount() == 2) {
            N(event);
            return true;
        }
        M(event);
        return true;
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView
    public boolean s(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getPointerCount() == 2) {
            this.oriDis = L(event);
        }
        return super.s(event);
    }

    public final void setCountMove(long j3) {
        this.countMove = j3;
    }

    public final void setCountScale(long j3) {
        this.countScale = j3;
    }

    public final void setMovieOperationCallBack(@Nullable a aVar) {
        this.movieOperationCallBack = aVar;
    }

    @Override // com.tencent.mobileqq.wink.editor.view.BorderView
    public boolean u(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        a aVar = this.movieOperationCallBack;
        boolean z16 = false;
        if (aVar != null) {
            a.C9048a.a(aVar, false, false, 2, null);
        }
        if (getCurStickerModel() == null) {
            z16 = true;
        }
        this.currentIsBackground = z16;
        return super.u(event);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BorderCoverView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f322663z0 = new LinkedHashMap();
        this.movieDownPoint = new PointF();
        this.oriDis = 1.0f;
    }

    public /* synthetic */ BorderCoverView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}

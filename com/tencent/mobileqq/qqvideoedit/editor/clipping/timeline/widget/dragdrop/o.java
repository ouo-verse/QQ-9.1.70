package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop;

import android.graphics.PointF;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\u0002H&J\b\u0010\u000b\u001a\u00020\u0002H&J\b\u0010\f\u001a\u00020\u0002H&J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\b\u0010\u0011\u001a\u00020\u000fH&J\b\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0014\u001a\u00020\u0012H&J\b\u0010\u0015\u001a\u00020\u0002H\u0016R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001f\u001a\u00020\u001a8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/o;", "", "", "l", "p", ReportConstant.COSTREPORT_PREFIX, DomainData.DOMAIN_NAME, tl.h.F, "getLength", "g", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/q;", "valueChangeListener", "", "setValueChangeListener", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "k", "o", "getTrackType", "Landroid/graphics/PointF;", "e", "()Landroid/graphics/PointF;", "startTouchPoint", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/k;", "j", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/k;", "setDragViewModel", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/k;)V", "dragViewModel", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface o {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class a {
        public static int a(@NotNull o oVar) {
            return oVar.h() - oVar.n();
        }

        public static int b(@NotNull o oVar) {
            return -1;
        }

        public static int c(@NotNull o oVar) {
            return 0;
        }

        public static void d(@NotNull o oVar, @NotNull DragModel dragModel) {
            Intrinsics.checkNotNullParameter(dragModel, "dragModel");
            oVar.j().j(dragModel);
        }
    }

    @Nullable
    PointF e();

    int g();

    int getLength();

    int getTrackType();

    int h();

    @NotNull
    DragViewModel j();

    boolean k();

    int l();

    int m();

    int n();

    boolean o();

    int p();

    void q();

    int r();

    int s();

    void setDragViewModel(@NotNull DragViewModel dragViewModel);

    void setValueChangeListener(@Nullable q valueChangeListener);

    int t();
}

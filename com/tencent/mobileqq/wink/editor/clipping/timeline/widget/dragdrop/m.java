package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.graphics.PointF;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\u0002H&J\b\u0010\u000b\u001a\u00020\u0002H&J\b\u0010\f\u001a\u00020\u0002H&J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\b\u0010\u0011\u001a\u00020\u000fH&J\b\u0010\u0012\u001a\u00020\u000fH&J\b\u0010\u0014\u001a\u00020\u0013H&J\b\u0010\u0015\u001a\u00020\u0013H&J\b\u0010\u0016\u001a\u00020\u0002H\u0016R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010 \u001a\u00020\u001b8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/m;", "", "", "l", "p", ReportConstant.COSTREPORT_PREFIX, DomainData.DOMAIN_NAME, tl.h.F, "getLength", "g", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/o;", "valueChangeListener", "", "setValueChangeListener", "B", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "k", "o", "getTrackType", "Landroid/graphics/PointF;", "e", "()Landroid/graphics/PointF;", "startTouchPoint", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/i;", "j", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/i;", "setDragViewModel", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/i;)V", "dragViewModel", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface m {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static int a(@NotNull m mVar) {
            return mVar.h() - mVar.n();
        }

        public static int b(@NotNull m mVar) {
            return -1;
        }

        public static int c(@NotNull m mVar) {
            return 0;
        }

        public static void d(@NotNull m mVar, @NotNull DragModel dragModel) {
            Intrinsics.checkNotNullParameter(dragModel, "dragModel");
            mVar.j().j(dragModel);
        }
    }

    void B();

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

    void setValueChangeListener(@Nullable o valueChangeListener);

    int t();
}

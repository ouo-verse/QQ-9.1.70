package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\u0006H&J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H&J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0017\u001a\u00020\u0016H&J\u001a\u0010\u001b\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001c\u001a\u00020\u0006H&J\b\u0010\u001d\u001a\u00020\u0004H&J\b\u0010\u001e\u001a\u00020\u0006H&J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H&J\u001c\u0010%\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00142\b\u0010$\u001a\u0004\u0018\u00010\u0014H&R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/l;", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/m;", "iDragView", "", "k", "", "leftMargin", "d", "rightMargin", "j", "i", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, HippyTKDListViewAdapter.X, "y", "l", "", "id", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/a;", "b", "", "e", "dragView", "", "isSelected", "r", "c", "a", "f", "positionOffset", "Landroid/view/View;", "view", "g", "startPoint", "endPoint", "setAdsorbedPoint", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/y;", "Lkotlin/collections/ArrayList;", tl.h.F, "()Ljava/util/ArrayList;", "trackModels", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface l {
    void a();

    @NotNull
    List<AttractPoint> b(@NotNull String id5);

    int c();

    int d(int leftMargin);

    float e();

    int f();

    void g(int positionOffset, @NotNull View view);

    @NotNull
    ArrayList<y> h();

    int i();

    int j(int rightMargin);

    void k(@NotNull m iDragView);

    void l(int x16, int y16);

    int m();

    int n();

    void r(@Nullable m dragView, boolean isSelected);

    void setAdsorbedPoint(@Nullable AttractPoint startPoint, @Nullable AttractPoint endPoint);
}

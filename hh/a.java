package hh;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.itemview.ad.QZoneAdBaseFeedItemView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0014JL\u0010\u0011\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0015"}, d2 = {"Lhh/a;", "Lhh/b;", "", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "manager", "firstVisiblePos", "lastVisiblePos", "firstCompletelyVisible", "lastCompletelyVisible", "", "isScrollUp", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends b {
    @Override // hh.b
    /* renamed from: c */
    protected String getTAG() {
        return "QZoneAdShakeScroller";
    }

    @Override // hh.b
    public void m(RecyclerView recyclerView, int newState, RecyclerView.LayoutManager manager, int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, boolean isScrollUp) {
        if (manager == null || newState != 0 || firstVisiblePos > lastVisiblePos || firstVisiblePos > lastVisiblePos) {
            return;
        }
        while (true) {
            View findViewByPosition = manager.findViewByPosition(firstVisiblePos);
            if (findViewByPosition instanceof QZoneAdBaseFeedItemView) {
                ((QZoneAdBaseFeedItemView) findViewByPosition).z0();
                return;
            } else if (firstVisiblePos == lastVisiblePos) {
                return;
            } else {
                firstVisiblePos++;
            }
        }
    }
}

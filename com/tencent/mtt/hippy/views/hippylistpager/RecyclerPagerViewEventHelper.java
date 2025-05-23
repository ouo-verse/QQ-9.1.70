package com.tencent.mtt.hippy.views.hippylistpager;

import android.graphics.Rect;
import android.view.View;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView;
import com.tencent.mtt.hippy.views.hippylist.RecyclerViewEventHelper;
import com.tencent.mtt.hippy.views.list.HippyListItemView;

/* loaded from: classes20.dex */
public class RecyclerPagerViewEventHelper extends RecyclerViewEventHelper {
    private Rect reusableExposureStateRect;

    public RecyclerPagerViewEventHelper(HippyRecyclerView hippyRecyclerView) {
        super(hippyRecyclerView);
        this.reusableExposureStateRect = new Rect();
    }

    private int calculateExposureState(View view) {
        if (view == null || !view.getGlobalVisibleRect(this.reusableExposureStateRect)) {
            return 2;
        }
        float height = this.reusableExposureStateRect.height() * this.reusableExposureStateRect.width();
        float measuredWidth = view.getMeasuredWidth() * view.getMeasuredHeight();
        if (height >= measuredWidth) {
            return 1;
        }
        if (height <= measuredWidth * 0.1f) {
            return 2;
        }
        return 3;
    }

    @Override // com.tencent.mtt.hippy.views.hippylist.RecyclerViewEventHelper
    protected void checkExposureView(View view) {
        if (view instanceof HippyListItemView) {
            ((HippyListItemView) view).moveToExposureState(calculateExposureState(view));
        }
    }
}

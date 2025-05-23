package com.tencent.mtt.hippy.views.hippylistpager;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerListAdapter;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView;
import com.tencent.mtt.hippy.views.hippylist.RecyclerViewEventHelper;
import java.util.Map;

/* loaded from: classes20.dex */
public class HippyRecyclerPagerView<ADP extends HippyRecyclerListAdapter> extends HippyRecyclerView {
    private final RecyclerPagerScrollHelper mPagerScrollHelper;

    public HippyRecyclerPagerView(Context context) {
        super(context);
        this.mPagerScrollHelper = new RecyclerPagerScrollHelper(this);
    }

    @Override // com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView
    protected RecyclerViewEventHelper createEventHelper() {
        return new RecyclerPagerViewEventHelper(this);
    }

    public int getPreCreateRowsNumber() {
        return this.mPagerScrollHelper.getPreCreateRowsNumber();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView, androidx.recyclerview.widget.RecyclerViewBase
    public void init() {
        setNestedScrollingEnabled(false);
    }

    @Override // com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView
    public void initRecyclerView() {
        HippyRecyclerPagerAdapter hippyRecyclerPagerAdapter = new HippyRecyclerPagerAdapter(this, this.hippyEngineContext);
        hippyRecyclerPagerAdapter.setHasStableIds(true);
        setAdapter(hippyRecyclerPagerAdapter);
        intEventHelper();
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            this.mPagerScrollHelper.setOrientation(((LinearLayoutManager) layoutManager).getOrientation());
        }
    }

    public void setAutoPageScrollDuration(int i3) {
        this.mPagerScrollHelper.setAutoPageScrollDuration(i3);
    }

    public void setItemViewPoolSize(HippyMap hippyMap) {
        int i3;
        for (Map.Entry<String, Object> entry : hippyMap.entrySet()) {
            try {
                int parseInt = Integer.parseInt(entry.getKey());
                Object value = entry.getValue();
                if (value instanceof Number) {
                    i3 = ((Number) value).intValue();
                } else {
                    i3 = 5;
                }
                setMaxRecycledViews(parseInt, i3);
            } catch (NumberFormatException unused) {
            }
        }
    }

    @Override // com.tencent.mtt.hippy.views.hippylist.HippyRecyclerView
    public void setListData() {
        int i3 = this.renderNodeCount;
        super.setListData();
        if (this.renderNodeCount > i3) {
            this.recyclerViewEventHelper.checkSendExposureEvent();
        }
    }

    public void setPageUpDownOffsetRatio(float f16) {
        this.mPagerScrollHelper.setPageUpDownOffsetRatio(f16);
    }

    public void setPreCreateRowsNumber(int i3) {
        this.mPagerScrollHelper.setPreCreateRowsNumber(i3);
    }
}

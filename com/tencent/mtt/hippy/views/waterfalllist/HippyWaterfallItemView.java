package com.tencent.mtt.hippy.views.waterfalllist;

import android.content.Context;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HippyWaterfallItemView extends HippyViewGroup {
    static final String TAG = "HippyWaterfallItemView";
    private int mType;

    public HippyWaterfallItemView(Context context) {
        super(context);
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i3) {
        this.mType = i3;
    }
}

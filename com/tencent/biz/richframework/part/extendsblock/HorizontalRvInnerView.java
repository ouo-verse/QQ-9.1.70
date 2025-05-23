package com.tencent.biz.richframework.part.extendsblock;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes5.dex */
public class HorizontalRvInnerView extends RecyclerView {
    private LinearLayoutManager mLinearLayoutManager;

    public HorizontalRvInnerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOrientation(int i3) {
        LinearLayoutManager linearLayoutManager = this.mLinearLayoutManager;
        if (linearLayoutManager != null) {
            linearLayoutManager.setOrientation(i3);
        }
    }

    public void setData(List list) {
    }
}

package com.tencent.biz.richframework.widget.listview.card;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.widget.listview.card.api.RFWCardModel;
import com.tencent.biz.richframework.widget.listview.card.framework.adapter.RFWCardListAdapter;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWCardListView extends RecyclerView {
    private final RFWCardListAdapter adapter;

    public RFWCardListView(Context context) {
        this(context, null, 0);
    }

    public RFWCardExtension getCardExtension() {
        RFWCardListAdapter rFWCardListAdapter = this.adapter;
        if (rFWCardListAdapter != null) {
            return rFWCardListAdapter.getCardExtension();
        }
        return null;
    }

    public boolean onBackPressed() {
        RFWCardListAdapter rFWCardListAdapter = this.adapter;
        if (rFWCardListAdapter != null) {
            return rFWCardListAdapter.onBackPressed();
        }
        return false;
    }

    public void setCardExtension(RFWCardExtension rFWCardExtension) {
        RFWCardListAdapter rFWCardListAdapter = this.adapter;
        if (rFWCardListAdapter != null) {
            rFWCardListAdapter.setCardExtension(rFWCardExtension);
        }
    }

    public void setData(List<? extends RFWCardModel> list) {
        RFWCardListAdapter rFWCardListAdapter = this.adapter;
        if (rFWCardListAdapter != null) {
            rFWCardListAdapter.setData(list);
        }
    }

    public RFWCardListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFWCardListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        setLayoutManager(linearLayoutManager);
        setMotionEventSplittingEnabled(false);
        RFWCardListAdapter rFWCardListAdapter = new RFWCardListAdapter(context);
        this.adapter = rFWCardListAdapter;
        setAdapter(rFWCardListAdapter);
        setOverScrollMode(2);
    }
}

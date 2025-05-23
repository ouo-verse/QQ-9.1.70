package com.tencent.biz.pubaccount.weishi.holder;

import UserGrowth.stFeed;
import UserGrowth.stSplitBlock;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.report.WSFollowBeaconReport;
import com.tencent.mobileqq.R;
import com.tencent.widget.pull2refresh.BaseViewHolder;

/* compiled from: P */
/* loaded from: classes32.dex */
public class e extends BaseViewHolder<stFeed> {

    /* renamed from: d, reason: collision with root package name */
    private TextView f80800d;

    public static e c(ViewGroup viewGroup, com.tencent.biz.pubaccount.weishi.f fVar) {
        return new e(viewGroup, fVar);
    }

    public void e() {
        WSFollowBeaconReport.y(2);
    }

    e(ViewGroup viewGroup, com.tencent.biz.pubaccount.weishi.f fVar) {
        super(viewGroup, R.layout.fxn);
        d();
    }

    private void d() {
        this.f80800d = (TextView) getView(R.id.f125447m3);
    }

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void bindData(stFeed stfeed) {
        stSplitBlock stsplitblock;
        if (stfeed == null || (stsplitblock = stfeed.recommend_splitter) == null) {
            return;
        }
        this.f80800d.setText(stsplitblock.tips);
    }
}

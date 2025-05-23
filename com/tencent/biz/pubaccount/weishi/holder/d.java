package com.tencent.biz.pubaccount.weishi.holder;

import UserGrowth.stFeed;
import UserGrowth.stSplitBlock;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.report.WSFollowBeaconReport;
import com.tencent.mobileqq.R;
import com.tencent.widget.pull2refresh.BaseViewHolder;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends BaseViewHolder<stFeed> {

    /* renamed from: d, reason: collision with root package name */
    private TextView f80798d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f80799e;

    public static d c(ViewGroup viewGroup, com.tencent.biz.pubaccount.weishi.f fVar) {
        return new d(viewGroup, fVar);
    }

    public void e() {
        WSFollowBeaconReport.y(1);
    }

    d(ViewGroup viewGroup, com.tencent.biz.pubaccount.weishi.f fVar) {
        super(viewGroup, R.layout.fx6);
        d();
    }

    private void d() {
        this.f80798d = (TextView) getView(R.id.f125377lw);
        this.f80799e = (TextView) getView(R.id.f125387lx);
    }

    @Override // com.tencent.widget.pull2refresh.BaseViewHolder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void bindData(stFeed stfeed) {
        stSplitBlock stsplitblock;
        if (stfeed == null || (stsplitblock = stfeed.recommend_splitter) == null) {
            return;
        }
        if (TextUtils.isEmpty(stsplitblock.text)) {
            this.f80798d.setVisibility(8);
        } else {
            this.f80798d.setVisibility(0);
            this.f80798d.setText(stsplitblock.text);
        }
        if (TextUtils.isEmpty(stsplitblock.tips)) {
            this.f80799e.setVisibility(8);
        } else {
            this.f80799e.setVisibility(0);
            this.f80799e.setText(stsplitblock.tips);
        }
    }
}

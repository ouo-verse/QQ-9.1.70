package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateTaskDetailInitBean;
import com.tencent.biz.richframework.queue.RFWDownloadQueue;
import com.tencent.biz.richframework.queue.RFWDownloadTaskStateData;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bh extends com.qzone.reborn.albumx.common.part.k {
    private QZoneIntimateTaskDetailInitBean E;
    private String F;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements RFWDownloadQueue.QueryBizTaskStateCallback {
        a() {
        }

        @Override // com.tencent.biz.richframework.queue.RFWDownloadQueue.QueryBizTaskStateCallback
        public void onTaskListRsp(List<RFWDownloadTaskStateData> list) {
            bh.this.G9(list);
        }
    }

    private void L9() {
        kj.b.l().d(this.F);
    }

    private void M9() {
        kj.b.l().r(this.F, new a());
    }

    @Override // com.qzone.reborn.albumx.common.part.k
    public List<RFWDownloadTaskStateData> E9(String str) {
        return kj.b.l().g(str);
    }

    @Override // com.qzone.reborn.albumx.common.part.k
    protected String F9() {
        return this.F;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.n5_) {
            L9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.reborn.albumx.common.part.k, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        M9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        QZoneIntimateTaskDetailInitBean qZoneIntimateTaskDetailInitBean = (QZoneIntimateTaskDetailInitBean) activity.getIntent().getSerializableExtra("key_bundle_common_init_bean");
        this.E = qZoneIntimateTaskDetailInitBean;
        if (qZoneIntimateTaskDetailInitBean != null) {
            this.F = qZoneIntimateTaskDetailInitBean.getSpaceId();
        }
        kj.b.l().s(this.F, this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        kj.b.l().t(this.F, this);
    }
}

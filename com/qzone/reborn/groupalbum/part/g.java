package com.qzone.reborn.groupalbum.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumTaskDetailInitBean;
import com.tencent.biz.richframework.queue.RFWDownloadQueue;
import com.tencent.biz.richframework.queue.RFWDownloadTaskStateData;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes37.dex */
public class g extends com.qzone.reborn.albumx.common.part.k {
    private GroupAlbumTaskDetailInitBean E;
    private String F;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements RFWDownloadQueue.QueryBizTaskStateCallback {
        a() {
        }

        @Override // com.tencent.biz.richframework.queue.RFWDownloadQueue.QueryBizTaskStateCallback
        public void onTaskListRsp(List<RFWDownloadTaskStateData> list) {
            g.this.G9(list);
        }
    }

    private void L9() {
        zh.b.l().d(this.F);
    }

    private void M9() {
        zh.b.l().q(this.F, new a());
    }

    @Override // com.qzone.reborn.albumx.common.part.k
    public List<RFWDownloadTaskStateData> E9(String str) {
        return zh.b.l().f(str);
    }

    @Override // com.qzone.reborn.albumx.common.part.k
    protected String F9() {
        return this.F;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumDownloadQueuePart";
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
        GroupAlbumTaskDetailInitBean groupAlbumTaskDetailInitBean = (GroupAlbumTaskDetailInitBean) activity.getIntent().getSerializableExtra("key_bundle_common_init_bean");
        this.E = groupAlbumTaskDetailInitBean;
        if (groupAlbumTaskDetailInitBean != null) {
            this.F = groupAlbumTaskDetailInitBean.getGroupId();
        }
        zh.b.l().r(this.F, this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        zh.b.l().s(this.F, this);
    }
}

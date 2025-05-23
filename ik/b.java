package ik;

import android.view.View;
import com.qzone.reborn.albumx.common.bean.e;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateTaskDetailInitBean;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends x9.b {

    /* renamed from: i, reason: collision with root package name */
    private QZoneIntimateTaskDetailInitBean f407889i;

    /* JADX WARN: Multi-variable type inference failed */
    private void w(View view) {
        QLog.d(getTAG(), 1, "[handleDeleteClick] ");
        kj.b.l().c(((e) this.mData).getStateData().getUrl());
    }

    private void x() {
        if (p() == null || p().getIntent() == null) {
            return;
        }
        this.f407889i = (QZoneIntimateTaskDetailInitBean) p().getIntent().getSerializableExtra("key_bundle_common_init_bean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // x9.b, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateDownloadQueueDeleteSection";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.mgv) {
            this.f447487e.g();
            w(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // x9.b, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        super.onInitView(view);
        x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onBindData(e eVar, int i3, List<Object> list) {
        String str;
        kj.b l3 = kj.b.l();
        QZoneIntimateTaskDetailInitBean qZoneIntimateTaskDetailInitBean = this.f407889i;
        if (qZoneIntimateTaskDetailInitBean != null) {
            str = qZoneIntimateTaskDetailInitBean.getSpaceId();
        } else {
            str = "";
        }
        int h16 = l3.h(str);
        if (h16 > 0) {
            v(i3, h16);
        } else {
            QLog.e(getTAG(), 1, "[onBindData] data list is empty");
        }
    }
}

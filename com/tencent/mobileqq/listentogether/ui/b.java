package com.tencent.mobileqq.listentogether.ui;

import android.content.Context;
import com.tencent.mobileqq.listentogether.nt.e;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b extends BaseListenTogetherPanel {
    public b(com.tencent.aio.api.runtime.a aVar, Context context) {
        super(aVar, context);
    }

    private String K() {
        long j3 = this.f241140a.g().l().getLong("key_peerUin", 0L);
        if (j3 == 0) {
            return ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(this.f241140a.g().r().c().j());
        }
        return String.valueOf(j3);
    }

    @Override // com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel
    public void C() {
        e eVar = this.f241141b;
        if (eVar != null) {
            eVar.d();
        }
    }

    @Override // com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel
    public boolean c() {
        return true;
    }

    @Override // com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel
    public boolean m() {
        return true;
    }

    @Override // com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel
    public void p() {
        super.p();
        UiData uiData = this.f241143d;
        uiData.f241157d = 2;
        uiData.f241158e = K();
        BaseListenTogetherPanel.ReportInfo reportInfo = new BaseListenTogetherPanel.ReportInfo();
        this.f241150k = reportInfo;
        reportInfo.mainAction = "c2c_AIO";
        reportInfo.shenFen = -1;
        reportInfo.reportUin = "";
    }
}

package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalFeedGridView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.richframework.data.base.UIStateData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h extends com.tencent.biz.qqcircle.bizparts.c {
    private QFSPersonalFeedGridView C;
    private com.tencent.biz.qqcircle.immersive.personal.viewmodel.l D;
    private int E;

    public h(Bundle bundle) {
        super(bundle);
        this.E = ErrorCode.ERROR_CHECKLEGALAPP_INVALID_APP;
    }

    private void j0() {
        this.D = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.l) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.l.class);
        if (getParentFragment() == null) {
            return;
        }
        this.D.Q1().observe(getParentFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.adapter.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                h.this.k0((UIStateData) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(UIStateData uIStateData) {
        if (uIStateData == null) {
            return;
        }
        if (uIStateData.getState() == 4 || uIStateData.getState() == 0 || uIStateData.getState() == 3) {
            notifyLoadingComplete(true, uIStateData.getIsFinish());
            getLoadInfo().setFinish(uIStateData.getIsFinish());
        }
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QFSPersonalFeedGridView qFSPersonalFeedGridView = new QFSPersonalFeedGridView(viewGroup.getContext());
        this.C = qFSPersonalFeedGridView;
        qFSPersonalFeedGridView.setData(new com.tencent.biz.qqcircle.immersive.personal.bean.b(this.E, this.D.R1()));
        return this.C;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QFSPersonalFeedGridBlock";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
        if (this.D != null && loadInfo.isRefreshState()) {
            this.D.T1(this.E, 2);
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        j0();
        String string = bundle.getString("key_bundle_owner_uin");
        int i3 = bundle.getInt("key_bundle_source_type");
        this.E = i3;
        this.D.W1(new com.tencent.biz.qqcircle.immersive.personal.bean.b(i3, string));
        this.D.U1(new com.tencent.biz.qqcircle.immersive.personal.interceptor.d());
        this.D.X1(new com.tencent.biz.qqcircle.immersive.personal.interceptor.c());
    }
}

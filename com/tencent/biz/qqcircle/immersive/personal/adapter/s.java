package com.tencent.biz.qqcircle.immersive.personal.adapter;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSRecentlyWatchTopTipsWidget;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class s extends com.tencent.biz.qqcircle.bizparts.c {
    private QFSRecentlyWatchTopTipsWidget C;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements Observer<QQCircleFeedBase$StFeedListBusiRspData> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData) {
            if (qQCircleFeedBase$StFeedListBusiRspData.has() && qQCircleFeedBase$StFeedListBusiRspData.recentWatchPageData != null && s.this.C != null) {
                s.this.C.setData(qQCircleFeedBase$StFeedListBusiRspData.recentWatchPageData.topContent.get());
            } else if (s.this.C != null) {
                s.this.C.setData("");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b implements Observer<UIStateData<List<e30.b>>> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<List<e30.b>> uIStateData) {
            boolean z16;
            int i3 = 0;
            if (uIStateData.getState() != 2 && uIStateData.getState() != 3 && uIStateData.getState() != 5) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (s.this.C != null) {
                QFSRecentlyWatchTopTipsWidget qFSRecentlyWatchTopTipsWidget = s.this.C;
                if (!z16) {
                    i3 = 8;
                }
                qFSRecentlyWatchTopTipsWidget.setVisibility(i3);
            }
        }
    }

    public s(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QFSRecentlyWatchTopTipsBlock";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public QCircleBaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QFSRecentlyWatchTopTipsWidget qFSRecentlyWatchTopTipsWidget = new QFSRecentlyWatchTopTipsWidget(viewGroup.getContext());
        this.C = qFSRecentlyWatchTopTipsWidget;
        return qFSRecentlyWatchTopTipsWidget;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
        com.tencent.biz.qqcircle.immersive.personal.viewmodel.l lVar = (com.tencent.biz.qqcircle.immersive.personal.viewmodel.l) getViewModel(com.tencent.biz.qqcircle.immersive.personal.viewmodel.l.class);
        if (getParentFragment() == null) {
            return;
        }
        lVar.P1().observe(getParentFragment(), new a());
        lVar.Q1().observe(getParentFragment(), new b());
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }
}

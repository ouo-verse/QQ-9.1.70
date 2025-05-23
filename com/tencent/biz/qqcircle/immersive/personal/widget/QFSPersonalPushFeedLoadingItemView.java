package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.views.QFSCircleProgressView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* loaded from: classes4.dex */
public class QFSPersonalPushFeedLoadingItemView extends QFSPersonalBaseFeedItemView {
    private QFSCircleProgressView C;
    private TextView D;

    public QFSPersonalPushFeedLoadingItemView(@NonNull Context context) {
        super(context);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gmw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView
    /* renamed from: n0 */
    public void bindData(com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, int i3) {
        super.bindData(eVar, i3);
        if (eVar.c().b("DITTO_FEED_BUSI_REQ_DATA") instanceof QQCircleFeedBase$StFeedBusiReqData) {
            this.D.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(((QQCircleFeedBase$StFeedBusiReqData) r5).pushList.totalClickCount.get()));
        }
        if (eVar.f() == null) {
            return;
        }
        int i16 = (int) eVar.f().loading.get();
        if (i16 <= 100 && i16 >= 0) {
            this.C.setProgress(Math.min(i16, 95));
            if (eVar.b() != null) {
                eVar.c();
                return;
            }
            return;
        }
        RFWLog.i("QFSPersonalPushFeedLoadingItemView", RFWLog.USR, "[bindData] -> loading error loading = " + i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView
    public void u0(View view) {
        super.u0(view);
        QFSCircleProgressView qFSCircleProgressView = (QFSCircleProgressView) view.findViewById(R.id.f348810c);
        this.C = qFSCircleProgressView;
        qFSCircleProgressView.setIsShowProgressNum(false);
        this.D = (TextView) view.findViewById(R.id.f56032ji);
    }
}

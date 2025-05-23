package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;

/* loaded from: classes4.dex */
public class QFSPersonalPushFeedFinishItemView extends QFSPersonalBaseFeedItemView {
    private TextView C;

    public QFSPersonalPushFeedFinishItemView(@NonNull Context context) {
        super(context);
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gmv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView
    /* renamed from: n0 */
    public void bindData(com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, int i3) {
        super.bindData(eVar, i3);
        if (eVar.f() == null) {
            return;
        }
        this.C.setText(String.format(com.tencent.biz.qqcircle.utils.h.a(R.string.f194064aw), Long.valueOf(eVar.f().drawCount.get())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView
    public void u0(View view) {
        super.u0(view);
        this.C = (TextView) view.findViewById(R.id.f56022jh);
    }
}

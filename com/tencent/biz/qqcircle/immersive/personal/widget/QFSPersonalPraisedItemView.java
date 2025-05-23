package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.personal.bean.e;
import com.tencent.mobileqq.R;

/* loaded from: classes4.dex */
public class QFSPersonalPraisedItemView<T extends com.tencent.biz.qqcircle.immersive.personal.bean.e> extends QFSPersonalBaseFeedItemView<T> {
    private TextView C;

    public QFSPersonalPraisedItemView(@NonNull Context context) {
        super(context);
    }

    private void x0(com.tencent.biz.qqcircle.immersive.personal.bean.e eVar) {
        if (eVar != null && eVar.b() != null) {
            this.C.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(eVar.b().likeInfo.count.get()));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gmt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0 */
    public void bindData(T t16, int i3) {
        super.bindData(t16, i3);
        if (t16 == null) {
            return;
        }
        x0(t16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView
    public void u0(View view) {
        super.u0(view);
        this.C = (TextView) view.findViewById(R.id.f56532kv);
    }
}

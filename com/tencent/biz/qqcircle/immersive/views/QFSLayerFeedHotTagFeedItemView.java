package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLayerFeedHotTagFeedItemView extends QFSPersonalBaseFeedItemView {
    private TextView C;
    private ImageView D;

    public QFSLayerFeedHotTagFeedItemView(@NonNull Context context) {
        super(context);
    }

    private void x0(com.tencent.biz.qqcircle.immersive.personal.bean.e eVar) {
        if (eVar != null && eVar.b() != null) {
            this.C.setText(com.tencent.biz.qqcircle.immersive.utils.r.f(eVar.b().visitorInfo.viewCount.get()));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.geg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView
    /* renamed from: n0 */
    public void bindData(com.tencent.biz.qqcircle.immersive.personal.bean.e eVar, int i3) {
        int i16;
        super.bindData(eVar, i3);
        if (eVar == null) {
            return;
        }
        x0(eVar);
        ImageView imageView = this.D;
        if (eVar.b().opMask2.get().contains(30)) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        imageView.setVisibility(i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView
    public void u0(View view) {
        super.u0(view);
        this.C = (TextView) view.findViewById(R.id.f56352kd);
        this.D = (ImageView) view.findViewById(R.id.f44341ox);
    }
}

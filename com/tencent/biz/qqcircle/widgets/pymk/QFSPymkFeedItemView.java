package com.tencent.biz.qqcircle.widgets.pymk;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.personal.bean.e;
import com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;

/* loaded from: classes5.dex */
public class QFSPymkFeedItemView extends QFSPersonalBaseFeedItemView {
    private static final int F = cx.a(4.0f);
    private TextView C;
    private RoundCorneredFrameLayout D;
    private int E;

    public QFSPymkFeedItemView(@NonNull Context context, int i3) {
        super(context);
        this.E = i3;
    }

    private void A0(int i3) {
        int i16;
        if (this.D == null) {
            return;
        }
        int i17 = 0;
        if (x0(i3)) {
            i16 = F;
        } else {
            i16 = 0;
        }
        if (y0(i3)) {
            i17 = F;
        }
        float f16 = i16;
        float f17 = i17;
        this.D.setRadius(f16, f17, f17, f16);
    }

    private boolean x0(int i3) {
        if (i3 == 0) {
            return true;
        }
        return false;
    }

    private boolean y0(int i3) {
        if (i3 == this.E - 1) {
            return true;
        }
        return false;
    }

    private void z0(e eVar) {
        if (eVar != null && eVar.b() != null) {
            this.C.setText(r.f(eVar.b().likeInfo.count.get()));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gpm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView
    /* renamed from: n0 */
    public void bindData(e eVar, int i3) {
        super.bindData(eVar, i3);
        if (eVar == null) {
            return;
        }
        z0(eVar);
        A0(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBaseFeedItemView
    public void u0(View view) {
        super.u0(view);
        this.C = (TextView) view.findViewById(R.id.f56532kv);
        this.D = (RoundCorneredFrameLayout) view.findViewById(R.id.f512227i);
    }
}

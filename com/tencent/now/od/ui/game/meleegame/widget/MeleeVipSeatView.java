package com.tencent.now.od.ui.game.meleegame.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.now.od.ui.common.widget.VipSeatView;
import pn3.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MeleeVipSeatView extends VipSeatView {
    private ImageView F;
    private ImageView G;
    private StrokeTextView H;

    public MeleeVipSeatView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.now.od.ui.common.widget.VipSeatView
    public void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.f167668e00, this);
        super.initView();
        this.F = (ImageView) findViewById(R.id.f165655x60);
        ImageLoader.getInstance().displayImage(a.f426515h.b(), this.F, un3.a.f439281b);
        this.G = (ImageView) findViewById(R.id.zlg);
        StrokeTextView strokeTextView = (StrokeTextView) findViewById(R.id.zlh);
        this.H = strokeTextView;
        strokeTextView.setTextSize(8.0f);
        this.H.setGravity(17);
        com.tencent.od.common.util.a.a(this.H);
        com.tencent.od.common.util.a.a(this.H.e());
    }

    public void setMvpLevel(int i3) {
        int i16 = i3 / 100;
        int i17 = 0;
        if (i16 < 0 || i16 > 11) {
            i16 = 0;
        }
        int i18 = i3 % 100;
        if (i18 >= 0 && i18 <= 9) {
            i17 = i18;
        }
        this.H.setText("L" + i16 + "-" + i17);
    }

    public void setMvpLevelVisible(int i3) {
        this.H.setVisibility(i3);
    }

    public void setMvpShowRes(String str) {
        ImageLoader.getInstance().displayImage(str, this.G, un3.a.f439281b);
    }

    public void setMvpViewVisible(int i3) {
        this.G.setVisibility(i3);
    }

    public MeleeVipSeatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MeleeVipSeatView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}

package com.qzone.reborn.feedx.widget.header;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.View;
import androidx.lifecycle.Observer;
import com.qzone.reborn.feedx.widget.QZoneLinearGradientView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;

/* compiled from: P */
/* loaded from: classes37.dex */
public class at extends d {

    /* renamed from: f, reason: collision with root package name */
    private final QZoneLinearGradientView f56210f;

    public at(View view) {
        super(view);
        this.f56210f = (QZoneLinearGradientView) view.findViewById(R.id.f162856n02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(Integer num) {
        this.f56210f.setVisibility(num.intValue() < 200 ? 8 : 0);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public View e() {
        return this.f56210f;
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneUserHomeShadowElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        this.f56210f.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, com.qzone.util.ar.e(160.0f), new int[]{Color.parseColor("#00000000"), Color.parseColor("#05000000"), Color.parseColor("#0F000000"), Color.parseColor("#16000000"), Color.parseColor("#21000000"), Color.parseColor("#28000000"), Color.parseColor("#2D000000"), Color.parseColor("#30000000"), Color.parseColor(GameCenterVideoViewController.GRAY_MASK)}, (float[]) null, Shader.TileMode.CLAMP));
        com.qzone.reborn.feedx.viewmodel.f fVar = (com.qzone.reborn.feedx.viewmodel.f) k(com.qzone.reborn.feedx.viewmodel.f.class);
        if (fVar != null) {
            fVar.M1().observe(i(), new Observer() { // from class: com.qzone.reborn.feedx.widget.header.as
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    at.this.o((Integer) obj);
                }
            });
        }
    }
}

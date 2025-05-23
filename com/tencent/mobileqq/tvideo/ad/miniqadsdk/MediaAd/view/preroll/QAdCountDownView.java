package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdCountDownView extends QAdBaseCountDownView {
    public QAdCountDownView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.preroll.QAdBaseCountDownView
    public void e(Context context) {
        View.inflate(context, R.layout.fsq, this);
        this.f303719m = (FrameLayout) findViewById(R.id.f120617_1);
        this.f303714d = (TextView) findViewById(R.id.ygb);
        this.f303715e = findViewById(R.id.f111186kj);
        this.f303716f = (TextView) findViewById(R.id.f111386l3);
        this.f303717h = (FrameLayout) findViewById(R.id.f86124qt);
        super.e(context);
    }

    public QAdCountDownView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

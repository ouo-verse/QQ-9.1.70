package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import java.util.Locale;
import pw2.n;
import pw2.s;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdMidCountDownView extends BaseMidCountView {
    private volatile View C;

    public QAdMidCountDownView(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.BaseMidCountView
    void d() {
        View inflate = View.inflate(getContext(), R.layout.fsm, this);
        this.f303679h = (TextView) inflate.findViewById(R.id.z6g);
        this.C = inflate.findViewById(R.id.z6e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388661;
        layoutParams.topMargin = s.a(8.0f);
        layoutParams.rightMargin = s.a(8.0f);
        this.C.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.view.BaseMidCountView
    String f(int i3) {
        n.a("QAdMidCountDownView", "second = " + i3);
        return String.format(Locale.US, "%02d", Integer.valueOf(i3));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        View view = this.C;
        if (view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (y.k(this.f303676d)) {
            marginLayoutParams.topMargin = s.a(31.0f);
        } else {
            marginLayoutParams.topMargin = s.a(8.0f);
        }
        view.setLayoutParams(marginLayoutParams);
    }
}

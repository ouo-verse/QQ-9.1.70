package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.SelectTouchBarView;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildLiveSelectTouchBarView extends SelectTouchBarView {
    public GuildLiveSelectTouchBarView(Context context) {
        super(context);
        d();
        c();
    }

    private void d() {
        this.f316232e.setBackgroundColor(getResources().getColor(R.color.bqs));
        this.f316232e.setTextColor(getResources().getColor(R.color.bqu));
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.cgg);
        this.f316232e.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
    }

    private void c() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.l9i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dip2px(0.5f));
        layoutParams.addRule(13);
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.cgf);
        layoutParams.leftMargin = dimensionPixelOffset;
        layoutParams.rightMargin = dimensionPixelOffset;
        View view = new View(getContext());
        view.setBackgroundColor(getResources().getColor(R.color.bqt));
        relativeLayout.addView(view, 0, layoutParams);
    }

    @Override // com.tencent.mobileqq.widget.SelectTouchBarView
    public void b() {
    }

    @Override // com.tencent.mobileqq.widget.SelectTouchBarView
    protected void a(RelativeLayout relativeLayout) {
    }
}

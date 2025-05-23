package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.model.af;
import com.tencent.mobileqq.search.util.aq;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import lo2.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i extends com.tencent.mobileqq.search.business.net.view.c {
    public final List<com.tencent.mobileqq.search.business.net.view.i> M;
    public final int N;
    private final int P;

    public i(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
        float f16;
        int measuredWidth;
        this.M = new ArrayList();
        if (aq.a()) {
            f16 = 4.0f;
        } else {
            f16 = 20.0f;
        }
        this.N = ViewUtils.dip2px(f16);
        LinearLayout linearLayout = (LinearLayout) j(i3);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (viewGroup.getMeasuredWidth() == 0) {
            measuredWidth = ScreenUtil.SCREEN_WIDTH;
        } else {
            measuredWidth = viewGroup.getMeasuredWidth();
        }
        this.P = measuredWidth;
        int dip2px = ViewUtils.dip2px(13.5f);
        layoutParams.rightMargin = dip2px;
        layoutParams.leftMargin = dip2px;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundDrawable(null);
        if (aq.a()) {
            this.f433999d.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
        }
    }

    @NotNull
    private LinearLayout.LayoutParams q(int i3, int i16) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, -2);
        int i17 = this.N / 4;
        if (i16 == 0) {
            layoutParams.rightMargin = i17;
        } else if (i16 == 1) {
            layoutParams.leftMargin = i17;
            layoutParams.rightMargin = i17;
        } else if (i16 == 2) {
            layoutParams.leftMargin = i17;
        }
        return layoutParams;
    }

    public void p(af afVar) {
        this.M.clear();
        LinearLayout linearLayout = (LinearLayout) j(this.E);
        linearLayout.removeAllViews();
        List<u> list = afVar.f283492b0;
        if (list != null && list.size() != 0) {
            Context context = linearLayout.getContext();
            int size = afVar.f283492b0.size();
            int i3 = 3;
            if (size >= 3) {
                i3 = afVar.f283492b0.size();
            }
            int c16 = ((this.P - x.c(context, 27.0f)) - this.N) / i3;
            for (int i16 = 0; i16 < size; i16++) {
                j jVar = new j((ViewGroup) getView(), c16);
                jVar.getView().setLayoutParams(q(c16, i16));
                linearLayout.addView(jVar.getView());
                this.M.add(jVar);
            }
        }
    }
}

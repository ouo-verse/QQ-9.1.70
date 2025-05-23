package com.tencent.mobileqq.search.view;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.search.model.ad;
import com.tencent.mobileqq.util.x;
import java.util.ArrayList;
import lo2.u;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h extends com.tencent.mobileqq.search.business.net.view.c {
    public final ArrayList<com.tencent.mobileqq.search.business.net.view.i> M;

    public h(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
        this.M = new ArrayList<>();
        LinearLayout linearLayout = (LinearLayout) j(i3);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int c16 = x.c(viewGroup.getContext(), 13.5f);
        layoutParams.rightMargin = c16;
        layoutParams.leftMargin = c16;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundDrawable(null);
    }

    public void p(ad adVar) {
        com.tencent.mobileqq.search.business.net.view.j jVar;
        this.M.clear();
        LinearLayout linearLayout = (LinearLayout) j(this.E);
        linearLayout.removeAllViews();
        ArrayList<u> arrayList = adVar.f283479c0;
        if (arrayList != null && arrayList.size() != 0) {
            Context context = linearLayout.getContext();
            int size = adVar.f283479c0.size();
            int i3 = 3;
            if (size >= 3) {
                i3 = adVar.f283479c0.size();
            }
            int c16 = (context.getResources().getDisplayMetrics().widthPixels - x.c(context, 27.0f)) / i3;
            for (int i16 = 0; i16 < size; i16++) {
                u uVar = adVar.f283479c0.get(i16);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c16, -2);
                if (uVar.f415279c0 != 1) {
                    jVar = null;
                } else {
                    jVar = new com.tencent.mobileqq.search.business.net.view.j((ViewGroup) getView(), 0);
                }
                if (jVar != null) {
                    jVar.getView().setLayoutParams(layoutParams);
                    linearLayout.addView(jVar.getView());
                    this.M.add(jVar);
                }
            }
        }
    }
}

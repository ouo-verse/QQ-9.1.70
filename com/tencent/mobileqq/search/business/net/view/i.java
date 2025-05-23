package com.tencent.mobileqq.search.business.net.view;

import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i extends c {
    public i(ViewGroup viewGroup, int i3) {
        super(viewGroup, i3);
    }

    @Override // com.tencent.mobileqq.search.business.net.view.c, sn2.g
    public void a() {
        super.a();
        TextView k3 = k();
        if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, null)) {
            if (k3 != null) {
                k3.setTextColor(k3.getContext().getResources().getColor(R.color.acf));
            }
        } else if (k3 != null) {
            k3.setTextColor(Color.parseColor("#737373"));
        }
    }
}

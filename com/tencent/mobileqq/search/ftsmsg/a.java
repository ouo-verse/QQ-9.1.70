package com.tencent.mobileqq.search.ftsmsg;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import vy2.b;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends do2.a {
    private int C;

    @Override // com.tencent.mobileqq.search.model.x
    public String l() {
        return HardCodeUtil.qqStr(R.string.mu8);
    }

    @Override // com.tencent.mobileqq.search.model.x
    public int n() {
        return nn2.a.e("fts_native_chathistory_maxnum", 3);
    }

    @Override // com.tencent.mobileqq.search.model.x
    public void q(View view) {
        SearchUtils.c1(this.f394360i, 40, 0, view);
        if (view.getContext() instanceof UniteSearchActivity) {
            SearchUtils.W0("all_result", "more_talk", "" + this.f394360i);
            com.tencent.mobileqq.search.report.b.e(null, 0, this.C, "0X8009D4F", 0, 0, null, null);
        }
        b.a.f443715d = -1;
        b.a.f443717f = 0;
        b.a.f443718g = -1;
        b.a.f443721j = -1;
        b.a.f443722k = -1;
        b.a.f443723l = -1;
        vy2.b.k(view);
        FTSEntitySearchActivity.P2(view.getContext(), this.f394360i, 1);
    }
}

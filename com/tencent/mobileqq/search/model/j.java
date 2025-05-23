package com.tencent.mobileqq.search.model;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class j extends x {
    public static final String C = HardCodeUtil.qqStr(R.string.n5v);

    /* renamed from: h, reason: collision with root package name */
    public List<y> f283540h;

    /* renamed from: i, reason: collision with root package name */
    private String f283541i;

    /* renamed from: m, reason: collision with root package name */
    private int f283542m;

    public j(List<y> list, String str, int i3) {
        this.f283540h = list;
        this.f283541i = str;
        this.f283542m = i3;
        r(7);
    }

    @Override // com.tencent.mobileqq.search.model.x
    public String l() {
        return C;
    }

    @Override // com.tencent.mobileqq.search.model.x
    /* renamed from: m */
    public String getKeyword() {
        return this.f283541i;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public int n() {
        return nn2.a.e("fts_native_contactor_maxnum", 3);
    }

    @Override // com.tencent.mobileqq.search.model.x
    public List<y> o() {
        return this.f283540h;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public void q(View view) {
        ContactSearchActivity.Q2(view.getContext(), this.f283541i, this.f283542m, 100860733, 2);
        SearchUtils.c1(this.f283541i, 20, 0, view);
        if (view.getContext() instanceof UniteSearchActivity) {
            SearchUtils.W0("all_result", "more_contact", "" + this.f283541i);
            if (SearchConfig.needSeparate) {
                SearchUtils.V0("search", VipFunCallConstants.KEY_GROUP, "more", 0, 0, SearchUtils.b0(this.f283542m));
            }
            com.tencent.mobileqq.search.report.b.e(null, 0, this.f283542m, "0X8009D3D", 0, 0, null, null);
        }
    }

    public int s() {
        return this.f283542m;
    }
}

package com.tencent.mobileqq.search.model;

import addcontacts.AccountSearchPb$record;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aq;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h extends z {
    private AccountSearchPb$record G;
    private String H;
    private CharSequence I;

    public h(AccountSearchPb$record accountSearchPb$record, String str, CharSequence charSequence) {
        this.G = accountSearchPb$record;
        this.H = str;
        this.I = charSequence;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 4;
    }

    @Override // com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return String.valueOf(this.G.code.get());
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        return HardCodeUtil.qqStr(R.string.n4t);
    }

    @Override // com.tencent.mobileqq.search.model.y
    public CharSequence o() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public boolean r() {
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: s */
    public String getKeyword() {
        return this.H;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: t */
    public CharSequence getSubTitleSpans() {
        return null;
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        return this.I;
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(View view) {
        Bundle b16 = aq.b(String.valueOf(this.G.code.get()), 2);
        b16.putInt("exposureSource", 3);
        TroopUtils.I((Activity) view.getContext(), b16, 2);
        SearchUtils.c1(this.H, 80, 0, view);
        SearchUtils.Z0(this.H, 80, view, false);
    }
}

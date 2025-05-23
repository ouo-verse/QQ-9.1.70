package com.tencent.mobileqq.search.model;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends x {

    /* renamed from: h, reason: collision with root package name */
    private List<y> f283531h;

    /* renamed from: i, reason: collision with root package name */
    private String f283532i;

    /* renamed from: m, reason: collision with root package name */
    private un2.a f283533m;

    public d(un2.a aVar, List<y> list, String str) {
        this.f283531h = list;
        this.f283532i = str;
        this.f283533m = aVar;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public String l() {
        return HardCodeUtil.qqStr(R.string.n4u);
    }

    @Override // com.tencent.mobileqq.search.model.x
    public String m() {
        return this.f283532i;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public int n() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public List<y> o() {
        return this.f283531h;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public void q(View view) {
        SearchUtils.c1(this.f283532i, 70, 0, view);
        Intent intent = new Intent();
        intent.putExtra("last_key_words", this.f283532i);
        intent.putExtra("from_key", 0);
        intent.setClass(view.getContext(), ClassificationSearchActivity.class);
        ClassificationSearchActivity.V2((Activity) view.getContext(), intent, this.f283533m);
    }
}

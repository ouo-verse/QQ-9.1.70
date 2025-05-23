package com.tencent.mobileqq.search.model;

import addcontacts.AccountSearchPb$record;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f extends z {
    private AccountSearchPb$record G;
    private String H;
    public CharSequence I;

    public f(AccountSearchPb$record accountSearchPb$record, String str, CharSequence charSequence) {
        this.G = accountSearchPb$record;
        this.H = str;
        this.I = charSequence;
    }

    public boolean G() {
        boolean z16;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("name = ");
            sb5.append((Object) this.I);
            sb5.append(", isCert = ");
            if (this.G.has() && this.G.flag.get() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("GroupNetSearchModelPublicAcntItem", 2, sb5.toString());
        }
        if (this.G.flag.has() && this.G.flag.get() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.model.t
    public int k() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.t
    /* renamed from: l */
    public String getUin() {
        return String.valueOf(this.G.uin.get());
    }

    @Override // com.tencent.mobileqq.search.model.y
    /* renamed from: m */
    public CharSequence getDescription() {
        return HardCodeUtil.qqStr(R.string.n4z);
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
        return SearchUtils.C(this.G.name.get(), this.H);
    }

    @Override // com.tencent.mobileqq.search.model.y
    public void v(View view) {
        Context context = view.getContext();
        if (context != null && (context instanceof BaseActivity)) {
            com.tencent.mobileqq.activity.contact.addcontact.publicaccount.a.a((QQAppInterface) ((BaseActivity) context).getAppRuntime(), context, this.G.class_index.get(), String.valueOf(this.G.uin.get()), String.valueOf(this.G.uin.get()), this.G.account_flag.get(), this.G.name.get(), 4);
            SearchUtils.c1(this.H, 70, 0, view);
            SearchUtils.Z0(this.H, 70, view, false);
        }
    }
}

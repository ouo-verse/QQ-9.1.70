package com.tencent.mobileqq.search.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends x {

    /* renamed from: h, reason: collision with root package name */
    private List<y> f283534h;

    /* renamed from: i, reason: collision with root package name */
    private String f283535i;

    /* renamed from: m, reason: collision with root package name */
    private un2.a f283536m;

    public e(un2.a aVar, List<y> list, String str) {
        this.f283534h = list;
        this.f283535i = str;
        this.f283536m = aVar;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public String l() {
        if (UniteSearchActivity.f282684b0 == 12) {
            return HardCodeUtil.qqStr(R.string.n4x) + ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), BaseApplication.getContext());
        }
        return HardCodeUtil.qqStr(R.string.n4w);
    }

    @Override // com.tencent.mobileqq.search.model.x
    /* renamed from: m */
    public String getKeyword() {
        return this.f283535i;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public int n() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public List<y> o() {
        return this.f283534h;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public void q(View view) {
        SearchUtils.c1(this.f283535i, 90, 0, view);
        Intent intent = new Intent();
        intent.putExtra("from_key", 2);
        intent.putExtra("last_key_words", this.f283535i);
        intent.setClass(view.getContext(), ClassificationSearchActivity.class);
        intent.putExtra("jump_src_key", 0);
        ClassificationSearchActivity.V2((Activity) view.getContext(), intent, this.f283536m);
        Context context = view.getContext();
        if (context != null && (context instanceof BaseActivity)) {
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(((BaseActivity) context).app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "0", "0X8005D22", "0X8005D22", 0, 0, "0", "1", this.f283535i, "", false);
        }
    }
}

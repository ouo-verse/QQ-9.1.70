package com.tencent.mobileqq.search.model;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.searchengine.NetSearchEngine;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g extends x {

    /* renamed from: h, reason: collision with root package name */
    private List<y> f283537h;

    /* renamed from: i, reason: collision with root package name */
    private String f283538i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f283539m;

    public g(un2.a aVar, List<y> list, String str, boolean z16) {
        this.f283537h = list;
        this.f283538i = str;
        this.f283539m = z16;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public String l() {
        return HardCodeUtil.qqStr(R.string.n4v);
    }

    @Override // com.tencent.mobileqq.search.model.x
    /* renamed from: m */
    public String getKeyword() {
        return this.f283538i;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public int n() {
        return 1;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public List<y> o() {
        return this.f283537h;
    }

    @Override // com.tencent.mobileqq.search.model.x
    public void q(View view) {
        SearchUtils.c1(this.f283538i, 80, 0, view);
        new Intent().putExtra("last_key_words", this.f283538i);
        Long valueOf = Long.valueOf(Double.valueOf(NetSearchEngine.f284800m * 1000000.0d).longValue());
        String str = "https://qqweb.qq.com/m/relativegroup/index.html?source=qun_recent_search&keyword=" + URLEncoder.encode(this.f283538i) + "&gpstype=1&sid=AWSAPtjyiVRg92WelXNMAqd0&_bid=165&lon=" + Long.valueOf(Double.valueOf(NetSearchEngine.C * 1000000.0d).longValue()) + "&lat=" + valueOf;
        if (this.f283539m) {
            str = str + "&show_tab=hot";
        }
        if (QLog.isColorLevel()) {
            QLog.d("search", 2, "lastKeywords = " + this.f283538i + " jump url is : " + str);
        }
        Intent intent = new Intent(view.getContext(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("uin", ((BaseActivity) view.getContext()).app.getCurrentAccountUin());
        intent.putExtra("portraitOnly", true);
        intent.putExtra("hide_more_button", true);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("isShowAd", false);
        view.getContext().startActivity(intent);
    }
}

package com.tencent.mobileqq.search;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.search.searchlocal.model.SearchHistory;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends j {

    /* renamed from: f0, reason: collision with root package name */
    private SearchHistory f283118f0;

    /* renamed from: g0, reason: collision with root package name */
    private QQAppInterface f283119g0;

    public d(QQAppInterface qQAppInterface, SearchHistory searchHistory) {
        this.f283119g0 = qQAppInterface;
        this.f283118f0 = searchHistory;
    }

    @Override // com.tencent.mobileqq.search.j
    public String d() {
        return this.f283118f0.uin;
    }

    @Override // com.tencent.mobileqq.search.j
    public String f() {
        return this.f283118f0.displayName;
    }

    @Override // com.tencent.mobileqq.search.j
    public String g() {
        TroopInfo k3;
        if (this.f283118f0.type == 1 && (k3 = ((TroopManager) this.f283119g0.getManager(QQManagerFactory.TROOP_MANAGER)).k(this.f283118f0.uin)) != null && !TextUtils.isEmpty(k3.troopRemark)) {
            return "(" + k3.troopRemark + ")";
        }
        return "";
    }

    @Override // com.tencent.mobileqq.search.j
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public SearchHistory h() {
        return this.f283118f0;
    }

    @Override // com.tencent.mobileqq.search.l
    public void match(String str) {
    }
}

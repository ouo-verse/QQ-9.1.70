package com.tencent.mobileqq.config.business.tendoc;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.mobileqq.config.ai;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f202836a;

    /* renamed from: b, reason: collision with root package name */
    private final List<String> f202837b;

    public a() {
        ArrayList arrayList = new ArrayList();
        this.f202837b = arrayList;
        this.f202836a = 1;
        arrayList.add("mp.weixin.qq.com");
        arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_POST);
        arrayList.add("kandian.qq.com");
    }

    public static a c(ai[] aiVarArr) {
        return new a();
    }

    public boolean a() {
        if (this.f202836a == 1) {
            return true;
        }
        return false;
    }

    public boolean b(String str) {
        if (!TextUtils.isEmpty(str) && this.f202837b.contains(str)) {
            return true;
        }
        return false;
    }
}

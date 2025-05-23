package com.tencent.biz.pubaccount.util;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.contains(PublicAccountDetailActivityImpl.DOMAIN_MP_ARTICLE) && !str.contains(PublicAccountDetailActivityImpl.DOMAIN_MP_POST) && !str.contains("kandian.qq.com") && !str.contains("sqimg.qq.com") && !str.contains("web.kandian.qq.com") && !str.contains("webtest.kandian.qq.com")) {
            return false;
        }
        return true;
    }
}

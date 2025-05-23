package com.tencent.mobileqq.nearby.interestTag.impl;

import com.tencent.mobileqq.nearby.interestTag.IInterestTagInfoUtils;
import m92.b;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class InterestTagInfoUtilsImpl implements IInterestTagInfoUtils {
    private b mInterestTagInfoUtils = new b();

    @Override // com.tencent.mobileqq.nearby.interestTag.IInterestTagInfoUtils
    public Object convertFrom(JSONObject jSONObject) {
        return this.mInterestTagInfoUtils.b(jSONObject);
    }

    @Override // com.tencent.mobileqq.nearby.interestTag.IInterestTagInfoUtils
    public Object convertFrom(Object obj) {
        return this.mInterestTagInfoUtils.a(obj);
    }
}

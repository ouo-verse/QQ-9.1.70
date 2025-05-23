package com.tencent.luggage.wxa.zj;

import com.luggage.trace.ProfileInfo;
import com.tencent.luggage.wxa.ka.r;
import com.tencent.luggage.wxa.lk.j;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/luggage/wxa/va/d;", "kotlin.jvm.PlatformType", "appId", "a", "(Lcom/tencent/luggage/wxa/va/d;)Lcom/tencent/luggage/wxa/va/d;"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes9.dex */
final class g<InputType, ResultType> implements r {

    /* renamed from: a, reason: collision with root package name */
    public static final g f146729a = new g();

    @Override // com.tencent.luggage.wxa.ka.r
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final com.tencent.luggage.wxa.va.d invoke(com.tencent.luggage.wxa.va.d dVar) {
        ProfileInfo profileInfo;
        String jsonString;
        com.tencent.luggage.wxa.lk.a a16 = j.a(dVar.f143315a);
        String str = "";
        if (a16 != null) {
            a16.stopTrace("");
            profileInfo = a16.getProfileInfo();
        } else {
            profileInfo = null;
        }
        if (profileInfo != null && (jsonString = profileInfo.toJsonString()) != null) {
            str = jsonString;
        }
        return new com.tencent.luggage.wxa.va.d(str);
    }
}

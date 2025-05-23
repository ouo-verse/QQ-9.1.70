package com.tencent.biz.pubaccount.weishi.profile;

import UserGrowth.stGetPersonalInfoRsp;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/profile/a;", "", "LUserGrowth/stGetPersonalInfoRsp;", "rsp", "", "P", "", "errCode", "", "errMsg", "onFail", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public interface a {
    void P(stGetPersonalInfoRsp rsp);

    void onFail(int errCode, String errMsg);
}

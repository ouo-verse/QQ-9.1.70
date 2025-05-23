package com.tencent.mobileqq.partner;

import com.tencent.mobileqq.partner.signin.i;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u00030\u0002H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/partner/IPartnerApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lkotlin/Pair;", "", "getPartnerSignInDelegate", "Lcom/tencent/mobileqq/partner/signin/i;", "param", "", "openPartnerSignInDialog", "mutualmark_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPartnerApi extends QRouteApi {
    @NotNull
    Pair<String, ?> getPartnerSignInDelegate();

    void openPartnerSignInDialog(@NotNull i param);
}

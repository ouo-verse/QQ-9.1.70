package com.tencent.mobileqq.matchfriend.api.impl;

import com.tencent.mobileqq.matchfriend.api.ITacitInviteFriendApi;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/api/impl/TacitInviteFriendApiImpl;", "Lcom/tencent/mobileqq/matchfriend/api/ITacitInviteFriendApi;", "()V", DTConstants.TAG.API, "Lcom/tencent/mobileqq/matchfriend/api/impl/TacitRepository;", "getApi", "()Lcom/tencent/mobileqq/matchfriend/api/impl/TacitRepository;", "sendGrayMsg", "", "accountId", "", "appId", "", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class TacitInviteFriendApiImpl implements ITacitInviteFriendApi {
    private final TacitRepository api = new TacitRepository();

    public final TacitRepository getApi() {
        return this.api;
    }

    @Override // com.tencent.mobileqq.matchfriend.api.ITacitInviteFriendApi
    public void sendGrayMsg(String accountId, int appId) {
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        this.api.d(accountId, appId);
    }
}

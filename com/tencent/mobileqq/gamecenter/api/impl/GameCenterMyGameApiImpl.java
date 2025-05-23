package com.tencent.mobileqq.gamecenter.api.impl;

import com.tencent.mobileqq.gamecenter.api.IGameCenterMyGameApi;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/api/impl/GameCenterMyGameApiImpl;", "Lcom/tencent/mobileqq/gamecenter/api/IGameCenterMyGameApi;", "()V", "getMyGameRedPointPathInterface", "Lcom/tencent/mobileqq/tianshu/data/BusinessInfoCheckUpdateItem$DynamicRedPointPathInterface;", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GameCenterMyGameApiImpl implements IGameCenterMyGameApi {
    @Override // com.tencent.mobileqq.gamecenter.api.IGameCenterMyGameApi
    @NotNull
    public BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface getMyGameRedPointPathInterface() {
        return new cd1.a();
    }
}

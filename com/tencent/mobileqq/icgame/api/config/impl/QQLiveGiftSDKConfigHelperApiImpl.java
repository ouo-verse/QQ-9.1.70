package com.tencent.mobileqq.icgame.api.config.impl;

import com.tencent.mobileqq.icgame.api.config.IQQLiveGiftSDKConfigHelperApi;
import com.tencent.mobileqq.icgame.api.room.QQLiveGiftSDKConfigHelper;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/config/impl/QQLiveGiftSDKConfigHelperApiImpl;", "Lcom/tencent/mobileqq/icgame/api/config/IQQLiveGiftSDKConfigHelperApi;", "()V", "getSceneIdAuto", "", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class QQLiveGiftSDKConfigHelperApiImpl implements IQQLiveGiftSDKConfigHelperApi {
    @Override // com.tencent.mobileqq.icgame.api.config.IQQLiveGiftSDKConfigHelperApi
    public int getSceneIdAuto() {
        return QQLiveGiftSDKConfigHelper.INSTANCE.getSceneIdAuto();
    }
}

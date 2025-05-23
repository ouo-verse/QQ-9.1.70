package com.tencent.mobileqq.kandian.biz.common.api.impl;

import com.tencent.mobileqq.kandian.biz.common.api.IKanDianClassProvider;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import kotlin.Metadata;
import mqq.manager.Manager;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/common/api/impl/KanDianClassProviderImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/api/IKanDianClassProvider;", "()V", "getKanDianMergeManagerClass", "Ljava/lang/Class;", "Lmqq/manager/Manager;", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class KanDianClassProviderImpl implements IKanDianClassProvider {
    @Override // com.tencent.mobileqq.kandian.biz.common.api.IKanDianClassProvider
    public Class<? extends Manager> getKanDianMergeManagerClass() {
        return KandianMergeManager.class;
    }
}

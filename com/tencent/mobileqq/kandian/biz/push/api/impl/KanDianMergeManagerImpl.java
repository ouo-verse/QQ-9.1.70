package com.tencent.mobileqq.kandian.biz.push.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/push/api/impl/KanDianMergeManagerImpl;", "Lcom/tencent/mobileqq/kandian/biz/push/api/IKanDianMergeManager;", "()V", "kanDianMergeManager", "Lcom/tencent/mobileqq/kandian/glue/businesshandler/engine/KandianMergeManager;", "onCreate", "", "appRuntime", "Lmqq/app/AppRuntime;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class KanDianMergeManagerImpl implements IKanDianMergeManager {
    private KandianMergeManager kanDianMergeManager;

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        KandianMergeManager kandianMergeManager = this.kanDianMergeManager;
        if (kandianMergeManager != null) {
            kandianMergeManager.onDestroy();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        Manager manager = appRuntime != null ? appRuntime.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER) : null;
        this.kanDianMergeManager = manager instanceof KandianMergeManager ? (KandianMergeManager) manager : null;
    }
}

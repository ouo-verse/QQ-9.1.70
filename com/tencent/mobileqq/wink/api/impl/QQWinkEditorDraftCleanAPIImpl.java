package com.tencent.mobileqq.wink.api.impl;

import com.tencent.mobileqq.wink.api.IQQWinkEditorDraftCleanAPI;
import com.tencent.mobileqq.wink.editdraft.WinkEditorDraftCleanUtil;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/api/impl/QQWinkEditorDraftCleanAPIImpl;", "Lcom/tencent/mobileqq/wink/api/IQQWinkEditorDraftCleanAPI;", "()V", "deleteQCircleDraft", "", "missionId", "", "deleteQZoneDraft", "missionIds", "", "tryBatchDeleteQCircleDraft", "tryBatchDeleteQZoneDraft", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class QQWinkEditorDraftCleanAPIImpl implements IQQWinkEditorDraftCleanAPI {
    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorDraftCleanAPI
    public void deleteQCircleDraft(@Nullable String missionId) {
        WinkEditorDraftCleanUtil.f318495a.f(missionId);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorDraftCleanAPI
    public void deleteQZoneDraft(@Nullable List<String> missionIds) {
        WinkEditorDraftCleanUtil.f318495a.g(missionIds);
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorDraftCleanAPI
    public void tryBatchDeleteQCircleDraft() {
        WinkEditorDraftCleanUtil.f318495a.n();
    }

    @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorDraftCleanAPI
    public void tryBatchDeleteQZoneDraft() {
        WinkEditorDraftCleanUtil.f318495a.o();
    }
}

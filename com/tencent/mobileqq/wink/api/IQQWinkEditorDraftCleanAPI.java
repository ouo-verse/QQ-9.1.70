package com.tencent.mobileqq.wink.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/api/IQQWinkEditorDraftCleanAPI;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "deleteQCircleDraft", "", "missionId", "", "deleteQZoneDraft", "missionIds", "", "tryBatchDeleteQCircleDraft", "tryBatchDeleteQZoneDraft", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IQQWinkEditorDraftCleanAPI extends QRouteApi {
    void deleteQCircleDraft(@Nullable String missionId);

    void deleteQZoneDraft(@Nullable List<String> missionIds);

    void tryBatchDeleteQCircleDraft();

    void tryBatchDeleteQZoneDraft();
}

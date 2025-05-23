package com.tencent.aelight.camera.api;

import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/aelight/camera/api/IAEFlashShowMaterialManagerUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getRandomGuildPic", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "initAsync", "", "forceRefresh", "", "aelight-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAEFlashShowMaterialManagerUtil extends QRouteApi {
    @Nullable
    AEMaterialMetaData getRandomGuildPic();

    void initAsync(boolean forceRefresh);
}

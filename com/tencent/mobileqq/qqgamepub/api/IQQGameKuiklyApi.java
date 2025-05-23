package com.tencent.mobileqq.qqgamepub.api;

import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqgamepub/api/IQQGameKuiklyApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/kuikly/core/render/android/b;", "renderExport", "", "registerExternalModule", "", "", "bundleList", "updateGamePubAccountKuikly", "qqgamepubaccount-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQGameKuiklyApi extends QRouteApi {
    void registerExternalModule(@NotNull b renderExport);

    void updateGamePubAccountKuikly(@Nullable List<String> bundleList);
}

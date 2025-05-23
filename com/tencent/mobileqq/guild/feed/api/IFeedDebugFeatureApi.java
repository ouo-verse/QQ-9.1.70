package com.tencent.mobileqq.guild.feed.api;

import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/IFeedDebugFeatureApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/mobileqq/guild/feed/api/e;", "createFeedEditorSchemeDebugFragmentImpl", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes13.dex */
public interface IFeedDebugFeatureApi extends QRouteApi {
    @NotNull
    e createFeedEditorSchemeDebugFragmentImpl(@NotNull Fragment fragment);
}

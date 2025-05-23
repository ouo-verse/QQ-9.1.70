package com.tencent.mobileqq.emoticonview.emoticontabs.hotpicsearch.api;

import com.tencent.mobileqq.emoticonview.AbsEmoticonPanelLifecycleObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QRouteFactory(singleton = false)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/emoticontabs/hotpicsearch/api/IHotPicSearchTabHelperBuilder;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "build", "Lcom/tencent/mobileqq/emoticonview/AbsEmoticonPanelLifecycleObserver;", "providerID", "", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IHotPicSearchTabHelperBuilder extends QRouteApi {
    @Nullable
    AbsEmoticonPanelLifecycleObserver build(int providerID);
}

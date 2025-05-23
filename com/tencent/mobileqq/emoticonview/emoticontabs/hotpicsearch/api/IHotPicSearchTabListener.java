package com.tencent.mobileqq.emoticonview.emoticontabs.hotpicsearch.api;

import com.tencent.mobileqq.emoticon.IEmotionTabCreateListener;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/emoticontabs/hotpicsearch/api/IHotPicSearchTabListener;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "build", "Lcom/tencent/mobileqq/emoticon/IEmotionTabCreateListener;", "app", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanelApp;", "isMergeHotPicExperiment", "", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IHotPicSearchTabListener extends QRouteApi {
    @NotNull
    IEmotionTabCreateListener build(@Nullable IEmoticonMainPanelApp app);

    boolean isMergeHotPicExperiment();
}

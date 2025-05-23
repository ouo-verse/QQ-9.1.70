package com.tencent.mobileqq.emoticonview.emoticontabs.hotpicsearch.api;

import com.tencent.mobileqq.emoticon.IEmotionPanelBuilder;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.vas.VasReportUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QRouteFactory(singleton = false)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u00012\u00020\u0002J4\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/emoticontabs/hotpicsearch/api/IHotPicSearchTabContentBuilder;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/emoticon/IEmotionPanelBuilder;", "init", "", "app", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanelApp;", "columnNum", "", "panelType", VasReportUtils.BUSINESS_TYPE_EMOTION, "callback", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "qqemoticonpanel-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IHotPicSearchTabContentBuilder extends QRouteApi, IEmotionPanelBuilder {
    void init(@Nullable IEmoticonMainPanelApp app, int columnNum, int panelType, int emotionType, @Nullable EmoticonCallback callback);
}

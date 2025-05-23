package com.tencent.mobileqq.zplan.emoticon.api;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticon.IEmotionPanelBuilder;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanEmotionPanelBuilder extends QRouteApi, IEmotionPanelBuilder {
    EmotionInjectionInfo init(IEmoticonMainPanelApp iEmoticonMainPanelApp, Context context, int i3, int i16, EmoticonCallback emoticonCallback, ViewGroup viewGroup, p pVar);
}

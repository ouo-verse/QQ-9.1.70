package com.tencent.mobileqq.zplan.emoticon.api.impl;

import com.tencent.mobileqq.emoticon.IEmotionTabCreateListener;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmotionPanelTabCreateListener;
import kotlinx.coroutines.CoroutineScope;
import oh3.a;

/* loaded from: classes34.dex */
public class ZPlanEmotionPanelTabCreateListenerImpl implements IZPlanEmotionPanelTabCreateListener {
    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmotionPanelTabCreateListener
    public IEmotionTabCreateListener build(IEmoticonMainPanelApp iEmoticonMainPanelApp, CoroutineScope coroutineScope) {
        return new a(iEmoticonMainPanelApp, coroutineScope);
    }
}

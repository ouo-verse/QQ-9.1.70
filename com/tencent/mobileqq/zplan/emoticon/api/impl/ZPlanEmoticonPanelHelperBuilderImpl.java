package com.tencent.mobileqq.zplan.emoticon.api.impl;

import com.tencent.mobileqq.emoticonview.AbsEmoticonPanelLifecycleObserver;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonPanelHelperBuilder;
import com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonPanelLifecycleObserver;
import com.tencent.mobileqq.zplan.emoticon.panel.util.c;

/* loaded from: classes34.dex */
public class ZPlanEmoticonPanelHelperBuilderImpl implements IZPlanEmoticonPanelHelperBuilder {
    @Override // com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonPanelHelperBuilder
    public AbsEmoticonPanelLifecycleObserver build(int i3, int i16, String str) {
        ZPlanEmoticonApi zPlanEmoticonApi = ZPlanEmoticonApi.INSTANCE;
        zPlanEmoticonApi.updateVersion(i16, str);
        if (zPlanEmoticonApi.getVersion(i16) != 2) {
            return new c(i3);
        }
        return new ZPlanEmoticonPanelLifecycleObserver(i3);
    }
}

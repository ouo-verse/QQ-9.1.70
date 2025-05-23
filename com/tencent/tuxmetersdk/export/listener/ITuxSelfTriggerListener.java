package com.tencent.tuxmetersdk.export.listener;

import com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback;
import com.tencent.tuxmetersdk.impl.TuxSurveyConfig;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface ITuxSelfTriggerListener {
    void onSelfTrigger(List<TuxSurveyConfig> list, ITuxSurveyEventCallback iTuxSurveyEventCallback);
}

package com.tencent.tuxmetersdk.export.listener;

import com.tencent.tuxmetersdk.export.injector.event.ITuxSurveyEventCallback;
import com.tencent.tuxmetersdk.impl.TuxSurveyConfig;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface ITuxTriggerListener {
    void onTrigger(TuxSurveyConfig tuxSurveyConfig, ITuxSurveyEventCallback iTuxSurveyEventCallback);
}

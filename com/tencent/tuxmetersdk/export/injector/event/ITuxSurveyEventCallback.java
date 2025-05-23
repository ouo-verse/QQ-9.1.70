package com.tencent.tuxmetersdk.export.injector.event;

import com.tencent.tuxmetersdk.export.config.BeforeTriggerErrorCode;
import com.tencent.tuxmetersdk.export.config.DisappearReason;
import com.tencent.tuxmetersdk.export.config.EventErrorCode;
import com.tencent.tuxmetersdk.export.config.TriggerErrorCode;
import com.tencent.tuxmetersdk.impl.TuxSurveyConfig;
import com.tencent.tuxmetersdk.model.SurveyConfig;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface ITuxSurveyEventCallback {
    void onClick(TuxSurveyConfig tuxSurveyConfig);

    void onDelayDeliver(TuxSurveyConfig tuxSurveyConfig, long j3);

    void onDeliverWhenTrigger(TuxSurveyConfig tuxSurveyConfig);

    void onDisappear(TuxSurveyConfig tuxSurveyConfig, DisappearReason disappearReason);

    void onEventAction(String str, Map<String, String> map);

    void onEventErrorCode(EventErrorCode eventErrorCode, Map<String, String> map, TuxSurveyConfig tuxSurveyConfig);

    void onHalfFloatingLayerDisappear(TuxSurveyConfig tuxSurveyConfig, DisappearReason disappearReason);

    void onHalfFloatingLayerShow(TuxSurveyConfig tuxSurveyConfig);

    void onPreSubmit(TuxSurveyConfig tuxSurveyConfig);

    void onProcessRule(SurveyConfig surveyConfig, RuleProcessInfo ruleProcessInfo);

    void onReceiveBeforeTriggerErrorCode(TuxSurveyConfig tuxSurveyConfig, BeforeTriggerErrorCode beforeTriggerErrorCode);

    void onReceiveTriggerErrorCode(TuxSurveyConfig tuxSurveyConfig, TriggerErrorCode triggerErrorCode);

    void onShow(TuxSurveyConfig tuxSurveyConfig);

    void onStartWhenTrigger(TuxSurveyConfig tuxSurveyConfig);

    void onSubmit(TuxSurveyConfig tuxSurveyConfig);
}

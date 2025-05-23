package com.tencent.tuxmeterqui.config;

import com.tencent.tuxmetersdk.impl.TuxSurveyConfig;
import com.tencent.tuxmetersdk.model.Option;
import com.tencent.tuxmetersdk.model.Question;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface TuxEventListener {
    void onStarQuestionClick(Question question, Option option, String str);

    void onSurveyClose(TuxSurveyConfig tuxSurveyConfig);

    void onSurveyDisplayed(TuxSurveyConfig tuxSurveyConfig);

    void onSurveySubmit(TuxSurveyConfig tuxSurveyConfig);
}

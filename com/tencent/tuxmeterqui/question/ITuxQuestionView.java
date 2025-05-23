package com.tencent.tuxmeterqui.question;

import com.tencent.tuxmeterqui.config.TuxQuestionConfig;
import com.tencent.tuxmetersdk.model.Question;
import com.tencent.tuxmetersdk.model.Resource;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface ITuxQuestionView {
    Question getQuestion();

    boolean hasAnsweredInRequired();

    void setViewVisibility(boolean z16);

    void updateQuestionNumber(int i3);

    void updateView(Question question, Resource resource, TuxQuestionConfig tuxQuestionConfig);
}

package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProJoinGuildChoiceQuestionItem extends Serializable {
    ArrayList<String> getAnswers();

    String getCorrectAnswer();

    String getQuestion();

    String toString();
}

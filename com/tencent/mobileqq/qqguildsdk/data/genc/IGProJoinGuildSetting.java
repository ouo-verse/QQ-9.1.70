package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProJoinGuildSetting extends Serializable {
    IGProJoinGuildChoiceQuestion getChoiceQuestion();

    int getOptionType();

    IGProJoinGuildWordQuestion getWordQuestion();

    String toString();
}

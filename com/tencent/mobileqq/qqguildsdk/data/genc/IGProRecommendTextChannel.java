package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProRecommendTextChannel extends Serializable {
    ArrayList<String> getAvatars();

    boolean getIsActive();

    ArrayList<String> getMemberAvatars();

    ArrayList<com.tencent.mobileqq.qqguildsdk.data.fe> getMsgAbstracts();

    String getMsgSummary();

    int getNoreadNum();

    String getTagMsg();

    String toString();
}

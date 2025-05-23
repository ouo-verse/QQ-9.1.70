package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProAISearchUserSessionCategory extends Serializable {
    String getCategoryName();

    ArrayList<IGProAISearchSession> getSessionList();

    String toString();
}

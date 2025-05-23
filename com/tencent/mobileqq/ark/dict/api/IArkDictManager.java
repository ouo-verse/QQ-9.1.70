package com.tencent.mobileqq.ark.dict.api;

import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.ark.dict.g;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
/* loaded from: classes11.dex */
public interface IArkDictManager extends IRuntimeService {
    void clearDict();

    bc getAnalysisThread();

    void initWordData();

    boolean isUseTestDict();

    void loadTestDict();

    void reloadWordData();

    void setUseTestDict(boolean z16);

    void updateLocalDict();

    g wordSegment(String str);
}

package com.tencent.tuxmetersdk.export.listener;

import com.tencent.tuxmetersdk.model.SurveyConfig;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface ITuxRefreshListener {
    void onFailure(int i3, String str);

    void onSuccess(List<SurveyConfig> list, long j3, long j16);
}

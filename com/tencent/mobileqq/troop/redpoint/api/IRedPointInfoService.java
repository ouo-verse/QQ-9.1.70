package com.tencent.mobileqq.troop.redpoint.api;

import android.view.View;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.redpoint.b;
import com.tencent.mobileqq.troop.redpoint.c;
import java.util.HashMap;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process = {""})
/* loaded from: classes19.dex */
public interface IRedPointInfoService extends IRuntimeService {
    void addRedPointListener(c cVar);

    void cleanRedPointInfoById(String str, String str2, int i3);

    void cleanRedPointInfoByIds(String str, String str2, List<Integer> list);

    b getRedPointInfo(String str, String str2);

    void notifyRedPointViewClick(String str, String str2, View view);

    void removeRedPointListener(c cVar);

    void updateRedPointInfo(String str, String str2, int i3, int i16);

    void updateRedPointInfos(String str, String str2, HashMap<Integer, Integer> hashMap);
}

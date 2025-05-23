package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopAioKeywordService extends IRuntimeService {
    void getTroopAioKeywordTipInfo(List<Integer> list, com.tencent.mobileqq.troop.observer.b bVar);
}

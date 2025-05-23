package com.tencent.mobileqq.stranger.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes18.dex */
public interface IStrangerService extends IRuntimeService {
    void deleteStrangers(List<Long> list);

    void notifyUI(int i3, boolean z16, Object obj);
}

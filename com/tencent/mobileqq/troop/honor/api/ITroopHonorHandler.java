package com.tencent.mobileqq.troop.honor.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopHonorHandler extends IRuntimeService {
    void getHostTroopHonorList();

    void getHostTroopHonorList(boolean z16);
}

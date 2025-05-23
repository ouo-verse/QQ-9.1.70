package com.tencent.mobileqq.troop.troopgag.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.troopgag.data.d;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopGagService extends IRuntimeService {
    d getSelfGagInfo(String str, boolean z16);
}

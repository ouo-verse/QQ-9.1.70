package com.qwallet.temp;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.troopgag.data.d;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {""})
/* loaded from: classes3.dex */
public interface ITroopGagMgr extends IRuntimeService {
    d getSelfGagInfo(String str, boolean z16);

    boolean isMySelfSilent(String str);
}

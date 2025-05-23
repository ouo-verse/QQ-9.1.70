package com.tencent.mobileqq.troop.api.troopcreate;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopCreateGrayMsg extends IRuntimeService {
    void addCreateNewTroopGrayTips(String str, boolean z16, String str2);

    void addTroopCreatedGrayTipsMr(String str);
}

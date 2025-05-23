package com.tencent.mobileqq.troop.troopcreate.tempapi;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.search.model.k;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ICreateTroopForUI extends IRuntimeService {
    String getTroopUinFromModel(k kVar);

    int getUinTypeFromModel(k kVar);
}

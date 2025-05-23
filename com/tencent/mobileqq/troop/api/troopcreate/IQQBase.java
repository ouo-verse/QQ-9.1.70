package com.tencent.mobileqq.troop.api.troopcreate;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface IQQBase extends IRuntimeService {
    String getAccountNickName(AppInterface appInterface, String str);

    int getAnimationTypeR2L();

    int getBackButtonSideL();

    String getHeaderText(String str);
}

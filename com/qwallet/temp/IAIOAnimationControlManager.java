package com.qwallet.temp;

import com.tencent.mobileqq.qroute.annotation.Service;
import d4.c;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {""})
/* loaded from: classes3.dex */
public interface IAIOAnimationControlManager extends IRuntimeService {
    boolean addPlayAnimationList(c cVar, boolean z16);

    void removeAllGiftMsgByTroop(String str);
}

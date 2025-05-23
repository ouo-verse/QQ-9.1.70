package com.tencent.mobileqq.ark.api.impl;

import com.tencent.mobileqq.ark.api.IArkAppLifeEvent;
import com.tencent.mobileqq.ark.event.ArkAppCenterEvent;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkAppLifeEventImpl implements IArkAppLifeEvent {
    @Override // com.tencent.mobileqq.ark.api.IArkAppLifeEvent
    public void attachEvent(String str, String str2, i91.a aVar) {
        ArkAppCenterEvent.a(str, str2, aVar);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkAppLifeEvent
    public void detachEvent(String str, String str2) {
        ArkAppCenterEvent.b(str, str2);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkAppLifeEvent
    public void doAction(int i3, String str, Object obj) {
        ArkAppCenterEvent.c(i3, str, obj);
    }
}

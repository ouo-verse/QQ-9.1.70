package com.qwallet.temp.impl;

import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import d4.e;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a implements e {
    @Override // d4.e
    public void a(BaseQQAppInterface baseQQAppInterface, int i3, String str, String str2, long j3, boolean z16, int i16, int i17, boolean z17, int i18, int i19, boolean z18, long j16, Bundle bundle, ArrayList<AtTroopMemberInfo> arrayList, String str3, boolean z19, MessageRecord messageRecord, int i26) {
        ChatActivityFacade.c1((QQAppInterface) baseQQAppInterface, i3, str, str2, j3, z16, i16, i17, z17, i18, i19, z18, j16, bundle, arrayList, str3, z19, messageRecord, i26);
    }

    @Override // d4.e
    public MessageForPtt b(BaseQQAppInterface baseQQAppInterface, String str, p pVar, int i3, int i16) {
        return ChatActivityFacade.J((QQAppInterface) baseQQAppInterface, str, pVar, i3, i16);
    }
}

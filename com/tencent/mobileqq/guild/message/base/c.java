package com.tencent.mobileqq.guild.message.base;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class c implements r {
    public abstract com.tencent.mobileqq.troop.navigatebar.b a(AppInterface appInterface);

    public abstract com.tencent.mobileqq.troop.navigatebar.c b(BaseMessageManager.a aVar);

    public abstract String c(MessageRecord messageRecord);

    public abstract boolean d(AppRuntime appRuntime, String str, long j3, long j16, boolean z16, Bundle bundle, int i3);

    public abstract void e(AppRuntime appRuntime, String str, com.tencent.mobileqq.troop.data.c cVar, MessageRecord messageRecord, boolean z16);
}

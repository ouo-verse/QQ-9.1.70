package com.tencent.mobileqq.activity.recent.msgbox;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;

/* compiled from: P */
/* loaded from: classes10.dex */
public interface c {
    void a(Context context, BaseQQAppInterface baseQQAppInterface, Message message, int i3, MsgSummary msgSummary, boolean z16, boolean z17);

    String b(AppInterface appInterface, String str, int i3, int i16, Message message);

    int c(AppInterface appInterface, String str, int i3, int i16, Message message);

    boolean d(AppInterface appInterface, String str, int i3);
}

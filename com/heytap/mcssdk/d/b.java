package com.heytap.mcssdk.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b extends c {
    @Override // com.heytap.mcssdk.d.d
    public BaseMode a(Context context, int i3, Intent intent) {
        if (4103 != i3 && 4098 != i3) {
            return null;
        }
        BaseMode a16 = a(intent);
        com.heytap.mcssdk.d.k().a((DataMessage) a16, com.heytap.mcssdk.d.f36151b, i3);
        return a16;
    }

    @Override // com.heytap.mcssdk.d.c
    protected BaseMode a(Intent intent) {
        try {
            DataMessage dataMessage = new DataMessage();
            dataMessage.setMessageID(com.heytap.mcssdk.f.a.b(intent.getStringExtra(com.heytap.mcssdk.a.a.f36093c)));
            dataMessage.setTaskID(com.heytap.mcssdk.f.a.b(intent.getStringExtra(com.heytap.mcssdk.a.a.f36094d)));
            dataMessage.setAppPackage(com.heytap.mcssdk.f.a.b(intent.getStringExtra(com.heytap.mcssdk.a.a.f36095e)));
            dataMessage.setTitle(com.heytap.mcssdk.f.a.b(intent.getStringExtra("title")));
            dataMessage.setContent(com.heytap.mcssdk.f.a.b(intent.getStringExtra("content")));
            dataMessage.setDescription(com.heytap.mcssdk.f.a.b(intent.getStringExtra("description")));
            String b16 = com.heytap.mcssdk.f.a.b(intent.getStringExtra(com.heytap.mcssdk.a.a.f36099i));
            dataMessage.setNotifyID(TextUtils.isEmpty(b16) ? 0 : Integer.parseInt(b16));
            return dataMessage;
        } catch (Exception e16) {
            com.heytap.mcssdk.f.c.b("OnHandleIntent--" + e16.getMessage());
            return null;
        }
    }
}

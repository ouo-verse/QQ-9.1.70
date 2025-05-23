package com.heytap.mcssdk.d;

import android.content.Context;
import android.content.Intent;
import com.heytap.msp.push.mode.BaseMode;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a extends c {
    @Override // com.heytap.mcssdk.d.d
    public BaseMode a(Context context, int i3, Intent intent) {
        if (4105 == i3) {
            return a(intent);
        }
        return null;
    }

    @Override // com.heytap.mcssdk.d.c
    protected BaseMode a(Intent intent) {
        try {
            com.heytap.mcssdk.c.a aVar = new com.heytap.mcssdk.c.a();
            aVar.a(Integer.parseInt(com.heytap.mcssdk.f.a.b(intent.getStringExtra("command"))));
            aVar.b(Integer.parseInt(com.heytap.mcssdk.f.a.b(intent.getStringExtra("code"))));
            aVar.e(com.heytap.mcssdk.f.a.b(intent.getStringExtra("content")));
            aVar.a(com.heytap.mcssdk.f.a.b(intent.getStringExtra(com.heytap.mcssdk.a.a.f36102l)));
            aVar.b(com.heytap.mcssdk.f.a.b(intent.getStringExtra(com.heytap.mcssdk.a.a.f36103m)));
            aVar.f(com.heytap.mcssdk.f.a.b(intent.getStringExtra(com.heytap.mcssdk.a.a.f36095e)));
            com.heytap.mcssdk.f.c.b("OnHandleIntent-message:" + aVar.toString());
            return aVar;
        } catch (Exception e16) {
            com.heytap.mcssdk.f.c.b("OnHandleIntent--" + e16.getMessage());
            return null;
        }
    }
}

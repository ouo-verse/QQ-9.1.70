package com.heytap.mcssdk.d;

import android.content.Context;
import android.content.Intent;
import com.heytap.msp.push.mode.BaseMode;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class c implements d {
    public static List<BaseMode> a(Context context, Intent intent) {
        int i3;
        BaseMode a16;
        if (intent == null) {
            return null;
        }
        try {
            i3 = Integer.parseInt(com.heytap.mcssdk.f.a.b(intent.getStringExtra("type")));
        } catch (Exception e16) {
            com.heytap.mcssdk.f.c.e("MessageParser--getMessageByIntent--Exception:" + e16.getMessage());
            i3 = 4096;
        }
        com.heytap.mcssdk.f.c.b("MessageParser--getMessageByIntent--type:" + i3);
        ArrayList arrayList = new ArrayList();
        for (d dVar : com.heytap.mcssdk.d.k().o()) {
            if (dVar != null && (a16 = dVar.a(context, i3, intent)) != null) {
                arrayList.add(a16);
            }
        }
        return arrayList;
    }

    protected abstract BaseMode a(Intent intent);
}

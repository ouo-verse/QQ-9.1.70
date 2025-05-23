package com.heytap.mcssdk.f;

import android.content.Context;
import android.content.Intent;
import com.heytap.msp.push.mode.MessageStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f36197a = "type";

    /* renamed from: b, reason: collision with root package name */
    private static final String f36198b = "count";

    /* renamed from: c, reason: collision with root package name */
    private static final String f36199c = "list";

    /* renamed from: d, reason: collision with root package name */
    private static final int f36200d = 1017;

    public static void a(Context context, MessageStat messageStat) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(messageStat);
        a(context, linkedList);
    }

    private static void b(Context context, List<MessageStat> list) {
        try {
            Intent intent = new Intent();
            intent.setAction(com.heytap.mcssdk.d.k().m());
            intent.setPackage(com.heytap.mcssdk.d.k().l());
            intent.putExtra(com.heytap.mcssdk.a.a.f36095e, context.getPackageName());
            intent.putExtra("type", 12291);
            intent.putExtra("count", list.size());
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<MessageStat> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toJsonObject());
            }
            intent.putStringArrayListExtra("list", arrayList);
            context.startService(intent);
        } catch (Exception e16) {
            c.e("statisticMessage--Exception" + e16.getMessage());
        }
    }

    public static void a(Context context, List<MessageStat> list) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(list);
        c.b("isSupportStatisticByMcs:" + a(context) + ",list size:" + linkedList.size());
        if (linkedList.size() <= 0 || !a(context)) {
            return;
        }
        b(context, linkedList);
    }

    private static boolean a(Context context) {
        String l3 = com.heytap.mcssdk.d.k().l();
        return g.a(context, l3) && g.b(context, l3) >= 1017;
    }
}

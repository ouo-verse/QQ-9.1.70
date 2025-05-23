package com.xiaomi.push.service;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes28.dex */
public class be {

    /* renamed from: a, reason: collision with root package name */
    private static Object f389704a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, Queue<String>> f389705b = new HashMap();

    public static boolean a(XMPushService xMPushService, String str, String str2) {
        synchronized (f389704a) {
            SharedPreferences sharedPreferences = xMPushService.getSharedPreferences("push_message_ids", 0);
            Queue<String> queue = f389705b.get(str);
            if (queue == null) {
                String[] split = sharedPreferences.getString(str, "").split(",");
                LinkedList linkedList = new LinkedList();
                for (String str3 : split) {
                    linkedList.add(str3);
                }
                f389705b.put(str, linkedList);
                queue = linkedList;
            }
            if (queue.contains(str2)) {
                return true;
            }
            queue.add(str2);
            if (queue.size() > 25) {
                queue.poll();
            }
            String d16 = com.xiaomi.push.ag.d(queue, ",");
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, d16);
            edit.commit();
            return false;
        }
    }
}

package com.tencent.mobileqq.onlinestatus.utils;

import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ae {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<Integer, AppRuntime.Status> f256335a;

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap<Integer, AppRuntime.Status> f256336b;

    static {
        HashMap<Integer, AppRuntime.Status> hashMap = new HashMap<>();
        f256335a = hashMap;
        HashMap<Integer, AppRuntime.Status> hashMap2 = new HashMap<>();
        f256336b = hashMap2;
        AppRuntime.Status status = AppRuntime.Status.online;
        hashMap.put(10, status);
        AppRuntime.Status status2 = AppRuntime.Status.offline;
        hashMap.put(20, status2);
        AppRuntime.Status status3 = AppRuntime.Status.away;
        hashMap.put(30, status3);
        AppRuntime.Status status4 = AppRuntime.Status.invisiable;
        hashMap.put(40, status4);
        hashMap.put(50, AppRuntime.Status.busy);
        hashMap.put(60, AppRuntime.Status.qme);
        hashMap.put(70, AppRuntime.Status.dnd);
        AppRuntime.Status status5 = AppRuntime.Status.receiveofflinemsg;
        hashMap.put(-55, status5);
        hashMap.put(201, status5);
        hashMap.put(-6, status2);
        hashMap.put(250, status2);
        hashMap.put(95, status2);
        hashMap.put(100, status2);
        hashMap.put(101, status2);
        hashMap.put(90, status);
        hashMap.put(91, status);
        hashMap2.put(31, status3);
        hashMap2.put(11, status);
        hashMap2.put(41, status4);
    }

    public static boolean a(AppRuntime.Status status) {
        if (status != AppRuntime.Status.away && status != AppRuntime.Status.dnd && status != AppRuntime.Status.busy) {
            return false;
        }
        return true;
    }

    public static AppRuntime.Status b(int i3) {
        HashMap<Integer, AppRuntime.Status> hashMap = f256335a;
        if (hashMap.containsKey(Integer.valueOf(i3))) {
            return hashMap.get(Integer.valueOf(i3));
        }
        if (OnlineStatusToggleUtils.d()) {
            HashMap<Integer, AppRuntime.Status> hashMap2 = f256336b;
            if (hashMap2.containsKey(Integer.valueOf(i3))) {
                return hashMap2.get(Integer.valueOf(i3));
            }
        }
        return AppRuntime.Status.offline;
    }

    public static AppRuntime.Status c(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar) {
        byte u16 = cVar.u();
        HashMap<Integer, AppRuntime.Status> hashMap = f256335a;
        if (hashMap.containsKey(Integer.valueOf(u16))) {
            return hashMap.get(Integer.valueOf(u16));
        }
        return AppRuntime.Status.offline;
    }
}

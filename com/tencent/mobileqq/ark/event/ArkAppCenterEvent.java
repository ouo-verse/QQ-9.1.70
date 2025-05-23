package com.tencent.mobileqq.ark.event;

import i91.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkAppCenterEvent {

    /* renamed from: a, reason: collision with root package name */
    private static final DictObservers f199480a = new DictObservers();

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class DictObservers extends HashMap<String, Observers> {
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class Observers extends HashMap<String, a> {
    }

    public static void a(String str, String str2, a aVar) {
        if (str == null) {
            return;
        }
        DictObservers dictObservers = f199480a;
        Observers observers = dictObservers.get(str);
        if (observers == null) {
            observers = new Observers();
            dictObservers.put(str, observers);
        }
        observers.put(str2, aVar);
    }

    public static void b(String str, String str2) {
        if (str == null) {
            for (Map.Entry<String, Observers> entry : f199480a.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().remove(str2);
                }
            }
            return;
        }
        Observers observers = f199480a.get(str);
        if (observers != null) {
            observers.remove(str2);
        }
    }

    public static void c(int i3, String str, Object obj) {
        Observers observers = f199480a.get(str);
        if (observers != null) {
            for (Map.Entry<String, a> entry : observers.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().a(i3, str, obj);
                }
            }
        }
    }
}

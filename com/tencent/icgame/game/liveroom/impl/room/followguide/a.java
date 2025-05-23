package com.tencent.icgame.game.liveroom.impl.room.followguide;

import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static InterfaceC5835a f115327a;

    /* renamed from: b, reason: collision with root package name */
    private static HashSet<Integer> f115328b = new HashSet<>();

    /* compiled from: P */
    /* renamed from: com.tencent.icgame.game.liveroom.impl.room.followguide.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC5835a {
        void show();
    }

    public static boolean a() {
        return !f115328b.isEmpty();
    }

    public static void b() {
        f115327a = null;
        f115328b.clear();
    }

    public static void c(int i3, boolean z16) {
        InterfaceC5835a interfaceC5835a;
        if (z16) {
            f115328b.add(Integer.valueOf(i3));
        } else {
            f115328b.remove(Integer.valueOf(i3));
        }
        if (f115328b.isEmpty() && (interfaceC5835a = f115327a) != null) {
            interfaceC5835a.show();
        }
    }

    public static void d(InterfaceC5835a interfaceC5835a) {
        if (f115328b.isEmpty()) {
            interfaceC5835a.show();
        } else {
            f115327a = interfaceC5835a;
        }
    }
}

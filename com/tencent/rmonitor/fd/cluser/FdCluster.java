package com.tencent.rmonitor.fd.cluser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes25.dex */
public class FdCluster {

    /* renamed from: a, reason: collision with root package name */
    private static final c[] f365569a = {new d(1, "socket:["), new d(6, "pipe:["), new b(2, "anon_inode:[eventpoll]", "anon_inode:[eventfd]"), new d(3, "/dev/ashmem"), new d(4, "/dmabuf", "anon_inode:dmabuf", "/dev/ion"), new d(5, "/data/", "/storage/", "/sdcard/"), new d(9, "/system/", "/vendor/", "/apex/", "/sys/", "/proc/"), new d(7, "/dev/mali", "/dev/kgsl-3d", "/dev/pvrsrvkm"), new d(8, "/dev/")};

    private void a(int i3, String str, Map<Integer, v04.a> map) {
        v04.a aVar = map.get(Integer.valueOf(i3));
        if (aVar == null) {
            aVar = new v04.a(i3);
            map.put(Integer.valueOf(i3), aVar);
        }
        aVar.c(str);
    }

    public static v04.a c(Map<Integer, v04.a> map) {
        if (map != null && !map.isEmpty()) {
            ArrayList arrayList = new ArrayList(map.values());
            Collections.sort(arrayList);
            return (v04.a) arrayList.get(0);
        }
        return null;
    }

    @Nullable
    private static c d(String str) {
        for (c cVar : f365569a) {
            if (cVar.match(str)) {
                return cVar;
            }
        }
        return null;
    }

    public static String matchFdType(String str) {
        c d16 = d(str);
        if (d16 != null) {
            return y04.c.m(d16.a());
        }
        return "others";
    }

    public Map<Integer, v04.a> b(List<String> list) {
        HashMap hashMap = new HashMap();
        for (String str : list) {
            c d16 = d(str);
            if (d16 != null) {
                a(d16.a(), str, hashMap);
            } else {
                a(10, str, hashMap);
            }
        }
        return hashMap;
    }
}

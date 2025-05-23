package com.tencent.mobileqq.guild.media.core.data;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes14.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, Object> f228070a = new HashMap();

    public Object a(int i3) {
        return this.f228070a.get(Integer.valueOf(i3));
    }

    public void b(int i3, Object obj) {
        this.f228070a.put(Integer.valueOf(i3), obj);
    }
}

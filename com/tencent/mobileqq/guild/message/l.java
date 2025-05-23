package com.tencent.mobileqq.guild.message;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.group_pro_proto.common.common$Msg;

/* compiled from: P */
/* loaded from: classes14.dex */
public class l implements st1.d {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f230585a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<Object> f230586b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<Object[]> f230587c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<Long, List<common$Msg>> f230588d = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private Set<String> f230589e = Collections.newSetFromMap(new ConcurrentHashMap());

    @Override // st1.d
    public Object a(String str) {
        if (!this.f230585a.containsKey(str)) {
            synchronized (this.f230585a) {
                if (!this.f230585a.containsKey(str)) {
                    this.f230585a.put(str, new Object());
                }
            }
        }
        return this.f230585a.get(str);
    }

    @Override // st1.d
    public void b(Object obj) {
        synchronized (this.f230586b) {
            this.f230586b.add(obj);
        }
    }

    @Override // st1.d
    public List<common$Msg> c(Long l3) {
        return this.f230588d.remove(l3);
    }

    @Override // st1.d
    public synchronized List<Object[]> d() {
        return this.f230587c;
    }

    @Override // st1.d
    public synchronized void e() {
        this.f230587c.clear();
    }

    @Override // st1.d
    public synchronized void f(Object[] objArr) {
        this.f230587c.add(objArr);
    }

    @Override // st1.d
    public List<Object> g() {
        ArrayList arrayList;
        synchronized (this.f230586b) {
            arrayList = new ArrayList();
            arrayList.addAll(this.f230586b);
            j();
        }
        return arrayList;
    }

    @Override // st1.d
    public void h(Long l3, List<common$Msg> list) {
        this.f230588d.put(l3, list);
    }

    public void i() {
        QLog.i("GuildMessageCache", 1, "clear.");
        synchronized (this.f230585a) {
            this.f230585a.clear();
        }
        this.f230586b.clear();
        e();
        this.f230588d.clear();
        this.f230589e.clear();
    }

    public void j() {
        synchronized (this.f230586b) {
            this.f230586b.clear();
        }
    }
}

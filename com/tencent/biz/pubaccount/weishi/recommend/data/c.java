package com.tencent.biz.pubaccount.weishi.recommend.data;

import UserGrowth.stExposureFeedInfo;
import UserGrowth.stSimpleMetaFeed;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<stExposureFeedInfo> f81414a = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private final HashSet<String> f81415b = new HashSet<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final c f81416a = new c();
    }

    c() {
    }

    public static c e() {
        return a.f81416a;
    }

    public void c() {
        this.f81415b.clear();
    }

    public ArrayList<stExposureFeedInfo> d() {
        ArrayList<stExposureFeedInfo> arrayList = new ArrayList<>(this.f81414a);
        this.f81414a.clear();
        return arrayList;
    }

    public void b(List<stSimpleMetaFeed> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<stSimpleMetaFeed> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public void a(stSimpleMetaFeed stsimplemetafeed) {
        if (stsimplemetafeed == null) {
            return;
        }
        String str = stsimplemetafeed.f25129id;
        if (this.f81415b.contains(str)) {
            return;
        }
        this.f81415b.add(str);
        stExposureFeedInfo stexposurefeedinfo = new stExposureFeedInfo();
        stexposurefeedinfo.f25117id = str;
        this.f81414a.add(stexposurefeedinfo);
    }
}

package com.qzone.reborn.feedx.itemview;

import android.content.Context;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.itemview.friendlike.j;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jo.h;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static volatile b f54842c;

    /* renamed from: a, reason: collision with root package name */
    private final List<nf.a<?>> f54843a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Integer, Constructor> f54844b = new HashMap();

    b() {
        b(new xf.a());
        a();
        b(new hg.d());
        b(new uf.a());
        b(new lf.a());
        b(new j());
        b(new com.qzone.reborn.feedx.itemview.friendlike.d());
        d();
        c();
        b(new mf.a());
        b(new rf.a());
        b(new tf.a());
        b(new sf.b());
        b(new sf.a());
        b(new ag.a());
        b(new dg.a());
        b(new fg.a());
        b(new gg.a());
        b(new gg.b());
        b(new kg.a());
        b(new wf.b());
        b(new zf.b());
        b(new zf.a());
        b(new jg.a());
        b(new qf.a());
        b(new cg.a());
        h();
    }

    private void a() {
        b(new kf.e());
        b(new kf.b());
        b(new kf.a());
        b(new jf.b());
        b(new jf.a());
        b(new jf.c());
        b(new jf.e());
        b(new jf.f());
        b(new jf.d());
        b(new hf.d());
        b(new hf.b());
        b(new p019if.a());
        b(new p019if.b());
        b(new hf.c());
        b(new hf.e());
        b(new hf.a());
    }

    private void b(nf.a aVar) {
        try {
            this.f54844b.put(Integer.valueOf(aVar.b().mViewType), aVar.a().getConstructor(Context.class));
            this.f54843a.add(aVar);
        } catch (NoSuchMethodException e16) {
            e16.printStackTrace();
        }
    }

    private void c() {
        b(new of.a());
    }

    private void d() {
        b(new eg.b());
        b(new eg.a());
        b(new ig.a());
        b(new pf.a());
        b(new wf.a());
        b(new yf.a());
        b(new vf.a());
        b(new of.b());
        b(new of.c());
        b(new of.d());
    }

    public static b e() {
        if (f54842c == null) {
            synchronized (b.class) {
                if (f54842c == null) {
                    f54842c = new b();
                }
            }
        }
        return f54842c;
    }

    private void h() {
        b(new bg.d());
        b(new bg.c());
        b(new bg.a());
        b(new bg.b());
    }

    public QZoneBaseFeedItemView f(int i3, Context context) {
        Constructor constructor = this.f54844b.get(Integer.valueOf(i3));
        try {
            h hVar = h.f410717a;
            hVar.g("item_view_construct").h(constructor.getName() + "#newInstance");
            QZoneBaseFeedItemView qZoneBaseFeedItemView = (QZoneBaseFeedItemView) constructor.newInstance(context);
            hVar.g("item_view_construct").b(constructor.getName() + "#newInstance");
            return qZoneBaseFeedItemView;
        } catch (Throwable th5) {
            xe.b.f447841a.d(th5);
            return new QZoneEmptyItemView(context);
        }
    }

    public int g(BusinessFeedData businessFeedData, int i3) {
        for (nf.a<?> aVar : this.f54843a) {
            if (businessFeedData != null && aVar.c(businessFeedData)) {
                return aVar.b().mViewType;
            }
        }
        return QZoneFeedType.UNIQUE_TYPE_UNKNOWN.mViewType;
    }
}

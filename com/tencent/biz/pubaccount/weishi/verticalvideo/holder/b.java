package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalVideoRelativeLayout;
import com.tencent.mobileqq.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class b implements com.tencent.biz.pubaccount.weishi.baseui.c<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> {
    public Context C;
    public View D;
    private View E;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> f82121d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> f82122e;

    /* renamed from: f, reason: collision with root package name */
    private WSVerticalVideoRelativeLayout f82123f;

    /* renamed from: h, reason: collision with root package name */
    public Map<String, com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j>> f82124h = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public WSVerticalPageFragment f82125i;

    /* renamed from: m, reason: collision with root package name */
    public au f82126m;

    public b(Context context, au auVar) {
        this.C = context;
        this.f82126m = auVar;
        if (auVar != null) {
            this.D = auVar.itemView;
            this.f82125i = auVar.f82128e;
        }
        a();
    }

    private void l() {
        View view = this.D;
        if (view != null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.f1181973h);
            WSVerticalItemVideoProgressController wSVerticalItemVideoProgressController = new WSVerticalItemVideoProgressController(this.C, this.f82126m, this.f82123f);
            this.f82122e = wSVerticalItemVideoProgressController;
            wSVerticalItemVideoProgressController.r(viewStub);
            b(this.f82122e);
        }
    }

    private void m() {
        View view = this.D;
        if (view != null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.f1182673o);
            ah ahVar = new ah(this.C, this.f82126m);
            this.f82121d = ahVar;
            ahVar.r(viewStub);
            b(this.f82121d);
        }
    }

    private void n() {
        this.E = this.D.findViewById(R.id.f1187074v);
        this.f82123f = (WSVerticalVideoRelativeLayout) this.D.findViewById(R.id.f1181373b);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void a() {
        n();
        m();
        l();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void f(int i3) {
        Map<String, com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j>> map = this.f82124h;
        if (map != null) {
            Iterator<Map.Entry<String, com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> value = it.next().getValue();
                if (value instanceof c) {
                    ((c) value).v(i3);
                }
            }
        }
    }

    public View g() {
        return this.E;
    }

    public FrameLayout h() {
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar = this.f82121d;
        if (bVar instanceof ah) {
            return ((ah) bVar).z();
        }
        return null;
    }

    public com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> i() {
        return this.f82121d;
    }

    public View j() {
        com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar = this.f82121d;
        if (bVar instanceof ah) {
            return ((ah) bVar).A();
        }
        return null;
    }

    public com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> k() {
        return this.f82122e;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void onPageSelected(int i3) {
        Map<String, com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j>> map = this.f82124h;
        if (map != null) {
            Iterator<Map.Entry<String, com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> value = it.next().getValue();
                if (value instanceof c) {
                    ((c) value).u(i3);
                }
            }
        }
    }

    public void p(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        Map<String, com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j>> map = this.f82124h;
        if (map == null) {
            return;
        }
        for (Map.Entry<String, com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j>> entry : map.entrySet()) {
            if (!TextUtils.equals(entry.getKey(), ah.class.getName()) && !TextUtils.equals(entry.getKey(), WSVerticalItemVideoProgressController.class.getName())) {
                entry.getValue().j(jVar);
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void setData(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
        this.E.setVisibility(0);
        Map<String, com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j>> map = this.f82124h;
        if (map != null) {
            Iterator<Map.Entry<String, com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().j(jVar);
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void recycle() {
        Map<String, com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j>> map = this.f82124h;
        if (map != null) {
            Iterator<Map.Entry<String, com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().i();
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void setPosition(int i3) {
        Map<String, com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j>> map = this.f82124h;
        if (map != null) {
            Iterator<Map.Entry<String, com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().k(i3);
            }
        }
    }

    public void b(com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> bVar) {
        if (bVar != null) {
            this.f82124h.put(bVar.getClass().getName(), bVar);
        }
    }

    public void o(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar) {
    }
}

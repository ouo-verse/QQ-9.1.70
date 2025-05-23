package com.tencent.biz.pubaccount.weishi.profile;

import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h extends com.tencent.biz.pubaccount.weishi.presenter.a<g> {

    /* renamed from: f, reason: collision with root package name */
    private jz.c<j> f81280f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f81281h;

    /* renamed from: i, reason: collision with root package name */
    private String f81282i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements jz.c<j> {
        a() {
        }

        @Override // jz.c
        public void d0(List<j> list, boolean z16, boolean z17, Object obj) {
            if (h.this.x0() == null) {
                return;
            }
            if (obj instanceof Boolean) {
                h.this.f81281h = ((Boolean) obj).booleanValue();
            }
            h.this.x0().hideLoading();
            h.this.x0().Q1(list, z17, z16, h.this.f81281h);
        }

        @Override // jz.c
        public void i(int i3, String str, boolean z16, boolean z17) {
            if (h.this.x0() == null) {
                return;
            }
            h.this.x0().hideLoading();
            h.this.x0().Q0(i3, str, z16);
        }
    }

    private jz.c<j> C0() {
        jz.c<j> cVar = this.f81280f;
        if (cVar != null) {
            return cVar;
        }
        a aVar = new a();
        this.f81280f = aVar;
        return aVar;
    }

    private String getFrom() {
        g x06 = x0();
        if (x06 == null || x06.getPageType() == 1) {
            return "works_in_profile";
        }
        return "praise_in_profile";
    }

    @Override // com.tencent.biz.pubaccount.weishi.presenter.a, com.tencent.biz.pubaccount.weishi.d
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public void attachView(g gVar) {
        super.attachView(gVar);
        w00.e.b().a(getFrom(), D0()).b(C0());
    }

    public String D0() {
        return String.valueOf(hashCode());
    }

    public void E0() {
        w00.e.b().a(getFrom(), D0()).reset();
    }

    public void F0(String str) {
        this.f81282i = str;
    }

    @Override // com.tencent.biz.pubaccount.weishi.presenter.a, com.tencent.biz.pubaccount.weishi.d
    public void detachView() {
        super.detachView();
        w00.e.b().a(getFrom(), D0()).c(C0());
        w00.e.b().c(getFrom(), D0());
        this.f81280f = null;
    }

    public void B0(String str, int i3, boolean z16, boolean z17) {
        if (z16) {
            x0().showLoading();
        }
        this.f81282i = str;
        w00.e.b().a(getFrom(), D0()).a(new w00.c(z16, z17, str, new ArrayList(), 10019, i3));
    }
}

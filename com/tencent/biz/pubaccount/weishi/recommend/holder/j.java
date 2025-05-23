package com.tencent.biz.pubaccount.weishi.recommend.holder;

import UserGrowth.stCardInfo;
import UserGrowth.stCollection;
import UserGrowth.stCollectionCardInfo;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes32.dex */
public class j implements com.tencent.biz.pubaccount.weishi.baseui.c<stSimpleMetaFeed> {
    private stSimpleMetaFeed C;

    /* renamed from: d, reason: collision with root package name */
    private final Context f81453d;

    /* renamed from: e, reason: collision with root package name */
    private final i f81454e;

    /* renamed from: f, reason: collision with root package name */
    private final ViewGroup f81455f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f81456h;

    /* renamed from: i, reason: collision with root package name */
    private final SparseArray<d10.e> f81457i = new SparseArray<>();

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.t f81458m;

    public j(Context context, View view, i iVar) {
        this.f81453d = context;
        this.f81454e = iVar;
        this.f81455f = (ViewGroup) view;
        a();
    }

    private void b(int i3, int i16, ArrayList<stCollection> arrayList) {
        String str;
        int layoutPosition = this.f81454e.getLayoutPosition();
        com.tencent.biz.pubaccount.weishi.t tVar = this.f81458m;
        if (tVar != null) {
            str = tVar.F;
        } else {
            str = "";
        }
        for (int i17 = 0; i17 < i16; i17++) {
            c10.a aVar = new c10.a(arrayList.get(i17), i3);
            d10.e eVar = this.f81457i.get(i17);
            if (eVar == null) {
                eVar = new d10.e(this.f81453d, this.C);
                this.f81457i.append(i17, eVar);
            }
            eVar.k(layoutPosition);
            eVar.o(this.f81455f);
            eVar.s(i17);
            eVar.t(str);
            eVar.r(aVar);
        }
    }

    private void j() {
        stCardInfo stcardinfo = this.C.cardInfo;
        stCollectionCardInfo stcollectioncardinfo = stcardinfo.collectionCardInfo;
        com.tencent.biz.pubaccount.weishi.util.x.i("WSGridCollectionItemView", "setData :" + stcollectioncardinfo.toString());
        this.f81456h.setText(stcollectioncardinfo.title);
        ArrayList<stCollection> arrayList = stcollectioncardinfo.collectionList;
        int min = Math.min(arrayList.size(), 5);
        b(stcardinfo.cardType, min, arrayList);
        g(min);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void a() {
        com.tencent.biz.pubaccount.weishi.util.x.i("WSGridCollectionItemView", "initUI:" + this.C);
        this.f81456h = (TextView) this.f81455f.findViewById(R.id.v2q);
    }

    public void h(com.tencent.biz.pubaccount.weishi.t tVar) {
        this.f81458m = tVar;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void setData(stSimpleMetaFeed stsimplemetafeed) {
        this.C = stsimplemetafeed;
        j();
    }

    private void g(int i3) {
        if (i3 + 1 >= this.f81457i.size()) {
            return;
        }
        while (i3 < this.f81457i.size()) {
            d10.e eVar = this.f81457i.get(i3);
            if (eVar != null) {
                eVar.q();
            }
            i3++;
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void c() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void d() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void recycle() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void e(int i3) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void f(int i3) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void onPageSelected(int i3) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void setPosition(int i3) {
    }
}

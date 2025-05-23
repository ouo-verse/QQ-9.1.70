package com.qzone.album.business.photolist.adapter;

import android.view.View;
import android.widget.LinearLayout;
import com.qzone.album.business.photolist.ui.listitem.PhotoView;
import com.qzone.album.data.model.PhotoCacheData;
import com.tencent.mobileqq.R;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class u extends com.qzone.album.business.photolist.adapter.a {

    /* renamed from: c0, reason: collision with root package name */
    protected int[] f42757c0 = {R.id.fni, R.id.fnj, R.id.fnk, R.id.fnl};

    /* renamed from: d0, reason: collision with root package name */
    protected int f42758d0 = 0;

    /* renamed from: e0, reason: collision with root package name */
    protected ArrayList<WeakReference<b>> f42759e0 = new ArrayList<>(5);

    /* renamed from: f0, reason: collision with root package name */
    public AbsListView.RecyclerListener f42760f0 = new a();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements AbsListView.RecyclerListener {
        a() {
        }

        @Override // com.tencent.widget.AbsListView.RecyclerListener
        public void onMovedToScrapHeap(View view) {
            Object tag = view.getTag();
            if (tag instanceof b) {
                b bVar = (b) tag;
                for (int i3 = 0; i3 < u.this.f42652e; i3++) {
                    bVar.f42763b[i3].e();
                }
                return;
            }
            u.this.P(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public LinearLayout f42762a;

        /* renamed from: b, reason: collision with root package name */
        public PhotoView[] f42763b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
            if (this.f42763b == null) {
                this.f42763b = new PhotoView[u.this.f42652e];
            }
        }
    }

    public u(x4.a aVar, View.OnClickListener onClickListener) {
        this.f42651d = aVar;
        M();
        O(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public s4.d J(PhotoCacheData photoCacheData) {
        Long valueOf;
        s4.d dVar = new s4.d();
        if (photoCacheData == null) {
            return dVar;
        }
        if (!photoCacheData.timevisible && !photoCacheData.poivisible) {
            return dVar;
        }
        long j3 = photoCacheData.shoottime;
        if (j3 > 0) {
            valueOf = Long.valueOf(j3);
        } else {
            valueOf = Long.valueOf(photoCacheData.uploadtime);
        }
        return this.R.get(valueOf);
    }

    protected int K() {
        return 0;
    }

    public int L(int i3) {
        PhotoCacheData photoCacheData;
        if (!com.qzone.adapter.feedcomponent.i.H().S0()) {
            return 0;
        }
        while (i3 >= 0) {
            PhotoCacheData[] photoCacheDataArr = (PhotoCacheData[]) getItem(i3);
            if (photoCacheDataArr != null && photoCacheDataArr.length > 0 && (photoCacheData = photoCacheDataArr[0]) != null && photoCacheData.timevisible) {
                break;
            }
            i3--;
        }
        return i3 * this.f42652e;
    }

    protected void M() {
        this.f42655i = this.f42651d.getResources().getDisplayMetrics().widthPixels;
        this.f42656m = this.f42651d.getResources().getDisplayMetrics().heightPixels;
        int K = K();
        int dimensionPixelSize = this.f42651d.getResources().getDimensionPixelSize(R.dimen.f159263yw);
        int i3 = this.f42655i;
        if (i3 < 480) {
            this.f42652e = 3;
        }
        int i16 = i3 - (K * 2);
        int i17 = this.f42652e;
        int i18 = (i16 - (dimensionPixelSize * (i17 - 1))) / i17;
        this.f42653f = i18;
        this.f42654h = i18;
    }

    public void O(x4.a aVar) {
        if (aVar.getListView() != null) {
            com.qzone.proxy.feedcomponent.b.a("PhotoListAdapter", "setRecyclerListener");
            aVar.getListView().setRecyclerListener(this.f42760f0);
        }
    }

    @Override // com.qzone.album.business.photolist.adapter.a
    public void u() {
        com.qzone.proxy.feedcomponent.b.a("PhotoListAdapter", "recycleView holderlist size:" + this.f42759e0.size());
        Iterator<WeakReference<b>> it = this.f42759e0.iterator();
        while (it.hasNext()) {
            WeakReference<b> next = it.next();
            if (next.get() != null) {
                for (int i3 = 0; i3 < this.f42652e; i3++) {
                    next.get().f42763b[i3].e();
                }
            }
        }
    }

    @Override // com.qzone.album.business.photolist.adapter.a
    public void v(s4.d dVar) {
        ArrayList<PhotoCacheData> arrayList;
        if (dVar == null || (arrayList = dVar.f433296c) == null || arrayList.size() <= 0) {
            return;
        }
        int size = dVar.f433296c.size();
        boolean z16 = true;
        boolean z17 = true;
        for (int i3 = 0; i3 < size; i3++) {
            if (dVar.f433296c.get(i3) != null) {
                if (dVar.f433296c.get(i3).isChecked) {
                    z17 = false;
                } else {
                    z16 = false;
                }
            }
        }
        PhotoCacheData photoCacheData = dVar.f433296c.get(0);
        if (photoCacheData != null) {
            if (z16) {
                photoCacheData.allSelectedStatus = true;
            }
            if (z17) {
                photoCacheData.allSelectedStatus = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N(b bVar, View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.hck);
        bVar.f42762a = linearLayout;
        linearLayout.removeAllViews();
        for (int i3 = 0; i3 < this.f42652e; i3++) {
            bVar.f42763b[i3] = new PhotoView(this.f42651d.k());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f42653f, this.f42654h);
            if (i3 != this.f42652e - 1) {
                layoutParams.rightMargin = u4.a.z().o(2.0f);
            }
            bVar.f42762a.addView(bVar.f42763b[i3], layoutParams);
            bVar.f42763b[i3].c(this.f42651d.k(), this.f42653f, this.f42654h);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P(View view) {
    }
}

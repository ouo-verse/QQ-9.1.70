package com.qzone.album.business.photolist.adapter;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.qzone.album.business.photolist.adapter.a;
import com.qzone.album.business.photolist.controller.BasePhotoModelController;
import com.qzone.album.business.photolist.ui.listitem.NormalHeaderCell;
import com.qzone.album.business.photolist.ui.listitem.PhotoView;
import com.qzone.album.data.model.PhotoCacheData;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class z extends BaseAdapter {
    public int C;
    protected int D;
    protected int E;
    protected int F;
    protected int G;
    protected int H;
    protected int I;
    protected int J;
    protected a.f K;
    private b L;
    private View.OnClickListener M;

    /* renamed from: d, reason: collision with root package name */
    LayoutInflater f42854d;

    /* renamed from: e, reason: collision with root package name */
    protected x4.a f42855e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f42856f;

    /* renamed from: h, reason: collision with root package name */
    protected final int[] f42857h;

    /* renamed from: i, reason: collision with root package name */
    List<com.qzone.component.cache.database.a[]> f42858i;

    /* renamed from: m, reason: collision with root package name */
    public List<? extends com.qzone.component.cache.database.a> f42859m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Object tag = view.getTag();
            if (tag != null && (tag instanceof d)) {
                d dVar = (d) tag;
                if (dVar.f42866b != null) {
                    if (z.this.L != null) {
                        z.this.L.a(view, (ArrayList) z.this.f42859m, ((PhotoCacheData) dVar.f42866b).index);
                    } else {
                        a.f fVar = z.this.K;
                        if (fVar != null) {
                            fVar.onClick(view);
                        }
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        void a(View view, ArrayList<PhotoCacheData> arrayList, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        NormalHeaderCell f42861a;

        /* renamed from: b, reason: collision with root package name */
        public LinearLayout f42862b;

        /* renamed from: c, reason: collision with root package name */
        public PhotoView[] f42863c;

        public c() {
            if (this.f42863c == null) {
                this.f42863c = new PhotoView[z.this.C];
            }
        }

        public void a() {
            this.f42861a.setVisibility(0);
            this.f42862b.setVisibility(0);
            for (int i3 = 0; i3 < z.this.C; i3++) {
                this.f42863c[i3].setVisibility(8);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int f42865a;

        /* renamed from: b, reason: collision with root package name */
        public com.qzone.component.cache.database.a f42866b;
    }

    public z(x4.a aVar, boolean z16) {
        this.f42856f = false;
        this.f42857h = new int[]{R.id.fni, R.id.fnj, R.id.fnk, R.id.fnl};
        this.C = 3;
        this.M = new a();
        if (aVar != null) {
            this.f42855e = aVar;
            this.f42854d = aVar.getLayoutInflater();
        }
        if (this.f42854d == null) {
            this.f42854d = LayoutInflater.from(u4.a.z().B());
        }
        this.f42856f = z16;
        d();
    }

    private void d() {
        if (com.qzone.album.env.common.a.m().v() < 480) {
            this.C = 3;
        }
        Resources resources = this.f42855e.getResources();
        if (resources != null) {
            this.H = resources.getDimensionPixelSize(R.dimen.f158293cd);
            this.I = resources.getDimensionPixelSize(R.dimen.f159100w8);
            this.J = resources.getDimensionPixelSize(R.dimen.f159099w7);
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f158296cg);
            this.F = dimensionPixelSize;
            this.G = dimensionPixelSize;
        }
        int v3 = com.qzone.album.env.common.a.m().v() - (this.H * 2);
        int i3 = this.F;
        int ceil = (int) Math.ceil(((v3 - (i3 * (r2 - 1))) * 1.0d) / this.C);
        this.D = ceil;
        this.E = ceil;
    }

    public List<com.qzone.component.cache.database.a[]> b(List<com.qzone.component.cache.database.a> list) {
        this.f42859m = list;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            list.removeAll(Collections.singleton(null));
            PhotoCacheData[] photoCacheDataArr = new PhotoCacheData[this.C];
            int i3 = 0;
            for (int i16 = 0; i16 < list.size(); i16++) {
                PhotoCacheData photoCacheData = (PhotoCacheData) list.get(i16);
                if (photoCacheData != null) {
                    photoCacheData.index = i16;
                    photoCacheData.timevisible = false;
                    photoCacheData.isChecked = f(photoCacheData);
                    photoCacheData.titleStartIndex = 0;
                    photoCacheData.descvisible = false;
                    if (com.qzone.album.env.common.a.m().B()) {
                        photoCacheData.index = i16;
                        photoCacheData.isChecked = f(photoCacheData);
                    }
                }
                if (i16 == 0) {
                    if (photoCacheData != null) {
                        photoCacheData.timevisible = true;
                        photoCacheData.descvisible = true;
                    }
                    photoCacheDataArr[i3] = photoCacheData;
                    i3++;
                } else {
                    if (i3 % this.C == 0) {
                        arrayList.add(photoCacheDataArr);
                        photoCacheDataArr = new PhotoCacheData[this.C];
                        i3 = 0;
                    }
                    if (g(list, i16)) {
                        if (photoCacheData != null) {
                            photoCacheData.timevisible = true;
                            photoCacheData.descvisible = true;
                        }
                        if (photoCacheDataArr[0] != null) {
                            arrayList.add(photoCacheDataArr);
                        }
                        photoCacheDataArr = new PhotoCacheData[this.C];
                        photoCacheDataArr[0] = photoCacheData;
                        i3 = 1;
                    } else {
                        photoCacheDataArr[i3] = photoCacheData;
                        i3++;
                    }
                }
            }
            if (photoCacheDataArr[0] != null) {
                arrayList.add(photoCacheDataArr);
            }
        }
        return arrayList;
    }

    public int c(int i3) {
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
        return i3 * this.C;
    }

    protected boolean f(PhotoCacheData photoCacheData) {
        x4.a aVar = this.f42855e;
        if (aVar != null) {
            return ((BasePhotoModelController) aVar).g3(photoCacheData);
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f42858i.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f42858i.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    public void i(a.f fVar) {
        this.K = fVar;
    }

    public void j(b bVar) {
        this.L = bVar;
    }

    public void setData(List<com.qzone.component.cache.database.a[]> list) {
        this.f42858i = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            if (com.qzone.album.env.common.a.m().v() < 480) {
                this.C = 3;
            }
            view = this.f42854d.inflate(R.layout.bmk, (ViewGroup) null);
            cVar = new c();
            e(cVar, view);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.a();
        int i16 = this.G;
        int i17 = this.H;
        ((ViewGroup) view).setPadding(i17, i16 / 2, i17, i16 / 2);
        try {
            h(cVar, view, i3);
        } catch (OutOfMemoryError e16) {
            com.qzone.proxy.feedcomponent.b.c("VideoListAdapter", e16.toString());
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    private void e(c cVar, View view) {
        NormalHeaderCell normalHeaderCell = (NormalHeaderCell) view.findViewById(R.id.faf);
        cVar.f42861a = normalHeaderCell;
        normalHeaderCell.a(this.f42855e);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.hck);
        cVar.f42862b = linearLayout;
        linearLayout.removeAllViews();
        for (int i3 = 0; i3 < this.C; i3++) {
            cVar.f42863c[i3] = new PhotoView(this.f42855e.k());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.D, this.E);
            if (i3 != this.C - 1) {
                layoutParams.rightMargin = u4.a.z().o(2.0f);
            }
            cVar.f42862b.addView(cVar.f42863c[i3], layoutParams);
            cVar.f42863c[i3].c(this.f42855e.k(), this.D, this.E);
        }
    }

    public boolean g(List<com.qzone.component.cache.database.a> list, int i3) {
        if (i3 >= 1) {
            if (!com.qzone.album.util.g.l(((PhotoCacheData) list.get(i3)).uploadtime * 1000, ((PhotoCacheData) list.get(i3 - 1)).uploadtime * 1000)) {
                return true;
            }
        }
        return false;
    }

    private void h(c cVar, View view, int i3) {
        PhotoCacheData[] photoCacheDataArr;
        if (getItem(i3) == null || (photoCacheDataArr = (PhotoCacheData[]) getItem(i3)) == null || photoCacheDataArr.length == 0) {
            return;
        }
        cVar.f42861a.b(null, this.f42855e, photoCacheDataArr, null, false, -1, 0, true);
        int c16 = c(i3);
        int i16 = 0;
        while (true) {
            int i17 = this.C;
            if (i16 >= i17) {
                return;
            }
            int i18 = (i17 * i3) + i16;
            d dVar = new d();
            dVar.f42866b = photoCacheDataArr[i16];
            dVar.f42865a = (this.C * i3) + i16;
            cVar.f42863c[i16].setTag(dVar);
            PhotoCacheData photoCacheData = photoCacheDataArr.length > i16 ? photoCacheDataArr[i16] : null;
            cVar.f42863c[i16].f(this.f42855e, false, photoCacheData, null, false, false);
            if (photoCacheData != null) {
                if (AppSetting.f99565y) {
                    cVar.f42863c[i16].setContentDescription(com.qzone.util.l.a(R.string.saw) + ((i18 - c16) + 1) + ", " + com.qzone.album.util.g.d(photoCacheDataArr[0].shoottime * 1000));
                }
                if (!TextUtils.isEmpty(photoCacheData.clientKey)) {
                    cVar.f42863c[i16].setOnClickListener(null);
                } else {
                    cVar.f42863c[i16].setOnClickListener(this.M);
                }
                cVar.f42863c[i16].setClickBoxImgVisibility(8);
            }
            i16++;
        }
    }

    public z(x4.a aVar, List<com.qzone.component.cache.database.a[]> list, boolean z16) {
        this(aVar, z16);
        if (list != null) {
            this.f42858i = list;
        } else {
            this.f42858i = new ArrayList();
        }
        this.f42856f = z16;
    }
}

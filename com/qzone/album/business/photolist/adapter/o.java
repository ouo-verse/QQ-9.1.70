package com.qzone.album.business.photolist.adapter;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.album.ui.widget.a;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class o extends u {

    /* renamed from: l0, reason: collision with root package name */
    protected static int f42723l0 = 2;

    /* renamed from: m0, reason: collision with root package name */
    protected static int f42724m0 = 0;

    /* renamed from: n0, reason: collision with root package name */
    protected static int f42725n0 = 1;

    /* renamed from: g0, reason: collision with root package name */
    private int f42726g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f42727h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f42728i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f42729j0;

    /* renamed from: k0, reason: collision with root package name */
    private a.b f42730k0;

    public o(x4.a aVar, View.OnClickListener onClickListener) {
        super(aVar, onClickListener);
        this.f42726g0 = 2;
        this.f42727h0 = 1;
        this.f42728i0 = 1;
        this.f42729j0 = 1;
        T();
        S();
    }

    private void S() {
        this.f42727h0 = com.qzone.album.env.common.a.m().v();
        this.f42728i0 = ar.e(12.0f);
        this.f42729j0 = ar.e(9.0f);
        a.b bVar = new a.b();
        x4.a aVar = this.f42651d;
        if (aVar == null) {
            bVar.a(-16777216);
        } else {
            bVar.f44273b = -16777216;
            bVar.f44274c = aVar.getResources().getColor(R.color.f156976gm);
            bVar.f44275d = this.f42651d.getResources().getColor(R.color.f156976gm);
            bVar.f44276e = this.f42651d.getResources().getColor(R.color.f156976gm);
            bVar.f44277f = Color.parseColor("#7fffffff");
        }
        bVar.f44278g = R.drawable.fwe;
        bVar.f44279h = R.drawable.fwi;
        this.f42730k0 = bVar;
    }

    private void T() {
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_ALBUM_DETAIL_RECOM_ALBUM_LIST_NUM_OF_COLUMN, 2);
        this.f42726g0 = config;
        if (config <= 0) {
            this.f42726g0 = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.album.business.photolist.adapter.u
    public void P(View view) {
        super.P(view);
        Object tag = view.getTag();
        if (tag instanceof com.qzone.album.ui.widget.a) {
            ((com.qzone.album.ui.widget.a) tag).j();
        }
    }

    public int Q() {
        return super.getCount();
    }

    public abstract View R(int i3, View view, ViewGroup viewGroup);

    @Override // com.qzone.album.business.photolist.adapter.a, android.widget.Adapter
    public int getCount() {
        return super.getCount();
    }

    @Override // com.qzone.album.business.photolist.adapter.a, android.widget.Adapter
    public Object getItem(int i3) {
        int itemViewType = getItemViewType(i3);
        if (itemViewType != f42725n0 && itemViewType == f42724m0) {
            return super.getItem(i3);
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        return f42724m0;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View R = R(i3, view, viewGroup);
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return R;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return f42723l0;
    }
}

package com.qzone.album.business.photolist.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.qzone.album.business.photolist.adapter.h;
import com.qzone.album.business.photolist.ui.listitem.NormalHeaderCell;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.util.QZoneAlbumUtil;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class f extends h {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a extends h.d {

        /* renamed from: e, reason: collision with root package name */
        NormalHeaderCell f42685e;
    }

    public f(x4.a aVar, View.OnClickListener onClickListener) {
        super(aVar, onClickListener);
    }

    private void P(a aVar, View view, int i3) {
        int i16;
        PhotoCacheData photoCacheData;
        PhotoCacheData[] photoCacheDataArr = (PhotoCacheData[]) getItem(i3);
        if (photoCacheDataArr == null || photoCacheDataArr.length == 0) {
            return;
        }
        aVar.f42685e.b(this, this.f42651d, photoCacheDataArr, null, this.C, this.H, this.I, this.E);
        N(photoCacheDataArr[0], aVar, i3);
        M(photoCacheDataArr[0], aVar, i3);
        if (com.qzone.adapter.feedcomponent.i.H().S0()) {
            int i17 = i3;
            while (i17 >= 0) {
                PhotoCacheData[] photoCacheDataArr2 = (PhotoCacheData[]) getItem(i17);
                if (photoCacheDataArr2 != null && photoCacheDataArr2.length > 0 && (photoCacheData = photoCacheDataArr2[0]) != null && photoCacheData.timevisible) {
                    break;
                } else {
                    i17--;
                }
            }
            i16 = i17 * this.f42652e;
        } else {
            i16 = 0;
        }
        int i18 = this.f42652e;
        int i19 = i3 * i18;
        aVar.f42695a.setTag(Integer.valueOf(i18 * i3));
        PhotoCacheData photoCacheData2 = photoCacheDataArr.length > 0 ? photoCacheDataArr[0] : null;
        aVar.f42695a.e(this.f42651d, photoCacheData2);
        if (photoCacheData2 != null) {
            if (com.qzone.adapter.feedcomponent.i.H().S0()) {
                aVar.f42695a.setContentDescription(com.qzone.util.l.a(R.string.f171654k12) + ((i19 - i16) + 1) + ", " + com.qzone.album.util.g.d(photoCacheData2.shoottime * 1000));
            }
            aVar.f42695a.setOnClickListener(null);
            aVar.f42695a.setOnLongClickListener(null);
            if (this.C) {
                aVar.f42695a.setClickable(false);
                aVar.f42695a.setOnClickListener(this.f42651d.a(i3 * this.f42652e, photoCacheData2.fakeType));
            } else {
                if (!photoCacheData2.isFakePhoto()) {
                    aVar.f42695a.setOnClickListener(this.V);
                    aVar.f42695a.setOnLongClickListener(this.W);
                }
                aVar.f42695a.setClickable(true);
            }
        }
    }

    protected void O(a aVar, View view) {
        super.K(aVar, view);
        NormalHeaderCell normalHeaderCell = (NormalHeaderCell) view.findViewById(R.id.faf);
        aVar.f42685e = normalHeaderCell;
        normalHeaderCell.a(this.f42651d);
    }

    @Override // com.qzone.album.business.photolist.adapter.a
    public List<PhotoCacheData[]> a(List<PhotoCacheData> list) {
        this.K = true;
        if (QZoneAlbumUtil.B(this.I)) {
            o(list);
            list = H(this.I);
        }
        return super.a(list);
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f42651d.getLayoutInflater().inflate(R.layout.bmc, (ViewGroup) null);
            aVar = new a();
            O(aVar, view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        try {
            this.f42687c0.add(new WeakReference<>(aVar));
            P(aVar, view, i3);
        } catch (OutOfMemoryError e16) {
            com.qzone.proxy.feedcomponent.b.c("BigNormalPhotoListAdapter", e16.toString() + " position= " + i3);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }
}

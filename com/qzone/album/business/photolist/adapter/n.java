package com.qzone.album.business.photolist.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.qzone.album.business.photolist.adapter.h;
import com.qzone.album.business.photolist.ui.listitem.TravelHeaderCell;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PhotoPoiArea;
import com.qzone.album.util.QZoneAlbumUtil;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class n extends h {

    /* renamed from: d0, reason: collision with root package name */
    protected long f42720d0;

    /* renamed from: e0, reason: collision with root package name */
    protected long f42721e0;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a extends h.d {

        /* renamed from: e, reason: collision with root package name */
        TravelHeaderCell f42722e;
    }

    public n(x4.a aVar, View.OnClickListener onClickListener) {
        super(aVar, onClickListener);
        this.f42720d0 = 0L;
        this.f42721e0 = 0L;
    }

    private void P(a aVar, View view, int i3) {
        PhotoCacheData[] photoCacheDataArr;
        int i16;
        PhotoCacheData photoCacheData;
        if (getItem(i3) == null || (photoCacheDataArr = (PhotoCacheData[]) getItem(i3)) == null || photoCacheDataArr.length == 0) {
            return;
        }
        aVar.f42722e.b(this, this.f42651d, photoCacheDataArr, null, this.C, this.E, false, this.H, this.f42720d0, i3);
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
                aVar.f42695a.setContentDescription(com.qzone.util.l.a(R.string.f171657k15) + ((i19 - i16) + 1) + ", " + com.qzone.album.util.g.d(photoCacheData2.shoottime * 1000));
            }
            if (this.C) {
                aVar.f42695a.setClickable(false);
                aVar.f42695a.setOnLongClickListener(this.W);
                aVar.f42695a.setOnClickListener(this.f42651d.a(i3 * this.f42652e, photoCacheData2.fakeType));
            } else {
                aVar.f42695a.setOnClickListener(this.V);
                aVar.f42695a.setOnLongClickListener(this.W);
                aVar.f42695a.setClickable(true);
            }
        }
    }

    protected void O(a aVar, View view) {
        super.K(aVar, view);
        TravelHeaderCell travelHeaderCell = (TravelHeaderCell) view.findViewById(R.id.jvy);
        aVar.f42722e = travelHeaderCell;
        travelHeaderCell.a(this.f42651d);
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f42651d.getLayoutInflater().inflate(R.layout.bme, (ViewGroup) null);
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
            com.qzone.proxy.feedcomponent.b.c("BigTravelPhotoListAdapter", e16.toString() + " position= " + i3);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    @Override // com.qzone.album.business.photolist.adapter.a
    public List<PhotoCacheData[]> a(List<PhotoCacheData> list) {
        long j3;
        ArrayList arrayList = new ArrayList();
        PhotoCacheData[] photoCacheDataArr = new PhotoCacheData[this.f42652e];
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        this.Q = new ArrayList<>();
        int i3 = 0;
        while (true) {
            j3 = 0;
            if (i3 >= list.size()) {
                break;
            }
            PhotoCacheData photoCacheData = list.get(i3);
            if (photoCacheData != null && photoCacheData.shoottime > 0) {
                this.Q.add(photoCacheData);
            }
            i3++;
        }
        QZLog.d("BigTravelPhotoListAdapter", 4, "shootTimePhotoCacheDatas size:" + this.Q.size() + " size:" + this.P.size());
        Collections.sort(this.Q, QZoneAlbumUtil.w(6));
        if (this.Q.size() == 0) {
            arrayList.add(photoCacheDataArr);
            return arrayList;
        }
        ArrayList<PhotoCacheData> arrayList2 = this.Q;
        this.f42720d0 = 0L;
        if (com.qzone.album.util.a.i(this.f42651d) != null && com.qzone.album.util.a.i(this.f42651d).photoPoiAreaList != null) {
            ArrayList<PhotoPoiArea> arrayList3 = com.qzone.album.util.a.i(this.f42651d).photoPoiAreaList;
            if (com.qzone.album.util.a.i(this.f42651d).startShootTime == 0) {
                if (arrayList3.size() > 0 && arrayList3.get(0) != null) {
                    this.f42720d0 = arrayList3.get(0).startShootTime * 1000;
                }
            } else {
                this.f42720d0 = com.qzone.album.util.a.i(this.f42651d).startShootTime * 1000;
            }
            if (this.f42720d0 > com.qzone.album.business.photolist.adapter.a.f42649b0) {
                this.f42720d0 = 1L;
            }
            this.f42720d0 = QZoneAlbumUtil.q(this.f42720d0);
            if (arrayList3.size() > 0 && arrayList3.get(arrayList3.size() - 1) != null) {
                this.f42721e0 = arrayList3.get(arrayList3.size() - 1).endShootTime * 1000;
            }
            ArrayList arrayList4 = new ArrayList(3);
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (i16 < arrayList2.size()) {
                PhotoCacheData photoCacheData2 = arrayList2.get(i16);
                if (i16 <= 0 || !q(photoCacheData2, arrayList2.get(i16 - 1))) {
                    if (com.qzone.album.env.common.a.m().B() && photoCacheData2 != null) {
                        if (i16 == this.f42651d.l()) {
                            this.f42651d.d(photoCacheData2.lloc);
                        }
                        photoCacheData2.index = i16;
                    }
                    if (photoCacheData2 != null) {
                        photoCacheData2.descvisible = false;
                    }
                    if (photoCacheData2 != null && photoCacheData2.shoottime > j3) {
                        if (i18 == 0 && photoCacheDataArr[0] == null) {
                            photoCacheData2.timevisible = true;
                            photoCacheData2.poivisible = true;
                            photoCacheData2.descvisible = true;
                            this.L = photoCacheData2.desc;
                            com.qzone.proxy.feedcomponent.b.a("BigTravelPhotoListAdapter", "add uploadNickName:" + photoCacheData2.uploadUin);
                            arrayList4.add(Long.valueOf(photoCacheData2.uploadUin));
                            photoCacheDataArr[i18] = photoCacheData2;
                            i18++;
                        } else {
                            if (i18 % this.f42652e == 0) {
                                arrayList.add(photoCacheDataArr);
                                photoCacheDataArr = new PhotoCacheData[this.f42652e];
                                i18 = 0;
                            }
                            int i19 = i16 - 1;
                            if (com.qzone.album.util.a.m(arrayList2, i16, i19, true)) {
                                photoCacheData2.timevisible = true;
                                photoCacheData2.poivisible = true;
                                photoCacheData2.descvisible = true;
                                this.L = photoCacheData2.desc;
                                PhotoCacheData photoCacheData3 = photoCacheDataArr[0];
                                if (photoCacheData3 != null) {
                                    photoCacheData3.uploadUinList = d(arrayList4);
                                    arrayList.add(photoCacheDataArr);
                                    i17 = i16 + 1;
                                } else if (i17 < arrayList.size() && arrayList.get(i17) != null) {
                                    ((PhotoCacheData[]) arrayList.get(i17))[0].uploadUinList = d(arrayList4);
                                    i17 = i16;
                                }
                                photoCacheDataArr = new PhotoCacheData[this.f42652e];
                                photoCacheDataArr[0] = photoCacheData2;
                                com.qzone.proxy.feedcomponent.b.a("BigTravelPhotoListAdapter", "add uploadNickName:" + photoCacheData2.uploadUin);
                                arrayList4.add(Long.valueOf(photoCacheData2.uploadUin));
                            } else if (com.qzone.album.util.a.j(this.f42651d, arrayList2, i16, i19)) {
                                photoCacheData2.timevisible = false;
                                photoCacheData2.poivisible = true;
                                photoCacheData2.descvisible = true;
                                PhotoCacheData photoCacheData4 = photoCacheDataArr[0];
                                if (photoCacheData4 != null) {
                                    photoCacheData4.uploadUinList = d(arrayList4);
                                    arrayList.add(photoCacheDataArr);
                                    i17 = i16 + 1;
                                } else if (i17 < arrayList.size() && arrayList.get(i17) != null) {
                                    ((PhotoCacheData[]) arrayList.get(i17))[0].uploadUinList = d(arrayList4);
                                    i17 = i16;
                                }
                                photoCacheDataArr = new PhotoCacheData[this.f42652e];
                                photoCacheDataArr[0] = photoCacheData2;
                                com.qzone.proxy.feedcomponent.b.a("BigTravelPhotoListAdapter", "add uploadNickName:" + photoCacheData2.uploadUin);
                                arrayList4.add(Long.valueOf(photoCacheData2.uploadUin));
                            } else {
                                if (!photoCacheData2.desc.equals(this.L)) {
                                    photoCacheData2.descvisible = true;
                                    this.L = photoCacheData2.desc;
                                }
                                com.qzone.proxy.feedcomponent.b.a("BigTravelPhotoListAdapter", "add uploadNickName:" + photoCacheData2.uploadUin);
                                arrayList4.add(Long.valueOf(photoCacheData2.uploadUin));
                                photoCacheDataArr[i18] = photoCacheData2;
                                i18++;
                            }
                            i18 = 1;
                        }
                    }
                }
                i16++;
                j3 = 0;
            }
            arrayList.add(photoCacheDataArr);
            if (i17 < arrayList.size() && arrayList.get(i17) != null) {
                ((PhotoCacheData[]) arrayList.get(i17))[0].uploadUinList = d(arrayList4);
            }
            return arrayList;
        }
        com.qzone.proxy.feedcomponent.b.i("BigTravelPhotoListAdapter", "changeDataStruct getTravelData == null || photoPoiAreaList == null");
        return null;
    }
}

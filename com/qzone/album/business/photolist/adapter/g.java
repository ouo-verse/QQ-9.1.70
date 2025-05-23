package com.qzone.album.business.photolist.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.qzone.album.business.photolist.adapter.h;
import com.qzone.album.business.photolist.ui.listitem.ParentHeaderCell;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.util.QZoneAlbumUtil;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class g extends h {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a extends h.d {

        /* renamed from: e, reason: collision with root package name */
        ParentHeaderCell f42686e;
    }

    public g(x4.a aVar, View.OnClickListener onClickListener) {
        super(aVar, onClickListener);
    }

    private void O(a aVar, View view) {
        super.K(aVar, view);
        ParentHeaderCell parentHeaderCell = (ParentHeaderCell) view.findViewById(R.id.fig);
        aVar.f42686e = parentHeaderCell;
        parentHeaderCell.c(this.f42651d);
    }

    private void P(a aVar, View view, int i3) {
        PhotoCacheData[] photoCacheDataArr;
        int i16;
        PhotoCacheData photoCacheData;
        if (getItem(i3) == null || (photoCacheDataArr = (PhotoCacheData[]) getItem(i3)) == null || photoCacheDataArr.length == 0) {
            return;
        }
        aVar.f42686e.d(this, this.f42651d, photoCacheDataArr, null, this.C, this.E, false, this.H, i3);
        PhotoCacheData photoCacheData2 = photoCacheDataArr[0];
        if (photoCacheData2 != null) {
            N(photoCacheData2, aVar, i3);
            M(photoCacheDataArr[0], aVar, i3);
        }
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
        PhotoCacheData photoCacheData3 = photoCacheDataArr.length > 0 ? photoCacheDataArr[0] : null;
        aVar.f42695a.e(this.f42651d, photoCacheData3);
        if (photoCacheData3 != null) {
            if (com.qzone.adapter.feedcomponent.i.H().S0()) {
                aVar.f42695a.setContentDescription(com.qzone.util.l.a(R.string.f171655k13) + ((i19 - i16) + 1) + ", " + com.qzone.album.util.g.d(photoCacheData3.shoottime * 1000));
            }
            if (this.C) {
                aVar.f42695a.setClickable(false);
                aVar.f42695a.setLongClickable(false);
                aVar.f42695a.setOnClickListener(this.f42651d.a(i3 * this.f42652e, photoCacheData3.fakeType));
            } else {
                aVar.f42695a.setOnClickListener(this.V);
                aVar.f42695a.setOnLongClickListener(this.W);
                aVar.f42695a.setClickable(true);
            }
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f42651d.getLayoutInflater().inflate(R.layout.bmb, (ViewGroup) null);
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
            com.qzone.proxy.feedcomponent.b.c("BigParentingPhotoListAdapter", e16.toString() + " position= " + i3);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    @Override // com.qzone.album.business.photolist.adapter.a
    public List<PhotoCacheData[]> a(List<PhotoCacheData> list) {
        long j3;
        ArrayList arrayList = new ArrayList();
        PhotoCacheData[] photoCacheDataArr = new PhotoCacheData[this.f42652e];
        if (list != null && list.size() != 0) {
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
            Collections.sort(this.Q, QZoneAlbumUtil.w(5));
            if (this.Q.size() == 0) {
                arrayList.add(photoCacheDataArr);
                return arrayList;
            }
            ArrayList<PhotoCacheData> arrayList2 = this.Q;
            ArrayList arrayList3 = new ArrayList(3);
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
                        photoCacheData2.timevisible = false;
                    }
                    if (photoCacheData2 != null && photoCacheData2.shoottime > j3) {
                        if (i18 == 0 && arrayList.size() == 0) {
                            photoCacheData2.timevisible = true;
                            photoCacheData2.descvisible = true;
                            this.L = photoCacheData2.desc;
                            com.qzone.proxy.feedcomponent.b.a("BigParentingPhotoListAdapter", "add uploadNickName:" + photoCacheData2.uploadNickName);
                            arrayList3.add(photoCacheData2.uploadNickName);
                            photoCacheDataArr[i18] = photoCacheData2;
                            i18++;
                        } else {
                            if (i18 % this.f42652e == 0) {
                                arrayList.add(photoCacheDataArr);
                                photoCacheDataArr = new PhotoCacheData[this.f42652e];
                                i18 = 0;
                            }
                            if (com.qzone.album.util.a.m(arrayList2, i16, i16 - 1, true)) {
                                photoCacheData2.timevisible = true;
                                photoCacheData2.descvisible = true;
                                this.L = photoCacheData2.desc;
                                PhotoCacheData photoCacheData3 = photoCacheDataArr[0];
                                if (photoCacheData3 != null) {
                                    photoCacheData3.shareUploadContent = b(arrayList3);
                                    arrayList.add(photoCacheDataArr);
                                    i17 = i16 + 1;
                                } else if (i17 < arrayList.size() && arrayList.get(i17) != null) {
                                    ((PhotoCacheData[]) arrayList.get(i17))[0].shareUploadContent = b(arrayList3);
                                    i17 = i16;
                                }
                                photoCacheDataArr = new PhotoCacheData[this.f42652e];
                                photoCacheDataArr[0] = photoCacheData2;
                                com.qzone.proxy.feedcomponent.b.a("BigParentingPhotoListAdapter", "add uploadNickName:" + photoCacheData2.uploadNickName);
                                arrayList3.add(photoCacheData2.uploadNickName);
                                i18 = 1;
                            } else {
                                if (!photoCacheData2.desc.equals(this.L)) {
                                    photoCacheData2.descvisible = true;
                                    this.L = photoCacheData2.desc;
                                }
                                com.qzone.proxy.feedcomponent.b.a("BigParentingPhotoListAdapter", "add uploadNickName:" + photoCacheData2.uploadNickName);
                                arrayList3.add(photoCacheData2.uploadNickName);
                                photoCacheDataArr[i18] = photoCacheData2;
                                i18++;
                            }
                        }
                    }
                }
                i16++;
                j3 = 0;
            }
            if (photoCacheDataArr[0] != null) {
                arrayList.add(photoCacheDataArr);
                if (i17 < arrayList.size() && arrayList.get(i17) != null) {
                    ((PhotoCacheData[]) arrayList.get(i17))[0].shareUploadContent = b(arrayList3);
                }
            }
        }
        return arrayList;
    }
}

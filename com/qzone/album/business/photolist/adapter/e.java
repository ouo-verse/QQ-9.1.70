package com.qzone.album.business.photolist.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.qzone.album.business.photolist.adapter.h;
import com.qzone.album.business.photolist.ui.listitem.MultiHeaderCell;
import com.qzone.album.data.model.PhotoCacheData;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e extends h {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a extends h.d {

        /* renamed from: e, reason: collision with root package name */
        MultiHeaderCell f42684e;
    }

    public e(x4.a aVar, View.OnClickListener onClickListener) {
        super(aVar, onClickListener);
    }

    private void O(List<PhotoCacheData[]> list) {
        new s4.d();
        this.S = new HashMap<>();
        if (this.C || this.H == 4) {
            long j3 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3) != null) {
                    if (list.get(i3)[0] != null && list.get(i3)[0].timevisible) {
                        j3 = list.get(i3)[0].batch_id;
                        s4.d dVar = new s4.d();
                        if (!this.S.containsKey(Long.valueOf(j3))) {
                            this.S.put(Long.valueOf(j3), dVar);
                            dVar.f433294a = j3;
                        }
                        for (int i16 = 0; i16 < this.f42652e; i16++) {
                            if (list.get(i3)[i16] != null) {
                                if (com.qzone.album.env.common.a.m().D()) {
                                    x4.a aVar = this.f42651d;
                                    if (aVar != null && aVar.o().contains(Integer.valueOf((this.f42652e * i3) + i16))) {
                                        list.get(i3)[i16].isChecked = true;
                                    } else {
                                        list.get(i3)[i16].isChecked = false;
                                    }
                                }
                                this.S.get(Long.valueOf(j3)).f433296c.add(list.get(i3)[i16]);
                                this.S.get(Long.valueOf(j3)).f433295b.add(Integer.valueOf((this.f42652e * i3) + i16));
                            }
                        }
                    } else if (list.get(i3)[0] != null && list.get(i3)[0].batchvisible) {
                        j3 = list.get(i3)[0].batch_id;
                        s4.d dVar2 = new s4.d();
                        if (!this.S.containsKey(Long.valueOf(j3))) {
                            this.S.put(Long.valueOf(j3), dVar2);
                            dVar2.f433294a = j3;
                        }
                        for (int i17 = 0; i17 < this.f42652e; i17++) {
                            if (list.get(i3)[i17] != null) {
                                if (com.qzone.album.env.common.a.m().D()) {
                                    x4.a aVar2 = this.f42651d;
                                    if (aVar2 != null && aVar2.o().contains(Integer.valueOf((this.f42652e * i3) + i17))) {
                                        list.get(i3)[i17].isChecked = true;
                                    } else {
                                        list.get(i3)[i17].isChecked = false;
                                    }
                                }
                                this.S.get(Long.valueOf(j3)).f433296c.add(list.get(i3)[i17]);
                                this.S.get(Long.valueOf(j3)).f433295b.add(Integer.valueOf((this.f42652e * i3) + i17));
                            }
                        }
                    } else {
                        for (int i18 = 0; i18 < this.f42652e; i18++) {
                            if (list.get(i3)[i18] != null) {
                                if (com.qzone.album.env.common.a.m().D()) {
                                    x4.a aVar3 = this.f42651d;
                                    if (aVar3 != null && aVar3.o().contains(Integer.valueOf((this.f42652e * i3) + i18))) {
                                        list.get(i3)[i18].isChecked = true;
                                    } else {
                                        list.get(i3)[i18].isChecked = false;
                                    }
                                }
                                this.S.get(Long.valueOf(j3)).f433296c.add(list.get(i3)[i18]);
                                this.S.get(Long.valueOf(j3)).f433295b.add(Integer.valueOf((this.f42652e * i3) + i18));
                            }
                        }
                    }
                }
            }
        }
    }

    private void Q(a aVar, View view, int i3) {
        int i16;
        PhotoCacheData photoCacheData;
        PhotoCacheData[] photoCacheDataArr = (PhotoCacheData[]) getItem(i3);
        if (photoCacheDataArr == null || photoCacheDataArr.length == 0) {
            return;
        }
        aVar.f42684e.b(this, this.f42651d, photoCacheDataArr, null, this.C, this.H, this.E);
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
                aVar.f42695a.setContentDescription(com.qzone.util.l.a(R.string.f171653k11) + ((i19 - i16) + 1) + ", " + com.qzone.album.util.g.d(photoCacheData2.shoottime * 1000));
            }
            if (this.C) {
                aVar.f42695a.setClickable(false);
                aVar.f42695a.setOnClickListener(this.f42651d.a(i3 * this.f42652e, photoCacheData2.fakeType));
                return;
            }
            if (photoCacheData2.isFakePhoto()) {
                aVar.f42695a.setOnClickListener(null);
                aVar.f42695a.setOnLongClickListener(null);
            } else {
                aVar.f42695a.setOnClickListener(this.V);
                aVar.f42695a.setOnLongClickListener(this.W);
            }
            aVar.f42695a.setClickable(true);
        }
    }

    private void R(List<PhotoCacheData[]> list, List<PhotoCacheData> list2) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        PhotoCacheData[] photoCacheDataArr = new PhotoCacheData[this.f42652e];
        if (m() != null) {
            Collections.sort(list2, m());
        }
        for (int i3 = 0; i3 < list2.size(); i3++) {
            PhotoCacheData photoCacheData = list2.get(i3);
            if (hashMap.containsKey(Long.valueOf(photoCacheData.batch_id))) {
                ((List) hashMap.get(Long.valueOf(photoCacheData.batch_id))).add(photoCacheData);
            } else {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(photoCacheData);
                hashMap.put(Long.valueOf(photoCacheData.batch_id), arrayList2);
            }
        }
        ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
        Collections.sort(arrayList3, f());
        for (int i16 = 0; i16 < arrayList3.size(); i16++) {
            arrayList.addAll((Collection) ((Map.Entry) arrayList3.get(i16)).getValue());
        }
        int i17 = 0;
        for (int i18 = 0; i18 < arrayList.size(); i18++) {
            PhotoCacheData photoCacheData2 = arrayList.get(i18);
            if (i18 <= 0 || !q(photoCacheData2, arrayList.get(i18 - 1))) {
                if (photoCacheData2 != null) {
                    photoCacheData2.descvisible = false;
                    if (com.qzone.album.env.common.a.m().B()) {
                        photoCacheData2.index = i18;
                        photoCacheData2.isChecked = r(photoCacheData2);
                    }
                }
                if (i18 == 0) {
                    if (photoCacheData2 != null) {
                        photoCacheData2.timevisible = true;
                        photoCacheData2.descvisible = true;
                        if (!this.F) {
                            photoCacheData2.batchvisible = true;
                        } else {
                            photoCacheData2.batchvisible = false;
                        }
                        this.L = photoCacheData2.desc;
                    }
                    photoCacheDataArr[i17] = photoCacheData2;
                } else {
                    if (i17 % this.f42652e == 0) {
                        list.add(photoCacheDataArr);
                        photoCacheDataArr = new PhotoCacheData[this.f42652e];
                        i17 = 0;
                    }
                    if (t(arrayList, i18)) {
                        if (photoCacheData2 != null) {
                            photoCacheData2.timevisible = true;
                            photoCacheData2.descvisible = true;
                            if (p(arrayList, i18) && !this.F) {
                                photoCacheData2.batchvisible = true;
                            } else {
                                photoCacheData2.batchvisible = false;
                            }
                            this.L = photoCacheData2.desc;
                        }
                        if (photoCacheDataArr[0] != null) {
                            list.add(photoCacheDataArr);
                        }
                        PhotoCacheData[] photoCacheDataArr2 = new PhotoCacheData[this.f42652e];
                        photoCacheDataArr2[0] = photoCacheData2;
                        photoCacheDataArr = photoCacheDataArr2;
                        i17 = 1;
                    } else if (p(arrayList, i18)) {
                        if (!this.F) {
                            if (photoCacheData2 != null) {
                                photoCacheData2.batchvisible = true;
                            }
                            if (photoCacheDataArr[0] != null) {
                                list.add(photoCacheDataArr);
                            }
                            photoCacheDataArr = new PhotoCacheData[this.f42652e];
                            i17 = 0;
                        } else if (photoCacheData2 != null) {
                            photoCacheData2.batchvisible = false;
                            if (!photoCacheData2.desc.equals(this.L)) {
                                photoCacheData2.descvisible = true;
                                this.L = photoCacheData2.desc;
                            }
                        }
                        photoCacheDataArr[i17] = photoCacheData2;
                        i17++;
                    } else {
                        if (photoCacheData2 != null && !photoCacheData2.desc.equals(this.L)) {
                            photoCacheData2.descvisible = true;
                            this.L = photoCacheData2.desc;
                        }
                        photoCacheDataArr[i17] = photoCacheData2;
                    }
                }
                i17++;
            }
        }
        if (photoCacheDataArr[0] != null) {
            list.add(photoCacheDataArr);
        }
    }

    protected void P(a aVar, View view) {
        super.K(aVar, view);
        MultiHeaderCell multiHeaderCell = (MultiHeaderCell) view.findViewById(R.id.f2n);
        aVar.f42684e = multiHeaderCell;
        multiHeaderCell.a(this.f42651d);
    }

    @Override // com.qzone.album.business.photolist.adapter.a
    public List<PhotoCacheData[]> a(List<PhotoCacheData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            R(arrayList, list);
            O(arrayList);
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f42651d.getLayoutInflater().inflate(R.layout.bm9, (ViewGroup) null);
            aVar = new a();
            P(aVar, view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        try {
            this.f42687c0.add(new WeakReference<>(aVar));
            Q(aVar, view, i3);
        } catch (OutOfMemoryError e16) {
            com.qzone.proxy.feedcomponent.b.c("BigMultiPhotoListAdapter", e16.toString() + " position= " + i3);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }
}

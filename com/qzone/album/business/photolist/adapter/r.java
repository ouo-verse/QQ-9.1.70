package com.qzone.album.business.photolist.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.album.business.photolist.adapter.u;
import com.qzone.album.business.photolist.ui.listitem.MultiHeaderCell;
import com.qzone.album.data.model.PhotoCacheData;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class r extends o {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends u.b {

        /* renamed from: d, reason: collision with root package name */
        MultiHeaderCell f42751d;

        a() {
            super();
        }
    }

    public r(x4.a aVar, View.OnClickListener onClickListener) {
        super(aVar, onClickListener);
    }

    private void U(List<PhotoCacheData[]> list) {
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

    private void X(List<PhotoCacheData[]> list, List<PhotoCacheData> list2) {
        List<PhotoCacheData> list3;
        PhotoCacheData[] photoCacheDataArr = new PhotoCacheData[this.f42652e];
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        if (m() != null) {
            Collections.sort(list2, m());
        }
        List<PhotoCacheData> list4 = this.P;
        if ((list4 == null || list4.size() == 0) && (list3 = this.X) != null) {
            this.P = list3;
        }
        if (!this.F) {
            for (int i3 = 0; i3 < list2.size(); i3++) {
                PhotoCacheData photoCacheData = list2.get(i3);
                if (photoCacheData != null) {
                    if (hashMap.containsKey(Long.valueOf(photoCacheData.batch_id))) {
                        ((List) hashMap.get(Long.valueOf(photoCacheData.batch_id))).add(photoCacheData);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(photoCacheData);
                        hashMap.put(Long.valueOf(photoCacheData.batch_id), arrayList2);
                    }
                }
            }
            ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
            Collections.sort(arrayList3, f());
            for (int i16 = 0; i16 < arrayList3.size(); i16++) {
                arrayList.addAll((Collection) ((Map.Entry) arrayList3.get(i16)).getValue());
            }
        } else {
            if (m() != null) {
                Collections.sort(list2, m());
            }
            arrayList.addAll(list2);
        }
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < arrayList.size(); i19++) {
            PhotoCacheData photoCacheData2 = arrayList.get(i19);
            if (i19 <= 0 || !q(photoCacheData2, arrayList.get(i19 - 1))) {
                if (photoCacheData2 != null) {
                    photoCacheData2.descvisible = false;
                    if (com.qzone.album.env.common.a.m().B()) {
                        photoCacheData2.index = i17;
                        photoCacheData2.isChecked = r(photoCacheData2);
                        i17++;
                    }
                }
                if (i19 == 0) {
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
                    photoCacheDataArr[i18] = photoCacheData2;
                } else {
                    if (i18 % this.f42652e == 0) {
                        list.add(photoCacheDataArr);
                        photoCacheDataArr = new PhotoCacheData[this.f42652e];
                        i18 = 0;
                    }
                    if (t(arrayList, i19)) {
                        if (photoCacheData2 != null) {
                            photoCacheData2.timevisible = true;
                            photoCacheData2.descvisible = true;
                            if (p(arrayList, i19) && !this.F) {
                                photoCacheData2.batchvisible = true;
                            } else {
                                photoCacheData2.batchvisible = false;
                            }
                            this.L = photoCacheData2.desc;
                        }
                        if (photoCacheDataArr[0] != null) {
                            list.add(photoCacheDataArr);
                        }
                        photoCacheDataArr = new PhotoCacheData[this.f42652e];
                        photoCacheDataArr[0] = photoCacheData2;
                        i18 = 1;
                    } else if (p(arrayList, i19)) {
                        if (!this.F) {
                            if (photoCacheData2 != null) {
                                photoCacheData2.batchvisible = true;
                            }
                            if (photoCacheDataArr[0] != null) {
                                list.add(photoCacheDataArr);
                            }
                            photoCacheDataArr = new PhotoCacheData[this.f42652e];
                            i18 = 0;
                        } else if (photoCacheData2 != null) {
                            photoCacheData2.batchvisible = false;
                            if (!photoCacheData2.desc.equals(this.L)) {
                                photoCacheData2.descvisible = true;
                                this.L = photoCacheData2.desc;
                            }
                        }
                        photoCacheDataArr[i18] = photoCacheData2;
                        i18++;
                    } else {
                        if (photoCacheData2 != null && !photoCacheData2.desc.equals(this.L)) {
                            photoCacheData2.descvisible = true;
                            this.L = photoCacheData2.desc;
                        }
                        photoCacheDataArr[i18] = photoCacheData2;
                    }
                }
                i18++;
            }
        }
        if (photoCacheDataArr[0] != null) {
            list.add(photoCacheDataArr);
        }
    }

    @Override // com.qzone.album.business.photolist.adapter.u
    protected s4.d J(PhotoCacheData photoCacheData) {
        s4.d dVar = new s4.d();
        if (photoCacheData == null || !photoCacheData.batchvisible) {
            return dVar;
        }
        return this.S.get(Long.valueOf(photoCacheData.batch_id));
    }

    @Override // com.qzone.album.business.photolist.adapter.u
    protected int K() {
        return u4.a.z().o(12.0f);
    }

    protected void V(a aVar, View view) {
        super.N(aVar, view);
        MultiHeaderCell multiHeaderCell = (MultiHeaderCell) view.findViewById(R.id.f2n);
        aVar.f42751d = multiHeaderCell;
        multiHeaderCell.a(this.f42651d);
    }

    @Override // com.qzone.album.business.photolist.adapter.a
    public List<PhotoCacheData[]> a(List<PhotoCacheData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            X(arrayList, list);
            U(arrayList);
        }
        return arrayList;
    }

    @Override // com.qzone.album.business.photolist.adapter.o
    public View R(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f42651d.getLayoutInflater().inflate(R.layout.bm_, (ViewGroup) null);
            aVar = new a();
            V(aVar, view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        try {
            this.f42759e0.add(new WeakReference<>(aVar));
            W(aVar, view, i3);
        } catch (OutOfMemoryError e16) {
            com.qzone.proxy.feedcomponent.b.c("MultiPhotoListAdapter", e16.toString() + " position= " + i3);
        }
        return view;
    }

    private void W(a aVar, View view, int i3) {
        PhotoCacheData[] photoCacheDataArr;
        if (getItem(i3) == null || (photoCacheDataArr = (PhotoCacheData[]) getItem(i3)) == null || photoCacheDataArr.length == 0) {
            return;
        }
        s4.d J = J(photoCacheDataArr[0]);
        aVar.f42751d.b(this, this.f42651d, photoCacheDataArr, J, this.C, this.H, this.E);
        int L = L(i3);
        int i16 = 0;
        while (true) {
            int i17 = this.f42652e;
            if (i16 >= i17) {
                return;
            }
            int i18 = (i17 * i3) + i16;
            aVar.f42763b[i16].g();
            aVar.f42763b[i16].setTag(Integer.valueOf((this.f42652e * i3) + i16));
            aVar.f42763b[i16].setNumberCheckBoxTag(Integer.valueOf(i18));
            aVar.f42763b[i16].setCheckBoxTag(Integer.valueOf(i18));
            PhotoCacheData photoCacheData = photoCacheDataArr.length > i16 ? photoCacheDataArr[i16] : null;
            aVar.f42763b[i16].f(this.f42651d, false, photoCacheData, null, this.C, this.D);
            if (photoCacheData != null) {
                if (AppSetting.f99565y) {
                    aVar.f42763b[i16].setContentDescription(com.qzone.util.l.a(R.string.f172209oc2) + ((i18 - L) + 1) + ", " + com.qzone.album.util.g.d(photoCacheDataArr[0].shoottime * 1000));
                }
                aVar.f42763b[i16].setOnClickListener(null);
                aVar.f42763b[i16].setOnLongClickListener(null);
                if (this.C && !this.f42651d.w()) {
                    PhotoCacheData photoCacheData2 = photoCacheData;
                    aVar.f42763b[i16].setOnClickListener(this.f42651d.s((this.f42652e * i3) + i16, photoCacheData.fakeType, photoCacheData.lloc, photoCacheData, J));
                    aVar.f42763b[i16].setCBClickListener(this.f42651d.z((this.f42652e * i3) + i16, photoCacheData2.fakeType, photoCacheData2.lloc, photoCacheData2, J));
                } else {
                    if (TextUtils.isEmpty(photoCacheData.clientKey)) {
                        aVar.f42763b[i16].setOnClickListener(this.V);
                        aVar.f42763b[i16].setOnLongClickListener(this.W);
                    }
                    aVar.f42763b[i16].setClickBoxImgVisibility(8);
                }
            }
            i16++;
        }
    }
}

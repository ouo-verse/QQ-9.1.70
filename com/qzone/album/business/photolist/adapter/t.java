package com.qzone.album.business.photolist.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.qzone.album.business.photolist.adapter.u;
import com.qzone.album.business.photolist.ui.listitem.ParentHeaderCell;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.util.QZoneAlbumUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class t extends o {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends u.b {

        /* renamed from: d, reason: collision with root package name */
        ParentHeaderCell f42755d;

        a() {
            super();
        }
    }

    public t(x4.a aVar, View.OnClickListener onClickListener) {
        super(aVar, onClickListener);
    }

    private void U(List<PhotoCacheData[]> list) {
        this.R = new HashMap<>();
        new s4.d();
        if (this.C || this.H == 4) {
            long j3 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3) != null) {
                    if (list.get(i3)[0] != null && list.get(i3)[0].timevisible) {
                        if (list.get(i3)[0].shoottime > 0) {
                            j3 = list.get(i3)[0].shoottime;
                        } else {
                            j3 = list.get(i3)[0].uploadtime;
                        }
                        s4.d dVar = new s4.d();
                        if (!this.R.containsKey(Long.valueOf(j3))) {
                            this.R.put(Long.valueOf(j3), dVar);
                            dVar.f433294a = j3;
                        }
                        for (int i16 = 0; i16 < this.f42652e; i16++) {
                            if (list.get(i3)[i16] != null) {
                                if (s(list, i3, i16)) {
                                    list.get(i3)[i16].isChecked = true;
                                } else {
                                    list.get(i3)[i16].isChecked = false;
                                }
                                this.R.get(Long.valueOf(j3)).f433296c.add(list.get(i3)[i16]);
                                this.R.get(Long.valueOf(j3)).f433295b.add(Integer.valueOf((this.f42652e * i3) + i16));
                            }
                        }
                    } else {
                        for (int i17 = 0; i17 < this.f42652e; i17++) {
                            if (list.get(i3)[i17] != null) {
                                if (s(list, i3, i17)) {
                                    list.get(i3)[i17].isChecked = true;
                                } else {
                                    list.get(i3)[i17].isChecked = false;
                                }
                                this.R.get(Long.valueOf(j3)).f433296c.add(list.get(i3)[i17]);
                                this.R.get(Long.valueOf(j3)).f433295b.add(Integer.valueOf((this.f42652e * i3) + i17));
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.qzone.album.business.photolist.adapter.u
    protected int K() {
        return u4.a.z().o(12.0f);
    }

    protected void V(a aVar, View view) {
        super.N(aVar, view);
        ParentHeaderCell parentHeaderCell = (ParentHeaderCell) view.findViewById(R.id.fig);
        aVar.f42755d = parentHeaderCell;
        parentHeaderCell.c(this.f42651d);
    }

    @Override // com.qzone.album.business.photolist.adapter.a
    public List<PhotoCacheData[]> a(List<PhotoCacheData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            o(list);
            X(arrayList, I(arrayList, 5));
            U(arrayList);
        }
        return arrayList;
    }

    @Override // com.qzone.album.business.photolist.adapter.o
    public View R(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f42651d.getLayoutInflater().inflate(R.layout.bmh, (ViewGroup) null);
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
            com.qzone.proxy.feedcomponent.b.c("ParentingPhotoListAdapter", e16.toString() + " position= " + i3);
        }
        return view;
    }

    private void W(a aVar, View view, int i3) {
        PhotoCacheData[] photoCacheDataArr;
        new ArrayList();
        if (getItem(i3) == null || (photoCacheDataArr = (PhotoCacheData[]) getItem(i3)) == null || photoCacheDataArr.length == 0) {
            return;
        }
        char c16 = 0;
        s4.d J = J(photoCacheDataArr[0]);
        aVar.f42755d.d(this, this.f42651d, photoCacheDataArr, J, this.C, this.E, this.G, this.H, i3);
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
                    aVar.f42763b[i16].setContentDescription(com.qzone.util.l.a(R.string.ozh) + ((i18 - L) + 1) + ", " + com.qzone.album.util.g.d(photoCacheDataArr[c16].shoottime * 1000));
                }
                if (this.C) {
                    if (this.f42651d.w()) {
                        aVar.f42763b[i16].setOnClickListener(this.V);
                        aVar.f42763b[i16].setClickBoxImgVisibility(8);
                    } else {
                        PhotoCacheData photoCacheData2 = photoCacheData;
                        aVar.f42763b[i16].setOnClickListener(this.f42651d.s((this.f42652e * i3) + i16, photoCacheData.fakeType, photoCacheData.lloc, photoCacheData2, J));
                        aVar.f42763b[i16].setCBClickListener(this.f42651d.z((this.f42652e * i3) + i16, photoCacheData.fakeType, photoCacheData.lloc, photoCacheData2, J));
                    }
                    aVar.f42763b[i16].setOnLongClickListener(null);
                } else {
                    aVar.f42763b[i16].setOnClickListener(this.V);
                    aVar.f42763b[i16].setOnLongClickListener(this.W);
                }
            }
            i16++;
            c16 = 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004e, code lost:
    
        if (q(r6, r24.get(r7 - 1)) != false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:82:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x022e A[LOOP:1: B:84:0x0226->B:86:0x022e, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void X(List<PhotoCacheData[]> list, List<PhotoCacheData> list2) {
        PhotoCacheData[] photoCacheDataArr;
        char c16;
        int i3;
        int i16;
        int i17;
        char c17;
        if (list2 == null) {
            return;
        }
        this.N.clear();
        int i18 = this.f42652e;
        PhotoCacheData[] photoCacheDataArr2 = new PhotoCacheData[i18];
        PhotoCacheData[] photoCacheDataArr3 = new PhotoCacheData[i18];
        ArrayList arrayList = new ArrayList(3);
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i36 = 0;
        int i37 = 0;
        int i38 = 0;
        int i39 = 0;
        while (true) {
            int i46 = i39;
            photoCacheDataArr = photoCacheDataArr3;
            if (i19 >= list2.size()) {
                break;
            }
            PhotoCacheData photoCacheData = list2.get(i19);
            if (photoCacheData == null) {
                i16 = i36;
            } else {
                if (i19 > 0) {
                    i16 = i36;
                } else {
                    i16 = i36;
                }
                if (i19 == this.f42651d.l()) {
                    i17 = i29;
                    this.f42651d.d(photoCacheData.lloc);
                } else {
                    i17 = i29;
                }
                photoCacheData.index = i27;
                i27++;
                if (photoCacheData.shoottime > 0) {
                    if (list.size() == 0 && i37 == 0) {
                        photoCacheData.timevisible = true;
                        photoCacheData.beginIndex = i26;
                        arrayList.add(Long.valueOf(photoCacheData.uploadUin));
                        photoCacheDataArr2[i37] = photoCacheData;
                        i37++;
                        i28++;
                    } else {
                        if (i37 % this.f42652e == 0) {
                            list.add(photoCacheDataArr2);
                            photoCacheDataArr2 = new PhotoCacheData[this.f42652e];
                            i37 = 0;
                        }
                        if (com.qzone.album.util.a.l(list2, i19, i38)) {
                            photoCacheData.timevisible = true;
                            if (photoCacheDataArr2[0] != null) {
                                list.add(photoCacheDataArr2);
                                if (i26 < list.size() && list.get(i26) != null) {
                                    com.qzone.proxy.feedcomponent.b.a("ParentingPhotoListAdapter", "changeToShareUploadString beginIndex:" + i26 + " groupNum:" + i28);
                                    list.get(i26)[0].uploadUinList = d(arrayList);
                                    list.get(i26)[0].groupNum = i28;
                                    i28 = 0;
                                }
                                i26 = list.size();
                            } else if (i26 < list.size() && list.get(i26) != null) {
                                com.qzone.proxy.feedcomponent.b.a("ParentingPhotoListAdapter", "changeToShareUploadString beginIndex:" + i26 + " groupNum:" + i28);
                                c17 = 0;
                                list.get(i26)[0].uploadUinList = d(arrayList);
                                list.get(i26)[0].groupNum = i28;
                                i26 = list.size();
                                i28 = 0;
                                PhotoCacheData[] photoCacheDataArr4 = new PhotoCacheData[this.f42652e];
                                photoCacheDataArr4[c17] = photoCacheData;
                                arrayList.add(Long.valueOf(photoCacheData.uploadUin));
                                photoCacheDataArr2 = photoCacheDataArr4;
                                i37 = 1;
                            }
                            c17 = 0;
                            PhotoCacheData[] photoCacheDataArr42 = new PhotoCacheData[this.f42652e];
                            photoCacheDataArr42[c17] = photoCacheData;
                            arrayList.add(Long.valueOf(photoCacheData.uploadUin));
                            photoCacheDataArr2 = photoCacheDataArr42;
                            i37 = 1;
                        } else {
                            arrayList.add(Long.valueOf(photoCacheData.uploadUin));
                            photoCacheDataArr2[i37] = photoCacheData;
                            i37++;
                        }
                        photoCacheData.beginIndex = i26;
                        i28++;
                    }
                    i38 = i19;
                    i39 = i46;
                    photoCacheDataArr3 = photoCacheDataArr;
                    i36 = i16;
                    i29 = i17;
                } else {
                    i29 = i17 + 1;
                    if (this.N.size() == 0 && i16 == 0) {
                        photoCacheData.timevisible = true;
                        photoCacheDataArr[i16] = photoCacheData;
                        i36 = i16 + 1;
                        i39 = i19;
                        photoCacheDataArr3 = photoCacheDataArr;
                    } else {
                        if (i16 % this.f42652e == 0) {
                            this.N.add(photoCacheDataArr);
                            photoCacheDataArr3 = new PhotoCacheData[this.f42652e];
                            i16 = 0;
                        } else {
                            photoCacheDataArr3 = photoCacheDataArr;
                        }
                        if (QZoneAlbumUtil.A(this.H) && com.qzone.album.util.a.m(list2, i19, i46, false)) {
                            photoCacheData.timevisible = true;
                            if (photoCacheDataArr3[0] != null) {
                                this.N.add(photoCacheDataArr3);
                            }
                            photoCacheDataArr3 = new PhotoCacheData[this.f42652e];
                            photoCacheDataArr3[0] = photoCacheData;
                            i36 = 1;
                        } else {
                            photoCacheDataArr3[i16] = photoCacheData;
                            i36 = i16 + 1;
                        }
                        i39 = i19;
                    }
                }
                i19++;
            }
            i39 = i46;
            photoCacheDataArr3 = photoCacheDataArr;
            i36 = i16;
            i19++;
        }
        int i47 = i29;
        if (photoCacheDataArr2[0] != null) {
            list.add(photoCacheDataArr2);
            if (i26 < list.size() && list.get(i26) != null) {
                com.qzone.proxy.feedcomponent.b.a("ParentingPhotoListAdapter", "add last beginIndex:" + i26 + " groupNum:" + i28);
                c16 = 0;
                list.get(i26)[0].uploadUinList = d(arrayList);
                list.get(i26)[0].groupNum = i28;
                if (photoCacheDataArr[c16] != null) {
                    this.N.add(photoCacheDataArr);
                }
                int size = list.size();
                for (i3 = 0; i3 < this.N.size(); i3++) {
                    PhotoCacheData photoCacheData2 = this.N.get(i3)[0];
                    photoCacheData2.groupNum = i47;
                    photoCacheData2.beginIndex = size + i3;
                }
                list.addAll(this.N);
            }
        }
        c16 = 0;
        if (photoCacheDataArr[c16] != null) {
        }
        int size2 = list.size();
        while (i3 < this.N.size()) {
        }
        list.addAll(this.N);
    }
}

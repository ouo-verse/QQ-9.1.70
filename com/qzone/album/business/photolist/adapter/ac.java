package com.qzone.album.business.photolist.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.qzone.album.business.photolist.adapter.u;
import com.qzone.album.business.photolist.ui.listitem.TravelHeaderCell;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PhotoPoiArea;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.widget.AsyncImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ac extends o {

    /* renamed from: o0, reason: collision with root package name */
    protected long f42674o0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends u.b {

        /* renamed from: d, reason: collision with root package name */
        TravelHeaderCell f42675d;

        /* renamed from: e, reason: collision with root package name */
        AsyncImageView f42676e;

        a() {
            super();
        }
    }

    public ac(x4.a aVar, View.OnClickListener onClickListener) {
        super(aVar, onClickListener);
        this.f42674o0 = 0L;
    }

    private void U(List<PhotoCacheData[]> list) {
        this.R = new HashMap<>();
        new s4.d();
        if (this.C || this.H == 4) {
            long j3 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3) != null) {
                    if (list.get(i3)[0] != null && (list.get(i3)[0].timevisible || list.get(i3)[0].poivisible)) {
                        if (list.get(i3)[0].shoottime > 0) {
                            j3 = list.get(i3)[0].shoottime;
                        } else {
                            j3 = list.get(i3)[0].uploadtime;
                        }
                        PhotoPoiArea f16 = com.qzone.album.util.a.f(this.f42651d, list.get(i3)[0]);
                        s4.d dVar = new s4.d();
                        if (!this.R.containsKey(Long.valueOf(j3))) {
                            this.R.put(Long.valueOf(j3), dVar);
                            dVar.f433294a = j3;
                            dVar.f433297d = f16;
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

    private void W() {
        ArrayList<PhotoPoiArea> arrayList = com.qzone.album.util.a.i(this.f42651d).photoPoiAreaList;
        if (com.qzone.album.util.a.i(this.f42651d).startShootTime == 0) {
            if (arrayList.size() > 0 && arrayList.get(0) != null) {
                this.f42674o0 = arrayList.get(0).startShootTime * 1000;
            }
        } else {
            this.f42674o0 = com.qzone.album.util.a.i(this.f42651d).startShootTime * 1000;
        }
        if (this.f42674o0 > com.qzone.album.business.photolist.adapter.a.f42649b0) {
            this.f42674o0 = 1L;
        }
        this.f42674o0 = QZoneAlbumUtil.q(this.f42674o0);
    }

    @Override // com.qzone.album.business.photolist.adapter.u
    protected int K() {
        return u4.a.z().o(12.0f);
    }

    protected void V(a aVar, View view) {
        super.N(aVar, view);
        TravelHeaderCell travelHeaderCell = (TravelHeaderCell) view.findViewById(R.id.jvy);
        aVar.f42675d = travelHeaderCell;
        travelHeaderCell.a(this.f42651d);
        aVar.f42676e = (AsyncImageView) view.findViewById(R.id.hdz);
    }

    @Override // com.qzone.album.business.photolist.adapter.a
    public List<PhotoCacheData[]> a(List<PhotoCacheData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            o(list);
            List<PhotoCacheData> I = I(arrayList, 6);
            if (com.qzone.album.util.a.i(this.f42651d) != null && com.qzone.album.util.a.i(this.f42651d).photoPoiAreaList != null) {
                W();
                Y(arrayList, I);
                U(arrayList);
                return arrayList;
            }
            com.qzone.proxy.feedcomponent.b.i("TravelPhotoListAdapter", "changeDataStruct getTravelData == null || photoPoiAreaList == null");
        }
        return arrayList;
    }

    @Override // com.qzone.album.business.photolist.adapter.o
    public View R(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f42651d.getLayoutInflater().inflate(R.layout.bmj, (ViewGroup) null);
            aVar = new a();
            V(aVar, view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        try {
            this.f42759e0.add(new WeakReference<>(aVar));
            X(aVar, view, i3);
        } catch (OutOfMemoryError e16) {
            com.qzone.proxy.feedcomponent.b.c("TravelPhotoListAdapter", e16.toString() + " position= " + i3);
        }
        return view;
    }

    private void X(a aVar, View view, int i3) {
        PhotoCacheData photoCacheData;
        int i16;
        int i17;
        PhotoCacheData photoCacheData2;
        PhotoCacheData photoCacheData3;
        if (getItem(i3) == null) {
            return;
        }
        PhotoCacheData[] photoCacheDataArr = (PhotoCacheData[]) getItem(i3);
        if (photoCacheDataArr != null && photoCacheDataArr.length != 0 && (photoCacheData = photoCacheDataArr[0]) != null) {
            s4.d J = J(photoCacheData);
            aVar.f42762a.setVisibility(0);
            aVar.f42676e.setVisibility(8);
            aVar.f42675d.b(this, this.f42651d, photoCacheDataArr, J, this.C, this.E, this.G, this.H, this.f42674o0, i3);
            int i18 = 1;
            if (QZoneAlbumUtil.A(this.H)) {
                aVar.f42676e.setVisibility(8);
                i17 = i3;
                i16 = 0;
            } else {
                PhotoCacheData photoCacheData4 = photoCacheDataArr[0];
                if (photoCacheData4 != null) {
                    PhotoCacheData[] photoCacheDataArr2 = (PhotoCacheData[]) getItem(photoCacheData4.beginIndex);
                    i16 = 0;
                    i17 = i3;
                    Object item = getItem(i17 + 1);
                    PhotoCacheData[] photoCacheDataArr3 = item instanceof PhotoCacheData[] ? (PhotoCacheData[]) item : null;
                    if (photoCacheDataArr2 != null && photoCacheDataArr2.length > 0) {
                        int i19 = photoCacheDataArr2[0].groupNum;
                        int i26 = this.f42652e;
                        if (i19 % i26 == 2 && i19 > 3 && (photoCacheDataArr3 == null || photoCacheDataArr3.length == 0 || ((photoCacheData3 = photoCacheDataArr3[0]) != null && (photoCacheData3.poivisible || photoCacheData3.timevisible)))) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar.f42676e.getLayoutParams();
                            layoutParams.addRule(8, R.id.hck);
                            layoutParams.addRule(6, -1);
                            aVar.f42676e.setLayoutParams(layoutParams);
                            aVar.f42676e.setVisibility(0);
                            aVar.f42676e.setAsyncImageProcessor(new z4.a());
                            aVar.f42676e.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_travel_stamp4.png");
                        } else if (i19 == 1) {
                            aVar.f42676e.setVisibility(8);
                        } else if (i19 % i26 == 1 && i19 > 3 && (photoCacheDataArr3 == null || photoCacheDataArr3.length == 0 || ((photoCacheData2 = photoCacheDataArr3[0]) != null && (photoCacheData2.poivisible || photoCacheData2.timevisible)))) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aVar.f42676e.getLayoutParams();
                            layoutParams2.addRule(6, R.id.hck);
                            layoutParams2.addRule(8, -1);
                            aVar.f42676e.setLayoutParams(layoutParams2);
                            aVar.f42676e.setVisibility(0);
                            aVar.f42676e.setAsyncImageProcessor(new z4.a());
                            aVar.f42676e.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_travel_stamp5.png");
                        } else {
                            aVar.f42676e.setVisibility(8);
                        }
                    }
                } else {
                    i16 = 0;
                    i17 = i3;
                }
            }
            int L = L(i17);
            int i27 = i16;
            while (true) {
                int i28 = this.f42652e;
                if (i27 >= i28) {
                    return;
                }
                int i29 = (i28 * i17) + i27;
                aVar.f42763b[i27].g();
                aVar.f42763b[i27].setTag(Integer.valueOf((this.f42652e * i17) + i27));
                aVar.f42763b[i27].setNumberCheckBoxTag(Integer.valueOf(i29));
                aVar.f42763b[i27].setCheckBoxTag(Integer.valueOf(i29));
                PhotoCacheData photoCacheData5 = photoCacheDataArr.length > i27 ? photoCacheDataArr[i27] : null;
                aVar.f42763b[i27].f(this.f42651d, false, photoCacheData5, null, this.C, this.D);
                if (photoCacheData5 != null) {
                    if (this.C) {
                        if (AppSetting.f99565y) {
                            aVar.f42763b[i27].setContentDescription(com.qzone.util.l.a(R.string.f172796u91) + ((i29 - L) + i18) + ", " + com.qzone.album.util.g.d(photoCacheDataArr[i16].shoottime * 1000));
                        }
                        if (this.f42651d.w()) {
                            aVar.f42763b[i27].setOnClickListener(this.V);
                            aVar.f42763b[i27].setClickBoxImgVisibility(8);
                        } else {
                            PhotoCacheData photoCacheData6 = photoCacheData5;
                            aVar.f42763b[i27].setOnClickListener(this.f42651d.s((this.f42652e * i17) + i27, photoCacheData5.fakeType, photoCacheData5.lloc, photoCacheData6, J));
                            aVar.f42763b[i27].setCBClickListener(this.f42651d.z((this.f42652e * i17) + i27, photoCacheData5.fakeType, photoCacheData5.lloc, photoCacheData6, J));
                        }
                        aVar.f42675d.setUploadPersonVisibility(8);
                        aVar.f42763b[i27].setOnLongClickListener(null);
                    } else {
                        aVar.f42763b[i27].setOnClickListener(this.V);
                        aVar.f42763b[i27].setOnLongClickListener(this.W);
                    }
                }
                i27++;
                i18 = 1;
            }
        } else {
            aVar.f42676e.setVisibility(8);
            aVar.f42675d.setVisibility(8);
            aVar.f42762a.setVisibility(8);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004e, code lost:
    
        if (q(r6, r24.get(r7 - 1)) != false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02ea A[LOOP:1: B:101:0x02e2->B:103:0x02ea, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void Y(List<PhotoCacheData[]> list, List<PhotoCacheData> list2) {
        PhotoCacheData[] photoCacheDataArr;
        char c16;
        int i3;
        int i16;
        int i17;
        int i18;
        char c17;
        char c18;
        if (list2 == null) {
            return;
        }
        this.N.clear();
        int i19 = this.f42652e;
        PhotoCacheData[] photoCacheDataArr2 = new PhotoCacheData[i19];
        PhotoCacheData[] photoCacheDataArr3 = new PhotoCacheData[i19];
        ArrayList arrayList = new ArrayList(3);
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i36 = 0;
        int i37 = 0;
        int i38 = 0;
        int i39 = 0;
        int i46 = 0;
        while (true) {
            int i47 = i46;
            photoCacheDataArr = photoCacheDataArr3;
            if (i26 >= list2.size()) {
                break;
            }
            PhotoCacheData photoCacheData = list2.get(i26);
            if (photoCacheData == null) {
                i16 = i37;
            } else {
                if (i26 > 0) {
                    i16 = i37;
                } else {
                    i16 = i37;
                }
                if (i26 == this.f42651d.l()) {
                    i17 = i36;
                    this.f42651d.d(photoCacheData.lloc);
                } else {
                    i17 = i36;
                }
                photoCacheData.index = i28;
                i28++;
                i37 = 1;
                if (photoCacheData.shoottime > 0) {
                    if (list.size() == 0 && i38 == 0) {
                        photoCacheData.timevisible = true;
                        photoCacheData.poivisible = true;
                        photoCacheData.beginIndex = i27;
                        arrayList.add(Long.valueOf(photoCacheData.uploadUin));
                        photoCacheDataArr2[i38] = photoCacheData;
                        i38++;
                        i29++;
                        i39 = i26;
                        i46 = i47;
                        photoCacheDataArr3 = photoCacheDataArr;
                        i37 = i16;
                        i36 = i17;
                        i26++;
                    } else {
                        if (i38 % this.f42652e == 0) {
                            list.add(photoCacheDataArr2);
                            photoCacheDataArr2 = new PhotoCacheData[this.f42652e];
                            i38 = 0;
                        }
                        i18 = i28;
                        if (com.qzone.album.util.a.l(list2, i26, i39)) {
                            photoCacheData.timevisible = true;
                            photoCacheData.poivisible = true;
                            if (photoCacheDataArr2[0] != null) {
                                list.add(photoCacheDataArr2);
                                if (i27 < list.size() && list.get(i27) != null) {
                                    com.qzone.proxy.feedcomponent.b.a("TravelPhotoListAdapter", "changeToShareUploadString beginIndex:" + i27 + " groupNum:" + i29);
                                    list.get(i27)[0].uploadUinList = d(arrayList);
                                    list.get(i27)[0].groupNum = i29;
                                    i29 = 0;
                                }
                                i27 = list.size();
                            } else if (i27 < list.size() && list.get(i27) != null) {
                                com.qzone.proxy.feedcomponent.b.a("TravelPhotoListAdapter", "changeToShareUploadString beginIndex:" + i27 + " groupNum:" + i29);
                                c18 = 0;
                                list.get(i27)[0].uploadUinList = d(arrayList);
                                list.get(i27)[0].groupNum = i29;
                                i27 = list.size();
                                i29 = 0;
                                photoCacheDataArr2 = new PhotoCacheData[this.f42652e];
                                photoCacheDataArr2[c18] = photoCacheData;
                                arrayList.add(Long.valueOf(photoCacheData.uploadUin));
                            }
                            c18 = 0;
                            photoCacheDataArr2 = new PhotoCacheData[this.f42652e];
                            photoCacheDataArr2[c18] = photoCacheData;
                            arrayList.add(Long.valueOf(photoCacheData.uploadUin));
                        } else if (com.qzone.album.util.a.j(this.f42651d, list2, i26, i39)) {
                            photoCacheData.timevisible = true;
                            photoCacheData.poivisible = true;
                            if (photoCacheDataArr2[0] != null) {
                                list.add(photoCacheDataArr2);
                                if (i27 < list.size() && list.get(i27) != null) {
                                    com.qzone.proxy.feedcomponent.b.a("TravelPhotoListAdapter", "changeToShareUploadString beginIndex:" + i27 + " groupNum:" + i29);
                                    list.get(i27)[0].uploadUinList = d(arrayList);
                                    list.get(i27)[0].groupNum = i29;
                                    i29 = 0;
                                }
                                i27 = list.size();
                            } else if (i27 < list.size() && list.get(i27) != null) {
                                com.qzone.proxy.feedcomponent.b.a("TravelPhotoListAdapter", "changeToShareUploadString beginIndex:" + i27 + " groupNum:" + i29);
                                c17 = 0;
                                list.get(i27)[0].uploadUinList = d(arrayList);
                                list.get(i27)[0].groupNum = i29;
                                i27 = list.size();
                                i29 = 0;
                                PhotoCacheData[] photoCacheDataArr4 = new PhotoCacheData[this.f42652e];
                                photoCacheDataArr4[c17] = photoCacheData;
                                arrayList.add(Long.valueOf(photoCacheData.uploadUin));
                                photoCacheDataArr2 = photoCacheDataArr4;
                            }
                            c17 = 0;
                            PhotoCacheData[] photoCacheDataArr42 = new PhotoCacheData[this.f42652e];
                            photoCacheDataArr42[c17] = photoCacheData;
                            arrayList.add(Long.valueOf(photoCacheData.uploadUin));
                            photoCacheDataArr2 = photoCacheDataArr42;
                        } else {
                            arrayList.add(Long.valueOf(photoCacheData.uploadUin));
                            photoCacheDataArr2[i38] = photoCacheData;
                            i38++;
                            photoCacheData.beginIndex = i27;
                            i29++;
                            i39 = i26;
                            i46 = i47;
                            photoCacheDataArr3 = photoCacheDataArr;
                            i37 = i16;
                            i36 = i17;
                        }
                        i38 = 1;
                        photoCacheData.beginIndex = i27;
                        i29++;
                        i39 = i26;
                        i46 = i47;
                        photoCacheDataArr3 = photoCacheDataArr;
                        i37 = i16;
                        i36 = i17;
                    }
                } else {
                    i18 = i28;
                    i36 = i17 + 1;
                    if (this.N.size() == 0 && i16 == 0) {
                        photoCacheData.timevisible = true;
                        photoCacheDataArr[i16] = photoCacheData;
                        i37 = i16 + 1;
                        i46 = i26;
                        photoCacheDataArr3 = photoCacheDataArr;
                    } else {
                        if (i16 % this.f42652e == 0) {
                            this.N.add(photoCacheDataArr);
                            photoCacheDataArr3 = new PhotoCacheData[this.f42652e];
                            i16 = 0;
                        } else {
                            photoCacheDataArr3 = photoCacheDataArr;
                        }
                        if (QZoneAlbumUtil.A(this.H) && com.qzone.album.util.a.m(list2, i26, i47, false)) {
                            photoCacheData.timevisible = true;
                            if (photoCacheDataArr3[0] != null) {
                                this.N.add(photoCacheDataArr3);
                            }
                            photoCacheDataArr3 = new PhotoCacheData[this.f42652e];
                            photoCacheDataArr3[0] = photoCacheData;
                        } else {
                            photoCacheDataArr3[i16] = photoCacheData;
                            i37 = i16 + 1;
                        }
                        i46 = i26;
                    }
                }
                i28 = i18;
                i26++;
            }
            i46 = i47;
            photoCacheDataArr3 = photoCacheDataArr;
            i37 = i16;
            i26++;
        }
        int i48 = i36;
        if (photoCacheDataArr2[0] != null) {
            list.add(photoCacheDataArr2);
            if (i27 < list.size() && list.get(i27) != null) {
                com.qzone.proxy.feedcomponent.b.a("TravelPhotoListAdapter", "add last beginIndex:" + i27 + " groupNum:" + i29);
                c16 = 0;
                list.get(i27)[0].uploadUinList = d(arrayList);
                list.get(i27)[0].groupNum = i29;
                if (photoCacheDataArr[c16] != null) {
                    this.N.add(photoCacheDataArr);
                }
                int size = list.size();
                for (i3 = 0; i3 < this.N.size(); i3++) {
                    PhotoCacheData photoCacheData2 = this.N.get(i3)[0];
                    photoCacheData2.groupNum = i48;
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

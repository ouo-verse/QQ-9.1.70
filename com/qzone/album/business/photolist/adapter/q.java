package com.qzone.album.business.photolist.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qzone.album.business.photolist.adapter.u;
import com.qzone.album.business.photolist.ui.listitem.LoverHeaderCell;
import com.qzone.album.data.model.PhotoCacheData;
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
public class q extends o {

    /* renamed from: o0, reason: collision with root package name */
    private int f42743o0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends u.b {

        /* renamed from: d, reason: collision with root package name */
        LoverHeaderCell f42744d;

        /* renamed from: e, reason: collision with root package name */
        RelativeLayout f42745e;

        /* renamed from: f, reason: collision with root package name */
        View f42746f;

        /* renamed from: g, reason: collision with root package name */
        AsyncImageView f42747g;

        /* renamed from: h, reason: collision with root package name */
        RelativeLayout f42748h;

        /* renamed from: i, reason: collision with root package name */
        AsyncImageView f42749i;

        a() {
            super();
        }
    }

    public q(x4.a aVar, View.OnClickListener onClickListener) {
        super(aVar, onClickListener);
        this.f42743o0 = this.f42654h + u4.a.z().o(5.0f);
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
        LoverHeaderCell loverHeaderCell = (LoverHeaderCell) view.findViewById(R.id.ehq);
        aVar.f42744d = loverHeaderCell;
        loverHeaderCell.d(this.f42651d);
        aVar.f42745e = (RelativeLayout) view.findViewById(R.id.f166685hc3);
        View findViewById = view.findViewById(R.id.f166686hc4);
        aVar.f42746f = findViewById;
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.width = this.f42653f * 3;
        layoutParams.height = this.f42654h - u4.a.z().o(16.0f);
        aVar.f42746f.setLayoutParams(layoutParams);
        aVar.f42747g = (AsyncImageView) view.findViewById(R.id.hbv);
        aVar.f42749i = (AsyncImageView) view.findViewById(R.id.hk_);
        aVar.f42748h = (RelativeLayout) view.findViewById(R.id.hka);
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
            view = this.f42651d.getLayoutInflater().inflate(R.layout.bmg, (ViewGroup) null);
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
            com.qzone.proxy.feedcomponent.b.c("LoversPhotoListAdapter", e16.toString() + " position= " + i3);
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void W(a aVar, View view, int i3) {
        PhotoCacheData[] photoCacheDataArr;
        boolean z16;
        PhotoCacheData[] photoCacheDataArr2;
        RelativeLayout.LayoutParams layoutParams;
        PhotoCacheData photoCacheData;
        int i16;
        int i17;
        boolean z17;
        boolean z18;
        PhotoCacheData photoCacheData2;
        new ArrayList();
        if (getItem(i3) == null || (photoCacheDataArr = (PhotoCacheData[]) getItem(i3)) == null || photoCacheDataArr.length == 0) {
            return;
        }
        s4.d J = J(photoCacheDataArr[0]);
        aVar.f42744d.e(this, this.f42651d, photoCacheDataArr, J, this.C, this.E, this.G, this.H, i3);
        if (photoCacheDataArr[0] != null) {
            int i18 = i3 + 1;
            if (i18 < Q()) {
                Object item = getItem(i18);
                if (item instanceof PhotoCacheData[]) {
                    photoCacheDataArr2 = (PhotoCacheData[]) item;
                    layoutParams = (RelativeLayout.LayoutParams) aVar.f42746f.getLayoutParams();
                    photoCacheData = photoCacheDataArr[0];
                    if (photoCacheData == null && photoCacheData.timevisible && (photoCacheDataArr2 == null || (photoCacheDataArr2.length != 0 && photoCacheDataArr2[0].timevisible))) {
                        layoutParams.height = this.f42743o0;
                        layoutParams.topMargin = u4.a.z().o(16.0f);
                        int i19 = this.f42653f;
                        int i26 = photoCacheDataArr[0].numbersOfColumn;
                        layoutParams.width = i19 * i26;
                        i17 = i26 - 1;
                        z17 = true;
                        z18 = false;
                    } else {
                        if (photoCacheData == null && photoCacheData.timevisible && photoCacheDataArr2 != null && photoCacheDataArr2.length != 0) {
                            layoutParams.height = (this.f42654h - u4.a.z().o(16.0f)) + this.f42743o0 + u4.a.z().o(2.0f);
                            layoutParams.topMargin = u4.a.z().o(16.0f);
                            int i27 = this.f42653f;
                            i16 = photoCacheDataArr[0].numbersOfColumn;
                            layoutParams.width = i27 * i16;
                        } else if (photoCacheData == null && !photoCacheData.timevisible && (photoCacheDataArr2 == null || (photoCacheDataArr2.length != 0 && photoCacheDataArr2[0].timevisible))) {
                            layoutParams.height = this.f42743o0 + u4.a.z().o(16.0f);
                            layoutParams.topMargin = 0;
                            int i28 = this.f42653f;
                            int i29 = this.f42652e;
                            layoutParams.width = i28 * i29;
                            i17 = i29 - 1;
                            z17 = true;
                            z18 = z17;
                        } else {
                            layoutParams.height = this.f42654h + this.f42743o0 + u4.a.z().o(2.0f);
                            layoutParams.topMargin = 0;
                            int i36 = this.f42653f;
                            i16 = this.f42652e;
                            layoutParams.width = i36 * i16;
                        }
                        i17 = i16 - 1;
                        z17 = false;
                        z18 = z17;
                    }
                    aVar.f42746f.setLayoutParams(layoutParams);
                    photoCacheData2 = photoCacheDataArr[0];
                    if (photoCacheData2 != null) {
                        aVar.f42746f.setBackgroundResource(g4.d.f401218c[photoCacheData2.group]);
                    }
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aVar.f42745e.getLayoutParams();
                    if (!z17) {
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) aVar.f42747g.getLayoutParams();
                        layoutParams3.addRule(12, -1);
                        int i37 = this.f42653f;
                        layoutParams3.leftMargin = (i17 * i37) + layoutParams.leftMargin + (i37 / 2);
                        layoutParams2.height = u4.a.z().o(26.0f) + this.f42743o0 + u4.a.z().o(2.0f);
                        aVar.f42747g.setLayoutParams(layoutParams3);
                        aVar.f42747g.setVisibility(0);
                    } else {
                        layoutParams2.height = this.f42654h + u4.a.z().o(2.0f);
                        aVar.f42747g.setVisibility(8);
                    }
                    aVar.f42745e.setLayoutParams(layoutParams2);
                    aVar.f42746f.setVisibility(0);
                    aVar.f42762a.setVisibility(0);
                    z16 = z18;
                }
            }
            photoCacheDataArr2 = null;
            layoutParams = (RelativeLayout.LayoutParams) aVar.f42746f.getLayoutParams();
            photoCacheData = photoCacheDataArr[0];
            if (photoCacheData == null) {
            }
            if (photoCacheData == null) {
            }
            if (photoCacheData == null) {
            }
            layoutParams.height = this.f42654h + this.f42743o0 + u4.a.z().o(2.0f);
            layoutParams.topMargin = 0;
            int i362 = this.f42653f;
            i16 = this.f42652e;
            layoutParams.width = i362 * i16;
            i17 = i16 - 1;
            z17 = false;
            z18 = z17;
            aVar.f42746f.setLayoutParams(layoutParams);
            photoCacheData2 = photoCacheDataArr[0];
            if (photoCacheData2 != null) {
            }
            RelativeLayout.LayoutParams layoutParams22 = (RelativeLayout.LayoutParams) aVar.f42745e.getLayoutParams();
            if (!z17) {
            }
            aVar.f42745e.setLayoutParams(layoutParams22);
            aVar.f42746f.setVisibility(0);
            aVar.f42762a.setVisibility(0);
            z16 = z18;
        } else {
            aVar.f42746f.setVisibility(8);
            aVar.f42762a.setVisibility(8);
            z16 = false;
        }
        int L = L(i3);
        int i38 = 0;
        while (true) {
            int i39 = this.f42652e;
            if (i38 >= i39) {
                break;
            }
            int i46 = (i39 * i3) + i38;
            aVar.f42763b[i38].g();
            aVar.f42763b[i38].setTag(Integer.valueOf((this.f42652e * i3) + i38));
            aVar.f42763b[i38].setNumberCheckBoxTag(Integer.valueOf(i46));
            aVar.f42763b[i38].setCheckBoxTag(Integer.valueOf(i46));
            PhotoCacheData photoCacheData3 = photoCacheDataArr.length > i38 ? photoCacheDataArr[i38] : null;
            PhotoCacheData photoCacheData4 = photoCacheData3;
            int i47 = i38;
            aVar.f42763b[i38].f(this.f42651d, z16, photoCacheData3, photoCacheDataArr[0], this.C, this.D);
            if (photoCacheData4 != null) {
                if (AppSetting.f99565y) {
                    aVar.f42763b[i47].setContentDescription(com.qzone.util.l.a(R.string.nw8) + ((i46 - L) + 1) + ", " + com.qzone.album.util.g.d(photoCacheDataArr[0].shoottime * 1000));
                }
                aVar.f42763b[i47].setOnLongClickListener(null);
                if (this.C && !this.f42651d.w()) {
                    aVar.f42763b[i47].setOnClickListener(this.f42651d.s((this.f42652e * i3) + i47, photoCacheData4.fakeType, photoCacheData4.lloc, photoCacheData4, J));
                    aVar.f42763b[i47].setCBClickListener(this.f42651d.z((this.f42652e * i3) + i47, photoCacheData4.fakeType, photoCacheData4.lloc, photoCacheData4, J));
                } else {
                    aVar.f42763b[i47].setOnClickListener(this.V);
                    aVar.f42763b[i47].setOnLongClickListener(this.W);
                    aVar.f42763b[i47].setClickBoxImgVisibility(8);
                }
            }
            i38 = i47 + 1;
        }
        if (i3 == Q() - 1 && com.qzone.album.util.a.n(this.f42651d)) {
            if (this.C) {
                aVar.f42748h.setVisibility(8);
                return;
            }
            aVar.f42748h.setVisibility(0);
            aVar.f42749i.setAsyncImageProcessor(new z4.a());
            aVar.f42749i.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_lovers_footer.png");
            aVar.f42749i.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return;
        }
        aVar.f42748h.setVisibility(8);
    }

    private void X(List<PhotoCacheData[]> list, List<PhotoCacheData> list2) {
        char c16;
        int i3;
        int i16;
        int i17;
        List<PhotoCacheData> list3;
        int i18;
        int i19;
        PhotoCacheData[] photoCacheDataArr;
        int i26;
        PhotoCacheData[] photoCacheDataArr2;
        int i27;
        char c17;
        PhotoCacheData photoCacheData;
        List<PhotoCacheData> list4 = list2;
        if (list4 == null) {
            return;
        }
        this.N.clear();
        int i28 = this.f42652e;
        PhotoCacheData[] photoCacheDataArr3 = new PhotoCacheData[i28];
        PhotoCacheData[] photoCacheDataArr4 = new PhotoCacheData[i28];
        ArrayList arrayList = new ArrayList(3);
        int i29 = (this.C || this.P.size() <= 0) ? 0 : 1;
        int i36 = 0;
        int i37 = 0;
        int i38 = 0;
        int i39 = 0;
        int i46 = -1;
        int i47 = 0;
        boolean z16 = false;
        int i48 = 0;
        int i49 = 0;
        while (i36 < list2.size()) {
            PhotoCacheData photoCacheData2 = list4.get(i36);
            if (photoCacheData2 != null && (i36 <= 0 || !q(photoCacheData2, list4.get(i36 - 1)))) {
                if (com.qzone.album.env.common.a.m().B()) {
                    if (i36 == this.f42651d.l()) {
                        i19 = i29;
                        this.f42651d.d(photoCacheData2.lloc);
                    } else {
                        i19 = i29;
                    }
                    photoCacheData2.index = i47;
                    i47++;
                } else {
                    i19 = i29;
                }
                PhotoCacheData[] photoCacheDataArr5 = photoCacheDataArr4;
                if (photoCacheData2.shoottime > 0) {
                    if (i46 == -1 || z16) {
                        i18 = i19;
                    } else {
                        i18 = i46 + 1;
                        z16 = true;
                    }
                    i26 = i47;
                    if (list.size() == 0 && i37 == 0) {
                        photoCacheData2.timevisible = true;
                        photoCacheDataArr3[i37] = photoCacheData2;
                        i37++;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("add uploadUin:");
                        i17 = i46;
                        sb5.append(photoCacheData2.uploadUin);
                        sb5.append(" beginIndex:");
                        sb5.append(i38);
                        com.qzone.proxy.feedcomponent.b.a("LoversPhotoListAdapter", sb5.toString());
                        arrayList.add(Long.valueOf(photoCacheData2.uploadUin));
                        photoCacheDataArr4 = photoCacheDataArr5;
                        i49 = i36;
                        i47 = i26;
                        list3 = list2;
                    } else {
                        i17 = i46;
                        int i56 = this.f42652e;
                        photoCacheDataArr = photoCacheDataArr5;
                        if (i37 % i56 != 0 || (photoCacheData = photoCacheDataArr3[0]) == null) {
                            list3 = list2;
                            i27 = i49;
                        } else {
                            photoCacheData.numbersOfColumn = i37;
                            photoCacheData.group = i18 % i56;
                            list.add(photoCacheDataArr3);
                            photoCacheDataArr3 = new PhotoCacheData[this.f42652e];
                            list3 = list2;
                            i27 = i49;
                            i37 = 0;
                        }
                        if (com.qzone.album.util.a.m(list3, i36, i27, true)) {
                            photoCacheData2.timevisible = true;
                            PhotoCacheData photoCacheData3 = photoCacheDataArr3[0];
                            if (photoCacheData3 != null) {
                                photoCacheData3.numbersOfColumn = i37;
                                photoCacheData3.group = i18 % this.f42652e;
                                list.add(photoCacheDataArr3);
                                if (i38 < list.size() && list.get(i38) != null) {
                                    com.qzone.proxy.feedcomponent.b.a("LoversPhotoListAdapter", "changeToShareUploadString beginIndex:" + i38);
                                    list.get(i38)[0].shareUploadContent = c(arrayList);
                                }
                                i38 = list.size();
                            } else if (i38 < list.size() && list.get(i38) != null) {
                                com.qzone.proxy.feedcomponent.b.a("LoversPhotoListAdapter", "changeToShareUploadString beginIndex:" + i38);
                                c17 = 0;
                                list.get(i38)[0].shareUploadContent = c(arrayList);
                                i38 = list.size();
                                PhotoCacheData[] photoCacheDataArr6 = new PhotoCacheData[this.f42652e];
                                photoCacheDataArr6[c17] = photoCacheData2;
                                i18++;
                                com.qzone.proxy.feedcomponent.b.a("LoversPhotoListAdapter", "add uploadUin:" + photoCacheData2.uploadUin + " beginIndex:" + i38);
                                arrayList.add(Long.valueOf(photoCacheData2.uploadUin));
                                photoCacheDataArr3 = photoCacheDataArr6;
                                i37 = 1;
                            }
                            c17 = 0;
                            PhotoCacheData[] photoCacheDataArr62 = new PhotoCacheData[this.f42652e];
                            photoCacheDataArr62[c17] = photoCacheData2;
                            i18++;
                            com.qzone.proxy.feedcomponent.b.a("LoversPhotoListAdapter", "add uploadUin:" + photoCacheData2.uploadUin + " beginIndex:" + i38);
                            arrayList.add(Long.valueOf(photoCacheData2.uploadUin));
                            photoCacheDataArr3 = photoCacheDataArr62;
                            i37 = 1;
                        } else {
                            com.qzone.proxy.feedcomponent.b.a("LoversPhotoListAdapter", "add uploadUin:" + photoCacheData2.uploadUin + " beginIndex:" + i38);
                            arrayList.add(Long.valueOf(photoCacheData2.uploadUin));
                            photoCacheDataArr3[i37] = photoCacheData2;
                            i37++;
                        }
                        i49 = i36;
                        i47 = i26;
                        photoCacheDataArr4 = photoCacheDataArr;
                    }
                } else {
                    photoCacheDataArr = photoCacheDataArr5;
                    i17 = i46;
                    i26 = i47;
                    int i57 = i49;
                    list3 = list2;
                    if (this.N.size() == 0 && i39 == 0) {
                        photoCacheData2.timevisible = true;
                        photoCacheDataArr[i39] = photoCacheData2;
                        i39++;
                        i49 = i57;
                        i48 = i36;
                        i18 = i19;
                        i47 = i26;
                        photoCacheDataArr4 = photoCacheDataArr;
                    } else {
                        int i58 = this.f42652e;
                        if (i39 % i58 == 0) {
                            PhotoCacheData photoCacheData4 = photoCacheDataArr[0];
                            photoCacheData4.numbersOfColumn = i39;
                            photoCacheData4.group = i19 % i58;
                            this.N.add(photoCacheDataArr);
                            photoCacheDataArr2 = new PhotoCacheData[this.f42652e];
                            i39 = 0;
                        } else {
                            photoCacheDataArr2 = photoCacheDataArr;
                        }
                        if (QZoneAlbumUtil.A(this.H) && com.qzone.album.util.a.m(list3, i36, i48, false)) {
                            photoCacheData2.timevisible = true;
                            PhotoCacheData photoCacheData5 = photoCacheDataArr2[0];
                            if (photoCacheData5 != null) {
                                photoCacheData5.numbersOfColumn = i39;
                                photoCacheData5.group = i19 % this.f42652e;
                                this.N.add(photoCacheDataArr2);
                                i19++;
                            }
                            photoCacheDataArr2 = new PhotoCacheData[this.f42652e];
                            photoCacheDataArr2[0] = photoCacheData2;
                            i39 = 1;
                        } else {
                            photoCacheDataArr2[i39] = photoCacheData2;
                            i39++;
                        }
                        i49 = i57;
                        i48 = i36;
                        i17 = i19;
                        i47 = i26;
                        photoCacheDataArr4 = photoCacheDataArr2;
                        i18 = i17;
                    }
                }
            } else {
                i17 = i46;
                int i59 = i29;
                list3 = list4;
                i18 = i59;
            }
            i36++;
            i46 = i17;
            List<PhotoCacheData> list5 = list3;
            i29 = i18;
            list4 = list5;
        }
        PhotoCacheData[] photoCacheDataArr7 = photoCacheDataArr4;
        int i65 = i29;
        int i66 = i46;
        PhotoCacheData photoCacheData6 = photoCacheDataArr3[0];
        if (photoCacheData6 != null) {
            photoCacheData6.numbersOfColumn = i37;
            photoCacheData6.group = i65 % this.f42652e;
            i3 = i65 + 1;
            list.add(photoCacheDataArr3);
            if (i38 >= list.size() || list.get(i38) == null) {
                c16 = 0;
            } else {
                com.qzone.proxy.feedcomponent.b.a("LoversPhotoListAdapter", "add last beginIndex:" + i38);
                c16 = 0;
                list.get(i38)[0].shareUploadContent = c(arrayList);
            }
        } else {
            c16 = 0;
            i3 = i65;
        }
        PhotoCacheData photoCacheData7 = photoCacheDataArr7[c16];
        if (photoCacheData7 != null) {
            photoCacheData7.numbersOfColumn = i39;
            if (i66 != -1) {
                i16 = i66 % this.f42652e;
            } else {
                i16 = i3 % this.f42652e;
            }
            photoCacheData7.group = i16;
            this.N.add(photoCacheDataArr7);
        }
        list.addAll(this.N);
    }
}

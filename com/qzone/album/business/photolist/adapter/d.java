package com.qzone.album.business.photolist.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qzone.album.business.photolist.adapter.h;
import com.qzone.album.business.photolist.ui.listitem.LoverHeaderCell;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.widget.AsyncImageView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d extends h {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a extends h.d {

        /* renamed from: e, reason: collision with root package name */
        LoverHeaderCell f42679e;

        /* renamed from: f, reason: collision with root package name */
        View f42680f;

        /* renamed from: g, reason: collision with root package name */
        AsyncImageView f42681g;

        /* renamed from: h, reason: collision with root package name */
        RelativeLayout f42682h;

        /* renamed from: i, reason: collision with root package name */
        AsyncImageView f42683i;
    }

    public d(x4.a aVar, View.OnClickListener onClickListener) {
        super(aVar, onClickListener);
    }

    private void P(a aVar, View view, int i3) {
        PhotoCacheData[] photoCacheDataArr;
        int i16;
        PhotoCacheData photoCacheData;
        if (getItem(i3) == null || (photoCacheDataArr = (PhotoCacheData[]) getItem(i3)) == null || photoCacheDataArr.length == 0) {
            return;
        }
        aVar.f42679e.e(this, this.f42651d, photoCacheDataArr, null, this.C, this.E, false, this.H, i3);
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
            if (photoCacheData3.picItem != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar.f42680f.getLayoutParams();
                layoutParams.width = aVar.f42695a.b();
                layoutParams.height = aVar.f42695a.a() + u4.a.z().o(22.0f);
                layoutParams.topMargin = u4.a.z().o(16.0f);
                layoutParams.leftMargin = u4.a.z().o(32.0f);
                aVar.f42680f.setLayoutParams(layoutParams);
                View view2 = aVar.f42680f;
                int[] iArr = g4.d.f401218c;
                view2.setBackgroundResource(iArr[i3 % iArr.length]);
                if (i3 % g4.d.f401218c.length == 0) {
                    aVar.f42681g.setAsyncImageProcessor(new z4.a());
                    aVar.f42681g.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_lovers_sigh_icon.png");
                } else {
                    aVar.f42681g.setAsyncImageProcessor(new z4.a());
                    aVar.f42681g.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_lovers_love_icon.png");
                }
                aVar.f42681g.setVisibility(0);
            }
            if (com.qzone.adapter.feedcomponent.i.H().S0()) {
                aVar.f42695a.setContentDescription(com.qzone.util.l.a(R.string.f171652k10) + ((i19 - i16) + 1) + ", " + com.qzone.album.util.g.d(photoCacheDataArr[0].uploadtime * 1000));
            }
            if (this.C) {
                aVar.f42695a.setClickable(false);
                aVar.f42695a.setLongClickable(false);
                aVar.f42695a.setOnClickListener(this.f42651d.a(this.f42652e * i3, photoCacheData3.fakeType));
            } else {
                aVar.f42695a.setOnClickListener(this.V);
                aVar.f42695a.setOnLongClickListener(this.W);
                aVar.f42695a.setClickable(true);
                aVar.f42695a.setLongClickable(true);
            }
        }
        if (i3 == getCount() - 1 && com.qzone.album.util.a.n(this.f42651d)) {
            if (this.C) {
                aVar.f42682h.setVisibility(8);
                return;
            }
            aVar.f42682h.setVisibility(0);
            aVar.f42683i.setAsyncImageProcessor(new z4.a());
            aVar.f42683i.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_lovers_footer.png");
            aVar.f42683i.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return;
        }
        aVar.f42682h.setVisibility(8);
    }

    @Override // com.qzone.album.business.photolist.adapter.h
    protected void J() {
        super.J();
        this.f42653f -= u4.a.z().o(40.0f);
    }

    protected void O(a aVar, View view) {
        super.K(aVar, view);
        LoverHeaderCell loverHeaderCell = (LoverHeaderCell) view.findViewById(R.id.ehq);
        aVar.f42679e = loverHeaderCell;
        loverHeaderCell.d(this.f42651d);
        aVar.f42697c = (ViewGroup) view.findViewById(R.id.fre);
        CellTextView cellTextView = (CellTextView) view.findViewById(R.id.dam);
        aVar.f42696b = cellTextView;
        cellTextView.setFont(10050, "https://qzonestyle.gtimg.cn/qzone/space_item/material/CustomFont/org/2/10050/FZMiaoWu_GB_YS.zip", 2);
        View findViewById = view.findViewById(R.id.f166686hc4);
        aVar.f42680f = findViewById;
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.width = this.f42653f;
        layoutParams.height = this.f42654h;
        aVar.f42680f.setLayoutParams(layoutParams);
        aVar.f42681g = (AsyncImageView) view.findViewById(R.id.hbv);
        aVar.f42683i = (AsyncImageView) view.findViewById(R.id.hk_);
        aVar.f42682h = (RelativeLayout) view.findViewById(R.id.hka);
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f42651d.getLayoutInflater().inflate(R.layout.bma, (ViewGroup) null);
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
            com.qzone.proxy.feedcomponent.b.c("BigLoversPhotoListAdapter", e16.toString() + " position= " + i3);
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
                            com.qzone.proxy.feedcomponent.b.a("BigLoversPhotoListAdapter", "add uploadUin:" + photoCacheData2.uploadUin);
                            arrayList3.add(Long.valueOf(photoCacheData2.uploadUin));
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
                                    photoCacheData3.shareUploadContent = c(arrayList3);
                                    arrayList.add(photoCacheDataArr);
                                    i17 = i16 + 1;
                                } else if (i17 < arrayList.size() && arrayList.get(i17) != null) {
                                    ((PhotoCacheData[]) arrayList.get(i17))[0].shareUploadContent = c(arrayList3);
                                    i17 = i16;
                                }
                                photoCacheDataArr = new PhotoCacheData[this.f42652e];
                                photoCacheDataArr[0] = photoCacheData2;
                                com.qzone.proxy.feedcomponent.b.a("BigLoversPhotoListAdapter", "add uploadUin:" + photoCacheData2.uploadUin);
                                arrayList3.add(Long.valueOf(photoCacheData2.uploadUin));
                                i18 = 1;
                            } else {
                                if (!photoCacheData2.desc.equals(this.L)) {
                                    photoCacheData2.descvisible = true;
                                    this.L = photoCacheData2.desc;
                                }
                                com.qzone.proxy.feedcomponent.b.a("BigLoversPhotoListAdapter", "add uploadUin:" + photoCacheData2.uploadUin);
                                arrayList3.add(Long.valueOf(photoCacheData2.uploadUin));
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
                    ((PhotoCacheData[]) arrayList.get(i17))[0].shareUploadContent = c(arrayList3);
                }
            }
        }
        return arrayList;
    }
}

package com.qzone.album.business.photolist.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.qzone.album.business.photolist.adapter.u;
import com.qzone.album.business.photolist.controller.BasePhotoModelController;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.widget.SafeTextView;
import com.qzone.widget.AsyncImageView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class p extends u {

    /* renamed from: g0, reason: collision with root package name */
    private int f42731g0;

    /* renamed from: h0, reason: collision with root package name */
    protected View.OnClickListener f42732h0;

    /* renamed from: i0, reason: collision with root package name */
    private AlbumCacheData f42733i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f42734j0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends u.b {

        /* renamed from: d, reason: collision with root package name */
        SafeTextView f42735d;

        /* renamed from: e, reason: collision with root package name */
        SafeTextView f42736e;

        /* renamed from: f, reason: collision with root package name */
        CellTextView f42737f;

        /* renamed from: g, reason: collision with root package name */
        RelativeLayout f42738g;

        /* renamed from: h, reason: collision with root package name */
        RelativeLayout f42739h;

        /* renamed from: i, reason: collision with root package name */
        View f42740i;

        /* renamed from: j, reason: collision with root package name */
        AsyncImageView f42741j;

        a() {
            super();
        }
    }

    public p(x4.a aVar, View.OnClickListener onClickListener) {
        super(aVar, onClickListener);
        this.f42734j0 = 1;
        this.f42732h0 = onClickListener;
        this.f42731g0 = this.f42654h + u4.a.z().o(5.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0181  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void S(a aVar, View view, int i3) {
        PhotoCacheData[] photoCacheDataArr;
        int i16;
        int i17;
        int i18;
        AlbumCacheData albumCacheData;
        if (getItem(i3) == null || (photoCacheDataArr = (PhotoCacheData[]) getItem(i3)) == null || photoCacheDataArr.length == 0) {
            return;
        }
        aVar.f42735d.setVisibility(8);
        aVar.f42736e.setVisibility(8);
        aVar.f42737f.setVisibility(8);
        int i19 = 0;
        if (i3 == 0 && (albumCacheData = this.f42733i0) != null) {
            if (albumCacheData.getAlbumThemeTypeValue() == 8) {
                aVar.f42735d.setVisibility(0);
            } else if (this.f42733i0.getAlbumThemeTypeValue() == 11) {
                aVar.f42737f.setVisibility(0);
            } else {
                aVar.f42736e.setVisibility(0);
            }
        }
        AlbumCacheData albumCacheData2 = this.f42733i0;
        if (albumCacheData2 != null && albumCacheData2.getAlbumThemeTypeValue() == 11) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.f42738g.getLayoutParams();
            if (this.f42733i0.albumtype == 11) {
                view.setBackgroundResource(R.color.a8h);
                layoutParams.leftMargin = K();
                aVar.f42739h.setVisibility(0);
                PhotoCacheData[] photoCacheDataArr2 = (PhotoCacheData[]) getItem(i3 + 1);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aVar.f42740i.getLayoutParams();
                PhotoCacheData photoCacheData = photoCacheDataArr[0];
                boolean z16 = true;
                if (photoCacheData != null && photoCacheDataArr2 == null && i3 == 0) {
                    layoutParams2.height = this.f42731g0;
                    layoutParams2.topMargin = u4.a.z().o(16.0f);
                    int i26 = this.f42653f;
                    i17 = photoCacheDataArr[0].numbersOfColumn;
                    layoutParams2.width = i26 * i17;
                } else {
                    if (photoCacheData != null && photoCacheDataArr2 != null && photoCacheDataArr2.length != 0) {
                        layoutParams2.height = (this.f42654h - u4.a.z().o(16.0f)) + this.f42731g0 + u4.a.z().o(2.0f);
                        layoutParams2.topMargin = u4.a.z().o(16.0f);
                        int i27 = this.f42653f;
                        i16 = photoCacheDataArr[0].numbersOfColumn;
                        layoutParams2.width = i27 * i16;
                    } else if (photoCacheData != null && photoCacheDataArr2 == null && i3 != 0) {
                        layoutParams2.height = this.f42731g0 + u4.a.z().o(16.0f);
                        layoutParams2.topMargin = 0;
                        int i28 = this.f42653f;
                        i17 = this.f42652e;
                        layoutParams2.width = i28 * i17;
                    } else {
                        layoutParams2.height = this.f42654h + this.f42731g0 + u4.a.z().o(2.0f);
                        layoutParams2.topMargin = 0;
                        int i29 = this.f42653f;
                        i16 = this.f42652e;
                        layoutParams2.width = i29 * i16;
                    }
                    i18 = i16 - 1;
                    z16 = false;
                    aVar.f42740i.setLayoutParams(layoutParams2);
                    if (photoCacheDataArr[0] != null) {
                        aVar.f42740i.setBackgroundResource(R.color.a65);
                    }
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) aVar.f42739h.getLayoutParams();
                    if (!z16) {
                        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) aVar.f42741j.getLayoutParams();
                        layoutParams4.addRule(12, -1);
                        int i36 = this.f42653f;
                        layoutParams4.leftMargin = (i18 * i36) + layoutParams2.leftMargin + (i36 / 2);
                        layoutParams3.height = u4.a.z().o(26.0f) + this.f42731g0 + u4.a.z().o(2.0f);
                        aVar.f42741j.setLayoutParams(layoutParams4);
                        aVar.f42741j.setAsyncImageProcessor(new z4.a());
                        aVar.f42741j.setAsyncImage("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_lovers_love_icon.png");
                        aVar.f42741j.setVisibility(0);
                    } else {
                        layoutParams3.height = this.f42654h + u4.a.z().o(2.0f);
                        aVar.f42741j.setVisibility(8);
                    }
                    aVar.f42739h.setLayoutParams(layoutParams3);
                }
                i18 = i17 - 1;
                aVar.f42740i.setLayoutParams(layoutParams2);
                if (photoCacheDataArr[0] != null) {
                }
                RelativeLayout.LayoutParams layoutParams32 = (RelativeLayout.LayoutParams) aVar.f42739h.getLayoutParams();
                if (!z16) {
                }
                aVar.f42739h.setLayoutParams(layoutParams32);
            } else {
                aVar.f42739h.setVisibility(8);
            }
            aVar.f42738g.setLayoutParams(layoutParams);
        }
        while (i19 < this.f42652e) {
            aVar.f42763b[i19].g();
            aVar.f42763b[i19].setTag(Integer.valueOf((this.f42652e * i3) + i19));
            PhotoCacheData photoCacheData2 = photoCacheDataArr.length > i19 ? photoCacheDataArr[i19] : null;
            aVar.f42763b[i19].f(this.f42651d, false, photoCacheData2, null, this.C, this.D);
            if (photoCacheData2 != null) {
                aVar.f42763b[i19].setOnClickListener(null);
                aVar.f42763b[i19].setClickBoxImgVisibility(8);
            }
            i19++;
        }
    }

    @Override // com.qzone.album.business.photolist.adapter.u
    protected int K() {
        if (((BasePhotoModelController) this.f42651d).Y2()) {
            return u4.a.z().o(12.0f);
        }
        return 0;
    }

    protected void Q(a aVar, View view) {
        super.N(aVar, view);
        aVar.f42735d = (SafeTextView) view.findViewById(R.id.jph);
        aVar.f42736e = (SafeTextView) view.findViewById(R.id.jq9);
        CellTextView cellTextView = (CellTextView) view.findViewById(R.id.jpb);
        aVar.f42737f = cellTextView;
        cellTextView.setNinePatchBackground(R.drawable.fwo);
        aVar.f42737f.setFont(10050, "https://qzonestyle.gtimg.cn/qzone/space_item/material/CustomFont/org/2/10050/FZMiaoWu_GB_YS.zip", 2);
        aVar.f42738g = (RelativeLayout) view.findViewById(R.id.hk6);
        aVar.f42739h = (RelativeLayout) view.findViewById(R.id.hk5);
        View findViewById = view.findViewById(R.id.hk7);
        aVar.f42740i = findViewById;
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.width = this.f42653f * 3;
        layoutParams.height = this.f42654h - u4.a.z().o(16.0f);
        aVar.f42740i.setLayoutParams(layoutParams);
        aVar.f42741j = (AsyncImageView) view.findViewById(R.id.hk8);
    }

    public void R(AlbumCacheData albumCacheData) {
        this.f42733i0 = albumCacheData;
    }

    public void T(int i3) {
        this.f42734j0 = i3;
    }

    @Override // com.qzone.album.business.photolist.adapter.a
    public List<PhotoCacheData[]> a(List<PhotoCacheData> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            PhotoCacheData[] photoCacheDataArr = new PhotoCacheData[this.f42652e];
            int i3 = 0;
            for (int i16 = 0; i16 < list.size(); i16++) {
                PhotoCacheData photoCacheData = list.get(i16);
                if (photoCacheData != null) {
                    photoCacheData.index = i16;
                    if (photoCacheData.isFakePhoto()) {
                        int i17 = this.f42652e;
                        if (i3 % i17 == 0) {
                            PhotoCacheData photoCacheData2 = photoCacheDataArr[0];
                            if (photoCacheData2 != null) {
                                photoCacheData2.numbersOfColumn = i3;
                            }
                            photoCacheDataArr = new PhotoCacheData[i17];
                            arrayList.add(photoCacheDataArr);
                            i3 = 0;
                        }
                        photoCacheDataArr[i3] = photoCacheData;
                        i3++;
                    }
                }
            }
            PhotoCacheData photoCacheData3 = photoCacheDataArr[0];
            if (photoCacheData3 != null) {
                photoCacheData3.numbersOfColumn = i3;
            }
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.f42651d.getLayoutInflater().inflate(R.layout.f168995bi2, (ViewGroup) null);
            aVar = new a();
            Q(aVar, view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        try {
            S(aVar, view, i3);
        } catch (OutOfMemoryError e16) {
            com.qzone.proxy.feedcomponent.b.c("FakeVideoViewAdapter", e16.toString() + " position= " + i3);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    @Override // com.qzone.album.business.photolist.adapter.u
    public void O(x4.a aVar) {
    }
}

package com.qzone.album.business.photolist.ui.listitem;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.qzone.album.business.photolist.ui.SharingOwnersListBar;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PhotoPoiArea;
import com.qzone.album.data.model.PoiInfo;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.widget.SafeTextView;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import s4.d;
import x4.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class TravelHeaderCell extends LinearLayout {
    protected CellTextView C;
    protected ImageView D;
    protected View E;
    protected CellTextView F;
    protected CellTextView G;
    protected SharingOwnersListBar H;
    protected SafeTextView I;
    protected Button J;
    protected RelativeLayout K;
    private View L;

    /* renamed from: d, reason: collision with root package name */
    protected NoShootTimeTitleLayout f43652d;

    /* renamed from: e, reason: collision with root package name */
    protected LinearLayout f43653e;

    /* renamed from: f, reason: collision with root package name */
    protected RelativeLayout f43654f;

    /* renamed from: h, reason: collision with root package name */
    protected SafeTextView f43655h;

    /* renamed from: i, reason: collision with root package name */
    protected ImageView f43656i;

    /* renamed from: m, reason: collision with root package name */
    protected CellTextView f43657m;

    public TravelHeaderCell(Context context) {
        super(context);
    }

    public void a(a aVar) {
        View inflate = LayoutInflater.from(aVar.k()).inflate(R.layout.bj5, this);
        this.f43652d = (NoShootTimeTitleLayout) inflate.findViewById(R.id.hcd);
        this.f43653e = (LinearLayout) inflate.findViewById(R.id.f166694he2);
        this.f43654f = (RelativeLayout) inflate.findViewById(R.id.f166693he1);
        this.f43655h = (SafeTextView) inflate.findViewById(R.id.f166692he0);
        this.I = (SafeTextView) inflate.findViewById(R.id.jlb);
        this.K = (RelativeLayout) inflate.findViewById(R.id.frf);
        this.f43656i = (ImageView) inflate.findViewById(R.id.fw6);
        this.J = (Button) inflate.findViewById(R.id.frc);
        this.f43657m = (CellTextView) inflate.findViewById(R.id.fwe);
        this.C = (CellTextView) inflate.findViewById(R.id.fvz);
        this.D = (ImageView) inflate.findViewById(R.id.fw7);
        this.F = (CellTextView) inflate.findViewById(R.id.dav);
        this.E = inflate.findViewById(R.id.xfp);
        this.L = inflate.findViewById(R.id.ll8);
        CellTextView cellTextView = (CellTextView) inflate.findViewById(R.id.daw);
        this.G = cellTextView;
        cellTextView.setFont(10050, "https://qzonestyle.gtimg.cn/qzone/space_item/material/CustomFont/org/2/10050/FZMiaoWu_GB_YS.zip", 2);
        this.H = (SharingOwnersListBar) inflate.findViewById(R.id.f166695he3);
    }

    public void setUploadPersonVisibility(int i3) {
        this.H.setVisibility(i3);
    }

    public TravelHeaderCell(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void b(com.qzone.album.business.photolist.adapter.a aVar, a aVar2, PhotoCacheData[] photoCacheDataArr, d dVar, boolean z16, boolean z17, boolean z18, int i3, long j3, int i16) {
        String str;
        PoiInfo poiInfo;
        if (z16) {
            this.f43657m.setMaxWidth(aVar2.getResources().getDisplayMetrics().widthPixels / 2);
        } else {
            this.f43657m.setMaxWidth((aVar2.getResources().getDisplayMetrics().widthPixels * 5) / 9);
        }
        PhotoPoiArea f16 = com.qzone.album.util.a.f(aVar2, photoCacheDataArr[0]);
        PhotoCacheData photoCacheData = photoCacheDataArr[0];
        if (photoCacheData != null && photoCacheData.timevisible) {
            long j16 = photoCacheData.shoottime * 1000;
            if (j16 > 0) {
                this.I.setVisibility(0);
                this.I.setText(QZoneAlbumUtil.n(j16));
                String a16 = com.qzone.album.util.a.a(f16, j3);
                if (TextUtils.isEmpty(a16)) {
                    this.f43655h.setVisibility(8);
                } else {
                    this.f43655h.setVisibility(0);
                    this.f43655h.setText("DAY" + a16);
                }
                this.f43653e.setVisibility(0);
                this.f43652d.setVisibility(8);
                this.f43654f.setVisibility(0);
            } else {
                this.f43652d.setVisibility(0);
                this.f43652d.b(i3, aVar, aVar2, photoCacheDataArr, dVar, z17);
                this.f43654f.setVisibility(8);
            }
        } else {
            this.f43652d.setVisibility(8);
            this.f43654f.setVisibility(8);
        }
        this.J.setVisibility(8);
        this.D.setVisibility(8);
        PhotoCacheData photoCacheData2 = photoCacheDataArr[0];
        if (photoCacheData2 != null && photoCacheData2.poivisible) {
            if (f16 != null) {
                String trim = f16.sceneryName.trim();
                if (TextUtils.isEmpty(trim) && (poiInfo = f16.poiInfo) != null) {
                    str = poiInfo.poiName.trim();
                } else {
                    str = "";
                }
                if (!TextUtils.isEmpty(trim.trim() + str.trim())) {
                    this.K.setVisibility(0);
                    this.f43656i.setVisibility(0);
                    if (z16) {
                        this.J.setVisibility(0);
                        this.J.setText(l.a(R.string.u8z));
                        if (z17 && !aVar2.y() && !z18) {
                            this.D.setVisibility(0);
                        }
                    }
                    if (!TextUtils.isEmpty(trim)) {
                        this.f43657m.setVisibility(0);
                        this.f43657m.setText(trim);
                        this.f43657m.setTextColor(aVar2.getResources().getColor(R.color.black));
                    }
                    if (!TextUtils.isEmpty(str)) {
                        this.C.setVisibility(0);
                        this.C.setText(str);
                    }
                } else if (z17) {
                    this.K.setVisibility(0);
                    this.f43656i.setVisibility(0);
                    this.f43657m.setVisibility(0);
                    this.f43657m.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumEditLocation", "\u7f16\u8f91\u5730\u70b9"));
                    this.f43657m.setTextColor(aVar2.getResources().getColor(R.color.f157894a60));
                    if (z16) {
                        this.J.setVisibility(0);
                        this.J.setText(l.a(R.string.u8x));
                        if (!aVar2.y() && !z18) {
                            this.D.setVisibility(0);
                        } else {
                            this.D.setVisibility(8);
                        }
                    }
                } else {
                    this.K.setVisibility(0);
                    this.f43656i.setVisibility(8);
                    this.f43657m.setVisibility(8);
                    this.C.setVisibility(8);
                }
                String str2 = f16.description;
                if (z17) {
                    this.L.setVisibility(0);
                    if (!TextUtils.isEmpty(str2)) {
                        this.F.setRichText(str2);
                    } else {
                        this.F.setRichText(aVar2.getResources().getText(R.string.gbt));
                    }
                } else if (TextUtils.isEmpty(str2)) {
                    this.L.setVisibility(8);
                } else {
                    this.F.setRichText(str2);
                    this.L.setVisibility(0);
                }
            }
            List<Long> list = photoCacheDataArr[0].uploadUinList;
            if (list != null && list.size() > 0 && aVar2.g() != null && aVar2.g().sharingAlbumClientAttrArrayList != null && aVar2.g().sharingAlbumClientAttrArrayList.size() >= 2) {
                this.H.e(aVar2.g(), (ArrayList) photoCacheDataArr[0].uploadUinList, 4, getResources().getDimensionPixelSize(R.dimen.f159514ap0), getResources().getDimensionPixelOffset(R.dimen.aoz), true);
                this.H.setVisibility(0);
            } else {
                this.H.setVisibility(8);
            }
            setVisibility(0);
        } else {
            this.K.setVisibility(8);
            this.f43656i.setVisibility(8);
            this.f43657m.setVisibility(8);
            this.C.setVisibility(8);
            this.L.setVisibility(8);
        }
        if (this.K.getVisibility() == 8 && this.f43654f.getVisibility() == 8 && this.f43652d.getVisibility() == 8) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
        PhotoCacheData photoCacheData3 = photoCacheDataArr[0];
        if (photoCacheData3 != null && photoCacheData3.descvisible && !TextUtils.isEmpty(photoCacheData3.desc) && aVar2.f()) {
            setVisibility(0);
            this.G.setRichText(photoCacheDataArr[0].desc);
            this.G.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.G.getLayoutParams();
            if (!photoCacheDataArr[0].poivisible) {
                layoutParams.topMargin = u4.a.z().o(12.0f);
            } else {
                layoutParams.topMargin = 0;
            }
            this.G.setLayoutParams(layoutParams);
        } else {
            this.G.setVisibility(8);
        }
        if (!z16 && z17 && f16 != null) {
            this.f43657m.setClickable(true);
            this.f43657m.setOnClickListener(aVar2.v(f16));
            this.G.setClickable(true);
            this.G.setOnClickListener(aVar2.r(photoCacheDataArr[0]));
            this.F.setClickable(true);
            this.F.setOnClickListener(aVar2.j(f16));
            this.E.setOnClickListener(aVar2.j(f16));
        }
        if (!z16 || photoCacheDataArr[0] == null) {
            return;
        }
        aVar.v(dVar);
        if (photoCacheDataArr[0].allSelectedStatus) {
            this.J.setSelected(true);
            this.J.setText(l.a(R.string.u8y));
        } else {
            this.J.setSelected(false);
            this.J.setText(l.a(R.string.f172795u90));
        }
        this.f43652d.setBtnSelected(photoCacheDataArr[0].allSelectedStatus, aVar2.n(dVar));
        this.J.setVisibility(0);
        this.J.setOnClickListener(aVar2.n(dVar));
        if (aVar2.h()) {
            this.D.setOnClickListener(aVar2.q(f16));
            this.f43657m.setClickable(true);
            this.f43657m.setOnClickListener(aVar2.q(f16));
        } else if (aVar2.w() || aVar2.A()) {
            this.J.setVisibility(4);
            this.J.setClickable(false);
        }
    }
}

package com.qzone.album.business.photolist.ui.listitem;

import NS_MOBILE_PHOTO.TimeEvent;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.qzone.album.data.model.LoveAlbumTimeEvent;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.SharingAlbumClientAttr;
import com.qzone.album.data.model.TimeLine;
import com.qzone.album.util.g;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.widget.FeedDate;
import com.qzone.proxy.feedcomponent.widget.SafeTextView;
import com.qzone.util.l;
import com.qzone.widget.AvatarImageView;
import com.tencent.mobileqq.R;
import java.util.Map;
import s4.d;
import x4.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class LoverHeaderCell extends LinearLayout {
    protected AvatarImageView C;
    protected FeedDate D;
    protected Button E;
    protected RelativeLayout F;
    protected CellTextView G;
    private View H;

    /* renamed from: d, reason: collision with root package name */
    protected NoShootTimeTitleLayout f43609d;

    /* renamed from: e, reason: collision with root package name */
    protected FrameLayout f43610e;

    /* renamed from: f, reason: collision with root package name */
    protected SafeTextView f43611f;

    /* renamed from: h, reason: collision with root package name */
    protected CellTextView f43612h;

    /* renamed from: i, reason: collision with root package name */
    protected SafeTextView f43613i;

    /* renamed from: m, reason: collision with root package name */
    protected AvatarImageView f43614m;

    public LoverHeaderCell(Context context) {
        super(context);
    }

    public void d(a aVar) {
        View.inflate(aVar.k(), R.layout.f168998bj1, this);
        setOrientation(1);
        this.f43609d = (NoShootTimeTitleLayout) findViewById(R.id.hcd);
        this.F = (RelativeLayout) findViewById(R.id.hby);
        this.E = (Button) findViewById(R.id.dai);
        FeedDate feedDate = (FeedDate) findViewById(R.id.hbx);
        this.D = feedDate;
        feedDate.setTextColor(aVar.getResources().getColor(R.color.a67));
        this.f43610e = (FrameLayout) findViewById(R.id.f166682hc0);
        this.f43611f = (SafeTextView) findViewById(R.id.f166683hc1);
        this.f43613i = (SafeTextView) findViewById(R.id.hbw);
        this.f43612h = (CellTextView) findViewById(R.id.dah);
        this.H = findViewById(R.id.ll8);
        this.f43614m = (AvatarImageView) findViewById(R.id.f166684hc2);
        this.C = (AvatarImageView) findViewById(R.id.hbz);
        this.G = (CellTextView) findViewById(R.id.dam);
    }

    public LoverHeaderCell(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SharingAlbumClientAttr c(a aVar, long j3) {
        for (int i3 = 0; i3 < aVar.g().sharingAlbumClientAttrArrayList.size(); i3++) {
            SharingAlbumClientAttr sharingAlbumClientAttr = aVar.g().sharingAlbumClientAttrArrayList.get(i3);
            if (sharingAlbumClientAttr.uin == j3) {
                return sharingAlbumClientAttr;
            }
        }
        return null;
    }

    private void b(com.qzone.album.business.photolist.adapter.a aVar, a aVar2, PhotoCacheData[] photoCacheDataArr, d dVar, boolean z16, boolean z17, int i3) {
        if (photoCacheDataArr == null || photoCacheDataArr.length <= 0 || photoCacheDataArr[0] == null || aVar2 == null || !z16) {
            return;
        }
        aVar.v(dVar);
        if (photoCacheDataArr[0].allSelectedStatus) {
            this.E.setSelected(true);
            this.E.setText(l.a(R.string.f172156nw4));
        } else {
            this.E.setSelected(false);
            this.E.setText(l.a(R.string.f172155nw3));
        }
        this.f43609d.setBtnSelected(photoCacheDataArr[0].allSelectedStatus, aVar2.n(dVar));
        this.E.setOnClickListener(aVar2.n(dVar));
        if (aVar2.h()) {
            return;
        }
        if (aVar2.w() || aVar2.A()) {
            this.E.setVisibility(4);
            this.E.setClickable(false);
        }
    }

    private void g(a aVar, PhotoCacheData photoCacheData, boolean z16) {
        if (z16) {
            String[] split = photoCacheData.shareUploadContent.split(",");
            if (split.length == 1) {
                SharingAlbumClientAttr c16 = c(aVar, Long.parseLong(split[0]));
                this.C.j(Long.parseLong(split[0]));
                if (c16 != null) {
                    this.C.setBackgroundResource(c16.gender == 1 ? R.drawable.aqc : R.drawable.aqd);
                }
                this.C.setVisibility(0);
                this.f43614m.setVisibility(8);
                return;
            }
            if (split.length == 2) {
                SharingAlbumClientAttr c17 = c(aVar, Long.parseLong(split[0]));
                SharingAlbumClientAttr c18 = c(aVar, Long.parseLong(split[1]));
                if (c17 == null || c18 == null) {
                    this.f43614m.k(split[0]);
                    this.C.k(split[1]);
                } else if (c17.gender == 2) {
                    this.f43614m.j(c18.uin);
                    this.C.j(c17.uin);
                } else {
                    this.f43614m.j(c17.uin);
                    this.C.j(c18.uin);
                }
                this.f43614m.setVisibility(0);
                this.C.setVisibility(0);
                return;
            }
            this.f43614m.setVisibility(8);
            this.C.setVisibility(8);
            return;
        }
        this.f43614m.setVisibility(8);
        this.C.setVisibility(8);
    }

    private void a(a aVar, PhotoCacheData[] photoCacheDataArr, boolean z16, boolean z17) {
        PhotoCacheData photoCacheData;
        PhotoCacheData photoCacheData2;
        if (photoCacheDataArr != null && photoCacheDataArr.length > 0 && (photoCacheData2 = photoCacheDataArr[0]) != null && photoCacheData2.descvisible && !TextUtils.isEmpty(photoCacheData2.desc) && aVar != null && aVar.f()) {
            setVisibility(0);
            this.G.setRichText(photoCacheDataArr[0].desc);
            this.G.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.G.getLayoutParams();
            if (!photoCacheDataArr[0].timevisible) {
                layoutParams.topMargin = u4.a.z().o(12.0f);
            } else {
                layoutParams.topMargin = 0;
            }
            this.G.setLayoutParams(layoutParams);
        } else {
            this.G.setVisibility(8);
        }
        if (!z16 && z17 && aVar != null && photoCacheDataArr != null && photoCacheDataArr.length > 0 && photoCacheDataArr[0] != null && aVar.f()) {
            this.G.setClickable(true);
            this.G.setOnClickListener(aVar.r(photoCacheDataArr[0]));
        }
        if (photoCacheDataArr == null || photoCacheDataArr.length <= 0 || (photoCacheData = photoCacheDataArr[0]) == null || !photoCacheData.timevisible || aVar == null || !aVar.f()) {
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.F.getLayoutParams();
        PhotoCacheData photoCacheData3 = photoCacheDataArr[0];
        if (photoCacheData3.descvisible && !TextUtils.isEmpty(photoCacheData3.desc)) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.F.getLayoutParams();
            layoutParams3.topMargin = u4.a.z().o(12.0f);
            layoutParams3.bottomMargin = u4.a.z().o(5.0f);
            this.F.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.G.getLayoutParams();
            layoutParams4.topMargin = 0;
            layoutParams4.bottomMargin = u4.a.z().o(11.0f);
            this.G.setLayoutParams(layoutParams4);
            return;
        }
        layoutParams2.topMargin = u4.a.z().o(12.0f);
        layoutParams2.bottomMargin = u4.a.z().o(11.0f);
        this.F.setLayoutParams(layoutParams2);
    }

    private void f(com.qzone.album.business.photolist.adapter.a aVar, a aVar2, PhotoCacheData[] photoCacheDataArr, boolean z16, boolean z17, boolean z18, int i3, int i16, d dVar) {
        LoveAlbumTimeEvent loveAlbumTimeEvent;
        Map<String, TimeEvent> map;
        long j3 = photoCacheDataArr[0].shoottime * 1000;
        if (j3 > 0) {
            this.f43609d.setVisibility(8);
            TimeLine h16 = com.qzone.album.util.a.h(aVar2, photoCacheDataArr[0]);
            if (com.qzone.album.util.a.k(aVar2, (PhotoCacheData[]) aVar.getItem(i16), (PhotoCacheData[]) aVar.getItem(i16 - 1))) {
                this.f43610e.setVisibility(8);
            } else if (h16 != null) {
                this.f43610e.setVisibility(0);
                this.f43611f.setText(h16.toShowLoversDay());
            } else {
                this.f43610e.setVisibility(8);
            }
            String h17 = g.h(j3);
            if (h16 != null && (map = h16.festivals) != null) {
                TimeEvent timeEvent = map.get(h17);
                if (timeEvent != null) {
                    this.f43613i.setText(timeEvent.copywriter);
                    this.f43613i.setVisibility(0);
                } else {
                    this.f43613i.setVisibility(8);
                }
            } else {
                this.f43613i.setVisibility(8);
            }
            this.F.setVisibility(0);
            if (z16) {
                this.E.setVisibility(0);
            } else {
                this.E.setVisibility(8);
            }
            this.D.setText(g.g(j3));
            com.qzone.album.data.model.TimeEvent g16 = com.qzone.album.util.a.g(aVar2.g(), j3);
            if (z17) {
                if (g16 != null && !TextUtils.isEmpty(g16.f43881f)) {
                    this.f43612h.setRichText(g16.f43881f);
                    loveAlbumTimeEvent = LoveAlbumTimeEvent.toLoveAlbumTimeEvent(g16);
                    loveAlbumTimeEvent.type = 2L;
                    loveAlbumTimeEvent.action = 2;
                } else {
                    loveAlbumTimeEvent = new LoveAlbumTimeEvent(photoCacheDataArr[0].shoottime);
                    loveAlbumTimeEvent.type = 2L;
                    loveAlbumTimeEvent.action = 1;
                    this.f43612h.setText(aVar2.getResources().getString(R.string.gbt));
                }
                this.f43612h.setOnClickListener(aVar2.B(loveAlbumTimeEvent, j3));
                this.H.setVisibility(0);
                return;
            }
            if (g16 != null && !TextUtils.isEmpty(g16.f43881f)) {
                this.f43612h.setRichText(g16.f43881f);
                this.H.setVisibility(0);
                return;
            } else {
                this.H.setVisibility(8);
                return;
            }
        }
        this.f43609d.setVisibility(0);
        this.f43609d.b(i3, aVar, aVar2, photoCacheDataArr, dVar, z17);
        this.f43610e.setVisibility(8);
        this.F.setVisibility(8);
        this.f43612h.setVisibility(8);
    }

    public void e(com.qzone.album.business.photolist.adapter.a aVar, a aVar2, PhotoCacheData[] photoCacheDataArr, d dVar, boolean z16, boolean z17, boolean z18, int i3, int i16) {
        if (photoCacheDataArr != null && photoCacheDataArr.length > 0) {
            boolean z19 = false;
            PhotoCacheData photoCacheData = photoCacheDataArr[0];
            if (photoCacheData != null && photoCacheData.timevisible) {
                setVisibility(0);
                f(aVar, aVar2, photoCacheDataArr, z16, z17, z18, i3, i16, dVar);
                PhotoCacheData photoCacheData2 = photoCacheDataArr[0];
                if (!z16 && !TextUtils.isEmpty(photoCacheData2.shareUploadContent) && aVar2.g() != null && aVar2.g().sharingAlbumClientAttrArrayList != null) {
                    z19 = true;
                }
                g(aVar2, photoCacheData2, z19);
                a(aVar2, photoCacheDataArr, z16, z17);
                b(aVar, aVar2, photoCacheDataArr, dVar, z16, z18, i3);
            }
        }
        setVisibility(8);
        this.f43609d.setVisibility(8);
        this.F.setVisibility(8);
        this.f43610e.setVisibility(8);
        this.H.setVisibility(8);
        a(aVar2, photoCacheDataArr, z16, z17);
        b(aVar, aVar2, photoCacheDataArr, dVar, z16, z18, i3);
    }
}

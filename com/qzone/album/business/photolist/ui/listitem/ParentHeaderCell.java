package com.qzone.album.business.photolist.ui.listitem;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.qzone.album.business.photolist.ui.SharingOwnersListBar;
import com.qzone.album.data.model.LoveAlbumTimeEvent;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.TimeEvent;
import com.qzone.album.data.model.TimeLine;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.proxy.feedcomponent.widget.FeedDate;
import com.qzone.proxy.feedcomponent.widget.SafeTextView;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.Calendar;
import s4.d;
import x4.a;

/* loaded from: classes39.dex */
public class ParentHeaderCell extends LinearLayout {
    protected FeedDate C;
    protected Button D;
    protected RelativeLayout E;
    protected SharingOwnersListBar F;
    private View G;

    /* renamed from: d, reason: collision with root package name */
    protected NoShootTimeTitleLayout f43633d;

    /* renamed from: e, reason: collision with root package name */
    protected FrameLayout f43634e;

    /* renamed from: f, reason: collision with root package name */
    protected SafeTextView f43635f;

    /* renamed from: h, reason: collision with root package name */
    protected SafeTextView f43636h;

    /* renamed from: i, reason: collision with root package name */
    protected CellTextView f43637i;

    /* renamed from: m, reason: collision with root package name */
    protected CellTextView f43638m;

    public ParentHeaderCell(Context context) {
        super(context);
    }

    public void c(a aVar) {
        View.inflate(aVar.k(), R.layout.f169001bj4, this);
        setOrientation(1);
        this.f43633d = (NoShootTimeTitleLayout) findViewById(R.id.hcd);
        this.f43634e = (FrameLayout) findViewById(R.id.dan);
        this.f43635f = (SafeTextView) findViewById(R.id.dao);
        this.E = (RelativeLayout) findViewById(R.id.dak);
        this.D = (Button) findViewById(R.id.dai);
        FeedDate feedDate = (FeedDate) findViewById(R.id.dal);
        this.C = feedDate;
        feedDate.setTextColor(aVar.getResources().getColor(R.color.a67));
        this.f43638m = (CellTextView) findViewById(R.id.dam);
        this.f43636h = (SafeTextView) findViewById(R.id.daj);
        this.f43637i = (CellTextView) findViewById(R.id.dah);
        this.G = findViewById(R.id.ll8);
        this.F = (SharingOwnersListBar) findViewById(R.id.m3h);
    }

    public ParentHeaderCell(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(a aVar, PhotoCacheData[] photoCacheDataArr, boolean z16, boolean z17) {
        PhotoCacheData photoCacheData = photoCacheDataArr[0];
        if (photoCacheData != null && photoCacheData.descvisible && !TextUtils.isEmpty(photoCacheData.desc) && aVar != null && aVar.f()) {
            setVisibility(0);
            this.f43638m.setRichText(photoCacheDataArr[0].desc);
            this.f43638m.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f43638m.getLayoutParams();
            if (!photoCacheDataArr[0].timevisible) {
                layoutParams.topMargin = u4.a.z().o(12.0f);
            } else {
                layoutParams.topMargin = 0;
            }
            this.f43638m.setLayoutParams(layoutParams);
        } else {
            this.f43638m.setVisibility(8);
        }
        if (!z16 && z17 && aVar != null && photoCacheDataArr[0] != null && aVar.f()) {
            this.f43638m.setClickable(true);
            this.f43638m.setOnClickListener(aVar.r(photoCacheDataArr[0]));
        }
        PhotoCacheData photoCacheData2 = photoCacheDataArr[0];
        if (photoCacheData2 == null || !photoCacheData2.timevisible || aVar == null || !aVar.f()) {
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.E.getLayoutParams();
        PhotoCacheData photoCacheData3 = photoCacheDataArr[0];
        if (photoCacheData3.descvisible && !TextUtils.isEmpty(photoCacheData3.desc)) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.E.getLayoutParams();
            layoutParams3.topMargin = u4.a.z().o(12.0f);
            layoutParams3.bottomMargin = u4.a.z().o(5.0f);
            this.E.setLayoutParams(layoutParams3);
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f43638m.getLayoutParams();
            layoutParams4.topMargin = 0;
            layoutParams4.bottomMargin = u4.a.z().o(11.0f);
            this.f43638m.setLayoutParams(layoutParams4);
            return;
        }
        layoutParams2.topMargin = u4.a.z().o(12.0f);
        layoutParams2.bottomMargin = u4.a.z().o(11.0f);
        this.E.setLayoutParams(layoutParams2);
    }

    private void b(com.qzone.album.business.photolist.adapter.a aVar, a aVar2, PhotoCacheData[] photoCacheDataArr, d dVar, boolean z16, boolean z17, int i3) {
        if (photoCacheDataArr[0] == null || aVar2 == null || !z16) {
            return;
        }
        aVar.v(dVar);
        if (photoCacheDataArr[0].allSelectedStatus) {
            this.D.setSelected(true);
            this.D.setText(l.a(R.string.ozd));
        } else {
            this.D.setSelected(false);
            this.D.setText(l.a(R.string.ozc));
        }
        this.f43633d.setBtnSelected(photoCacheDataArr[0].allSelectedStatus, aVar2.n(dVar));
        this.D.setOnClickListener(aVar2.n(dVar));
        if (aVar2.h()) {
            return;
        }
        if (aVar2.w() || aVar2.A()) {
            this.D.setVisibility(4);
            this.D.setClickable(false);
        }
    }

    private void e(com.qzone.album.business.photolist.adapter.a aVar, a aVar2, PhotoCacheData[] photoCacheDataArr, boolean z16, boolean z17, boolean z18, int i3, int i16, d dVar) {
        LoveAlbumTimeEvent loveAlbumTimeEvent;
        long j3 = photoCacheDataArr[0].shoottime * 1000;
        if (j3 > 0) {
            this.f43633d.setVisibility(8);
            TimeLine h16 = com.qzone.album.util.a.h(aVar2, photoCacheDataArr[0]);
            if (com.qzone.album.util.a.k(aVar2, (PhotoCacheData[]) aVar.getItem(i16), (PhotoCacheData[]) aVar.getItem(i16 - 1))) {
                this.f43634e.setVisibility(8);
            } else if (h16 != null) {
                this.f43634e.setVisibility(0);
                this.f43635f.setText(h16.toShowAgeSpanStr());
            } else {
                this.f43634e.setVisibility(8);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j3);
            this.E.setVisibility(0);
            if (z16) {
                this.D.setVisibility(0);
            } else {
                this.D.setVisibility(8);
            }
            this.C.setText(QZoneAlbumUtil.K(calendar.get(1), calendar.get(2) + 1, calendar.get(5)));
            int e16 = com.qzone.album.util.a.e(aVar2, calendar);
            if (e16 > 0 && e16 <= 365) {
                this.f43636h.setText(e16 + l.a(R.string.ozb));
                this.f43636h.setVisibility(0);
            } else {
                this.f43636h.setVisibility(8);
            }
            TimeEvent g16 = com.qzone.album.util.a.g(aVar2.g(), j3);
            if (z17) {
                if (g16 != null && !TextUtils.isEmpty(g16.f43881f)) {
                    this.f43637i.setRichText(g16.f43881f);
                    loveAlbumTimeEvent = LoveAlbumTimeEvent.toLoveAlbumTimeEvent(g16);
                    loveAlbumTimeEvent.type = 2L;
                    loveAlbumTimeEvent.action = 2;
                } else {
                    loveAlbumTimeEvent = new LoveAlbumTimeEvent(photoCacheDataArr[0].shoottime);
                    loveAlbumTimeEvent.type = 2L;
                    loveAlbumTimeEvent.action = 1;
                    this.f43637i.setText(aVar2.getResources().getString(R.string.gbt));
                }
                this.f43637i.setOnClickListener(aVar2.B(loveAlbumTimeEvent, j3));
                this.f43637i.setVisibility(0);
                this.G.setVisibility(0);
                return;
            }
            if (g16 != null && !TextUtils.isEmpty(g16.f43881f)) {
                this.f43637i.setRichText(g16.f43881f);
                this.G.setVisibility(0);
                return;
            } else {
                this.G.setVisibility(8);
                return;
            }
        }
        this.f43633d.setVisibility(0);
        this.f43633d.b(i3, aVar, aVar2, photoCacheDataArr, dVar, z17);
        this.f43634e.setVisibility(8);
        this.E.setVisibility(8);
        this.G.setVisibility(8);
    }

    public void d(com.qzone.album.business.photolist.adapter.a aVar, a aVar2, PhotoCacheData[] photoCacheDataArr, d dVar, boolean z16, boolean z17, boolean z18, int i3, int i16) {
        PhotoCacheData photoCacheData = photoCacheDataArr[0];
        if (photoCacheData != null && photoCacheData.timevisible) {
            setVisibility(0);
            e(aVar, aVar2, photoCacheDataArr, z16, z17, z18, i3, i16, dVar);
            SharingOwnersListBar sharingOwnersListBar = this.F;
            if (sharingOwnersListBar != null) {
                sharingOwnersListBar.e(aVar2.g(), (ArrayList) photoCacheDataArr[0].uploadUinList, 4, getResources().getDimensionPixelSize(R.dimen.f159514ap0), getResources().getDimensionPixelOffset(R.dimen.aoz), true);
                if (z16) {
                    this.F.setVisibility(8);
                } else {
                    this.F.setVisibility(0);
                }
            }
        } else {
            SharingOwnersListBar sharingOwnersListBar2 = this.F;
            if (sharingOwnersListBar2 != null) {
                sharingOwnersListBar2.setVisibility(8);
            }
            setVisibility(8);
            this.f43633d.setVisibility(8);
            this.f43634e.setVisibility(8);
            this.E.setVisibility(8);
            this.G.setVisibility(8);
        }
        a(aVar2, photoCacheDataArr, z16, z17);
        b(aVar, aVar2, photoCacheDataArr, dVar, z16, z18, i3);
    }
}

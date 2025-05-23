package com.qzone.album.business.photolist.ui.timeline;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qzone.album.business.photolist.controller.ViewerModelController;
import com.qzone.album.business.photolist.ui.timeline.view.AbstractTimeLineView;
import com.qzone.album.business.photolist.ui.timeline.view.LoversPhotoTimeLineView;
import com.qzone.album.business.photolist.ui.timeline.view.NormalPhotoTimeLineView;
import com.qzone.album.business.photolist.ui.timeline.view.ParentingPhotoTimeLineView;
import com.qzone.album.business.photolist.ui.timeline.view.TravelPhotoTimeLineView;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.ParentingAlbumData;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PhotoPoiArea;
import com.qzone.album.data.model.TimeLine;
import com.qzone.album.data.model.TravelAlbumData;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import m4.d;
import s4.e;

/* loaded from: classes39.dex */
public class QZonePhotoListTimeLine {

    /* renamed from: a, reason: collision with root package name */
    private Activity f43714a;

    /* renamed from: b, reason: collision with root package name */
    private ViewerModelController f43715b;

    /* renamed from: c, reason: collision with root package name */
    private View.OnClickListener f43716c;

    /* renamed from: d, reason: collision with root package name */
    private View f43717d;

    /* renamed from: e, reason: collision with root package name */
    private View f43718e;

    /* renamed from: f, reason: collision with root package name */
    private View f43719f;

    /* renamed from: g, reason: collision with root package name */
    private AbstractTimeLineView f43720g;

    /* renamed from: n, reason: collision with root package name */
    private RelativeLayout f43727n;

    /* renamed from: o, reason: collision with root package name */
    private Button f43728o;

    /* renamed from: p, reason: collision with root package name */
    private ImageView f43729p;

    /* renamed from: q, reason: collision with root package name */
    private ImageView f43730q;

    /* renamed from: r, reason: collision with root package name */
    private ImageView f43731r;

    /* renamed from: s, reason: collision with root package name */
    private e f43732s;

    /* renamed from: t, reason: collision with root package name */
    private e f43733t;

    /* renamed from: w, reason: collision with root package name */
    private AnimationDrawable f43736w;

    /* renamed from: x, reason: collision with root package name */
    private AnimationDrawable f43737x;

    /* renamed from: h, reason: collision with root package name */
    private int f43721h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f43722i = 0;

    /* renamed from: j, reason: collision with root package name */
    private PhotoCacheData f43723j = null;

    /* renamed from: k, reason: collision with root package name */
    private Animation f43724k = null;

    /* renamed from: l, reason: collision with root package name */
    private Animation f43725l = null;

    /* renamed from: m, reason: collision with root package name */
    private int f43726m = 500;

    /* renamed from: u, reason: collision with root package name */
    private SparseIntArray f43734u = new SparseIntArray(12);

    /* renamed from: v, reason: collision with root package name */
    private long f43735v = -1;

    /* renamed from: y, reason: collision with root package name */
    private com.qzone.album.business.photolist.ui.timeline.a f43738y = new b();

    /* loaded from: classes39.dex */
    class b implements com.qzone.album.business.photolist.ui.timeline.a {
        b() {
        }

        @Override // com.qzone.album.business.photolist.ui.timeline.a
        public void a(long j3, long j16, int i3) {
            if (!QZonePhotoListTimeLine.this.f43715b.e1()) {
                com.qzone.album.env.common.a.m().U(R.string.gdc);
                return;
            }
            QZonePhotoListTimeLine.this.t(0, j3, j16);
            QZonePhotoListTimeLine.this.f43715b.m1(0);
            QZonePhotoListTimeLine.this.E(false);
        }

        @Override // com.qzone.album.business.photolist.ui.timeline.a
        public void b(PhotoPoiArea photoPoiArea) {
            com.qzone.album.env.common.a.m().R("368", "27", "2");
            if (!QZonePhotoListTimeLine.this.f43715b.e1()) {
                com.qzone.album.env.common.a.m().U(R.string.gdc);
                return;
            }
            if (photoPoiArea != null) {
                com.qzone.album.env.common.a.m().c("QZonePhotoListTimeLine.", "poiArea.startShootTime:" + photoPoiArea.startShootTime + " poiArea.endShootTime:" + photoPoiArea.endShootTime);
                d dVar = new d();
                dVar.f416111a = photoPoiArea.sceneryName;
                QZonePhotoListTimeLine.this.u(0, photoPoiArea.startShootTime, photoPoiArea.endShootTime, dVar);
                QZonePhotoListTimeLine.this.f43715b.m1(0);
                QZonePhotoListTimeLine.this.E(false);
            }
        }

        @Override // com.qzone.album.business.photolist.ui.timeline.a
        public void c(TimeLine timeLine) {
            com.qzone.album.env.common.a.m().R("368", "27", "1");
            if (!QZonePhotoListTimeLine.this.f43715b.e1()) {
                com.qzone.album.env.common.a.m().U(R.string.gdc);
            } else if (timeLine != null) {
                QZonePhotoListTimeLine.this.t(0, timeLine.beginTime, timeLine.endTime);
                QZonePhotoListTimeLine.this.f43715b.m1(0);
                QZonePhotoListTimeLine.this.E(false);
            }
        }
    }

    public QZonePhotoListTimeLine(Activity activity, ViewerModelController viewerModelController) {
        this.f43714a = activity;
        this.f43715b = viewerModelController;
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable g(long j3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3 * 1000);
        try {
            return this.f43715b.getResources().getDrawable(this.f43734u.get(calendar.get(2) + 1));
        } catch (Exception e16) {
            QZLog.e("QZonePhotoListTimeLine.", "getDrawableByMonth catch an exception.", e16);
            return null;
        }
    }

    private void o() {
        if (this.f43715b.e3()) {
            View findViewById = this.f43717d.findViewById(R.id.fii);
            this.f43718e = findViewById;
            this.f43720g = (ParentingPhotoTimeLineView) findViewById.findViewById(R.id.fih);
            this.f43728o.setBackgroundResource(R.drawable.f162331ay4);
            this.f43728o.setOnClickListener(this.f43716c);
            this.f43728o.setVisibility(0);
        } else if (this.f43715b.i3()) {
            View findViewById2 = this.f43717d.findViewById(R.id.f167008jw0);
            this.f43718e = findViewById2;
            this.f43720g = (TravelPhotoTimeLineView) findViewById2.findViewById(R.id.jvz);
            this.f43728o.setBackgroundResource(R.drawable.ay6);
            this.f43728o.setOnClickListener(this.f43716c);
            this.f43728o.setVisibility(0);
        } else if (this.f43715b.Y2()) {
            View findViewById3 = this.f43717d.findViewById(R.id.ehs);
            this.f43718e = findViewById3;
            this.f43720g = (LoversPhotoTimeLineView) findViewById3.findViewById(R.id.ehr);
        } else {
            View findViewById4 = this.f43717d.findViewById(R.id.b5z);
            this.f43718e = findViewById4;
            NormalPhotoTimeLineView normalPhotoTimeLineView = (NormalPhotoTimeLineView) findViewById4.findViewById(R.id.b5y);
            this.f43720g = normalPhotoTimeLineView;
            Activity activity = this.f43714a;
            if (activity instanceof Activity) {
                normalPhotoTimeLineView.setPaddingForTimeLineHeader(activity);
            }
        }
        this.f43718e.setVisibility(4);
        this.f43720g.setTimeLineListener(this.f43738y);
        this.f43719f.setOnClickListener(this.f43716c);
        this.f43719f.setVisibility(8);
        this.f43728o.setVisibility(8);
        this.f43728o.setClickable(false);
    }

    private void q() {
        this.f43719f = this.f43717d.findViewById(R.id.fqc);
        this.f43727n = (RelativeLayout) this.f43717d.findViewById(R.id.jsn);
        this.f43728o = (Button) this.f43717d.findViewById(R.id.jsm);
        this.f43727n.setVisibility(8);
    }

    private void r() {
        this.f43717d = this.f43714a.findViewById(R.id.hab);
        q();
        o();
        this.f43724k = AnimationUtils.loadAnimation(this.f43714a, R.anim.f155013gl);
        this.f43725l = AnimationUtils.loadAnimation(this.f43714a, R.anim.f155014gm);
    }

    private void s(long j3) {
        if (this.f43730q == null || this.f43731r == null || this.f43736w == null || this.f43737x == null) {
            return;
        }
        if (this.f43735v == -1) {
            this.f43735v = j3;
        }
        this.f43730q.setImageDrawable(g(this.f43735v));
        this.f43730q.setAlpha(1.0f);
        this.f43731r.setVisibility(8);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.f43735v * 1000);
        int i3 = calendar.get(1);
        int i16 = calendar.get(2) + 1;
        calendar.setTimeInMillis(1000 * j3);
        int i17 = calendar.get(1);
        int i18 = calendar.get(2) + 1;
        if (i3 == i17 && i16 == i18) {
            return;
        }
        this.f43731r.setImageDrawable(g(j3));
        this.f43736w.stop();
        this.f43737x.stop();
        this.f43730q.clearAnimation();
        this.f43731r.clearAnimation();
        if (this.f43735v < j3) {
            this.f43729p.setImageDrawable(this.f43736w);
            this.f43736w.start();
        } else {
            this.f43729p.setImageDrawable(this.f43737x);
            this.f43737x.start();
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        final AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation2.setAnimationListener(new a(j3));
        alphaAnimation.setDuration(400L);
        alphaAnimation2.setDuration(80L);
        this.f43730q.startAnimation(alphaAnimation);
        this.f43731r.setAlpha(0.0f);
        this.f43731r.setVisibility(0);
        this.f43731r.postDelayed(new Runnable() { // from class: com.qzone.album.business.photolist.ui.timeline.QZonePhotoListTimeLine.2
            @Override // java.lang.Runnable
            public void run() {
                QZonePhotoListTimeLine.this.f43731r.startAnimation(alphaAnimation2);
            }
        }, 280L);
        this.f43735v = j3;
    }

    private void w() {
        this.f43719f.setVisibility(8);
        this.f43727n.setVisibility(8);
        this.f43728o.setVisibility(8);
        this.f43728o.setClickable(false);
        this.f43718e.setVisibility(8);
    }

    public void A(View.OnClickListener onClickListener) {
        this.f43716c = onClickListener;
    }

    public void B(e eVar) {
        this.f43732s = eVar;
    }

    public void C() {
        int i3;
        long j3;
        BaseAdapter B1 = this.f43715b.B1();
        if (B1 != null) {
            if (this.f43715b.h3()) {
                i3 = this.f43722i;
            } else {
                i3 = this.f43721h;
            }
            if (i3 >= B1.getCount()) {
                i3 = B1.getCount() - 1;
            }
            if (i3 < 0) {
                i3 = 0;
            }
            if (B1.getItem(i3) != null && ((PhotoCacheData[]) B1.getItem(i3))[0] != null) {
                PhotoCacheData photoCacheData = ((PhotoCacheData[]) B1.getItem(i3))[0];
                this.f43723j = photoCacheData;
                if (photoCacheData != null) {
                    if (!this.f43715b.h3() && !QZoneAlbumUtil.B(this.f43715b.l2())) {
                        j3 = this.f43723j.uploadtime;
                    } else {
                        j3 = this.f43723j.shoottime;
                    }
                    z(j3);
                    return;
                }
                return;
            }
            com.qzone.album.env.common.a.m().b("QZonePhotoListTimeLine.", "syncTimeLineSelection getBaseAdapter().getItem(syncTime) == null || ((PhotoCacheData[])getBaseAdapter().getItem(syncTime))[0] == null and syncTime = ", Integer.valueOf(i3));
        }
    }

    public void D() {
        BaseAdapter B1 = this.f43715b.B1();
        if (B1 != null) {
            if (j() == 0) {
                C();
            }
            if (this.f43721h >= B1.getCount()) {
                this.f43721h = B1.getCount() - 1;
            }
            if (this.f43721h < 0) {
                this.f43721h = 0;
            }
            if (B1.getItem(this.f43721h) == null || ((PhotoCacheData[]) B1.getItem(this.f43721h))[0] == null) {
                return;
            }
            this.f43723j = ((PhotoCacheData[]) B1.getItem(this.f43721h))[0];
            if (!this.f43715b.h3() && !QZoneAlbumUtil.B(this.f43715b.l2())) {
                long j3 = this.f43723j.uploadtime;
                if (j3 > 0) {
                    s(j3);
                    return;
                }
                return;
            }
            long j16 = this.f43723j.shoottime;
            if (j16 > 0) {
                s(j16);
            }
        }
    }

    public void E(boolean z16) {
        if (this.f43718e.getVisibility() == 0 && !z16) {
            this.f43725l.setDuration(this.f43726m);
            this.f43718e.startAnimation(this.f43725l);
            this.f43718e.setVisibility(4);
            this.f43728o.setVisibility(0);
            this.f43719f.setVisibility(8);
        } else if (this.f43718e.getVisibility() != 0 && z16) {
            this.f43724k.setDuration(this.f43726m);
            this.f43718e.startAnimation(this.f43724k);
            this.f43718e.setVisibility(0);
            this.f43728o.setVisibility(8);
            this.f43719f.setVisibility(0);
            C();
            this.f43720g.b();
        }
        this.f43728o.setVisibility(8);
        this.f43728o.setClickable(false);
    }

    public void G() {
        w();
        o();
    }

    public void e() {
        this.f43736w = (AnimationDrawable) this.f43715b.getResources().getDrawable(R.drawable.hih);
        this.f43737x = (AnimationDrawable) this.f43715b.getResources().getDrawable(R.drawable.hii);
        this.f43729p.setImageDrawable(this.f43715b.getResources().getDrawable(R.drawable.hyj));
        this.f43734u.clear();
        this.f43734u.put(1, R.drawable.hyv);
        this.f43734u.put(2, R.drawable.hyw);
        this.f43734u.put(3, R.drawable.hyx);
        this.f43734u.put(4, R.drawable.hyy);
        this.f43734u.put(5, R.drawable.hyz);
        this.f43734u.put(6, R.drawable.f162354hz0);
        this.f43734u.put(7, R.drawable.f162355hz1);
        this.f43734u.put(8, R.drawable.f162356hz2);
        this.f43734u.put(9, R.drawable.f162357hz3);
        this.f43734u.put(10, R.drawable.hys);
        this.f43734u.put(11, R.drawable.hyt);
        this.f43734u.put(12, R.drawable.hyu);
    }

    public boolean f() {
        return this.f43720g.a().c();
    }

    public m4.e h(int i3) {
        int intValue;
        int intValue2;
        int i16;
        HashMap<Long, Long> hashMap = new HashMap<>();
        int i17 = 0;
        if (i3 == 0) {
            HashMap<String, Long> b16 = this.f43720g.a().b();
            hashMap.put(b16.get("beginTime"), b16.get("endTime"));
            Long l3 = b16.get("start");
            Long l16 = b16.get("number");
            Long l17 = b16.get("photoOffset");
            intValue = l3 != null ? l3.intValue() : 0;
            intValue2 = l16 != null ? l16.intValue() : 0;
            if (l17 != null) {
                i17 = l17.intValue();
            }
        } else {
            if (i3 == 1) {
                HashMap<String, Long> f16 = this.f43720g.a().f();
                hashMap.put(f16.get("beginTime"), f16.get("endTime"));
                Long l18 = f16.get("start");
                Long l19 = f16.get("number");
                intValue = l18 != null ? l18.intValue() : 0;
                if (l19 != null) {
                    intValue2 = l19.intValue();
                }
                intValue2 = 0;
                i17 = intValue;
                i16 = intValue2;
            } else if (i3 != 2) {
                intValue2 = 0;
                i16 = intValue2;
            } else {
                HashMap<String, Long> d16 = this.f43720g.a().d();
                hashMap.put(d16.get("beginTime"), d16.get("endTime"));
                Long l26 = d16.get("start");
                Long l27 = d16.get("number");
                intValue = l26 != null ? l26.intValue() : 0;
                if (l27 != null) {
                    intValue2 = l27.intValue();
                }
                intValue2 = 0;
                i17 = intValue;
                i16 = intValue2;
            }
            QZLog.i("QZonePhotoListTimeLine.-TimeLine", "getPhotoByTimeLine timeRange:" + hashMap + ", start:" + i17 + ", number:" + intValue2);
            m4.e eVar = new m4.e();
            eVar.f416112a = i3;
            eVar.f416113b = hashMap;
            eVar.f416114c = i17;
            eVar.f416115d = intValue2;
            eVar.f416116e = i16;
            return eVar;
        }
        int i18 = i17;
        i17 = intValue;
        i16 = i18;
        QZLog.i("QZonePhotoListTimeLine.-TimeLine", "getPhotoByTimeLine timeRange:" + hashMap + ", start:" + i17 + ", number:" + intValue2);
        m4.e eVar2 = new m4.e();
        eVar2.f416112a = i3;
        eVar2.f416113b = hashMap;
        eVar2.f416114c = i17;
        eVar2.f416115d = intValue2;
        eVar2.f416116e = i16;
        return eVar2;
    }

    public e i() {
        return this.f43732s;
    }

    public int j() {
        return this.f43718e.getVisibility();
    }

    public View k() {
        return this.f43727n;
    }

    public e l() {
        return this.f43733t;
    }

    public boolean m(int i3) {
        return this.f43720g.a().j(i3);
    }

    public e n(View view) {
        e eVar = new e(view, this.f43727n);
        this.f43733t = eVar;
        return eVar;
    }

    public void u(int i3, long j3, long j16, d dVar) {
        if (this.f43715b.b3()) {
            this.f43720g.setIsAscOrder(QZoneAlbumUtil.C(this.f43715b.l2()));
        }
        this.f43720g.a().k(i3, j3, j16, dVar);
    }

    public void v() {
        this.f43736w = (AnimationDrawable) this.f43715b.getResources().getDrawable(R.drawable.b06);
        this.f43737x = (AnimationDrawable) this.f43715b.getResources().getDrawable(R.drawable.b07);
        this.f43729p.setImageDrawable(this.f43715b.getResources().getDrawable(R.drawable.qzone_skin_timeline_1));
        this.f43734u.clear();
        this.f43734u.put(1, R.drawable.qzone_skin_timeline_calendar_1);
        this.f43734u.put(2, R.drawable.qzone_skin_timeline_calendar_2);
        this.f43734u.put(3, R.drawable.qzone_skin_timeline_calendar_3);
        this.f43734u.put(4, R.drawable.qzone_skin_timeline_calendar_4);
        this.f43734u.put(5, R.drawable.qzone_skin_timeline_calendar_5);
        this.f43734u.put(6, R.drawable.qzone_skin_timeline_calendar_6);
        this.f43734u.put(7, R.drawable.qzone_skin_timeline_calendar_7);
        this.f43734u.put(8, R.drawable.qzone_skin_timeline_calendar_8);
        this.f43734u.put(9, R.drawable.qzone_skin_timeline_calendar_9);
        this.f43734u.put(10, R.drawable.qzone_skin_timeline_calendar_10);
        this.f43734u.put(11, R.drawable.qzone_skin_timeline_calendar_11);
        this.f43734u.put(12, R.drawable.qzone_skin_timeline_calendar_12);
    }

    public void x(int i3) {
        this.f43721h = i3;
    }

    public void y(int i3) {
        this.f43722i = i3;
    }

    public void z(long j3) {
        this.f43720g.setSelection(j3);
    }

    public void F(AlbumCacheData albumCacheData) {
        ArrayList<TimeLine> arrayList;
        ArrayList<PhotoPoiArea> arrayList2;
        ArrayList<TimeLine> arrayList3;
        if (albumCacheData == null) {
            return;
        }
        if (albumCacheData.isParentingAlbum()) {
            ParentingAlbumData parentingAlbumData = albumCacheData.parentingData;
            if (parentingAlbumData != null && (arrayList3 = parentingAlbumData.timeLineList) != null && arrayList3.size() > 0 && ((albumCacheData.parentingData.timeLineList.size() != 1 || albumCacheData.parentingData.timeLineList.get(0) == null || albumCacheData.parentingData.timeLineList.get(0).showYear != -2) && albumCacheData.albumnum > 0)) {
                com.qzone.album.env.common.a.m().b("QZonePhotoListTimeLine.", "updateTimeLine ParentingAlbum showTimeLine");
                this.f43720g.setLoverAndParentingData(albumCacheData.parentingData.timeLineList, albumCacheData.birthDateTime);
                this.f43727n.setVisibility(0);
                this.f43715b.K7();
                return;
            }
            this.f43715b.p7();
            com.qzone.album.env.common.a.m().b("QZonePhotoListTimeLine.", "updateTimeLine ParentingAlbum NoShowTimeLine");
            this.f43727n.setVisibility(8);
            return;
        }
        if (albumCacheData.isTravelAlbum()) {
            TravelAlbumData travelAlbumData = albumCacheData.travelData;
            if (travelAlbumData != null && (arrayList2 = travelAlbumData.photoPoiAreaList) != null && arrayList2.size() > 0 && albumCacheData.albumnum > 0) {
                com.qzone.album.env.common.a.m().b("QZonePhotoListTimeLine.", "updateTimeLine TravelAlbum showTimeLine");
                TravelAlbumData travelAlbumData2 = albumCacheData.travelData;
                this.f43720g.setTravelData(travelAlbumData2.photoPoiAreaList, travelAlbumData2.startShootTime);
                this.f43727n.setVisibility(0);
                this.f43715b.K7();
                return;
            }
            this.f43715b.p7();
            com.qzone.album.env.common.a.m().b("QZonePhotoListTimeLine.", "updateTimeLine TravelAlbum NoShowTimeLine");
            this.f43727n.setVisibility(8);
            return;
        }
        if (albumCacheData.isLoveAlbum()) {
            ParentingAlbumData parentingAlbumData2 = albumCacheData.parentingData;
            if (parentingAlbumData2 != null && (arrayList = parentingAlbumData2.timeLineList) != null && arrayList.size() > 0 && ((albumCacheData.parentingData.timeLineList.size() != 1 || albumCacheData.parentingData.timeLineList.get(0) == null || albumCacheData.parentingData.timeLineList.get(0).showYear != -2) && albumCacheData.albumnum > 0)) {
                com.qzone.album.env.common.a.m().b("QZonePhotoListTimeLine.", "updateTimeLine LoversAlbum showTimeLine");
                this.f43720g.setLoverAndParentingData(albumCacheData.parentingData.timeLineList, albumCacheData.loveTime);
                this.f43715b.K7();
            } else {
                this.f43715b.p7();
                com.qzone.album.env.common.a.m().b("QZonePhotoListTimeLine.", "updateTimeLine LoversAlbum NoShowTimeLine");
            }
            this.f43727n.setVisibility(8);
            return;
        }
        ArrayList<TimeLine> arrayList4 = albumCacheData.commonPhotoTimeLineList;
        if (arrayList4 != null && arrayList4.size() > 0 && albumCacheData.albumnum > 0) {
            com.qzone.album.env.common.a.m().b("QZonePhotoListTimeLine.", "updateTimeLine CommonALbum showTimeLine");
            boolean C = QZoneAlbumUtil.C(this.f43715b.l2());
            this.f43720g.setIsAscOrder(C);
            this.f43720g.setNormalData(albumCacheData.commonPhotoTimeLineList, C);
            this.f43715b.K7();
        } else {
            this.f43715b.p7();
            com.qzone.album.env.common.a.m().b("QZonePhotoListTimeLine.", "updateTimeLine CommonALbum NoShowTimeLine");
        }
        this.f43727n.setVisibility(8);
    }

    public void p(View view) {
        this.f43729p = (ImageView) view.findViewById(R.id.heh);
        this.f43730q = (ImageView) view.findViewById(R.id.hei);
        this.f43731r = (ImageView) view.findViewById(R.id.hej);
        v();
        view.setVisibility(0);
        view.setOnClickListener(this.f43716c);
        view.setId(R.id.f165896dt3);
        AccessibilityUtil.p(view, l.a(R.string.f2201768e));
        view.setAlpha(1.0f);
    }

    public void t(int i3, long j3, long j16) {
        u(i3, j3, j16, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f43740d;

        a(long j3) {
            this.f43740d = j3;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            QZonePhotoListTimeLine.this.f43730q.setImageDrawable(QZonePhotoListTimeLine.this.g(this.f43740d));
            QZonePhotoListTimeLine.this.f43730q.setAlpha(1.0f);
            QZonePhotoListTimeLine.this.f43731r.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}

package com.qzone.album.business.albumlist.adapter;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.qzone.album.business.albumlist.ui.VideoHeaderCell;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.ui.widget.VideoPhotoView;
import com.qzone.reborn.event.QZoneFeedxLayerCommentEvent;
import com.qzone.reborn.event.QZoneFeedxLayerPraiseEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VideoRecentAdapter extends com.qzone.album.business.photolist.adapter.c implements SimpleEventReceiver {
    public static int J = 2;
    protected int C;
    protected int D;
    protected int E;
    protected int F;
    private b H;

    /* renamed from: d, reason: collision with root package name */
    private Context f42071d;

    /* renamed from: e, reason: collision with root package name */
    private long f42072e;

    /* renamed from: i, reason: collision with root package name */
    protected int f42075i;

    /* renamed from: m, reason: collision with root package name */
    protected int f42076m;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<c> f42073f = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<e> f42074h = new ArrayList<>();
    private boolean G = false;
    private View.OnClickListener I = new a();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue >= 0) {
                if (VideoRecentAdapter.this.H != null) {
                    b bVar = VideoRecentAdapter.this.H;
                    VideoRecentAdapter videoRecentAdapter = VideoRecentAdapter.this;
                    bVar.a(view, videoRecentAdapter.A(videoRecentAdapter.f42073f), intValue);
                }
            } else {
                QZLog.e("VideoRecentAdapter", "clickPos is invalid: " + intValue);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        void a(View view, ArrayList<PhotoCacheData> arrayList, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        PhotoCacheData f42080a;

        /* renamed from: b, reason: collision with root package name */
        boolean f42081b;

        public c(PhotoCacheData photoCacheData, boolean z16) {
            this.f42080a = photoCacheData;
            this.f42081b = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        VideoHeaderCell f42083a;

        /* renamed from: b, reason: collision with root package name */
        LinearLayout f42084b;

        /* renamed from: c, reason: collision with root package name */
        VideoPhotoView[] f42085c;

        /* renamed from: d, reason: collision with root package name */
        int f42086d;

        public d() {
            if (this.f42085c == null) {
                this.f42085c = new VideoPhotoView[VideoRecentAdapter.J];
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private c[] f42088a;

        /* renamed from: b, reason: collision with root package name */
        private int[] f42089b;

        /* renamed from: c, reason: collision with root package name */
        private int f42090c;

        e() {
            int i3 = VideoRecentAdapter.J;
            this.f42088a = new c[i3];
            this.f42089b = new int[i3];
            this.f42090c = 0;
        }

        public void a(c cVar, int i3) {
            int i16 = this.f42090c;
            if (i16 < VideoRecentAdapter.J) {
                this.f42088a[i16] = cVar;
                this.f42089b[i16] = i3;
                this.f42090c = i16 + 1;
            }
        }

        public c b(int i3) {
            if (i3 < this.f42090c) {
                return this.f42088a[i3];
            }
            return null;
        }

        public int c(int i3) {
            if (i3 < this.f42090c) {
                return this.f42089b[i3];
            }
            return -1;
        }

        public boolean d() {
            return this.f42090c == 0;
        }

        public boolean e() {
            return this.f42090c == VideoRecentAdapter.J;
        }

        public int f() {
            return this.f42090c;
        }
    }

    public VideoRecentAdapter(Context context, List<PhotoCacheData> list) {
        this.f42071d = context;
        if (pl.a.f426446a.B(context)) {
            J = 4;
        } else {
            J = 2;
        }
        this.f42072e = com.qzone.album.env.common.a.m().s();
        q();
        if (list == null || list.isEmpty()) {
            return;
        }
        if (list.size() > 0) {
            QZLog.d("[PhotoAlbum]recentVideo", 2, "setAdapterData size : " + list.size());
            this.f42073f.clear();
            Iterator<PhotoCacheData> it = list.iterator();
            while (it.hasNext()) {
                this.f42073f.add(new c(it.next(), false));
            }
        } else {
            this.f42073f.clear();
        }
        g();
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<PhotoCacheData> A(ArrayList<c> arrayList) {
        ArrayList<PhotoCacheData> arrayList2 = new ArrayList<>();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().f42080a);
            }
        }
        return arrayList2;
    }

    private void g() {
        Iterator<c> it = this.f42073f.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                it.remove();
            }
        }
    }

    private void h() {
        this.f42074h.clear();
        e eVar = new e();
        Calendar calendar = Calendar.getInstance();
        int i3 = -1;
        int i16 = -1;
        for (int i17 = 0; i17 < this.f42073f.size(); i17++) {
            c cVar = this.f42073f.get(i17);
            calendar.setTimeInMillis(cVar.f42080a.uploadtime * 1000);
            int i18 = calendar.get(1);
            int i19 = calendar.get(2);
            calendar.get(5);
            if (i18 != i3 || i19 != i16) {
                if (!eVar.d()) {
                    this.f42074h.add(eVar);
                }
                eVar = new e();
                i3 = i18;
                i16 = i19;
            }
            if (eVar.e()) {
                this.f42074h.add(eVar);
                eVar = new e();
            }
            eVar.a(cVar, i17);
        }
        if (eVar.d()) {
            return;
        }
        this.f42074h.add(eVar);
    }

    private void o(final QZoneFeedxLayerCommentEvent qZoneFeedxLayerCommentEvent) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.album.business.albumlist.adapter.VideoRecentAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                PhotoCacheData photoCacheData;
                QZoneFeedxLayerCommentEvent qZoneFeedxLayerCommentEvent2 = qZoneFeedxLayerCommentEvent;
                if (qZoneFeedxLayerCommentEvent2 == null) {
                    return;
                }
                String str = qZoneFeedxLayerCommentEvent2.lloc;
                if (VideoRecentAdapter.this.f42073f == null || VideoRecentAdapter.this.f42073f.isEmpty()) {
                    return;
                }
                for (int i3 = 0; i3 < VideoRecentAdapter.this.f42073f.size(); i3++) {
                    c cVar = (c) VideoRecentAdapter.this.f42073f.get(i3);
                    if (cVar != null && (photoCacheData = cVar.f42080a) != null && TextUtils.equals(photoCacheData.lloc, str)) {
                        cVar.f42080a.cmtnum++;
                        return;
                    }
                }
            }
        });
    }

    private void p(final QZoneFeedxLayerPraiseEvent qZoneFeedxLayerPraiseEvent) {
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.album.business.albumlist.adapter.VideoRecentAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                PhotoCacheData photoCacheData;
                QZoneFeedxLayerPraiseEvent qZoneFeedxLayerPraiseEvent2 = qZoneFeedxLayerPraiseEvent;
                if (qZoneFeedxLayerPraiseEvent2 == null) {
                    return;
                }
                boolean z16 = qZoneFeedxLayerPraiseEvent2.isPraise;
                int i3 = qZoneFeedxLayerPraiseEvent2.likeNum;
                String str = qZoneFeedxLayerPraiseEvent2.lloc;
                if (VideoRecentAdapter.this.f42073f == null || VideoRecentAdapter.this.f42073f.isEmpty()) {
                    return;
                }
                for (int i16 = 0; i16 < VideoRecentAdapter.this.f42073f.size(); i16++) {
                    c cVar = (c) VideoRecentAdapter.this.f42073f.get(i16);
                    if (cVar != null && (photoCacheData = cVar.f42080a) != null && TextUtils.equals(photoCacheData.lloc, str)) {
                        PhotoCacheData photoCacheData2 = cVar.f42080a;
                        photoCacheData2.mylike = z16 ? 1 : 0;
                        photoCacheData2.likenum = i3;
                        return;
                    }
                }
            }
        });
    }

    private void q() {
        pl.a aVar = pl.a.f426446a;
        this.C = aVar.o(this.f42071d);
        this.D = aVar.n(this.f42071d);
        int dimensionPixelSize = this.f42071d.getResources().getDimensionPixelSize(R.dimen.f159263yw);
        int i3 = this.C;
        int i16 = J;
        int i17 = (i3 - (dimensionPixelSize * (i16 - 1))) / i16;
        this.f42075i = i17;
        this.f42076m = i17;
        this.E = i17;
        this.F = (i17 * 598) / 374;
    }

    private void v(d dVar, View view, int i3) {
        y(dVar, i3);
        z(dVar, i3);
    }

    private void y(d dVar, int i3) {
        if (s(i3)) {
            dVar.f42083a.b(j(i3, 0).f42080a);
            dVar.f42083a.setVisibility(0);
        } else {
            dVar.f42083a.setVisibility(8);
        }
    }

    private void z(d dVar, int i3) {
        e i16 = i(i3);
        t(dVar);
        for (int i17 = 0; i17 < i16.f() && i17 < J; i17++) {
            c b16 = i16.b(i17);
            int c16 = i16.c(i17);
            boolean z16 = this.G;
            if (z16 && b16 != null) {
                VideoPhotoView videoPhotoView = dVar.f42085c[i17];
                PhotoCacheData photoCacheData = b16.f42080a;
                long j3 = photoCacheData.ownerUin;
                String str = photoCacheData.mapExtern.get(PhotoCacheData.FRIEND_NICK_NAME);
                PhotoCacheData photoCacheData2 = b16.f42080a;
                videoPhotoView.setFriendVideo(z16, j3, str, photoCacheData2.uploadtime, photoCacheData2.videodata.videoDesc);
            }
            dVar.f42085c[i17].setTag(Integer.valueOf(c16));
            if (b16 != null) {
                dVar.f42085c[i17].b(b16.f42080a);
                dVar.f42085c[i17].setVisibility(0);
                dVar.f42085c[i17].setOnClickListener(this.I);
            } else {
                dVar.f42085c[i17].setVisibility(8);
            }
        }
    }

    @Override // com.qzone.album.business.photolist.adapter.c
    public void b(Configuration configuration) {
        q();
    }

    @Override // com.qzone.album.business.photolist.adapter.c
    public void c() {
        super.c();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f42074h.size();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QZoneFeedxLayerPraiseEvent.class);
        arrayList.add(QZoneFeedxLayerCommentEvent.class);
        return arrayList;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    public PhotoCacheData l(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i3 = 0; i3 < this.f42073f.size(); i3++) {
            if (this.f42073f.get(i3) != null && this.f42073f.get(i3).f42080a != null && str.equals(this.f42073f.get(i3).f42080a.unikey)) {
                return this.f42073f.get(i3).f42080a;
            }
        }
        return null;
    }

    public PhotoCacheData m(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (int i3 = 0; i3 < this.f42073f.size(); i3++) {
                if (this.f42073f.get(i3) != null && this.f42073f.get(i3).f42080a != null && str.equals(this.f42073f.get(i3).f42080a.albumid) && str2.equals(this.f42073f.get(i3).f42080a.lloc)) {
                    return this.f42073f.get(i3).f42080a;
                }
            }
        }
        return null;
    }

    public ArrayList<PhotoCacheData> n(String str) {
        ArrayList<PhotoCacheData> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (int i3 = 0; i3 < this.f42073f.size(); i3++) {
            if (this.f42073f.get(i3) != null && this.f42073f.get(i3).f42080a != null && str.equals(this.f42073f.get(i3).f42080a.pssUgcKey)) {
                arrayList.add(this.f42073f.get(i3).f42080a);
            }
        }
        return arrayList;
    }

    @Override // com.qzone.album.business.photolist.adapter.c
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QZoneFeedxLayerPraiseEvent) {
            p((QZoneFeedxLayerPraiseEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QZoneFeedxLayerCommentEvent) {
            o((QZoneFeedxLayerCommentEvent) simpleBaseEvent);
        }
    }

    public void u(boolean z16) {
        this.G = z16;
    }

    public void w(b bVar) {
        this.H = bVar;
    }

    private void t(d dVar) {
        for (int i3 = 0; i3 < J; i3++) {
            dVar.f42085c[i3].setVisibility(8);
            dVar.f42085c[i3].c();
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return j(i3, 0);
    }

    private e i(int i3) {
        if (i3 >= 0 && i3 < this.f42074h.size()) {
            return this.f42074h.get(i3);
        }
        return new e();
    }

    private c j(int i3, int i16) {
        if (i3 >= 0 && i3 < this.f42074h.size()) {
            return this.f42074h.get(i3).b(i16);
        }
        return new c(null, false);
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        d dVar;
        if (view == null) {
            view = LayoutInflater.from(this.f42071d).inflate(R.layout.bin, (ViewGroup) null);
            dVar = new d();
            r(dVar, view);
            view.setTag(dVar);
        } else {
            dVar = (d) view.getTag();
        }
        if (dVar.f42086d != this.C) {
            r(dVar, view);
        }
        try {
            v(dVar, view, i3);
        } catch (OutOfMemoryError e16) {
            QZLog.e("VideoRecentAdapter", e16.toString() + " position= " + i3);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    public PhotoCacheData k(int i3) {
        if (i3 < 0 || i3 >= this.f42073f.size()) {
            return null;
        }
        return this.f42073f.get(i3).f42080a;
    }

    public void x(List<PhotoCacheData> list) {
        if (list != null && list.size() > 0) {
            QZLog.d("VideoRecentAdapter", 2, "setAdapterData size : " + list.size());
            this.f42073f.clear();
            Iterator<PhotoCacheData> it = list.iterator();
            while (it.hasNext()) {
                this.f42073f.add(new c(it.next(), false));
            }
        } else {
            this.f42073f.clear();
        }
        g();
        h();
    }

    private void r(d dVar, View view) {
        VideoHeaderCell videoHeaderCell = (VideoHeaderCell) view.findViewById(R.id.krn);
        dVar.f42083a = videoHeaderCell;
        videoHeaderCell.a(this.f42071d);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.hck);
        dVar.f42084b = linearLayout;
        linearLayout.removeAllViews();
        for (int i3 = 0; i3 < J; i3++) {
            dVar.f42085c[i3] = new VideoPhotoView(this.f42071d);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.E, this.F);
            if (i3 != J - 1) {
                layoutParams.rightMargin = u4.a.z().o(2.0f);
            }
            dVar.f42084b.addView(dVar.f42085c[i3], layoutParams);
            dVar.f42085c[i3].a(this.f42071d, this.f42075i, this.f42076m);
        }
        dVar.f42086d = this.C;
    }

    private boolean s(int i3) {
        if (i3 == 0) {
            return true;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j(i3, 0).f42080a.uploadtime * 1000);
        int i16 = calendar.get(1);
        int i17 = calendar.get(2);
        calendar.get(5);
        calendar.setTimeInMillis(j(i3 - 1, 0).f42080a.uploadtime * 1000);
        int i18 = calendar.get(1);
        int i19 = calendar.get(2);
        calendar.get(5);
        return (i16 == i18 && i17 == i19) ? false : true;
    }
}

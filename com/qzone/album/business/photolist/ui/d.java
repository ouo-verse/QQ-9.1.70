package com.qzone.album.business.photolist.ui;

import NS_MOBILE_MATERIAL.CustomAlbumItem;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.album.business.photolist.controller.BasePhotoModelController;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.RecomAlbumExData;
import com.qzone.album.data.model.RecomAlbumList;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AvatarImageView;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import com.tencent.component.media.image.processor.RoundCornerProcessor;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.AbsListView;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import org.slf4j.Marker;
import s8.f;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private BasePhotoModelController f43324a;

    /* renamed from: b, reason: collision with root package name */
    private LinearLayout f43325b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f43326c;

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f43327d;

    /* renamed from: e, reason: collision with root package name */
    private AvatarImageView f43328e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f43329f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f43330g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f43331h;

    /* renamed from: i, reason: collision with root package name */
    private ProgressBar f43332i;

    /* renamed from: j, reason: collision with root package name */
    private ImageProcessor f43333j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f43334k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f43335l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f43336m;

    /* renamed from: n, reason: collision with root package name */
    private int f43337n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Object tag = view.getTag();
            if (tag instanceof AlbumCacheData) {
                AlbumCacheData albumCacheData = (AlbumCacheData) tag;
                if (albumCacheData != null && albumCacheData.ownerUin != com.qzone.album.env.common.a.m().s()) {
                    if (com.qzone.album.util.d.f(albumCacheData.albumrights) && !albumCacheData.allowAccess) {
                        d.this.e(albumCacheData, 0, null);
                    } else {
                        d.this.f(albumCacheData);
                    }
                }
                LpReportInfo_pf00064.allReport(326, 1, 33);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            d.this.f43335l = true;
            d.this.f43327d.setVisibility(8);
            View d06 = d.this.f43324a.d0();
            if (d06 != null) {
                d06.setVisibility(0);
            }
            d.this.f43324a.a0();
            u4.a.z().n0();
            com.qzone.album.env.common.a.m().Y("qzone_album_second_page", false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public d(BasePhotoModelController basePhotoModelController) {
        this.f43336m = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_MANUAL_LOAD_SWITCH_STATUS, 1) == 1;
        this.f43337n = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_RECOMMEND_COUNT_NUM_LIMIT, 999);
        this.f43324a = basePhotoModelController;
        if (this.f43325b == null) {
            LinearLayout linearLayout = new LinearLayout(this.f43324a.q2());
            this.f43325b = linearLayout;
            linearLayout.setOrientation(1);
            this.f43325b.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.f43324a.q2().getLayoutInflater().inflate(R.layout.bqq, this.f43325b);
            LinearLayout linearLayout2 = (LinearLayout) this.f43325b.findViewById(R.id.hqc);
            this.f43326c = linearLayout2;
            this.f43329f = (TextView) linearLayout2.findViewById(R.id.hq_);
            this.f43328e = (AvatarImageView) this.f43326c.findViewById(R.id.hqg);
            this.f43327d = (RelativeLayout) this.f43326c.findViewById(R.id.hqe);
            this.f43330g = (TextView) this.f43326c.findViewById(R.id.hqd);
            this.f43331h = (TextView) this.f43326c.findViewById(R.id.hq9);
            this.f43332i = (ProgressBar) this.f43326c.findViewById(R.id.hqh);
            this.f43325b.setVisibility(8);
            if (this.f43324a.m2() != null) {
                this.f43324a.m2().addView(this.f43325b, -1);
            }
        }
    }

    private void m() {
        BasePhotoModelController basePhotoModelController = this.f43324a;
        int R = basePhotoModelController.f43008x0.albumnum - basePhotoModelController.f43012z0.R(basePhotoModelController.T);
        if (R > 0) {
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumRecomClickToLoadMore", "\u70b9\u51fb\u67e5\u770b\u66f4\u591a");
            String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumRecomLoadMore", "\u52a0\u8f7d\u5269\u4f59\u7684");
            String config3 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumRecomLeftNum", "\u4e2a\u7167\u7247\u89c6\u9891");
            this.f43330g.setText(config);
            this.f43331h.setText(config2 + R + config3);
            this.f43327d.setOnClickListener(new c());
        } else {
            this.f43330g.setVisibility(8);
            this.f43331h.setText(l.a(R.string.s2n));
            this.f43327d.setOnClickListener(null);
        }
        this.f43332i.setVisibility(8);
    }

    public boolean g() {
        return this.f43335l;
    }

    public boolean h() {
        return this.f43334k;
    }

    public boolean i() {
        return this.f43336m;
    }

    public void k(int i3) {
        RelativeLayout relativeLayout = this.f43327d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i3);
        }
    }

    public void l(int i3) {
        LinearLayout linearLayout = this.f43325b;
        if (linearLayout != null) {
            linearLayout.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b extends ImageProcessor {
        b() {
        }

        @Override // com.tencent.component.media.image.ImageProcessor
        public Drawable process(Drawable drawable) {
            return new RoundCornerProcessor(new float[]{ar.e(5.0f), ar.e(5.0f), 0.0f, 0.0f, 0.0f, 0.0f, ar.e(5.0f), ar.e(5.0f)}).process(new NormalFeedImageProcessor(ar.e(120.0f), ar.e(115.0f)).process(drawable));
        }
    }

    private String d(int i3, int i16) {
        if (i3 > i16) {
            return i16 + Marker.ANY_NON_NULL_MARKER;
        }
        return i3 + "";
    }

    protected void e(AlbumCacheData albumCacheData, int i3, String str) {
        if (albumCacheData == null) {
            return;
        }
        this.f43324a.q2().startActivity(t4.a.N().U(this.f43324a.q2(), albumCacheData, i3, str, this.f43324a.S.longValue()));
    }

    protected void f(AlbumCacheData albumCacheData) {
        if (albumCacheData == null) {
            return;
        }
        u4.a.z().S(this.f43324a.q2(), albumCacheData);
    }

    public void n(RecomAlbumList recomAlbumList) {
        ArrayList<RecomAlbumExData> arrayList;
        int i3;
        int i16;
        CustomAlbumItem e16;
        RecomAlbumList recomAlbumList2 = recomAlbumList;
        if (this.f43334k || this.f43325b == null || this.f43326c == null || recomAlbumList2 == null || (arrayList = recomAlbumList2.recomAlbumVecExList) == null || arrayList.size() <= 0 || this.f43324a.U2()) {
            return;
        }
        this.f43334k = true;
        BasePhotoModelController basePhotoModelController = this.f43324a;
        if (basePhotoModelController.f42943b0 && (e16 = com.qzone.album.util.b.e(basePhotoModelController.f43008x0)) != null) {
            this.f43329f.setTextColor((int) e16.iTextColor);
            this.f43330g.setTextColor((int) e16.iTextColor);
        }
        AlbumCacheData albumCacheData = this.f43324a.f43008x0;
        if (albumCacheData != null && !TextUtils.isEmpty(albumCacheData.albumOwner)) {
            this.f43329f.setText(this.f43324a.f43008x0.albumOwner + l.a(R.string.s2h));
        } else {
            this.f43329f.setText(f.f().g(String.valueOf(this.f43324a.f43008x0.ownerUin)) + l.a(R.string.s2c));
        }
        this.f43328e.j(this.f43324a.f43008x0.ownerUin);
        this.f43327d.setVisibility(0);
        m();
        int size = recomAlbumList2.recomAlbumVecExList.size();
        Drawable drawable = this.f43324a.getResources().getDrawable(R.drawable.aqm);
        Drawable drawable2 = this.f43324a.getResources().getDrawable(R.drawable.fvw);
        Drawable drawable3 = this.f43324a.getResources().getDrawable(R.drawable.fvv);
        Drawable drawable4 = this.f43324a.getResources().getDrawable(R.drawable.fvu);
        int i17 = 0;
        while (i17 < size) {
            RecomAlbumExData recomAlbumExData = recomAlbumList2.recomAlbumVecExList.get(i17);
            if (recomAlbumExData != null) {
                View view = (RelativeLayout) this.f43324a.q2().getLayoutInflater().inflate(R.layout.bip, (ViewGroup) null);
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.hct);
                TextView textView = (TextView) view.findViewById(R.id.hcu);
                AsyncImageView asyncImageView = (AsyncImageView) view.findViewById(R.id.hcs);
                TextView textView2 = (TextView) view.findViewById(R.id.hcq);
                TextView textView3 = (TextView) view.findViewById(R.id.hcv);
                TextView textView4 = (TextView) view.findViewById(R.id.hcx);
                i3 = size;
                i16 = i17;
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), drawable3.getMinimumHeight());
                drawable4.setBounds(0, 0, drawable4.getMinimumWidth(), drawable4.getMinimumHeight());
                relativeLayout.setBackgroundDrawable(drawable);
                textView.setTextColor(-16777216);
                textView2.setTextColor(-7829368);
                textView2.setCompoundDrawables(drawable4, null, null, null);
                textView3.setTextColor(-7829368);
                textView3.setCompoundDrawables(drawable3, null, null, null);
                textView4.setTextColor(-7829368);
                textView4.setCompoundDrawables(drawable2, null, null, null);
                AlbumCacheData albumCacheData2 = recomAlbumExData.albumInfo;
                if (albumCacheData2 != null) {
                    view.setTag(albumCacheData2);
                    view.setOnClickListener(new a());
                    textView.setText(albumCacheData2.albumname);
                    textView2.setText(d(albumCacheData2.albumnum, this.f43337n));
                    textView4.setText(d(recomAlbumExData.viewCount, this.f43337n));
                    textView3.setText(d(recomAlbumExData.likeCnt, this.f43337n));
                    if (this.f43333j == null) {
                        this.f43333j = new b();
                    }
                    asyncImageView.setAsyncImageProcessor(this.f43333j);
                    asyncImageView.setAsyncImage(albumCacheData2.coverUrl.url);
                    this.f43326c.addView(view);
                }
            } else {
                i3 = size;
                i16 = i17;
            }
            i17 = i16 + 1;
            recomAlbumList2 = recomAlbumList;
            size = i3;
        }
        this.f43325b.setVisibility(0);
        View d06 = this.f43324a.d0();
        if (d06 != null) {
            d06.setVisibility(8);
        }
        LpReportInfo_pf00064.allReport(326, 1, 32);
    }

    public void j(boolean z16) {
    }
}

package com.qzone.album.business.photolist.ui.header;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.album.business.photolist.controller.BasePhotoModelController;
import com.qzone.album.business.photolist.controller.ViewerModelController;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.AlbumSocialInfoCacheData;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.common.account.LoginData;
import com.qzone.preview.view.d;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AvatarImageView;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import ho.i;
import ho.j;
import u4.h;

/* loaded from: classes39.dex */
public class AlbumHeaderPanel {

    /* renamed from: a, reason: collision with root package name */
    protected Activity f43344a;

    /* renamed from: b, reason: collision with root package name */
    protected BasePhotoModelController f43345b;

    /* renamed from: c, reason: collision with root package name */
    protected View f43346c;

    /* renamed from: d, reason: collision with root package name */
    protected TextView f43347d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f43348e;

    /* renamed from: f, reason: collision with root package name */
    protected TextView f43349f;

    /* renamed from: g, reason: collision with root package name */
    protected TextView f43350g;

    /* renamed from: h, reason: collision with root package name */
    protected String f43351h;

    /* renamed from: i, reason: collision with root package name */
    private AlbumHeaderContainer f43352i;

    /* renamed from: j, reason: collision with root package name */
    protected View f43353j;

    /* renamed from: k, reason: collision with root package name */
    protected QZoneAlbumHeaderView f43354k;

    /* renamed from: l, reason: collision with root package name */
    protected QzoneAlbumNoShootTimeHintView f43355l;

    /* renamed from: m, reason: collision with root package name */
    protected QZoneAlbumFakeVideoView f43356m;

    /* renamed from: n, reason: collision with root package name */
    protected View f43357n;

    /* renamed from: o, reason: collision with root package name */
    protected QZoneAlbumHeaderView f43358o;

    /* renamed from: p, reason: collision with root package name */
    private h f43359p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f43360q = true;

    /* renamed from: r, reason: collision with root package name */
    private int f43361r = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            j z16 = i.z();
            AlbumHeaderPanel albumHeaderPanel = AlbumHeaderPanel.this;
            z16.r(albumHeaderPanel.f43344a, albumHeaderPanel.f43345b.f42989q1);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements ViewStub.OnInflateListener {
        b() {
        }

        @Override // android.view.ViewStub.OnInflateListener
        public void onInflate(ViewStub viewStub, View view) {
            AlbumHeaderPanel.this.f43357n = view;
            AsyncImageView asyncImageView = (AsyncImageView) view.findViewById(R.id.bw6);
            asyncImageView.setDecodeConfig(Bitmap.Config.ARGB_8888);
            asyncImageView.setAsyncImage("https://qzonestyle.gtimg.cn/aoi/sola/20160122174435_JB9nd5ApXQ.png");
            AlbumHeaderPanel albumHeaderPanel = AlbumHeaderPanel.this;
            AlbumHeaderPanel albumHeaderPanel2 = AlbumHeaderPanel.this;
            Activity activity = albumHeaderPanel2.f43344a;
            BasePhotoModelController basePhotoModelController = albumHeaderPanel2.f43345b;
            albumHeaderPanel.f43358o = new QZoneAlbumHeaderView(activity, basePhotoModelController.f42940a0, basePhotoModelController.P2(), AlbumHeaderPanel.this.f43359p, AlbumHeaderPanel.this.f43345b.W2());
            AlbumHeaderPanel albumHeaderPanel3 = AlbumHeaderPanel.this;
            albumHeaderPanel3.n(albumHeaderPanel3.f43358o);
            AlbumHeaderPanel albumHeaderPanel4 = AlbumHeaderPanel.this;
            albumHeaderPanel4.E(albumHeaderPanel4.f43358o);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10, 1);
            AlbumHeaderPanel albumHeaderPanel5 = AlbumHeaderPanel.this;
            ((ViewGroup) albumHeaderPanel5.f43357n).addView(albumHeaderPanel5.f43358o, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c extends QZoneAlbumUtil.f {
        c() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            AlbumHeaderPanel.this.f43359p.getListView().setBackgroundDrawable(drawable);
        }
    }

    public AlbumHeaderPanel(Activity activity, BasePhotoModelController basePhotoModelController, h hVar) {
        this.f43344a = activity;
        this.f43345b = basePhotoModelController;
        this.f43359p = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(QZoneAlbumHeaderView qZoneAlbumHeaderView) {
        BasePhotoModelController basePhotoModelController = this.f43345b;
        if (basePhotoModelController == null || basePhotoModelController.f43008x0 == null || qZoneAlbumHeaderView == null) {
            return;
        }
        boolean z16 = false;
        com.qzone.album.env.common.a.m().b("[PhotoAlbum] AlbumHeaderPanel", "updateHeader albumname:", this.f43345b.f43008x0.albumname);
        qZoneAlbumHeaderView.x0(this.f43345b.f43008x0);
        this.f43354k.setUploadPhotoButtonVisible(false);
        QZoneAlbumHeaderView qZoneAlbumHeaderView2 = this.f43354k;
        AlbumCacheData albumCacheData = this.f43345b.f43008x0;
        if (albumCacheData != null && albumCacheData.isShareInvitePanding()) {
            z16 = true;
        }
        qZoneAlbumHeaderView2.setShareAlbumJoinButtonVisible(z16);
    }

    private void F() {
        this.f43359p.getListView().setBackgroundDrawable(null);
    }

    private void G() {
        BasePhotoModelController basePhotoModelController = this.f43345b;
        String b16 = com.qzone.album.util.b.b(basePhotoModelController != null ? basePhotoModelController.f43008x0 : null);
        if (!TextUtils.isEmpty(b16)) {
            ImageLoader.Options obtain = ImageLoader.Options.obtain();
            obtain.extraProcessor = new d();
            obtain.useMainThread = true;
            Drawable loadImage = ImageLoader.getInstance().loadImage(b16, new c(), obtain);
            if (loadImage != null) {
                this.f43359p.getListView().setBackgroundDrawable(loadImage);
                return;
            }
            return;
        }
        this.f43359p.getListView().setBackgroundDrawable(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(QZoneAlbumHeaderView qZoneAlbumHeaderView) {
        String str;
        AlbumCacheData albumCacheData = this.f43345b.f43008x0;
        if (albumCacheData != null) {
            str = albumCacheData.albumdesc;
        } else {
            str = "";
        }
        qZoneAlbumHeaderView.setCoverText(str);
        qZoneAlbumHeaderView.setOnUploadPhotoButtonClickListener(this.f43345b.G1());
        if (!this.f43345b.P2()) {
            qZoneAlbumHeaderView.setEditButtonClickListener(this.f43345b.S1());
        }
        qZoneAlbumHeaderView.setOnVisitorButtonClickListener(this.f43345b.X1());
        qZoneAlbumHeaderView.setOnCommentClickListener(this.f43345b.R1());
        qZoneAlbumHeaderView.setOnLikeClickListener(this.f43345b.U1());
        qZoneAlbumHeaderView.setGoToEditAlbumClickListener(this.f43345b.S1());
        qZoneAlbumHeaderView.setOnLoveWaveClickListener(this.f43345b.N1());
        qZoneAlbumHeaderView.setShareAlbumJoinButtonClickListener(this.f43345b.j2());
        qZoneAlbumHeaderView.setOnInviteOpenLoveZoneClickListener(this.f43345b.T1());
        qZoneAlbumHeaderView.setSharingOwnersListBarClickListener(this.f43345b.k2());
        qZoneAlbumHeaderView.setAddSharingOwnersListClickListener(this.f43345b.z1());
        qZoneAlbumHeaderView.setRequestToJoinMultiAlbumClickListener(this.f43345b.d2());
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.AlbumHeaderPanel.1
            @Override // java.lang.Runnable
            public void run() {
                BasePhotoModelController basePhotoModelController = AlbumHeaderPanel.this.f43345b;
                AlbumSocialInfoCacheData A = basePhotoModelController.f43012z0.A(basePhotoModelController.T);
                AlbumHeaderPanel albumHeaderPanel = AlbumHeaderPanel.this;
                albumHeaderPanel.f43345b.D0 = A;
                albumHeaderPanel.f43344a.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.AlbumHeaderPanel.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AlbumHeaderPanel.this.C();
                    }
                });
            }
        });
    }

    private void o() {
        Activity activity = this.f43344a;
        BasePhotoModelController basePhotoModelController = this.f43345b;
        QZoneAlbumHeaderView qZoneAlbumHeaderView = new QZoneAlbumHeaderView(activity, basePhotoModelController.f42940a0, basePhotoModelController.P2(), this.f43359p, this.f43345b.W2());
        this.f43354k = qZoneAlbumHeaderView;
        n(qZoneAlbumHeaderView);
        this.f43352i.a(this.f43354k);
        s();
        l();
        this.f43359p.getListView().setCoverMode(true, BasePhotoModelController.f42936w2);
    }

    private void p() {
        View inflate = this.f43344a.getLayoutInflater().inflate(R.layout.bo8, (ViewGroup) null);
        this.f43346c = inflate;
        this.f43352i.a(inflate);
        this.f43346c.setOnClickListener(new a());
        AvatarImageView avatarImageView = (AvatarImageView) this.f43346c.findViewById(R.id.c1q);
        avatarImageView.setAsyncClipSize(ar.d(60.0f), ar.d(60.0f));
        avatarImageView.k(this.f43351h);
        ((TextView) this.f43346c.findViewById(R.id.c1u)).setText(this.f43345b.f42992r1);
        this.f43347d = (TextView) this.f43346c.findViewById(R.id.c1t);
        this.f43348e = (TextView) this.f43346c.findViewById(R.id.c1s);
        this.f43349f = (TextView) this.f43346c.findViewById(R.id.c1r);
        this.f43350g = (TextView) this.f43346c.findViewById(R.id.f165127c22);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.AlbumHeaderPanel.3
            @Override // java.lang.Runnable
            public void run() {
                final x6.a g16 = z5.a.f().g(AlbumHeaderPanel.this.f43345b.f42989q1);
                AlbumHeaderPanel.this.f43344a.runOnUiThread(new Runnable() { // from class: com.qzone.album.business.photolist.ui.header.AlbumHeaderPanel.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AlbumHeaderPanel.this.D(g16);
                    }
                });
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f43359p.getListView().getLayoutParams();
        layoutParams.addRule(3, R.id.f166672ha0);
        this.f43359p.getListView().setLayoutParams(layoutParams);
    }

    private void q() {
        if (!this.f43345b.P2()) {
            View inflate = this.f43344a.getLayoutInflater().inflate(R.layout.bo7, (ViewGroup) null);
            this.f43353j = inflate;
            r(inflate);
            this.f43352i.a(this.f43353j);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f43359p.getListView().getLayoutParams();
        layoutParams.addRule(3, R.id.f166672ha0);
        this.f43359p.getListView().setLayoutParams(layoutParams);
    }

    public void A(boolean z16) {
        B(this.f43353j, z16);
        B(this.f43354k, z16);
        if (this.f43360q) {
            B(this.f43355l, z16);
        }
        B(this.f43356m, z16);
    }

    public void B(View view, boolean z16) {
        AlbumHeaderContainer albumHeaderContainer = this.f43352i;
        if (albumHeaderContainer != null) {
            albumHeaderContainer.c(view);
            if (z16) {
                this.f43352i.a(view);
            }
        }
    }

    public void C() {
        int i3;
        com.qzone.album.env.common.a.m().b("[PhotoAlbum] AlbumHeaderPanel", "updateAlbumCover...");
        BasePhotoModelController basePhotoModelController = this.f43345b;
        AlbumSocialInfoCacheData albumSocialInfoCacheData = basePhotoModelController.D0;
        if (albumSocialInfoCacheData != null && this.f43354k != null) {
            basePhotoModelController.D0 = albumSocialInfoCacheData;
            com.qzone.album.env.common.a.m().b("[PhotoAlbum] AlbumHeaderPanel", "bigCoverUrl:", albumSocialInfoCacheData.bigCoverUrl, "\nsocialInfo.albumdesc:", albumSocialInfoCacheData.albumdesc, "\nsocialInfo.albumType:", Integer.valueOf(albumSocialInfoCacheData.albumType));
            AlbumCacheData g16 = this.f43345b.g();
            if (g16 != null) {
                g16.albumtype = albumSocialInfoCacheData.albumType;
            }
            this.f43354k.x0(g16);
            this.f43354k.X0();
            if (this.f43345b.W2()) {
                this.f43354k.setCoverImageUrl(com.qzone.album.util.b.a(g16));
            } else {
                if (albumSocialInfoCacheData.isCoverUserSet) {
                    this.f43354k.setCoverImageUrl(albumSocialInfoCacheData.bigCoverUrl);
                }
                this.f43354k.setCoverText(albumSocialInfoCacheData.albumdesc);
            }
            this.f43354k.setVisitorsCount(albumSocialInfoCacheData.albumVisitNum, g16);
            this.f43354k.setCommentCount(albumSocialInfoCacheData.commentNum, g16);
            BasePhotoModelController basePhotoModelController2 = this.f43345b;
            if (basePhotoModelController2 instanceof ViewerModelController) {
                this.f43354k.setAKeyGenData(basePhotoModelController2.Y, (ViewerModelController) basePhotoModelController2);
            }
            this.f43354k.setLikeCount(albumSocialInfoCacheData.albumLikeNum, g16);
            this.f43354k.setUploadPhotoButtonVisible(false);
            this.f43354k.setFromPublicUrlAndIsNotInShareList((!this.f43345b.T2() || g16 == null || g16.isInConfirmedShareList()) ? false : true);
            this.f43354k.setShareAlbumJoinButtonVisible((g16 != null && g16.isShareInvitePanding()) || (this.f43345b.T2() && g16 != null && !g16.isInConfirmedShareList() && this.f43345b.P2()));
            if (this.f43345b.W2() && this.f43358o != null) {
                G();
                this.f43358o.x0(g16);
                this.f43358o.setCoverImageUrl(com.qzone.album.util.b.a(g16));
                this.f43358o.setVisitorsCount(albumSocialInfoCacheData.albumVisitNum, g16);
                this.f43358o.setCommentCount(albumSocialInfoCacheData.commentNum, g16);
                this.f43358o.setLikeCount(albumSocialInfoCacheData.albumLikeNum, g16);
                this.f43358o.setUploadPhotoButtonVisible(false);
                this.f43345b.f42941a1.m(false);
                if (this.f43359p.getListView().getEmptyView() != this.f43357n) {
                    try {
                        this.f43359p.getListView().setEmptyView(this.f43357n);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                return;
            }
            if (!this.f43345b.W2() && this.f43345b.b3()) {
                com.qzone.album.env.common.a.m().b("[PhotoAlbum] AlbumHeaderPanel", "mThemeRecommentType:", Integer.valueOf(this.f43361r), "\n socialInfo.albumRecommendType:", Integer.valueOf(albumSocialInfoCacheData.albumRecommendType));
                F();
                if (this.f43361r == -1 && (i3 = albumSocialInfoCacheData.albumRecommendType) != 0) {
                    this.f43361r = i3;
                }
                this.f43354k.setThemeRecommendType(this.f43361r);
                this.f43354k.setThemeBannerBtnClickListener(this.f43345b.i2(this.f43361r));
            } else {
                this.f43354k.setThemeRecommendType(0);
            }
            View view = this.f43357n;
            if (view != null) {
                view.setVisibility(8);
            }
            if (this.f43359p.getListView().getEmptyView() != this.f43345b.f42941a1.e()) {
                this.f43359p.getListView().setEmptyView(this.f43345b.f42941a1.e());
                return;
            }
            return;
        }
        com.qzone.album.env.common.a.m().i("[PhotoAlbum] AlbumHeaderPanel", "socialInfo == null || mQZoneAlbumHeaderView == null");
    }

    public void d(int i3) {
        y(i3);
        if (i3 == 0 && this.f43360q) {
            this.f43352i.a(this.f43355l);
        }
    }

    public void e(boolean z16) {
        this.f43352i.setLayerStatus(z16);
    }

    public View f() {
        View view = this.f43357n;
        if (view != null) {
            return view;
        }
        ViewStub viewStub = (ViewStub) this.f43344a.findViewById(R.id.fls);
        this.f43357n = viewStub;
        if (viewStub != null) {
            viewStub.setOnInflateListener(new b());
        }
        return this.f43357n;
    }

    public QZoneAlbumFakeVideoView g() {
        return this.f43356m;
    }

    public AlbumHeaderContainer h() {
        return this.f43352i;
    }

    public View i() {
        return this.f43357n;
    }

    public QZoneAlbumHeaderView j() {
        return this.f43354k;
    }

    public QzoneAlbumNoShootTimeHintView k() {
        return this.f43355l;
    }

    public void l() {
        if (this.f43345b.e3() || this.f43345b.i3() || this.f43345b.Y2()) {
            QZoneAlbumFakeVideoView qZoneAlbumFakeVideoView = new QZoneAlbumFakeVideoView(this.f43344a.getApplicationContext(), this.f43345b, (View.OnClickListener) null);
            this.f43356m = qZoneAlbumFakeVideoView;
            this.f43352i.a(qZoneAlbumFakeVideoView);
            this.f43356m.b();
            this.f43345b.K0 = true;
        }
    }

    public void m() {
        this.f43352i = new AlbumHeaderContainer(this.f43344a);
        this.f43359p.getListView().addHeaderView(this.f43352i);
        if (this.f43345b.h()) {
            if (this.f43345b.Q2()) {
                p();
            } else if (this.f43345b.k3()) {
                q();
            } else {
                o();
            }
        }
    }

    public void s() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("is_need_show_no_shoot_time_hint_view_");
        sb5.append(this.f43345b.T);
        this.f43360q = u5.b.H(sb5.toString(), 1, LoginData.getInstance().getUin()) == 1;
        if (this.f43345b.h3() && !this.f43345b.P2() && this.f43360q) {
            Activity activity = this.f43344a;
            BasePhotoModelController basePhotoModelController = this.f43345b;
            QzoneAlbumNoShootTimeHintView qzoneAlbumNoShootTimeHintView = new QzoneAlbumNoShootTimeHintView(activity, basePhotoModelController, basePhotoModelController.W1(), this.f43345b.V1());
            this.f43355l = qzoneAlbumNoShootTimeHintView;
            this.f43352i.a(qzoneAlbumNoShootTimeHintView);
            this.f43355l.setVisibility(8);
        }
    }

    public void t() {
        if (j() != null) {
            j().Y0(this.f43344a.getApplicationContext());
        }
    }

    public void u() {
        if (j() != null) {
            j().l0();
        }
    }

    public void v() {
        if (j() != null) {
            j().m0();
        }
    }

    public void w() {
        if (j() != null) {
            j().n0();
        }
    }

    public void x() {
        if (j() != null) {
            j().o0();
        }
    }

    public void z(boolean z16) {
        this.f43360q = z16;
    }

    public void D(x6.a aVar) {
        String a16;
        if (aVar == null || this.f43346c == null) {
            return;
        }
        int i3 = aVar.gender;
        if (i3 != 0) {
            a16 = i3 != 1 ? null : l.a(R.string.jc7);
        } else {
            a16 = l.a(R.string.jc8);
        }
        if (a16 == null) {
            this.f43347d.setVisibility(8);
        } else {
            this.f43347d.setVisibility(0);
            this.f43347d.setText(a16);
        }
        String str = aVar.astro;
        if (TextUtils.isEmpty(str)) {
            this.f43348e.setVisibility(8);
        } else {
            this.f43348e.setVisibility(0);
            this.f43348e.setText(str);
        }
        String str2 = aVar.city;
        if (TextUtils.isEmpty(str2)) {
            this.f43349f.setVisibility(8);
        } else {
            this.f43349f.setVisibility(0);
            this.f43349f.setText(str2);
        }
    }

    public void y(int i3) {
        if (i3 == 0) {
            this.f43352i.c(this.f43355l);
        }
    }

    private void r(View view) {
        Button button;
        if (view == null || (button = (Button) view.findViewById(R.id.kke)) == null) {
            return;
        }
        button.setText(R.string.gpe);
        button.setOnClickListener(this.f43345b.H1());
    }
}

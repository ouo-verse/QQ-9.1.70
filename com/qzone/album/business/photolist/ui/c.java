package com.qzone.album.business.photolist.ui;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.album.business.photolist.controller.BasePhotoModelController;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.PhotoPoiArea;
import com.qzone.album.data.model.TravelAlbumData;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.qzone.widget.AsyncImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class c implements View.OnClickListener {
    private RelativeLayout C;
    private RelativeLayout D;
    private RelativeLayout E;
    private LinearLayout F;
    private Button G;
    private Button H;
    private Button I;
    private Button J;
    private Button K;
    private Button L;
    private Button M;
    private FrameLayout N;
    private TextView P;
    private TextView Q;
    private b R;
    private int S;
    private boolean T = false;
    private boolean U = false;
    private boolean V = false;
    private a W;
    private View X;

    /* renamed from: d, reason: collision with root package name */
    private Activity f43311d;

    /* renamed from: e, reason: collision with root package name */
    private BasePhotoModelController f43312e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f43313f;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f43314h;

    /* renamed from: i, reason: collision with root package name */
    private RelativeLayout f43315i;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f43316m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        AsyncImageView f43317a;

        /* renamed from: b, reason: collision with root package name */
        TextView f43318b;

        /* renamed from: c, reason: collision with root package name */
        TextView f43319c;

        /* renamed from: d, reason: collision with root package name */
        Button f43320d;

        /* renamed from: e, reason: collision with root package name */
        Button f43321e;

        /* renamed from: f, reason: collision with root package name */
        View f43322f;

        public a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface b {
        void a(View view);

        void b(View view);

        void c(View view);

        void d(View view);

        void e(View view);

        void f(View view);

        void g(View view);

        void h(View view);

        void i(View view);

        void j(View view);

        void k(View view);
    }

    public c(Activity activity, BasePhotoModelController basePhotoModelController) {
        this.f43311d = activity;
        this.f43312e = basePhotoModelController;
        if (this.R == null) {
            this.R = basePhotoModelController.Q1();
        }
    }

    private String b() {
        return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumPhoneAlbum", "\u624b\u673a\u76f8\u518c");
    }

    private void f(int i3) {
        if (!this.V) {
            this.N = (FrameLayout) this.f43311d.findViewById(R.id.ayo);
            this.Q = (TextView) this.f43311d.findViewById(R.id.agf);
            this.P = (TextView) this.f43311d.findViewById(R.id.fqz);
            this.Q.setOnClickListener(this);
            this.P.setOnClickListener(this);
            this.V = true;
        }
        this.P.setEnabled(false);
        this.P.setVisibility(8);
        this.Q.setVisibility(8);
        if (i3 == 4) {
            this.Q.setVisibility(0);
        } else if (i3 == 5) {
            this.P.setVisibility(0);
        }
    }

    private void g() {
        this.f43313f = (LinearLayout) this.f43311d.findViewById(R.id.fr6);
        if (!this.f43312e.P2()) {
            j();
        } else {
            i();
        }
        this.U = true;
    }

    private void h() {
        this.F = (LinearLayout) this.f43311d.findViewById(R.id.f166179em4);
        Button button = (Button) this.f43311d.findViewById(R.id.agx);
        this.L = button;
        button.setOnClickListener(this);
        this.T = true;
    }

    private void i() {
        this.f43313f.setVisibility(8);
        this.X = ((ViewStub) this.f43311d.findViewById(R.id.f166507fp1)).inflate();
        if (this.W == null) {
            this.W = new a();
        }
        this.W.f43317a = (AsyncImageView) this.X.findViewById(R.id.f164257p5);
        this.W.f43317a.setDefaultImage(R.drawable.asd);
        this.W.f43318b = (TextView) this.X.findViewById(R.id.f164277qh);
        this.W.f43319c = (TextView) this.X.findViewById(R.id.f164279qk);
        this.W.f43320d = (Button) this.X.findViewById(R.id.i8i);
        this.W.f43321e = (Button) this.X.findViewById(R.id.i8h);
        this.W.f43322f = this.X.findViewById(R.id.i8j);
        this.W.f43320d.setOnClickListener(this);
        this.W.f43321e.setOnClickListener(this);
        this.W.f43322f.setOnClickListener(this);
        n(this.f43312e.f2());
        this.f43312e.K3();
    }

    private void j() {
        this.f43314h = (RelativeLayout) this.f43311d.findViewById(R.id.fr_);
        this.f43315i = (RelativeLayout) this.f43311d.findViewById(R.id.fr9);
        this.f43316m = (RelativeLayout) this.f43311d.findViewById(R.id.fra);
        this.C = (RelativeLayout) this.f43311d.findViewById(R.id.fr7);
        this.D = (RelativeLayout) this.f43311d.findViewById(R.id.fr8);
        this.E = (RelativeLayout) this.f43311d.findViewById(R.id.frb);
        this.G = (Button) this.f43311d.findViewById(R.id.f166515fr3);
        this.H = (Button) this.f43311d.findViewById(R.id.f166514fr2);
        this.I = (Button) this.f43311d.findViewById(R.id.f166516fr4);
        this.J = (Button) this.f43311d.findViewById(R.id.f166512fr0);
        this.K = (Button) this.f43311d.findViewById(R.id.f166513fr1);
        this.M = (Button) this.f43311d.findViewById(R.id.fr5);
        this.G.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.M.setOnClickListener(this);
        if (this.f43312e.h3()) {
            this.E.setVisibility(8);
            this.f43314h.setVisibility(0);
            if (this.f43312e.i3()) {
                this.f43315i.setVisibility(0);
            }
        } else {
            if (!this.f43312e.a3() && this.S != 6) {
                this.E.setVisibility(0);
            } else {
                this.E.setVisibility(8);
            }
            this.f43314h.setVisibility(8);
            this.f43315i.setVisibility(8);
        }
        l(false);
    }

    private void k(Button button, int i3, int i16) {
        Drawable drawable = this.f43311d.getResources().getDrawable(i3);
        drawable.setBounds(0, 0, ar.e(25.0f), ar.e(25.0f));
        button.setCompoundDrawables(null, drawable, null, null);
        button.setTextColor(this.f43311d.getResources().getColor(i16));
        button.setCompoundDrawablePadding(ar.e(-3.0f));
    }

    private void m(int i3) {
        try {
            this.f43312e.v0((int) this.f43311d.getResources().getDimension(i3));
        } catch (Exception e16) {
            QZLog.e("BottomPanel", 2, "setReshipPaddingBottom set padding bottom exception ", e16);
        }
    }

    private void u(int i3) {
        a aVar = this.W;
        if (aVar == null) {
            QZLog.e("BottomPanel", 1, "updateGuestBottomLayout with reshipViewStub==null!!");
            return;
        }
        if (i3 > 0) {
            if (!aVar.f43321e.isEnabled()) {
                this.W.f43321e.setEnabled(true);
            }
            if (QQTheme.isVasTheme() && this.W.f43321e.isEnabled()) {
                this.W.f43321e.setBackgroundResource(R.drawable.f160492i5);
            } else {
                this.W.f43321e.setBackgroundResource(R.drawable.f160501ig);
            }
            if (!this.W.f43320d.isEnabled()) {
                this.W.f43320d.setEnabled(true);
            }
            this.W.f43321e.setText(l.a(R.string.k2s) + i3 + ")");
            return;
        }
        if (aVar.f43321e.isEnabled()) {
            this.W.f43321e.setEnabled(false);
        }
        if (this.W.f43320d.isEnabled()) {
            this.W.f43320d.setEnabled(false);
        }
        this.W.f43321e.setText(l.a(R.string.k2r));
    }

    private void v(int i3) {
        if (this.f43313f == null || !this.U) {
            return;
        }
        l(i3 > 0);
    }

    public void a() {
        Button button = this.L;
        if (button == null || !button.isEnabled()) {
            return;
        }
        this.L.performClick();
    }

    public void c(boolean z16) {
        LinearLayout linearLayout = this.F;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        FrameLayout frameLayout = this.N;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.f43313f;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        View view = this.X;
        if (view != null) {
            view.setVisibility(8);
            this.f43312e.v0(0);
            if (z16) {
                o5.a.c(4, 4);
            }
        }
    }

    public void d(Animation.AnimationListener animationListener, long j3, boolean z16) {
        if (this.f43313f == null) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f43311d, R.anim.f154788cn);
        loadAnimation.setAnimationListener(animationListener);
        loadAnimation.setDuration(j3);
        this.f43313f.startAnimation(loadAnimation);
        c(z16);
    }

    public void e(int i3) {
        this.S = i3;
        if ((i3 == 2 || i3 == 3 || i3 == 7) && !this.T) {
            h();
        } else if (QZoneAlbumUtil.A(i3)) {
            f(i3);
        }
        if (this.U) {
            return;
        }
        g();
    }

    public void n(BusinessAlbumInfo businessAlbumInfo) {
        a aVar = this.W;
        if (aVar == null || this.X == null) {
            return;
        }
        if (businessAlbumInfo != null) {
            aVar.f43317a.setAsyncImage(businessAlbumInfo.mCover);
            this.W.f43318b.setText(businessAlbumInfo.mTitle);
            this.W.f43319c.setText(businessAlbumInfo.getPrivacyDescription());
        } else {
            aVar.f43317a.setAsyncImage(null);
            this.W.f43318b.setText(b());
            this.W.f43319c.setText(b());
        }
    }

    public void o() {
        if (this.f43313f == null) {
            return;
        }
        this.f43313f.startAnimation(AnimationUtils.loadAnimation(this.f43311d, R.anim.f154785cl));
        this.f43313f.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TravelAlbumData travelAlbumData;
        ArrayList<PhotoPoiArea> arrayList;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.R != null && view != null) {
            int id5 = view.getId();
            if (id5 == R.id.f166515fr3 || id5 == R.id.fqz) {
                this.R.g(view);
            } else if (id5 == R.id.agf) {
                this.R.k(view);
            } else if (id5 == R.id.f166514fr2) {
                AlbumCacheData albumCacheData = this.f43312e.f43008x0;
                if (albumCacheData != null && (travelAlbumData = albumCacheData.travelData) != null && (arrayList = travelAlbumData.photoPoiAreaList) != null && arrayList.size() > 0) {
                    this.R.f(view);
                } else {
                    com.qzone.album.env.common.a.m().W(this.f43311d.getResources().getString(R.string.gbf), 1);
                }
            } else if (id5 == R.id.f166516fr4) {
                this.R.a(view);
            } else if (id5 == R.id.f166512fr0) {
                this.R.b(view);
            } else if (id5 == R.id.f166513fr1) {
                this.R.h(view);
            } else if (id5 == R.id.fr5) {
                this.R.d(view);
            } else if (id5 == R.id.agx) {
                this.R.i(view);
            } else if (id5 == R.id.i8j) {
                this.R.e(view);
                o5.a.c(2, 4);
            } else if (id5 == R.id.i8i) {
                this.R.c(view);
            } else if (id5 == R.id.i8h) {
                this.R.j(view);
                o5.a.c(3, 4);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void q(int i3) {
        this.S = i3;
        p();
        if (i3 != 1 && i3 != 6) {
            LinearLayout linearLayout = this.f43313f;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            View view = this.X;
            if (view != null) {
                view.setVisibility(8);
                this.f43312e.v0(0);
                return;
            }
            return;
        }
        if (!this.f43312e.P2()) {
            this.f43313f.setVisibility(0);
            if (this.f43312e.i3() && !this.f43312e.P2()) {
                this.f43315i.setVisibility(0);
            } else {
                this.f43315i.setVisibility(8);
            }
            if (!this.f43312e.h3()) {
                this.f43314h.setVisibility(8);
                if (!this.f43312e.a3() && i3 != 6) {
                    this.E.setVisibility(0);
                } else {
                    this.E.setVisibility(8);
                }
            } else {
                this.f43314h.setVisibility(0);
                this.E.setVisibility(8);
            }
            if (this.f43312e.g() != null && this.f43312e.g().isSharingAlbumOnServer()) {
                this.I.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumCopy", "\u590d\u5236"));
                this.I.setTag(QZoneContant.KEY_RESHIP);
            } else {
                this.I.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AlbumTransfer", "\u8f6c\u79fb"));
            }
            this.f43316m.setVisibility(0);
            this.C.setVisibility(0);
            this.D.setVisibility(0);
            return;
        }
        View view2 = this.X;
        if (view2 != null) {
            view2.setVisibility(0);
            o5.a.c(1, 4);
        }
    }

    public void r(int i3) {
        int i16 = this.S;
        if (i16 == 2 || i16 == 3 || i16 == 7) {
            t(i3);
            return;
        }
        if (i16 == 5) {
            s(i3);
        } else if (this.f43312e.P2()) {
            m(R.dimen.aqx);
            u(i3);
        } else {
            v(i3);
        }
    }

    public void s(int i3) {
        if (this.N != null && this.P != null) {
            p();
            if (i3 > 0) {
                if (!this.P.isEnabled()) {
                    this.P.setEnabled(true);
                }
                this.P.setTextColor(Color.parseColor("#2BBEF6"));
                return;
            } else {
                if (this.P.isEnabled()) {
                    this.P.setEnabled(false);
                }
                this.P.setTextColor(this.f43311d.getResources().getColor(R.color.f156936fq));
                return;
            }
        }
        QZLog.e("BottomPanel", 1, "clearUpPhotoBottomLayout/mBtmSetTime is null when do updateClearUpPhotoBottom()!");
    }

    public void t(int i3) {
        if (this.F != null && this.L != null) {
            p();
            if (i3 > 0) {
                if (!this.L.isEnabled()) {
                    this.L.setEnabled(true);
                }
                this.L.setText(l.a(R.string.k2t) + i3 + ")");
                return;
            }
            if (this.L.isEnabled()) {
                this.L.setEnabled(false);
            }
            this.L.setText(l.a(R.string.ket));
            return;
        }
        QZLog.e("BottomPanel", 1, "dynamicBottomLayout/mBtnDynamicConfirm is null when do updateDynamicBottomLayout()!");
    }

    private void p() {
        c(false);
        if (this.f43312e.P2()) {
            View view = this.X;
            if (view == null || view.getVisibility() == 0) {
                return;
            }
            this.X.setVisibility(0);
            return;
        }
        int i3 = this.S;
        if (i3 != 2 && i3 != 3 && i3 != 7) {
            if (QZoneAlbumUtil.A(i3)) {
                FrameLayout frameLayout = this.N;
                if (frameLayout == null || frameLayout.getVisibility() != 8) {
                    return;
                }
                this.N.setVisibility(0);
                this.P.setVisibility(8);
                this.Q.setVisibility(8);
                int i16 = this.S;
                if (i16 == 4) {
                    this.Q.setVisibility(0);
                    return;
                } else {
                    if (i16 == 5) {
                        this.P.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            LinearLayout linearLayout = this.f43313f;
            if (linearLayout == null || linearLayout.getVisibility() != 8) {
                return;
            }
            this.f43313f.setVisibility(0);
            return;
        }
        LinearLayout linearLayout2 = this.F;
        if (linearLayout2 == null || linearLayout2.getVisibility() != 8) {
            return;
        }
        this.F.setVisibility(0);
    }

    private void l(boolean z16) {
        if (z16) {
            k(this.G, R.drawable.f162183fw1, R.color.black);
            k(this.H, R.drawable.f162182fw0, R.color.black);
            k(this.I, R.drawable.f162184fw2, R.color.black);
            k(this.J, R.drawable.fvz, R.color.black);
            k(this.K, R.drawable.ftu, R.color.black);
            return;
        }
        k(this.G, R.drawable.aqs, R.color.f156936fq);
        k(this.H, R.drawable.aqr, R.color.f156936fq);
        k(this.I, R.drawable.aqt, R.color.f156936fq);
        k(this.J, R.drawable.aqp, R.color.f156936fq);
        k(this.K, R.drawable.aqq, R.color.f156936fq);
    }
}

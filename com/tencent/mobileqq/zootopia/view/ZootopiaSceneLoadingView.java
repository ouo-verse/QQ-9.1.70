package com.tencent.mobileqq.zootopia.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.state.report.SquareReportConst;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ZootopiaSceneLoadingView extends ZPlanBaseSceneLoadingView {
    public static boolean S = false;
    private ImageView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private int G;
    private String H;
    private int I;
    private boolean J;
    private Runnable K;
    private URLDrawable L;
    private View.OnClickListener M;
    private boolean N;
    private id3.d P;
    private ZootopiaEnterParams Q;
    private ZootopiaSource R;

    /* renamed from: e, reason: collision with root package name */
    private View f329670e;

    /* renamed from: f, reason: collision with root package name */
    private RoundImageView f329671f;

    /* renamed from: h, reason: collision with root package name */
    private FrameLayout f329672h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f329673i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f329674m;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements com.tencent.mobileqq.zootopia.ipc.k {
        a() {
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.k
        public void onResult(boolean z16) {
            ZootopiaSceneLoadingView.S = z16;
            ZootopiaSceneLoadingView.this.f329672h.setVisibility(ZootopiaSceneLoadingView.S ? 0 : 8);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ id3.d f329681d;

        b(id3.d dVar) {
            this.f329681d = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            id3.d dVar = this.f329681d;
            if (dVar != null) {
                dVar.c("clck", view, ZootopiaSceneLoadingView.this.v());
            }
            View.OnClickListener onClickListener = ZootopiaSceneLoadingView.this.M;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public ZootopiaSceneLoadingView(Context context) {
        this(context, null);
    }

    private void A(String str) {
        int u16;
        int u17;
        if (QLog.isColorLevel()) {
            QLog.d("ZootopiaSceneLoadingView", 1, "setIconUrl:" + str);
        }
        if (!TextUtils.isEmpty(str)) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            if (this.N) {
                u16 = u(R.dimen.f10953g);
            } else {
                u16 = u(R.dimen.f10943f);
            }
            obtain.mRequestWidth = u16;
            if (this.N) {
                u17 = u(R.dimen.f10953g);
            } else {
                u17 = u(R.dimen.f10943f);
            }
            obtain.mRequestHeight = u17;
            obtain.mFailedDrawable = getResources().getDrawable(R.drawable.ik_);
            URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
            drawable.startDownload();
            this.f329671f.setImageDrawable(drawable);
            return;
        }
        this.f329671f.setImageResource(R.drawable.ik_);
    }

    private void B(String str) {
        this.D.setText(str);
    }

    private void C() {
        ImageView imageView = this.C;
        if (imageView != null && this.J) {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            rotateAnimation.setDuration(5000L);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setRepeatMode(1);
            imageView.startAnimation(rotateAnimation);
        }
    }

    private void D() {
        if (this.J) {
            t();
            C();
            E(this.L, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(URLDrawable uRLDrawable, boolean z16) {
        ImageView imageView = this.f329674m;
        if ((this.L == null || imageView == null || imageView.getDrawable() == null) && this.J) {
            if (uRLDrawable == null && z16) {
                y();
                return;
            }
            this.L = uRLDrawable;
            if (imageView != null) {
                imageView.setImageDrawable(uRLDrawable);
            }
        }
    }

    private void F() {
        ImageView imageView = this.C;
        if (imageView == null || this.J) {
            return;
        }
        imageView.clearAnimation();
    }

    private void G() {
        if (this.J) {
            return;
        }
        I();
        F();
        H();
    }

    private void H() {
        ImageView imageView = this.f329674m;
        if (imageView == null || this.J) {
            return;
        }
        imageView.setImageDrawable(null);
    }

    private void I() {
        TextView textView = this.E;
        if (textView == null || this.J) {
            return;
        }
        textView.removeCallbacks(this.K);
    }

    private void r() {
        final FrameLayout frameLayout = this.f329672h;
        if (frameLayout == null) {
            return;
        }
        frameLayout.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.view.ZootopiaSceneLoadingView.5
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                if (layoutParams != null) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    int statusBarHeight = ImmersiveUtils.getStatusBarHeight(ZootopiaSceneLoadingView.this.getContext());
                    if (statusBarHeight <= 0) {
                        layoutParams2.topMargin = ZootopiaSceneLoadingView.this.N ? ZootopiaSceneLoadingView.this.u(R.dimen.f108638) : ZootopiaSceneLoadingView.this.u(R.dimen.f108537);
                    } else {
                        layoutParams2.topMargin = statusBarHeight + (ZootopiaSceneLoadingView.this.N ? ZootopiaSceneLoadingView.this.u(R.dimen.f108739) : ZootopiaSceneLoadingView.this.u(R.dimen.f108436));
                    }
                    frameLayout.requestLayout();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        TextView textView = this.E;
        if (textView != null && this.J) {
            textView.removeCallbacks(this.K);
            textView.postDelayed(this.K, 800L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int u(int i3) {
        return getResources().getDimensionPixelSize(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> v() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("zplan_map_id", Integer.valueOf(this.Q.getMapId()));
        hashMap.put("zplan_map_name", this.Q.getName());
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, com.tencent.sqshow.zootopia.utils.ag.f373258a.d(this.R));
        return hashMap;
    }

    private String w() {
        int i3 = (this.I + 1) & 3;
        this.I = i3;
        if (i3 == 1) {
            return ".";
        }
        if (i3 == 2) {
            return "..";
        }
        if (i3 != 3) {
            return "";
        }
        return MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    private void x() {
        final FrameLayout frameLayout;
        final id3.d dVar = this.P;
        if (dVar == null || (frameLayout = this.f329672h) == null) {
            return;
        }
        dVar.g(frameLayout, "em_zplan_map_loading_back", new HashMap(), false, false, null, false, false);
        frameLayout.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.view.ZootopiaSceneLoadingView.4
            @Override // java.lang.Runnable
            public void run() {
                dVar.c("imp", frameLayout, ZootopiaSceneLoadingView.this.v());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        String w3 = w();
        this.H = w3;
        this.E.setText(w3);
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView
    public void e(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f329673i.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.F.setText(str2.concat("%"));
        }
        QLog.i("ZootopiaSceneLoadingView", 4, " progress text == " + str + MiniBoxNoticeInfo.APPNAME_SUFFIX + str2.concat("%"));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.J = true;
        D();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.J = false;
        G();
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView
    public void setOnBackArrowClickListener(View.OnClickListener onClickListener) {
        this.M = onClickListener;
    }

    public ZootopiaSceneLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    private void y() {
        try {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.view.ZootopiaSceneLoadingView.6
                @Override // java.lang.Runnable
                public void run() {
                    String a16 = com.tencent.sqshow.zootopia.utils.af.f373257a.a(ZootopiaSceneLoadingView.this.getContext(), "zootopia_scene_loading_anim_outer_apng.png");
                    if (a16 == null) {
                        QLog.e("ZootopiaSceneLoadingView", 1, "filePath is null");
                        return;
                    }
                    ApngOptions apngOptions = new ApngOptions();
                    apngOptions.setRequestWidth(ZootopiaSceneLoadingView.this.N ? ZootopiaSceneLoadingView.this.u(R.dimen.f10933e) : ZootopiaSceneLoadingView.this.u(R.dimen.f10923d));
                    apngOptions.setRequestHeight(ZootopiaSceneLoadingView.this.N ? ZootopiaSceneLoadingView.this.u(R.dimen.f10933e) : ZootopiaSceneLoadingView.this.u(R.dimen.f10923d));
                    final URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("", apngOptions, a16);
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.view.ZootopiaSceneLoadingView.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ZootopiaSceneLoadingView.this.E(apngURLDrawable, false);
                        }
                    });
                }
            }, 64, null, true);
        } catch (Throwable th5) {
            QLog.e("ZootopiaSceneLoadingView", 1, "loadEllipsisAnimation fail.", th5);
        }
    }

    public ZootopiaSceneLoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.G = 0;
        this.H = "";
        this.I = 0;
        this.J = false;
        this.K = new Runnable() { // from class: com.tencent.mobileqq.zootopia.view.ZootopiaSceneLoadingView.1
            @Override // java.lang.Runnable
            public void run() {
                ZootopiaSceneLoadingView.this.z();
                ZootopiaSceneLoadingView.this.t();
            }
        };
        this.M = null;
        this.N = false;
        this.P = null;
    }

    private void s(ZootopiaEnterParams zootopiaEnterParams) {
        if (zootopiaEnterParams == null) {
            return;
        }
        B(zootopiaEnterParams.getName());
        A(zootopiaEnterParams.getIcon());
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView
    public void c(id3.d dVar, ZootopiaEnterParams zootopiaEnterParams, ZootopiaSource zootopiaSource) {
        if (zootopiaEnterParams == null) {
            return;
        }
        this.Q = zootopiaEnterParams;
        this.R = zootopiaSource;
        this.P = dVar;
        if (this.f329670e == null) {
            boolean z16 = zootopiaEnterParams.getScreenType() != 2;
            this.N = z16;
            View inflate = View.inflate(getContext(), z16 ? R.layout.d99 : R.layout.d98, this);
            this.f329670e = inflate;
            this.f329672h = (FrameLayout) inflate.findViewById(R.id.r1k);
            this.f329673i = (TextView) this.f329670e.findViewById(R.id.r1q);
            this.f329671f = (RoundImageView) this.f329670e.findViewById(R.id.r1m);
            this.f329674m = (ImageView) this.f329670e.findViewById(R.id.r1o);
            this.C = (ImageView) this.f329670e.findViewById(R.id.r1n);
            this.D = (TextView) this.f329670e.findViewById(R.id.r1p);
            this.E = (TextView) this.f329670e.findViewById(R.id.r1s);
            this.F = (TextView) this.f329670e.findViewById(R.id.r1r);
            ((ZootopiaSceneLoadingBg) this.f329670e.findViewById(R.id.pel)).a(zootopiaEnterParams.getShowGameHealthyLoading());
            r();
            ((com.tencent.mobileqq.zootopia.ipc.l) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.l.class)).isSwitchOn(1000, new a());
            this.f329672h.setOnClickListener(new b(dVar));
            x();
        }
        s(zootopiaEnterParams);
    }
}

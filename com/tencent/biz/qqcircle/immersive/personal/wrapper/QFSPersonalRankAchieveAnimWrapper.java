package com.tencent.biz.qqcircle.immersive.personal.wrapper;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.manager.e;
import com.tencent.biz.qqcircle.immersive.personal.bean.q;
import com.tencent.biz.qqcircle.immersive.utils.l;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.order.IOrderElement;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.theme.SkinnableView;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import fa0.d;
import uq3.k;

/* loaded from: classes4.dex */
public class QFSPersonalRankAchieveAnimWrapper implements d.a, IOrderElement, SkinnableView {
    private static final float J = cx.a(4.0f);
    private static final float K = cx.a(60.0f);
    private static final float L = cx.a(24.0f);
    private static final float M = cx.a(106.0f);
    protected Size C;
    private boolean F;
    private int G;

    /* renamed from: d, reason: collision with root package name */
    private Context f89393d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f89394e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f89395f;

    /* renamed from: h, reason: collision with root package name */
    private View f89396h;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView f89397i;

    /* renamed from: m, reason: collision with root package name */
    private View f89398m;
    private boolean D = false;
    private boolean E = false;
    private final Runnable H = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.wrapper.QFSPersonalRankAchieveAnimWrapper.1
        @Override // java.lang.Runnable
        public void run() {
            QFSPersonalRankAchieveAnimWrapper.this.x();
        }
    };
    private final d<q> I = new d<>(q.a());

    public QFSPersonalRankAchieveAnimWrapper(Context context, View view) {
        this.f89393d = context;
        o(view);
        n();
        s();
        e.a().addElement(this);
    }

    private void h() {
        View view = this.f89396h;
        if (view == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.f89396h.setLayoutParams(layoutParams);
    }

    private void i() {
        FrameLayout frameLayout = this.f89394e;
        if (frameLayout == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        layoutParams.width = (int) (K + L);
        this.f89394e.setLayoutParams(layoutParams);
    }

    private String k(q qVar) {
        if (qVar == null) {
            return null;
        }
        if (QCircleCommonUtil.isInNightMode()) {
            return qVar.f88506b;
        }
        return qVar.f88505a;
    }

    private String l() {
        RFWMultiDownloadHelper.DownloadResult downloadResult;
        String[] b16;
        if (!this.I.r()) {
            QLog.e("QFSPersonalRankAchieveAnimWrapper", 1, "getAchieveAnimZipLastPicUrl res not loaded");
            this.I.v();
            return null;
        }
        String k3 = k(this.I.o());
        if (TextUtils.isEmpty(k3)) {
            return null;
        }
        if (this.I.m() == null) {
            downloadResult = null;
        } else {
            downloadResult = this.I.m().get(k3);
        }
        if (downloadResult == null || (b16 = q50.a.b(k3, downloadResult.mFilePath)) == null || b16.length <= 0) {
            return null;
        }
        return b16[b16.length - 1];
    }

    private void n() {
        this.E = k.a().c("sp_key_personal_new_rank_achieve_done_anim", false);
    }

    private void o(View view) {
        if (view == null) {
            QLog.e("QFSPersonalRankAchieveAnimWrapper", 1, "initView rootView is null");
            return;
        }
        this.f89394e = (FrameLayout) view.findViewById(R.id.f32350ti);
        this.f89395f = (ImageView) view.findViewById(R.id.f31270ql);
        this.f89396h = view.findViewById(R.id.f31280qm);
        this.f89397i = (RecyclerView) view.findViewById(R.id.f32790up);
        this.f89398m = view.findViewById(R.id.f32340th);
        u();
        this.C = n.b(this.f89395f.getContext(), R.dimen.f159412d41, R.dimen.f159411d40);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        if (this.f89397i != null && r0.getWidth() >= cx.g() - M) {
            return true;
        }
        return false;
    }

    private void r() {
        View view = this.f89396h;
        if (view != null && view.getVisibility() == 0) {
            PathInterpolator pathInterpolator = new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f89396h, "translationX", J, K);
            ofFloat.setInterpolator(pathInterpolator);
            ofFloat.setDuration(280L);
            ofFloat.start();
            return;
        }
        QLog.e("QFSPersonalRankAchieveAnimWrapper", 1, "playRankArrowAnim arrowView is null or not visible");
    }

    private void s() {
        if (this.I.r()) {
            return;
        }
        QLog.e("QFSPersonalRankAchieveAnimWrapper", 1, "preDownResource res not load succeed");
        this.I.x(this);
        this.I.v();
    }

    private void t() {
        k.a().j("sp_key_personal_new_rank_achieve_done_anim", this.E);
    }

    private void u() {
        if (this.f89398m != null && this.f89393d != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
            gradientDrawable.setColors(new int[]{this.f89393d.getResources().getColor(R.color.ajr), QFSQUIUtilsKt.d(this.f89393d, R.color.qui_common_bg_bottom_light)});
            this.f89398m.setBackground(gradientDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.f89395f == null) {
            QLog.e("QFSPersonalRankAchieveAnimWrapper", 1, "startAnimInner mIvAnimView is null");
            return;
        }
        if (!this.I.r()) {
            if (this.G < 1) {
                s();
                this.G++;
                RFWThreadManager.getUIHandler().removeCallbacks(this.H);
                RFWThreadManager.getUIHandler().postDelayed(this.H, 500L);
                QLog.e("QFSPersonalRankAchieveAnimWrapper", 1, "startAnimInner resLoad retry count = " + this.G);
                return;
            }
            v();
            QLog.e("QFSPersonalRankAchieveAnimWrapper", 1, "startAnimInner resLoad retry finish, showStaticView");
            return;
        }
        String k3 = k(this.I.o());
        if (TextUtils.isEmpty(k3)) {
            v();
            QLog.e("QFSPersonalRankAchieveAnimWrapper", 1, "startAnimInner likeAnimUrl is empty");
        } else {
            l.d(k3, this.I.m(), 400L, this.f89395f, new a());
            h();
            i();
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        RecyclerView recyclerView = this.f89397i;
        if (recyclerView == null) {
            QLog.e("QFSPersonalRankAchieveAnimWrapper", 1, "updateMaskWithAchieveView recyclerView is null");
        } else {
            recyclerView.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.wrapper.QFSPersonalRankAchieveAnimWrapper.3
                @Override // java.lang.Runnable
                public void run() {
                    boolean q16 = QFSPersonalRankAchieveAnimWrapper.this.q();
                    if (QLog.isColorLevel()) {
                        QLog.d("QFSPersonalRankAchieveAnimWrapper", 2, "updateMaskWithAchieveView needShowMask = " + q16);
                    }
                    if (q16 && QFSPersonalRankAchieveAnimWrapper.this.f89398m != null) {
                        QFSPersonalRankAchieveAnimWrapper.this.f89398m.setVisibility(0);
                    }
                }
            });
        }
    }

    @Override // fa0.d.a
    public void A2() {
        QLog.d("QFSPersonalRankAchieveAnimWrapper", 1, "onPreloadSucceed");
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getContextHashCode() {
        Context context = this.f89393d;
        if (context == null) {
            return "";
        }
        return String.valueOf(context.hashCode());
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getElementExtraKey() {
        return com.tencent.biz.richframework.order.a.a(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getGroup() {
        return "personal_type_anim";
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ String getGroupExtraKey() {
        return com.tencent.biz.richframework.order.a.b(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 100;
    }

    @Override // fa0.d.a
    public void h4() {
        QLog.e("QFSPersonalRankAchieveAnimWrapper", 1, "onPreloadSucceed");
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public /* synthetic */ boolean isDataReady() {
        return com.tencent.biz.richframework.order.a.c(this);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        return this.F;
    }

    public void j(boolean z16) {
        QLog.d("QFSPersonalRankAchieveAnimWrapper", 1, "bindData showAnim = " + z16);
        this.F = z16;
        if (!z16) {
            this.E = false;
        }
    }

    public void m() {
        QLog.d("QFSPersonalRankAchieveAnimWrapper", 1, "hideAnimView");
        ImageView imageView = this.f89395f;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        View view = this.f89396h;
        if (view != null) {
            view.setTranslationX(0.0f);
        }
        RFWThreadManager.getUIHandler().removeCallbacks(this.H);
        t();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        w(500L);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        m();
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        u();
    }

    public boolean p() {
        ImageView imageView = this.f89395f;
        if (imageView != null && imageView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public void v() {
        if (this.f89395f == null) {
            return;
        }
        String l3 = l();
        if (TextUtils.isEmpty(l3)) {
            l3 = QCircleSkinHelper.getInstance().getUrl("qvideo_skin_tips_achievement_0");
        }
        if (QLog.isColorLevel()) {
            QLog.d("QFSPersonalRankAchieveAnimWrapper", 2, "showStaticView staticPicUrl = " + l3);
        }
        Option enableAutoDeleteLocalCache = Option.obtain().setUrl(l3).setTargetView(this.f89395f).setRequestWidth(this.C.getWidth()).setRequestHeight(this.C.getHeight()).setEnableAutoDeleteLocalCache(false);
        enableAutoDeleteLocalCache.setNeedShowLoadingDrawable(false);
        QCircleFeedPicLoader.g().loadImage(enableAutoDeleteLocalCache);
        this.D = false;
        this.f89395f.setVisibility(0);
        View view = this.f89396h;
        if (view != null) {
            view.setTranslationX(K);
            h();
            i();
        }
        y();
    }

    public void w(long j3) {
        if (!isElementCanActivate()) {
            QLog.e("QFSPersonalRankAchieveAnimWrapper", 1, "startAnim element cannot show");
            return;
        }
        if (this.D) {
            QLog.d("QFSPersonalRankAchieveAnimWrapper", 1, "startAnim anim is running");
            return;
        }
        if (this.E) {
            v();
            QLog.d("QFSPersonalRankAchieveAnimWrapper", 1, "startAnim done anim");
        } else {
            this.D = true;
            QLog.d("QFSPersonalRankAchieveAnimWrapper", 1, "startAnim");
            RFWThreadManager.getUIHandler().removeCallbacks(this.H);
            RFWThreadManager.getUIHandler().postDelayed(this.H, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements QQAnimationDrawable.QQAnimationListener {
        a() {
        }

        @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
        public void onStart() {
            if (QFSPersonalRankAchieveAnimWrapper.this.f89395f != null) {
                QFSPersonalRankAchieveAnimWrapper.this.f89395f.setVisibility(0);
            }
            QFSPersonalRankAchieveAnimWrapper.this.y();
            QFSPersonalRankAchieveAnimWrapper.this.E = true;
        }

        @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
        public void onStop() {
            QLog.d("QFSPersonalRankAchieveAnimWrapper", 1, "achieveAnim stop");
            QFSPersonalRankAchieveAnimWrapper.this.v();
            QFSPersonalRankAchieveAnimWrapper.this.D = false;
        }

        @Override // com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener
        public void onPlay(int i3) {
        }
    }
}

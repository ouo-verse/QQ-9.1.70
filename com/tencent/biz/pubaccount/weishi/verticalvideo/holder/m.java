package com.tencent.biz.pubaccount.weishi.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.pubaccount.weishi.comment.WsCommentPresenter;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.vas.ui.VasPagImageView;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.libpag.PAGFile;
import org.libpag.PAGImageView;

/* compiled from: P */
/* loaded from: classes32.dex */
public class m extends com.tencent.biz.pubaccount.weishi.baseui.b<com.tencent.biz.pubaccount.weishi.verticalvideo.data.j> {
    private com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b C;
    private WSVerticalPageFragment D;
    private TextView E;
    private View F;
    private ImageView G;
    private KandianUrlImageView H;
    private VasPagImageView I;
    private stSimpleMetaFeed J;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            m.this.D();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            m.this.C();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            m.this.A();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            m.this.B(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class e implements Function1<PAGImageView, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PAGImageView.PAGImageViewListener f82145d;

        e(PAGImageView.PAGImageViewListener pAGImageViewListener) {
            this.f82145d = pAGImageViewListener;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(PAGImageView pAGImageView) {
            m.this.F(pAGImageView, this.f82145d);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements PAGImageView.PAGImageViewListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PAGImageView.PAGImageViewListener f82147d;

        f(PAGImageView.PAGImageViewListener pAGImageViewListener) {
            this.f82147d = pAGImageViewListener;
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationCancel(PAGImageView pAGImageView) {
            PAGImageView.PAGImageViewListener pAGImageViewListener = this.f82147d;
            if (pAGImageViewListener != null) {
                pAGImageViewListener.onAnimationCancel(pAGImageView);
            }
            pAGImageView.removeListener(this);
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationEnd(PAGImageView pAGImageView) {
            PAGImageView.PAGImageViewListener pAGImageViewListener = this.f82147d;
            if (pAGImageViewListener != null) {
                pAGImageViewListener.onAnimationEnd(pAGImageView);
            }
            pAGImageView.removeListener(this);
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationRepeat(PAGImageView pAGImageView) {
            PAGImageView.PAGImageViewListener pAGImageViewListener = this.f82147d;
            if (pAGImageViewListener != null) {
                pAGImageViewListener.onAnimationRepeat(pAGImageView);
            }
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationStart(PAGImageView pAGImageView) {
            PAGImageView.PAGImageViewListener pAGImageViewListener = this.f82147d;
            if (pAGImageViewListener != null) {
                pAGImageViewListener.onAnimationStart(pAGImageView);
            }
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationUpdate(PAGImageView pAGImageView) {
            PAGImageView.PAGImageViewListener pAGImageViewListener = this.f82147d;
            if (pAGImageViewListener != null) {
                pAGImageViewListener.onAnimationUpdate(pAGImageView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class g implements Function1<PAGImageView, Unit> {
        g() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(PAGImageView pAGImageView) {
            pAGImageView.pause();
            pAGImageView.setCurrentFrame(0);
            pAGImageView.setVisibility(8);
            return null;
        }
    }

    public m(Context context, com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b bVar) {
        super(context);
        this.C = bVar;
        au auVar = bVar.f82126m;
        if (auVar != null) {
            this.D = auVar.f82128e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(View view) {
        E();
        com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b bVar = this.C;
        if (bVar instanceof WSVerticalVideoOperationRightItemView) {
            ((WSVerticalVideoOperationRightItemView) bVar).onClick(view);
        }
        H(0, 8, z(1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(PAGImageView pAGImageView, PAGImageView.PAGImageViewListener pAGImageViewListener) {
        PAGFile Load = PagViewMonitor.Load(BaseApplicationImpl.getApplication().getResources().getAssets(), "wspag/ws_comment_at_guide.pag");
        if (Load != null) {
            pAGImageView.setVisibility(0);
            pAGImageView.setComposition(Load);
            pAGImageView.setRepeatCount(1);
            pAGImageView.addListener(new f(pAGImageViewListener));
            pAGImageView.play();
            G();
        }
    }

    private void G() {
        Map<String, String> hashMap;
        WSVerticalPageFragment wSVerticalPageFragment = this.D;
        if (wSVerticalPageFragment != null) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.g presenter = wSVerticalPageFragment.getPresenter();
            if (presenter != null) {
                hashMap = presenter.h0();
            } else {
                hashMap = new HashMap<>();
            }
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.y(this.D.getFrom(), this.D.getPlayScene(), this.J, hashMap);
        }
    }

    private void H(int i3, int i16, Map<String, String> map) {
        WsCommentPresenter wsCommentPresenter;
        WSVerticalPageFragment wSVerticalPageFragment = this.D;
        if (wSVerticalPageFragment == null || (wsCommentPresenter = wSVerticalPageFragment.f81812c0) == null) {
            return;
        }
        wsCommentPresenter.m0(com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.l(wSVerticalPageFragment.getFrom()), this.D.getPlayScene()).v0(d()).r0(this.J).t0(5).z0(i3, i16, this.D.getPlayScene(), map);
    }

    private void J() {
        if (o10.a.f421718a.h()) {
            this.H.setVisibility(0);
        } else {
            this.H.setVisibility(8);
        }
        E();
    }

    private Map<String, String> z(int i3) {
        Map<String, String> hashMap;
        com.tencent.biz.pubaccount.weishi.verticalvideo.g presenter;
        WSVerticalPageFragment wSVerticalPageFragment = this.D;
        if (wSVerticalPageFragment != null && (presenter = wSVerticalPageFragment.getPresenter()) != null) {
            hashMap = presenter.h0();
        } else {
            hashMap = new HashMap<>();
        }
        if (i3 != -1) {
            hashMap.put("btn_status", String.valueOf(i3));
        }
        return hashMap;
    }

    public void E() {
        this.I.setVisibility(8);
        this.I.api().postAction(new g());
    }

    public void I(PAGImageView.PAGImageViewListener pAGImageViewListener) {
        this.I.setVisibility(0);
        this.I.api().postAction(new e(pAGImageViewListener));
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        if (c() != null) {
            this.J = c().e();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        String d16 = iz.a.g().d();
        if (!TextUtils.isEmpty(d16)) {
            this.E.setText(d16);
        }
        J();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.d1r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        H(1, 7, z(-1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        H(0, 4, z(-1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        H(0, 8, z(0));
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.E = (TextView) p(R.id.p76);
        View p16 = p(R.id.f163261p55);
        this.F = p16;
        p16.setOnClickListener(new a());
        ImageView imageView = (ImageView) p(R.id.p4b);
        this.G = imageView;
        imageView.setOnClickListener(new b());
        KandianUrlImageView kandianUrlImageView = (KandianUrlImageView) p(R.id.p4a);
        this.H = kandianUrlImageView;
        kandianUrlImageView.setOnClickListener(new c());
        VasPagImageView vasPagImageView = (VasPagImageView) p(R.id.p5a);
        this.I = vasPagImageView;
        vasPagImageView.api().build();
        this.I.setOnClickListener(new d());
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }
}

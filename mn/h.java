package mn;

import android.animation.Animator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.LottieAnimationView;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.qzmoment.comment.QZMFeedCommentInfo;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.state.report.SquareReportConst;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.List;
import mqq.util.WeakReference;
import qzonemoment.QZMomentMeta$StLike;

/* compiled from: P */
/* loaded from: classes38.dex */
public class h extends mn.a implements View.OnClickListener {
    private c C;

    /* renamed from: e, reason: collision with root package name */
    private LottieAnimationView f417017e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f417018f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f417019h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f417020i;

    /* renamed from: m, reason: collision with root package name */
    private b f417021m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class b implements Observer<QZMFeedCommentInfo> {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<h> f417023d;

        public b(h hVar) {
            this.f417023d = new WeakReference<>(hVar);
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(QZMFeedCommentInfo qZMFeedCommentInfo) {
            h hVar = this.f417023d.get();
            if (hVar == null) {
                return;
            }
            hVar.J(qZMFeedCommentInfo.mTotalCommentCount);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class c implements Observer<bn.c> {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<h> f417024d;

        public c(h hVar) {
            this.f417024d = new WeakReference<>(hVar);
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(bn.c cVar) {
            h hVar = this.f417024d.get();
            if (hVar == null) {
                return;
            }
            hVar.K(cVar.b().likeInfo);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void A() {
        HashMap hashMap = new HashMap();
        hashMap.put("operated_feed", ((bn.b) this.mData).a().f430362id.get());
        hashMap.put("author_id", ((bn.b) this.mData).a().poster.f430367id.get());
        fo.b i3 = new fo.b().l(hashMap).i(((bn.b) this.mData).a().f430362id.get());
        fo.c.o(this.f417019h, "em_bas_comment_button", i3);
        fo.c.o(this.f417020i, "em_bas_comment_button", i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void B(QZMomentMeta$StLike qZMomentMeta$StLike) {
        HashMap hashMap = new HashMap();
        hashMap.put("operated_feed", ((bn.b) this.mData).a().f430362id.get());
        hashMap.put("author_id", ((bn.b) this.mData).a().poster.f430367id.get());
        HashMap hashMap2 = new HashMap();
        if (qZMomentMeta$StLike != null && F()) {
            hashMap2.put(SquareReportConst.Key.KEY_LIKE_PANEL_IS_LIKE, Integer.valueOf(qZMomentMeta$StLike.status.get() != 1 ? 0 : 1));
        }
        fo.b l3 = new fo.b().l(hashMap).i(((bn.b) this.mData).a().f430362id.get()).l(hashMap2);
        fo.c.o(this.f417017e, "em_bas_like_button", l3);
        fo.c.o(this.f417018f, "em_bas_like_button", l3);
    }

    private void D() {
        if (F()) {
            z();
        } else {
            H(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean F() {
        T t16 = this.mData;
        if (t16 == 0 || ((bn.b) t16).a() == null || ((bn.b) this.mData).a().poster == null) {
            return true;
        }
        return !TextUtils.equals(LoginData.getInstance().getUinString(), ((bn.b) this.mData).a().poster.f430367id.get());
    }

    private void H(boolean z16) {
        gn.d dVar = (gn.d) q(gn.d.class);
        if (dVar == null) {
            return;
        }
        dVar.J6(y(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void K(QZMomentMeta$StLike qZMomentMeta$StLike) {
        if (qZMomentMeta$StLike.count.get() == 0) {
            this.f417018f.setText(l.a(R.string.f1334869));
        } else {
            this.f417018f.setText(String.valueOf(qZMomentMeta$StLike.count.get()));
        }
        ViewGroup.LayoutParams layoutParams = this.f417017e.getLayoutParams();
        if (qZMomentMeta$StLike.status.get() == 1) {
            if (!this.f417017e.isAnimating()) {
                this.f417017e.setProgress(1.0f);
            }
            layoutParams.width = ImmersiveUtils.dpToPx(37.0f);
            layoutParams.height = ImmersiveUtils.dpToPx(36.5f);
        } else {
            this.f417017e.setProgress(0.0f);
            layoutParams.width = ImmersiveUtils.dpToPx(39.0f);
            layoutParams.height = ImmersiveUtils.dpToPx(38.5f);
        }
        this.f417017e.setLayoutParams(layoutParams);
        ((bn.b) this.mData).a().likeInfo.set(qZMomentMeta$StLike);
        B(qZMomentMeta$StLike);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private QZMFeedCommentInfo y(boolean z16) {
        QZMFeedCommentInfo qZMFeedCommentInfo = new QZMFeedCommentInfo(((bn.b) this.mData).a());
        qZMFeedCommentInfo.mIsGuest = F();
        qZMFeedCommentInfo.mIsFromHostPraise = z16;
        qZMFeedCommentInfo.mTotalCommentCount = ((bn.b) this.mData).a().commentCount.get();
        return qZMFeedCommentInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void onBindData(bn.b bVar, int i3, List<Object> list) {
        if (u()) {
            getStubView(R.id.mkg).setVisibility(8);
            return;
        }
        getStubView(R.id.mkg).setVisibility(0);
        if (bVar == null || bVar.a() == null) {
            return;
        }
        K(((bn.b) this.mData).a().likeInfo);
        J(bVar.a().commentCount.get());
        en.a.a().observerGlobalState(new QZMFeedCommentInfo(bVar.a(), bVar.a().commentCount.get()), this.f417021m);
        en.a.a().observerGlobalState(new bn.c(bVar.a().f430362id.get(), bVar.a()), this.C);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mn.a, com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZMFeedOperationPresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        switch (view.getId()) {
            case R.id.kun /* 1745224089 */:
            case R.id.nib /* 1745225650 */:
                C();
                break;
            case R.id.lbi /* 1745224118 */:
            case R.id.f162959nj4 /* 1745225679 */:
                D();
                break;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void C() {
        H(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.mkg};
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void J(int i3) {
        if (i3 == 0) {
            this.f417020i.setText(l.a(R.string.f133365x));
        } else {
            this.f417020i.setText(String.valueOf(i3));
        }
        ((bn.b) this.mData).a().commentCount.set(i3);
        A();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void z() {
        if (com.qzone.reborn.util.e.b("QZMFeedOperationPresenter", 500L)) {
            return;
        }
        gn.a aVar = (gn.a) q(gn.a.class);
        int i3 = 1;
        if (aVar == null) {
            QLog.e("QZMFeedOperationPresenter", 1, "ioc is null");
            return;
        }
        if (aVar.e8() == null) {
            QLog.e("QZMFeedOperationPresenter", 1, "do like viewmodel is null");
            return;
        }
        if (this.f417017e.isAnimating()) {
            QLog.i("QZMFeedOperationPresenter", 1, "do like isAnimating");
            return;
        }
        this.f417017e.addAnimatorListener(new a());
        if (((bn.b) this.mData).a().likeInfo.status.get() == 0) {
            this.f417017e.playAnimation();
        } else {
            i3 = 0;
        }
        aVar.e8().R1(p().hashCode(), i3, ((bn.b) this.mData).a(), ((bn.b) this.mData).a().likeInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View view) {
        this.f417017e = (LottieAnimationView) view.findViewById(R.id.lbi);
        this.f417018f = (TextView) view.findViewById(R.id.f162959nj4);
        this.f417019h = (ImageView) view.findViewById(R.id.kun);
        this.f417020i = (TextView) view.findViewById(R.id.nib);
        this.f417017e.setOnClickListener(this);
        this.f417018f.setOnClickListener(this);
        this.f417019h.setOnClickListener(this);
        this.f417020i.setOnClickListener(this);
        this.f417017e.setAnimation("feeds/RightNowlike.json");
        this.f417021m = new b(this);
        this.C = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a extends com.tencent.mobileqq.widget.f {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            h.this.f417017e.removeAnimatorListener(this);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h.this.f417017e.removeAnimatorListener(this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}

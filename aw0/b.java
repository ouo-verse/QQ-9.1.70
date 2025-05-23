package aw0;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.tencent.icgame.game.liveroom.impl.room.fansgroup.view.FansGroupGiftTipView;
import com.tencent.icgame.trpcprotocol.qlive.TrpcFansGroupOuterClass$GetFansGroupInfoRsp;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqgift.data.service.d;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import yv0.e;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private long f27026a;

    /* renamed from: b, reason: collision with root package name */
    private int f27027b;

    /* renamed from: c, reason: collision with root package name */
    private long f27028c;

    /* renamed from: d, reason: collision with root package name */
    private IQQLiveSDK f27029d;

    /* renamed from: f, reason: collision with root package name */
    private ViewGroup f27031f;

    /* renamed from: g, reason: collision with root package name */
    private FansGroupGiftTipView f27032g;

    /* renamed from: i, reason: collision with root package name */
    private TrpcFansGroupOuterClass$GetFansGroupInfoRsp f27034i;

    /* renamed from: k, reason: collision with root package name */
    private d f27036k;

    /* renamed from: e, reason: collision with root package name */
    private int f27030e = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f27033h = false;

    /* renamed from: j, reason: collision with root package name */
    private bw0.c f27035j = new bw0.c();

    /* renamed from: l, reason: collision with root package name */
    private Animator.AnimatorListener f27037l = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a implements e<TrpcFansGroupOuterClass$GetFansGroupInfoRsp> {
        a() {
        }

        @Override // yv0.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(TrpcFansGroupOuterClass$GetFansGroupInfoRsp trpcFansGroupOuterClass$GetFansGroupInfoRsp) {
            b.this.f27034i = trpcFansGroupOuterClass$GetFansGroupInfoRsp;
            rt0.a.f("ICGameGift|ICGameGiftFansGroup", "fetchFansGroupInfo.getFansGroupInfo.success", "data.group_info=" + aw0.a.f(trpcFansGroupOuterClass$GetFansGroupInfoRsp));
            if (b.this.f27034i != null && b.this.f27036k != null) {
                b bVar = b.this;
                bVar.q(bVar.f27036k, b.this.f27034i);
            }
        }

        @Override // yv0.e
        public void fail(int i3, String str) {
            rt0.a.f("ICGameGift|ICGameGiftFansGroup", "fetchFansGroupInfo.getFansGroupInfo.fail", "code=" + i3 + ",msg=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: aw0.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0074b implements ValueAnimator.AnimatorUpdateListener {
        C0074b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.this.f27032g.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            b.this.f27032g.requestLayout();
        }
    }

    private void f() {
        IQQLiveSDK iQQLiveSDK = this.f27029d;
        if (iQQLiveSDK != null && iQQLiveSDK.getProxySsoService() != null) {
            this.f27035j.i(this.f27029d.getProxySsoService());
            this.f27035j.c(this.f27028c, new a());
        } else {
            rt0.a.c("ICGameGift|ICGameGiftFansGroup", "fetchFansGroupInfo", "mLiveSDK is null");
        }
    }

    private boolean g() {
        int childCount = this.f27031f.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (this.f27032g == this.f27031f.getChildAt(i3)) {
                return true;
            }
        }
        return false;
    }

    private boolean h(d dVar) {
        String str;
        if (!aw0.a.c(dVar)) {
            rt0.a.f("ICGameGift|ICGameGiftFansGroup", "onFansGiftCheck", "is not fansgroup gift");
            return false;
        }
        if (aw0.a.e(dVar, this.f27034i)) {
            rt0.a.f("ICGameGift|ICGameGiftFansGroup", "onFansGiftCheck", "has unlock fansgroup gift");
            return false;
        }
        rt0.a.f("ICGameGift|ICGameGiftFansGroup", "onFansGiftCheck", "giftData=" + dVar.toString());
        IQQLiveSDK iQQLiveSDK = this.f27029d;
        if (iQQLiveSDK == null || iQQLiveSDK.getAppRuntime() == null) {
            return false;
        }
        if (aw0.a.d(this.f27034i)) {
            str = "\u6682\u672a\u8fbe\u5230\u89e3\u9501\u7b49\u7ea7";
        } else {
            str = "\u8bf7\u5148\u52a0\u5165\u7c89\u4e1d\u56e2";
        }
        QQToast.makeText(this.f27029d.getAppRuntime().getApplicationContext(), str, 0).show();
        return true;
    }

    private void p(int i3, int i16, Animator.AnimatorListener animatorListener) {
        this.f27032g.clearAnimation();
        ValueAnimator duration = ValueAnimator.ofInt(i3, i16).setDuration(100L);
        duration.addUpdateListener(new C0074b());
        if (animatorListener != null) {
            duration.addListener(animatorListener);
        }
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(d dVar, TrpcFansGroupOuterClass$GetFansGroupInfoRsp trpcFansGroupOuterClass$GetFansGroupInfoRsp) {
        if (!aw0.a.d(trpcFansGroupOuterClass$GetFansGroupInfoRsp)) {
            this.f27032g.setJoinFansGroupText("\u52a0\u5165\u7c89\u4e1d\u56e2");
            this.f27032g.setFansGroupTitleText("\u52a0\u5165\u6211\u7684\u7c89\u4e1d\u56e2\uff0c\u5373\u53ef\u89e3\u9501\u9001\u793c\u7279\u6743");
            this.f27032g.g(true);
        } else {
            int a16 = aw0.a.a(dVar);
            this.f27032g.setJoinFansGroupText("\u53bb\u5347\u7ea7");
            this.f27032g.setFansGroupTitleText("\u7c89\u4e1d\u56e2" + a16 + "\u7ea7\u6210\u5458\u4e13\u5c5e\u793c\u7269");
            this.f27032g.g(aw0.a.e(dVar, trpcFansGroupOuterClass$GetFansGroupInfoRsp) ^ true);
        }
        if (!aw0.a.b(trpcFansGroupOuterClass$GetFansGroupInfoRsp)) {
            this.f27032g.g(false);
        }
        this.f27032g.f(this.f27033h);
    }

    public void i() {
        this.f27035j.g();
        this.f27026a = 0L;
        this.f27028c = 0L;
        this.f27029d = null;
    }

    public void j() {
        if (this.f27029d == null) {
            rt0.a.c("ICGameGift|ICGameGiftFansGroup", "onGiftPanelResume", "mLiveSDK is null, is not inited!");
        } else {
            f();
        }
    }

    public void k(int i3, long j3, int i16, long j16, fu0.c cVar, ViewGroup viewGroup) {
        long j17;
        String str;
        this.f27026a = j3;
        this.f27027b = i16;
        this.f27028c = j16;
        this.f27029d = cVar.f();
        IAudienceRoom N = cVar.N(j3);
        if (N != null && N.getRoomLiveInfo() != null && N.getRoomLiveInfo().anchorInfo != null) {
            j17 = N.getRoomLiveInfo().anchorInfo.uid;
            str = N.getRoomLiveInfo().anchorInfo.headUrl;
        } else {
            rt0.a.c("ICGameGift|ICGameGiftFansGroup", "onGiftPanelShow", "get uid & headUrl fail, roomId=" + j3 + ", anchorUid=" + j16);
            j17 = 0;
            str = "";
        }
        this.f27031f = viewGroup;
        FansGroupGiftTipView fansGroupGiftTipView = new FansGroupGiftTipView(viewGroup.getContext());
        this.f27032g = fansGroupGiftTipView;
        fansGroupGiftTipView.setParam(cVar.K().longValue(), j17, str);
        this.f27030e = ViewUtils.dpToPx(48.0f);
        this.f27031f.setPadding(0, 0, 0, 0);
        this.f27031f.addView(this.f27032g);
        this.f27032g.setVisibility(8);
        this.f27032g.getLayoutParams().height = 0;
        this.f27032g.requestLayout();
        f();
    }

    public boolean l(d dVar, int i3) {
        if (!aw0.a.c(dVar)) {
            rt0.a.f("ICGameGift|ICGameGiftFansGroup", "onSelectGiftItem", "is not fansgroup gift");
            if (this.f27033h && g()) {
                p(this.f27030e, 0, this.f27037l);
                this.f27032g.e(false);
                this.f27032g.f(false);
            }
            this.f27033h = false;
            return false;
        }
        rt0.a.f("ICGameGift|ICGameGiftFansGroup", "onSelectGiftItem", "giftData=" + dVar.toString());
        if (!g()) {
            this.f27032g.setVisibility(8);
            this.f27031f.removeAllViews();
            this.f27031f.addView(this.f27032g);
        }
        if (!this.f27033h) {
            this.f27033h = true;
            this.f27032g.setVisibility(0);
            p(0, this.f27030e, null);
            this.f27032g.e(true);
        }
        this.f27036k = dVar;
        q(dVar, this.f27034i);
        return true;
    }

    public boolean m(d dVar) {
        return h(dVar);
    }

    public void o(d dVar, boolean z16, int i3) {
        if (dVar == null) {
            rt0.a.c("ICGameGift|ICGameGiftFansGroup", "setFansGroupTipsEnable", "setFansGroupTipsEnable while giftServiceData is null!");
            return;
        }
        if (z16) {
            l(dVar, i3);
        } else if (this.f27033h && g()) {
            this.f27032g.setVisibility(8);
            this.f27033h = false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.f27032g.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public void n(boolean z16) {
    }
}

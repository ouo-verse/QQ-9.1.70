package ij4;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.api.IODGameManager;
import com.tencent.mobileqq.qqlive.room.giftheader.IGiftHeaderHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.gift.impl.timi.TimiGiftPanel;
import com.tencent.timi.game.liveroom.impl.room.fansgroup.view.FansGroupGiftTipView;
import com.tencent.timi.game.liveroom.impl.room.userlevel.GiftPanelUserPayLevelView;
import com.tencent.timi.game.liveroom.impl.room.userlevel.bean.UserLevelToggle;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private long f407871a;

    /* renamed from: b, reason: collision with root package name */
    private int f407872b;

    /* renamed from: c, reason: collision with root package name */
    private long f407873c;

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f407875e;

    /* renamed from: f, reason: collision with root package name */
    private FansGroupGiftTipView f407876f;

    /* renamed from: h, reason: collision with root package name */
    private nr4.d f407878h;

    /* renamed from: i, reason: collision with root package name */
    private pi2.a f407879i;

    /* renamed from: k, reason: collision with root package name */
    private com.tencent.mobileqq.qqgift.data.service.d f407881k;

    /* renamed from: l, reason: collision with root package name */
    private com.tencent.timi.game.liveroom.impl.room.userlevel.b f407882l;

    /* renamed from: d, reason: collision with root package name */
    private int f407874d = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f407877g = false;

    /* renamed from: j, reason: collision with root package name */
    private jj4.d f407880j = new jj4.d();

    /* renamed from: m, reason: collision with root package name */
    private Animator.AnimatorListener f407883m = new d();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements pi2.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f407884a;

        a(long j3) {
            this.f407884a = j3;
        }

        @Override // pi2.b
        public void a(long j3, @NonNull String str, @NonNull String str2, @NonNull HashMap<String, String> hashMap) {
            TimiGiftPanel.Companion companion = TimiGiftPanel.INSTANCE;
            companion.a(j3, str, str2);
            companion.d(hashMap);
            ((IODGameManager) QRoute.api(IODGameManager.class)).recordSelectedSendGiftUserId(this.f407884a, j3);
        }

        @Override // pi2.b
        public void closeGiftPanel() {
            TimiGiftPanel.INSTANCE.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ij4.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public class C10535b implements zi4.a<nr4.d> {
        C10535b() {
        }

        @Override // zi4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(nr4.d dVar) {
            b.this.f407878h = dVar;
            AegisLogger.i("Gift|GiftFansGroup", "fetchFansGroupInfo.getFansGroupInfo.success", "data.group_info=" + ij4.a.f(dVar));
            if (b.this.f407878h != null && b.this.f407881k != null) {
                b bVar = b.this;
                bVar.u(bVar.f407881k, b.this.f407878h);
            }
        }

        @Override // zi4.a
        public void fail(int i3, String str) {
            AegisLogger.i("Gift|GiftFansGroup", "fetchFansGroupInfo.getFansGroupInfo.fail", "code=" + i3 + ",msg=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.this.f407876f.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            b.this.f407876f.requestLayout();
        }
    }

    private void g(ViewGroup viewGroup, boolean z16) {
        if (!UserLevelToggle.INSTANCE.c()) {
            AegisLogger.e("Gift|GiftFansGroup", "addUserPayLevelView", "User pay level view is disable!");
            return;
        }
        GiftPanelUserPayLevelView giftPanelUserPayLevelView = new GiftPanelUserPayLevelView(viewGroup.getContext(), z16);
        this.f407875e.addView(giftPanelUserPayLevelView);
        if (this.f407882l == null) {
            this.f407882l = new com.tencent.timi.game.liveroom.impl.room.userlevel.b();
        }
        this.f407882l.j((Activity) viewGroup.getContext(), giftPanelUserPayLevelView);
    }

    private void h() {
        this.f407880j.m(null);
        this.f407880j.e(this.f407873c, new C10535b());
    }

    private boolean i() {
        int childCount = this.f407875e.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (this.f407876f == this.f407875e.getChildAt(i3)) {
                return true;
            }
        }
        return false;
    }

    private boolean j(com.tencent.mobileqq.qqgift.data.service.d dVar) {
        String str;
        if (!ij4.a.c(dVar)) {
            AegisLogger.i("Gift|GiftFansGroup", "onFansGiftCheck", "is not fansgroup gift");
            return false;
        }
        if (ij4.a.e(dVar, this.f407878h)) {
            AegisLogger.i("Gift|GiftFansGroup", "onFansGiftCheck", "has unlock fansgroup gift");
            return false;
        }
        AegisLogger.i("Gift|GiftFansGroup", "onFansGiftCheck", "giftData=" + dVar.toString());
        if (ij4.a.d(this.f407878h)) {
            str = "\u6682\u672a\u8fbe\u5230\u89e3\u9501\u7b49\u7ea7";
        } else {
            str = "\u8bf7\u5148\u52a0\u5165\u7c89\u4e1d\u56e2";
        }
        QQToast.makeText(BaseApplication.context, str, 0).show();
        return true;
    }

    private boolean q(com.tencent.mobileqq.qqgift.data.service.d dVar) {
        com.tencent.timi.game.liveroom.impl.room.userlevel.b bVar = this.f407882l;
        if (bVar == null) {
            return false;
        }
        bVar.i(dVar.f264878f);
        int d16 = this.f407882l.d(dVar);
        if (d16 <= 0 || this.f407882l.f(dVar)) {
            return false;
        }
        QQToast.makeText(BaseApplication.context, "\u7528\u6237\u7b49\u7ea7LV." + d16 + "\u89e3\u9501\u5f53\u524d\u793c\u7269", 0).show();
        return true;
    }

    private void s(int i3, int i16, Animator.AnimatorListener animatorListener) {
        this.f407876f.clearAnimation();
        ValueAnimator duration = ValueAnimator.ofInt(i3, i16).setDuration(100L);
        duration.addUpdateListener(new c());
        if (animatorListener != null) {
            duration.addListener(animatorListener);
        }
        duration.start();
    }

    private void t(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3) {
        com.tencent.timi.game.liveroom.impl.room.userlevel.b bVar = this.f407882l;
        if (bVar != null && i3 == -1) {
            if (dVar != null) {
                bVar.l();
                this.f407882l.m(dVar.f264878f);
            } else {
                bVar.m(0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(com.tencent.mobileqq.qqgift.data.service.d dVar, nr4.d dVar2) {
        if (!ij4.a.d(dVar2)) {
            this.f407876f.setJoinFansGroupText("\u52a0\u5165\u7c89\u4e1d\u56e2");
            this.f407876f.setFansGroupTitleText("\u52a0\u5165\u6211\u7684\u7c89\u4e1d\u56e2\uff0c\u5373\u53ef\u89e3\u9501\u9001\u793c\u7279\u6743");
            this.f407876f.g(true);
        } else {
            int a16 = ij4.a.a(dVar);
            this.f407876f.setJoinFansGroupText("\u53bb\u5347\u7ea7");
            this.f407876f.setFansGroupTitleText("\u7c89\u4e1d\u56e2" + a16 + "\u7ea7\u6210\u5458\u4e13\u5c5e\u793c\u7269");
            this.f407876f.g(ij4.a.e(dVar, dVar2) ^ true);
        }
        if (!ij4.a.b(dVar2)) {
            this.f407876f.g(false);
        }
        this.f407876f.f(this.f407877g);
    }

    public void k() {
        com.tencent.timi.game.liveroom.impl.room.userlevel.b bVar = this.f407882l;
        if (bVar != null) {
            bVar.h();
            this.f407882l = null;
        }
        this.f407880j.l();
        this.f407871a = 0L;
        this.f407873c = 0L;
    }

    public void l() {
        h();
    }

    public void m(int i3, long j3, int i16, long j16, ViewGroup viewGroup, boolean z16) {
        this.f407871a = j3;
        this.f407872b = i16;
        this.f407873c = j16;
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        long k3 = cVar.k(j3, 0);
        String e16 = cVar.e(j3, 0);
        this.f407875e = viewGroup;
        FansGroupGiftTipView fansGroupGiftTipView = new FansGroupGiftTipView(viewGroup.getContext());
        this.f407876f = fansGroupGiftTipView;
        fansGroupGiftTipView.setParam(cVar.G(), k3, e16);
        this.f407874d = ViewUtils.dpToPx(48.0f);
        a aVar = new a(j3);
        pi2.a giftHeader = ((IGiftHeaderHelper) QRoute.api(IGiftHeaderHelper.class)).getGiftHeader(viewGroup.getContext(), this.f407872b);
        this.f407879i = giftHeader;
        if (giftHeader != null) {
            giftHeader.a(aVar);
            this.f407879i.b(j3, j16);
            this.f407875e.addView(this.f407879i.getView());
        } else if (10014 == i3) {
            ((IGiftHeaderHelper) QRoute.api(IGiftHeaderHelper.class)).setHostSelectedChangeCallback(j3, i16, aVar);
        }
        g(viewGroup, z16);
        this.f407875e.setPadding(0, 0, 0, 0);
        this.f407875e.addView(this.f407876f);
        this.f407876f.setVisibility(8);
        this.f407876f.getLayoutParams().height = 0;
        this.f407876f.requestLayout();
        h();
    }

    public boolean n(com.tencent.mobileqq.qqgift.data.service.d dVar, int i3) {
        t(dVar, i3);
        if (!ij4.a.c(dVar)) {
            AegisLogger.i("Gift|GiftFansGroup", "onSelectGiftItem", "is not fansgroup gift");
            if (this.f407877g && i()) {
                s(this.f407874d, 0, this.f407883m);
                this.f407876f.e(false);
                this.f407876f.f(false);
            }
            this.f407877g = false;
            return false;
        }
        AegisLogger.i("Gift|GiftFansGroup", "onSelectGiftItem", "giftData=" + dVar.toString());
        if (!i()) {
            this.f407876f.setVisibility(8);
            com.tencent.timi.game.liveroom.impl.room.userlevel.b bVar = this.f407882l;
            if (bVar != null) {
                bVar.l();
            }
            this.f407875e.removeAllViews();
            this.f407875e.addView(this.f407876f);
        }
        if (!this.f407877g) {
            this.f407877g = true;
            this.f407876f.setVisibility(0);
            com.tencent.timi.game.liveroom.impl.room.userlevel.b bVar2 = this.f407882l;
            if (bVar2 != null) {
                bVar2.e();
            }
            s(0, this.f407874d, null);
            this.f407876f.e(true);
        }
        this.f407881k = dVar;
        u(dVar, this.f407878h);
        return true;
    }

    public boolean o(com.tencent.mobileqq.qqgift.data.service.d dVar) {
        if (!j(dVar) && !q(dVar)) {
            return false;
        }
        return true;
    }

    public void p(boolean z16) {
        com.tencent.timi.game.liveroom.impl.room.userlevel.b bVar = this.f407882l;
        if (bVar != null) {
            bVar.c(z16);
        }
    }

    public void r(com.tencent.mobileqq.qqgift.data.service.d dVar, boolean z16, int i3) {
        if (dVar == null) {
            AegisLogger.e("Gift|GiftFansGroup", "setFansGroupTipsEnable", "setFansGroupTipsEnable while giftServiceData is null!");
            return;
        }
        if (z16) {
            n(dVar, i3);
            return;
        }
        if (this.f407877g && i()) {
            this.f407876f.setVisibility(8);
            this.f407877g = false;
        }
        com.tencent.timi.game.liveroom.impl.room.userlevel.b bVar = this.f407882l;
        if (bVar != null) {
            bVar.e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.f407876f.setVisibility(8);
            if (b.this.f407882l != null) {
                b.this.f407882l.l();
            }
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
}

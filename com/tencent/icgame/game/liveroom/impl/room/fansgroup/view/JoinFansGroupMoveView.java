package com.tencent.icgame.game.liveroom.impl.room.fansgroup.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.liveroom.impl.room.follow.TGLiveFollowManager;
import com.tencent.icgame.trpcprotocol.qlive.TrpcFansGroupOuterClass$GetFansGroupInfoRsp;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.api.IQQLiveFollowStateListener;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.icgame.api.room.ILiveRoomMessage;
import com.tencent.mobileqq.icgame.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.o;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class JoinFansGroupMoveView extends FrameLayout {
    private long C;
    private String D;
    private long E;
    private bw0.c F;
    private IQQLiveSDK G;
    private ILiveRoomMessage H;
    private String I;
    private String J;
    private int K;
    private boolean L;
    private boolean M;
    private boolean N;
    private int P;
    private final Runnable Q;
    private final v22.a R;
    private IQQLiveFollowStateListener S;

    /* renamed from: d, reason: collision with root package name */
    private final RoundImageView f115233d;

    /* renamed from: e, reason: collision with root package name */
    private final IAegisLogApi f115234e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f115235f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f115236h;

    /* renamed from: i, reason: collision with root package name */
    private Context f115237i;

    /* renamed from: m, reason: collision with root package name */
    private long f115238m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class a implements yv0.e<TrpcFansGroupOuterClass$GetFansGroupInfoRsp> {
        a() {
        }

        @Override // yv0.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(TrpcFansGroupOuterClass$GetFansGroupInfoRsp trpcFansGroupOuterClass$GetFansGroupInfoRsp) {
            if (trpcFansGroupOuterClass$GetFansGroupInfoRsp.group_info.get() == null || trpcFansGroupOuterClass$GetFansGroupInfoRsp.group_info.status.get() != 2) {
                JoinFansGroupMoveView.this.f115234e.i("ICGameJoinFansGroupMoveView", 1, "checkFansGroupNoJoinAndAnim data.group_info =" + trpcFansGroupOuterClass$GetFansGroupInfoRsp.group_info);
                return;
            }
            JoinFansGroupMoveView.this.p();
        }

        @Override // yv0.e
        public void fail(int i3, String str) {
            JoinFansGroupMoveView.this.f115234e.i("ICGameJoinFansGroupMoveView", 1, "checkFansGroupNoJoinAndAnim code=" + i3 + ",msg=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!o.a()) {
                cw0.a.c(JoinFansGroupMoveView.this.f115237i, JoinFansGroupMoveView.this.C, JoinFansGroupMoveView.this.E, 2);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class d implements IQQLiveCheckFollowCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f115242a;

        d(boolean z16) {
            this.f115242a = z16;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onFail(int i3, String str) {
            JoinFansGroupMoveView.this.f115234e.e("ICGameJoinFansGroupMoveView", 1, "onEnterRoom checkFollowAnchor errCode=" + i3 + ",errMsg=" + str);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onSuccess(int i3) {
            boolean z16;
            if (i3 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            JoinFansGroupMoveView.this.f115234e.i("ICGameJoinFansGroupMoveView", 1, "checkAnchorFollowInfo  followed=" + z16 + ",isFinishSendGift=" + this.f115242a);
            if (z16) {
                if (this.f115242a) {
                    JoinFansGroupMoveView.this.q(true, 5000L);
                } else {
                    JoinFansGroupMoveView.this.q(true, r5.K);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class e implements v22.a {
        e() {
        }

        @Override // v22.a
        public void a(GiftMessage giftMessage) {
            if (giftMessage == null) {
                return;
            }
            LiveUserInfo selfUserInfo = ((fu0.c) qx0.a.b(fu0.c.class)).getSelfUserInfo();
            if (selfUserInfo == null) {
                JoinFansGroupMoveView.this.f115234e.e("ICGameJoinFansGroupMoveView", 1, "none self userInfo");
            } else if (giftMessage.sender == selfUserInfo.uid) {
                JoinFansGroupMoveView.this.f115234e.i("ICGameJoinFansGroupMoveView", 1, "receive self gift msg");
                JoinFansGroupMoveView.this.j(true);
            }
        }

        @Override // v22.a
        public void onError(int i3, String str) {
            JoinFansGroupMoveView.this.f115234e.e("ICGameJoinFansGroupMoveView", 1, "mReceiveGiftMessageListener code=" + i3 + "msg=" + str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class f implements IQQLiveFollowStateListener {
        f() {
        }

        @Override // com.tencent.mobileqq.icgame.api.IQQLiveFollowStateListener
        public void onFollowStateChange(long j3, long j16, int i3, String str) {
            long longValue = ((fu0.c) qx0.a.b(fu0.c.class)).K().longValue();
            QLog.i("ICGameJoinFansGroupMoveView", 1, "onFollowStateChange thread=" + Thread.currentThread().getName());
            if (JoinFansGroupMoveView.this.C == j16 && j3 == longValue && str.equals(String.valueOf(JoinFansGroupMoveView.this.f115238m))) {
                if (i3 == 1) {
                    JoinFansGroupMoveView.this.i();
                } else {
                    JoinFansGroupMoveView joinFansGroupMoveView = JoinFansGroupMoveView.this;
                    joinFansGroupMoveView.removeCallbacks(joinFansGroupMoveView.Q);
                }
            }
        }
    }

    public JoinFansGroupMoveView(Context context) {
        this(context, null);
    }

    private void m() {
        this.F.h(this.C);
    }

    private void n() {
        TGLiveFollowManager.f115307a.r(this.S);
    }

    private void o() {
        boolean z16;
        String str;
        HashMap hashMap = new HashMap();
        if (getResources().getConfiguration().orientation == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("icgame_screen_orientation", str);
        hashMap.put("zengzhi_moduleid", "em_qqlive_joinfantuan_lead");
        ((ru0.a) qx0.a.b(ru0.a.class)).a(this, true, "", "em_qqlive_joinfantuan_lead", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z16, long j3) {
        this.f115234e.i("ICGameJoinFansGroupMoveView", 1, "startShowFansView isShow=" + z16);
        if (z16) {
            ILiveRoomMessage k3 = ((fu0.c) qx0.a.b(fu0.c.class)).k(this.f115238m);
            this.H = k3;
            if (k3 != null) {
                k3.registerReceiveGiftMessageListener(this.R);
            }
            removeCallbacks(this.Q);
            postDelayed(this.Q, j3);
            return;
        }
        removeCallbacks(this.Q);
        setVisibility(8);
    }

    private void r() {
        n();
        ILiveRoomMessage iLiveRoomMessage = this.H;
        if (iLiveRoomMessage != null) {
            iLiveRoomMessage.unRegisterReceiveGiftMessageListener(this.R);
        }
    }

    protected void i() {
        j(false);
    }

    protected void j(boolean z16) {
        if (this.M && this.L) {
            this.f115234e.i("ICGameJoinFansGroupMoveView", 1, "checkAnchorFollowInfo: isFinishSendGift==" + z16);
            IQQLiveFollowMsgService followMsgService = this.G.getFollowMsgService();
            if (followMsgService == null) {
                this.f115234e.i("ICGameJoinFansGroupMoveView", 1, "checkAnchorFollowInfo: followMsgService==null");
            } else {
                followMsgService.checkFollowAnchor(this.C, new d(z16));
            }
        }
    }

    public void k() {
        this.f115234e.i("ICGameJoinFansGroupMoveView", 1, "checkFansGroupNoJoinAndAnim ");
        this.F.c(this.C, new a());
    }

    public void l() {
        clearAnimation();
        removeCallbacks(this.Q);
        this.F.g();
        r();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l();
    }

    public void p() {
        this.f115234e.i("ICGameJoinFansGroupMoveView", 1, "startMoveAnim isMovingAnim=" + this.N);
        if (this.N) {
            return;
        }
        this.N = true;
        setVisibility(0);
        o();
        this.f115233d.setImageDrawable(URLDrawable.getDrawable(this.D));
        if (!TextUtils.isEmpty(this.J)) {
            this.f115235f.setText(this.J);
        }
        if (!TextUtils.isEmpty(this.I)) {
            this.f115236h.setText(this.I);
        }
        setOnClickListener(new b());
        clearAnimation();
        float f16 = -ScreenUtil.dip2px(232.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this, "translationX", f16, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f16).setDuration(5000L);
        duration.addListener(new c());
        duration.start();
        m();
        this.L = false;
    }

    public JoinFansGroupMoveView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public JoinFansGroupMoveView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f115234e = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        this.F = new bw0.c();
        this.I = "";
        this.J = "";
        this.K = 60000;
        this.P = 0;
        this.Q = new Runnable() { // from class: com.tencent.icgame.game.liveroom.impl.room.fansgroup.view.JoinFansGroupMoveView.1
            @Override // java.lang.Runnable
            public void run() {
                JoinFansGroupMoveView.this.k();
            }
        };
        this.R = new e();
        this.S = new f();
        View.inflate(context, R.layout.faq, this);
        this.f115233d = (RoundImageView) findViewById(R.id.ya8);
        this.f115235f = (TextView) findViewById(R.id.ya_);
        this.f115236h = (TextView) findViewById(R.id.yad);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            JoinFansGroupMoveView joinFansGroupMoveView = JoinFansGroupMoveView.this;
            joinFansGroupMoveView.removeCallbacks(joinFansGroupMoveView.Q);
            JoinFansGroupMoveView.this.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            JoinFansGroupMoveView.this.clearAnimation();
            JoinFansGroupMoveView joinFansGroupMoveView = JoinFansGroupMoveView.this;
            joinFansGroupMoveView.removeCallbacks(joinFansGroupMoveView.Q);
            JoinFansGroupMoveView.this.setVisibility(8);
            JoinFansGroupMoveView.this.f115234e.i("ICGameJoinFansGroupMoveView", 1, "startMoveAnim onAnimationEnd");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            JoinFansGroupMoveView.this.f115234e.i("ICGameJoinFansGroupMoveView", 1, "startMoveAnim onAnimationStart");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}

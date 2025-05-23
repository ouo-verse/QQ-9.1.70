package com.tencent.mobileqq.activity;

import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.nineoldandroids.animation.ObjectAnimator;
import com.tencent.image.ApngImage;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.GestureActivityModule;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.c;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.c;
import com.tencent.mobileqq.profile.vote.VoteHelper;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ez;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.ZanBannerView;
import com.tencent.mobileqq.vas.au;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.visitors.AdComponent;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.NearbyZanAnimLayout;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.richframework.argus.node.ArgusTag;
import com.tencent.util.AnimateUtils;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.Pair;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.SimpleTextView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
@ArgusTag(testConfigKey = "Argus_Visitors_Activity", testTags = {"AUTO_PRELOAD"})
/* loaded from: classes9.dex */
public class VisitorsActivity extends IphoneTitleBarActivity implements OverScrollViewListener, DecodeTaskCompletionListener, View.OnClickListener, PraiseManager.a, SwipListView.SwipListListener, qd2.a {
    static IPatchRedirector $redirector_;
    ImageView A0;
    private SVIPObserver A1;
    ImageView B0;
    int B1;
    TextView C0;
    t C1;
    TextView D0;
    private StatusManager D1;
    TextView E0;
    private com.tencent.mobileqq.richstatus.e E1;
    TextView F0;
    private int F1;
    View G0;
    long G1;
    ImageView H0;
    CardObserver H1;
    ImageView I0;
    SparseArray<Pair<Point, Boolean>> I1;
    ImageView J0;
    l92.d J1;
    ImageView K0;
    com.tencent.mobileqq.observer.a K1;
    View L0;
    int L1;
    View M0;
    int N0;
    Runnable O0;
    TabBarView P0;
    int Q0;
    int R0;
    int S0;
    String T0;
    boolean U0;
    boolean V0;
    AlphaAnimation W0;
    AlphaAnimation X0;
    int Y0;
    IFaceDecoder Z0;

    /* renamed from: a0, reason: collision with root package name */
    protected String f177514a0;

    /* renamed from: a1, reason: collision with root package name */
    Bitmap f177515a1;

    /* renamed from: b0, reason: collision with root package name */
    TabBarView f177516b0;

    /* renamed from: b1, reason: collision with root package name */
    ViewGroup f177517b1;

    /* renamed from: c0, reason: collision with root package name */
    VoteHelper f177518c0;

    /* renamed from: c1, reason: collision with root package name */
    NearbyZanAnimLayout f177519c1;

    /* renamed from: d0, reason: collision with root package name */
    public ArrayList<CardProfile> f177520d0;

    /* renamed from: d1, reason: collision with root package name */
    public int f177521d1;

    /* renamed from: e0, reason: collision with root package name */
    SwipListView f177522e0;

    /* renamed from: e1, reason: collision with root package name */
    HashMap<String, ImageView> f177523e1;

    /* renamed from: f0, reason: collision with root package name */
    v f177524f0;

    /* renamed from: f1, reason: collision with root package name */
    long f177525f1;

    /* renamed from: g0, reason: collision with root package name */
    boolean f177526g0;

    /* renamed from: g1, reason: collision with root package name */
    volatile boolean f177527g1;

    /* renamed from: h0, reason: collision with root package name */
    private PullRefreshHeader f177528h0;

    /* renamed from: h1, reason: collision with root package name */
    protected int f177529h1;

    /* renamed from: i0, reason: collision with root package name */
    View f177530i0;

    /* renamed from: i1, reason: collision with root package name */
    public CardHandler f177531i1;

    /* renamed from: j0, reason: collision with root package name */
    long f177532j0;

    /* renamed from: j1, reason: collision with root package name */
    boolean f177533j1;

    /* renamed from: k0, reason: collision with root package name */
    int f177534k0;

    /* renamed from: k1, reason: collision with root package name */
    public l92.a f177535k1;

    /* renamed from: l0, reason: collision with root package name */
    v f177536l0;

    /* renamed from: l1, reason: collision with root package name */
    String f177537l1;

    /* renamed from: m0, reason: collision with root package name */
    public ArrayList<CardProfile> f177538m0;

    /* renamed from: m1, reason: collision with root package name */
    com.tencent.mobileqq.hotchat.ui.c f177539m1;

    /* renamed from: n0, reason: collision with root package name */
    boolean f177540n0;

    /* renamed from: n1, reason: collision with root package name */
    long f177541n1;

    /* renamed from: o0, reason: collision with root package name */
    View f177542o0;

    /* renamed from: o1, reason: collision with root package name */
    public Random f177543o1;

    /* renamed from: p0, reason: collision with root package name */
    long f177544p0;

    /* renamed from: p1, reason: collision with root package name */
    public boolean f177545p1;

    /* renamed from: q0, reason: collision with root package name */
    int f177546q0;

    /* renamed from: q1, reason: collision with root package name */
    private int f177547q1;

    /* renamed from: r0, reason: collision with root package name */
    LocalRedTouchManager f177548r0;

    /* renamed from: r1, reason: collision with root package name */
    private boolean f177549r1;

    /* renamed from: s0, reason: collision with root package name */
    com.tencent.mobileqq.app.bk f177550s0;

    /* renamed from: s1, reason: collision with root package name */
    ObjectAnimator f177551s1;

    /* renamed from: t0, reason: collision with root package name */
    boolean f177552t0;

    /* renamed from: t1, reason: collision with root package name */
    Handler.Callback f177553t1;

    /* renamed from: u0, reason: collision with root package name */
    boolean f177554u0;

    /* renamed from: u1, reason: collision with root package name */
    MqqWeakReferenceHandler f177555u1;

    /* renamed from: v0, reason: collision with root package name */
    boolean f177556v0;

    /* renamed from: v1, reason: collision with root package name */
    TabBarView.d f177557v1;

    /* renamed from: w0, reason: collision with root package name */
    ViewGroup f177558w0;

    /* renamed from: w1, reason: collision with root package name */
    private final boolean f177559w1;

    /* renamed from: x0, reason: collision with root package name */
    RelativeLayout f177560x0;

    /* renamed from: x1, reason: collision with root package name */
    private final boolean f177561x1;

    /* renamed from: y0, reason: collision with root package name */
    View f177562y0;

    /* renamed from: y1, reason: collision with root package name */
    private AtomicBoolean f177563y1;

    /* renamed from: z0, reason: collision with root package name */
    ZanBannerView f177564z0;

    /* renamed from: z1, reason: collision with root package name */
    private AtomicBoolean f177565z1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CardProfile f177570d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.profile.like.d f177571e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f177572f;

        a(CardProfile cardProfile, com.tencent.mobileqq.profile.like.d dVar, int i3) {
            this.f177570d = cardProfile;
            this.f177571e = dVar;
            this.f177572f = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, VisitorsActivity.this, cardProfile, dVar, Integer.valueOf(i3));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i3;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                CardProfile cardProfile = this.f177570d;
                int i16 = cardProfile.type;
                if (i16 == 3) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                int i17 = i3;
                short s16 = cardProfile.bIsLastVoteCharged;
                if (i16 == 3) {
                    s16 = ((com.tencent.mobileqq.nearby.c) VisitorsActivity.this.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER)).d(this.f177570d.lEctID);
                }
                VisitorsActivity.this.N2(this.f177571e, this.f177572f, this.f177570d.bVoteCnt, s16);
                ReportController.o(VisitorsActivity.this.app, "CliOper", "", String.valueOf(this.f177570d.lEctID), "like_mall", "like_list_view", i17, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements com.tencent.mobileqq.richstatus.e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.richstatus.e
        public void onGetIcon(int i3, int i16, Bitmap bitmap) {
            int i17;
            TextView textView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), bitmap);
                return;
            }
            if (bitmap != null && i16 == 200) {
                SwipListView swipListView = VisitorsActivity.this.f177522e0;
                if (swipListView != null) {
                    i17 = swipListView.getChildCount();
                } else {
                    i17 = 0;
                }
                for (int i18 = 0; i18 < i17; i18++) {
                    Object tag = swipListView.getChildAt(i18).getTag();
                    if (tag != null && (tag instanceof s)) {
                        s sVar = (s) tag;
                        if (sVar.f177606n == i3 && (textView = sVar.f177600h) != null) {
                            VisitorsActivity.this.u3(textView, i3);
                        }
                    }
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c extends CardObserver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onFavoritorsList(boolean z16, String str, ArrayList<CardProfile> arrayList, long j3, long j16, byte[] bArr, Card card) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, arrayList, Long.valueOf(j3), Long.valueOf(j16), bArr, card);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VisitorsActivity", 2, "onFavoritorsList.isSuccess=" + z16 + ";uin=" + str + ";startMid=" + j3 + ";nextMid=" + j16);
                if (arrayList != null) {
                    QLog.d("VisitorsActivity", 2, "onFavoritorsList.voters.size=" + arrayList.size());
                }
            }
            if (!VisitorsActivity.this.app.getCurrentAccountUin().equals(str)) {
                return;
            }
            if (z16) {
                VisitorsActivity visitorsActivity = VisitorsActivity.this;
                ArrayList<CardProfile> arrayList2 = visitorsActivity.f177538m0;
                if (visitorsActivity.f177540n0) {
                    arrayList2 = new ArrayList<>();
                }
                VisitorsActivity visitorsActivity2 = VisitorsActivity.this;
                visitorsActivity2.f177544p0 = j16;
                v vVar = visitorsActivity2.f177536l0;
                if (j16 == -1) {
                    z17 = false;
                }
                vVar.k(z17);
                if (arrayList != null) {
                    arrayList2 = com.tencent.mobileqq.service.lbs.b.a(arrayList2, arrayList);
                }
                VisitorsActivity.this.e3(arrayList2, j3);
                return;
            }
            VisitorsActivity.this.f3();
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetPartakeLikeRankingList(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (QLog.isDebugVersion()) {
                QLog.d("VisitorsActivity", 2, "onGetPartakeLikeRankingList.isSuccess=" + z16 + ";isOn=" + z17);
            }
            if (z16) {
                VisitorsActivity.this.n3(z17);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onReqDelVoteRecord(boolean z16, long j3, long j16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("VisitorsActivity", 2, String.format("onReqDelVoteRecord selfUin:%s targetUin:%d type:%d", Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3)));
            }
            if (j3 == Long.parseLong(VisitorsActivity.this.app.getCurrentAccountUin()) && !z16) {
                VisitorsActivity.this.showToast(1, HardCodeUtil.qqStr(R.string.vhv));
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onReqFavoriteResult(boolean z16, String str, String str2, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (!str.equals(VisitorsActivity.this.app.getCurrentAccountUin())) {
                return;
            }
            if (i16 == 1) {
                if (!z16) {
                    VisitorsActivity.this.f177518c0.i(str2, i3, true);
                    return;
                } else {
                    VisitorsActivity.this.f177518c0.j(str2, i3, true);
                    return;
                }
            }
            if (i16 == 0) {
                VisitorsActivity.this.f177518c0.p(Long.parseLong(str2));
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetPartakeLikeRankingList(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VisitorsActivity", 2, "onSetPartakeLikeRankingList.isSuccess=" + z16 + ";isOn=" + z17);
            }
            if (z16) {
                VisitorsActivity.this.n3(z17);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onVoterList(boolean z16, String str, ArrayList<CardProfile> arrayList, ArrayList<Long> arrayList2, int i3, int i16, int i17, int i18, int i19, long j3, long j16, byte[] bArr, Card card) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, arrayList, arrayList2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Long.valueOf(j3), Long.valueOf(j16), bArr, card);
                return;
            }
            if (QLog.isDebugVersion()) {
                QLog.d("VisitorsActivity", 2, "onVoterList.isSuccess=" + z16 + ";uin=" + str + ";startMid=" + j3 + ";nextMid=" + j16 + "todayVoteCount=" + i17 + "todayVoteRank=" + i18 + "totalVoteCount=" + i19);
                if (arrayList != null) {
                    QLog.d("VisitorsActivity", 2, "onVoterList.voters.size=" + arrayList.size());
                }
            }
            if (VisitorsActivity.this.app.getCurrentAccountUin().equals(str)) {
                if (z16) {
                    VisitorsActivity.this.f177518c0.g(arrayList2, i3, i16, j3);
                    VisitorsActivity visitorsActivity = VisitorsActivity.this;
                    ArrayList<CardProfile> arrayList3 = visitorsActivity.f177520d0;
                    if (visitorsActivity.f177526g0) {
                        QQMessageFacade messageFacade = visitorsActivity.app.getMessageFacade();
                        String str2 = AppConstants.VOTE_MSG_UIN;
                        messageFacade.O0(str2, 1001);
                        VisitorsActivity.this.app.getMessageFacade().O0(str2, 10002);
                        arrayList3 = new ArrayList<>();
                    }
                    VisitorsActivity visitorsActivity2 = VisitorsActivity.this;
                    visitorsActivity2.f177532j0 = j16;
                    visitorsActivity2.f177524f0.k(j16 != -1);
                    if (arrayList != null) {
                        arrayList3 = com.tencent.mobileqq.service.lbs.b.a(arrayList3, arrayList);
                    }
                    VisitorsActivity.this.h3(arrayList3, j3);
                    VisitorsActivity.this.y3(i17, i18, i19);
                    return;
                }
                VisitorsActivity.this.g3();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class d extends l92.d {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this);
            }
        }

        @Override // l92.d
        public void e(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str);
                return;
            }
            if (z16 && TextUtils.equals("0", str)) {
                v vVar = VisitorsActivity.this.f177524f0;
                if (vVar != null) {
                    vVar.notifyDataSetChanged();
                }
                v vVar2 = VisitorsActivity.this.f177536l0;
                if (vVar2 != null) {
                    vVar2.notifyDataSetChanged();
                }
            }
        }

        @Override // l92.d
        public void m(boolean z16, String str, String str2, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (!str.equals(VisitorsActivity.this.app.getCurrentAccountUin())) {
                return;
            }
            if (i16 == 1) {
                if (!z16) {
                    VisitorsActivity.this.f177518c0.i(str2, i3, false);
                    return;
                } else {
                    VisitorsActivity.this.f177518c0.j(str2, i3, false);
                    return;
                }
            }
            if (i16 == 0) {
                VisitorsActivity.this.f177518c0.p(Long.parseLong(str2));
            }
        }

        @Override // l92.d
        public void n(boolean z16, ArrayList<Object> arrayList, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), arrayList, Integer.valueOf(i3));
                return;
            }
            if (z16 && arrayList != null) {
                try {
                    if (arrayList.size() > 0) {
                        Iterator<Object> it = arrayList.iterator();
                        while (it.hasNext()) {
                            c.b bVar = (c.b) it.next();
                            if (i3 == 511) {
                                if (bVar.f252558a == 0) {
                                    VisitorsActivity.this.f177518c0.j(bVar.f252560c + "", bVar.f252561d + bVar.f252562e, false);
                                }
                            } else if (bVar.f252558a == 0) {
                                VisitorsActivity.this.f177518c0.p(bVar.f252560c);
                            }
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class e extends com.tencent.mobileqq.observer.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.observer.a, mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            } else {
                VisitorsActivity.this.z3();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements ez.f<Integer> {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.utils.ez.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.tencent.mobileqq.utils.ez<Integer> ezVar, float f16, Integer num, Transformation transformation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, ezVar, Float.valueOf(f16), num, transformation);
                return;
            }
            VisitorsActivity.this.E0.setText(num + "");
            if (num.intValue() > 9999) {
                VisitorsActivity.this.E0.setTextSize(36.0f);
            } else {
                VisitorsActivity.this.E0.setTextSize(44.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g extends AnimateUtils.AnimationAdapter {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this);
            }
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                VisitorsActivity.this.U0 = false;
            }
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                VisitorsActivity.this.H0.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h extends AnimateUtils.AnimationAdapter {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this);
            }
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                VisitorsActivity.this.I0.setVisibility(0);
                VisitorsActivity.this.f177558w0.setClipChildren(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i extends AnimateUtils.AnimationAdapter {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this);
            }
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                VisitorsActivity.this.J0.setVisibility(0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class j implements Handler.Callback {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            Object[] objArr;
            View childAt;
            TextView textView;
            int length;
            Bitmap bitmap;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            boolean z16 = true;
            switch (message.what) {
                case 1:
                    VisitorsActivity.this.f177522e0.springBackOverScrollHeaderView();
                    return false;
                case 2:
                    VisitorsActivity.this.stopTitleProgress();
                    VisitorsActivity.this.f177522e0.springBackOverScrollHeaderView();
                    VisitorsActivity.this.f177522e0.springBackOverScrollHeaderView();
                    VisitorsActivity visitorsActivity = VisitorsActivity.this;
                    visitorsActivity.showToast(1, visitorsActivity.getString(R.string.f171139ci4));
                    return false;
                case 3:
                    VisitorsActivity visitorsActivity2 = VisitorsActivity.this;
                    if (visitorsActivity2.f177521d1 == 0) {
                        visitorsActivity2.f177524f0.notifyDataSetChanged();
                    } else {
                        visitorsActivity2.f177536l0.notifyDataSetChanged();
                    }
                    VisitorsActivity.this.G1 = SystemClock.uptimeMillis();
                    return false;
                case 4:
                    VisitorsActivity.this.f177522e0.springBackOverScrollHeaderView();
                    return false;
                case 5:
                    Object obj = message.obj;
                    if (obj instanceof Object[]) {
                        Object[] objArr2 = (Object[]) obj;
                        ArrayList arrayList = (ArrayList) objArr2[0];
                        ArrayList arrayList2 = (ArrayList) objArr2[1];
                        VisitorsActivity.this.f177520d0.addAll(arrayList);
                        VisitorsActivity.this.f177538m0.addAll(arrayList2);
                        if (QLog.isDebugVersion()) {
                            QLog.d("VisitorsActivity", 2, "setDataSet visitor UI_ONINIT");
                        }
                        VisitorsActivity visitorsActivity3 = VisitorsActivity.this;
                        visitorsActivity3.f177524f0.j(visitorsActivity3.f177520d0);
                        if (QLog.isDebugVersion()) {
                            QLog.d("VisitorsActivity", 2, "setDataSet favor UI_ONINIT");
                        }
                        VisitorsActivity visitorsActivity4 = VisitorsActivity.this;
                        visitorsActivity4.f177536l0.j(visitorsActivity4.f177538m0);
                        VisitorsActivity.this.f177524f0.notifyDataSetChanged();
                        VisitorsActivity.this.f177536l0.notifyDataSetChanged();
                    }
                    VisitorsActivity.this.f177527g1 = true;
                    if (!NetworkUtil.isNetSupport(VisitorsActivity.this)) {
                        VisitorsActivity.this.f177555u1.sendEmptyMessageDelayed(2, 1000L);
                        return false;
                    }
                    VisitorsActivity.this.C3(true);
                    return false;
                case 6:
                    VisitorsActivity.this.f177518c0.l();
                    return false;
                case 7:
                    if (QLog.isDebugVersion()) {
                        QLog.d("VisitorsActivity", 2, "setDataSet fresh fav data");
                    }
                    VisitorsActivity visitorsActivity5 = VisitorsActivity.this;
                    visitorsActivity5.f177536l0.j(visitorsActivity5.f177538m0);
                    VisitorsActivity.this.f177536l0.notifyDataSetChanged();
                    return false;
                case 8:
                    if (QLog.isDebugVersion()) {
                        QLog.d("VisitorsActivity", 2, "setDataSet fresh fav data");
                    }
                    VisitorsActivity visitorsActivity6 = VisitorsActivity.this;
                    visitorsActivity6.f177524f0.j(visitorsActivity6.f177520d0);
                    VisitorsActivity.this.f177524f0.notifyDataSetChanged();
                    return false;
                case 9:
                    VisitorsActivity.this.f177518c0.q((CardProfile) message.obj);
                    return false;
                case 10:
                    VisitorsActivity.this.r3(false, message.arg1, message.arg2, message.getData().getInt("totalVoteCount"));
                    return false;
                case 11:
                    int i16 = message.arg1;
                    int i17 = message.arg2;
                    if (i16 > 20) {
                        i16 = 20;
                    }
                    if (i16 > 0 && (objArr = (Object[]) message.obj) != null && objArr.length == 2) {
                        int intValue = ((Integer) objArr[0]).intValue();
                        SwipListView swipListView = VisitorsActivity.this.f177522e0;
                        int firstVisiblePosition = swipListView.getFirstVisiblePosition();
                        int lastVisiblePosition = swipListView.getLastVisiblePosition();
                        if (intValue >= firstVisiblePosition && intValue <= lastVisiblePosition && (childAt = swipListView.getChildAt((intValue - firstVisiblePosition) + swipListView.getHeaderViewsCount())) != null && (textView = (TextView) childAt.findViewById(R.id.kcb)) != null) {
                            int[] iArr = new int[2];
                            textView.getLocationInWindow(iArr);
                            com.tencent.mobileqq.profile.like.d dVar = (com.tencent.mobileqq.profile.like.d) objArr[1];
                            if (TextUtils.isEmpty(dVar.f260235c)) {
                                length = 1;
                            } else {
                                length = dVar.f260235c.length() + 1;
                            }
                            if (!TextUtils.isEmpty(textView.getText())) {
                                i3 = 2 * textView.getText().length();
                            }
                            float width = iArr[0] + ((textView.getWidth() * length) / i3);
                            float paddingTop = (iArr[1] - VisitorsActivity.this.B1) + textView.getPaddingTop();
                            if (i17 > 0 && (bitmap = dVar.f260242j) != null) {
                                VisitorsActivity.this.f177519c1.e(dVar, bitmap, width, paddingTop);
                            } else {
                                VisitorsActivity.this.f177519c1.e(dVar, dVar.f260240h, width, paddingTop);
                            }
                            int i18 = i16 - 1;
                            if (i18 > 0) {
                                Message obtainMessage = VisitorsActivity.this.f177555u1.obtainMessage(11, i18, i17, objArr);
                                VisitorsActivity visitorsActivity7 = VisitorsActivity.this;
                                if (visitorsActivity7.f177543o1 == null) {
                                    visitorsActivity7.f177543o1 = new Random();
                                }
                                int[] iArr2 = com.tencent.mobileqq.dating.j.T;
                                VisitorsActivity.this.f177555u1.sendMessageDelayed(obtainMessage, iArr2[VisitorsActivity.this.f177543o1.nextInt(iArr2.length)] * 5);
                            } else {
                                VisitorsActivity.this.f177555u1.sendEmptyMessageDelayed(12, 2000L);
                            }
                            z16 = false;
                        }
                    }
                    if (z16) {
                        VisitorsActivity.this.f177555u1.sendEmptyMessageDelayed(12, 100L);
                    }
                    return false;
                case 12:
                    VisitorsActivity.this.f177545p1 = false;
                    return false;
                case 13:
                    VisitorsActivity.this.P2(message.arg1);
                    return false;
                default:
                    return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class k extends AnimateUtils.AnimationAdapter {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this);
            }
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            } else {
                VisitorsActivity.this.K0.setVisibility(0);
                VisitorsActivity.this.U0 = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class l extends AnimateUtils.AnimationAdapter {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this);
            }
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            VisitorsActivity visitorsActivity = VisitorsActivity.this;
            if (visitorsActivity.N0 > 0) {
                visitorsActivity.f177555u1.postDelayed(visitorsActivity.O0, 200L);
            } else {
                visitorsActivity.M0.setVisibility(4);
            }
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            r4.N0--;
            VisitorsActivity.this.M0.setVisibility(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class m implements TabBarView.d {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.TabBarView.d
        public void a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                VisitorsActivity.this.t3(i16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class n implements au.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f177586a;

        n(String str) {
            this.f177586a = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this, (Object) str);
            }
        }

        @Override // com.tencent.mobileqq.vas.au.b
        public void onLeftClick() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            VasWebviewUtil.reportCommercialDrainage(VisitorsActivity.this.app.getCurrentAccountUin(), "thumbup", "click_getit", "", 1, 0, 0, "", this.f177586a, "");
            Intent intent = new Intent(VisitorsActivity.this, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("fragmentStyle", 3);
            intent.putExtra("url", "https://m.vip.qq.com/freedom/dbzan.html?_nav_alpha=0");
            intent.putExtra("isTransparentTitle", true);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            VisitorsActivity.this.startActivity(intent);
        }

        @Override // com.tencent.mobileqq.vas.au.b
        public void onRightClick() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VisitorsActivity", 2, "ZanDoubleDialog: onRightClick: ");
            }
            VasWebviewUtil.reportCommercialDrainage(VisitorsActivity.this.app.getCurrentAccountUin(), "thumbup", "click_pay", "", 1, 0, 0, "", this.f177586a, "");
            VasH5PayUtil.openH5Pay((Context) VisitorsActivity.this, "mvip.n.a.dbzan_dbzan", "CJCLUBT", 3, false, true);
            VisitorsActivity.this.f177565z1.set(true);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class o extends SVIPObserver {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    dialogInterface.dismiss();
                }
            }
        }

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.SVIPObserver
        public void onVipStatusChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VisitorsActivity", 2, "onVipStatusChanged: ");
            }
            QQAppInterface qQAppInterface = VisitorsActivity.this.app;
            if (qQAppInterface != null && VasUtil.getSignedService(qQAppInterface).getVipStatus().isSVip()) {
                VisitorsActivity.this.C3(true);
                VisitorsActivity.this.w3(true);
                if (VisitorsActivity.this.f177563y1.compareAndSet(true, false)) {
                    if (VisitorsActivity.this.f177565z1.get()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("VisitorsActivity", 2, "onVipStatusChanged: showDialog");
                        }
                        DialogUtil.createCustomDialog(VisitorsActivity.this, 232, (String) null, HardCodeUtil.qqStr(R.string.vhz), (String) null, HardCodeUtil.qqStr(R.string.vhw), new a(), (DialogInterface.OnClickListener) null).show();
                    }
                    VisitorsActivity visitorsActivity = VisitorsActivity.this;
                    visitorsActivity.removeObserver(visitorsActivity.A1);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class p implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            VisitorsActivity.this.f177517b1.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            int[] iArr = new int[2];
            VisitorsActivity.this.f177517b1.getLocationInWindow(iArr);
            VisitorsActivity.this.B1 = iArr[1];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class q implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 3) {
                        VisitorsActivity.this.A0.setAlpha(255);
                        VisitorsActivity.this.C0.setAlpha(1.0f);
                        VisitorsActivity.this.B0.setAlpha(255);
                    }
                } else {
                    VisitorsActivity.this.A0.setAlpha(255);
                    VisitorsActivity.this.C0.setAlpha(1.0f);
                    VisitorsActivity.this.B0.setAlpha(255);
                    ReportController.o(VisitorsActivity.this.app, "dc00898", "", "", "0X8007611", "0X8007611", 0, 0, "", "", "", "");
                    com.tencent.mobileqq.profile.vote.a.b(VisitorsActivity.this, false);
                    VisitorsActivity.this.G0.setVisibility(8);
                    VisitorsActivity.this.M0.clearAnimation();
                    VisitorsActivity visitorsActivity = VisitorsActivity.this;
                    visitorsActivity.N0 = 0;
                    visitorsActivity.f177555u1.removeCallbacks(visitorsActivity.O0);
                }
            } else {
                VisitorsActivity.this.A0.setAlpha(127);
                VisitorsActivity.this.C0.setAlpha(0.5f);
                VisitorsActivity.this.B0.setAlpha(127);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class r extends AnimateUtils.AnimationAdapter {
        static IPatchRedirector $redirector_;

        r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this);
            }
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                return;
            }
            VisitorsActivity visitorsActivity = VisitorsActivity.this;
            if (animation == visitorsActivity.X0 && visitorsActivity.f177554u0) {
                visitorsActivity.centerView.setText("");
            }
            VisitorsActivity.this.centerView.clearAnimation();
        }

        @Override // com.tencent.util.AnimateUtils.AnimationAdapter, android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            VisitorsActivity visitorsActivity = VisitorsActivity.this;
            if (animation == visitorsActivity.W0) {
                visitorsActivity.centerView.setText(R.string.cgj);
                VisitorsActivity visitorsActivity2 = VisitorsActivity.this;
                visitorsActivity2.centerView.setTextColor(visitorsActivity2.getResources().getColorStateList(R.color.qui_common_text_white));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class s {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        LinearLayout f177593a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f177594b;

        /* renamed from: c, reason: collision with root package name */
        TextView f177595c;

        /* renamed from: d, reason: collision with root package name */
        ImageView f177596d;

        /* renamed from: e, reason: collision with root package name */
        TextView f177597e;

        /* renamed from: f, reason: collision with root package name */
        TextView f177598f;

        /* renamed from: g, reason: collision with root package name */
        TextView f177599g;

        /* renamed from: h, reason: collision with root package name */
        TextView f177600h;

        /* renamed from: i, reason: collision with root package name */
        TextView f177601i;

        /* renamed from: j, reason: collision with root package name */
        ImageView f177602j;

        /* renamed from: k, reason: collision with root package name */
        TextView f177603k;

        /* renamed from: l, reason: collision with root package name */
        SimpleTextView f177604l;

        /* renamed from: m, reason: collision with root package name */
        int f177605m;

        /* renamed from: n, reason: collision with root package name */
        int f177606n;

        /* renamed from: o, reason: collision with root package name */
        Object f177607o;

        s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class t implements AbsListView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        int f177608d;

        /* renamed from: e, reason: collision with root package name */
        boolean f177609e;

        t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this);
            } else {
                this.f177608d = 0;
                this.f177609e = true;
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
            int i18;
            AlphaAnimation alphaAnimation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            View childAt = absListView.getChildAt(0);
            if (childAt != null && i3 == 0) {
                if (VisitorsActivity.this.f177562y0.getVisibility() == 0) {
                    i18 = VisitorsActivity.this.f177562y0.getHeight() + 0;
                } else {
                    i18 = 0;
                }
                int i19 = (int) (i18 + (((IphoneTitleBarActivity) VisitorsActivity.this).mDensity * 77.0f));
                int i26 = i19 - VisitorsActivity.this.S0;
                int abs = Math.abs(childAt.getTop());
                if (abs > this.f177608d && abs >= i19 && VisitorsActivity.this.f177516b0.getVisibility() == 8) {
                    this.f177609e = false;
                    VisitorsActivity.this.f177516b0.setVisibility(0);
                } else if (abs < this.f177608d && abs <= i19 && VisitorsActivity.this.f177516b0.getVisibility() == 0) {
                    this.f177609e = true;
                    VisitorsActivity.this.f177516b0.setVisibility(8);
                }
                CharSequence text = VisitorsActivity.this.centerView.getText();
                if (abs > this.f177608d && abs >= i26 && "".equals(text)) {
                    alphaAnimation = VisitorsActivity.this.W0;
                } else if (abs < this.f177608d && abs <= i26 && VisitorsActivity.this.T0.equals(text)) {
                    alphaAnimation = VisitorsActivity.this.X0;
                } else {
                    alphaAnimation = null;
                }
                if (alphaAnimation != null && alphaAnimation != VisitorsActivity.this.centerView.getAnimation()) {
                    alphaAnimation.reset();
                    VisitorsActivity visitorsActivity = VisitorsActivity.this;
                    if (visitorsActivity.f177554u0) {
                        visitorsActivity.centerView.startAnimation(alphaAnimation);
                    }
                }
                this.f177608d = abs;
                return;
            }
            if (i3 > 0) {
                this.f177609e = false;
                VisitorsActivity.this.f177516b0.setVisibility(0);
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            View currentFocus;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) absListView, i3);
            } else if (VersionUtils.isOreo() && (currentFocus = VisitorsActivity.this.getCurrentFocus()) != null) {
                currentFocus.clearFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class u {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        TextView f177611a;

        /* renamed from: b, reason: collision with root package name */
        ProgressBar f177612b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f177613c;

        u() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class v extends BaseAdapter {
        static IPatchRedirector $redirector_;
        public String C;
        LayoutInflater D;
        private int E;
        private int F;
        boolean G;
        int H;
        int I;
        int J;
        int K;
        protected com.tencent.mobileqq.nearby.c L;

        /* renamed from: d, reason: collision with root package name */
        qd2.a f177614d;

        /* renamed from: e, reason: collision with root package name */
        List<CardProfile> f177615e;

        /* renamed from: f, reason: collision with root package name */
        private int f177616f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f177617h;

        /* renamed from: i, reason: collision with root package name */
        boolean f177618i;

        /* renamed from: m, reason: collision with root package name */
        public int f177619m;

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class a implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) v.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    v.this.f177614d.Y0(view.getTag());
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes9.dex */
        class b implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) v.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    v.this.f177614d.Y0(view.getTag());
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class c implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ s f177622d;

            c(s sVar) {
                this.f177622d = sVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) v.this, (Object) sVar);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    v.this.f177614d.Z0(this.f177622d);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        public v(Context context, QQAppInterface qQAppInterface, qd2.a aVar, int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, VisitorsActivity.this, context, qQAppInterface, aVar, Integer.valueOf(i3), Boolean.valueOf(z16));
                return;
            }
            this.f177615e = new ArrayList();
            this.f177616f = 0;
            this.f177617h = false;
            this.f177619m = 0;
            Resources resources = VisitorsActivity.this.getResources();
            this.E = BaseAIOUtils.f(17.0f, resources);
            this.F = BaseAIOUtils.f(15.0f, resources);
            this.f177614d = aVar;
            this.f177616f = i3;
            this.G = z16;
            this.H = BaseAIOUtils.f(38.0f, resources);
            this.I = BaseAIOUtils.f(86.0f, resources);
            this.J = BaseAIOUtils.f(60.0f, resources);
            this.L = (com.tencent.mobileqq.nearby.c) VisitorsActivity.this.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER);
        }

        private View b(ViewGroup viewGroup) {
            View inflate = VisitorsActivity.this.getLayoutInflater().inflate(R.layout.f168250q4, viewGroup, false);
            s sVar = new s();
            sVar.f177593a = (LinearLayout) inflate.findViewById(R.id.jun);
            sVar.f177594b = (ImageView) inflate.findViewById(R.id.icon);
            sVar.f177596d = (ImageView) inflate.findViewById(R.id.kyw);
            sVar.f177595c = (TextView) inflate.findViewById(R.id.text1);
            sVar.f177598f = (TextView) inflate.findViewById(R.id.l6b);
            sVar.f177597e = (TextView) inflate.findViewById(R.id.lastMsgTime);
            sVar.f177599g = (TextView) inflate.findViewById(R.id.kcb);
            sVar.f177600h = (TextView) inflate.findViewById(R.id.ben);
            sVar.f177601i = (TextView) inflate.findViewById(R.id.kce);
            sVar.f177602j = (ImageView) inflate.findViewById(R.id.dyw);
            sVar.f177603k = (TextView) inflate.findViewById(R.id.f165293co3);
            SimpleTextView simpleTextView = (SimpleTextView) inflate.findViewById(R.id.ajn);
            sVar.f177604l = simpleTextView;
            simpleTextView.setGravity(17);
            sVar.f177604l.setText(VisitorsActivity.this.getString(R.string.bbl));
            sVar.f177604l.setTextSize(1, 16.0f);
            sVar.f177604l.setTextColor(-1);
            sVar.f177604l.setOnClickListener(new c(sVar));
            inflate.findViewById(R.id.b8q).getLayoutParams().width = VisitorsActivity.this.f177547q1;
            inflate.setTag(sVar);
            return inflate;
        }

        private View c() {
            View inflate = VisitorsActivity.this.getLayoutInflater().inflate(R.layout.f168308si, (ViewGroup) null);
            u uVar = new u();
            uVar.f177611a = (TextView) inflate.findViewById(R.id.f0v);
            uVar.f177612b = (ProgressBar) inflate.findViewById(R.id.i5n);
            uVar.f177613c = (ImageView) inflate.findViewById(R.id.eex);
            inflate.setTag(uVar);
            return inflate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(Object obj, s sVar) {
            int i3;
            if (obj == null) {
                return;
            }
            CardProfile cardProfile = (CardProfile) obj;
            String valueOf = String.valueOf(cardProfile.lEctID);
            sVar.f177607o = cardProfile;
            sVar.f177595c.setText(StringUtil.trim(String.valueOf(cardProfile.strNick)));
            byte b16 = cardProfile.bAage;
            if (b16 > 0) {
                sVar.f177597e.setText(String.valueOf((int) b16));
            } else {
                sVar.f177597e.setText("");
            }
            TextView textView = sVar.f177597e;
            if (cardProfile.bSex == 1) {
                i3 = R.drawable.f160892cs3;
            } else {
                i3 = R.drawable.cs8;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(i3, 0, 0, 0);
            if (cardProfile.bSex == 1) {
                sVar.f177597e.setBackgroundResource(R.drawable.af9);
            } else {
                sVar.f177597e.setBackgroundResource(R.drawable.af_);
            }
            byte b17 = cardProfile.bConstellation;
            if (b17 != 0 && b17 <= 12) {
                sVar.f177598f.setText(ProfileCardUtil.D(b17));
                sVar.f177598f.setBackgroundResource(R.drawable.afa);
                sVar.f177598f.setVisibility(0);
            } else {
                sVar.f177598f.setVisibility(8);
            }
            sVar.f177602j.setTag(cardProfile);
            int Y2 = VisitorsActivity.this.Y2(cardProfile, valueOf);
            if (Y2 != 0 && Y2 != 2) {
                sVar.f177602j.setVisibility(8);
            } else {
                sVar.f177602j.setVisibility(0);
                if (cardProfile.bTodayVotedCnt > 0) {
                    if (this.L.d(cardProfile.lEctID)) {
                        if (cardProfile.bAvailableCnt <= 0) {
                            sVar.f177602j.setImageResource(R.drawable.dkt);
                        } else {
                            sVar.f177602j.setImageResource(R.drawable.dku);
                        }
                    } else if (cardProfile.bAvailableCnt <= 0) {
                        sVar.f177602j.setImageResource(R.drawable.f5a);
                    } else {
                        sVar.f177602j.setImageResource(R.drawable.f5h);
                    }
                } else {
                    sVar.f177602j.setImageResource(R.drawable.f58);
                }
                sVar.f177602j.setOnClickListener(VisitorsActivity.this);
            }
            f(sVar, cardProfile);
            if (!TextUtils.isEmpty(cardProfile.strTime)) {
                sVar.f177601i.setText(cardProfile.strTime);
                sVar.f177601i.setVisibility(0);
            } else {
                sVar.f177601i.setVisibility(8);
            }
            VisitorsActivity.B3(cardProfile.stVipInfo, sVar.f177596d, sVar.f177595c);
            if (cardProfile.isFriend) {
                sVar.f177603k.setVisibility(0);
            } else {
                sVar.f177603k.setVisibility(8);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) sVar.f177600h.getLayoutParams();
            if (sVar.f177597e.getVisibility() == 0) {
                layoutParams.addRule(3, sVar.f177597e.getId());
            } else if (sVar.f177598f.getVisibility() == 0) {
                layoutParams.addRule(3, sVar.f177598f.getId());
            } else {
                layoutParams.addRule(3, sVar.f177593a.getId());
            }
            sVar.f177600h.setLayoutParams(layoutParams);
            VisitorsActivity.this.f177523e1.put(valueOf, sVar.f177594b);
            VisitorsActivity.this.S2(valueOf, cardProfile.uSource, cardProfile.wFace, sVar.f177594b, cardProfile);
        }

        private void e(u uVar) {
            int i3;
            int i16;
            TextView textView = uVar.f177611a;
            if (this.f177618i) {
                i3 = R.string.c5s;
            } else {
                i3 = R.string.cat;
            }
            textView.setText(i3);
            ProgressBar progressBar = uVar.f177612b;
            int i17 = 0;
            if (this.f177618i) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            progressBar.setVisibility(i16);
            ImageView imageView = uVar.f177613c;
            if (this.f177618i) {
                i17 = 8;
            }
            imageView.setVisibility(i17);
        }

        private void f(s sVar, CardProfile cardProfile) {
            int i3;
            TextView textView = sVar.f177600h;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            if (sVar.f177597e.getVisibility() == 0) {
                layoutParams.addRule(3, sVar.f177597e.getId());
            } else if (sVar.f177598f.getVisibility() == 0) {
                layoutParams.addRule(3, sVar.f177598f.getId());
            } else {
                layoutParams.addRule(3, sVar.f177595c.getId());
            }
            textView.setLayoutParams(layoutParams);
            CharSequence T2 = VisitorsActivity.this.T2(cardProfile, sVar.f177599g, false, ((Integer) sVar.f177602j.getTag(R.id.dyw)).intValue());
            if (cardProfile.payVoteCount > 0) {
                sVar.f177606n = 0;
                sVar.f177599g.setText(TextUtils.concat(T2, "\uff0c"));
                Object[] objArr = new Object[2];
                if (this.f177616f == 0) {
                    i3 = R.string.f172917vi4;
                } else {
                    i3 = R.string.vi5;
                }
                objArr[0] = HardCodeUtil.qqStr(i3);
                objArr[1] = Integer.valueOf(cardProfile.payVoteCount * 2);
                textView.setText(String.format("%s%d\u91d1\u8c46", objArr));
                textView.setVisibility(0);
                return;
            }
            sVar.f177606n = 0;
            textView.setVisibility(8);
            sVar.f177599g.setText(T2);
        }

        private void h() {
            View view;
            if (VisitorsActivity.this.f177534k0 == 0) {
                Rect rect = new Rect();
                View view2 = VisitorsActivity.this.f177562y0;
                if (view2 != null && view2.getVisibility() == 0) {
                    view = VisitorsActivity.this.f177562y0;
                } else {
                    view = VisitorsActivity.this.f177516b0;
                }
                view.getGlobalVisibleRect(rect);
                int i3 = rect.bottom;
                int i16 = VisitorsActivity.this.getResources().getDisplayMetrics().heightPixels;
                if (QLog.isDebugVersion()) {
                    QLog.d("VisitorsActivity", 2, "init empty h " + VisitorsActivity.this.f177534k0);
                }
                VisitorsActivity visitorsActivity = VisitorsActivity.this;
                visitorsActivity.f177534k0 = (i16 - i3) - BaseAIOUtils.f(75.0f, visitorsActivity.getResources());
            }
        }

        private void l(ArrayList<CardProfile> arrayList) {
            ArrayList<Long> arrayList2 = new ArrayList<>();
            Iterator<CardProfile> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(Long.valueOf(it.next().lEctID));
            }
            HashMap hashMap = new HashMap();
            com.tencent.qqnt.kernel.api.y f16 = com.tencent.qqnt.msg.f.f();
            if (f16 != null) {
                try {
                    hashMap.putAll(f16.getUidByUin("VisitorsActivity", arrayList2));
                } catch (Exception e16) {
                    QLog.i("VisitorsActivity", 1, "checkProfileIsFriend fail " + e16);
                }
            }
            Map<String, Boolean> isFriends = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriends("VisitorsActivity", new ArrayList<>(hashMap.values()));
            StringBuilder sb5 = new StringBuilder();
            Iterator<CardProfile> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                CardProfile next = it5.next();
                boolean z16 = false;
                next.isFriend = false;
                String str = (String) hashMap.get(Long.valueOf(next.lEctID));
                if (!TextUtils.isEmpty(str)) {
                    Boolean bool = isFriends.get(str);
                    if (bool != null && bool.booleanValue()) {
                        z16 = true;
                    }
                    next.isFriend = z16;
                    sb5.append("uin ");
                    sb5.append(next.lEctID);
                    sb5.append(" isFirend ");
                    sb5.append(next.isFriend);
                    sb5.append(" ");
                }
            }
            QLog.i("VisitorsActivity", 1, "updateProfileIsFriend " + ((Object) sb5));
        }

        @Override // android.widget.Adapter
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public CardProfile getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (CardProfile) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            if (i3 < this.f177615e.size()) {
                return this.f177615e.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.f177615e.size() + 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, i3)).longValue();
            }
            if (i3 > this.f177615e.size() - 1) {
                return -1L;
            }
            return this.f177615e.get(i3).lEctID;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, i3)).intValue();
            }
            if (i3 > this.f177615e.size() - 1) {
                if (this.f177615e.size() == 0) {
                    int i16 = this.f177616f;
                    if (i16 == 0) {
                        return 3;
                    }
                    if (i16 == 1) {
                        return 4;
                    }
                } else {
                    if (this.f177617h) {
                        return 1;
                    }
                    return 2;
                }
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            View view3;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                view2 = (View) iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                int itemViewType = getItemViewType(i3);
                if (itemViewType != 0) {
                    if (itemViewType != 1) {
                        if (itemViewType != 2) {
                            if (itemViewType != 3) {
                                if (itemViewType == 4) {
                                    if (VisitorsActivity.this.f177542o0 == null) {
                                        h();
                                        VisitorsActivity visitorsActivity = VisitorsActivity.this;
                                        visitorsActivity.f177542o0 = visitorsActivity.getLayoutInflater().inflate(R.layout.aye, (ViewGroup) null);
                                        VisitorsActivity.this.f177542o0.setLayoutParams(new AbsListView.LayoutParams(-1, VisitorsActivity.this.f177534k0));
                                    }
                                    view = VisitorsActivity.this.f177542o0;
                                }
                            } else {
                                if (VisitorsActivity.this.f177530i0 == null) {
                                    h();
                                    VisitorsActivity visitorsActivity2 = VisitorsActivity.this;
                                    visitorsActivity2.f177530i0 = visitorsActivity2.getLayoutInflater().inflate(R.layout.c3h, (ViewGroup) null);
                                    VisitorsActivity.this.f177530i0.setLayoutParams(new AbsListView.LayoutParams(-1, VisitorsActivity.this.f177534k0));
                                }
                                view = VisitorsActivity.this.f177530i0;
                                TextView textView = (TextView) view.findViewById(R.id.bws);
                                LikeRankingInfo a16 = VisitorsActivity.this.f177550s0.a();
                                String string = VisitorsActivity.this.getString(R.string.ifg);
                                if (a16 == null || a16.totalLikeCount <= 0) {
                                    string = VisitorsActivity.this.getString(R.string.iff);
                                }
                                textView.setText(string);
                            }
                        } else {
                            if (this.D == null) {
                                this.D = (LayoutInflater) viewGroup.getContext().getSystemService("layout_inflater");
                            }
                            view = this.D.inflate(R.layout.ayf, (ViewGroup) null);
                            if (this.G && (i16 = this.K) > this.J) {
                                view.setMinimumHeight(i16);
                                view.setLayoutParams(new AbsListView.LayoutParams(-1, this.K));
                            }
                            ((TextView) view.findViewById(R.id.b_4)).setText(this.C);
                        }
                    } else {
                        if (view == null || !(view.getTag() instanceof u)) {
                            view = c();
                            view.setOnClickListener(new b());
                        }
                        e((u) view.getTag());
                    }
                } else {
                    if (i3 > this.f177619m) {
                        this.f177619m = i3;
                    }
                    if (view == null || !(view.getTag() instanceof s)) {
                        view = b(viewGroup);
                        view.setOnClickListener(new a());
                    }
                    s sVar = (s) view.getTag();
                    sVar.f177602j.setTag(R.id.dyw, Integer.valueOf(i3));
                    sVar.f177605m = i3;
                    d(getItem(i3), sVar);
                    VisitorsActivity.this.A3(view, i3);
                }
                view.setTag(-1, Integer.valueOf(i3));
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return 5;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            return false;
        }

        public CardProfile i(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (CardProfile) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            if (i3 < this.f177615e.size()) {
                return this.f177615e.remove(i3);
            }
            return null;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
            }
            if (i3 > this.f177615e.size() - 1) {
                return !this.f177618i;
            }
            return super.isEnabled(i3);
        }

        public void j(ArrayList<CardProfile> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
                return;
            }
            if (arrayList != null && arrayList.size() >= 1) {
                l(arrayList);
                this.f177615e = arrayList;
                VisitorsActivity.this.L1 = -1;
                int size = this.I * arrayList.size();
                VisitorsActivity visitorsActivity = VisitorsActivity.this;
                int i3 = visitorsActivity.Y0;
                if (size < i3) {
                    this.K = (i3 - visitorsActivity.getTitleBarHeight()) - size;
                    return;
                }
                return;
            }
            if (QLog.isDebugVersion()) {
                QLog.d("VisitorsActivity", 2, "setDataSet profiles empty:" + arrayList);
            }
        }

        public void k(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, z16);
            } else {
                this.f177617h = z16;
            }
        }
    }

    public VisitorsActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f177520d0 = new ArrayList<>();
        this.f177526g0 = false;
        this.f177532j0 = -1L;
        this.f177538m0 = new ArrayList<>();
        this.f177540n0 = false;
        this.f177544p0 = -1L;
        this.f177556v0 = false;
        this.N0 = 5;
        this.U0 = false;
        this.V0 = false;
        this.f177521d1 = -1;
        this.f177523e1 = new HashMap<>();
        this.f177525f1 = 0L;
        this.f177527g1 = false;
        this.f177529h1 = 0;
        this.f177533j1 = true;
        this.f177541n1 = 0L;
        this.f177545p1 = false;
        this.f177549r1 = ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen();
        this.f177553t1 = new j();
        this.f177555u1 = new MqqWeakReferenceHandler(this.f177553t1);
        this.f177557v1 = new m();
        this.f177559w1 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("Argus_Visitors_Activity", false);
        this.f177561x1 = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("Argus_Visitors_Activity_Resource", false);
        this.f177563y1 = new AtomicBoolean(true);
        this.f177565z1 = new AtomicBoolean(false);
        this.A1 = new o();
        this.B1 = 0;
        this.E1 = new b();
        this.F1 = 0;
        this.G1 = 0L;
        this.H1 = new c();
        this.I1 = new SparseArray<>();
        this.J1 = new d();
        this.K1 = new e();
        this.L1 = -1;
    }

    public static void B3(VipBaseInfo vipBaseInfo, ImageView imageView, TextView textView) {
        Map<Integer, VipOpenInfo> map;
        imageView.setVisibility(8);
        textView.setTextColor(textView.getResources().getColorStateList(R.color.qui_common_text_primary));
        if (vipBaseInfo != null && (map = vipBaseInfo.mOpenInfo) != null) {
            VipOpenInfo vipOpenInfo = map.get(7);
            if (vipOpenInfo != null && vipOpenInfo.bOpen) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.h39);
                textView.setTextColor(textView.getResources().getColorStateList(R.color.skin_red));
                return;
            }
            VipOpenInfo vipOpenInfo2 = vipBaseInfo.mOpenInfo.get(3);
            if (vipOpenInfo2 != null && vipOpenInfo2.bOpen) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.h39);
                textView.setTextColor(textView.getResources().getColorStateList(R.color.skin_red));
                return;
            }
            VipOpenInfo vipOpenInfo3 = vipBaseInfo.mOpenInfo.get(1);
            if (vipOpenInfo3 != null && vipOpenInfo3.bOpen) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.h7y);
                textView.setTextColor(textView.getResources().getColorStateList(R.color.skin_red));
            }
        }
    }

    private Bitmap U2() {
        if (this.f177515a1 == null) {
            this.f177515a1 = BaseImageUtil.getDefaultFaceBitmap140_140();
        }
        return this.f177515a1;
    }

    private long V2() {
        return getActivity().getSharedPreferences("favoritors_last_refresh_time", 0).getLong("favoritors_last_refresh_time", 0L);
    }

    private long W2() {
        return getActivity().getSharedPreferences("visitors_last_refresh_time", 0).getLong("visitors_last_refresh_time", 0L);
    }

    private boolean Z2(long j3) {
        if (j3 != 6 && j3 != 37 && j3 != 41 && j3 != 42 && j3 != 45) {
            return false;
        }
        return true;
    }

    private void b3(AllInOne allInOne) {
        Bundle bundle = new Bundle();
        bundle.putInt("param_mode", 3);
        int intExtra = getIntent().getIntExtra("frome_where", 6);
        Intent intent = new Intent();
        intent.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
        intent.putExtras(bundle);
        intent.putExtra("frome_where", intExtra);
        intent.addFlags(268435456);
        RouteUtils.startActivityForResult(BaseApplication.getContext(), intent, "/nearby/people/profile", 1023);
    }

    private void i3(CardProfile cardProfile) {
        AllInOne allInOne = new AllInOne(String.valueOf(cardProfile.lEctID), 41);
        allInOne.nickname = cardProfile.strNick;
        allInOne.age = cardProfile.bAage;
        allInOne.gender = cardProfile.bSex;
        allInOne.faceId = cardProfile.wFace;
        if (QLog.isColorLevel()) {
            QLog.d("VisitorsActivity", 2, String.format("openProfileCard nickname=%s likeSource=%s", cardProfile.strNick, Long.valueOf(cardProfile.uSource)));
        }
        if (cardProfile.isFriend) {
            allInOne.f260789pa = 1;
            allInOne.likeSource = 1L;
            ProfileUtils.openProfileCardForResult(this, allInOne, 1023);
            return;
        }
        long j3 = cardProfile.uSource;
        if (j3 == 53) {
            allInOne.f260789pa = 96;
            ProfileUtils.openProfileCardForResult(this, allInOne, 1023);
            return;
        }
        if (Z2(j3)) {
            b3(allInOne);
            return;
        }
        if (this.f177521d1 == 0) {
            allInOne.profileEntryType = 16;
        } else {
            allInOne.profileEntryType = 38;
        }
        long j16 = cardProfile.uSource;
        if (j16 > 0 && j16 <= 48) {
            allInOne.likeSource = j16;
        } else {
            allInOne.likeSource = 6L;
        }
        allInOne.f260789pa = 19;
        ProfileUtils.openProfileCardForResult(this, allInOne, 1023);
        this.f177541n1 = cardProfile.lEctID;
    }

    private void initData() {
        this.f177518c0 = new VoteHelper(this, this.f177555u1, this.app);
        this.f177524f0 = new v(this, this.app, this, 0, this.f177552t0);
        this.f177536l0 = new v(this, this.app, this, 1, this.f177552t0);
        if (QLog.isDebugVersion()) {
            QLog.d("VisitorsActivity", 2, "setDataSet init visitors");
        }
        this.f177524f0.j(this.f177520d0);
        if (QLog.isDebugVersion()) {
            QLog.d("VisitorsActivity", 2, "setDataSet init favorite");
        }
        this.f177536l0.j(this.f177538m0);
        this.f177524f0.C = getString(R.string.chx);
        this.f177536l0.C = getString(R.string.cgs);
        startTitleProgress();
        this.f177537l1 = getResources().getString(R.string.f171513fq4);
    }

    @TargetApi(11)
    private void initUI() {
        setRightButton(R.string.hhb, this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f177547q1 = displayMetrics.widthPixels;
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.dm6);
        this.f177517b1 = viewGroup;
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new p());
        SwipListView swipListView = (SwipListView) findViewById(R.id.kzn);
        this.f177522e0 = swipListView;
        swipListView.setContentBackground(getResources().getDrawable(R.drawable.bg_texture), false);
        PullRefreshHeader pullRefreshHeader = (PullRefreshHeader) getLayoutInflater().inflate(R.layout.f168433w5, (ViewGroup) this.f177522e0, false);
        this.f177528h0 = pullRefreshHeader;
        this.f177522e0.setOverScrollHeader(pullRefreshHeader);
        this.f177522e0.setOverScrollListener(this);
        this.f177522e0.setSwipListListener(this);
        this.f177522e0.setDragEnable(true);
        this.f177522e0.setSelector(R.color.ajr);
        this.f177522e0.setNeedCheckSpringback(true);
        NearbyZanAnimLayout nearbyZanAnimLayout = (NearbyZanAnimLayout) findViewById(R.id.f6u);
        this.f177519c1 = nearbyZanAnimLayout;
        nearbyZanAnimLayout.setVisibility(0);
        this.f177519c1.setEnabled(false);
        if (this.f177552t0) {
            this.f194786vg.setBackgroundResource(R.color.als);
            this.rightViewText.setTextColor(getResources().getColorStateList(R.color.qui_common_text_allwhite_primary));
            this.rightViewText.setBackgroundDrawable(null);
            this.leftView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.qui_chevron_left_icon_white_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.ee7);
            this.f177558w0 = viewGroup2;
            viewGroup2.setBackgroundResource(R.color.als);
            this.f177556v0 = this.f177550s0.e();
            this.S0 = ViewUtils.dpToPx(46.0f);
            this.f177528h0.setArrowColor(1);
            this.T0 = getString(R.string.cgj);
            this.centerView.setText("");
            this.Y0 = ViewUtils.getScreenHeight();
            View inflate = LayoutInflater.from(this).inflate(R.layout.aw5, (ViewGroup) null);
            this.f177562y0 = inflate.findViewById(R.id.idr);
            this.f177564z0 = (ZanBannerView) inflate.findViewById(R.id.l76);
            inflate.findViewById(R.id.ief).setOnClickListener(this);
            new AdComponent().d((ViewGroup) inflate.findViewById(R.id.f1041762l));
            this.D0 = (TextView) inflate.findViewById(R.id.f167054k93);
            this.E0 = (TextView) inflate.findViewById(R.id.f167036k63);
            this.F0 = (TextView) inflate.findViewById(R.id.ka9);
            this.G0 = inflate.findViewById(R.id.dxr);
            this.f177560x0 = (RelativeLayout) inflate.findViewById(R.id.ie6);
            int round = Math.round(ViewUtils.getScreenWidth() * 0.29f);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.D0.getLayoutParams();
            layoutParams.width = round;
            this.D0.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.F0.getLayoutParams();
            layoutParams2.width = round;
            this.F0.setLayoutParams(layoutParams2);
            this.A0 = (ImageView) inflate.findViewById(R.id.dxi);
            this.C0 = (TextView) inflate.findViewById(R.id.dxk);
            this.B0 = (ImageView) inflate.findViewById(R.id.dxh);
            this.f177562y0.setOnTouchListener(new q());
            this.H0 = (ImageView) inflate.findViewById(R.id.f165945dw4);
            this.I0 = (ImageView) inflate.findViewById(R.id.dw5);
            this.J0 = (ImageView) inflate.findViewById(R.id.dw6);
            this.K0 = (ImageView) inflate.findViewById(R.id.dw7);
            this.L0 = inflate.findViewById(R.id.ibw);
            if (this.f177556v0 && VersionUtils.isHoneycomb()) {
                this.L0.setVisibility(0);
            }
            this.M0 = inflate.findViewById(R.id.dyx);
            this.R0 = -ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
            this.Q0 = ViewUtils.getScreenWidth() / 2;
            this.f177522e0.addHeaderView(inflate);
            r rVar = new r();
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.W0 = alphaAnimation;
            alphaAnimation.setDuration(300L);
            this.W0.setInterpolator(this, android.R.anim.accelerate_interpolator);
            this.W0.setAnimationListener(rVar);
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
            this.X0 = alphaAnimation2;
            alphaAnimation2.setDuration(300L);
            this.X0.setInterpolator(this, android.R.anim.accelerate_interpolator);
            this.X0.setAnimationListener(rVar);
            t tVar = new t();
            this.C1 = tVar;
            this.f177522e0.setOnScrollListener(tVar);
            TabBarView tabBarView = (TabBarView) inflate.findViewById(R.id.j9y);
            this.P0 = tabBarView;
            tabBarView.x();
            this.P0.setTabTitleList(new String[]{getString(R.string.iga), getString(R.string.f171025bs2)});
            this.P0.c(0, getString(R.string.iga));
            this.P0.c(1, getString(R.string.f171025bs2));
            this.P0.setSelectedTab(0, false);
            this.P0.setOnTabChangeListener(this.f177557v1);
            z3();
            LikeRankingInfo a16 = this.f177550s0.a();
            r3(true, a16.likeCountOfToday, a16.rankingNum, a16.totalLikeCount);
        }
        this.f177522e0.setAdapter((ListAdapter) this.f177524f0);
        if (this.f177552t0) {
            findViewById(R.id.i9x).setVisibility(8);
            this.f177516b0 = (TabBarView) findViewById(R.id.cdc);
        } else {
            this.f177516b0 = (TabBarView) findViewById(R.id.i9x);
        }
        this.f177516b0.c(0, getString(R.string.iga));
        this.f177516b0.c(1, getString(R.string.f171025bs2));
        this.f177516b0.setOnTabChangeListener(this.f177557v1);
        this.f177516b0.setSelectedTab(0, false);
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.activity.VisitorsActivity.9
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                ArrayList<CardProfile> S2 = VisitorsActivity.this.f177531i1.S2(2, 7);
                ArrayList<CardProfile> S22 = VisitorsActivity.this.f177531i1.S2(3, 7);
                if (!VisitorsActivity.this.isFinishing()) {
                    VisitorsActivity.this.f177518c0.f();
                    VisitorsActivity.this.f177555u1.obtainMessage(5, 0, 0, new Object[]{S2, S22}).sendToTarget();
                }
            }
        }, null, true);
        MqqWeakReferenceHandler mqqWeakReferenceHandler = this.f177555u1;
        mqqWeakReferenceHandler.sendMessage(mqqWeakReferenceHandler.obtainMessage(13, 1, 0));
    }

    private void j3(long j3) {
        getActivity().getSharedPreferences("favoritors_last_refresh_time", 0).edit().putLong("favoritors_last_refresh_time", j3).commit();
    }

    private void l3(long j3) {
        getActivity().getSharedPreferences("visitors_last_refresh_time", 0).edit().putLong("visitors_last_refresh_time", j3).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u3(TextView textView, int i3) {
        com.tencent.mobileqq.widget.bo boVar = new com.tencent.mobileqq.widget.bo(getResources(), this.D1.K(i3, 200), false, false);
        if (this.F1 == 0) {
            this.F1 = (int) ((textView.getTextSize() * 1.1f) + 0.5f);
        }
        int i16 = this.F1;
        boVar.setBounds(0, 0, i16, i16);
        textView.setCompoundDrawables(boVar, null, null, null);
    }

    public void A3(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) view, i3);
            return;
        }
        int scrollX = view.getScrollX();
        if (i3 >= 0 && this.f177524f0 != null && this.L1 == i3) {
            view.scrollTo(0, 0);
        } else if (scrollX != 0) {
            view.scrollTo(0, 0);
        }
        view.setTag(-3, Integer.valueOf(getResources().getDimensionPixelSize(R.dimen.b4b)));
    }

    boolean C3(boolean z16) {
        String currentAccountUin = this.app.getCurrentAccountUin();
        if (z16) {
            this.f177526g0 = true;
            this.f177532j0 = -1L;
            this.f177531i1.o3(currentAccountUin, this.f177514a0, 0L, 30);
        } else {
            long j3 = this.f177532j0;
            if (j3 > -1) {
                this.f177531i1.o3(currentAccountUin, this.f177514a0, j3, 30);
            }
        }
        return true;
    }

    void D3(TextView textView, Bitmap bitmap, int i3) {
        Drawable d16 = com.tencent.biz.common.util.e.d(new BitmapDrawable(getResources(), bitmap), i3);
        int textSize = (int) ((textView.getTextSize() * 1.1f) + 0.5f);
        d16.setBounds(0, 0, textSize, textSize);
        textView.setCompoundDrawables(d16, null, null, null);
        textView.setCompoundDrawablePadding(5);
    }

    @Override // com.tencent.mobileqq.profile.like.PraiseManager.a
    public void M0(int i3, com.tencent.mobileqq.profile.like.d dVar, int i16, String str) {
        v vVar;
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), dVar, Integer.valueOf(i16), str);
            return;
        }
        if (i3 == 0) {
            return;
        }
        Pair<Point, Boolean> pair = this.I1.get(i3);
        if (pair != null) {
            Point point = pair.first;
            Q2(dVar, point.x, point.y, pair.second.booleanValue(), false);
            this.I1.remove(i3);
        }
        SwipListView swipListView = this.f177522e0;
        int i17 = this.f177521d1;
        if (i17 == 0) {
            vVar = this.f177524f0;
        } else if (i17 == 1) {
            vVar = this.f177536l0;
        } else {
            vVar = null;
        }
        int firstVisiblePosition = swipListView.getFirstVisiblePosition();
        if (vVar == null) {
            return;
        }
        for (int i18 = 0; i18 < vVar.f177615e.size(); i18++) {
            CardProfile item = vVar.getItem(i18);
            if (item != null && item.dwLikeCustomId == i3) {
                View childAt = swipListView.getChildAt((i18 - firstVisiblePosition) + swipListView.getHeaderViewsCount());
                if (childAt != null && (textView = (TextView) childAt.findViewById(R.id.kcb)) != null) {
                    T2(item, textView, true, i18);
                    return;
                }
                return;
            }
        }
    }

    public void M2(ImageView imageView, int i3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, imageView, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        PraiseManager praiseManager = (PraiseManager) this.app.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
        int[] iArr = new int[2];
        imageView.getLocationInWindow(iArr);
        float paddingLeft = iArr[0] + imageView.getPaddingLeft();
        float paddingTop = (iArr[1] - this.B1) + imageView.getPaddingTop();
        if (z17 && praiseManager.f260200f.e(Integer.valueOf(i3)) == null) {
            praiseManager.h(this);
            this.I1.put(i3, new Pair<>(new Point((int) paddingLeft, (int) paddingTop), Boolean.valueOf(z16)));
        }
        Q2(praiseManager.g(i3, z17, "from_profile_card"), paddingLeft, paddingTop, z16, z17);
    }

    public void N2(com.tencent.mobileqq.profile.like.d dVar, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, dVar, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (this.f177545p1) {
            if (QLog.isColorLevel()) {
                QLog.d("VisitorsActivity", 2, "doPraiseAnim, mIsPraiseAnimating=true");
            }
        } else {
            this.f177555u1.sendMessage(this.f177555u1.obtainMessage(11, i16, i17, new Object[]{Integer.valueOf(i3), dVar}));
            this.f177545p1 = true;
        }
    }

    public void P2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
            return;
        }
        if (isFinishing()) {
            QLog.d("VisitorsActivity", 1, "doPraiseMallEntryAnim isFinishing return");
            return;
        }
        Vector<c.a> vector = com.tencent.mobileqq.profile.like.c.f260224c;
        if (vector != null && !vector.isEmpty()) {
            ZanBannerView zanBannerView = this.f177564z0;
            if (zanBannerView != null) {
                zanBannerView.setInfoList(com.tencent.mobileqq.profile.like.c.f260224c);
                VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "thumbup", "banner_pageview", "", 1, 0, 0, "", "", "");
                return;
            }
            return;
        }
        if (i3 > 0) {
            ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.activity.VisitorsActivity.13
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (VisitorsActivity.this.isFinishing()) {
                            QLog.d("VisitorsActivity", 1, "doPraiseMallEntryAnim run isFinishing return");
                            return;
                        }
                        com.tencent.mobileqq.profile.like.c.a(VisitorsActivity.this.app);
                        VisitorsActivity.this.f177555u1.sendMessageDelayed(VisitorsActivity.this.f177555u1.obtainMessage(13, 0, 0), 100L);
                    }
                }
            });
        }
    }

    public void Q2(com.tencent.mobileqq.profile.like.d dVar, float f16, float f17, boolean z16, boolean z17) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, dVar, Float.valueOf(f16), Float.valueOf(f17), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (dVar != null) {
            if (!z16 && (bitmap = dVar.f260242j) != null) {
                NearbyZanAnimLayout nearbyZanAnimLayout = this.f177519c1;
                nearbyZanAnimLayout.h(dVar, bitmap, this.app, this.f177539m1.a(2, nearbyZanAnimLayout.f236900h), f16 - com.tencent.mobileqq.util.x.c(this, 20.0f), f17 - com.tencent.mobileqq.util.x.c(this, 20.0f), com.tencent.mobileqq.util.x.c(this, 75.0f), com.tencent.mobileqq.util.x.c(this, 65.0f));
                return;
            } else {
                this.f177519c1.e(dVar, dVar.f260240h, f16, f17);
                return;
            }
        }
        if (!z17) {
            if (!z16) {
                i3 = 2;
            }
            if (i3 == 2) {
                NearbyZanAnimLayout nearbyZanAnimLayout2 = this.f177519c1;
                nearbyZanAnimLayout2.g(this.f177539m1.a(i3, nearbyZanAnimLayout2.f236900h).c(), this.app, this.f177539m1.a(i3, this.f177519c1.f236900h), f16 - com.tencent.mobileqq.util.x.c(this, 20.0f), f17 - com.tencent.mobileqq.util.x.c(this, 20.0f), com.tencent.mobileqq.util.x.c(this, 75.0f), com.tencent.mobileqq.util.x.c(this, 65.0f));
            } else {
                NearbyZanAnimLayout nearbyZanAnimLayout3 = this.f177519c1;
                nearbyZanAnimLayout3.d(this.f177539m1.a(i3, nearbyZanAnimLayout3.f236900h).c(), f16, f17);
            }
        }
    }

    public void R2(ImageView imageView, boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, imageView, Boolean.valueOf(z16));
            return;
        }
        int f16 = PraiseManager.f(this.app);
        if (f16 > 0) {
            M2(imageView, f16, z16, true);
            return;
        }
        imageView.setVisibility(0);
        imageView.getLocationInWindow(new int[2]);
        if (!z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        if (i3 == 2) {
            NearbyZanAnimLayout nearbyZanAnimLayout = this.f177519c1;
            nearbyZanAnimLayout.g(this.f177539m1.a(i3, nearbyZanAnimLayout.f236900h).c(), this.app, this.f177539m1.a(i3, this.f177519c1.f236900h), (r0[0] + imageView.getPaddingLeft()) - com.tencent.mobileqq.util.x.c(this, 20.0f), ((r0[1] - this.B1) + imageView.getPaddingTop()) - com.tencent.mobileqq.util.x.c(this, 20.0f), com.tencent.mobileqq.util.x.c(this, 75.0f), com.tencent.mobileqq.util.x.c(this, 65.0f));
        } else {
            NearbyZanAnimLayout nearbyZanAnimLayout2 = this.f177519c1;
            nearbyZanAnimLayout2.d(this.f177539m1.a(i3, nearbyZanAnimLayout2.f236900h).c(), r0[0] + imageView.getPaddingLeft(), (r0[1] - this.B1) + imageView.getPaddingTop());
        }
    }

    void S2(String str, long j3, int i3, ImageView imageView, CardProfile cardProfile) {
        if (!cardProfile.isFriend && Z2(j3)) {
            Bitmap bitmapFromCache = this.Z0.getBitmapFromCache(32, str, 200);
            if (bitmapFromCache == null) {
                this.Z0.requestDecodeStrangeFace(str, 200, true, false);
                bitmapFromCache = U2();
            }
            imageView.setImageBitmap(bitmapFromCache);
            return;
        }
        Bitmap bitmapFromCache2 = this.Z0.getBitmapFromCache(1, str);
        if (bitmapFromCache2 == null) {
            this.Z0.requestDecodeFace(str, 1, false);
            bitmapFromCache2 = U2();
        }
        imageView.setImageBitmap(bitmapFromCache2);
    }

    CharSequence T2(CardProfile cardProfile, TextView textView, boolean z16, int i3) {
        int i16;
        com.tencent.mobileqq.profile.like.d g16;
        String str = this.f177537l1;
        Object[] objArr = new Object[2];
        if (cardProfile.type == 2) {
            i16 = R.string.vhx;
        } else if (cardProfile.bSex == 1) {
            i16 = R.string.vhy;
        } else {
            i16 = R.string.f172913vi0;
        }
        boolean z17 = false;
        objArr[0] = HardCodeUtil.qqStr(i16);
        objArr[1] = Short.valueOf(cardProfile.bVoteCnt);
        SpannableString spannableString = new SpannableString(String.format(str, objArr));
        if (cardProfile.dwLikeCustomId > 0) {
            PraiseManager praiseManager = (PraiseManager) this.app.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
            praiseManager.h(this);
            if (z16) {
                g16 = praiseManager.f260200f.e(Integer.valueOf((int) cardProfile.dwLikeCustomId));
            } else {
                g16 = praiseManager.g((int) cardProfile.dwLikeCustomId, true, "from_profile_card");
            }
            if (g16 != null && !TextUtils.isEmpty(g16.f260235c)) {
                SpannableString valueOf = SpannableString.valueOf(TextUtils.concat(g16.f260235c, spannableString));
                valueOf.setSpan(new ForegroundColorSpan(g16.f260236d), 0, g16.f260235c.length(), 33);
                Bitmap bitmap = g16.f260238f;
                if (bitmap != null) {
                    D3(textView, bitmap, g16.f260236d);
                    z17 = true;
                }
                textView.setOnClickListener(new a(cardProfile, g16, i3));
                textView.setClickable(true);
                spannableString = valueOf;
            }
        } else {
            textView.setOnClickListener(null);
        }
        if (!z17) {
            textView.setCompoundDrawables(null, null, null, null);
        }
        return spannableString;
    }

    @Override // qd2.a
    public void Y0(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, obj);
            return;
        }
        if (obj == null) {
            return;
        }
        int i3 = this.f177521d1;
        if (i3 == 0) {
            if (obj instanceof s) {
                ReportController.r(this.app, "CliOper", "", "", "0X800444A", "0X800444A", 0, 0, "", "", "", "");
                i3((CardProfile) ((s) obj).f177607o);
                return;
            } else {
                if (obj instanceof u) {
                    d3();
                    return;
                }
                return;
            }
        }
        if (i3 == 1) {
            if (obj instanceof s) {
                ReportController.r(this.app, "CliOper", "", "", "0X8004447", "0X8004447", 0, 0, "", "", "", "");
                i3((CardProfile) ((s) obj).f177607o);
            } else if (obj instanceof u) {
                c3();
            }
        }
    }

    int Y2(CardProfile cardProfile, String str) {
        int i3;
        boolean z16 = cardProfile.isFriend;
        byte b16 = cardProfile.bMutualFriends;
        if (b16 != 1) {
            i3 = 10;
            if (b16 != 2) {
                if (z16 || cardProfile.bCloseNeighborVote != 1) {
                    if (cardProfile.bAvailableCnt <= 0) {
                        if (cardProfile.bTodayVotedCnt <= 0) {
                            i3 = -3;
                        }
                        i3 = 2;
                    }
                    i3 = 0;
                }
            } else if (cardProfile.bCloseNeighborVote != 1) {
                if (cardProfile.bAvailableCnt <= 0) {
                    if (cardProfile.bTodayVotedCnt <= 0) {
                        i3 = -2;
                    }
                    i3 = 2;
                }
                i3 = 0;
            }
        } else {
            if (cardProfile.bAvailableCnt <= 0) {
                if (cardProfile.bTodayVotedCnt <= 0) {
                    i3 = -1;
                }
                i3 = 2;
            }
            i3 = 0;
        }
        if (this.f177549r1) {
            QLog.i("VisitorsActivity", 2, String.format("getVoteLevel visibility=%d uin=%s isFrd=%b mutual=%d ", Integer.valueOf(i3), str, Boolean.valueOf(z16), Byte.valueOf(cardProfile.bMutualFriends)));
        }
        return i3;
    }

    @Override // qd2.a
    public void Z0(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, obj);
            return;
        }
        if (obj != null && (obj instanceof s)) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread() && QLog.isColorLevel()) {
                QLog.i("VisitorsActivity", 2, "warning!!!!!! onRightBtnClick not in main thread");
            }
            int i3 = this.f177521d1;
            if (i3 == 0) {
                CardProfile i16 = this.f177524f0.i(((s) obj).f177605m);
                this.f177524f0.notifyDataSetChanged();
                if (i16 != null) {
                    this.f177518c0.k(i16.lEctID, 1);
                }
                ReportController.o(this.app, "dc00898", "", "", "0X8009702", "0X8009702", 0, 0, "", "", "", "");
                return;
            }
            if (i3 == 1) {
                CardProfile i17 = this.f177536l0.i(((s) obj).f177605m);
                this.f177536l0.notifyDataSetChanged();
                if (i17 != null) {
                    this.f177518c0.k(i17.lEctID, 0);
                }
                ReportController.o(this.app, "dc00898", "", "", "0X8009703", "0X8009703", 0, 0, "", "", "", "");
            }
        }
    }

    void c3() {
        if (!NetworkUtil.isNetSupport(this)) {
            showToast(1, getString(R.string.f171139ci4));
            return;
        }
        w3(false);
        v vVar = this.f177536l0;
        vVar.f177618i = true;
        vVar.notifyDataSetChanged();
    }

    void d3() {
        if (!NetworkUtil.isNetSupport(this)) {
            showToast(1, getString(R.string.f171139ci4));
            return;
        }
        C3(false);
        v vVar = this.f177524f0;
        vVar.f177618i = true;
        vVar.notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 != 1023 && i3 == 1028 && QLog.isColorLevel()) {
            QLog.d("NearbyLikeLimitManager", 2, "VisitorsActivity->doOnActivityResult, resultCode=" + i16);
        }
        super.doOnActivityResult(i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) configuration);
        } else {
            super.doOnConfigurationChanged(configuration);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        RelativeLayout relativeLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        this.f177531i1 = (CardHandler) this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        this.f177535k1 = (l92.a) this.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
        addObserver(this.H1);
        addObserver(this.A1);
        String currentAccountUin = this.app.getCurrentAccountUin();
        Intent intent = getIntent();
        this.f177514a0 = String.valueOf(intent.getLongExtra("toUin", 0L));
        this.f177550s0 = (com.tencent.mobileqq.app.bk) this.app.getManager(QQManagerFactory.LIKE_RANKING_LIST_MANAGER);
        this.f177552t0 = intent.getBooleanExtra("extra_show_rank", false);
        this.f177546q0 = intent.getIntExtra("extra_from", -1);
        if (QLog.isDebugVersion()) {
            QLog.d("VisitorsActivity", 2, "mShowRank=" + this.f177552t0);
        }
        this.f177539m1 = new com.tencent.mobileqq.hotchat.ui.c(this);
        if (this.f177552t0) {
            this.f177548r0 = (LocalRedTouchManager) this.app.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
            this.app.registObserver(this.K1);
            if (this.f177546q0 == 1) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.VisitorsActivity.3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VisitorsActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        RedTouchItem j3 = VisitorsActivity.this.f177548r0.j(BusinessInfoCheckUpdateItem.UIAPPID_ME_PROFILE_LIKE_RANDKINGLIST);
                        if (j3 != null && j3.unReadFlag && j3.passThroughLevel > 0) {
                            j3.passThroughLevel = 0;
                            VisitorsActivity.this.f177548r0.B();
                            ReportController.o(VisitorsActivity.this.app, "dc00898", "", "", "0X800760F", "0X800760F", 0, 0, "1", "", "", "");
                            return;
                        }
                        ReportController.o(VisitorsActivity.this.app, "dc00898", "", "", "0X800760F", "0X800760F", 0, 0, "2", "", "", "");
                    }
                }, 5, null, false);
            }
        }
        String str = this.f177514a0;
        if (str != null) {
            currentAccountUin.equals(str);
        }
        this.f177532j0 = getIntent().getLongExtra("nextMidVoter", -1L);
        setContentView(R.layout.c3i);
        initData();
        initUI();
        this.app.addObserver(this.J1);
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
        this.Z0 = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
        StatusManager statusManager = (StatusManager) this.app.getManager(QQManagerFactory.STATUS_MANAGER);
        this.D1 = statusManager;
        statusManager.C(this.E1);
        if (isInMultiWindow() && (relativeLayout = this.titleRoot) != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) relativeLayout.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 0, 0);
            this.titleRoot.setLayoutParams(marginLayoutParams);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        ObjectAnimator objectAnimator = this.f177551s1;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
            this.f177551s1.cancel();
        }
        IFaceDecoder iFaceDecoder = this.Z0;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        super.doOnDestroy();
        this.f177555u1.removeCallbacksAndMessages(null);
        removeObserver(this.H1);
        this.D1.b0(this.E1);
        removeObserver(this.A1);
        this.app.removeObserver(this.J1);
        if (this.f177552t0) {
            this.app.unRegistObserver(this.K1);
        }
        ((PraiseManager) this.app.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER)).j(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.doOnPause();
            ApngImage.pauseAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.doOnResume();
        ApngImage.playByTag(14);
        this.f177554u0 = this.f177550s0.c();
        if (QLog.isDebugVersion()) {
            QLog.d("VisitorsActivity", 2, "doOnResume mPartakeRank=" + this.f177554u0);
        }
        n3(this.f177554u0);
        CardHandler cardHandler = this.f177531i1;
        if (cardHandler != null) {
            cardHandler.d3();
        }
        if (this.f177552t0 && SystemBarActivityModule.getSystemBarComp(this) != null) {
            int color = getResources().getColor(R.color.als);
            SystemBarActivityModule.getSystemBarComp(this).setStatusColor(color);
            SystemBarActivityModule.getSystemBarComp(this).setStatusBarColor(color);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        if (this.f177555u1.hasMessages(6)) {
            this.f177555u1.removeMessages(6);
            this.f177518c0.l();
        }
        NearbyZanAnimLayout nearbyZanAnimLayout = this.f177519c1;
        if (nearbyZanAnimLayout != null) {
            nearbyZanAnimLayout.clearAnimation();
        }
        super.doOnStop();
    }

    public void e3(ArrayList<CardProfile> arrayList, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, arrayList, Long.valueOf(j3));
            return;
        }
        this.f177538m0.clear();
        this.f177538m0.addAll(arrayList);
        if (QLog.isColorLevel()) {
            QLog.d("VisitorsActivity", 2, "setDataSet onFavoriteListOk");
        }
        this.f177536l0.j(this.f177538m0);
        if (QLog.isColorLevel()) {
            QLog.d("VisitorsActivity", 2, "expandGroup onFavoriteListOk");
        }
        this.f177536l0.f177618i = false;
        this.f177540n0 = false;
        if (j3 == 0) {
            p3(true);
        }
        this.f177536l0.notifyDataSetChanged();
    }

    void f3() {
        this.f177540n0 = false;
        QQToast.makeText(this, 1, R.string.hqe, 0).show(getTitleBarHeight());
        p3(false);
        v vVar = this.f177536l0;
        if (vVar.f177618i) {
            vVar.f177618i = false;
            vVar.notifyDataSetChanged();
        }
    }

    void g3() {
        this.f177526g0 = false;
        QQToast.makeText(this, 1, R.string.hqe, 0).show(getTitleBarHeight());
        s3(false);
        v vVar = this.f177524f0;
        if (vVar.f177618i) {
            vVar.f177618i = false;
            vVar.notifyDataSetChanged();
        }
        if (this.f177552t0) {
            this.L0.setVisibility(0);
        }
    }

    public void h3(ArrayList<CardProfile> arrayList, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, arrayList, Long.valueOf(j3));
            return;
        }
        this.f177520d0.clear();
        this.f177520d0.addAll(arrayList);
        if (QLog.isDebugVersion()) {
            QLog.d("VisitorsActivity", 2, "setDataSet onVisitorListOk");
        }
        this.f177524f0.j(this.f177520d0);
        if (QLog.isDebugVersion()) {
            QLog.d("VisitorsActivity", 2, "expandGroup onVisitorListOk");
        }
        this.f177524f0.f177618i = false;
        this.f177526g0 = false;
        if (j3 == 0) {
            s3(true);
        }
        this.f177524f0.notifyDataSetChanged();
    }

    @Override // com.tencent.widget.SwipListView.SwipListListener
    public void hideMenuPop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this);
        }
    }

    @Override // com.tencent.widget.SwipListView.SwipListListener
    public void interceptTouchEvent(boolean z16) {
        TopGestureLayout topGestureLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, z16);
            return;
        }
        FlingHandler flingHandler = GestureActivityModule.getFlingHandler(this);
        if (flingHandler != null && (flingHandler instanceof FlingGestureHandler) && (topGestureLayout = ((FlingGestureHandler) flingHandler).mTopLayout) != null) {
            topGestureLayout.setInterceptTouchFlag(!z16);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isCloneInflaterInSubThreadEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f177559w1;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isDelegateLayoutInflaterEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.f177559w1;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean isDelegateResourceEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.f177561x1;
    }

    public void n3(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        if (z16) {
            View view = this.f177562y0;
            if (view != null) {
                view.setVisibility(0);
                if (!TextUtils.isEmpty(this.centerView.getText().toString())) {
                    this.centerView.setText(R.string.cgj);
                    return;
                } else {
                    this.centerView.setText("");
                    return;
                }
            }
            return;
        }
        View view2 = this.f177562y0;
        if (view2 != null) {
            view2.setVisibility(8);
            TextView textView = this.centerView;
            if (textView != null) {
                textView.setText(R.string.cgj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        String str;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        v vVar = this.f177524f0;
        if (vVar != null && (i16 = vVar.f177619m) > 0) {
            ReportController.r(this.app, "CliOper", "", "", "0X8004446", "0X8004446", 0, 0, String.valueOf(i16), "", "", "");
        }
        v vVar2 = this.f177536l0;
        if (vVar2 != null && (i3 = vVar2.f177619m) > 0) {
            ReportController.r(this.app, "CliOper", "", "", "0X8004449", "0X8004449", 0, 0, String.valueOf(i3), "", "", "");
        }
        ReportController.o(this.app, "dc00898", "", "", "0X8007612", "0X8007612", 0, 0, "", "", "", "");
        if (this.f177546q0 == 2 && (str = this.f177514a0) != null && str.equalsIgnoreCase(this.app.getCurrentAccountUin())) {
            AllInOne allInOne = new AllInOne(this.f177514a0, 0);
            Bundle bundle = new Bundle();
            bundle.putBoolean("single_top", true);
            ProfileActivity.J2(getActivity(), allInOne, bundle);
            overridePendingTransition(R.anim.activity_back, R.anim.activity_finish);
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
        } else if (view == this.rightViewText) {
            ReportController.o(this.app, "dc00898", "", "", "0X8007613", "0X8007613", 0, 0, "", "", "", "");
            startActivity(new Intent(this, (Class<?>) LikeSettingActivity.class));
        } else if (view.getId() == R.id.dyw) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof CardProfile)) {
                CardProfile cardProfile = (CardProfile) tag;
                if (this.f177518c0.h(cardProfile, (ImageView) view)) {
                    String num = Integer.toString(cardProfile.type);
                    VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "thumbup", "dbzan_pageview", "", 1, 0, 0, "", num, "");
                    com.tencent.mobileqq.vas.au auVar = new com.tencent.mobileqq.vas.au(this);
                    auVar.N(new n(num));
                    auVar.show();
                }
            }
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ief) {
                String a16 = this.f177564z0.a();
                if (TextUtils.isEmpty(a16)) {
                    a16 = IndividuationUrlHelper.getMarketUrl(this, "praise", "");
                }
                Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
                VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "thumbup", "banner_click", "", 1, 0, 0, "", this.f177564z0.b(), "");
                VasWebviewUtil.openQQBrowserWithoutAD(this, a16, 536870912L, intent, false, -1);
                ReportController.o(this.app, "CliOper", "", "", "like_mall", "like_enter", 0, 0, "", "", "", "");
            } else if (id5 == R.id.idr) {
                ReportController.o(this.app, "dc00898", "", "", "0X8007611", "0X8007611", 0, 0, "", "", "", "");
                com.tencent.mobileqq.profile.vote.a.b(this, false);
                this.G0.setVisibility(8);
                this.M0.clearAnimation();
                this.N0 = 0;
                this.f177555u1.removeCallbacks(this.O0);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public View onCreateCenterView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (View) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        super.onCreateCenterView();
        this.centerView.setText(R.string.ifc);
        return this.centerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity
    public View onCreateRightView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (View) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        super.onCreateRightView();
        this.rightViewText.setVisibility(8);
        return this.rightViewText;
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
            return;
        }
        if (bitmap == null && i3 > 0) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.G1;
        this.f177555u1.removeMessages(3);
        if (i3 != 0 && uptimeMillis < 800) {
            this.f177555u1.sendEmptyMessageDelayed(3, 800 - uptimeMillis);
            return;
        }
        this.G1 = SystemClock.uptimeMillis();
        if (this.f177521d1 == 0) {
            this.f177524f0.notifyDataSetChanged();
        } else {
            this.f177536l0.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public void onNotCompleteVisable(int i3, View view, ListView listView) {
        long V2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), view, listView);
            return;
        }
        PullRefreshHeader pullRefreshHeader = this.f177528h0;
        if (this.f177521d1 == 0) {
            V2 = W2();
        } else {
            V2 = V2();
        }
        pullRefreshHeader.i(V2);
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public void onViewCompleteVisable(int i3, View view, ListView listView) {
        long V2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), view, listView);
            return;
        }
        PullRefreshHeader pullRefreshHeader = this.f177528h0;
        if (this.f177521d1 == 0) {
            V2 = W2();
        } else {
            V2 = V2();
        }
        pullRefreshHeader.d(V2);
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public boolean onViewCompleteVisableAndReleased(int i3, View view, ListView listView) {
        long V2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), view, listView)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.Visitor", 2, "onViewCompleteVisableAndReleased");
        }
        if (!this.f177527g1) {
            if (this.f177521d1 == 0) {
                this.f177555u1.sendEmptyMessage(1);
            } else {
                this.f177555u1.sendEmptyMessage(4);
            }
            showToast(0, HardCodeUtil.qqStr(R.string.f172915vi2));
            return true;
        }
        PullRefreshHeader pullRefreshHeader = this.f177528h0;
        if (this.f177521d1 == 0) {
            V2 = W2();
        } else {
            V2 = V2();
        }
        pullRefreshHeader.h(V2);
        if (!stopTitleProgress()) {
            if (!NetworkUtil.isNetSupport(this)) {
                this.f177555u1.sendEmptyMessageDelayed(2, 1000L);
            } else if (this.f177521d1 == 0) {
                C3(true);
            } else {
                w3(true);
            }
        }
        return true;
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public void onViewNotCompleteVisableAndReleased(int i3, View view, ListView listView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), view, listView);
        }
    }

    void p3(boolean z16) {
        j3(System.currentTimeMillis());
        if (!stopTitleProgress()) {
            if (z16) {
                this.f177555u1.sendEmptyMessageDelayed(4, 800L);
                this.f177528h0.l(0);
            } else {
                showToast(1, getString(R.string.hqe));
                this.f177522e0.springBackOverScrollHeaderView();
            }
        }
    }

    @TargetApi(11)
    void r3(boolean z16, int i3, int i16, int i17) {
        int i18;
        TranslateAnimation translateAnimation;
        TranslateAnimation translateAnimation2;
        TranslateAnimation translateAnimation3;
        TranslateAnimation translateAnimation4;
        if (i3 >= 0) {
            this.D0.setText(i3 + "");
        }
        if (i3 == 0) {
            this.F0.setText(HardCodeUtil.qqStr(R.string.f172914vi1));
            this.F0.setTextSize(1, 18.0f);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.F0.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, ViewUtils.dpToPx(7.0f));
        } else if (i16 > 0) {
            this.F0.setText(String.valueOf(i16));
            this.F0.setTextSize(1, 30.0f);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.F0.getLayoutParams();
            layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, layoutParams2.rightMargin, ViewUtils.dpToPx(5.0f));
        }
        if (z16) {
            if (i17 > 0) {
                this.E0.setText(i17 + "");
                if (i17 > 9999) {
                    this.E0.setTextSize(36.0f);
                } else {
                    this.E0.setTextSize(44.0f);
                }
            }
        } else {
            LikeRankingInfo a16 = this.f177550s0.a();
            if (i17 >= 0 && i17 > (i18 = a16.totalLikeCount)) {
                if (i18 <= 0) {
                    i18 = 0;
                }
                com.tencent.mobileqq.utils.ez ezVar = new com.tencent.mobileqq.utils.ez(Integer.valueOf(i18), Integer.valueOf(i17), new f());
                ezVar.setStartOffset(200L);
                ezVar.setDuration(1200L);
                this.E0.startAnimation(ezVar);
            } else {
                int i19 = a16.totalLikeCount;
                if (i19 <= 0) {
                    i19 = 0;
                }
                this.E0.setText(i19 + "");
            }
        }
        this.f177550s0.i(i3, i16, i17);
        if (!z16 && !this.f177556v0) {
            this.L0.setVisibility(0);
            return;
        }
        if (z16 && this.f177556v0) {
            return;
        }
        try {
            this.H0.setImageResource(R.drawable.ewk);
            this.I0.setImageResource(R.drawable.ewl);
            this.J0.setImageResource(R.drawable.ewm);
            this.K0.setImageResource(R.drawable.fot);
            int dpToPx = ViewUtils.dpToPx(1.0f);
            if (z16) {
                int i26 = dpToPx * (-299);
                int i27 = this.Q0;
                float f16 = i26 + i27;
                float f17 = i26 + i27;
                int i28 = dpToPx * 42;
                int i29 = this.R0;
                translateAnimation = new TranslateAnimation(0, f16, 0, f17, 0, i28 + i29, 0, i28 + i29);
                translateAnimation.setDuration(0L);
                translateAnimation.setStartOffset(0L);
            } else {
                int i36 = this.Q0;
                int i37 = this.R0;
                translateAnimation = new TranslateAnimation(0, (dpToPx * (-493)) + i36, 0, (dpToPx * (-299)) + i36, 0, (dpToPx * 174) + i37, 0, (dpToPx * 42) + i37);
                translateAnimation.setDuration(900L);
                translateAnimation.setStartOffset(500L);
            }
            translateAnimation.setFillEnabled(true);
            translateAnimation.setFillAfter(true);
            translateAnimation.setInterpolator(new OvershootInterpolator(1.0f));
            translateAnimation.setAnimationListener(new g());
            this.H0.startAnimation(translateAnimation);
            if (z16) {
                int i38 = dpToPx * (-217);
                int i39 = this.Q0;
                float f18 = i38 + i39;
                float f19 = i38 + i39;
                int i46 = dpToPx * 47;
                int i47 = this.R0;
                translateAnimation2 = new TranslateAnimation(0, f18, 0, f19, 0, i46 + i47, 0, i46 + i47);
                translateAnimation2.setDuration(0L);
                translateAnimation2.setStartOffset(0L);
            } else {
                int i48 = this.Q0;
                int i49 = this.R0;
                translateAnimation2 = new TranslateAnimation(0, (dpToPx * (-520)) + i48, 0, (dpToPx * (-217)) + i48, 0, (dpToPx * 239) + i49, 0, (dpToPx * 47) + i49);
                translateAnimation2.setDuration(900L);
                translateAnimation2.setStartOffset(350L);
            }
            translateAnimation2.setFillEnabled(true);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setInterpolator(new OvershootInterpolator(1.0f));
            translateAnimation2.setAnimationListener(new h());
            this.I0.startAnimation(translateAnimation2);
            if (z16) {
                int i56 = this.Q0;
                float f26 = (dpToPx * (-2)) + i56;
                float f27 = (dpToPx * (-15)) + i56;
                int i57 = dpToPx * 50;
                int i58 = this.R0;
                translateAnimation3 = new TranslateAnimation(0, f26, 0, f27, 0, i57 + i58, 0, i57 + i58);
                translateAnimation3.setDuration(0L);
                translateAnimation3.setStartOffset(0L);
            } else {
                int i59 = this.Q0;
                int i65 = this.R0;
                translateAnimation3 = new TranslateAnimation(0, (dpToPx * (-160)) + i59, 0, (dpToPx * (-15)) + i59, 0, (dpToPx * 138) + i65, 0, (dpToPx * 50) + i65);
                translateAnimation3.setDuration(900L);
                translateAnimation3.setStartOffset(200L);
            }
            translateAnimation3.setFillEnabled(true);
            translateAnimation3.setFillAfter(true);
            translateAnimation3.setInterpolator(new OvershootInterpolator(1.0f));
            translateAnimation3.setAnimationListener(new i());
            this.J0.startAnimation(translateAnimation3);
            if (z16) {
                int i66 = dpToPx * 74;
                int i67 = this.Q0;
                float f28 = i66 + i67;
                float f29 = i66 + i67;
                int i68 = dpToPx * 34;
                int i69 = this.R0;
                translateAnimation4 = new TranslateAnimation(0, f28, 0, f29, 0, i68 + i69, 0, i68 + i69);
                translateAnimation4.setDuration(0L);
                translateAnimation4.setStartOffset(0L);
            } else {
                int i75 = this.Q0;
                int i76 = this.R0;
                TranslateAnimation translateAnimation5 = new TranslateAnimation(0, (dpToPx * (-180)) + i75, 0, (dpToPx * 74) + i75, 0, (dpToPx * 148) + i76, 0, (dpToPx * 34) + i76);
                translateAnimation5.setDuration(900L);
                translateAnimation5.setStartOffset(300L);
                translateAnimation4 = translateAnimation5;
            }
            translateAnimation4.setFillEnabled(true);
            translateAnimation4.setFillAfter(true);
            translateAnimation4.setInterpolator(new OvershootInterpolator(1.0f));
            translateAnimation4.setAnimationListener(new k());
            this.K0.startAnimation(translateAnimation4);
            if (!z16) {
                this.f177556v0 = false;
                this.f177550s0.h(NetConnInfoCenter.getServerTimeMillis());
                AnimationSet animationSet = new AnimationSet(true);
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 5.0f, 1.0f, 5.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(JoinTimeType.THIRTY_MINUTES);
                animationSet.addAnimation(scaleAnimation);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
                alphaAnimation.setDuration(400L);
                animationSet.addAnimation(alphaAnimation);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.8f, 0.0f);
                alphaAnimation2.setDuration(1400L);
                alphaAnimation2.setStartOffset(400L);
                animationSet.addAnimation(alphaAnimation2);
                animationSet.setFillAfter(true);
                animationSet.setFillEnabled(true);
                if (this.O0 == null) {
                    this.O0 = new Runnable(scaleAnimation, alphaAnimation, alphaAnimation2, animationSet) { // from class: com.tencent.mobileqq.activity.VisitorsActivity.21
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ ScaleAnimation f177566d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ AlphaAnimation f177567e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ AlphaAnimation f177568f;

                        /* renamed from: h, reason: collision with root package name */
                        final /* synthetic */ AnimationSet f177569h;

                        {
                            this.f177566d = scaleAnimation;
                            this.f177567e = alphaAnimation;
                            this.f177568f = alphaAnimation2;
                            this.f177569h = animationSet;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, VisitorsActivity.this, scaleAnimation, alphaAnimation, alphaAnimation2, animationSet);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this);
                                return;
                            }
                            this.f177566d.reset();
                            this.f177567e.reset();
                            this.f177568f.reset();
                            this.f177569h.reset();
                            VisitorsActivity.this.M0.startAnimation(this.f177569h);
                        }
                    };
                }
                animationSet.setAnimationListener(new l());
                this.N0 = 5;
                this.M0.startAnimation(animationSet);
                this.L0.setVisibility(0);
            }
        } catch (OutOfMemoryError unused) {
            QLog.e("VisitorsActivity", 1, "load img oom");
        }
    }

    void s3(boolean z16) {
        l3(System.currentTimeMillis());
        if (!stopTitleProgress()) {
            if (z16) {
                this.f177555u1.sendEmptyMessageDelayed(1, 800L);
                this.f177528h0.l(0);
            } else {
                showToast(1, getString(R.string.hqe));
                this.f177522e0.springBackOverScrollHeaderView();
            }
        }
    }

    public void showToast(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3, (Object) str);
        } else if (isResume()) {
            QQToast.makeText(this, i3, str, 0).show(getTitleBarHeight());
        }
    }

    void t3(int i3) {
        View currentFocus;
        if (this.f177521d1 == i3) {
            if (QLog.isDebugVersion()) {
                QLog.d("VisitorsActivity", 2, "[switchToTab] same tab return");
                return;
            }
            return;
        }
        if (this.f177552t0 && QLog.isDebugVersion()) {
            QLog.d("VisitorsActivity", 2, "[switchToTab]tab=" + i3 + ", top1=" + this.C1.f177608d + ", visible1=" + this.C1.f177609e);
        }
        this.f177521d1 = i3;
        if (i3 == 0) {
            this.f177522e0.setAdapter((ListAdapter) this.f177524f0);
            this.f177519c1.clearAnimation();
            com.tencent.mobileqq.hotchat.ui.b.d(this.f177519c1);
            this.f177555u1.removeMessages(8);
            this.f177555u1.sendEmptyMessage(8);
        } else if (i3 == 1) {
            ReportController.r(this.app, "CliOper", "", "", "0X8004448", "0X8004448", 0, 0, "", "", "", "");
            this.f177522e0.setAdapter((ListAdapter) this.f177536l0);
            this.f177519c1.clearAnimation();
            com.tencent.mobileqq.hotchat.ui.b.d(this.f177519c1);
            Collections.sort(this.f177538m0, new CardProfile.CardProfileComparator());
            this.f177555u1.removeMessages(7);
            this.f177555u1.sendEmptyMessage(7);
            if (VersionUtils.isOreo() && (currentFocus = getCurrentFocus()) != null) {
                currentFocus.clearFocus();
            }
            if (this.f177533j1) {
                this.f177533j1 = false;
                startTitleProgress();
                if (!NetworkUtil.isNetSupport(this)) {
                    this.f177555u1.sendEmptyMessageDelayed(2, 1000L);
                    return;
                }
                w3(true);
            }
        }
        this.f177522e0.setSelectionFromTop(0, -this.C1.f177608d);
        if (this.f177552t0) {
            int n3 = this.f177516b0.n();
            int i16 = this.f177521d1;
            if (n3 != i16) {
                this.f177516b0.setSelectedTab(i16, false);
            }
            int n16 = this.P0.n();
            int i17 = this.f177521d1;
            if (n16 != i17) {
                this.P0.setSelectedTab(i17, false);
            }
        }
    }

    @Override // com.tencent.widget.SwipListView.SwipListListener
    public void updateCurShowRightView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) view);
            return;
        }
        int i3 = -1;
        if (view != null) {
            Object tag = view.getTag(-1);
            if (tag instanceof Integer) {
                i3 = ((Integer) tag).intValue();
            }
        }
        this.L1 = i3;
    }

    public void v3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        try {
            this.f177536l0.j(this.f177538m0);
            this.f177536l0.notifyDataSetChanged();
        } catch (Exception e16) {
            QLog.e("VisitorsActivity", 1, "updateFavData fail.", e16);
        }
    }

    boolean w3(boolean z16) {
        String currentAccountUin = this.app.getCurrentAccountUin();
        if (z16) {
            this.f177540n0 = true;
            this.f177544p0 = -1L;
            this.f177531i1.W2(currentAccountUin, this.f177514a0, 0L, 30);
        } else {
            long j3 = this.f177544p0;
            if (j3 > -1) {
                this.f177531i1.W2(currentAccountUin, this.f177514a0, j3, 30);
            }
        }
        return true;
    }

    public void x3(long j3) {
        v vVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, j3);
            return;
        }
        SwipListView swipListView = this.f177522e0;
        if (this.f177521d1 == 1) {
            vVar = this.f177536l0;
        } else {
            vVar = this.f177524f0;
        }
        int childCount = swipListView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            Object tag = swipListView.getChildAt(i3).getTag();
            if (tag != null && (tag instanceof s)) {
                s sVar = (s) tag;
                Object obj = sVar.f177607o;
                if ((obj instanceof CardProfile) && ((CardProfile) obj).lEctID == j3) {
                    vVar.d(obj, sVar);
                    return;
                }
            }
        }
    }

    void y3(int i3, int i16, int i17) {
        if (!this.f177552t0) {
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("VisitorsActivity", 2, "updateRank todayVoteRank=" + i3 + ", todayVoteRank=" + i16 + ", totalVoteCount=" + i17);
        }
        Message obtainMessage = this.f177555u1.obtainMessage(10);
        obtainMessage.arg1 = i3;
        obtainMessage.arg2 = i16;
        Bundle bundle = new Bundle();
        bundle.putInt("totalVoteCount", i17);
        obtainMessage.setData(bundle);
        if (this.V0) {
            this.f177555u1.sendMessageDelayed(obtainMessage, 200L);
        } else {
            this.f177555u1.sendMessage(obtainMessage);
        }
    }

    void z3() {
        RedTouchItem j3 = this.f177548r0.j(BusinessInfoCheckUpdateItem.UIAPPID_ME_PROFILE_LIKE_RANDKINGLIST);
        if (this.f177548r0.d(j3, false)) {
            if (QLog.isColorLevel()) {
                QLog.d("VisitorsActivity", 2, "updateRedPoint level:" + j3.passThroughLevel);
            }
            this.G0.setVisibility(0);
        }
    }
}

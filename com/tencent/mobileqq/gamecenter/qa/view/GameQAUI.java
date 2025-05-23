package com.tencent.mobileqq.gamecenter.qa.view;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi;
import com.tencent.mobileqq.gamecenter.qa.data.GameStrategyChannelEntry;
import com.tencent.mobileqq.gamecenter.qa.fragment.GameQuestionExpertListFragment;
import com.tencent.mobileqq.gamecenter.qa.model.GameListItem;
import com.tencent.mobileqq.gamecenter.qa.model.GameQuestionUserInfo;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotPanelApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import fe1.b;
import gp3.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameQAUI implements View.OnClickListener, ViewPager.OnPageChangeListener, Handler.Callback, b.a, TextWatcher {
    private com.tencent.mobileqq.gamecenter.qa.model.d A0;
    private volatile boolean B0;
    private View C;
    private View D;
    private boolean D0;
    private TextView E;
    private boolean E0;
    private XListView F;
    private boolean F0;
    private View G;
    private long G0;
    private View H;
    private long H0;
    private View I;
    private boolean I0;
    private View J;
    private TextView K;
    private boolean K0;
    private View L;
    private boolean L0;
    private boolean M0;
    private boolean N0;
    private int O0;
    private ImageView P;
    private boolean P0;
    private View Q;
    private boolean Q0;
    private RelativeLayout R;
    private RelativeLayout S;
    private ImageView T;
    private ImageView U;
    private TextView V;
    private ImageView W;
    private TextView X;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private ImageView f212763a0;

    /* renamed from: b0, reason: collision with root package name */
    private View f212764b0;

    /* renamed from: c0, reason: collision with root package name */
    private RelativeLayout f212765c0;

    /* renamed from: d, reason: collision with root package name */
    private QBaseActivity f212766d;

    /* renamed from: d0, reason: collision with root package name */
    private TextView f212767d0;

    /* renamed from: e, reason: collision with root package name */
    private RelativeLayout f212768e;

    /* renamed from: e0, reason: collision with root package name */
    private ImageView f212769e0;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f212770f;

    /* renamed from: f0, reason: collision with root package name */
    private View f212771f0;

    /* renamed from: g0, reason: collision with root package name */
    private TextView f212772g0;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f212773h;

    /* renamed from: h0, reason: collision with root package name */
    private TextView f212774h0;

    /* renamed from: i, reason: collision with root package name */
    private sd1.e f212775i;

    /* renamed from: i0, reason: collision with root package name */
    private EditText f212776i0;

    /* renamed from: j0, reason: collision with root package name */
    private TextView f212777j0;

    /* renamed from: l0, reason: collision with root package name */
    private GameQuestionListAdapter f212779l0;

    /* renamed from: m, reason: collision with root package name */
    private AutoSwitchVerticalViewPager f212780m;

    /* renamed from: m0, reason: collision with root package name */
    private n f212781m0;

    /* renamed from: n0, reason: collision with root package name */
    private h f212782n0;

    /* renamed from: o0, reason: collision with root package name */
    private vd1.b f212783o0;

    /* renamed from: p0, reason: collision with root package name */
    private long f212784p0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f212786r0;

    /* renamed from: s0, reason: collision with root package name */
    private String f212787s0;

    /* renamed from: u0, reason: collision with root package name */
    private int f212789u0;

    /* renamed from: v0, reason: collision with root package name */
    private com.tencent.mobileqq.gamecenter.qa.model.e f212790v0;

    /* renamed from: w0, reason: collision with root package name */
    private int f212791w0;

    /* renamed from: x0, reason: collision with root package name */
    private String f212792x0;

    /* renamed from: y0, reason: collision with root package name */
    private Handler f212793y0;

    /* renamed from: z0, reason: collision with root package name */
    private com.tencent.mobileqq.gamecenter.qa.model.d f212794z0;
    private ImageView[] M = new ImageView[3];
    private ImageView[] N = new ImageView[3];

    /* renamed from: k0, reason: collision with root package name */
    private fe1.c f212778k0 = new fe1.c();

    /* renamed from: q0, reason: collision with root package name */
    private int f212785q0 = 1;

    /* renamed from: t0, reason: collision with root package name */
    private List<com.tencent.mobileqq.gamecenter.qa.model.b> f212788t0 = new ArrayList();
    private long C0 = 60000;
    private List<Long> J0 = new ArrayList();
    private final OverScrollViewListener R0 = new a();
    private fe1.d S0 = new fe1.a() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameQAUI.2
        @Override // fe1.a, fe1.d
        public void onCheckAtRobot(long j3, boolean z16) {
            QLog.d("GameQAUI", 1, "onCheckAtRobot, errorCode=", Long.valueOf(j3), ", isAvailable=", Boolean.valueOf(z16));
            GameQAUI.this.K0 = z16;
        }

        @Override // fe1.a, fe1.d
        public void onExpertOnlineHeartbeat(long j3, int i3) {
            QLog.d("GameQAUI", 1, "onExpertOnlineHeartbeat, errorCode=", Long.valueOf(j3), ", interval=", Integer.valueOf(i3));
            if (j3 != 0 || i3 <= 0) {
                GameQAUI.this.C0 = 60000L;
            } else {
                GameQAUI.this.C0 = i3 * 1000;
            }
        }

        @Override // fe1.a, fe1.d
        public void onGetAuthWhite(long j3, String str, int i3, boolean z16) {
            QLog.d("GameQAUI", 1, "onGetAuthWhite, errorCode=", Long.valueOf(j3), ", isWhite=", Boolean.valueOf(z16));
            GameQAUI.this.D0 = z16;
            GameQAUI.this.E0 = true;
            if (GameQAUI.this.D0 && !GameQAUtil.u()) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameQAUI.2.8
                    @Override // java.lang.Runnable
                    public void run() {
                        GameQAUI.this.O0();
                    }
                });
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameQAUI.2.9
                @Override // java.lang.Runnable
                public void run() {
                    GameQAUI.this.R();
                }
            });
        }

        @Override // fe1.a, fe1.d
        public void onGetBindInfoRsp(final long j3, final int i3, final String str) {
            QLog.d("GameQAUI", 1, "onGetBindInfoRsp, errorCode=", Long.valueOf(j3), ", appid=", Integer.valueOf(i3), ", robotId=", str);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameQAUI.2.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j3 == 0) {
                        GameQAUI.this.v0(i3, str);
                    } else {
                        QQToast.makeText(BaseApplication.getContext(), "\u62c9\u53d6\u6e38\u620f\u4fe1\u606f\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!", 0).show();
                    }
                }
            });
        }

        @Override // fe1.a, fe1.d
        public void onGetExpertList(long j3, com.tencent.mobileqq.gamecenter.qa.model.e eVar) {
            super.onGetExpertList(j3, eVar);
            QLog.d("GameQAUI", 1, "onGetExpertList, errorCode=", Long.valueOf(j3));
            if (j3 == 0 && eVar != null && eVar.f212643d == 0) {
                GameQAUI.this.f212790v0 = eVar;
                GameQAUI.this.F0 = true;
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameQAUI.2.5
                    @Override // java.lang.Runnable
                    public void run() {
                        GameQAUI.this.U0();
                        GameQAUI.this.R();
                    }
                });
            }
        }

        @Override // fe1.a, fe1.d
        public void onGetNoAnswer(long j3, final com.tencent.mobileqq.gamecenter.qa.model.g gVar) {
            QLog.d("GameQAUI", 1, "onGetNoAnswer, errorCode=", Long.valueOf(j3), ", result=", gVar);
            if (gVar != null) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameQAUI.2.6
                    @Override // java.lang.Runnable
                    public void run() {
                        GameQAUI gameQAUI = GameQAUI.this;
                        com.tencent.mobileqq.gamecenter.qa.model.g gVar2 = gVar;
                        gameQAUI.Y0(gVar2.f212648a, gVar2.f212649b);
                    }
                });
            } else {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameQAUI.2.7
                    @Override // java.lang.Runnable
                    public void run() {
                        GameQAUI.this.Y0(0L, null);
                    }
                });
            }
        }

        @Override // fe1.a, fe1.d
        public void onGetQuestionList(long j3, final com.tencent.mobileqq.gamecenter.qa.model.f fVar) {
            super.onGetQuestionList(j3, fVar);
            QLog.d("GameQAUI", 1, "onGetQuestionList, errorCode=", Long.valueOf(j3));
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameQAUI.2.4
                @Override // java.lang.Runnable
                public void run() {
                    if (GameQAUI.this.H.getVisibility() == 0) {
                        GameQAUI.this.F.springBackOverScrollHeaderView();
                    } else if (GameQAUI.this.I.getVisibility() == 0) {
                        GameQAUI.this.F.springBackOverScrollFooterView();
                    }
                    GameQAUI.this.Z0(fVar);
                }
            });
        }

        @Override // fe1.a, fe1.d
        public void onLikeAnswerRsp(long j3, final long j16, final long j17, final boolean z16, boolean z17) {
            QLog.d("GameQAUI", 1, "onGetQuestionList, errorCode=", Long.valueOf(j3), ", questionId=", Long.valueOf(j16), ", answerId=", Long.valueOf(j17), ", isLike=", Boolean.valueOf(z16), ", success=", Boolean.valueOf(z17));
            if (z17) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameQAUI.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        GameQAUI.this.V0(j16, j17, z16);
                    }
                });
            }
        }

        @Override // fe1.a, fe1.d
        public void onSetBindInfoRsp(final long j3, final int i3) {
            QLog.d("GameQAUI", 1, "onSetBindInfoRsp, errorCode=", Long.valueOf(j3), ", appid=", Integer.valueOf(i3));
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameQAUI.2.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    GameQAUI gameQAUI = GameQAUI.this;
                    if (j3 == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    gameQAUI.d1(z16, i3);
                }
            });
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f212823d;

        b(int i3) {
            this.f212823d = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) GameQAUI.this.C.getLayoutParams();
            layoutParams.bottomMargin = intValue;
            GameQAUI.this.C.setLayoutParams(layoutParams);
            if (intValue == this.f212823d) {
                GameQAUI.this.C.setVisibility(8);
                GameQAUI.this.F.setVisibility(8);
                GameQAUI.this.G.setVisibility(8);
                GameQAUI.this.D.setVisibility(0);
                GameQAUI.this.f212780m.setVisibility(0);
                GameQAUI.this.f212780m.c(5000L);
                return;
            }
            if (intValue == 0) {
                GameQAUI.this.C.setVisibility(4);
            }
        }
    }

    public GameQAUI(sd1.e eVar) {
        this.f212775i = eVar;
    }

    private void B0() {
        String format;
        String str;
        if (!TextUtils.isEmpty(this.f212792x0)) {
            format = String.format(this.f212792x0, Integer.valueOf(this.f212783o0.f441458c));
        } else {
            format = String.format("https://youxi.gamecenter.qq.com/ogame/game-strategy-qa/home.html?_tde_id=7137&appid=%s&_wv=131073&_wwv=132&_fv=0&gamecenter_src=pindao", Integer.valueOf(this.f212783o0.f441458c));
        }
        GameQAUtil.x(this.f212766d, this.f212783o0.f441458c, format);
        GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
        vd1.b bVar = this.f212783o0;
        gameStrategyChannelEntry.guildId = bVar.f441456a;
        gameStrategyChannelEntry.channelId = bVar.f441457b;
        if (this.H0 == 0) {
            str = "907090";
        } else {
            str = "907234";
        }
        com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", str, "20", String.valueOf(bVar.f441458c), GameQAUtil.i(this.f212766d, gameStrategyChannelEntry));
    }

    private void C0() {
        QLog.d("GameQAUI", 1, "queryChannelBindInfoAsync");
        K();
        this.f212778k0.Z0(this.S0);
        fe1.c cVar = this.f212778k0;
        vd1.b bVar = this.f212783o0;
        cVar.N(bVar.f441456a, bVar.f441457b);
    }

    private void D0() {
        QLog.d("GameQAUI", 1, "resetData: " + this);
        this.f212784p0 = 0L;
        List<com.tencent.mobileqq.gamecenter.qa.model.b> list = this.f212788t0;
        if (list != null) {
            list.clear();
        }
        this.f212790v0 = null;
    }

    private void F0(final ImageView imageView, String str) {
        if (imageView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            imageView.setImageResource(R.drawable.f160830com);
            return;
        }
        Bitmap b16 = gp3.e.a().b(str);
        if (b16 != null) {
            imageView.setImageBitmap(b16);
        } else {
            gp3.e.a().c(str, new e.b() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameQAUI.4
                @Override // gp3.e.b
                public void onImageLoaded(String str2, final Bitmap bitmap, String str3) {
                    imageView.post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameQAUI.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            imageView.setImageBitmap(bitmap);
                        }
                    });
                }
            });
        }
    }

    private void G0() {
        EditText editText = this.f212776i0;
        if (editText != null) {
            String obj = editText.getText().toString();
            if ("@\u6e38\u620f\u95ee\u7b54\u52a9\u624b".equals(obj.trim())) {
                try {
                    this.f212776i0.setSelection(obj.length());
                } catch (Exception e16) {
                    QLog.e("GameQAUI", 1, "setInputSelection, exception=", e16);
                }
            }
        }
    }

    private void I() {
        QLog.d("GameQAUI", 1, "checkAtRobot");
        if (GameQAUtil.v(this.f212783o0.f441458c)) {
            K();
            this.f212778k0.Z0(this.S0);
            fe1.c cVar = this.f212778k0;
            vd1.b bVar = this.f212783o0;
            cVar.J(bVar.f441456a, bVar.f441457b);
        }
    }

    private void I0() {
        EditText editText;
        this.f212765c0.setVisibility(8);
        this.f212771f0.setVisibility(0);
        if (!this.M0 && (editText = this.f212776i0) != null) {
            editText.addTextChangedListener(this);
            this.M0 = true;
        }
        com.tencent.mobileqq.gamecenter.qa.util.f.c();
    }

    private void J() {
        QLog.d("GameQAUI", 1, "checkGameAppid");
        this.f212764b0.setVisibility(0);
        h hVar = this.f212782n0;
        if (hVar != null) {
            hVar.h();
        }
        if (GameQAUtil.v(this.f212783o0.f441458c)) {
            QLog.d("GameQAUI", 1, "checkGameAppid, valid appid from jump uri");
            this.f212764b0.setVisibility(8);
            return;
        }
        vd1.b bVar = this.f212783o0;
        int f16 = GameQAUtil.f(bVar.f441456a, bVar.f441457b);
        if (GameQAUtil.v(f16)) {
            QLog.d("GameQAUI", 1, "checkGameAppid, valid appid from local saved");
            b1(f16);
            this.f212764b0.setVisibility(8);
        } else {
            QLog.d("GameQAUI", 1, "checkGameAppid, query appid");
            C0();
        }
    }

    private void J0() {
        QLog.d("GameQAUI", 1, "showAssistantBubble, mShowAtAssistantBubble=", Boolean.valueOf(this.K0));
        if (!this.K0) {
            return;
        }
        View findViewById = ((ViewGroup) this.f212768e.getParent().getParent()).findViewById(R.id.sjm);
        if (findViewById != null && findViewById.getVisibility() == 0) {
            QLog.d("GameQAUI", 1, "showAssistantBubble, reply view visible");
            return;
        }
        if (this.f212773h == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.f212768e.getContext()).inflate(R.layout.ebo, (ViewGroup) this.f212768e, false);
            this.f212773h = relativeLayout;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.addRule(9);
            int[] iArr = new int[2];
            ((ViewGroup) this.f212768e.getParent().getParent()).findViewById(R.id.vxi).getLocationOnScreen(iArr);
            layoutParams.topMargin = iArr[1] - ViewUtils.dpToPx(45.0f);
            this.f212768e.addView(this.f212773h, layoutParams);
        }
        this.f212773h.findViewById(R.id.f657239p).setOnClickListener(this);
        this.f212773h.setVisibility(0);
        GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
        vd1.b bVar = this.f212783o0;
        gameStrategyChannelEntry.guildId = bVar.f441456a;
        gameStrategyChannelEntry.channelId = bVar.f441457b;
        com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907437", "8", String.valueOf(bVar.f441458c), GameQAUtil.i(this.f212766d, gameStrategyChannelEntry));
    }

    private void K() {
        if (this.f212778k0 == null) {
            this.f212778k0 = new fe1.c();
        }
    }

    private void K0() {
        ValueAnimator ofInt = ValueAnimator.ofInt(Z(), 0);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.m
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GameQAUI.this.p0(valueAnimator);
            }
        });
        ofInt.start();
    }

    private void L() {
        EditText editText;
        if (this.O0 == 2 && (editText = this.f212776i0) != null) {
            editText.removeTextChangedListener(this);
            this.M0 = false;
            if ("@\u6e38\u620f\u95ee\u7b54\u52a9\u624b".equals(this.f212776i0.getText().toString().trim())) {
                this.f212776i0.setText("");
            }
        }
    }

    private void L0() {
        if (this.R.getVisibility() == 0) {
            RelativeLayout relativeLayout = this.R;
            relativeLayout.startAnimation(X(relativeLayout));
        }
        if (this.S.getVisibility() == 0) {
            RelativeLayout relativeLayout2 = this.S;
            relativeLayout2.startAnimation(X(relativeLayout2));
        }
    }

    private void M0(com.tencent.mobileqq.gamecenter.qa.model.d dVar) {
        if (dVar == null) {
            return;
        }
        GameQuestionUserInfo gameQuestionUserInfo = dVar.f212638c;
        if (gameQuestionUserInfo != null) {
            this.V.setText(gameQuestionUserInfo.name);
            F0(this.W, dVar.f212638c.avatar);
        } else {
            this.V.setText("");
        }
        this.X.setText(W(dVar));
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.12f, 1, 0.0f);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setDuration(250L);
        this.R.setVisibility(0);
        this.S.setVisibility(4);
        this.R.startAnimation(translateAnimation);
    }

    private void N0(com.tencent.mobileqq.gamecenter.qa.model.d dVar) {
        if (dVar == null) {
            return;
        }
        GameQuestionUserInfo gameQuestionUserInfo = dVar.f212638c;
        if (gameQuestionUserInfo != null) {
            this.Y.setText(gameQuestionUserInfo.name);
            F0(this.f212763a0, dVar.f212638c.avatar);
        } else {
            this.Y.setText("");
        }
        this.Z.setText(W(dVar));
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setDuration(250L);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameQAUI.8
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ApngOptions apngOptions = new ApngOptions();
                apngOptions.setRequestHeight(ViewUtils.dpToPx(241.0f));
                apngOptions.setRequestWidth(ViewUtils.dpToPx(53.0f));
                apngOptions.setLoop(1);
                apngOptions.setUseCache(false);
                Drawable dynamicDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable("https://img.gamecenter.qq.com/xgame/gm/1649665007581_67d9745fec860f9b2004d519f1ea4aa4.png", apngOptions, "");
                GameQAUI.this.U.setVisibility(0);
                GameQAUI.this.U.setImageDrawable(dynamicDrawable);
                GameQAUI.this.T.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameQAUI.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GameQAUI.this.T.setVisibility(4);
                        GameQAUI.this.U.setVisibility(4);
                    }
                }, 1200L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.S.setVisibility(0);
        this.S.startAnimation(translateAnimation);
        this.U.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameQAUI.9
            @Override // java.lang.Runnable
            public void run() {
                GameQAUI.this.U.setVisibility(4);
                ApngOptions apngOptions = new ApngOptions();
                apngOptions.setRequestHeight(ViewUtils.dpToPx(113.0f));
                apngOptions.setRequestWidth(ViewUtils.dpToPx(87.0f));
                apngOptions.setLoop(1);
                apngOptions.setUseCache(false);
                Drawable dynamicDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable("https://img.gamecenter.qq.com/xgame/gm/1646121252689_ffbfc088e3a45bb1d4bbfa0fe5ae6352.png", apngOptions, "");
                GameQAUI.this.T.setVisibility(0);
                GameQAUI.this.T.setImageDrawable(dynamicDrawable);
            }
        }, 150L);
        GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
        vd1.b bVar = this.f212783o0;
        gameStrategyChannelEntry.guildId = bVar.f441456a;
        gameStrategyChannelEntry.channelId = bVar.f441457b;
        com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907237", "8", String.valueOf(bVar.f441458c), GameQAUtil.i(this.f212766d, gameStrategyChannelEntry));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0() {
        QLog.d("GameQAUI", 1, "showExpertGuideBubble");
        this.Q.setVisibility(0);
        this.Q.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameQAUI.3
            @Override // java.lang.Runnable
            public void run() {
                GameQAUI.this.Q.setVisibility(8);
            }
        }, 5000L);
        GameQAUtil.H();
    }

    private void P() {
        QLog.d("GameQAUI", 1, "executeAskButtonTest, mIsExpertLoaded=", Boolean.valueOf(this.E0), ", mIsAskBtnExecuted=", Boolean.valueOf(this.N0));
        int a16 = com.tencent.mobileqq.gamecenter.qa.util.f.a();
        this.O0 = a16;
        QLog.d("GameQAUI", 1, "executeAskButtonTest, askButtonTestType=", Integer.valueOf(a16));
        int i3 = this.O0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    S();
                    return;
                }
                return;
            }
            R();
            return;
        }
        Q();
    }

    private void P0() {
        if (this.f212790v0 == null) {
            QQToast.makeText(this.f212766d, "\u6b63\u5728\u83b7\u53d6\u8ba4\u8bc1\u5927\u795e\u5217\u8868\uff0c\u8bf7\u7a0d\u5019!", 0).show();
            a0();
            return;
        }
        GameQuestionExpertListFragment gameQuestionExpertListFragment = new GameQuestionExpertListFragment(this.f212766d, ThemeUtil.isNowThemeIsNight(null, false, null));
        gameQuestionExpertListFragment.Rh(this.f212783o0);
        gameQuestionExpertListFragment.Oh(this.f212790v0);
        gameQuestionExpertListFragment.Ph(this.D0);
        this.f212766d.getSupportFragmentManager().beginTransaction().add(gameQuestionExpertListFragment, "GameQAUI").commit();
        GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
        vd1.b bVar = this.f212783o0;
        gameStrategyChannelEntry.guildId = bVar.f441456a;
        gameStrategyChannelEntry.channelId = bVar.f441457b;
        com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907091", "20", String.valueOf(bVar.f441458c), GameQAUtil.i(this.f212766d, gameStrategyChannelEntry));
    }

    private void Q() {
        QLog.d("GameQAUI", 1, "executeAskButtonTestA");
        this.f212765c0.setVisibility(8);
        this.f212771f0.setVisibility(8);
        com.tencent.mobileqq.gamecenter.qa.util.f.c();
    }

    private void Q0() {
        QLog.d("GameQAUI", 1, "startHeartbeat");
        this.f212793y0.removeMessages(3);
        this.B0 = true;
        Handler handler = this.f212793y0;
        handler.sendMessage(handler.obtainMessage(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        boolean z16;
        String string;
        QLog.d("GameQAUI", 1, "executeAskButtonTestB, mAskBtnTestType=", Integer.valueOf(this.O0));
        if (this.O0 != 1 || this.f212775i == null) {
            return;
        }
        TextView textView = this.f212777j0;
        if (textView != null && textView.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("GameQAUI", 1, "executeAskButtonTestB, mIsExpert=", Boolean.valueOf(this.D0), ", isQASendBtnVisible=", Boolean.valueOf(z16), ", mIsAskBtnTestBExecuted=", Boolean.valueOf(this.N0), ", mIsExpertLoaded=", Boolean.valueOf(this.E0), ", mExpertOnlineStatusUpdated=", Boolean.valueOf(this.F0));
        if (!this.N0 && !this.D0 && z16 && this.F0 && this.E0) {
            Resources resources = this.f212765c0.getResources();
            if (!GameQAUtil.r()) {
                string = resources.getString(R.string.f1368505_);
                GameQAUtil.F();
            } else if (!g0()) {
                QLog.d("GameQAUI", 1, "executeAskButtonTestB, no expert online");
                return;
            } else if (!GameQAUtil.J()) {
                QLog.d("GameQAUI", 1, "executeAskButtonTestB, max count, abort");
                return;
            } else {
                GameQAUtil.p();
                string = resources.getString(R.string.f1368605a);
            }
            QLog.d("GameQAUI", 1, "executeAskButtonTestB, show");
            this.f212767d0.setText(string);
            this.f212765c0.setVisibility(0);
            this.f212771f0.setVisibility(8);
            this.f212769e0.setVisibility(0);
            ApngOptions apngOptions = new ApngOptions();
            apngOptions.setRequestHeight(ViewUtils.dpToPx(27.0f));
            apngOptions.setRequestWidth(ViewUtils.dpToPx(74.0f));
            apngOptions.setLoop(1);
            apngOptions.setUseCache(false);
            this.f212769e0.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable("https://img.gamecenter.qq.com/xgame/gm/1652173275072_e0884ed3dad53492125838800da45104.png", apngOptions, ""));
            this.f212769e0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.k
                @Override // java.lang.Runnable
                public final void run() {
                    GameQAUI.this.m0();
                }
            }, 2000L);
            this.f212765c0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.l
                @Override // java.lang.Runnable
                public final void run() {
                    GameQAUI.this.n0();
                }
            }, 4000L);
            this.N0 = true;
            com.tencent.mobileqq.gamecenter.qa.util.f.c();
            GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
            vd1.b bVar = this.f212783o0;
            gameStrategyChannelEntry.guildId = bVar.f441456a;
            gameStrategyChannelEntry.channelId = bVar.f441457b;
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907907", "8", String.valueOf(bVar.f441458c), GameQAUtil.i(this.f212766d, gameStrategyChannelEntry));
        }
    }

    private void R0() {
        QLog.d("GameQAUI", 1, "stopHeartbeat");
        this.f212793y0.removeMessages(3);
        this.B0 = false;
        Handler handler = this.f212793y0;
        handler.sendMessage(handler.obtainMessage(3));
    }

    private void S() {
        QLog.d("GameQAUI", 1, "executeAskButtonTestC");
        I0();
    }

    private void S0() {
        this.f212793y0.removeMessages(1);
    }

    private void T(boolean z16) {
        if (z16) {
            int Z = Z();
            ValueAnimator ofInt = ValueAnimator.ofInt(0, Z);
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.addUpdateListener(new b(Z));
            ofInt.start();
            return;
        }
        if (this.f212779l0.getCount() == 0) {
            return;
        }
        this.F.setVisibility(0);
        this.G.setVisibility(0);
        this.C.setVisibility(4);
        this.D.setVisibility(8);
        this.f212780m.setVisibility(8);
        this.f212780m.g();
        K0();
        GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
        vd1.b bVar = this.f212783o0;
        gameStrategyChannelEntry.guildId = bVar.f441456a;
        gameStrategyChannelEntry.channelId = bVar.f441457b;
        com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907101", "8", String.valueOf(bVar.f441458c), GameQAUtil.i(this.f212766d, gameStrategyChannelEntry));
    }

    private void T0() {
        b0();
        d0();
        Q0();
        a0();
        I();
        P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        com.tencent.mobileqq.gamecenter.qa.model.e eVar = this.f212790v0;
        if (eVar != null && eVar.f212640a.size() > 0) {
            QLog.d("GameQAUI", 1, "updateExpertHeadIcon, size=", Integer.valueOf(this.f212790v0.f212640a.size()));
            int size = this.f212790v0.f212640a.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.tencent.mobileqq.gamecenter.qa.model.d dVar = this.f212790v0.f212640a.get(i3);
                GameQuestionUserInfo gameQuestionUserInfo = dVar.f212638c;
                if (gameQuestionUserInfo != null && !TextUtils.isEmpty(gameQuestionUserInfo.avatar)) {
                    this.M[i3].setVisibility(0);
                    this.N[i3].setVisibility(0);
                    F0(this.M[i3], dVar.f212638c.avatar);
                }
                if (i3 == 2) {
                    break;
                }
            }
            if (size < 3) {
                this.M[2].setVisibility(8);
                this.N[2].setVisibility(8);
                this.P.setVisibility(8);
            }
            if (size < 2) {
                this.M[1].setVisibility(8);
                this.N[1].setVisibility(8);
                return;
            }
            return;
        }
        this.M[0].setVisibility(8);
        this.M[1].setVisibility(8);
        this.M[2].setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(long j3, long j16, boolean z16) {
        List<com.tencent.mobileqq.gamecenter.qa.model.b> a16 = this.f212779l0.a();
        if (a16 != null) {
            Iterator<com.tencent.mobileqq.gamecenter.qa.model.b> it = a16.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.mobileqq.gamecenter.qa.model.b next = it.next();
                if (next.f212615a.f212617a == j3) {
                    com.tencent.mobileqq.gamecenter.qa.model.a aVar = next.f212616b;
                    if (aVar.f212598a == j16) {
                        aVar.f212609l = z16;
                        if (z16) {
                            aVar.f212606i++;
                        } else {
                            aVar.f212606i--;
                        }
                    }
                }
            }
            this.f212779l0.e(a16);
            this.f212779l0.notifyDataSetChanged();
        }
    }

    private String W(com.tencent.mobileqq.gamecenter.qa.model.d dVar) {
        if (dVar != null) {
            long j3 = dVar.f212636a;
            if (j3 > 0 && dVar.f212637b > 0) {
                return String.format("\u5171\u56de\u7b54%s\u4e2a\u95ee\u9898\uff0c\u83b7\u5f97%s\u4e2a\u8d5e", GameQAUtil.l(j3), GameQAUtil.l(dVar.f212637b));
            }
            if (j3 > 0 && dVar.f212637b <= 0) {
                return String.format("\u5171\u56de\u7b54%s\u4e2a\u95ee\u9898", GameQAUtil.l(j3));
            }
            if (j3 <= 0) {
                long j16 = dVar.f212637b;
                if (j16 > 0) {
                    return String.format("\u5171\u83b7\u5f97%s\u4e2a\u8d5e", GameQAUtil.l(j16));
                }
            }
            return "\u5feb\u53bb\u8bf7\u6559\u95ee\u9898\u5427~";
        }
        return "";
    }

    private void W0(com.tencent.mobileqq.gamecenter.qa.model.d dVar) {
        if (dVar != null) {
            if (this.S.getVisibility() == 4) {
                this.A0 = dVar;
                N0(dVar);
                return;
            }
            com.tencent.mobileqq.gamecenter.qa.model.d dVar2 = this.A0;
            this.f212794z0 = dVar2;
            this.A0 = dVar;
            M0(dVar2);
            N0(dVar);
        }
    }

    private AnimationSet X(View view) {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -2.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(500L);
        animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new c(view));
        return animationSet;
    }

    private void X0() {
        QLog.d("GameQAUI", 1, "updateQAList");
        if (GameQAUtil.v(this.f212783o0.f441458c)) {
            this.f212787s0 = "view_0_" + (System.currentTimeMillis() / 1000);
            this.f212781m0.g(this.f212783o0);
            this.f212779l0.g(this.f212783o0);
            this.f212784p0 = 0L;
            c0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0(long j3, String str) {
        String str2;
        this.H0 = j3;
        if (j3 == 0) {
            this.K.setText("\u95ee\u7b54\u4e13\u533a");
        } else {
            this.K.setText(String.format("\u6709%s\u4e2a\u95ee\u9898\u5f85\u56de\u7b54", Long.valueOf(j3)));
        }
        if (!TextUtils.isEmpty(str)) {
            this.f212792x0 = str;
        } else {
            this.f212792x0 = "https://youxi.gamecenter.qq.com/ogame/game-strategy-qa/home.html?_tde_id=7137&appid=%s&_wv=131073&_wwv=132&_fv=0&gamecenter_src=pindao";
        }
        String deleteParameter = URLUtil.deleteParameter(this.f212792x0, "adtag");
        this.f212792x0 = deleteParameter;
        this.f212792x0 = URLUtil.addParameter(deleteParameter, "adtag", "pindao_unsolved");
        GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
        vd1.b bVar = this.f212783o0;
        gameStrategyChannelEntry.guildId = bVar.f441456a;
        gameStrategyChannelEntry.channelId = bVar.f441457b;
        if (j3 == 0) {
            str2 = "907232";
        } else {
            str2 = "907233";
        }
        com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", str2, "8", String.valueOf(bVar.f441458c), GameQAUtil.i(this.f212766d, gameStrategyChannelEntry));
    }

    private int Z() {
        if (this.f212791w0 == 0) {
            this.f212791w0 = (ViewUtils.getScreenHeight() - ViewUtils.dip2px(303.0f)) - ImmersiveUtils.getStatusBarHeight(this.f212766d);
        }
        return this.f212791w0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0(com.tencent.mobileqq.gamecenter.qa.model.f fVar) {
        QLog.d("GameQAUI", 1, "updateQuestionList");
        if (fVar != null) {
            long j3 = fVar.f212645b;
            this.f212784p0 = j3;
            this.f212786r0 = fVar.f212646c;
            QLog.d("GameQAUI", 1, "updateQuestionList, mNextPageIndex=", Long.valueOf(j3), ", mNextPageType=", Integer.valueOf(this.f212785q0), ", mIsPageFetchOver=", Boolean.valueOf(this.f212786r0));
            List<com.tencent.mobileqq.gamecenter.qa.model.b> list = fVar.f212644a;
            if (list != null && list.size() > 0) {
                QLog.d("GameQAUI", 1, "updateQuestionList, size=", Integer.valueOf(fVar.f212644a.size()));
                if (fVar.f212645b == 1) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(fVar.f212644a);
                    this.f212781m0.setData(arrayList);
                    this.f212781m0.notifyDataSetChanged();
                    this.f212780m.c(5000L);
                    this.f212788t0 = fVar.f212644a;
                    if (fVar.f212647d > 0) {
                        this.E.setText(GameQAUtil.m(fVar.f212647d) + "\u4e2a\u70ed\u95e8\u95ee\u7b54");
                    } else {
                        this.E.setText("\u6682\u65e0\u66f4\u591a\u95ee\u7b54");
                    }
                } else {
                    this.f212788t0.addAll(fVar.f212644a);
                }
                QLog.d("GameQAUI", 1, "updateQuestionList, list size=", Integer.valueOf(this.f212788t0.size()));
                this.f212779l0.e(this.f212788t0);
                this.f212779l0.notifyDataSetChanged();
            }
        }
    }

    private void a0() {
        QLog.d("GameQAUI", 1, "getExpertList");
        if (GameQAUtil.v(this.f212783o0.f441458c)) {
            K();
            this.f212778k0.Z0(this.S0);
            fe1.c cVar = this.f212778k0;
            vd1.b bVar = this.f212783o0;
            cVar.Y(bVar.f441456a, bVar.f441457b, bVar.f441458c, 0, 20);
        }
    }

    private void b0() {
        QLog.d("GameQAUI", 1, "getNoAnswerNum");
        vd1.b bVar = this.f212783o0;
        if (bVar != null && GameQAUtil.v(bVar.f441458c)) {
            K();
            this.f212778k0.Z0(this.S0);
            this.f212778k0.U(this.f212783o0.f441458c);
        }
    }

    private void b1(int i3) {
        vd1.b bVar = this.f212783o0;
        if (bVar != null) {
            bVar.f441458c = i3;
        }
        sd1.e eVar = this.f212775i;
        if (eVar != null) {
            eVar.o0(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        QLog.d("GameQAUI", 1, "getQuestionList, mNextPageIndex=", Long.valueOf(this.f212784p0));
        if (GameQAUtil.v(this.f212783o0.f441458c)) {
            K();
            this.f212778k0.Z0(this.S0);
            this.f212778k0.Z(this.f212783o0.f441458c, this.f212784p0, this.f212785q0, this.f212787s0, 15);
        }
    }

    private void c1() {
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(this.f212766d) + ViewUtils.dpToPx(44.0f);
        View findViewById = this.f212770f.findViewById(R.id.t6j);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        findViewById.setLayoutParams(layoutParams);
        View findViewById2 = this.f212770f.findViewById(R.id.u6r);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) findViewById2.getLayoutParams();
        layoutParams2.topMargin = statusBarHeight;
        findViewById2.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f212780m.getLayoutParams();
        layoutParams3.topMargin = statusBarHeight + ViewUtils.dpToPx(34.0f);
        this.f212780m.setLayoutParams(layoutParams3);
    }

    private void d0() {
        QLog.d("GameQAUI", 1, "getAuthWhite");
        if (GameQAUtil.v(this.f212783o0.f441458c)) {
            K();
            this.f212778k0.Z0(this.S0);
            fe1.c cVar = this.f212778k0;
            vd1.b bVar = this.f212783o0;
            cVar.M(bVar.f441457b, bVar.f441458c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1(boolean z16, int i3) {
        if (z16) {
            b1(i3);
            vd1.b bVar = this.f212783o0;
            GameQAUtil.E(bVar.f441456a, bVar.f441457b, i3);
            this.f212782n0.h();
            this.f212764b0.setVisibility(8);
            X0();
            T0();
            return;
        }
        QQToast.makeText(this.f212766d, "\u8bbe\u7f6e\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!", 0).show();
    }

    private void f0(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("GameQAUI", 2, "handleExpertOnlineMsg, msgContent=", str);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Long valueOf = Long.valueOf(jSONObject.optLong("Uin"));
            synchronized (this.J0) {
                if (this.J0.contains(valueOf)) {
                    QLog.w("GameQAUI", 2, "handleExpertOnlineMsg, duplicate uin, abort");
                    return;
                }
                this.J0.add(valueOf);
                com.tencent.mobileqq.gamecenter.qa.model.d dVar = new com.tencent.mobileqq.gamecenter.qa.model.d();
                GameQuestionUserInfo gameQuestionUserInfo = new GameQuestionUserInfo();
                gameQuestionUserInfo.uin = valueOf.longValue();
                gameQuestionUserInfo.name = jSONObject.optString("Nick");
                gameQuestionUserInfo.avatar = jSONObject.optString("Head");
                dVar.f212638c = gameQuestionUserInfo;
                dVar.f212637b = jSONObject.optLong("AnswerLike");
                dVar.f212636a = jSONObject.optLong("AnswerNum");
                QLog.d("GameQAUI", 1, "handleExpertOnlineMsg, expert=", dVar);
                long currentTimeMillis = System.currentTimeMillis();
                if (this.S.getVisibility() == 4) {
                    Message obtainMessage = this.f212793y0.obtainMessage(1);
                    obtainMessage.obj = dVar;
                    this.f212793y0.sendMessage(obtainMessage);
                    this.G0 = currentTimeMillis;
                    return;
                }
                long j3 = this.G0;
                if (currentTimeMillis - j3 >= 1450) {
                    Message obtainMessage2 = this.f212793y0.obtainMessage(1);
                    obtainMessage2.obj = dVar;
                    this.f212793y0.sendMessage(obtainMessage2);
                    this.G0 = currentTimeMillis;
                    return;
                }
                long j16 = 1450 - (currentTimeMillis - j3);
                Message obtainMessage3 = this.f212793y0.obtainMessage(1);
                obtainMessage3.obj = dVar;
                this.f212793y0.sendMessageDelayed(obtainMessage3, j16);
                this.G0 = currentTimeMillis + j16;
            }
        } catch (Exception e16) {
            QLog.e("GameQAUI", 1, "handleExpertOnlineMsg exception=", e16);
        }
    }

    private boolean g0() {
        List<com.tencent.mobileqq.gamecenter.qa.model.d> list;
        com.tencent.mobileqq.gamecenter.qa.model.e eVar = this.f212790v0;
        if (eVar != null && (list = eVar.f212640a) != null && list.size() > 0) {
            Iterator<com.tencent.mobileqq.gamecenter.qa.model.d> it = this.f212790v0.f212640a.iterator();
            while (it.hasNext()) {
                if (it.next().f212639d) {
                    return true;
                }
            }
        }
        return false;
    }

    private void i0() {
        QLog.d("GameQAUI", 1, "heartbeat");
        if (GameQAUtil.v(this.f212783o0.f441458c)) {
            K();
            this.f212778k0.Z0(this.S0);
            fe1.c cVar = this.f212778k0;
            vd1.b bVar = this.f212783o0;
            cVar.I0(bVar.f441456a, bVar.f441457b, bVar.f441458c);
        }
    }

    private void j0() {
        QLog.d("GameQAUI", 1, "hideAssistantBubble");
        RelativeLayout relativeLayout = this.f212773h;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    private void l0() {
        QLog.d("GameQAUI", 1, "insertAtQAAssistant");
        j0();
        ((IGuildRobotPanelApi) QRoute.api(IGuildRobotPanelApi.class)).insertAtSpan(this.f212766d, this.f212776i0, "144115218681192658", "\u6e38\u620f\u95ee\u7b54\u52a9\u624b", false);
        ((IGuildRobotPanelApi) QRoute.api(IGuildRobotPanelApi.class)).openRobotFunctionsPanel(this.f212776i0, "144115218681192658", null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0() {
        this.f212769e0.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0() {
        this.f212765c0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(AdapterView adapterView, View view, int i3, long j3) {
        GameQuestionListAdapter gameQuestionListAdapter = this.f212779l0;
        if (gameQuestionListAdapter != null) {
            this.L0 = true;
            com.tencent.mobileqq.gamecenter.qa.model.b item = gameQuestionListAdapter.getItem(i3);
            GameQAUtil.z(this.f212766d, this.f212783o0.f441458c, item.f212615a.f212617a);
            GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
            vd1.b bVar = this.f212783o0;
            gameStrategyChannelEntry.guildId = bVar.f441456a;
            gameStrategyChannelEntry.channelId = bVar.f441457b;
            Map<Integer, String> j16 = GameQAUtil.j(this.f212766d, gameStrategyChannelEntry, item.f212615a.f212617a);
            j16.put(4, String.valueOf(item.f212616b.f212598a));
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907103", "20", String.valueOf(this.f212783o0.f441458c), j16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(ValueAnimator valueAnimator) {
        com.tencent.mobileqq.gamecenter.qa.model.b bVar;
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        layoutParams.bottomMargin = intValue;
        this.C.setLayoutParams(layoutParams);
        if (intValue == 0) {
            this.C.setVisibility(0);
            if (this.f212781m0.getF373114d() > 0) {
                List<com.tencent.mobileqq.gamecenter.qa.model.b> d16 = this.f212781m0.d();
                int currentItem = this.f212780m.getCurrentItem();
                if (d16 != null && currentItem < d16.size() && (bVar = d16.get(currentItem)) != null && bVar.f212615a != null) {
                    List<com.tencent.mobileqq.gamecenter.qa.model.b> a16 = this.f212779l0.a();
                    int size = a16.size();
                    for (final int i3 = 0; i3 < size; i3++) {
                        if (a16.get(i3).f212615a.f212617a == bVar.f212615a.f212617a) {
                            this.F.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.view.GameQAUI.6
                                @Override // java.lang.Runnable
                                public void run() {
                                    GameQAUI.this.F.setSelection(i3);
                                }
                            }, 200L);
                            return;
                        }
                    }
                }
            }
        }
    }

    private void r0() {
        QLog.d("GameQAUI", 1, "onAtAssistantBtnClick");
        this.f212771f0.setVisibility(8);
        EditText editText = this.f212776i0;
        if (editText == null) {
            return;
        }
        if (TextUtils.isEmpty(editText.getText().toString())) {
            ((IGuildRobotPanelApi) QRoute.api(IGuildRobotPanelApi.class)).insertAtSpan(this.f212766d, this.f212776i0, "144115218681192658", "\u6e38\u620f\u95ee\u7b54\u52a9\u624b", false);
        }
        this.f212776i0.requestFocus();
        ((InputMethodManager) this.f212766d.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(this.f212776i0, 0);
        GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
        vd1.b bVar = this.f212783o0;
        gameStrategyChannelEntry.guildId = bVar.f441456a;
        gameStrategyChannelEntry.channelId = bVar.f441457b;
        com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907908", "20", String.valueOf(bVar.f441458c), GameQAUtil.i(this.f212766d, gameStrategyChannelEntry));
    }

    private void s0() {
        QLog.d("GameQAUI", 1, "onAtExpertBtnClick");
        GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
        vd1.b bVar = this.f212783o0;
        gameStrategyChannelEntry.guildId = bVar.f441456a;
        gameStrategyChannelEntry.channelId = bVar.f441457b;
        ((IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class)).openGameStrategyQuestionDialog((QBaseActivity) U(), this.f212783o0.f441458c, gameStrategyChannelEntry);
        com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907909", "20", String.valueOf(this.f212783o0.f441458c), GameQAUtil.i(this.f212766d, gameStrategyChannelEntry));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(int i3, String str) {
        if (GameQAUtil.v(i3)) {
            b1(i3);
            vd1.b bVar = this.f212783o0;
            GameQAUtil.E(bVar.f441456a, bVar.f441457b, i3);
            this.f212764b0.setVisibility(8);
            X0();
            T0();
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        this.f212782n0.p(this.f212783o0, ((IQQGuildService) peekAppRuntime.getRuntimeService(IQQGuildService.class, "")).isCurrentGuildManager((AppInterface) peekAppRuntime, this.f212783o0.f441456a));
    }

    public void A0() {
        QLog.d("GameQAUI", 1, "onResume:" + this);
        if (this.I0) {
            QLog.d("GameQAUI", 1, "onResume, already resumed");
            return;
        }
        this.I0 = true;
        if (this.f212776i0 == null) {
            this.f212776i0 = (EditText) ((ViewGroup) this.f212768e.getParent().getParent()).findViewById(R.id.vxk);
        }
        if (this.f212777j0 == null) {
            this.f212777j0 = (TextView) ((ViewGroup) this.f212768e.getParent().getParent()).findViewById(R.id.f29770mj);
        }
        fe1.b.b().a(this);
        this.f212780m.c(5000L);
        this.f212770f.setVisibility(0);
        T0();
        h hVar = this.f212782n0;
        if (hVar != null) {
            hVar.i();
        }
        GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
        vd1.b bVar = this.f212783o0;
        gameStrategyChannelEntry.guildId = bVar.f441456a;
        gameStrategyChannelEntry.channelId = bVar.f441457b;
        com.tencent.mobileqq.gamecenter.qa.util.e.b("5", "122", "9072", "907201", "907089", "7", String.valueOf(bVar.f441458c), GameQAUtil.i(this.f212766d, gameStrategyChannelEntry), com.tencent.mobileqq.gamecenter.qa.util.f.b());
    }

    public void E0(int i3, String str) {
        K();
        this.f212778k0.Z0(this.S0);
        fe1.c cVar = this.f212778k0;
        vd1.b bVar = this.f212783o0;
        cVar.Y0(bVar.f441456a, bVar.f441457b, i3, str);
    }

    public void H0(GameListItem gameListItem) {
        h hVar;
        if (gameListItem != null && (hVar = this.f212782n0) != null) {
            hVar.o(gameListItem);
        }
    }

    public void M(sd1.e eVar) {
        this.f212775i = eVar;
    }

    public void O() {
        fe1.c cVar = this.f212778k0;
        if (cVar != null) {
            cVar.N0();
            this.f212778k0 = null;
        }
    }

    public Activity U() {
        return this.f212766d;
    }

    public int V() {
        return this.f212783o0.f441458c;
    }

    public int Y() {
        if (this.f212789u0 == 0) {
            this.f212789u0 = ImmersiveUtils.getStatusBarHeight(this.f212766d) + ViewUtils.dpToPx(98.0f);
        }
        return this.f212789u0;
    }

    @Override // fe1.b.a
    public void a(int i3, String str, String str2, String str3) {
        vd1.b bVar;
        if (i3 == 1 && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && (bVar = this.f212783o0) != null && str2.equals(bVar.f441456a) && str3.equals(this.f212783o0.f441457b)) {
            f0(str);
        }
    }

    public void a1(vd1.b bVar) {
        QLog.d("GameQAUI", 1, "updateSession, sessionInfo=", bVar);
        this.f212783o0 = bVar;
        J();
        X0();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String obj = editable.toString();
        if (TextUtils.isEmpty(obj)) {
            ((IGuildRobotPanelApi) QRoute.api(IGuildRobotPanelApi.class)).insertAtSpan(this.f212766d, this.f212776i0, "144115218681192658", "\u6e38\u620f\u95ee\u7b54\u52a9\u624b", false);
        } else if (!obj.startsWith("@\u6e38\u620f\u95ee\u7b54\u52a9\u624b")) {
            this.f212776i0.setText("");
        }
        if ("@\u6e38\u620f\u95ee\u7b54\u52a9\u624b".equals(obj.trim())) {
            this.f212793y0.removeMessages(4);
            Handler handler = this.f212793y0;
            handler.sendMessageDelayed(handler.obtainMessage(4), 300L);
        }
    }

    public RelativeLayout e0() {
        return this.f212770f;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            J0();
                            return false;
                        }
                        return false;
                    }
                    G0();
                    return false;
                }
                i0();
                if (this.B0) {
                    this.f212793y0.removeMessages(3);
                    Handler handler = this.f212793y0;
                    handler.sendMessageDelayed(handler.obtainMessage(3), this.C0);
                    return false;
                }
                return false;
            }
            L0();
            return false;
        }
        this.f212793y0.removeMessages(2);
        W0((com.tencent.mobileqq.gamecenter.qa.model.d) message.obj);
        Handler handler2 = this.f212793y0;
        handler2.sendMessageDelayed(handler2.obtainMessage(2), 3000L);
        return false;
    }

    public void k0() {
        QLog.d("GameQAUI", 1, "initView");
        this.f212768e.addView(this.f212770f);
        this.f212793y0 = new Handler(Looper.getMainLooper(), this);
        View findViewById = this.f212770f.findViewById(R.id.u6q);
        this.C = findViewById;
        findViewById.setOnClickListener(this);
        View findViewById2 = this.f212770f.findViewById(R.id.thn);
        this.D = findViewById2;
        findViewById2.setOnClickListener(this);
        this.E = (TextView) this.f212770f.findViewById(R.id.f113146pu);
        this.G = this.f212770f.findViewById(R.id.f1196077a);
        this.J = this.f212770f.findViewById(R.id.u7b);
        this.K = (TextView) this.f212770f.findViewById(R.id.f113256q5);
        this.J.setOnClickListener(this);
        View findViewById3 = this.f212770f.findViewById(R.id.u7_);
        this.L = findViewById3;
        findViewById3.setOnClickListener(this);
        XListView xListView = (XListView) this.f212770f.findViewById(R.id.yjp);
        this.F = xListView;
        xListView.setVerticalScrollBarEnabled(false);
        View inflate = LayoutInflater.from(this.f212766d).inflate(R.layout.f167990ec0, (ViewGroup) this.F, false);
        this.I = inflate;
        this.F.setOverScrollFooter(inflate);
        View inflate2 = LayoutInflater.from(this.f212766d).inflate(R.layout.f167990ec0, (ViewGroup) null);
        this.H = inflate2;
        this.F.setOverScrollHeader(inflate2);
        this.F.setOverScrollListener(this.R0);
        this.F.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.j
            @Override // com.tencent.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
                GameQAUI.this.o0(adapterView, view, i3, j3);
            }
        });
        GameQuestionListAdapter gameQuestionListAdapter = new GameQuestionListAdapter(this.f212766d);
        this.f212779l0 = gameQuestionListAdapter;
        gameQuestionListAdapter.d(this);
        this.F.setAdapter((ListAdapter) this.f212779l0);
        this.f212780m = (AutoSwitchVerticalViewPager) this.f212770f.findViewById(R.id.f1188675a);
        n nVar = new n(this.f212766d);
        this.f212781m0 = nVar;
        nVar.f(this);
        this.f212780m.setAdapter(this.f212781m0);
        this.f212780m.addOnPageChangeListener(this);
        this.M[0] = (ImageView) this.f212770f.findViewById(R.id.xjs);
        this.M[1] = (ImageView) this.f212770f.findViewById(R.id.xju);
        this.M[2] = (ImageView) this.f212770f.findViewById(R.id.xjw);
        this.N[0] = (ImageView) this.f212770f.findViewById(R.id.xjt);
        this.N[1] = (ImageView) this.f212770f.findViewById(R.id.xjv);
        this.N[2] = (ImageView) this.f212770f.findViewById(R.id.xjx);
        this.P = (ImageView) this.f212770f.findViewById(R.id.xeb);
        View findViewById4 = this.f212770f.findViewById(R.id.u6n);
        this.Q = findViewById4;
        findViewById4.setOnClickListener(this);
        this.Q.setVisibility(8);
        this.R = (RelativeLayout) this.f212770f.findViewById(R.id.vjp);
        this.S = (RelativeLayout) this.f212770f.findViewById(R.id.vjq);
        this.V = (TextView) this.R.findViewById(R.id.ke8);
        this.W = (ImageView) this.R.findViewById(R.id.xjr);
        this.X = (TextView) this.R.findViewById(R.id.f113046pk);
        this.Y = (TextView) this.S.findViewById(R.id.f113186py);
        this.Z = (TextView) this.S.findViewById(R.id.f113056pl);
        this.f212763a0 = (ImageView) this.S.findViewById(R.id.xjy);
        this.T = (ImageView) this.f212770f.findViewById(R.id.f165783xk4);
        this.U = (ImageView) this.f212770f.findViewById(R.id.xk5);
        this.f212764b0 = this.f212770f.findViewById(R.id.u69);
        this.f212782n0 = new h(this, new WeakReference(this.f212766d));
        this.f212765c0 = (RelativeLayout) this.f212770f.findViewById(R.id.u78);
        TextView textView = (TextView) this.f212770f.findViewById(R.id.f113246q4);
        this.f212767d0 = textView;
        textView.setOnClickListener(this);
        this.f212769e0 = (ImageView) this.f212770f.findViewById(R.id.xko);
        this.f212771f0 = this.f212770f.findViewById(R.id.u79);
        this.f212772g0 = (TextView) this.f212770f.findViewById(R.id.tcv);
        this.f212774h0 = (TextView) this.f212770f.findViewById(R.id.tcw);
        this.f212772g0.setOnClickListener(this);
        this.f212774h0.setOnClickListener(this);
        c1();
        D0();
        U0();
        this.f212779l0.e(null);
        this.f212781m0.setData(null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.u6q) {
            T(true);
            GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
            vd1.b bVar = this.f212783o0;
            gameStrategyChannelEntry.guildId = bVar.f441456a;
            gameStrategyChannelEntry.channelId = bVar.f441457b;
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907100", "20", String.valueOf(bVar.f441458c), GameQAUtil.i(this.f212766d, gameStrategyChannelEntry));
        } else if (id5 == R.id.thn) {
            T(false);
            GameStrategyChannelEntry gameStrategyChannelEntry2 = new GameStrategyChannelEntry();
            vd1.b bVar2 = this.f212783o0;
            gameStrategyChannelEntry2.guildId = bVar2.f441456a;
            gameStrategyChannelEntry2.channelId = bVar2.f441457b;
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907099", "20", String.valueOf(bVar2.f441458c), GameQAUtil.i(this.f212766d, gameStrategyChannelEntry2));
        } else if (id5 == R.id.u7b) {
            B0();
        } else if (id5 == R.id.u7_) {
            P0();
        } else if (id5 == R.id.u6n) {
            this.Q.setVisibility(8);
        } else if (id5 == R.id.f657239p) {
            l0();
            GameStrategyChannelEntry gameStrategyChannelEntry3 = new GameStrategyChannelEntry();
            vd1.b bVar3 = this.f212783o0;
            gameStrategyChannelEntry3.guildId = bVar3.f441456a;
            gameStrategyChannelEntry3.channelId = bVar3.f441457b;
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907438", "20", String.valueOf(bVar3.f441458c), GameQAUtil.i(this.f212766d, gameStrategyChannelEntry3));
        } else if (id5 == R.id.tcv) {
            r0();
        } else if (id5 == R.id.tcw) {
            s0();
        } else if (id5 == R.id.f113246q4) {
            this.f212765c0.setVisibility(8);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        if (this.f212780m.b()) {
            this.f212780m.g();
            this.f212780m.c(5000L);
        }
        com.tencent.mobileqq.gamecenter.qa.model.b e16 = this.f212781m0.e(i3);
        if (e16 != null && e16.f212615a != null) {
            GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
            vd1.b bVar = this.f212783o0;
            gameStrategyChannelEntry.guildId = bVar.f441456a;
            gameStrategyChannelEntry.channelId = bVar.f441457b;
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907095", "8", String.valueOf(bVar.f441458c), GameQAUtil.j(this.f212766d, gameStrategyChannelEntry, e16.f212615a.f212617a));
        }
    }

    public void q0(com.tencent.mobileqq.gamecenter.qa.model.b bVar) {
        QLog.d("GameQAUI", 1, "likeAnswer, card=", bVar);
        K();
        this.f212778k0.Z0(this.S0);
        this.f212778k0.M0(bVar.f212615a.f212617a, bVar.f212616b.f212598a, this.f212783o0.f441458c, !r11.f212609l);
    }

    public void t0(QBaseActivity qBaseActivity, RelativeLayout relativeLayout) {
        QLog.d("GameQAUI", 1, "onCreateView");
        this.f212766d = qBaseActivity;
        this.f212768e = relativeLayout;
        this.f212770f = (RelativeLayout) LayoutInflater.from(relativeLayout.getContext()).inflate(R.layout.ebq, (ViewGroup) relativeLayout, false);
    }

    public void u0() {
        QLog.d("GameQAUI", 1, "onDestroy: " + this);
        this.f212768e.removeView(this.f212770f);
        AutoSwitchVerticalViewPager autoSwitchVerticalViewPager = this.f212780m;
        if (autoSwitchVerticalViewPager != null) {
            autoSwitchVerticalViewPager.removeOnPageChangeListener(this);
        }
        h hVar = this.f212782n0;
        if (hVar != null) {
            hVar.destroy();
        }
        EditText editText = this.f212776i0;
        if (editText != null) {
            editText.removeTextChangedListener(this);
        }
        AutoSwitchVerticalViewPager autoSwitchVerticalViewPager2 = this.f212780m;
        if (autoSwitchVerticalViewPager2 != null) {
            autoSwitchVerticalViewPager2.a();
        }
        O();
        this.M0 = false;
        D0();
    }

    public void w0(boolean z16) {
        QLog.d("GameQAUI", 1, "onInputPanelChanged, show=", Boolean.valueOf(z16), ", mIsInputPanelVisible=", Boolean.valueOf(this.Q0));
        if (this.Q0 == z16) {
            return;
        }
        this.Q0 = z16;
        if (z16) {
            this.f212775i.V(ImmersiveUtils.getStatusBarHeight(this.f212766d) + ViewUtils.dpToPx(44.0f));
            this.f212765c0.setVisibility(8);
            this.f212770f.setVisibility(8);
            this.f212793y0.removeMessages(5);
            Handler handler = this.f212793y0;
            handler.sendMessageDelayed(handler.obtainMessage(5), 300L);
            return;
        }
        this.f212775i.V(Y());
        this.f212770f.setVisibility(0);
        this.f212793y0.removeMessages(5);
        j0();
        if (this.O0 == 2) {
            I0();
        }
    }

    public void x0(boolean z16) {
        if (z16) {
            if (this.f212771f0.getVisibility() == 0) {
                this.P0 = true;
                this.f212771f0.setVisibility(8);
                return;
            } else {
                this.P0 = false;
                return;
            }
        }
        if (this.P0 && !this.Q0) {
            S();
        }
    }

    public void z0() {
        QLog.d("GameQAUI", 1, "onPause: " + this);
        if (!this.I0) {
            QLog.d("GameQAUI", 1, "onPause, already paused");
            return;
        }
        this.I0 = false;
        synchronized (this.J0) {
            this.J0.clear();
        }
        fe1.b.b().d(this);
        this.f212780m.g();
        this.R.setVisibility(4);
        this.S.setVisibility(4);
        if (!this.L0) {
            T(true);
        }
        this.L0 = false;
        R0();
        S0();
        this.N0 = false;
        this.E0 = false;
        this.F0 = false;
        L();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f212825d;

        c(View view) {
            this.f212825d = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            View view = this.f212825d;
            if (view != null) {
                view.setVisibility(4);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public void N() {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements OverScrollViewListener {
        a() {
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public boolean onViewCompleteVisableAndReleased(int i3, View view, ListView listView) {
            QLog.d("GameQAUI", 1, "onViewCompleteVisableAndReleased, overScrollPosition=", Integer.valueOf(i3), ", overScrollerView=", view);
            if (view == GameQAUI.this.H) {
                GameQAUI.this.f212784p0 = 0L;
                GameQAUI.this.f212786r0 = false;
                GameQAUI.this.c0();
            } else if (view == GameQAUI.this.I) {
                if (!GameQAUI.this.f212786r0) {
                    GameQAUI.this.c0();
                } else {
                    GameQAUI.this.F.springBackOverScrollFooterView();
                }
            }
            return true;
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onNotCompleteVisable(int i3, View view, ListView listView) {
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onViewCompleteVisable(int i3, View view, ListView listView) {
        }

        @Override // com.tencent.widget.OverScrollViewListener
        public void onViewNotCompleteVisableAndReleased(int i3, View view, ListView listView) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }
}

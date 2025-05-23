package com.tencent.mobileqq.nearby.now;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.animation.AnimatorProxy;
import com.tencent.av.utils.ba;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.fling.FlingConstant;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.nearby.n;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.nearby.now.utils.IStorageCenter;
import com.tencent.mobileqq.nearby.now.view.CustomViewPager;
import com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.i;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SmallVideoFragment extends PublicBaseFragment implements DragFrameLayout.a, com.tencent.mobileqq.nearby.now.a {
    public StuffContainerView C;
    protected DragFrameLayout D;
    protected RelativeLayout E;
    protected CustomViewPager F;
    protected RelativeLayout G;
    protected QQStoryLoadingView H;
    protected View I;
    protected View J;
    protected int K;
    protected int L;
    protected int M;
    protected int N;
    protected AudioManager P;
    private boolean Q;
    private BaseActivity S;
    private String T;
    private Bundle U;
    public View Y;
    private boolean R = true;
    private int V = -1;
    private long W = 0;
    protected boolean X = false;
    protected AudioManager.OnAudioFocusChangeListener Z = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements StuffContainerView.f {
        a() {
        }

        @Override // com.tencent.mobileqq.nearby.now.view.StuffContainerView.f
        public void onClose(int i3) {
            String str;
            if (SmallVideoFragment.this.C.c() != null) {
                str = SmallVideoFragment.this.C.c().f252695e;
            } else {
                str = "0";
            }
            long j3 = SmallVideoFragment.this.C.c() != null ? SmallVideoFragment.this.C.c().D : 0L;
            if (QLog.isColorLevel()) {
                QLog.i("Native_ShortVideo_Report", 2, "onClickClose report module=short_video, action=view_click, obj1=6, res2=" + str + ", anchor=" + j3);
            }
            h hVar = (h) SmallVideoFragment.this.F.getAdapter();
            if (hVar.getView(SmallVideoFragment.this.F.getCurrentItem()) instanceof IShortVideoCommentsView) {
                ((com.tencent.mobileqq.nearby.now.view.b) ((IShortVideoCommentsView) hVar.getView(SmallVideoFragment.this.F.getCurrentItem()))).hideInputKeyboard();
            }
            SmallVideoFragment.this.wh();
        }
    }

    public static void launch(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("raw_url", str);
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("scroll_to_comment");
        String queryParameter2 = parse.getQueryParameter(ThemeConstants.THEME_DIY_BG_FROM_SUFFIX);
        if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("1")) {
            intent.putExtra("scroll_to_comment", true);
        }
        if (!TextUtils.isEmpty(queryParameter2)) {
            intent.putExtra(ThemeConstants.THEME_DIY_BG_FROM_SUFFIX, queryParameter2);
        }
        intent.addFlags(268435456);
        intent.putExtra("public_fragment_window_feature", 1);
        String queryParameter3 = parse.getQueryParameter("play_mode");
        if (!TextUtils.isEmpty(queryParameter3)) {
            intent.putExtra("play_mode", queryParameter3);
        }
        PublicTransFragmentActivity.start(context, intent, n.p());
    }

    private void sh() {
        this.C.setOnCloseListener(new a());
    }

    private void th(Bundle bundle) {
        if ("2".equals(bundle.getString("play_mode"))) {
            this.C.f(false);
        } else {
            this.C.f(true);
        }
    }

    private void uh() {
        this.G.setVisibility(0);
        this.H.setVisibility(0);
        this.H.c();
        if (!TextUtils.isEmpty(this.U.getString("imageUri"))) {
            this.T = this.U.getString("imageUri");
        } else if (!TextUtils.isEmpty(this.U.getString("cover_url"))) {
            this.T = this.U.getString("cover_url");
        }
        if (getBaseActivity().getIntent() != null) {
            int intExtra = getBaseActivity().getIntent().getIntExtra("system_msg_type", 0);
            boolean booleanExtra = getBaseActivity().getIntent().getBooleanExtra("scroll_to_comment", false);
            this.V = getBaseActivity().getIntent().getIntExtra("feedType", -1);
            if (intExtra == 2 || booleanExtra) {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.SmallVideoFragment.2
                    @Override // java.lang.Runnable
                    public void run() {
                        h hVar = (h) SmallVideoFragment.this.F.getAdapter();
                        if (hVar.getView(SmallVideoFragment.this.F.getCurrentItem()) instanceof IShortVideoCommentsView) {
                            ((IShortVideoCommentsView) hVar.getView(SmallVideoFragment.this.F.getCurrentItem())).scrollToComment();
                        }
                    }
                }, 1000L);
            }
        }
    }

    public static void vh(Context context, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.addFlags(268435456);
        intent.putExtra("public_fragment_window_feature", 1);
        PublicTransFragmentActivity.start(context, intent, n.p());
    }

    private boolean xh() {
        h hVar = (h) this.F.getAdapter();
        if (hVar.getView(this.F.getCurrentItem()) instanceof IShortVideoCommentsView) {
            return ((IShortVideoCommentsView) hVar.getView(this.F.getCurrentItem())).isScrollTop();
        }
        return false;
    }

    @Override // com.tencent.biz.qqstory.view.widget.DragFrameLayout.a
    public boolean C9() {
        if (this.F.getCurrentItem() == 0) {
            return xh();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.nearby.now.a
    public void Je() {
        View view = this.J;
        if (view != null) {
            view.setVisibility(8);
        }
        if (this.G.getVisibility() != 8) {
            this.E.setBackgroundDrawable(new ColorDrawable(-1));
            this.G.setVisibility(8);
            this.G.setBackgroundColor(0);
            QQStoryLoadingView qQStoryLoadingView = this.H;
            if (qQStoryLoadingView != null) {
                qQStoryLoadingView.d();
                this.H.setVisibility(8);
            }
        }
    }

    @Override // com.tencent.mobileqq.nearby.now.a
    public void U7() {
        QQStoryLoadingView qQStoryLoadingView = this.H;
        if (qQStoryLoadingView != null) {
            qQStoryLoadingView.d();
            this.H.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.qqstory.view.widget.DragFrameLayout.a
    public boolean bg() {
        if (!(this.F.getAdapter() instanceof h)) {
            return false;
        }
        int size = ((h) this.F.getAdapter()).f252886h.size();
        if (this.F.getAdapter().getF373114d() == 0 || this.F.getCurrentItem() >= size - 1) {
            return xh();
        }
        return false;
    }

    public View findViewById(int i3) {
        return this.Y.findViewById(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.axk;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        activity.getWindow().addFlags(128);
        activity.getWindow().setSoftInputMode(18);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.nearby.now.a
    public void o4() {
        if (this.P == null) {
            this.P = (AudioManager) getBaseActivity().getApplicationContext().getSystemService("audio");
        }
        try {
            int requestAudioFocus = this.P.requestAudioFocus(this.Z, 3, 2);
            if (requestAudioFocus == 0) {
                requestAudioFocus = this.P.requestAudioFocus(this.Z, 3, 1);
            }
            if (requestAudioFocus == 0) {
                this.P.requestAudioFocus(this.Z, 3, 3);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        this.C.g(i3, i16, intent);
        h hVar = (h) this.F.getAdapter();
        if (hVar.getView(this.F.getCurrentItem()) instanceof IShortVideoCommentsView) {
            ((IShortVideoCommentsView) hVar.getView(this.F.getCurrentItem())).onActivityResult(i3, i16, intent);
        }
        if (i16 == -1) {
            if (i3 != 123) {
                if (i3 == 124) {
                    final com.tencent.mobileqq.nearby.b bVar = (com.tencent.mobileqq.nearby.b) this.S.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.SmallVideoFragment.5
                        @Override // java.lang.Runnable
                        public void run() {
                            String str;
                            q h16 = new q(SmallVideoFragment.this.S.app).i("dc00899").a("grp_lbs").f("video").d("playpage_fw_suc").h(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getAnchorUin());
                            String[] strArr = new String[4];
                            strArr[0] = "4";
                            strArr[1] = String.valueOf(bVar.getSelfGender());
                            strArr[2] = ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getFrom();
                            if (TextUtils.equals(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getFrom(), "2")) {
                                str = ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getFeedId();
                            } else {
                                str = "";
                            }
                            strArr[3] = str;
                            h16.b(strArr).g();
                        }
                    }, 16, null, false);
                    return;
                }
                return;
            }
            Intent intent2 = new Intent();
            intent2.putExtras(intent);
            AbsStructMsg d16 = i.d(intent2.getByteArrayExtra(AppConstants.Key.STRUCT_MSG_BYTES));
            if (d16 == null) {
                return;
            }
            ShareMsgHelper.g(getBaseActivity().app, intent2.getStringExtra("uin"), intent2.getIntExtra("uintype", -1), d16, null);
            ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_fw_suc").LvInd1().reportByVideo(getBaseActivity().app);
            final com.tencent.mobileqq.nearby.b bVar2 = (com.tencent.mobileqq.nearby.b) this.S.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.SmallVideoFragment.4
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    q h16 = new q(SmallVideoFragment.this.S.app).i("dc00899").a("grp_lbs").f("video").d("playpage_fw_suc").h(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getAnchorUin());
                    String[] strArr = new String[4];
                    strArr[0] = "3";
                    strArr[1] = String.valueOf(bVar2.getSelfGender());
                    strArr[2] = ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getFrom();
                    if (TextUtils.equals(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getFrom(), "2")) {
                        str = ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getFeedId();
                    } else {
                        str = "";
                    }
                    strArr[3] = str;
                    h16.b(strArr).g();
                }
            }, 16, null, false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.S = (BaseActivity) activity;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ((IStorageCenter) QRoute.api(IStorageCenter.class)).init(getBaseActivity(), "shortVideo");
        q92.c.c(0);
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(getContentLayoutId(), (ViewGroup) null);
        this.Y = inflate;
        inflate.setFitsSystemWindows(true);
        this.W = System.currentTimeMillis();
        getBaseActivity().getIntent().putExtra(FlingConstant.FLING_ACTION_KEY, 0);
        this.U = super.getBaseActivity().getIntent().getExtras();
        ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).setFrom(this.U.getString(ThemeConstants.THEME_DIY_BG_FROM_SUFFIX, ""));
        StuffContainerView stuffContainerView = (StuffContainerView) findViewById(R.id.kso);
        this.C = stuffContainerView;
        stuffContainerView.setApp(getBaseActivity().app);
        this.C.setCallBack(this);
        th(this.U);
        this.F = this.C.f252840f;
        this.J = findViewById(R.id.efi);
        int rh5 = rh();
        uh();
        yh(this.U);
        this.D.f94506d = rh5;
        this.C.e(this.U);
        this.C.n(this.U);
        sh();
        q92.c.h();
        return this.Y;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        final long currentTimeMillis = System.currentTimeMillis() - this.W;
        ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_time").d4(currentTimeMillis + "").genderInd1().reportByVideo(getActivity() != null ? getBaseActivity().app : null);
        final com.tencent.mobileqq.nearby.b bVar = (com.tencent.mobileqq.nearby.b) this.S.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.SmallVideoFragment.3
            @Override // java.lang.Runnable
            public void run() {
                q h16 = new q(SmallVideoFragment.this.S.app).i("dc00899").a("grp_lbs").f("video").d("playpage_time").h(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getAnchorUin());
                String[] strArr = new String[4];
                StringBuilder sb5 = new StringBuilder();
                sb5.append(currentTimeMillis);
                String str = "";
                sb5.append("");
                strArr[0] = sb5.toString();
                strArr[1] = String.valueOf(bVar.getSelfGender());
                strArr[2] = ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getFrom();
                if (TextUtils.equals(((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getFrom(), "2")) {
                    str = ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).getFeedId();
                }
                strArr[3] = str;
                h16.b(strArr).g();
            }
        }, 16, null, false);
        this.C.i();
        DragFrameLayout dragFrameLayout = this.D;
        if (dragFrameLayout != null) {
            dragFrameLayout.a();
        }
        AudioManager audioManager = this.P;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this.Z);
        }
        AnimatorProxy.wrap(this.I).reset();
        AnimatorProxy.wrap(this.E).reset();
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        h hVar = (h) this.F.getAdapter();
        if (hVar.getView(this.F.getCurrentItem()) instanceof IShortVideoCommentsView) {
            ((com.tencent.mobileqq.nearby.now.view.b) ((IShortVideoCommentsView) hVar.getView(this.F.getCurrentItem()))).hideInputKeyboard();
        }
        super.onFinish();
        if (getBaseActivity() != null) {
            getBaseActivity().overridePendingTransition(0, R.anim.f154550b4);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.Q = false;
        this.C.j();
        AudioManager audioManager = this.P;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this.Z);
        }
    }

    @Override // com.tencent.biz.qqstory.view.widget.DragFrameLayout.a
    public void sa(View view, int i3, int i16, int i17, int i18, int i19, int i26) {
        if (i3 - i17 > ba.dp2px(getBaseActivity(), 60.0f)) {
            ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).opType("video").opName("slide_quit").genderInd1().reportByVideo(getBaseActivity().app);
            if (this.X) {
                wh();
            } else {
                getBaseActivity().finish();
            }
            this.C.l();
            return;
        }
        this.D.b(250);
        AlphaAnimation alphaAnimation = new AlphaAnimation(ViewHelper.getAlpha(this.I), 1.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(200L);
        this.I.startAnimation(alphaAnimation);
    }

    protected void wh() {
        ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).opType("video").opName("clk_quit").genderInd1().reportByVideo(getBaseActivity().app);
        if (!this.X) {
            getBaseActivity().finish();
        } else {
            ViewHelper.setAlpha(this.I, 0.0f);
            this.I.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.qqstory.view.widget.DragFrameLayout.a
    public boolean xa() {
        return xh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        this.Q = true;
        super.onResume();
        if (this.R) {
            this.R = false;
        } else {
            this.C.k();
        }
        ((InputMethodManager) getBaseActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.C.getWindowToken(), 0);
    }

    @Override // com.tencent.biz.qqstory.view.widget.DragFrameLayout.a
    public void jd(int i3, int i16, int i17, int i18, int i19, int i26) {
        float dp2px = 1.0f - ((i17 - i19) / ba.dp2px(getBaseActivity(), 60.0f));
        if (dp2px < 0.0f) {
            dp2px = 0.0f;
        }
        ViewHelper.setAlpha(this.I, dp2px);
    }

    private int rh() {
        this.D = (DragFrameLayout) findViewById(R.id.bpw);
        this.I = findViewById(R.id.f164301ri);
        this.G = (RelativeLayout) findViewById(R.id.fxx);
        this.H = (QQStoryLoadingView) findViewById(R.id.ks5);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.bq_);
        this.E = relativeLayout;
        this.D.setDraggableView(relativeLayout);
        this.D.setOnDraggingListener(this);
        this.K = 0;
        this.L = 0;
        this.M = -1;
        this.N = -1;
        this.D.f94506d = -1;
        return -1;
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements AudioManager.OnAudioFocusChangeListener {
        b() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i3) {
            if ((i3 == -1 || i3 == -2 || i3 == -3) && SmallVideoFragment.this.Q) {
                SmallVideoFragment.this.o4();
            }
        }
    }

    private void yh(Bundle bundle) {
    }
}

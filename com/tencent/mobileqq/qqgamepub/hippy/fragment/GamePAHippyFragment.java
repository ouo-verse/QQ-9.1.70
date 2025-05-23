package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.hippy.view.GamePubAccountHeadView;
import com.tencent.mobileqq.qqgamepub.mvp.presenter.buisness.QQGameHippyPresenter;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.QQGameUIHelper;
import com.tencent.mobileqq.qqgamepub.view.GameArkView;
import com.tencent.mobileqq.qqgamepub.view.NavBarQQGamePub;
import com.tencent.mobileqq.qqgamepub.view.QQGamePubViewpager;
import com.tencent.mobileqq.qqgamepub.web.view.GameContentView;
import com.tencent.mobileqq.qqgamepub.web.view.QQGameIndicator2;
import com.tencent.mobileqq.qqgamepub.web.view.UnreadTipLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.supportui.views.recyclerview.LinearLayoutManager;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

@Deprecated
/* loaded from: classes16.dex */
public class GamePAHippyFragment extends GamePAHippyBaseFragment<QQGameHippyPresenter> implements jh2.c, GameContentView.a, View.OnClickListener, mh2.b<QQGameHippyPresenter> {
    private View E;
    private ViewGroup F;
    private NavBarQQGamePub G;
    private View H;
    private TextView I;
    private GestureDetector J;
    private QQGameIndicator2 K;
    private QQGamePubViewpager L;
    private com.tencent.mobileqq.qqgamepub.view.a M;
    private UnreadTipLayout N;
    public LinearLayout P;
    public ImageView Q;
    public TextView R;
    private GameContentView S;
    private LinearLayout T;
    private RelativeLayout U;
    private GamePubAccountHeadView V;
    private boolean W = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements com.tencent.mobileqq.widget.navbar.a {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(View view, int i3) {
            if (i3 == 5) {
                ((QQGameHippyPresenter) GamePAHippyFragment.this.C).K();
            } else if (i3 == 1) {
                ((QQGameHippyPresenter) GamePAHippyFragment.this.C).x();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return super.onDoubleTapEvent(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return super.onSingleTapConfirmed(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class c implements View.OnTouchListener {
        c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return GamePAHippyFragment.this.J.onTouchEvent(motionEvent);
        }
    }

    private void Lh(final View view) {
        view.post(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.fragment.a
            @Override // java.lang.Runnable
            public final void run() {
                GamePAHippyFragment.this.Yh(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nh() {
        QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, "isSetHeadScrollWithHippy=" + this.W);
        ViewGroup viewGroup = this.F;
        if (viewGroup == null) {
            return;
        }
        for (View view : Ph(viewGroup)) {
            if (view instanceof HippyListView) {
                this.W = true;
                QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, "set Head Scrol lWith Hippy");
                this.U.bringToFront();
                HippyListView hippyListView = (HippyListView) view;
                hippyListView.setMomentumScrollBeginEventEnable(false);
                hippyListView.addOnListScrollListener(new d(view));
                return;
            }
        }
    }

    private List<View> Ph(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                arrayList.add(childAt);
                arrayList.addAll(Ph(childAt));
            }
        }
        return arrayList;
    }

    private QQGameMsgInfo Rh() {
        QQGamePubViewpager qQGamePubViewpager = this.L;
        if (qQGamePubViewpager != null) {
            return ((QQGameHippyPresenter) this.C).W(qQGamePubViewpager.getCurrentItem());
        }
        return null;
    }

    private void Th() {
        this.L = (QQGamePubViewpager) this.E.findViewById(R.id.f1196377d);
        this.K = (QQGameIndicator2) this.E.findViewById(R.id.fhp);
        this.N = (UnreadTipLayout) this.E.findViewById(R.id.ydl);
        this.P = (LinearLayout) this.E.findViewById(R.id.yfx);
        this.R = (TextView) this.E.findViewById(R.id.f112226nc);
        this.Q = (ImageView) this.E.findViewById(R.id.icq);
        this.S = (GameContentView) this.E.findViewById(R.id.yee);
        com.tencent.mobileqq.qqgamepub.utils.b.c().d(2);
    }

    private void Uh(View view) {
        Lh(view.findViewById(R.id.yfs));
        this.F = (ViewGroup) view.findViewById(R.id.x_x);
        this.G = (NavBarQQGamePub) view.findViewById(R.id.rlCommenTitle);
        this.U = (RelativeLayout) view.findViewById(R.id.e3u);
        this.T = (LinearLayout) view.findViewById(R.id.eet);
        this.V = (GamePubAccountHeadView) view.findViewById(R.id.yeu);
    }

    private void Vh() {
        ImageView imageView = (ImageView) this.G.findViewById(R.id.f165972dz1);
        this.G.setRightImage(getResources().getDrawable(R.drawable.dfq), getResources().getDrawable(R.drawable.f162247bi0));
        imageView.setImageResource(R.drawable.b6q);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    private void Wh() {
        int d16 = ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).d();
        if (d16 > 1) {
            ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).s(1);
            int i3 = d16 - 1;
            ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).r(i3);
            ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).q(i3);
            this.Q.setVisibility(8);
            this.N.setVisibility(0);
            this.N.setUnreadNum(i3);
            this.N.setOnClickListener(this);
            this.N.post(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    GamePAHippyFragment.this.K.setVisibility(4);
                    GamePAHippyFragment.this.N.b();
                }
            });
            ((QQGameHippyPresenter) this.C).C().h();
        }
    }

    private View Xh(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.ebf, (ViewGroup) null, false);
        Uh(inflate);
        QQGameUIHelper.e(inflate, this.T, getQBaseActivity());
        initNavBar();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Yh(View view) {
        int fixedWidth = ((IHippySetting) QRoute.api(IHippySetting.class)).getFixedWidth(Qh());
        if (fixedWidth > 0) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                QLog.i("QQGamePub_GamePubAccountHippyFragment", 1, "[adaptFixedWidth] width:" + layoutParams.width + ",fixedWidth:" + fixedWidth);
                layoutParams.width = fixedWidth;
                view.setLayoutParams(layoutParams);
                return;
            }
            QLog.i("QQGamePub_GamePubAccountHippyFragment", 1, "[adaptFixedWidth] params is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zh() {
        RelativeLayout relativeLayout;
        if (((QQGameHippyPresenter) this.C).T() && (relativeLayout = this.U) != null) {
            relativeLayout.post(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment.12
                @Override // java.lang.Runnable
                public void run() {
                    GamePAHippyFragment gamePAHippyFragment = GamePAHippyFragment.this;
                    ((QQGameHippyPresenter) gamePAHippyFragment.C).h0(gamePAHippyFragment.V.getHeight());
                }
            });
        }
    }

    private void initNavBar() {
        this.G.setGamePubType(((QQGameHippyPresenter) this.C).z());
        this.G.setBackgroundResource(R.drawable.njt);
        this.H = this.G.g();
        try {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) getResources().getDimension(R.dimen.title_bar_height));
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(MobileQQ.sMobileQQ);
            layoutParams.setMargins(0, statusBarHeight, 0, 0);
            this.G.setLayoutParams(layoutParams);
            QLog.d("QQGamePub_GamePubAccountHippyFragment", 4, "statusBarHeight = " + statusBarHeight);
        } catch (Throwable th5) {
            QLog.e("QQGamePub_GamePubAccountHippyFragment", 4, "set statusBarHeight failed:" + th5.getMessage());
        }
        this.G.setOnItemSelectListener(new a());
        this.G.k();
        Vh();
        initTitleBar();
    }

    private void initViewPager() {
        ((QQGameHippyPresenter) this.C).e0(getQBaseActivity(), this);
        this.L.setAdapter(((QQGameHippyPresenter) this.C).Y());
        this.L.setOffscreenPageLimit(5);
        this.K.setViewPager(this.L);
        this.K.b();
        this.K.setPageListener(this);
        int a06 = ((QQGameHippyPresenter) this.C).a0();
        this.L.setCurrentItem(a06);
        ((QQGameHippyPresenter) this.C).S(a06);
    }

    @Override // com.tencent.mobileqq.qqgamepub.web.view.GameContentView.a
    public void M3() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment.11
            @Override // java.lang.Runnable
            public void run() {
                GamePAHippyFragment.this.Zh();
            }
        });
    }

    @Override // lh2.a
    /* renamed from: Mh, reason: merged with bridge method [inline-methods] */
    public QQGameHippyPresenter V() {
        return new QQGameHippyPresenter();
    }

    @Override // mh2.b
    public void N5(int i3) {
        List<com.tencent.mobileqq.qqgamepub.view.a> Z = ((QQGameHippyPresenter) this.C).Z();
        for (int i16 = 0; i16 < Z.size(); i16++) {
            if (i16 == i3) {
                com.tencent.mobileqq.qqgamepub.view.a aVar = Z.get(i16);
                this.M = aVar;
                if (aVar instanceof GameArkView) {
                    com.tencent.mobileqq.qqgamepub.utils.b.c().g((GameArkView) this.M);
                    ((GameArkView) this.M).c();
                } else {
                    com.tencent.mobileqq.qqgamepub.utils.b.c().g(null);
                }
            } else {
                com.tencent.mobileqq.qqgamepub.view.a aVar2 = Z.get(i16);
                if (aVar2 != null) {
                    aVar2.onPause();
                }
            }
        }
        com.tencent.mobileqq.qqgamepub.view.a aVar3 = this.M;
        if (aVar3 != null) {
            aVar3.onResume();
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.web.view.GameContentView.a
    public void O5(long j3) {
        QQGameUIHelper.h(j3, this.S, this.H);
    }

    public void Oh(int i3, com.tencent.mobileqq.qqgamepub.view.a aVar) {
        if (i3 == this.L.getCurrentItem()) {
            this.M = aVar;
            if (aVar instanceof GameArkView) {
                GameArkView gameArkView = (GameArkView) aVar;
                gameArkView.setPrePause(false);
                com.tencent.mobileqq.qqgamepub.utils.b.c().g(gameArkView);
                return;
            }
            com.tencent.mobileqq.qqgamepub.utils.b.c().g(null);
        }
    }

    protected String Qh() {
        return HippyQQConstants.ModuleName.QQ_GAME_PUBLICACCOUNT;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mh2.b
    public void R0(int i3) {
        if (((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).d() > 0) {
            int f16 = ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).f();
            int e16 = ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).e();
            if (i3 >= f16 && f16 <= e16 && i3 <= e16) {
                int i16 = f16 + 1;
                ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).s(i16);
                int i17 = (e16 - i16) + 1;
                ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).q(i17);
                if (i17 > 0 && i17 <= 3) {
                    o(true, i17);
                    return;
                } else {
                    o(false, 0);
                    return;
                }
            }
            return;
        }
        o(false, 0);
    }

    public void Sh() {
        GameContentView gameContentView = this.S;
        if (gameContentView != null) {
            gameContentView.setUiRefresh(this);
            this.S.c();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void initTitleBar() {
        TextView titleTextView = this.G.getTitleTextView();
        this.I = titleTextView;
        titleTextView.setText(R.string.ivu);
        this.I.setTextColor(-1);
        this.J = new GestureDetector(getQBaseActivity(), new b());
        this.I.setOnTouchListener(new c());
    }

    @Override // mh2.b
    public ViewPager n0() {
        return this.L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mh2.b
    public void o(boolean z16, int i3) {
        if (!z16) {
            this.N.setVisibility(8);
            this.P.setVisibility(8);
            this.K.setVisibility(0);
            ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).q(0);
            ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).r(0);
            ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).s(0);
            return;
        }
        this.Q.setVisibility(8);
        this.N.setVisibility(0);
        this.N.setUnreadNum(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.ydl) {
            if (this.L != null) {
                int b06 = ((QQGameHippyPresenter) this.C).b0();
                if (((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).d() >= 3) {
                    this.L.setCurrentItem(((QQGameHippyPresenter) this.C).c0());
                } else {
                    int currentItem = this.L.getCurrentItem();
                    int i3 = currentItem + 1;
                    if (i3 < b06) {
                        this.L.setCurrentItem(i3);
                    } else if (currentItem == b06 - 1) {
                        this.L.setCurrentItem(b06);
                    }
                    if (((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).d() == 0) {
                        this.K.setVisibility(0);
                        this.N.setVisibility(4);
                        this.K.d();
                    }
                }
            }
            ((QQGameHippyPresenter) this.C).C().i();
        } else if (view.getId() == R.id.yfx) {
            QQGameMsgInfo Rh = Rh();
            String str2 = "";
            if (Rh == null) {
                str = "";
            } else {
                String str3 = Rh.gameAppId;
                if (!TextUtils.isEmpty(Rh.paMsgid)) {
                    str2 = Rh.paMsgid;
                }
                str = str2;
                str2 = str3;
            }
            ((QQGameHippyPresenter) this.C).C().c(str2, str);
            if (this.L != null) {
                int b07 = ((QQGameHippyPresenter) this.C).b0();
                if (((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).d() >= 3) {
                    this.L.setCurrentItem(((QQGameHippyPresenter) this.C).c0());
                } else {
                    int currentItem2 = this.L.getCurrentItem();
                    int i16 = currentItem2 + 1;
                    if (i16 < b07) {
                        this.L.setCurrentItem(i16);
                    } else if (currentItem2 == b07 - 1) {
                        this.L.setCurrentItem(b07);
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyBaseFragment, com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.E = Xh(layoutInflater);
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).a("initView");
        Th();
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).a("initHeadView");
        loadHippy(this.F);
        ((QQGameHippyPresenter) this.C).O(2);
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).a("loadHippy");
        Sh();
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).a("initGameContentView");
        initViewPager();
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).a("initViewPager");
        Wh();
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).a("initTipLayout");
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).a("initViewEnd");
        View view = this.E;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        try {
            GameContentView gameContentView = this.S;
            if (gameContentView != null) {
                gameContentView.f();
            }
        } catch (Throwable th5) {
            QLog.e("QQGamePub_GamePubAccountHippyFragment", 1, th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment
    public void onLoadHippyError(final int i3, final String str) {
        LinearLayout linearLayout;
        QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, "onLoadHippyError statusCode:" + i3 + " msg:" + str);
        super.onLoadHippyError(i3, str);
        ((QQGameHippyPresenter) this.C).O(6);
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).u(false);
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).n(-1L);
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).a("onLoadHippyEnd");
        RelativeLayout relativeLayout = this.U;
        if (relativeLayout != null && (linearLayout = this.T) != null) {
            relativeLayout.removeView(linearLayout);
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment.7
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) GamePAHippyFragment.this.C).i()).k(i3 + "", str);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment
    public void onLoadHippySuccess() {
        LinearLayout linearLayout;
        super.onLoadHippySuccess();
        ((QQGameHippyPresenter) this.C).O(5);
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).a("onLoadHippyEnd");
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).u(true);
        RelativeLayout relativeLayout = this.U;
        if (relativeLayout != null && (linearLayout = this.T) != null) {
            relativeLayout.removeView(linearLayout);
        }
        if (!this.W) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment.5
                @Override // java.lang.Runnable
                @SuppressLint({"LongLogTag"})
                public void run() {
                    GamePAHippyFragment.this.Nh();
                }
            }, 500L);
        }
    }

    @Override // jh2.c
    public void onPageSelected(int i3) {
        ((QQGameHippyPresenter) this.C).V(i3);
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyBaseFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        try {
            com.tencent.mobileqq.qqgamepub.view.a aVar = this.M;
            if (aVar instanceof GameArkView) {
                aVar.onPause();
            }
        } catch (Throwable th5) {
            QLog.e("QQGamePub_GamePubAccountHippyFragment", 1, th5.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyBaseFragment, com.tencent.hippy.qq.fragment.CommonHippyFragment, com.tencent.hippy.qq.fragment.BaseHippyFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.mobileqq.qqgamepub.view.a aVar = this.M;
        if (aVar != null) {
            aVar.onResume();
        }
        try {
            QQGamePubViewpager qQGamePubViewpager = this.L;
            qQGamePubViewpager.setCurrentItem(((QQGameHippyPresenter) this.C).X(qQGamePubViewpager.getCurrentItem()));
        } catch (Throwable th5) {
            QLog.e("QQGamePub_GamePubAccountHippyFragment", 1, th5.getMessage());
        }
    }

    @Override // mh2.b
    public void q(final GmpEnterInfoRsp gmpEnterInfoRsp, boolean z16) {
        if (gmpEnterInfoRsp != null && gmpEnterInfoRsp.retCode == 0 && gmpEnterInfoRsp.state == 1 && z16) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment.8
                @Override // java.lang.Runnable
                public void run() {
                    if (GamePAHippyFragment.this.getQBaseActivity() != null && !GamePAHippyFragment.this.getQBaseActivity().isFinishing() && GamePAHippyFragment.this.isAdded() && GamePAHippyFragment.this.G != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, "show game enter icon");
                        }
                        GamePAHippyFragment.this.G.setCurType(2);
                        GamePAHippyFragment.this.G.m(false);
                        NavBarQQGamePub navBarQQGamePub = GamePAHippyFragment.this.G;
                        GmpEnterInfoRsp gmpEnterInfoRsp2 = gmpEnterInfoRsp;
                        navBarQQGamePub.l(gmpEnterInfoRsp2.icon, gmpEnterInfoRsp2.content, gmpEnterInfoRsp2.url);
                        GamePAHippyFragment.this.G.setmBubbleid(gmpEnterInfoRsp.bubbleId);
                        GamePubAccountHelper.N(gmpEnterInfoRsp);
                        ((QQGameHippyPresenter) GamePAHippyFragment.this.C).C().e(gmpEnterInfoRsp.bubbleId, false);
                    }
                }
            });
            return;
        }
        final GmpEnterInfoRsp p16 = GamePubAccountHelper.p();
        ((QQGameHippyPresenter) this.C).C().e(p16.bubbleId, true);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment.9
            @Override // java.lang.Runnable
            public void run() {
                if (GamePAHippyFragment.this.getQBaseActivity() != null && !GamePAHippyFragment.this.getQBaseActivity().isFinishing() && GamePAHippyFragment.this.isAdded()) {
                    ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).showGameEnterCacheInfo(GamePAHippyFragment.this.G, p16);
                }
            }
        });
        if (QLog.isColorLevel()) {
            QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, "rec game enter is null");
        }
    }

    @Override // mh2.b
    public void refreshHead(final int i3) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment.10
            @Override // java.lang.Runnable
            public void run() {
                if (GamePAHippyFragment.this.L != null && ((QQGameHippyPresenter) GamePAHippyFragment.this.C).Y() != null) {
                    ((QQGameHippyPresenter) GamePAHippyFragment.this.C).d0();
                    GamePAHippyFragment.this.K.b();
                    GamePAHippyFragment.this.L.setCurrentItem(i3);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyBaseFragment
    public void uh(long j3) {
        ((QQGameHippyPresenter) this.C).O(3);
        M3();
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).a("onHippyFirstScreen");
        QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, "--->on HippyFirstScreen");
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).v(j3);
        if (!this.W) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment.15
                @Override // java.lang.Runnable
                public void run() {
                    GamePAHippyFragment.this.Nh();
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyBaseFragment
    public void xh(long j3) {
        super.xh(j3);
        ((QQGameHippyPresenter) this.C).O(4);
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).a("onHippShow");
        QLog.d("QQGamePub_GamePubAccountHippyFragment", 1, "--->on hippy show");
        ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) this.C).i()).w(j3);
        if (!this.W) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment.13
                @Override // java.lang.Runnable
                public void run() {
                    GamePAHippyFragment.this.Nh();
                }
            });
        }
        M3();
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment.14
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                ((com.tencent.mobileqq.qqgamepub.mvp.model.buisness.a) ((QQGameHippyPresenter) GamePAHippyFragment.this.C).i()).k("0", "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class d implements RecyclerView.OnListScrollListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f264530d;

        d(View view) {
            this.f264530d = view;
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
        public void onScroll(int i3, int i16) {
            if (((LinearLayoutManager) ((HippyListView) this.f264530d).getLayoutManager()).findFirstVisibleItemPosition() == 0) {
                GamePAHippyFragment.this.U.setVisibility(0);
                if (GamePAHippyFragment.this.M != null) {
                    GamePAHippyFragment.this.M.onResume();
                }
            } else {
                com.tencent.mobileqq.qqgamepub.utils.b.c().i();
                GamePAHippyFragment.this.U.setVisibility(8);
                if (GamePAHippyFragment.this.M != null) {
                    GamePAHippyFragment.this.M.onPause();
                }
            }
            if (GamePAHippyFragment.this.U.getVisibility() == 0) {
                GamePAHippyFragment.this.U.scrollTo(0, QQGameUIHelper.c((HippyListView) this.f264530d));
            }
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
        public void onDragEnd() {
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
        public void onScrollEnd() {
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
        public void onStartDrag() {
        }

        @Override // com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener
        public void onStartFling() {
        }
    }

    @Override // jh2.c
    public void onPageScrolled(int i3, float f16, int i16) {
    }
}

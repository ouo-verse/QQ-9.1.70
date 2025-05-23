package com.tencent.biz.pubaccount.subscript;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.subscript.a;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.util.k;
import com.tencent.biz.ui.CustomGuideView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.activity.em;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes4.dex */
public class SubscriptFeedsActivity extends IphoneTitleBarActivity implements View.OnClickListener, Observer, DragFrameLayout.b, SwipListView.RightIconMenuListener {

    /* renamed from: a0, reason: collision with root package name */
    private com.tencent.biz.pubaccount.subscript.a f80002a0;

    /* renamed from: b0, reason: collision with root package name */
    private SwipListView f80003b0;

    /* renamed from: c0, reason: collision with root package name */
    public SubscriptRecommendController f80004c0;

    /* renamed from: d0, reason: collision with root package name */
    public View f80005d0;

    /* renamed from: e0, reason: collision with root package name */
    protected DragFrameLayout f80006e0;

    /* renamed from: g0, reason: collision with root package name */
    private com.tencent.biz.pubaccount.subscript.c f80008g0;

    /* renamed from: m0, reason: collision with root package name */
    private PopupWindow f80014m0;

    /* renamed from: n0, reason: collision with root package name */
    private CustomGuideView f80015n0;

    /* renamed from: o0, reason: collision with root package name */
    private View f80016o0;

    /* renamed from: p0, reason: collision with root package name */
    private EditText f80017p0;

    /* renamed from: q0, reason: collision with root package name */
    private long f80018q0;

    /* renamed from: r0, reason: collision with root package name */
    private TopGestureLayout f80019r0;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f80025x0;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f80026y0;

    /* renamed from: f0, reason: collision with root package name */
    private int f80007f0 = -1;

    /* renamed from: h0, reason: collision with root package name */
    protected int f80009h0 = 0;

    /* renamed from: i0, reason: collision with root package name */
    protected boolean f80010i0 = false;

    /* renamed from: j0, reason: collision with root package name */
    private ArrayList<ReadInJoyArticle> f80011j0 = null;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f80012k0 = false;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f80013l0 = false;

    /* renamed from: s0, reason: collision with root package name */
    private long f80020s0 = 0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f80021t0 = false;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f80022u0 = false;

    /* renamed from: v0, reason: collision with root package name */
    public long f80023v0 = 0;

    /* renamed from: w0, reason: collision with root package name */
    public long f80024w0 = 0;

    /* renamed from: z0, reason: collision with root package name */
    private XListView.DrawFinishedListener f80027z0 = new c();
    private float A0 = 0.0f;
    private float B0 = 0.0f;
    private int C0 = 0;
    private boolean D0 = false;
    bs E0 = new a();
    MqqHandler F0 = new MqqHandler(ThreadManagerV2.getSubThreadLooper()) { // from class: com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.12
        @Override // mqq.os.MqqHandler
        public void handleMessage(Message message) {
            if (SubscriptFeedsActivity.this.isFinishing()) {
                return;
            }
            switch (message.what) {
                case 1004:
                    SubscriptFeedsActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z16 = true;
                            SubscriptFeedsActivity.this.f80002a0.f80073h = true;
                            SubscriptFeedsActivity subscriptFeedsActivity = SubscriptFeedsActivity.this;
                            if (subscriptFeedsActivity.f80002a0.f80072f != 1) {
                                z16 = false;
                            }
                            subscriptFeedsActivity.V2(false, z16, false);
                        }
                    });
                    return;
                case 1005:
                    SubscriptFeedsActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.12.2
                        @Override // java.lang.Runnable
                        public void run() {
                            SubscriptRecommendController subscriptRecommendController = SubscriptFeedsActivity.this.f80004c0;
                            if (subscriptRecommendController != null) {
                                subscriptRecommendController.D();
                            }
                        }
                    });
                    return;
                case 1006:
                    SubscriptFeedsActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.12.3
                        @Override // java.lang.Runnable
                        public void run() {
                            SubscriptFeedsActivity.this.f80002a0.f80072f = 0;
                            SubscriptFeedsActivity.this.V2(true, false, false);
                        }
                    });
                    return;
                case 1007:
                    SubscriptFeedsActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.12.4
                        @Override // java.lang.Runnable
                        public void run() {
                            SubscriptFeedsActivity.this.f80013l0 = true;
                        }
                    });
                    return;
                default:
                    return;
            }
        }
    };
    private boolean G0 = false;
    private com.tencent.biz.pubaccount.subscript.b H0 = new b();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends bs {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bs
        public void onSendResult(boolean z16, String str, long j3) {
            SubscriptFeedsActivity.this.T2();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b extends com.tencent.biz.pubaccount.subscript.b {
        b() {
        }

        @Override // com.tencent.biz.pubaccount.subscript.b
        protected void b(boolean z16, ArrayList<ReadInJoyArticle> arrayList) {
            if (QLog.isColorLevel()) {
                QLog.d("SubscriptObserver", 2, "onGetRecommendReadInJoyArticleList isSuccess: " + z16 + " | data: " + arrayList);
            }
            if (!z16) {
                return;
            }
            if (arrayList != null && arrayList.size() == 4) {
                if (SubscriptFeedsActivity.this.F0 != null) {
                    Message message = new Message();
                    message.what = 1003;
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("ReadInJoyArticleList", arrayList);
                    message.setData(bundle);
                    SubscriptFeedsActivity.this.F0.removeMessages(1003);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SubscriptObserver", 2, "onGetRecommendReadInJoyArticleList data is null or small than 4");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class c implements XListView.DrawFinishedListener {
        c() {
        }

        @Override // com.tencent.widget.XListView.DrawFinishedListener
        public void drawFinished() {
            SubscriptFeedsActivity subscriptFeedsActivity = SubscriptFeedsActivity.this;
            if (!subscriptFeedsActivity.f80025x0 && subscriptFeedsActivity.f80026y0) {
                subscriptFeedsActivity.f80025x0 = true;
                k.a("SUBSCRIPT_FEEDS_COST", null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class e implements View.OnFocusChangeListener {
        e() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            if (z16) {
                view.clearFocus();
                SubscriptFeedsActivity.this.P2();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - SubscriptFeedsActivity.this.f80018q0 > 1500) {
                    SubscriptFeedsActivity.this.f80018q0 = currentTimeMillis;
                    UniteSearchActivity.I2(SubscriptFeedsActivity.this, null, 12);
                    if (QLog.isColorLevel()) {
                        QLog.d("SubscriptFeedsActivity", 2, "Search Subscript Account...");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2() {
        PopupWindow popupWindow = this.f80014m0;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f80015n0.setOnClickListener(null);
            try {
                this.f80014m0.dismiss();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("SubscriptFeedsActivity", 2, "closeSubscriptCenterGuideWindow, " + e16);
                }
            }
        }
    }

    private void Q2(boolean z16) {
        if (this.f80019r0 == null) {
            ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
            View childAt = viewGroup.getChildAt(0);
            if (childAt != null && (childAt instanceof DragFrameLayout)) {
                viewGroup = (ViewGroup) childAt;
            }
            View childAt2 = viewGroup.getChildAt(0);
            if (childAt2 instanceof TopGestureLayout) {
                this.f80019r0 = (TopGestureLayout) childAt2;
            }
        }
        TopGestureLayout topGestureLayout = this.f80019r0;
        if (topGestureLayout != null) {
            topGestureLayout.setInterceptTouchFlag(z16);
        }
    }

    private void R2() {
        boolean isInNightMode = ThemeUtil.isInNightMode(this.app);
        if (this.f80002a0.getCount() == 0) {
            ((TextView) this.f80005d0.findViewById(R.id.jxi)).setText(R.string.f171426ex0);
            this.f80005d0.setVisibility(0);
            if (!isInNightMode) {
                this.f80005d0.setBackgroundResource(R.color.f157570tg);
            } else {
                this.f80005d0.setBackgroundResource(R.color.f157571th);
            }
            this.f80003b0.setBackgroundResource(R.drawable.trans);
            this.f80003b0.setEnabled(false);
            SubscriptRecommendController subscriptRecommendController = this.f80004c0;
            if (subscriptRecommendController != null) {
                subscriptRecommendController.z();
                return;
            }
            return;
        }
        this.f80005d0.setVisibility(8);
        if (!isInNightMode) {
            this.f80003b0.setBackgroundResource(R.color.f157570tg);
        } else {
            this.f80003b0.setBackgroundResource(R.color.f157571th);
        }
        this.f80003b0.setEnabled(true);
    }

    private void U2() {
        String str = AppSetting.f99551k + this.app.getCurrentUin() + "subscript_guid";
        boolean z16 = true;
        if (!this.app.getPreferences().getBoolean(str, true) || !SubscriptRecommendController.e(this.app)) {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        this.app.getPreferences().edit().putBoolean(str, false).commit();
        try {
            Resources resources = getResources();
            this.f80014m0 = new PopupWindow();
            CustomGuideView customGuideView = new CustomGuideView(this);
            this.f80015n0 = customGuideView;
            customGuideView.H = resources.getColor(R.color.ahr);
            this.f80015n0.G = resources.getColor(R.color.ahs);
            this.f80015n0.F = l.X(2, 14, resources);
            this.f80015n0.E = BaseAIOUtils.f(12.0f, resources);
            this.f80015n0.f96960i = BaseAIOUtils.f(30.0f, resources);
            this.f80015n0.f96961m = BaseAIOUtils.f(7.0f, resources);
            this.f80015n0.I = BaseAIOUtils.f(12.0f, resources);
            this.f80015n0.C = BaseAIOUtils.f(3.0f, resources);
            this.f80015n0.f96959h = HardCodeUtil.qqStr(R.string.f172749ty0);
            this.f80015n0.setOnClickListener(this);
            this.f80015n0.setId(R.id.j7a);
            this.f80014m0.setContentView(this.f80015n0);
            this.f80014m0.setFocusable(false);
            this.f80014m0.setOutsideTouchable(false);
            this.f80014m0.setWidth(this.f80015n0.e());
            this.f80014m0.setHeight(-2);
            final int e16 = this.f80015n0.e();
            final int i3 = getResources().getDisplayMetrics().widthPixels;
            this.rightViewText.post(new Runnable() { // from class: com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        int[] iArr = new int[2];
                        SubscriptFeedsActivity.this.rightViewText.getLocationInWindow(iArr);
                        int f16 = ((i3 - iArr[0]) - e16) - BaseAIOUtils.f(2.0f, SubscriptFeedsActivity.this.getResources());
                        PopupWindow popupWindow = SubscriptFeedsActivity.this.f80014m0;
                        SubscriptFeedsActivity subscriptFeedsActivity = SubscriptFeedsActivity.this;
                        popupWindow.showAsDropDown(subscriptFeedsActivity.rightViewText, f16, -BaseAIOUtils.f(5.0f, subscriptFeedsActivity.getResources()));
                    } catch (Exception e17) {
                        if (QLog.isColorLevel()) {
                            QLog.e("SubscriptFeedsActivity", 2, "showSubscriptCenterGuideWindow, " + e17);
                        }
                    }
                }
            });
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.e("SubscriptFeedsActivity", 2, "showSubscriptCenterGuideWindow, " + e17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V2(boolean z16, boolean z17, boolean z18) {
        com.tencent.biz.pubaccount.subscript.a aVar;
        if (z16 || z17 || z18) {
            this.f80026y0 = true;
            com.tencent.biz.pubaccount.subscript.a aVar2 = this.f80002a0;
            if (aVar2 != null) {
                aVar2.b();
                this.f80002a0.notifyDataSetChanged();
            }
            R2();
        }
        SubscriptRecommendController subscriptRecommendController = this.f80004c0;
        if (subscriptRecommendController != null && (aVar = this.f80002a0) != null && !this.G0 && subscriptRecommendController.f80051i && aVar.f80072f == 0 && aVar.f80073h && aVar.f80070d == 0) {
            this.G0 = true;
            subscriptRecommendController.y();
        }
    }

    private void fillData() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.7
            @Override // java.lang.Runnable
            public void run() {
                ((IPublicAccountDataManager) SubscriptFeedsActivity.this.app.getRuntimeService(IPublicAccountDataManager.class, "all")).initPublicAccountDataManager();
                TroopBarAssistantManager.n().N(SubscriptFeedsActivity.this.app);
            }
        });
        if (TroopBarAssistantManager.n().V(this.app)) {
            TroopBarAssistantManager.n().t(this.app.getEntityManagerFactory().createEntityManager(), this.app);
        }
        addObserver(this.E0);
        addObserver(this.H0);
        this.app.getMessageFacade().addObserver(this);
        HtmlOffline.j("2278", this.app, true, new f());
    }

    public void S2() {
        if (this.f80010i0) {
            this.f80004c0.r();
            this.f80010i0 = false;
        } else {
            this.f80004c0.D();
        }
        this.f80002a0.h(this.f80004c0);
    }

    void T2() {
        try {
            MqqHandler mqqHandler = this.F0;
            if (mqqHandler != null) {
                mqqHandler.removeMessages(1002);
                this.F0.sendEmptyMessage(1002);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("SubscriptFeedsActivity", 2, "refreshTroopBarAccountList, error: ", e16);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0034, code lost:
    
        if (r4 != 3) goto L57;
     */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent;
        int pointToPosition;
        int headerViewsCount;
        View view;
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        SwipListView swipListView = this.f80003b0;
        if (swipListView != null && this.f80002a0 != null) {
            if (this.C0 == 0) {
                int[] iArr = new int[2];
                swipListView.getLocationOnScreen(iArr);
                this.C0 = iArr[1];
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        if (Math.abs(x16 - this.A0) > Math.abs(y16 - this.B0)) {
                            float f16 = this.A0;
                            if (x16 - f16 > 20.0f) {
                                if (this.D0) {
                                    ((ViewGroup) this.mContentView).requestDisallowInterceptTouchEvent(true);
                                }
                            } else if (x16 - f16 < -20.0f) {
                                ((ViewGroup) this.mContentView).requestDisallowInterceptTouchEvent(true);
                            }
                        } else {
                            Math.abs(y16 - this.B0);
                        }
                    }
                }
                ((ViewGroup) this.mContentView).requestDisallowInterceptTouchEvent(false);
                this.D0 = false;
            } else {
                this.A0 = x16;
                this.B0 = y16;
                this.D0 = false;
                int height = this.f80003b0.getHeight();
                int i3 = this.C0;
                if (y16 >= i3) {
                    SubscriptRecommendController subscriptRecommendController = this.f80004c0;
                    if (subscriptRecommendController != null && subscriptRecommendController.f80053k == 1 && (view = subscriptRecommendController.f80044b) != null) {
                        int[] iArr2 = new int[2];
                        view.findViewById(R.id.f166827ii1).getLocationOnScreen(iArr2);
                        if (y16 >= iArr2[1] && y16 < r4 + r0.getHeight()) {
                            this.D0 = true;
                        }
                    } else if (y16 < height + i3 && (pointToPosition = this.f80003b0.pointToPosition((int) x16, ((int) y16) - i3)) != -1 && (headerViewsCount = pointToPosition - this.f80003b0.getHeaderViewsCount()) >= 0 && headerViewsCount < this.f80002a0.getCount()) {
                        if (headerViewsCount == this.f80007f0) {
                            this.D0 = true;
                        }
                        if (this.f80002a0.getItem(headerViewsCount).equals("SubscriptRecommendController")) {
                            this.D0 = true;
                        }
                    }
                }
            }
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        } else {
            dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        }
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        Drawable drawable;
        this.f80023v0 = SystemClock.uptimeMillis();
        k.a(null, "SUBSCRIPT_FEEDS_COST");
        super.doOnCreate(bundle);
        getWindow().setFlags(16777216, 16777216);
        new MqqHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.2
            @Override // java.lang.Runnable
            public void run() {
                IWebProcessManagerService iWebProcessManagerService = (IWebProcessManagerService) SubscriptFeedsActivity.this.app.getRuntimeService(IWebProcessManagerService.class, "");
                if (iWebProcessManagerService != null) {
                    iWebProcessManagerService.startWebProcess(22, null);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SubscriptFeedsActivity", 2, "enter folder preload web process");
                }
            }
        }, 1000L);
        setContentView(R.layout.f168559ac0);
        getWindow().setBackgroundDrawable(null);
        DragFrameLayout e16 = DragFrameLayout.e(this);
        this.f80006e0 = e16;
        e16.addOnDragModeChangeListener(this, false);
        this.f80010i0 = true;
        this.f80009h0 = super.getIntent().getIntExtra("come_from", 0);
        this.f80020s0 = super.getIntent().getLongExtra("start_time", 0L);
        this.f80021t0 = super.getIntent().getBooleanExtra("has_red_hot", false);
        this.f80008g0 = new com.tencent.biz.pubaccount.subscript.c();
        setTitle(((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, getApplicationContext()));
        updateUnreadNumOnTitleBar();
        boolean e17 = SubscriptRecommendController.e(this.app);
        this.rightViewText.setText(R.string.f170867aw0);
        if (e17) {
            this.rightViewText.setVisibility(0);
        } else {
            this.rightViewText.setVisibility(8);
        }
        this.rightViewImg.setVisibility(8);
        this.rightViewText.setOnClickListener(this);
        this.f80005d0 = findViewById(R.id.bww);
        SwipListView swipListView = (SwipListView) findViewById(R.id.c9n);
        this.f80003b0 = swipListView;
        if (ThemeUtil.isInNightMode(this.app)) {
            drawable = getResources().getDrawable(R.color.ahq);
        } else {
            drawable = getResources().getDrawable(R.color.a08);
        }
        swipListView.setDivider(drawable);
        this.f80003b0.setDividerHeight(getResources().getDimensionPixelSize(R.dimen.f158696ml));
        this.f80003b0.setOnScrollListener(new d());
        this.f80003b0.setDrawFinishedListener(this.f80027z0);
        View inflate = LayoutInflater.from(this).inflate(R.layout.bx4, (ViewGroup) null);
        this.f80016o0 = inflate;
        inflate.setBackgroundDrawable(null);
        ((Button) this.f80016o0.findViewById(R.id.btn_cancel_search)).setVisibility(8);
        ((TextView) this.f80016o0.findViewById(R.id.kag)).setText(String.format(getResources().getString(R.string.e0k), ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, getApplicationContext())));
        EditText editText = (EditText) this.f80016o0.findViewById(R.id.et_search_keyword);
        this.f80017p0 = editText;
        editText.setCursorVisible(false);
        this.f80017p0.setOnFocusChangeListener(new e());
        this.f80003b0.addHeaderView(this.f80016o0);
        U2();
        com.tencent.biz.pubaccount.subscript.a aVar = new com.tencent.biz.pubaccount.subscript.a(this, this.app, this.f80003b0, getLayoutInflater());
        this.f80002a0 = aVar;
        aVar.f(this);
        this.f80003b0.setAdapter((ListAdapter) this.f80002a0);
        this.f80002a0.d(this.f80006e0);
        this.f80002a0.g(this.f80008g0);
        if (!ThemeUtil.isInNightMode(this.app)) {
            this.f80003b0.setBackgroundResource(R.color.f157570tg);
        } else {
            this.f80003b0.setBackgroundResource(R.color.f157571th);
        }
        this.f80003b0.setDragEnable(true);
        this.f80003b0.setRightIconMenuListener(this);
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.5
            @Override // java.lang.Runnable
            public void run() {
                SubscriptFeedsActivity subscriptFeedsActivity = SubscriptFeedsActivity.this;
                subscriptFeedsActivity.f80022u0 = SubscriptRecommendController.o(subscriptFeedsActivity.app);
                if (((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).showPubAccUin(SubscriptFeedsActivity.this.app)) {
                    SubscriptFeedsActivity.this.f80022u0 = true;
                }
            }
        });
        fillData();
        if (this.f80004c0 == null) {
            this.f80004c0 = new SubscriptRecommendController(this, this.app, this.f80008g0);
        }
        this.app.setHandler(getClass(), this.F0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null) {
            qQAppInterface.removeHandler(getClass());
        }
        MqqHandler mqqHandler = this.F0;
        if (mqqHandler != null) {
            mqqHandler.removeCallbacksAndMessages(null);
            this.F0 = null;
        }
        removeObserver(this.E0);
        removeObserver(this.H0);
        QQAppInterface qQAppInterface2 = this.app;
        if (qQAppInterface2 != null && qQAppInterface2.getMessageFacade() != null) {
            this.app.getMessageFacade().deleteObserver(this);
        }
        SwipListView swipListView = this.f80003b0;
        if (swipListView != null) {
            swipListView.setAdapter((ListAdapter) null);
            this.f80003b0.setDrawFinishedListener(null);
        }
        com.tencent.biz.pubaccount.subscript.a aVar = this.f80002a0;
        if (aVar != null) {
            aVar.c();
            this.f80002a0 = null;
        }
        this.f80011j0 = null;
        SubscriptRecommendController subscriptRecommendController = this.f80004c0;
        if (subscriptRecommendController != null) {
            subscriptRecommendController.d();
        }
        this.f80006e0.removeOnDragModeChangeListener(this);
        this.f80008g0.a();
        this.f80008g0 = null;
        if (this.f80020s0 != 0) {
            this.f80020s0 = System.currentTimeMillis() - this.f80020s0;
            boolean z16 = this.f80021t0;
            ReportController.o(this.app, "dc00899", IPublicAccountHandler.MAIN_ACTION, "0", "0X80064CC", "0X80064CC", 0, 0, "" + (z16 ? 1 : 0), "" + this.f80020s0, "", "");
            this.f80020s0 = 0L;
            this.f80021t0 = false;
        }
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        DragFrameLayout dragFrameLayout = this.f80006e0;
        if (dragFrameLayout != null) {
            dragFrameLayout.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        int i3;
        super.doOnResume();
        boolean n3 = SubscriptRecommendController.n(this.app);
        View findViewById = super.findViewById(R.id.f165894dt1);
        if (n3) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
        if (this.f80012k0) {
            this.f80012k0 = false;
        }
        if (this.f80022u0) {
            String h16 = SubscriptRecommendController.h(this.app);
            Intent intent = new Intent(this, (Class<?>) ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
            if (TextUtils.isEmpty(h16)) {
                h16 = "http://sqimg.qq.com/qq_product_operations/dyzx_folder/index.html?_bid=2312";
            }
            intent.putExtra("url", h16);
            intent.putExtra("uin", this.app.getCurrentUin());
            intent.putExtra("fromLocalUrl", true);
            intent.putExtra("hide_operation_bar", true);
            intent.putExtra(IPublicAccountBrowser.KEY_BACK_TEXT, HardCodeUtil.qqStr(R.string.txo));
            intent.putExtra(IPublicAccountBrowser.KEY_HIDE_SHARE_BUTTON, true);
            intent.putExtra(IPublicAccountBrowser.KEY_BACK_TEXT, ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, this));
            intent.putExtra(IPublicAccountBrowser.KEY_CALL_FROM, 1001);
            startActivity(intent);
            overridePendingTransition(R.anim.f154867eg, R.anim.f154425m);
            if (QLog.isColorLevel()) {
                QLog.d("SubscriptFeedsActivity", 2, "subscript full recommend need show !");
            }
            this.f80022u0 = false;
            ReportController.o(this.app, "CliOper", "", "", "0X8006505", "0X8006505", 0, 0, "", "", "", "");
        }
        S2();
        T2();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        TroopBarAssistantManager.n().S(this.app);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j3;
        String str;
        IPublicAccountHandler iPublicAccountHandler;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        int i3 = 0;
        if (id5 == R.id.j7a) {
            ReportController.o(this.app, "CliOper", "", "", "0X8006572", "0X8006572", 0, 0, "", "", "", "");
            em.d(this, ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, this), null, "http://dyzx.mp.qq.com/static/v8/page/subscribecategory.html?_wv=1027&_bid=2278");
            SubscriptRecommendController.H(this.app, false);
            P2();
        } else if (id5 == R.id.ivTitleBtnRightText) {
            ReportController.o(this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005734", "0X8005734", 0, 0, "", "", "", "");
            em.d(this, ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, this), null, "http://dyzx.mp.qq.com/static/v8/page/subscribecategory.html?_wv=1027&_bid=2278");
            SubscriptRecommendController.H(this.app, false);
            P2();
        } else if (id5 == R.id.j7_) {
            if (((Integer) view.getTag(R.id.j7d)).intValue() == com.tencent.biz.pubaccount.subscript.a.f80069c0) {
                Object tag = view.getTag(R.id.j7c);
                Object tag2 = view.getTag(R.id.j7l);
                String str2 = "";
                if (tag2 == null) {
                    str = "";
                } else {
                    str = (String) tag2;
                }
                if (tag2 != null) {
                    i3 = ((Integer) tag).intValue();
                }
                Integer valueOf = Integer.valueOf(i3);
                if (valueOf.intValue() > 0) {
                    ReportController.o(this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X800572E", "0X800572E", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(this.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X800572F", "0X800572F", 0, 0, "", "", "", "");
                }
                ReportController.o(this.app, "CliOper", "", "", "0X8006240", "0X8006240", 0, 0, "", "", "", "");
                if (TextUtils.isEmpty(TroopBarAssistantManager.n().o(str)) && (iPublicAccountHandler = (IPublicAccountHandler) this.app.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT)) != null) {
                    iPublicAccountHandler.getUserFollowList();
                }
                Object tag3 = view.getTag(R.id.j7e);
                if (tag3 != null) {
                    str2 = (String) tag3;
                }
                Intent intent = new Intent(this, (Class<?>) ChatActivity.class);
                intent.putExtra("uintype", 1008);
                intent.putExtra("uin", str);
                intent.putExtra("uinname", str2);
                intent.putExtra("start_time", System.currentTimeMillis());
                intent.putExtra("red_hot_count", valueOf);
                startActivity(intent);
                P2();
            }
        } else if (id5 != R.id.e0h && id5 != R.id.f165987e02 && id5 != R.id.f165988e03 && id5 != R.id.f165989e04 && id5 != R.id.f165990e05) {
            if (id5 != R.id.eqh) {
            }
        } else {
            ReportController.o(null, "CliOper", "", "", "0X8006155", "0X8006155", 0, 0, "", "", "", "");
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.putExtra("channel_id", 0);
            intent2.putExtra("readinjoy_launch_source", 9);
            ArrayList arrayList = new ArrayList();
            ArrayList<ReadInJoyArticle> arrayList2 = this.f80011j0;
            if (arrayList2 != null && arrayList2.size() == 4) {
                while (i3 < 4) {
                    arrayList.add(Long.valueOf(this.f80011j0.get(i3).mArticleID));
                    i3++;
                }
                intent2.putExtra("subscription_all_article_id", arrayList);
                if (view.getId() != R.id.f165987e02 && view.getId() != R.id.f165988e03 && view.getId() != R.id.f165989e04 && view.getId() != R.id.f165990e05) {
                    intent2.putExtra("subscription_click_article_id", 0L);
                } else {
                    ReadInJoyArticle readInJoyArticle = this.f80011j0.get(((Integer) view.getTag()).intValue());
                    if (readInJoyArticle != null) {
                        j3 = readInJoyArticle.mArticleID;
                    } else {
                        j3 = -1;
                    }
                    intent2.putExtra("subscription_click_article_id", Long.valueOf(j3));
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("SubscriptFeedsActivity", 2, "subscription folder jump to readinjoy with ReadInJoyArticles wrong param");
            }
            this.f80012k0 = true;
            P2();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.widget.SwipListView.RightIconMenuListener
    public void onRightIconMenuHide(View view) {
        this.f80007f0 = -1;
        Q2(true);
    }

    @Override // com.tencent.widget.SwipListView.RightIconMenuListener
    public void onRightIconMenuShow(View view) {
        this.f80007f0 = ((Integer) view.getTag(R.id.j7f)).intValue();
        Q2(false);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (obj instanceof MessageRecord) {
            MessageRecord messageRecord = (MessageRecord) obj;
            if (!messageRecord.isSendFromLocal()) {
                runOnUiThread(new Runnable() { // from class: com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.11
                    @Override // java.lang.Runnable
                    public void run() {
                        SubscriptFeedsActivity.this.updateUnreadNumOnTitleBar();
                    }
                });
            }
            if (messageRecord.isSendFromLocal() && messageRecord.msgtype == -2002) {
                return;
            }
            T2();
        }
    }

    void updateUnreadNumOnTitleBar() {
        if (this.leftView != null) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    QQMessageFacade messageFacade = SubscriptFeedsActivity.this.app.getMessageFacade();
                    if (messageFacade != null) {
                        final int H1 = messageFacade.H1();
                        SubscriptFeedsActivity.this.leftView.post(new Runnable() { // from class: com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                int i3 = H1;
                                if (i3 <= 0) {
                                    SubscriptFeedsActivity.this.leftView.setText(R.string.hvn);
                                } else if (i3 > 99) {
                                    SubscriptFeedsActivity subscriptFeedsActivity = SubscriptFeedsActivity.this;
                                    subscriptFeedsActivity.leftView.setText(String.format("%s(%d+)", subscriptFeedsActivity.getString(R.string.hvn), 99));
                                } else {
                                    SubscriptFeedsActivity subscriptFeedsActivity2 = SubscriptFeedsActivity.this;
                                    subscriptFeedsActivity2.leftView.setText(String.format("%s(%d)", subscriptFeedsActivity2.getString(R.string.hvn), Integer.valueOf(H1)));
                                }
                            }
                        });
                    }
                }
            }, 5, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements com.tencent.biz.common.offline.a {
        f() {
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("SubscriptFeedsActivity", 2, "HtmlOffline.checkUpByBusinessId businessId=2278, code=" + i3);
            }
            SubscriptFeedsActivity.this.app.getApplication();
            int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("network", "" + systemNetwork);
            hashMap.put("status_code", "" + i3);
            StatisticCollector.getInstance(SubscriptFeedsActivity.this).collectPerformance((String) null, "subscription_htmloffline", true, 0L, 0L, hashMap, "", false);
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
        }
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragModeChangedListener
    public void onChange(boolean z16, int i3, QUIBadgeDragLayout qUIBadgeDragLayout) {
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class d implements AbsListView.OnScrollListener {
        d() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (i3 != 0) {
                oy3.a.a().b("list_subscript");
                return;
            }
            oy3.a.a().c("list_subscript", false);
            for (int i16 = 0; i16 <= absListView.getChildCount(); i16++) {
                View childAt = absListView.getChildAt(i16);
                if (childAt != null && (childAt.getTag() instanceof a.C0817a)) {
                    a.C0817a c0817a = (a.C0817a) childAt.getTag();
                    Drawable drawable = c0817a.f80083h.getDrawable();
                    if (drawable != null && (drawable instanceof URLDrawable)) {
                        URLDrawable uRLDrawable = (URLDrawable) drawable;
                        if (!uRLDrawable.isDownloadStarted()) {
                            if (QLog.isColorLevel()) {
                                QLog.d("SubscriptFeedsActivity", 2, "list child view start download pic!  uin : " + c0817a.f80076a);
                            }
                            uRLDrawable.startDownload();
                            uRLDrawable.setAutoDownload(true);
                        }
                    }
                }
            }
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        }
    }
}

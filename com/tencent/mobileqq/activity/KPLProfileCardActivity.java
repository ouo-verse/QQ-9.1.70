package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.KplCard;
import com.tencent.mobileqq.data.KplHelper;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.base.view.PullToZoomHeaderListView;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.HorizontalScrollLayout;
import com.tencent.mobileqq.widget.KPLScoreView;
import com.tencent.mobileqq.widget.ProfileCardFavorItemView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.XSimpleListAdapter;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.List;

/* loaded from: classes9.dex */
public class KPLProfileCardActivity extends BaseActivity implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    KplCard f176350a0;

    /* renamed from: b0, reason: collision with root package name */
    TextView f176351b0;

    /* renamed from: c0, reason: collision with root package name */
    Button f176352c0;

    /* renamed from: d0, reason: collision with root package name */
    LayoutInflater f176353d0;

    /* renamed from: e0, reason: collision with root package name */
    PullToZoomHeaderListView f176354e0;

    /* renamed from: f0, reason: collision with root package name */
    ImmersiveTitleBar2 f176355f0;

    /* renamed from: g0, reason: collision with root package name */
    TextView f176356g0;

    /* renamed from: h0, reason: collision with root package name */
    URLImageView f176357h0;

    /* renamed from: i0, reason: collision with root package name */
    AvatarLayout f176358i0;

    /* renamed from: j0, reason: collision with root package name */
    KplRoleInfo.WZRYUIinfo f176359j0;

    /* renamed from: k0, reason: collision with root package name */
    View f176360k0;

    /* renamed from: l0, reason: collision with root package name */
    boolean f176361l0;

    /* renamed from: m0, reason: collision with root package name */
    CardObserver f176362m0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) KPLProfileCardActivity.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            KPLProfileCardActivity kPLProfileCardActivity = KPLProfileCardActivity.this;
            if (!kPLProfileCardActivity.f176361l0) {
                ReportController.o(kPLProfileCardActivity.app, "dc00898", "", "", "0X8008438", "0X8008438", 0, 0, "", "", "", "");
                KPLProfileCardActivity.this.f176361l0 = true;
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes9.dex */
    class b extends CardObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) KPLProfileCardActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetKplCard(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("KPLProfileCardActivity", 2, "onGetKplCard, isSuccess=" + z16);
            }
            if (z16 && obj != null && (obj instanceof KplCard)) {
                KplCard kplCard = (KplCard) obj;
                KPLProfileCardActivity.this.Q2(kplCard);
                KPLProfileCardActivity.this.f176350a0 = kplCard;
            }
        }
    }

    public KPLProfileCardActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f176361l0 = false;
            this.f176362m0 = new b();
        }
    }

    private ViewGroup H2(ViewGroup viewGroup, int i3, String str) {
        if (viewGroup == null || i3 <= 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f176353d0.inflate(R.layout.f168839b00, (ViewGroup) null);
        View findViewById = viewGroup2.findViewById(R.id.icon);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.info);
        findViewById.setBackgroundResource(i3);
        textView.setText(str.trim());
        viewGroup.addView(viewGroup2);
        return viewGroup2;
    }

    private void I2() {
        if (!NetworkUtil.isNetworkAvailable(this)) {
            QQToast.makeText(this, getResources().getString(R.string.cjn), 0).show(getTitleBarHeight());
            return;
        }
        KplRoleInfo.WZRYUIinfo wZRYUIinfo = this.f176359j0;
        if (wZRYUIinfo != null && this.f176350a0 != null) {
            if (TextUtils.isEmpty(wZRYUIinfo.verifyMsg)) {
                this.f176359j0.verifyMsg = KplHelper.getKplVerifyMsg(this.app);
            }
            if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f176359j0.uin), "KPLProfileCardActivity")) {
                KplCard kplCard = this.f176350a0;
                String buildNickName = KplRoleInfo.WZRYUIinfo.buildNickName(kplCard.qqNick, kplCard.gameNick);
                KplRoleInfo.WZRYUIinfo wZRYUIinfo2 = this.f176359j0;
                int i3 = wZRYUIinfo2.sourceId;
                if (i3 == 0) {
                    i3 = 3045;
                }
                int i16 = i3;
                int i17 = wZRYUIinfo2.subSourceId;
                if (i17 == 0) {
                    i17 = 23;
                }
                int i18 = i17;
                Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(this, 1, this.f176359j0.uin, null, i16, i18, buildNickName, null, null, getString(R.string.f170028dd), null);
                startAddFriend.putExtra(IProfileCardConst.KEY_WZRY_DATA, this.f176359j0);
                ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(this, startAddFriend, 228);
                ReportController.o(this.app, "CliOper", "", "", "0X80085C5", "0X80085C5", 0, 0, String.valueOf(i18), "", "", "");
            }
        }
    }

    private void J2(HorizontalScrollLayout horizontalScrollLayout, KplCard kplCard) {
        int i3;
        horizontalScrollLayout.removeAllViews();
        int size = kplCard.roleList.size();
        int M = (int) com.tencent.mobileqq.utils.ah.M();
        if (size <= 4) {
            i3 = M / 4;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            horizontalScrollLayout.setLayoutParams(layoutParams);
        } else {
            i3 = (M * 146) / 640;
        }
        int i16 = i3;
        int f16 = i16 - BaseAIOUtils.f(20.0f, getResources());
        Drawable drawable = null;
        for (int i17 = 0; i17 < size; i17++) {
            KplRoleInfo kplRoleInfo = kplCard.roleList.get(i17);
            if (kplRoleInfo != null) {
                View inflate = this.f176353d0.inflate(R.layout.azs, (ViewGroup) null);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.d_m);
                if (drawable == null) {
                    drawable = getResources().getDrawable(R.drawable.f161838f42);
                }
                Drawable drawable2 = drawable;
                String str = kplRoleInfo.roleUrl;
                String str2 = kplRoleInfo.roleName;
                String str3 = kplRoleInfo.roleScore;
                try {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mLoadingDrawable = drawable2;
                    obtain.mFailedDrawable = drawable2;
                    obtain.mRequestHeight = f16;
                    obtain.mRequestWidth = f16;
                    URLDrawable drawable3 = URLDrawable.getDrawable(str, obtain);
                    drawable3.setTag(com.tencent.mobileqq.urldrawable.a.c(f16, f16, (int) (com.tencent.mobileqq.utils.ah.q() * 16.0f)));
                    drawable3.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
                    imageView.setImageDrawable(drawable3);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                ((TextView) inflate.findViewById(R.id.jq_)).setText(str2);
                ((TextView) inflate.findViewById(R.id.bgr)).setText(str3);
                inflate.setContentDescription(str2 + str3);
                horizontalScrollLayout.addView(inflate, new LinearLayout.LayoutParams(i16, -2));
                drawable = drawable2;
            }
        }
    }

    public static Intent K2(Context context) {
        return new Intent(context, (Class<?>) KPLProfileCardActivity.class);
    }

    private void L2() {
        setContentView(R.layout.avm);
        this.f176353d0 = (LayoutInflater) getSystemService("layout_inflater");
        this.f176360k0 = View.inflate(this, R.layout.avl, null);
        this.f176361l0 = false;
        FrameLayout frameLayout = (FrameLayout) findViewById(android.R.id.content);
        if (frameLayout != null) {
            frameLayout.setBackgroundResource(R.drawable.qq_profilecard_info_bg);
        }
        this.f176357h0 = (URLImageView) this.f176360k0.findViewById(R.id.dkn);
        this.f176358i0 = (AvatarLayout) this.f176360k0.findViewById(R.id.f165801dk3);
        this.f176351b0 = (TextView) this.f176360k0.findViewById(R.id.dkj);
        AvatarLayout avatarLayout = this.f176358i0;
        avatarLayout.d(0, avatarLayout.findViewById(R.id.a6e), false);
        PullToZoomHeaderListView pullToZoomHeaderListView = (PullToZoomHeaderListView) findViewById(R.id.common_xlistview);
        this.f176354e0 = pullToZoomHeaderListView;
        pullToZoomHeaderListView.setHeaderImage(this.f176357h0);
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        this.f176356g0 = textView;
        textView.setText(getString(R.string.button_back));
        this.f176356g0.setBackgroundResource(R.drawable.b09);
        this.f176356g0.setTextColor(getResources().getColor(R.color.a8u));
        this.f176356g0.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.al_);
        View inflate = View.inflate(this, R.layout.azh, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        Button button = (Button) inflate.findViewById(R.id.txt);
        this.f176352c0 = button;
        button.setText(R.string.aah);
        this.f176352c0.setTag(QQFriendJsPlugin.API_ADD_FRIEND);
        this.f176352c0.setOnClickListener(this);
        linearLayout.addView(inflate, layoutParams);
        this.f176352c0.setEnabled(false);
        ImmersiveTitleBar2 immersiveTitleBar2 = (ImmersiveTitleBar2) findViewById(R.id.jq6);
        this.f176355f0 = immersiveTitleBar2;
        immersiveTitleBar2.setVisibility(4);
        this.f176354e0.setAdapter((ListAdapter) new XSimpleListAdapter(this.f176360k0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M2() {
        FriendsManager friendsManager = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        CardHandler cardHandler = (CardHandler) this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        KplRoleInfo.WZRYUIinfo wZRYUIinfo = this.f176359j0;
        if (wZRYUIinfo != null) {
            this.f176350a0 = friendsManager.x(wZRYUIinfo.uin);
            if (!NetworkUtil.isNetworkAvailable(this)) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.KPLProfileCardActivity.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) KPLProfileCardActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            KPLProfileCardActivity kPLProfileCardActivity = KPLProfileCardActivity.this;
                            QQToast.makeText(kPLProfileCardActivity, kPLProfileCardActivity.getResources().getString(R.string.cjn), 0).show(KPLProfileCardActivity.this.getTitleBarHeight());
                        }
                    }
                });
            } else {
                cardHandler.Z2(this.f176359j0.uin);
            }
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.KPLProfileCardActivity.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) KPLProfileCardActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    KPLProfileCardActivity kPLProfileCardActivity = KPLProfileCardActivity.this;
                    kPLProfileCardActivity.Q2(kPLProfileCardActivity.f176350a0);
                }
            }
        });
    }

    private void N2(KplCard kplCard) {
        String str;
        if (kplCard == null) {
            return;
        }
        this.f176351b0.setText(KplRoleInfo.WZRYUIinfo.buildNickName(kplCard.qqNick, kplCard.gameNick));
        this.f176352c0.setEnabled(true);
        View findViewById = this.f176360k0.findViewById(R.id.f163854ah);
        findViewById.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) findViewById.findViewById(R.id.f163853ag);
        linearLayout.removeAllViews();
        int i3 = kplCard.gender;
        if (i3 == 0) {
            str = HardCodeUtil.qqStr(R.string.nkb);
        } else if (i3 == 1) {
            str = HardCodeUtil.qqStr(R.string.nkd);
        } else {
            str = "";
        }
        H2(linearLayout, R.drawable.qq_profilecard_item_information, str + kplCard.gameLevel);
        H2(linearLayout, R.drawable.adb, kplCard.commonInfo);
        ProfileCardFavorShowView profileCardFavorShowView = (ProfileCardFavorShowView) this.f176360k0.findViewById(R.id.e1j);
        profileCardFavorShowView.setVisibility(0);
        profileCardFavorShowView.setTitle(HardCodeUtil.qqStr(R.string.nkc));
        profileCardFavorShowView.removeAllViews();
        ProfileCardFavorItemView profileCardFavorItemView = new ProfileCardFavorItemView(this);
        profileCardFavorItemView.setTitle(HardCodeUtil.qqStr(R.string.nkf));
        profileCardFavorItemView.setArrowVisiale(false);
        profileCardFavorItemView.D.setVisibility(8);
        KPLScoreView kPLScoreView = new KPLScoreView(this);
        kPLScoreView.setKplValue(kplCard.mvpLevel + HardCodeUtil.qqStr(R.string.nkh), kplCard.superLevel + HardCodeUtil.qqStr(R.string.nkg), kplCard.score + "%", kplCard.round + HardCodeUtil.qqStr(R.string.nkh));
        profileCardFavorItemView.addView(kPLScoreView);
        profileCardFavorItemView.C.setImageDrawable(new ColorDrawable(getResources().getColor(R.color.f158017al3)));
        profileCardFavorShowView.addView(profileCardFavorItemView);
        List<KplRoleInfo> list = kplCard.roleList;
        if (list != null && list.size() > 0) {
            ProfileCardFavorItemView profileCardFavorItemView2 = new ProfileCardFavorItemView(this);
            profileCardFavorItemView2.setTitle(HardCodeUtil.qqStr(R.string.nki));
            profileCardFavorItemView2.setArrowVisiale(false);
            View inflate = this.f176353d0.inflate(R.layout.b0c, (ViewGroup) null);
            HorizontalScrollLayout horizontalScrollLayout = (HorizontalScrollLayout) inflate.findViewById(R.id.iie);
            horizontalScrollLayout.setOnTouchListener(new a());
            J2(horizontalScrollLayout, kplCard);
            profileCardFavorItemView2.addView(inflate);
            profileCardFavorItemView2.C.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.f158017al3)));
            profileCardFavorShowView.addView(profileCardFavorItemView2);
        }
    }

    private void P2(KplCard kplCard) {
        Drawable colorDrawable;
        if (kplCard == null) {
            return;
        }
        try {
            colorDrawable = getResources().getDrawable(R.drawable.f2v);
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            colorDrawable = new ColorDrawable(getResources().getColor(R.color.black));
        }
        try {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = colorDrawable;
            obtain.mFailedDrawable = colorDrawable;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.a0m);
            int i3 = getResources().getDisplayMetrics().widthPixels;
            obtain.mRequestHeight = dimensionPixelSize;
            obtain.mRequestWidth = i3;
            URLDrawable drawable = URLDrawable.getDrawable(kplCard.bgUrl, obtain);
            drawable.setTag(com.tencent.mobileqq.urldrawable.a.c(i3, dimensionPixelSize, (int) (com.tencent.mobileqq.utils.ah.q() * 10.0f)));
            this.f176357h0.setImageDrawable(drawable);
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        this.f176358i0.setFaceDrawable(this.app, 1, this.f176359j0.uin, 200, true, true, true, false, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q2(KplCard kplCard) {
        P2(kplCard);
        N2(kplCard);
    }

    private void initData() {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.activity.KPLProfileCardActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) KPLProfileCardActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    KPLProfileCardActivity.this.M2();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, null, true);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        this.f176359j0 = (KplRoleInfo.WZRYUIinfo) getIntent().getSerializableExtra(IProfileCardConst.KEY_WZRY_DATA);
        L2();
        initData();
        this.app.addObserver(this.f176362m0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.app.removeObserver(this.f176362m0);
            super.doOnDestroy();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ivTitleBtnLeft) {
                finish();
            } else if (id5 != R.id.ivTitleBtnRightText && QQFriendJsPlugin.API_ADD_FRIEND.equals(view.getTag())) {
                I2();
                ReportController.o(this.app, "dc00898", "", "", "0X8008436", "0X8008436", 0, 0, "", "", "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}

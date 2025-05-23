package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StMessageStatus;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StQQGroup;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StYouZanGood;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StYouZanShop;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetMainPageRsp;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StMainPageJumpH5URL;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerView;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import com.tencent.biz.subscribe.widget.textview.NewStyleFollowTextView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class RelativePersonalDetailHeadItemView extends RelativeFeedBaseHeaderView implements View.OnClickListener, SimpleEventReceiver {
    private boolean E;
    private Context F;
    private CertifiedAccountRead$StGetMainPageRsp G;
    private RecyclerView H;
    private b I;
    private TextView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private TextView N;
    private SquareImageView P;
    private Button Q;
    private TextView R;
    private ImageView S;
    private TextView T;
    private ImageView U;
    private ImageView V;
    private ImageView W;

    /* renamed from: a0, reason: collision with root package name */
    private View f96502a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f96503b0;

    /* renamed from: c0, reason: collision with root package name */
    private LinearLayout f96504c0;

    /* renamed from: d0, reason: collision with root package name */
    private FrameLayout f96505d0;

    /* renamed from: e0, reason: collision with root package name */
    private NewStyleFollowTextView f96506e0;

    /* renamed from: f0, reason: collision with root package name */
    private ImageView f96507f0;

    /* renamed from: g0, reason: collision with root package name */
    private ImageView f96508g0;

    /* renamed from: h0, reason: collision with root package name */
    private LinearLayout f96509h0;

    /* renamed from: i0, reason: collision with root package name */
    private TextView f96510i0;

    /* renamed from: j0, reason: collision with root package name */
    private TextView f96511j0;

    /* renamed from: k0, reason: collision with root package name */
    private TopGestureLayout f96512k0;

    /* renamed from: l0, reason: collision with root package name */
    private FollowedRecommendBannerView f96513l0;

    /* renamed from: m0, reason: collision with root package name */
    private AnimationDrawable f96514m0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StYouZanShop f96517d;

        a(CertifiedAccountMeta$StYouZanShop certifiedAccountMeta$StYouZanShop) {
            this.f96517d = certifiedAccountMeta$StYouZanShop;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            com.tencent.biz.subscribe.d.l(this.f96517d.schema.get());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: d, reason: collision with root package name */
        private List<CertifiedAccountMeta$StQQGroup> f96519d;

        public b(List<CertifiedAccountMeta$StQQGroup> list) {
            this.f96519d = list;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<CertifiedAccountMeta$StQQGroup> list = this.f96519d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
            c cVar;
            List<CertifiedAccountMeta$StQQGroup> list = this.f96519d;
            if (list != null && list.size() > i3 && (cVar = (c) viewHolder) != null) {
                cVar.b(this.f96519d.get(i3));
            }
            EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
            ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f167704c74, viewGroup, false);
            List<CertifiedAccountMeta$StQQGroup> list = this.f96519d;
            if (list != null && list.size() == 1) {
                viewGroup2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            return new c(viewGroup2);
        }
    }

    /* loaded from: classes5.dex */
    private class c extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private TextView f96521d;

        /* renamed from: e, reason: collision with root package name */
        private TextView f96522e;

        /* renamed from: f, reason: collision with root package name */
        private Button f96523f;

        /* renamed from: h, reason: collision with root package name */
        private CertifiedAccountMeta$StQQGroup f96524h;

        public c(View view) {
            super(view);
            this.f96521d = (TextView) view.findViewById(R.id.tv_name);
            this.f96522e = (TextView) view.findViewById(R.id.mdk);
            Button button = (Button) view.findViewById(R.id.f164674lb3);
            this.f96523f = button;
            button.setOnClickListener(this);
        }

        public void b(CertifiedAccountMeta$StQQGroup certifiedAccountMeta$StQQGroup) {
            int i3;
            String str;
            if (certifiedAccountMeta$StQQGroup != null) {
                this.f96521d.setText(certifiedAccountMeta$StQQGroup.name.get());
                this.f96522e.setText(certifiedAccountMeta$StQQGroup.memberNum.get() + HardCodeUtil.qqStr(R.string.szt));
                this.f96524h = certifiedAccountMeta$StQQGroup;
                Button button = this.f96523f;
                if (certifiedAccountMeta$StQQGroup.joinState.get() == 1) {
                    i3 = R.string.szp;
                } else {
                    i3 = R.string.szo;
                }
                button.setText(HardCodeUtil.qqStr(i3));
                if (RelativePersonalDetailHeadItemView.this.G.user != null) {
                    String str2 = RelativePersonalDetailHeadItemView.this.G.user.f24929id.get();
                    if (certifiedAccountMeta$StQQGroup.joinState.get() == 1) {
                        str = "open_butten";
                    } else {
                        str = "enter_butten";
                    }
                    VSReporter.n(str2, "auth_fan", str, 0, 0, new String[0]);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.f96524h != null && view != null && view.getContext() != null) {
                if (this.f96524h.joinState.get() == 1) {
                    Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(view.getContext()), new int[]{2});
                    m3.putExtra("uin", String.valueOf(this.f96524h.f24927id.get()));
                    m3.putExtra("uintype", 1);
                    m3.putExtra("uinname", this.f96524h.name.get());
                    view.getContext().startActivity(m3);
                } else {
                    Bundle b16 = aq.b(String.valueOf(this.f96524h.f24927id.get()), 4);
                    b16.putInt("t_s_f", 1001);
                    TroopUtils.I(view.getContext(), b16, 2);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public RelativePersonalDetailHeadItemView(Context context) {
        super(context);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.F = context;
    }

    private void A() {
        if (this.G != null && this.F != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(this.G.user.iconInfo.iconUrl.get())) {
                arrayList.add(this.G.user.iconInfo.iconUrl.get());
            } else {
                arrayList.add(this.G.user.icon.get());
            }
            Intent intent = new Intent(this.F, (Class<?>) TroopAvatarWallPreviewActivity.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, arrayList);
            bundle.putBoolean(IProfileCardConst.KEY_DELETE_ABILITY, false);
            bundle.putBoolean("IS_EDIT", false);
            bundle.putBoolean("is_use_path", true);
            bundle.putBoolean("is_show_action", false);
            bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_IS_NOT_SHOW_INDEX, false);
            intent.putExtras(bundle);
            this.F.startActivity(intent);
            VSReporter.p(this.G.user.f24929id.get(), "auth_person", "clk_head", 0, 0, new String[0]);
        }
    }

    private View B(CertifiedAccountMeta$StYouZanGood certifiedAccountMeta$StYouZanGood) {
        SquareImageView squareImageView = new SquareImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ImmersiveUtils.dpToPx(27.0f), ImmersiveUtils.dpToPx(27.0f));
        layoutParams.rightMargin = ImmersiveUtils.dpToPx(5.0f);
        squareImageView.setLayoutParams(layoutParams);
        squareImageView.setRoundRect(ImmersiveUtils.dpToPx(5.0f));
        squareImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        UIUtils.t(squareImageView, certifiedAccountMeta$StYouZanGood.img.get(), ImmersiveUtils.dpToPx(27.0f), ImmersiveUtils.dpToPx(27.0f), null, "");
        return squareImageView;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean D(int i3) {
        char c16;
        CertifiedAccountMeta$StUser certifiedAccountMeta$StUser;
        CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp = this.G;
        if (certifiedAccountRead$StGetMainPageRsp != null && (certifiedAccountMeta$StUser = certifiedAccountRead$StGetMainPageRsp.user) != null) {
            String binaryString = Long.toBinaryString(certifiedAccountMeta$StUser.attr.get());
            if (!TextUtils.isEmpty(binaryString) && binaryString.length() > i3) {
                c16 = binaryString.charAt((binaryString.length() - 1) - i3);
                if (c16 != '1') {
                    return true;
                }
                return false;
            }
        }
        c16 = '0';
        if (c16 != '1') {
        }
    }

    private void F() {
        String str;
        if (this.f96502a0 == null) {
            this.f96502a0 = findViewById(R.id.lqy);
        }
        CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp = this.G;
        if (certifiedAccountRead$StGetMainPageRsp != null && certifiedAccountRead$StGetMainPageRsp.user.youZhan.size() != 0) {
            if (this.G.user.youZhan.get(0).goods.size() != 0) {
                CertifiedAccountMeta$StYouZanShop certifiedAccountMeta$StYouZanShop = this.G.user.youZhan.get(0);
                if (this.f96504c0 == null) {
                    this.f96504c0 = (LinearLayout) findViewById(R.id.lqk);
                }
                if (this.f96503b0 == null) {
                    this.f96503b0 = (TextView) findViewById(R.id.mcy);
                }
                TextView textView = (TextView) findViewById(R.id.mdy);
                if (SubscribeUtils.o(this.G.user.attr.get())) {
                    str = HardCodeUtil.qqStr(R.string.szr);
                } else {
                    str = this.G.user.nick.get();
                }
                textView.setText(str);
                this.f96504c0.removeAllViews();
                this.f96502a0.setVisibility(0);
                this.f96503b0.setText(String.format(HardCodeUtil.qqStr(R.string.vs_), Integer.valueOf(certifiedAccountMeta$StYouZanShop.goodNum.get())));
                int i3 = 4;
                if (certifiedAccountMeta$StYouZanShop.goods.size() <= 4) {
                    i3 = certifiedAccountMeta$StYouZanShop.goods.size();
                }
                for (int i16 = 0; i16 < i3; i16++) {
                    this.f96504c0.addView(B(certifiedAccountMeta$StYouZanShop.goods.get(i16)));
                }
                this.f96502a0.setOnClickListener(new a(certifiedAccountMeta$StYouZanShop));
                return;
            }
        }
        this.f96502a0.setVisibility(8);
    }

    private void G() {
        this.Q.setOnClickListener(this);
        this.T.setOnClickListener(this);
        this.V.setOnClickListener(this);
        this.U.setOnClickListener(this);
        this.S.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.f96505d0.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean H() {
        return D(1);
    }

    private boolean I() {
        return D(3);
    }

    private String J(String str) {
        String str2 = "";
        if (str == null) {
            return "";
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("location");
            if (optJSONObject == null) {
                return "";
            }
            String optString = optJSONObject.optString("country");
            String optString2 = optJSONObject.optString("province");
            String optString3 = optJSONObject.optString(GdtGetUserInfoHandler.KEY_AREA);
            if (!TextUtils.isEmpty(optString)) {
                str2 = optString;
            }
            if (!TextUtils.isEmpty(optString2)) {
                str2 = str2 + "\u00b7" + optString2;
            }
            if (!TextUtils.isEmpty(optString3)) {
                return str2 + "\u00b7" + optString3;
            }
            return str2;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    private void K() {
        try {
            String str = SubscribeUtils.j() + "/certified_account_personal_head_bg.png";
            if (new File(str).exists()) {
                ViewGroup.LayoutParams layoutParams = this.W.getLayoutParams();
                int screenWidth = ImmersiveUtils.getScreenWidth();
                layoutParams.width = screenWidth;
                layoutParams.height = (int) (screenWidth * 0.66d);
                this.W.setLayoutParams(layoutParams);
                this.W.setImageDrawable(Drawable.createFromPath(str));
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (this.f96514m0 == null) {
            this.f96514m0 = (AnimationDrawable) getResources().getDrawable(R.drawable.lf6);
        }
        this.f96514m0.stop();
        ImageView imageView = this.V;
        if (imageView != null && imageView.getVisibility() != 8) {
            this.V.setImageDrawable(this.f96514m0);
            this.f96514m0.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        AnimationDrawable animationDrawable = this.f96514m0;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
        this.V.setImageResource(R.drawable.nyi);
    }

    private void N(final PublishBoxStatusEvent publishBoxStatusEvent) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView.3
            @Override // java.lang.Runnable
            public void run() {
                if (RelativePersonalDetailHeadItemView.this.H() && publishBoxStatusEvent.taskCount > 0) {
                    RelativePersonalDetailHeadItemView.this.V.setVisibility(0);
                    RelativePersonalDetailHeadItemView.this.T.setVisibility(0);
                    hd0.c.k("RelativePersonalDetailH", "updateUploadBoxStatus  PublishBoxStatusEvent  VISIBLE  taskCount = " + publishBoxStatusEvent.taskCount + "  hasRunningTask:" + publishBoxStatusEvent.hasRunningTask + "  hasOfflineWaitingTask:" + publishBoxStatusEvent.hasOfflineWaitingTask);
                    PublishBoxStatusEvent publishBoxStatusEvent2 = publishBoxStatusEvent;
                    if (publishBoxStatusEvent2.hasRunningTask) {
                        RelativePersonalDetailHeadItemView.this.L();
                        RelativePersonalDetailHeadItemView.this.T.setBackgroundResource(R.drawable.skin_tips_newmessage);
                        RelativePersonalDetailHeadItemView.this.T.setText(String.valueOf(publishBoxStatusEvent.taskCount));
                        return;
                    } else if (publishBoxStatusEvent2.hasOfflineWaitingTask) {
                        RelativePersonalDetailHeadItemView.this.M();
                        RelativePersonalDetailHeadItemView.this.T.setBackgroundResource(R.drawable.gcs);
                        RelativePersonalDetailHeadItemView.this.T.setText("");
                        return;
                    } else {
                        RelativePersonalDetailHeadItemView.this.M();
                        RelativePersonalDetailHeadItemView.this.T.setBackgroundResource(R.drawable.gcr);
                        RelativePersonalDetailHeadItemView.this.T.setText("");
                        return;
                    }
                }
                RelativePersonalDetailHeadItemView.this.V.setVisibility(8);
                RelativePersonalDetailHeadItemView.this.T.setVisibility(8);
                hd0.c.k("RelativePersonalDetailH", "updateUploadBoxStatus  PublishBoxStatusEvent  GONE");
            }
        });
    }

    private boolean z() {
        return D(0);
    }

    public void C(boolean z16) {
        TopGestureLayout E = E();
        if (E != null) {
            E.setInterceptTouchFlag(z16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("RelativePersonalDetailH", 2, "enableFlingRight->enable:" + z16);
        }
    }

    protected TopGestureLayout E() {
        if (this.f96512k0 == null && (getContext() instanceof BaseActivity)) {
            ViewGroup viewGroup = (ViewGroup) ((BaseActivity) getContext()).getWindow().getDecorView();
            View childAt = viewGroup.getChildAt(0);
            if (childAt instanceof DragFrameLayout) {
                viewGroup = (ViewGroup) childAt;
            }
            View childAt2 = viewGroup.getChildAt(0);
            if (childAt2 instanceof TopGestureLayout) {
                this.f96512k0 = (TopGestureLayout) childAt2;
            }
        }
        return this.f96512k0;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    public void c(Object obj) {
        CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp = (CertifiedAccountRead$StGetMainPageRsp) obj;
        this.G = certifiedAccountRead$StGetMainPageRsp;
        if (certifiedAccountRead$StGetMainPageRsp == null) {
            return;
        }
        NewStyleFollowTextView newStyleFollowTextView = this.f96506e0;
        if (newStyleFollowTextView != null) {
            newStyleFollowTextView.setUserData(certifiedAccountRead$StGetMainPageRsp.user);
            this.f96506e0.setNoneReportType(false);
            this.f96506e0.setExtraTypeInfo(g());
        }
        if (this.G.vecGroup.get() != null && this.G.vecGroup.get().size() != 0) {
            this.R.setVisibility(0);
            b bVar = new b(this.G.vecGroup.get());
            this.I = bVar;
            this.H.setAdapter(bVar);
            CertifiedAccountMeta$StUser certifiedAccountMeta$StUser = this.G.user;
            if (certifiedAccountMeta$StUser != null && this.E) {
                VSReporter.n(certifiedAccountMeta$StUser.f24929id.get(), "auth_fan", "card_expo", 0, 0, new String[0]);
                this.E = false;
            }
        } else {
            this.R.setVisibility(8);
        }
        CertifiedAccountMeta$StUser certifiedAccountMeta$StUser2 = this.G.user;
        if (certifiedAccountMeta$StUser2 != null && certifiedAccountMeta$StUser2.get() != null) {
            setPostUserData(this.G.user);
        }
        this.L.setText(SubscribeUtils.b(this.G.feedCount.get()));
        this.M.setText(SubscribeUtils.b(this.G.fansCount.get()));
        this.N.setText(SubscribeUtils.b(this.G.followCount.get()));
        F();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(FollowUpdateEvent.class);
        arrayList.add(PublishBoxStatusEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    public int i() {
        return R.layout.f167702c72;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
        QzoneIPCModule.getInstance().getCertifiedAccountTaskList();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp;
        CertifiedAccountMeta$StMessageStatus certifiedAccountMeta$StMessageStatus;
        CertifiedAccountRead$StMainPageJumpH5URL certifiedAccountRead$StMainPageJumpH5URL;
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.lau) {
            CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp2 = this.G;
            if (certifiedAccountRead$StGetMainPageRsp2 != null && (certifiedAccountRead$StMainPageJumpH5URL = certifiedAccountRead$StGetMainPageRsp2.jumpURLs) != null && !TextUtils.isEmpty(certifiedAccountRead$StMainPageJumpH5URL.editPageURL.get())) {
                com.tencent.biz.subscribe.d.l(this.G.jumpURLs.editPageURL.get());
            }
        } else if (id5 != R.id.loo && id5 != R.id.men) {
            if (id5 != R.id.lo7 && id5 != R.id.lo8) {
                if (id5 == R.id.eda) {
                    CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp3 = this.G;
                    if (certifiedAccountRead$StGetMainPageRsp3 != null && certifiedAccountRead$StGetMainPageRsp3.user.has() && !TextUtils.isEmpty(this.G.user.f24929id.get()) && H()) {
                        com.tencent.biz.subscribe.d.l("https://h5.qzone.qq.com/subscription/followlist?_proxy=1_wv=3");
                    }
                } else if (id5 == R.id.dvu) {
                    A();
                } else if (id5 == R.id.lqf) {
                    CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp4 = this.G;
                    if (certifiedAccountRead$StGetMainPageRsp4 != null && certifiedAccountRead$StGetMainPageRsp4.user.has() && !TextUtils.isEmpty(this.G.user.f24929id.get()) && H()) {
                        com.tencent.biz.subscribe.d.l("https://h5.qzone.qq.com/subscription/fanslist/{uin}?_proxy=1&_wv=3".replace("{uin}", this.G.user.f24929id.get()));
                        VSReporter.p(this.G.user.f24929id.get(), "auth_person", "clk_fans", 0, 0, new String[0]);
                    }
                } else if (id5 == R.id.fd_ && this.G != null) {
                    if (this.f96513l0.i()) {
                        this.f96513l0.f();
                        this.f96508g0.setImageResource(R.drawable.cfq);
                        VSReporter.p(this.G.user.f24929id.get(), "auth_person", "show_reco", 0, 0, new String[0]);
                    } else {
                        this.f96513l0.e(this.G.user.f24929id.get());
                        this.f96508g0.setImageResource(R.drawable.cfr);
                        VSReporter.p(this.G.user.f24929id.get(), "auth_person", "fold_reco", 0, 0, new String[0]);
                    }
                }
            } else {
                CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp5 = this.G;
                if (certifiedAccountRead$StGetMainPageRsp5 != null && (certifiedAccountMeta$StMessageStatus = certifiedAccountRead$StGetMainPageRsp5.messStatus) != null && !TextUtils.isEmpty(certifiedAccountMeta$StMessageStatus.jumpURL.get())) {
                    com.tencent.biz.subscribe.d.l(this.G.messStatus.jumpURL.get());
                    VSReporter.p(this.G.user.f24929id.get(), "auth_person", "msg_clk", 0, 0, new String[0]);
                }
            }
        } else if (this.F != null && (certifiedAccountRead$StGetMainPageRsp = this.G) != null && certifiedAccountRead$StGetMainPageRsp.user != null) {
            Intent intent = new Intent();
            intent.putExtra(QZoneHelper.Constants.KEY_TYPE_QUEUE, 2);
            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                QQAppInterface qQAppInterface = (QQAppInterface) runtime;
                userInfo.nickname = qQAppInterface.getCurrentNickname();
                userInfo.qzone_uin = qQAppInterface.getCurrentUin();
            }
            QZoneHelper.forwardToPublishQueue((Activity) this.F, userInfo, intent, -1);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        AnimationDrawable animationDrawable = this.f96514m0;
        if (animationDrawable != null) {
            animationDrawable.stop();
            this.f96514m0 = null;
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp;
        CertifiedAccountMeta$StUser certifiedAccountMeta$StUser;
        if ((simpleBaseEvent instanceof FollowUpdateEvent) && (certifiedAccountRead$StGetMainPageRsp = this.G) != null && (certifiedAccountMeta$StUser = certifiedAccountRead$StGetMainPageRsp.user) != null) {
            FollowUpdateEvent followUpdateEvent = (FollowUpdateEvent) simpleBaseEvent;
            if (TextUtils.equals(certifiedAccountMeta$StUser.f24929id.get(), followUpdateEvent.useId)) {
                final int i3 = this.G.fansCount.get();
                if (followUpdateEvent.followStatus == 1 && this.G.user.followState.get() == 0) {
                    i3++;
                    if (!this.f96513l0.i()) {
                        this.f96513l0.e(followUpdateEvent.useId);
                    }
                    this.f96508g0.setImageResource(R.drawable.cfr);
                } else if (followUpdateEvent.followStatus == 0 && this.G.user.followState.get() == 1 && i3 > 0) {
                    i3--;
                }
                this.G.fansCount.set(i3);
                this.G.user.followState.set(followUpdateEvent.followStatus);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalDetailHeadItemView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        RelativePersonalDetailHeadItemView.this.M.setText(i3 + "");
                    }
                });
                hd0.c.k("RelativePersonalDetailH", "onReceiveEvent  id:" + followUpdateEvent.useId + " , status:" + followUpdateEvent.followStatus + " " + toString());
                return;
            }
        }
        if (simpleBaseEvent instanceof PublishBoxStatusEvent) {
            N((PublishBoxStatusEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    public void p(Context context, View view) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.m7d);
        this.H = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.F, 0, false));
        this.H.setNestedScrollingEnabled(true);
        this.J = (TextView) findViewById(R.id.mdg);
        this.K = (TextView) findViewById(R.id.f167042k73);
        this.f96506e0 = (NewStyleFollowTextView) findViewById(R.id.mco);
        this.L = (TextView) findViewById(R.id.mcg);
        this.M = (TextView) findViewById(R.id.k7x);
        this.N = (TextView) findViewById(R.id.k86);
        this.P = (SquareImageView) findViewById(R.id.dvu);
        this.Q = (Button) findViewById(R.id.lau);
        this.R = (TextView) findViewById(R.id.mcc);
        this.S = (ImageView) findViewById(R.id.lo8);
        this.T = (TextView) findViewById(R.id.men);
        this.U = (ImageView) findViewById(R.id.lo7);
        this.V = (ImageView) findViewById(R.id.loo);
        this.W = (ImageView) findViewById(R.id.g0e);
        this.f96505d0 = (FrameLayout) findViewById(R.id.fd_);
        this.f96508g0 = (ImageView) findViewById(R.id.g0h);
        this.f96507f0 = (ImageView) findViewById(R.id.f165969dy0);
        this.f96513l0 = (FollowedRecommendBannerView) findViewById(R.id.f166764i24);
        this.f96509h0 = (LinearLayout) findViewById(R.id.f166100gi4);
        this.f96510i0 = (TextView) findViewById(R.id.k9e);
        this.f96511j0 = (TextView) findViewById(R.id.jfd);
        K();
        G();
        C(false);
    }

    public void setCardReport(boolean z16) {
        this.E = z16;
    }

    public void setPostUserData(CertifiedAccountMeta$StUser certifiedAccountMeta$StUser) {
        CertifiedAccountMeta$StMessageStatus certifiedAccountMeta$StMessageStatus;
        if (this.f96506e0 != null && certifiedAccountMeta$StUser != null && certifiedAccountMeta$StUser.get() != null) {
            this.J.setText(certifiedAccountMeta$StUser.nick.get());
            this.K.setText(certifiedAccountMeta$StUser.desc.get());
            this.P.getLayoutParams().width = ScreenUtil.dip2px(92.0f);
            this.P.getLayoutParams().height = ScreenUtil.dip2px(92.0f);
            com.tencent.biz.subscribe.a.e(certifiedAccountMeta$StUser.icon.get(), this.P);
            if (z()) {
                this.Q.setVisibility(0);
            } else {
                this.Q.setVisibility(8);
            }
            if (I()) {
                this.U.setVisibility(0);
                CertifiedAccountRead$StGetMainPageRsp certifiedAccountRead$StGetMainPageRsp = this.G;
                if (certifiedAccountRead$StGetMainPageRsp != null && (certifiedAccountMeta$StMessageStatus = certifiedAccountRead$StGetMainPageRsp.messStatus) != null && certifiedAccountMeta$StMessageStatus.readStatus.get() == 1) {
                    this.S.setVisibility(0);
                } else {
                    this.S.setVisibility(8);
                }
            } else {
                this.U.setVisibility(8);
                this.S.setVisibility(8);
            }
            if (H()) {
                this.f96506e0.setVisibility(8);
                this.f96505d0.setVisibility(8);
            } else {
                this.Q.setVisibility(8);
                if (certifiedAccountMeta$StUser.type.get() == 1) {
                    this.f96506e0.setVisibility(0);
                    this.f96505d0.setVisibility(0);
                } else {
                    this.f96506e0.setVisibility(8);
                    this.f96505d0.setVisibility(8);
                }
                this.V.setVisibility(8);
                this.T.setVisibility(8);
            }
            if (certifiedAccountMeta$StUser.personInfo.sex.get() == 1) {
                this.f96507f0.setImageResource(R.drawable.cfs);
            } else if (certifiedAccountMeta$StUser.personInfo.sex.get() == 2) {
                this.f96507f0.setImageResource(R.drawable.cft);
            }
            if (TextUtils.isEmpty(certifiedAccountMeta$StUser.personInfo.location.get()) && TextUtils.isEmpty(certifiedAccountMeta$StUser.personInfo.school.get())) {
                this.f96509h0.setVisibility(8);
                return;
            }
            this.f96509h0.setVisibility(0);
            this.f96510i0.setText(J(certifiedAccountMeta$StUser.personInfo.location.get()));
            this.f96511j0.setText(certifiedAccountMeta$StUser.personInfo.school.get());
        }
    }
}

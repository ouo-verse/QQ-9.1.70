package com.tencent.mobileqq.activity.aio.intimate;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper;
import com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderCardUtil;
import com.tencent.mobileqq.activity.aio.intimate.header.n;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.couple.api.IZPlanCoupleSceneHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.api.IQZoneIntimateSpaceApi;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import qzone.QZIntimateSpaceRedDotReader$EntranceInfo;

/* loaded from: classes10.dex */
public class MainIntimateTitlePart extends Part implements View.OnClickListener, View.OnTouchListener {
    private View C;
    private View D;
    private ImageView E;
    private ImageView F;
    private TextView G;
    private ImageView H;
    private LinearLayout I;
    private ActionSheet J;
    private IntimateInfoShareHelper K;
    private QQCustomDialog L;
    private QQProgressDialog M;
    private TextView N;
    private IntimateInfo P;
    private int T;
    private URLDrawable Y;

    /* renamed from: c0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.aio.intimate.header.h f178873c0;

    /* renamed from: d, reason: collision with root package name */
    private IntimateInfoHandler f178874d;

    /* renamed from: d0, reason: collision with root package name */
    private QZIntimateSpaceRedDotReader$EntranceInfo f178875d0;

    /* renamed from: e, reason: collision with root package name */
    private Handler f178876e;

    /* renamed from: e0, reason: collision with root package name */
    private f61.d f178877e0;

    /* renamed from: f0, reason: collision with root package name */
    private AnimatorSet f178879f0;

    /* renamed from: h, reason: collision with root package name */
    private Context f178881h;

    /* renamed from: i, reason: collision with root package name */
    private View f178883i;

    /* renamed from: m, reason: collision with root package name */
    private View f178886m;

    /* renamed from: f, reason: collision with root package name */
    private String f178878f = "";
    private boolean Q = false;
    private boolean R = false;
    private int S = 1;
    private int U = 0;
    private int V = 0;
    private long W = 0;
    private boolean X = false;
    private boolean Z = false;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f178871a0 = false;

    /* renamed from: b0, reason: collision with root package name */
    private g f178872b0 = null;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f178880g0 = true;

    /* renamed from: h0, reason: collision with root package name */
    private int f178882h0 = 0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f178884i0 = false;

    /* renamed from: j0, reason: collision with root package name */
    public View.OnClickListener f178885j0 = new c();

    /* loaded from: classes10.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (MainIntimateTitlePart.this.J != null) {
                MainIntimateTitlePart.this.J.dismiss();
            }
            MainIntimateTitlePart.this.qa(5);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            try {
                if (MainIntimateTitlePart.this.L != null && MainIntimateTitlePart.this.L.isShowing()) {
                    MainIntimateTitlePart.this.L.dismiss();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (QLog.isColorLevel()) {
                QLog.d("intimate_relationship", 2, "disband cancel");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (!TextUtils.isEmpty(MainIntimateTitlePart.this.f178878f) && MainIntimateTitlePart.this.P != null) {
                if (MainIntimateTitlePart.this.T == 1) {
                    MainIntimateTitlePart mainIntimateTitlePart = MainIntimateTitlePart.this;
                    mainIntimateTitlePart.Z9(mainIntimateTitlePart.f178878f);
                } else {
                    MainIntimateTitlePart mainIntimateTitlePart2 = MainIntimateTitlePart.this;
                    mainIntimateTitlePart2.Y9(mainIntimateTitlePart2.f178878f, MainIntimateTitlePart.this.P.maskType);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface g {
        void a();
    }

    public MainIntimateTitlePart(Context context, View view) {
        this.f178881h = context;
        this.f178883i = view;
        this.f178886m = view.findViewById(R.id.jqb);
        this.C = this.f178883i.findViewById(R.id.f98385my);
        this.D = this.f178883i.findViewById(R.id.f98355mv);
        this.E = (ImageView) this.f178883i.findViewById(R.id.a47);
        this.F = (ImageView) this.f178883i.findViewById(R.id.eps);
        this.I = (LinearLayout) this.f178883i.findViewById(R.id.f72653rf);
        this.H = (ImageView) this.f178883i.findViewById(R.id.f72643re);
        this.G = (TextView) this.f178883i.findViewById(R.id.f72663rg);
        this.N = (TextView) this.f178883i.findViewById(R.id.tqh);
        this.E.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.E.setOnTouchListener(this);
        this.F.setOnTouchListener(this);
        this.I.setOnTouchListener(this);
        this.I.setBackground(ie0.a.f().k(this.I.getContext(), R.color.qui_common_fill_allblack_weak, ViewUtils.dip2px(18.0f), 1000));
        this.I.setVisibility(8);
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(this.f178881h);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        layoutParams.topMargin = statusBarHeight;
        this.C.setLayoutParams(layoutParams);
        this.D.setLayoutParams(new RelativeLayout.LayoutParams(-1, statusBarHeight + ViewUtils.dpToPx(44.0f)));
        this.D.setAlpha(0.0f);
        Ua(null, true);
        if (AppSetting.f99565y) {
            this.E.setContentDescription(HardCodeUtil.qqStr(R.string.f171898lr0));
            this.F.setContentDescription(HardCodeUtil.qqStr(R.string.ngp));
            this.I.setContentDescription(HardCodeUtil.qqStr(R.string.f213185pi));
        }
        this.f178873c0 = (com.tencent.mobileqq.activity.aio.intimate.header.h) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("intimate_aio_rightframe_game_8970_config");
    }

    private void Ga(String str) {
        if (TextUtils.isEmpty(str)) {
            this.G.setVisibility(8);
            int dip2px = ViewUtils.dip2px(6.0f);
            this.I.setPadding(dip2px, 0, dip2px, 0);
        } else {
            int dip2px2 = ViewUtils.dip2px(10.0f);
            this.G.setVisibility(0);
            this.G.setText(str);
            this.I.setPadding(dip2px2, 0, dip2px2, 0);
        }
    }

    private void Ka() {
        Context context = this.f178881h;
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            QZIntimateSpaceRedDotReader$EntranceInfo qZIntimateSpaceRedDotReader$EntranceInfo = this.f178875d0;
            if (qZIntimateSpaceRedDotReader$EntranceInfo != null && qZIntimateSpaceRedDotReader$EntranceInfo.lst_publish_time.get() != Long.MIN_VALUE) {
                String V = QZoneConfigHelper.V();
                QLog.d("intimate_relationship", 1, "[showDisbandDialog] mQZoneIntimateLstPublishTime = " + this.f178875d0.lst_publish_time.get() + ", qzoneIntimateDisbandUrl = " + V + ", spaceId = " + this.f178875d0.space_id.get());
                if (this.f178875d0.lst_publish_time.get() > 0 && !TextUtils.isEmpty(V) && !TextUtils.isEmpty(this.f178875d0.space_id.get())) {
                    ((IQZoneIntimateSpaceApi) QRoute.api(IQZoneIntimateSpaceApi.class)).handleSchemeWithSpaceId(V, this.f178875d0.space_id.get(), this.f178881h, null);
                    return;
                }
                if (this.L == null) {
                    this.L = DialogUtil.createCustomDialog(this.f178881h, 230).setMessage(R.string.byn).setPositiveButton(R.string.bym, new f()).setNegativeButton(R.string.byl, new e());
                }
                this.L.show();
                return;
            }
            QLog.e("MainIntimateTitlePart", 1, "[showDisbandDialog] qzone entrance info is null or error");
            QQToast.makeText(this.f178881h, 1, R.string.f160881w8, 1).show();
            Message obtainMessage = this.f178876e.obtainMessage();
            obtainMessage.what = 9;
            this.f178876e.sendMessage(obtainMessage);
            return;
        }
        QLog.d("MainIntimateTitlePart", 1, "showDisbandDialog, mActivity == null or is finishing!");
    }

    private void La() {
        if (QLog.isColorLevel()) {
            QLog.d("MainIntimateTitlePart", 2, String.format("isIntimate" + this.Q, new Object[0]));
        }
        ReportController.o(null, "dc00898", "", "", "0X800A119", "0X800A119", this.S, 0, "", "", "", "");
        this.J = ActionSheet.createMenuSheet(this.f178881h);
        IntimateInfo intimateInfo = this.P;
        final String f16 = FriendIntimateRelationshipHelper.f(intimateInfo.maskType, intimateInfo.maskLevel);
        if (!IntimateHeaderCardUtil.O(this.U)) {
            f16 = IntimateHeaderCardUtil.h(this.U);
        }
        if (!TextUtils.isEmpty(f16)) {
            this.J.addButton(R.string.byx, 0, 0);
            sa(1);
        }
        if (this.Q || this.R) {
            this.J.addButton(R.string.f161121wv, 0, 1);
            sa(2);
        }
        this.J.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.activity.aio.intimate.h
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                MainIntimateTitlePart.this.ia(f16, view, i3);
            }
        });
        this.J.addCancelButton(R.string.cancel);
        this.J.setOnBottomCancelListener(this.f178885j0);
        sa(5);
        this.J.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ma() {
        IntimateInfoShareHelper intimateInfoShareHelper = this.K;
        if (intimateInfoShareHelper == null) {
            return;
        }
        if (this.X) {
            this.X = false;
            intimateInfoShareHelper.T();
        }
        this.K.S(this.U, this.V, this.W);
        this.K.X();
    }

    private void Na(String str) {
        Context context = this.f178881h;
        if (!(context instanceof BaseActivity)) {
            return;
        }
        BaseActivity baseActivity = (BaseActivity) context;
        if (this.M == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this.f178881h, baseActivity.getTitleBarHeight());
            this.M = qQProgressDialog;
            qQProgressDialog.setBackAndSearchFilter(true);
        }
        this.M.setMessage(str);
        QQProgressDialog qQProgressDialog2 = this.M;
        if (qQProgressDialog2 != null && !qQProgressDialog2.isShowing() && !baseActivity.isFinishing()) {
            this.M.show();
        }
    }

    private void Oa() {
        if (QLog.isColorLevel()) {
            QLog.d("MainIntimateTitlePart", 2, String.format("isIntimate" + this.Q, new Object[0]));
        }
        ReportController.o(null, "dc00898", "", "", "0X800A119", "0X800A119", this.S, 0, "", "", "", "");
        this.J = ActionSheet.createMenuSheet(this.f178881h);
        IntimateInfo intimateInfo = this.P;
        final String f16 = FriendIntimateRelationshipHelper.f(intimateInfo.maskType, intimateInfo.maskLevel);
        if (!TextUtils.isEmpty(f16)) {
            this.J.addButton(R.string.byx, 0);
            sa(1);
        }
        if (this.Q) {
            if (this.Z) {
                this.J.addButton(R.string.f161121wv, 0);
            } else {
                this.J.addButton(R.string.byj, 3);
            }
        } else {
            this.J.addButton(R.string.byv, 0);
            sa(3);
        }
        if (this.f178871a0) {
            this.J.addButton(R.string.f160931wc, 0);
            ta();
        }
        this.J.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.activity.aio.intimate.g
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                MainIntimateTitlePart.this.ja(f16, view, i3);
            }
        });
        this.J.addCancelButton(R.string.cancel);
        this.J.setOnBottomCancelListener(this.f178885j0);
        sa(5);
        this.J.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pa(final URLDrawable uRLDrawable) {
        if (!this.X && this.K != null) {
            Ma();
        } else {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.intimate.i
                @Override // java.lang.Runnable
                public final void run() {
                    MainIntimateTitlePart.this.la(uRLDrawable);
                }
            });
        }
    }

    private void Qa(ImageView imageView, List<f61.d> list) {
        if (list == null || list.isEmpty() || !this.f178880g0) {
            return;
        }
        wa(list.get(0));
        if (list.size() == 1) {
            QLog.i("MainIntimateTitlePart", 1, "[startRelateIconAnimation]: iconSize <= 1");
            return;
        }
        QLog.i("MainIntimateTitlePart", 1, "[startReleateIconAnimation]");
        this.f178880g0 = false;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setStartDelay(300L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.addListener(new a(list));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat2.setDuration(333L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        this.f178879f0 = animatorSet;
        animatorSet.play(ofFloat2).after(ofFloat);
        this.f178879f0.addListener(new b());
        this.f178879f0.start();
    }

    private void Sa() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.I.getLayoutParams();
        int dip2px = ViewUtils.dip2px(8.0f);
        if (this.F.getVisibility() == 0) {
            if (dip2px == layoutParams.rightMargin) {
                return;
            }
            layoutParams.addRule(0, this.F.getId());
            layoutParams.removeRule(11);
            layoutParams.rightMargin = dip2px;
        } else {
            int i3 = dip2px * 2;
            if (i3 == layoutParams.rightMargin) {
                return;
            }
            layoutParams.removeRule(0);
            layoutParams.addRule(11);
            layoutParams.rightMargin = i3;
        }
        this.I.setLayoutParams(layoutParams);
    }

    private void T9() {
        ReportController.o(null, "dc00898", "", "", "0X8009F71", "0X8009F71", 0, 0, "", "", "", "");
        String b16 = FriendIntimateRelationshipHelper.b(this.f178878f);
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, "click menu_bind_intimate url:" + b16);
        }
        if (!TextUtils.isEmpty(b16)) {
            this.f178881h.startActivity(new Intent(this.f178881h, (Class<?>) QQBrowserActivity.class).putExtra("url", b16));
        }
        qa(3);
    }

    private boolean U9() {
        int i3;
        if (!this.Z && n.b() && !this.Q && !this.R && (i3 = this.U) != 71 && i3 != 81 && i3 != 82) {
            IntimateInfo intimateInfo = this.P;
            TextUtils.isEmpty(FriendIntimateRelationshipHelper.f(intimateInfo.maskType, intimateInfo.maskLevel));
        }
        return true;
    }

    private void V9() {
        if (this.f178879f0 != null) {
            QLog.i("MainIntimateTitlePart", 1, "cancelIconAnimator");
            this.f178880g0 = true;
            this.f178879f0.cancel();
            this.f178879f0 = null;
            this.f178882h0 = 0;
            this.H.setAlpha(1.0f);
        }
    }

    private void Va(ImageView imageView, int i3) {
        if (imageView == null) {
            return;
        }
        try {
            imageView.setBackgroundColor(0);
            imageView.setImageResource(i3);
        } catch (Exception unused) {
            QLog.e("MainIntimateTitlePart", 1, "updateZPlanButton error");
        }
    }

    private void W9(boolean z16) {
        if (z16) {
            this.D.setVisibility(0);
            this.D.setBackground(this.f178881h.getResources().getDrawable(R.drawable.qui_bg_nav_secondary));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
            int dpToPx = ViewUtils.dpToPx(24.0f);
            layoutParams.width = dpToPx;
            layoutParams.height = dpToPx;
            this.F.setLayoutParams(layoutParams);
            this.F.setBackground(null);
            this.F.setImageDrawable(this.f178881h.getResources().getDrawable(R.drawable.qui_chat_settings_icon_nav_secondary));
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
            layoutParams2.width = dpToPx;
            layoutParams2.height = dpToPx;
            this.E.setLayoutParams(layoutParams2);
            this.E.setBackground(null);
            this.E.setImageDrawable(this.f178881h.getResources().getDrawable(R.drawable.qui_chevron_left_icon_navigation_02_selector));
            return;
        }
        this.D.setVisibility(8);
        this.D.setBackground(null);
        Drawable drawable = this.f178881h.getResources().getDrawable(R.drawable.f161203k73);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
        int dpToPx2 = ViewUtils.dpToPx(36.0f);
        layoutParams3.width = dpToPx2;
        layoutParams3.height = dpToPx2;
        this.F.setLayoutParams(layoutParams3);
        this.F.setBackground(drawable);
        this.F.setImageDrawable(this.f178881h.getResources().getDrawable(R.drawable.qui_more_icon_white_selector));
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
        layoutParams4.width = dpToPx2;
        layoutParams4.height = dpToPx2;
        this.E.setLayoutParams(layoutParams4);
        this.E.setBackground(drawable);
        this.E.setImageDrawable(this.f178881h.getResources().getDrawable(R.drawable.qui_chevron_left_icon_white_selector));
    }

    private void X9() {
        g gVar = this.f178872b0;
        if (gVar != null) {
            gVar.a();
        }
        this.f178871a0 = false;
        ra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y9(String str, int i3) {
        if (!TextUtils.isEmpty(str)) {
            if (NetworkUtil.isNetworkAvailable(this.f178881h)) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (!(peekAppRuntime instanceof QQAppInterface)) {
                    return;
                }
                if (this.f178874d == null) {
                    this.f178874d = (IntimateInfoHandler) ((QQAppInterface) peekAppRuntime).getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER);
                }
                this.f178874d.F2(str, this.P.maskType);
            } else {
                Message obtainMessage = this.f178876e.obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.obj = this.f178881h.getResources().getString(R.string.hpk);
                this.f178876e.sendMessage(obtainMessage);
                QLog.d("intimate_relationship", 1, String.format("disbandIntimateRelationship network is not available, uin: %s", str));
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, String.format("disbandIntimateRelationship, friendUin: %s, type: %s", str, Integer.valueOf(i3)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z9(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, "disbandLoverRelationship sendRequest");
        }
        cooperation.vip.manager.c cVar = new cooperation.vip.manager.c();
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return;
            }
            cVar.e(Long.parseLong(peekAppRuntime.getCurrentUin()), Long.parseLong(str));
        } catch (Exception unused) {
            Message obtainMessage = this.f178876e.obtainMessage();
            obtainMessage.what = 5;
            this.f178876e.sendMessage(obtainMessage);
        }
    }

    private long aa(long j3) {
        f61.h hVar;
        List<MutualMarkModel> list;
        IntimateInfo intimateInfo = this.P;
        if (intimateInfo != null && (hVar = intimateInfo.mutualMarkList) != null && (list = hVar.f397922c) != null) {
            for (MutualMarkModel mutualMarkModel : list) {
                if (mutualMarkModel.D == j3) {
                    return mutualMarkModel.X;
                }
            }
        }
        return 0L;
    }

    private HashMap<String, Object> ca(int i3) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("button_click_item", Integer.valueOf(i3));
        return hashMap;
    }

    private void da(int i3, String str) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3 || i3 == 4) {
                        T9();
                        return;
                    }
                    return;
                }
                ga(71L, aa(71L));
                return;
            }
            ha();
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            Ja(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea() {
        QQProgressDialog qQProgressDialog = this.M;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            try {
                this.M.dismiss();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private void ga(long j3, long j16) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("MainIntimateTitlePart", 1, "jumpBindPage fail, app is null");
        } else {
            if (this.f178881h == null) {
                QLog.e("MainIntimateTitlePart", 1, "jumpBindPage fail, context is null");
                return;
            }
            com.tencent.mobileqq.activity.aio.intimate.e.a(this.f178881h, this.f178878f, j3, this.f178873c0, peekAppRuntime.getCurrentUin());
            qa(4);
        }
    }

    private void ha() {
        if (this.f178881h == null) {
            QLog.e("MainIntimateTitlePart", 1, "jumpManagePage fail, context is null");
            return;
        }
        String o16 = FriendIntimateRelationshipHelper.o();
        if (QLog.isColorLevel()) {
            QLog.d("MainIntimateTitlePart", 2, "jumpManagePage url:" + o16);
        }
        if (!TextUtils.isEmpty(o16)) {
            this.f178881h.startActivity(new Intent(this.f178881h, (Class<?>) QQBrowserActivity.class).putExtra("url", o16));
        }
        qa(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ia(String str, View view, int i3) {
        ActionSheet actionSheet = this.J;
        if (actionSheet != null) {
            actionSheet.dismiss();
        }
        da(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ja(String str, View view, int i3) {
        ActionSheet actionSheet = this.J;
        if (actionSheet == null) {
            return;
        }
        actionSheet.dismiss();
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    X9();
                    return;
                }
                return;
            } else if (TextUtils.isEmpty(str)) {
                if (this.f178871a0) {
                    X9();
                    return;
                }
                return;
            } else {
                if (!TextUtils.isEmpty(str)) {
                    if (this.Q) {
                        if (this.Z) {
                            ha();
                            return;
                        } else {
                            Ka();
                            return;
                        }
                    }
                    T9();
                    return;
                }
                return;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            Ja(str);
            return;
        }
        if (this.Q) {
            if (this.Z) {
                ha();
                return;
            } else {
                Ka();
                return;
            }
        }
        T9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void la(URLDrawable uRLDrawable) {
        Bitmap createBitmap = Bitmap.createBitmap(750, 1272, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        uRLDrawable.setBounds(0, 0, 750, 1272);
        uRLDrawable.draw(canvas);
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100215", false);
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, "IntimateInfoView isOptSwitch = " + isSwitchOn);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            return;
        }
        Context context = this.f178881h;
        if (!(context instanceof BaseActivity)) {
            return;
        }
        this.K = new IntimateInfoShareHelper((BaseActivity) context, (QQAppInterface) peekAppRuntime, this.P, this.f178878f, createBitmap);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.intimate.MainIntimateTitlePart.6
            @Override // java.lang.Runnable
            public void run() {
                MainIntimateTitlePart.this.Ma();
            }
        });
    }

    private boolean ma(IntimateInfo intimateInfo) {
        boolean d16 = com.tencent.mobileqq.activity.aio.intimate.e.d(intimateInfo);
        if (!n.c() && ((IntimateHeaderCardUtil.u() && d16) || (IntimateHeaderCardUtil.v() && !d16))) {
            return true;
        }
        return false;
    }

    private void pa() {
        if (this.f178879f0 != null) {
            QLog.i("MainIntimateTitlePart", 1, "pauseIconAnimator");
            this.f178879f0.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa(int i3) {
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_clck", "pg_aio_swipleft", "em_bas_more_btn", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgSwipLeftData(), ca(i3));
    }

    private void ra() {
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_clck", "pg_aio_swipleft", "em_zplan_friend_time_close_btn", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgSwipLeftData(), new HashMap<>());
    }

    private void sa(int i3) {
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_clck", "pg_aio_swipleft", "em_bas_more_btn", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgSwipLeftData(), ca(i3));
    }

    private void ta() {
        ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_imp", "pg_aio_swipleft", "em_zplan_friend_time_close_btn", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgSwipLeftData(), new HashMap<>());
    }

    private void ua() {
        if (this.f178879f0 != null) {
            QLog.i("MainIntimateTitlePart", 1, "resumeIconAnimator");
            this.f178879f0.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa(f61.d dVar) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        int dip2px = ViewUtils.dip2px(24.0f);
        obtain.mRequestHeight = dip2px;
        obtain.mRequestWidth = dip2px;
        this.H.setImageDrawable(URLDrawable.getDrawable(dVar.getIcon(), obtain));
        String desc = dVar.getDesc();
        this.f178877e0 = dVar;
        Ga(desc);
    }

    public void Aa(IntimateInfo intimateInfo) {
        this.P = intimateInfo;
    }

    public void Ba(boolean z16, g gVar) {
        this.f178871a0 = z16;
        this.f178872b0 = gVar;
    }

    public void Ca(boolean z16) {
        this.Q = z16;
    }

    public void Da(boolean z16) {
        this.R = z16;
    }

    public void Ea(boolean z16) {
        this.Z = z16;
        if (z16) {
            Va(this.E, R.drawable.qui_chevron_left_icon_primary_selector);
            Va(this.F, R.drawable.qui_more_icon_primary);
            this.I.setVisibility(8);
        }
    }

    public void Fa(boolean z16) {
        int i3;
        ImageView imageView = this.F;
        if (imageView != null) {
            if (z16 && U9()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
            Sa();
        }
    }

    public void Ha(int i3) {
        this.S = i3;
    }

    public void Ia(Handler handler) {
        this.f178876e = handler;
    }

    public void Ja(String str) {
        ReportController.o(null, "dc00898", "", "", "0X800A11A", "0X800A11A", this.S, 0, "", "", "", "");
        if (this.Y == null || this.X) {
            Na(this.f178881h.getResources().getString(R.string.c7z));
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = 750;
            obtain.mRequestHeight = 1272;
            this.Y = URLDrawable.getDrawable(str, obtain);
        }
        if (this.Y.getStatus() != 1 && this.Y.getStatus() != 4) {
            this.Y.setURLDrawableListener(new d());
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.intimate.MainIntimateTitlePart.5
                @Override // java.lang.Runnable
                public void run() {
                    if (MainIntimateTitlePart.this.Y.getStatus() == 0) {
                        MainIntimateTitlePart.this.Y.downloadImediatly();
                    } else {
                        MainIntimateTitlePart.this.Y.restartDownload();
                    }
                }
            });
        } else {
            ea();
            Pa(this.Y);
        }
        qa(1);
    }

    public void Ra(int i3, int i16, long j3) {
        this.U = i3;
        this.V = i16;
        this.W = j3;
        boolean z16 = true;
        this.X = true;
        if (!this.R) {
            if ((j3 & 64) == 0) {
                z16 = false;
            }
            this.R = z16;
        }
    }

    public void Ta(QZIntimateSpaceRedDotReader$EntranceInfo qZIntimateSpaceRedDotReader$EntranceInfo) {
        this.f178875d0 = qZIntimateSpaceRedDotReader$EntranceInfo;
    }

    public void Ua(IntimateInfo intimateInfo, boolean z16) {
        f61.h hVar;
        boolean z17;
        if (intimateInfo != null) {
            this.f178884i0 = ma(intimateInfo);
        }
        if (this.Z) {
            W9(false);
            this.I.setVisibility(8);
            V9();
            return;
        }
        W9(this.f178884i0);
        if (this.f178884i0) {
            this.I.setVisibility(8);
            V9();
            return;
        }
        if (!z16) {
            boolean a16 = com.tencent.mobileqq.activity.aio.intimate.b.f178912a.a();
            QLog.i("MainIntimateTitlePart", 1, "[updateRelateEntryUI]: canShowGuide= " + a16 + " mCurGuideInfo " + this.f178877e0);
            if (this.f178877e0 != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (a16 == z17) {
                QLog.d("MainIntimateTitlePart", 1, "[updateRelateEntryUI] no need to update ui.");
                return;
            }
        }
        if (intimateInfo != null && (hVar = intimateInfo.mutualMarkList) != null && !hVar.f397926g.isEmpty()) {
            com.tencent.mobileqq.activity.aio.intimate.b.f178912a.e();
            Qa(this.H, intimateInfo.mutualMarkList.f397926g);
        } else {
            V9();
            Drawable o16 = ie0.a.f().o(this.I.getContext(), R.drawable.qui_intimate, R.color.qui_common_icon_white, 1000);
            this.f178877e0 = null;
            this.H.setImageDrawable(o16);
            Ga(null);
        }
        this.I.setVisibility(0);
        Sa();
    }

    public ImageView ba() {
        return this.F;
    }

    public void na() {
        Context context = this.f178881h;
        if (context != null && (context instanceof Activity)) {
            ((Activity) context).onBackPressed();
        }
    }

    public void oa() {
        QLog.i("MainIntimateTitlePart", 1, "[onDrawerClosed]");
        V9();
        Ua(null, true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!u.a().b()) {
            int id5 = view.getId();
            if (id5 == R.id.a47) {
                na();
            } else if (id5 == R.id.eps) {
                if (!this.Z && n.b()) {
                    La();
                } else {
                    Oa();
                }
            } else if (id5 == R.id.f72653rf) {
                f61.d dVar = this.f178877e0;
                if (dVar != null) {
                    ga(dVar.getId(), aa(this.f178877e0.getId()));
                    com.tencent.mobileqq.activity.aio.intimate.b.f178912a.b();
                    Ua(null, true);
                } else {
                    T9();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void onDestroy() {
        IntimateInfoShareHelper intimateInfoShareHelper = this.K;
        if (intimateInfoShareHelper != null) {
            intimateInfoShareHelper.L();
        }
        this.J = null;
        this.f178872b0 = null;
        V9();
    }

    public void onPause() {
        QLog.i("MainIntimateTitlePart", 1, "[onPause]");
        pa();
    }

    public void onResume() {
        QLog.i("MainIntimateTitlePart", 1, "[onResume]");
        ua();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3) {
                view.setAlpha(1.0f);
                return false;
            }
            return false;
        }
        view.setAlpha(0.5f);
        return false;
    }

    public void va(boolean z16) {
        float f16;
        if (this.D.getVisibility() != 0) {
            return;
        }
        View view = this.D;
        if (z16) {
            f16 = 0.0f;
        } else {
            f16 = 1.0f;
        }
        view.setAlpha(f16);
    }

    public void xa(int i3) {
        this.T = i3;
    }

    public void za(String str) {
        TextView textView;
        this.f178878f = str;
        if (((IZPlanCoupleSceneHelper) QRoute.api(IZPlanCoupleSceneHelper.class)).getCoupleAvatarSwitchState(this.f178878f) && (textView = this.N) != null) {
            textView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements Animator.AnimatorListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f178887d;

        a(List list) {
            this.f178887d = list;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!MainIntimateTitlePart.this.f178880g0) {
                MainIntimateTitlePart.this.f178882h0++;
                MainIntimateTitlePart.this.wa((f61.d) this.f178887d.get(MainIntimateTitlePart.this.f178882h0 % this.f178887d.size()));
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (MainIntimateTitlePart.this.f178879f0 != null && !MainIntimateTitlePart.this.f178880g0) {
                MainIntimateTitlePart.this.f178879f0.start();
            } else {
                QLog.i("MainIntimateTitlePart", 1, "[iconAnimation]: end");
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class d implements URLDrawable.URLDrawableListener {
        d() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            MainIntimateTitlePart.this.ea();
            QQToast.makeText(MainIntimateTitlePart.this.f178881h, 0, R.string.bz_, 1).show();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            MainIntimateTitlePart.this.ea();
            QQToast.makeText(MainIntimateTitlePart.this.f178881h, 0, R.string.bz_, 1).show();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            MainIntimateTitlePart.this.ea();
            MainIntimateTitlePart mainIntimateTitlePart = MainIntimateTitlePart.this;
            mainIntimateTitlePart.Pa(mainIntimateTitlePart.Y);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}

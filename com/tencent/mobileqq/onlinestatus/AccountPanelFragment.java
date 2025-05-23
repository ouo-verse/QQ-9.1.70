package com.tencent.mobileqq.onlinestatus;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanel;
import com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.aw;
import com.tencent.mobileqq.onlinestatus.diy.DIYStatusDialogFragment;
import com.tencent.mobileqq.onlinestatus.model.CustomShareInfo;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.mobileqq.onlinestatus.music.SyncMusicInfoHandler;
import com.tencent.mobileqq.onlinestatus.tencentvideo.TencentVideoNameHandler;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment;
import com.tencent.mobileqq.onlinestatus.view.SyncStatusExtInfoPopWindow;
import com.tencent.mobileqq.onlinestatus.view.s;
import com.tencent.mobileqq.onlinestatus.view.v;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import com.tencent.mobileqq.onlinestatus.y;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager;
import com.tencent.mobileqq.vashealth.api.IQQHealthStatusApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.onlinestatus.OnlineStatusExtInfo$SynchVideoBizInfo;

/* loaded from: classes16.dex */
public class AccountPanelFragment extends BaseStatusCardViewFragment implements aw.a, v.a, OnlineStatusPanel.a, y, SyncStatusExtInfoPopWindow.c, s.k {
    private QBaseActivity Q;
    private ba R;
    private bt S;
    private com.tencent.mobileqq.onlinestatus.view.ax T;
    private QQCustomDialog U;
    protected DIYStatusDialogFragment V;
    protected SyncStatusExtInfoPopWindow W;
    private OnlineStatusResDownLoader X;
    private AccountPanelViewModel Y;
    private com.tencent.mobileqq.onlinestatus.binder.j Z;

    /* renamed from: a0, reason: collision with root package name */
    private com.tencent.mobileqq.onlinestatus.view.s f255252a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f255253b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f255254c0;

    /* renamed from: d0, reason: collision with root package name */
    private y.a f255255d0;

    /* renamed from: e0, reason: collision with root package name */
    private List<y.a> f255256e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f255257f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f255258g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f255259h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f255260i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f255261j0;

    /* renamed from: k0, reason: collision with root package name */
    private long f255262k0;

    /* renamed from: l0, reason: collision with root package name */
    private com.tencent.mobileqq.mvvm.d f255263l0;

    /* renamed from: m0, reason: collision with root package name */
    private final BaseStatusCardViewFragment.a f255264m0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime.Status f255267d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f255268e;

        b(AppRuntime.Status status, long j3) {
            this.f255267d = status;
            this.f255268e = j3;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Intent intent = new Intent();
            intent.putExtra("KEY_ONLINE_STATUS", this.f255267d);
            intent.putExtra("KEY_ONLINE_EXT_STATUS", this.f255268e);
            QPublicFragmentActivity.startForResult(AccountPanelFragment.this.Q, intent, (Class<? extends QPublicBaseFragment>) AccountOnlineStateActivity.class, 234);
            if (AccountPanelFragment.this.U != null && AccountPanelFragment.this.U.isShowing()) {
                AccountPanelFragment.this.U.dismiss();
                AccountPanelFragment.this.U = null;
            }
            ReportController.o(null, "dc00898", "", "", "0X8009DE2", "0X8009DE2", 0, 0, "", "", "", "");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(Color.parseColor("#40A0FF"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class c extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ClickableSpan f255270a;

        c(ClickableSpan clickableSpan) {
            this.f255270a = clickableSpan;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i3) {
            ClickableSpan clickableSpan;
            super.sendAccessibilityEvent(view, i3);
            if (i3 == 1 && (clickableSpan = this.f255270a) != null) {
                clickableSpan.onClick(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime.Status f255272d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f255273e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f255274f;

        d(AppRuntime.Status status, long j3, String str) {
            this.f255272d = status;
            this.f255273e = j3;
            this.f255274f = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (AccountPanelFragment.this.Y == null) {
                return;
            }
            if (!NetworkUtil.isNetworkAvailable(AccountPanelFragment.this.Q)) {
                AccountPanelFragment.this.Y.A2().setValue(Boolean.TRUE);
                QQToast.makeText(AccountPanelFragment.this.Q, 1, R.string.hpk, 1).show();
            } else {
                AccountPanelFragment.this.Y.k3(this.f255272d, this.f255273e, true);
                AccountPanelFragment.ai(AccountPanelFragment.this);
                ReportController.o(null, "dc00898", "", "", "0X8009DE1", "0X8009DE1", 0, 0, "", "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            try {
                if (AccountPanelFragment.this.U != null && AccountPanelFragment.this.U.isShowing()) {
                    AccountPanelFragment.this.Y.A2().setValue(Boolean.TRUE);
                    AccountPanelFragment.this.U.dismiss();
                    AccountPanelFragment.this.U = null;
                }
            } catch (Exception e16) {
                QLog.e("AccountPanelFragment", 1, "mOnlineStatusDialog.onClick: " + e16);
            }
            if (QLog.isColorLevel()) {
                QLog.d("AccountPanelFragment", 2, "switch status cancel");
            }
        }
    }

    /* loaded from: classes16.dex */
    class f implements BaseStatusCardViewFragment.a {
        f() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment.a
        public void G0(AppRuntime.Status status, long j3) {
            AccountPanelFragment.this.G0(status, j3);
        }

        @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment.a
        public void L0(AppRuntime.Status status, int i3) {
            AccountPanelFragment.this.L0(status, i3);
        }
    }

    public AccountPanelFragment() {
        super(QBaseActivity.sTopActivity, null);
        this.R = new ba();
        this.T = new com.tencent.mobileqq.onlinestatus.view.ax();
        this.f255257f0 = false;
        this.f255258g0 = false;
        this.f255259h0 = -1;
        this.f255260i0 = -1;
        this.f255261j0 = false;
        this.f255262k0 = 0L;
        this.f255264m0 = new f();
        this.f255257f0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ai(boolean z16) {
        if (!z16) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.p
            @Override // java.lang.Runnable
            public final void run() {
                AccountPanelFragment.this.zi();
            }
        }, 32, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Bi(boolean z16) {
        com.tencent.mobileqq.onlinestatus.view.s sVar;
        if (z16 && (sVar = this.f255252a0) != null && this.Y != null) {
            sVar.l0();
            this.Y.A2().setValue(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ci(int i3) {
        if (this.f255252a0 != null && this.Q != null && this.Y != null) {
            QLog.d("AccountPanelFragment", 1, "onZplanPanelCallback scene=" + i3);
            if (i3 == 1) {
                this.f255252a0.y1(this.Q.getResources().getString(R.string.f172412qd));
            } else if (i3 == 2) {
                bs.A0(1, new ec2.a() { // from class: com.tencent.mobileqq.onlinestatus.c
                    @Override // ec2.a
                    public final void a(boolean z16) {
                        AccountPanelFragment.this.Bi(z16);
                    }
                });
                ReportController.o(null, "dc00898", "", "", "0X800C426", "0X800C426", 0, 0, "", "", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Di(AppRuntime.Status status, long j3, boolean z16) {
        if (this.f255252a0 != null && this.Y != null) {
            boolean o16 = be.o();
            boolean ri5 = ri(status, j3);
            boolean z17 = !z16;
            boolean isDeviceSupportFilament = ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).isDeviceSupportFilament();
            if (o16 && ri5 && z17 && bs.T() && isDeviceSupportFilament) {
                Wi();
                bs.B0();
            } else {
                this.f255252a0.A1();
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        AccountPanelFragment.this.Ui();
                    }
                }, 200L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fi(String str, int i3, boolean z16, int i16, int i17, final CustomShareInfo customShareInfo, final int i18, String str2, String str3) {
        AppInterface appInterface = getAppInterface();
        if (appInterface != null && str2 != null && str3 != null) {
            final an anVar = new an();
            anVar.f255412c = str2;
            anVar.f255414e = str3;
            anVar.f255411b = str;
            anVar.f255413d = i3;
            anVar.f255410a = false;
            anVar.f255417h = z16;
            anVar.f255415f = i16;
            anVar.f255418i = i17;
            appInterface.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.g
                @Override // java.lang.Runnable
                public final void run() {
                    AccountPanelFragment.this.Ei(anVar, customShareInfo, i18);
                }
            });
            return;
        }
        z3();
        QBaseActivity qBaseActivity = this.Q;
        if (qBaseActivity != null) {
            QQToast.makeText(qBaseActivity.getApplicationContext(), 1, R.string.f227976sh, 0).show();
        }
        QLog.e("AccountPanelFragment", 1, "appInterfaceCallBack: " + appInterface + " songName: " + str2 + " singerName: " + str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hi(final String str, final String str2, final int i3, final JSONObject jSONObject, final String str3) {
        QLog.d("AccountPanelFragment", 1, "showTencentVideoStatusPopWindow, videoName: " + str3);
        AppInterface appInterface = getAppInterface();
        if (appInterface != null && str3 != null) {
            appInterface.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.f
                @Override // java.lang.Runnable
                public final void run() {
                    AccountPanelFragment.this.Gi(str3, str, str2, i3, jSONObject);
                }
            });
        }
    }

    private void Pi() {
        if (this.Y != null && this.Q != null) {
            if (com.tencent.mobileqq.onlinestatus.utils.ab.f256333a.c("exp_qq_base_online_status_fold_v1")) {
                com.tencent.mobileqq.config.business.ak.f202506a.a().v();
            }
            this.Y.l3();
            View view = this.C;
            if (view != null) {
                view.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        AccountPanelFragment.this.vi();
                    }
                });
            } else {
                Qi(this.Q.getResources().getDisplayMetrics().widthPixels, this.Q.getResources().getDisplayMetrics().heightPixels);
            }
        }
    }

    private void Qi(int i3, int i16) {
        int i17;
        boolean z16;
        int i18 = this.Q.getResources().getConfiguration().orientation;
        this.R.f255578q = true;
        int i19 = 0;
        int i26 = 4;
        int i27 = 3;
        if (OnlineStatusToggleUtils.d()) {
            if (i16 >= ViewUtils.dpToPx(720.0f)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i17 = 4;
            } else {
                i17 = 3;
            }
            ba baVar = this.R;
            baVar.f255568g = 12;
            baVar.f255570i = 16;
            baVar.f255566e = 16;
            baVar.f255567f = 16;
            baVar.f255574m = 16;
        } else {
            i17 = 3;
        }
        if (i18 != 2 && PadUtil.a(this.Q) == DeviceType.TABLET && AppSetting.t(this.Q)) {
            int min = Math.min(com.tencent.mobileqq.onlinestatus.utils.x.INSTANCE.a(this.R, i3, ViewUtils.dpToPx(72.0f)), 9);
            if (min >= 4) {
                i26 = min;
            }
        } else {
            i27 = i17;
        }
        this.R.f255577p = false;
        if (this.f255259h0 != i16 || this.f255260i0 != i3) {
            this.f255260i0 = i3;
            this.f255259h0 = i16;
            this.f255252a0.i0(i3, i16);
        }
        AppInterface appInterface = getAppInterface();
        if (this.S == null) {
            ba baVar2 = this.R;
            baVar2.f255562a = 1;
            baVar2.f255571j = i3;
            baVar2.f255565d = i26;
            baVar2.f255564c = i27;
            if (OnlineStatusToggleUtils.d()) {
                i19 = 16;
            }
            baVar2.f255574m = i19;
            bt btVar = new bt(this.Q, this.f255252a0.r0(), this, this.R, this);
            this.S = btVar;
            btVar.b();
        } else if (appInterface != null) {
            this.S.m(true, ((IOnlineStatusService) appInterface.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus(), af.C().M(appInterface));
            ba baVar3 = this.R;
            if (baVar3.f255565d == i26 && baVar3.f255564c == i27) {
                if (baVar3.f255571j != i3) {
                    baVar3.f255571j = i3;
                    this.S.a(false);
                }
            } else {
                baVar3.f255571j = i3;
                baVar3.f255565d = i26;
                baVar3.f255564c = i27;
                this.S.a(true);
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.o
            @Override // java.lang.Runnable
            public final void run() {
                AccountPanelFragment.this.wi();
            }
        });
    }

    private void Ri(boolean z16) {
        String str;
        QLog.d("AccountPanelFragment", 2, "onAccountChanged AccountPanel-accountChangeSuccess " + z16);
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.r(null, "dc00898", "", "", "0X800BDEE", "0X800BDEE", 0, 0, str, "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ui() {
        com.tencent.mobileqq.onlinestatus.view.s sVar;
        QBaseActivity qBaseActivity;
        QLog.d("AccountPanelFragment", 1, "showGotoShareTips");
        if (be.k() && bs.U() && (sVar = this.f255252a0) != null && (qBaseActivity = this.Q) != null) {
            sVar.y1(qBaseActivity.getResources().getString(R.string.f172362q9));
            bs.y0();
        }
    }

    private void Vi() {
        AppInterface appInterface = getAppInterface();
        if (appInterface != null && be.o() && ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).isSupportAvatarView(bs.q(appInterface, appInterface.getCurrentAccountUin()).f256383a) && be.f() && be.p() && bs.T() && ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).isDeviceSupportFilament()) {
            bs.o(new u() { // from class: com.tencent.mobileqq.onlinestatus.m
                @Override // com.tencent.mobileqq.onlinestatus.u
                public final void a(boolean z16) {
                    AccountPanelFragment.this.Ai(z16);
                }
            });
        }
    }

    private void Wi() {
        AppInterface appInterface = getAppInterface();
        if (this.Q != null && appInterface != null) {
            QLog.d("AccountPanelFragment", 1, "showAvatarGuidePanel");
            ReportController.o(null, "dc00898", "", "", "0X800C425", "0X800C425", 0, 0, "", "", "", "");
            Intent intent = new Intent();
            intent.putExtra("type", 1);
            ZplanOnlineStatusFragment.zh(this.Q, intent);
            ((IOnlineStatusService) appInterface.getRuntimeService(IOnlineStatusService.class, "")).setOnlineStatusZplanPanelListener(new IOnlineStatusService.OnlineStatusZplanPanelListener() { // from class: com.tencent.mobileqq.onlinestatus.b
                @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService.OnlineStatusZplanPanelListener
                public final void onZplanPanelCallback(int i3) {
                    AccountPanelFragment.this.Ci(i3);
                }
            });
        }
    }

    private void Xi(final AppRuntime.Status status, final long j3) {
        bs.o(new u() { // from class: com.tencent.mobileqq.onlinestatus.j
            @Override // com.tencent.mobileqq.onlinestatus.u
            public final void a(boolean z16) {
                AccountPanelFragment.this.Di(status, j3, z16);
            }
        });
    }

    private void Yi(View view, long j3) {
        this.T.f(view, this.Q, fi(), this.f255252a0.o0(), this, this.f255264m0, j3, R.id.zxc);
    }

    private void Zi(AppRuntime.Status status, long j3) {
        int i3;
        int i16;
        int i17;
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            return;
        }
        QQCustomDialog qQCustomDialog = this.U;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.U.dismiss();
            this.U = null;
        }
        String P = af.C().P(j3, status);
        String string = this.Q.getResources().getString(R.string.f68, P);
        AutoReplyManagerImpl autoReplyManagerImpl = (AutoReplyManagerImpl) ((IOnlineStatusManagerService) appInterface.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.b.class);
        AutoReplyText autoReplyText = new AutoReplyText();
        if (autoReplyManagerImpl != null) {
            autoReplyText = autoReplyManagerImpl.a();
        }
        String str = autoReplyText.mRawText;
        Paint paint = new Paint();
        paint.setTextSize(ViewUtils.spToPx(14.0f));
        if (j3 != 1000 && j3 != 1028) {
            if (status == AppRuntime.Status.dnd) {
                i16 = R.string.f171476f64;
                i17 = 4;
            } else {
                i16 = R.string.f67;
                i17 = 3;
            }
            String trimRawString = AutoReplyText.trimRawString(this.Q.getResources().getString(i16, TextUtils.subQQTextString(str, paint, 3, 16, (int) (ViewUtils.dpToPx(i17 * 242) - paint.measureText(this.Q.getResources().getString(i16))), true)), true);
            SpannableString spannableString = new SpannableString(trimRawString);
            b bVar = new b(status, j3);
            spannableString.setSpan(bVar, trimRawString.length() - 7, trimRawString.length(), 33);
            QQCustomDialog messageMaxLine = DialogUtil.createCustomDialog(this.Q, 230).setTitle(string).setMessageWithoutAutoLink(new QQText(spannableString, 3, 16)).setMessageMaxLine(i17);
            this.U = messageMaxLine;
            if (AppSetting.f99565y) {
                messageMaxLine.getMessageTextView().setAccessibilityDelegate(new c(bVar));
            }
        } else {
            if (j3 == 1000) {
                i3 = R.string.vvb;
            } else {
                i3 = R.string.f197184jb;
            }
            this.U = DialogUtil.createCustomDialog(this.Q, 230).setTitle(string).setMessageWithoutAutoLink(new QQText(this.Q.getResources().getString(i3), 3, 16)).setMessageMaxLine(4);
        }
        if (!this.Q.isFinishing()) {
            this.U.show();
        }
        this.U.setPositiveButton(R.string.f66, new d(status, j3, P));
        this.U.setNegativeButton(R.string.f171475f62, new e());
        this.U.setCancelable(false);
        this.U.show();
    }

    static /* bridge */ /* synthetic */ y.c ai(AccountPanelFragment accountPanelFragment) {
        accountPanelFragment.getClass();
        return null;
    }

    private void aj() {
        if (this.X == null) {
            this.X = new OnlineStatusResDownLoader();
        }
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            return;
        }
        this.X.b(appInterface);
    }

    private OnLineStatusBlurBg.a fi() {
        long j3;
        AccountPanelViewModel accountPanelViewModel = this.Y;
        AppRuntime.Status status = null;
        if (accountPanelViewModel == null) {
            return null;
        }
        com.tencent.mobileqq.onlinestatus.model.g value = accountPanelViewModel.l2().getValue();
        if (value != null) {
            status = value.f256022a;
            j3 = value.f256023b;
        } else {
            j3 = 0;
        }
        if (status == null) {
            status = AppRuntime.Status.online;
        }
        OnLineStatusBlurBg.a aVar = new OnLineStatusBlurBg.a();
        aVar.f255313b = this.Q;
        aVar.f255318g = R.id.zxc;
        aVar.f255319h = R.id.f908153h;
        aVar.f255317f = status + "_" + j3;
        aVar.f255320i = false;
        return aVar;
    }

    @Nullable
    private AppInterface getAppInterface() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            return null;
        }
        return (AppInterface) peekAppRuntime;
    }

    private void gi() {
        List<y.a> list = this.f255256e0;
        if (list != null && !list.isEmpty()) {
            Iterator<y.a> it = this.f255256e0.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    private void hi() {
        com.tencent.mobileqq.onlinestatus.model.g value;
        if (!OnlineStatusToggleUtils.A() || (value = this.Y.l2().getValue()) == null || value.f256022a != AppRuntime.Status.online || value.f256023b != 2017 || ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepPermission()) {
            return;
        }
        ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).requestStepPermission(new a(), null);
    }

    private void ii() {
        OnlineStatusResDownLoader onlineStatusResDownLoader = this.X;
        if (onlineStatusResDownLoader != null) {
            onlineStatusResDownLoader.e();
            this.X = null;
        }
    }

    private void ji() {
        SyncStatusExtInfoPopWindow syncStatusExtInfoPopWindow = this.W;
        if (syncStatusExtInfoPopWindow != null && syncStatusExtInfoPopWindow.getDialog() != null) {
            this.W.getDialog().dismiss();
        }
        this.W = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ki, reason: merged with bridge method [inline-methods] */
    public void Ei(an anVar, CustomShareInfo customShareInfo, int i3) {
        AppInterface appInterface = getAppInterface();
        if (this.Q != null && appInterface != null) {
            ji();
            SyncStatusExtInfoPopWindow syncStatusExtInfoPopWindow = new SyncStatusExtInfoPopWindow(anVar, customShareInfo, appInterface, this, this);
            this.W = syncStatusExtInfoPopWindow;
            syncStatusExtInfoPopWindow.Th(i3);
            this.W.Sh(new h(this));
            FragmentManager supportFragmentManager = this.Q.getSupportFragmentManager();
            if (!this.Q.isDestroyed() && !this.Q.isFinishing() && !supportFragmentManager.isStateSaved()) {
                this.W.show(supportFragmentManager, "mSyncStatusExtInfoPopWindow");
            }
        }
    }

    private void mi(AppRuntime.Status status, long j3) {
        Intent intent = new Intent();
        intent.putExtra("KEY_ONLINE_STATUS", status);
        intent.putExtra("KEY_ONLINE_EXT_STATUS", j3);
        QPublicFragmentActivity.startForResult(this.Q, intent, (Class<? extends QPublicBaseFragment>) AccountOnlineStateActivity.class, 234);
    }

    private boolean ni(com.tencent.mobileqq.onlinestatus.model.g gVar) {
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            return false;
        }
        au I = af.C().I(gVar.f256022a, gVar.f256023b);
        com.tencent.mobileqq.onlinestatus.manager.d dVar = (com.tencent.mobileqq.onlinestatus.manager.d) ((IOnlineStatusManagerService) appInterface.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.d.class);
        if (dVar == null) {
            return false;
        }
        return dVar.w(I, this.Q);
    }

    private View oi() {
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            return null;
        }
        com.tencent.mobileqq.mvvm.d checkAndAddLifeCycleFragment = ((ILifeCycleFragmentInjectApi) QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment(this.Q);
        this.f255263l0 = checkAndAddLifeCycleFragment;
        this.Y = (AccountPanelViewModel) com.tencent.mobileqq.mvvm.h.b(checkAndAddLifeCycleFragment, new com.tencent.mobileqq.onlinestatus.viewmodel.d(appInterface)).get(AccountPanelViewModel.class);
        this.Z = new com.tencent.mobileqq.onlinestatus.binder.j();
        com.tencent.mobileqq.onlinestatus.view.s sVar = new com.tencent.mobileqq.onlinestatus.view.s(this.Q, this);
        this.f255252a0 = sVar;
        sVar.o1(this);
        com.tencent.mobileqq.onlinestatus.utils.ab abVar = com.tencent.mobileqq.onlinestatus.utils.ab.f256333a;
        boolean c16 = abVar.c("exp_qq_base_online_status_trans_v2");
        this.Y.h3(c16);
        this.f255252a0.p1(c16);
        abVar.a("exp_qq_base_online_status_trans_v2");
        View x06 = this.f255252a0.x0(this.f255253b0);
        this.Z.p(checkAndAddLifeCycleFragment, this.Y, this.f255252a0);
        this.Z.k(checkAndAddLifeCycleFragment, this.Y, this);
        this.Z.i(checkAndAddLifeCycleFragment, this.Y, this.f255252a0);
        this.Z.t(checkAndAddLifeCycleFragment, this.Y, this.f255252a0);
        this.Z.o(checkAndAddLifeCycleFragment, this.Y, this.f255252a0);
        this.Z.m(checkAndAddLifeCycleFragment, this.Y, this.f255252a0);
        this.Z.l(checkAndAddLifeCycleFragment, this.Y, this.f255252a0, this);
        this.Z.u(checkAndAddLifeCycleFragment, this.Y, this.f255252a0, this.Q);
        this.Z.v(checkAndAddLifeCycleFragment, this.Y, this.f255252a0, this);
        this.Z.r(checkAndAddLifeCycleFragment, this.Y, this.f255252a0, this);
        this.Z.q(checkAndAddLifeCycleFragment, this.Y, this);
        this.Z.s(checkAndAddLifeCycleFragment, this.Y, this.Q, this);
        this.Z.j(checkAndAddLifeCycleFragment, this.Y, this.f255252a0);
        this.Z.n(checkAndAddLifeCycleFragment, this.Y, this);
        return x06;
    }

    private boolean pi() {
        Fragment findFragmentByTag;
        QBaseActivity qBaseActivity = this.Q;
        if (qBaseActivity == null || (findFragmentByTag = qBaseActivity.getSupportFragmentManager().findFragmentByTag("OnlineStatusContainerFragment")) == null || findFragmentByTag.isHidden()) {
            return false;
        }
        return true;
    }

    private boolean qi(au auVar, AppRuntime.Status status) {
        com.tencent.mobileqq.onlinestatus.model.g value = this.Y.l2().getValue();
        if (value == null) {
            return false;
        }
        AppRuntime.Status status2 = AppRuntime.Status.online;
        if (status == status2 && value.f256022a == status2) {
            long j3 = value.f256023b;
            long j16 = auVar.f255489b;
            if (j3 != j16 || j16 == 2000 || j16 == 1021) {
                return false;
            }
            return true;
        }
        if (value.f256022a != status) {
            return false;
        }
        return true;
    }

    private boolean ri(AppRuntime.Status status, long j3) {
        return ((IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class)).isSupportAvatarView(bs.r(status, j3).f256383a);
    }

    private void si() {
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            return;
        }
        au J = af.C().J(AppRuntime.Status.online, 1080L, false);
        if (!android.text.TextUtils.isEmpty(J.f255501n)) {
            ((com.tencent.mobileqq.onlinestatus.manager.u) ((IOnlineStatusManagerService) appInterface.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.h.class)).O(this.Q, J.f255501n + "&from=1");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ti(String str) {
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            return;
        }
        Ri(((ISubAccountService) appInterface.getRuntimeService(ISubAccountService.class, "")).isSubAccountUin(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ui(DialogInterface dialogInterface, int i3) {
        AppInterface appInterface = getAppInterface();
        if (this.Y != null && this.Q != null && appInterface != null) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountPanelFragment", 2, "onAccoutChangeFailed -> LoginActivity");
            }
            ReportController.r(null, "dc00898", "", "", "0X800B430", "0X800B430", 0, 0, "", "", "", "");
            Intent intent = new Intent();
            intent.putExtra("is_change_account", true);
            intent.putExtra("uin", this.Y.z2());
            intent.putExtra("befault_uin", appInterface.getCurrentAccountUin());
            intent.putExtra("switch_account_fail", true);
            com.tencent.mobileqq.onlinestatus.utils.ai.a(this.Q, intent, RouterConstants.UI_ROUTER_LOGIN);
            this.Y.g3(null);
            return;
        }
        QLog.d("AccountPanelFragment", 1, "onAccoutChangeFailed params null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void vi() {
        View view = this.C;
        if (view != null && this.Q != null) {
            try {
                int measuredWidth = view.getMeasuredWidth();
                if (measuredWidth <= 0) {
                    measuredWidth = this.Q.getResources().getDisplayMetrics().widthPixels;
                }
                if (OnlineStatusToggleUtils.d()) {
                    measuredWidth -= ViewUtils.dip2px(16.0f) * 2;
                }
                int measuredHeight = this.C.getMeasuredHeight();
                if (measuredHeight <= 0) {
                    measuredHeight = this.Q.getResources().getDisplayMetrics().heightPixels;
                }
                Qi(measuredWidth, measuredHeight);
            } catch (Exception e16) {
                QLog.e("AccountPanelFragment", 1, "prepareContentViews " + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void wi() {
        Object l26;
        AccountPanelViewModel accountPanelViewModel = this.Y;
        if (accountPanelViewModel == null) {
            return;
        }
        if (accountPanelViewModel.l2() != null && this.Y.l2().getValue() != null) {
            AccountPanelViewModel accountPanelViewModel2 = this.Y;
            accountPanelViewModel2.d3(accountPanelViewModel2.l2().getValue().f256023b);
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = "data: ";
        if (this.Y.l2() == null) {
            l26 = "null";
        } else {
            l26 = this.Y.l2();
        }
        objArr[1] = l26;
        QLog.e("AccountPanelFragment", 1, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xi(boolean z16) {
        AccountPanelViewModel accountPanelViewModel = this.Y;
        if (accountPanelViewModel != null && accountPanelViewModel.A2() != null) {
            this.Y.A2().setValue(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void yi(boolean z16) {
        if (this.Q == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("type", 2);
        intent.putExtra("gender", z16);
        ZplanOnlineStatusFragment.zh(this.Q, intent);
        bs.B0();
        ReportController.o(null, "dc00898", "", "", "0X800C424", "0X800C424", 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zi() {
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            return;
        }
        final boolean Y = bs.Y(appInterface);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.q
            @Override // java.lang.Runnable
            public final void run() {
                AccountPanelFragment.this.yi(Y);
            }
        });
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment
    protected void Ah(View view, int[] iArr) {
        if (view.getWidth() != 0 && view.getHeight() != 0) {
            iArr[0] = view.getWidth();
            iArr[1] = view.getHeight();
        } else {
            iArr[0] = view.getResources().getDisplayMetrics().widthPixels;
            iArr[1] = view.getResources().getDisplayMetrics().heightPixels;
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.s.k
    public void C4(int i3, boolean z16) {
        ba baVar = this.R;
        baVar.f255576o = true;
        baVar.f255577p = false;
        bt btVar = this.S;
        if (btVar != null) {
            btVar.j();
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.y
    public void D3(y.d dVar) {
        AccountPanelViewModel accountPanelViewModel = this.Y;
        if (accountPanelViewModel != null) {
            accountPanelViewModel.f3(dVar);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment
    public void Fh() {
        if (OnlineStatusToggleUtils.e()) {
            try {
                FragmentManager supportFragmentManager = this.Q.getSupportFragmentManager();
                Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(yh());
                if (findFragmentByTag != null) {
                    supportFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
                }
                supportFragmentManager.beginTransaction().add(this.P, this, yh()).addToBackStack(yh()).commitAllowingStateLoss();
                return;
            } catch (Exception e16) {
                QLog.e("AccountPanelFragment", 1, "showFragment ", e16);
                return;
            }
        }
        super.Fh();
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.v.a
    public void G0(AppRuntime.Status status, long j3) {
        if (af.j0(status, j3)) {
            this.R.f255575n = true;
        }
    }

    public void Ii() {
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            return;
        }
        this.Y.B2(this.Q, appInterface);
    }

    public void Ji(View view, String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            QLog.e("AccountPanelFragment", 1, "scheme is null");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f255262k0 <= 1000) {
            return;
        }
        this.f255262k0 = currentTimeMillis;
        bs.s0(str, this.Q);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.AccountPanelFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (AccountPanelFragment.this.f255252a0 != null) {
                    AccountPanelFragment.this.f255252a0.a1();
                }
            }
        }, 200L);
    }

    public void Ki() {
        this.Y.L2();
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.v.a
    public void L0(AppRuntime.Status status, int i3) {
        AccountPanelViewModel accountPanelViewModel;
        com.tencent.mobileqq.onlinestatus.model.g value;
        if (this.S == null || (accountPanelViewModel = this.Y) == null || (value = accountPanelViewModel.l2().getValue()) == null) {
            return;
        }
        this.S.h(value.f256022a, value.f256023b);
    }

    public void Li(Activity activity) {
        this.Y.M2(activity);
    }

    @Override // com.tencent.mobileqq.onlinestatus.y
    public boolean Md() {
        if (this.Q == null) {
            return false;
        }
        if (pi()) {
            this.Q.getSupportFragmentManager().popBackStack();
            return true;
        }
        if (!isShowing()) {
            return false;
        }
        com.tencent.mobileqq.onlinestatus.view.s sVar = this.f255252a0;
        if (sVar != null) {
            sVar.h1();
            this.f255252a0.f0();
        }
        this.Q.getSupportFragmentManager().popBackStack();
        return true;
    }

    public void Mi(View view) {
        jc2.b bVar;
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            return;
        }
        int i3 = 1;
        if (!NetworkUtil.isNetworkAvailable(this.Q)) {
            QQToast.makeText(this.Q, 1, R.string.hpk, 1).show();
            return;
        }
        com.tencent.mobileqq.onlinestatus.model.g value = this.Y.l2().getValue();
        if (value == null) {
            QLog.e("AccountPanelFragment", 1, "onMyOnlineStatusClicked curStatus null!");
            return;
        }
        if (this.f255252a0.y0(value.f256023b)) {
            bv.b("0X800B0F2", 1);
            ((ICustomOnlineStatusManager) QRoute.api(ICustomOnlineStatusManager.class)).openH5(this.Q, WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL);
        } else {
            long j3 = value.f256023b;
            if (j3 == 1040) {
                bv.b("0X800B0F2", 3);
                kc2.a.f412010a.a(this.Q, kc2.c.c(appInterface), 4013);
            } else if (j3 == 1030) {
                bv.b("0X800B0F2", 4);
                com.tencent.mobileqq.config.business.af a16 = com.tencent.mobileqq.config.business.ah.f202497a.a();
                com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = bs.H("AccountPanelFragment");
                if (a16 != null && (bVar = a16.f202496d) != null && !android.text.TextUtils.isEmpty(bVar.f409781a) && H != null && bs.d0(H)) {
                    af.n0(this.Q, a16.f202496d.f409781a);
                }
            } else if (OnlineStatusToggleUtils.A() && value.f256023b == 2017) {
                ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).jumpToMainPage();
            } else {
                long j16 = value.f256023b;
                if (j16 == 1021) {
                    com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H2 = bs.H("AccountPanelFragment");
                    if (H2 != null && !android.text.TextUtils.isEmpty(H2.i0()) && !android.text.TextUtils.isEmpty(H2.g0()) && !android.text.TextUtils.isEmpty(H2.h0())) {
                        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startAppByAppid(this.Q, "1109840991", H2.i0(), null, 4013, null);
                    }
                } else if (j16 == 1028) {
                    com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H3 = bs.H("AccountPanelFragment");
                    if (H3 != null && !android.text.TextUtils.isEmpty(H3.V())) {
                        ((com.tencent.mobileqq.onlinestatus.manager.k) ((IOnlineStatusManagerService) appInterface.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.e.class)).I(this.Q, H3.V());
                    }
                } else if (j16 == 1080) {
                    si();
                    bv.b("0X800BD1D", 0);
                } else if (ni(value)) {
                    QLog.d("AccountPanelFragment", 1, "onMyOnlineStatusClicked handle by eventOnlineStatus.");
                } else if (ar.a(value.f256022a)) {
                    AppRuntime.Status status = value.f256022a;
                    if (status != AppRuntime.Status.away) {
                        if (status == AppRuntime.Status.busy) {
                            i3 = 2;
                        } else {
                            i3 = 3;
                        }
                    }
                    bv.b("0X800B6BB", i3);
                    mi(value.f256022a, value.f256023b);
                } else {
                    au J = af.C().J(value.f256022a, value.f256023b, false);
                    if (!android.text.TextUtils.isEmpty(J.f255501n)) {
                        bs.s0(J.f255501n, this.Q);
                    }
                }
            }
        }
        as.g(value.f256022a, ((IOnlineStatusService) appInterface.getRuntimeService(IOnlineStatusService.class, "")).getExtOnlineStatus());
    }

    public void Ni(ISubAccountApi.f fVar) {
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            return;
        }
        this.Y.C2(fVar, appInterface, this.Q);
    }

    @Override // com.tencent.mobileqq.onlinestatus.y
    public void O8(String str, final int i3) {
        if (str == null) {
            z3();
            QLog.e("AccountPanelFragment", 1, "videoJson value is null");
            QQToast.makeText(this.Q.getApplicationContext(), 1, R.string.f238167j1, 0).show();
            return;
        }
        try {
            final JSONObject jSONObject = new JSONObject(str);
            final String optString = jSONObject.optString("cid");
            final String optString2 = jSONObject.optString("url");
            if (optString != null && optString2 != null) {
                AppInterface appInterface = getAppInterface();
                if (appInterface == null) {
                    return;
                }
                TencentVideoNameHandler tencentVideoNameHandler = (TencentVideoNameHandler) appInterface.getBusinessHandler(TencentVideoNameHandler.class.getName());
                tencentVideoNameHandler.E2(new y.f() { // from class: com.tencent.mobileqq.onlinestatus.d
                    @Override // com.tencent.mobileqq.onlinestatus.y.f
                    public final void a(String str2) {
                        AccountPanelFragment.this.Hi(optString, optString2, i3, jSONObject, str2);
                    }
                });
                tencentVideoNameHandler.D2(2, optString, appInterface.getCurrentAccountUin());
                return;
            }
            z3();
            QQToast.makeText(this.Q.getApplicationContext(), 1, R.string.f238167j1, 0).show();
            QLog.e("AccountPanelFragment", 1, "vId: " + optString + ", vUrl: " + optString2);
        } catch (JSONException e16) {
            z3();
            QQToast.makeText(this.Q.getApplicationContext(), 1, R.string.f238167j1, 0).show();
            QLog.e("AccountPanelFragment", 1, "get videoInfo failed showTencentVideoStatusPopWindow: " + e16);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.y
    public void Og(y.a aVar) {
        this.f255255d0 = aVar;
    }

    public void Oi(SimpleAccount simpleAccount) {
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            return;
        }
        this.Y.E2(this.Q, simpleAccount, appInterface);
    }

    @Override // com.tencent.mobileqq.onlinestatus.y
    public void Pc(y.b bVar) {
        com.tencent.mobileqq.onlinestatus.view.s sVar = this.f255252a0;
        if (sVar != null) {
            sVar.n1(bVar);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.aw.a
    public void Q9(au auVar, View view) {
        if (auVar != null && view != null) {
            Yi(view, auVar.B);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.a
    public ArrayList<au> Qg() {
        bt btVar = this.S;
        if (btVar != null) {
            return btVar.e();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.onlinestatus.y
    public void Rb() {
        this.Y.p2().setValue(Boolean.FALSE);
    }

    public void Si(AppRuntime.Status status, long j3) {
        bt btVar = this.S;
        if (btVar != null) {
            btVar.h(status, j3);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.y
    public void b6() {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("AccountPanelFragment", 2, "onAccoutChangeFailed");
        }
        com.tencent.mobileqq.onlinestatus.view.ax axVar = this.T;
        if (axVar != null) {
            axVar.a();
        }
        ii();
        AccountPanelViewModel accountPanelViewModel = this.Y;
        if (accountPanelViewModel != null) {
            accountPanelViewModel.p2().setValue(Boolean.FALSE);
            str = this.Y.z2();
        } else {
            str = null;
        }
        AppInterface appInterface = getAppInterface();
        if (this.Q != null && appInterface != null && !android.text.TextUtils.isEmpty(str)) {
            ReportController.r(null, "dc00898", "", "", "0X800B42F", "0X800B42F", 0, 0, "", "", "", "");
            QQCustomDialog message = DialogUtil.createCustomDialog(this.Q, 230).setTitle(this.Q.getString(R.string.f173179hs4)).setMessage(this.Q.getString(R.string.f173178hs3));
            message.setPositiveButton(R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AccountPanelFragment.this.ui(dialogInterface, i3);
                }
            });
            message.setCancelable(true);
            message.show();
        }
    }

    public void bj() {
        bt btVar = this.S;
        if (btVar != null) {
            btVar.l();
        }
    }

    public void cj(AppRuntime.Status status, long j3) {
        bt btVar = this.S;
        if (btVar != null) {
            btVar.m(true, status, j3);
        }
    }

    public void dj(int i3) {
        this.Y.n3(i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.onlinestatus.aw.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g2(au auVar, au auVar2, View view) {
        long j3;
        char c16;
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            return;
        }
        int i3 = 1;
        if (!NetworkUtil.isNetworkAvailable(this.Q)) {
            QQToast.makeText(this.Q, 1, R.string.hpk, 1).show();
            if (this.S != null) {
                com.tencent.mobileqq.onlinestatus.model.g value = this.Y.l2().getValue();
                if (value == null) {
                    value = new com.tencent.mobileqq.onlinestatus.model.g(auVar.f255494g, auVar.f255489b);
                }
                this.S.h(value.f256022a, value.f256023b);
                return;
            }
            return;
        }
        AppRuntime.Status i16 = af.C().i(auVar2);
        AppRuntime.Status i17 = af.C().i(auVar);
        if (i16 != null && auVar2 != null && this.T.f(view, this.Q, fi(), this.f255252a0.o0(), this, this.f255264m0, auVar2.f255489b, R.id.zxc)) {
            L0(i16, (int) auVar2.f255489b);
            return;
        }
        if (auVar2 != null) {
            j3 = auVar2.f255489b;
        } else {
            j3 = -1;
        }
        if (i16 != null && auVar2 != null && !qi(auVar2, i16)) {
            as.f(appInterface, i16, auVar2.f255489b);
            Xi(i16, auVar2.f255489b);
            SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("online_battery", 0);
            boolean z16 = sharedPreferences.getBoolean("has_set_battery", false);
            if (af.C().e0(auVar2) && !z16) {
                sharedPreferences.edit().putBoolean("has_set_battery", true).apply();
                Zi(i16, auVar2.f255489b);
            } else if (ar.a(i16)) {
                Zi(i16, auVar2.f255489b);
            } else if (auVar2.f255489b == 1028 && !com.tencent.mobileqq.onlinestatus.manager.k.C()) {
                com.tencent.mobileqq.onlinestatus.manager.k.K();
                Zi(i16, auVar2.f255489b);
            } else {
                long j16 = auVar2.f255489b;
                if (j16 == 2000) {
                    c16 = 0;
                    this.V = af.C().l(this.Q, i16, this.Y, null, auVar2.f255489b, this, this.f255254c0);
                } else {
                    c16 = 0;
                    if (j16 == 1021) {
                        Bundle bundle = new Bundle();
                        OnlineStatusExtInfo$SynchVideoBizInfo onlineStatusExtInfo$SynchVideoBizInfo = new OnlineStatusExtInfo$SynchVideoBizInfo();
                        onlineStatusExtInfo$SynchVideoBizInfo.synch_type.set(1);
                        bundle.putByteArray("TencentVideoInfo", onlineStatusExtInfo$SynchVideoBizInfo.toByteArray());
                        bundle.putInt("StatusId", 1021);
                        ((OnlineStatusHandler) appInterface.getBusinessHandler(OnlineStatusHandler.class.getName())).b3(5, bundle, null);
                        ((IZPlanApi) QRoute.api(IZPlanApi.class)).showStatusTip(this.Q, auVar2.f255489b);
                    } else {
                        this.Y.k3(i16, j16, true);
                        ((IZPlanApi) QRoute.api(IZPlanApi.class)).showStatusTip(this.Q, auVar2.f255489b);
                    }
                }
                if (!QLog.isColorLevel()) {
                    Object[] objArr = new Object[3];
                    objArr[c16] = i17;
                    objArr[1] = i16;
                    objArr[2] = Long.valueOf(auVar2.f255489b);
                    QLog.d("AccountPanelFragment", 2, String.format("onOnlineStatusChanged, %s -> %s, %d", objArr));
                    return;
                }
                return;
            }
            c16 = 0;
            if (!QLog.isColorLevel()) {
            }
        } else {
            if (qi(auVar2, i16) && ar.a(i16)) {
                com.tencent.mobileqq.onlinestatus.model.g value2 = this.Y.l2().getValue();
                AppRuntime.Status status = value2.f256022a;
                if (status != AppRuntime.Status.away) {
                    if (status == AppRuntime.Status.busy) {
                        i3 = 2;
                    } else {
                        i3 = 3;
                    }
                }
                bv.b("0X800B754", i3);
                mi(value2.f256022a, value2.f256023b);
                return;
            }
            if (qi(auVar2, i16) && i16 == AppRuntime.Status.online && j3 == 0) {
                ((ICustomOnlineStatusManager) QRoute.api(ICustomOnlineStatusManager.class)).openH5(this.Q, WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL);
            }
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.a
    public ArrayList<au> getDataList() {
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            return null;
        }
        return af.C().L(((IOnlineStatusService) appInterface.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus(), af.C().M(appInterface), true);
    }

    @Override // com.tencent.mobileqq.onlinestatus.y
    public boolean isShowing() {
        if (isAdded() && !isHidden() && getView() != null && getView().getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.onlinestatus.y
    public boolean l(boolean z16) {
        try {
            AppInterface appInterface = getAppInterface();
            com.tencent.mobileqq.onlinestatus.view.s sVar = this.f255252a0;
            if (sVar != null && appInterface != null) {
                sVar.X0(appInterface);
            }
            if (QLog.isColorLevel()) {
                QLog.d("AccountPanelFragment", 2, String.format("dismiss AccountPanel, needAnim: %s", Boolean.valueOf(z16)));
            }
            if (OnlineStatusToggleUtils.e() && QLog.isDevelopLevel()) {
                QLog.i("AccountPanelViewModel", 1, "dismiss " + QLog.getStackTraceString(new Throwable()));
            }
            this.T.b();
            DIYStatusDialogFragment dIYStatusDialogFragment = this.V;
            if (dIYStatusDialogFragment != null && dIYStatusDialogFragment.getDialog() != null) {
                this.V.getDialog().dismiss();
            }
            ji();
            if (!z16) {
                return uh();
            }
            return sh();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.y
    public void l2(String str, final int i3) {
        if (str == null) {
            z3();
            QLog.e("AccountPanelFragment", 1, "extInfoJson value is null");
            QQToast.makeText(this.Q.getApplicationContext(), 1, R.string.f227976sh, 0).show();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            final String optString = jSONObject.optString(IOnlineStatusService.SONG_ID);
            final int optInt = jSONObject.optInt(IOnlineStatusService.SYNC_TYPE);
            final int optInt2 = jSONObject.optInt(IOnlineStatusService.REMAIN_TIME);
            final boolean optBoolean = jSONObject.optBoolean(IOnlineStatusService.PAUSE_FLAG);
            final int optInt3 = jSONObject.optInt("duration");
            if (!android.text.TextUtils.isEmpty(optString) && optInt >= 0 && optInt2 >= 0 && optInt3 > 0) {
                AppInterface appInterface = getAppInterface();
                if (appInterface == null) {
                    return;
                }
                SyncMusicInfoHandler syncMusicInfoHandler = (SyncMusicInfoHandler) appInterface.getBusinessHandler(SyncMusicInfoHandler.class.getName());
                final CustomShareInfo c16 = com.tencent.mobileqq.onlinestatus.utils.f.c(AppRuntime.Status.online, 1028L, jSONObject);
                syncMusicInfoHandler.H2(new y.e() { // from class: com.tencent.mobileqq.onlinestatus.e
                    @Override // com.tencent.mobileqq.onlinestatus.y.e
                    public final void a(String str2, String str3) {
                        AccountPanelFragment.this.Fi(optString, optInt, optBoolean, optInt2, optInt3, c16, i3, str2, str3);
                    }
                });
                syncMusicInfoHandler.G2(optString, optInt);
                return;
            }
            z3();
            QQToast.makeText(this.Q.getApplicationContext(), 1, R.string.f227976sh, 0).show();
            QLog.e("AccountPanelFragment", 1, "songId: " + optString + ", songType: " + optInt + ", remainTime: " + optInt2 + ", duration: " + optInt3);
        } catch (JSONException e16) {
            z3();
            QQToast.makeText(this.Q.getApplicationContext(), 1, R.string.f227976sh, 0).show();
            QLog.e("AccountPanelFragment", 1, "get extInfoJson failed showSyncSingSongPopWindow: " + e16);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.aw.a
    public void l3(View view) {
        l(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: li, reason: merged with bridge method [inline-methods] */
    public void Gi(String str, String str2, String str3, int i3, JSONObject jSONObject) {
        AppInterface appInterface = getAppInterface();
        if (appInterface != null && this.Q != null) {
            if (!android.text.TextUtils.isEmpty(str2) && !android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str3)) {
                ji();
                SyncStatusExtInfoPopWindow syncStatusExtInfoPopWindow = new SyncStatusExtInfoPopWindow(str, str2, str3, com.tencent.mobileqq.onlinestatus.utils.f.c(AppRuntime.Status.online, 1021L, jSONObject), this, this, appInterface);
                this.W = syncStatusExtInfoPopWindow;
                syncStatusExtInfoPopWindow.Th(i3);
                this.W.Sh(new h(this));
                FragmentManager supportFragmentManager = this.Q.getSupportFragmentManager();
                if (!this.Q.isDestroyed() && !this.Q.isFinishing() && !supportFragmentManager.isStateSaved()) {
                    this.W.show(supportFragmentManager, "tencentVideoStatusPopWindow");
                    return;
                }
                return;
            }
            QQToast.makeText(appInterface.getApplicationContext(), R.string.f238167j1, 0).show();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public void onAccountChanged() {
        final AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            return;
        }
        final String currentAccountUin = appInterface.getCurrentAccountUin();
        QLog.d("AccountPanelFragment", 2, "onAccountChanged");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.i
            @Override // java.lang.Runnable
            public final void run() {
                AccountPanelFragment.this.ti(currentAccountUin);
            }
        }, 16, null, true);
        DIYStatusDialogFragment dIYStatusDialogFragment = this.V;
        if (dIYStatusDialogFragment != null) {
            dIYStatusDialogFragment.Oh(appInterface);
        }
        if (!android.text.TextUtils.isEmpty(this.Y.z2())) {
            ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginFinish(true, "");
        }
        this.Y.g3(null);
        this.T.a();
        ii();
        this.f255257f0 = !l(false);
        if (OnlineStatusToggleUtils.k()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.AccountPanelFragment.7
                @Override // java.lang.Runnable
                public void run() {
                    ((ISubAccountAssistantForward) QRoute.api(ISubAccountAssistantForward.class)).doSomethingAfterSwitchAccountSuccess(appInterface, AccountPanelFragment.this.Q);
                }
            }, 16, null, true);
        } else {
            ((ISubAccountAssistantForward) QRoute.api(ISubAccountAssistantForward.class)).doSomethingAfterSwitchAccountSuccess(appInterface, this.Q);
        }
        this.f255252a0.U0();
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i3 == 100) {
            OnlineStatusPermissionChecker.b(intent, i16, this.Q, MobileQQ.sMobileQQ.peekAppRuntime(), true);
            return;
        }
        if (i3 != 299 && i3 != 234) {
            if (this.T.e(i3, i16, intent)) {
                this.f255252a0.M1();
                return;
            }
            return;
        }
        this.Y.A2().setValue(Boolean.TRUE);
    }

    @Override // com.tencent.mobileqq.onlinestatus.y
    public void onDestory() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100981", true)) {
            Pc(null);
            Og(null);
            D3(null);
        }
        bt btVar = this.S;
        if (btVar != null) {
            btVar.f();
        }
        AppInterface appInterface = getAppInterface();
        com.tencent.mobileqq.onlinestatus.view.s sVar = this.f255252a0;
        if (sVar != null && appInterface != null) {
            sVar.W0(appInterface);
        }
        ii();
        this.T.b();
        this.T.a();
        AccountPanelViewModel accountPanelViewModel = this.Y;
        if (accountPanelViewModel != null) {
            accountPanelViewModel.Y2(true);
            this.Y.h2(true);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AccountPanelFragment", 2, "onDestory");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f255261j0) {
            this.f255261j0 = false;
            ImmersiveUtils.setStatusTextColor(this.f255258g0, this.Q.getWindow());
        }
        AppInterface appInterface = getAppInterface();
        com.tencent.mobileqq.onlinestatus.view.s sVar = this.f255252a0;
        if (sVar != null) {
            if (appInterface != null) {
                sVar.e1(appInterface);
            }
            this.f255252a0.g0();
            this.f255252a0.b1(appInterface);
            this.f255252a0.c1();
        }
        if (appInterface != null) {
            ((IOnlineStatusService) appInterface.getRuntimeService(IOnlineStatusService.class, "")).setOnlineStatusZplanPanelListener(null);
            ((SyncMusicInfoHandler) appInterface.getBusinessHandler(SyncMusicInfoHandler.class.getName())).H2(null);
        }
        y.a aVar = this.f255255d0;
        if (aVar != null) {
            aVar.a();
        }
        gi();
        if (OnlineStatusToggleUtils.e()) {
            try {
                onDestory();
                AccountPanelViewModel accountPanelViewModel = this.Y;
                if (accountPanelViewModel != null) {
                    accountPanelViewModel.b3();
                    this.Y.g2(this.f255263l0);
                }
            } catch (Exception e16) {
                QLog.e("AccountPanelFragment", 1, "onDestroy " + e16);
            }
            if (!OnlineStatusToggleUtils.y()) {
                this.Y = null;
                this.f255252a0 = null;
                this.f255263l0 = null;
                this.Z = null;
                this.S = null;
                this.Q = null;
                this.C = null;
                this.D = null;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ji();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        if (QLog.isColorLevel()) {
            QLog.d("AccountPanelFragment", 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        super.onPause();
        AccountPanelViewModel accountPanelViewModel = this.Y;
        if (accountPanelViewModel != null) {
            accountPanelViewModel.e3(false);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        bt btVar = this.S;
        if (btVar != null) {
            this.R.f255577p = false;
            btVar.g();
        }
        if (isShowing()) {
            this.f255252a0.onPostThemeChanged();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        if (QLog.isColorLevel()) {
            QLog.d("AccountPanelFragment", 2, "onResume");
        }
        super.onResume();
        if (!this.f255257f0 && this.Y != null) {
            if (isShowing()) {
                this.f255252a0.Y0();
                this.Y.A2().setValue(Boolean.TRUE);
                this.Y.r2();
            }
            this.Y.e3(true);
            Pi();
            com.tencent.mobileqq.onlinestatus.utils.ab.f256333a.a("exp_qq_base_online_status_fold_v1");
            return;
        }
        this.f255257f0 = false;
        l(false);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (QLog.isColorLevel()) {
            QLog.d("AccountPanelFragment", 2, DKHippyEvent.EVENT_STOP);
        }
        com.tencent.mobileqq.onlinestatus.view.s sVar = this.f255252a0;
        if (sVar != null) {
            sVar.a1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment
    public void ph() {
        super.ph();
        AccountPanelViewModel accountPanelViewModel = this.Y;
        if (accountPanelViewModel != null) {
            accountPanelViewModel.Y2(false);
            this.Y.h2(false);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.y
    public void qe(y.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f255256e0 == null) {
            this.f255256e0 = new ArrayList();
        }
        if (!this.f255256e0.contains(aVar)) {
            this.f255256e0.add(aVar);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.y
    public void s8() {
        try {
            l(false);
            this.T.b();
            DIYStatusDialogFragment dIYStatusDialogFragment = this.V;
            if (dIYStatusDialogFragment != null) {
                dIYStatusDialogFragment.dismiss();
            }
        } catch (Exception e16) {
            QLog.e("AccountPanelFragment", 1, "dismissRecursive: failed. ", e16);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.y
    public void show(int i3) {
        if (i3 == 6 || i3 == 7) {
            bs.z0(new ec2.a() { // from class: com.tencent.mobileqq.onlinestatus.l
                @Override // ec2.a
                public final void a(boolean z16) {
                    AccountPanelFragment.this.xi(z16);
                }
            });
        }
        show();
        this.f255254c0 = i3;
        com.tencent.mobileqq.onlinestatus.utils.z.w(i3);
        if (i3 == 7) {
            com.tencent.mobileqq.onlinestatus.utils.z.x();
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment
    protected View vh() {
        return this.C;
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment
    protected String yh() {
        return y.class.getName();
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.SyncStatusExtInfoPopWindow.c
    public void z3() {
        l(true);
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            return;
        }
        ((SyncMusicInfoHandler) appInterface.getBusinessHandler(SyncMusicInfoHandler.class.getName())).H2(null);
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment
    protected void zh(View view, boolean z16) {
        float f16;
        float f17;
        float f18;
        float f19 = 0.5f;
        float f26 = 1.0f;
        if (z16) {
            f16 = 0.5f;
        } else {
            f16 = 1.0f;
        }
        if (z16) {
            f19 = 1.0f;
        }
        float f27 = 0.0f;
        if (z16) {
            f17 = 0.0f;
        } else {
            f17 = 1.0f;
        }
        if (z16) {
            f27 = 1.0f;
        }
        if (z16) {
            f18 = 0.02f;
        } else {
            f18 = 1.0f;
        }
        if (!z16) {
            f26 = 0.02f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, f16, f19);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, f16, f19);
        if (view != this.C) {
            ofFloat.setDuration(230L);
            ofFloat2.setDuration(230L);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, f18, f26);
            ofFloat3.setDuration(70L);
            if (z16) {
                ofFloat3.setStartDelay(70L);
            }
            this.H.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ObjectAnimator.ofFloat(this.C, com.tencent.luggage.wxa.c8.c.f123400v, f17, f27));
        } else {
            this.H.play(ofFloat).with(ofFloat2).with(ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, f17, f27));
        }
        this.H.setInterpolator(new AccelerateDecelerateInterpolator());
        this.H.setDuration(300L);
    }

    @Override // com.tencent.mobileqq.onlinestatus.view.BaseStatusCardViewFragment, com.tencent.mobileqq.onlinestatus.y
    public void show() {
        AppInterface appInterface;
        if (this.Q == null || isShowing() || (appInterface = getAppInterface()) == null) {
            return;
        }
        this.f255258g0 = ImmersiveUtils.isStatusTextUseDarkColor(this.Q.getWindow());
        this.f255261j0 = true;
        aj();
        this.Y.c3(true);
        if (!OnlineStatusToggleUtils.p()) {
            this.f255252a0.z1(this.Q);
        }
        super.show();
        this.Y.U2(null);
        this.Y.f2();
        this.f255252a0.Y(appInterface);
        this.f255252a0.X();
        Pi();
        this.Y.i2(this.Q, appInterface);
        if (this.f255253b0 == 10) {
            this.Q.sendBroadcast(new Intent("before_account_change"));
        }
        if (QLog.isColorLevel()) {
            QLog.d("AccountPanelFragment", 2, "show AccountPanel");
        }
        ReportController.o(appInterface, "dc00898", "", "", "0X800AC35", "0X800AC35", 0, 0, "", "", "", "");
        if (bs.Z(appInterface)) {
            this.Y.H2();
        }
        this.f255252a0.Z0(appInterface);
        Vi();
        Gh(true);
        hi();
    }

    public AccountPanelFragment(@NonNull QBaseActivity qBaseActivity, int i3) {
        super(qBaseActivity, null);
        this.R = new ba();
        this.T = new com.tencent.mobileqq.onlinestatus.view.ax();
        this.f255257f0 = false;
        this.f255258g0 = false;
        this.f255259h0 = -1;
        this.f255260i0 = -1;
        this.f255261j0 = false;
        this.f255262k0 = 0L;
        this.f255264m0 = new f();
        this.f255253b0 = i3;
        this.Q = qBaseActivity;
        View oi5 = oi();
        if (oi5 == null) {
            try {
                onDestroy();
                return;
            } catch (Exception e16) {
                QLog.e("AccountPanelFragment", 1, "AccountPanelFragment " + e16);
                return;
            }
        }
        this.C = oi5;
        this.D = oi5.findViewById(R.id.b9j);
        this.I = 0;
        Bh(new float[]{0.5f, 0.0f});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a implements h43.e {
        a() {
        }

        @Override // h43.e
        public void b() {
            AccountPanelFragment.this.Y.A2().setValue(Boolean.TRUE);
        }

        @Override // h43.e
        public void a() {
        }
    }

    public void Ti(View view) {
    }
}

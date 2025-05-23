package com.qwallet.activity.patternlock;

import Wallet.GetPasswordReq;
import Wallet.GetPasswordRsp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qwallet.activity.QWalletAppInterface;
import com.qwallet.activity.QWalletTitleBarActivity;
import com.qwallet.protocol.Wallet.PatternLock.SetPasswordReq;
import com.qwallet.protocol.Wallet.PatternLock.SetPasswordRsp;
import com.qwallet.temp.IQWalletApiProxy;
import com.qwallet.temp.IQWalletTemp;
import com.qwallet.utils.QWalletUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.widget.LockPatternView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import cooperation.qwallet.plugin.IActivity;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.qwallet.plugin.PropertyUtils;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;
import java.text.MessageFormat;
import java.util.List;
import mqq.util.WeakReference;

/* loaded from: classes3.dex */
public class PatternLockActivity extends QWalletTitleBarActivity implements View.OnClickListener, com.qwallet.activity.sso.f {
    protected LockPatternView V;
    protected TextView W;
    protected TextView X;

    /* renamed from: a0, reason: collision with root package name */
    protected QQCustomDialog f41317a0;

    /* renamed from: b0, reason: collision with root package name */
    protected QQCustomDialog f41318b0;

    /* renamed from: c0, reason: collision with root package name */
    protected QWalletPayProgressDialog f41319c0;

    /* renamed from: d0, reason: collision with root package name */
    private e f41320d0;

    /* renamed from: i0, reason: collision with root package name */
    protected com.qwallet.activity.sso.d f41325i0;

    /* renamed from: j0, reason: collision with root package name */
    protected com.qwallet.activity.sso.c f41326j0;

    /* renamed from: n0, reason: collision with root package name */
    private com.qwallet.activity.patternlock.biz.a f41330n0;

    /* renamed from: t0, reason: collision with root package name */
    private int[] f41336t0;

    /* renamed from: u0, reason: collision with root package name */
    private long[] f41337u0;

    /* renamed from: v0, reason: collision with root package name */
    private View f41338v0;
    protected float Y = 1.0f;
    protected long Z = 0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f41321e0 = false;

    /* renamed from: f0, reason: collision with root package name */
    protected boolean f41322f0 = false;

    /* renamed from: g0, reason: collision with root package name */
    private String f41323g0 = null;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f41324h0 = false;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f41327k0 = false;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f41328l0 = true;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f41329m0 = false;

    /* renamed from: o0, reason: collision with root package name */
    private Handler f41331o0 = new Handler();

    /* renamed from: p0, reason: collision with root package name */
    private LockPatternView.b f41332p0 = new a();

    /* renamed from: q0, reason: collision with root package name */
    private Animation.AnimationListener f41333q0 = new b();

    /* renamed from: r0, reason: collision with root package name */
    private int f41334r0 = 0;

    /* renamed from: s0, reason: collision with root package name */
    private int f41335s0 = 5;

    /* renamed from: w0, reason: collision with root package name */
    private BroadcastReceiver f41339w0 = new c();

    /* loaded from: classes3.dex */
    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                long longExtra = intent.getLongExtra("timeid", 0L);
                PatternLockActivity patternLockActivity = PatternLockActivity.this;
                if (longExtra > patternLockActivity.Z && !patternLockActivity.isFinishing()) {
                    PatternLockActivity.this.setResult(0);
                    PatternLockActivity.this.finish();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public static abstract class e {
        protected e() {
        }

        public abstract void a();

        public abstract void b();

        public abstract void c(int i3, boolean z16, boolean z17, Object obj);

        public abstract void d(List<LockPatternView.a> list);

        public abstract void e(View view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public class f extends g {
        protected f() {
            super();
        }

        @Override // com.qwallet.activity.patternlock.PatternLockActivity.g, com.qwallet.activity.patternlock.PatternLockActivity.e
        public void a() {
            super.a();
        }

        @Override // com.qwallet.activity.patternlock.PatternLockActivity.g, com.qwallet.activity.patternlock.PatternLockActivity.e
        public void b() {
            super.b();
            if (this.f41352c < 5) {
                PatternLockActivity.this.W.setText(R.string.g9y);
            }
        }

        @Override // com.qwallet.activity.patternlock.PatternLockActivity.g, com.qwallet.activity.patternlock.PatternLockActivity.e
        public void e(View view) {
            super.e(view);
        }

        @Override // com.qwallet.activity.patternlock.PatternLockActivity.g
        protected void l() {
            this.f41350a = 5;
            PatternLockUtils.setUnlockFailedTimes(PatternLockActivity.this.getContext(), QWalletUtils.h(), 0);
            PatternLockActivity.this.V.c();
            if (!NetworkUtil.isNetSupport(PatternLockActivity.this.getOutActivity())) {
                QQToast.makeText(PatternLockActivity.this.getOutActivity(), R.string.b3j, 0).show(PropertyUtils.getToastOffset(PatternLockActivity.this.getOutActivity()));
                PatternLockActivity.this.setResult(0);
                PatternLockActivity.this.Ch();
                return;
            }
            QWalletAppInterface.getInstance().unRegistUIObserver(PatternLockActivity.this);
            Intent intent = new Intent();
            intent.putExtra("action_mode", 2);
            intent.putExtra("enable_act_anim", true);
            intent.putExtra(IPCConst.KEY_TITLE_TEXT, PatternLockActivity.this.getString(R.string.bi9));
            intent.putExtra("is_for_revising_pwd", true);
            PatternLockActivity.this.launchFragmentForResult(intent, PatternLockActivity.class, 302);
            if (QLog.isColorLevel()) {
                QLog.d("Q.qwallet.pay.unlock", 2, "unlock success.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public class g extends e {

        /* renamed from: a, reason: collision with root package name */
        protected int f41350a = 5;

        /* renamed from: b, reason: collision with root package name */
        protected String f41351b = "";

        /* renamed from: c, reason: collision with root package name */
        protected int f41352c = 0;

        /* renamed from: d, reason: collision with root package name */
        protected long f41353d = 0;

        /* renamed from: e, reason: collision with root package name */
        private boolean f41354e = false;

        /* renamed from: f, reason: collision with root package name */
        protected Handler f41355f = new Handler();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        g.this.g();
                        dialogInterface.dismiss();
                        return;
                    }
                    return;
                }
                dialogInterface.dismiss();
                PatternLockActivity.this.onBackEvent();
            }
        }

        protected g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            QWalletAppInterface.getInstance().unRegistUIObserver(PatternLockActivity.this);
            if (!PatternLockUtils.isPatternLockOpened(PatternLockActivity.this.getContext(), QWalletUtils.h())) {
                return;
            }
            PatternLockActivity.this.f41330n0.i(3);
        }

        private void i() {
            this.f41350a--;
            PatternLockUtils.setLastUnlockFailedTime(PatternLockActivity.this.getActivity(), QWalletUtils.h(), NetConnInfoCenter.getServerTimeMillis() / 1000);
            PatternLockUtils.setUnlockFailedTimes(PatternLockActivity.this.getActivity(), QWalletUtils.h(), 5 - this.f41350a);
            PatternLockActivity.this.V.setDisplayMode(2);
            if (this.f41350a > 0) {
                j();
            } else {
                k();
            }
        }

        @Override // com.qwallet.activity.patternlock.PatternLockActivity.e
        public void a() {
            this.f41351b = PatternLockActivity.this.getString(R.string.bij);
            this.f41352c = PatternLockUtils.getUnlockFailedTimes(PatternLockActivity.this.getActivity(), QWalletUtils.h());
            this.f41353d = PatternLockUtils.getLastUnlockFailedTime(PatternLockActivity.this.getActivity(), QWalletUtils.h());
            this.f41350a = 5 - this.f41352c;
            this.f41354e = PatternLockActivity.this.getIntent().getBooleanExtra("is_close_pwd", false);
            if (NetworkUtil.isNetSupport(PatternLockActivity.this.getContext())) {
                PatternLockActivity.this.Gh();
            }
        }

        @Override // com.qwallet.activity.patternlock.PatternLockActivity.e
        public void b() {
            int i3;
            if (this.f41352c > 0) {
                long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
                if (this.f41353d + 600 < serverTimeMillis) {
                    this.f41350a = 5;
                    this.f41352c = 0;
                    PatternLockUtils.setUnlockFailedTimes(PatternLockActivity.this.getContext(), QWalletUtils.h(), 0);
                    PatternLockUtils.setLastUnlockFailedTime(PatternLockActivity.this.getContext(), QWalletUtils.h(), 0L);
                    return;
                }
                if (this.f41352c >= 5) {
                    PatternLockActivity.this.V.setEnabled(false);
                    long j3 = 600 - (serverTimeMillis - this.f41353d);
                    long j16 = j3 / 60;
                    if (j3 % 60 != 0) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    PatternLockActivity.this.W.setText(PatternLockActivity.this.getString(R.string.g__, Long.valueOf(j16 + i3)));
                    PatternLockActivity patternLockActivity = PatternLockActivity.this;
                    patternLockActivity.W.setTextColor(patternLockActivity.getResources().getColor(R.color.f157924ab3));
                }
            }
        }

        @Override // com.qwallet.activity.patternlock.PatternLockActivity.e
        public void c(int i3, boolean z16, boolean z17, Object obj) {
            if (i3 != 3 && i3 != 2) {
                return;
            }
            String str = "";
            if (i3 == 3) {
                if (z16 && obj != null && (obj instanceof GetPasswordRsp)) {
                    GetPasswordRsp getPasswordRsp = (GetPasswordRsp) obj;
                    if (getPasswordRsp.ret == 0) {
                        if (!TextUtils.isEmpty(getPasswordRsp.password)) {
                            str = MD5.toMD5(QWalletHelperDelegate.getQWDevId() + getPasswordRsp.password);
                        }
                        PatternLockUtils.setSyncPatternLockState(PatternLockActivity.this.getContext(), QWalletUtils.h(), false);
                        PatternLockUtils.setPWD(PatternLockActivity.this.getContext(), QWalletUtils.h(), str);
                        PatternLockUtils.setPWDType(PatternLockActivity.this.getContext(), QWalletUtils.h(), getPasswordRsp.passwordType);
                        PatternLockUtils.setCheckIntervalTime(PatternLockActivity.this.getContext(), QWalletUtils.h(), getPasswordRsp.checkInterval);
                        PatternLockUtils.setForgroundIntervalTime(PatternLockActivity.this.getContext(), QWalletUtils.h(), getPasswordRsp.passInterval);
                        return;
                    }
                    return;
                }
                return;
            }
            if (i3 == 2 && this.f41354e) {
                if (z16 && obj != null && (obj instanceof SetPasswordRsp) && ((SetPasswordRsp) obj).ret == 0) {
                    QQToast.makeText(PatternLockActivity.this.getContext(), R.string.g_3, 0).show(PropertyUtils.getTitleBarHeight(PatternLockActivity.this.getOutActivity()));
                    PatternLockActivity.this.setResult(-1);
                    PatternLockActivity.this.Ch();
                    com.tencent.mobileqq.qwallet.c.e("shousipwd.close", "", "", "", "");
                    return;
                }
                QQToast.makeText(PatternLockActivity.this.getContext(), R.string.g9z, 0).show(PropertyUtils.getTitleBarHeight(PatternLockActivity.this.getOutActivity()));
                PatternLockActivity.this.setResult(0);
                PatternLockActivity.this.Ch();
            }
        }

        @Override // com.qwallet.activity.patternlock.PatternLockActivity.e
        public void d(List<LockPatternView.a> list) {
            boolean z16 = true;
            if (list != null) {
                if (h(PatternLockActivity.Fh(list))) {
                    l();
                    z16 = false;
                } else {
                    i();
                }
            } else {
                QQToast.makeText(PatternLockActivity.this.getContext(), 1, PatternLockActivity.this.getString(R.string.bie), 0).show(PropertyUtils.getTitleBarHeight(PatternLockActivity.this.getActivity()));
                i();
            }
            if (z16) {
                PatternLockActivity.this.Bh();
            }
        }

        @Override // com.qwallet.activity.patternlock.PatternLockActivity.e
        public void e(View view) {
            if (view.getId() == R.id.f165357cu3) {
                g();
            }
        }

        protected boolean h(String str) {
            String h16 = QWalletUtils.h();
            String pwd = PatternLockUtils.getPWD(PatternLockActivity.this.getContext(), h16);
            String encodeToLocalPWD = PatternLockUtils.encodeToLocalPWD(PatternLockActivity.this.getContext(), h16, str);
            if (!TextUtils.isEmpty(pwd) && !TextUtils.isEmpty(encodeToLocalPWD) && pwd.equals(encodeToLocalPWD)) {
                return true;
            }
            return false;
        }

        void j() {
            if (QLog.isColorLevel()) {
                QLog.d("Q.qwallet.pay.unlock", 2, "onUnlockFailedInRange");
            }
            String format = MessageFormat.format(this.f41351b, Integer.valueOf(this.f41350a));
            PatternLockActivity patternLockActivity = PatternLockActivity.this;
            patternLockActivity.W.setTextColor(patternLockActivity.getResources().getColor(R.color.f157924ab3));
            String str = this.f41350a + "";
            int indexOf = format.indexOf(str);
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(new StyleSpan(1), indexOf, str.length() + indexOf, 18);
            PatternLockActivity.this.W.setText(spannableString);
            PatternLockActivity patternLockActivity2 = PatternLockActivity.this;
            patternLockActivity2.Ih(patternLockActivity2.W);
        }

        void k() {
            if (QLog.isColorLevel()) {
                QLog.d("Q.qwallet.pay.unlock", 2, "onUnlockFailedOutRange");
            }
            PatternLockActivity.this.V.setEnabled(false);
            QQCustomDialog qQCustomDialog = PatternLockActivity.this.f41317a0;
            if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
                PatternLockActivity.this.f41317a0.dismiss();
            }
            String string = PatternLockActivity.this.getString(R.string.g__, 10);
            PatternLockActivity.this.W.setText(string);
            PatternLockActivity patternLockActivity = PatternLockActivity.this;
            patternLockActivity.W.setTextColor(patternLockActivity.getResources().getColor(R.color.f157924ab3));
            PatternLockActivity.this.W.setText(string);
            String string2 = PatternLockActivity.this.getString(R.string.bih);
            String string3 = PatternLockActivity.this.getString(R.string.g9t);
            String string4 = PatternLockActivity.this.getString(R.string.cancel);
            String string5 = PatternLockActivity.this.getString(R.string.g9v);
            a aVar = new a();
            PatternLockActivity patternLockActivity2 = PatternLockActivity.this;
            patternLockActivity2.f41317a0 = DialogUtil.createCustomDialog(patternLockActivity2.getContext(), 231, string2, string3, string4, string5, aVar, aVar);
            PatternLockActivity.this.f41317a0.setCancelable(false);
            PatternLockActivity.this.f41317a0.show();
        }

        protected void l() {
            this.f41350a = 5;
            PatternLockUtils.setUnlockFailedTimes(PatternLockActivity.this.getContext(), QWalletUtils.h(), 0);
            PatternLockUtils.setFirstEnterAfterLoginState(PatternLockActivity.this.getContext(), QWalletUtils.h(), false);
            if (this.f41354e) {
                PatternLockActivity.this.Hh("");
            } else {
                PatternLockActivity.this.setResult(-1);
                PatternLockActivity.this.finish();
                if (PatternLockActivity.this.f41324h0) {
                    Intent intent = new Intent();
                    intent.setAction("action.qwallet.patterlock.open.success");
                    PatternLockActivity.this.sendBroadcast(intent);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.qwallet.pay.unlock", 2, "unlock success.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eh() {
        int[] iArr;
        long[] jArr;
        int i3 = this.f41334r0;
        int i16 = this.f41335s0;
        int i17 = 0;
        if (i3 < i16 && (iArr = this.f41336t0) != null && iArr.length >= i16 && (jArr = this.f41337u0) != null && jArr.length >= i16) {
            if (i3 > 0) {
                i17 = iArr[i3 - 1];
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(i17, iArr[i3], 0.0f, 0.0f);
            translateAnimation.setAnimationListener(this.f41333q0);
            translateAnimation.setDuration(this.f41337u0[this.f41334r0]);
            this.f41338v0.startAnimation(translateAnimation);
            this.f41334r0++;
            return;
        }
        this.f41334r0 = 0;
        this.f41338v0 = null;
    }

    public static String Fh(List<LockPatternView.a> list) {
        if (list == null) {
            return "";
        }
        int size = list.size();
        StringBuilder sb5 = new StringBuilder(size);
        for (int i3 = 0; i3 < size; i3++) {
            LockPatternView.a aVar = list.get(i3);
            sb5.append((char) ((aVar.c() * 3) + aVar.b() + 49));
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ih(View view) {
        this.f41334r0 = 0;
        this.f41335s0 = 5;
        this.f41337u0 = new long[]{50, 100, 100, 100, 100};
        float f16 = this.Y;
        this.f41336t0 = new int[]{(int) ((-20.0f) * f16), (int) (20.0f * f16), (int) ((-15.0f) * f16), (int) (f16 * 15.0f), 0};
        this.f41338v0 = view;
        Eh();
    }

    private void initData() {
        int intExtra = getIntent().getIntExtra("action_mode", 0);
        if (intExtra == 1) {
            this.f41320d0 = new g();
        } else if (intExtra == 2) {
            this.f41320d0 = new d();
        } else if (intExtra == 3) {
            this.f41320d0 = new f();
        } else {
            throw new RuntimeException("PatterLockActivity.initData ActionMode error.");
        }
        this.f41323g0 = getIntent().getStringExtra(IPCConst.KEY_TITLE_TEXT);
        this.Y = getResources().getDisplayMetrics().density;
        this.f41320d0.a();
    }

    private void initUI(View view) {
        String str = this.f41323g0;
        if (str != null) {
            setTitle(str);
        } else if (this.f41324h0) {
            setTitle(R.string.g_b);
        } else {
            setTitle(R.string.g_a);
        }
        TextView textView = (TextView) view.findViewById(R.id.cu5);
        this.W = textView;
        ol2.b.d(textView, 20);
        LockPatternView lockPatternView = (LockPatternView) view.findViewById(R.id.f165358cu4);
        this.V = lockPatternView;
        lockPatternView.setFillInGapCell(false);
        this.V.setTactileFeedbackEnabled(false);
        this.V.setOnPatternListener(this.f41332p0);
        TextView textView2 = (TextView) view.findViewById(R.id.f165357cu3);
        this.X = textView2;
        ol2.b.d(textView2, 20);
        this.X.setOnClickListener(this);
        if (this.Y <= 1.00001f) {
            ViewGroup.LayoutParams layoutParams = this.V.getLayoutParams();
            float f16 = this.Y;
            layoutParams.height = (int) (f16 * 240.0f);
            layoutParams.width = (int) (f16 * 240.0f);
            this.V.setLayoutParams(layoutParams);
        }
        this.f41320d0.b();
    }

    protected void Bh() {
        Handler handler = this.f41331o0;
        if (handler == null) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: com.qwallet.activity.patternlock.PatternLockActivity.4
            @Override // java.lang.Runnable
            public void run() {
                if (!PatternLockActivity.this.isFinishing()) {
                    PatternLockActivity.this.V.c();
                }
            }
        }, 500L);
    }

    protected void Ch() {
        this.V.setEnabled(false);
        this.X.setEnabled(false);
        this.f41331o0.postDelayed(new Runnable() { // from class: com.qwallet.activity.patternlock.PatternLockActivity.5
            @Override // java.lang.Runnable
            public void run() {
                if (!PatternLockActivity.this.isFinishing()) {
                    PatternLockActivity.this.finish();
                }
            }
        }, 1500L);
    }

    protected void Dh() {
        this.V.setEnabled(false);
        this.X.setEnabled(false);
        this.f41331o0.postDelayed(new Runnable() { // from class: com.qwallet.activity.patternlock.PatternLockActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (!PatternLockActivity.this.isFinishing()) {
                    PatternLockActivity.this.setResult(-1);
                    PatternLockActivity.this.finish();
                }
            }
        }, 1500L);
    }

    protected void Gh() {
        QWalletAppInterface.getInstance().registUIObserver(this);
        GetPasswordReq getPasswordReq = new GetPasswordReq();
        getPasswordReq.MQOS = "android";
        getPasswordReq.MQVersion = ah.Q(getContext());
        if (this.f41326j0 == null) {
            this.f41326j0 = new com.qwallet.activity.sso.c();
        }
        this.f41326j0.y(getActivity(), true, null, getPasswordReq);
    }

    @Override // com.qwallet.activity.sso.f
    public int H9() {
        return -1;
    }

    protected void Hh(String str) {
        QWalletAppInterface.getInstance().registUIObserver(this);
        SetPasswordReq setPasswordReq = new SetPasswordReq();
        setPasswordReq.MQOS = "android";
        setPasswordReq.password = str;
        setPasswordReq.deviceId = QWalletHelperDelegate.getQWDevId();
        setPasswordReq.passwordType = 0;
        if (this.f41325i0 == null) {
            this.f41325i0 = new com.qwallet.activity.sso.d();
        }
        this.f41325i0.y(getActivity(), true, null, setPasswordReq);
        QWalletPayProgressDialog qWalletPayProgressDialog = this.f41319c0;
        if (qWalletPayProgressDialog != null && qWalletPayProgressDialog.isShowing()) {
            this.f41319c0.dismiss();
        }
        QWalletPayProgressDialog qWalletPayProgressDialog2 = new QWalletPayProgressDialog(getContext());
        this.f41319c0 = qWalletPayProgressDialog2;
        qWalletPayProgressDialog2.setMessage(getString(R.string.g_9));
        this.f41319c0.setCancelable(false);
        this.f41319c0.show();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4 && keyEvent.getAction() == 0) {
            onBackEvent();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    public boolean doOnLogout() {
        return true;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    public void finish() {
        super.finish();
        if (this.f41322f0) {
            getActivity().overridePendingTransition(R.anim.f154442w, 0);
        } else if (!this.f41321e0) {
            getActivity().overridePendingTransition(R.anim.f154442w, R.anim.f154550b4);
        }
    }

    @Override // com.qwallet.activity.sso.f
    public void g3(int i3, boolean z16, boolean z17, Object obj) {
        if (isFinishing()) {
            return;
        }
        this.f41320d0.c(i3, z16, z17, obj);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    @NonNull
    public FragmentAnimation getFragmentAnimation() {
        if (this.f41321e0) {
            return FragmentAnimation.DEFAULT;
        }
        return FragmentAnimation.NONE;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarImmersive() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (i3 == 302) {
            setResult(i16);
            finish();
        }
    }

    @Override // com.qwallet.activity.QWalletTitleBarActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (this.f41324h0) {
            PatternLockUtils.setFirstEnterAfterLoginState(getContext(), QWalletUtils.h(), true);
        }
        if (this.f41324h0) {
            boolean z16 = this.f41329m0;
            if (!z16 && getIntent() != null) {
                z16 = getIntent().getBooleanExtra("is_from_background", false);
            }
            if (z16 && ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getJumpLock(getOutActivity(), QWalletUtils.h())) {
                RouteUtils.startActivity(getOutActivity(), new Intent(), RouterConstants.UI_ROUTE_GESTURE_PWD_UNLOCK);
                if (QLog.isDevelopLevel()) {
                    QLog.d("Q.qwallet.pay.unlock", 4, "startUnlockActivity... PatternLockActivity");
                }
            }
            Intent intent = new Intent();
            intent.setAction(IActivity.ACTION_QWALLET_PATTERN_LOCK_COLSEALL);
            sendBroadcast(intent);
        }
        setResult(0);
        finish();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f41320d0.e(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qwallet.activity.QWalletTitleBarActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (QLog.isColorLevel()) {
            QLog.d("Q.qwallet.pay.unlock", 2, "onCreate begin.");
        }
        if (getIntent() == null) {
            finish();
        }
        this.f41324h0 = getIntent().getBooleanExtra("is_for_entrance", false);
        this.f41321e0 = getIntent().getBooleanExtra("enable_act_anim", false);
        initData();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("qwallet.patternlock");
        registerReceiver(this.f41339w0, intentFilter);
        View inflate = layoutInflater.inflate(R.layout.bd7, viewGroup, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f41331o0.removeCallbacksAndMessages(null);
        QQCustomDialog qQCustomDialog = this.f41317a0;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            this.f41317a0.dismiss();
        }
        QWalletPayProgressDialog qWalletPayProgressDialog = this.f41319c0;
        if (qWalletPayProgressDialog != null && qWalletPayProgressDialog.isShowing()) {
            this.f41319c0.dismiss();
        }
        QQCustomDialog qQCustomDialog2 = this.f41318b0;
        if (qQCustomDialog2 != null && qQCustomDialog2.isShowing()) {
            this.f41318b0.dismiss();
        }
        QWalletAppInterface.getInstance().unRegistUIObserver(this);
        com.qwallet.activity.patternlock.biz.a aVar = this.f41330n0;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.f41324h0) {
            unregisterReceiver(this.f41339w0);
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f41324h0) {
            boolean appForground = BaseGesturePWDUtil.getAppForground(getOutActivity());
            this.f41328l0 = appForground;
            if (!appForground && ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getJumpLock(getOutActivity(), QWalletUtils.h())) {
                this.f41329m0 = true;
            }
            if (!this.f41328l0) {
                this.f41328l0 = true;
                ((IQWalletApiProxy) QRoute.api(IQWalletApiProxy.class)).setAppForground(getOutActivity(), this.f41328l0);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.f41324h0) {
            boolean isAppOnForeground = BaseGesturePWDUtil.isAppOnForeground(getOutActivity());
            this.f41328l0 = isAppOnForeground;
            if (!isAppOnForeground) {
                ((IQWalletApiProxy) QRoute.api(IQWalletApiProxy.class)).setAppForground(getOutActivity(), this.f41328l0);
            }
        }
    }

    @Override // com.qwallet.activity.QWalletTitleBarActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        initUI(view);
        if (this.f41324h0) {
            this.Z = System.currentTimeMillis();
            Intent intent = new Intent();
            intent.setAction("qwallet.patternlock");
            intent.putExtra("timeid", this.Z);
            sendBroadcast(intent);
        }
        com.qwallet.activity.patternlock.biz.a b16 = com.qwallet.activity.patternlock.biz.c.a().b(0);
        this.f41330n0 = b16;
        b16.e(new WeakReference<>(getActivity()));
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        super.onWindowFocusChanged(z16);
        if (z16 && !this.f41327k0) {
            this.f41327k0 = true;
        }
    }

    /* loaded from: classes3.dex */
    class a implements LockPatternView.b {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.LockPatternView.b
        public void onPatternDetected(List<LockPatternView.a> list) {
            PatternLockActivity.this.f41320d0.d(list);
        }

        @Override // com.tencent.mobileqq.widget.LockPatternView.b
        public void onPatternCleared() {
        }

        @Override // com.tencent.mobileqq.widget.LockPatternView.b
        public void onPatternStart() {
        }

        @Override // com.tencent.mobileqq.widget.LockPatternView.b
        public void onPatternCellAdded(List<LockPatternView.a> list) {
        }
    }

    /* loaded from: classes3.dex */
    class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PatternLockActivity.this.Eh();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public class d extends e {

        /* renamed from: b, reason: collision with root package name */
        private String f41344b;

        /* renamed from: a, reason: collision with root package name */
        private int f41343a = 1;

        /* renamed from: c, reason: collision with root package name */
        private boolean f41345c = false;

        /* renamed from: d, reason: collision with root package name */
        private boolean f41346d = false;

        /* renamed from: e, reason: collision with root package name */
        protected int f41347e = R.string.g9s;

        protected d() {
        }

        @Override // com.qwallet.activity.patternlock.PatternLockActivity.e
        public void a() {
            this.f41345c = PatternLockActivity.this.getIntent().getBooleanExtra("is_first_create_patternlock", false);
            this.f41346d = PatternLockActivity.this.getIntent().getBooleanExtra("is_from_create_patternlock", false);
            if (PatternLockActivity.this.getIntent().getBooleanExtra("is_for_revising_pwd", false)) {
                this.f41347e = R.string.g_2;
            }
        }

        @Override // com.qwallet.activity.patternlock.PatternLockActivity.e
        public void b() {
            PatternLockActivity.this.W.setText(R.string.g_5);
            PatternLockActivity.this.X.setVisibility(8);
        }

        @Override // com.qwallet.activity.patternlock.PatternLockActivity.e
        public void c(int i3, boolean z16, boolean z17, Object obj) {
            boolean z18;
            if (i3 != 2) {
                return;
            }
            QWalletPayProgressDialog qWalletPayProgressDialog = PatternLockActivity.this.f41319c0;
            if (qWalletPayProgressDialog != null && qWalletPayProgressDialog.isShowing()) {
                PatternLockActivity.this.f41319c0.dismiss();
            }
            if (z16 && obj != null && (obj instanceof SetPasswordRsp) && ((SetPasswordRsp) obj).ret == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                QQToast.makeText(PatternLockActivity.this.getContext(), this.f41347e, 0).show(PropertyUtils.getTitleBarHeight(PatternLockActivity.this.getOutActivity()));
                PatternLockUtils.setPWD(PatternLockActivity.this.getContext(), QWalletUtils.h(), PatternLockUtils.encodeToLocalPWD(PatternLockActivity.this.getContext(), QWalletUtils.h(), this.f41344b));
                PatternLockUtils.setPWDType(PatternLockActivity.this.getContext(), QWalletUtils.h(), 0);
                PatternLockUtils.setFirstCreatePatternLock(PatternLockActivity.this.getContext(), QWalletUtils.h(), false);
                PatternLockUtils.setUnlockFailedTimes(PatternLockActivity.this.getContext(), QWalletUtils.h(), 0);
                PatternLockActivity.this.setResult(-1);
                if (this.f41346d) {
                    com.tencent.mobileqq.qwallet.c.e("shousipwd.open", "", "", "", "");
                }
                if (this.f41345c) {
                    PatternLockActivity.this.Dh();
                    return;
                } else {
                    PatternLockActivity.this.Ch();
                    return;
                }
            }
            QQToast.makeText(PatternLockActivity.this.getContext(), R.string.g9z, 0).show(PropertyUtils.getTitleBarHeight(PatternLockActivity.this.getOutActivity()));
            PatternLockActivity.this.setResult(0);
            PatternLockActivity.this.Ch();
        }

        /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x00c1  */
        @Override // com.qwallet.activity.patternlock.PatternLockActivity.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void d(List<LockPatternView.a> list) {
            boolean z16;
            String Fh;
            String str;
            int i3 = this.f41343a;
            boolean z17 = false;
            if (i3 == 1) {
                if (list != null && list.size() >= 4) {
                    this.f41344b = PatternLockActivity.Fh(list);
                    PatternLockActivity.this.W.setText(R.string.g_4);
                    this.f41343a = 2;
                } else {
                    QQToast.makeText(PatternLockActivity.this.getContext(), R.string.g_1, 0).show(PropertyUtils.getTitleBarHeight(PatternLockActivity.this.getOutActivity()));
                }
            } else {
                if (i3 == 2) {
                    if (list != null && list.size() >= 4 && (Fh = PatternLockActivity.Fh(list)) != null && (str = this.f41344b) != null && Fh.equals(str)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        QQToast.makeText(PatternLockActivity.this.getContext(), R.string.bhw, 0).show(PropertyUtils.getTitleBarHeight(PatternLockActivity.this.getOutActivity()));
                    } else {
                        if (!NetworkUtil.isNetSupport(PatternLockActivity.this.getOutActivity())) {
                            QQToast.makeText(PatternLockActivity.this.getOutActivity(), R.string.b3j, 0).show(PropertyUtils.getToastOffset(PatternLockActivity.this.getOutActivity()));
                            PatternLockActivity.this.setResult(0);
                            PatternLockActivity.this.Ch();
                            return;
                        }
                        PatternLockActivity patternLockActivity = PatternLockActivity.this;
                        patternLockActivity.Hh(PatternLockUtils.encodeToServerPWD(patternLockActivity.getContext(), QWalletUtils.h(), this.f41344b));
                    }
                }
                if (!z17) {
                    PatternLockActivity.this.Bh();
                    return;
                }
                return;
            }
            z17 = true;
            if (!z17) {
            }
        }

        @Override // com.qwallet.activity.patternlock.PatternLockActivity.e
        public void e(View view) {
        }
    }
}

package com.tencent.mobileqq.qqexpand.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.avbiz.Constants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil;
import com.tencent.mobileqq.qqexpand.manager.c;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.widget.MatchingView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExtendFriendVoiceMatchLoadingFragment extends PublicBaseFragment implements c.e, View.OnClickListener {
    protected QQCustomDialog C;
    private AnimatorSet D;
    private MatchingView E;
    private BaseActivity F;
    private ViewGroup G;
    private com.tencent.mobileqq.qqexpand.manager.c H;
    private f I;
    private vg2.f K;
    private long M;
    private QQAppInterface N;
    private final int J = 2;
    private int L = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            ExtendFriendVoiceMatchLoadingFragment.this.F.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ExtendFriendVoiceMatchLoadingFragment.this.Ah();
            ExtendFriendVoiceMatchLoadingFragment.this.F.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ExtendFriendVoiceMatchLoadingFragment extendFriendVoiceMatchLoadingFragment = ExtendFriendVoiceMatchLoadingFragment.this;
            extendFriendVoiceMatchLoadingFragment.Dh(extendFriendVoiceMatchLoadingFragment.K);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            ExtendFriendVoiceMatchLoadingFragment.this.F.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MatchingView f263781d;

        e(MatchingView matchingView) {
            this.f263781d = matchingView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f263781d.k();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f263781d.setVisibility(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class f extends Handler {

        /* renamed from: b, reason: collision with root package name */
        public static int f263783b = 1;

        /* renamed from: c, reason: collision with root package name */
        public static int f263784c = 2;

        /* renamed from: d, reason: collision with root package name */
        public static int f263785d = 4;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<ExtendFriendVoiceMatchLoadingFragment> f263786a;

        public f(ExtendFriendVoiceMatchLoadingFragment extendFriendVoiceMatchLoadingFragment) {
            this.f263786a = new WeakReference<>(extendFriendVoiceMatchLoadingFragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ExtendFriendVoiceMatchLoadingFragment extendFriendVoiceMatchLoadingFragment;
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 == f263785d) {
                ExtendFriendVoiceMatchLoadingFragment extendFriendVoiceMatchLoadingFragment2 = this.f263786a.get();
                if (extendFriendVoiceMatchLoadingFragment2 != null) {
                    extendFriendVoiceMatchLoadingFragment2.zh();
                    return;
                }
                return;
            }
            if (i3 == f263783b) {
                ExtendFriendVoiceMatchLoadingFragment extendFriendVoiceMatchLoadingFragment3 = this.f263786a.get();
                if (extendFriendVoiceMatchLoadingFragment3 != null) {
                    QLog.e("ExtendFriendVoiceMatchLoadingFragment", 1, "limitchat matching time out from ui");
                    extendFriendVoiceMatchLoadingFragment3.Fh(true);
                    return;
                }
                return;
            }
            if (i3 != f263784c || (extendFriendVoiceMatchLoadingFragment = this.f263786a.get()) == null) {
                return;
            }
            extendFriendVoiceMatchLoadingFragment.Gh();
            BaseActivity baseActivity = extendFriendVoiceMatchLoadingFragment.getBaseActivity();
            if (baseActivity != null) {
                baseActivity.finish();
            }
        }
    }

    private void Bh(String str) {
        BaseActivity baseActivity;
        if (this.C == null && (baseActivity = this.F) != null && this.N != null) {
            this.C = DialogUtil.createCustomDialog(baseActivity, 230).setMessage(str).setPositiveButton(this.F.getString(R.string.fiw), new c()).setNegativeButton(this.F.getString(R.string.fiv), new b());
        }
        try {
            QQCustomDialog qQCustomDialog = this.C;
            if (qQCustomDialog == null || qQCustomDialog.isShowing()) {
                return;
            }
            this.C.show();
        } catch (Throwable th5) {
            QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, "match fail dialog error:" + th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh(vg2.f fVar) {
        if (this.H.t() == 2) {
            QLog.i("ExtendFriendVoiceMatchLoadingFragment", 2, "startMatching IN STATE_MATCHING return");
            return;
        }
        if (!NetworkUtil.isNetSupportHw(BaseApplication.getContext())) {
            xh(this.F.getString(R.string.f171498fj1), false);
            return;
        }
        this.H.m(2);
        int t16 = this.H.t();
        if (t16 == 0) {
            this.M = System.currentTimeMillis();
            this.H.x(fVar);
            f fVar2 = this.I;
            if (fVar2 != null) {
                fVar2.sendEmptyMessageDelayed(f.f263783b, 35000L);
            }
            wh();
            return;
        }
        QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, "startMatching IN STATE_MATCHING return : " + t16);
    }

    private void Eh() {
        this.E.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fh(boolean z16) {
        f fVar = this.I;
        if (fVar != null) {
            fVar.removeMessages(f.f263783b);
        }
        int t16 = this.H.t();
        Gh();
        if (t16 == 2) {
            this.H.l();
            if (z16) {
                Bh(this.F.getString(R.string.fiz));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gh() {
        this.E.l();
    }

    private void wh() {
        MatchingView matchingView = this.E;
        if (matchingView != null) {
            matchingView.j("# \u8bed\u97f3\u8fde\u9ea6");
        }
        Ch(this.E, (ImageView) this.G.findViewById(R.id.p0b));
    }

    private void xh(String str, boolean z16) {
        BaseActivity baseActivity = this.F;
        if (baseActivity == null || baseActivity.isFinishing()) {
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.F, 230);
        if (createCustomDialog != null) {
            String string = this.F.getString(R.string.f198674nc);
            if (z16) {
                TextView messageTextView = createCustomDialog.getMessageTextView();
                if (messageTextView != null) {
                    messageTextView.setGravity(17);
                }
                createCustomDialog.setTitle(R.string.f198864nv);
                string = this.F.getString(R.string.f198664nb);
            }
            createCustomDialog.setMessage(str);
            createCustomDialog.setPositiveButton(string, new d());
            try {
                createCustomDialog.show();
            } catch (Throwable th5) {
                QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, "match handleFailAndQuitDialog error:" + th5);
            }
        }
        AnimatorSet animatorSet = this.D;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.D.end();
        }
        Ah();
    }

    private void yh() {
        if (QLog.isColorLevel()) {
            QLog.d("ExtendFriendVoiceMatchLoadingFragment", 2, "handleOutOfMatchCountResult");
        }
        Gh();
        BaseActivity baseActivity = this.F;
        if (baseActivity != null && !baseActivity.isFinishing()) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.F, 230);
            if (createCustomDialog != null) {
                String string = this.F.getString(R.string.f198664nb);
                createCustomDialog.setMessage(this.F.getString(R.string.f198714ng));
                createCustomDialog.setPositiveButton(string, new a());
                try {
                    createCustomDialog.show();
                } catch (Throwable th5) {
                    QLog.e("ExtendFriendVoiceMatchLoadingFragment", 1, "match handleOutOfMatchCountResult error:" + th5);
                }
            }
            AnimatorSet animatorSet = this.D;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.D.end();
            }
            Ah();
            return;
        }
        QLog.d("ExtendFriendVoiceMatchLoadingFragment", 1, "handleOutOfMatchCountResult return");
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        LiuHaiUtils.initLiuHaiProperty(activity);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        this.F.finish();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.f163230p04) {
            return;
        }
        onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseActivity baseActivity = getBaseActivity();
        this.F = baseActivity;
        QQAppInterface qQAppInterface = (QQAppInterface) baseActivity.getAppInterface();
        this.N = qQAppInterface;
        if (qQAppInterface == null) {
            QLog.w("ExtendFriendVoiceMatchLoadingFragment", 1, "can't find app!!");
            this.N = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        }
        com.tencent.mobileqq.qqexpand.manager.c cVar = (com.tencent.mobileqq.qqexpand.manager.c) this.N.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
        this.H = cVar;
        cVar.z(this);
        this.I = new f(this);
        Intent intent = this.F.getIntent();
        if (intent != null) {
            this.L = intent.getIntExtra("intent_sex_key", 0);
        }
        com.tencent.mobileqq.qqexpand.manager.c.A(this.N, this.L);
        vg2.f fVar = new vg2.f();
        this.K = fVar;
        fVar.f441618a = 10000;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        f fVar = this.I;
        if (fVar != null) {
            fVar.removeMessages(f.f263783b);
            this.I.removeMessages(f.f263784c);
        }
        ReportController.o(this.N, "dc00898", "", "", "qq_kuolie", "0X800AA93", 0, 0, "", "", Constants.Business.MATCH_FRIEND, "");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Fh(false);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#match_page#view", true, -1L, -1L, null, true, true);
        Ah();
        Eh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh() {
        Dh(this.K);
        ReportController.o(this.N, "dc00898", "", "", "0X800A68F", "0X800A68F", 3, this.L, "", "", "", "");
        HashMap hashMap = new HashMap();
        hashMap.put("frompage", String.valueOf(3));
        ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#chat_tab#match_btn", true, -1L, -1L, hashMap, true, true);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.f167378d03, (ViewGroup) null);
        this.G = viewGroup2;
        this.E = (MatchingView) viewGroup2.findViewById(R.id.p0f);
        ((ImageView) this.G.findViewById(R.id.f163230p04)).setOnClickListener(this);
        View findViewById = this.G.findViewById(R.id.p0l);
        if (findViewById != null) {
            if (ThemeUtil.isInNightMode(this.N)) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
        }
        if (LiuHaiUtils.isLiuHaiUseValid()) {
            RelativeLayout relativeLayout = (RelativeLayout) this.G.findViewById(R.id.p1u);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.topMargin = LiuHaiUtils.sNotchHeight;
            relativeLayout.setLayoutParams(layoutParams);
        }
        f fVar = this.I;
        fVar.sendMessage(fVar.obtainMessage(f.f263785d));
        return this.G;
    }

    public void Ch(MatchingView matchingView, View view) {
        if (matchingView == null || view == null) {
            return;
        }
        if (this.D == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(matchingView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, 0.0f, 1.0f);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, 0.0f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            this.D = animatorSet;
            animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
            this.D.addListener(new e(matchingView));
        }
        this.D.start();
    }

    @Override // com.tencent.mobileqq.qqexpand.manager.c.e
    public void w8(int i3, vg2.d dVar, String str, String str2) {
        String str3;
        QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, "onMatchResult result" + i3);
        f fVar = this.I;
        if (fVar != null) {
            fVar.removeMessages(f.f263783b);
        }
        if (i3 == 0 && dVar != null) {
            LimitChatUtil.n(this.F, dVar, str, this.L, 10000, 2);
            Gh();
            ReportController.o(null, "dc00898", "", dVar.f441607c, "0X80096A6", "0X80096A6", 2, 0, "", "", "", "");
            HashMap hashMap = new HashMap();
            hashMap.put("duration", String.valueOf((System.currentTimeMillis() - this.M) / 1000));
            hashMap.put("to_uid", dVar.f441607c);
            hashMap.put("match_type", "1");
            hashMap.put("source_id", String.valueOf(dVar.f441613i));
            hashMap.put("choose_condition", String.valueOf(this.L + 1));
            ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("success#match_page#match_inline", true, -1L, -1L, hashMap, true, true);
            QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, "before finish on success");
            this.F.finish();
            QLog.e("ExtendFriendVoiceMatchLoadingFragment", 2, "after finish on success");
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("failed_reason", str2);
        hashMap2.put("match_type", "1");
        ((IExpandReportUtils) QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("failed#match_page#match_inline", true, -1L, -1L, hashMap2, true, true);
        if (i3 == 7) {
            Gh();
            com.tencent.mobileqq.qqexpand.manager.e eVar = (com.tencent.mobileqq.qqexpand.manager.e) this.N.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
            if (TextUtils.isEmpty(str2)) {
                str3 = eVar.Y();
                if (TextUtils.isEmpty(str3)) {
                    str3 = this.F.getString(R.string.ixe);
                }
            } else {
                str3 = str2;
            }
            xh(str3, false);
            return;
        }
        if (i3 == 2) {
            Gh();
            Bh(TextUtils.isEmpty(str2) ? this.F.getString(R.string.fiz) : str2);
            return;
        }
        if (i3 == 8) {
            Gh();
            xh(TextUtils.isEmpty(str2) ? this.F.getString(R.string.f198854nu) : str2, true);
            return;
        }
        if (i3 == 9) {
            yh();
            return;
        }
        if (i3 == 13) {
            Gh();
            AnimatorSet animatorSet = this.D;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.D.end();
            }
            Ah();
            return;
        }
        Gh();
        xh(TextUtils.isEmpty(str2) ? this.F.getString(R.string.f171499fj2) : str2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ah() {
    }
}

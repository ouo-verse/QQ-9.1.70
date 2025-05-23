package com.qzone.common.activities.base;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneFragmentHolderActivity extends BaseActivityForFragmentV2 implements com.qzone.common.activities.titlebuilder.f, IObserver.main {

    /* renamed from: a0, reason: collision with root package name */
    BaseFragment f45376a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f45377b0 = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements ha1.a {
        a() {
        }

        @Override // ha1.a
        public void onColorNoteAnimFinish() {
            QZoneFragmentHolderActivity.super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements com.tencent.mobileqq.colornote.swipe.a {
        b() {
        }

        @Override // com.tencent.mobileqq.colornote.swipe.a
        public void a() {
            QLog.d("QZoneFragmentHolderActivity", 1, "onPageSwipeNotClose");
        }

        @Override // com.tencent.mobileqq.colornote.swipe.a
        public void onPageSwipeClose() {
            QLog.d("QZoneFragmentHolderActivity", 1, "onPageSwipeClose");
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class c extends BaseFragmentContainerImp {
        public c(BaseFragment baseFragment) {
            super(baseFragment);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface d {
        void a(MiniMsgUser miniMsgUser);

        boolean b();

        void c(MiniMsgUser miniMsgUser);
    }

    private void R2() {
        ActivityResultCaller activityResultCaller = this.f45376a0;
        if ((activityResultCaller instanceof d) && ((d) activityResultCaller).b()) {
            EventCenter.getInstance().addUIObserver(this, "MiniAIO", 1, 2);
        }
    }

    private void S2() {
        if (supportColorNote()) {
            IColorNoteController iColorNoteController = (IColorNoteController) QRoute.api(IColorNoteController.class);
            this.mColorNoteController = iColorNoteController;
            iColorNoteController.init(this, true, false, null, true, true, R.color.f156954am1);
            this.mColorNoteController.attachToActivity(this);
            this.mColorNoteController.setServiceInfo(this);
            this.mColorNoteController.setOnColorNoteAnimFinishListener(new a());
            this.mColorNoteController.setOnPageSwipeListener(new b());
        }
    }

    private void T2(String str) {
        int a16 = bx.a(str);
        if (a16 == 1) {
            U2();
            setTheme(R.style.f173748jk);
            getWindow().setSoftInputMode(18);
            return;
        }
        if (a16 == 2) {
            setRequestedOrientation(-1);
            setTheme(R.style.f173578gg);
            getWindow().setSoftInputMode(18);
            return;
        }
        if (a16 == 3) {
            setRequestedOrientation(-1);
            setTheme(R.style.f173749jl);
            return;
        }
        if (a16 == 4) {
            U2();
            setTheme(R.style.f173748jk);
        } else if (a16 != 5) {
            U2();
            setTheme(R.style.f173578gg);
            getWindow().setSoftInputMode(35);
        } else {
            U2();
            setTheme(R.style.f173578gg);
            getWindow().setSoftInputMode(18);
        }
    }

    private String V2(Intent intent) {
        String stringExtra = intent.getStringExtra("KEY_FRAGMENT_NAME");
        return TextUtils.isEmpty(stringExtra) ? intent.getStringExtra("qzone_plugin_activity_name") : stringExtra;
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    public void IOnSetTheme() {
        BaseFragment baseFragment = this.f45376a0;
        if (baseFragment != null) {
            baseFragment.IOnSetTheme();
        } else {
            super.IOnSetTheme();
        }
    }

    public void U2() {
        if (AppSetting.o(getActivity())) {
            return;
        }
        setRequestedOrientation(1);
    }

    public boolean Y2(String str) {
        return TextUtils.equals(str, this.f45377b0);
    }

    @Override // com.qzone.common.activities.base.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IColorNoteController iColorNoteController = this.mColorNoteController;
        if (iColorNoteController != null) {
            iColorNoteController.exitAnimation();
        } else {
            super.finish();
        }
    }

    @Override // com.qzone.common.activities.base.BaseActivity, com.tencent.mobileqq.colornote.f
    public ColorNote getColorNote() {
        BaseFragment baseFragment = this.f45376a0;
        if (baseFragment != null) {
            return baseFragment.getColorNote();
        }
        return super.getColorNote();
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    protected int getFeedListBackgroundId() {
        BaseFragment baseFragment = this.f45376a0;
        if (baseFragment != null && baseFragment.getFeedListBackgroundId() != 0) {
            return this.f45376a0.getFeedListBackgroundId();
        }
        return super.getFeedListBackgroundId();
    }

    @Override // com.qzone.common.activities.base.BaseActivityForFragmentV2
    public int getMainFragmentId() {
        return android.R.id.content;
    }

    @Override // com.qzone.common.activities.titlebuilder.f
    public Handler getMainHandler() {
        return getHandler();
    }

    public BasePartFragment getQZoneBaseFragment() {
        return this.f45376a0;
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    public String getRMonitorTraceName() {
        return "";
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    public boolean isEnableNightMask() {
        BaseFragment baseFragment = this.f45376a0;
        if (baseFragment != null) {
            return baseFragment.isEnableNightMask();
        }
        return super.isEnableNightMask();
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    public boolean needCheckCreditLevel() {
        BaseFragment baseFragment = this.f45376a0;
        if (baseFragment != null) {
            return baseFragment.needCheckCreditLevel();
        }
        return super.needCheckCreditLevel();
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    public boolean needMiniAIO() {
        BaseFragment baseFragment = this.f45376a0;
        if (baseFragment != null) {
            return baseFragment.needMiniAIO();
        }
        return super.needMiniAIO();
    }

    @Override // com.qzone.common.activities.base.BaseActivityForFragmentV2, com.qzone.common.activities.base.BaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.qzone.reborn.util.f.f59544a.b(this, bundle);
        super.onCreate(bundle);
        this.f45377b0 = V2(getIntent());
        QLog.d("QZoneFragmentHolderActivity", 1, "onCreate, mFragmentName: " + this.f45377b0);
        if (TextUtils.isEmpty(this.f45377b0)) {
            w5.b.g("QZoneFragmentHolderActivity", 1, "QZoneFragmentHolderActivity error, fragment name is empty");
            finish();
        } else {
            T2(this.f45377b0);
            W2(bundle, this.f45377b0);
            S2();
            R2();
        }
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        MiniMsgUser miniMsgUser = this.mMiniMsgUser;
        if (miniMsgUser == null) {
            return;
        }
        int i3 = event.what;
        if (i3 == 1) {
            ActivityResultCaller activityResultCaller = this.f45376a0;
            if (activityResultCaller instanceof d) {
                ((d) activityResultCaller).c(miniMsgUser);
                return;
            }
            return;
        }
        if (i3 != 2) {
            return;
        }
        ActivityResultCaller activityResultCaller2 = this.f45376a0;
        if (activityResultCaller2 instanceof d) {
            ((d) activityResultCaller2).a(miniMsgUser);
        }
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    protected boolean shouldReportUsage() {
        return false;
    }

    @Override // com.qzone.common.activities.base.BaseActivity
    protected boolean supportColorNote() {
        BaseFragment baseFragment = this.f45376a0;
        if (baseFragment != null) {
            return baseFragment.supportColorNote();
        }
        return super.supportColorNote();
    }

    private void W2(Bundle bundle, String str) {
        if (bundle != null) {
            this.f45376a0 = (BaseFragment) getSupportFragmentManager().findFragmentByTag(str);
        }
        if (this.f45376a0 == null) {
            BaseFragment a16 = bw.a(str);
            this.f45376a0 = a16;
            if (a16 != null) {
                if (getIntent() != null && getIntent().getExtras() != null) {
                    this.f45376a0.setArguments(getIntent().getExtras());
                }
                BaseFragment baseFragment = this.f45376a0;
                baseFragment.setContainerInf(new c(baseFragment));
                this.f45376a0.setFragmentName(str);
                getSupportFragmentManager().beginTransaction().add(android.R.id.content, this.f45376a0, str).commit();
                return;
            }
            w5.b.g("QZoneFragmentHolderActivity", 1, "baseFragment is null, ensure fragment name" + str);
        }
    }

    @Override // com.qzone.common.activities.titlebuilder.f
    public ViewGroup Kd() {
        return (ViewGroup) findViewById(R.id.jqh);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("KEY_FRAGMENT_NAME");
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.equals(this.f45377b0, stringExtra)) {
            intent.setComponent(new ComponentName(this, ak.k(stringExtra)));
            intent.putExtra("KEY_FRAGMENT_NAME", stringExtra);
            intent.setFlags(268435456);
            startActivity(intent);
            return;
        }
        super.onNewIntent(intent);
    }
}

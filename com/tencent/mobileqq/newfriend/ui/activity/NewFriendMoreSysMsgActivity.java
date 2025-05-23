package com.tencent.mobileqq.newfriend.ui.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.GestureActivityModule;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NewFriendMoreSysMsgActivity extends QBaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private NewFriendMoreSysMsgAdapter f254059a0;

    /* renamed from: b0, reason: collision with root package name */
    private QUISecNavBar f254060b0;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Function2<View, BaseAction, Unit> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewFriendMoreSysMsgActivity.this);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(View view, BaseAction baseAction) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) baseAction);
            }
            int i3 = b.f254062a[baseAction.ordinal()];
            if (i3 != 1) {
                if (i3 == 2 && NewFriendMoreSysMsgActivity.this.f254059a0 != null) {
                    NewFriendMoreSysMsgActivity.this.f254059a0.i();
                    return null;
                }
                return null;
            }
            NewFriendMoreSysMsgActivity.this.finish();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f254062a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29184);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[BaseAction.values().length];
            f254062a = iArr;
            try {
                iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f254062a[BaseAction.ACTION_RIGHT_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public NewFriendMoreSysMsgActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void startNewFriendMoreSysMsgActivityForResult(Activity activity, int i3, int i16) {
        Intent intent = new Intent(activity, (Class<?>) NewFriendMoreSysMsgActivity.class);
        intent.putExtra("first_visible_index", i16);
        activity.startActivityForResult(intent, i3);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    @TargetApi(14)
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        int intExtra = getIntent().getIntExtra("first_visible_index", 0);
        setContentView(R.layout.ayk);
        SwipListView swipListView = (SwipListView) findViewById(R.id.j9u);
        View findViewById = findViewById(R.id.f_a);
        QUISecNavBar qUISecNavBar = (QUISecNavBar) findViewById(R.id.zpr);
        this.f254060b0 = qUISecNavBar;
        qUISecNavBar.setOnBaseTitleBarClickListener(new a());
        this.f254060b0.R(this);
        this.f254059a0 = new NewFriendMoreSysMsgAdapter(this, (AppInterface) getAppRuntime(), swipListView, findViewById, null, GestureActivityModule.getFlingHandler(this), intExtra);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnDestroy();
        NewFriendServiceImpl newFriendServiceImpl = (NewFriendServiceImpl) getAppRuntime().getRuntimeService(INewFriendService.class, "");
        newFriendServiceImpl.markSystemMsgReaded();
        newFriendServiceImpl.clearAllSysSuspiciousCache();
        this.f254059a0.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.doOnResume();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}

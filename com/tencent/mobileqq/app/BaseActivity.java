package com.tencent.mobileqq.app;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
@Deprecated
/* loaded from: classes11.dex */
public class BaseActivity extends QBaseActivity {
    static IPatchRedirector $redirector_ = null;
    public static int CHAT_FRAGMENT_TYPE = 0;
    public static int GUILD_ARTICLE_MSG_DETAIL_TYPE = 0;
    public static int GUILD_TOP_MSG_LIST_TYPE = 0;
    public static final String TAG = "qqBaseActivity";
    public static BaseActivity sTopActivity;
    public QQAppInterface app;
    private int chatFragmentType;
    private String className;
    QBaseFragment.IFragmentAttachCallback mIFragmentAttachCallback;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69577);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
            return;
        }
        CHAT_FRAGMENT_TYPE = 1;
        GUILD_ARTICLE_MSG_DETAIL_TYPE = 4;
        GUILD_TOP_MSG_LIST_TYPE = 5;
    }

    public BaseActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.className = getClass().getSimpleName();
            this.chatFragmentType = CHAT_FRAGMENT_TYPE;
        }
    }

    private ChatFragment getGuildArticleMsgChatFragmentByTagName(String str) {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments.isEmpty()) {
            return null;
        }
        return (ChatFragment) fragments.get(0).getChildFragmentManager().findFragmentByTag(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void beforeDoOnCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.beforeDoOnCreate();
            updateAppRuntime();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            super.doOnBackPressed();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) configuration);
        } else {
            super.doOnConfigurationChanged(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        return super.doOnCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.doOnDestroy();
        if (sTopActivity == this) {
            sTopActivity = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
        } else {
            super.doOnNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.doOnPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    @TargetApi(9)
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.doOnResume();
            sTopActivity = this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.doOnStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.doOnStop();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public String getActivityName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.className;
    }

    public AppInterface getAppInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (AppInterface) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime instanceof AppInterface) {
            return (AppInterface) appRuntime;
        }
        return null;
    }

    @Nullable
    public ChatFragment getChatFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (ChatFragment) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        String name = ChatFragment.class.getName();
        int i3 = this.chatFragmentType;
        if (i3 == GUILD_TOP_MSG_LIST_TYPE) {
            return getGuildArticleMsgChatFragmentByTagName(((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getGuildTopMsgListChatFragmentClassName());
        }
        if (i3 == GUILD_ARTICLE_MSG_DETAIL_TYPE) {
            return getGuildArticleMsgChatFragmentByTagName(((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getGuildArticleMsgChatFragmentClassName());
        }
        if (i3 == CHAT_FRAGMENT_TYPE) {
            if (this instanceof SplashActivity) {
                name = ((SplashActivity) this).getChatFragmentTag();
            } else {
                name = ChatFragment.class.getName();
            }
        }
        QBaseFragment qBaseFragment = (QBaseFragment) getSupportFragmentManager().findFragmentByTag(name);
        if (qBaseFragment instanceof ChatFragment) {
            return (ChatFragment) qBaseFragment;
        }
        return null;
    }

    public int getChatFragmentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.chatFragmentType;
    }

    public String getCurrentAccountUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime == null) {
            return "";
        }
        if (appRuntime instanceof AppInterface) {
            return ((AppInterface) appRuntime).getCurrentAccountUin();
        }
        return appRuntime.getAccount();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public String getPreProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public int getTitleBarHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void onAccountChanged() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        super.onAccountChanged();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onAccountChanged ");
            if (getAppRuntime() == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("qqBaseActivity", 2, sb5.toString());
        }
        updateAppRuntime();
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    public void setChatFragmentType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        this.chatFragmentType = i3;
        QLog.i("qqBaseActivity", 1, "setChatFragmentType type=" + this.chatFragmentType);
    }

    public void setFragmentAttachListener(QBaseFragment.IFragmentAttachCallback iFragmentAttachCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) iFragmentAttachCallback);
        } else {
            this.mIFragmentAttachCallback = iFragmentAttachCallback;
        }
    }

    public void updateAppRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime instanceof QQAppInterface) {
            this.app = (QQAppInterface) appRuntime;
        }
        if (QLog.isColorLevel()) {
            QLog.i("qqBaseActivity", 4, "updateAppRuntime, " + appRuntime);
        }
    }
}

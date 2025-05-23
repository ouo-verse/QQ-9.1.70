package com.tencent.biz.lebasearch;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.IFunctionConfigManager;
import com.tencent.mobileqq.search.api.impl.FunctionConfigManagerImpl;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.QfavHelper;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes2.dex */
public class LebaSearchTransparentJumpActivity extends IphoneTitleBarActivity {

    /* renamed from: a0, reason: collision with root package name */
    public View f78619a0;

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (runtime instanceof QQAppInterface)) {
            this.app = (QQAppInterface) runtime;
        }
        this.f78619a0 = new View(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        FunctionConfigManagerImpl functionConfigManagerImpl = (FunctionConfigManagerImpl) this.app.getRuntimeService(IFunctionConfigManager.class, "all");
        if (functionConfigManagerImpl.resultModel != null) {
            functionConfigManagerImpl.resultModel = null;
        }
        if (functionConfigManagerImpl.templateBaseItem != null) {
            functionConfigManagerImpl.templateBaseItem = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        Intent intent = getIntent();
        int i3 = 0;
        int intExtra = intent.getIntExtra("key_business", 0);
        if (intExtra != 2) {
            if (intExtra != 3) {
                if (intExtra != 4) {
                    if (intExtra != 5) {
                        if (intExtra != 7) {
                            if (intExtra != 100) {
                                if (intExtra == 101) {
                                    ((FunctionConfigManagerImpl) this.app.getRuntimeService(IFunctionConfigManager.class, "all")).templateBaseItem.v(this.f78619a0);
                                }
                            } else {
                                String stringExtra = intent.getStringExtra("key_click_web_search_fts_key");
                                if (!TextUtils.isEmpty(stringExtra)) {
                                    try {
                                        i3 = Integer.valueOf(stringExtra.split("-")[1]).intValue();
                                    } catch (Exception unused) {
                                        if (QLog.isColorLevel()) {
                                            QLog.e("IphoneTitleBarActivity", 2, " local result idStr parse error!");
                                        }
                                    }
                                }
                                y yVar = ((FunctionConfigManagerImpl) this.app.getRuntimeService(IFunctionConfigManager.class, "all")).resultModel;
                                if (yVar != null) {
                                    this.f78619a0.setTag(R.id.kxc, Integer.valueOf(i3));
                                    yVar.v(this.f78619a0);
                                } else {
                                    QLog.d("kueenie", 2, "result model is null");
                                }
                            }
                        } else {
                            Intent intent2 = new Intent(this, (Class<?>) PhoneUnityBindInfoActivity.class);
                            intent2.putExtra("kSrouce", 18);
                            startActivity(intent2);
                        }
                    } else {
                        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                        try {
                            long longValue = Long.valueOf(this.app.getCurrentAccountUin()).longValue();
                            userInfo.qzone_uin = String.valueOf(longValue);
                            String currentNickname = this.app.getCurrentNickname();
                            if (TextUtils.isEmpty(currentNickname)) {
                                currentNickname = ac.f(this.app, String.valueOf(longValue));
                            }
                            userInfo.nickname = currentNickname;
                            QZoneHelper.forwardFromSearchToPersonalAlbum(this, userInfo, Long.valueOf(longValue), 0, false, -1);
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            return;
                        }
                    }
                } else {
                    intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, getString(R.string.button_back));
                    QfavHelper.i(this, this.app.getAccount(), intent, -1, false);
                }
            } else {
                Intent intent3 = new Intent();
                intent3.putExtra("force_refresh", true);
                intent3.putExtra("refer", QZoneHelper.QZoneAppConstants.REFER_SCHEME_ACTIVE_FEED);
                QzonePluginProxyActivity.setActivityNameToIntent(intent3, QZoneHelper.FRIEND_FEED);
                intent3.addFlags(805306368);
                QZoneHelper.forwardFromSearchToFriendFeed(this, this.app.getCurrentAccountUin(), intent3, -1);
            }
        } else {
            ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).launchQWalletAct(this, this.app, true, 6);
        }
        finish();
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}

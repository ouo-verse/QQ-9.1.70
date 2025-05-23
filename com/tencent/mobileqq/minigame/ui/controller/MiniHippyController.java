package com.tencent.mobileqq.minigame.ui.controller;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.mobileqq.minihippy.MiniHippyFragment;
import com.tencent.mobileqq.minihippy.MiniHippyWebViewFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.IUIProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy;
import com.tencent.util.URLUtil;
import d92.d;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniHippyController implements g92.a {
    private static final String HIPPY_FROM = "miniapp";
    private static final String KEY_SCHEME_H5 = "webUrl";
    public static final int POP_BACK_FROM_JS_HANDLE = 1;
    public static final int POP_BACK_FROM_MODULE_METHOD = 2;
    public static final int POP_BACK_FROM_NO_HANDLE = 0;
    public static final String TAG = "MiniHippyPart";
    private String appId;
    private String extInfo;
    private String extendData;
    private String firstPath;
    protected GameActivity1 mActivity;
    private final AtomicInteger mFragmentIndex = new AtomicInteger(0);
    private final IUIProxy mIUIProxy;
    private Fragment mRootFragment;

    public MiniHippyController(GameActivity1 gameActivity1, IUIProxy iUIProxy) {
        this.mActivity = gameActivity1;
        this.mIUIProxy = iUIProxy;
    }

    private void addRootFragment(Fragment fragment) {
        fragment.getArguments().putBoolean("minihippy_root", true);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.ckj, fragment);
        beginTransaction.commitAllowingStateLoss();
        this.mRootFragment = fragment;
    }

    private void addRootHippy(String str, String str2, String str3, String str4) {
        OpenHippyInfo a16 = d.a(str, str2, str3, str4);
        if (a16 == null) {
            finishWithError("get openHippyInfo null.");
            return;
        }
        a16.isEnbaleRightFling = false;
        a16.preloadType = TabPreloadItem.PreloadType.PRE_LOAD;
        a16.isAnimated = true;
        if (TextUtils.isEmpty(a16.from)) {
            a16.from = "miniapp";
        }
        MiniHippyFragment miniHippyFragment = new MiniHippyFragment();
        Intent intent = new Intent();
        intent.putExtra("params", a16.toBundle());
        miniHippyFragment.setArguments(intent.getExtras());
        miniHippyFragment.yh(this);
        addRootFragment(miniHippyFragment);
        ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).preloadPSKey(a16);
    }

    private boolean addRootWebView(String str) {
        String parseWebUrl = parseWebUrl(str);
        if (TextUtils.isEmpty(parseWebUrl)) {
            return false;
        }
        MiniHippyWebViewFragment qh5 = MiniHippyWebViewFragment.qh(parseWebUrl);
        qh5.rh(this);
        addRootFragment(qh5);
        return true;
    }

    private void finishWithError(String str) {
        QQToast.makeText(this.mActivity, 1, "\u52a0\u8f7d\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8fde\u63a5\u540e\u91cd\u8bd5", 0).show();
        this.mActivity.finish();
        QLog.e(TAG, 1, str);
    }

    private String getFragmentTag() {
        return "MiniHippy-" + this.mFragmentIndex.getAndIncrement();
    }

    private FragmentManager getSupportFragmentManager() {
        return this.mActivity.getSupportFragmentManager();
    }

    private Fragment getTopFragment() {
        Fragment findFragmentByTag;
        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        if (backStackEntryCount <= 0) {
            findFragmentByTag = this.mRootFragment;
        } else {
            findFragmentByTag = getSupportFragmentManager().findFragmentByTag(getSupportFragmentManager().getBackStackEntryAt(backStackEntryCount - 1).getName());
        }
        QLog.i(TAG, 2, "getTopFragment: count=" + backStackEntryCount + ", fragment=" + findFragmentByTag);
        return findFragmentByTag;
    }

    private void handleParamUrlChange(String str, String str2, String str3, String str4) {
        OpenHippyInfo a16 = d.a(this.appId, this.extInfo, this.extendData, this.firstPath);
        OpenHippyInfo a17 = d.a(str, str2, str3, str4);
        if (a16 == null || a17 == null) {
            return;
        }
        String str5 = a17.url;
        if ((str5 == null || str5.equals(a16.url)) ? false : true) {
            Fragment topFragment = getTopFragment();
            if (topFragment instanceof MiniHippyFragment) {
                ((MiniHippyFragment) topFragment).Bh(a17.url);
            }
        }
    }

    private void handleSchemeOnNewIntent(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.i(TAG, 1, "doOnNewIntent: scheme is null.");
            return;
        }
        if (isWebUrl(str)) {
            String parseWebUrl = parseWebUrl(str);
            if (TextUtils.isEmpty(parseWebUrl)) {
                return;
            }
            openUrl(parseWebUrl);
            return;
        }
        Fragment topFragment = getTopFragment();
        if (topFragment instanceof MiniHippyFragment) {
            ((MiniHippyFragment) topFragment).Ah(str);
        }
    }

    private String parseWebUrl(String str) {
        try {
            return new JSONObject(str).optString(KEY_SCHEME_H5);
        } catch (JSONException unused) {
            QLog.e(TAG, 1, "parseWebUrl: webUrlJson parse failed. extendData=" + str);
            return null;
        }
    }

    private boolean popHippyFragment() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        int backStackEntryCount = supportFragmentManager.getBackStackEntryCount();
        QLog.i(TAG, 2, "onBackEvent: fragment backStackCount= " + backStackEntryCount);
        if (backStackEntryCount <= 0) {
            return false;
        }
        supportFragmentManager.popBackStack();
        return true;
    }

    private void pushFragment(Fragment fragment) {
        String fragmentTag = getFragmentTag();
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.f154476ii, 0, 0, R.anim.f154480ae).add(R.id.ckj, fragment, fragmentTag).addToBackStack(fragmentTag).commitAllowingStateLoss();
    }

    private void pushHippyFragment(OpenHippyInfo openHippyInfo) {
        QLog.d(TAG, 2, "pushHippy: bundleName=" + openHippyInfo.bundleName);
        if (TextUtils.isEmpty(openHippyInfo.from)) {
            openHippyInfo.from = "miniapp";
        }
        MiniHippyFragment miniHippyFragment = new MiniHippyFragment();
        Intent intent = new Intent();
        intent.putExtra("params", openHippyInfo.toBundle());
        miniHippyFragment.setArguments(intent.getExtras());
        miniHippyFragment.yh(this);
        pushFragment(miniHippyFragment);
    }

    public void backToHome() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        int backStackEntryCount = supportFragmentManager.getBackStackEntryCount();
        for (int i3 = 0; i3 < backStackEntryCount; i3++) {
            supportFragmentManager.popBackStack();
        }
        QLog.i(TAG, 1, "left size = " + supportFragmentManager.getFragments().size());
        this.extendData = null;
        addRootHippy(this.appId, this.extInfo, null, this.firstPath);
    }

    public String getAppId() {
        return this.appId;
    }

    @Override // g92.a
    public void handleRestart(ViewGroup viewGroup, String str, String str2, String str3, String str4) {
        backToHome();
    }

    @Override // g92.a
    public void initView(ViewGroup viewGroup, String str, String str2, String str3, String str4) {
        if (isWebUrl(str3) && addRootWebView(str3)) {
            return;
        }
        addRootHippy(str, str2, str3, str4);
    }

    @Override // g92.a
    public void onBackPressed() {
        Fragment topFragment = getTopFragment();
        if ((topFragment instanceof MiniHippyFragment) && ((MiniHippyFragment) topFragment).onBackEvent(new HippyEngine.BackPressHandler() { // from class: com.tencent.mobileqq.minigame.ui.controller.a
            @Override // com.tencent.mtt.hippy.HippyEngine.BackPressHandler
            public final void handleBackPress() {
                MiniHippyController.this.lambda$onBackPressed$0();
            }
        })) {
            QLog.i(TAG, 2, "[doOnBackPressed] handle back event by js");
        } else {
            popOrBackFragment(0);
        }
    }

    @Override // g92.a
    public void onCreate(Bundle bundle, String str, String str2, String str3, String str4) {
        this.appId = str;
        this.extInfo = str2;
        this.extendData = str3;
        this.firstPath = str4;
    }

    public void onHippyLoadFinish() {
        if (this.mIUIProxy != null) {
            Intent intent = new Intent();
            intent.setAction(ThirdPartyMiniPageProxy.ACTION_HIPPY_LOAD_SUCCESS);
            this.mIUIProxy.onIntentUpdate(intent);
        }
    }

    @Override // g92.a
    public void onNewIntent(String str, String str2, String str3, String str4) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "[doOnNewIntent] appInfo:" + str2);
        }
        handleSchemeOnNewIntent(str3);
        handleQueryOnNewIntent(str4);
        handleParamUrlChange(str, str2, str3, str4);
    }

    @Override // g92.a
    public void openUrl(String str) {
        String addParameterWithoutEncode = URLUtil.addParameterWithoutEncode(str, "isInMiniApp", "1");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "openUrl: url=" + addParameterWithoutEncode);
        }
        MiniHippyWebViewFragment qh5 = MiniHippyWebViewFragment.qh(addParameterWithoutEncode);
        qh5.rh(this);
        pushFragment(qh5);
    }

    public boolean popOrBackFragment(int i3) {
        QLog.i(TAG, 2, "[popOrBackFragment] from:" + i3);
        if (popHippyFragment()) {
            return true;
        }
        if (this.mActivity.moveTaskToBack(true)) {
            return false;
        }
        this.mActivity.finish();
        return true;
    }

    public void pushMiniHippy(Intent intent) {
        Bundle bundle;
        Bundle extras = intent.getExtras();
        if (extras == null || (bundle = extras.getBundle("params")) == null) {
            return;
        }
        pushHippyFragment(new OpenHippyInfo(bundle));
    }

    @Override // g92.a
    public void updateView(ViewGroup viewGroup, String str, String str2, String str3, String str4) {
        addRootHippy(str, str2, str3, str4);
    }

    private void handleQueryOnNewIntent(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[handleQueryOnNewIntent] pagePath:" + str);
            }
            Fragment topFragment = getTopFragment();
            if (topFragment instanceof MiniHippyFragment) {
                ((MiniHippyFragment) topFragment).zh(str);
                return;
            }
            return;
        }
        QLog.i(TAG, 2, "[handleQueryOnNewIntent] pagePath is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBackPressed$0() {
        popOrBackFragment(1);
    }

    private boolean isWebUrl(String str) {
        return str != null && str.contains(KEY_SCHEME_H5);
    }

    @Override // g92.a
    public void onDestroy() {
    }

    @Override // g92.a
    public void onPause() {
    }

    @Override // g92.a
    public void onResume() {
    }

    @Override // g92.a
    public void onStart() {
    }

    @Override // g92.a
    public void onStop() {
    }

    @Override // g92.a
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // g92.a
    public void onActivityResult(int i3, int i16, Intent intent) {
    }
}

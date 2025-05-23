package com.tencent.mobileqq.gamecenter.qa.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyService;
import com.tencent.mobileqq.gamecenter.qa.data.GameStrategyAuthRequire;
import com.tencent.mobileqq.gamecenter.qa.data.GameStrategyChannelEntry;
import com.tencent.mobileqq.gamecenter.qa.data.InviteData;
import com.tencent.mobileqq.gamecenter.qa.fragment.QQGameStrategyAnswerDialog;
import com.tencent.mobileqq.gamecenter.qa.fragment.QQGameStrategyAnswerFragment;
import com.tencent.mobileqq.gamecenter.qa.fragment.QQGameStrategyArticleFragment;
import com.tencent.mobileqq.gamecenter.qa.fragment.QQGameStrategyAuthDialogFragment;
import com.tencent.mobileqq.gamecenter.qa.fragment.QQGameStrategyQuestionDialog;
import com.tencent.mobileqq.gamecenter.qa.fragment.QQGameStrategyQuestionFragment;
import com.tencent.mobileqq.gamecenter.qa.fragment.QQGameTransparentFragment;
import com.tencent.mobileqq.gamecenter.qa.jumpaction.e;
import com.tencent.mobileqq.gamecenter.qa.manager.GameStrategyDraftHandler;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.mobileqq.gamecenter.qa.view.QQGameStrategyAtDialog;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.u;
import com.tencent.mobileqq.webviewplugin.r;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import ud1.GameRankConfig;
import ud1.c;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGameStrategyApiImpl implements IQQGameStrategyApi {
    private static final String FRAGMENT_ANSWER_TAG = "QQGameStrategyAnswerDialog";
    private static final String FRAGMENT_AT_TAG = "openGameStrategyAtDialog";
    private static final String FRAGMENT_AUTH_TAG = "openGameStrategyAuthDialog";
    private static final String FRAGMENT_QUESTION_TAG = "QQGameStrategyQuestionDialog";
    private static final long JS_BUNDLE_PRELOAD_DELAY = 2000;
    private static final String QA_LINK_URL_PREFIX = "https://youxi.gamecenter.qq.com";
    private static final String TAG = "QQGameStrategyApiImpl";

    private static r getWebUiMethodInterface(QQBrowserActivity qQBrowserActivity) {
        List<Fragment> fragments;
        FragmentManager supportFragmentManager = qQBrowserActivity.getSupportFragmentManager();
        if (supportFragmentManager != null && (fragments = supportFragmentManager.getFragments()) != null && fragments.size() > 0) {
            int i3 = qQBrowserActivity.currentTabIndex;
            if (i3 < 0 || i3 >= fragments.size()) {
                i3 = 0;
            }
            if (fragments.get(i3) instanceof WebViewFragment) {
                return (WebViewFragment) fragments.get(i3);
            }
            QLog.e(TAG, 2, "cast Fragment (index: " + i3 + ") is null!");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$answerQuestion$0(vd1.b bVar, QBaseActivity qBaseActivity, int i3, long j3, String str, boolean z16, boolean z17, GameStrategyAuthRequire gameStrategyAuthRequire) {
        if (!z16) {
            return;
        }
        GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
        gameStrategyChannelEntry.guildId = bVar.f441456a;
        gameStrategyChannelEntry.channelId = bVar.f441457b;
        if (z17) {
            openGameStrategyAuthDialog(qBaseActivity, i3, j3, str, gameStrategyChannelEntry, gameStrategyAuthRequire);
        } else {
            openGameStrategyAnswerDialog(qBaseActivity, i3, j3, str, gameStrategyChannelEntry);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi
    public void answerQuestion(final QBaseActivity qBaseActivity, final int i3, final long j3, final String str) {
        if (qBaseActivity == null) {
            return;
        }
        final vd1.b h16 = GameQAUtil.h();
        if (h16 == null) {
            QLog.e(TAG, 1, "answerQuestion, sessionInfo null");
        } else if (i3 != h16.f441458c) {
            QLog.e(TAG, 1, "answerQuestion, error appId");
            QQToast.makeText(qBaseActivity.getApplicationContext(), 1, "\u8df3\u8f6c\u9519\u8bef\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 1);
        } else {
            ((IQQGameStrategyService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameStrategyService.class, "")).openGameStrategyAnswerAction(h16.f441457b, i3, new ce1.a() { // from class: com.tencent.mobileqq.gamecenter.qa.api.impl.b
                @Override // ce1.a
                public final void a(boolean z16, boolean z17, GameStrategyAuthRequire gameStrategyAuthRequire) {
                    QQGameStrategyApiImpl.this.lambda$answerQuestion$0(h16, qBaseActivity, i3, j3, str, z16, z17, gameStrategyAuthRequire);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi
    public void clearDraftCache() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.api.impl.QQGameStrategyApiImpl.1
            @Override // java.lang.Runnable
            public void run() {
                GameStrategyDraftHandler.c();
            }
        }, 64, null, true);
    }

    public void commitFragment(QBaseActivity qBaseActivity, Fragment fragment, String str) {
        qBaseActivity.getSupportFragmentManager().beginTransaction().add(fragment, str).commit();
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi
    public GameRankConfig getGameRankConfig() {
        return (GameRankConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100497");
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi
    public Class getHippyUIParserClass() {
        return e.class;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi
    public Class getJumpParserClass() {
        return com.tencent.mobileqq.gamecenter.qa.jumpaction.a.class;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi
    public Fragment getStrategyDialogFragment(QBaseActivity qBaseActivity) {
        FragmentManager supportFragmentManager = qBaseActivity.getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(FRAGMENT_QUESTION_TAG);
        if (findFragmentByTag != null) {
            return findFragmentByTag;
        }
        return supportFragmentManager.findFragmentByTag(FRAGMENT_ANSWER_TAG);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi
    public Set<Integer> getSupportSceneSet() {
        return new HashSet<Integer>() { // from class: com.tencent.mobileqq.gamecenter.qa.api.impl.QQGameStrategyApiImpl.2
            {
                add(0);
                add(1);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi
    public boolean isGameQAUrl(Activity activity) {
        r rVar;
        CustomWebView webView;
        if (activity instanceof r) {
            rVar = (r) activity;
        } else {
            if (activity instanceof u) {
                WebViewFragment currentWebViewFragment = ((u) activity).getCurrentWebViewFragment();
                if (currentWebViewFragment != null) {
                    rVar = currentWebViewFragment;
                } else if (activity instanceof QQBrowserActivity) {
                    rVar = getWebUiMethodInterface((QQBrowserActivity) activity);
                }
            }
            rVar = null;
        }
        if (rVar != null && (webView = rVar.getWebView()) != null && webView.getUrl() != null && webView.getUrl().startsWith(QA_LINK_URL_PREFIX)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi
    public boolean isGameRobot(String str) {
        c cVar = (c) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100500");
        if (cVar != null && cVar.a().contains(str)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi
    public void openGameQAQuoteArticle(Activity activity, int i3, int i16, long j3) {
        QPublicFragmentActivity.startForResult(activity, QQGameStrategyArticleFragment.yh(i16, j3), (Class<? extends QPublicBaseFragment>) QQGameStrategyArticleFragment.class, i3);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi
    public void openGameStrategyAnswer(Context context, int i3, long j3, String str, String str2, String str3, int i16, int i17) {
        Intent ph5 = QQGameStrategyAnswerFragment.ph(i3, j3, str, str2, str3, i16, i17);
        if (!(context instanceof Activity)) {
            ph5.addFlags(268435456);
        }
        QPublicFragmentActivity.start(context, ph5, QQGameStrategyAnswerFragment.class);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi
    public void openGameStrategyAnswerDialog(QBaseActivity qBaseActivity, int i3, long j3, String str, GameStrategyChannelEntry gameStrategyChannelEntry) {
        QQGameStrategyAnswerDialog qQGameStrategyAnswerDialog = new QQGameStrategyAnswerDialog();
        qQGameStrategyAnswerDialog.setArguments(QQGameStrategyAnswerDialog.qh(i3, j3, str, gameStrategyChannelEntry));
        commitFragment(qBaseActivity, qQGameStrategyAnswerDialog, FRAGMENT_ANSWER_TAG);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi
    public void openGameStrategyAtDialog(QBaseActivity qBaseActivity, int i3, long j3, ArrayList<InviteData> arrayList, ArrayList<String> arrayList2) {
        QQGameStrategyAtDialog qQGameStrategyAtDialog = new QQGameStrategyAtDialog();
        qQGameStrategyAtDialog.setArguments(QQGameStrategyAtDialog.INSTANCE.a(i3, j3, arrayList, arrayList2));
        commitFragment(qBaseActivity, qQGameStrategyAtDialog, FRAGMENT_AT_TAG);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi
    public void openGameStrategyAuthDialog(QBaseActivity qBaseActivity, int i3, GameStrategyAuthRequire gameStrategyAuthRequire) {
        QQGameStrategyAuthDialogFragment qQGameStrategyAuthDialogFragment = new QQGameStrategyAuthDialogFragment();
        qQGameStrategyAuthDialogFragment.setArguments(QQGameStrategyAuthDialogFragment.uh(i3, gameStrategyAuthRequire));
        commitFragment(qBaseActivity, qQGameStrategyAuthDialogFragment, FRAGMENT_AUTH_TAG);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi
    public void openGameStrategyQuestion(Context context, int i3, String str, String str2, int i16, int i17) {
        Intent ph5 = QQGameStrategyQuestionFragment.ph(i3, str, str2, i16, i17);
        if (!(context instanceof Activity)) {
            ph5.addFlags(268435456);
        }
        QPublicFragmentActivity.start(context, ph5, QQGameStrategyQuestionFragment.class);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi
    public void openGameStrategyQuestionDialog(QBaseActivity qBaseActivity, int i3, GameStrategyChannelEntry gameStrategyChannelEntry) {
        QQGameStrategyQuestionDialog qQGameStrategyQuestionDialog = new QQGameStrategyQuestionDialog();
        qQGameStrategyQuestionDialog.setArguments(QQGameStrategyQuestionDialog.qh(i3, gameStrategyChannelEntry));
        commitFragment(qBaseActivity, qQGameStrategyQuestionDialog, FRAGMENT_QUESTION_TAG);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi
    public void openTransparentPage(Context context, String str, int i3) {
        Intent ph5 = QQGameTransparentFragment.ph(str, i3);
        if (!(context instanceof Activity)) {
            ph5.addFlags(268435456);
        }
        ph5.putExtra("public_fragment_window_feature", 1);
        QPublicFragmentActivity.b.b(context, ph5, QPublicTransFragmentActivity.class, QQGameTransparentFragment.class);
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi
    public void preloadJsBundle() {
        boolean hippySwitch = ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).getHippySwitch();
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100649", false);
        QLog.d(TAG, 1, "preloadJsBundle, isHippySwitchOn=", Boolean.valueOf(hippySwitch), ", isPreloadSwitchOn=", Boolean.valueOf(isSwitchOn));
        if (hippySwitch && isSwitchOn) {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.api.impl.QQGameStrategyApiImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    Bundle bundle = new Bundle();
                    bundle.putString("reportFrom", "gameDongTai");
                    ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).updateJsBundle(HippyQQConstants.ModuleName.QQ_GAMECENTER_STRATEGYQA, ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isUpdateHippyJsBundleByHttp(), 3, bundle, null);
                }
            }, 16, null, false, 2000L);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi
    public void reportAskBtnClick(QBaseActivity qBaseActivity, int i3, GameStrategyChannelEntry gameStrategyChannelEntry) {
        boolean z16;
        String str;
        if (qBaseActivity != null) {
            View findViewById = qBaseActivity.findViewById(R.id.u78);
            if (findViewById != null && findViewById.getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Map<Integer, String> i16 = GameQAUtil.i(qBaseActivity, gameStrategyChannelEntry);
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            i16.put(5, str);
            com.tencent.mobileqq.gamecenter.qa.util.e.a("5", "122", "9072", "907201", "907117", "20", String.valueOf(i3), i16);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi
    public void openGameStrategyAuthDialog(QBaseActivity qBaseActivity, int i3, long j3, String str, GameStrategyChannelEntry gameStrategyChannelEntry, GameStrategyAuthRequire gameStrategyAuthRequire) {
        QQGameStrategyAuthDialogFragment qQGameStrategyAuthDialogFragment = new QQGameStrategyAuthDialogFragment();
        qQGameStrategyAuthDialogFragment.setArguments(QQGameStrategyAuthDialogFragment.th(i3, j3, str, gameStrategyChannelEntry, gameStrategyAuthRequire));
        commitFragment(qBaseActivity, qQGameStrategyAuthDialogFragment, FRAGMENT_AUTH_TAG);
    }
}

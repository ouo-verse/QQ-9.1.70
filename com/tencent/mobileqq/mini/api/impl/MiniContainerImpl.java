package com.tencent.mobileqq.mini.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.mini.activity.MiniContainerPageFragment;
import com.tencent.mobileqq.mini.api.ContainerLoadParams;
import com.tencent.mobileqq.mini.api.IContainerPageNavigator;
import com.tencent.mobileqq.mini.api.IContainerViewCallback;
import com.tencent.mobileqq.mini.api.IMiniContainer;
import com.tencent.mobileqq.mini.api.IMiniLoadCallback;
import com.tencent.mobileqq.mini.api.IMiniLoadingView;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.api.MiniContainerHolder;
import com.tencent.mobileqq.mini.container.MiniContainerForegroundCallback;
import com.tencent.mobileqq.mini.container.MiniEventCenter;
import com.tencent.mobileqq.mini.container.MiniLoadCallbackImpl;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ah;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.qqmini.container.core.MiniView;
import com.tencent.qqmini.container.core.bb;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.utils.TbsLogClient;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.Foreground;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniContainerImpl implements IMiniContainer, IAccountCallback {
    private static final int DARK_COLOR = -16777216;
    private static final String DATA_SUFFIX = "data_directory_suffix";
    private static final int LIGHT_COLOR = -1;
    private static final String TAG = "MiniContainerImpl";
    private final List<WeakReference<MiniContainerHolder>> activeContainers;
    private final du3.s container;
    private AtomicBoolean currentThemeNight;
    private final MiniEventCenter eventCenter;
    private Set<String> loadingPath = new HashSet();
    private String mCurrentAccount;

    public MiniContainerImpl() {
        this.mCurrentAccount = "";
        eu3.g.a(false);
        this.container = du3.s.x();
        this.activeContainers = new LinkedList();
        this.eventCenter = new MiniEventCenter();
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            AppRuntime peekAppRuntime = mobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                this.mCurrentAccount = peekAppRuntime.getAccount();
            }
            MobileQQ.sMobileQQ.registerAccountCallback(this);
        }
        BaseApplication context = BaseApplication.getContext();
        initTbsSettings(context);
        initContainer(context);
        Foreground.addActivityLifeCallback(new MiniContainerForegroundCallback());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUpdate() {
        refreshContainer();
    }

    private void initContainer(Context context) {
        this.eventCenter.initialize();
        this.container.i0(context).g0(MiniConst.MiniContainerConst.APP_ID).o0(new X5Initializer()).j0(false).k0(new com.tencent.qqmini.container.core.e() { // from class: com.tencent.mobileqq.mini.api.impl.p
            @Override // com.tencent.qqmini.container.core.e
            public final boolean launchPage(Context context2, String str) {
                boolean lambda$initContainer$2;
                lambda$initContainer$2 = MiniContainerImpl.lambda$initContainer$2(context2, str);
                return lambda$initContainer$2;
            }
        }).n0(new bb() { // from class: com.tencent.mobileqq.mini.api.impl.q
            @Override // com.tencent.qqmini.container.core.bb
            public final void a() {
                MiniContainerImpl.this.doUpdate();
            }
        });
        QLog.d(TAG, 2, "MiniContainerImpl init");
    }

    private void initTbsSettings(Context context) {
        QLog.w(TAG, 1, "initTbsSettings, tbsVersion: " + QbSdk.getTbsVersion(context) + ", tmpDirTbsVersion: " + QbSdk.getTmpDirTbsVersion(context));
        Bundle bundle = new Bundle();
        String c16 = com.tencent.mobileqq.statistics.o.c();
        String F = ah.F();
        bundle.putString("qimei36", c16 == null ? "" : c16);
        if (c16 == null) {
            c16 = "";
        }
        bundle.putString(SemanticAttributes.DbCassandraConsistencyLevelValues.SERIAL, c16);
        if (F == null) {
            F = "";
        }
        bundle.putString("model", F);
        QbSdk.setUserID(context, bundle);
        String packageName = context.getPackageName();
        HashMap hashMap = new HashMap();
        hashMap.put(DATA_SUFFIX, packageName);
        Boolean bool = Boolean.TRUE;
        hashMap.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, bool);
        hashMap.put(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE, Boolean.FALSE);
        hashMap.put(TbsCoreSettings.TBS_SETTINGS_USE_PRIVATE_CLASSLOADER, bool);
        QbSdk.initTbsSettings(hashMap);
        QbSdk.setTbsLogClient(new TbsLogClient(BaseApplication.getContext()) { // from class: com.tencent.mobileqq.mini.api.impl.MiniContainerImpl.1
            @Override // com.tencent.smtt.utils.TbsLogClient
            public void d(String str, String str2) {
                if (QLog.isColorLevel()) {
                    QLog.d("[MiniContainerImpl]" + str, 1, str2);
                }
            }

            @Override // com.tencent.smtt.utils.TbsLogClient
            public void e(String str, String str2) {
                if (QLog.isColorLevel()) {
                    QLog.e("[MiniContainerImpl]" + str, 1, str2);
                }
            }

            @Override // com.tencent.smtt.utils.TbsLogClient
            public void i(String str, String str2) {
                if (QLog.isColorLevel()) {
                    QLog.i("[MiniContainerImpl]" + str, 1, str2);
                }
            }

            @Override // com.tencent.smtt.utils.TbsLogClient
            public void w(String str, String str2) {
                if (QLog.isColorLevel()) {
                    QLog.w("[MiniContainerImpl]" + str, 1, str2);
                }
            }
        });
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                WebView.setDataDirectorySuffix(packageName);
            } catch (Exception e16) {
                QLog.i(TAG, 2, "WebView.setDataDirectorySuffix:" + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$initContainer$2(Context context, String str) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("path", str);
        intent.putExtras(bundle);
        QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, MiniContainerPageFragment.class);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$load$1(ContainerLoadParams containerLoadParams, String str) {
        containerLoadParams.getContainerViewCallback().onMiniViewResult(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reloadAllMiniContainer$0() {
        QLog.d(TAG, 2, "reloadAllMiniContainer, size:" + this.activeContainers.size());
        Iterator<WeakReference<MiniContainerHolder>> it = this.activeContainers.iterator();
        while (it.hasNext()) {
            MiniContainerHolder miniContainerHolder = it.next().get();
            if (miniContainerHolder == null) {
                it.remove();
            } else {
                reloadMiniContainer(miniContainerHolder);
            }
        }
    }

    private void updateWebViewBg(boolean z16) {
        if (this.activeContainers == null) {
            return;
        }
        QLog.d(TAG, 1, "set miniviews bg color:" + z16);
        Iterator<WeakReference<MiniContainerHolder>> it = this.activeContainers.iterator();
        while (it.hasNext()) {
            MiniContainerHolder miniContainerHolder = it.next().get();
            if (miniContainerHolder != null && miniContainerHolder.getView() != null) {
                miniContainerHolder.getView().setBackgroundColor(z16 ? -16777216 : -1);
            }
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniContainer
    public void addExternalPlugin(Class<?> cls) {
        com.tencent.qqmini.container.core.h.a(cls);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniContainer
    public void checkUpdate() {
        du3.s sVar = this.container;
        if (sVar != null) {
            sVar.t();
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniContainer
    public void dispatchNativeEvent(String str, Map<String, ?> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", str);
        if (map == null) {
            map = new HashMap<>();
        }
        hashMap.put("data", map);
        this.container.u("onGeneralNativeEvent", hashMap);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniContainer
    public boolean isX5Installed() {
        BaseApplication context = BaseApplication.getContext();
        return context != null && com.tencent.qqmini.sdk.utils.e.a(context);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniContainer
    public void launchPage(Context context, String str) {
        du3.s sVar = this.container;
        if (sVar != null) {
            sVar.Y(context, str);
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniContainer
    public MiniContainerHolder load(Activity activity, LifecycleOwner lifecycleOwner, String str, Map<String, ?> map, IMiniLoadCallback iMiniLoadCallback) {
        return load(activity, lifecycleOwner, str, map, iMiniLoadCallback, null);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniContainer
    public void onThemeChanged() {
        boolean z16;
        String str;
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        QLog.d(TAG, 1, "onThemeChanged ,isNight:" + isNowThemeIsNight);
        if (this.currentThemeNight == null) {
            this.currentThemeNight = new AtomicBoolean(QQTheme.isNowThemeIsNight());
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = this.currentThemeNight.get() != isNowThemeIsNight;
        if (this.container.I()) {
            QLog.d(TAG, 1, "shouldChange:" + z17 + " currentThemeNight:" + this.currentThemeNight.get() + " isNowThemeIsNight:" + isNowThemeIsNight);
            if (!this.currentThemeNight.compareAndSet(!isNowThemeIsNight, isNowThemeIsNight) && !z16) {
                QLog.d(TAG, 1, "theme not changed,is Night" + isNowThemeIsNight);
            } else {
                HashMap hashMap = new HashMap();
                if (isNowThemeIsNight) {
                    str = MiniAppConst.MENU_STYLE_DARK;
                } else {
                    str = MiniAppConst.MENU_STYLE_LIGHT;
                }
                hashMap.put("theme", str);
                QLog.d(TAG, 1, "theme  changed,dispatch to js:" + isNowThemeIsNight);
                this.container.u("onThemeChange", hashMap);
            }
        } else {
            QLog.d(TAG, 1, "theme not changed,container is not ready, isChanged:" + (z17 ? this.currentThemeNight.compareAndSet(!isNowThemeIsNight, isNowThemeIsNight) : false));
        }
        if (z17 || z16) {
            updateWebViewBg(isNowThemeIsNight);
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniContainer
    public void prefetchPageDataWithExtraParam(String str, String str2, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "prefetchContainerDataWithPagePath error page path is null");
        } else {
            this.container.c0(str, str2, map);
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniContainer
    public void refreshContainer() {
        if (this.container.H()) {
            QLog.w(TAG, 4, "refreshContainer abandon because container is preparing");
            return;
        }
        QLog.d(TAG, 4, "refreshContainer");
        this.container.f0();
        initContainer(BaseApplication.getContext());
        reloadAllMiniContainer();
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniContainer
    public void registerMiniView(View view) {
        if (view instanceof MiniView) {
            this.activeContainers.add(new WeakReference<>(new MiniContainerHolder(view)));
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniContainer
    public void reloadAllMiniContainer() {
        eu3.f.i(new Runnable() { // from class: com.tencent.mobileqq.mini.api.impl.r
            @Override // java.lang.Runnable
            public final void run() {
                MiniContainerImpl.this.lambda$reloadAllMiniContainer$0();
            }
        });
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniContainer
    public void reset() {
        if (this.container.H()) {
            QLog.e(TAG, 1, "reset hContainer abandon because container is preparing");
            return;
        }
        Iterator<WeakReference<MiniContainerHolder>> it = this.activeContainers.iterator();
        while (it.hasNext()) {
            MiniContainerHolder miniContainerHolder = it.next().get();
            if (miniContainerHolder != null && miniContainerHolder.getView() != null && (miniContainerHolder.getView() instanceof MiniView) && !((MiniView) miniContainerHolder.getView()).n()) {
                QLog.e(TAG, 1, "reset hContainer abandon because miniView is not Destroyed");
                return;
            }
        }
        QLog.d(TAG, 1, "reset Container");
        this.container.f0();
        initContainer(BaseApplication.getContext());
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniContainer
    public void retry(View view) {
        if (view instanceof MiniView) {
            QLog.d(TAG, 1, TVKCommonParamEnum.REQ_PARAM_KEY_RETRY);
            ((MiniView) view).x();
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniContainer
    public void setContainerNavigator(final IContainerPageNavigator iContainerPageNavigator) {
        du3.s sVar = this.container;
        if (sVar == null) {
            return;
        }
        if (iContainerPageNavigator == null) {
            sVar.l0(null);
        } else {
            sVar.l0(new com.tencent.qqmini.container.core.d() { // from class: com.tencent.mobileqq.mini.api.impl.MiniContainerImpl.4
                @Override // com.tencent.qqmini.container.core.d
                public boolean navigateBack() {
                    return iContainerPageNavigator.navigateBack();
                }

                @Override // com.tencent.qqmini.container.core.d
                public boolean navigateTo(String str) {
                    return iContainerPageNavigator.navigateTo(str);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniContainer
    public void setDrawEnabled(View view, boolean z16) {
        if (view instanceof MiniView) {
            ((MiniView) view).setDrawEnabled(z16);
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniContainer
    public void setLoadingView(View view, final IMiniLoadingView iMiniLoadingView) {
        if (view instanceof MiniView) {
            QLog.d(TAG, 1, "setLoadingView");
            ((MiniView) view).setLoadingView(new com.tencent.qqmini.container.core.f() { // from class: com.tencent.mobileqq.mini.api.impl.MiniContainerImpl.3
                @Override // com.tencent.qqmini.container.core.f
                public boolean hide() {
                    IMiniLoadingView iMiniLoadingView2 = iMiniLoadingView;
                    return iMiniLoadingView2 != null && iMiniLoadingView2.hide();
                }

                @Override // com.tencent.qqmini.container.core.f
                public boolean show() {
                    IMiniLoadingView iMiniLoadingView2 = iMiniLoadingView;
                    return iMiniLoadingView2 != null && iMiniLoadingView2.show();
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniContainer
    public MiniContainerHolder load(Activity activity, LifecycleOwner lifecycleOwner, String str, Map<String, ?> map, IMiniLoadCallback iMiniLoadCallback, IContainerViewCallback iContainerViewCallback) {
        ContainerLoadParams containerLoadParams = new ContainerLoadParams();
        containerLoadParams.setData(map).setLoadingCallback(iMiniLoadCallback).setContainerViewCallback(iContainerViewCallback).setAddDefaultLoadingView(false).setAddDefaultRetryView(false);
        return load(activity, lifecycleOwner, str, containerLoadParams);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniContainer
    public void prefetchPageData(String str) {
        prefetchPageDataWithExtraParam(str, null, null);
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniContainer
    public void prepare() {
        QLog.d(TAG, 2, "prepare");
        final du3.s sVar = this.container;
        Objects.requireNonNull(sVar);
        eu3.f.i(new Runnable() { // from class: com.tencent.mobileqq.mini.api.impl.s
            @Override // java.lang.Runnable
            public final void run() {
                du3.s.this.d0();
            }
        });
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChanged(AppRuntime appRuntime) {
        if (appRuntime != null) {
            String account = appRuntime.getAccount();
            QLog.d(TAG, 2, "MiniContainerImpl onAccountChanged,origin:" + this.mCurrentAccount + ",new:" + account);
            if (TextUtils.equals(this.mCurrentAccount, account)) {
                return;
            }
            this.mCurrentAccount = account;
            refreshContainer();
        }
    }

    private void reloadMiniContainer(MiniContainerHolder miniContainerHolder) {
        final MiniView miniView;
        if (miniContainerHolder == null || (miniView = (MiniView) miniContainerHolder.getView()) == null) {
            return;
        }
        miniView.post(new Runnable() { // from class: com.tencent.mobileqq.mini.api.impl.o
            @Override // java.lang.Runnable
            public final void run() {
                MiniView.this.w();
            }
        });
    }

    @Override // com.tencent.mobileqq.mini.api.IMiniContainer
    public MiniContainerHolder load(Activity activity, LifecycleOwner lifecycleOwner, final String str, final ContainerLoadParams containerLoadParams) {
        QLog.d(TAG, 1, "load");
        MiniView miniView = (MiniView) LayoutInflater.from(activity).inflate(R.layout.djs, (ViewGroup) null);
        miniView.setLifeCycleOwner(lifecycleOwner);
        if (containerLoadParams.getContainerViewCallback() != null) {
            miniView.setMiniViewCallback(new com.tencent.qqmini.container.core.g() { // from class: com.tencent.mobileqq.mini.api.impl.n
                @Override // com.tencent.qqmini.container.core.g
                public final void a(String str2) {
                    MiniContainerImpl.lambda$load$1(ContainerLoadParams.this, str2);
                }
            });
        }
        final IMiniLoadCallback loadCallback = containerLoadParams.getLoadCallback();
        containerLoadParams.setLoadingCallback(new IMiniLoadCallback() { // from class: com.tencent.mobileqq.mini.api.impl.MiniContainerImpl.2
            @Override // com.tencent.mobileqq.mini.api.IMiniLoadCallback
            public void onLoaded(int i3, String str2) {
                QLog.i(MiniContainerImpl.TAG, 1, "remove path:" + str);
                MiniContainerImpl.this.loadingPath.remove(str);
                IMiniLoadCallback iMiniLoadCallback = loadCallback;
                if (iMiniLoadCallback != null) {
                    iMiniLoadCallback.onLoaded(i3, str2);
                }
            }
        });
        miniView.setLoadCallback(new MiniLoadCallbackImpl(containerLoadParams, miniView));
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        miniView.setBackgroundColor(isNowThemeIsNight ? -16777216 : -1);
        QLog.d(TAG, 1, "load set mini view background color, isDark: " + isNowThemeIsNight);
        QLog.d(TAG, 1, "load path" + str);
        this.loadingPath.add(str);
        miniView.s(str, containerLoadParams.getData());
        MiniContainerHolder miniContainerHolder = new MiniContainerHolder(miniView);
        this.activeContainers.add(new WeakReference<>(miniContainerHolder));
        return miniContainerHolder;
    }

    @Override // mqq.app.IAccountCallback
    public void onAccountChangeFailed(AppRuntime appRuntime) {
    }

    @Override // mqq.app.IAccountCallback
    public void onLogout(Constants.LogoutReason logoutReason) {
    }
}

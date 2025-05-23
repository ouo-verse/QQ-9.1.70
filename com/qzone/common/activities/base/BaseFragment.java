package com.qzone.common.activities.base;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.requestengine.callbacks.QZoneServiceCallback;
import com.qzone.reborn.tracer.monitor.QZoneMonitorProxyImpl;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.TagData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.TimeCostTrace;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BaseFragment extends ImmersivePartFragment implements PerfTracer.PerfTimeReport, ActivityCallBackInterface, QZoneServiceCallback {
    public static final int DEFAULT_FLAG = 4095;
    private static final HashMap<Class, WeakReference<BaseFragment>> FRAGEMTN_MAP = new HashMap<>();
    public static final int MSG_DELAY_REFRESH = 87;
    static final int MSG_NET_STATE_CHANGED = 86;
    static final int MSG_REFRESH = 0;
    public static final int RESUME_FLAG1 = 1;
    public static final int RESUME_FLAG10 = 512;
    public static final int RESUME_FLAG11 = 1024;
    public static final int RESUME_FLAG12 = 2048;
    public static final int RESUME_FLAG2 = 2;
    public static final int RESUME_FLAG3 = 4;
    public static final int RESUME_FLAG4 = 8;
    public static final int RESUME_FLAG5 = 16;
    public static final int RESUME_FLAG6 = 32;
    public static final int RESUME_FLAG7 = 64;
    public static final int RESUME_FLAG8 = 128;
    public static final int RESUME_FLAG9 = 256;
    protected static final String TAG = "BaseFragment";
    protected static final int WHAT_NOT_NET = 100001;
    private static boolean hasNet = false;
    private static int lastOrientation = -1;
    protected d5.c configInf;
    protected volatile d5.u containerInf;
    private d5.p footBannerInf;
    private FragmentRequestInterface fragmentRequestInterface;
    protected int mStatusBarHeight;
    protected long mUIThreadID;
    private ViewModelStore mViewModelStore;
    protected boolean netStateCallback;
    private NetworkState.NetworkStateListener netStateListener;
    protected d5.v pageDataInf;
    protected d5.ab reporterInf;
    protected String skinid;
    private boolean started;
    d5.ae toastInf;
    d5.af videoWindowPlayInf;
    private String mFragmentName = "";
    private long lastNolinkToastShowTime = 0;
    private final long NO_LINK_TOAST_SHOW_INTERVAL = 2000;
    public String simpleClassname = getClass().getSimpleName();
    protected volatile boolean mReplace = false;
    private final tn.a mServerResultPreProcessor = new tn.a();
    private LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
    protected final String ActivityName = "[Activity]" + TAG;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name */
        private final java.lang.ref.WeakReference<BaseFragment> f45047a;

        public a(BaseFragment baseFragment) {
            this.f45047a = new java.lang.ref.WeakReference<>(baseFragment);
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        public Map<String, Object> getDynamicParams(String str) {
            BaseFragment baseFragment;
            java.lang.ref.WeakReference<BaseFragment> weakReference = this.f45047a;
            if (weakReference == null || (baseFragment = weakReference.get()) == null) {
                return null;
            }
            return baseFragment.getChildDaTongDynamicParams();
        }
    }

    public BaseFragment() {
        com.qzone.app.f.b(this);
    }

    public static BaseFragment getResumedFragment(Class<? extends BaseFragment> cls) {
        WeakReference<BaseFragment> weakReference = FRAGEMTN_MAP.get(cls);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private void iniStatusBarHeight() {
        this.mStatusBarHeight = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
    }

    public static boolean isMoveTaskToBack(Intent intent) {
        return intent.getComponent() == null || !intent.getComponent().getPackageName().equals(BaseApplication.getContext().getPackageName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResult$2(QZoneResult qZoneResult) {
        if (isFinishing()) {
            return;
        }
        onServiceResult(qZoneResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNetStateCallback$0(boolean z16) {
        QZLog.w(QZLog.TO_DEVICE_TAG, TAG + "\t onNetworkConnect() connected: " + z16);
        if (this.containerInf != null) {
            Message obtain = Message.obtain();
            obtain.what = 86;
            obtain.obj = Boolean.valueOf(z16);
            this.containerInf.getHandler().sendMessageDelayed(obtain, 3000L);
        }
    }

    public <T extends View> T $(int i3) {
        return (T) findViewById(i3);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return null;
    }

    public boolean checkNetworkConnect() {
        return hasNet;
    }

    protected boolean checkSelfPermission(String str) {
        return getActivity() != null && getActivity().checkSelfPermission(str) == 0;
    }

    protected void dispatchOnActivityResult(int i3, int i16, Intent intent) {
        Fragment findFragmentById = getParentFragmentManager().findFragmentById(getMainFragmentId());
        if (findFragmentById == null || findFragmentById == this) {
            return;
        }
        findFragmentById.onActivityResult(i3, i16, intent);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        return com.tencent.biz.richframework.compat.f.b(this, i3, keyEvent);
    }

    protected boolean enableDaTongPageRegister() {
        return false;
    }

    public View findViewById(int i3) {
        if (this.containerInf == null) {
            return null;
        }
        return this.containerInf.findViewById(i3);
    }

    public void finish() {
        if (this.containerInf != null) {
            this.containerInf.finish();
        }
    }

    public AppRuntime getAppRuntime() {
        return BaseApplicationImpl.getApplication().getRuntime();
    }

    public Context getApplicationContext() {
        if (getActivity() != null) {
            return getActivity().getApplicationContext();
        }
        return BaseApplicationImpl.getApplication();
    }

    protected Map<String, Object> getChildDaTongDynamicParams() {
        return null;
    }

    protected Map<String, Object> getChildDaTongPageParams() {
        return null;
    }

    public ColorNote getColorNote() {
        return null;
    }

    public d5.u getContainerInf() {
        return this.containerInf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return 0;
    }

    public String getCurSkinId() {
        return this.skinid;
    }

    protected String getDaTongPageId() {
        return "";
    }

    public int getFeedListBackgroundId() {
        return 0;
    }

    public String getFragmentName() {
        return this.mFragmentName;
    }

    public Handler getHandler() {
        if (this.containerInf == null) {
            QZLog.w(TAG, "getHandler: container is not init now");
            return null;
        }
        return this.containerInf.getHandler();
    }

    public Intent getIntent() {
        if (this.containerInf == null) {
            return null;
        }
        return this.containerInf.getIntent();
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public String getLogTag() {
        return TAG;
    }

    public int getMainFragmentId() {
        return R.id.elo;
    }

    public Activity getOutActivity() {
        return getActivity();
    }

    public int getPageId() {
        return 0;
    }

    public SharedPreferences getSharedPreferences(String str, int i3) {
        if (getActivity() != null) {
            return getActivity().getSharedPreferences(str, i3);
        }
        return BaseApplicationImpl.getApplication().getSharedPreferences(str, i3);
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    public Object getSystemService(String str) {
        return getActivity().getSystemService(str);
    }

    public d5.ae getToastInf() {
        return this.toastInf;
    }

    public d5.af getVideoWindowPlayInf() {
        return this.videoWindowPlayInf;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (BaseApplicationImpl.getApplication() != null) {
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new ViewModelStore();
            }
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public Window getWindow() {
        if (this.containerInf == null) {
            return null;
        }
        return this.containerInf.getWindow();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 0) {
            onExecuteRefresh();
            return;
        }
        if (i3 == 86) {
            onNetStateChanged(((Boolean) message.obj).booleanValue());
            return;
        }
        if (i3 != 999910 && i3 != 999914) {
            onHandleMessage(message);
            return;
        }
        this.pageDataInf.b(this.pageDataInf.a(message));
        onHandleMessage(message);
    }

    public /* bridge */ /* synthetic */ void initWindowStyleAndAnimation(Activity activity) {
        com.tencent.biz.richframework.compat.f.c(this, activity);
    }

    public boolean isDestroyed() {
        return isDetached() || isRemoving();
    }

    public boolean isEnableNightMask() {
        return false;
    }

    public boolean isFinishing() {
        return isDetached() || isRemoving() || !isAdded();
    }

    public final boolean isResumed(int i3) {
        return this.containerInf != null && this.containerInf.b(i3);
    }

    protected boolean isRumtimeReady() {
        FragmentRequestInterface fragmentRequestInterface = this.fragmentRequestInterface;
        if (fragmentRequestInterface != null) {
            return fragmentRequestInterface.isAppInterfaceReady();
        }
        return true;
    }

    public boolean isRuntimeReady() {
        FragmentRequestInterface fragmentRequestInterface = this.fragmentRequestInterface;
        if (fragmentRequestInterface != null) {
            return fragmentRequestInterface.isAppInterfaceReady();
        }
        return false;
    }

    public boolean isStarted() {
        return this.started;
    }

    public /* bridge */ /* synthetic */ boolean isSupportScreenShot() {
        return com.tencent.biz.richframework.compat.f.d(this);
    }

    protected boolean isUIThread() {
        return Thread.currentThread().getId() == this.mUIThreadID;
    }

    public /* bridge */ /* synthetic */ boolean isWrapContent() {
        return com.tencent.biz.richframework.compat.f.e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needAdjustImmersive() {
        return false;
    }

    public boolean needCheckCreditLevel() {
        return false;
    }

    public /* bridge */ /* synthetic */ boolean needImmersive() {
        return com.tencent.biz.richframework.compat.f.f(this);
    }

    public boolean needMiniAIO() {
        return false;
    }

    public /* bridge */ /* synthetic */ boolean needStatusTrans() {
        return com.tencent.biz.richframework.compat.f.g(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyAdapter(final BaseAdapter baseAdapter) {
        if (!isUIThread()) {
            runOnUiThread(new Runnable() { // from class: com.qzone.common.activities.base.z
                @Override // java.lang.Runnable
                public final void run() {
                    BaseFragment.lambda$notifyAdapter$1(baseAdapter);
                }
            }, 0L);
        } else if (baseAdapter != null) {
            baseAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        dispatchOnActivityResult(i3, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onBackPress() {
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "[Activity]" + TAG + " onBackPress");
        return false;
    }

    public void onBackPressed() {
        if (super.onBackEvent()) {
            return;
        }
        try {
            finish();
        } catch (Exception e16) {
            QZLog.e(TAG, 1, "onBackPressed catch an exception.", e16);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i3 = configuration.orientation;
        if ((i3 == 1 || i3 == 2) && i3 != lastOrientation) {
            lastOrientation = i3;
            d5.c cVar = this.configInf;
            if (cVar != null) {
                cVar.a();
            }
            onScreenOrientationChange();
        }
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        iniStatusBarHeight();
        this.mUIThreadID = Thread.currentThread().getId();
        setNetStateCallback(true);
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = getContentLayoutId() != 0 ? layoutInflater.inflate(getContentLayoutId(), viewGroup, false) : null;
        if (inflate != null) {
            inflate.setTag(TagData.TAG_DATA_ID, createViewTagData());
        }
        return inflate;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        NetworkState.NetworkStateListener networkStateListener;
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        if (this.containerInf != null) {
            this.containerInf.getHandler().removeCallbacksAndMessages(null);
        }
        if (this.netStateCallback && (networkStateListener = this.netStateListener) != null) {
            NetworkState.removeListener(networkStateListener);
        }
        Activity activity = this.containerInf != null ? this.containerInf.getActivity() : null;
        boolean z16 = activity != null && activity.isChangingConfigurations();
        ViewModelStore viewModelStore = this.mViewModelStore;
        if (viewModelStore != null && !z16) {
            viewModelStore.clear();
        }
        FRAGEMTN_MAP.remove(getClass());
        try {
            super.onDestroy();
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onHandleMessage(Message message) {
        if (isFinishing()) {
            return;
        }
        Object obj = message.obj;
        if (obj instanceof QZoneResult) {
            this.mServerResultPreProcessor.e(getActivity(), (QZoneResult) obj);
        }
    }

    @Override // com.qzone.common.activities.base.ActivityCallBackInterface
    public boolean onKeyUp(int i3, KeyEvent keyEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onNetStateChanged(boolean z16) {
        QZLog.w(QZLog.TO_DEVICE_TAG, TAG + "\t onNetStateChanged() hasNet: " + z16);
        hasNet = z16;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (getParentFragmentManager() != null) {
            Fragment findFragmentById = getParentFragmentManager().findFragmentById(getMainFragmentId());
            if (!(findFragmentById instanceof BaseFragment) || findFragmentById == this) {
                return;
            }
            ((BaseFragment) findFragmentById).onNewIntent(intent);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        d5.ab abVar = this.reporterInf;
        if (abVar != null) {
            abVar.onPause();
        }
        FRAGEMTN_MAP.remove(getClass());
        try {
            super.onPause();
        } catch (Exception e16) {
            QZLog.w(e16);
        }
        if (getPageId() > 0) {
            com.qzone.reborn.tracer.monitor.b.a().stop();
        }
        po.a.f426574a.a(getFragmentName());
        ee2.d.b("qzone");
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public /* bridge */ /* synthetic */ void onPostThemeChanged() {
        com.tencent.biz.richframework.compat.f.k(this);
    }

    public /* bridge */ /* synthetic */ void onPreThemeChanged() {
        com.tencent.biz.richframework.compat.f.l(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        ee2.d.a("qzone");
        po.a.f426574a.b(getFragmentName());
        if (getPageId() > 0) {
            com.qzone.reborn.tracer.monitor.b.a().start(getActivity());
        }
        d5.ab abVar = this.reporterInf;
        if (abVar != null) {
            abVar.onResume();
        }
        FRAGEMTN_MAP.put(getClass(), new WeakReference<>(this));
        try {
            super.onResume();
        } catch (Exception e16) {
            QZLog.w(e16);
        }
        d5.p pVar = this.footBannerInf;
        if (pVar != null) {
            pVar.onResume();
        }
        d5.af afVar = this.videoWindowPlayInf;
        if (afVar != null) {
            afVar.onResume();
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        registerDaTongReportPageId();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.started = false;
        try {
            super.onStop();
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.qzone.reborn.tracer.monitor.b.a().injectProxyImpl(QZoneMonitorProxyImpl.b());
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean overrideFinish() {
        return com.tencent.biz.richframework.compat.f.o(this);
    }

    public void overridePendingTransition(int i3, int i16) {
        if (this.containerInf != null) {
            this.containerInf.overridePendingTransition(i3, i16);
        }
    }

    public void registerDaTongReportPageId() {
        String str;
        if (!enableDaTongPageRegister()) {
            QLog.i(TAG, 1, "[registerDaTongReportPageId] enableDaTongPageRegister is false, subPage: " + getLogTag());
            return;
        }
        View fragmentContentView = getFragmentContentView();
        if (fragmentContentView == null) {
            QLog.i(TAG, 1, "[registerDaTongReportPageId]  contentView == null , subPage: " + getLogTag());
            return;
        }
        if (!TextUtils.isEmpty(getDaTongPageId())) {
            str = getDaTongPageId();
        } else {
            str = "qzone_base_pageId";
        }
        VideoReport.setPageId(fragmentContentView, str);
        VideoReport.setPageParams(fragmentContentView, new fo.a().d(getLogTag(), getChildDaTongPageParams()));
        VideoReport.setEventDynamicParams(fragmentContentView, new a(this));
        QLog.i(TAG, 1, "[registerDaTongReportPageId]  | appKey: 0AND0MWZXR4U3RVU | subPage: " + getLogTag() + " | pageId: " + str);
    }

    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.containerInf != null) {
            return this.containerInf.registerReceiver(broadcastReceiver, intentFilter);
        }
        return null;
    }

    public void requestWindowFeature(int i3) {
        if (this.containerInf != null) {
            Activity activity = this.containerInf.getActivity();
            if (activity != null) {
                try {
                    activity.requestWindowFeature(i3);
                    return;
                } catch (Throwable th5) {
                    QZLog.e(TAG, "requestWindowFeature error ", th5);
                    return;
                }
            }
            QZLog.e(TAG, "not attach activity:", new IllegalArgumentException());
        }
    }

    public final void runOnUiThread(Runnable runnable, long j3) {
        if (this.containerInf == null) {
            QZLog.w(TAG, "runOnUiThread: container is not init now");
        } else {
            this.containerInf.c(runnable, j3);
        }
    }

    public void sendBroadcast(Intent intent) {
        if (this.containerInf != null) {
            this.containerInf.sendBroadcast(intent);
        }
    }

    @Inject
    @Named("BaseFragmentConfigImp")
    public void setConfigInf(d5.c cVar) {
        this.configInf = cVar;
    }

    @Inject(type = "com.qzone.common.activities.base.BaseFragmentContainerImp")
    public void setContainerInf(d5.u uVar) {
        this.containerInf = uVar;
    }

    @Inject(type = "com.qzone.common.activities.base.BaseFragmentFootBannerImp")
    public void setFootBannerInf(d5.p pVar) {
        this.footBannerInf = pVar;
    }

    public void setFragmentName(String str) {
        this.mFragmentName = str;
    }

    public void setFragmentRequestInterface(FragmentRequestInterface fragmentRequestInterface) {
        this.fragmentRequestInterface = fragmentRequestInterface;
    }

    public String setLastActivityName() {
        if (this.containerInf == null) {
            return "";
        }
        return this.containerInf.getString(R.string.button_back);
    }

    public void setNetStateCallback(boolean z16) {
        this.netStateCallback = z16;
        if (z16) {
            if (this.netStateListener == null) {
                this.netStateListener = new NetworkState.NetworkStateListener() { // from class: com.qzone.common.activities.base.aa
                    @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
                    public final void onNetworkConnect(boolean z17) {
                        BaseFragment.this.lambda$setNetStateCallback$0(z17);
                    }
                };
            }
            NetworkState.addListener(this.netStateListener);
            hasNet = NetworkState.isNetSupport();
            return;
        }
        NetworkState.NetworkStateListener networkStateListener = this.netStateListener;
        if (networkStateListener != null) {
            NetworkState.removeListener(networkStateListener);
        }
    }

    @Inject
    @Named("BaseFragmentPageDataImp")
    public void setPageDataInf(d5.v vVar) {
        this.pageDataInf = vVar;
    }

    @Inject
    @Named("BaseFragmentReporter")
    public void setReporterInf(d5.ab abVar) {
        this.reporterInf = abVar;
    }

    public void setResult(int i3) {
        if (this.containerInf != null) {
            this.containerInf.setResult(i3);
        }
    }

    public void setTheme(int i3) {
        if (getActivity() != null) {
            getActivity().setTheme(i3);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (this.containerInf != null) {
            Activity activity = this.containerInf.getActivity();
            if (activity != null) {
                activity.setTitle(charSequence);
            } else {
                QZLog.e(TAG, "not attach activity:", new IllegalArgumentException());
            }
        }
    }

    @Inject
    @Named("BaseFragmentToastImp")
    public void setToastInf(d5.ae aeVar) {
        this.toastInf = aeVar;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z16) {
        d5.ab abVar;
        super.setUserVisibleHint(z16);
        if (!z16 || (abVar = this.reporterInf) == null) {
            return;
        }
        abVar.onResume();
    }

    @Inject
    @Named("BaseFragmentVideoWindowPlayImp")
    public void setVideoWindowPlayInf(d5.af afVar) {
        this.videoWindowPlayInf = afVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivity(Intent intent) {
        try {
            super.startActivity(intent);
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivityForResult(Intent intent, int i3) {
        if (!isMoveTaskToBack(intent)) {
            intent.addFlags(262144);
        }
        intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, setLastActivityName());
        try {
            super.startActivityForResult(intent, i3);
        } catch (Exception e16) {
            QZLog.e(TAG, "startActivityForResult error: ", e16);
        }
    }

    public boolean supportColorNote() {
        return false;
    }

    public void toast(String str) {
        d5.ae aeVar = this.toastInf;
        if (aeVar != null) {
            aeVar.a(str);
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        if (this.containerInf != null) {
            this.containerInf.unregisterReceiver(broadcastReceiver);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    public AppRuntime waitAppRuntime() {
        FragmentRequestInterface fragmentRequestInterface = this.fragmentRequestInterface;
        if (fragmentRequestInterface != null) {
            return fragmentRequestInterface.waitAppInterface();
        }
        return null;
    }

    public <T extends View> T $(View view, int i3) {
        return (T) view.findViewById(i3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // com.qzone.adapter.feedcomponent.IServiceCallback
    public final void onResult(final QZoneResult qZoneResult) {
        if (qZoneResult == null || isFinishing()) {
            return;
        }
        runOnUiThread(new Runnable() { // from class: com.qzone.common.activities.base.y
            @Override // java.lang.Runnable
            public final void run() {
                BaseFragment.this.lambda$onResult$2(qZoneResult);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        this.started = true;
        try {
            super.onStart();
        } catch (Exception e16) {
            QZLog.w(e16);
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showNoNetworkTips() {
        if (isResumed(1)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastNolinkToastShowTime < 2000) {
                return;
            }
            this.lastNolinkToastShowTime = currentTimeMillis;
            toast(R.string.ghi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$notifyAdapter$1(BaseAdapter baseAdapter) {
        if (baseAdapter != null) {
            baseAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onWindowFocusChanged(boolean z16) {
        if (!z16 || this.mReplace) {
            return;
        }
        this.mReplace = true;
    }

    public void setResult(int i3, Intent intent) {
        if (this.containerInf != null) {
            this.containerInf.setResult(i3, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivity(Intent intent, Bundle bundle) {
        try {
            super.startActivity(intent, bundle);
        } catch (Exception e16) {
            QZLog.w(e16);
        }
    }

    public void toast(String str, int i3) {
        d5.ae aeVar = this.toastInf;
        if (aeVar != null) {
            aeVar.c(str, i3);
        }
    }

    @Override // com.qzone.common.activities.base.ActivityCallBackInterface
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4 && keyEvent.getRepeatCount() == 0) {
            return onBackPress();
        }
        return false;
    }

    public final void runOnUiThread(Runnable runnable) {
        if (this.containerInf == null) {
            QZLog.w(TAG, "runOnUiThread: container is not init now");
        } else {
            this.containerInf.post(runnable);
        }
    }

    public void setTitle(int i3) {
        if (this.containerInf != null) {
            setTitle(this.containerInf.getString(i3));
        } else {
            QZLog.e(TAG, "not attach activity:", new IllegalArgumentException());
        }
    }

    public void toast(int i3) {
        d5.ae aeVar = this.toastInf;
        if (aeVar != null) {
            aeVar.b(i3);
        }
    }

    public void toast(int i3, int i16) {
        d5.ae aeVar = this.toastInf;
        if (aeVar != null) {
            aeVar.toast(i3, i16);
        }
    }

    public void IOnSetTheme() {
    }

    protected void onExecuteRefresh() {
    }

    protected void onScreenOrientationChange() {
    }

    protected void onServiceResult(QZoneResult qZoneResult) {
    }

    @Override // com.qzone.common.activities.base.ActivityCallBackInterface
    public void onUserLeaveHint() {
    }

    @Override // cooperation.qzone.util.PerfTracer.PerfTimeReport
    public void reportPerfTime(TimeCostTrace timeCostTrace) {
    }
}

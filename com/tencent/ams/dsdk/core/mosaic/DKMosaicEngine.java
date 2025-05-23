package com.tencent.ams.dsdk.core.mosaic;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.dsdk.cache.ModuleConfigCache;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.dsdk.core.mosaic.DKMosaicEngine;
import com.tencent.ams.dsdk.data.ModuleInfo;
import com.tencent.ams.dsdk.event.DKEventCenter;
import com.tencent.ams.dsdk.fodder.TemplateManager;
import com.tencent.ams.dsdk.monitor.metric.DynamicReporter;
import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.dsdk.utils.FileUtils;
import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.ams.dsdk.view.video.VideoLoader;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSValue;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicManager;
import com.tencent.ams.mosaic.MosaicView;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.g;
import com.tencent.ams.mosaic.j;
import com.tencent.ams.mosaic.jsengine.a;
import com.tencent.ams.mosaic.jsengine.common.Env;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.ams.mosaic.jsengine.component.video.VideoComponentImpl;
import com.tencent.ams.mosaic.k;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.pts.utils.PTSFileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKMosaicEngine extends DKEngine<OnCreateMosaicEngineListener> {
    static IPatchRedirector $redirector_ = null;
    public static final String PARAM_KEY_AD_INFO = "PKAI";
    public static final String PARAM_KEY_MOSAIC_SO_INFO = "PKMSI";
    public static final String PARAM_KEY_TEMPLATE_ASSERT_PATH = "PKTAP";
    public static final String PARAM_KEY_TEMPLATE_FILE_PATH = "PKTFP";
    private static final String TAG = "DKMosaicEngine";
    private static final Map<com.tencent.ams.mosaic.jsengine.a, DKMosaicEngine> sEngineMap;
    private List<j> mCommonJSContents;
    private final MosaicCreateEngineListener mCreateEngineListener;
    private boolean mCreateHandled;
    private f.c mImageLoader;
    private volatile boolean mIsEngineCreating;
    private volatile boolean mIsInitialized;
    private boolean mIsRequiredTemplate;
    private com.tencent.ams.mosaic.jsengine.a mJsEngine;
    private MosaicView mMosaicView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.ams.dsdk.core.mosaic.DKMosaicEngine$4, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass4 implements MosaicManager.g {
        static IPatchRedirector $redirector_;
        final /* synthetic */ String val$adType;
        final /* synthetic */ View val$container;
        final /* synthetic */ DKEngine.OnViewCreateExtraEventListener val$extraEventListener;
        final /* synthetic */ ModuleInfo val$moduleInfo;
        final /* synthetic */ long val$startTime;
        final /* synthetic */ DKEngine.OnViewCreateListener val$viewCreateListener;

        AnonymousClass4(DKEngine.OnViewCreateExtraEventListener onViewCreateExtraEventListener, DKEngine.OnViewCreateListener onViewCreateListener, String str, long j3, ModuleInfo moduleInfo, View view) {
            this.val$extraEventListener = onViewCreateExtraEventListener;
            this.val$viewCreateListener = onViewCreateListener;
            this.val$adType = str;
            this.val$startTime = j3;
            this.val$moduleInfo = moduleInfo;
            this.val$container = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DKMosaicEngine.this, onViewCreateExtraEventListener, onViewCreateListener, str, Long.valueOf(j3), moduleInfo, view);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onViewCreated$0(DKEngine.OnViewCreateListener onViewCreateListener, String str) {
            onViewCreateListener.onViewLoadComplete();
            if (((DKEngine) DKMosaicEngine.this).eventCenter != null) {
                ((DKEngine) DKMosaicEngine.this).eventCenter.fireViewLoadComplete(str);
            }
        }

        @Override // com.tencent.ams.mosaic.MosaicManager.g
        public void onViewCreateFail(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
                return;
            }
            DLog.i(DKMosaicEngine.TAG, "onViewCreateFail, errorCode: " + i3);
            DKMosaicEngine.this.onMosaicViewCreateFail(this.val$viewCreateListener, i3, this.val$adType);
            DKEngine.OnViewCreateExtraEventListener onViewCreateExtraEventListener = this.val$extraEventListener;
            if (onViewCreateExtraEventListener != null) {
                onViewCreateExtraEventListener.onViewCreateExtraEvent(DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATE_FAIL, String.valueOf(i3));
            }
            DynamicReporter.reportDynamicRenderEnd(this.val$startTime, String.valueOf(i3), this.val$moduleInfo, TagValue.MOSAIC);
        }

        @Override // com.tencent.ams.mosaic.MosaicManager.g
        public void onViewCreateStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            DLog.i(DKMosaicEngine.TAG, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATE_START);
            DKEngine.OnViewCreateExtraEventListener onViewCreateExtraEventListener = this.val$extraEventListener;
            if (onViewCreateExtraEventListener != null) {
                onViewCreateExtraEventListener.onViewCreateExtraEvent(DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATE_START, null);
            }
        }

        @Override // com.tencent.ams.mosaic.MosaicManager.g
        public void onViewCreated(MosaicView mosaicView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) mosaicView);
                return;
            }
            DLog.i(DKMosaicEngine.TAG, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED);
            DKEngine.OnViewCreateExtraEventListener onViewCreateExtraEventListener = this.val$extraEventListener;
            if (onViewCreateExtraEventListener != null) {
                onViewCreateExtraEventListener.onViewCreateExtraEvent(DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, null);
            }
            if (mosaicView != null && mosaicView.getView() != null) {
                DKEngine.OnViewCreateExtraEventListener onViewCreateExtraEventListener2 = this.val$extraEventListener;
                if (onViewCreateExtraEventListener2 != null) {
                    onViewCreateExtraEventListener2.onViewCreateExtraEvent(DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_NOT_NULL, null);
                }
                if (DKMosaicEngine.this.checkCreateHandledAndSetIfCan()) {
                    DLog.i(DKMosaicEngine.TAG, "view create is handled");
                    return;
                }
                DKEngine.OnViewCreateExtraEventListener onViewCreateExtraEventListener3 = this.val$extraEventListener;
                if (onViewCreateExtraEventListener3 != null) {
                    onViewCreateExtraEventListener3.onViewCreateExtraEvent(DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_BEFORE_INTERCEPTED, null);
                }
                final DKEngine.OnViewCreateListener onViewCreateListener = this.val$viewCreateListener;
                final String str = this.val$adType;
                Runnable runnable = new Runnable() { // from class: com.tencent.ams.dsdk.core.mosaic.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        DKMosaicEngine.AnonymousClass4.this.lambda$onViewCreated$0(onViewCreateListener, str);
                    }
                };
                boolean onInterceptViewCreate = this.val$viewCreateListener.onInterceptViewCreate(mosaicView.getView(), 9000, runnable);
                if (!onInterceptViewCreate) {
                    this.val$viewCreateListener.onViewCreate(mosaicView.getView(), 9000);
                }
                if (((DKEngine) DKMosaicEngine.this).eventCenter != null) {
                    ((DKEngine) DKMosaicEngine.this).eventCenter.fireViewCreated(this.val$adType);
                }
                if (!onInterceptViewCreate) {
                    DKMosaicEngine.this.bindMosaicView(mosaicView, this.val$container, this.val$viewCreateListener, runnable);
                }
                this.val$viewCreateListener.onViewInitialized();
                DynamicReporter.reportDynamicRenderEnd(this.val$startTime, "none", this.val$moduleInfo, TagValue.MOSAIC);
                return;
            }
            this.val$viewCreateListener.onViewInitializeError(9001);
            if (((DKEngine) DKMosaicEngine.this).eventCenter != null) {
                ((DKEngine) DKMosaicEngine.this).eventCenter.fireViewCreateFail(9001, this.val$adType);
            }
            DynamicReporter.reportDynamicRenderEnd(this.val$startTime, TagValue.NO_VIEW_CREATED, this.val$moduleInfo, TagValue.MOSAIC);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15309);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            sEngineMap = new HashMap(1);
            DKMosaicEngineHelper.getInstance().initSoConfig(DKEngine.getApplicationContext());
        }
    }

    public DKMosaicEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIsInitialized = false;
        this.mCreateEngineListener = new MosaicCreateEngineListener(null);
        this.mIsRequiredTemplate = true;
        initLogSupport();
        Env.d(DKConfiguration.getPlatform());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindMosaicView(final MosaicView mosaicView, final View view, DKEngine.OnViewCreateListener onViewCreateListener, final Runnable runnable) {
        DLog.i(TAG, "bindMosaicView");
        if (mosaicView != null && mosaicView.getView() != null && (view instanceof ViewGroup)) {
            DynamicUtils.runOnUiThreadAtFrontOfQueue(new Runnable() { // from class: com.tencent.ams.dsdk.core.mosaic.c
                @Override // java.lang.Runnable
                public final void run() {
                    DKMosaicEngine.lambda$bindMosaicView$2(view, mosaicView, runnable);
                }
            });
            this.mMosaicView = mosaicView;
        } else {
            DLog.w(TAG, "bindMosaicView fail: you should set 'ViewGroup' type container in createViewInfo");
            if (onViewCreateListener != null) {
                onViewCreateListener.onViewInitializeError(9009);
            }
        }
    }

    private void bindView(DKEngine.CreateViewInfo createViewInfo) {
        DLog.i(TAG, "bindView, createInfo: " + createViewInfo);
        if (createViewInfo == null) {
            DLog.w(TAG, "createView fail: createViewInfo is null");
            return;
        }
        final DKEngine.OnViewCreateListener onViewCreateListener = createViewInfo.onViewCreateListener;
        if (onViewCreateListener == null) {
            DLog.w(TAG, "createView fail: onViewCreateListener is null.");
            return;
        }
        onViewCreateListener.onViewCreateStart();
        Map<String, String> map = createViewInfo.params;
        if (map == null) {
            DLog.w(TAG, "params is null.");
            onMosaicViewCreateFail(onViewCreateListener, 9004, null);
            return;
        }
        final String str = map.get(DKEngine.PARAM_KEY_AD_TYPE);
        String str2 = map.get(DKEngine.PARAM_KEY_APP_NAME);
        List<j> readJsContentList = readJsContentList(createViewInfo.context, map, this.mBundleInfo);
        if (!f.k().u() && (readJsContentList == null || readJsContentList.size() == 0)) {
            DLog.w(TAG, "js contents is empty.");
            onMosaicViewCreateFail(onViewCreateListener, 9006, str);
            return;
        }
        String readTemplateContent = readTemplateContent(map);
        if (!f.k().v() && TextUtils.isEmpty(readTemplateContent) && this.mIsRequiredTemplate) {
            DLog.w(TAG, "template content is empty.");
            onMosaicViewCreateFail(onViewCreateListener, 9010, str);
            return;
        }
        k kVar = new k(readTemplateContent, map.get(PARAM_KEY_AD_INFO), this.mCommonJSContents, readJsContentList);
        View view = createViewInfo.container;
        com.tencent.ams.mosaic.d dVar = new com.tencent.ams.mosaic.d(map, kVar) { // from class: com.tencent.ams.dsdk.core.mosaic.DKMosaicEngine.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ k val$mosaicTemplate;
            final /* synthetic */ Map val$params;

            {
                this.val$params = map;
                this.val$mosaicTemplate = kVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, DKMosaicEngine.this, map, kVar);
                }
            }

            @Override // com.tencent.ams.mosaic.d
            public com.tencent.ams.mosaic.jsengine.a getJSEngine() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                    return DKMosaicEngine.this.mJsEngine;
                }
                return (com.tencent.ams.mosaic.jsengine.a) iPatchRedirector.redirect((short) 5, (Object) this);
            }

            @Override // com.tencent.ams.mosaic.d
            public int getRootViewHeight() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
                }
                try {
                    return Integer.parseInt((String) this.val$params.get(DKEngine.PARAM_KEY_ROOT_VIEW_HEIGHT));
                } catch (NumberFormatException unused) {
                    return 0;
                }
            }

            @Override // com.tencent.ams.mosaic.d
            public int getRootViewWidth() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
                }
                try {
                    return Integer.parseInt((String) this.val$params.get(DKEngine.PARAM_KEY_ROOT_VIEW_WIDTH));
                } catch (NumberFormatException unused) {
                    return 0;
                }
            }

            @Override // com.tencent.ams.mosaic.d
            public k getTemplate() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (k) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                return this.val$mosaicTemplate;
            }

            @Override // com.tencent.ams.mosaic.d
            public boolean isRequiredTemplate() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                    return DKMosaicEngine.this.mIsRequiredTemplate;
                }
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
        };
        final DKEngine.OnViewCreateExtraEventListener onViewCreateExtraEventListener = createViewInfo.onViewCreateExtraEventListener;
        if (onViewCreateExtraEventListener != null) {
            MosaicManager.j().n(new MosaicManager.f() { // from class: com.tencent.ams.dsdk.core.mosaic.a
                @Override // com.tencent.ams.mosaic.MosaicManager.f
                public final void a(String str3, String str4) {
                    DKMosaicEngine.lambda$bindView$0(DKEngine.OnViewCreateExtraEventListener.this, str3, str4);
                }
            });
        }
        final ModuleInfo moduleInfo = ModuleConfigCache.getModuleInfo(str2);
        final long uptimeMillis = SystemClock.uptimeMillis();
        DynamicReporter.reportDynamicRenderStart(moduleInfo, TagValue.MOSAIC);
        MosaicManager.j().g(createViewInfo.context, dVar, new AnonymousClass4(onViewCreateExtraEventListener, onViewCreateListener, str, uptimeMillis, moduleInfo, view));
        if (createViewInfo.createTimeOut <= 0) {
            return;
        }
        WorkThreadManager.getInstance().schedule(new Runnable() { // from class: com.tencent.ams.dsdk.core.mosaic.b
            @Override // java.lang.Runnable
            public final void run() {
                DKMosaicEngine.this.lambda$bindView$1(onViewCreateListener, str, uptimeMillis, moduleInfo);
            }
        }, createViewInfo.createTimeOut);
    }

    public static DKMosaicEngine getDKMosaicEngine(com.tencent.ams.mosaic.jsengine.a aVar) {
        return sEngineMap.get(aVar);
    }

    private static void initLogSupport() {
        DLog.LogSupport logSupport = DKConfiguration.getLogSupport();
        if (logSupport != null && f.k().m() == null) {
            f.k().M(new f.e() { // from class: com.tencent.ams.dsdk.core.mosaic.DKMosaicEngine.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) DLog.LogSupport.this);
                    }
                }

                @Override // com.tencent.ams.mosaic.f.e
                public void d(String str, String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
                    } else {
                        DLog.LogSupport.this.d(str, str2);
                    }
                }

                @Override // com.tencent.ams.mosaic.f.e
                public void e(String str, String str2, Throwable th5) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                        iPatchRedirector.redirect((short) 7, this, str, str2, th5);
                    } else {
                        DLog.LogSupport.this.e(str, str2, th5);
                    }
                }

                @Override // com.tencent.ams.mosaic.f.e
                public void i(String str, String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
                    } else {
                        DLog.LogSupport.this.i(str, str2);
                    }
                }

                @Override // com.tencent.ams.mosaic.f.e
                public void v(String str, String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
                    } else {
                        DLog.LogSupport.this.v(str, str2);
                    }
                }

                @Override // com.tencent.ams.mosaic.f.e
                public void w(String str, String str2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                        DLog.LogSupport.this.w(str, str2);
                    } else {
                        iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
                    }
                }

                @Override // com.tencent.ams.mosaic.f.e
                public void w(String str, String str2, Throwable th5) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                        DLog.LogSupport.this.w(str, str2, th5);
                    } else {
                        iPatchRedirector.redirect((short) 6, this, str, str2, th5);
                    }
                }
            });
        }
    }

    private boolean isEnvironmentNotSupport() {
        try {
            com.tencent.ams.mosaic.utils.f.a(TAG, "mosaic is support");
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$bindMosaicView$2(View view, MosaicView mosaicView, Runnable runnable) {
        DLog.i(TAG, "add mosiac view to container.");
        ((ViewGroup) view).addView(mosaicView.getView(), new FrameLayout.LayoutParams(-1, -1));
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$bindView$0(DKEngine.OnViewCreateExtraEventListener onViewCreateExtraEventListener, String str, String str2) {
        if (onViewCreateExtraEventListener != null) {
            onViewCreateExtraEventListener.onViewCreateExtraEvent(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindView$1(DKEngine.OnViewCreateListener onViewCreateListener, String str, long j3, ModuleInfo moduleInfo) {
        DLog.i(TAG, "createView info timeout");
        onMosaicViewCreateFail(onViewCreateListener, DKEngine.ViewCreateError.CREATE_TIME_OUT, str);
        DynamicReporter.reportDynamicRenderEnd(j3, TagValue.CREATE_TIME_OUT, moduleInfo, TagValue.MOSAIC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMosaicViewCreateFail(DKEngine.OnViewCreateListener onViewCreateListener, int i3, String str) {
        if (checkCreateHandledAndSetIfCan()) {
            return;
        }
        DLog.w(TAG, "createView fail errorCode: " + i3 + ", adType: " + str);
        if (onViewCreateListener != null) {
            onViewCreateListener.onViewCreate(null, i3);
        }
        DKEventCenter dKEventCenter = this.eventCenter;
        if (dKEventCenter != null) {
            dKEventCenter.fireViewCreateFail(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<j> readJsContentList(Context context, Map<String, String> map, ModuleInfo moduleInfo) {
        String str = map.get(DKEngine.PARAM_KEY_JS_FILE_PATH);
        String str2 = map.get(DKEngine.PARAM_KEY_JS_DEBUG_FILE_PATH);
        String str3 = map.get(DKEngine.PARAM_KEY_JS_ASSETS_PATH);
        map.get(DKEngine.PARAM_KEY_APP_NAME);
        ArrayList arrayList = new ArrayList();
        boolean equals = "1".equals(map.get(DKEngine.PARAM_KEY_IS_DEBUG_MODE));
        if (equals && !TextUtils.isEmpty(str3)) {
            readJsContentsFromAssert(context, arrayList, str3);
        } else if (equals && !TextUtils.isEmpty(str2)) {
            moduleInfo.setEncryptType(0);
            readJsContentsFromFile(arrayList, str2, moduleInfo);
        } else if (!TextUtils.isEmpty(str)) {
            readJsContentsFromFile(arrayList, str, moduleInfo);
        } else {
            DLog.w(TAG, "jsAssetsPath and jsFilePath are both empty");
            return null;
        }
        return arrayList;
    }

    private void readJsContentsFromAssert(Context context, List<j> list, String str) {
        try {
            for (String str2 : context.getResources().getAssets().list(str)) {
                if (str2.endsWith(PTSFileUtil.JS_FORMAT)) {
                    list.add(new j(MosaicUtils.T(context, str + "/" + str2), str2));
                } else if (!str2.contains(".")) {
                    readJsContentsFromAssert(context, list, str + "/" + str2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void readJsContentsFromFile(List<j> list, String str, ModuleInfo moduleInfo) {
        if (FileUtils.isFileExist(str)) {
            File file = new File(str);
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        readJsContentsFromFile(list, file2.getAbsolutePath(), moduleInfo);
                    }
                    return;
                }
                return;
            }
            if (file.isFile() && str.endsWith(PTSFileUtil.JS_FORMAT)) {
                try {
                    byte[] readBytesFromFile = FileUtils.readBytesFromFile(str);
                    if (moduleInfo != null && moduleInfo.getEncryptType() == 2) {
                        list.add(new j(readBytesFromFile, str));
                    } else {
                        list.add(new j(new String(readBytesFromFile), str));
                    }
                } catch (Throwable th5) {
                    DLog.e(TAG, "read js file error. file: " + str, th5);
                }
            }
        }
    }

    private String readTemplateContent(Map<String, String> map) {
        String str;
        String str2 = map.get(DKEngine.PARAM_KEY_TEMPLATE_ID);
        if (!TextUtils.isEmpty(str2)) {
            str = TemplateManager.getInstance().getTemplatePath(str2, false, 0L, map.get(DKEngine.PARAM_KEY_SCENE));
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = map.get(PARAM_KEY_TEMPLATE_FILE_PATH);
        }
        if (!TextUtils.isEmpty(str)) {
            return MosaicUtils.U(str);
        }
        String str3 = map.get(PARAM_KEY_TEMPLATE_ASSERT_PATH);
        if (!TextUtils.isEmpty(str3)) {
            return MosaicUtils.T(DKEngine.getApplicationContext(), str3);
        }
        DLog.w(TAG, "readTemplateContent failed");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMosaicImageLoader(com.tencent.ams.mosaic.jsengine.a aVar, f.c cVar) {
        if (aVar != null) {
            if (DKConfiguration.isEnableResourcePreload()) {
                cVar = new DKImagePreloader(cVar);
            }
            aVar.e(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMosaicVideoLoader(com.tencent.ams.mosaic.jsengine.a aVar, VideoLoader videoLoader) {
        if (aVar != null) {
            if (videoLoader != null) {
                aVar.q(new DKDefaultMosaicVideoLoader(videoLoader));
            } else {
                aVar.q(null);
            }
        }
    }

    protected synchronized boolean checkCreateHandledAndSetIfCan() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.mCreateHandled) {
            return true;
        }
        this.mCreateHandled = true;
        return false;
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public /* bridge */ /* synthetic */ void createEngine(Context context, Map map, OnCreateMosaicEngineListener onCreateMosaicEngineListener) {
        createEngine2(context, (Map<String, String>) map, onCreateMosaicEngineListener);
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public int getEngineGroupId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public DKEventCenter.EngineType getEngineType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (DKEventCenter.EngineType) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return DKEventCenter.EngineType.MOSAIC;
    }

    public com.tencent.ams.mosaic.jsengine.a getJsEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.ams.mosaic.jsengine.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mJsEngine;
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    protected /* bridge */ /* synthetic */ void handleCreateEngine(Context context, Map map, OnCreateMosaicEngineListener onCreateMosaicEngineListener) {
        handleCreateEngine2(context, (Map<String, String>) map, onCreateMosaicEngineListener);
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public void handleViewCreate(DKEngine.CreateViewInfo createViewInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) createViewInfo);
            return;
        }
        DLog.i(TAG, "handleViewCreate, createInfo: " + createViewInfo);
        if (createViewInfo != null && createViewInfo.onViewCreateListener != null) {
            if (isEnvironmentNotSupport()) {
                DLog.w(TAG, "createView error: env not support.");
                DKEngine.OnViewCreateListener onViewCreateListener = createViewInfo.onViewCreateListener;
                if (onViewCreateListener != null) {
                    onViewCreateListener.onViewInitializeError(9008);
                    return;
                }
                return;
            }
            if (!this.mIsInitialized) {
                DLog.w(TAG, "engine is not initialized.");
                DKEngine.OnViewCreateListener onViewCreateListener2 = createViewInfo.onViewCreateListener;
                if (onViewCreateListener2 != null) {
                    onViewCreateListener2.onViewInitializeError(9002);
                    return;
                }
                return;
            }
            bindView(createViewInfo);
            return;
        }
        DLog.w(TAG, "create view info is null or listener is null.");
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public boolean isEnginePreWarmed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.mIsInitialized;
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public boolean onBackPressed(DKEngine.BackPressHandler backPressHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) backPressHandler)).booleanValue();
        }
        DLog.i(TAG, "onBackPressed");
        return false;
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        DLog.i(TAG, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        if (this.mJsEngine != null) {
            DLog.i(TAG, "do close engien");
            sEngineMap.remove(this.mJsEngine);
            this.mJsEngine.close();
        }
        MosaicView mosaicView = this.mMosaicView;
        if (mosaicView != null) {
            mosaicView.destroy();
            this.mMosaicView = null;
        }
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            DLog.i(TAG, "onResume");
        }
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            DLog.i(TAG, DKHippyEvent.EVENT_STOP);
        }
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public void sendEvent(String str, Object obj) {
        com.tencent.ams.mosaic.jsengine.a jSEngine;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str, obj);
            return;
        }
        DLog.i(TAG, "sendEvent, event: " + str);
        MosaicView mosaicView = this.mMosaicView;
        if (mosaicView == null) {
            jSEngine = null;
        } else {
            jSEngine = mosaicView.getJSEngine();
        }
        if (jSEngine != null) {
            jSEngine.n(str, new Object[]{obj}, new a.b() { // from class: com.tencent.ams.dsdk.core.mosaic.DKMosaicEngine.5
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKMosaicEngine.this);
                    }
                }

                @Override // com.tencent.ams.mosaic.jsengine.a.b
                public void onFail(JSFunction jSFunction) {
                    String funcName;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) jSFunction);
                        return;
                    }
                    if (jSFunction == null) {
                        funcName = null;
                    } else {
                        funcName = jSFunction.getFuncName();
                    }
                    DLog.i(DKMosaicEngine.TAG, "send event onFail. function: " + funcName);
                }

                @Override // com.tencent.ams.mosaic.jsengine.a.b
                public void onSuccess(JSFunction jSFunction, JSValue jSValue) {
                    String funcName;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) jSFunction, (Object) jSValue);
                        return;
                    }
                    if (jSFunction == null) {
                        funcName = null;
                    } else {
                        funcName = jSFunction.getFuncName();
                    }
                    DLog.i(DKMosaicEngine.TAG, "send event success. functionName: " + funcName);
                }
            });
        }
    }

    public void sendMosaicEvent(String str, Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, (Object) map);
            return;
        }
        DLog.i(TAG, "sendMosaicEvent, eventKey: " + str);
        com.tencent.ams.mosaic.jsengine.a aVar = this.mJsEngine;
        if (aVar != null && aVar.g() != null) {
            this.mJsEngine.g().b(new g(str, map));
        }
    }

    public void setDebugJs(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            f.k().H(z16);
        }
    }

    public void setDebugTemplate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            f.k().J(z16);
        }
    }

    public void setImageLoader(f.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
        } else {
            this.mImageLoader = cVar;
            setMosaicImageLoader(this.mJsEngine, cVar);
        }
    }

    public void setRequiredTemplate(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
            return;
        }
        DLog.i(TAG, "setRequiredTemplate, isRequiredTemplate: " + z16);
        this.mIsRequiredTemplate = z16;
    }

    @Override // com.tencent.ams.dsdk.core.DKEngine
    public void setVideoLoader(VideoLoader videoLoader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) videoLoader);
        } else {
            super.setVideoLoader(videoLoader);
            setMosaicVideoLoader(this.mJsEngine, videoLoader);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class MosaicCreateEngineListener implements OnCreateMosaicEngineListener {
        static IPatchRedirector $redirector_;
        private final List<OnCreateMosaicEngineListener> mCreateEngineListeners;

        MosaicCreateEngineListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.mCreateEngineListeners = new ArrayList();
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void addListener(OnCreateMosaicEngineListener onCreateMosaicEngineListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) onCreateMosaicEngineListener);
            } else if (onCreateMosaicEngineListener != null) {
                this.mCreateEngineListeners.add(onCreateMosaicEngineListener);
            }
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
        public void onEngineInitializeError(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
                return;
            }
            Iterator<OnCreateMosaicEngineListener> it = this.mCreateEngineListeners.iterator();
            while (it.hasNext()) {
                it.next().onEngineInitializeError(i3);
            }
            this.mCreateEngineListeners.clear();
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
        public void onEngineInitialized() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            Iterator<OnCreateMosaicEngineListener> it = this.mCreateEngineListeners.iterator();
            while (it.hasNext()) {
                it.next().onEngineInitialized();
            }
            this.mCreateEngineListeners.clear();
        }

        @Override // com.tencent.ams.dsdk.core.mosaic.OnCreateMosaicEngineListener
        public void onSoLoadFailed(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, i3);
                return;
            }
            Iterator<OnCreateMosaicEngineListener> it = this.mCreateEngineListeners.iterator();
            while (it.hasNext()) {
                it.next().onSoLoadFailed(i3);
            }
        }

        @Override // com.tencent.ams.dsdk.core.mosaic.OnCreateMosaicEngineListener
        public void onSoLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            Iterator<OnCreateMosaicEngineListener> it = this.mCreateEngineListeners.iterator();
            while (it.hasNext()) {
                it.next().onSoLoadStart();
            }
        }

        @Override // com.tencent.ams.dsdk.core.mosaic.OnCreateMosaicEngineListener
        public void onSoLoadSuccess(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
                return;
            }
            Iterator<OnCreateMosaicEngineListener> it = this.mCreateEngineListeners.iterator();
            while (it.hasNext()) {
                it.next().onSoLoadSuccess(i3);
            }
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
        public void onWillCreateEngine() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            Iterator<OnCreateMosaicEngineListener> it = this.mCreateEngineListeners.iterator();
            while (it.hasNext()) {
                it.next().onWillCreateEngine();
            }
        }

        /* synthetic */ MosaicCreateEngineListener(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                return;
            }
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) anonymousClass1);
        }
    }

    /* renamed from: createEngine, reason: avoid collision after fix types in other method */
    public synchronized void createEngine2(Context context, Map<String, String> map, OnCreateMosaicEngineListener onCreateMosaicEngineListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, context, map, onCreateMosaicEngineListener);
            return;
        }
        DLog.i(TAG, "createEngine, params: " + map);
        if (isEnvironmentNotSupport()) {
            DLog.w(TAG, "createEngine error: env not support.");
            return;
        }
        if (onCreateMosaicEngineListener != null) {
            this.mCreateEngineListener.addListener(onCreateMosaicEngineListener);
        }
        if (this.mIsEngineCreating) {
            DLog.w(TAG, "engine is creating.");
            return;
        }
        this.mIsEngineCreating = true;
        this.mCreateEngineListener.onWillCreateEngine();
        super.createEngine(context, map, (Map<String, String>) onCreateMosaicEngineListener);
    }

    /* renamed from: handleCreateEngine, reason: avoid collision after fix types in other method */
    protected void handleCreateEngine2(Context context, Map<String, String> map, OnCreateMosaicEngineListener onCreateMosaicEngineListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, context, map, onCreateMosaicEngineListener);
            return;
        }
        DLog.i(TAG, "handleCreateEngine, params: " + map);
        WorkThreadManager.getInstance().getImmediateThreadPool().execute(new Runnable(context, map, onCreateMosaicEngineListener) { // from class: com.tencent.ams.dsdk.core.mosaic.DKMosaicEngine.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context val$context;
            final /* synthetic */ OnCreateMosaicEngineListener val$onCreateEngineListener;
            final /* synthetic */ Map val$params;

            {
                this.val$context = context;
                this.val$params = map;
                this.val$onCreateEngineListener = onCreateMosaicEngineListener;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, DKMosaicEngine.this, context, map, onCreateMosaicEngineListener);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (((DKEngine) DKMosaicEngine.this).mIsDebugMode) {
                    f.k().I(((DKEngine) DKMosaicEngine.this).mModuleId);
                }
                DKMosaicEngine dKMosaicEngine = DKMosaicEngine.this;
                dKMosaicEngine.mCommonJSContents = dKMosaicEngine.readJsContentList(this.val$context, this.val$params, ((DKEngine) dKMosaicEngine).mVendorInfo);
                if (!((DKEngine) DKMosaicEngine.this).mIsDebugMode && (DKMosaicEngine.this.mCommonJSContents == null || DKMosaicEngine.this.mCommonJSContents.size() == 0)) {
                    DLog.w(DKMosaicEngine.TAG, "common js contents is empty.");
                    OnCreateMosaicEngineListener onCreateMosaicEngineListener2 = this.val$onCreateEngineListener;
                    if (onCreateMosaicEngineListener2 != null) {
                        onCreateMosaicEngineListener2.onEngineInitializeError(6);
                    }
                    DKMosaicEngine.this.mIsEngineCreating = false;
                    return;
                }
                MosaicManager.j().f(this.val$context, DKMosaicEngine.this.mCommonJSContents, new MosaicManager.d() { // from class: com.tencent.ams.dsdk.core.mosaic.DKMosaicEngine.2.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                        }
                    }

                    @Override // com.tencent.ams.mosaic.MosaicManager.d
                    public void onEngineCreateFail(int i3) {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 8)) {
                            iPatchRedirector3.redirect((short) 8, (Object) this, i3);
                            return;
                        }
                        DLog.i(DKMosaicEngine.TAG, "onEngineCreateFail, errorCode: " + i3);
                        OnCreateMosaicEngineListener onCreateMosaicEngineListener3 = AnonymousClass2.this.val$onCreateEngineListener;
                        if (onCreateMosaicEngineListener3 != null) {
                            onCreateMosaicEngineListener3.onEngineInitializeError(i3);
                        }
                        DKMosaicEngine.this.mIsEngineCreating = false;
                    }

                    @Override // com.tencent.ams.mosaic.MosaicManager.d
                    public void onEngineCreateStart() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        } else {
                            DLog.i(DKMosaicEngine.TAG, "onEngineCreateStart");
                        }
                    }

                    @Override // com.tencent.ams.mosaic.MosaicManager.d
                    public void onEngineCreated(com.tencent.ams.mosaic.jsengine.a aVar) {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 7)) {
                            iPatchRedirector3.redirect((short) 7, (Object) this, (Object) aVar);
                            return;
                        }
                        DLog.i(DKMosaicEngine.TAG, "handleCreateEngine onEngineCreated");
                        if (DKEngine.DKModuleID.XJ_PAGE.equals(((DKEngine) DKMosaicEngine.this).mModuleId)) {
                            aVar.o(ComponentFactory.ComponentType.VIDEO, VideoComponentImpl.class);
                        }
                        DKMosaicEngine.this.mJsEngine = aVar;
                        f.k().K(aVar, new DKMosaicDownloadManagerImpl(DKEngine.getApplicationContext(), DKMosaicEngine.this));
                        DKMosaicEngine.this.mIsInitialized = true;
                        OnCreateMosaicEngineListener onCreateMosaicEngineListener3 = AnonymousClass2.this.val$onCreateEngineListener;
                        if (onCreateMosaicEngineListener3 != null) {
                            onCreateMosaicEngineListener3.onEngineInitialized();
                        }
                        DKMosaicEngine.this.mIsEngineCreating = false;
                    }

                    @Override // com.tencent.ams.mosaic.MosaicManager.d
                    public void onEngineInjectStart(com.tencent.ams.mosaic.jsengine.a aVar) {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 3)) {
                            iPatchRedirector3.redirect((short) 3, (Object) this, (Object) aVar);
                            return;
                        }
                        DLog.i(DKMosaicEngine.TAG, "onEngineInjectStart");
                        DKMosaicEngine.sEngineMap.put(aVar, DKMosaicEngine.this);
                        aVar.k(new DKMosaicNativeApiProvider(((DKEngine) DKMosaicEngine.this).mMethodDispatcher));
                        aVar.g().a(new DKMosaicEventHandler(((DKEngine) DKMosaicEngine.this).mMethodDispatcher));
                        DKMosaicEngine dKMosaicEngine2 = DKMosaicEngine.this;
                        dKMosaicEngine2.setMosaicImageLoader(aVar, dKMosaicEngine2.mImageLoader);
                        DKMosaicEngine dKMosaicEngine3 = DKMosaicEngine.this;
                        dKMosaicEngine3.setMosaicVideoLoader(aVar, dKMosaicEngine3.getVideoLoader());
                    }

                    @Override // com.tencent.ams.mosaic.MosaicManager.d
                    public void onSoLoadFail(int i3) {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 5)) {
                            iPatchRedirector3.redirect((short) 5, (Object) this, i3);
                            return;
                        }
                        DLog.i(DKMosaicEngine.TAG, "onSoLoadFail, errorCode: " + i3);
                        OnCreateMosaicEngineListener onCreateMosaicEngineListener3 = AnonymousClass2.this.val$onCreateEngineListener;
                        if (onCreateMosaicEngineListener3 != null) {
                            onCreateMosaicEngineListener3.onSoLoadFailed(i3);
                        }
                    }

                    @Override // com.tencent.ams.mosaic.MosaicManager.d
                    public void onSoLoadStart() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 4)) {
                            iPatchRedirector3.redirect((short) 4, (Object) this);
                            return;
                        }
                        DLog.i(DKMosaicEngine.TAG, "onSoLoadStart");
                        OnCreateMosaicEngineListener onCreateMosaicEngineListener3 = AnonymousClass2.this.val$onCreateEngineListener;
                        if (onCreateMosaicEngineListener3 != null) {
                            onCreateMosaicEngineListener3.onSoLoadStart();
                        }
                    }

                    @Override // com.tencent.ams.mosaic.MosaicManager.d
                    public void onSoLoadSuccess(int i3) {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 6)) {
                            iPatchRedirector3.redirect((short) 6, (Object) this, i3);
                            return;
                        }
                        DLog.i(DKMosaicEngine.TAG, "onSoLoadSuccess, status: " + i3);
                        OnCreateMosaicEngineListener onCreateMosaicEngineListener3 = AnonymousClass2.this.val$onCreateEngineListener;
                        if (onCreateMosaicEngineListener3 != null) {
                            onCreateMosaicEngineListener3.onSoLoadSuccess(i3);
                        }
                    }
                });
            }
        });
    }
}

package com.tencent.gdtad.api.hippy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.hippy.qq.api.IHippyAdapter;
import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.hippy.qq.api.LibraryLoadListener;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtHippyDemoFragment extends QPublicBaseFragment implements View.OnClickListener {
    private HippyEngine C;
    private HippyRootView D;
    private boolean E;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class b implements HippyExceptionHandlerAdapter {
        b() {
        }

        @Override // com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter
        public void handleBackgroundTracing(String str) {
            GdtLog.e("GdtHippyDemoFragment", str);
        }

        @Override // com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter
        public void handleJsException(HippyJsException hippyJsException) {
            GdtLog.e("GdtHippyDemoFragment", hippyJsException.getMessage() + hippyJsException.getStack());
        }

        @Override // com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter
        public void handleNativeException(Exception exc, boolean z16) {
            GdtLog.e("GdtHippyDemoFragment", exc.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class c implements HippyEngine.EngineListener {

        /* compiled from: P */
        /* loaded from: classes6.dex */
        class a implements HippyEngine.ModuleListener {
            a() {
            }

            @Override // com.tencent.mtt.hippy.HippyEngine.ModuleListener
            public boolean onJsException(HippyJsException hippyJsException) {
                return true;
            }

            @Override // com.tencent.mtt.hippy.HippyEngine.ModuleListener
            public void onLoadCompleted(HippyEngine.ModuleLoadStatus moduleLoadStatus, String str, HippyRootView hippyRootView) {
                if (moduleLoadStatus != HippyEngine.ModuleLoadStatus.STATUS_OK) {
                    GdtLog.e("GdtHippyDemoFragment", "loadModule failed code:" + moduleLoadStatus + ", msg=" + str);
                }
            }
        }

        c() {
        }

        @Override // com.tencent.mtt.hippy.HippyEngine.EngineListener
        public void onInitialized(HippyEngine.EngineInitStatus engineInitStatus, String str) {
            if (engineInitStatus != HippyEngine.EngineInitStatus.STATUS_OK) {
                GdtLog.e("GdtHippyDemoFragment", "hippy engine init failed code:" + engineInitStatus + ", msg=" + str);
                return;
            }
            HippyEngine.ModuleLoadParams moduleLoadParams = new HippyEngine.ModuleLoadParams();
            moduleLoadParams.context = GdtHippyDemoFragment.this.getActivity();
            moduleLoadParams.componentName = "Demo";
            moduleLoadParams.codeCacheTag = "Demo";
            moduleLoadParams.jsAssetsPath = "index.android.js";
            moduleLoadParams.jsFilePath = null;
            HippyMap hippyMap = new HippyMap();
            moduleLoadParams.jsParams = hippyMap;
            hippyMap.pushString("msgFromNative", "Hi js developer, I come from native code!");
            a aVar = new a();
            GdtHippyDemoFragment gdtHippyDemoFragment = GdtHippyDemoFragment.this;
            gdtHippyDemoFragment.D = gdtHippyDemoFragment.C.loadModule(moduleLoadParams, aVar, null);
            if (GdtHippyDemoFragment.this.getActivity() == null) {
                GdtLog.e("GdtHippyDemoFragment", "getActivity is null");
            } else {
                GdtHippyDemoFragment.this.getActivity().setContentView(GdtHippyDemoFragment.this.D);
            }
        }
    }

    public static void start(Activity activity, Class<? extends QPublicBaseFragment> cls) {
        th(activity, cls, new Bundle());
    }

    private static void th(Activity activity, Class<? extends QPublicBaseFragment> cls, Bundle bundle) {
        if (activity != null && bundle != null) {
            GdtLog.i("GdtHippyDemoFragment", "start");
            Intent intent = new Intent();
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
            intent.putExtras(bundle);
            QPublicFragmentActivity.start(activity, intent, cls);
            return;
        }
        GdtLog.i("GdtHippyDemoFragment", "start error");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == null) {
            GdtLog.e("GdtHippyDemoFragment", "[onClick] view is null");
        } else if (view.getId() == R.id.tdy) {
            this.E = true;
        } else if (view.getId() == R.id.tgx) {
            if (!((IHippyLibrary) QRoute.api(IHippyLibrary.class)).isLibraryLoaded()) {
                GdtLog.i("GdtHippyDemoFragment", "[init] isLibraryLoaded : false");
                ((IHippyLibrary) QRoute.api(IHippyLibrary.class)).loadLibraryIfNeed(new a());
            } else {
                sh();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.eck, viewGroup, false);
        inflate.findViewById(R.id.tdy).setOnClickListener(this);
        inflate.findViewById(R.id.tgx).setOnClickListener(this);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        HippyEngine hippyEngine = this.C;
        if (hippyEngine != null) {
            hippyEngine.destroyModule(this.D);
            this.C.destroyEngine();
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        HippyEngine hippyEngine = this.C;
        if (hippyEngine != null) {
            hippyEngine.onEngineResume();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        HippyEngine hippyEngine = this.C;
        if (hippyEngine != null) {
            hippyEngine.onEnginePause();
        }
    }

    public void sh() {
        GdtLog.i("GdtHippyDemoFragment", "initEngineAndShow");
        HippyEngine.EngineInitParams engineInitParams = new HippyEngine.EngineInitParams();
        engineInitParams.context = getActivity();
        engineInitParams.imageLoader = ((IHippyAdapter) QRoute.api(IHippyAdapter.class)).createImageLoader();
        engineInitParams.debugServerHost = "localhost:38989";
        engineInitParams.debugMode = this.E;
        engineInitParams.enableLog = false;
        engineInitParams.coreJSAssetsPath = "vendor.android.js";
        engineInitParams.codeCacheTag = "common";
        engineInitParams.exceptionHandler = new b();
        ArrayList arrayList = new ArrayList();
        HippyUtils.addBaseApiProvider(arrayList);
        engineInitParams.providers = arrayList;
        HippyEngine create = HippyEngine.create(engineInitParams);
        this.C = create;
        create.initEngine(new c());
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements LibraryLoadListener {
        a() {
        }

        @Override // com.tencent.hippy.qq.api.LibraryLoadListener
        public void onLoadSuccess() {
            GdtHippyDemoFragment.this.sh();
            QQToast.makeText(GdtHippyDemoFragment.this.getActivity(), 0, "\u52a0\u8f7d\u6846\u67b6\u6210\u529f", 0).show();
        }

        @Override // com.tencent.hippy.qq.api.LibraryLoadListener
        public void onLoadFail(int i3, String str) {
        }
    }
}

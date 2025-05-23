package com.tencent.ams.dsdk.core.mosaic;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ams.dsdk.cache.SoConfigCache;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.data.SoConfig;
import com.tencent.ams.dsdk.data.SoInfo;
import com.tencent.ams.dsdk.data.SoPlatform;
import com.tencent.ams.dsdk.fodder.SoConfigManager;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.ams.dsdk.view.webview.DKMosaicWebViewComponentImpl;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.ams.mosaic.load.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKMosaicEngineHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKMosaicEngineHelper";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Holder {
        static IPatchRedirector $redirector_;
        private static final DKMosaicEngineHelper INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15345);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new DKMosaicEngineHelper(null);
            }
        }

        Holder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ DKMosaicEngineHelper(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
    }

    public static DKMosaicEngineHelper getInstance() {
        return Holder.INSTANCE;
    }

    private void init() {
        DLog.i(TAG, "init");
        f.k().G(new f.a() { // from class: com.tencent.ams.dsdk.core.mosaic.DKMosaicEngineHelper.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKMosaicEngineHelper.this);
                }
            }

            @Override // com.tencent.ams.mosaic.f.a
            public void execute(Runnable runnable) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
                } else {
                    WorkThreadManager.getInstance().getImmediateThreadPool().execute(runnable);
                }
            }
        });
        f.k().E(ComponentFactory.ComponentType.VIDEO, DKMosaicVideoComponent.class);
        f.k().E("WebView", DKMosaicWebViewComponentImpl.class);
        f.k().O("dsdk" + File.separator + DKConfiguration.Directory.RESOURCES);
        SoConfigManager.getInstance().registerOnSoConfigUpdateListener(new DKMosaicSoUpdateListener());
        f.k().L(new DKMosaicDownloadManagerImpl(DKEngine.getApplicationContext()));
        f.k().N(new DKMosaicSoDownloadListener());
    }

    private e toSoItem(SoInfo soInfo) {
        if (soInfo != null && !TextUtils.isEmpty(soInfo.url) && !TextUtils.isEmpty(soInfo.md5)) {
            return new e(soInfo.url, soInfo.md5, soInfo.name, soInfo.priority);
        }
        return null;
    }

    private List<e> toSoItems(List<SoInfo> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<SoInfo> it = list.iterator();
            while (it.hasNext()) {
                e soItem = toSoItem(it.next());
                if (soItem != null) {
                    arrayList.add(soItem);
                }
            }
            return arrayList;
        }
        return null;
    }

    public List<com.tencent.ams.mosaic.load.d> getQuickJSSoConfigs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        SoConfig soConfig = SoConfigCache.getInstance().getSoConfig(1);
        ArrayList arrayList = new ArrayList();
        com.tencent.ams.mosaic.load.d quickJSSOConfig = toQuickJSSOConfig(soConfig);
        if (soConfig != null) {
            arrayList.add(quickJSSOConfig);
        }
        DLog.i(TAG, "getQuickJSSoConfigs, configList: " + arrayList);
        return arrayList;
    }

    public void initSoConfig(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            f.k().R(DKConfiguration.isUseNewSoLoader());
            f.k().P(context, getQuickJSSoConfigs());
        }
    }

    public com.tencent.ams.mosaic.load.d toQuickJSSOConfig(SoConfig soConfig) {
        List<SoPlatform> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.ams.mosaic.load.d) iPatchRedirector.redirect((short) 4, (Object) this, (Object) soConfig);
        }
        if (soConfig == null || (list = soConfig.platforms) == null || list.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (SoPlatform soPlatform : soConfig.platforms) {
            if (soPlatform != null) {
                List<e> soItems = toSoItems(soPlatform.soList);
                if (!TextUtils.isEmpty(soPlatform.abi) && soItems != null && !soItems.isEmpty()) {
                    hashMap.put(soPlatform.abi, soItems);
                }
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return new com.tencent.ams.mosaic.load.d(soConfig.version, hashMap);
    }

    DKMosaicEngineHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            init();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

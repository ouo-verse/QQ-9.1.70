package com.tencent.mobileqq.qqvideoplatform.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqvideoplatform.api.IQQVideoSDKConfigMgr;
import com.tencent.mobileqq.qqvideoplatform.api.IVideoSoLoader;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.videoplatform.api.LoadSoCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class VideoSoLoaderImpl implements IVideoSoLoader {
    static IPatchRedirector $redirector_ = null;
    private static final String DOWNLOAD_SO_PREFIX = "DownloadProxy";
    public static final String TAG = "[VideoPlatform]VideoSoManagerImpl";
    private static final String TPCORE_SO_PREFIX = "TPCore";

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements OnLoadListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VideoSoLoaderImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
        public void onLoadResult(int i3, LoadExtResult loadExtResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) loadExtResult);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(VideoSoLoaderImpl.TAG, 2, "onLoadResult: loadFromAAR=true, loadCkeySo, resCode = " + i3 + ", loadExtResult = " + loadExtResult);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class b implements OnLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoadSoCallback f276401a;

        b(LoadSoCallback loadSoCallback) {
            this.f276401a = loadSoCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VideoSoLoaderImpl.this, (Object) loadSoCallback);
            }
        }

        @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
        public void onLoadResult(int i3, LoadExtResult loadExtResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) loadExtResult);
                return;
            }
            if (LogUtil.isColorLevel()) {
                LogUtil.d(VideoSoLoaderImpl.TAG, 2, "initSDKAsync, onLoadResult, resCode = " + i3 + ", loadExtResult = " + loadExtResult);
            }
            if (i3 == 0) {
                this.f276401a.onLoad(true);
            } else {
                this.f276401a.onLoad(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class c implements OnLoadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f276403a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LoadSoCallback f276404b;

        c(String str, LoadSoCallback loadSoCallback) {
            this.f276403a = str;
            this.f276404b = loadSoCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, VideoSoLoaderImpl.this, str, loadSoCallback);
            }
        }

        @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
        public void onLoadResult(int i3, LoadExtResult loadExtResult) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) loadExtResult);
                return;
            }
            if (LogUtil.isColorLevel()) {
                LogUtil.d(VideoSoLoaderImpl.TAG, 2, "loadSoAsync: " + this.f276403a + " ,onLoadResult, resCode = " + i3 + ", loadExtResult = " + loadExtResult);
            }
            LoadSoCallback loadSoCallback = this.f276404b;
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            loadSoCallback.onLoad(z16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class d implements OnLoadListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) VideoSoLoaderImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
        public void onLoadResult(int i3, LoadExtResult loadExtResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) loadExtResult);
                return;
            }
            if (LogUtil.isColorLevel()) {
                LogUtil.d(VideoSoLoaderImpl.TAG, 2, "preloadSo, onLoadResult, resCode = " + i3 + ", loadExtResult = " + loadExtResult);
            }
        }
    }

    public VideoSoLoaderImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String[] getCkeySoNamesForDebug() {
        return new String[]{"ckguard", "ckeygeneratorV2"};
    }

    private static String[] getSoNames() {
        ArrayList arrayList = new ArrayList(Arrays.asList("ckguard", "ckeygeneratorV2"));
        arrayList.addAll(getThumbSoNamesFromConfig());
        if (LogUtil.isColorLevel()) {
            LogUtil.d(TAG, 2, "loadSo, soNames  = " + arrayList);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private String getTargetSoName(String str, String str2) {
        for (String str3 : getSoNames()) {
            if (str3.contains(str)) {
                str2 = str3;
            }
        }
        return str2;
    }

    private static String[] getThumbSoNameForDebug() {
        return (String[]) getThumbSoNamesFromConfig().toArray(new String[0]);
    }

    private static ArrayList<String> getThumbSoNamesFromConfig() {
        ArrayList<String> arrayList = new ArrayList<>();
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeString(IQQVideoSDKConfigMgr.CONFIG_KEY_SUPERPLAYER_SO_NAMES, "");
        arrayList.add(SoLoadConstants.SONAME_TPCORE_MASTER);
        arrayList.add(SoLoadConstants.SONAME_DOWNLOADPROXY);
        return arrayList;
    }

    private void loadSoAsync(boolean z16, String str, LoadSoCallback loadSoCallback) {
        if (z16) {
            try {
                System.loadLibrary(str);
                loadSoCallback.onLoad(true);
                return;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "loadSoAsync: " + str + ", loadFromAAR=true, loadThumbSo error", th5);
                loadSoCallback.onLoad(false);
                return;
            }
        }
        SoLoadManager.getInstance().load(str, new c(str, loadSoCallback));
    }

    private boolean loadSoSync(boolean z16, String str) {
        boolean z17 = false;
        if (z16) {
            try {
                System.loadLibrary(str);
                return true;
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "loadSoSync: soName=" + str + ", loadFromAAR=true, loadThumbSo error", th5);
                return false;
            }
        }
        LoadExtResult loadSync = SoLoadManager.getInstance().loadSync(str);
        if (loadSync != null) {
            z17 = loadSync.isSucc();
        }
        if (LogUtil.isColorLevel()) {
            LogUtil.d(TAG, 2, "loadSoSync, soName=" + str + ", bDownProxyResult  = " + z17);
        }
        return z17;
    }

    @Override // com.tencent.mobileqq.qqvideoplatform.api.IVideoSoLoader
    public boolean isAllSoExist(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, z16)).booleanValue();
        }
        if (z16) {
            return true;
        }
        return SoLoadManager.getInstance().isExist(getSoNames());
    }

    @Override // com.tencent.mobileqq.qqvideoplatform.api.IVideoSoLoader
    public boolean isDownloadSoExist(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, z16)).booleanValue();
        }
        if (z16) {
            return true;
        }
        return SoLoadManager.getInstance().isExist(getTargetSoName("DownloadProxy", SoLoadConstants.SONAME_DOWNLOADPROXY));
    }

    @Override // com.tencent.mobileqq.qqvideoplatform.api.IVideoSoLoader
    public boolean isTpCoreSoExist(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, z16)).booleanValue();
        }
        if (z16) {
            return true;
        }
        return SoLoadManager.getInstance().isExist(getTargetSoName("TPCore", SoLoadConstants.SONAME_TPCORE_MASTER));
    }

    @Override // com.tencent.mobileqq.qqvideoplatform.api.IVideoSoLoader
    public void loadDownProxyAsync(boolean z16, LoadSoCallback loadSoCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), loadSoCallback);
        } else {
            loadSoAsync(z16, getTargetSoName("DownloadProxy", SoLoadConstants.SONAME_DOWNLOADPROXY), loadSoCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoplatform.api.IVideoSoLoader
    public boolean loadDownProxySync(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, z16)).booleanValue();
        }
        return loadSoSync(z16, getTargetSoName("DownloadProxy", SoLoadConstants.SONAME_DOWNLOADPROXY));
    }

    @Override // com.tencent.mobileqq.qqvideoplatform.api.IVideoSoLoader
    public void loadMonetSo(LoadSoCallback loadSoCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) loadSoCallback);
        } else {
            loadSoAsync(false, SoLoadConstants.MONET_SO, loadSoCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoplatform.api.IVideoSoLoader
    public void loadSo(boolean z16, LoadSoCallback loadSoCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), loadSoCallback);
            return;
        }
        if (z16) {
            SoLoadManager.getInstance().loadSequentially(getCkeySoNamesForDebug(), new a());
            for (String str : getThumbSoNameForDebug()) {
                try {
                    System.loadLibrary(str);
                } catch (Throwable th5) {
                    QLog.e(TAG, 2, "loadSo: loadFromAAR=true, loadThumbSo error, name=" + str, th5);
                    loadSoCallback.onLoad(false);
                    return;
                }
            }
            loadSoCallback.onLoad(true);
            return;
        }
        SoLoadManager.getInstance().loadSequentially(getSoNames(), new b(loadSoCallback));
    }

    @Override // com.tencent.mobileqq.qqvideoplatform.api.IVideoSoLoader
    public boolean loadTPCoreSync(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, z16)).booleanValue();
        }
        return loadSoSync(z16, getTargetSoName("TPCore", SoLoadConstants.SONAME_TPCORE_MASTER));
    }

    @Override // com.tencent.mobileqq.qqvideoplatform.api.IVideoSoLoader
    public void preloadSo(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else if (!z16) {
            SoLoadManager.getInstance().download(getSoNames(), new d());
        }
    }
}

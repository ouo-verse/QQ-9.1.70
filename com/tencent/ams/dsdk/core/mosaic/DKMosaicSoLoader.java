package com.tencent.ams.dsdk.core.mosaic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.dsdk.download.DownloadManager;
import com.tencent.ams.dsdk.download.DownloadRequest;
import com.tencent.ams.dsdk.download.SimpleDownloadCallback;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.dsdk.utils.FileUtils;
import com.tencent.ams.dsdk.utils.Md5Utils;
import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Deprecated
/* loaded from: classes3.dex */
public class DKMosaicSoLoader {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKMosaicSoLoader";
    private static final DKMosaicSoLoader instance;
    private boolean mIsSoLoaded;
    private boolean mIsSoLoading;
    private List<SoLoadListener> mSoLoadListeners;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Cpu {
        static IPatchRedirector $redirector_;
        private static final byte[] GET_LOCKER;
        private static volatile Boolean sIs64Bit;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15559);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                GET_LOCKER = new byte[0];
            }
        }

        public Cpu() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static boolean is64Bit(Context context) {
            if (sIs64Bit != null) {
                return sIs64Bit.booleanValue();
            }
            synchronized (GET_LOCKER) {
                if (sIs64Bit != null) {
                    return sIs64Bit.booleanValue();
                }
                sIs64Bit = Boolean.valueOf(is64BitImpl(context));
                return sIs64Bit.booleanValue();
            }
        }

        @SuppressLint({"ObsoleteSdkInt"})
        private static boolean is64BitImpl(Context context) {
            return Process.is64Bit();
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SoLoadFailReason {
        public static final int ABI_TYPE_NOT_GET = 2;
        public static final int CACHE_PATH_NOT_GET = 4;
        public static final int DOWNLOAD_SO_FAILED = 5;
        public static final int INVALID_SO_INFO = 1;
        public static final int LOAD_SO_LIB_FAILED = 6;
        public static final int SO_URL_NOT_FOUND = 3;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface SoLoadListener {
        void onSoLoadFailed(int i3, Throwable th5);

        void onSoLoadStart();

        void onSoLoadSuccess(int i3);
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SoLoadSuccessState {
        public static final int LOAD_SO_DOWNLOAD = 3;
        public static final int LOAD_SO_EXISTS = 2;
        public static final int LOAD_SO_LOADED = 1;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15610);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            instance = new DKMosaicSoLoader();
        }
    }

    public DKMosaicSoLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mIsSoLoaded = false;
        }
    }

    private void clearOldSo(String str) {
        File[] listFiles;
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2 != null) {
                        file2.delete();
                        f.e(TAG, "clearOldSo delete cache so: " + file2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchSoLoadFailed(SoLoadListener soLoadListener, int i3, Throwable th5) {
        if (soLoadListener != null) {
            soLoadListener.onSoLoadFailed(i3, th5);
        }
    }

    private void dispatchSoLoadStart(SoLoadListener soLoadListener) {
        if (soLoadListener != null) {
            soLoadListener.onSoLoadStart();
        }
    }

    private void dispatchSoLoadSuccess(SoLoadListener soLoadListener, int i3) {
        if (soLoadListener != null) {
            soLoadListener.onSoLoadSuccess(i3);
        }
    }

    private void downloadSo(@NonNull SoItem soItem, String str, String str2, SoLoadListener soLoadListener) {
        DownloadManager.getInstance().download(new DownloadRequest.Builder().setName(str).setFileMd5(soItem.md5).setUrl(soItem.url).setFolder(str2).setDownloadExecutor(WorkThreadManager.getInstance().getImmediateThreadPool()).build(), new SimpleDownloadCallback(soItem, str2, str, soLoadListener) { // from class: com.tencent.ams.dsdk.core.mosaic.DKMosaicSoLoader.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ SoLoadListener val$listener;
            final /* synthetic */ SoItem val$soItem;
            final /* synthetic */ String val$soName;
            final /* synthetic */ String val$soPath;

            {
                this.val$soItem = soItem;
                this.val$soPath = str2;
                this.val$soName = str;
                this.val$listener = soLoadListener;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, DKMosaicSoLoader.this, soItem, str2, str, soLoadListener);
                }
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onCancelled() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                DLog.i(DKMosaicSoLoader.TAG, "downloadSo onCancelled: " + this.val$soItem.url);
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onDownloadComplete() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this);
                    return;
                }
                DLog.i(DKMosaicSoLoader.TAG, "downloadSo onDownloadComplete");
                DKMosaicSoLoader.this.loadSoLib(this.val$soItem, this.val$soPath + File.separator + this.val$soName, 3, this.val$listener);
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onDownloadFailed(Exception exc) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) exc);
                } else {
                    DLog.e(DKMosaicSoLoader.TAG, "downloadSo failed. ", exc);
                    DKMosaicSoLoader.this.dispatchSoLoadFailed(this.val$listener, 5, exc);
                }
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onDownloadStart() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                } else {
                    DLog.i(DKMosaicSoLoader.TAG, "downloadSo onDownloadStart");
                }
            }
        });
    }

    @SuppressLint({"ObsoleteSdkInt"})
    private String[] getAbiType() {
        return Build.SUPPORTED_ABIS;
    }

    @NonNull
    private SoItem getBestSo(Context context, String str) {
        SoItem soItem;
        Map<String, SoItem> parseSoInfo = parseSoInfo(str);
        if (parseSoInfo != null && !parseSoInfo.isEmpty()) {
            String[] abiType = getAbiType();
            if (abiType != null && abiType.length != 0) {
                if (!TextUtils.isEmpty(abiType[0])) {
                    f.e(TAG, "getBestSo abiTypes: " + Arrays.toString(abiType));
                    for (String str2 : abiType) {
                        if (!TextUtils.isEmpty(str2) && ((!str2.contains(ResourceAttributes.HostArchValues.ARM64) || Cpu.is64Bit(context)) && (soItem = parseSoInfo.get(str2.toLowerCase())) != null)) {
                            f.e(TAG, "getBestSo success: " + soItem);
                            return soItem;
                        }
                    }
                    f.h(TAG, "getBestSo failed: so url not found");
                    return new SoItem(3);
                }
            }
            f.h(TAG, "getBestSo failed: abi type not get");
            return new SoItem(2);
        }
        f.h(TAG, "getBestSo failed: invalid soInfo: " + str);
        return new SoItem(1);
    }

    public static DKMosaicSoLoader getInstance() {
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public void loadSoLib(SoItem soItem, String str, int i3, SoLoadListener soLoadListener) {
        try {
            System.load(str);
            f.e(TAG, "loadSo success: " + soItem.url);
            this.mIsSoLoaded = true;
            dispatchSoLoadSuccess(soLoadListener, i3);
        } catch (Throwable th5) {
            f.i(TAG, "loadSo failed: " + soItem.url, th5);
            dispatchSoLoadFailed(soLoadListener, 6, th5);
        }
    }

    private Map<String, SoItem> parseSoInfo(String str) {
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("soList");
            if (optJSONArray != null) {
                HashMap hashMap = new HashMap();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("url");
                        String optString2 = optJSONObject.optString("md5");
                        String optString3 = optJSONObject.optString("abi");
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                            hashMap.put(optString3, new SoItem(optString, optString2, optString3));
                        }
                    }
                }
                return hashMap;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    protected String getLocalSoName(SoItem soItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) soItem);
        }
        if (soItem != null && !TextUtils.isEmpty(soItem.url)) {
            return Md5Utils.toMd5(soItem.url) + ".so";
        }
        return null;
    }

    protected String getLocalSoPath(Context context, SoItem soItem) {
        File filesDir;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) soItem);
        }
        if (context != null && (filesDir = context.getFilesDir()) != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(filesDir.getAbsolutePath());
            String str = File.separator;
            sb5.append(str);
            sb5.append("tad_cache");
            sb5.append(str);
            sb5.append("mosaic_so");
            sb5.append(str);
            return sb5.toString();
        }
        return null;
    }

    public void loadSo(Context context, String str, SoLoadListener soLoadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, str, soLoadListener);
            return;
        }
        dispatchSoLoadStart(soLoadListener);
        if (this.mIsSoLoaded) {
            f.e(TAG, "so loaded, not load again");
            dispatchSoLoadSuccess(soLoadListener, 1);
            return;
        }
        synchronized (this) {
            if (this.mIsSoLoaded) {
                f.e(TAG, "so loaded, not load again");
                dispatchSoLoadSuccess(soLoadListener, 1);
                return;
            }
            if (!this.mIsSoLoading) {
                SoItem bestSo = getBestSo(context, str);
                if (bestSo.failReason != 0) {
                    f.h(TAG, "loadSo failed failReason: " + bestSo.failReason);
                    dispatchSoLoadFailed(soLoadListener, bestSo.failReason, null);
                    return;
                }
                this.mIsSoLoading = true;
                loadSo(bestSo, context, new SoLoadListener(soLoadListener) { // from class: com.tencent.ams.dsdk.core.mosaic.DKMosaicSoLoader.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ SoLoadListener val$listener;

                    {
                        this.val$listener = soLoadListener;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKMosaicSoLoader.this, (Object) soLoadListener);
                        }
                    }

                    @Override // com.tencent.ams.dsdk.core.mosaic.DKMosaicSoLoader.SoLoadListener
                    public void onSoLoadFailed(int i3, Throwable th5) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                            iPatchRedirector2.redirect((short) 4, (Object) this, i3, (Object) th5);
                            return;
                        }
                        SoLoadListener soLoadListener2 = this.val$listener;
                        if (soLoadListener2 != null) {
                            soLoadListener2.onSoLoadFailed(i3, th5);
                        }
                        synchronized (DKMosaicSoLoader.this) {
                            DKMosaicSoLoader.this.mIsSoLoading = false;
                            if (!DynamicUtils.isEmpty(DKMosaicSoLoader.this.mSoLoadListeners)) {
                                for (SoLoadListener soLoadListener3 : DKMosaicSoLoader.this.mSoLoadListeners) {
                                    if (soLoadListener3 != null) {
                                        soLoadListener3.onSoLoadFailed(i3, th5);
                                    }
                                }
                                DKMosaicSoLoader.this.mSoLoadListeners = null;
                            }
                        }
                    }

                    @Override // com.tencent.ams.dsdk.core.mosaic.DKMosaicSoLoader.SoLoadListener
                    public void onSoLoadStart() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }

                    @Override // com.tencent.ams.dsdk.core.mosaic.DKMosaicSoLoader.SoLoadListener
                    public void onSoLoadSuccess(int i3) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                            iPatchRedirector2.redirect((short) 3, (Object) this, i3);
                            return;
                        }
                        SoLoadListener soLoadListener2 = this.val$listener;
                        if (soLoadListener2 != null) {
                            soLoadListener2.onSoLoadSuccess(i3);
                        }
                        synchronized (DKMosaicSoLoader.this) {
                            DKMosaicSoLoader.this.mIsSoLoading = false;
                            if (!DynamicUtils.isEmpty(DKMosaicSoLoader.this.mSoLoadListeners)) {
                                for (SoLoadListener soLoadListener3 : DKMosaicSoLoader.this.mSoLoadListeners) {
                                    if (soLoadListener3 != null) {
                                        soLoadListener3.onSoLoadSuccess(i3);
                                    }
                                }
                                DKMosaicSoLoader.this.mSoLoadListeners = null;
                            }
                        }
                    }
                });
            } else {
                if (this.mSoLoadListeners == null) {
                    this.mSoLoadListeners = new ArrayList();
                }
                this.mSoLoadListeners.add(soLoadListener);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class SoItem {
        static IPatchRedirector $redirector_;
        String abiType;
        int failReason;
        String md5;
        String url;

        public SoItem(String str, String str2, String str3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DKMosaicSoLoader.this, str, str2, str3);
                return;
            }
            this.url = str;
            this.md5 = str2;
            this.abiType = str3;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "SoItem{url='" + this.url + "', md5='" + this.md5 + "', abiType='" + this.abiType + "', failReason=" + this.failReason + '}';
        }

        public SoItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.failReason = i3;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) DKMosaicSoLoader.this, i3);
            }
        }
    }

    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    private void loadSo(@NonNull SoItem soItem, Context context, SoLoadListener soLoadListener) {
        String localSoPath = getLocalSoPath(context, soItem);
        if (TextUtils.isEmpty(localSoPath)) {
            dispatchSoLoadFailed(soLoadListener, 4, null);
            return;
        }
        String localSoName = getLocalSoName(soItem);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(localSoPath);
        String str = File.separator;
        sb5.append(str);
        sb5.append(localSoName);
        String sb6 = sb5.toString();
        if (!FileUtils.isFileExist(sb6)) {
            clearOldSo(localSoPath);
            downloadSo(soItem, localSoName, localSoPath, soLoadListener);
            return;
        }
        f.e(TAG, "loadSo find cache so: " + sb6);
        loadSoLib(soItem, localSoPath + str + localSoName, 2, soLoadListener);
    }
}

package com.tencent.ams.dsdk.fodder;

import android.text.TextUtils;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.data.PreloadInfo;
import com.tencent.ams.dsdk.download.DownloadManager;
import com.tencent.ams.dsdk.download.DownloadRequest;
import com.tencent.ams.dsdk.download.SimpleDownloadCallback;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.FileUtils;
import com.tencent.ams.dsdk.utils.Md5Utils;
import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ResourceManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ResourceManager";
    private String mFileDir;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Holder {
        static IPatchRedirector $redirector_;
        private static final ResourceManager INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18451);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new ResourceManager(null);
            }
        }

        Holder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* synthetic */ ResourceManager(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) anonymousClass1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doPreload, reason: merged with bridge method [inline-methods] */
    public void lambda$preload$0(String str) {
        int length;
        if (TextUtils.isEmpty(str)) {
            DLog.e(TAG, "do preload template is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Object obj = JSONObject.NULL;
            if (obj.equals(jSONObject)) {
                return;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("preload");
            if (obj.equals(optJSONArray) || (length = optJSONArray.length()) <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < length; i3++) {
                PreloadInfo fromJSON = PreloadInfo.fromJSON(optJSONArray.optJSONObject(i3));
                if (fromJSON == null) {
                    DLog.w(TAG, "do preload parse preloadInfo fail for preload node: " + optJSONArray.optJSONObject(i3));
                } else {
                    String preloadPath = getPreloadPath(fromJSON.getUrl());
                    if (!TextUtils.isEmpty(preloadPath)) {
                        File file = new File(preloadPath);
                        if (file.exists() && file.isFile()) {
                            DLog.i(TAG, "do preload file exists: " + preloadPath);
                            FileUtils.updateLastModified(file);
                        }
                    }
                    arrayList.add(fromJSON);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                downloadResource((PreloadInfo) it.next());
            }
        } catch (Throwable th5) {
            DLog.e(TAG, "preload fail", th5);
        }
    }

    private void downloadResource(PreloadInfo preloadInfo) {
        if (preloadInfo == null) {
            return;
        }
        String url = preloadInfo.getUrl();
        if (TextUtils.isEmpty(url)) {
            return;
        }
        DownloadManager.getInstance().download(new DownloadRequest.Builder().setUrl(url).setFolder(this.mFileDir).setName(Md5Utils.toMd5(url)).setFileMd5(preloadInfo.getMd5()).build(), new SimpleDownloadCallback(preloadInfo) { // from class: com.tencent.ams.dsdk.fodder.ResourceManager.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ PreloadInfo val$preloadInfo;

            {
                this.val$preloadInfo = preloadInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ResourceManager.this, (Object) preloadInfo);
                }
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onCancelled() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this);
                    return;
                }
                super.onCancelled();
                DLog.i(ResourceManager.TAG, "downloadResource cancelled, preloadInfo: " + this.val$preloadInfo);
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onDownloadComplete() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                    return;
                }
                super.onDownloadComplete();
                DLog.i(ResourceManager.TAG, "downloadResource complete, preloadInfo: " + this.val$preloadInfo);
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onDownloadFailed(Exception exc) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) exc);
                } else {
                    super.onDownloadFailed(exc);
                    DLog.i(ResourceManager.TAG, String.format("downloadResource failed, preloadInfo: %s, error:%s", this.val$preloadInfo, exc.getMessage()));
                }
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onDownloadStart() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                super.onDownloadStart();
                DLog.i(ResourceManager.TAG, "downloadResource start, preloadInfo: " + this.val$preloadInfo);
            }
        });
    }

    public static ResourceManager getInstance() {
        return Holder.INSTANCE;
    }

    private void initPath() {
        String fileDir = FileUtils.getFileDir();
        if (!TextUtils.isEmpty(fileDir)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(fileDir);
            String str = File.separator;
            sb5.append(str);
            sb5.append(DKConfiguration.Directory.RESOURCES);
            sb5.append(str);
            this.mFileDir = sb5.toString();
            DLog.i(TAG, "init path success: " + this.mFileDir);
            return;
        }
        DLog.w(TAG, "init path failed: null root path");
    }

    public void clearExpireFiles() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        DLog.i(TAG, "clearExpireFiles");
        FileUtils.clearExpireFile(this.mFileDir, DKConfiguration.getPreloadExpireTime());
        FileUtils.clearExceedSpaceSizeFile(this.mFileDir, DKConfiguration.getPreloadMaxSize());
    }

    public File getPreloadFile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (File) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        String preloadPath = getPreloadPath(str);
        if (TextUtils.isEmpty(preloadPath)) {
            return null;
        }
        File file = new File(preloadPath);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        return file;
    }

    public String getPreloadPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.mFileDir)) {
            return null;
        }
        String md5 = Md5Utils.toMd5(str);
        if (TextUtils.isEmpty(md5)) {
            return null;
        }
        return this.mFileDir + md5;
    }

    public void preload(File file) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) file);
            return;
        }
        final String stringFromFile = FileUtils.stringFromFile(file);
        if (TextUtils.isEmpty(stringFromFile)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.ams.dsdk.fodder.b
            @Override // java.lang.Runnable
            public final void run() {
                ResourceManager.this.lambda$preload$0(stringFromFile);
            }
        };
        if (DKConfiguration.isEnableOrganizeThreads()) {
            WorkThreadManager.getInstance().getBackgroundThreadPool().execute(runnable);
        } else {
            WorkThreadManager.getInstance().getImmediateThreadPool().execute(runnable);
        }
    }

    ResourceManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            initPath();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

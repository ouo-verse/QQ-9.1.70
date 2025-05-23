package com.tencent.ams.dsdk.fodder;

import android.text.TextUtils;
import com.tencent.ams.dsdk.cache.TemplateConfigCache;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.data.TemplateInfo;
import com.tencent.ams.dsdk.download.Download;
import com.tencent.ams.dsdk.download.DownloadManager;
import com.tencent.ams.dsdk.download.DownloadRequest;
import com.tencent.ams.dsdk.download.SimpleDownloadCallback;
import com.tencent.ams.dsdk.monitor.metric.DynamicReporter;
import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.FileUtils;
import com.tencent.ams.dsdk.utils.HttpUtils;
import com.tencent.ams.dsdk.utils.Md5Utils;
import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TemplateManager {
    static IPatchRedirector $redirector_ = null;
    public static final int MAX_RETRY = 3;
    public static final int REQUEST_TIMEOUT = 3000;
    private static final String SUFFIX = ".json";
    private static final String TAG = "TemplateManager";
    private String mFileDir;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class CheckFinishUpdateTemplateListenerV2 implements UpdateTemplateListenerV2 {
        static IPatchRedirector $redirector_;
        boolean isFinishCall;
        UpdateTemplateListener listener;
        int templateSize;

        CheckFinishUpdateTemplateListenerV2(UpdateTemplateListener updateTemplateListener, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TemplateManager.this, updateTemplateListener, Integer.valueOf(i3));
                return;
            }
            this.listener = updateTemplateListener;
            this.templateSize = i3;
            DLog.i(TemplateManager.TAG, "new CheckFinishUpdateTemplateListenerV2: templateSize=" + i3);
        }

        public void checkFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
                return;
            }
            DLog.d(TemplateManager.TAG, "checkFinish: templateSize=" + this.templateSize);
            int i3 = this.templateSize - 1;
            this.templateSize = i3;
            if (i3 <= 0 && !this.isFinishCall) {
                UpdateTemplateListener updateTemplateListener = this.listener;
                if (updateTemplateListener != null) {
                    updateTemplateListener.onFinish();
                }
                DynamicReporter.reportDldTptEnd();
                this.isFinishCall = true;
            }
        }

        @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListener
        public void onFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            }
        }

        @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListener
        public void onItemCancelled(TemplateInfo templateInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) templateInfo);
                return;
            }
            UpdateTemplateListener updateTemplateListener = this.listener;
            if (updateTemplateListener != null) {
                updateTemplateListener.onItemCancelled(templateInfo);
            }
            checkFinish();
        }

        @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListenerV2
        public void onItemExisted(TemplateInfo templateInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) templateInfo);
                return;
            }
            UpdateTemplateListener updateTemplateListener = this.listener;
            if (updateTemplateListener instanceof UpdateTemplateListenerV2) {
                ((UpdateTemplateListenerV2) updateTemplateListener).onItemExisted(templateInfo);
            }
            checkFinish();
        }

        @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListener
        public void onItemFailed(TemplateInfo templateInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) templateInfo);
                return;
            }
            UpdateTemplateListener updateTemplateListener = this.listener;
            if (updateTemplateListener != null) {
                updateTemplateListener.onItemFailed(templateInfo);
            }
            checkFinish();
        }

        @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListener
        public void onItemStart(TemplateInfo templateInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) templateInfo);
                return;
            }
            UpdateTemplateListener updateTemplateListener = this.listener;
            if (updateTemplateListener != null) {
                updateTemplateListener.onItemStart(templateInfo);
            }
        }

        @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListener
        public void onItemSuccess(TemplateInfo templateInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) templateInfo);
                return;
            }
            UpdateTemplateListener updateTemplateListener = this.listener;
            if (updateTemplateListener != null) {
                updateTemplateListener.onItemSuccess(templateInfo);
            }
            checkFinish();
        }

        @Override // com.tencent.ams.dsdk.fodder.TemplateManager.UpdateTemplateListener
        public void onStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            UpdateTemplateListener updateTemplateListener = this.listener;
            if (updateTemplateListener != null) {
                updateTemplateListener.onStart();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Holder {
        static IPatchRedirector $redirector_;
        private static final TemplateManager INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18686);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new TemplateManager(null);
            }
        }

        Holder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface UpdateTemplateListener {
        void onFinish();

        void onItemCancelled(TemplateInfo templateInfo);

        void onItemFailed(TemplateInfo templateInfo);

        void onItemStart(TemplateInfo templateInfo);

        void onItemSuccess(TemplateInfo templateInfo);

        void onStart();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface UpdateTemplateListenerV2 extends UpdateTemplateListener {
        void onItemExisted(TemplateInfo templateInfo);
    }

    /* synthetic */ TemplateManager(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this, (Object) anonymousClass1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCache(String str, List<TemplateInfo> list) {
        DLog.i(TAG, "clearCache scene: " + str);
        updateTemplateFileLastModified(str, list);
        FileUtils.clearExpireFile(getFileDir(str), DKConfiguration.getBundleExpireTime(), true);
        FileUtils.clearExceedSpaceSizeFile(getFileDir(str), DKConfiguration.getTemplateMaxSize());
    }

    private void doDownload(TemplateInfo templateInfo, Download.Callback callback, String str) {
        Executor immediateThreadPool;
        if (templateInfo == null) {
            return;
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        DownloadRequest.Builder fileMd5 = new DownloadRequest.Builder().setUrl(templateInfo.getUrl()).setFolder(getFileDir(str)).setName(getTemplateFileName(templateInfo.getTemplateId())).setFileMd5(templateInfo.getMd5());
        if (isEmpty) {
            immediateThreadPool = null;
        } else {
            immediateThreadPool = WorkThreadManager.getInstance().getImmediateThreadPool();
        }
        DownloadManager.getInstance().download(fileMd5.setDownloadExecutor(immediateThreadPool).build(), callback);
    }

    private void downloadTemplateAsync(TemplateInfo templateInfo, UpdateTemplateListenerV2 updateTemplateListenerV2, String str) {
        DLog.i(TAG, "downloadTemplateAsync, templateInfo: " + templateInfo);
        if (updateTemplateListenerV2 != null) {
            updateTemplateListenerV2.onItemStart(templateInfo);
        }
        DynamicReporter.reportDldTptItemStart(templateInfo);
        doDownload(templateInfo, new SimpleDownloadCallback(templateInfo, updateTemplateListenerV2, str) { // from class: com.tencent.ams.dsdk.fodder.TemplateManager.4
            static IPatchRedirector $redirector_;
            final /* synthetic */ UpdateTemplateListenerV2 val$listener;
            final /* synthetic */ String val$scene;
            final /* synthetic */ TemplateInfo val$templateInfo;

            {
                this.val$templateInfo = templateInfo;
                this.val$listener = updateTemplateListenerV2;
                this.val$scene = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TemplateManager.this, templateInfo, updateTemplateListenerV2, str);
                }
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onCancelled() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                DLog.i(TemplateManager.TAG, "downloadTemplateAsync, cancelled, template: " + this.val$templateInfo);
                UpdateTemplateListenerV2 updateTemplateListenerV22 = this.val$listener;
                if (updateTemplateListenerV22 != null) {
                    updateTemplateListenerV22.onItemCancelled(this.val$templateInfo);
                }
                DynamicReporter.reportDldTptItemCanceled(this.val$templateInfo);
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onDownloadComplete() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                    return;
                }
                DLog.i(TemplateManager.TAG, "downloadTemplateAsync, complete, template: " + this.val$templateInfo);
                UpdateTemplateListenerV2 updateTemplateListenerV22 = this.val$listener;
                if (updateTemplateListenerV22 != null) {
                    updateTemplateListenerV22.onItemSuccess(this.val$templateInfo);
                }
                if (this.val$templateInfo != null && DKConfiguration.isEnableResourcePreload()) {
                    ResourceManager.getInstance().preload(TemplateManager.this.getTemplateFile(this.val$templateInfo.getTemplateId(), this.val$scene));
                }
                DynamicReporter.reportDldTptItemSuccess(this.val$templateInfo);
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onDownloadFailed(Exception exc) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) exc);
                    return;
                }
                DLog.i(TemplateManager.TAG, "downloadTemplateAsync, failed, template: " + this.val$templateInfo + ", error: " + exc);
                UpdateTemplateListenerV2 updateTemplateListenerV22 = this.val$listener;
                if (updateTemplateListenerV22 != null) {
                    updateTemplateListenerV22.onItemFailed(this.val$templateInfo);
                }
                DynamicReporter.reportDldTptItemFailed(this.val$templateInfo);
            }
        }, str);
    }

    private void downloadTemplateSync(TemplateInfo templateInfo, long j3, String str) {
        DLog.i(TAG, "downloadTemplateSync, templateInfo: " + templateInfo + ", timeout: " + j3 + ", scene: " + str);
        if (templateInfo == null) {
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        UpdateTemplateListenerV2 updateTemplateListener = DKConfiguration.getUpdateTemplateListener();
        if (updateTemplateListener != null) {
            updateTemplateListener.onItemStart(templateInfo);
        }
        DynamicReporter.reportDldTptItemStart(templateInfo);
        doDownload(templateInfo, new SimpleDownloadCallback(templateInfo, countDownLatch, updateTemplateListener) { // from class: com.tencent.ams.dsdk.fodder.TemplateManager.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ UpdateTemplateListener val$globalListener;
            final /* synthetic */ CountDownLatch val$latch;
            final /* synthetic */ TemplateInfo val$templateInfo;

            {
                this.val$templateInfo = templateInfo;
                this.val$latch = countDownLatch;
                this.val$globalListener = updateTemplateListener;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TemplateManager.this, templateInfo, countDownLatch, updateTemplateListener);
                }
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onCancelled() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                DLog.i(TemplateManager.TAG, "downloadTemplateSync, cancelled, template: " + this.val$templateInfo);
                this.val$latch.countDown();
                UpdateTemplateListener updateTemplateListener2 = this.val$globalListener;
                if (updateTemplateListener2 != null) {
                    updateTemplateListener2.onItemCancelled(this.val$templateInfo);
                }
                DynamicReporter.reportDldTptItemCanceled(this.val$templateInfo);
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onDownloadComplete() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                    return;
                }
                DLog.i(TemplateManager.TAG, "downloadTemplateSync, complete, template: " + this.val$templateInfo);
                this.val$latch.countDown();
                UpdateTemplateListener updateTemplateListener2 = this.val$globalListener;
                if (updateTemplateListener2 != null) {
                    updateTemplateListener2.onItemSuccess(this.val$templateInfo);
                }
                DynamicReporter.reportDldTptItemSuccess(this.val$templateInfo);
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onDownloadFailed(Exception exc) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) exc);
                    return;
                }
                DLog.i(TemplateManager.TAG, "downloadTemplateSync, failed, template: " + this.val$templateInfo + ", error: " + exc);
                this.val$latch.countDown();
                UpdateTemplateListener updateTemplateListener2 = this.val$globalListener;
                if (updateTemplateListener2 != null) {
                    updateTemplateListener2.onItemFailed(this.val$templateInfo);
                }
                DynamicReporter.reportDldTptItemFailed(this.val$templateInfo);
            }
        }, str);
        try {
            countDownLatch.await(j3, TimeUnit.MILLISECONDS);
        } catch (Throwable th5) {
            DLog.e(TAG, "downloadTemplateSync error.", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadTemplates(List<TemplateInfo> list, UpdateTemplateListenerV2 updateTemplateListenerV2, @DKEngine.SceneType String str) {
        if (list != null && !list.isEmpty()) {
            boolean isEnableResourcePreload = DKConfiguration.isEnableResourcePreload();
            if (isEnableResourcePreload) {
                ResourceManager.getInstance().clearExpireFiles();
            }
            CheckFinishUpdateTemplateListenerV2 checkFinishUpdateTemplateListenerV2 = new CheckFinishUpdateTemplateListenerV2(updateTemplateListenerV2, list.size());
            try {
                for (TemplateInfo templateInfo : list) {
                    if (templateInfo == null) {
                        checkFinishUpdateTemplateListenerV2.checkFinish();
                    } else {
                        File templateFile = getTemplateFile(templateInfo.getTemplateId(), str);
                        if (templateFile != null && templateFile.exists()) {
                            if (templateFile.exists() && templateFile.isFile()) {
                                if (templateInfo.isForceUpdate() && (TextUtils.isEmpty(templateInfo.getMd5()) || !templateInfo.getMd5().equalsIgnoreCase(Md5Utils.toMd5(templateFile)))) {
                                    DLog.d(TAG, "downloadTemplate, template existed: but md5 check failed\uff01\n" + templateInfo);
                                    downloadTemplateAsync(templateInfo, checkFinishUpdateTemplateListenerV2, str);
                                } else {
                                    DLog.d(TAG, "downloadTemplate, template existed: " + templateInfo);
                                    checkFinishUpdateTemplateListenerV2.onItemExisted(templateInfo);
                                    DynamicReporter.reportTptItemExist(templateInfo);
                                    if (isEnableResourcePreload) {
                                        ResourceManager.getInstance().preload(templateFile);
                                    }
                                }
                            }
                        }
                        downloadTemplateAsync(templateInfo, checkFinishUpdateTemplateListenerV2, str);
                    }
                }
                return;
            } catch (Throwable th5) {
                DLog.e(TAG, "templateInfo check error :", th5);
                return;
            }
        }
        DLog.w(TAG, "template info list is empty.");
        if (updateTemplateListenerV2 != null) {
            updateTemplateListenerV2.onFinish();
            DynamicReporter.reportDldTptEnd();
        }
    }

    private String getFileDir(String str) {
        if (TextUtils.isEmpty(this.mFileDir)) {
            initPath();
        }
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.mFileDir);
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append(str);
            sb5.append(str2);
            return sb5.toString();
        }
        return this.mFileDir;
    }

    public static TemplateManager getInstance() {
        return Holder.INSTANCE;
    }

    private JSONObject getRequestBody() {
        return getRequestBody(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File getTemplateFile(String str, String str2) {
        File templateFileWithoutLastModifiedUpdated = getTemplateFileWithoutLastModifiedUpdated(str, str2);
        FileUtils.updateLastModified(templateFileWithoutLastModifiedUpdated);
        return templateFileWithoutLastModifiedUpdated;
    }

    private String getTemplateFileName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str + ".json";
    }

    private void initPath() {
        String fileDir = FileUtils.getFileDir();
        if (!TextUtils.isEmpty(fileDir)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(fileDir);
            String str = File.separator;
            sb5.append(str);
            sb5.append(DKConfiguration.Directory.TEMPLATES);
            sb5.append(str);
            this.mFileDir = sb5.toString();
            DLog.i(TAG, "init path success: " + this.mFileDir);
            return;
        }
        DLog.w(TAG, "init path failed: null root path");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateTemplate$0() {
        DLog.i(TAG, "doUpdateTemplate");
        UpdateTemplateListenerV2 updateTemplateListener = DKConfiguration.getUpdateTemplateListener();
        if (updateTemplateListener != null) {
            updateTemplateListener.onStart();
        }
        DynamicReporter.reportDldTptStart();
        List<TemplateInfo> requestTemplateList = requestTemplateList();
        clearCache(null, requestTemplateList);
        if (requestTemplateList != null && !requestTemplateList.isEmpty()) {
            TemplateConfigCache.getInstance().updateTemplateCache(requestTemplateList);
        } else {
            requestTemplateList = TemplateConfigCache.getInstance().getTemplateList();
        }
        downloadTemplates(requestTemplateList, updateTemplateListener, null);
    }

    private TemplateInfo parseTemplateInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        TemplateInfo templateInfo = new TemplateInfo();
        templateInfo.setTemplateId(jSONObject.optString("template_id"));
        templateInfo.setUrl(jSONObject.optString("url"));
        templateInfo.setMd5(jSONObject.optString("md5"));
        templateInfo.setForceUpdate(jSONObject.optBoolean("force_update"));
        templateInfo.setMinModuleVersion(jSONObject.optString("min_module_version"));
        return templateInfo;
    }

    private List<TemplateInfo> parseTemplateListResponse(String str, long j3) {
        DLog.i(TAG, "parseTemplateList");
        if (TextUtils.isEmpty(str)) {
            DynamicReporter.reportTptCfgGetEnd(j3, TagValue.RESP_EMPTY);
            return null;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONArray optJSONArray = new JSONObject(str).optJSONArray(DKConfiguration.Directory.TEMPLATES);
            if (optJSONArray == null) {
                DynamicReporter.reportTptCfgGetEnd(j3, TagValue.RESP_TEMPLATES_EMPTY);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                TemplateInfo parseTemplateInfo = parseTemplateInfo(optJSONArray.optJSONObject(i3));
                if (parseTemplateInfo != null) {
                    arrayList.add(parseTemplateInfo);
                }
            }
            DLog.i(TAG, "parseTemplateList finish, timeCost: " + (System.currentTimeMillis() - currentTimeMillis));
            DynamicReporter.reportTptCfgGetEnd(j3, "none");
            return arrayList;
        } catch (Throwable th5) {
            DLog.e(TAG, "params response error.");
            DynamicReporter.reportTptCfgGetEnd(j3, th5.getClass().getName(), th5.getMessage());
            return null;
        }
    }

    private TemplateInfo parseTemplateResponse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return parseTemplateInfo(new JSONObject(str).optJSONObject("template"));
        } catch (Throwable th5) {
            DLog.e(TAG, "parseTemplateResponse error.", th5);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestAndDownloadTemplate(String str, long j3, boolean z16, @DKEngine.SceneType String str2) {
        int i3;
        TemplateInfo requestTemplate = requestTemplate(str);
        if (requestTemplate != null) {
            TemplateConfigCache.getInstance().updateTemplateInfo(requestTemplate, str2);
            if (z16) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            requestTemplate.setDownloadType(i3);
            downloadTemplateSync(requestTemplate, j3, str2);
        }
    }

    private TemplateInfo requestTemplate(String str) {
        String jSONObject;
        byte[] bArr = null;
        if (TextUtils.isEmpty(str)) {
            DLog.w(TAG, "templateId is null");
            return null;
        }
        String templateUrl = DKConfiguration.getTemplateUrl();
        if (TextUtils.isEmpty(templateUrl)) {
            DLog.w(TAG, "get template config url is empty.");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject requestBody = getRequestBody(str);
        if (requestBody == null) {
            jSONObject = null;
        } else {
            jSONObject = requestBody.toString();
        }
        if (jSONObject != null) {
            bArr = jSONObject.getBytes();
        }
        String postHttpJson = HttpUtils.postHttpJson(templateUrl, bArr, 3000, 3);
        DLog.i(TAG, "requestTemplate finis, timeCost: " + (System.currentTimeMillis() - currentTimeMillis) + ", response: " + postHttpJson);
        return parseTemplateResponse(postHttpJson);
    }

    private List<TemplateInfo> requestTemplateList() {
        long currentTimeMillis = System.currentTimeMillis();
        DynamicReporter.reportTptCfgGetStart();
        String templateListUrl = DKConfiguration.getTemplateListUrl();
        byte[] bArr = null;
        if (TextUtils.isEmpty(templateListUrl)) {
            DLog.w(TAG, "template config url error.");
            DynamicReporter.reportTptCfgGetEnd(currentTimeMillis, TagValue.URL_INVALID);
            return null;
        }
        JSONObject requestBody = getRequestBody();
        if (requestBody != null) {
            bArr = requestBody.toString().getBytes();
        }
        String postHttpJson = HttpUtils.postHttpJson(templateListUrl, bArr, 3000, 3);
        DLog.d(TAG, "requestTemplateList finis, timeCost: " + (System.currentTimeMillis() - currentTimeMillis) + ", response: " + postHttpJson);
        return parseTemplateListResponse(postHttpJson, currentTimeMillis);
    }

    private void updateTemplateFileLastModified(String str, List<TemplateInfo> list) {
        boolean z16;
        DLog.i(TAG, "updateTemplateFileLastModified, scene");
        if (list != null && !list.isEmpty()) {
            for (TemplateInfo templateInfo : list) {
                if (templateInfo != null) {
                    File templateFile = getTemplateFile(templateInfo.getTemplateId(), str);
                    if (templateFile != null && templateFile.exists()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    DLog.i(TAG, "update file last modified. result: " + z16 + ", file: " + templateFile);
                }
            }
        }
    }

    public boolean deleteTemplate(@DKEngine.SceneType String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        DLog.i(TAG, "deleteTemplate, scene: " + str + ", templateId: " + str2);
        TemplateInfo removeTemplateCache = TemplateConfigCache.getInstance().removeTemplateCache(str, str2);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("delete template config: ");
        sb5.append(removeTemplateCache);
        DLog.i(TAG, sb5.toString());
        File templateFile = getTemplateFile(str2, str);
        DLog.i(TAG, "delete template file: " + templateFile);
        if (templateFile != null) {
            return templateFile.delete();
        }
        return false;
    }

    public File getTemplateFileWithoutLastModifiedUpdated(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? getTemplateFileWithoutLastModifiedUpdated(str, null) : (File) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
    }

    public String getTemplatePath(String str, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? getTemplatePath(str, z16, j3, (String) null) : (String) iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16), Long.valueOf(j3));
    }

    public void updateTemplate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        DLog.i(TAG, "updateTemplate");
        TemplateConfigCache.getInstance();
        Runnable runnable = new Runnable() { // from class: com.tencent.ams.dsdk.fodder.d
            @Override // java.lang.Runnable
            public final void run() {
                TemplateManager.this.lambda$updateTemplate$0();
            }
        };
        if (DKConfiguration.isEnableOrganizeThreads()) {
            WorkThreadManager.getInstance().getCachedThreadPool().execute(runnable);
        } else {
            WorkThreadManager.getInstance().getImmediateThreadPool().execute(runnable);
        }
    }

    TemplateManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            initPath();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private JSONObject getRequestBody(String str) {
        try {
            JSONObject createRequestBody = HttpUtils.createRequestBody();
            if (createRequestBody != null && !TextUtils.isEmpty(str)) {
                createRequestBody.put("template_id", str);
            }
            return createRequestBody;
        } catch (Throwable th5) {
            DLog.e(TAG, "build request body error.", th5);
            return null;
        }
    }

    public File getTemplateFileWithoutLastModifiedUpdated(String str, @DKEngine.SceneType String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (File) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
        }
        String templateFileName = getTemplateFileName(str);
        if (TextUtils.isEmpty(templateFileName)) {
            return null;
        }
        return new File(getFileDir(str2), templateFileName);
    }

    public String getTemplatePath(String str, boolean z16, long j3, @DKEngine.SceneType String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16), Long.valueOf(j3), str2);
        }
        DLog.i(TAG, String.format(Locale.getDefault(), "getTemplatePath templateId = %s , enableRealTime = %b, timeout= %d, scene = %s", str, Boolean.valueOf(z16), Long.valueOf(j3), str2));
        if (TextUtils.isEmpty(getFileDir(str2))) {
            return null;
        }
        File templateFile = getTemplateFile(str, str2);
        if (templateFile != null && templateFile.exists()) {
            DLog.i("TemplateManagertemplate file existed");
            return templateFile.getAbsolutePath();
        }
        TemplateInfo templateInfo = TemplateConfigCache.getInstance().getTemplateInfo(str, str2);
        if (templateInfo != null) {
            templateInfo.setDownloadType(z16 ? 1 : 2);
            if (z16) {
                downloadTemplateSync(templateInfo, j3, str2);
            } else {
                downloadTemplateAsync(templateInfo, DKConfiguration.getUpdateTemplateListener(), str2);
            }
        } else if (TextUtils.isEmpty(str2)) {
            if (z16) {
                requestAndDownloadTemplate(str, j3, true, str2);
            } else {
                WorkThreadManager.getInstance().getImmediateThreadPool().execute(new Runnable(str, j3, str2) { // from class: com.tencent.ams.dsdk.fodder.TemplateManager.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String val$scene;
                    final /* synthetic */ String val$templateId;
                    final /* synthetic */ long val$timeout;

                    {
                        this.val$templateId = str;
                        this.val$timeout = j3;
                        this.val$scene = str2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, TemplateManager.this, str, Long.valueOf(j3), str2);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            TemplateManager.this.requestAndDownloadTemplate(this.val$templateId, this.val$timeout, false, this.val$scene);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
            }
        }
        File templateFile2 = getTemplateFile(str, str2);
        if (templateFile2 == null || !templateFile2.exists()) {
            return null;
        }
        return templateFile2.getAbsolutePath();
    }

    public void updateTemplate(String str, List<TemplateInfo> list, UpdateTemplateListener updateTemplateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, list, updateTemplateListener);
            return;
        }
        TemplateConfigCache.getInstance();
        if (list == null || list.isEmpty()) {
            return;
        }
        WorkThreadManager.getInstance().getImmediateThreadPool().execute(new Runnable(new CheckFinishUpdateTemplateListenerV2(updateTemplateListener, list.size()), str, list) { // from class: com.tencent.ams.dsdk.fodder.TemplateManager.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$scene;
            final /* synthetic */ List val$templateInfoList;
            final /* synthetic */ UpdateTemplateListenerV2 val$updateTemplateListener;

            {
                this.val$updateTemplateListener = r6;
                this.val$scene = str;
                this.val$templateInfoList = list;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TemplateManager.this, r6, str, list);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                DLog.i(TemplateManager.TAG, "doUpdateTemplate");
                this.val$updateTemplateListener.onStart();
                TemplateManager.this.clearCache(this.val$scene, this.val$templateInfoList);
                TemplateConfigCache.getInstance().updateTemplateCache(this.val$scene, this.val$templateInfoList);
                TemplateManager.this.downloadTemplates(this.val$templateInfoList, this.val$updateTemplateListener, this.val$scene);
            }
        });
    }

    public String getTemplatePath(TemplateInfo templateInfo, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? getTemplatePath(templateInfo, z16, j3, (String) null) : (String) iPatchRedirector.redirect((short) 6, this, templateInfo, Boolean.valueOf(z16), Long.valueOf(j3));
    }

    public String getTemplatePath(TemplateInfo templateInfo, boolean z16, long j3, @DKEngine.SceneType String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, this, templateInfo, Boolean.valueOf(z16), Long.valueOf(j3), str);
        }
        if (templateInfo == null) {
            return null;
        }
        String templateId = templateInfo.getTemplateId();
        if (TextUtils.isEmpty(getFileDir(str))) {
            return null;
        }
        File templateFile = getTemplateFile(templateId, str);
        if (templateFile != null && templateFile.exists()) {
            return templateFile.getAbsolutePath();
        }
        templateInfo.setDownloadType(z16 ? 1 : 2);
        if (z16) {
            downloadTemplateSync(templateInfo, j3, str);
        } else {
            downloadTemplateAsync(templateInfo, DKConfiguration.getUpdateTemplateListener(), str);
        }
        File templateFile2 = getTemplateFile(templateId, str);
        if (templateFile2 == null || !templateFile2.exists()) {
            return null;
        }
        return templateFile2.getAbsolutePath();
    }
}

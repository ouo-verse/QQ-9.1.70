package com.tencent.mobileqq.search.rich;

import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.ArkViewModelBase;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppInfo;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.component.ArkMediaPlayer;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ArkNodeContainer extends ArkViewModel implements ArkAppMgr.IGetAppPathByNameCallback {

    /* renamed from: a, reason: collision with root package name */
    public ArkAppInfo.TimeRecord f283727a;

    /* renamed from: b, reason: collision with root package name */
    private b f283728b;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static final class a implements ArkAppMgr.IGetAppPathByNameCallback {

        /* renamed from: a, reason: collision with root package name */
        protected WeakReference<ArkNodeContainer> f283730a;

        public a(ArkNodeContainer arkNodeContainer) {
            this.f283730a = new WeakReference<>(arkNodeContainer);
        }

        @Override // com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback
        public void onGetAppPathByName(int i3, String str, ArkAppMgr.AppPathInfo appPathInfo) {
            ArkNodeContainer arkNodeContainer = this.f283730a.get();
            if (arkNodeContainer == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("ArkNodeContainer", 1, "onGetAppPathByName.wrapper == null");
                    return;
                }
                return;
            }
            arkNodeContainer.onGetAppPathByName(i3, str, appPathInfo);
        }
    }

    public ArkNodeContainer(com.tencent.mobileqq.search.rich.a aVar) {
        super(aVar, !com.tencent.mobileqq.ark.b.f199160b);
        this.f283727a = new ArkAppInfo.TimeRecord(this.mTimeRecord);
        l91.a.a();
    }

    private void a(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public void b(String str) {
        try {
            new JSONObject(str);
        } catch (Exception e16) {
            QLog.e("ArkNodeContainer", 2, String.format("CheckMetaLegality,appMeta is parse error and msg=%s", e16.getMessage()));
        }
    }

    public boolean c(b bVar, String str, float f16) {
        this.f283728b = bVar;
        if (bVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            b(str);
        }
        return super.init(this.f283728b.a(), this.f283728b.f(), this.f283728b.c(), str, com.tencent.mobileqq.ark.f.b(), this.f283728b.d(), f16);
    }

    public void d() {
        destroy();
        this.f283728b = null;
    }

    @Override // com.tencent.ark.ArkViewModel, com.tencent.ark.ArkViewModelBase
    protected void initLibrary() {
        ark.MediaSetStub(ArkMediaPlayer.F);
    }

    protected void loadArkApp(String str, int i3, String str2) {
        boolean z16;
        boolean z17;
        if (QLog.isColorLevel()) {
            QLog.d("ArkNodeContainer", 2, String.format("loadArkApp, apppath:" + str + " retcode:" + i3 + " msg:" + str2, new Object[0]));
        }
        if (i3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i3 == -2) {
            z17 = true;
        } else {
            z17 = false;
        }
        String cacheDirectory = ArkEnvironmentManager.getInstance().getCacheDirectory();
        String storageDirectory = ArkEnvironmentManager.getInstance().getStorageDirectory();
        String appResPath = ArkEnvironmentManager.getInstance().getAppResPath(this.mAppInfo.name);
        a(cacheDirectory);
        a(storageDirectory);
        a(appResPath);
        if (str2 == null) {
            str2 = "";
        }
        doLoadArkApp(str, cacheDirectory, storageDirectory, appResPath, z16, z17, i3, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ark.ArkViewModelBase
    public void onFirstDrawEnd() {
        super.onFirstDrawEnd();
    }

    @Override // com.tencent.ark.open.ArkAppMgr.IGetAppPathByNameCallback
    public void onGetAppPathByName(int i3, String str, ArkAppMgr.AppPathInfo appPathInfo) {
        String str2;
        if (appPathInfo != null) {
            str2 = appPathInfo.path;
        } else {
            str2 = null;
        }
        ArkAppInfo.TimeRecord timeRecord = this.f283727a;
        timeRecord.getAppFromLocal = false;
        timeRecord.endOfGetApp = System.currentTimeMillis();
        loadArkApp(str2, i3, str);
    }

    @Override // com.tencent.ark.ArkViewModelBase
    public boolean onLoadApp(ArkViewModelBase.AppInfo appInfo) {
        if (((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime()) == null) {
            this.mInit = false;
            this.mLoadFailed = true;
            ArkViewImplement arkViewImplement = this.mViewImpl;
            if (arkViewImplement != null) {
                arkViewImplement.onLoadFailed(null, this.mErrorInfo.retCode, true);
            }
            return true;
        }
        this.f283727a.beginOfGetApp = System.currentTimeMillis();
        final String b16 = this.f283728b.b();
        if (TextUtils.isEmpty(b16)) {
            ArkAppMgr arkAppMgr = ArkAppMgr.getInstance();
            ArkViewModelBase.AppInfo appInfo2 = this.mAppInfo;
            b16 = arkAppMgr.getAppPathFromCache(appInfo2.name, appInfo2.bizSrc, appInfo2.appMinVersion);
        }
        if (QLog.isColorLevel()) {
            QLog.i("ArkNodeContainer", 2, String.format("onLoadApp,mAppInfo.name=%s,appPath=%s", this.mAppInfo.name, b16));
        }
        if (!TextUtils.isEmpty(b16)) {
            ArkDispatchTask.getInstance().post(this.mAppInfo.name, new Runnable() { // from class: com.tencent.mobileqq.search.rich.ArkNodeContainer.1
                @Override // java.lang.Runnable
                public void run() {
                    ArkAppInfo.TimeRecord timeRecord = ArkNodeContainer.this.f283727a;
                    timeRecord.getAppFromLocal = true;
                    timeRecord.endOfGetApp = System.currentTimeMillis();
                    if (QLog.isColorLevel()) {
                        QLog.i("ArkNodeContainer", 2, String.format("getAppPathByNameFromLocal.in.wrapper: %h", this));
                    }
                    ArkNodeContainer.this.loadArkApp(b16, 0, null);
                }
            });
            return true;
        }
        ArkViewImplement arkViewImplement2 = this.mViewImpl;
        if (arkViewImplement2 != null) {
            arkViewImplement2.onLoading();
        }
        if (QLog.isColorLevel()) {
            QLog.i("ArkNodeContainer", 2, String.format("onLoadApp,mAppInfo.name=%s,appPath=%s,viewImplement=%h", this.mAppInfo.name, b16, arkViewImplement2));
        }
        ArkAppMgr.getInstance().getAppPathByName(appInfo.name, appInfo.appMinVersion, appInfo.bizSrc, new a(this));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ark.ArkViewModelBase
    public void onRunAppFailed() {
        if (QLog.isColorLevel()) {
            QLog.i("ArkNodeContainer", 2, String.format("onRunAppFailed", new Object[0]));
        }
        ArkViewImplement arkViewImplement = this.mViewImpl;
        if (arkViewImplement != null) {
            if (this.f283728b != null) {
                this.mErrorInfo.f72565msg = String.format(arkViewImplement.getView().getContext().getString(R.string.h_y), this.f283728b.a());
            } else {
                this.mErrorInfo.f72565msg = "";
            }
            this.mErrorInfo.canRetry = false;
        }
        super.onRunAppFailed();
    }
}

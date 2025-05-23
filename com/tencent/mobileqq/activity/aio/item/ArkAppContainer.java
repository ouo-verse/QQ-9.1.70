package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModelBase;
import com.tencent.ark.aio.BaseArkAppContainer;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppInfo;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.aio.msglist.holder.component.ark.view.ArkAsyncRunnableProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.ark.api.IArkService;
import com.tencent.mobileqq.ark.base.DefaultApplicationCallback;
import com.tencent.mobileqq.ark.component.ArkMediaPlayer;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ArkAppContainer extends BaseArkAppContainer {

    /* renamed from: i, reason: collision with root package name */
    public static String f179261i = null;

    /* renamed from: j, reason: collision with root package name */
    public static String f179262j = "";

    /* renamed from: k, reason: collision with root package name */
    private static final ark.ApplicationCallback f179263k = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f179264a;

    /* renamed from: b, reason: collision with root package name */
    public ArkAppMessage.Config f179265b;

    /* renamed from: c, reason: collision with root package name */
    public ArkAppInfo.TimeRecord f179266c;

    /* renamed from: d, reason: collision with root package name */
    protected WeakReference<ArkAppContainer> f179267d;

    /* renamed from: e, reason: collision with root package name */
    protected ArkViewModelBase.Size f179268e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f179269f;

    /* renamed from: g, reason: collision with root package name */
    int f179270g;

    /* renamed from: h, reason: collision with root package name */
    protected WeakReference<b> f179271h;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a extends DefaultApplicationCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.ark.base.DefaultApplicationCallback
        protected boolean b(String str) {
            if (!super.b(str)) {
                return false;
            }
            return !com.tencent.mobileqq.ark.f.e();
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface b {
        boolean Fb(ArkAppContainer arkAppContainer);

        boolean U1(ArkAppContainer arkAppContainer, String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface c {
        void a(ArkAppContainer arkAppContainer, ArkAppLoadLayout arkAppLoadLayout);
    }

    public ArkAppContainer() {
        super(f179263k, !com.tencent.mobileqq.ark.b.f199160b);
        this.f179264a = "";
        this.f179265b = null;
        this.f179266c = new ArkAppInfo.TimeRecord(this.mTimeRecord);
        this.f179269f = false;
        this.f179270g = -1;
        this.f179271h = new WeakReference<>(null);
        this.f179269f = false;
        ((IArkEnvironment) QRoute.api(IArkEnvironment.class)).setScriptLeakCheckEnabled(true);
        this.f179267d = new WeakReference<>(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static QQAppInterface e() {
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        QLog.i("ArkApp.ArkAppContainer", 1, "getAppInterface, return null");
        return null;
    }

    private static void i(ArkAppMgr.AppPathInfo appPathInfo) {
        QQAppInterface e16;
        boolean z16;
        if (appPathInfo != null && (e16 = e()) != null) {
            if (appPathInfo.from != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            ((IArkService) e16.getRuntimeService(IArkService.class)).reportPredownloadFirstHit(appPathInfo.desc.name, z16);
        }
    }

    @Override // com.tencent.ark.ArkViewModelBase
    public void SafeAsyncRun(Runnable runnable) {
        super.SafeAsyncRun(new ArkAsyncRunnableProxy(runnable, d()));
    }

    @Override // com.tencent.ark.ArkViewModelBase
    public void SafeAsyncRunDelay(Runnable runnable, long j3) {
        super.SafeAsyncRunDelay(new ArkAsyncRunnableProxy(runnable, d()), j3);
    }

    public void a(b bVar) {
        this.f179271h = new WeakReference<>(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ark.ArkViewModel, com.tencent.ark.ArkViewModelBase
    public void applicationCreate(ark.Application application) {
        super.applicationCreate(application);
        if (application != null) {
            this.f179264a = application.GetVersion();
        }
    }

    public void b(String str) {
        try {
            new JSONObject(str);
        } catch (Exception e16) {
            com.tencent.mobileqq.ark.d.d("ArkApp.ArkAppContainer", String.format("CheckMetaLegality,appMeta is parse error and msg=%s", e16.getMessage()));
        }
    }

    public String c(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public ArkViewModelBase.AppInfo d() {
        return this.mAppInfo;
    }

    @Override // com.tencent.ark.aio.BaseArkAppContainer
    public void doCloseViewEvent() {
        b bVar = this.f179271h.get();
        if (bVar != null) {
            bVar.Fb(this);
        }
    }

    @Override // com.tencent.ark.aio.BaseArkAppContainer
    public void doOpenCardViewEvent(String str, String str2) {
        b bVar = this.f179271h.get();
        if (bVar != null) {
            bVar.U1(this, str, str2);
        }
    }

    public String f() {
        return "";
    }

    public ArkViewModelBase.Size g() {
        return this.f179268e;
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public int getChatType() {
        return 0;
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public Object getContactData() {
        return null;
    }

    @Override // com.tencent.ark.ArkViewModelBase
    public ark.Container getContainer() {
        return this.mContainer;
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public Object getMyContext() {
        return null;
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public String getPeerNick() {
        return "";
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public String getPeerUid() {
        return null;
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public String getPeerUin() {
        return "";
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public String getSenderUid() {
        return null;
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public String getSenderUin() {
        return f179262j;
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public String getTroopUin() {
        return "";
    }

    public boolean h(String str, String str2, String str3, String str4, String str5, float f16, SessionInfo sessionInfo) {
        boolean z16;
        f179261i = null;
        int i3 = sessionInfo.f179555d;
        if (i3 == 1) {
            f179261i = sessionInfo.f179557e;
        }
        this.f179270g = i3;
        this.f179265b = new ArkAppMessage.Config();
        String f17 = f();
        this.f179265b.fromString(f17);
        Integer num = this.f179265b.round;
        if (num != null && num.intValue() == 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.mRoundCorner = z16;
        if (!TextUtils.isEmpty(str5)) {
            b(str5);
        }
        String b16 = com.tencent.mobileqq.ark.f.b();
        QLog.d("ArkApp.ArkAppContainer", 1, "old container init appName=" + str + ", appView=" + str2 + ", appMinVersion=" + str4 + ", config=" + f17 + ", bizSrc=" + str3 + ", scale=" + f16);
        return super.init(str, str2, str4, str5, b16, str3, f16);
    }

    @Override // com.tencent.ark.aio.BaseArkAppContainer
    protected void handleBeforeGetAppPathName() {
        super.handleBeforeGetAppPathName();
        this.f179266c.beginOfGetApp = System.currentTimeMillis();
    }

    @Override // com.tencent.ark.aio.BaseArkAppContainer
    protected void handleOnGetAppPathByName() {
        super.handleOnGetAppPathByName();
        ArkAppInfo.TimeRecord timeRecord = this.f179266c;
        timeRecord.getAppFromLocal = false;
        timeRecord.endOfGetApp = System.currentTimeMillis();
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public boolean hasContactData() {
        return false;
    }

    @Override // com.tencent.ark.ArkViewModel, com.tencent.ark.ArkViewModelBase
    protected void initLibrary() {
        ark.MediaSetStub(ArkMediaPlayer.F);
    }

    public void j(int i3, int i16) {
        this.f179268e = new ArkViewModelBase.Size(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ark.ArkViewModelBase
    public void onFirstDrawEnd() {
        super.onFirstDrawEnd();
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.item.ArkAppContainer.2
            @Override // java.lang.Runnable
            public void run() {
                ArkAppContainer.this.f179266c.doReport();
                ArkAppContainer.this.f179266c.doExtraTimeReport();
            }
        });
    }

    @Override // com.tencent.ark.aio.BaseArkAppContainer
    protected void onLoadAppPathInfoCache(ArkAppMgr.AppPathInfo appPathInfo) {
        super.onLoadAppPathInfoCache(appPathInfo);
        i(appPathInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ark.ArkViewModelBase
    public void onRunAppFailed() {
        ArkViewImplement arkViewImplement = this.mViewImpl;
        if (arkViewImplement != null) {
            ark.Application application = this.mApplication;
            if (application != null && application.GetScriptType() == 2 && !ark.Application.JSCLoaded()) {
                String string = arkViewImplement.getView().getContext().getString(R.string.c2e);
                this.mErrorInfo.f72565msg = c(string);
                this.mErrorInfo.canRetry = true;
                if (((IArkEnvironment) QRoute.api(IArkEnvironment.class)).isJSCLibExist()) {
                    ((IArkEnvironment) QRoute.api(IArkEnvironment.class)).initJSCLibPath();
                    QLog.i("ArkApp.ArkAppContainer", 1, "run app fail, jsc load fail, init path");
                } else {
                    QLog.i("ArkApp.ArkAppContainer", 1, "run app fail, jsc load fail, library not exist");
                }
            } else {
                String string2 = arkViewImplement.getView().getContext().getString(R.string.c2j);
                this.mErrorInfo.f72565msg = c(string2);
                this.mErrorInfo.canRetry = false;
            }
        }
        super.onRunAppFailed();
    }

    public ArkAppContainer(boolean z16) {
        super(f179263k, z16 && !com.tencent.mobileqq.ark.b.f199160b);
        this.f179264a = "";
        this.f179265b = null;
        this.f179266c = new ArkAppInfo.TimeRecord(this.mTimeRecord);
        this.f179269f = false;
        this.f179270g = -1;
        this.f179271h = new WeakReference<>(null);
        this.f179269f = false;
        l91.a.a();
        this.f179267d = new WeakReference<>(this);
    }
}

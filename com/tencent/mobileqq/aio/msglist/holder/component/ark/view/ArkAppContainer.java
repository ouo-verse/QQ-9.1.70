package com.tencent.mobileqq.aio.msglist.holder.component.ark.view;

import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModelBase;
import com.tencent.ark.aio.BaseArkAppContainer;
import com.tencent.ark.ark;
import com.tencent.ark.data.ArkAppConfig;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.helper.t;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IArkApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkAppContainer extends BaseArkAppContainer {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.aio.api.runtime.a f190675a;

    /* renamed from: b, reason: collision with root package name */
    private MsgRecord f190676b;

    /* renamed from: c, reason: collision with root package name */
    private ArkAppConfig f190677c;

    /* renamed from: d, reason: collision with root package name */
    protected ArkViewModelBase.Size f190678d;

    /* renamed from: e, reason: collision with root package name */
    private String f190679e;

    /* renamed from: f, reason: collision with root package name */
    protected WeakReference<ArkAppContainer> f190680f;

    public ArkAppContainer(com.tencent.aio.api.runtime.a aVar) {
        this(true, aVar);
    }

    @Override // com.tencent.ark.ArkViewModelBase
    public void SafeAsyncRun(Runnable runnable) {
        super.SafeAsyncRun(new ArkAsyncRunnableProxy(runnable, this.mAppInfo));
    }

    @Override // com.tencent.ark.ArkViewModelBase
    public void SafeAsyncRunDelay(Runnable runnable, long j3) {
        super.SafeAsyncRunDelay(new ArkAsyncRunnableProxy(runnable, this.mAppInfo), j3);
    }

    @Override // com.tencent.ark.ArkViewModelBase
    public void activateView(boolean z16, boolean z17) {
        boolean z18 = this.mIsActivated;
        super.activateView(z16, z17);
        if (z18 == this.mIsActivated) {
            return;
        }
        if (this.mIsActivated) {
            t.INSTANCE.d(this.f190675a, this.f190680f);
        } else {
            t.INSTANCE.c(this.f190675a, this.f190680f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ark.ArkViewModel, com.tencent.ark.ArkViewModelBase
    public void applicationCreate(ark.Application application) {
        super.applicationCreate(application);
        if (application != null) {
            this.f190679e = application.GetVersion();
        }
    }

    public com.tencent.aio.api.runtime.a c() {
        return this.f190675a;
    }

    public String d() {
        return this.f190679e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ark.aio.BaseArkAppContainer, com.tencent.ark.ArkViewModelBase
    public void destroy() {
        super.destroy();
        t.INSTANCE.e(this.f190675a, this.f190680f);
    }

    public ArkAppConfig e() {
        return this.f190677c;
    }

    public ArkViewModelBase.Size f() {
        return this.f190678d;
    }

    public WeakReference<ArkAppContainer> g() {
        return this.f190680f;
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public int getChatType() {
        MsgRecord msgRecord = this.f190676b;
        if (msgRecord != null) {
            return msgRecord.getChatType();
        }
        return 0;
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public Object getContactData() {
        return this.f190676b;
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public Object getMyContext() {
        return c();
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public String getPeerNick() {
        MsgRecord msgRecord = this.f190676b;
        if (msgRecord != null) {
            return msgRecord.getPeerName();
        }
        return "";
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public String getPeerUid() {
        MsgRecord msgRecord = this.f190676b;
        if (msgRecord != null) {
            return String.valueOf(msgRecord.getPeerUid());
        }
        return "";
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public String getPeerUin() {
        MsgRecord msgRecord = this.f190676b;
        if (msgRecord != null) {
            return String.valueOf(msgRecord.getPeerUin());
        }
        return "";
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public String getSenderUid() {
        MsgRecord msgRecord = this.f190676b;
        if (msgRecord != null) {
            return String.valueOf(msgRecord.getSenderUid());
        }
        return "";
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public String getSenderUin() {
        MsgRecord msgRecord = this.f190676b;
        if (msgRecord != null) {
            return String.valueOf(msgRecord.getSenderUin());
        }
        return "";
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public String getTroopUin() {
        MsgRecord msgRecord = this.f190676b;
        if (msgRecord != null) {
            return msgRecord.getGuildId();
        }
        return "";
    }

    @Override // com.tencent.ark.ArkViewModelBase
    public String getViewId() {
        MsgRecord msgRecord = this.f190676b;
        if (msgRecord == null) {
            return null;
        }
        return String.valueOf(msgRecord.getMsgId());
    }

    public void h(com.tencent.aio.api.runtime.a aVar) {
        this.f190675a = aVar;
    }

    @Override // com.tencent.ark.aio.IArkAppContainerModel
    public boolean hasContactData() {
        if (this.f190676b != null) {
            return true;
        }
        return false;
    }

    public void i(int i3, int i16) {
        this.f190678d = new ArkViewModelBase.Size(i3, i16);
    }

    @Override // com.tencent.ark.aio.BaseArkAppContainer, com.tencent.ark.ArkViewModelBase
    public boolean init(String str, String str2, String str3, String str4, String str5, String str6, float f16) {
        boolean z16 = true;
        QLog.d("ArkApp.ArkAppContainer", 1, "init appName=" + str + ", appView=" + str2 + ", appMinVersion=" + str3 + ", config=" + str5 + ", bizSrc=" + str6 + ", scale=" + f16);
        t.INSTANCE.d(this.f190675a, this.f190680f);
        ArkAppConfig arkAppConfig = new ArkAppConfig();
        this.f190677c = arkAppConfig;
        arkAppConfig.fromString(str5);
        Integer num = this.f190677c.round;
        if (num != null && num.intValue() == 0) {
            z16 = false;
        }
        this.mRoundCorner = z16;
        return super.init(str, str2, str3, str4, ((IArkApi) com.tencent.qqnt.aio.adapter.a.b(IArkApi.class)).getCurrentAppConfig(), str6, f16);
    }

    @Override // com.tencent.ark.ArkViewModel, com.tencent.ark.ArkViewModelBase
    protected void initLibrary() {
        ark.MediaSetStub(((IArkApi) com.tencent.qqnt.aio.adapter.a.b(IArkApi.class)).getPlayerStubFactory());
    }

    public void j(MsgRecord msgRecord) {
        this.f190676b = msgRecord;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ark.ArkViewModelBase
    public void onFirstDrawEnd() {
        super.onFirstDrawEnd();
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.ark.view.ArkAppContainer.1
            @Override // java.lang.Runnable
            public void run() {
                ((BaseArkAppContainer) ArkAppContainer.this).mExtraTimerRecord.doReport();
                ((BaseArkAppContainer) ArkAppContainer.this).mExtraTimerRecord.doExtraTimeReport();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ark.ArkViewModelBase
    public void onRunAppFailed() {
        ArkViewImplement arkViewImplement = this.mViewImpl;
        if (arkViewImplement != null) {
            ark.Application application = this.mApplication;
            if (application != null && application.GetScriptType() == 2 && !ark.Application.JSCLoaded()) {
                this.mErrorInfo.f72565msg = arkViewImplement.getView().getContext().getString(R.string.c2e);
                this.mErrorInfo.canRetry = true;
            } else {
                this.mErrorInfo.f72565msg = arkViewImplement.getView().getContext().getString(R.string.c2j);
                this.mErrorInfo.canRetry = false;
            }
        }
        super.onRunAppFailed();
    }

    public ArkAppContainer(boolean z16, com.tencent.aio.api.runtime.a aVar) {
        super(((IArkApi) com.tencent.qqnt.aio.adapter.a.b(IArkApi.class)).getApplicationCallback(), z16 && !((IArkApi) com.tencent.qqnt.aio.adapter.a.b(IArkApi.class)).isEngineDisableHardwareRendering());
        this.f190679e = "";
        WeakReference<ArkAppContainer> weakReference = new WeakReference<>(this);
        this.f190680f = weakReference;
        this.f190675a = aVar;
        t.INSTANCE.d(aVar, weakReference);
        ((IArkApi) com.tencent.qqnt.aio.adapter.a.b(IArkApi.class)).setScriptLeakCheckEnabled(true);
        ((IArkApi) com.tencent.qqnt.aio.adapter.a.b(IArkApi.class)).initArkEnv();
    }

    @Override // com.tencent.ark.aio.BaseArkAppContainer
    public void doCloseViewEvent() {
    }

    @Override // com.tencent.ark.aio.BaseArkAppContainer
    public void doOpenCardViewEvent(String str, String str2) {
    }
}

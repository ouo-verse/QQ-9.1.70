package com.tencent.mobileqq.vip.impl;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.accountPage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.VasMMKVProxy;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVasQQSettingMe;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0006\u0010\u0006\u001a\u00020\u0002R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vip/impl/VasQQSettingMeImpl;", "Lcom/tencent/mobileqq/vip/IVasQQSettingMe;", "", "reqAccountJumpUrl", "", "getAccountJumpUrl", "clearAccountJumpUrl", "", "justReqTime", "J", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasQQSettingMeImpl implements IVasQQSettingMe {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String ACCOUNT_URL = "account_url";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String EXPIRE_TIME = "expire_time";

    @NotNull
    public static final String REQ_CMD = "trpc.qqva.tab_proxy.AccountPage.SsoGetAccountPageURL";

    @NotNull
    public static final String TAG = "VasQQSettingMeImpl";

    @NotNull
    public static final String TG_RQ_CONTROL = "account_req_control";

    @NotNull
    public static final String TG_SERVICE_NAME = "vas_experiment_switch";

    @NotNull
    public static final String TG_SWITCH = "account_switch";
    private long justReqTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vip/impl/VasQQSettingMeImpl$a;", "", "", "ACCOUNT_URL", "Ljava/lang/String;", "EXPIRE_TIME", "REQ_CMD", "TAG", "TG_RQ_CONTROL", "TG_SERVICE_NAME", "TG_SWITCH", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50240);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public VasQQSettingMeImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reqAccountJumpUrl$lambda$0(VasMMKVProxy mmkv, int i3, boolean z16, Object obj) {
        String str;
        Intrinsics.checkNotNullParameter(mmkv, "$mmkv");
        if (z16 && (obj instanceof accountPage.GetAccountPageURLRsp)) {
            str = ((accountPage.GetAccountPageURLRsp) obj).url.get();
        } else {
            str = "";
        }
        mmkv.encodeString(ACCOUNT_URL, str);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "rsp : " + z16 + " >> " + str);
        }
    }

    public final void clearAccountJumpUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        VasMMKVProxy accountInfo = VasMMKV.INSTANCE.getAccountInfo(VasUtil.getApp().getCurrentAccountUin());
        accountInfo.removeKey(EXPIRE_TIME);
        accountInfo.removeKey(ACCOUNT_URL);
    }

    @Override // com.tencent.mobileqq.vip.IVasQQSettingMe
    @Nullable
    public String getAccountJumpUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String decodeString = VasMMKV.INSTANCE.getAccountInfo(VasUtil.getApp().getCurrentAccountUin()).decodeString(ACCOUNT_URL, "");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "get: " + decodeString);
        }
        return decodeString;
    }

    @Override // com.tencent.mobileqq.vip.IVasQQSettingMe
    public void reqAccountJumpUrl() {
        Boolean bool;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (Math.abs(currentTimeMillis - this.justReqTime) < 2) {
            return;
        }
        this.justReqTime = currentTimeMillis;
        AppRuntime app = VasUtil.getApp();
        IRuntimeService runtimeService = app.getRuntimeService(IFeatureRuntimeService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026ava, ProcessConstant.ALL)");
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) runtimeService;
        if (!iFeatureRuntimeService.isFeatureSwitchEnable(TG_SERVICE_NAME, false)) {
            clearAccountJumpUrl();
            return;
        }
        JSONObject jSONObject = iFeatureRuntimeService.getJSONObject(TG_SERVICE_NAME, "");
        if (jSONObject != null) {
            bool = Boolean.valueOf(jSONObject.optBoolean(TG_SWITCH));
        } else {
            bool = null;
        }
        if (bool != null && !Intrinsics.areEqual(bool, Boolean.FALSE)) {
            final VasMMKVProxy accountInfo = VasMMKV.INSTANCE.getAccountInfo(app.getCurrentAccountUin());
            if (Math.abs(currentTimeMillis - accountInfo.decodeLong(EXPIRE_TIME, 0L)) < jSONObject.optLong(TG_RQ_CONTROL)) {
                return;
            }
            accountInfo.encodeLong(EXPIRE_TIME, currentTimeMillis);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "req : currentTime\uff1a " + currentTimeMillis + " interavleTime: " + jSONObject.optLong(TG_RQ_CONTROL) + " ");
            }
            VasUtil.getService(app).getPbRequest().request(REQ_CMD, new accountPage.GetAccountPageURLReq(), accountPage.GetAccountPageURLRsp.class, new BusinessObserver() { // from class: com.tencent.mobileqq.vip.impl.a
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public final void onUpdate(int i3, boolean z16, Object obj) {
                    VasQQSettingMeImpl.reqAccountJumpUrl$lambda$0(VasMMKVProxy.this, i3, z16, obj);
                }
            });
            return;
        }
        clearAccountJumpUrl();
    }
}

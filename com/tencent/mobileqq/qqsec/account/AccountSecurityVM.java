package com.tencent.mobileqq.qqsec.account;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.QQProtectRisks$QQProtectRisksRequest;
import com.tencent.ims.QQProtectRisks$QQProtectRisksResponse;
import com.tencent.ims.QQProtectRisks$RiskInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.identity.ISafeApi;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.identification.af;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.IWXAuthApi;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.api.IQPMiscUtilsApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import face.qqlogin.FaceSecureCheck$SecureCheckResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_0x5e1$RspBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 Z2\u00020\u0001:\u0001[B\u0007\u00a2\u0006\u0004\bX\u0010YJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0002J\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\bJ\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\bR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"R\u001f\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0\u001e8\u0006\u00a2\u0006\f\n\u0004\b(\u0010 \u001a\u0004\b)\u0010\"R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b+\u0010 \u001a\u0004\b,\u0010\"R\u001f\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0\u001e8\u0006\u00a2\u0006\f\n\u0004\b/\u0010 \u001a\u0004\b0\u0010\"R%\u00106\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000203\u0018\u0001020\u001e8\u0006\u00a2\u0006\f\n\u0004\b4\u0010 \u001a\u0004\b5\u0010\"R\u001d\u00109\u001a\b\u0012\u0004\u0012\u00020\u00160\u001e8\u0006\u00a2\u0006\f\n\u0004\b7\u0010 \u001a\u0004\b8\u0010\"R2\u0010@\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010BR$\u0010L\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010T\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0013\u0010W\u001a\u0004\u0018\u00010.8F\u00a2\u0006\u0006\u001a\u0004\bU\u0010V\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/qqsec/account/AccountSecurityVM;", "Landroidx/lifecycle/ViewModel;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", SemanticAttributes.DbSystemValues.H2, "Lcom/tencent/ims/QQProtectRisks$QQProtectRisksResponse;", "rspBody", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqsec/account/RiskInfoItem;", "Lkotlin/collections/ArrayList;", "i2", "u2", "", "message", "r2", "l2", "m2", "", "g2", "result", "q2", "R1", "j2", "t2", "b2", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Landroidx/lifecycle/MutableLiveData;", "riskInfoLiveData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getQpimSwitchLiveData", "qpimSwitchLiveData", "Ltencent/im/oidb/oidb_0x5e1$RspBody;", BdhLogUtil.LogTag.Tag_Conn, "W1", "faceStateLiveData", "D", "X1", "gesturePwdStateLiveData", "Loicq/wlogin_sdk/devicelock/DevlockInfo;", "E", "T1", "devlockInfoLiveData", "", "Lcom/tencent/mobileqq/dt/api/g;", UserInfo.SEX_FEMALE, "d2", "secureEntryLiveData", "G", "f2", "thirdAccountLiveData", "H", "Ljava/util/ArrayList;", "Z1", "()Ljava/util/ArrayList;", "setRiskInfoItems", "(Ljava/util/ArrayList;)V", "riskInfoItems", "I", "Ljava/lang/String;", "tipTextNoRisks", "J", "tipTextWithRisks", "K", "Ltencent/im/oidb/oidb_0x5e1$RspBody;", "U1", "()Ltencent/im/oidb/oidb_0x5e1$RspBody;", "o2", "(Ltencent/im/oidb/oidb_0x5e1$RspBody;)V", "faceStateInfo", "Lface/qqlogin/FaceSecureCheck$SecureCheckResponse;", "L", "Lface/qqlogin/FaceSecureCheck$SecureCheckResponse;", "e2", "()Lface/qqlogin/FaceSecureCheck$SecureCheckResponse;", "p2", "(Lface/qqlogin/FaceSecureCheck$SecureCheckResponse;)V", "secureInfo", "S1", "()Loicq/wlogin_sdk/devicelock/DevlockInfo;", "devlockInfo", "<init>", "()V", "M", "a", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class AccountSecurityVM extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<oidb_0x5e1$RspBody> faceStateLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> gesturePwdStateLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<DevlockInfo> devlockInfoLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<com.tencent.mobileqq.dt.api.g>> secureEntryLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> thirdAccountLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private ArrayList<RiskInfoItem> riskInfoItems;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private String tipTextNoRisks;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private String tipTextWithRisks;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private oidb_0x5e1$RspBody faceStateInfo;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private FaceSecureCheck$SecureCheckResponse secureInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Bundle> riskInfoLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> qpimSwitchLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqsec/account/AccountSecurityVM$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqsec.account.AccountSecurityVM$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qqsec/account/AccountSecurityVM$b", "Lcom/tencent/mobileqq/observer/c;", "Lface/qqlogin/FaceSecureCheck$SecureCheckResponse;", "rsp", "", "checkSecureResponse", "", "cmd", "", "code", "message", "onFailedResponse", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends com.tencent.mobileqq.observer.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountSecurityVM.this);
            }
        }

        @Override // com.tencent.mobileqq.observer.c
        public void checkSecureResponse(@Nullable FaceSecureCheck$SecureCheckResponse rsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
            } else {
                QLog.i("AccountSecurityVM", 1, "checkSecureResponse");
                AccountSecurityVM.this.p2(rsp);
            }
        }

        @Override // com.tencent.mobileqq.observer.c
        public void onFailedResponse(@Nullable String cmd, int code, @Nullable String message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, cmd, Integer.valueOf(code), message);
                return;
            }
            QLog.w("AccountSecurityVM", 1, "checkUserSecureInfo onFailedResponse cmd:" + cmd + " code:" + code + " message:" + message);
            if (code == 1002) {
                message = BaseApplication.getContext().getString(R.string.yjh);
            }
            if (message != null) {
                AccountSecurityVM.this.r2(message);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qqsec/account/AccountSecurityVM$c", "Lcom/tencent/mobileqq/observer/c;", "Ltencent/im/oidb/oidb_0x5e1$RspBody;", "rspBody", "", "getFaceStateSuccess", "", "cmd", "", "code", "message", "onFailedResponse", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c extends com.tencent.mobileqq.observer.c {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountSecurityVM.this);
            }
        }

        @Override // com.tencent.mobileqq.observer.c
        public void getFaceStateSuccess(@Nullable oidb_0x5e1$RspBody rspBody) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rspBody);
                return;
            }
            QLog.i("AccountSecurityVM", 1, "getFaceStateSuccess");
            AccountSecurityVM.this.o2(rspBody);
            AccountSecurityVM.this.W1().postValue(rspBody);
        }

        @Override // com.tencent.mobileqq.observer.c
        public void onFailedResponse(@Nullable String cmd, int code, @Nullable String message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, cmd, Integer.valueOf(code), message);
                return;
            }
            QLog.w("AccountSecurityVM", 1, "getUserFaceState onFailedResponse cmd:" + cmd + " code:" + code + " message:" + message);
            if (code == 1002) {
                message = BaseApplication.getContext().getString(R.string.yjh);
            }
            if (message != null) {
                AccountSecurityVM.this.r2(message);
            }
            AccountSecurityVM.this.W1().postValue(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqsec/account/AccountSecurityVM$d", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountSecurityVM.this);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AccountSecurityVM.this.h2(errorCode, data, bundle);
            } else {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(errorCode), data, bundle);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J.\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qqsec/account/AccountSecurityVM$e", "Lcom/tencent/mobileqq/loginregister/servlet/h;", "Loicq/wlogin_sdk/request/WUserSigInfo;", "userSigInfo", "Loicq/wlogin_sdk/devicelock/DevlockInfo;", "info", "", "ret", "Loicq/wlogin_sdk/tools/ErrMsg;", "errMsg", "", "c", "qqsafeblock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class e extends com.tencent.mobileqq.loginregister.servlet.h {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ISafeApi f274380e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AppRuntime f274381f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f274382h;

        e(ISafeApi iSafeApi, AppRuntime appRuntime, String str) {
            this.f274380e = iSafeApi;
            this.f274381f = appRuntime;
            this.f274382h = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AccountSecurityVM.this, iSafeApi, appRuntime, str);
            }
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.h
        public void c(@Nullable WUserSigInfo userSigInfo, @Nullable DevlockInfo info, int ret, @Nullable ErrMsg errMsg) {
            String str;
            String tips;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, userSigInfo, info, Integer.valueOf(ret), errMsg);
                return;
            }
            QLog.i("AccountSecurityVM", 1, "onCheckDevLockStatus ret:" + ret);
            if (info == null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onCheckDevLockStatus errMsg:");
                if (errMsg != null) {
                    str = errMsg.getMessage();
                } else {
                    str = null;
                }
                sb5.append(str);
                QLog.e("AccountSecurityVM", 1, sb5.toString());
                if (errMsg != null && !TextUtils.isEmpty(errMsg.getMessage())) {
                    tips = errMsg.getMessage();
                } else {
                    tips = BaseApplication.getContext().getString(R.string.aza);
                }
                AccountSecurityVM accountSecurityVM = AccountSecurityVM.this;
                Intrinsics.checkNotNullExpressionValue(tips, "tips");
                accountSecurityVM.r2(tips);
            } else {
                com.tencent.mobileqq.equipmentlock.a.b().f(info.TransferInfo);
                String str2 = info.MbGuideInfo;
                if (str2 != null) {
                    this.f274380e.setLocalSecretPhoneUrl(str2);
                }
                if (info.DevSetup == 1) {
                    z16 = true;
                }
                this.f274380e.setLocalDevlockStatus(this.f274381f, BaseApplication.getContext(), this.f274382h, z16);
            }
            AccountSecurityVM.this.T1().postValue(info);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18407);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AccountSecurityVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.riskInfoLiveData = new MutableLiveData<>();
        this.qpimSwitchLiveData = new MutableLiveData<>();
        this.faceStateLiveData = new MutableLiveData<>();
        this.gesturePwdStateLiveData = new MutableLiveData<>();
        this.devlockInfoLiveData = new MutableLiveData<>();
        this.secureEntryLiveData = new MutableLiveData<>();
        this.thirdAccountLiveData = new MutableLiveData<>();
        this.riskInfoItems = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(AccountSecurityVM this$0, int i3, List list) {
        Integer num;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getSecureEntryData callback code:");
        sb5.append(i3);
        sb5.append(" size:");
        if (list != null) {
            num = Integer.valueOf(list.size());
        } else {
            num = null;
        }
        sb5.append(num);
        QLog.i("AccountSecurityVM", 1, sb5.toString());
        this$0.secureEntryLiveData.postValue(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h2(int errorCode, byte[] data, Bundle bundle) {
        ArrayList<RiskInfoItem> arrayList;
        String str;
        Object orNull;
        int i3;
        boolean z16 = true;
        QLog.i("AccountSecurityVM", 1, "handleRiskInfoResponse errorCode:" + errorCode);
        QQProtectRisks$QQProtectRisksResponse qQProtectRisks$QQProtectRisksResponse = null;
        if (errorCode == 0 && data != null) {
            try {
                QQProtectRisks$QQProtectRisksResponse qQProtectRisks$QQProtectRisksResponse2 = new QQProtectRisks$QQProtectRisksResponse();
                qQProtectRisks$QQProtectRisksResponse2.mergeFrom(data);
                qQProtectRisks$QQProtectRisksResponse = qQProtectRisks$QQProtectRisksResponse2;
            } catch (Throwable th5) {
                QLog.d("AccountSecurityVM", 1, "error protobuf content:", th5);
            }
        }
        if (qQProtectRisks$QQProtectRisksResponse != null) {
            arrayList = i2(qQProtectRisks$QQProtectRisksResponse);
        } else {
            arrayList = new ArrayList<>();
        }
        this.riskInfoItems = arrayList;
        if (qQProtectRisks$QQProtectRisksResponse != null) {
            u2(qQProtectRisks$QQProtectRisksResponse);
            if (qQProtectRisks$QQProtectRisksResponse.uint32_qpim_switches.has()) {
                this.qpimSwitchLiveData.postValue(Integer.valueOf(qQProtectRisks$QQProtectRisksResponse.uint32_qpim_switches.get()));
            }
        }
        if (!this.riskInfoItems.isEmpty()) {
            if (TextUtils.isEmpty(this.tipTextWithRisks)) {
                String str2 = this.riskInfoItems.get(0).f274383d;
                Intrinsics.checkNotNullExpressionValue(str2, "riskInfoItems[0].mLeftText");
                int size = this.riskInfoItems.size();
                String string = BaseApplication.getContext().getString(R.string.f172954g30);
                Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026g.qsec_risk_info_dangers)");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(string, Arrays.copyOf(new Object[]{str2, Integer.valueOf(size)}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                this.tipTextWithRisks = format;
            }
            str = this.tipTextWithRisks;
            z16 = false;
        } else {
            if (TextUtils.isEmpty(this.tipTextNoRisks)) {
                this.tipTextNoRisks = BaseApplication.getContext().getString(R.string.f172957g33);
            }
            str = this.tipTextNoRisks;
        }
        if (qQProtectRisks$QQProtectRisksResponse == null) {
            str = BaseApplication.getContext().getString(R.string.f172956g32);
        }
        MutableLiveData<Bundle> mutableLiveData = this.riskInfoLiveData;
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("bSafe", z16);
        bundle2.putString("TipText", str);
        mutableLiveData.postValue(bundle2);
        int size2 = this.riskInfoItems.size();
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.riskInfoItems, 0);
        RiskInfoItem riskInfoItem = (RiskInfoItem) orNull;
        if (riskInfoItem != null) {
            i3 = riskInfoItem.f274388m;
        } else {
            i3 = 100;
        }
        ReportController.o(null, "dc00898", "", "", "0X800C28F", "0X800C28F", i3, 0, String.valueOf(size2), "", "", "");
    }

    private final ArrayList<RiskInfoItem> i2(QQProtectRisks$QQProtectRisksResponse rspBody) {
        ArrayList<RiskInfoItem> arrayList = new ArrayList<>();
        if (rspBody.uint32_sec_cmd.get() != 1) {
            return arrayList;
        }
        String str = rspBody.str_no_risk_text.get();
        if (!TextUtils.isEmpty(str)) {
            this.tipTextNoRisks = str;
        }
        String str2 = rspBody.str_risk_tip_text.get();
        if (!TextUtils.isEmpty(str2)) {
            this.tipTextWithRisks = str2;
        }
        if (rspBody.risk_info_list.has() && !rspBody.risk_info_list.isEmpty()) {
            int size = rspBody.risk_info_list.size();
            for (int i3 = 0; i3 < size; i3++) {
                QQProtectRisks$RiskInfo qQProtectRisks$RiskInfo = rspBody.risk_info_list.get(i3);
                Intrinsics.checkNotNullExpressionValue(qQProtectRisks$RiskInfo, "rspBody.risk_info_list.get(index)");
                QQProtectRisks$RiskInfo qQProtectRisks$RiskInfo2 = qQProtectRisks$RiskInfo;
                if (!qQProtectRisks$RiskInfo2.uint32_item_type.has() || qQProtectRisks$RiskInfo2.uint32_item_type.get() != 1) {
                    RiskInfoItem riskInfoItem = new RiskInfoItem();
                    riskInfoItem.f274383d = qQProtectRisks$RiskInfo2.str_left_text.get();
                    riskInfoItem.f274386h = qQProtectRisks$RiskInfo2.str_jump_target.get();
                    if (!TextUtils.isEmpty(riskInfoItem.f274383d) && !TextUtils.isEmpty(riskInfoItem.f274386h)) {
                        riskInfoItem.f274384e = qQProtectRisks$RiskInfo2.str_right_text.get();
                        riskInfoItem.f274385f = qQProtectRisks$RiskInfo2.str_desc_text.get();
                        riskInfoItem.f274387i = qQProtectRisks$RiskInfo2.uint32_click_report_id.get();
                        if (qQProtectRisks$RiskInfo2.uint32_item_id.has()) {
                            riskInfoItem.f274388m = qQProtectRisks$RiskInfo2.uint32_item_id.get();
                        }
                        if (qQProtectRisks$RiskInfo2.str_right_text_open.has()) {
                            riskInfoItem.C = qQProtectRisks$RiskInfo2.str_right_text_open.get();
                        }
                        arrayList.add(riskInfoItem);
                        QLog.d("AccountSecurityVM", 1, riskInfoItem.f274383d + ',' + riskInfoItem.f274384e + ',' + riskInfoItem.f274385f + ',' + riskInfoItem.f274386h + ',' + riskInfoItem.f274387i + ',' + riskInfoItem.f274388m + ',' + riskInfoItem.C);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(AccountSecurityVM this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        this$0.gesturePwdStateLiveData.postValue(Integer.valueOf(BaseGesturePWDUtil.getGesturePWDState(BaseApplication.getContext(), peekAppRuntime.getCurrentAccountUin())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n2(AccountSecurityVM this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("AccountSecurityVM", 2, "requestThirdAccountBindingInfo status: " + z16);
        if (!Intrinsics.areEqual(Boolean.valueOf(z16), this$0.thirdAccountLiveData.getValue())) {
            this$0.thirdAccountLiveData.postValue(Boolean.valueOf(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r2(final String message) {
        final Function0<Toast> function0 = new Function0<Toast>(message) { // from class: com.tencent.mobileqq.qqsec.account.AccountSecurityVM$showToast$toastBlock$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $message;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$message = message;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) message);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Toast invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Toast) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return QQToast.makeText(BaseApplication.getContext(), 1, this.$message, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            }
        };
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            function0.invoke();
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqsec.account.r
                @Override // java.lang.Runnable
                public final void run() {
                    AccountSecurityVM.s2(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s2(Function0 toastBlock) {
        Intrinsics.checkNotNullParameter(toastBlock, "$toastBlock");
        toastBlock.invoke();
    }

    private final void u2(QQProtectRisks$QQProtectRisksResponse rspBody) {
        long j3;
        String str;
        String str2;
        if (rspBody.uint32_cache_time.has()) {
            j3 = rspBody.uint32_cache_time.get();
        } else {
            j3 = 3600;
        }
        long j16 = j3;
        if (rspBody.str_risk_exist.has()) {
            str = rspBody.str_risk_exist.get();
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str) && rspBody.risk_info_list.has() && !rspBody.risk_info_list.isEmpty()) {
            str2 = BaseApplication.getContext().getString(R.string.frr);
        } else {
            str2 = str;
        }
        u.f274415a.b(str2, j16, System.currentTimeMillis());
    }

    public final void R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        QLog.i("AccountSecurityVM", 1, "checkUserSecureInfo start");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        LoginVerifyServlet.d(peekAppRuntime, peekAppRuntime.getCurrentAccountUin(), new b());
    }

    @Nullable
    public final DevlockInfo S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (DevlockInfo) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.devlockInfoLiveData.getValue();
    }

    @NotNull
    public final MutableLiveData<DevlockInfo> T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.devlockInfoLiveData;
    }

    @Nullable
    public final oidb_0x5e1$RspBody U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (oidb_0x5e1$RspBody) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.faceStateInfo;
    }

    @NotNull
    public final MutableLiveData<oidb_0x5e1$RspBody> W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.faceStateLiveData;
    }

    @NotNull
    public final MutableLiveData<Integer> X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.gesturePwdStateLiveData;
    }

    @NotNull
    public final ArrayList<RiskInfoItem> Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.riskInfoItems;
    }

    @NotNull
    public final MutableLiveData<Bundle> a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.riskInfoLiveData;
    }

    public final void b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            ((IDTAPI) QRoute.api(IDTAPI.class)).getSecureEntryList(new com.tencent.mobileqq.dt.api.f() { // from class: com.tencent.mobileqq.qqsec.account.s
                @Override // com.tencent.mobileqq.dt.api.f
                public final void onResult(int i3, List list) {
                    AccountSecurityVM.c2(AccountSecurityVM.this, i3, list);
                }
            });
        }
    }

    @NotNull
    public final MutableLiveData<List<com.tencent.mobileqq.dt.api.g>> d2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.secureEntryLiveData;
    }

    @Nullable
    public final FaceSecureCheck$SecureCheckResponse e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (FaceSecureCheck$SecureCheckResponse) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.secureInfo;
    }

    @NotNull
    public final MutableLiveData<Boolean> f2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.thirdAccountLiveData;
    }

    public final boolean g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        if (!(com.tencent.mobileqq.identification.c.j().a() instanceof af)) {
            QLog.i("AccountSecurityVM", 1, "getUserFaceState return, area is not usable");
            ReportController.r(null, "dc00898", "", "", "0X800B0EC", "0X800B0EC", 0, 0, "", "", "", "");
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        QLog.i("AccountSecurityVM", 1, "getUserFaceState start");
        LoginVerifyServlet.h(peekAppRuntime, peekAppRuntime.getCurrentAccountUin(), new c());
        return true;
    }

    public final void j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqsec.account.p
                @Override // java.lang.Runnable
                public final void run() {
                    AccountSecurityVM.k2(AccountSecurityVM.this);
                }
            }, 16, null, true);
        }
    }

    public final void l2() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        QQProtectRisks$QQProtectRisksRequest qQProtectRisks$QQProtectRisksRequest = new QQProtectRisks$QQProtectRisksRequest();
        qQProtectRisks$QQProtectRisksRequest.uint32_sec_cmd.set(1);
        qQProtectRisks$QQProtectRisksRequest.str_package_name.set(((IQPMiscUtilsApi) QRoute.api(IQPMiscUtilsApi.class)).getAppPackageName());
        qQProtectRisks$QQProtectRisksRequest.uint32_app_id.set(AppSetting.f());
        qQProtectRisks$QQProtectRisksRequest.support_more_security_check.set(true);
        ProtoUtils.d(appInterface, new d(), qQProtectRisks$QQProtectRisksRequest.toByteArray(), "AccountSafeSvc.RiskDetect");
    }

    public final void m2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            QLog.d("AccountSecurityVM", 2, "requestThirdAccountBindingInfo");
            ((IWXAuthApi) QRoute.api(IWXAuthApi.class)).checkWXNeedShowRedDotGuide(new IWXAuthApi.b() { // from class: com.tencent.mobileqq.qqsec.account.q
                @Override // com.tencent.mobileqq.wxapi.IWXAuthApi.b
                public final void onResult(boolean z16) {
                    AccountSecurityVM.n2(AccountSecurityVM.this, z16);
                }
            });
        }
    }

    public final void o2(@Nullable oidb_0x5e1$RspBody oidb_0x5e1_rspbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) oidb_0x5e1_rspbody);
        } else {
            this.faceStateInfo = oidb_0x5e1_rspbody;
        }
    }

    public final void p2(@Nullable FaceSecureCheck$SecureCheckResponse faceSecureCheck$SecureCheckResponse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) faceSecureCheck$SecureCheckResponse);
        } else {
            this.secureInfo = faceSecureCheck$SecureCheckResponse;
        }
    }

    public final void q2(int result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, result);
            return;
        }
        oidb_0x5e1$RspBody oidb_0x5e1_rspbody = this.faceStateInfo;
        if (oidb_0x5e1_rspbody != null && !oidb_0x5e1_rspbody.rpt_msg_uin_data.isEmpty()) {
            oidb_0x5e1_rspbody.rpt_msg_uin_data.get(0).user_login_guard_face.set(result);
            this.faceStateLiveData.postValue(oidb_0x5e1_rspbody);
        }
    }

    public final void t2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        QLog.i("AccountSecurityVM", 1, "startGetDevLockStatus");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        QRouteApi api = QRoute.api(ISafeApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ISafeApi::class.java)");
        ISafeApi iSafeApi = (ISafeApi) api;
        int checkDevLockStatus = iSafeApi.checkDevLockStatus(peekAppRuntime, currentAccountUin, new e(iSafeApi, peekAppRuntime, currentAccountUin));
        if (checkDevLockStatus != 0) {
            QLog.e("AccountSecurityVM", 1, "checkDevLockStatus error ret:" + checkDevLockStatus);
            this.devlockInfoLiveData.postValue(null);
        }
    }
}

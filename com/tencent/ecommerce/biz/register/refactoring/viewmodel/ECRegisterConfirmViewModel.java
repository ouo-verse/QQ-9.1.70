package com.tencent.ecommerce.biz.register.refactoring.viewmodel;

import android.content.Context;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.ticket.api.IECPSKeyCallback;
import com.tencent.ecommerce.repo.register.ECMsgBox;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import yg0.ECPsKey;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 g2\u00020\u0001:\u0002hiB\u0011\u0012\b\u0010d\u001a\u0004\u0018\u00010c\u00a2\u0006\u0004\be\u0010fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0010R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0010R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u0010R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010%R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b(\u0010%R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b*\u0010\u0010\u001a\u0004\b+\u0010%R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00180\r8\u0006\u00a2\u0006\f\n\u0004\b-\u0010\u0010\u001a\u0004\b.\u0010%R\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b0\u0010\u0010\u001a\u0004\b1\u0010%R\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\u001d0\r8\u0006\u00a2\u0006\f\n\u0004\b3\u0010\u0010\u001a\u0004\b4\u0010%R\u001d\u00108\u001a\b\u0012\u0004\u0012\u00020 0\r8\u0006\u00a2\u0006\f\n\u0004\b6\u0010\u0010\u001a\u0004\b7\u0010%R\"\u0010?\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010C\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010:\u001a\u0004\bA\u0010<\"\u0004\bB\u0010>R\"\u0010G\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010:\u001a\u0004\bE\u0010<\"\u0004\bF\u0010>R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010:\u001a\u0004\bI\u0010<\"\u0004\bJ\u0010>R\"\u0010N\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010:\u001a\u0004\bL\u0010<\"\u0004\bM\u0010>R\"\u0010R\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010:\u001a\u0004\bP\u0010<\"\u0004\bQ\u0010>R\"\u0010V\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010:\u001a\u0004\bT\u0010<\"\u0004\bU\u0010>R\"\u0010Z\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010:\u001a\u0004\bX\u0010<\"\u0004\bY\u0010>R\"\u0010^\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010:\u001a\u0004\b\\\u0010<\"\u0004\b]\u0010>R\"\u0010b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010:\u001a\u0004\b`\u0010<\"\u0004\ba\u0010>\u00a8\u0006j"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/viewmodel/ECRegisterConfirmViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Z1", "o2", "Landroid/content/Context;", "context", "T1", "p2", "r2", "", "smsCode", "q2", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "_realNameVerifyStatus", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "_faceVerifyStatus", BdhLogUtil.LogTag.Tag_Conn, "_registerStatus", "D", "_registerBySessionRespMediaId", "", "E", "_sendSmsCodeStatus", UserInfo.SEX_FEMALE, "_registerBySessionStatus", "Lcom/tencent/ecommerce/biz/register/refactoring/viewmodel/ECRegisterConfirmViewModel$GetPsKeyStatus;", "G", "_getPsKeyStatus", "Lcom/tencent/ecommerce/repo/register/ECMsgBox;", "H", "_registerRespMsgBox", "I", "c2", "()Landroidx/lifecycle/MutableLiveData;", "realNameVerifyStatusLiveData", "J", "U1", "faceVerifyStatusLiveData", "K", "g2", "registerStatusLiveData", "L", SemanticAttributes.DbSystemValues.H2, "sendSmsCodeStatusLiveData", "M", "d2", "registerBySessionStatus", "N", "W1", "getPsKeyStatusLiveData", "P", "e2", "registerRespMsgBoxLiveData", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "k2", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "userName", BdhLogUtil.LogTag.Tag_Req, "j2", "setUserID", "userID", ExifInterface.LATITUDE_SOUTH, "l2", "setUserPhone", "userPhone", "T", "i2", "setSmsCode", "U", ICustomDataEditor.STRING_ARRAY_PARAM_2, "t2", "psKey", "V", "X1", ICustomDataEditor.STRING_PARAM_2, "originPhoneNum", "W", "b2", "u2", "realNameVerifySessionId", "X", "m2", "w2", "verifyFaceRespSessionId", "Y", "f2", "v2", "registerRespSessionId", "Z", ICustomDataEditor.NUMBER_PARAM_2, "setFollowAccount", "isFollowAccount", "Landroid/os/Bundle;", "arguments", "<init>", "(Landroid/os/Bundle;)V", "a0", "a", "GetPsKeyStatus", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECRegisterConfirmViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<Integer> _registerStatus;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<String> _registerBySessionRespMediaId;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _sendSmsCodeStatus;

    /* renamed from: F, reason: from kotlin metadata */
    private final MutableLiveData<Integer> _registerBySessionStatus;

    /* renamed from: G, reason: from kotlin metadata */
    private final MutableLiveData<GetPsKeyStatus> _getPsKeyStatus;

    /* renamed from: H, reason: from kotlin metadata */
    private final MutableLiveData<ECMsgBox> _registerRespMsgBox;

    /* renamed from: I, reason: from kotlin metadata */
    private final MutableLiveData<Integer> realNameVerifyStatusLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    private final MutableLiveData<Integer> faceVerifyStatusLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    private final MutableLiveData<Integer> registerStatusLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> sendSmsCodeStatusLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    private final MutableLiveData<Integer> registerBySessionStatus;

    /* renamed from: N, reason: from kotlin metadata */
    private final MutableLiveData<GetPsKeyStatus> getPsKeyStatusLiveData;

    /* renamed from: P, reason: from kotlin metadata */
    private final MutableLiveData<ECMsgBox> registerRespMsgBoxLiveData;

    /* renamed from: Q, reason: from kotlin metadata */
    private String userName;

    /* renamed from: R, reason: from kotlin metadata */
    private String userID;

    /* renamed from: S, reason: from kotlin metadata */
    private String userPhone;

    /* renamed from: T, reason: from kotlin metadata */
    private String smsCode;

    /* renamed from: U, reason: from kotlin metadata */
    private String psKey;

    /* renamed from: V, reason: from kotlin metadata */
    private String originPhoneNum;

    /* renamed from: W, reason: from kotlin metadata */
    private String realNameVerifySessionId;

    /* renamed from: X, reason: from kotlin metadata */
    private String verifyFaceRespSessionId;

    /* renamed from: Y, reason: from kotlin metadata */
    private String registerRespSessionId;

    /* renamed from: Z, reason: from kotlin metadata */
    private String isFollowAccount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Integer> _realNameVerifyStatus;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Integer> _faceVerifyStatus;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/viewmodel/ECRegisterConfirmViewModel$GetPsKeyStatus;", "", "(Ljava/lang/String;I)V", "SUCCESS", "FAILED", "TIMEOUT", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public enum GetPsKeyStatus {
        SUCCESS,
        FAILED,
        TIMEOUT
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/viewmodel/ECRegisterConfirmViewModel$b", "Lcom/tencent/ecommerce/base/ticket/api/IECPSKeyCallback;", "", "Lyg0/b;", "pSKeys", "", "onSuccess", "", "msg", "onFailed", "onTimeout", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECPSKeyCallback {
        b() {
        }

        @Override // com.tencent.ecommerce.base.ticket.api.IECPSKeyCallback
        public void onFailed(String msg2) {
            ECRegisterConfirmViewModel.this._getPsKeyStatus.setValue(GetPsKeyStatus.FAILED);
            cg0.a.a("ECRegisterConfirmViewModel", "getPSKeyAndBindQQPay", "[getPSKeyAndBindQQPay] getPsKeysAsync onFailed, msg = " + msg2);
        }

        @Override // com.tencent.ecommerce.base.ticket.api.IECPSKeyCallback
        public void onSuccess(List<ECPsKey> pSKeys) {
            Object first;
            ECRegisterConfirmViewModel eCRegisterConfirmViewModel = ECRegisterConfirmViewModel.this;
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) pSKeys);
            String value = ((ECPsKey) first).getValue();
            if (value == null) {
                value = "";
            }
            eCRegisterConfirmViewModel.t2(value);
            ECRegisterConfirmViewModel.this._getPsKeyStatus.setValue(GetPsKeyStatus.SUCCESS);
            cg0.a.b("ECRegisterConfirmViewModel", "[getPSKeyAndBindQQPay] getPsKeysAsync onSuccess, pskKey = " + ECRegisterConfirmViewModel.this.getPsKey());
        }

        @Override // com.tencent.ecommerce.base.ticket.api.IECPSKeyCallback
        public void onTimeout(String msg2) {
            ECRegisterConfirmViewModel.this._getPsKeyStatus.setValue(GetPsKeyStatus.TIMEOUT);
            cg0.a.a("ECRegisterConfirmViewModel", "getPSKeyAndBindQQPay", "[getPSKeyAndBindQQPay] getPsKeysAsync onTimeout, msg = " + msg2);
        }
    }

    public ECRegisterConfirmViewModel(Bundle bundle) {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this._realNameVerifyStatus = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        this._faceVerifyStatus = mutableLiveData2;
        MutableLiveData<Integer> mutableLiveData3 = new MutableLiveData<>();
        this._registerStatus = mutableLiveData3;
        this._registerBySessionRespMediaId = new MutableLiveData<>();
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this._sendSmsCodeStatus = mutableLiveData4;
        MutableLiveData<Integer> mutableLiveData5 = new MutableLiveData<>();
        this._registerBySessionStatus = mutableLiveData5;
        MutableLiveData<GetPsKeyStatus> mutableLiveData6 = new MutableLiveData<>();
        this._getPsKeyStatus = mutableLiveData6;
        MutableLiveData<ECMsgBox> mutableLiveData7 = new MutableLiveData<>();
        this._registerRespMsgBox = mutableLiveData7;
        this.realNameVerifyStatusLiveData = mutableLiveData;
        this.faceVerifyStatusLiveData = mutableLiveData2;
        this.registerStatusLiveData = mutableLiveData3;
        this.sendSmsCodeStatusLiveData = mutableLiveData4;
        this.registerBySessionStatus = mutableLiveData5;
        this.getPsKeyStatusLiveData = mutableLiveData6;
        this.registerRespMsgBoxLiveData = mutableLiveData7;
        this.userName = "";
        this.userID = "";
        this.userPhone = "";
        this.smsCode = "";
        this.psKey = "";
        this.originPhoneNum = "";
        this.realNameVerifySessionId = "";
        this.verifyFaceRespSessionId = "";
        this.registerRespSessionId = "";
        this.isFollowAccount = "0";
        if (bundle != null) {
            this.userName = bundle.getString("userName", "");
            this.userID = bundle.getString("userId", "");
            this.userPhone = bundle.getString("userPhone", "");
            this.smsCode = bundle.getString("userSmsCode", "");
            this.isFollowAccount = bundle.getString("is_follow", "0");
        }
    }

    public final void T1(Context context) {
        if (!(this.realNameVerifySessionId.length() == 0)) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECRegisterConfirmViewModel$faceVerify$1(this, context, null), 3, null);
        } else {
            cg0.a.a("ECRegisterConfirmViewModel", "faceVerify", "[faceVerify] sessionId is null");
        }
    }

    public final MutableLiveData<Integer> U1() {
        return this.faceVerifyStatusLiveData;
    }

    public final MutableLiveData<GetPsKeyStatus> W1() {
        return this.getPsKeyStatusLiveData;
    }

    /* renamed from: X1, reason: from getter */
    public final String getOriginPhoneNum() {
        return this.originPhoneNum;
    }

    public final void Z1() {
        zg0.a.f452502b.b(new String[]{"kandian.qq.com"}, new b());
    }

    /* renamed from: a2, reason: from getter */
    public final String getPsKey() {
        return this.psKey;
    }

    /* renamed from: b2, reason: from getter */
    public final String getRealNameVerifySessionId() {
        return this.realNameVerifySessionId;
    }

    public final MutableLiveData<Integer> c2() {
        return this.realNameVerifyStatusLiveData;
    }

    public final MutableLiveData<Integer> d2() {
        return this.registerBySessionStatus;
    }

    public final MutableLiveData<ECMsgBox> e2() {
        return this.registerRespMsgBoxLiveData;
    }

    /* renamed from: f2, reason: from getter */
    public final String getRegisterRespSessionId() {
        return this.registerRespSessionId;
    }

    public final MutableLiveData<Integer> g2() {
        return this.registerStatusLiveData;
    }

    public final MutableLiveData<Boolean> h2() {
        return this.sendSmsCodeStatusLiveData;
    }

    /* renamed from: i2, reason: from getter */
    public final String getSmsCode() {
        return this.smsCode;
    }

    /* renamed from: j2, reason: from getter */
    public final String getUserID() {
        return this.userID;
    }

    /* renamed from: k2, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* renamed from: l2, reason: from getter */
    public final String getUserPhone() {
        return this.userPhone;
    }

    /* renamed from: m2, reason: from getter */
    public final String getVerifyFaceRespSessionId() {
        return this.verifyFaceRespSessionId;
    }

    /* renamed from: n2, reason: from getter */
    public final String getIsFollowAccount() {
        return this.isFollowAccount;
    }

    public final void o2() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECRegisterConfirmViewModel$realNameVerify$1(this, null), 3, null);
    }

    public final void p2() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECRegisterConfirmViewModel$register$1(this, null), 3, null);
    }

    public final void q2(String smsCode) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECRegisterConfirmViewModel$registerBySessionId$1(this, smsCode, null), 3, null);
    }

    public final void r2() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECRegisterConfirmViewModel$sendSmsCodeBySession$1(this, null), 3, null);
    }

    public final void s2(String str) {
        this.originPhoneNum = str;
    }

    public final void t2(String str) {
        this.psKey = str;
    }

    public final void u2(String str) {
        this.realNameVerifySessionId = str;
    }

    public final void v2(String str) {
        this.registerRespSessionId = str;
    }

    public final void w2(String str) {
        this.verifyFaceRespSessionId = str;
    }
}

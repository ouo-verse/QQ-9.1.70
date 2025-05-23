package com.qwallet.authorize.dialog;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qwallet.authorize.AuthorizePhoneData;
import com.qwallet.localphone.QWalletLocalPhoneModule;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.pb.QWalletAuthorize$AuthConfirmReq;
import com.tencent.mobileqq.qwallet.pb.QWalletAuthorize$AuthConfirmRsp;
import com.tencent.mobileqq.qwallet.pb.QWalletAuthorize$GetAuthPhonePanelReq;
import com.tencent.mobileqq.qwallet.pb.QWalletAuthorize$GetAuthPhonePanelRsp;
import com.tencent.mobileqq.qwallet.pb.QWalletAuthorize$PhoneNo;
import com.tencent.mobileqq.qwallet.pb.QWalletLocalPhone$GetMobileGWPhoneRsp;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.gateway.QWalletGatewayServlet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 R2\u00020\u0001:\u0001SB\u000f\u0012\u0006\u0010O\u001a\u00020N\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004JW\u0010\u0010\u001a\u00020\u00022O\b\u0002\u0010\u000f\u001aI\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006JN\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000726\u0010\u0016\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00020\u0014R#\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00190\u00188\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00188\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001dR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u00188\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u001dR\u001a\u0010+\u001a\u00020&8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u00100\u001a\u00020\r8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001a\u00103\u001a\u00020\r8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b1\u0010-\u001a\u0004\b2\u0010/R\u001a\u00106\u001a\u00020\r8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b4\u0010-\u001a\u0004\b5\u0010/R\"\u0010;\u001a\u00020\r8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010-\u001a\u0004\b8\u0010/\"\u0004\b9\u0010:R\u0014\u0010=\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010<R4\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00192\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00198\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b(\u0010?\"\u0004\b@\u0010AR.\u0010I\u001a\u0004\u0018\u00010\u00112\b\u0010>\u001a\u0004\u0018\u00010\u00118\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR.\u0010M\u001a\u0004\u0018\u00010\u00112\b\u0010>\u001a\u0004\u0018\u00010\u00118\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010D\u001a\u0004\bK\u0010F\"\u0004\bL\u0010H\u00a8\u0006T"}, d2 = {"Lcom/qwallet/authorize/dialog/AuthorizeViewModel;", "Landroidx/lifecycle/ViewModel;", "", "g2", "Lcom/tencent/mobileqq/qcoroutine/api/coroutine/b;", "b2", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "retCode", "", "retMsg", "receiver", "Z1", "Lcom/qwallet/authorize/AuthorizePhoneData;", "phoneData", "agreeSavePhone", "Lkotlin/Function2;", "dataStr", "callback", "X1", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "P1", "()Landroidx/lifecycle/MutableLiveData;", "authorizePhoneList", "Lcom/tencent/mobileqq/qwallet/pb/QWalletAuthorize$GetAuthPhonePanelRsp;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "O1", "authorizePanelData", BdhLogUtil.LogTag.Tag_Conn, "R1", "localPhoneResult", "", "D", "J", "N1", "()J", "appId", "E", "Ljava/lang/String;", "S1", "()Ljava/lang/String;", "openId", UserInfo.SEX_FEMALE, "M1", CommonConstant.KEY_ACCESS_TOKEN, "G", "U1", "sign", "H", "T1", "e2", "(Ljava/lang/String;)V", "sessionId", "I", "isChangeAccount", "value", "Ljava/util/List;", "d2", "(Ljava/util/List;)V", "remotePhoneList", "K", "Lcom/qwallet/authorize/AuthorizePhoneData;", "Q1", "()Lcom/qwallet/authorize/AuthorizePhoneData;", "c2", "(Lcom/qwallet/authorize/AuthorizePhoneData;)V", "localPhoneData", "L", "W1", "f2", "snapPhoneData", "Landroidx/lifecycle/SavedStateHandle;", "stateHandle", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V", "M", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class AuthorizeViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> localPhoneResult;

    /* renamed from: D, reason: from kotlin metadata */
    private final long appId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String openId;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final String accessToken;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final String sign;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String sessionId;

    /* renamed from: I, reason: from kotlin metadata */
    private final int isChangeAccount;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private List<AuthorizePhoneData> remotePhoneList;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private AuthorizePhoneData localPhoneData;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private AuthorizePhoneData snapPhoneData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<AuthorizePhoneData>> authorizePhoneList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<QWalletAuthorize$GetAuthPhonePanelRsp> authorizePanelData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/qwallet/authorize/dialog/AuthorizeViewModel$b", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/QWalletAuthorize$AuthConfirmRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class b implements o<QWalletAuthorize$AuthConfirmRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, String, Unit> f41414a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Boolean, ? super String, Unit> function2) {
            this.f41414a = function2;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull QWalletAuthorize$AuthConfirmRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            String dataStr = rsp.data.get();
            Function2<Boolean, String, Unit> function2 = this.f41414a;
            Boolean bool = Boolean.TRUE;
            Intrinsics.checkNotNullExpressionValue(dataStr, "dataStr");
            function2.invoke(bool, dataStr);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f41414a.invoke(Boolean.FALSE, errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/qwallet/authorize/dialog/AuthorizeViewModel$c", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/QWalletAuthorize$GetAuthPhonePanelRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class c implements o<QWalletAuthorize$GetAuthPhonePanelRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3<Boolean, Integer, String, Unit> f41416b;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function3<? super Boolean, ? super Integer, ? super String, Unit> function3) {
            this.f41416b = function3;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull QWalletAuthorize$GetAuthPhonePanelRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            AuthorizeViewModel.this.O1().postValue(rsp);
            ArrayList arrayList = new ArrayList();
            List<QWalletAuthorize$PhoneNo> list = rsp.phones.get();
            Intrinsics.checkNotNullExpressionValue(list, "rsp.phones.get()");
            for (QWalletAuthorize$PhoneNo qWalletAuthorize$PhoneNo : list) {
                String str = qWalletAuthorize$PhoneNo.mask_no.get();
                Intrinsics.checkNotNullExpressionValue(str, "it.mask_no.get()");
                String str2 = qWalletAuthorize$PhoneNo.f278700no.get();
                Intrinsics.checkNotNullExpressionValue(str2, "it.no.get()");
                String str3 = qWalletAuthorize$PhoneNo.token.get();
                Intrinsics.checkNotNullExpressionValue(str3, "it.token.get()");
                int i3 = qWalletAuthorize$PhoneNo.source.get();
                String str4 = qWalletAuthorize$PhoneNo.source_tag.get();
                Intrinsics.checkNotNullExpressionValue(str4, "it.source_tag.get()");
                arrayList.add(new AuthorizePhoneData(str, str2, str3, i3, str4, qWalletAuthorize$PhoneNo.carrier_type.get(), qWalletAuthorize$PhoneNo.state.get(), true));
            }
            AuthorizeViewModel.this.d2(arrayList);
            Function3<Boolean, Integer, String, Unit> function3 = this.f41416b;
            if (function3 != null) {
                function3.invoke(Boolean.TRUE, 0, "");
            }
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Function3<Boolean, Integer, String, Unit> function3 = this.f41416b;
            if (function3 != null) {
                function3.invoke(Boolean.FALSE, Integer.valueOf(errCode), errMsg);
            }
        }
    }

    public AuthorizeViewModel(@NotNull SavedStateHandle stateHandle) {
        long longValue;
        int intValue;
        Intrinsics.checkNotNullParameter(stateHandle, "stateHandle");
        this.authorizePhoneList = new MutableLiveData<>();
        this.authorizePanelData = new MutableLiveData<>();
        this.localPhoneResult = new MutableLiveData<>();
        Long l3 = (Long) stateHandle.get("extra_key_authorize_appid");
        if (l3 == null) {
            longValue = 0;
        } else {
            longValue = l3.longValue();
        }
        this.appId = longValue;
        String str = (String) stateHandle.get("extra_key_authorize_openid");
        this.openId = str == null ? "" : str;
        String str2 = (String) stateHandle.get("extra_key_authorize_access_token");
        this.accessToken = str2 == null ? "" : str2;
        String str3 = (String) stateHandle.get("extra_key_authorize_sign");
        this.sign = str3 == null ? "" : str3;
        this.sessionId = "";
        Integer num = (Integer) stateHandle.get("extra_key_authorize_change_account");
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        this.isChangeAccount = intValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a2(AuthorizeViewModel authorizeViewModel, Function3 function3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function3 = null;
        }
        authorizeViewModel.Z1(function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2(List<AuthorizePhoneData> list) {
        this.remotePhoneList = list;
        g2();
    }

    private final void g2() {
        Object obj;
        ArrayList arrayList = new ArrayList();
        List<AuthorizePhoneData> list = this.remotePhoneList;
        if (list != null) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, list);
        }
        AuthorizePhoneData authorizePhoneData = this.snapPhoneData;
        if (authorizePhoneData != null) {
            arrayList.add(authorizePhoneData);
        }
        AuthorizePhoneData authorizePhoneData2 = this.localPhoneData;
        if (authorizePhoneData2 != null) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((AuthorizePhoneData) obj).getPhoneMask(), authorizePhoneData2.getPhoneMask())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            AuthorizePhoneData authorizePhoneData3 = (AuthorizePhoneData) obj;
            if (authorizePhoneData3 != null) {
                arrayList.remove(authorizePhoneData3);
                arrayList.add(0, authorizePhoneData3);
            } else {
                arrayList.add(0, authorizePhoneData2);
            }
        }
        this.authorizePhoneList.postValue(arrayList);
    }

    @NotNull
    /* renamed from: M1, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* renamed from: N1, reason: from getter */
    public final long getAppId() {
        return this.appId;
    }

    @NotNull
    public final MutableLiveData<QWalletAuthorize$GetAuthPhonePanelRsp> O1() {
        return this.authorizePanelData;
    }

    @NotNull
    public final MutableLiveData<List<AuthorizePhoneData>> P1() {
        return this.authorizePhoneList;
    }

    @Nullable
    /* renamed from: Q1, reason: from getter */
    public final AuthorizePhoneData getLocalPhoneData() {
        return this.localPhoneData;
    }

    @NotNull
    public final MutableLiveData<Boolean> R1() {
        return this.localPhoneResult;
    }

    @NotNull
    /* renamed from: S1, reason: from getter */
    public final String getOpenId() {
        return this.openId;
    }

    @NotNull
    /* renamed from: T1, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    @NotNull
    /* renamed from: U1, reason: from getter */
    public final String getSign() {
        return this.sign;
    }

    @Nullable
    /* renamed from: W1, reason: from getter */
    public final AuthorizePhoneData getSnapPhoneData() {
        return this.snapPhoneData;
    }

    public final void X1(@NotNull AuthorizePhoneData phoneData, boolean agreeSavePhone, @NotNull Function2<? super Boolean, ? super String, Unit> callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(phoneData, "phoneData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (agreeSavePhone && !phoneData.getHasSavePhone() && phoneData.getSource() == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        QWalletAuthorize$PhoneNo qWalletAuthorize$PhoneNo = new QWalletAuthorize$PhoneNo();
        qWalletAuthorize$PhoneNo.source.set(phoneData.getSource());
        qWalletAuthorize$PhoneNo.source_tag.set(phoneData.getSourceTag());
        qWalletAuthorize$PhoneNo.token.set(phoneData.getToken());
        qWalletAuthorize$PhoneNo.mask_no.set(phoneData.getPhoneMask());
        qWalletAuthorize$PhoneNo.f278700no.set(phoneData.getPhone());
        QWalletAuthorize$AuthConfirmReq qWalletAuthorize$AuthConfirmReq = new QWalletAuthorize$AuthConfirmReq();
        qWalletAuthorize$AuthConfirmReq.appid.set(this.appId);
        qWalletAuthorize$AuthConfirmReq.openid.set(this.openId);
        qWalletAuthorize$AuthConfirmReq.access_token.set(this.accessToken);
        qWalletAuthorize$AuthConfirmReq.phone.set(qWalletAuthorize$PhoneNo);
        qWalletAuthorize$AuthConfirmReq.msg_no.set(this.sessionId);
        qWalletAuthorize$AuthConfirmReq.save_gw_phone.set(z16);
        b bVar = new b(callback);
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        Object newInstance = QWalletAuthorize$AuthConfirmRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.qwallet.phonesdk.PhoneSDK", "AuthConfirm", qWalletAuthorize$AuthConfirmReq, (MessageMicro) newInstance, false, false, false, null, bVar);
    }

    public final void Z1(@Nullable Function3<? super Boolean, ? super Integer, ? super String, Unit> receiver) {
        QWalletAuthorize$GetAuthPhonePanelReq qWalletAuthorize$GetAuthPhonePanelReq = new QWalletAuthorize$GetAuthPhonePanelReq();
        qWalletAuthorize$GetAuthPhonePanelReq.appid.set(this.appId);
        qWalletAuthorize$GetAuthPhonePanelReq.openid.set(this.openId);
        qWalletAuthorize$GetAuthPhonePanelReq.access_token.set(this.accessToken);
        qWalletAuthorize$GetAuthPhonePanelReq.sign.set(this.sign);
        qWalletAuthorize$GetAuthPhonePanelReq.status.set(this.isChangeAccount);
        c cVar = new c(receiver);
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        Object newInstance = QWalletAuthorize$GetAuthPhonePanelRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.qwallet.phonesdk.PhoneSDK", "GetAuthPhonePanel", qWalletAuthorize$GetAuthPhonePanelReq, (MessageMicro) newInstance, false, false, false, null, cVar);
    }

    @Nullable
    public final com.tencent.mobileqq.qcoroutine.api.coroutine.b b2() {
        this.localPhoneResult.postValue(Boolean.FALSE);
        return QWalletLocalPhoneModule.f41592a.i(this.appId, this.sign, "", new Function3<Integer, QWalletLocalPhone$GetMobileGWPhoneRsp, String, Unit>() { // from class: com.qwallet.authorize.dialog.AuthorizeViewModel$requestMobileGatewayURL$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, QWalletLocalPhone$GetMobileGWPhoneRsp qWalletLocalPhone$GetMobileGWPhoneRsp, String str) {
                invoke(num.intValue(), qWalletLocalPhone$GetMobileGWPhoneRsp, str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @Nullable QWalletLocalPhone$GetMobileGWPhoneRsp qWalletLocalPhone$GetMobileGWPhoneRsp, @Nullable String str) {
                AuthorizeViewModel.this.R1().postValue(Boolean.TRUE);
                if (i3 == 0 && qWalletLocalPhone$GetMobileGWPhoneRsp != null) {
                    AuthorizeViewModel authorizeViewModel = AuthorizeViewModel.this;
                    String str2 = qWalletLocalPhone$GetMobileGWPhoneRsp.session_id.get();
                    Intrinsics.checkNotNullExpressionValue(str2, "rsp.session_id.get()");
                    authorizeViewModel.e2(str2);
                    AuthorizeViewModel authorizeViewModel2 = AuthorizeViewModel.this;
                    String str3 = qWalletLocalPhone$GetMobileGWPhoneRsp.mask_phone.mask.get();
                    Intrinsics.checkNotNullExpressionValue(str3, "rsp.mask_phone.mask.get()");
                    String str4 = qWalletLocalPhone$GetMobileGWPhoneRsp.mask_phone.mask.get();
                    Intrinsics.checkNotNullExpressionValue(str4, "rsp.mask_phone.mask.get()");
                    String str5 = qWalletLocalPhone$GetMobileGWPhoneRsp.phone_token.get();
                    Intrinsics.checkNotNullExpressionValue(str5, "rsp.phone_token.get()");
                    authorizeViewModel2.c2(new AuthorizePhoneData(str3, str4, str5, 4, "\u672c\u673a\u53f7\u7801", qWalletLocalPhone$GetMobileGWPhoneRsp.carrier_type.get(), 0, false));
                    return;
                }
                QLog.e("AuthorizeViewModel", 1, "requestMobileGatewayURL error: " + i3 + ", " + str);
            }
        });
    }

    public final void c2(@Nullable AuthorizePhoneData authorizePhoneData) {
        this.localPhoneData = authorizePhoneData;
        g2();
    }

    public final void e2(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }

    public final void f2(@Nullable AuthorizePhoneData authorizePhoneData) {
        this.snapPhoneData = authorizePhoneData;
        g2();
    }
}

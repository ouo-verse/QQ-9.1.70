package com.qwallet.authorize.phone;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qwallet.authorize.AuthorizePhoneData;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.pb.QWalletAuthorize$DelReq;
import com.tencent.mobileqq.qwallet.pb.QWalletAuthorize$DelRsp;
import com.tencent.mobileqq.qwallet.pb.QWalletAuthorize$GetPhonesReq;
import com.tencent.mobileqq.qwallet.pb.QWalletAuthorize$GetPhonesRsp;
import com.tencent.mobileqq.qwallet.pb.QWalletAuthorize$PhoneNo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tenpay.sdk.net.gateway.QWalletGatewayServlet;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 G2\u00020\u0001:\u0001HB\u000f\u0012\u0006\u0010D\u001a\u00020C\u00a2\u0006\u0004\bE\u0010FJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R#\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00188\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010#\u001a\u00020\u001e8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010&\u001a\u00020\u001e8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"R\u001a\u0010)\u001a\u00020\u001e8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010\"RL\u00101\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010*j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`+2\u001a\u0010,\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010*j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`+8\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b-\u0010.\"\u0004\b/\u00100R.\u00108\u001a\u0004\u0018\u00010\u00022\b\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R.\u0010;\u001a\u0004\u0018\u00010\u00022\b\u0010,\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u00103\u001a\u0004\b9\u00105\"\u0004\b:\u00107R\"\u0010B\u001a\u00020<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A\u00a8\u0006I"}, d2 = {"Lcom/qwallet/authorize/phone/j;", "Landroidx/lifecycle/ViewModel;", "Lcom/qwallet/authorize/AuthorizePhoneData;", "authorizePhoneData", "", "X1", "e2", "Z1", "W1", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "R1", "()Landroidx/lifecycle/MutableLiveData;", "authorizePhoneList", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "Q1", "()I", ICustomDataEditor.STRING_ARRAY_PARAM_2, "(I)V", "authorizeMaxPhoneSize", "", BdhLogUtil.LogTag.Tag_Conn, "J", "P1", "()J", "appId", "", "D", "Ljava/lang/String;", "S1", "()Ljava/lang/String;", "openId", "E", "O1", CommonConstant.KEY_ACCESS_TOKEN, UserInfo.SEX_FEMALE, "getSign$qwallet_impl_release", "sign", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "value", "G", "Ljava/util/ArrayList;", "b2", "(Ljava/util/ArrayList;)V", "remotePhoneList", "H", "Lcom/qwallet/authorize/AuthorizePhoneData;", "getLocalPhoneData", "()Lcom/qwallet/authorize/AuthorizePhoneData;", "setLocalPhoneData", "(Lcom/qwallet/authorize/AuthorizePhoneData;)V", "localPhoneData", "T1", "c2", "snapPhoneData", "", "Z", "U1", "()Z", "d2", "(Z)V", "updatePhoneList", "Landroidx/lifecycle/SavedStateHandle;", "stateHandle", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V", "K", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class j extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final long appId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String openId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String accessToken;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final String sign;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ArrayList<AuthorizePhoneData> remotePhoneList;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private AuthorizePhoneData localPhoneData;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private AuthorizePhoneData snapPhoneData;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean updatePhoneList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<AuthorizePhoneData>> authorizePhoneList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int authorizeMaxPhoneSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/qwallet/authorize/phone/j$b", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/QWalletAuthorize$DelRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class b implements o<QWalletAuthorize$DelRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AuthorizePhoneData f41443b;

        b(AuthorizePhoneData authorizePhoneData) {
            this.f41443b = authorizePhoneData;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull QWalletAuthorize$DelRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            QQToast.makeText(MobileQQ.sMobileQQ, 2, "\u5220\u9664\u6210\u529f", 0).show();
            ArrayList arrayList = j.this.remotePhoneList;
            if (arrayList != null) {
                arrayList.remove(this.f41443b);
            }
            j.this.e2();
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.d(QPublicBaseFragment.TAG, 1, "requestDelPhone onFail errCode=" + errCode + " errMsg=" + errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/qwallet/authorize/phone/j$c", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/QWalletAuthorize$GetPhonesRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class c implements o<QWalletAuthorize$GetPhonesRsp> {
        c() {
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull QWalletAuthorize$GetPhonesRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            j.this.a2(rsp.maximum.get());
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
            j.this.b2(arrayList);
            j.this.e2();
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.d(QPublicBaseFragment.TAG, 1, "requestGetPhoneList onFail errCode=" + errCode + " errMsg=" + errMsg);
        }
    }

    public j(@NotNull SavedStateHandle stateHandle) {
        long longValue;
        Intrinsics.checkNotNullParameter(stateHandle, "stateHandle");
        this.authorizePhoneList = new MutableLiveData<>();
        this.authorizeMaxPhoneSize = 3;
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
        this.sign = str3 != null ? str3 : "";
        this.localPhoneData = (AuthorizePhoneData) stateHandle.get("extra_key_local_phone_data");
        this.snapPhoneData = (AuthorizePhoneData) stateHandle.get("extra_key_snap_phone_data");
    }

    private final void X1(AuthorizePhoneData authorizePhoneData) {
        QWalletAuthorize$DelReq qWalletAuthorize$DelReq = new QWalletAuthorize$DelReq();
        qWalletAuthorize$DelReq.appid.set(this.appId);
        qWalletAuthorize$DelReq.openid.set(this.openId);
        qWalletAuthorize$DelReq.access_token.set(this.accessToken);
        qWalletAuthorize$DelReq.token.set(authorizePhoneData.getToken());
        b bVar = new b(authorizePhoneData);
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        Object newInstance = QWalletAuthorize$DelRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.qwallet.phonesdk.PhoneSDK", "DelPhone", qWalletAuthorize$DelReq, (MessageMicro) newInstance, false, false, false, null, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b2(ArrayList<AuthorizePhoneData> arrayList) {
        this.remotePhoneList = arrayList;
        e2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e2() {
        ArrayList arrayList = new ArrayList();
        AuthorizePhoneData authorizePhoneData = this.localPhoneData;
        if (authorizePhoneData != null) {
            arrayList.add(authorizePhoneData);
        }
        ArrayList<AuthorizePhoneData> arrayList2 = this.remotePhoneList;
        if (arrayList2 != null) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, arrayList2);
        }
        AuthorizePhoneData authorizePhoneData2 = this.snapPhoneData;
        if (authorizePhoneData2 != null) {
            arrayList.add(authorizePhoneData2);
        }
        this.authorizePhoneList.postValue(arrayList);
    }

    @NotNull
    /* renamed from: O1, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    /* renamed from: P1, reason: from getter */
    public final long getAppId() {
        return this.appId;
    }

    /* renamed from: Q1, reason: from getter */
    public final int getAuthorizeMaxPhoneSize() {
        return this.authorizeMaxPhoneSize;
    }

    @NotNull
    public final MutableLiveData<List<AuthorizePhoneData>> R1() {
        return this.authorizePhoneList;
    }

    @NotNull
    /* renamed from: S1, reason: from getter */
    public final String getOpenId() {
        return this.openId;
    }

    @Nullable
    /* renamed from: T1, reason: from getter */
    public final AuthorizePhoneData getSnapPhoneData() {
        return this.snapPhoneData;
    }

    /* renamed from: U1, reason: from getter */
    public final boolean getUpdatePhoneList() {
        return this.updatePhoneList;
    }

    public final void W1(@NotNull AuthorizePhoneData authorizePhoneData) {
        Intrinsics.checkNotNullParameter(authorizePhoneData, "authorizePhoneData");
        if (authorizePhoneData.getSource() == 1) {
            c2(null);
            QQToast.makeText(MobileQQ.sMobileQQ, 2, "\u5220\u9664\u6210\u529f", 0).show();
            e2();
            return;
        }
        X1(authorizePhoneData);
    }

    public final void Z1() {
        QWalletAuthorize$GetPhonesReq qWalletAuthorize$GetPhonesReq = new QWalletAuthorize$GetPhonesReq();
        qWalletAuthorize$GetPhonesReq.appid.set(this.appId);
        qWalletAuthorize$GetPhonesReq.openid.set(this.openId);
        qWalletAuthorize$GetPhonesReq.access_token.set(this.accessToken);
        qWalletAuthorize$GetPhonesReq.sign.set(this.sign);
        c cVar = new c();
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        Object newInstance = QWalletAuthorize$GetPhonesRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.qwallet.phonesdk.PhoneSDK", "GetPhones", qWalletAuthorize$GetPhonesReq, (MessageMicro) newInstance, false, false, false, null, cVar);
    }

    public final void a2(int i3) {
        this.authorizeMaxPhoneSize = i3;
    }

    public final void c2(@Nullable AuthorizePhoneData authorizePhoneData) {
        this.snapPhoneData = authorizePhoneData;
        e2();
    }

    public final void d2(boolean z16) {
        this.updatePhoneList = z16;
    }
}

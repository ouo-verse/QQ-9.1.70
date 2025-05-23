package com.qwallet.student;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.pb.StudentPB$ConfirmAuthReq;
import com.tencent.mobileqq.qwallet.pb.StudentPB$ConfirmAuthRsp;
import com.tencent.mobileqq.qwallet.pb.StudentPB$GetAuthPanelReq;
import com.tencent.mobileqq.qwallet.pb.StudentPB$GetAuthPanelRsp;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.gateway.QWalletGatewayServlet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-JW\u0010\r\u001a\u00020\u000b2O\b\u0002\u0010\f\u001aI\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0002J>\u0010\u0010\u001a\u00020\u000b26\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u000b0\u000eR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\u00020\t8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\t8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u0014\u0010!\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u0019R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u0019R\u0014\u0010)\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010\u0019\u00a8\u00060"}, d2 = {"Lcom/qwallet/student/n;", "Landroidx/lifecycle/ViewModel;", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "retCode", "", "retMsg", "", "receiver", "N1", "Lkotlin/Function2;", "dataStr", "M1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/qwallet/pb/StudentPB$GetAuthPanelRsp;", "i", "Landroidx/lifecycle/MutableLiveData;", "L1", "()Landroidx/lifecycle/MutableLiveData;", "studentPanelData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "getAppid$qwallet_impl_release", "()Ljava/lang/String;", "appid", BdhLogUtil.LogTag.Tag_Conn, "getOpenid$qwallet_impl_release", "openid", "D", CommonConstant.KEY_ACCESS_TOKEN, "", "E", "J", "timestamp", UserInfo.SEX_FEMALE, "sign", "G", WadlProxyConsts.CHANNEL, "Landroidx/lifecycle/SavedStateHandle;", "stateHandle", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V", "H", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class n extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String openid;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String accessToken;

    /* renamed from: E, reason: from kotlin metadata */
    private final long timestamp;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final String sign;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final String channel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<StudentPB$GetAuthPanelRsp> studentPanelData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appid;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/qwallet/student/n$b", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/StudentPB$ConfirmAuthRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class b implements o<StudentPB$ConfirmAuthRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, String, Unit> f41747a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Boolean, ? super String, Unit> function2) {
            this.f41747a = function2;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull StudentPB$ConfirmAuthRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            String dataStr = rsp.result.get();
            Function2<Boolean, String, Unit> function2 = this.f41747a;
            Boolean bool = Boolean.TRUE;
            Intrinsics.checkNotNullExpressionValue(dataStr, "dataStr");
            function2.invoke(bool, dataStr);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.f41747a.invoke(Boolean.FALSE, errMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/qwallet/student/n$c", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/StudentPB$GetAuthPanelRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class c implements o<StudentPB$GetAuthPanelRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function3<Boolean, Integer, String, Unit> f41749b;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function3<? super Boolean, ? super Integer, ? super String, Unit> function3) {
            this.f41749b = function3;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull StudentPB$GetAuthPanelRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            QLog.d("StudentViewModel", 1, "requestGetAppInfo onSuccess");
            n.this.L1().postValue(rsp);
            Function3<Boolean, Integer, String, Unit> function3 = this.f41749b;
            if (function3 != null) {
                function3.invoke(Boolean.TRUE, 0, "");
            }
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.d("StudentViewModel", 1, "requestGetAppInfo onFail");
            Function3<Boolean, Integer, String, Unit> function3 = this.f41749b;
            if (function3 != null) {
                function3.invoke(Boolean.FALSE, Integer.valueOf(errCode), errMsg);
            }
        }
    }

    public n(@NotNull SavedStateHandle stateHandle) {
        long longValue;
        Intrinsics.checkNotNullParameter(stateHandle, "stateHandle");
        this.studentPanelData = new MutableLiveData<>();
        String str = (String) stateHandle.get("extra_key_student_appid");
        this.appid = str == null ? "" : str;
        String str2 = (String) stateHandle.get("extra_key_student_openid");
        this.openid = str2 == null ? "" : str2;
        String str3 = (String) stateHandle.get("extra_key_student_access_token");
        this.accessToken = str3 == null ? "" : str3;
        Long l3 = (Long) stateHandle.get("extra_key_student_timestamp");
        if (l3 == null) {
            longValue = 0;
        } else {
            longValue = l3.longValue();
        }
        this.timestamp = longValue;
        String str4 = (String) stateHandle.get("extra_key_student_sign");
        this.sign = str4 == null ? "" : str4;
        String str5 = (String) stateHandle.get("extra_key_student_channel");
        this.channel = str5 != null ? str5 : "";
    }

    @NotNull
    public final MutableLiveData<StudentPB$GetAuthPanelRsp> L1() {
        return this.studentPanelData;
    }

    public final void M1(@NotNull Function2<? super Boolean, ? super String, Unit> receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        StudentPB$ConfirmAuthReq studentPB$ConfirmAuthReq = new StudentPB$ConfirmAuthReq();
        studentPB$ConfirmAuthReq.appid.set(this.appid);
        studentPB$ConfirmAuthReq.openid.set(this.openid);
        studentPB$ConfirmAuthReq.access_token.set(this.accessToken);
        studentPB$ConfirmAuthReq.timestamp.set(this.timestamp);
        studentPB$ConfirmAuthReq.sign.set(this.sign);
        studentPB$ConfirmAuthReq.channel.set(this.channel);
        b bVar = new b(receiver);
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        Object newInstance = StudentPB$ConfirmAuthRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.campus.verification.Student", "ConfirmAuth", studentPB$ConfirmAuthReq, (MessageMicro) newInstance, false, false, false, null, bVar);
    }

    public final void N1(@Nullable Function3<? super Boolean, ? super Integer, ? super String, Unit> receiver) {
        StudentPB$GetAuthPanelReq studentPB$GetAuthPanelReq = new StudentPB$GetAuthPanelReq();
        studentPB$GetAuthPanelReq.appid.set(this.appid);
        studentPB$GetAuthPanelReq.openid.set(this.openid);
        studentPB$GetAuthPanelReq.access_token.set(this.accessToken);
        studentPB$GetAuthPanelReq.timestamp.set(this.timestamp);
        studentPB$GetAuthPanelReq.sign.set(this.sign);
        studentPB$GetAuthPanelReq.channel.set(this.channel);
        c cVar = new c(receiver);
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        Object newInstance = StudentPB$GetAuthPanelRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.campus.verification.Student", "GetAuthPanel", studentPB$GetAuthPanelReq, (MessageMicro) newInstance, false, true, false, null, cVar);
    }
}

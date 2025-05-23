package com.tenpay.idverify.utils;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.qwallet.protocol.Wallet.hb.ElementPB$Addr;
import com.qwallet.protocol.Wallet.hb.ElementPB$CheckAddressReq;
import com.qwallet.protocol.Wallet.hb.ElementPB$CheckAddressRsp;
import com.qwallet.protocol.Wallet.hb.ElementPB$CreDate;
import com.qwallet.protocol.Wallet.hb.ElementPB$PreCheckRegElementReq;
import com.qwallet.protocol.Wallet.hb.ElementPB$PreCheckRegElementRsp;
import com.qwallet.protocol.Wallet.hb.ElementPB$RegElement;
import com.qwallet.temp.IPayShareMsgTempApi;
import com.tencent.mobileqq.base.a;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.proxy.dlg.age.AgeSelDlg;
import com.tenpay.sdk.net.core.encrypt.EcdhEncryptResult;
import com.tenpay.sdk.net.core.encrypt.PayEncryptUtils;
import com.tenpay.sdk.net.gateway.QWalletGatewayServlet;
import com.tenpay.util.Utils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JB\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u0010J\u009e\u0001\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000626\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u001b\u0012\b\b\u0013\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u001b\u0012\b\b\u0013\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\b0\u001aJ(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J2\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/tenpay/idverify/utils/IdVerifyUtils;", "", "()V", "ERROR_CHECK_FORM_SEX_INVALID", "", "TAG", "", "checkAddress", "", "fragment", "Landroidx/fragment/app/Fragment;", "province", "city", TtmlNode.TAG_REGION, "address", "receiver", "Lkotlin/Function1;", "", "checkForm", "name", "creId", "creBegin", "validDate", "creType", "job", "sexType", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "isSuccess", "errCode", "createAddress", "Lcom/qwallet/protocol/Wallet/hb/ElementPB$Addr;", "createCreDate", "Lcom/qwallet/protocol/Wallet/hb/ElementPB$CreDate;", "forwardMsgToFriend", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "requestCode", "forwardType", "forwardTitle", "forwardDialogText", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class IdVerifyUtils {
    public static final int ERROR_CHECK_FORM_SEX_INVALID = 130213;

    @NotNull
    public static final IdVerifyUtils INSTANCE = new IdVerifyUtils();

    @NotNull
    private static final String TAG = "IdVerifyUtils";

    IdVerifyUtils() {
    }

    private final ElementPB$Addr createAddress(String province, String city, String region, String address) {
        ElementPB$Addr elementPB$Addr = new ElementPB$Addr();
        elementPB$Addr.province.set(province);
        elementPB$Addr.city.set(city);
        elementPB$Addr.region.set(region);
        elementPB$Addr.address.set(address);
        return elementPB$Addr;
    }

    private final ElementPB$CreDate createCreDate(String creBegin, String validDate) {
        if (Intrinsics.areEqual(AgeSelDlg.LONG_YEAR_TXT, validDate)) {
            validDate = Utils.formatDate(9999, 12, 31);
        }
        ElementPB$CreDate elementPB$CreDate = new ElementPB$CreDate();
        elementPB$CreDate.begin.set(creBegin);
        elementPB$CreDate.expire.set(validDate);
        return elementPB$CreDate;
    }

    @JvmStatic
    public static final void forwardMsgToFriend(@Nullable Activity activity, int requestCode, int forwardType, @NotNull String forwardTitle, @NotNull String forwardDialogText) {
        Intrinsics.checkNotNullParameter(forwardTitle, "forwardTitle");
        Intrinsics.checkNotNullParameter(forwardDialogText, "forwardDialogText");
        if (activity == null) {
            return;
        }
        QRouteApi api = QRoute.api(IPayShareMsgTempApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IPayShareMsgTempApi::class.java)");
        ((IPayShareMsgTempApi) api).forwardMsgToQQ(activity, requestCode, forwardType, forwardTitle, forwardDialogText);
    }

    public final void checkAddress(@NotNull final Fragment fragment, @NotNull String province, @NotNull String city, @NotNull String region, @NotNull String address, @NotNull final Function1<? super Boolean, Unit> receiver) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(province, "province");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(region, "region");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        ElementPB$CheckAddressReq elementPB$CheckAddressReq = new ElementPB$CheckAddressReq();
        elementPB$CheckAddressReq.addr.set(createAddress(province, city, region, address));
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        h<ElementPB$CheckAddressRsp> hVar = new h<ElementPB$CheckAddressRsp>(fragment) { // from class: com.tenpay.idverify.utils.IdVerifyUtils$checkAddress$1
            @Override // pl2.k
            public void onFail(int errCode, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QLog.i("IdVerifyUtils", 1, "checkAddress onFail: " + errMsg);
                receiver.invoke(Boolean.FALSE);
            }

            @Override // pl2.k
            public void onSuccess(@NotNull ElementPB$CheckAddressRsp rsp) {
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                receiver.invoke(Boolean.TRUE);
            }
        };
        Object newInstance = ElementPB$CheckAddressRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.qwallet.regbind.Element", "CheckAddress", elementPB$CheckAddressReq, (MessageMicro) newInstance, true, false, false, null, hVar);
    }

    public final void checkForm(@NotNull final Fragment fragment, @NotNull String name, @NotNull String creId, @NotNull String creBegin, @NotNull String validDate, int creType, @NotNull String job, int sexType, @NotNull String province, @NotNull String city, @NotNull String region, @NotNull String address, @NotNull final Function2<? super Boolean, ? super Integer, Unit> receiver) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(creId, "creId");
        Intrinsics.checkNotNullParameter(creBegin, "creBegin");
        Intrinsics.checkNotNullParameter(validDate, "validDate");
        Intrinsics.checkNotNullParameter(job, "job");
        Intrinsics.checkNotNullParameter(province, "province");
        Intrinsics.checkNotNullParameter(city, "city");
        Intrinsics.checkNotNullParameter(region, "region");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        PayEncryptUtils payEncryptUtils = PayEncryptUtils.INSTANCE;
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "sMobileQQ.applicationContext");
        EcdhEncryptResult ecdhEncrypt = payEncryptUtils.ecdhEncrypt(applicationContext, creId, a.c());
        TransInfoInput transInfoInput = new TransInfoInput("ecdh", ecdhEncrypt.getEcdhTag(), ecdhEncrypt.getMsgNo(), ecdhEncrypt.getPublicKey());
        ElementPB$RegElement elementPB$RegElement = new ElementPB$RegElement();
        elementPB$RegElement.name.set(name);
        elementPB$RegElement.cre_id.set(ecdhEncrypt.getEncryptContent());
        ElementPB$CreDate elementPB$CreDate = elementPB$RegElement.cre_date;
        IdVerifyUtils idVerifyUtils = INSTANCE;
        elementPB$CreDate.set(idVerifyUtils.createCreDate(creBegin, validDate));
        elementPB$RegElement.cre_type.set(creType);
        elementPB$RegElement.job.set(job);
        elementPB$RegElement.sex.set(sexType);
        elementPB$RegElement.addr.set(idVerifyUtils.createAddress(province, city, region, address));
        elementPB$RegElement.trans.set(transInfoInput.toMutableList());
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        ElementPB$PreCheckRegElementReq elementPB$PreCheckRegElementReq = new ElementPB$PreCheckRegElementReq();
        elementPB$PreCheckRegElementReq.element.set(elementPB$RegElement);
        h<ElementPB$PreCheckRegElementRsp> hVar = new h<ElementPB$PreCheckRegElementRsp>(fragment) { // from class: com.tenpay.idverify.utils.IdVerifyUtils$checkForm$2
            @Override // pl2.k
            public void onFail(int errCode, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QLog.i("IdVerifyUtils", 1, "checkForm onFail: " + errMsg);
                receiver.invoke(Boolean.FALSE, Integer.valueOf(errCode));
            }

            @Override // pl2.k
            public void onSuccess(@NotNull ElementPB$PreCheckRegElementRsp rsp) {
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                receiver.invoke(Boolean.TRUE, 0);
            }
        };
        Object newInstance = ElementPB$PreCheckRegElementRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.qwallet.regbind.Element", "PreCheckRegElement", elementPB$PreCheckRegElementReq, (MessageMicro) newInstance, true, false, false, null, hVar);
    }
}

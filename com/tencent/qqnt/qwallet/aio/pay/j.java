package com.tencent.qqnt.qwallet.aio.pay;

import android.content.Intent;
import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import com.tencent.ark.ark;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.openpay.constants.OpenConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqnt.kernel.nativeinterface.WalletAio;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\bH\u0014J\b\u0010\u000e\u001a\u00020\nH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0004R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R@\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/pay/j;", "Lcom/tencent/qqnt/qwallet/aio/c;", "Lkotlin/Pair;", "", "Landroid/content/Intent;", "W1", "walletUrl", "X1", "", "O1", "Lcom/tencent/qqnt/qwallet/aio/pay/g;", "rawData", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Z1", "Q1", "Lcom/tencent/qqnt/kernel/nativeinterface/WalletAio;", "T1", "", "U1", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "S1", "()Landroidx/lifecycle/MutableLiveData;", "paymentData", "<set-?>", "D", "Lkotlin/Pair;", "R1", "()Lkotlin/Pair;", "jumpInfo", "<init>", "()V", "E", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class j extends com.tencent.qqnt.qwallet.aio.c {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<PaymentData> paymentData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Pair<String, ? extends Intent> jumpInfo;

    private final Pair<String, Intent> W1() {
        List<String> split$default;
        boolean z16;
        boolean z17;
        boolean z18;
        String str = M1().getReceiver().actionsPriority;
        Intrinsics.checkNotNullExpressionValue(str, "aioModel.receiver.actionsPriority");
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new char[]{QbAddrData.DATA_SPLITER}, false, 0, 6, (Object) null);
        for (String str2 : split$default) {
            if (Intrinsics.areEqual("3", str2)) {
                String str3 = M1().getReceiver().nativeAndroid;
                Intrinsics.checkNotNullExpressionValue(str3, "aioModel.receiver.nativeAndroid");
                if (str3.length() > 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    String str4 = M1().getReceiver().nativeAndroid;
                    Intrinsics.checkNotNullExpressionValue(str4, "aioModel.receiver.nativeAndroid");
                    Intent X1 = X1(str4);
                    if (X1 != null) {
                        return new Pair<>(RouterConstants.UI_ROUTER_PAY_BRIDGE, X1);
                    }
                }
            }
            if (Intrinsics.areEqual("2", str2)) {
                String str5 = M1().getReceiver().jumpUrl;
                Intrinsics.checkNotNullExpressionValue(str5, "aioModel.receiver.jumpUrl");
                if (str5.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    Intent intent = new Intent();
                    intent.setData(Uri.parse(M1().getReceiver().jumpUrl));
                    return new Pair<>(RouterConstants.UI_ROUTER_JUMP, intent);
                }
            }
            String str6 = M1().getReceiver().linkUrl;
            Intrinsics.checkNotNullExpressionValue(str6, "aioModel.receiver.linkUrl");
            if (str6.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Intent intent2 = new Intent();
                intent2.putExtra("url", M1().getReceiver().linkUrl);
                return new Pair<>(RouterConstants.UI_ROUTE_BROWSER, intent2);
            }
        }
        return null;
    }

    private final Intent X1(String walletUrl) {
        boolean z16;
        boolean z17;
        Uri parse = Uri.parse(walletUrl);
        String path = parse.getPath();
        boolean z18 = true;
        if (path != null) {
            int hashCode = path.hashCode();
            if (hashCode != 110760) {
                if (hashCode == 110891 && path.equals("pfa")) {
                    String queryParameter = parse.getQueryParameter("data");
                    String queryParameter2 = parse.getQueryParameter("tokenid");
                    if (queryParameter != null && queryParameter.length() != 0) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (!z17) {
                        if (queryParameter2 != null && queryParameter2.length() != 0) {
                            z18 = false;
                        }
                        if (!z18) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("pfa_req", walletUrl);
                            jSONObject.put("token_id", queryParameter2);
                            String jSONObject2 = jSONObject.toString();
                            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026             }.toString()");
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("userId", com.tencent.mobileqq.base.a.c());
                            jSONObject3.put(HippyHeaderListViewController.VIEW_TAG, "payByFriendConfirm");
                            jSONObject3.put("appInfo", "appid#1344242394|bargainor_id#1000030201|channel#paymsg");
                            jSONObject3.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, 2);
                            jSONObject3.put("extra_data", jSONObject2);
                            String jSONObject4 = jSONObject3.toString();
                            Intrinsics.checkNotNullExpressionValue(jSONObject4, "JSONObject().apply {\n   \u2026             }.toString()");
                            Intent intent = new Intent();
                            intent.putExtra(ark.ARKMETADATA_JSON, jSONObject4);
                            intent.putExtra("callbackSn", "0");
                            intent.putExtra("pay_requestcode", 5);
                            return intent;
                        }
                    }
                    return null;
                }
            } else if (path.equals(OpenConstants.ApiName.PAY)) {
                String queryParameter3 = parse.getQueryParameter("payData");
                String queryParameter4 = parse.getQueryParameter("reqCode");
                if (queryParameter3 != null && queryParameter3.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    if (queryParameter4 != null && queryParameter4.length() != 0) {
                        z18 = false;
                    }
                    if (!z18) {
                        Intent intent2 = new Intent();
                        intent2.putExtra(ark.ARKMETADATA_JSON, queryParameter3);
                        intent2.putExtra("callbackSn", "0");
                        intent2.putExtra("pay_requestcode", Integer.parseInt(queryParameter4));
                        return intent2;
                    }
                }
                return null;
            }
        }
        WalletAio receiver = M1().getReceiver();
        String str = "actionPriorities " + receiver.actionsPriority + ", linkUrl " + receiver.linkUrl + ", jumpUrl " + receiver.jumpUrl + ", nativeAndroid " + receiver.nativeAndroid;
        QLog.w(getTAG(), 1, "parseQWalletSchema: invalid jumpInfo " + str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.c
    public void O1() {
        super.O1();
        this.jumpInfo = W1();
        a2(Q1());
        Z1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public PaymentData Q1() {
        WalletAio T1 = T1();
        String str = T1.title;
        Intrinsics.checkNotNullExpressionValue(str, "it.title");
        String str2 = T1.subTitle;
        Intrinsics.checkNotNullExpressionValue(str2, "it.subTitle");
        String str3 = T1.content;
        Intrinsics.checkNotNullExpressionValue(str3, "it.content");
        return new PaymentData(str, str2, str3, false);
    }

    @Nullable
    public final Pair<String, Intent> R1() {
        return this.jumpInfo;
    }

    @NotNull
    public final MutableLiveData<PaymentData> S1() {
        return this.paymentData;
    }

    @NotNull
    protected WalletAio T1() {
        if (!M1().b()) {
            return M1().getReceiver();
        }
        return M1().getSender();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean U1() {
        return Intrinsics.areEqual(M1().d(), com.tencent.mobileqq.base.a.c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a2(@NotNull PaymentData rawData) {
        Intrinsics.checkNotNullParameter(rawData, "rawData");
        this.paymentData.postValue(rawData);
    }

    protected void Z1() {
    }
}

package com.tenpay.marketservice;

import android.os.Bundle;
import com.qwallet.protocol.Wallet.pb.UserSwitchSrv$OpItem;
import com.qwallet.protocol.Wallet.pb.UserSwitchSrv$SsoSetSwitchReq;
import com.qwallet.protocol.Wallet.pb.UserSwitchSrv$SsoSetSwitchRsp;
import com.tencent.mobileqq.base.a;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import pl2.o;
import pl2.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/tenpay/marketservice/MarketServiceUtils;", "", "()V", "TAG", "", "getMarketServiceKey", "sendMarketServiceSwitch", "", "setMarketServiceSwitch", "isSwitchOn", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class MarketServiceUtils {

    @NotNull
    public static final MarketServiceUtils INSTANCE = new MarketServiceUtils();

    @NotNull
    private static final String TAG = "MarketServiceUtils";

    MarketServiceUtils() {
    }

    @JvmStatic
    public static final void sendMarketServiceSwitch() {
        List<UserSwitchSrv$OpItem> listOf;
        MarketServiceUtils marketServiceUtils = INSTANCE;
        if (!g.a(marketServiceUtils.getMarketServiceKey())) {
            QLog.w(TAG, 1, "ignored sendMarketServiceSwitch, local cache is null");
            return;
        }
        boolean b16 = g.b(marketServiceUtils.getMarketServiceKey());
        UserSwitchSrv$SsoSetSwitchReq userSwitchSrv$SsoSetSwitchReq = new UserSwitchSrv$SsoSetSwitchReq();
        UserSwitchSrv$OpItem userSwitchSrv$OpItem = new UserSwitchSrv$OpItem();
        int i3 = 2;
        userSwitchSrv$OpItem.f41702sw.set(2);
        PBEnumField pBEnumField = userSwitchSrv$OpItem.f41701op;
        if (b16) {
            i3 = 1;
        }
        pBEnumField.set(i3);
        PBRepeatMessageField<UserSwitchSrv$OpItem> pBRepeatMessageField = userSwitchSrv$SsoSetSwitchReq.items;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(userSwitchSrv$OpItem);
        pBRepeatMessageField.set(listOf);
        final o<UserSwitchSrv$SsoSetSwitchRsp> oVar = new o<UserSwitchSrv$SsoSetSwitchRsp>() { // from class: com.tenpay.marketservice.MarketServiceUtils$sendMarketServiceSwitch$callback$1
            @Override // pl2.k
            public void onFail(int errCode, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QLog.w("MarketServiceUtils", 1, "SsoSetSwitch onFail: errMsg " + errMsg);
            }

            @Override // pl2.k
            public void onSuccess(@NotNull UserSwitchSrv$SsoSetSwitchRsp rsp) {
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                QLog.d("MarketServiceUtils", 1, "SsoSetSwitch onSuccess");
            }
        };
        p.Companion companion = p.INSTANCE;
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=trpc.qpay.user_switch_srv.UserSwitch.SsoSetSwitch callback: " + oVar + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), p.class);
        newIntent.putExtra("cmd", "trpc.qpay.user_switch_srv.UserSwitch.SsoSetSwitch");
        newIntent.putExtra("data", fh.b(userSwitchSrv$SsoSetSwitchReq.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new BusinessObserver() { // from class: com.tenpay.marketservice.MarketServiceUtils$sendMarketServiceSwitch$$inlined$sendRequest$default$1
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i16, boolean z16, Bundle bundle) {
                int i17;
                String str;
                if (bundle != null) {
                    i17 = bundle.getInt("rsp_code");
                } else {
                    i17 = 1001;
                }
                if (bundle != null) {
                    str = bundle.getString("rsp_msg");
                } else {
                    str = null;
                }
                if (z16) {
                    try {
                        MessageMicro rsp = ((MessageMicro) UserSwitchSrv$SsoSetSwitchRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                        o oVar2 = o.this;
                        if (oVar2 != null) {
                            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                            oVar2.onSuccess((o) rsp);
                            return;
                        }
                        return;
                    } catch (Exception unused) {
                        QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + UserSwitchSrv$SsoSetSwitchRsp.class + " failed.");
                        o oVar3 = o.this;
                        if (oVar3 != null) {
                            oVar3.onFail(i17, p.INSTANCE.a());
                            return;
                        }
                        return;
                    }
                }
                o oVar4 = o.this;
                if (oVar4 != null) {
                    if (str == null) {
                        str = "empty bundle";
                    }
                    oVar4.onFail(i17, str);
                }
            }
        });
        waitAppRuntime.startServlet(newIntent);
    }

    @NotNull
    public final String getMarketServiceKey() {
        return "qwallet_market_service_switch_" + a.c();
    }

    public final void setMarketServiceSwitch(boolean isSwitchOn) {
        QLog.i(TAG, 1, "setMarketServiceSwitch " + isSwitchOn);
        g.l(getMarketServiceKey(), isSwitchOn);
    }
}

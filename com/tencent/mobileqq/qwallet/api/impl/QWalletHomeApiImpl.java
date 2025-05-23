package com.tencent.mobileqq.qwallet.api.impl;

import android.content.Intent;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$VirtualEntity;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletHomeApi;
import com.tencent.mobileqq.qwallet.api.IQWalletKuiklyApi;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.home.HomeLegacyBizManager;
import com.tencent.mobileqq.qwallet.home.QWalletHomeAdvIPCModule;
import com.tencent.mobileqq.qwallet.home.pop.QWalletHomeKuiklyPopFragment;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.ipc.QWalletRedTouchInfo;
import dl2.QWalletCommonPopConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/api/impl/QWalletHomeApiImpl;", "Lcom/tencent/mobileqq/qwallet/api/IQWalletHomeApi;", "", "getH5RedPointsAsJson", "h5Extra", "", "onH5RedPointClick", "url", "onH5TechReport", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "getAdvIPCModule", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfo", "checkRedPointResReady", "<init>", "()V", "Companion", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletHomeApiImpl implements IQWalletHomeApi {

    @NotNull
    private static final String TAG = "QWalletHomeApiImpl";

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletHomeApi
    public void checkRedPointResReady(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo) {
        boolean z16;
        if (!QWalletHomeKuiklyPopFragment.INSTANCE.a(appInfo)) {
            return;
        }
        List<String> b16 = ((QWalletCommonPopConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_COMMON_POP_WINDOW_CONFIG, QWalletCommonPopConfig.INSTANCE.a())).b();
        List<String> list = b16;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w(TAG, 1, "no need preload");
            return;
        }
        QLog.i(TAG, 1, "start check bundle loaded: " + b16);
        for (final String str : b16) {
            ((IQWalletKuiklyApi) QRoute.api(IQWalletKuiklyApi.class)).preloadKuiklyBundle(str, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.qwallet.api.impl.QWalletHomeApiImpl$checkRedPointResReady$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2) {
                    invoke(num.intValue(), str2);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @NotNull String msg2) {
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    QLog.i("QWalletHomeApiImpl", 2, "preload finish: " + str + " " + i3 + " " + msg2);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletHomeApi
    @NotNull
    public QIPCModule getAdvIPCModule() {
        return QWalletHomeAdvIPCModule.f277953d;
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletHomeApi
    @NotNull
    public String getH5RedPointsAsJson() {
        List<QWalletHomePage$VirtualEntity> value;
        Object obj;
        JSONObject jSONObject = new JSONObject();
        List<QWalletRedTouchInfo> value2 = HomeLegacyBizManager.f277929d.o().getValue();
        if (value2 != null) {
            Iterator<T> it = value2.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((QWalletRedTouchInfo) obj).isForH5()) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            QWalletRedTouchInfo qWalletRedTouchInfo = (QWalletRedTouchInfo) obj;
            if (qWalletRedTouchInfo != null) {
                String valueOf = String.valueOf(qWalletRedTouchInfo.appId);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("isSystemRedPoint", true);
                Unit unit = Unit.INSTANCE;
                jSONObject.put(valueOf, jSONObject2);
            }
        }
        if (!HomeLegacyBizManager.p("100007.102300") && (value = HomeLegacyBizManager.f277929d.h().getValue()) != null) {
            for (QWalletHomePage$VirtualEntity qWalletHomePage$VirtualEntity : value) {
                String valueOf2 = String.valueOf(qWalletHomePage$VirtualEntity.f41700id.get());
                JSONObject optJSONObject = jSONObject.optJSONObject(valueOf2);
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                } else {
                    Intrinsics.checkNotNullExpressionValue(optJSONObject, "resultObj.optJSONObject(key) ?: JSONObject()");
                }
                optJSONObject.put("hasRedPoint", c4.a.d(qWalletHomePage$VirtualEntity));
                optJSONObject.put("hasMarket", c4.a.b(qWalletHomePage$VirtualEntity));
                optJSONObject.put("marketType", qWalletHomePage$VirtualEntity.market.type.get());
                optJSONObject.put("marketText", qWalletHomePage$VirtualEntity.market.name.get());
                if (!optJSONObject.has("isSystemRedPoint")) {
                    optJSONObject.put("isSystemRedPoint", false);
                }
                Unit unit2 = Unit.INSTANCE;
                jSONObject.put(valueOf2, optJSONObject);
            }
        }
        QLog.d(TAG, 1, "getH5RedPointsAsJson: result " + jSONObject);
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "resultObj.toString()");
        return jSONObject3;
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletHomeApi
    public void onH5RedPointClick(@NotNull String h5Extra) {
        boolean z16;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(h5Extra, "h5Extra");
        QLog.d(TAG, 1, "onH5RedPointClick: h5 extra " + h5Extra);
        if (h5Extra.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(h5Extra);
            int optInt = jSONObject.optInt("virtualEntityId");
            if (optInt == 0) {
                return;
            }
            Object obj = null;
            if (jSONObject.optBoolean("isSystemRedPoint")) {
                List<QWalletRedTouchInfo> value = HomeLegacyBizManager.f277929d.o().getValue();
                if (value != null) {
                    Iterator<T> it = value.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        QWalletRedTouchInfo qWalletRedTouchInfo = (QWalletRedTouchInfo) next;
                        if (qWalletRedTouchInfo.isForH5() && qWalletRedTouchInfo.appId == optInt) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (z18) {
                            obj = next;
                            break;
                        }
                    }
                    QWalletRedTouchInfo qWalletRedTouchInfo2 = (QWalletRedTouchInfo) obj;
                    if (qWalletRedTouchInfo2 != null) {
                        HomeLegacyBizManager homeLegacyBizManager = HomeLegacyBizManager.f277929d;
                        String str = qWalletRedTouchInfo2.path;
                        Intrinsics.checkNotNullExpressionValue(str, "it.path");
                        homeLegacyBizManager.d(str);
                        return;
                    }
                    return;
                }
                return;
            }
            List<QWalletHomePage$VirtualEntity> value2 = HomeLegacyBizManager.f277929d.h().getValue();
            if (value2 != null) {
                Iterator<T> it5 = value2.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    Object next2 = it5.next();
                    if (((QWalletHomePage$VirtualEntity) next2).f41700id.get() == optInt) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        obj = next2;
                        break;
                    }
                }
                QWalletHomePage$VirtualEntity qWalletHomePage$VirtualEntity = (QWalletHomePage$VirtualEntity) obj;
                if (qWalletHomePage$VirtualEntity != null) {
                    String optString = jSONObject.optString("type");
                    if (Intrinsics.areEqual(optString, "redPoint")) {
                        c4.a.C(qWalletHomePage$VirtualEntity);
                        return;
                    }
                    if (Intrinsics.areEqual(optString, "market")) {
                        c4.a.A(qWalletHomePage$VirtualEntity);
                        return;
                    }
                    QLog.d(TAG, 1, "onH5RedPointClick: illegal type, " + optString);
                }
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "onH5RedPointClick: ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.api.IQWalletHomeApi
    public void onH5TechReport(@NotNull String url, @NotNull String h5Extra) {
        boolean z16;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(h5Extra, "h5Extra");
        QLog.d(TAG, 1, "onH5TechReport: extra " + h5Extra);
        if (h5Extra.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("QWALLET_BROADCAST_H5_REPORT_EVENT");
            intent.putExtra("BROADCAST_KEY_REPORT_DATA", h5Extra);
            intent.putExtra("BROADCAST_KEY_REPORT_URL", url);
            MobileQQ.sMobileQQ.getApplicationContext().sendBroadcast(intent);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "onH5RedPointClick: ", e16);
        }
    }
}

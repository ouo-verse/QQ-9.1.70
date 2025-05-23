package com.tencent.mobileqq.qwallet.hb.aio.impl.pregrab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ark.ark;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.e;
import com.tencent.mobileqq.qwallet.hb.aio.impl.d;
import com.tencent.mobileqq.qwallet.hb.aio.impl.pregrab.a;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.basebl.DecytBean;
import com.tenpay.sdk.basebl.EncryptRequest;
import com.tenpay.sdk.net.NetUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.im.qqwallet.QWalletHbPreGrab$QQHBReply;
import tl.h;
import vk2.QWalletHbModel;
import vk2.QWalletMsgModel;
import vk2.QWalletSessionInfo;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 42\u00020\u0001:\u0001(B\u000f\u0012\u0006\u0010*\u001a\u00020'\u00a2\u0006\u0004\b2\u00103J&\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J\\\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J8\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00132\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\"\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002Jb\u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020\u001cH\u0002JJ\u0010\"\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010#\u001a\u00020\u0006J\u001a\u0010&\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u000f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/aio/impl/pregrab/QWalletPreGrabControllerV2;", "", "Lmqq/app/AppRuntime;", "appRuntime", "Lkotlin/Function1;", "", "", "callback", h.F, "Lvk2/e;", "sessionInfo", "Lvk2/d;", "qqWalletMsg", "authKey", "groupId", "", NotifyMsgApiImpl.KEY_GROUP_TYPE, "name", "hbFrom", "", "f", "Landroid/content/Context;", "context", "reqParams", "pskey", "g", "Landroid/os/Bundle;", "bundle", "Lorg/json/JSONObject;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "redId", "hbPreData", "", "i", DomainData.DOMAIN_NAME, "l", "retCode", "retMsg", "j", "Lcom/tencent/mobileqq/qwallet/hb/aio/impl/pregrab/a;", "a", "Lcom/tencent/mobileqq/qwallet/hb/aio/impl/pregrab/a;", "bizCallback", "b", "I", "keyIndex", "", "c", "J", "startTime", "<init>", "(Lcom/tencent/mobileqq/qwallet/hb/aio/impl/pregrab/a;)V", "d", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletPreGrabControllerV2 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a bizCallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int keyIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long startTime;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qwallet/hb/aio/impl/pregrab/QWalletPreGrabControllerV2$b", "Lcom/tencent/mobileqq/qwallet/e$a;", "", "code", "", "errMsg", "pskey", "", "onFinish", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements e.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<String, Unit> f277267a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super String, Unit> function1) {
            this.f277267a = function1;
        }

        @Override // com.tencent.mobileqq.qwallet.e.a
        public void onFinish(int code, @Nullable String errMsg, @Nullable String pskey) {
            this.f277267a.invoke(pskey);
        }
    }

    public QWalletPreGrabControllerV2(@NotNull a bizCallback) {
        Intrinsics.checkNotNullParameter(bizCallback, "bizCallback");
        this.bizCallback = bizCallback;
        this.keyIndex = Math.abs(new Random().nextInt()) % 16;
        this.startTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> f(AppRuntime appRuntime, QWalletSessionInfo sessionInfo, QWalletMsgModel qqWalletMsg, String authKey, String groupId, int groupType, String name, int hbFrom) {
        HashMap hashMapOf;
        QWalletHbModel hbModel = qqWalletMsg.getHbModel();
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("listid", hbModel.getRedPacketId()), TuplesKt.to(WadlProxyConsts.CHANNEL, String.valueOf(hbModel.getRedChannel())), TuplesKt.to(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, groupId), TuplesKt.to("grouptype", String.valueOf(groupType)), TuplesKt.to("groupuin", sessionInfo.getTroopUin()), TuplesKt.to("name", name), TuplesKt.to("pay_flag", String.valueOf(hbModel.getBody().payFlag)), TuplesKt.to("authkey", authKey), TuplesKt.to("uin", appRuntime.getCurrentAccountUin()), TuplesKt.to("senderuin", qqWalletMsg.getSenderUin()), TuplesKt.to("trans_seq", String.valueOf(this.keyIndex)), TuplesKt.to("hb_from", String.valueOf(hbFrom)));
        if (sessionInfo.getCurType() == 10014) {
            String selfTinyId = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
            Intrinsics.checkNotNullExpressionValue(selfTinyId, "appRuntime.getRuntimeSer\u2026Constant.MAIN).selfTinyId");
            hashMapOf.put("tinyid", selfTinyId);
            hashMapOf.put("guild_id", sessionInfo.getTroopUin());
            hashMapOf.put("sub_guild_id", sessionInfo.getCurFriendUin());
            hashMapOf.put("name", d.a(appRuntime, sessionInfo.getTroopUin(), selfTinyId));
        }
        return hashMapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String g(AppRuntime appRuntime, Context context, Map<String, String> reqParams, String pskey) {
        String joinToString$default;
        boolean z16;
        Set<Map.Entry<String, String>> entrySet = reqParams.entrySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : entrySet) {
            CharSequence charSequence = (CharSequence) ((Map.Entry) obj).getValue();
            if (charSequence != null && charSequence.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                arrayList.add(obj);
            }
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ContainerUtils.FIELD_DELIMITER, null, null, 0, null, new Function1<Map.Entry<? extends String, ? extends String>, CharSequence>() { // from class: com.tencent.mobileqq.qwallet.hb.aio.impl.pregrab.QWalletPreGrabControllerV2$getEncryptText$params$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends String> entry) {
                return invoke2((Map.Entry<String, String>) entry);
            }

            @NotNull
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(@NotNull Map.Entry<String, String> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String key = it.getKey();
                return ((Object) key) + ContainerUtils.KEY_VALUE_DELIMITER + Uri.encode(it.getValue());
            }
        }, 30, null);
        try {
            try {
                return new EncryptRequest(context).encypt(appRuntime.getCurrentUin(), "hb_pre_grapver=2.0&chv=3", this.keyIndex, joinToString$default, pskey, ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).hexGuid()).encText;
            } catch (Exception e16) {
                e = e16;
                QLog.e("QWalletPreGrabController", 1, "encrypt fail, ", e);
                return null;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private final void h(AppRuntime appRuntime, Function1<? super String, Unit> callback) {
        e.c(false, null, new b(callback), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i(AppRuntime appRuntime, QWalletSessionInfo sessionInfo, Context context, QWalletMsgModel qqWalletMsg, String redId, String authKey, int groupType, String groupId, String name, JSONObject hbPreData) {
        JSONObject jSONObject;
        JSONObject c16 = d.c(appRuntime, qqWalletMsg, sessionInfo, groupType, name, redId, authKey, groupId, "appid#1344242394|bargainor_id#1000030201|channel#msg", "graphb");
        JSONObject optJSONObject = c16.optJSONObject("extra_data");
        if (optJSONObject != null) {
            jSONObject = optJSONObject.put("hb_pre_data", hbPreData.toString());
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString(ark.ARKMETADATA_JSON, c16.toString());
        bundle.putString("callbackSn", "0");
        Intent payBridgeIntent = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getPayBridgeIntent(context);
        payBridgeIntent.putExtras(bundle);
        payBridgeIntent.putExtra("pay_requestcode", 5);
        if (!(context instanceof Activity)) {
            payBridgeIntent.addFlags(268435456);
        }
        context.startActivity(payBridgeIntent);
        return true;
    }

    public static /* synthetic */ void k(QWalletPreGrabControllerV2 qWalletPreGrabControllerV2, int i3, String str, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str = null;
        }
        qWalletPreGrabControllerV2.j(i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject m(Bundle bundle, AppRuntime appRuntime, Context context) throws IllegalArgumentException {
        boolean z16;
        byte[] byteArray = bundle.getByteArray("data");
        DecytBean decytBean = null;
        if (byteArray != null) {
            boolean z17 = true;
            if (byteArray.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                QWalletHbPreGrab$QQHBReply qWalletHbPreGrab$QQHBReply = new QWalletHbPreGrab$QQHBReply();
                qWalletHbPreGrab$QQHBReply.mergeFrom(byteArray);
                String str = qWalletHbPreGrab$QQHBReply.retMsg.get();
                QLog.i("QWalletPreGrabController", 2, "pregrab rsp: code=" + qWalletHbPreGrab$QQHBReply.retCode.get() + " msg=" + str);
                String str2 = qWalletHbPreGrab$QQHBReply.rspText.get();
                try {
                    decytBean = new EncryptRequest(context).decypt(appRuntime.getCurrentUin(), "hb_pre_grap", this.keyIndex, str2);
                } catch (Throwable th5) {
                    QLog.e("QWalletPreGrabController", 1, "decrypt fail: " + this.keyIndex + " " + str2, th5);
                }
                if (decytBean == null || decytBean.type != 0) {
                    z17 = false;
                }
                if (z17) {
                    int i3 = this.keyIndex;
                    String str3 = decytBean.decryptStr;
                    if (str3 != null) {
                        str2 = str3;
                    }
                    return NetUtil.getReturnData(i3, str2);
                }
                throw new IllegalArgumentException(str);
            }
        }
        return null;
    }

    public final void j(int retCode, @Nullable String retMsg) {
        QLog.i("QWalletPreGrabController", 1, "pregrab logic finish. retCode=" + retCode + " retMsg=" + retMsg + " cost time: " + (System.currentTimeMillis() - this.startTime));
        a.C8460a.a(this.bizCallback, retCode, null, 2, null);
    }

    public final void l() {
        this.bizCallback.b();
    }

    public final void n(@NotNull AppRuntime appRuntime, @NotNull Context context, @NotNull QWalletSessionInfo sessionInfo, @NotNull QWalletMsgModel qqWalletMsg, @NotNull String redId, @Nullable String authKey, @Nullable String groupId, int hbFrom) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(qqWalletMsg, "qqWalletMsg");
        Intrinsics.checkNotNullParameter(redId, "redId");
        QLog.i("QWalletPreGrabController", 1, "pregrab start, uin=" + sessionInfo.getCurFriendUin() + " groupId=" + groupId + " redId=" + redId);
        l();
        h(appRuntime, new QWalletPreGrabControllerV2$preGrabHb$1(this, sessionInfo, appRuntime, qqWalletMsg, authKey, groupId, hbFrom, context, redId));
    }
}

package com.tenpay.sdk.net.core.processor;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.ipc.IComIPCUtils;
import com.tencent.mobileqq.qwallet.utils.f;
import com.tencent.mobileqq.qwallet.utils.g;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.SoterCore;
import com.tenpay.api.QFuncProxy;
import com.tenpay.api.TenUtilsApi;
import com.tenpay.ndk.CertUtil;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.helper.SharedHelper;
import com.tenpay.sdk.net.NetUtil;
import com.tenpay.sdk.net.core.comm.SessionKey;
import com.tenpay.sdk.net.core.encrypt.BizEncryptController;
import com.tenpay.sdk.net.core.encrypt.DecryptResult;
import com.tenpay.sdk.net.core.encrypt.EncryptResult;
import com.tenpay.sdk.net.core.encrypt.NoEncryptResult;
import com.tenpay.sdk.net.core.encrypt.PayEncryptUtils;
import com.tenpay.sdk.net.core.exception.EcdhException;
import com.tenpay.sdk.net.core.exception.EncryptException;
import com.tenpay.sdk.net.core.log.DLog;
import com.tenpay.sdk.net.core.log.ILogAgent;
import com.tenpay.sdk.net.core.statistic.StatisticInfo;
import com.tenpay.sdk.util.QWSoterConstans;
import com.tenpay.sdk.util.TenUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010&\n\u0002\b\n\u0018\u0000 32\u00020\u0001:\u000234B\u0005\u00a2\u0006\u0002\u0010\u0002Jt\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000f2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\bH\u0002JF\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u001c2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fH\u0002J<\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000f2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u001cH\u0002J>\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\"\u001a\u0004\u0018\u00010\bJ\u001c\u0010#\u001a\u00020\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010$\u001a\u0004\u0018\u00010\u001fH\u0002JH\u0010%\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u001c\u0010'\u001a\u00020\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010!\u001a\u0004\u0018\u00010\u0006H\u0002J.\u0010(\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fH\u0002JJ\u0010)\u001a\u00020\u001a2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u001c2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0+2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fH\u0002JR\u0010,\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u001c2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0+2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fH\u0002J&\u0010-\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fH\u0002J4\u0010.\u001a\u00020\u001a2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0+2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fH\u0002J.\u0010/\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fH\u0002J:\u00100\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u00010\b2\b\u00102\u001a\u0004\u0018\u00010\b2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/tenpay/sdk/net/core/processor/EncryptProcessor;", "", "()V", "encryptController", "Lcom/tenpay/sdk/net/core/encrypt/BizEncryptController;", "encryptExtra", "Lcom/tenpay/sdk/net/core/encrypt/EncryptResult;", "url", "", "sessionKey", "Lcom/tenpay/sdk/net/core/comm/SessionKey;", "isEncrypt", "", "isEcdhEncrypt", WadlProxyConsts.EXTRA_DATA, "", "processResult", "postDataMap", "statisticInfo", "Lcom/tenpay/sdk/net/core/statistic/StatisticInfo;", "getContext", "Landroid/content/Context;", "getGuid", "isPlainTextRsp", "content", "processCertSign", "", "encryptText", "", "processCodePayCgi", "processDecrypt", "Lcom/tenpay/sdk/net/core/encrypt/DecryptResult;", "isSuccessful", "encryptResult", "bodyContent", "processDecryptStatistic", "decryptResult", "processEncrypt", "Lcom/tenpay/sdk/net/core/processor/EncryptProcessor$ProcessResult;", "processEncryptStatistic", "processPayGateCgi", "processPayPasswd", "entry", "", "processPwd", "processSkey", "processTimeStamp", "processWalletGateCgi", "putEncryptParam", "psKey", "guid", "Companion", "ProcessResult", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class EncryptProcessor {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final BizEncryptController encryptController = new BizEncryptController(getContext());

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002\u00a8\u0006\u0005"}, d2 = {"Lcom/tenpay/sdk/net/core/processor/EncryptProcessor$Companion;", "", "()V", "tag", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String tag() {
            return "QWalletHttp-Encrypt(" + Thread.currentThread().getName() + ")";
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005H\u00c6\u0003J\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u00c6\u0003JO\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/tenpay/sdk/net/core/processor/EncryptProcessor$ProcessResult;", "", "url", "", "bodyData", "", "finalExtra", "encryptResult", "Lcom/tenpay/sdk/net/core/encrypt/EncryptResult;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/tenpay/sdk/net/core/encrypt/EncryptResult;)V", "getBodyData", "()Ljava/util/Map;", "getEncryptResult", "()Lcom/tenpay/sdk/net/core/encrypt/EncryptResult;", "getFinalExtra", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class ProcessResult {

        @NotNull
        private final Map<String, String> bodyData;

        @Nullable
        private final EncryptResult encryptResult;

        @NotNull
        private final Map<String, String> finalExtra;

        @NotNull
        private final String url;

        public ProcessResult(@NotNull String url, @NotNull Map<String, String> bodyData, @NotNull Map<String, String> finalExtra, @Nullable EncryptResult encryptResult) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(bodyData, "bodyData");
            Intrinsics.checkNotNullParameter(finalExtra, "finalExtra");
            this.url = url;
            this.bodyData = bodyData;
            this.finalExtra = finalExtra;
            this.encryptResult = encryptResult;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ProcessResult copy$default(ProcessResult processResult, String str, Map map, Map map2, EncryptResult encryptResult, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = processResult.url;
            }
            if ((i3 & 2) != 0) {
                map = processResult.bodyData;
            }
            if ((i3 & 4) != 0) {
                map2 = processResult.finalExtra;
            }
            if ((i3 & 8) != 0) {
                encryptResult = processResult.encryptResult;
            }
            return processResult.copy(str, map, map2, encryptResult);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final Map<String, String> component2() {
            return this.bodyData;
        }

        @NotNull
        public final Map<String, String> component3() {
            return this.finalExtra;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final EncryptResult getEncryptResult() {
            return this.encryptResult;
        }

        @NotNull
        public final ProcessResult copy(@NotNull String url, @NotNull Map<String, String> bodyData, @NotNull Map<String, String> finalExtra, @Nullable EncryptResult encryptResult) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(bodyData, "bodyData");
            Intrinsics.checkNotNullParameter(finalExtra, "finalExtra");
            return new ProcessResult(url, bodyData, finalExtra, encryptResult);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ProcessResult)) {
                return false;
            }
            ProcessResult processResult = (ProcessResult) other;
            if (Intrinsics.areEqual(this.url, processResult.url) && Intrinsics.areEqual(this.bodyData, processResult.bodyData) && Intrinsics.areEqual(this.finalExtra, processResult.finalExtra) && Intrinsics.areEqual(this.encryptResult, processResult.encryptResult)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final Map<String, String> getBodyData() {
            return this.bodyData;
        }

        @Nullable
        public final EncryptResult getEncryptResult() {
            return this.encryptResult;
        }

        @NotNull
        public final Map<String, String> getFinalExtra() {
            return this.finalExtra;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((((this.url.hashCode() * 31) + this.bodyData.hashCode()) * 31) + this.finalExtra.hashCode()) * 31;
            EncryptResult encryptResult = this.encryptResult;
            if (encryptResult == null) {
                hashCode = 0;
            } else {
                hashCode = encryptResult.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "ProcessResult(url=" + this.url + ", bodyData=" + this.bodyData + ", finalExtra=" + this.finalExtra + ", encryptResult=" + this.encryptResult + ")";
        }
    }

    private final EncryptResult encryptExtra(String url, SessionKey sessionKey, boolean isEncrypt, boolean isEcdhEncrypt, Map<String, String> extraData, Map<String, String> processResult, Map<String, String> postDataMap, StatisticInfo statisticInfo) {
        EncryptResult encryptResult;
        int random = sessionKey.getRandom();
        String str = null;
        try {
            putEncryptParam(url, sessionKey.getPskey(), getGuid(), processResult);
            str = CollectionsKt___CollectionsKt.joinToString$default(processResult.entrySet(), ContainerUtils.FIELD_DELIMITER, null, null, 0, null, new Function1<Map.Entry<String, String>, CharSequence>() { // from class: com.tenpay.sdk.net.core.processor.EncryptProcessor$encryptExtra$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull Map.Entry<String, String> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((Object) it.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + ((Object) it.getValue());
                }
            }, 30, null);
            QLog.d(INSTANCE.tag(), 1, "before encrypt: " + random + ", " + processResult);
            if (isEncrypt) {
                encryptResult = this.encryptController.encrypt(sessionKey.getUin(), random, str, isEcdhEncrypt);
                processEncryptStatistic(statisticInfo, encryptResult);
                postDataMap.put("req_text", encryptResult.getParamString());
                postDataMap.putAll(encryptResult.toParamMap());
            } else {
                NoEncryptResult noEncryptResult = new NoEncryptResult(processResult, str);
                postDataMap.putAll(noEncryptResult.toParamMap());
                encryptResult = noEncryptResult;
            }
            processCertSign(url, encryptResult.getParamString(), extraData, postDataMap);
            return encryptResult;
        } catch (EcdhException e16) {
            QLog.w(INSTANCE.tag(), 1, "ecdh encrypt extra error, " + random + ", " + str);
            throw e16;
        } catch (Exception e17) {
            throw new EncryptException("encrypt extra error, " + random + ", " + str, e17);
        }
    }

    private final Context getContext() {
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "sMobileQQ.applicationContext");
        return applicationContext;
    }

    private final String getGuid() {
        boolean z16;
        String hexGuid = ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).hexGuid();
        if (hexGuid.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            hexGuid = ((IComIPCUtils) QRoute.api(IComIPCUtils.class)).ipcGetGuid();
            if (hexGuid == null) {
                hexGuid = "";
            }
            QLog.w(INSTANCE.tag(), 1, "ipc guid = " + hexGuid);
        }
        return hexGuid;
    }

    private final boolean isPlainTextRsp(String content) {
        try {
            new JSONObject(content);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0039, code lost:
    
        if (r5 != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void processCertSign(String url, String encryptText, Map<String, String> extraData, Map<String, String> postDataMap) {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        boolean contains$default4;
        boolean contains$default5;
        String str = null;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "qpay_cert_activate", false, 2, (Object) null);
        if (!contains$default) {
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "qpay_ydt.cgi", false, 2, (Object) null);
            if (!contains$default2) {
                contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "qpay_balance.cgi", false, 2, (Object) null);
                if (!contains$default3) {
                    contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "qpay_fpay_regbind.cgi", false, 2, (Object) null);
                    if (!contains$default4) {
                        contains$default5 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "qpay_itg_verify.cgi", false, 2, (Object) null);
                    }
                }
            }
            str = extraData.get("qpay_cert_cn");
        } else {
            str = extraData.get("cn");
        }
        if (str == null) {
            return;
        }
        try {
            String genUserSigNoEncode = CertUtil.getInstance(getContext()).genUserSigNoEncode(str, encryptText);
            if (genUserSigNoEncode != null) {
                postDataMap.put("qpay_cert_sign", genUserSigNoEncode);
            }
        } catch (EcdhException e16) {
            QLog.w(INSTANCE.tag(), 1, "ecdh generate userSig error");
            throw e16;
        } catch (Exception e17) {
            throw new EncryptException("generate userSig error, " + str + ", " + encryptText, e17);
        }
    }

    private final void processCodePayCgi(String url, Map<String, String> processResult, Map<String, String> extraData) {
        boolean contains$default;
        boolean contains$default2;
        String URI_CODE_PAY_CODE_GEN = Cgi.URI_CODE_PAY_CODE_GEN;
        Intrinsics.checkNotNullExpressionValue(URI_CODE_PAY_CODE_GEN, "URI_CODE_PAY_CODE_GEN");
        boolean z16 = false;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) URI_CODE_PAY_CODE_GEN, false, 2, (Object) null);
        if (!contains$default) {
            String URI_CODE_PAY_CANCEL = Cgi.URI_CODE_PAY_CANCEL;
            Intrinsics.checkNotNullExpressionValue(URI_CODE_PAY_CANCEL, "URI_CODE_PAY_CANCEL");
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) URI_CODE_PAY_CANCEL, false, 2, (Object) null);
            if (!contains$default2) {
                return;
            }
        }
        String qrCodePaySign = TenUtils.getQrCodePaySign(getContext(), extraData);
        if (qrCodePaySign == null || qrCodePaySign.length() == 0) {
            z16 = true;
        }
        if (!z16) {
            processResult.put("sign", URLEncoder.encode(qrCodePaySign, "utf-8"));
        }
    }

    private final void processDecryptStatistic(StatisticInfo statisticInfo, DecryptResult decryptResult) {
        StatisticInfo.EncryptUnit encryptUnit;
        if (statisticInfo != null && (encryptUnit = statisticInfo.getEncryptUnit()) != null && decryptResult != null) {
            encryptUnit.setDecryptTime(decryptResult.getDecodeCostTime());
            encryptUnit.setDhCtrlCode(decryptResult.getErrorCode());
        }
    }

    public static /* synthetic */ ProcessResult processEncrypt$default(EncryptProcessor encryptProcessor, String str, SessionKey sessionKey, Map map, boolean z16, boolean z17, StatisticInfo statisticInfo, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            statisticInfo = null;
        }
        return encryptProcessor.processEncrypt(str, sessionKey, map, z16, z17, statisticInfo);
    }

    private final void processEncryptStatistic(StatisticInfo statisticInfo, EncryptResult encryptResult) {
        StatisticInfo.EncryptUnit encryptUnit;
        if (statisticInfo != null && (encryptUnit = statisticInfo.getEncryptUnit()) != null && encryptResult != null) {
            encryptUnit.setEncryptAlgorithm(encryptResult.getStatistic().getEncryptAlgorithm());
            encryptUnit.setDhCostTime(encryptResult.getStatistic().getDhCostTime());
            encryptUnit.setEncryptTime(encryptResult.getStatistic().getEncryptTime());
        }
    }

    private final void processPayGateCgi(String url, SessionKey sessionKey, Map<String, String> processResult) {
        boolean contains$default;
        String URI_PAY_GATE = Cgi.URI_PAY_GATE;
        Intrinsics.checkNotNullExpressionValue(URI_PAY_GATE, "URI_PAY_GATE");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) URI_PAY_GATE, false, 2, (Object) null);
        if (!contains$default) {
            return;
        }
        processResult.put("model_xml", SoterCore.generateRemoteCheckRequestParam());
        processResult.put("device_id", QFuncProxy.getDeviceId(getContext()));
        String uin = sessionKey.getUin();
        if (SharedHelper.soterOpen(uin)) {
            processResult.put("soter_flag", "1");
            processResult.put(QWSoterConstans.CGI_KEY_QPAYGATE_BUSI_TYPE, String.valueOf(SharedHelper.getCurSoterBusiType(uin)));
            return;
        }
        if (System.currentTimeMillis() / 1000 >= g.f279262a.g("soter_noticed_time_" + uin)) {
            processResult.put("soter_flag", "2");
        }
    }

    private final void processPayPasswd(Map<String, String> extraData, Map.Entry<String, String> entry, Map<String, String> processResult) {
        long j3;
        try {
            String value = entry.getValue();
            if (value == null) {
                return;
            }
            String str = extraData.get("timestamp");
            if (str != null) {
                j3 = Long.parseLong(str);
            } else {
                j3 = 0;
            }
            processResult.put("pay_passwd", TenUtils.getEncWithMacPasswd(getContext(), value, j3));
        } catch (NumberFormatException e16) {
            QLog.w(INSTANCE.tag(), 1, "processPayPasswd error", e16);
        }
    }

    private final void processPwd(String url, Map<String, String> extraData, Map.Entry<String, String> entry, Map<String, String> processResult) {
        boolean z16;
        long currentTimeMillis;
        boolean contains$default;
        String str = extraData.get("timestamp_old");
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            processResult.put("p", TenUtils.getEncWithMacPasswd(getContext(), entry.getValue(), str));
            return;
        }
        try {
            String str2 = extraData.get("timestamp");
            if (str2 != null) {
                currentTimeMillis = Long.parseLong(str2);
            } else {
                currentTimeMillis = 0;
            }
        } catch (NumberFormatException e16) {
            QLog.e(INSTANCE.tag(), 1, "processP error", e16);
            currentTimeMillis = System.currentTimeMillis() / 1000;
        }
        String URI_QWallet_CONFIRM_WITHDRAW = Cgi.URI_QWallet_CONFIRM_WITHDRAW;
        Intrinsics.checkNotNullExpressionValue(URI_QWallet_CONFIRM_WITHDRAW, "URI_QWallet_CONFIRM_WITHDRAW");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) URI_QWallet_CONFIRM_WITHDRAW, false, 2, (Object) null);
        if (contains$default) {
            processResult.put("p", TenUtils.getEncWithNoMacPasswd(getContext(), entry.getValue(), currentTimeMillis));
        } else {
            processResult.put("p", TenUtils.getEncWithMacPasswd(getContext(), entry.getValue(), currentTimeMillis));
        }
    }

    private final void processSkey(SessionKey sessionKey, Map<String, String> postDataMap) {
        sessionKey.putSessionKey(postDataMap);
    }

    private final void processTimeStamp(Map.Entry<String, String> entry, Map<String, String> processResult) {
        long j3;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        try {
            String value = entry.getValue();
            if (value != null) {
                j3 = Long.parseLong(value);
            } else {
                j3 = 0;
            }
            currentTimeMillis += j3;
        } catch (NumberFormatException e16) {
            QLog.w(INSTANCE.tag(), 1, "processTimeStamp error", e16);
        }
        processResult.put(entry.getKey(), Uri.encode(String.valueOf(currentTimeMillis)));
    }

    private final void processWalletGateCgi(String url, SessionKey sessionKey, Map<String, String> processResult) {
        boolean contains$default;
        boolean contains$default2;
        String URL_WALLET_GATE = Cgi.URL_WALLET_GATE;
        Intrinsics.checkNotNullExpressionValue(URL_WALLET_GATE, "URL_WALLET_GATE");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) URL_WALLET_GATE, false, 2, (Object) null);
        if (!contains$default) {
            return;
        }
        String uin = sessionKey.getUin();
        String userInfoExtend = TenUtils.getJsonFromSP("user_info_extend" + uin, uin, "user_info_extend", Cgi.userInfoExtendEnc);
        if (!TextUtils.isEmpty(userInfoExtend)) {
            Intrinsics.checkNotNullExpressionValue(userInfoExtend, "userInfoExtend");
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) userInfoExtend, (CharSequence) "address_suggest", false, 2, (Object) null);
            if (contains$default2) {
                return;
            }
        }
        processResult.put("need_suggest", "1");
    }

    private final void putEncryptParam(String url, String psKey, String guid, Map<String, String> processResult) {
        boolean z16;
        boolean z17 = false;
        if (psKey != null) {
            if (psKey.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = true;
            }
        }
        if (z17) {
            processResult.put("pskey", psKey);
        }
        PsKeyProcessor psKeyProcessor = PsKeyProcessor.INSTANCE;
        if (psKeyProcessor.isForbidUrl(url)) {
            QLog.i(INSTANCE.tag(), 1, "the forbid use url : " + url);
            psKeyProcessor.appendForbidParams2Url(processResult);
        }
        processResult.put("h_net_type", TenUtilsApi.getNetworkType(getContext().getApplicationContext()));
        HashMap<String, String> deviceInfoMap = NetUtil.getDeviceInfoMap(getContext(), guid);
        Intrinsics.checkNotNullExpressionValue(deviceInfoMap, "getDeviceInfoMap(getContext(), guid)");
        processResult.putAll(deviceInfoMap);
    }

    @Nullable
    public final DecryptResult processDecrypt(boolean isSuccessful, boolean isEcdhEncrypt, @NotNull SessionKey sessionKey, @Nullable EncryptResult encryptResult, @Nullable StatisticInfo statisticInfo, @Nullable String bodyContent) {
        boolean z16;
        String str;
        PayEncryptUtils.EncryptType encryptType;
        Integer num;
        Intrinsics.checkNotNullParameter(sessionKey, "sessionKey");
        boolean z17 = true;
        String str2 = null;
        if (!isSuccessful) {
            QLog.w(INSTANCE.tag(), 1, "rsp not successful");
            if (!isEcdhEncrypt) {
                return null;
            }
            throw new EcdhException("ecdh request occur fail", null, 2, null);
        }
        int random = sessionKey.getRandom();
        if (bodyContent != null && bodyContent.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        Companion companion = INSTANCE;
        f.b(companion.tag(), "before decrypt " + random + MsgSummary.STR_COLON + bodyContent);
        if (isPlainTextRsp(bodyContent)) {
            QLog.d(companion.tag(), 2, "is plaintext rsp");
            return new DecryptResult(PayEncryptUtils.EncryptType.TYPE_PLAINTEXT, 0, bodyContent, 0L);
        }
        try {
            DecryptResult decrypt = this.encryptController.decrypt(sessionKey.getUin(), random, bodyContent, isEcdhEncrypt, encryptResult);
            processDecryptStatistic(statisticInfo, decrypt);
            if (decrypt != null) {
                str = decrypt.getDecodedPlain();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                String tag = companion.tag();
                if (decrypt != null) {
                    encryptType = decrypt.getEncryptType();
                } else {
                    encryptType = null;
                }
                if (decrypt != null) {
                    num = Integer.valueOf(decrypt.getErrorCode());
                } else {
                    num = null;
                }
                if (decrypt != null) {
                    str2 = decrypt.getDecodedPlain();
                }
                f.b(tag, "after decrypt type:" + encryptType + ", tlsCode:" + num + ", content:" + str2);
                return decrypt;
            }
            throw new EncryptException("decrypt content fail, " + random + ", " + bodyContent, null, 2, null);
        } catch (EcdhException e16) {
            QLog.w(INSTANCE.tag(), 1, "ecdh decrypt occur error, " + random + ", " + bodyContent);
            throw e16;
        } catch (Exception e17) {
            throw new EncryptException("decrypt occur error, " + random + ", " + bodyContent, e17);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x0078. Please report as an issue. */
    @NotNull
    public final ProcessResult processEncrypt(@NotNull String url, @NotNull SessionKey sessionKey, @NotNull Map<String, String> extraData, boolean isEncrypt, boolean isEcdhEncrypt, @Nullable StatisticInfo statisticInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(sessionKey, "sessionKey");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, String> entry : extraData.entrySet()) {
            String value = entry.getValue();
            if (value != null && value.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry2 : linkedHashMap2.entrySet()) {
            String key = entry2.getKey();
            switch (key.hashCode()) {
                case -1919323627:
                    if (key.equals("pay_passwd")) {
                        processPayPasswd(extraData, entry2, linkedHashMap);
                        break;
                    } else {
                        linkedHashMap.put(entry2.getKey(), Uri.encode(entry2.getValue()));
                        break;
                    }
                case -1197692275:
                    if (key.equals("skey_type")) {
                        ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, INSTANCE.tag(), "ignored income skey: " + entry2, null, 4, null);
                        break;
                    } else {
                        linkedHashMap.put(entry2.getKey(), Uri.encode(entry2.getValue()));
                        break;
                    }
                case 112:
                    if (key.equals("p")) {
                        processPwd(url, extraData, entry2, linkedHashMap);
                        break;
                    } else {
                        linkedHashMap.put(entry2.getKey(), Uri.encode(entry2.getValue()));
                        break;
                    }
                case 3532044:
                    if (key.equals("skey")) {
                        ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, INSTANCE.tag(), "ignored income skey: " + entry2, null, 4, null);
                        break;
                    } else {
                        linkedHashMap.put(entry2.getKey(), Uri.encode(entry2.getValue()));
                        break;
                    }
                case 55126294:
                    if (key.equals("timestamp")) {
                        processTimeStamp(entry2, linkedHashMap);
                        break;
                    } else {
                        linkedHashMap.put(entry2.getKey(), Uri.encode(entry2.getValue()));
                        break;
                    }
                case 1052461640:
                    if (key.equals("trans_seq")) {
                        ILogAgent.DefaultImpls.w$default(DLog.INSTANCE, INSTANCE.tag(), "ignored income skey: " + entry2, null, 4, null);
                        break;
                    } else {
                        linkedHashMap.put(entry2.getKey(), Uri.encode(entry2.getValue()));
                        break;
                    }
                case 2045741950:
                    if (key.equals("timestamp_old")) {
                        break;
                    } else {
                        linkedHashMap.put(entry2.getKey(), Uri.encode(entry2.getValue()));
                        break;
                    }
                default:
                    linkedHashMap.put(entry2.getKey(), Uri.encode(entry2.getValue()));
                    break;
            }
        }
        processWalletGateCgi(url, sessionKey, linkedHashMap);
        processPayGateCgi(url, sessionKey, linkedHashMap);
        processCodePayCgi(url, linkedHashMap, extraData);
        processSkey(sessionKey, linkedHashMap);
        Map<String, String> linkedHashMap3 = new LinkedHashMap<>();
        EncryptResult encryptExtra = encryptExtra(url, sessionKey, isEncrypt, isEcdhEncrypt, extraData, linkedHashMap, linkedHashMap3, statisticInfo);
        processSkey(sessionKey, linkedHashMap3);
        return new ProcessResult(url, linkedHashMap3, linkedHashMap, encryptExtra);
    }
}

package com.tencent.mobileqq.qwallet.kuikly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qwallet.authorize.AuthorizeEntryFragment;
import com.tencent.ark.ark;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.kuikly.core.render.android.c;
import com.tencent.kuikly.core.render.android.d;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin;
import com.tencent.mobileqq.qwallet.pet.fragment.HalfKuiklyEntryFragment;
import com.tencent.mobileqq.qwallet.pet.fragment.HalfWebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.bank.BindBankModule;
import com.tenpay.realname.RealNameSource;
import com.tenpay.sdk.QWalletFakeUrl;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 02\u00020\u0001:\u0005\u001112+\u0015B\u0007\u00a2\u0006\u0004\b.\u0010/J?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u000e\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002JI\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR>\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cj\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e`\u001f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010)\u001a\u0004\u0018\u00010'8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010(R\u0016\u0010-\u001a\u0004\u0018\u00010*8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/qwallet/kuikly/QWalletKuiklyPageRouterModule;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "g", "i", "j", "Lorg/json/JSONObject;", "paramJSON", "a", "method", "call", "Ljava/util/concurrent/atomic/AtomicInteger;", "d", "Ljava/util/concurrent/atomic/AtomicInteger;", "callSeqNo", "Landroid/os/ResultReceiver;", "e", "Landroid/os/ResultReceiver;", "resultReceiver", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/qwallet/kuikly/QWalletKuiklyPageRouterModule$b;", "Lkotlin/collections/HashMap;", "f", "Ljava/util/HashMap;", "getCallbackMap$qwallet_impl_release", "()Ljava/util/HashMap;", "setCallbackMap$qwallet_impl_release", "(Ljava/util/HashMap;)V", "callbackMap", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "()Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "qqRenderView", "Landroidx/fragment/app/Fragment;", "c", "()Landroidx/fragment/app/Fragment;", "qqKuiklyFragment", "<init>", "()V", h.F, "b", "KuiklyResultReceiver", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletKuiklyPageRouterModule extends i01.e {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ResultReceiver resultReceiver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicInteger callSeqNo = new AtomicInteger(0);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<Integer, b> callbackMap = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B4\u0012+\u0010\u0014\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tj\u0004\u0018\u0001`\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014R>\u0010\u0013\u001a)\u0012%\u0012#\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\tj\u0002`\u000e0\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qwallet/kuikly/QWalletKuiklyPageRouterModule$KuiklyResultReceiver;", "Landroid/os/ResultReceiver;", "", QzoneIPCModule.RESULT_CODE, "Landroid/os/Bundle;", "resultData", "", "onReceiveResult", "Lmqq/util/WeakReference;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "d", "Lmqq/util/WeakReference;", "getCallbackWeak", "()Lmqq/util/WeakReference;", "callbackWeak", "callback", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class KuiklyResultReceiver extends ResultReceiver {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<Function1<Object, Unit>> callbackWeak;

        public KuiklyResultReceiver(@Nullable Function1<Object, Unit> function1) {
            super(new Handler(MobileQQ.sMobileQQ.getMainLooper()));
            this.callbackWeak = new WeakReference<>(function1);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int resultCode, @NotNull Bundle resultData) {
            JSONObject jSONObject;
            Intrinsics.checkNotNullParameter(resultData, "resultData");
            Function1<Object, Unit> function1 = this.callbackWeak.get();
            if (function1 == null) {
                return;
            }
            OpenTenpayViewResult openTenpayViewResult = new OpenTenpayViewResult(null, null, null, 7, null);
            try {
                String string = resultData.getString("result");
                if (string != null) {
                    jSONObject = new JSONObject(string);
                } else {
                    jSONObject = new JSONObject();
                }
            } catch (JSONException e16) {
                QLog.e("QWalletPageRouterModule", 1, e16, new Object[0]);
                jSONObject = new JSONObject();
            }
            openTenpayViewResult.b(Integer.valueOf(jSONObject.optInt(QzoneIPCModule.RESULT_CODE, -1)));
            openTenpayViewResult.c(jSONObject.optString("retmsg"));
            openTenpayViewResult.a(jSONObject.optString("data"));
            function1.invoke(new GsonBuilder().create().toJson(openTenpayViewResult));
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B4\u0012+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002j\u0004\u0018\u0001`\u0007\u00a2\u0006\u0004\b\r\u0010\u000eR<\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0002j\u0004\u0018\u0001`\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/kuikly/QWalletKuiklyPageRouterModule$b;", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "a", "Lkotlin/jvm/functions/Function1;", "getRealCallback", "()Lkotlin/jvm/functions/Function1;", "realCallback", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Function1<Object, Unit> realCallback;

        public b(@Nullable Function1<Object, Unit> function1) {
            this.realCallback = function1;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qwallet/kuikly/QWalletKuiklyPageRouterModule$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "retCode", "Ljava/lang/Integer;", "getRetCode", "()Ljava/lang/Integer;", "setRetCode", "(Ljava/lang/Integer;)V", "retMsg", "Ljava/lang/String;", "getRetMsg", "()Ljava/lang/String;", "setRetMsg", "(Ljava/lang/String;)V", "result", "getResult", "setResult", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.kuikly.QWalletKuiklyPageRouterModule$c, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class OpenAuthorizationResult {

        @SerializedName("result")
        @Nullable
        private String result;

        @SerializedName("retCode")
        @Nullable
        private Integer retCode;

        @SerializedName("retMsg")
        @Nullable
        private String retMsg;

        public OpenAuthorizationResult() {
            this(null, null, null, 7, null);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OpenAuthorizationResult)) {
                return false;
            }
            OpenAuthorizationResult openAuthorizationResult = (OpenAuthorizationResult) other;
            if (Intrinsics.areEqual(this.retCode, openAuthorizationResult.retCode) && Intrinsics.areEqual(this.retMsg, openAuthorizationResult.retMsg) && Intrinsics.areEqual(this.result, openAuthorizationResult.result)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            Integer num = this.retCode;
            int i3 = 0;
            if (num == null) {
                hashCode = 0;
            } else {
                hashCode = num.hashCode();
            }
            int i16 = hashCode * 31;
            String str = this.retMsg;
            if (str == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str2 = this.result;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "OpenAuthorizationResult(retCode=" + this.retCode + ", retMsg=" + this.retMsg + ", result=" + this.result + ")";
        }

        public OpenAuthorizationResult(@Nullable Integer num, @Nullable String str, @Nullable String str2) {
            this.retCode = num;
            this.retMsg = str;
            this.result = str2;
        }

        public /* synthetic */ OpenAuthorizationResult(Integer num, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qwallet/kuikly/QWalletKuiklyPageRouterModule$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "retCode", "Ljava/lang/Integer;", "getRetCode", "()Ljava/lang/Integer;", "b", "(Ljava/lang/Integer;)V", "retMsg", "Ljava/lang/String;", "getRetMsg", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "data", "getData", "a", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.kuikly.QWalletKuiklyPageRouterModule$d, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class OpenTenpayViewResult {

        @SerializedName("data")
        @Nullable
        private String data;

        @SerializedName("retCode")
        @Nullable
        private Integer retCode;

        @SerializedName("retMsg")
        @Nullable
        private String retMsg;

        public OpenTenpayViewResult() {
            this(null, null, null, 7, null);
        }

        public final void a(@Nullable String str) {
            this.data = str;
        }

        public final void b(@Nullable Integer num) {
            this.retCode = num;
        }

        public final void c(@Nullable String str) {
            this.retMsg = str;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OpenTenpayViewResult)) {
                return false;
            }
            OpenTenpayViewResult openTenpayViewResult = (OpenTenpayViewResult) other;
            if (Intrinsics.areEqual(this.retCode, openTenpayViewResult.retCode) && Intrinsics.areEqual(this.retMsg, openTenpayViewResult.retMsg) && Intrinsics.areEqual(this.data, openTenpayViewResult.data)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            Integer num = this.retCode;
            int i3 = 0;
            if (num == null) {
                hashCode = 0;
            } else {
                hashCode = num.hashCode();
            }
            int i16 = hashCode * 31;
            String str = this.retMsg;
            if (str == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str2 = this.data;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "OpenTenpayViewResult(retCode=" + this.retCode + ", retMsg=" + this.retMsg + ", data=" + this.data + ")";
        }

        public OpenTenpayViewResult(@Nullable Integer num, @Nullable String str, @Nullable String str2) {
            this.retCode = num;
            this.retMsg = str;
            this.data = str2;
        }

        public /* synthetic */ OpenTenpayViewResult(Integer num, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qwallet/kuikly/QWalletKuiklyPageRouterModule$e", "Lcom/tencent/kuikly/core/render/android/c;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class e implements c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f278591d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QWalletKuiklyPageRouterModule f278592e;

        e(Function1<Object, Unit> function1, QWalletKuiklyPageRouterModule qWalletKuiklyPageRouterModule) {
            this.f278591d = function1;
            this.f278592e = qWalletKuiklyPageRouterModule;
        }

        @Override // com.tencent.kuikly.core.render.android.c
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            c.a.a(this, requestCode, resultCode, data);
            if (requestCode == 101) {
                OpenTenpayViewResult openTenpayViewResult = new OpenTenpayViewResult(null, null, null, 7, null);
                if (resultCode == -1) {
                    openTenpayViewResult.b(0);
                } else {
                    openTenpayViewResult.b(-1);
                }
                QLog.w("QWalletPageRouterModule", 1, "bindNewCard result: " + openTenpayViewResult);
                Function1<Object, Unit> function1 = this.f278591d;
                if (function1 != null) {
                    function1.invoke(new GsonBuilder().create().toJson(openTenpayViewResult));
                }
                this.f278592e.removeKuiklyRenderLifeCycleCallback(this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qwallet/kuikly/QWalletKuiklyPageRouterModule$f", "Lcom/tencent/kuikly/core/render/android/c;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class f implements c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f278593d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QWalletKuiklyPageRouterModule f278594e;

        f(Function1<Object, Unit> function1, QWalletKuiklyPageRouterModule qWalletKuiklyPageRouterModule) {
            this.f278593d = function1;
            this.f278594e = qWalletKuiklyPageRouterModule;
        }

        @Override // com.tencent.kuikly.core.render.android.c
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            String str;
            String stringExtra;
            c.a.a(this, requestCode, resultCode, data);
            if (requestCode != 103) {
                return;
            }
            int i3 = -1;
            if (data != null) {
                i3 = data.getIntExtra("extra_key_result_code", -1);
            }
            String str2 = "";
            if (data == null || (str = data.getStringExtra("extra_key_result_msg")) == null) {
                str = "";
            }
            if (data != null && (stringExtra = data.getStringExtra("extra_key_result_data")) != null) {
                str2 = stringExtra;
            }
            OpenAuthorizationResult openAuthorizationResult = new OpenAuthorizationResult(Integer.valueOf(i3), str, str2);
            QLog.w("QWalletPageRouterModule", 1, "onCallback result: " + openAuthorizationResult);
            Function1<Object, Unit> function1 = this.f278593d;
            if (function1 != null) {
                function1.invoke(new GsonBuilder().create().toJson(openAuthorizationResult));
            }
            this.f278594e.removeKuiklyRenderLifeCycleCallback(this);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qwallet/kuikly/QWalletKuiklyPageRouterModule$g", "Lcom/tencent/kuikly/core/render/android/c;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class g implements c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f278595d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QWalletKuiklyPageRouterModule f278596e;

        g(Function1<Object, Unit> function1, QWalletKuiklyPageRouterModule qWalletKuiklyPageRouterModule) {
            this.f278595d = function1;
            this.f278596e = qWalletKuiklyPageRouterModule;
        }

        @Override // com.tencent.kuikly.core.render.android.c
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            c.a.a(this, requestCode, resultCode, data);
            if (requestCode == 102) {
                OpenTenpayViewResult openTenpayViewResult = new OpenTenpayViewResult(0, null, null, 6, null);
                QLog.w("QWalletPageRouterModule", 1, "openCustomUrl result: " + openTenpayViewResult);
                Function1<Object, Unit> function1 = this.f278595d;
                if (function1 != null) {
                    function1.invoke(new GsonBuilder().create().toJson(openTenpayViewResult));
                }
                this.f278596e.removeKuiklyRenderLifeCycleCallback(this);
            }
        }
    }

    private final void a(JSONObject paramJSON, Function1<Object, Unit> callback) {
        String str;
        String str2;
        String optString;
        boolean z16;
        String str3 = null;
        if (paramJSON != null) {
            str = paramJSON.optString("bargainorId");
        } else {
            str = null;
        }
        boolean z17 = true;
        if (paramJSON != null && (str2 = paramJSON.optString("sourceId")) != null) {
            if (str2.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str2 = "0";
            }
        } else {
            str2 = null;
        }
        if (paramJSON != null && (optString = paramJSON.optString(RealNameSource.EXTRA_KEY_SOURCE_NAME)) != null) {
            if (optString.length() != 0) {
                z17 = false;
            }
            if (z17) {
                optString = RealNameSource.INSTANCE.getSourceName(str2);
            }
            str3 = optString;
        }
        Activity activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            intent.putExtra("bargainor_id", str);
            intent.putExtra(RealNameSource.EXTRA_KEY_SOURCE, new RealNameSource(str2, str3));
            addKuiklyRenderLifecycleCallback(new e(callback, this));
            BindBankModule.INSTANCE.startWithSwitchForResult(activity, intent, 101, 3, true);
        }
    }

    private final Fragment c() {
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h hVar;
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g d16 = d();
        if (d16 != null) {
            hVar = d16.getDelegate();
        } else {
            hVar = null;
        }
        if (!(hVar instanceof Fragment)) {
            return null;
        }
        return (Fragment) hVar;
    }

    private final com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g d() {
        d O0;
        ViewGroup view;
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        ViewParent viewParent = null;
        if (aVar != null && (O0 = aVar.O0()) != null && (view = O0.getView()) != null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (parent == null) {
                    break;
                }
                if (parent instanceof com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g) {
                    viewParent = parent;
                    break;
                }
                parent = parent.getParent();
            }
        }
        return (com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g) viewParent;
    }

    private final void g(String params, Function1<Object, Unit> callback) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (callback != null) {
                callback.invoke(new GsonBuilder().create().toJson(new OpenAuthorizationResult(-1, "not support url", null, 4, null)));
                return;
            }
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(params);
            long optLong = jSONObject.optLong("appId");
            String optString = jSONObject.optString("openId");
            String optString2 = jSONObject.optString(CommonConstant.KEY_ACCESS_TOKEN);
            String optString3 = jSONObject.optString("sign");
            int optInt = jSONObject.optInt("isChangeAccount", 0);
            addKuiklyRenderLifecycleCallback(new f(callback, this));
            Intent intent = new Intent(getActivity(), (Class<?>) QPublicTransFragmentActivity.class);
            intent.putExtra("extra_key_authorize_appid", optLong);
            intent.putExtra("extra_key_authorize_openid", optString);
            intent.putExtra("extra_key_authorize_access_token", optString2);
            intent.putExtra("extra_key_authorize_sign", optString3);
            intent.putExtra("extra_key_authorize_change_account", optInt);
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra("public_fragment_class", AuthorizeEntryFragment.class.getName());
            Fragment c16 = c();
            if (c16 == null) {
                return;
            }
            c16.startActivityForResult(intent, 103);
        } catch (JSONException e16) {
            QLog.e("QWalletPageRouterModule", 1, e16, new Object[0]);
            if (callback != null) {
                callback.invoke(new GsonBuilder().create().toJson(new OpenAuthorizationResult(-1, "not support url", null, 4, null)));
            }
        }
    }

    private final void i(String params, Function1<Object, Unit> callback) {
        boolean z16;
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (callback != null) {
                callback.invoke(new GsonBuilder().create().toJson(new OpenTenpayViewResult(-1, "not support url", null, 4, null)));
                return;
            }
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(params);
            String url = jSONObject.optString("url");
            String title = jSONObject.optString("title");
            String merchantLogo = jSONObject.optString("merchantLogo");
            String merchantTitle = jSONObject.optString("merchantTitle");
            int optInt = jSONObject.optInt("heightPercentage", 88);
            int optInt2 = jSONObject.optInt("opacity", 50);
            boolean optBoolean = jSONObject.optBoolean("showStatusBar");
            addKuiklyRenderLifecycleCallback(new g(callback, this));
            Fragment c16 = c();
            if (c16 == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(url, "url");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "mqqapi://kuikly/open", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "http://", false, 2, null);
                if (!startsWith$default2) {
                    startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(url, "https://", false, 2, null);
                    if (!startsWith$default3) {
                        if (callback != null) {
                            callback.invoke(new GsonBuilder().create().toJson(new OpenTenpayViewResult(-1, "not support url", null, 4, null)));
                            return;
                        }
                        return;
                    }
                }
                HalfWebViewFragment.Companion companion = HalfWebViewFragment.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(merchantLogo, "merchantLogo");
                Intrinsics.checkNotNullExpressionValue(merchantTitle, "merchantTitle");
                companion.c(c16, url, merchantLogo, merchantTitle, optInt, optInt2, 102);
                return;
            }
            HalfKuiklyEntryFragment.Companion companion2 = HalfKuiklyEntryFragment.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(merchantLogo, "merchantLogo");
            Intrinsics.checkNotNullExpressionValue(merchantTitle, "merchantTitle");
            companion2.a(c16, url, title, merchantLogo, merchantTitle, optInt, optInt2, optBoolean, 102);
        } catch (JSONException e16) {
            QLog.e("QWalletPageRouterModule", 1, e16, new Object[0]);
            if (callback != null) {
                callback.invoke(new GsonBuilder().create().toJson(new OpenTenpayViewResult(-1, "not support url", null, 4, null)));
            }
        }
    }

    private final void j(String params, Function1<Object, Unit> callback) {
        JSONObject jSONObject;
        String str = null;
        if (params != null) {
            jSONObject = new JSONObject(params);
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            str = jSONObject.optString(HippyHeaderListViewController.VIEW_TAG);
        }
        if (Intrinsics.areEqual(str, QWalletFakeUrl.FAKEURL_BINDNEWCARD)) {
            a(jSONObject, callback);
            return;
        }
        this.callbackMap.put(Integer.valueOf(this.callSeqNo.incrementAndGet()), new b(callback));
        this.resultReceiver = new KuiklyResultReceiver(callback);
        Bundle bundle = new Bundle();
        bundle.putString(ark.ARKMETADATA_JSON, params);
        PayBridgeActivity.tenpay(getActivity(), 5, bundle, this.resultReceiver);
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != 123662927) {
            if (hashCode != 1439804692) {
                if (hashCode == 1724141210 && method.equals(TenpayPlugin.PLUGIN_NAME)) {
                    j(params, callback);
                    return Unit.INSTANCE;
                }
            } else if (method.equals("openCustomUrl")) {
                i(params, callback);
                return Unit.INSTANCE;
            }
        } else if (method.equals("openAuthorization")) {
            g(params, callback);
            return Unit.INSTANCE;
        }
        QLog.w("QWalletPageRouterModule", 1, "unknown method: " + method);
        return super.call(method, params, callback);
    }
}

package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import android.app.Activity;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.inject.IVasInject;
import com.tencent.mobileqq.vas.inject.VasInjectApi;
import com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ=\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tJ\u0006\u0010\f\u001a\u00020\bR;\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/al;", "", "", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "b", "a", "Lkotlin/jvm/functions/Function1;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class al {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BL\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\b\u00123\u0010\u0019\u001a/\u0012)\u0012'\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012j\u0004\u0018\u0001`\u0017\u0018\u00010\u0011\u00a2\u0006\u0004\b\u001a\u0010\u001bJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fRA\u0010\u0019\u001a/\u0012)\u0012'\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012j\u0004\u0018\u0001`\u0017\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/al$a;", "Lcom/tencent/mobileqq/vip/api/h;", "", "vipMa", "billno", "payStr", "", "b", "", "code", "a", "msg", "c", "Ljava/lang/String;", "userId", "I", "buyNum", "Lmqq/util/WeakReference;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "Lmqq/util/WeakReference;", "callbackRef", "<init>", "(Ljava/lang/String;ILmqq/util/WeakReference;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements com.tencent.mobileqq.vip.api.h {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String userId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int buyNum;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final WeakReference<Function1<Object, Unit>> callbackRef;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/kuikly/moduleimpl/al$a$a", "Lcom/tencent/mobileqq/vas/pay/page/PayTypeSelectedDialog$b;", "", "type", "", NodeProps.ON_CLICK, "vas-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.vas.kuikly.moduleimpl.al$a$a, reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        public static final class C8914a implements PayTypeSelectedDialog.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f309782a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Activity f309783b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ a f309784c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f309785d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f309786e;

            C8914a(String str, Activity activity, a aVar, String str2, String str3) {
                this.f309782a = str;
                this.f309783b = activity;
                this.f309784c = aVar;
                this.f309785d = str2;
                this.f309786e = str3;
            }

            @Override // com.tencent.mobileqq.vas.pay.page.PayTypeSelectedDialog.b
            public void onClick(int type) {
                String str;
                QLog.i("VasKuiklyModule", 1, "user selected pay type: " + type);
                JSONObject jSONObject = new JSONObject(this.f309782a);
                String offerId = jSONObject.optString("app_id");
                String optString = jSONObject.optString("productid");
                String serviceType = jSONObject.optString("serviceType");
                int optInt = jSONObject.optInt("month");
                String reportData = jSONObject.optString("reportData");
                Activity topActivity = this.f309783b;
                Intrinsics.checkNotNullExpressionValue(topActivity, "topActivity");
                e23.c cVar = new e23.c(topActivity);
                Intrinsics.checkNotNullExpressionValue(offerId, "offerId");
                Intrinsics.checkNotNullExpressionValue(serviceType, "serviceType");
                String str2 = this.f309784c.userId;
                int i3 = this.f309784c.buyNum;
                JSONObject jSONObject2 = new JSONObject();
                String str3 = this.f309786e;
                jSONObject2.put("apf", "2");
                jSONObject2.put("preorder_bill", str3);
                Unit unit = Unit.INSTANCE;
                String encode = URLEncoder.encode(jSONObject2.toString(), "utf-8");
                Intrinsics.checkNotNullExpressionValue(encode, "encode(JSONObject().appl\u2026   }.toString(), \"utf-8\")");
                String str4 = this.f309785d;
                String str5 = this.f309786e;
                if (optInt != 1) {
                    str = optInt + QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO;
                } else {
                    str = "";
                }
                Intrinsics.checkNotNullExpressionValue(reportData, "reportData");
                cVar.a(new e23.a(offerId, serviceType, serviceType, str2, i3, encode, null, null, null, null, null, null, null, null, null, null, optString, str4, str5, str, null, reportData, 1114048, null), type);
            }
        }

        public a(@NotNull String userId, int i3, @Nullable WeakReference<Function1<Object, Unit>> weakReference) {
            Intrinsics.checkNotNullParameter(userId, "userId");
            this.userId = userId;
            this.buyNum = i3;
            this.callbackRef = weakReference;
        }

        @Override // com.tencent.mobileqq.vip.api.k
        public void a(int code) {
            Function1<Object, Unit> function1;
            WeakReference<Function1<Object, Unit>> weakReference = this.callbackRef;
            if (weakReference != null && (function1 = weakReference.get()) != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", code);
                jSONObject.put("msg", "");
                function1.invoke(jSONObject.toString());
            }
        }

        @Override // com.tencent.mobileqq.vip.api.h
        public void b(@NotNull String vipMa, @NotNull String billno, @NotNull String payStr) {
            Intrinsics.checkNotNullParameter(vipMa, "vipMa");
            Intrinsics.checkNotNullParameter(billno, "billno");
            Intrinsics.checkNotNullParameter(payStr, "payStr");
            Activity topActivity = Foreground.getTopActivity();
            Intrinsics.checkNotNullExpressionValue(topActivity, "topActivity");
            PayTypeSelectedDialog payTypeSelectedDialog = new PayTypeSelectedDialog(topActivity);
            payTypeSelectedDialog.O(new C8914a(payStr, topActivity, this, vipMa, billno));
            payTypeSelectedDialog.show();
        }

        @Override // com.tencent.mobileqq.vip.api.k
        public void c(int code, @NotNull String msg2) {
            Function1<Object, Unit> function1;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            WeakReference<Function1<Object, Unit>> weakReference = this.callbackRef;
            if (weakReference != null && (function1 = weakReference.get()) != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", code);
                jSONObject.put("msg", msg2);
                function1.invoke(jSONObject.toString());
            }
        }
    }

    public final void a() {
        this.callback = null;
    }

    public final void b(@Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNull(params);
        JSONObject jSONObject = new JSONObject(params);
        String userId = jSONObject.optString("userId");
        int optInt = jSONObject.optInt("businessType");
        String optString = jSONObject.optString("aid");
        String optString2 = jSONObject.optString("itemId");
        jSONObject.optString("itemSubId");
        jSONObject.optInt("product_type");
        int optInt2 = jSONObject.optInt("buyNum");
        jSONObject.optString(AdParam.PF);
        Activity topActivity = Foreground.getTopActivity();
        this.callback = callback;
        IVasInject vasInjectApi = VasInjectApi.getInstance();
        Intrinsics.checkNotNullExpressionValue(userId, "userId");
        vasInjectApi.itemLyPay(userId, optString, optInt, optInt2, optString2, topActivity, new a(userId, optInt2, new WeakReference(callback)));
    }
}

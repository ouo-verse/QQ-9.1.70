package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.loginregister.IPrettyAccountRegisterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J?\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042'\u0010\f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006j\u0002`\u000bJ/\u0010\u000e\u001a\u00020\n2'\u0010\f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006j\u0002`\u000bJ/\u0010\u000f\u001a\u00020\n2'\u0010\f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0006j\u0002`\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/w;", "", "Landroid/content/Context;", "context", "", "jsonString", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "c", "e", "b", "<init>", "()V", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class w {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/kuikly/moduleimpl/w$b", "Lcom/tencent/mobileqq/guid/d;", "", "bytes", "", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements com.tencent.mobileqq.guid.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f309856a;

        b(Function1<Object, Unit> function1) {
            this.f309856a = function1;
        }

        @Override // com.tencent.mobileqq.guid.d
        public void a(@NotNull byte[] bytes) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            StringBuilder sb5 = new StringBuilder(bytes.length * 2);
            for (byte b16 : bytes) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b16)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                sb5.append(format);
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "with(StringBuilder(bytes\u2026tring()\n                }");
            Function1<Object, Unit> function1 = this.f309856a;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", sb6));
            function1.invoke(mapOf);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/vas/kuikly/moduleimpl/w$c", "Lcom/tencent/mobileqq/login/aa;", "", "uin", "Landroid/os/Bundle;", "bundle", "", "c", "Lcom/tencent/mobileqq/login/aj;", "failedInfo", "b", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements com.tencent.mobileqq.login.aa {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f309857a;

        c(Function1<Object, Unit> function1) {
            this.f309857a = function1;
        }

        @Override // com.tencent.mobileqq.login.aa
        public void a() {
            Map mapOf;
            Function1<Object, Unit> function1 = this.f309857a;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("result", 2), TuplesKt.to("msg", "user cancel"));
            function1.invoke(mapOf);
        }

        @Override // com.tencent.mobileqq.login.aa
        public void b(@Nullable com.tencent.mobileqq.login.aj failedInfo) {
            int i3;
            Object obj;
            Map mapOf;
            Function1<Object, Unit> function1 = this.f309857a;
            Pair[] pairArr = new Pair[2];
            if (failedInfo != null) {
                i3 = failedInfo.f241865b;
            } else {
                i3 = -2;
            }
            pairArr[0] = TuplesKt.to("result", Integer.valueOf(i3));
            if (failedInfo != null) {
                obj = failedInfo.f241867d;
            } else {
                obj = null;
            }
            if (obj == null) {
                obj = "other";
            }
            pairArr[1] = TuplesKt.to("msg", obj);
            mapOf = MapsKt__MapsKt.mapOf(pairArr);
            function1.invoke(mapOf);
        }

        @Override // com.tencent.mobileqq.login.aa
        public void c(@Nullable String uin, @Nullable Bundle bundle) {
            Map mapOf;
            Function1<Object, Unit> function1 = this.f309857a;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("result", 0), TuplesKt.to("msg", "success"));
            function1.invoke(mapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String jsonString, Function1 callback) {
        Intrinsics.checkNotNullParameter(jsonString, "$jsonString");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        JSONObject jSONObject = new JSONObject(jsonString);
        String uin = jSONObject.optString("uin");
        String pwd = jSONObject.optString("pwd");
        String sig = jSONObject.optString(PreloadTRTCPlayerParams.KEY_SIG);
        QLog.i("VasKuiklyModule", 1, "call loginAccount");
        IPrettyAccountRegisterApi iPrettyAccountRegisterApi = (IPrettyAccountRegisterApi) QRoute.api(IPrettyAccountRegisterApi.class);
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        Intrinsics.checkNotNullExpressionValue(pwd, "pwd");
        Intrinsics.checkNotNullExpressionValue(sig, "sig");
        iPrettyAccountRegisterApi.login(uin, pwd, sig, new c(callback));
    }

    public final void b(@NotNull Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.guid.c.f213821a.g(new b(callback));
    }

    public final void c(@NotNull Context context, @NotNull final String jsonString, @NotNull final Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        Intrinsics.checkNotNullParameter(callback, "callback");
        y13.d.b(new Runnable() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.v
            @Override // java.lang.Runnable
            public final void run() {
                w.d(jsonString, callback);
            }
        });
    }

    public final void e(@NotNull Function1<Object, Unit> callback) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(callback, "callback");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("result", Boolean.valueOf(MobileQQ.sMobileQQ.isLoginByNT())));
        callback.invoke(mapOf);
    }
}

package com.tencent.mobileqq.zplan.room.impl.utils;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import zu4.b;
import zu4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ*\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J&\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002JA\u0010\u0015\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022/\u0010\u0014\u001a+\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\n0\u0010J7\u0010\u0018\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022%\b\u0002\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\n\u0018\u00010\u0010R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/utils/SignUtils;", "", "", "openId", "", PayProxy.Source.PAY_REQUEST_SIGN_TYPE_KEY, "Lkotlin/Pair;", "c", "Lzu4/b;", "rsp", "", h.F, "Lzu4/d;", "targetSign", "e", "b", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sign", "callback", "f", "", "success", "g", "", "Ljava/util/Map;", "signMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SignUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final SignUtils f335313a = new SignUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, d> signMap = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/utils/SignUtils$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzu4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements e<b> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f335315d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f335316e;

        /* JADX WARN: Multi-variable type inference failed */
        a(String str, Function1<? super Boolean, Unit> function1) {
            this.f335315d = str;
            this.f335316e = function1;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            SignUtils.f335313a.h(this.f335315d, result);
            QLog.d("TRTC_SIGN", 1, "reuqet success -> " + result);
            Function1<Boolean, Unit> function1 = this.f335316e;
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("TRTC_SIGN", 1, "request file => " + error + ", " + message);
            Function1<Boolean, Unit> function1 = this.f335316e;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
        }
    }

    SignUtils() {
    }

    private final String b(String openId) {
        return "TRTC_SIGN_" + openId;
    }

    private final Pair<String, String> c(String openId, int signType) {
        String b16 = b(openId);
        Map<String, d> map = signMap;
        d dVar = map.get(b16);
        if (dVar != null) {
            return e(dVar, signType);
        }
        d dVar2 = new d();
        pc4.a.f425898a.a(b16, dVar2);
        Pair<String, String> e16 = e(dVar2, signType);
        if (e16 != null) {
            map.put(b16, dVar2);
        }
        return e16;
    }

    private final Pair<String, String> e(d targetSign, int signType) {
        String str = targetSign.f453432b;
        if (str == null || targetSign.f453434d == null) {
            return null;
        }
        if (targetSign.f453431a != signType) {
            QLog.e("TRTC_SIGN", 1, "type is not match " + str + " , " + signType);
            return null;
        }
        if (targetSign.f453433c < NetConnInfoCenter.getServerTime()) {
            QLog.e("TRTC_SIGN", 1, "sign expire " + targetSign.f453433c + " and now is " + NetConnInfoCenter.getServerTime());
            return null;
        }
        return new Pair<>(targetSign.f453434d, targetSign.f453432b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String openId, b rsp) {
        d[] dVarArr = rsp.f453428a;
        if (dVarArr != null) {
            Intrinsics.checkNotNullExpressionValue(dVarArr, "rsp.signList");
            if (!(dVarArr.length == 0)) {
                QLog.i("TRTC_SIGN", 1, "save sign => " + rsp.f453428a.length);
                d[] dVarArr2 = rsp.f453428a;
                Intrinsics.checkNotNullExpressionValue(dVarArr2, "rsp.signList");
                for (d it : dVarArr2) {
                    String b16 = f335313a.b(openId);
                    Map<String, d> map = signMap;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    map.put(b16, it);
                    pc4.a.f425898a.b(b16, it);
                }
                return;
            }
        }
        QLog.e("TRTC_SIGN", 1, "rsp have not valid value");
    }

    public final void f(final String openId, final Function1<? super Pair<String, String>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Pair d16 = d(this, openId, 0, 2, null);
        if (d16 != null) {
            QLog.i("TRTC_SIGN", 1, "get sign from local -> " + d16);
            callback.invoke(d16);
            return;
        }
        g(openId, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.room.impl.utils.SignUtils$requestSign$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (z16) {
                    Pair<String, String> d17 = SignUtils.d(SignUtils.f335313a, openId, 0, 2, null);
                    QLog.i("TRTC_SIGN", 1, "get sign succes => " + d17);
                    callback.invoke(d17);
                    return;
                }
                callback.invoke(null);
            }
        });
    }

    public final void g(String openId, Function1<? super Boolean, Unit> callback) {
        zu4.a aVar = new zu4.a();
        aVar.f453426a = openId;
        aVar.f453427b = new int[]{1};
        QLog.i("TRTC_SIGN", 1, "reuqet sign => " + aVar);
        lk3.b.b(lk3.b.f414970a, aVar, new a(openId, callback), 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Pair d(SignUtils signUtils, String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return signUtils.c(str, i3);
    }
}

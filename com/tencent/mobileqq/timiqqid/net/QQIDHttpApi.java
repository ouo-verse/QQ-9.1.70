package com.tencent.mobileqq.timiqqid.net;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.timiqqid.helper.CommonUtils;
import com.tencent.mobileqq.timiqqid.helper.YoloLog;
import com.tencent.mobileqq.timiqqid.net.data.PassResult;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0007\u001a\u00020\u0005H\u0007J-\u0010\u000e\u001a\u00020\u00052#\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\u00050\bH\u0007J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\tH\u0002R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/timiqqid/net/QQIDHttpApi;", "", "", "url", "cookie", "", "i", "f", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/timiqqid/net/data/PassResult;", "Lkotlin/ParameterName;", "name", "data", "finishCallback", tl.h.F, "g", "result", "k", "b", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "c", "getCookie", "setCookie", "", "d", "Z", "stopped", "Ljava/lang/Runnable;", "e", "Ljava/lang/Runnable;", "getPassRunnable", "()Ljava/lang/Runnable;", "passRunnable", "<init>", "()V", "timi-qqid-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class QQIDHttpApi {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQIDHttpApi f293207a = new QQIDHttpApi();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String url = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String cookie = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean stopped = true;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Runnable passRunnable = new Runnable() { // from class: com.tencent.mobileqq.timiqqid.net.d
        @Override // java.lang.Runnable
        public final void run() {
            QQIDHttpApi.j();
        }
    };

    QQIDHttpApi() {
    }

    @JvmStatic
    public static final void f() {
        stopped = true;
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(passRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(passRunnable, 1000L);
    }

    @JvmStatic
    public static final void h(@NotNull final Function1<? super PassResult, Unit> finishCallback) {
        Intrinsics.checkNotNullParameter(finishCallback, "finishCallback");
        HttpRequester.f293200a.d(url, cookie, new c<PassResult>() { // from class: com.tencent.mobileqq.timiqqid.net.QQIDHttpApi$getPassResult$1
            @Override // com.tencent.mobileqq.timiqqid.net.c
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@NotNull PassResult data) {
                Intrinsics.checkNotNullParameter(data, "data");
                Function1<PassResult, Unit> function1 = finishCallback;
                if (function1 != null) {
                    function1.invoke(data);
                }
                QQIDHttpApi.stopped = true;
            }

            @Override // com.tencent.mobileqq.timiqqid.net.c
            public void onFail(final int code, @Nullable final String msg2) {
                boolean z16;
                YoloLog.e("QQIDViewModel", new Function0<String>() { // from class: com.tencent.mobileqq.timiqqid.net.QQIDHttpApi$getPassResult$1$onFail$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        return "getPassResult:" + code + ',' + msg2;
                    }
                });
                z16 = QQIDHttpApi.stopped;
                if (z16) {
                    QQIDHttpApi.f293207a.g();
                }
            }
        });
    }

    @JvmStatic
    public static final void i(@NotNull String url2, @NotNull String cookie2) {
        Intrinsics.checkNotNullParameter(url2, "url");
        Intrinsics.checkNotNullParameter(cookie2, "cookie");
        stopped = false;
        url = url2;
        cookie = cookie2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j() {
        h(new Function1<PassResult, Unit>() { // from class: com.tencent.mobileqq.timiqqid.net.QQIDHttpApi$passRunnable$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PassResult passResult) {
                invoke2(passResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull PassResult data) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (data.getBody() == null || data.getHeader().a() != 0) {
                    return;
                }
                QQIDHttpApi.f293207a.k(data);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(PassResult result) {
        PassResult.a body = result.getBody();
        if (body == null) {
            return;
        }
        if (body.c() == 1 || body.c() == 2) {
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            String string = mobileQQ.getString(R.string.f23157728);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026qid_notification_success)");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string2 = mobileQQ.getString(R.string.f23158729);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026fication_success_content)");
            String format = String.format(string2, Arrays.copyOf(new Object[]{body.b()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            String a16 = result.getBody().a();
            if (a16 == null) {
                return;
            }
            CommonUtils.a(string, format, a16);
        }
    }
}

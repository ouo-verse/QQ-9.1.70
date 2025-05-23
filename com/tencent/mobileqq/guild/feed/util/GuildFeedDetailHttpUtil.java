package com.tencent.mobileqq.guild.feed.util;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.adapter.http.HttpHeader;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/GuildFeedDetailHttpUtil;", "", "", "url", "e", "host", "Lcom/tencent/qqnt/msg/api/c;", "g", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "c", "account", "d", "b", "Ljava/lang/String;", "UA", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedDetailHttpUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildFeedDetailHttpUtil f223767a = new GuildFeedDetailHttpUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String UA = "QQ/" + AppSetting.f99551k + " Android/0.17 Android/" + Build.VERSION.RELEASE;

    GuildFeedDetailHttpUtil() {
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0084 A[Catch: Exception -> 0x00d5, TryCatch #0 {Exception -> 0x00d5, blocks: (B:10:0x002b, B:13:0x0036, B:15:0x0043, B:16:0x0058, B:18:0x0078, B:23:0x0084, B:25:0x008a, B:31:0x0098, B:36:0x00a2, B:45:0x004c), top: B:9:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, java.lang.Object, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String e(String url) {
        TicketManager ticketManager;
        boolean z16;
        boolean z17;
        AppInterface appInterface = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).appInterface();
        Intrinsics.checkNotNullExpressionValue(appInterface, "api(IQQGuildUtilApi::class.java).appInterface()");
        Manager manager = appInterface.getManager(2);
        if (manager instanceof TicketManager) {
            ticketManager = (TicketManager) manager;
        } else {
            ticketManager = null;
        }
        if (ticketManager == null) {
            return "";
        }
        String uin = appInterface.getAccount();
        try {
            String host = Uri.parse(url).getHost();
            if (host == null) {
                return "";
            }
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            if (ticketManager.useAsyncTicketInterface()) {
                BuildersKt__BuildersKt.runBlocking$default(null, new GuildFeedDetailHttpUtil$getCommonPSkeyCookie$1(objectRef, null), 1, null);
            } else {
                ?? a26 = ticketManager.getA2(uin);
                Intrinsics.checkNotNullExpressionValue(a26, "manager.getA2(uin)");
                objectRef.element = a26;
            }
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = "";
            BuildersKt__BuildersKt.runBlocking$default(null, new GuildFeedDetailHttpUtil$getCommonPSkeyCookie$2(host, objectRef2, null), 1, null);
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            String d16 = d(uin);
            CharSequence charSequence = (CharSequence) objectRef.element;
            boolean z18 = false;
            if (charSequence != null && charSequence.length() != 0) {
                z16 = false;
                if (!z16) {
                    return "";
                }
                CharSequence charSequence2 = (CharSequence) objectRef2.element;
                if (charSequence2 != null && charSequence2.length() != 0) {
                    z17 = false;
                    if (!z17) {
                        return "";
                    }
                    if (d16 == null || d16.length() == 0) {
                        z18 = true;
                    }
                    if (z18) {
                        return "";
                    }
                    return "uin=" + d16 + ";a2=" + objectRef.element + ";p_skey=" + objectRef2.element + ";p_uin=" + d16;
                }
                z17 = true;
                if (!z17) {
                }
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Exception e16) {
            QLog.e("GuildFeedDetailHttpUtil", 1, "collectHeader cookie exception happened", e16);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f(Continuation<? super com.tencent.qqnt.msg.api.c<String>> continuation) {
        Continuation intercepted;
        TicketManager ticketManager;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        AppInterface appInterface = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).appInterface();
        Intrinsics.checkNotNullExpressionValue(appInterface, "api(IQQGuildUtilApi::class.java).appInterface()");
        Manager manager = appInterface.getManager(2);
        if (manager instanceof TicketManager) {
            ticketManager = (TicketManager) manager;
        } else {
            ticketManager = null;
        }
        if (ticketManager == null) {
            QLog.e("queryA2Suspend", 2, "manager == null");
            cancellableContinuationImpl.resume(new com.tencent.qqnt.msg.api.c("", 1, "manager == null"), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedDetailHttpUtil$queryA2Suspend$2$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Throwable it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                    invoke2(th5);
                    return Unit.INSTANCE;
                }
            });
        } else {
            ticketManager.getA2(appInterface.getLongAccountUin(), 16, new MainTicketCallback() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedDetailHttpUtil$queryA2Suspend$2$2
                @Override // mqq.manager.MainTicketCallback
                public void onFail(int errorCode, @Nullable String errorMsg) {
                    QLog.e("queryA2Suspend", 2, "getA2 onFail errMsg=" + errorMsg);
                    if (errorMsg == null) {
                        errorMsg = "";
                    }
                    cancellableContinuationImpl.resume(new com.tencent.qqnt.msg.api.c<>("", 1, errorMsg), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedDetailHttpUtil$queryA2Suspend$2$2$onFail$1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                            invoke2(th5);
                            return Unit.INSTANCE;
                        }
                    });
                }

                @Override // mqq.manager.MainTicketCallback
                public void onSuccess(@Nullable MainTicketInfo info) {
                    String str;
                    if (info != null) {
                        str = info.getA2();
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        str = "";
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.e("queryA2Suspend", 4, "getA2 onSuccess");
                    }
                    cancellableContinuationImpl.resume(new com.tencent.qqnt.msg.api.c<>(str, 0, ""), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedDetailHttpUtil$queryA2Suspend$2$2$onSuccess$1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull Throwable it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                            invoke2(th5);
                            return Unit.INSTANCE;
                        }
                    });
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g(final String str, Continuation<? super com.tencent.qqnt.msg.api.c<String>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        AppInterface appInterface = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).appInterface();
        Intrinsics.checkNotNullExpressionValue(appInterface, "api(IQQGuildUtilApi::class.java).appInterface()");
        ((IPskeyManager) appInterface.getRuntimeService(IPskeyManager.class, "")).getPskey(new String[]{str}, new sd2.a() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedDetailHttpUtil$querySPKeySuspend$2$1
            @Override // sd2.a
            public void onFail(@NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QLog.e("querySPKey", 2, "getPSKey onFail errMsg=" + errMsg);
                cancellableContinuationImpl.resume(new com.tencent.qqnt.msg.api.c<>("", 1, errMsg), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedDetailHttpUtil$querySPKeySuspend$2$1$onFail$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Throwable it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                        invoke2(th5);
                        return Unit.INSTANCE;
                    }
                });
            }

            @Override // sd2.a
            public void onSuccess(@NotNull Map<String, String> domainToKeyMap) {
                Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
                String str2 = domainToKeyMap.get(str);
                if (str2 == null) {
                    str2 = "";
                }
                QLog.e("querySPKey", 2, "getPSKey onSuccess");
                cancellableContinuationImpl.resume(new com.tencent.qqnt.msg.api.c<>(str2, 0, ""), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.guild.feed.util.GuildFeedDetailHttpUtil$querySPKeySuspend$2$1$onSuccess$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull Throwable it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                        invoke2(th5);
                        return Unit.INSTANCE;
                    }
                });
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @NotNull
    public final Map<String, String> c(@NotNull String url) {
        HashMap hashMapOf;
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(url, "url");
        boolean z16 = false;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("Content-Type", "application/json"), TuplesKt.to("Connection", "keep-alive"), TuplesKt.to("Accept", "*/*"), TuplesKt.to("Pragma", "no-cache"), TuplesKt.to(HttpHeader.RSP.CHARSET, "utf-8"), TuplesKt.to("Cache-Control", "no-cache"), TuplesKt.to("User-Agent", UA));
        String e16 = e(url);
        if (e16.length() > 0) {
            z16 = true;
        }
        if (!z16) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        hashMapOf.put("Cookie", e16);
        return hashMapOf;
    }

    @NotNull
    public final String d(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        if (!TextUtils.isEmpty(account)) {
            if (account.length() < 10) {
                StringBuilder sb5 = new StringBuilder("o");
                for (int length = account.length(); length < 10; length++) {
                    sb5.append("0");
                }
                sb5.append(account);
                String sb6 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "{\n                val sb\u2026.toString()\n            }");
                return sb6;
            }
            return "o" + account;
        }
        return account;
    }
}

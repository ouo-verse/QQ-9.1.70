package com.tencent.mobileqq.guild.quicksearch.resultview.dssearch;

import android.util.Log;
import com.tencent.mobileqq.guild.aisearch.SSESearchConfig;
import com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.q;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.util.AppSetting;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import mqq.app.MobileQQ;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.DSSearchDepositary$startSseRequest$1", f = "DSSearchDepositary.kt", i = {}, l = {285}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class DSSearchDepositary$startSseRequest$1 extends SuspendLambda implements Function2<ProducerScope<? super q>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $psKey;
    final /* synthetic */ String $searchKey;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DSSearchDepositary this$0;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f231661a;

        static {
            int[] iArr = new int[ProcessState.values().length];
            try {
                iArr[ProcessState.THINKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProcessState.IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f231661a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSSearchDepositary$startSseRequest$1$b", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProducerScope<q> f231662a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ DSSearchDepositary f231663b;

        /* JADX WARN: Multi-variable type inference failed */
        b(ProducerScope<? super q> producerScope, DSSearchDepositary dSSearchDepositary) {
            this.f231662a = producerScope;
            this.f231663b = dSSearchDepositary;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException e16) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e16, "e");
            Logger.f235387a.d().w("QQGuildInSearchTag.DSSearchDepositary", 1, "connectFailed " + e16);
            Object mo2003trySendJP2dKIU = this.f231662a.mo2003trySendJP2dKIU(new q.Failed("connectFailed " + e16));
            if (mo2003trySendJP2dKIU instanceof ChannelResult.Failed) {
                Throwable m2012exceptionOrNullimpl = ChannelResult.m2012exceptionOrNullimpl(mo2003trySendJP2dKIU);
                Logger.b bVar = new Logger.b();
                String str = "[flow] connectFailed failed " + m2012exceptionOrNullimpl;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("QQGuildInSearchTag.DSSearchDepositary", 1, (String) it.next(), null);
                }
            }
            CoroutineScopeKt.cancel(this.f231662a, new CancellationException("connectFailed " + e16));
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            BufferedSource bufferedSource;
            String str;
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("QQGuildInSearchTag.DSSearchDepositary", "onResponse " + response.code());
            }
            if (!response.isSuccessful()) {
                Logger.f235387a.d().i("QQGuildInSearchTag.DSSearchDepositary", 1, "onResponse\uff0cerror=" + response.code());
                Object mo2003trySendJP2dKIU = this.f231662a.mo2003trySendJP2dKIU(new q.Failed("onResponse\uff0cerror=" + response.code()));
                if (mo2003trySendJP2dKIU instanceof ChannelResult.Failed) {
                    Throwable m2012exceptionOrNullimpl = ChannelResult.m2012exceptionOrNullimpl(mo2003trySendJP2dKIU);
                    Logger.b bVar = new Logger.b();
                    String str2 = "[flow] onResponse failed " + m2012exceptionOrNullimpl;
                    if (str2 instanceof String) {
                        bVar.a().add(str2);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("QQGuildInSearchTag.DSSearchDepositary", 1, (String) it.next(), null);
                    }
                }
                CoroutineScopeKt.cancel(this.f231662a, new CancellationException("Response error " + response.code()));
                response.close();
                return;
            }
            ResponseBody body = response.body();
            if (body != null) {
                bufferedSource = body.getBodySource();
            } else {
                bufferedSource = null;
            }
            if (bufferedSource != null) {
                try {
                    DSSearchDepositary$startSseRequest$1.b(this.f231662a, this.f231663b, bufferedSource);
                    return;
                } catch (Exception e16) {
                    if (e16 instanceof IOException) {
                        str = "timeout";
                    } else {
                        str = "handleResponse error";
                    }
                    Object mo2003trySendJP2dKIU2 = this.f231662a.mo2003trySendJP2dKIU(new q.Failed(str));
                    if (mo2003trySendJP2dKIU2 instanceof ChannelResult.Failed) {
                        ChannelResult.m2012exceptionOrNullimpl(mo2003trySendJP2dKIU2);
                        Logger logger2 = Logger.f235387a;
                        Logger.b bVar2 = new Logger.b();
                        bVar2.a().add("[flow] exception");
                        Iterator<T> it5 = bVar2.a().iterator();
                        while (it5.hasNext()) {
                            Logger.f235387a.d().e("QQGuildInSearchTag.DSSearchDepositary", 1, (String) it5.next(), e16);
                        }
                    }
                    CoroutineScopeKt.cancel(this.f231662a, ExceptionsKt.CancellationException("Cancel handle response", e16));
                    return;
                }
            }
            Logger.f235387a.d().i("QQGuildInSearchTag.DSSearchDepositary", 1, "onResponse source is null");
            Object mo2003trySendJP2dKIU3 = this.f231662a.mo2003trySendJP2dKIU(new q.Failed("onResponse source is null"));
            if (mo2003trySendJP2dKIU3 instanceof ChannelResult.Failed) {
                Throwable m2012exceptionOrNullimpl2 = ChannelResult.m2012exceptionOrNullimpl(mo2003trySendJP2dKIU3);
                Logger.b bVar3 = new Logger.b();
                String str3 = "[flow] onResponse failed " + m2012exceptionOrNullimpl2;
                if (str3 instanceof String) {
                    bVar3.a().add(str3);
                }
                Iterator<T> it6 = bVar3.a().iterator();
                while (it6.hasNext()) {
                    Logger.f235387a.d().e("QQGuildInSearchTag.DSSearchDepositary", 1, (String) it6.next(), null);
                }
            }
            CoroutineScopeKt.cancel(this.f231662a, new CancellationException("Response body is null"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DSSearchDepositary$startSseRequest$1(DSSearchDepositary dSSearchDepositary, String str, String str2, Continuation<? super DSSearchDepositary$startSseRequest$1> continuation) {
        super(2, continuation);
        this.this$0 = dSSearchDepositary;
        this.$searchKey = str;
        this.$psKey = str2;
    }

    private static final boolean a(ProducerScope<? super q> producerScope, DSSearchDepositary dSSearchDepositary, String str) {
        String contentUUId;
        JSONObject jSONObject;
        String optString;
        String str2;
        boolean z16;
        boolean z17;
        ProcessState processState;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            contentUUId = jSONObject2.optString("id", "");
            jSONObject = jSONObject2.getJSONArray("choices").getJSONObject(0);
            optString = jSONObject.optString("finish_reason");
            str2 = null;
        } catch (Exception e16) {
            Logger.f235387a.d().w("QQGuildInSearchTag.DSSearchDepositary", 1, "\u89e3\u6790\u95ee\u7b54\u5b57\u7b26\u4e32\u5931\u8d25 " + str + "; " + e16.getMessage());
        }
        if (Intrinsics.areEqual(optString, "sensitive")) {
            producerScope.mo2003trySendJP2dKIU(new q.Failed("sensitive"));
            SendChannel.DefaultImpls.close$default(producerScope, null, 1, null);
            return true;
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject(EventListener.KEY_DELTA);
        String content = jSONObject3.optString("content", "");
        String it = jSONObject3.optString("reasoning_content", "");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str2 = it;
        }
        if (str2 != null) {
            dSSearchDepositary.processState = ProcessState.THINKING;
            Intrinsics.checkNotNullExpressionValue(contentUUId, "contentUUId");
            producerScope.mo2003trySendJP2dKIU(new q.ReceiveReasonContent(contentUUId, str2));
            Logger.f235387a.d().i("QQGuildInSearchTag.DSSearchDepositary", 1, "reasonContent succ " + str2);
        }
        Intrinsics.checkNotNullExpressionValue(content, "content");
        if (content.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            processState = dSSearchDepositary.processState;
            int i3 = a.f231661a[processState.ordinal()];
            if (i3 == 1 || i3 == 2) {
                producerScope.mo2003trySendJP2dKIU(q.c.f231712a);
                dSSearchDepositary.processState = ProcessState.CONTENT_PROCESSED;
            }
            Intrinsics.checkNotNullExpressionValue(contentUUId, "contentUUId");
            producerScope.mo2003trySendJP2dKIU(new q.ReceiveContent(contentUUId, content));
            Logger.f235387a.d().i("QQGuildInSearchTag.DSSearchDepositary", 1, "succ " + content);
        }
        if (Intrinsics.areEqual(optString, "stop")) {
            producerScope.mo2003trySendJP2dKIU(q.a.f231710a);
            producerScope.cancel(new CancellationException("FinishReason stop"));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x002a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(ProducerScope<? super q> producerScope, DSSearchDepositary dSSearchDepositary, BufferedSource bufferedSource) {
        boolean z16;
        boolean startsWith$default;
        CharSequence trim;
        boolean startsWith$default2;
        String removePrefix;
        boolean isBlank;
        producerScope.mo2003trySendJP2dKIU(q.e.f231715a);
        boolean z17 = true;
        int i3 = 0;
        while (!bufferedSource.exhausted() && CoroutineScopeKt.isActive(producerScope)) {
            String readUtf8Line = bufferedSource.readUtf8Line();
            if (readUtf8Line != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(readUtf8Line);
                if (!isBlank) {
                    z16 = false;
                    if (!z16) {
                        i3++;
                    } else {
                        Logger logger = Logger.f235387a;
                        if (QLog.isDevelopLevel()) {
                            Log.d("QQGuildInSearchTag.DSSearchDepositary", "receive lineIndex=" + i3 + " content=" + readUtf8Line);
                            i3++;
                        }
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(readUtf8Line, "data:{\"error\":", false, 2, null);
                        if (startsWith$default) {
                            Logger.f235387a.d().i("QQGuildInSearchTag.DSSearchDepositary", 1, "onResponse error=" + readUtf8Line);
                            String substring = readUtf8Line.substring(5);
                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                            trim = StringsKt__StringsKt.trim((CharSequence) substring);
                            producerScope.mo2003trySendJP2dKIU(new q.Failed(trim.toString()));
                            CoroutineScopeKt.cancel(producerScope, new CancellationException("Error: " + readUtf8Line));
                            return;
                        }
                        if (!Intrinsics.areEqual(readUtf8Line, "data:data: [DONE]")) {
                            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(readUtf8Line, "data:data: ", false, 2, null);
                            if (startsWith$default2) {
                                removePrefix = StringsKt__StringsKt.removePrefix(readUtf8Line, (CharSequence) "data:data: ");
                                if (z17) {
                                    z17 = false;
                                }
                                if (a(producerScope, dSSearchDepositary, removePrefix)) {
                                    return;
                                }
                            } else {
                                Logger.f235387a.d().w("QQGuildInSearchTag.DSSearchDepositary", 1, "onResponse error line=" + readUtf8Line);
                            }
                        } else {
                            Logger.f235387a.d().i("QQGuildInSearchTag.DSSearchDepositary", 1, "succ end");
                            producerScope.mo2003trySendJP2dKIU(q.a.f231710a);
                            producerScope.cancel(new CancellationException("Data done"));
                            return;
                        }
                    }
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
        if (bufferedSource.exhausted() && CoroutineScopeKt.isActive(producerScope)) {
            Logger.f235387a.d().i("QQGuildInSearchTag.DSSearchDepositary", 1, "source exhausted, consider completed");
            producerScope.mo2003trySendJP2dKIU(q.a.f231710a);
            producerScope.cancel(new CancellationException("Source exhausted"));
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DSSearchDepositary$startSseRequest$1 dSSearchDepositary$startSseRequest$1 = new DSSearchDepositary$startSseRequest$1(this.this$0, this.$searchKey, this.$psKey, continuation);
        dSSearchDepositary$startSseRequest$1.L$0 = obj;
        return dSSearchDepositary$startSseRequest$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String p16;
        String str;
        SSESearchConfig sSESearchConfig;
        int n3;
        String i3;
        String j3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        if (i16 != 0) {
            if (i16 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = (ProducerScope) this.L$0;
            MediaType mediaType = MediaType.INSTANCE.get("application/json; charset=utf-8");
            String uin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
            p16 = this.this$0.p(this.$searchKey);
            if (this.$psKey.length() >= 10) {
                str = this.$psKey.substring(0, 10);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            } else {
                str = this.$psKey;
            }
            Request.Builder builder = new Request.Builder();
            DSSearchDepositary dSSearchDepositary = this.this$0;
            sSESearchConfig = dSSearchDepositary.sseSearchConfig;
            String url = sSESearchConfig.getUrl();
            n3 = this.this$0.n(str);
            i3 = dSSearchDepositary.i(url, "g_tk", n3);
            Request.Builder addHeader = builder.url(i3).addHeader("Content-Type", "application/json");
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            Request.Builder addHeader2 = addHeader.addHeader("Uin", uin);
            j3 = this.this$0.j(uin, this.$psKey, str);
            Request build = addHeader2.addHeader("Cookie", j3).post(RequestBody.INSTANCE.create(p16, mediaType)).build();
            if (!AppSetting.isPublicVersion()) {
                Logger.f235387a.d().i("QQGuildInSearchTag.DSSearchDepositary", 1, "send requestBody=" + p16 + " ");
            }
            final Call newCall = this.this$0.getClient().newCall(build);
            newCall.enqueue(new b(producerScope, this.this$0));
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.DSSearchDepositary$startSseRequest$1.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Logger.f235387a.d().i("QQGuildInSearchTag.DSSearchDepositary", 1, "startSseRequest awaitClose");
                    Call.this.cancel();
                }
            };
            this.label = 1;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super q> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DSSearchDepositary$startSseRequest$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

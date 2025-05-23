package com.tencent.libra.download.lightquic;

import com.tencent.libra.download.d;
import com.tencent.libra.download.lightquic.LightQuicRequestCallback;
import com.tencent.lightquic.api.LightQUICRequest;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00062\u00020\u0001:\u0001\bB\u00a7\u0001\b\u0007\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010*\u001a\u00020%\u0012\u0006\u0010.\u001a\u00020+\u0012`\u00106\u001a\\\u0012\u0013\u0012\u00110%\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00020/\u0012\u0006\u00109\u001a\u000207\u0012\b\b\u0002\u0010;\u001a\u00020\u0014\u0012\b\b\u0002\u0010<\u001a\u00020\u000f\u00a2\u0006\u0004\b=\u0010>J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R,\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R \u0010 \u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-Rn\u00106\u001a\\\u0012\u0013\u0012\u00110%\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00109\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u00108R\u0014\u0010;\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010:\u00a8\u0006?"}, d2 = {"Lcom/tencent/libra/download/lightquic/RFWLightQuicSession;", "", "", "k", "", "rangeStart", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/lightquic/api/LightQUICRequest;", "a", "Lcom/tencent/lightquic/api/LightQUICRequest;", "quicRequest", "", "b", "I", "retriedCount", "", "c", "[B", "byteArray", "Lkotlin/Function3;", "", "Lcom/tencent/libra/download/lightquic/LightQuicRequestCallback$RequestResultCode;", "d", "Lkotlin/jvm/functions/Function3;", "onQuicFinished", "Lcom/tencent/libra/download/lightquic/LightQuicRequestCallback;", "e", "Lcom/tencent/libra/download/lightquic/LightQuicRequestCallback;", "l", "()Lcom/tencent/libra/download/lightquic/LightQuicRequestCallback;", "getRequestCallback$annotations", "()V", "requestCallback", "Lcom/tencent/libra/download/lightquic/a;", "f", "Lcom/tencent/libra/download/lightquic/a;", "lightQuic", "", "g", "Ljava/lang/String;", "localPath", h.F, "url", "Lkotlinx/coroutines/CoroutineDispatcher;", "i", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "success", "errorCode", "j", "Lkotlin/jvm/functions/Function4;", "onSessionFinished", "Lcom/tencent/libra/download/d;", "Lcom/tencent/libra/download/d;", "retryStrategy", "Z", "startImmediately", "initialByteArray", "<init>", "(Lcom/tencent/libra/download/lightquic/a;Ljava/lang/String;Ljava/lang/String;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function4;Lcom/tencent/libra/download/d;Z[B)V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class RFWLightQuicSession {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private LightQUICRequest quicRequest;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int retriedCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private byte[] byteArray;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Function3<Boolean, LightQuicRequestCallback.RequestResultCode, byte[], Unit> onQuicFinished;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LightQuicRequestCallback requestCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final a lightQuic;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final String localPath;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String url;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final CoroutineDispatcher coroutineDispatcher;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final Function4<String, Boolean, LightQuicRequestCallback.RequestResultCode, byte[], Unit> onSessionFinished;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final d retryStrategy;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final boolean startImmediately;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public RFWLightQuicSession(@NotNull a lightQuic, @NotNull String localPath, @NotNull String url, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Function4<? super String, ? super Boolean, ? super LightQuicRequestCallback.RequestResultCode, ? super byte[], Unit> onSessionFinished, @NotNull d retryStrategy, boolean z16, @NotNull byte[] initialByteArray) {
        Intrinsics.checkNotNullParameter(lightQuic, "lightQuic");
        Intrinsics.checkNotNullParameter(localPath, "localPath");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        Intrinsics.checkNotNullParameter(onSessionFinished, "onSessionFinished");
        Intrinsics.checkNotNullParameter(retryStrategy, "retryStrategy");
        Intrinsics.checkNotNullParameter(initialByteArray, "initialByteArray");
        this.lightQuic = lightQuic;
        this.localPath = localPath;
        this.url = url;
        this.coroutineDispatcher = coroutineDispatcher;
        this.onSessionFinished = onSessionFinished;
        this.retryStrategy = retryStrategy;
        this.startImmediately = z16;
        this.byteArray = initialByteArray;
        Function3<Boolean, LightQuicRequestCallback.RequestResultCode, byte[], Unit> function3 = new Function3<Boolean, LightQuicRequestCallback.RequestResultCode, byte[], Unit>() { // from class: com.tencent.libra.download.lightquic.RFWLightQuicSession$onQuicFinished$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, LightQuicRequestCallback.RequestResultCode requestResultCode, byte[] bArr) {
                invoke(bool.booleanValue(), requestResultCode, bArr);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z17, @NotNull LightQuicRequestCallback.RequestResultCode errorCode, @NotNull byte[] byteArray) {
                Function4 function4;
                String str;
                d dVar;
                int i3;
                Function4 function42;
                String str2;
                int i16;
                byte[] bArr;
                byte[] plus;
                Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                Intrinsics.checkNotNullParameter(byteArray, "byteArray");
                if (!z17) {
                    dVar = RFWLightQuicSession.this.retryStrategy;
                    i3 = RFWLightQuicSession.this.retriedCount;
                    if (!dVar.a(errorCode, i3)) {
                        function42 = RFWLightQuicSession.this.onSessionFinished;
                        str2 = RFWLightQuicSession.this.localPath;
                        function42.invoke(str2, Boolean.FALSE, errorCode, byteArray);
                        return;
                    }
                    RFWLightQuicSession rFWLightQuicSession = RFWLightQuicSession.this;
                    i16 = rFWLightQuicSession.retriedCount;
                    rFWLightQuicSession.retriedCount = i16 + 1;
                    RFWLightQuicSession rFWLightQuicSession2 = RFWLightQuicSession.this;
                    bArr = rFWLightQuicSession2.byteArray;
                    plus = ArraysKt___ArraysJvmKt.plus(bArr, byteArray);
                    rFWLightQuicSession2.byteArray = plus;
                    RFWLightQuicSession.this.m(byteArray.length);
                    return;
                }
                function4 = RFWLightQuicSession.this.onSessionFinished;
                str = RFWLightQuicSession.this.localPath;
                function4.invoke(str, Boolean.TRUE, errorCode, byteArray);
            }
        };
        this.onQuicFinished = function3;
        this.requestCallback = new LightQuicRequestCallback(function3);
        if (z16) {
            n(this, 0L, 1, null);
        }
    }

    public static /* synthetic */ void n(RFWLightQuicSession rFWLightQuicSession, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        rFWLightQuicSession.m(j3);
    }

    public final void k() {
        LightQUICRequest lightQUICRequest = this.quicRequest;
        if (lightQUICRequest != null) {
            this.lightQuic.b(lightQUICRequest);
        }
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final LightQuicRequestCallback getRequestCallback() {
        return this.requestCallback;
    }

    public final void m(long rangeStart) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.coroutineDispatcher), null, null, new RFWLightQuicSession$startRequest$1(this, rangeStart, null), 3, null);
    }

    public /* synthetic */ RFWLightQuicSession(a aVar, String str, String str2, CoroutineDispatcher coroutineDispatcher, Function4 function4, d dVar, boolean z16, byte[] bArr, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, str, str2, coroutineDispatcher, function4, dVar, (i3 & 64) != 0 ? true : z16, (i3 & 128) != 0 ? new byte[0] : bArr);
    }
}

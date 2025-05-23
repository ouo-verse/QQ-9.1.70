package com.tencent.timi.game.sso.request;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.sail.c;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ur4.k;
import ur4.l;
import ur4.m;
import ur4.o;
import ur4.p;
import ur4.q;
import ur4.s;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u0017*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0018B'\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J!\u0010\n\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/timi/game/sso/request/QQLiveSendBarrageDataRequest;", "T", "Lcom/tencent/timi/game/sso/request/QQLiveBaseRequest;", "", "getMainCmd", "getSubCmd", "Lur4/o;", "getMessageNano", "", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "_message", "Ljava/lang/String;", "", "_roomId", "J", "", "_flutterChatId", "I", "_msgId", "<init>", "(Ljava/lang/String;JILjava/lang/String;)V", "Companion", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveSendBarrageDataRequest<T> extends QQLiveBaseRequest<T> {
    private final int _flutterChatId;

    @NotNull
    private final String _message;

    @NotNull
    private final String _msgId;
    private final long _roomId;

    public QQLiveSendBarrageDataRequest(@NotNull String _message, long j3, int i3, @NotNull String _msgId) {
        Intrinsics.checkNotNullParameter(_message, "_message");
        Intrinsics.checkNotNullParameter(_msgId, "_msgId");
        this._message = _message;
        this._roomId = j3;
        this._flutterChatId = i3;
        this._msgId = _msgId;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        try {
            return (T) p.c(convertInputStreamtoByteArray);
        } catch (InvalidProtocolBufferNanoException e16) {
            AegisLogger.INSTANCE.e(AegisLogger.AUDIENCE, "QQLiveSendFlutterChatRequest", "[decode] decode error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    /* renamed from: getMainCmd */
    public String getService() {
        return "trpc.qlive.word_svr.WordSvr";
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    /* renamed from: getSubCmd */
    public String getMethod() {
        return "SendFlutterChat";
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public o getMessageNano() {
        o oVar = new o();
        oVar.f439945b = this._flutterChatId;
        oVar.f439946c = this._roomId;
        oVar.f439947d = this._msgId;
        m mVar = new m();
        long j3 = this._roomId;
        mVar.f439933a = j3;
        mVar.f439934b = j3;
        k kVar = new k();
        l lVar = new l();
        lVar.f439929a = 1;
        q qVar = new q();
        byte[] bytes = this._message.getBytes(Charsets.UTF_16LE);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        qVar.f439951a = bytes;
        lVar.f439930b = qVar;
        Unit unit = Unit.INSTANCE;
        kVar.f439925a = new l[]{lVar};
        s sVar = new s();
        c cVar = c.f272176a;
        sVar.f439954a = cVar.G();
        LiveLoginInfo u16 = cVar.u();
        sVar.f439955b = u16 != null ? u16.m() : null;
        LiveLoginInfo u17 = cVar.u();
        sVar.f439958e = u17 != null ? u17.k() : null;
        LiveLoginInfo u18 = cVar.u();
        sVar.f439956c = u18 != null ? u18.j() : null;
        kVar.f439927c = sVar;
        kVar.f439926b = new ur4.c[0];
        mVar.f439935c = kVar;
        oVar.f439944a = mVar;
        return oVar;
    }
}

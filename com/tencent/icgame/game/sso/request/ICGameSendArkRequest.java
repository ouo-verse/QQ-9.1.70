package com.tencent.icgame.game.sso.request;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest;
import com.tencent.util.QQCustomArkDialogUtil;
import d32.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import lp4.b;
import lp4.d;
import lp4.f;
import lp4.g;
import lp4.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 \u0017*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0018B'\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J!\u0010\n\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/icgame/game/sso/request/ICGameSendArkRequest;", "T", "Lcom/tencent/mobileqq/icgame/api/sso/LiveBaseRequest;", "", "getMainCmd", "getSubCmd", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "", "resBytes", "decode", "([B)Ljava/lang/Object;", "", "uinType", "I", "", "uin", "J", QQCustomArkDialogUtil.META_DATA, "Ljava/lang/String;", "promptStr", "<init>", "(IJLjava/lang/String;Ljava/lang/String;)V", "Companion", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class ICGameSendArkRequest<T> extends LiveBaseRequest<T> {

    @NotNull
    private final String metaData;

    @NotNull
    private final String promptStr;
    private final long uin;
    private final int uinType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ICGameSendArkRequest(int i3, long j3, @NotNull String metaData, @NotNull String promptStr) {
        super(c.f392737b.a().getAppId());
        Intrinsics.checkNotNullParameter(metaData, "metaData");
        Intrinsics.checkNotNullParameter(promptStr, "promptStr");
        this.uinType = i3;
        this.uin = j3;
        this.metaData = metaData;
        this.promptStr = promptStr;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] resBytes) {
        try {
            return (T) h.c(resBytes);
        } catch (InvalidProtocolBufferNanoException e16) {
            a.INSTANCE.i("ICGameVSRequest|ICGameOnlinePlayerRequest", "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public String getMainCmd() {
        return "trpc.icggame.ark_msg.ArkMsg";
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        g gVar = new g();
        lp4.a aVar = new lp4.a();
        aVar.f415353a = "com.tencent.tuwen.lua";
        aVar.f415354b = "icgame.gameshare";
        byte[] bytes = this.metaData.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        aVar.f415355c = bytes;
        aVar.f415356d = this.promptStr;
        gVar.f415369a = aVar;
        f fVar = new f();
        if (this.uinType == 1) {
            d dVar = new d();
            dVar.f415362a = this.uin;
            fVar.f415368d = dVar;
        } else {
            b bVar = new b();
            bVar.f415357a = this.uin;
            fVar.f415367c = bVar;
        }
        gVar.f415370b = fVar;
        return gVar;
    }

    @Override // com.tencent.mobileqq.icgame.api.sso.LiveBaseRequest
    @NotNull
    public String getSubCmd() {
        return "SendArk";
    }
}

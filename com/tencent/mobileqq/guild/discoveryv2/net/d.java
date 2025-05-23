package com.tencent.mobileqq.guild.discoveryv2.net;

import com.tencent.mobileqq.guild.discoveryv2.net.e;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProTabContentCommonRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.eu;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B]\u0012\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0002\b\u000e\u0012\u0019\u0010\u0015\u001a\u0015\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00130\f\u00a2\u0006\u0002\b\u000e\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\u0012\u0012\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u001c\"\u00020\u001d\u00a2\u0006\u0004\b(\u0010)J\u000f\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR(\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0002\b\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R*\u0010\u0015\u001a\u0015\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00130\f\u00a2\u0006\u0002\b\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001f\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0\u001c8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010'\u001a\u00028\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0005\"\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/net/d;", "Req", "Rsp", "Lcom/tencent/mobileqq/guild/discoveryv2/net/e;", "b", "()Ljava/lang/Object;", "a", "req", "rsp", "", "d", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/eu;", "Lkotlin/ExtensionFunctionType;", "Lkotlin/jvm/functions/Function1;", "getCommonReq", "()Lkotlin/jvm/functions/Function1;", "commonReq", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProTabContentCommonRsp;", "getCommonRsp", "commonRsp", "Lkotlin/Function0;", "c", "Lkotlin/jvm/functions/Function0;", "getConstructor", "()Lkotlin/jvm/functions/Function0;", "constructor", "", "Lcom/tencent/mobileqq/guild/discoveryv2/net/f;", "[Lcom/tencent/mobileqq/guild/discoveryv2/net/f;", "getDecorators", "()[Lcom/tencent/mobileqq/guild/discoveryv2/net/f;", "decorators", "e", "Ljava/lang/Object;", "getReqContext", "setReqContext", "(Ljava/lang/Object;)V", "reqContext", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;[Lcom/tencent/mobileqq/guild/discoveryv2/net/f;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d<Req, Rsp> implements e<Req, Rsp> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Req, eu> commonReq;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Rsp, IGProTabContentCommonRsp> commonRsp;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Req> constructor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f[] decorators;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Req reqContext;

    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull Function1<? super Req, ? extends eu> commonReq, @NotNull Function1<? super Rsp, ? extends IGProTabContentCommonRsp> commonRsp, @NotNull Function0<? extends Req> constructor, @NotNull f... decorators) {
        Intrinsics.checkNotNullParameter(commonReq, "commonReq");
        Intrinsics.checkNotNullParameter(commonRsp, "commonRsp");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(decorators, "decorators");
        this.commonReq = commonReq;
        this.commonRsp = commonRsp;
        this.constructor = constructor;
        this.decorators = decorators;
        this.reqContext = (Req) constructor.invoke();
    }

    public Req a() {
        eu invoke = this.commonReq.invoke(this.reqContext);
        for (f fVar : this.decorators) {
            fVar.a(invoke);
        }
        return this.reqContext;
    }

    public Req b() {
        Req invoke = this.constructor.invoke();
        this.reqContext = invoke;
        eu invoke2 = this.commonReq.invoke(invoke);
        for (f fVar : this.decorators) {
            fVar.c(invoke2);
        }
        return this.reqContext;
    }

    public void c() {
        e.a.a(this);
    }

    public void d(Req req, Rsp rsp) {
        IGProTabContentCommonRsp invoke = this.commonRsp.invoke(rsp);
        if (invoke == null) {
            return;
        }
        for (f fVar : this.decorators) {
            fVar.b(this.commonReq.invoke(req), invoke);
        }
    }
}

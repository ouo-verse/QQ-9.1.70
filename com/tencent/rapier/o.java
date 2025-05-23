package com.tencent.rapier;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\tR\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/rapier/o;", "T", "Lcom/tencent/rapier/a;", "Lcom/tencent/rapier/b;", "callback", "", "a", "Lcom/tencent/rapier/d;", "", "Lcom/tencent/rapier/d;", "requestConverter", "b", "responseConverter", "Lcom/tencent/rapier/k;", "c", "Lcom/tencent/rapier/k;", "rapier", "Ljava/lang/reflect/Method;", "d", "Ljava/lang/reflect/Method;", "method", "", "", "e", "[Ljava/lang/Object;", "args", "Lcom/tencent/rapier/m;", "f", "Lcom/tencent/rapier/m;", "requestFactory", "Lcom/tencent/rapier/e;", "g", "Lcom/tencent/rapier/e;", "converterFactory", "<init>", "(Lcom/tencent/rapier/k;Ljava/lang/reflect/Method;[Ljava/lang/Object;Lcom/tencent/rapier/m;Lcom/tencent/rapier/e;)V", "rapier_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class o<T> implements com.tencent.rapier.a<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private d<T, byte[]> requestConverter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private d<byte[], T> responseConverter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final k rapier;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Method method;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Object[] args;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final m requestFactory;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final e<T> converterFactory;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J#\u0010\r\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"com/tencent/rapier/o$a", "Lcom/tencent/rapier/g;", "", "rspData", "", "", "params", "", "b", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "rapier_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class a implements g {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f364088b;

        a(b bVar) {
            this.f364088b = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) o.this, (Object) bVar);
            }
        }

        @Override // com.tencent.rapier.g
        public void a(@Nullable Integer errCode, @Nullable String errMsg) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) errCode, (Object) errMsg);
                return;
            }
            b bVar = this.f364088b;
            if (bVar != null) {
                if (errCode != null) {
                    i3 = errCode.intValue();
                } else {
                    i3 = -1;
                }
                if (errMsg == null) {
                    errMsg = "";
                }
                bVar.onFailure(i3, errMsg);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.rapier.g
        public void b(@Nullable byte[] rspData, @NotNull Map<Object, ? extends Object> params) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) rspData, (Object) params);
                return;
            }
            Intrinsics.checkNotNullParameter(params, "params");
            if (rspData == null) {
                b bVar = this.f364088b;
                if (bVar != null) {
                    bVar.onFailure(-1, "find rsp is null");
                    return;
                }
                return;
            }
            Object convert = o.this.responseConverter.convert(rspData);
            b bVar2 = this.f364088b;
            if (bVar2 != 0) {
                bVar2.onSuccess(convert);
            }
        }
    }

    public o(@NotNull k rapier, @NotNull Method method, @NotNull Object[] args, @NotNull m requestFactory, @NotNull e<T> converterFactory) {
        Intrinsics.checkNotNullParameter(rapier, "rapier");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        Intrinsics.checkNotNullParameter(converterFactory, "converterFactory");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, rapier, method, args, requestFactory, converterFactory);
            return;
        }
        this.rapier = rapier;
        this.method = method;
        this.args = args;
        this.requestFactory = requestFactory;
        this.converterFactory = converterFactory;
        Type genericReturnType = method.getGenericReturnType();
        p pVar = p.f364089a;
        if (genericReturnType != null) {
            Type a16 = pVar.a(0, (ParameterizedType) genericReturnType);
            this.requestConverter = converterFactory.a(rapier, a16);
            this.responseConverter = converterFactory.b(rapier, a16);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
    }

    @Override // com.tencent.rapier.a
    public void a(@Nullable b<T> callback) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) callback);
            return;
        }
        Object[] objArr = this.args;
        int i3 = 0;
        if (objArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Object obj = objArr[0];
            if (!(obj instanceof MessageNano)) {
                if (callback != null) {
                    callback.onFailure(-1, "find req is not a MessageNano");
                    return;
                }
                return;
            }
            String c16 = this.requestFactory.c();
            String b16 = this.requestFactory.b();
            byte[] bArr = (byte[]) this.requestConverter.convert(obj);
            l lVar = l.f364071b;
            if (lVar.a() == null) {
                if (callback != null) {
                    callback.onFailure(-1, "find network delegate is null, please set delegate first");
                    return;
                }
                return;
            }
            Object[] objArr2 = this.args;
            if (objArr2.length >= 2) {
                Object obj2 = objArr2[1];
                if (obj2 != null) {
                    i3 = ((Integer) obj2).intValue();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
            }
            int i16 = i3;
            f a16 = lVar.a();
            if (a16 != null) {
                a16.a(c16, b16, bArr, this.rapier.c(), i16, new a(callback));
                return;
            }
            return;
        }
        throw InvalidMethodException.INSTANCE.a();
    }
}

package com.tencent.mobileqq.qne.utils.network;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0003B3\b\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u0082\u0001\u0001\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qne/utils/network/f;", "T", "", "a", "Ljava/lang/Object;", "()Ljava/lang/Object;", "data", "", "b", "I", "getSsoErrorCode", "()I", "ssoErrorCode", "c", "getTrpcErrorCode", "trpcErrorCode", "", "d", "Ljava/lang/String;", "getTrpcErrorMsg", "()Ljava/lang/String;", "trpcErrorMsg", "<init>", "(Ljava/lang/Object;IILjava/lang/String;)V", "Lcom/tencent/mobileqq/qne/utils/network/f$a;", "qne-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class f<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final T data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int ssoErrorCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int trpcErrorCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String trpcErrorMsg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\u00020\u0003B1\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0001\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qne/utils/network/f$a;", "T", "Lcom/tencent/mobileqq/qne/utils/network/f;", "", "data", "", "ssoErrorCode", "trpcErrorCode", "", "trpcErrorMsg", "<init>", "(Ljava/lang/Object;IILjava/lang/String;)V", "qne-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static class a<T> extends f<T> {
        static IPatchRedirector $redirector_;

        public a(@Nullable T t16, int i3, int i16, @Nullable String str) {
            super(t16, i3, i16, str, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, t16, Integer.valueOf(i3), Integer.valueOf(i16), str);
            }
        }
    }

    public /* synthetic */ f(Object obj, int i3, int i16, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, i3, i16, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, this, obj, Integer.valueOf(i3), Integer.valueOf(i16), str, defaultConstructorMarker);
    }

    @Nullable
    public final T a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.data;
    }

    f(T t16, int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, t16, Integer.valueOf(i3), Integer.valueOf(i16), str);
            return;
        }
        this.data = t16;
        this.ssoErrorCode = i3;
        this.trpcErrorCode = i16;
        this.trpcErrorMsg = str;
    }
}

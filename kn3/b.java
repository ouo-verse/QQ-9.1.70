package kn3;

import com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ln3.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lkn3/b;", "", "a", "b", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lkn3/b$a;", "", "", "service", "method", "Lln3/a;", "a", "", "ERR_TIMEOUT", "I", "MSG_TIMEOUT", "Ljava/lang/String;", "<init>", "()V", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kn3.b$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ln3.a a(@NotNull String service, @NotNull String method) {
            Intrinsics.checkNotNullParameter(service, "service");
            Intrinsics.checkNotNullParameter(method, "method");
            return new C10670b(service, method);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lkn3/b$b;", "Lln3/a;", "", "reqData", "Lln3/a$a;", "callback", "", "a", "", "Ljava/lang/String;", "service", "b", "method", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "c", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kn3.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    private static final class C10670b implements ln3.a {

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private static final a f412726c = new a(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String service;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String method;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lkn3/b$b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: kn3.b$b$a */
        /* loaded from: classes22.dex */
        private static final class a {
            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            a() {
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"kn3/b$b$b", "Lcom/tencent/mobileqq/qqlive/callback/sso/IQQLiveProxySsoObserver;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "qq-live-od-logic-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: kn3.b$b$b, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        public static final class C10671b implements IQQLiveProxySsoObserver {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ a.InterfaceC10739a f412729a;

            C10671b(a.InterfaceC10739a interfaceC10739a) {
                this.f412729a = interfaceC10739a;
            }

            @Override // com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver
            public void onFail(int errCode, @Nullable String errMsg) {
                this.f412729a.onFail(errCode, errMsg);
            }

            @Override // com.tencent.mobileqq.qqlive.callback.sso.IQQLiveProxySsoObserver
            public void onReceive(@Nullable byte[] data) {
                this.f412729a.onReceive(data);
            }
        }

        public C10670b(@NotNull String service, @NotNull String method) {
            Intrinsics.checkNotNullParameter(service, "service");
            Intrinsics.checkNotNullParameter(method, "method");
            this.service = service;
            this.method = method;
        }

        @Override // ln3.a
        public void a(@NotNull byte[] reqData, @NotNull a.InterfaceC10739a callback) {
            Intrinsics.checkNotNullParameter(reqData, "reqData");
            Intrinsics.checkNotNullParameter(callback, "callback");
            com.tencent.now.od.cs.b.a(this.service, this.method, reqData, new C10671b(callback));
        }
    }
}

package com.tencent.crossengine.debugJs;

import com.tencent.crossengine.debugJs.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000#\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\b\u0007*\u0001\u000e\u0018\u0000 \u00132\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u0082 J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/crossengine/debugJs/InspectorBridge;", "", "", "nativeCreate", "Lcom/tencent/crossengine/debugJs/a;", "proxy", "", "c", "a", "J", "nativeInstance", "b", "Lcom/tencent/crossengine/debugJs/a;", "mProxy", "com/tencent/crossengine/debugJs/InspectorBridge$b", "Lcom/tencent/crossengine/debugJs/InspectorBridge$b;", "debugMessageListener", "<init>", "()V", "d", "library_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes32.dex */
public final class InspectorBridge {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long nativeInstance;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private a mProxy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final b debugMessageListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0083 R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/crossengine/debugJs/InspectorBridge$a;", "", "", "nativeInstance", "", "message", "", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "library_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.crossengine.debugJs.InspectorBridge$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void b(long nativeInstance, String message) {
            InspectorBridge.sendMessageToEngine(nativeInstance, message);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"com/tencent/crossengine/debugJs/InspectorBridge$b", "Lcom/tencent/crossengine/debugJs/a$a;", "", "message", "", "sendMessageToEngine", "a", "Lcom/tencent/crossengine/debugJs/a$a;", "getReal", "()Lcom/tencent/crossengine/debugJs/a$a;", "setReal", "(Lcom/tencent/crossengine/debugJs/a$a;)V", "real", "library_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes32.dex */
    public static final class b implements a.InterfaceC1022a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private a.InterfaceC1022a real = new a();

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/crossengine/debugJs/InspectorBridge$b$a", "Lcom/tencent/crossengine/debugJs/a$a;", "", "message", "", "sendMessageToEngine", "library_release"}, k = 1, mv = {1, 4, 0})
        /* loaded from: classes32.dex */
        public static final class a implements a.InterfaceC1022a {
            a() {
            }

            @Override // com.tencent.crossengine.debugJs.a.InterfaceC1022a
            public void sendMessageToEngine(String message) {
                Intrinsics.checkParameterIsNotNull(message, "message");
                try {
                    InspectorBridge.INSTANCE.b(InspectorBridge.this.nativeInstance, message);
                    Unit unit = Unit.INSTANCE;
                } catch (UnsatisfiedLinkError unused) {
                    InspectorBridge.INSTANCE.b(InspectorBridge.this.nativeInstance, message);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }

        b() {
        }

        @Override // com.tencent.crossengine.debugJs.a.InterfaceC1022a
        public void sendMessageToEngine(String message) {
            Intrinsics.checkParameterIsNotNull(message, "message");
            a.InterfaceC1022a interfaceC1022a = this.real;
            if (interfaceC1022a != null) {
                interfaceC1022a.sendMessageToEngine(message);
            }
        }
    }

    public InspectorBridge() {
        long nativeCreate;
        try {
            nativeCreate = nativeCreate();
        } catch (UnsatisfiedLinkError unused) {
            nativeCreate = nativeCreate();
        }
        this.nativeInstance = nativeCreate;
        this.debugMessageListener = new b();
    }

    private final native long nativeCreate();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void sendMessageToEngine(long j3, String str);

    public final void c(a proxy) {
        Intrinsics.checkParameterIsNotNull(proxy, "proxy");
        this.mProxy = proxy;
        proxy.a(this.debugMessageListener);
    }
}

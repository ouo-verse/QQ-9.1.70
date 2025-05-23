package com.tencent.qqmini.minigame.dynamic;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqmini.minigame.dynamic.client.ClientHandler;
import com.tencent.qqmini.minigame.dynamic.context.ClientMethod;
import com.tencent.qqmini.minigame.dynamic.context.DynamicPluginDexHandler;
import com.tencent.qqmini.minigame.dynamic.context.ServerMethod;
import com.tencent.qqmini.minigame.dynamic.extension.ModuleExportException;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u0018B\u000f\u0012\u0006\u00108\u001a\u000204\u00a2\u0006\u0004\b9\u0010:J\"\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H\u0002J\"\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H\u0002J4\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0016\u0010\u0018\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u000b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u000eH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0016J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u000bR\u0014\u0010 \u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010\u001fR\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+RX\u00103\u001aF\u0012B\u0012@\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b/\u0012\b\b\u001d\u0012\u0004\b\b(0\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u00a2\u0006\f\b/\u0012\b\b\u001d\u0012\u0004\b\b(\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010.j\u0002`10-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u00102R\u0017\u00108\u001a\u0002048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u00105\u001a\u0004\b6\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/qqmini/minigame/dynamic/DynamicCore;", "", "Lcom/tencent/qqmini/minigame/dynamic/b;", "Lcom/tencent/qqmini/minigame/dynamic/context/ClientMethod;", "method", "", "args", DomainData.DOMAIN_NAME, "f", "Landroid/content/Context;", "context", "", "contextCode", "pluginName", "", "params", "", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "k", "Lkotlin/Function0;", "Lcom/tencent/qqmini/minigame/dynamic/client/b;", "creator", "a", "data", h.F, "ext", "g", "name", "i", "Ljava/lang/String;", "instanceId", "Lcom/tencent/qqmini/minigame/dynamic/context/DynamicPluginDexHandler;", "b", "Lcom/tencent/qqmini/minigame/dynamic/context/DynamicPluginDexHandler;", "contextHandler", "Lcom/tencent/qqmini/minigame/dynamic/client/ClientHandler;", "c", "Lcom/tencent/qqmini/minigame/dynamic/client/ClientHandler;", "clientHandler", "d", "e", "Lkotlin/jvm/functions/Function0;", "clientExportCreator", "Landroid/util/SparseArray;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "methodId", "Lcom/tencent/qqmini/minigame/dynamic/context/DynamicClientMethodCallback;", "Landroid/util/SparseArray;", "clientMethodRegistry", "Lcom/tencent/qqmini/minigame/dynamic/a;", "Lcom/tencent/qqmini/minigame/dynamic/a;", "getDelegate", "()Lcom/tencent/qqmini/minigame/dynamic/a;", "delegate", "<init>", "(Lcom/tencent/qqmini/minigame/dynamic/a;)V", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class DynamicCore implements com.tencent.qqmini.minigame.dynamic.b {

    /* renamed from: h, reason: collision with root package name */
    private static long f346365h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String instanceId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private DynamicPluginDexHandler contextHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ClientHandler clientHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String pluginName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Function0<? extends com.tencent.qqmini.minigame.dynamic.client.b> clientExportCreator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final SparseArray<Function2<ClientMethod, List<? extends Object>, Object>> clientMethodRegistry;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a delegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002@\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001j\u0002`\tJ#\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqmini/minigame/dynamic/DynamicCore$b", "Lkotlin/Function2;", "Lcom/tencent/qqmini/minigame/dynamic/context/ClientMethod;", "Lkotlin/ParameterName;", "name", "methodId", "", "", "args", "Lcom/tencent/qqmini/minigame/dynamic/context/DynamicClientMethodCallback;", "a", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes23.dex */
    public static final class b implements Function2<ClientMethod, List<? extends Object>, Object> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object invoke(@NotNull ClientMethod methodId, @NotNull List<? extends Object> args) {
            Intrinsics.checkParameterIsNotNull(methodId, "methodId");
            Intrinsics.checkParameterIsNotNull(args, "args");
            return DynamicCore.this.f(methodId, args);
        }
    }

    public DynamicCore(@NotNull a delegate) {
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        this.delegate = delegate;
        long j3 = f346365h;
        f346365h = 1 + j3;
        this.instanceId = String.valueOf(j3);
        this.clientMethodRegistry = new SparseArray<>();
        delegate.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(ClientMethod method, List<? extends Object> args) {
        Function1<Object, Unit> function1;
        ClientHandler clientHandler;
        String str;
        boolean z16;
        final String str2 = (String) iu3.a.b(args);
        if (str2 != null) {
            if (str2.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                function1 = new Function1<Object, Unit>() { // from class: com.tencent.qqmini.minigame.dynamic.DynamicCore$callClientMethod$callback$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                        invoke2(obj);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Object obj) {
                        DynamicPluginDexHandler dynamicPluginDexHandler;
                        String str3;
                        List<? extends Object> listOf;
                        dynamicPluginDexHandler = DynamicCore.this.contextHandler;
                        if (dynamicPluginDexHandler != null) {
                            ServerMethod serverMethod = ServerMethod.ServerMethodFireCallback;
                            str3 = DynamicCore.this.instanceId;
                            listOf = CollectionsKt__CollectionsKt.listOf(str3, str2, obj);
                            dynamicPluginDexHandler.call(serverMethod, listOf);
                        }
                    }
                };
                clientHandler = this.clientHandler;
                if (clientHandler == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("clientHandler");
                }
                str = this.pluginName;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pluginName");
                }
                return clientHandler.c(str, (String) iu3.a.g(args), iu3.a.d(args), function1);
            }
        }
        function1 = null;
        clientHandler = this.clientHandler;
        if (clientHandler == null) {
        }
        str = this.pluginName;
        if (str == null) {
        }
        return clientHandler.c(str, (String) iu3.a.g(args), iu3.a.d(args), function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object n(ClientMethod method, List<? extends Object> args) {
        Function2<ClientMethod, List<? extends Object>, Object> function2 = this.clientMethodRegistry.get(method.getValue());
        if (function2 != null) {
            return function2.invoke(method, args);
        }
        return null;
    }

    @Override // com.tencent.qqmini.minigame.dynamic.b
    public void a(@NotNull Function0<? extends com.tencent.qqmini.minigame.dynamic.client.b> creator) {
        Intrinsics.checkParameterIsNotNull(creator, "creator");
        this.clientExportCreator = creator;
    }

    @Nullable
    public Object g(@NotNull String method, @Nullable Object params, @Nullable Object ext) {
        List<? extends Object> listOf;
        Intrinsics.checkParameterIsNotNull(method, "method");
        DynamicPluginDexHandler dynamicPluginDexHandler = this.contextHandler;
        if (dynamicPluginDexHandler != null) {
            ServerMethod serverMethod = ServerMethod.ServerMethodCallModuleMethod;
            listOf = CollectionsKt__CollectionsKt.listOf(this.instanceId, method, params, ext);
            return dynamicPluginDexHandler.call(serverMethod, listOf);
        }
        return null;
    }

    @Nullable
    public Object h(@NotNull String method, @NotNull Map<String, ? extends Object> data) {
        Intrinsics.checkParameterIsNotNull(method, "method");
        Intrinsics.checkParameterIsNotNull(data, "data");
        return g(method, data, null);
    }

    @NotNull
    public final com.tencent.qqmini.minigame.dynamic.client.b i(@NotNull String name) {
        com.tencent.qqmini.minigame.dynamic.client.b invoke;
        Intrinsics.checkParameterIsNotNull(name, "name");
        Function0<? extends com.tencent.qqmini.minigame.dynamic.client.b> function0 = this.clientExportCreator;
        if (function0 != null && (invoke = function0.invoke()) != null) {
            return invoke;
        }
        throw new ModuleExportException("can not find moduleExport, name: " + name);
    }

    public void j(@NotNull Context context, @NotNull String contextCode, @NotNull String pluginName, @NotNull Map<String, ? extends Object> params) {
        List<? extends Object> listOf;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(contextCode, "contextCode");
        Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
        Intrinsics.checkParameterIsNotNull(params, "params");
        this.pluginName = pluginName;
        this.contextHandler = new DynamicPluginDexHandler();
        String library = context.getApplicationInfo().nativeLibraryDir;
        QMLog.i("DynamicCore", "init contextCode:" + contextCode + ", pluginName:" + pluginName + " library:" + library);
        DynamicPluginDexHandler dynamicPluginDexHandler = this.contextHandler;
        if (dynamicPluginDexHandler == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(library, "library");
        dynamicPluginDexHandler.init(contextCode, pluginName, library);
        DynamicPluginDexHandler dynamicPluginDexHandler2 = this.contextHandler;
        if (dynamicPluginDexHandler2 == null) {
            Intrinsics.throwNpe();
        }
        dynamicPluginDexHandler2.setCallClient(new Function2<ClientMethod, List<? extends Object>, Object>() { // from class: com.tencent.qqmini.minigame.dynamic.DynamicCore$onAttach$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull ClientMethod method, @NotNull List<? extends Object> args) {
                Object n3;
                Intrinsics.checkParameterIsNotNull(method, "method");
                Intrinsics.checkParameterIsNotNull(args, "args");
                n3 = DynamicCore.this.n(method, args);
                return n3;
            }
        });
        this.clientHandler = new ClientHandler(this);
        this.clientMethodRegistry.put(ClientMethod.ClientMethodCallModuleMethod.getValue(), new b());
        DynamicPluginDexHandler dynamicPluginDexHandler3 = this.contextHandler;
        if (dynamicPluginDexHandler3 == null) {
            Intrinsics.throwNpe();
        }
        ServerMethod serverMethod = ServerMethod.ServerCreateInstance;
        listOf = CollectionsKt__CollectionsKt.listOf(this.instanceId, pluginName, params);
        dynamicPluginDexHandler3.call(serverMethod, listOf);
    }

    public void k() {
        List<? extends Object> listOf;
        DynamicPluginDexHandler dynamicPluginDexHandler = this.contextHandler;
        if (dynamicPluginDexHandler != null) {
            ServerMethod serverMethod = ServerMethod.ServerDestroyInstance;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(this.instanceId);
            dynamicPluginDexHandler.call(serverMethod, listOf);
        }
        DynamicPluginDexHandler dynamicPluginDexHandler2 = this.contextHandler;
        if (dynamicPluginDexHandler2 != null) {
            dynamicPluginDexHandler2.destroy();
        }
    }

    public void l() {
        Map mapOf;
        List<? extends Object> listOf;
        DynamicPluginDexHandler dynamicPluginDexHandler = this.contextHandler;
        if (dynamicPluginDexHandler != null) {
            ServerMethod serverMethod = ServerMethod.ServerUpdateInstance;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("didDisappear", "1"));
            listOf = CollectionsKt__CollectionsKt.listOf(this.instanceId, "didDisappear", mapOf);
            dynamicPluginDexHandler.call(serverMethod, listOf);
        }
    }

    public void m() {
        Map mapOf;
        List<? extends Object> listOf;
        DynamicPluginDexHandler dynamicPluginDexHandler = this.contextHandler;
        if (dynamicPluginDexHandler != null) {
            ServerMethod serverMethod = ServerMethod.ServerUpdateInstance;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("didAppear", "1"));
            listOf = CollectionsKt__CollectionsKt.listOf(this.instanceId, "didAppear", mapOf);
            dynamicPluginDexHandler.call(serverMethod, listOf);
        }
    }
}

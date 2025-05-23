package com.tencent.qqmini.minigame.dynamic.context;

import com.tencent.qqmini.minigame.dynamic.IDynamicEntry;
import com.tencent.qqmini.minigame.dynamic.context.DynamicDexClassLoader;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import iu3.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*JN\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0002J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\"\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u00152\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017H\u0016JN\u0010 \u001a\u00020\u00122D\u0010\u001f\u001a@\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0004\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aj\u0002`\u001eH\u0016JN\u0010!\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&RX\u0010'\u001aD\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0004\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001aj\u0004\u0018\u0001`\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqmini/minigame/dynamic/context/DynamicPluginDexHandler;", "", "Lcom/tencent/qqmini/minigame/dynamic/IDynamicEntry$Delegate;", "", "methodId", "arg0", "arg1", "arg2", "arg3", "arg4", "arg5", "callServer", "", "contextCode", "pluginName", "nativeLibraryDir", "Lcom/tencent/qqmini/minigame/dynamic/context/DynamicDexClassLoader;", "getClassLoader", "", "init", "destroy", "Lcom/tencent/qqmini/minigame/dynamic/context/ServerMethod;", "method", "", "args", "call", "Lkotlin/Function2;", "Lcom/tencent/qqmini/minigame/dynamic/context/ClientMethod;", "Lkotlin/ParameterName;", "name", "Lcom/tencent/qqmini/minigame/dynamic/context/DynamicClientMethodCallback;", "callback", "setCallClient", "callClient", "dynamicLoader", "Lcom/tencent/qqmini/minigame/dynamic/context/DynamicDexClassLoader;", "Lcom/tencent/qqmini/minigame/dynamic/IDynamicEntry;", "dynamicEntry", "Lcom/tencent/qqmini/minigame/dynamic/IDynamicEntry;", "callClientCallback", "Lkotlin/jvm/functions/Function2;", "<init>", "()V", "Companion", "a", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class DynamicPluginDexHandler implements IDynamicEntry.Delegate {
    private static final String TAG = "DynamicCore_PluginDexHandler";
    private Function2<? super ClientMethod, ? super List<? extends Object>, ? extends Object> callClientCallback;
    private IDynamicEntry dynamicEntry;
    private DynamicDexClassLoader dynamicLoader;

    private final Object callServer(int methodId, Object arg0, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) {
        try {
            IDynamicEntry iDynamicEntry = this.dynamicEntry;
            if (iDynamicEntry == null) {
                return null;
            }
            return iDynamicEntry.callServerMethod(methodId, arg0, arg1, arg2, arg3, arg4, arg5);
        } catch (Throwable th5) {
            QMLog.e(TAG, "callPlugin Throwable:" + th5);
            return null;
        }
    }

    private final DynamicDexClassLoader getClassLoader(String contextCode, String pluginName, String nativeLibraryDir) {
        DynamicDexClassLoader dynamicDexClassLoader = this.dynamicLoader;
        if (dynamicDexClassLoader == null) {
            DynamicDexClassLoader.Companion companion = DynamicDexClassLoader.INSTANCE;
            ClassLoader classLoader = DynamicPluginDexHandler.class.getClassLoader();
            if (classLoader == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(classLoader, "javaClass.classLoader!!");
            DynamicDexClassLoader a16 = companion.a(contextCode, pluginName, classLoader, nativeLibraryDir);
            this.dynamicLoader = a16;
            return a16;
        }
        return dynamicDexClassLoader;
    }

    @Nullable
    public Object call(@NotNull ServerMethod method, @NotNull List<? extends Object> args) {
        Intrinsics.checkParameterIsNotNull(method, "method");
        Intrinsics.checkParameterIsNotNull(args, "args");
        List arrayList = new ArrayList();
        int size = args.size();
        int i3 = 0;
        while (true) {
            Object obj = null;
            if (i3 >= size) {
                break;
            }
            Object obj2 = args.get(i3);
            if (obj2 != null) {
                obj = a.j(obj2);
            }
            arrayList.add(obj);
            i3++;
        }
        if (arrayList.size() >= 6) {
            arrayList = arrayList.subList(0, 6);
        } else {
            int size2 = 6 - arrayList.size();
            for (int i16 = 0; i16 < size2; i16++) {
                arrayList.add(null);
            }
        }
        return callServer(method.ordinal(), a.c(arrayList), a.e(arrayList), a.g(arrayList), a.d(arrayList), a.b(arrayList), a.f(arrayList));
    }

    @Override // com.tencent.qqmini.minigame.dynamic.IDynamicEntry.Delegate
    @Nullable
    public Object callClient(int methodId, @Nullable Object arg0, @Nullable Object arg1, @Nullable Object arg2, @Nullable Object arg3, @Nullable Object arg4, @Nullable Object arg5) {
        Object obj;
        List listOf;
        Function2<? super ClientMethod, ? super List<? extends Object>, ? extends Object> function2 = this.callClientCallback;
        if (function2 != null) {
            ClientMethod a16 = ClientMethod.INSTANCE.a(methodId);
            listOf = CollectionsKt__CollectionsKt.listOf(arg0, arg1, arg2, arg3, arg4, arg5);
            obj = function2.invoke(a16, listOf);
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        return a.j(obj);
    }

    public void destroy() {
        this.dynamicLoader = null;
        this.dynamicEntry = null;
    }

    public void init(@NotNull String contextCode, @NotNull String pluginName, @NotNull String nativeLibraryDir) {
        Intrinsics.checkParameterIsNotNull(contextCode, "contextCode");
        Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
        Intrinsics.checkParameterIsNotNull(nativeLibraryDir, "nativeLibraryDir");
        try {
            Class<?> loadClass = getClassLoader(contextCode, pluginName, nativeLibraryDir).loadClass("com.tencent.qqmini.minigame.dynamic.DynamicPluginImpl");
            if (loadClass != null) {
                Object newInstance = loadClass.newInstance();
                Intrinsics.checkExpressionValueIsNotNull(newInstance, "entryClass.newInstance()");
                IDynamicEntry iDynamicEntry = (IDynamicEntry) newInstance;
                iDynamicEntry.setDelegate(this);
                this.dynamicEntry = iDynamicEntry;
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<com.tencent.qqmini.minigame.dynamic.IDynamicEntry>");
        } catch (Throwable th5) {
            QMLog.e(TAG, "init Throwable:" + th5);
        }
    }

    public void setCallClient(@NotNull Function2<? super ClientMethod, ? super List<? extends Object>, ? extends Object> callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        this.callClientCallback = callback;
    }
}

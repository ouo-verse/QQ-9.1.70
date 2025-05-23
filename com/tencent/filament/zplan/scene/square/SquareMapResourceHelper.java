package com.tencent.filament.zplan.scene.square;

import com.tencent.component.network.module.base.QDLog;
import com.tencent.filament.zplan.avatar.exception.FetchFileException;
import com.tencent.filament.zplan.engine.FilamentViewerV2305;
import com.tencent.filament.zplan.engine.js.FilamentFileUtil;
import com.tencent.filament.zplan.engine.js.FilamentMD5Util;
import com.tencent.mm.libwxaudio.WxAudioNative;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002J'\u0010\u000f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J$\u0010\u0017\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00122\n\u0010\u0016\u001a\u00060\u0014j\u0002`\u0015J&\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00192\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002J\u001a\u0010\u001c\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u001eR\u0014\u0010'\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u001eR\u0014\u0010)\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010\u001eR\u0016\u0010,\u001a\u0004\u0018\u00010*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010+R\u0016\u0010/\u001a\u0004\u0018\u00010-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010.R,\u00104\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040201008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00103R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u00106\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006:"}, d2 = {"Lcom/tencent/filament/zplan/scene/square/SquareMapResourceHelper;", "", "", "taskKey", "", "k", "", "errorCode", "errorMsg", "j", "url", tl.h.F, "Lcom/tencent/zplan/zplantracing/c;", "zplanSpanContext", "shaderDir", "f", "(Lcom/tencent/zplan/zplantracing/c;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "spanContext", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2305;", "viewer", "", "Lcom/tencent/filament/zplan/engine/RenderObjectId;", "objectId", "i", "savePath", "Lkotlinx/coroutines/Deferred;", "l", "forceFileName", "g", "a", "Ljava/lang/String;", WxAudioNative.NativeCallBackInterface.KEY_GET_FILE_PATH_CACHE_DIR, "Lkotlin/Function1;", "b", "Lkotlin/jvm/functions/Function1;", "IMAGE_SHADER_PATH", "c", "IMAGE_GLTF_PATH", "d", "IMAGE_GLTF_BIN_PATH", "e", "IMAGE_GLTF_PNG_PATH", "Ldl0/b;", "Ldl0/b;", QDLog.TAG_DOWNLOAD, "Ldl0/j;", "Ldl0/j;", "threadPoolProxy", "", "", "Lkotlin/coroutines/Continuation;", "Ljava/util/Map;", "taskMap", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "taskMapLock", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class SquareMapResourceHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final String CACHE_DIR;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Function1<String, String> IMAGE_SHADER_PATH;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final String IMAGE_GLTF_PATH;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final String IMAGE_GLTF_BIN_PATH;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final String IMAGE_GLTF_PNG_PATH;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final dl0.b downloader;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final dl0.j threadPoolProxy;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, List<Continuation<Unit>>> taskMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final ReentrantLock taskMapLock;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static final SquareMapResourceHelper f106088j;

    static {
        SquareMapResourceHelper squareMapResourceHelper = new SquareMapResourceHelper();
        f106088j = squareMapResourceHelper;
        CACHE_DIR = FilamentFileUtil.INSTANCE.pathAppend(FilamentFileUtil.systemCacheDirectory(), "square/map/filament/scene");
        IMAGE_SHADER_PATH = new Function1<String, String>() { // from class: com.tencent.filament.zplan.scene.square.SquareMapResourceHelper$IMAGE_SHADER_PATH$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(@NotNull String shaderDir) {
                Intrinsics.checkNotNullParameter(shaderDir, "shaderDir");
                return shaderDir + "/chat_land.filamat";
            }
        };
        IMAGE_GLTF_PATH = squareMapResourceHelper.g("https://cdn.meta.qq.com/filament/map/block/SM_chat_land.gltf", "SM_chat_land.gltf");
        IMAGE_GLTF_BIN_PATH = squareMapResourceHelper.g("https://cdn.meta.qq.com/filament/map/block/SM_chat_land.bin", "SM_chat_land.bin");
        IMAGE_GLTF_PNG_PATH = squareMapResourceHelper.g("https://cdn.meta.qq.com/filament/map/block/Black.png", "Black.png");
        fl0.a aVar = fl0.a.f399763a;
        downloader = (dl0.b) aVar.a(dl0.b.class);
        threadPoolProxy = (dl0.j) aVar.a(dl0.j.class);
        taskMap = new LinkedHashMap();
        taskMapLock = new ReentrantLock();
    }

    SquareMapResourceHelper() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0024 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String h(String url) {
        List split$default;
        Object lastOrNull;
        boolean z16;
        boolean isBlank;
        split$default = StringsKt__StringsKt.split$default((CharSequence) url, new String[]{"."}, false, 0, 6, (Object) null);
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) split$default);
        String str = (String) lastOrNull;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return "";
                }
                return '.' + str;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String taskKey, int errorCode, String errorMsg) {
        ReentrantLock reentrantLock = taskMapLock;
        reentrantLock.lock();
        try {
            List<Continuation<Unit>> remove = taskMap.remove(taskKey);
            if (remove != null) {
                for (Continuation<Unit> continuation : remove) {
                    FetchFileException fetchFileException = new FetchFileException(FetchFileException.Type.DOWNLOAD_FAIL, errorCode, errorMsg, taskKey);
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(fetchFileException)));
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(String taskKey) {
        ReentrantLock reentrantLock = taskMapLock;
        reentrantLock.lock();
        try {
            List<Continuation<Unit>> remove = taskMap.remove(taskKey);
            if (remove != null) {
                Iterator<Continuation<Unit>> it = remove.iterator();
                while (it.hasNext()) {
                    it.next().resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Nullable
    public final Object f(@Nullable com.tencent.zplan.zplantracing.c cVar, @Nullable String str, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutine_suspended2;
        ArrayList arrayList = new ArrayList();
        Function1<String, String> function1 = IMAGE_SHADER_PATH;
        if (str == null) {
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (str == coroutine_suspended) {
                return str;
            }
            return Unit.INSTANCE;
        }
        String invoke = function1.invoke(str);
        if (!new File(invoke).exists()) {
            arrayList.add(l(cVar, "https://cdn.meta.qq.com/filament/map/block/chat_land.filamat", invoke));
        }
        String str2 = IMAGE_GLTF_PATH;
        if (!new File(str2).exists()) {
            arrayList.add(l(cVar, "https://cdn.meta.qq.com/filament/map/block/SM_chat_land.gltf", str2));
        }
        String str3 = IMAGE_GLTF_BIN_PATH;
        if (!new File(str3).exists()) {
            arrayList.add(l(cVar, "https://cdn.meta.qq.com/filament/map/block/SM_chat_land.bin", str3));
        }
        String str4 = IMAGE_GLTF_PNG_PATH;
        if (!new File(str4).exists()) {
            arrayList.add(l(cVar, "https://cdn.meta.qq.com/filament/map/block/Black.png", str4));
        }
        Object awaitAll = AwaitKt.awaitAll(arrayList, continuation);
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (awaitAll == coroutine_suspended2) {
            return awaitAll;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String g(@NotNull String url, @Nullable String forceFileName) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(url, "url");
        if (forceFileName != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(forceFileName);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    forceFileName = FilamentMD5Util.md5(url) + h(url);
                }
                return CACHE_DIR + '/' + forceFileName;
            }
        }
        z16 = true;
        if (z16) {
        }
        return CACHE_DIR + '/' + forceFileName;
    }

    public final void i(@Nullable com.tencent.zplan.zplantracing.c spanContext, @NotNull FilamentViewerV2305 viewer, long objectId) {
        Intrinsics.checkNotNullParameter(viewer, "viewer");
        viewer.updateRenderObjectGltf(spanContext, objectId, IMAGE_GLTF_PATH);
    }

    @NotNull
    public final Deferred<Unit> l(@Nullable com.tencent.zplan.zplantracing.c zplanSpanContext, @NotNull String url, @NotNull String savePath) {
        Deferred<Unit> async$default;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(savePath, "savePath");
        async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SquareMapResourceHelper$startDownloadJob$1(savePath, url, zplanSpanContext, null), 3, null);
        return async$default;
    }
}

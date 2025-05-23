package com.tencent.mobileqq.icgame.context;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\fR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/icgame/context/QQLiveContextCleaner;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "", "g", "version", h.F, "oldVersion", "", "f", "key", "", "d", "e", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "exceptionHandler", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "()V", "ic-game-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class QQLiveContextCleaner implements CoroutineScope {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final QQLiveContextCleaner f237249e = new QQLiveContextCleaner();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CoroutineExceptionHandler exceptionHandler = new a(CoroutineExceptionHandler.INSTANCE);

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ CoroutineScope f237251d = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Companion companion) {
            super(companion);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            QLog.w("ICGameContextCleaner", 1, "[exceptionHandler] " + exception);
        }
    }

    QQLiveContextCleaner() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<String> f(MMKVOptionEntity entity, String oldVersion) {
        boolean isBlank;
        Set<String> emptySet;
        Set<String> emptySet2;
        isBlank = StringsKt__StringsJVMKt.isBlank(oldVersion);
        if (isBlank) {
            QLog.i("ICGameContextCleaner", 1, "[findOldContexts] no old version");
            emptySet2 = SetsKt__SetsKt.emptySet();
            return emptySet2;
        }
        String h16 = h(oldVersion);
        emptySet = SetsKt__SetsKt.emptySet();
        Set<String> decodeStringSet = entity.decodeStringSet(h16, emptySet);
        Intrinsics.checkNotNullExpressionValue(decodeStringSet, "entity.decodeStringSet(v\u2026Key(oldVersion), setOf())");
        return decodeStringSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String g(MMKVOptionEntity entity) {
        String oldVersion = "";
        String decodeString = entity.decodeString("KEY_WINK_CONTEXT_OLD_VERSION", "");
        if (Intrinsics.areEqual(decodeString, AppSetting.f99551k)) {
            QLog.i("ICGameContextCleaner", 1, "[findOldVersion] no old version, current=" + decodeString);
        } else {
            oldVersion = decodeString;
        }
        Intrinsics.checkNotNullExpressionValue(oldVersion, "oldVersion");
        return oldVersion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String h(String version) {
        return "KEY_WINK_CONTEXT_LEGACY_" + version;
    }

    public final void d(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        BuildersKt__Builders_commonKt.launch$default(this, exceptionHandler, null, new QQLiveContextCleaner$addContextKey$1(key, null), 2, null);
    }

    public final void e() {
        BuildersKt__Builders_commonKt.launch$default(this, exceptionHandler, null, new QQLiveContextCleaner$clean$1(null), 2, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.f237251d.getCoroutineContext();
    }
}

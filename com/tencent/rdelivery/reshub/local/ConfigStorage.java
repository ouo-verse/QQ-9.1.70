package com.tencent.rdelivery.reshub.local;

import com.tencent.raft.standard.storage.IRStorage;
import com.tencent.rdelivery.reshub.core.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u001e\u001a\u00020\n\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J!\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\nR\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0017\u0010\u001e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/rdelivery/reshub/local/ConfigStorage;", "", "", "d", "i", "T", "Lkotlin/Function0;", "thenDo", h.F, "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "e", "value", "g", "a", "Ljava/lang/String;", "dataVersionKey", "Lcom/tencent/raft/standard/storage/IRStorage;", "b", "Lcom/tencent/raft/standard/storage/IRStorage;", "configStorage", "", "c", "J", "currentDataVersion", "Lcom/tencent/rdelivery/reshub/local/d;", "Lcom/tencent/rdelivery/reshub/local/d;", "sync", "f", "()Ljava/lang/String;", "key", "Lkotlin/jvm/functions/Function0;", "getOnReload", "()Lkotlin/jvm/functions/Function0;", "onReload", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class ConfigStorage {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String dataVersionKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final IRStorage configStorage;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile long currentDataVersion;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final d sync;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String key;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> onReload;

    public ConfigStorage(@NotNull String key, @NotNull Function0<Unit> onReload) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(onReload, "onReload");
        this.key = key;
        this.onReload = onReload;
        this.dataVersionKey = "mp_data_ver_" + key;
        this.configStorage = g.c();
        this.currentDataVersion = -1L;
        this.sync = d.f364544e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        if (!this.sync.a()) {
            return;
        }
        long j3 = this.configStorage.getLong(this.dataVersionKey, 0L);
        if (this.currentDataVersion == -1) {
            this.currentDataVersion = j3;
            return;
        }
        if (this.currentDataVersion != j3) {
            jz3.d.i("ConfigStorage", "Data Version Changed(" + this.currentDataVersion + " -> " + j3 + "), Reload Config(" + this.key + ") For MultiProcess Sync.");
            this.currentDataVersion = j3;
            this.onReload.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        if (!this.sync.a()) {
            return;
        }
        long j3 = this.configStorage.getLong(this.dataVersionKey, 0L) + 1;
        this.configStorage.putLong(this.dataVersionKey, j3);
        this.currentDataVersion = j3;
        jz3.d.i("ConfigStorage", "Update Data Version(" + j3 + "), For Config(" + this.key + ").");
    }

    @NotNull
    public final String e() {
        if (!this.sync.a()) {
            String string = this.configStorage.getString(this.key, "");
            if (string == null) {
                return "";
            }
            return string;
        }
        return (String) this.sync.b(new Function0<String>() { // from class: com.tencent.rdelivery.reshub.local.ConfigStorage$getConfigString$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IRStorage iRStorage;
                iRStorage = ConfigStorage.this.configStorage;
                String string2 = iRStorage.getString(ConfigStorage.this.getKey(), "");
                return string2 != null ? string2 : "";
            }
        });
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public final void g(@NotNull final String value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        if (!this.sync.a()) {
            this.configStorage.putString(this.key, value);
        } else {
            this.sync.b(new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.local.ConfigStorage$putConfigString$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IRStorage iRStorage;
                    iRStorage = ConfigStorage.this.configStorage;
                    iRStorage.putString(ConfigStorage.this.getKey(), value);
                    ConfigStorage.this.i();
                }
            });
        }
    }

    public final <T> T h(@NotNull final Function0<? extends T> thenDo) {
        Intrinsics.checkParameterIsNotNull(thenDo, "thenDo");
        if (!this.sync.a()) {
            return thenDo.invoke();
        }
        return (T) this.sync.b(new Function0<T>() { // from class: com.tencent.rdelivery.reshub.local.ConfigStorage$trySyncData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                ConfigStorage.this.d();
                return (T) thenDo.invoke();
            }
        });
    }
}

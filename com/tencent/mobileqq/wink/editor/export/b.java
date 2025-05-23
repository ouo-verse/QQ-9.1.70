package com.tencent.mobileqq.wink.editor.export;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import common.config.service.QzoneConfig;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0006B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/export/b;", "", "", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "switchParams", "<init>", "()V", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private static b f320188c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, Boolean> switchParams;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00028B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/export/b$a;", "", "Lcom/tencent/mobileqq/wink/editor/export/b;", "a", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/wink/editor/export/b;", "b", "()Lcom/tencent/mobileqq/wink/editor/export/b;", "", "RENDER_MODEL_SWITCH", "Ljava/lang/String;", "RENDER_SIZE_SYNC_OUTPUT_SIZE", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.export.b$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final b b() {
            if (b.f320188c == null) {
                b.f320188c = new b(null);
            }
            return b.f320188c;
        }

        @NotNull
        public final synchronized b a() {
            b b16;
            b16 = b();
            Intrinsics.checkNotNull(b16);
            return b16;
        }

        Companion() {
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean c() {
        if (!this.switchParams.contains("renderModelSwitch")) {
            this.switchParams.put("renderModelSwitch", Boolean.valueOf(QzoneConfig.isRenderModelExport()));
        }
        Boolean bool = this.switchParams.get("renderModelSwitch");
        Intrinsics.checkNotNull(bool);
        return bool.booleanValue();
    }

    b() {
        this.switchParams = new ConcurrentHashMap<>();
    }
}

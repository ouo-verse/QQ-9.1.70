package com.tencent.kuikly.core.render.android.turbo;

import android.content.Context;
import com.tencent.kuikly.core.render.android.expand.module.e;
import com.tencent.kuikly.core.render.android.scheduler.KuiklyRenderThreadManager;
import d01.w;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayCacheManager;", "", "Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayNode;", "node", "", "g", "viewNode", "", "cacheKey", "j", "", "data", "k", "i", "e", "nodeData", "f", "Lcom/tencent/kuikly/core/render/android/turbo/a;", h.F, "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "c", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRTurboDisplayCacheManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Object f118207b = new Object();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/render/android/turbo/KRTurboDisplayCacheManager$a;", "", "Landroid/content/Context;", "context", "", "turboDisplayKey", "b", "d", "pageName", "c", "cacheKey", "", "e", "TAG", "Ljava/lang/String;", "fileLock", "Ljava/lang/Object;", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.turbo.KRTurboDisplayCacheManager$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b(Context context, String turboDisplayKey) {
            return d(context) + '/' + turboDisplayKey;
        }

        private final String d(Context context) {
            File filesDir = context.getFilesDir();
            Intrinsics.checkNotNullExpressionValue(filesDir, "context.filesDir");
            String str = filesDir.getAbsolutePath() + "/TurboDisplay";
            File file = new File(str);
            if (!file.exists() && !file.mkdirs()) {
                w.f392617a.b("KRTurboDisplayCacheManager", "Error creating TurboDisplay directory");
            }
            return str;
        }

        @NotNull
        public final String c(@NotNull String turboDisplayKey, @NotNull String pageName) {
            Intrinsics.checkNotNullParameter(turboDisplayKey, "turboDisplayKey");
            Intrinsics.checkNotNullParameter(pageName, "pageName");
            return "kuikly_turbo_display_9" + e.INSTANCE.a(pageName + util.base64_pad_url + turboDisplayKey) + ".data";
        }

        public final boolean e(@NotNull Context context, @NotNull String cacheKey) {
            boolean exists;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
            try {
                synchronized (KRTurboDisplayCacheManager.f118207b) {
                    exists = new File(KRTurboDisplayCacheManager.INSTANCE.b(context, cacheKey)).exists();
                    Unit unit = Unit.INSTANCE;
                }
                return exists;
            } catch (Throwable th5) {
                w.f392617a.b("KRTurboDisplayCacheManager", "hasNodeWithCacheKey, " + cacheKey + ", e: " + th5);
                return false;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public KRTurboDisplayCacheManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(KRTurboDisplayNode node) {
        if (node.getTag() != -1 && node.getTag() >= 0) {
            node.C(-(node.getTag() + 2));
        }
        Integer parentTag = node.getParentTag();
        if (parentTag != null && parentTag.intValue() != -1 && parentTag.intValue() >= 0) {
            node.x(Integer.valueOf(-(parentTag.intValue() + 2)));
        }
        if (node.s()) {
            Iterator<KRTurboDisplayNode> it = node.j().iterator();
            while (it.hasNext()) {
                g(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(KRTurboDisplayNode viewNode, String cacheKey) {
        k(viewNode.E(), cacheKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(byte[] data, String cacheKey) {
        File file = new File(INSTANCE.b(this.context, cacheKey));
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        FilesKt__FileReadWriteKt.writeBytes(file, data);
    }

    public final void e(@NotNull final KRTurboDisplayNode viewNode, @NotNull final String cacheKey) {
        Intrinsics.checkNotNullParameter(viewNode, "viewNode");
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        KuiklyRenderThreadManager.f118203b.k(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.turbo.KRTurboDisplayCacheManager$cacheWithViewNode$1
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
                synchronized (KRTurboDisplayCacheManager.f118207b) {
                    try {
                        KRTurboDisplayCacheManager.this.g(viewNode);
                        KRTurboDisplayCacheManager.this.j(viewNode, cacheKey);
                    } catch (Throwable th5) {
                        w.f392617a.b("KRTurboDisplayCacheManager", "cacheWithViewNode, " + cacheKey + ", " + th5);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }, false);
    }

    public final void f(@NotNull final byte[] nodeData, @NotNull final String cacheKey) {
        boolean z16;
        Intrinsics.checkNotNullParameter(nodeData, "nodeData");
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        if (nodeData.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        KuiklyRenderThreadManager.f118203b.k(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.turbo.KRTurboDisplayCacheManager$cacheWithViewNodeData$1
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
                try {
                    synchronized (KRTurboDisplayCacheManager.f118207b) {
                        KRTurboDisplayCacheManager.this.k(nodeData, cacheKey);
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Throwable th5) {
                    w.f392617a.b("KRTurboDisplayCacheManager", "cacheWithViewNodeData: " + cacheKey + ", " + th5);
                }
            }
        }, false);
    }

    @Nullable
    public final a h(@NotNull String cacheKey) {
        a aVar;
        byte[] readBytes;
        boolean z16;
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        try {
            synchronized (f118207b) {
                File file = new File(INSTANCE.b(this.context, cacheKey));
                if (file.exists()) {
                    readBytes = FilesKt__FileReadWriteKt.readBytes(file);
                    if (readBytes.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        aVar = new a(KRTurboDisplayNode.INSTANCE.a(readBytes), readBytes);
                    } else {
                        aVar = null;
                    }
                    file.delete();
                } else {
                    aVar = null;
                }
                Unit unit = Unit.INSTANCE;
            }
            return aVar;
        } catch (Throwable th5) {
            w.f392617a.b("KRTurboDisplayCacheManager", "nodeWithCacheKey: " + cacheKey + ", e: " + th5);
            return null;
        }
    }

    public final void i(@NotNull String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        synchronized (f118207b) {
            try {
                new File(INSTANCE.b(this.context, cacheKey)).deleteOnExit();
            } catch (Throwable th5) {
                w.f392617a.b("KRTurboDisplayCacheManager", "removeCacheWithKey: " + cacheKey + ", " + th5);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}

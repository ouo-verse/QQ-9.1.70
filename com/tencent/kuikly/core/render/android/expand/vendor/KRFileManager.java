package com.tencent.kuikly.core.render.android.expand.vendor;

import android.os.Handler;
import android.os.Looper;
import android.util.ArrayMap;
import com.tencent.kuikly.core.render.android.css.ktx.b;
import com.tencent.kuikly.core.render.android.expand.module.KRNetworkModule;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0002JC\u0010\u0013\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00070\u0006R4\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00070\u00060\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/vendor/KRFileManager;", "", "", "url", "", "c", "Lkotlin/Function1;", "", "resultBlock", "e", "filePath", "b", "Lcom/tencent/kuikly/core/render/android/a;", "context", "cdnUrl", "storePath", "Lkotlin/ParameterName;", "name", "resultCallback", "d", "Landroid/util/ArrayMap;", "", "a", "Landroid/util/ArrayMap;", "downloadingMap", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRFileManager {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final KRFileManager f118087b = new KRFileManager();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final ArrayMap<String, List<Function1<String, Unit>>> downloadingMap = new ArrayMap<>();

    KRFileManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String url, String filePath) {
        List<Function1<String, Unit>> remove = downloadingMap.remove(url);
        if (remove != null) {
            Iterator<T> it = remove.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(filePath);
            }
        }
    }

    private final boolean c(String url) {
        if (downloadingMap.get(url) != null && (!r2.isEmpty())) {
            return true;
        }
        return false;
    }

    private final void e(String url, Function1<? super String, Unit> resultBlock) {
        ArrayMap<String, List<Function1<String, Unit>>> arrayMap = downloadingMap;
        List<Function1<String, Unit>> list = arrayMap.get(url);
        if (list == null) {
            list = new ArrayList<>();
            arrayMap.put(url, list);
        }
        Intrinsics.checkNotNullExpressionValue(list, "downloadingMap[url] ?: m\u2026Map[url] = this\n        }");
        list.add(resultBlock);
    }

    public final void d(@NotNull com.tencent.kuikly.core.render.android.a context, @NotNull final String cdnUrl, @NotNull String storePath, @NotNull Function1<? super String, Unit> resultCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cdnUrl, "cdnUrl");
        Intrinsics.checkNotNullParameter(storePath, "storePath");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        b.l();
        final File file = new File(storePath);
        if (file.exists()) {
            if (c(cdnUrl)) {
                e(cdnUrl, resultCallback);
                return;
            } else {
                resultCallback.invoke(storePath);
                return;
            }
        }
        file.createNewFile();
        e(cdnUrl, resultCallback);
        KRNetworkModule kRNetworkModule = (KRNetworkModule) context.a("KRNetworkModule");
        if (kRNetworkModule != null) {
            KRNetworkModule.g(kRNetworkModule, cdnUrl, storePath, 0, new Function1<String, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.vendor.KRFileManager$fetchFile$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable final String str) {
                    if (str == null && file.exists()) {
                        file.delete();
                    }
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.expand.vendor.KRFileManager$fetchFile$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            KRFileManager.f118087b.b(cdnUrl, str);
                        }
                    });
                }
            }, 4, null);
        }
    }
}

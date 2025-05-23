package com.tencent.aelight.camera.ae.util;

import android.content.res.AssetManager;
import androidx.collection.LruCache;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGFile;
import org.libpag.PAGLayer;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00042\u00020\u0001:\u0002\u0005\u0006B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aelight/camera/ae/util/PagViewMonitor;", "", "<init>", "()V", "Companion", "a", "b", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class PagViewMonitor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "PagViewMonitor";
    private static final int MAX_SIZE = 20;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001e\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/aelight/camera/ae/util/PagViewMonitor$a;", "", "", "pagPath", "Lorg/libpag/PAGFile;", "b", "Landroid/content/res/AssetManager;", "assetManager", "a", "Lorg/libpag/PAGLayer;", "layer", "", "c", "TAG", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "", "MAX_SIZE", "I", "d", "()I", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.ae.util.PagViewMonitor$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final PAGFile a(AssetManager assetManager, String pagPath) {
            QLog.d(e(), 1, "load asset path :" + pagPath);
            PAGFile Load = PAGFile.Load(assetManager, pagPath);
            try {
                if (wq.a.i() && Load != null) {
                    QLog.i(PagViewMonitor.INSTANCE.e(), 1, "load asset load hashCode : " + Load.hashCode());
                    if (pagPath != null) {
                        b.f65754a.a().put(Integer.valueOf(pagPath.hashCode()), pagPath);
                    }
                }
            } catch (Throwable th5) {
                QLog.e(e(), 1, "load asset: " + th5.getMessage());
            }
            return Load;
        }

        @JvmStatic
        public final PAGFile b(String pagPath) {
            QLog.i(e(), 1, "load path :" + pagPath);
            PAGFile Load = PAGFile.Load(pagPath);
            try {
                if (wq.a.i() && Load != null) {
                    QLog.i(PagViewMonitor.INSTANCE.e(), 1, "load hashCode : " + Load.hashCode());
                    if (pagPath != null) {
                        b.f65754a.a().put(Integer.valueOf(pagPath.hashCode()), pagPath);
                    }
                }
            } catch (Throwable th5) {
                QLog.e(e(), 1, "load hashCode : " + th5.getMessage());
            }
            return Load;
        }

        public final int d() {
            return PagViewMonitor.MAX_SIZE;
        }

        public final String e() {
            return PagViewMonitor.TAG;
        }

        Companion() {
        }

        @JvmStatic
        public final void c(PAGLayer layer) {
            try {
                if (wq.a.i()) {
                    QLog.d(e(), 1, "finalize");
                    if (layer != null) {
                        b.f65754a.a().remove(Integer.valueOf(layer.hashCode()));
                    }
                }
            } catch (Throwable th5) {
                QLog.e(e(), 1, "finalize : " + th5.getMessage());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/aelight/camera/ae/util/PagViewMonitor$b;", "", "", "b", "Landroidx/collection/LruCache;", "", "Landroidx/collection/LruCache;", "a", "()Landroidx/collection/LruCache;", "pathMap", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f65754a = new b();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static final LruCache<Integer, String> pathMap = new LruCache<>(PagViewMonitor.INSTANCE.d());

        b() {
        }

        public final LruCache<Integer, String> a() {
            return pathMap;
        }

        public final String b() {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                LruCache<Integer, String> lruCache = pathMap;
                synchronized (lruCache) {
                    for (Integer num : lruCache.snapshot().keySet()) {
                        stringBuffer.append("Key: " + num + ", Value: " + pathMap.get(num) + "\n");
                    }
                    Unit unit = Unit.INSTANCE;
                }
                String stringBuffer2 = stringBuffer.toString();
                Intrinsics.checkNotNullExpressionValue(stringBuffer2, "stringBuffer.toString()");
                return stringBuffer2;
            } catch (Throwable th5) {
                QLog.e(PagViewMonitor.INSTANCE.e(), 1, "mapToString : " + th5.getMessage());
                return "";
            }
        }
    }

    @JvmStatic
    public static final PAGFile Load(AssetManager assetManager, String str) {
        return INSTANCE.a(assetManager, str);
    }

    @JvmStatic
    public static final void finalize(PAGLayer pAGLayer) {
        INSTANCE.c(pAGLayer);
    }

    @JvmStatic
    public static final PAGFile Load(String str) {
        return INSTANCE.b(str);
    }
}

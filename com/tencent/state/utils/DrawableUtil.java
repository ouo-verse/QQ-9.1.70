package com.tencent.state.utils;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.image.URLDrawable;
import com.tencent.state.report.TechReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J$\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\r2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0015J\u001a\u0010\u001a\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0012\u0010\u001d\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0007J\u0012\u0010\u001e\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000RV\u0010\b\u001aJ\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\fj\b\u0012\u0004\u0012\u00020\u0004`\r0\tj$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\fj\b\u0012\u0004\u0012\u00020\u0004`\r`\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/state/utils/DrawableUtil;", "", "()V", "TAG", "", "optionsForClear", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "kotlin.jvm.PlatformType", "urlDrawableMap", "Ljava/util/HashMap;", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Lkotlin/collections/HashMap;", "clearContextCache", "", "context", "from", "findTargetSetOrNull", "getDrawable", "Landroid/graphics/drawable/Drawable;", "resId", "", "getDrawableUrl", "drawable", "markURLDrawable", "urlDrawable", "Lcom/tencent/image/URLDrawable;", "onContextDestroy", "onLowMemory", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DrawableUtil {
    private static final String TAG = "SquareDrawable_DrawableUtils";
    public static final DrawableUtil INSTANCE = new DrawableUtil();
    private static final HashMap<WeakReference<Context>, HashSet<String>> urlDrawableMap = new HashMap<>();
    private static final URLDrawable.URLDrawableOptions optionsForClear = URLDrawable.URLDrawableOptions.obtain();

    DrawableUtil() {
    }

    private final void clearContextCache(Context context, String from) {
        SquareLogger squareLog;
        StringBuilder sb5;
        HashMap<WeakReference<Context>, HashSet<String>> hashMap;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            hashMap = urlDrawableMap;
        } catch (Throwable th5) {
            try {
                SquareBaseKt.getSquareLog().e(TAG, from + ", err.", th5);
                squareLog = SquareBaseKt.getSquareLog();
                sb5 = new StringBuilder();
            } finally {
                SquareBaseKt.getSquareLog().i(TAG, from + ", cost: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
        if (hashMap.isEmpty()) {
            SquareBaseKt.getSquareLog().i(TAG, from + ", urlDrawableMap is empty");
            return;
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<WeakReference<Context>, HashSet<String>> entry : hashMap.entrySet()) {
            Context context2 = entry.getKey().get();
            if (context2 == null || Intrinsics.areEqual(context2, context)) {
                if (!entry.getValue().isEmpty()) {
                    hashSet.addAll(entry.getValue());
                    arrayList.add(entry.getKey());
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            urlDrawableMap.remove((WeakReference) it.next());
        }
        SquareBaseKt.getSquareLog().i(TAG, from + ", collect: " + hashSet.size());
        Iterator<Map.Entry<WeakReference<Context>, HashSet<String>>> it5 = urlDrawableMap.entrySet().iterator();
        while (it5.hasNext()) {
            hashSet.removeAll(it5.next().getValue());
        }
        Iterator it6 = hashSet.iterator();
        while (it6.hasNext()) {
            URLDrawable.removeMemoryCacheByUrl((String) it6.next(), optionsForClear);
        }
        SquareBaseKt.getSquareLog().i(TAG, from + ", clear: " + hashSet.size());
        squareLog = SquareBaseKt.getSquareLog();
        sb5 = new StringBuilder();
        sb5.append(from);
        sb5.append(", cost: ");
        sb5.append(System.currentTimeMillis() - currentTimeMillis);
        squareLog.i(TAG, sb5.toString());
    }

    private final HashSet<String> findTargetSetOrNull(Context context) {
        for (Map.Entry<WeakReference<Context>, HashSet<String>> entry : urlDrawableMap.entrySet()) {
            if (Intrinsics.areEqual(entry.getKey().get(), context)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public final Drawable getDrawable(int resId) {
        Map<String, Object> mutableMapOf;
        Application application = Square.INSTANCE.getApplication();
        if (application != null) {
            try {
                return AppCompatResources.getDrawable(application, resId);
            } catch (Throwable th5) {
                SquareBaseKt.getSquareLog().e(TAG, "getDrawable, err.", th5);
                if (th5 instanceof OutOfMemoryError) {
                    System.gc();
                    IReporter squareReporter = SquareBaseKt.getSquareReporter();
                    mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(TechReportConst.Key.KEY_TECH_TYPE, 1));
                    squareReporter.reportEvent(TechReportConst.CustomEventId.EVENT_ID_DEV_TECH_REPORT, mutableMapOf);
                }
            }
        }
        return null;
    }

    public final String getDrawableUrl(Drawable drawable) {
        String url;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (!(drawable instanceof URLDrawable)) {
            drawable = null;
        }
        URLDrawable uRLDrawable = (URLDrawable) drawable;
        if (uRLDrawable != null) {
            URL url2 = uRLDrawable.getURL();
            return (url2 == null || (url = url2.toString()) == null) ? "unknown" : url;
        }
        return "not URLDrawable";
    }

    public final void markURLDrawable(Context context, URLDrawable urlDrawable) {
        URL url;
        String url2;
        Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        if (!Square.INSTANCE.getConfig().getCommonUtils().getPerformanceConfig().getRemoveURLDrawableCacheOnDestroy()) {
            HashMap<WeakReference<Context>, HashSet<String>> hashMap = urlDrawableMap;
            if (!hashMap.isEmpty()) {
                hashMap.clear();
                return;
            }
            return;
        }
        if (context == null || (url = urlDrawable.getURL()) == null || (url2 = url.toString()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(url2, "urlDrawable.url?.toString() ?: return");
        try {
            HashSet<String> findTargetSetOrNull = findTargetSetOrNull(context);
            if (findTargetSetOrNull == null) {
                findTargetSetOrNull = new HashSet<>();
                urlDrawableMap.put(new WeakReference<>(context), findTargetSetOrNull);
            }
            findTargetSetOrNull.add(url2);
        } catch (Throwable th5) {
            SquareBaseKt.getSquareLog().e(TAG, "markURLDrawable err.", th5);
        }
    }

    public final void onContextDestroy(Context context) {
        if (!Square.INSTANCE.getConfig().getCommonUtils().getPerformanceConfig().getRemoveURLDrawableCacheOnDestroy()) {
            HashMap<WeakReference<Context>, HashSet<String>> hashMap = urlDrawableMap;
            if (!hashMap.isEmpty()) {
                hashMap.clear();
                return;
            }
            return;
        }
        clearContextCache(context, "onContextDestroy");
    }

    public final void onLowMemory(Context context) {
        clearContextCache(context, "onLowMemory");
    }
}

package h60;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.collection.LruCache;
import circlesearch.CircleSearchExhibition$PromptGuess;
import circlesearch.CircleSearchExhibition$PromptShading;
import circlesearch.CircleSearchExhibition$SquareRelevantInfo;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final LruCache<String, CircleSearchExhibition$PromptShading> f404429a = new LruCache<>(10);

    /* renamed from: b, reason: collision with root package name */
    private static final LruCache<String, CircleSearchExhibition$PromptGuess> f404430b = new LruCache<>(10);

    /* renamed from: c, reason: collision with root package name */
    private static final LruCache<String, CircleSearchExhibition$SquareRelevantInfo> f404431c = new LruCache<>(10);

    public static void a() {
        f404431c.evictAll();
    }

    @Nullable
    public static CircleSearchExhibition$PromptGuess b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[getPromptGuess] feed: ");
        sb5.append(str);
        sb5.append(" | cache: ");
        LruCache<String, CircleSearchExhibition$PromptGuess> lruCache = f404430b;
        sb5.append(lruCache.get(str));
        QLog.d("QFSSearchCacheHelper", 1, sb5.toString());
        return lruCache.get(str);
    }

    @Nullable
    public static CircleSearchExhibition$PromptShading c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f404429a.get(str);
    }

    @Nullable
    public static CircleSearchExhibition$SquareRelevantInfo d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f404431c.get(str);
    }

    public static boolean e() {
        if (b(QFSVideoView.L0()) != null) {
            return true;
        }
        return false;
    }

    public static void f(String str, CircleSearchExhibition$PromptGuess circleSearchExhibition$PromptGuess) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (circleSearchExhibition$PromptGuess == null) {
            f404430b.remove(str);
        }
        f404430b.put(str, circleSearchExhibition$PromptGuess);
    }

    public static void g(String str, CircleSearchExhibition$PromptShading circleSearchExhibition$PromptShading) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (circleSearchExhibition$PromptShading != null && circleSearchExhibition$PromptShading.shading_infos.get() != null && circleSearchExhibition$PromptShading.shading_infos.get().size() == 1) {
            f404429a.put(str, circleSearchExhibition$PromptShading);
        } else {
            f404429a.remove(str);
        }
    }

    public static void h(String str, CircleSearchExhibition$SquareRelevantInfo circleSearchExhibition$SquareRelevantInfo) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (circleSearchExhibition$SquareRelevantInfo != null && !circleSearchExhibition$SquareRelevantInfo.words.get().isEmpty()) {
            f404431c.put(str, circleSearchExhibition$SquareRelevantInfo);
        } else {
            f404431c.remove(str);
        }
    }
}

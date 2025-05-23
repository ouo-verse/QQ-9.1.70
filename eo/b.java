package eo;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u0014\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0017R2\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00020\u0019j\b\u0012\u0004\u0012\u00020\u0002`\u001a0\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Leo/b;", "", "", "scene", "", h.F, "", "pageId", "f", "i", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "a", "Landroid/content/Context;", "context", "feedKey", "c", "b", "d", "g", "e", "", "", "Ljava/util/Map;", "mStartTimeMap", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "mFeedExposureCountMap", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f396876a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Map<String, Long> mStartTimeMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static Map<String, HashSet<String>> mFeedExposureCountMap = new LinkedHashMap();

    b() {
    }

    private final void f(String scene, int pageId) {
        if (TextUtils.isEmpty(scene)) {
            return;
        }
        Long l3 = mStartTimeMap.get(scene);
        long longValue = l3 != null ? l3.longValue() : 0L;
        if (longValue <= 0) {
            QLog.e("QZonePageReportManager", 1, scene + " recordPageEndShow error: have you called start");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - longValue;
        HashSet<String> hashSet = mFeedExposureCountMap.get(scene);
        a.f396875a.e(pageId, currentTimeMillis, hashSet != null ? hashSet.size() : 0);
        i(scene);
    }

    private final void h(String scene) {
        if (TextUtils.isEmpty(scene)) {
            return;
        }
        Long l3 = mStartTimeMap.get(scene);
        if ((l3 != null ? l3.longValue() : 0L) <= 0) {
            QLog.e("QZonePageReportManager", 1, scene + " recordPageStartShow error: call start method twice");
        }
        mStartTimeMap.put(scene, Long.valueOf(System.currentTimeMillis()));
    }

    private final void i(String scene) {
        if (TextUtils.isEmpty(scene)) {
            return;
        }
        TypeIntrinsics.asMutableMap(mStartTimeMap).remove(scene);
        TypeIntrinsics.asMutableMap(mFeedExposureCountMap).remove(scene);
    }

    public final void c(Context context, String feedKey) {
        if (!(context instanceof Activity) || feedKey == null) {
            return;
        }
        b((Activity) context, feedKey);
    }

    public final void d(String scene, String feedKey) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (!TextUtils.isEmpty(scene) && !TextUtils.isEmpty(feedKey) && mStartTimeMap.containsKey(scene)) {
            HashSet<String> hashSet = mFeedExposureCountMap.get(scene);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                mFeedExposureCountMap.put(scene, hashSet);
            }
            if (feedKey != null) {
                hashSet.add(feedKey);
                return;
            }
            return;
        }
        QLog.e("QZonePageReportManager", 1, scene + " recordFeedExposure error, scene: " + scene + ", feedKey: " + feedKey);
    }

    private final String a(Activity activity) {
        if (activity == null) {
            return "";
        }
        return activity.getClass().getSimpleName() + activity.hashCode();
    }

    public final void b(Activity activity, String feedKey) {
        if (activity != null) {
            b bVar = f396876a;
            bVar.d(bVar.a(activity), feedKey);
        }
    }

    public final void e(Activity activity, int pageId) {
        if (activity != null) {
            b bVar = f396876a;
            bVar.f(bVar.a(activity), pageId);
        }
    }

    public final void g(Activity activity) {
        if (activity != null) {
            b bVar = f396876a;
            bVar.h(bVar.a(activity));
        }
    }
}

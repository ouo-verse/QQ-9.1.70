package com.tencent.mobileqq.zplan.authorize.impl.helper;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.sqshow.zootopia.recommend.main.ZPlanMainRecommendActivity;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import k74.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Foreground;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/helper/f;", "", "", "mapId", "", ZPlanPublishSource.FROM_SCHEME, "d", "", "b", "c", "", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "schemeCache", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f331488a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<Integer, String> schemeCache = new ConcurrentHashMap<>();

    f() {
    }

    public final boolean a(String mapId) {
        String currentfragments;
        List split$default;
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        i.Companion companion = i.INSTANCE;
        if (((com.tencent.mobileqq.zootopia.ipc.f) companion.a(com.tencent.mobileqq.zootopia.ipc.f.class)).isFloat()) {
            QLog.i("LaunchSchemehelper_", 1, "auto launch check pass: as showing float view");
            return false;
        }
        if (((com.tencent.mobileqq.zootopia.ipc.f) companion.a(com.tencent.mobileqq.zootopia.ipc.f.class)).isShowUE()) {
            QLog.i("LaunchSchemehelper_", 1, "ue is showing");
            return false;
        }
        List<String> a16 = g.f331490a.a(mapId);
        if (a16.isEmpty()) {
            QLog.i("LaunchSchemehelper_", 1, "config is Empty, support all page auto launch");
            return true;
        }
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity instanceof ZPlanMainRecommendActivity) {
            currentfragments = ((ZPlanMainRecommendActivity) topActivity).getCurrentFragments();
        } else if (topActivity instanceof ZootopiaActivity) {
            currentfragments = ((ZootopiaActivity) topActivity).getCurrentFragments();
        } else {
            currentfragments = "";
        }
        Intrinsics.checkNotNullExpressionValue(currentfragments, "currentfragments");
        split$default = StringsKt__StringsKt.split$default((CharSequence) currentfragments, new String[]{"\n"}, false, 0, 6, (Object) null);
        QLog.d("LaunchSchemehelper_", 1, " targetFragmet => " + split$default);
        if (currentfragments.length() == 0) {
            return false;
        }
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            if (a16.contains((String) it.next())) {
                QLog.i("LaunchSchemehelper_", 1, "can auto launch ~");
                return true;
            }
        }
        return false;
    }

    public final void b(int mapId) {
        QLog.i("LaunchSchemehelper_", 1, "clear Scheme: " + mapId + ", remove: " + schemeCache.remove(Integer.valueOf(mapId)) + " ");
    }

    public final int d(int mapId, String scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        QLog.i("LaunchSchemehelper_", 1, "save Scheme: mapId: " + mapId + ", scheme = " + scheme);
        if (mapId <= 0) {
            return -1;
        }
        if (scheme.length() == 0) {
            return -1;
        }
        schemeCache.put(Integer.valueOf(mapId), scheme);
        return 0;
    }

    public final String c(int mapId) {
        if (mapId <= 0) {
            return null;
        }
        String str = schemeCache.get(Integer.valueOf(mapId));
        QLog.i("LaunchSchemehelper_", 1, "getScheme mapId = " + mapId + ", scheme = " + str);
        return str;
    }
}

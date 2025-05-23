package com.tencent.mobileqq.kandian.glue.video;

import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u001a\u0010\n\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0011\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/kandian/glue/video/c;", "", "", "rowKey", "vid", "", "position", "duration", "", "a", "c", "", "b", "Ljava/util/Map;", "map", "", "()Z", "enable", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f240045a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, Long> map = new LinkedHashMap();

    c() {
    }

    public final void a(String rowKey, String vid, long position, long duration) {
        if (b()) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoResumeManager", 2, "cacheVideoStatus: rowKey=" + rowKey + ", vid=" + vid + ", position=" + position + ", duration=" + duration);
            }
            String str = rowKey + "_" + vid;
            Map<String, Long> map2 = map;
            if (duration - position <= 1500) {
                position = 0;
            }
            map2.put(str, Long.valueOf(position));
        }
    }

    public final boolean b() {
        return false;
    }

    public final long c(String rowKey, String vid) {
        if (b()) {
            Long l3 = map.get(rowKey + "_" + vid);
            long longValue = l3 != null ? l3.longValue() : 0L;
            r1 = longValue >= 1500 ? longValue : 0L;
            if (QLog.isColorLevel()) {
                QLog.d("VideoResumeManager", 2, "getPlayPosition: rowKey=" + rowKey + ", vid=" + vid + ", result=" + r1);
            }
        }
        return r1;
    }
}

package hr2;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.studymode.urlfilter.AccessibleLink.pb.AccessibleLinkFilter$AccessibleLink;
import com.tencent.mobileqq.studymode.urlfilter.AccessibleLink.pb.AccessibleLinkFilter$AccessibleLinks;
import com.tencent.mobileqq.studymode.urlfilter.StudyModeUrlFilterCachesInfo;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\n\u001a\u00020\u0006J\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u000e\u001a\u00020\rR\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0011\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001c\u00a8\u0006 "}, d2 = {"Lhr2/g;", "", "", "url", "Lcom/tencent/mobileqq/studymode/urlfilter/StudyModeUrlFilterCachesInfo;", "i", "", tl.h.F, "info", "d", "a", "Ljava/nio/ByteBuffer;", "f", "", "byteBuffer", "", "g", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "TAG", "", "Z", "()Z", "e", "(Z)V", "needStore", "Ljava/util/Map;", "caches", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean needStore;

    /* renamed from: a, reason: collision with root package name */
    public static final g f406087a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String TAG = "StudyModeUrlCaches";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, StudyModeUrlFilterCachesInfo> caches = new LinkedHashMap();

    g() {
    }

    public final void a() {
        caches.clear();
    }

    public final boolean b() {
        return needStore;
    }

    public final String c() {
        return TAG;
    }

    public final void e(boolean z16) {
        needStore = z16;
    }

    public final ByteBuffer f() {
        Map<String, StudyModeUrlFilterCachesInfo> map = caches;
        if (map.isEmpty()) {
            return null;
        }
        AccessibleLinkFilter$AccessibleLinks accessibleLinkFilter$AccessibleLinks = new AccessibleLinkFilter$AccessibleLinks();
        for (Map.Entry<String, StudyModeUrlFilterCachesInfo> entry : map.entrySet()) {
            String key = entry.getKey();
            StudyModeUrlFilterCachesInfo value = entry.getValue();
            if (value.f() && value.getNeedStoreKernel()) {
                AccessibleLinkFilter$AccessibleLink accessibleLinkFilter$AccessibleLink = new AccessibleLinkFilter$AccessibleLink();
                accessibleLinkFilter$AccessibleLink.url.set(key);
                accessibleLinkFilter$AccessibleLink.expire_time.set(value.getInvalidTime());
                accessibleLinkFilter$AccessibleLinks.links.get().add(accessibleLinkFilter$AccessibleLink);
                value.j(false);
            }
        }
        if (accessibleLinkFilter$AccessibleLinks.links.get().size() == 0) {
            return null;
        }
        QLog.d(TAG, 1, "urlfilter save trans=" + caches);
        try {
            return ByteBuffer.wrap(accessibleLinkFilter$AccessibleLinks.toByteArray());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[buffer] failed" + e16);
            return null;
        }
    }

    public final Map<String, StudyModeUrlFilterCachesInfo> g(byte[] byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "byteBuffer");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            AccessibleLinkFilter$AccessibleLinks accessibleLinkFilter$AccessibleLinks = new AccessibleLinkFilter$AccessibleLinks();
            accessibleLinkFilter$AccessibleLinks.mergeFrom(byteBuffer);
            List<AccessibleLinkFilter$AccessibleLink> list = accessibleLinkFilter$AccessibleLinks.links.get();
            Intrinsics.checkNotNullExpressionValue(list, "links.links.get()");
            for (AccessibleLinkFilter$AccessibleLink accessibleLinkFilter$AccessibleLink : list) {
                String str = accessibleLinkFilter$AccessibleLink.url.get();
                Intrinsics.checkNotNullExpressionValue(str, "link.url.get()");
                StudyModeUrlFilterCachesInfo studyModeUrlFilterCachesInfo = new StudyModeUrlFilterCachesInfo(str, accessibleLinkFilter$AccessibleLink.expire_time.get());
                String str2 = accessibleLinkFilter$AccessibleLink.url.get();
                Intrinsics.checkNotNullExpressionValue(str2, "link.url.get()");
                linkedHashMap.put(str2, studyModeUrlFilterCachesInfo);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[buffer] failed" + e16);
        }
        QLog.d(TAG, 1, "urlfilter read trans=" + linkedHashMap);
        return linkedHashMap;
    }

    public final void d(StudyModeUrlFilterCachesInfo info) {
        if (info != null) {
            Map<String, StudyModeUrlFilterCachesInfo> map = caches;
            StudyModeUrlFilterCachesInfo studyModeUrlFilterCachesInfo = map.get(info.getUrl());
            if (studyModeUrlFilterCachesInfo != null) {
                if (studyModeUrlFilterCachesInfo.a(info)) {
                    return;
                }
                studyModeUrlFilterCachesInfo.g(Math.max(studyModeUrlFilterCachesInfo.getInvalidTime(), info.getInvalidTime()));
                needStore = true;
                studyModeUrlFilterCachesInfo.j(false);
                return;
            }
            if (info.f()) {
                f406087a.h(info.getUrl());
                StudyModeUrlFilterCachesInfo studyModeUrlFilterCachesInfo2 = map.get(info.getUrl());
                if (studyModeUrlFilterCachesInfo2 == null) {
                    return;
                }
                studyModeUrlFilterCachesInfo2.j(false);
            }
        }
    }

    public final void h(String url) {
        if (url == null) {
            return;
        }
        Map<String, StudyModeUrlFilterCachesInfo> map = caches;
        StudyModeUrlFilterCachesInfo studyModeUrlFilterCachesInfo = map.get(url);
        if (studyModeUrlFilterCachesInfo != null) {
            studyModeUrlFilterCachesInfo.l();
        } else {
            map.put(url, new StudyModeUrlFilterCachesInfo(url, NetConnInfoCenter.getServerTimeMillis()));
        }
        needStore = true;
    }

    public final StudyModeUrlFilterCachesInfo i(String url) {
        if (url == null) {
            return null;
        }
        return caches.get(url);
    }
}

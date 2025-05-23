package com.tencent.biz.pubaccount.weishi.verticalvideo.onemore;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001e\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001a\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\bH\u0003J\u0018\u0010\u000f\u001a\u00020\u00042\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0007J\"\u0010\u0011\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0003\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/onemore/b;", "", "LUserGrowth/stSimpleMetaFeed;", "feed", "", "f", "d", "", "", "c", "key", "b", "", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "dataList", "a", "value", "e", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f82218a = new b();

    b() {
    }

    @JvmStatic
    public static final void a(List<? extends j> dataList) {
        stSimpleMetaFeed e16;
        Map<String, String> map_ext;
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        for (j jVar : dataList) {
            if (jVar != null && (e16 = jVar.e()) != null && (map_ext = e16.map_ext) != null) {
                Intrinsics.checkNotNullExpressionValue(map_ext, "map_ext");
                map_ext.remove("is_trigger");
                map_ext.remove("is_insert");
            }
        }
    }

    @JvmStatic
    public static final Map<String, String> c(stSimpleMetaFeed feed) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_trigger", b(feed, "is_trigger"));
        hashMap.put("is_insert", b(feed, "is_insert"));
        return hashMap;
    }

    @JvmStatic
    public static final void d(stSimpleMetaFeed feed) {
        e(feed, "is_insert", "2");
    }

    @JvmStatic
    public static final void f(stSimpleMetaFeed feed) {
        e(feed, "is_trigger", "1");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final String b(stSimpleMetaFeed feed, String key) {
        boolean z16;
        boolean isBlank;
        Map<String, String> map;
        String str = (feed == null || (map = feed.map_ext) == null) ? null : map.get(key);
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                return !z16 ? "0" : str;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @JvmStatic
    private static final void e(stSimpleMetaFeed feed, String key, String value) {
        if (feed == null) {
            return;
        }
        Map<String, String> map = feed.map_ext;
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(key, value);
        feed.map_ext = map;
    }
}

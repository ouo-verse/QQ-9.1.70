package fj;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lfj/a;", "", "", "key", "data", "", "c", "a", "b", "Ljava/util/HashMap;", "Ljava/util/HashMap;", "sDataMaps", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f399444a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Object> sDataMaps = new HashMap<>();

    a() {
    }

    public final Object a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = sDataMaps.get(key);
        QLog.d("GroupAlbumDetailDataManager", 1, "getData | key = " + key + " | object = " + obj);
        return obj;
    }

    public final void b(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        QLog.i("GroupAlbumDetailDataManager", 1, "removeData key = " + key);
        sDataMaps.remove(key);
    }

    public final void c(String key, Object data) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.d("GroupAlbumDetailDataManager", 1, "saveData  transfer key  | key = " + key + " | data = " + data);
        sDataMaps.put(key, data);
    }
}

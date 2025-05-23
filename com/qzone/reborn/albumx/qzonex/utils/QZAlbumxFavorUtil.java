package com.qzone.reborn.albumx.qzonex.utils;

import com.qzone.reborn.albumx.qzonex.bean.layer.QZAlbumxLayerExtraInfoBean;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bR7\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000ej\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/utils/QZAlbumxFavorUtil;", "", "", "key", "", "e", "value", "", "a", "f", "c", "Lic/c;", "shareContext", "d", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Lkotlin/Lazy;", "()Ljava/util/HashMap;", "FAVOR_HASH_MAP", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxFavorUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final QZAlbumxFavorUtil f53383a = new QZAlbumxFavorUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy FAVOR_HASH_MAP;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<String, String>>() { // from class: com.qzone.reborn.albumx.qzonex.utils.QZAlbumxFavorUtil$FAVOR_HASH_MAP$2
            @Override // kotlin.jvm.functions.Function0
            public final HashMap<String, String> invoke() {
                return new HashMap<>();
            }
        });
        FAVOR_HASH_MAP = lazy;
    }

    QZAlbumxFavorUtil() {
    }

    private final HashMap<String, String> b() {
        return (HashMap) FAVOR_HASH_MAP.getValue();
    }

    public final void a(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        b().put(key, value);
    }

    public final String c(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return b().get(key);
    }

    public final String d(ic.c shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        QZAlbumxLayerExtraInfoBean extraInfoBean = shareContext.getExtraInfoBean();
        String uin = extraInfoBean != null ? extraInfoBean.getUin() : null;
        QZAlbumxLayerExtraInfoBean extraInfoBean2 = shareContext.getExtraInfoBean();
        String albumId = extraInfoBean2 != null ? extraInfoBean2.getAlbumId() : null;
        QZAlbumxLayerExtraInfoBean extraInfoBean3 = shareContext.getExtraInfoBean();
        return uin + "_4_" + albumId + "_" + (extraInfoBean3 != null ? extraInfoBean3.getLLoc() : null);
    }

    public final boolean e(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return b().containsKey(key);
    }

    public final void f(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        b().remove(key);
    }
}

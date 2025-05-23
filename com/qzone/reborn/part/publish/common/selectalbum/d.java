package com.qzone.reborn.part.publish.common.selectalbum;

import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.util.i;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/qzone/reborn/part/publish/common/selectalbum/d;", "", "", "bizPrefix", "groupId", "b", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "c", "albumInfo", "", "d", "a", "", "Ljava/util/Map;", "selectedAlbumMap", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f58616a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, CommonAlbumInfo> selectedAlbumMap = new LinkedHashMap();

    d() {
    }

    private final String b(String bizPrefix, String groupId) {
        return bizPrefix + "_" + groupId;
    }

    public final void a(String bizPrefix, String groupId) {
        Intrinsics.checkNotNullParameter(bizPrefix, "bizPrefix");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        selectedAlbumMap.remove(groupId);
        i.b().q(b(bizPrefix, groupId), null);
    }

    public final CommonAlbumInfo c(String bizPrefix, String groupId) {
        Intrinsics.checkNotNullParameter(bizPrefix, "bizPrefix");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Map<String, CommonAlbumInfo> map = selectedAlbumMap;
        CommonAlbumInfo commonAlbumInfo = map.get(groupId);
        if (commonAlbumInfo != null) {
            return commonAlbumInfo;
        }
        CommonAlbumInfo commonAlbumInfo2 = (CommonAlbumInfo) i.b().i(b(bizPrefix, groupId), CommonAlbumInfo.class, null);
        if (commonAlbumInfo2 == null) {
            return null;
        }
        map.put(groupId, commonAlbumInfo2);
        return commonAlbumInfo2;
    }

    public final void d(String bizPrefix, String groupId, CommonAlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(bizPrefix, "bizPrefix");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        selectedAlbumMap.put(groupId, albumInfo);
        i.b().q(b(bizPrefix, groupId), albumInfo);
    }
}

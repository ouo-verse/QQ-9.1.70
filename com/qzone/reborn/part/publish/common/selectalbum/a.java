package com.qzone.reborn.part.publish.common.selectalbum;

import com.qzone.reborn.util.i;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/part/publish/common/selectalbum/a;", "", "", "spaceId", "b", "Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "c", "albumInfo", "", "d", "a", "", "Ljava/util/Map;", "selectedAlbumMap", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f58610a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, QZoneBaseAlbumMeta$AlbumInfo> selectedAlbumMap = new LinkedHashMap();

    a() {
    }

    private final String b(String spaceId) {
        return "intimate_selected_album_info_" + spaceId;
    }

    public final void a(String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        selectedAlbumMap.remove(spaceId);
        i.b().m(b(spaceId), null);
    }

    public final QZoneBaseAlbumMeta$AlbumInfo c(String spaceId) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Map<String, QZoneBaseAlbumMeta$AlbumInfo> map = selectedAlbumMap;
        QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo = map.get(spaceId);
        if (qZoneBaseAlbumMeta$AlbumInfo != null) {
            return qZoneBaseAlbumMeta$AlbumInfo;
        }
        byte[] e16 = i.b().e(b(spaceId), null);
        if (e16 != null) {
            try {
                QZoneBaseAlbumMeta$AlbumInfo mergeFrom = new QZoneBaseAlbumMeta$AlbumInfo().mergeFrom(e16);
                QZoneBaseAlbumMeta$AlbumInfo it = mergeFrom;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                map.put(spaceId, it);
                return mergeFrom;
            } catch (Exception e17) {
                RFWLog.fatal("QZoneIntimateSelectedAlbumRememberUtil", RFWLog.USR, e17);
            }
        }
        return null;
    }

    public final void d(String spaceId, QZoneBaseAlbumMeta$AlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        selectedAlbumMap.put(spaceId, albumInfo);
        i.b().m(b(spaceId), albumInfo.toByteArray());
    }
}

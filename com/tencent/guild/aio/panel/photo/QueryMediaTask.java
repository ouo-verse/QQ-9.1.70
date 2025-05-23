package com.tencent.guild.aio.panel.photo;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.activity.photo.FlowThumbDecoder;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.QAlbumBaseUtil;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.utils.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u0006B)\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0018\u0010\u0014\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0002\u0012\u0004\u0012\u00020\u00050\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR)\u0010\u0014\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u0002\u0012\u0004\u0012\u00020\u00050\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/guild/aio/panel/photo/QueryMediaTask;", "Ljava/lang/Runnable;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "l", "", "a", TencentLocation.RUN_MODE, "", "d", "Z", "getShowVideo", "()Z", "showVideo", "Lkotlin/Function1;", "Lcom/tencent/guild/api/media/album/e;", "e", "Lkotlin/jvm/functions/Function1;", "getCb", "()Lkotlin/jvm/functions/Function1;", "cb", "<init>", "(ZLkotlin/jvm/functions/Function1;)V", "f", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class QueryMediaTask implements Runnable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean showVideo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<List<? extends com.tencent.guild.api.media.album.e>, Unit> cb;

    /* JADX WARN: Multi-variable type inference failed */
    public QueryMediaTask(boolean z16, @NotNull Function1<? super List<? extends com.tencent.guild.api.media.album.e>, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.showVideo = z16;
        this.cb = cb5;
    }

    private final void a(List<? extends LocalMediaInfo> l3) {
        int i3;
        int i16;
        int size = l3.size();
        HashMap hashMap = new HashMap(l3.size());
        for (int i17 = 0; i17 < size; i17++) {
            try {
                LocalMediaInfo localMediaInfo = l3.get(i17);
                if (localMediaInfo.path != null) {
                    localMediaInfo.mMediaType = -1;
                    int mediaType = QAlbumUtil.getMediaType(localMediaInfo);
                    if (mediaType != 0) {
                        if (mediaType == 1) {
                            localMediaInfo.mMediaType = 1;
                        }
                    } else {
                        localMediaInfo.mMediaType = 0;
                    }
                    String str = localMediaInfo.path;
                    Intrinsics.checkNotNullExpressionValue(str, "info.path");
                    hashMap.put(str, localMediaInfo);
                    localMediaInfo.position = Integer.valueOf(i17);
                    int a16 = x.a(202.0f);
                    int i18 = localMediaInfo.orientation;
                    if (i18 != 90 && i18 != 270) {
                        localMediaInfo.thumbWidth = a16 / 2;
                        localMediaInfo.thumbHeight = a16 / 2;
                        int i19 = localMediaInfo.mediaWidth;
                        if (i19 > 0 && (i16 = localMediaInfo.mediaHeight) > 0) {
                            FlowThumbDecoder.determineThumbSize(localMediaInfo, i19, i16);
                        }
                    }
                    localMediaInfo.thumbWidth = a16 / 2;
                    localMediaInfo.thumbHeight = a16 / 2;
                    int i26 = localMediaInfo.mediaWidth;
                    if (i26 > 0 && (i3 = localMediaInfo.mediaHeight) > 0) {
                        FlowThumbDecoder.determineThumbSize(localMediaInfo, i26, i3);
                        int i27 = localMediaInfo.thumbWidth;
                        localMediaInfo.thumbWidth = localMediaInfo.thumbHeight;
                        localMediaInfo.thumbHeight = i27;
                    }
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaFileFilter filter;
        int collectionSizeOrDefault;
        if (this.showVideo) {
            filter = MediaFileFilter.getFilter(5);
        } else {
            filter = MediaFileFilter.getFilter(6);
        }
        MediaFileFilter mediaFileFilter = filter;
        mediaFileFilter.needWebp = true;
        List<LocalMediaInfo> albumMedias = QAlbumBaseUtil.getAlbumMedias(BaseApplication.context, QAlbumCustomAlbumConstants.RECENT_ALBUM_ID, null, 100, mediaFileFilter, 0, 0, true, null, false, -1L);
        if (albumMedias != null && albumMedias.size() != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("QueryMediaTask", 2, "get album medias size : " + albumMedias.size());
            }
            a(albumMedias);
            if (QLog.isColorLevel()) {
                QLog.d("QueryMediaTask", 2, "QueryMediaTask,mediaList.size :" + albumMedias.size());
            }
            Function1<List<? extends com.tencent.guild.api.media.album.e>, Unit> function1 = this.cb;
            List<LocalMediaInfo> list = albumMedias;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (LocalMediaInfo it : list) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(new com.tencent.guild.api.media.album.impl.a(it));
            }
            function1.invoke(arrayList);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QueryMediaTask", 2, "QueryMediaTask getAlbumMedias is null");
        }
    }
}

package com.qzone.reborn.groupalbum.reship.util;

import android.content.Context;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.groupalbum.reship.bean.GroupAlbumReshipInitBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.ArrayUtils;
import ho.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J6\u0010\f\u001a\u00020\u000b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJF\u0010\u0011\u001a\u00020\u000b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/groupalbum/reship/util/GroupAlbumReshipUtil;", "", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "Lkotlin/collections/ArrayList;", "mediaList", "", "groupId", "albumId", "Landroid/content/Context;", "context", "", "a", "", "sourceBatchId", "", "overLimitNum", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumReshipUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final GroupAlbumReshipUtil f56889a = new GroupAlbumReshipUtil();

    GroupAlbumReshipUtil() {
    }

    public final void a(ArrayList<CommonStMedia> mediaList, String groupId, String albumId, Context context) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(context, "context");
        b(mediaList, groupId, albumId, context, 0L, 0);
    }

    public final void b(ArrayList<CommonStMedia> mediaList, String groupId, String albumId, Context context, long sourceBatchId, int overLimitNum) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(context, "context");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.to9, 0).show();
            return;
        }
        int size = mediaList.size();
        CollectionsKt__MutableCollectionsKt.retainAll((List) mediaList, (Function1) new Function1<CommonStMedia, Boolean>() { // from class: com.qzone.reborn.groupalbum.reship.util.GroupAlbumReshipUtil$handleReship$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(CommonStMedia it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(!it.u());
            }
        });
        int size2 = mediaList.size();
        if (size2 == 0) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.to6, 0).show();
            return;
        }
        if (size2 < size) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f169543to4, 0).show();
        }
        CommonAlbumInfo commonAlbumInfo = new CommonAlbumInfo();
        commonAlbumInfo.V(albumId);
        i.m().l(context, new GroupAlbumReshipInitBean(groupId, commonAlbumInfo, mediaList, sourceBatchId, overLimitNum));
    }
}

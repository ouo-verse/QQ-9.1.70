package com.qzone.reborn.feedx.util;

import cooperation.qzone.QZoneHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/feedx/util/o;", "", "", "fragmentName", "", "a", "", "b", "Ljava/util/List;", "mQzoneProcessFragmentList", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f55766a = new o();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static List<String> mQzoneProcessFragmentList;

    static {
        List<String> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("com.qzone.publish.ui.activity.QZonePublishQueueAcitvity", "com.qzone.publish.ui.activity.QZoneUploadQualityActivity", QZoneHelper.PERSONAL_ALBUM_SELECT, "com.qzone.album.ui.activity.QZonePersonalAlbumAnswerActivity", "com.qzone.album.business.photolist.activity.QZoneSharingOwnersListActivity", "com.qzone.album.business.editalbum.QZoneNewAlbumActivity", "com.qzone.reborn.albumx.qzone.fragment.QZoneAlbumxLocalPhotoRecommendMediaListFragment", "com.qzone.reborn.albumx.qzone.fragment.QZoneAlbumxLocalPhotoRecommendMediaListFragment", "com.qzone.reborn.albumx.qzone.fragment.QZoneLocalPhotoRecommendStandaloneFragment");
        mQzoneProcessFragmentList = mutableListOf;
    }

    o() {
    }

    public final boolean a(String fragmentName) {
        Intrinsics.checkNotNullParameter(fragmentName, "fragmentName");
        return !mQzoneProcessFragmentList.contains(fragmentName);
    }
}

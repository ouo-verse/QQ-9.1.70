package com.qzone.reborn.groupalbum.part.feed;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.groupalbum.viewmodel.GroupAlbumFeedDetailViewModel;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/feed/p;", "Lcom/qzone/reborn/groupalbum/part/feed/j;", "Lgf/a;", "", "feedId", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "I9", "", "K9", "getDtPageId", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class p extends j {
    @Override // com.qzone.reborn.groupalbum.part.feed.j
    public BusinessFeedData I9(String feedId) {
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = (GroupAlbumFeedDetailViewModel) getViewModel(GroupAlbumFeedDetailViewModel.class);
        if (groupAlbumFeedDetailViewModel != null) {
            return groupAlbumFeedDetailViewModel.d2();
        }
        return null;
    }

    @Override // com.qzone.reborn.groupalbum.part.feed.j
    public int K9() {
        return ((GroupAlbumFeedDetailViewModel) getViewModel(GroupAlbumFeedDetailViewModel.class)).getScene();
    }

    @Override // com.qzone.reborn.groupalbum.part.feed.j
    public String getDtPageId() {
        return "pg_qz_group_album_dynamic_details";
    }
}

package com.qzone.reborn.groupalbum.part.feed;

import androidx.lifecycle.MutableLiveData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.groupalbum.viewmodel.GroupAlbumFeedDetailViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.richframework.data.base.UIStateData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\n"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/feed/r;", "Lcom/qzone/reborn/feedx/part/detail/u;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "J9", "", "L9", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class r extends com.qzone.reborn.feedx.part.detail.u {
    @Override // com.qzone.reborn.feedx.part.detail.u
    public BusinessFeedData J9() {
        MutableLiveData<UIStateData<BusinessFeedData>> i26;
        UIStateData<BusinessFeedData> value;
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = (GroupAlbumFeedDetailViewModel) getViewModel(GroupAlbumFeedDetailViewModel.class);
        if (groupAlbumFeedDetailViewModel == null || (i26 = groupAlbumFeedDetailViewModel.i2()) == null || (value = i26.getValue()) == null) {
            return null;
        }
        return value.getData();
    }

    @Override // com.qzone.reborn.feedx.part.detail.u
    protected boolean L9() {
        return false;
    }
}

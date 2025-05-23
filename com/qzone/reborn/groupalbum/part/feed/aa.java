package com.qzone.reborn.groupalbum.part.feed;

import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.groupalbum.event.GroupAlbumLayerCommentEvent;
import com.qzone.reborn.groupalbum.viewmodel.GroupAlbumFeedDetailViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/feed/aa;", "Lcom/qzone/reborn/groupalbum/part/feed/z;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/qzone/reborn/groupalbum/event/GroupAlbumLayerCommentEvent;", "event", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "D9", "Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumFeedDetailViewModel;", "d", "Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumFeedDetailViewModel;", "feedDetailViewModel", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class aa extends z {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GroupAlbumFeedDetailViewModel feedDetailViewModel;

    @Override // com.qzone.reborn.groupalbum.part.feed.z
    public BusinessFeedData D9(GroupAlbumLayerCommentEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = null;
        if (!event.getFromFeedDetail()) {
            return null;
        }
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel2 = this.feedDetailViewModel;
        if (groupAlbumFeedDetailViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedDetailViewModel");
        } else {
            groupAlbumFeedDetailViewModel = groupAlbumFeedDetailViewModel2;
        }
        return groupAlbumFeedDetailViewModel.d2();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(GroupAlbumFeedDetailViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumF\u2026ailViewModel::class.java)");
        this.feedDetailViewModel = (GroupAlbumFeedDetailViewModel) viewModel;
    }
}

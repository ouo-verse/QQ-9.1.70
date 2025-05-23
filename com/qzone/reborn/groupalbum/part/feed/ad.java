package com.qzone.reborn.groupalbum.part.feed;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.groupalbum.event.GroupAlbumLayerDeleteImageEvent;
import com.qzone.reborn.groupalbum.viewmodel.GroupAlbumFeedDetailViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/feed/ad;", "Lcom/qzone/reborn/groupalbum/part/feed/ac;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Lcom/qzone/reborn/groupalbum/event/GroupAlbumLayerDeleteImageEvent;", "event", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "C9", "", "feedId", "D9", "feedData", "E9", "Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumFeedDetailViewModel;", "d", "Lcom/qzone/reborn/groupalbum/viewmodel/GroupAlbumFeedDetailViewModel;", "feedDetailViewModel", "", "e", "Z", "shouldExit", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ad extends ac {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GroupAlbumFeedDetailViewModel feedDetailViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean shouldExit;

    @Override // com.qzone.reborn.groupalbum.part.feed.ac
    public BusinessFeedData C9(GroupAlbumLayerDeleteImageEvent event) {
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

    @Override // com.qzone.reborn.groupalbum.part.feed.ac
    public void D9(String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        this.shouldExit = true;
    }

    @Override // com.qzone.reborn.groupalbum.part.feed.ac
    public void E9(GroupAlbumLayerDeleteImageEvent event, BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        GroupAlbumFeedDetailViewModel groupAlbumFeedDetailViewModel = this.feedDetailViewModel;
        if (groupAlbumFeedDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedDetailViewModel");
            groupAlbumFeedDetailViewModel = null;
        }
        groupAlbumFeedDetailViewModel.Z1();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(GroupAlbumFeedDetailViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumF\u2026ailViewModel::class.java)");
        this.feedDetailViewModel = (GroupAlbumFeedDetailViewModel) viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        if (!this.shouldExit || activity == null) {
            return;
        }
        activity.onBackPressed();
    }
}

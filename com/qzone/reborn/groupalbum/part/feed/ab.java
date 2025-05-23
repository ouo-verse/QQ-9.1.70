package com.qzone.reborn.groupalbum.part.feed;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.reborn.groupalbum.event.GroupAlbumLayerCommentEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.ArrayUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/feed/ab;", "Lcom/qzone/reborn/groupalbum/part/feed/z;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/qzone/reborn/groupalbum/event/GroupAlbumLayerCommentEvent;", "event", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "D9", "Lcom/qzone/reborn/groupalbum/viewmodel/z;", "d", "Lcom/qzone/reborn/groupalbum/viewmodel/z;", "feedViewModel", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ab extends z {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.groupalbum.viewmodel.z feedViewModel;

    @Override // com.qzone.reborn.groupalbum.part.feed.z
    public BusinessFeedData D9(GroupAlbumLayerCommentEvent event) {
        BusinessFeedData businessFeedData;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getFromFeedDetail()) {
            return null;
        }
        com.qzone.reborn.groupalbum.viewmodel.z zVar = this.feedViewModel;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedViewModel");
            zVar = null;
        }
        UIStateData<List<BusinessFeedData>> value = zVar.d2().getValue();
        List<BusinessFeedData> data = value != null ? value.getData() : null;
        if (ArrayUtils.isOutOfArrayIndex(0, data)) {
            return null;
        }
        Intrinsics.checkNotNull(data);
        Iterator<BusinessFeedData> it = data.iterator();
        while (true) {
            if (!it.hasNext()) {
                businessFeedData = null;
                break;
            }
            businessFeedData = it.next();
            CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
            if (TextUtils.equals(feedCommInfo != null ? feedCommInfo.feedsid : null, event.getFeedId())) {
                break;
            }
        }
        if (businessFeedData != null) {
            return businessFeedData;
        }
        com.tencent.qqcamerakit.common.e.d("GroupAlbumSyncCommentFeedListPart", 1, "not find feedData need to be praised");
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(com.qzone.reborn.groupalbum.viewmodel.z.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumFeedViewModel::class.java)");
        this.feedViewModel = (com.qzone.reborn.groupalbum.viewmodel.z) viewModel;
    }
}

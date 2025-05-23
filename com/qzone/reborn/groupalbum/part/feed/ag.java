package com.qzone.reborn.groupalbum.part.feed;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.reborn.base.n;
import com.qzone.reborn.groupalbum.event.GroupAlbumLayerDeleteImageEvent;
import com.qzone.util.ToastUtil;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.ArrayUtils;
import java.util.Iterator;
import java.util.List;
import ki.ai;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/feed/ag;", "Lcom/qzone/reborn/groupalbum/part/feed/ac;", "", "feedId", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "K9", "Lcom/qzone/reborn/groupalbum/event/GroupAlbumLayerDeleteImageEvent;", "event", "feedData", "", "L9", "N9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "C9", "D9", "E9", "Lcom/qzone/reborn/groupalbum/viewmodel/z;", "d", "Lcom/qzone/reborn/groupalbum/viewmodel/z;", "feedViewModel", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ag extends ac {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.groupalbum.viewmodel.z feedViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/groupalbum/part/feed/ag$b", "Lcom/qzone/reborn/base/n$a;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "updateFeedData", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements n.a<BusinessFeedData> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f56741b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GroupAlbumLayerDeleteImageEvent f56742c;

        b(String str, GroupAlbumLayerDeleteImageEvent groupAlbumLayerDeleteImageEvent) {
            this.f56741b = str;
            this.f56742c = groupAlbumLayerDeleteImageEvent;
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BusinessFeedData updateFeedData, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(updateFeedData, "updateFeedData");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            BusinessFeedData K9 = ag.this.K9(this.f56741b);
            if (K9 != null) {
                GroupAlbumLayerDeleteImageEvent groupAlbumLayerDeleteImageEvent = this.f56742c;
                K9.setCellPictureInfo(updateFeedData.cellPictureInfo);
                K9.cellMediaInfo = updateFeedData.cellMediaInfo;
                if (!groupAlbumLayerDeleteImageEvent.getFromFeedDetail()) {
                    K9.setCellCommentInfo(updateFeedData.getCommentInfoV2());
                }
            }
            ag.this.N9();
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            ToastUtil.s(errorMsg, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BusinessFeedData K9(String feedId) {
        BusinessFeedData businessFeedData;
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
            if (TextUtils.equals(feedCommInfo != null ? feedCommInfo.feedsid : null, feedId)) {
                break;
            }
        }
        if (businessFeedData != null) {
            return businessFeedData;
        }
        com.tencent.qqcamerakit.common.e.d("GroupAlbumSyncImageFeedListPart", 1, "not find feedData need to be praised");
        return null;
    }

    private final void L9(final GroupAlbumLayerDeleteImageEvent event, BusinessFeedData feedData) {
        com.qzone.reborn.groupalbum.viewmodel.z zVar = this.feedViewModel;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedViewModel");
            zVar = null;
        }
        final String groupId = zVar.getGroupId();
        final String a16 = ef.b.a(feedData);
        if (a16 == null || a16.length() == 0) {
            return;
        }
        if (groupId == null || groupId.length() == 0) {
            return;
        }
        final String str = feedData.cellMediaInfo.albumId;
        final String batchId = event.getBatchId();
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.groupalbum.part.feed.ae
            @Override // java.lang.Runnable
            public final void run() {
                ag.M9(groupId, a16, str, batchId, this, event);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(String groupId, String str, String albumId, String batchId, ag this$0, GroupAlbumLayerDeleteImageEvent event) {
        Intrinsics.checkNotNullParameter(groupId, "$groupId");
        Intrinsics.checkNotNullParameter(batchId, "$batchId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "$event");
        ai aiVar = ai.f412446a;
        Intrinsics.checkNotNullExpressionValue(albumId, "albumId");
        aiVar.a(groupId, str, albumId, batchId, new b(str, event));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9() {
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.groupalbum.part.feed.af
            @Override // java.lang.Runnable
            public final void run() {
                ag.O9(ag.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(ag this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.qzone.reborn.groupalbum.viewmodel.z zVar = this$0.feedViewModel;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedViewModel");
            zVar = null;
        }
        zVar.i2();
    }

    @Override // com.qzone.reborn.groupalbum.part.feed.ac
    public BusinessFeedData C9(GroupAlbumLayerDeleteImageEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return K9(event.getFeedId());
    }

    @Override // com.qzone.reborn.groupalbum.part.feed.ac
    public void D9(String feedId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        com.qzone.reborn.groupalbum.viewmodel.z zVar = this.feedViewModel;
        com.qzone.reborn.groupalbum.viewmodel.z zVar2 = null;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedViewModel");
            zVar = null;
        }
        BusinessFeedData b26 = zVar.b2(feedId);
        if (b26 != null) {
            com.qzone.reborn.groupalbum.viewmodel.z zVar3 = this.feedViewModel;
            if (zVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedViewModel");
            } else {
                zVar2 = zVar3;
            }
            zVar2.f2(b26);
        }
    }

    @Override // com.qzone.reborn.groupalbum.part.feed.ac
    public void E9(GroupAlbumLayerDeleteImageEvent event, BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        L9(event, feedData);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(com.qzone.reborn.groupalbum.viewmodel.z.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumFeedViewModel::class.java)");
        this.feedViewModel = (com.qzone.reborn.groupalbum.viewmodel.z) viewModel;
    }
}

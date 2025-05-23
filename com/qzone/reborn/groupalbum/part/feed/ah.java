package com.qzone.reborn.groupalbum.part.feed;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.reborn.groupalbum.event.GroupAlbumLayerPraiseEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00130\u0012H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/feed/ah;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/qzone/reborn/groupalbum/event/GroupAlbumLayerPraiseEvent;", "event", "", "C9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/qzone/reborn/groupalbum/viewmodel/z;", "d", "Lcom/qzone/reborn/groupalbum/viewmodel/z;", "feedViewModel", "Lcom/qzone/reborn/groupalbum/viewmodel/x;", "e", "Lcom/qzone/reborn/groupalbum/viewmodel/x;", "praiseViewModel", "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ah extends com.qzone.reborn.base.k implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.groupalbum.viewmodel.z feedViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.groupalbum.viewmodel.x praiseViewModel;

    private final void C9(GroupAlbumLayerPraiseEvent event) {
        com.qzone.reborn.groupalbum.viewmodel.z zVar = this.feedViewModel;
        if (zVar == null || this.praiseViewModel == null) {
            return;
        }
        Intrinsics.checkNotNull(zVar);
        UIStateData<List<BusinessFeedData>> value = zVar.d2().getValue();
        BusinessFeedData businessFeedData = null;
        List<BusinessFeedData> data = value != null ? value.getData() : null;
        if (ArrayUtils.isOutOfArrayIndex(0, data)) {
            return;
        }
        Intrinsics.checkNotNull(data);
        Iterator<BusinessFeedData> it = data.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            BusinessFeedData next = it.next();
            CellFeedCommInfo feedCommInfo = next.getFeedCommInfo();
            if (TextUtils.equals(feedCommInfo != null ? feedCommInfo.feedsid : null, event.getFeedId())) {
                businessFeedData = next;
                break;
            }
        }
        if (businessFeedData == null) {
            com.tencent.qqcamerakit.common.e.d("GroupAlbumSyncPraisePart", 1, "not find feedData need to be praised");
            return;
        }
        CellLikeInfo cellLikeInfo = businessFeedData.cellLikeInfo;
        if (cellLikeInfo != null && cellLikeInfo.isLiked) {
            com.tencent.qqcamerakit.common.e.e("GroupAlbumSyncPraisePart", 1, "this feed has been praised yet, not need to praise again");
            return;
        }
        com.qzone.reborn.groupalbum.viewmodel.x xVar = this.praiseViewModel;
        Intrinsics.checkNotNull(xVar);
        xVar.M1(businessFeedData);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        this.feedViewModel = (com.qzone.reborn.groupalbum.viewmodel.z) getViewModel(com.qzone.reborn.groupalbum.viewmodel.z.class);
        this.praiseViewModel = (com.qzone.reborn.groupalbum.viewmodel.x) getViewModel(com.qzone.reborn.groupalbum.viewmodel.x.class);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof GroupAlbumLayerPraiseEvent) {
            C9((GroupAlbumLayerPraiseEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GroupAlbumLayerPraiseEvent.class);
        return arrayListOf;
    }
}

package com.qzone.reborn.groupalbum.part.feed;

import android.app.Activity;
import android.os.Bundle;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.reborn.groupalbum.event.GroupAlbumLayerDeleteImageEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\u000e\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00170\u0016H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/qzone/reborn/groupalbum/part/feed/ac;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/qzone/reborn/groupalbum/event/GroupAlbumLayerDeleteImageEvent;", "event", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "F9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "C9", "", "feedId", "D9", "E9", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class ac extends com.qzone.reborn.base.k implements SimpleEventReceiver<SimpleBaseEvent> {
    private final void F9(GroupAlbumLayerDeleteImageEvent event, BusinessFeedData feedData) {
        ArrayList<PictureItem> arrayList;
        String feedId = event.getFeedId();
        boolean z16 = false;
        boolean z17 = feedData.getVideoInfo() != null;
        CellPictureInfo cellPictureInfo = feedData.cellPictureInfo;
        if (cellPictureInfo != null && (arrayList = cellPictureInfo.pics) != null && arrayList.size() <= 1) {
            z16 = true;
        }
        if (!z17 && !z16) {
            E9(event, feedData);
        } else {
            D9(feedId);
        }
    }

    public abstract BusinessFeedData C9(GroupAlbumLayerDeleteImageEvent event);

    public abstract void D9(String feedId);

    public abstract void E9(GroupAlbumLayerDeleteImageEvent event, BusinessFeedData feedData);

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
        GroupAlbumLayerDeleteImageEvent groupAlbumLayerDeleteImageEvent;
        BusinessFeedData C9;
        if (!(event instanceof GroupAlbumLayerDeleteImageEvent) || (C9 = C9((groupAlbumLayerDeleteImageEvent = (GroupAlbumLayerDeleteImageEvent) event))) == null) {
            return;
        }
        F9(groupAlbumLayerDeleteImageEvent, C9);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GroupAlbumLayerDeleteImageEvent.class);
        return arrayListOf;
    }
}

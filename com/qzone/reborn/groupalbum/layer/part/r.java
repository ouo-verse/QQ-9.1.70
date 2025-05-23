package com.qzone.reborn.groupalbum.layer.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.groupalbum.event.GroupAlbumDeleteMediaEvent;
import com.qzone.reborn.groupalbum.event.GroupAlbumLayerDeleteImageEvent;
import com.qzone.reborn.intimate.event.QZoneLayerPostDataEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J6\u0010\r\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00072\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007H\u0002J\b\u0010\u000e\u001a\u00020\nH\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00180\u0007H\u0016J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u001aH\u0016R\u0014\u0010\u001e\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/qzone/reborn/groupalbum/layer/part/r;", "Lcom/qzone/reborn/groupalbum/layer/part/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/qzone/reborn/groupalbum/event/GroupAlbumDeleteMediaEvent;", "event", "", "D9", "Ljava/util/ArrayList;", "Lci/a;", "mediaList", "", "feedIdList", "batchList", "E9", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", tl.h.F, "Ljava/lang/String;", "TAG", "i", "sourceFeedId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "fromFeedDetail", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class r extends b implements SimpleEventReceiver<GroupAlbumDeleteMediaEvent> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "GroupAlbumLayerDeletePart";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String sourceFeedId = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean fromFeedDetail;

    private final void D9(GroupAlbumDeleteMediaEvent event) {
        List<? extends RFWLayerItemMediaInfo> mutableList;
        if (ArrayUtils.isOutOfArrayIndex(0, event.getDeleteList())) {
            RFWLog.e(getTAG(), RFWLog.USR, "media list is empty");
            return;
        }
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        Intrinsics.checkNotNull(value);
        RFWLayerState data = value.getData();
        if (data == null) {
            RFWLog.e(this.TAG, RFWLog.USR, "layer state data is null");
            return;
        }
        List<RFWLayerItemMediaInfo> richMediaDataList = data.getRichMediaDataList();
        if (ArrayUtils.isOutOfArrayIndex(this.mSelectedPosition, richMediaDataList)) {
            RFWLog.e(this.TAG, RFWLog.USR, "mSelectedPosition is out of bounds");
            return;
        }
        if (richMediaDataList == null) {
            return;
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) richMediaDataList);
        if (((RFWLayerItemMediaInfo) mutableList.remove(this.mSelectedPosition)) == null) {
            RFWLog.e(this.TAG, RFWLog.USR, "delete fail");
            return;
        }
        if (mutableList.isEmpty()) {
            onBackEvent();
            Activity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        RFWLayerState rFWLayerState = new RFWLayerState();
        rFWLayerState.setSelectedPosition(data.getSelectedPosition());
        rFWLayerState.setMediaSum(data.getMediaSum());
        rFWLayerState.setPositionOffset(data.getPositionOffset());
        rFWLayerState.setRichMediaDataList(mutableList);
        rFWLayerState.setMediaSum(rFWLayerState.getMediaSum() - 1);
        if (rFWLayerState.getSelectedPosition() > 0) {
            rFWLayerState.setSelectedPosition(rFWLayerState.getSelectedPosition() - 1);
        } else {
            rFWLayerState.setSelectedPosition(0);
        }
        UIStateData<RFWLayerState> rfwLayerInfoUIStateData = UIStateData.obtainSuccess(true);
        rfwLayerInfoUIStateData.setDataList(rFWLayerState);
        o9.e eVar = new o9.e();
        eVar.c(rFWLayerState);
        Intrinsics.checkNotNullExpressionValue(rfwLayerInfoUIStateData, "rfwLayerInfoUIStateData");
        eVar.d(rfwLayerInfoUIStateData);
        QZoneLayerPostDataEvent qZoneLayerPostDataEvent = new QZoneLayerPostDataEvent(eVar);
        qZoneLayerPostDataEvent.setLayerDeleteEventTrigger(true);
        SimpleEventBus.getInstance().dispatchEvent(qZoneLayerPostDataEvent);
    }

    private final void E9(ArrayList<ci.a> mediaList, ArrayList<String> feedIdList, ArrayList<String> batchList) {
        if (mediaList.isEmpty()) {
            RFWLog.e(getTAG(), RFWLog.USR, "notifyFeedListUpdate mediaList empty");
            return;
        }
        if (feedIdList.isEmpty()) {
            RFWLog.e(getTAG(), RFWLog.USR, "notifyFeedListUpdate feedIdList empty");
            return;
        }
        if (batchList.isEmpty()) {
            RFWLog.e(getTAG(), RFWLog.USR, "notifyFeedListUpdate batchList empty");
            return;
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        boolean z16 = this.fromFeedDetail;
        String str = feedIdList.get(0);
        Intrinsics.checkNotNull(str);
        String str2 = str;
        String str3 = batchList.get(0);
        Intrinsics.checkNotNull(str3);
        simpleEventBus.dispatchEvent(new GroupAlbumLayerDeleteImageEvent(z16, str2, str3, mediaList.get(0).getCom.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent.KEY_IS_VIDEO java.lang.String(), mediaList.get(0).getLLoc()));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<GroupAlbumDeleteMediaEvent>> getEventClass() {
        ArrayList<Class<GroupAlbumDeleteMediaEvent>> arrayList = new ArrayList<>();
        arrayList.add(GroupAlbumDeleteMediaEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intent intent;
        super.onInitView(rootView);
        Activity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey("key_feed_id")) {
            String stringExtra = intent.getStringExtra("key_feed_id");
            if (stringExtra == null) {
                stringExtra = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(stringExtra, "it.getStringExtra(GroupA\u2026Launcher.KEY_FEED_ID)?:\"\"");
            }
            this.sourceFeedId = stringExtra;
        }
        Bundle extras2 = intent.getExtras();
        if (extras2 != null && extras2.containsKey("key_is_detail_layer")) {
            this.fromFeedDetail = intent.getBooleanExtra("key_is_detail_layer", false);
        }
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.i, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
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
        if (event instanceof GroupAlbumDeleteMediaEvent) {
            GroupAlbumDeleteMediaEvent groupAlbumDeleteMediaEvent = (GroupAlbumDeleteMediaEvent) event;
            D9(groupAlbumDeleteMediaEvent);
            E9(groupAlbumDeleteMediaEvent.getDeleteList(), groupAlbumDeleteMediaEvent.getFeedList(), groupAlbumDeleteMediaEvent.getBatchList());
        }
    }
}

package com.qzone.reborn.albumx.qzonex.part.albumdetail;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.qzone.reborn.albumx.common.convert.bean.CommonBatchInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxEditMediaEvent;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxLayerPraiseEvent;
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
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 %2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u001c\u0010\u0013\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u001c\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a0\u0019j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a`\u001bH\u0016R\u001b\u0010\"\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/albumdetail/QZAlbumxSyncDataPart;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxEditMediaEvent;", "event", "", "E9", "Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxLayerPraiseEvent;", "F9", "", "linkId", "lloc", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "C9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lnc/y;", "d", "Lkotlin/Lazy;", "D9", "()Lnc/y;", "feedViewModel", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZAlbumxSyncDataPart extends com.qzone.reborn.base.k implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy feedViewModel;

    public QZAlbumxSyncDataPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<nc.y>() { // from class: com.qzone.reborn.albumx.qzonex.part.albumdetail.QZAlbumxSyncDataPart$feedViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final nc.y invoke() {
                return (nc.y) QZAlbumxSyncDataPart.this.getViewModel(nc.y.class);
            }
        });
        this.feedViewModel = lazy;
    }

    private final CommonStMedia C9(String linkId, String lloc) {
        com.qzone.reborn.albumx.common.bean.a aVar;
        CommonBatchInfo batchInfo;
        List<CommonStMedia> j3;
        UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> value = D9().O1().getValue();
        List<com.qzone.reborn.albumx.common.bean.a> data = value != null ? value.getData() : null;
        if (data == null || ArrayUtils.isOutOfArrayIndex(0, data)) {
            return null;
        }
        Iterator<com.qzone.reborn.albumx.common.bean.a> it = data.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            }
            aVar = it.next();
            if (TextUtils.equals(String.valueOf(aVar.getBatchInfo().getLinkId()), linkId)) {
                break;
            }
        }
        if (aVar != null && (batchInfo = aVar.getBatchInfo()) != null && (j3 = batchInfo.j()) != null) {
            for (CommonStMedia commonStMedia : j3) {
                if (TextUtils.equals(commonStMedia.k(), lloc)) {
                    return commonStMedia;
                }
            }
        }
        return null;
    }

    private final nc.y D9() {
        Object value = this.feedViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-feedViewModel>(...)");
        return (nc.y) value;
    }

    private final void E9(QZAlbumxEditMediaEvent event) {
        CommonStMedia C9 = C9(event.getLinkId(), event.getLloc());
        if (C9 == null) {
            return;
        }
        C9.x(event.getDesc());
    }

    private final void F9(QZAlbumxLayerPraiseEvent event) {
        CommonStMedia C9 = C9(event.getLinkId(), event.getLLoc());
        if (C9 == null) {
            return;
        }
        C9.getLike().f(event.getIsLike() ? 1 : 0);
        C9.getLike().g(event.getLikeCount());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
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
        if (event instanceof QZAlbumxLayerPraiseEvent) {
            F9((QZAlbumxLayerPraiseEvent) event);
        } else if (event instanceof QZAlbumxEditMediaEvent) {
            E9((QZAlbumxEditMediaEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZAlbumxLayerPraiseEvent.class, QZAlbumxEditMediaEvent.class);
        return arrayListOf;
    }
}

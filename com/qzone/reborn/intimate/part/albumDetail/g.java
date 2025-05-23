package com.qzone.reborn.intimate.part.albumDetail;

import android.app.Activity;
import android.os.Bundle;
import com.qzone.reborn.albumx.common.part.CommonAlbumDetailBodyPart;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.qzone.reborn.intimate.event.QZoneIntimateUploadAlbumEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nk.w;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\u0011\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f0\u000ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f`\u0010H\u0016J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/intimate/part/albumDetail/g;", "Lcom/qzone/reborn/albumx/common/part/CommonAlbumDetailBodyPart;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/qzone/reborn/intimate/event/QZoneIntimateUploadAlbumEvent;", "event", "", "ua", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onReceiveEvent", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class g extends CommonAlbumDetailBodyPart implements SimpleEventReceiver<SimpleBaseEvent> {
    private final void ua(QZoneIntimateUploadAlbumEvent event) {
        if (ca() && (K9() instanceof w)) {
            com.qzone.reborn.albumx.common.viewmodel.b K9 = K9();
            Intrinsics.checkNotNull(K9, "null cannot be cast to non-null type com.qzone.reborn.intimate.viewmodel.QZoneIntimateAlbumDetailViewModel");
            QZoneIntimateAlbumDetailInitBean initBean = ((w) K9).getInitBean();
            if (Intrinsics.areEqual(event.getSpaceId(), initBean != null ? initBean.getSpaceId() : null) && Intrinsics.areEqual(event.getAlbumId(), initBean.getAlbumId())) {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.intimate.part.albumDetail.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.va(g.this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.T9().autoRefresh();
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailBodyPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.qzone.reborn.albumx.common.part.CommonAlbumDetailBodyPart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZoneIntimateUploadAlbumEvent) {
            ua((QZoneIntimateUploadAlbumEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZoneIntimateUploadAlbumEvent.class);
        return arrayListOf;
    }
}

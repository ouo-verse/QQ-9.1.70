package com.qzone.reborn.albumx.qzonex.part.pictab;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.qzone.reborn.albumx.common.convert.bean.CommonPhotoInfo;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxEditMediaEvent;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxLayerPraiseEvent;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxTabLayerDeleteMediaEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nc.bp;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 &2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001'B\u000f\u0012\u0006\u0010#\u001a\u00020\u001e\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000fH\u0002J\u001c\u0010\u0015\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001c0\u001bH\u0016R\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/pictab/q;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxLayerPraiseEvent;", "event", "", "F9", "Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxEditMediaEvent;", "E9", "", "linkId", "lloc", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonPhotoInfo;", "C9", "Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxTabLayerDeleteMediaEvent;", "D9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lnc/bp;", "d", "Lnc/bp;", "getMediaViewModel", "()Lnc/bp;", "mediaViewModel", "<init>", "(Lnc/bp;)V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class q extends com.qzone.reborn.base.k implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final bp mediaViewModel;

    public q(bp mediaViewModel) {
        Intrinsics.checkNotNullParameter(mediaViewModel, "mediaViewModel");
        this.mediaViewModel = mediaViewModel;
    }

    private final CommonPhotoInfo C9(String linkId, String lloc) {
        List<CommonPhotoInfo> h16 = this.mediaViewModel.getRepo().h();
        if (ArrayUtils.isOutOfArrayIndex(0, h16)) {
            return null;
        }
        for (CommonPhotoInfo commonPhotoInfo : h16) {
            if (TextUtils.equals(String.valueOf(commonPhotoInfo.getMedia().getLinkId()), linkId) && TextUtils.equals(commonPhotoInfo.getMedia().k(), lloc)) {
                return commonPhotoInfo;
            }
        }
        return null;
    }

    private final void D9(QZAlbumxTabLayerDeleteMediaEvent event) {
        UIStateData<cb.a> value = this.mediaViewModel.W1().getValue();
        cb.a data = value != null ? value.getData() : null;
        if (data == null) {
            return;
        }
        data.r();
        data.E(data.getVideoNum() - event.getVideoNumber());
        data.y(data.getPhotoNum() - event.getPhotoNumber());
        this.mediaViewModel.W1().postValue(this.mediaViewModel.W1().getValue());
    }

    private final void E9(QZAlbumxEditMediaEvent event) {
        CommonPhotoInfo C9 = C9(event.getLinkId(), event.getLloc());
        if (C9 == null) {
            return;
        }
        C9.getMedia().x(event.getDesc());
    }

    private final void F9(QZAlbumxLayerPraiseEvent event) {
        CommonPhotoInfo C9 = C9(event.getLinkId(), event.getLLoc());
        if (C9 == null) {
            return;
        }
        C9.getMedia().getLike().f(event.getIsLike() ? 1 : 0);
        C9.getMedia().getLike().g(event.getLikeCount());
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
        } else if (event instanceof QZAlbumxTabLayerDeleteMediaEvent) {
            D9((QZAlbumxTabLayerDeleteMediaEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZAlbumxLayerPraiseEvent.class, QZAlbumxEditMediaEvent.class, QZAlbumxTabLayerDeleteMediaEvent.class);
        return arrayListOf;
    }
}

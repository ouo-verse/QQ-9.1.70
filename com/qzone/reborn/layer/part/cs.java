package com.qzone.reborn.layer.part;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.avbiz.Constants;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.video.event.RFWMediaFocusChangeEvent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider;
import com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\tH\u0016J\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001a0\u0019H\u0016R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/qzone/reborn/layer/part/cs;", "Lcom/qzone/reborn/layer/part/ap;", "Lcom/tencent/richframework/gallery/delegate/outer/IVideoPlayStrategyProvider;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "", "continuePlay", "isAutoPlayWhenVisible", "isLoopPlay", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "event", "onReceiveEvent", "", "getMinBufferingPacketDurationMs", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/richframework/gallery/delegate/inner/IVideoPlayerProvider;", "getMLayerVideoControlProvider", "()Lcom/tencent/richframework/gallery/delegate/inner/IVideoPlayerProvider;", "mLayerVideoControlProvider", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class cs extends ap implements IVideoPlayStrategyProvider, SimpleEventReceiver<SimpleBaseEvent> {
    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
    public boolean continuePlay(RFWLayerItemMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return false;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
    public boolean enableDispatchFileDownloadState(RFWLayerItemMediaInfo rFWLayerItemMediaInfo) {
        return IVideoPlayStrategyProvider.DefaultImpls.enableDispatchFileDownloadState(this, rFWLayerItemMediaInfo);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(RFWMediaFocusChangeEvent.class);
        return arrayList;
    }

    public final IVideoPlayerProvider getMLayerVideoControlProvider() {
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return RFWLayerIOCUtil.getVideoControlProvider(rootView);
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
    public long getMinBufferingPacketDurationMs(RFWLayerItemMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return 0L;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
    public boolean isAutoPlayWhenVisible(RFWLayerItemMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return true;
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.IVideoPlayStrategyProvider
    public boolean isLoopPlay(RFWLayerItemMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        RFWLayerIOCUtil.registerVideoPlayStrategyProvider(rootView, this);
    }

    @Override // com.qzone.reborn.layer.part.ap, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
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
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo;
        IVideoPlayerProvider mLayerVideoControlProvider;
        if (event instanceof RFWMediaFocusChangeEvent) {
            RFWMediaFocusChangeEvent rFWMediaFocusChangeEvent = (RFWMediaFocusChangeEvent) event;
            if (TextUtils.equals(Constants.Business.QQ_LAYER, rFWMediaFocusChangeEvent.getConflictBusinessName()) && TextUtils.equals(Constants.Business.QQ_CIRCLE_WINDOW, rFWMediaFocusChangeEvent.getFocusBusinessName()) && rFWMediaFocusChangeEvent.hasFocusConflict()) {
                IVideoPlayerProvider mLayerVideoControlProvider2 = getMLayerVideoControlProvider();
                boolean z16 = false;
                if (mLayerVideoControlProvider2 != null && mLayerVideoControlProvider2.isPlaying()) {
                    z16 = true;
                }
                if (!z16 || (rFWLayerItemMediaInfo = this.mCurrentSelectedItem) == null) {
                    return;
                }
                Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
                if (!rFWLayerItemMediaInfo.isVideo() || (mLayerVideoControlProvider = getMLayerVideoControlProvider()) == null) {
                    return;
                }
                mLayerVideoControlProvider.stop();
            }
        }
    }
}

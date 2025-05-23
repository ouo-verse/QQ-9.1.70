package com.tencent.richframework.gallery.datacenter;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.UiThread;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.richframework.data.base.BaseDataCenter;
import com.tencent.richframework.gallery.bean.RFWLayerFileDownloadState;
import com.tencent.richframework.gallery.bean.RFWLayerVideoLoadState;
import com.tencent.richframework.gallery.datacenter.converter.FileDownloadStateConverter;
import com.tencent.richframework.gallery.datacenter.converter.PicLoadStateConverter;
import com.tencent.richframework.gallery.datacenter.converter.VideoLoadStateConverter;
import com.tencent.richframework.gallery.event.RFWLayerFileStateChangeEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006J\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/richframework/gallery/datacenter/RFWLayerDataCenter;", "Lcom/tencent/richframework/data/base/BaseDataCenter;", "()V", "handler", "Landroid/os/Handler;", "getFileDownloadState", "Lcom/tencent/richframework/gallery/bean/RFWLayerFileDownloadState;", "id", "", "getLayerVideoLoadState", "Lcom/tencent/richframework/gallery/bean/RFWLayerVideoLoadState;", "updateFileState", "", "fileDownloadState", "updateVideoFileState", "mediaId", "updateVideoPlayState", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_STATE, "Lcom/tencent/richframework/gallery/bean/RFWLayerVideoLoadState$PlayState;", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerDataCenter extends BaseDataCenter {

    @NotNull
    public static final RFWLayerDataCenter INSTANCE;
    private static final Handler handler;

    static {
        RFWLayerDataCenter rFWLayerDataCenter = new RFWLayerDataCenter();
        INSTANCE = rFWLayerDataCenter;
        handler = new Handler(Looper.getMainLooper());
        rFWLayerDataCenter.addDataConverter(new PicLoadStateConverter());
        rFWLayerDataCenter.addDataConverter(new VideoLoadStateConverter());
        rFWLayerDataCenter.addDataConverter(new FileDownloadStateConverter());
    }

    RFWLayerDataCenter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @UiThread
    public final RFWLayerFileDownloadState getFileDownloadState(String id5) {
        MutableLiveData liveData = getGlobalData(RFWLayerFileDownloadState.class, id5);
        Intrinsics.checkNotNullExpressionValue(liveData, "liveData");
        RFWLayerFileDownloadState rFWLayerFileDownloadState = (RFWLayerFileDownloadState) liveData.getValue();
        if (rFWLayerFileDownloadState == null) {
            return new RFWLayerFileDownloadState(id5);
        }
        return rFWLayerFileDownloadState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @UiThread
    public final RFWLayerVideoLoadState getLayerVideoLoadState(String id5) {
        MutableLiveData liveData = getGlobalData(RFWLayerVideoLoadState.class, id5);
        Intrinsics.checkNotNullExpressionValue(liveData, "liveData");
        RFWLayerVideoLoadState rFWLayerVideoLoadState = (RFWLayerVideoLoadState) liveData.getValue();
        if (rFWLayerVideoLoadState == null) {
            RFWLayerVideoLoadState rFWLayerVideoLoadState2 = new RFWLayerVideoLoadState();
            rFWLayerVideoLoadState2.setMediaId(id5);
            return rFWLayerVideoLoadState2;
        }
        return rFWLayerVideoLoadState;
    }

    public final void updateFileState(@NotNull final RFWLayerFileDownloadState fileDownloadState) {
        Intrinsics.checkNotNullParameter(fileDownloadState, "fileDownloadState");
        handler.post(new Runnable() { // from class: com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter$updateFileState$1
            @Override // java.lang.Runnable
            public final void run() {
                RFWLayerFileDownloadState fileDownloadState2;
                RFWLayerDataCenter rFWLayerDataCenter = RFWLayerDataCenter.INSTANCE;
                fileDownloadState2 = rFWLayerDataCenter.getFileDownloadState(RFWLayerFileDownloadState.this.getMediaId());
                if (!Intrinsics.areEqual(fileDownloadState2, RFWLayerFileDownloadState.this)) {
                    rFWLayerDataCenter.initOrUpdateGlobalState((RFWLayerDataCenter) RFWLayerFileDownloadState.this, true);
                }
            }
        });
    }

    public final void updateVideoFileState(@NotNull final String mediaId, @NotNull final RFWLayerFileDownloadState fileDownloadState) {
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        Intrinsics.checkNotNullParameter(fileDownloadState, "fileDownloadState");
        if (TextUtils.isEmpty(mediaId)) {
            return;
        }
        handler.post(new Runnable() { // from class: com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter$updateVideoFileState$1
            @Override // java.lang.Runnable
            public final void run() {
                RFWLayerVideoLoadState layerVideoLoadState;
                RFWLayerDataCenter rFWLayerDataCenter = RFWLayerDataCenter.INSTANCE;
                layerVideoLoadState = rFWLayerDataCenter.getLayerVideoLoadState(mediaId);
                layerVideoLoadState.setFileDownloadState(fileDownloadState);
                rFWLayerDataCenter.initOrUpdateGlobalState((RFWLayerDataCenter) layerVideoLoadState, true);
                SimpleEventBus.getInstance().dispatchEvent(new RFWLayerFileStateChangeEvent(fileDownloadState));
            }
        });
    }

    public final void updateVideoPlayState(@NotNull final String mediaId, @NotNull final RFWLayerVideoLoadState.PlayState playState) {
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        Intrinsics.checkNotNullParameter(playState, "playState");
        if (TextUtils.isEmpty(mediaId)) {
            return;
        }
        handler.post(new Runnable() { // from class: com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter$updateVideoPlayState$1
            @Override // java.lang.Runnable
            public final void run() {
                RFWLayerVideoLoadState layerVideoLoadState;
                RFWLayerDataCenter rFWLayerDataCenter = RFWLayerDataCenter.INSTANCE;
                layerVideoLoadState = rFWLayerDataCenter.getLayerVideoLoadState(mediaId);
                layerVideoLoadState.setCurrentPlayState(playState);
                rFWLayerDataCenter.initOrUpdateGlobalState((RFWLayerDataCenter) layerVideoLoadState, true);
            }
        });
    }
}

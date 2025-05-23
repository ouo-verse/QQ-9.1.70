package com.tencent.biz.richframework.video.rfw.demo.view;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.drive.a;
import com.tencent.biz.richframework.video.rfw.drive.b;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.view.RFWVideoView;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DemoItemView extends FrameLayout implements IRFWLayerItemViewScrollerStatus {
    private final RFWVideoView mPlayerView;

    public DemoItemView(@NonNull Context context) {
        super(context);
        RFWVideoView rFWVideoView = new RFWVideoView(context);
        this.mPlayerView = rFWVideoView;
        addView(rFWVideoView, 0, new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(-16777216);
    }

    private void playUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        initPlayerConfig();
        RFWPlayerOptions playUrl = RFWPlayerOptions.obtain(-100).setPlayUrl(str);
        playUrl.getListenerSet().addPrepareListeners(new IRFWPlayerPrepareListener() { // from class: com.tencent.biz.richframework.video.rfw.demo.view.DemoItemView.1
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
            public void onVideoPrepared(RFWPlayer rFWPlayer) {
                rFWPlayer.start();
            }

            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
            public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
            }
        });
        this.mPlayerView.loadPlayOptions(playUrl);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public RFWVideoView getVideoView() {
        return this.mPlayerView;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public /* synthetic */ boolean isFloatingView() {
        return a.b(this);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public boolean isVideoType() {
        return true;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public /* synthetic */ void onDestroy() {
        b.a(this);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public /* synthetic */ void onFeedPageScrolled(int i3, float f16, int i16) {
        b.b(this, i3, f16, i16);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        playUrl("https://cesium.com/public/SandcastleSampleData/big-buck-bunny_trailer.mp4");
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public /* synthetic */ void onLoadFeedExport(int i3, int i16) {
        b.c(this, i3, i16);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public /* synthetic */ void onPageScrolledIdle(int i3) {
        b.d(this, i3);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public /* synthetic */ void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        b.e(this, rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public /* synthetic */ void onPosUpdate(int i3) {
        b.f(this, i3);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        b.g(this, rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public /* synthetic */ void onStart(RFWFeedSelectInfo rFWFeedSelectInfo) {
        b.h(this, rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public /* synthetic */ void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
        b.i(this, rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public /* synthetic */ void onViewHolderAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        a.d(this, viewHolder);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public /* synthetic */ void onViewHolderDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        a.e(this, viewHolder);
    }

    private void initPlayerConfig() {
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
    }
}

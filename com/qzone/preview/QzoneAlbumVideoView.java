package com.qzone.preview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideo;
import com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideoControlView;
import com.tencent.oskplayer.util.PlayerUtils;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneAlbumVideoView extends IndividualAutoVideo {
    private final String V;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    public QzoneAlbumVideoView(Context context) {
        super(context);
        this.V = "QzoneAlbumVideoView";
        this.hasSoundTipLayout = false;
        this.hasSoundLinesLayout = false;
        this.mSoundLinesLayout = null;
        this.f279806h = false;
        setOnTouchListener(new a());
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideo, com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    protected void addAutoVideoCover(Context context) {
        this.mVideoCover = new QzoneAlbumVideoCover(context, this);
        addView(this.mVideoCover, new ViewGroup.LayoutParams(-2, -2));
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public BaseVideoManager getBaseVideoManager() {
        return this.baseVideoManager.get();
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideo, com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    protected void initChildView() {
        super.initChildView();
        this.K = null;
        QzoneAlbumVideoControlView qzoneAlbumVideoControlView = new QzoneAlbumVideoControlView(getContext(), FeedVideoEnv.playerResources);
        this.f279805f = qzoneAlbumVideoControlView;
        qzoneAlbumVideoControlView.setVisibility(4);
    }

    public void m(View.OnClickListener onClickListener) {
        ((QzoneAlbumVideoControlView) this.f279805f).C(onClickListener);
    }

    public boolean n() {
        return this.T.isPlaying() || getState() == 2;
    }

    public IndividualAutoVideoControlView o() {
        return this.f279805f;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideo, com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    protected void onVideoSizeChanged(int i3, int i16) {
        super.onVideoSizeChanged(i3, i16);
    }

    public void setVideoManager(BaseVideoManager baseVideoManager) {
        this.baseVideoManager = new WeakReference<>(baseVideoManager);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public boolean shouldResponseToAudioFocusChange() {
        return false;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.IndividualAutoVideo, com.tencent.mobileqq.qzoneplayer.video.BaseVideo
    public void update() {
        super.update();
        PlayerUtils.runOnUiThread(new Runnable() { // from class: com.qzone.preview.QzoneAlbumVideoView.2
            @Override // java.lang.Runnable
            public void run() {
                ((IndividualAutoVideo) QzoneAlbumVideoView.this).f279805f.u(0);
            }
        });
    }
}

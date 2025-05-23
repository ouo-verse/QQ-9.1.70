package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsHttpValidProcess;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager;
import com.tencent.biz.richframework.video.rfw.view.RFWVideoView;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSAudioView extends RFWVideoView {

    /* renamed from: d, reason: collision with root package name */
    private int f90304d;

    /* renamed from: e, reason: collision with root package name */
    private int f90305e;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements RFWPlayerOptionsProcessManager.IProcessCallBack {
        a() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionsProcessManager.IProcessCallBack
        public void onFinish(RFWPlayerOptions rFWPlayerOptions, boolean z16) {
            QFSAudioView.super.loadPlayOptions(rFWPlayerOptions);
        }
    }

    public QFSAudioView(@NonNull Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView, com.tencent.biz.richframework.widget.BaseWidgetView
    public void bindData(Object obj, int i3) {
        super.bindData(obj, i3);
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    protected boolean isAudio() {
        return true;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    public void loadPlayOptions(RFWPlayerOptions rFWPlayerOptions) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(RFWPlayerOptionsHttpValidProcess.DEFAULT_PROCESS_URL_HTTP_VALID);
        RFWPlayerOptionsProcessManager.g().startProcess(linkedList, rFWPlayerOptions, new a());
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        super.onVideoPrepared(iSuperPlayer);
        int i3 = this.f90305e;
        if (i3 > 0) {
            setLoopBack(true, this.f90304d, i3);
        } else {
            setLoopBack(true);
        }
        iSuperPlayer.start();
    }

    public void setPlayRange(int i3, int i16) {
        this.f90304d = i3;
        this.f90305e = i16;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public QFSSeekBar getProgressBar() {
        return null;
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    protected void reportVideoStartPlay() {
    }

    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    protected void reportVideoPassivePause(int i3, int i16, long j3, long j16, long j17) {
    }
}

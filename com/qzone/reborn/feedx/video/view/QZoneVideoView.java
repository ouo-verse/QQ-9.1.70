package com.qzone.reborn.feedx.video.view;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import com.qzone.reborn.feedx.video.c;
import com.qzone.reborn.feedx.video.process.QZonePlayerOptionsProcessManager;
import com.qzone.util.ToastUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneVideoView extends QZoneBaseVideoView<Object> {
    private final QZoneProgressLoadingView I;
    private boolean J;
    private Runnable K;
    private SeekBar L;
    private com.qzone.reborn.feedx.video.process.a M;

    /* compiled from: P */
    /* renamed from: com.qzone.reborn.feedx.video.view.QZoneVideoView$3, reason: invalid class name */
    /* loaded from: classes37.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ QZoneVideoView this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.setLoadingViewStatus(true);
            QLog.d(this.this$0.getLogTag(), 1, "onSecondBufferStart show loading");
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.reborn.feedx.video.view.QZoneVideoView$4, reason: invalid class name */
    /* loaded from: classes37.dex */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ QZoneVideoView this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.setLoadingViewStatus(false);
            QLog.d(this.this$0.getLogTag(), 1, "onSecondBufferEnd hide loading");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements QZonePlayerOptionsProcessManager.b {
        a() {
        }

        @Override // com.qzone.reborn.feedx.video.process.QZonePlayerOptionsProcessManager.b
        public void a(c cVar, boolean z16) {
            QLog.d(cVar.s() + "QZoneVideoView", 1, "loadPlayOptions finish");
            QZoneVideoView.super.A0(cVar);
        }
    }

    public QZoneVideoView(Context context) {
        this(context, null);
    }

    public long D0() {
        if (getSuperPlayer() != null) {
            return getSuperPlayer().getCurrentPositionMs();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.video.view.QZoneBaseVideoView
    public void firstFrameRenderCallBack() {
        super.firstFrameRenderCallBack();
        QZoneProgressLoadingView qZoneProgressLoadingView = this.I;
        if (qZoneProgressLoadingView != null) {
            qZoneProgressLoadingView.r0();
        }
        if (w0() != null) {
            w0().setVisibility(0);
            w0().setOnSeekBarChangeListener(this);
            E0(w0(), this.J);
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    @Override // com.qzone.reborn.feedx.video.view.QZoneBaseVideoView, android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        super.handleMessage(message);
        int i3 = message.what;
        return false;
    }

    @Override // com.qzone.reborn.feedx.video.view.QZoneBaseVideoView
    protected boolean isNeedSeekWhenDragging() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.video.view.QZoneBaseVideoView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.video.view.QZoneBaseVideoView, com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QZoneProgressLoadingView qZoneProgressLoadingView = this.I;
        if (qZoneProgressLoadingView != null) {
            qZoneProgressLoadingView.r0();
        }
    }

    @Override // com.qzone.reborn.feedx.video.view.QZoneBaseVideoView, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        super.onStartTrackingTouch(seekBar);
    }

    @Override // com.qzone.reborn.feedx.video.view.QZoneBaseVideoView, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
        super.onStopTrackingTouch(seekBar);
        EventCollector.getInstance().onStopTrackingTouch(seekBar);
    }

    @Override // com.qzone.reborn.feedx.video.view.QZoneBaseVideoView
    public void onVideoPlayError(int i3, int i16, final int i17, String str) {
        QLog.e(getLogTag(), 1, "video play error, errorCode = " + i17);
        if (this.K == null) {
            this.K = new Runnable() { // from class: com.qzone.reborn.feedx.video.view.QZoneVideoView.2
                @Override // java.lang.Runnable
                public void run() {
                    QZoneVideoView.this.setLoadingViewStatus(true);
                    c cVar = QZoneVideoView.this.f55847e;
                    if (cVar == null) {
                        return;
                    }
                    if (cVar.f() >= uq3.c.S2() || i17 == Integer.parseInt("19000001")) {
                        ToastUtil.s(HardCodeUtil.qqStr(R.string.v68) + i17, 3);
                        QLog.d(QZoneVideoView.this.getLogTag(), 1, "retry return");
                    }
                }
            };
        }
        RFWThreadManager.getUIHandler().removeCallbacks(this.K);
        RFWThreadManager.getUIHandler().post(this.K);
    }

    @Override // com.qzone.reborn.feedx.video.view.QZoneBaseVideoView
    public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
        super.onVideoPrepared(iSuperPlayer);
    }

    @Override // com.qzone.reborn.feedx.video.view.QZoneBaseVideoView, com.tencent.biz.richframework.widget.BaseWidgetView
    public void release() {
        super.release();
        if (this.K != null) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.K);
        }
        setLoadingViewStatus(false);
    }

    public void setExchangeUrlProcess(com.qzone.reborn.feedx.video.process.a aVar) {
        this.M = aVar;
    }

    public void setLoadingView(View view) {
        if (view != null) {
            this.I.setLoadingView(view);
        }
    }

    public void setProgressBar(SeekBar seekBar) {
        this.L = seekBar;
    }

    public void setSupportSeek(boolean z16) {
        E0(w0(), z16);
        this.J = z16;
    }

    @Override // com.qzone.reborn.feedx.video.view.QZoneBaseVideoView
    public void start() {
        super.start();
    }

    @Override // com.qzone.reborn.feedx.video.view.QZoneBaseVideoView
    public SeekBar w0() {
        return this.L;
    }

    public QZoneVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.qzone.reborn.feedx.video.view.QZoneBaseVideoView
    public void A0(c cVar) {
        setLoadingViewStatus(true);
        LinkedList<com.qzone.reborn.feedx.video.process.a> linkedList = new LinkedList<>();
        com.qzone.reborn.feedx.video.process.a aVar = this.M;
        if (aVar != null) {
            linkedList.add(aVar);
        }
        QZonePlayerOptionsProcessManager.d().f(linkedList, cVar, new a());
    }

    public void setLoadingView(View view, int i3) {
        if (view != null) {
            this.I.setLoadingView(view);
            this.I.setScreenOrientation(i3);
        }
    }

    public QZoneVideoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.J = true;
        this.I = new QZoneProgressLoadingView(context);
    }

    public void setLoadingViewStatus(boolean z16) {
        if (z16) {
            this.I.s0();
            if (w0() != null) {
                w0().setVisibility(8);
                return;
            }
            return;
        }
        this.I.r0();
        if (w0() != null) {
            w0().setVisibility(0);
        }
    }

    private void E0(SeekBar seekBar, boolean z16) {
        if (seekBar == null) {
            return;
        }
        seekBar.setEnabled(z16);
    }

    @Override // com.qzone.reborn.feedx.video.view.QZoneBaseVideoView
    protected void reportVideoStartPlay() {
    }

    @Override // com.qzone.reborn.feedx.video.view.QZoneBaseVideoView
    public void B0(long j3, long j16) {
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}

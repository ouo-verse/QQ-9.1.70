package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.optionsprocess.RFWPlayerOptionPreloadCheckProcess;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSTVKVideoView extends QFSVideoView {
    public QFSTVKVideoView(@NonNull Context context) {
        super(context);
    }

    public void Y0(int i3, Object obj) {
        RFWPlayer qCirclePlayer = getQCirclePlayer();
        if (qCirclePlayer == null) {
            return;
        }
        qCirclePlayer.onRealTimeInfoChange(i3, obj);
    }

    public void Z0(String str, int i3) {
        RFWPlayer qCirclePlayer = getQCirclePlayer();
        if (qCirclePlayer == null) {
            return;
        }
        qCirclePlayer.switchDefinition(str, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    public LinkedList<String> getProcessOrder(int i3) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(RFWPlayerOptionPreloadCheckProcess.DEFAULT_PROCESS_PRELOAD_CHECK);
        return linkedList;
    }

    public QFSTVKVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.QFSVideoView, com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    protected void reportVideoStartPlay() {
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.QFSVideoView, com.tencent.biz.richframework.video.rfw.view.RFWVideoView
    public void reportVideoPassivePause(int i3, int i16, long j3, long j16, long j17) {
    }
}

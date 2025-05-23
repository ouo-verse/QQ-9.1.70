package com.tencent.aelight.camera.api.impl;

import android.os.Bundle;
import ar.f;
import com.tencent.aelight.camera.api.IAEEditorProcess;
import com.tencent.aelight.camera.qipc.api.IAECameraGetInfoServer;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;

/* loaded from: classes32.dex */
public class AEEditorProcessImpl implements IAEEditorProcess {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$preloadQQSysEmojiApng$0() {
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), IAECameraGetInfoServer.NAME, "ACTION_PRE_DOWNLOAD_QQ_SYS_EMOJI_APNG", new Bundle());
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorProcess
    public void clean() {
        f.g().e();
        SimpleEventBus.getInstance().dispatchEvent(new WinkFinishActivityEvent(true, true));
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorProcess
    public boolean isGenerateWorking() {
        return f.g().j();
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorProcess
    public void preloadQQSysEmojiApng() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                AEEditorProcessImpl.lambda$preloadQQSysEmojiApng$0();
            }
        }, 16, null, false);
    }

    @Override // com.tencent.aelight.camera.api.IAEEditorProcess
    public void requestGenerateVideo(String str) {
        f.g().l(str);
    }
}

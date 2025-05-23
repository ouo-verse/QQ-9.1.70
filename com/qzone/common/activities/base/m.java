package com.qzone.common.activities.base;

import com.qzone.module.feedcomponent.ui.AudioFeedBubble;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;

/* compiled from: P */
@Named("BaseFeedFragmentAudioImp")
/* loaded from: classes39.dex */
public class m implements d5.b {
    @Inject
    public m() {
    }

    @Override // d5.b
    public void stopAll() {
        AudioFeedBubble.stopAll();
    }
}

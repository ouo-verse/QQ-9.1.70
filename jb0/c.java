package jb0;

import com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerPreRenderCallBack;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c implements IRFWPlayerPreRenderCallBack {
    @Override // com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerPreRenderCallBack
    public void onNotifyScreenFeedChange(Object obj) {
        if (!(obj instanceof e30.b)) {
            return;
        }
        u30.d.d().m(((e30.b) obj).g());
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerPreRenderCallBack
    public void onPreloadVideo(Object obj) {
        if (!(obj instanceof e30.b)) {
            return;
        }
        u30.d.d().p(((e30.b) obj).g());
    }
}

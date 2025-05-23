package com.tencent.biz.pubaccount.weishi.player;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.biz.pubaccount.weishi.util.x;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0016\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J,\u0010\u0013\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\u0015\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/player/g;", "Lcom/tencent/biz/pubaccount/weishi/player/f;", "Lcom/tencent/biz/pubaccount/weishi/player/e;", "playParam", "", "j", "", "i", "e", tl.h.F, "d", "b", "", "isCompleted", "a", "", "model", "what", "errorMsg", "c", Element.ELEMENT_NAME_TIMES, "g", "f", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public class g implements f {
    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void a(e playParam, boolean isCompleted) {
        x.j("WSPlayerStatusListenerAdapter", "[onVideoStop] title:" + j(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void b(e playParam) {
        x.j("WSPlayerStatusListenerAdapter", "[onVideoRestart] title:" + j(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void c(e playParam, int model, int what, String errorMsg) {
        x.j("WSPlayerStatusListenerAdapter", "[onVideoError] title:" + j(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void d(e playParam) {
        x.j("WSPlayerStatusListenerAdapter", "[onVideoPause] title:" + j(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void e(e playParam) {
        x.j("WSPlayerStatusListenerAdapter", "[onVideoStart] title:" + j(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void f(e playParam) {
        x.j("WSPlayerStatusListenerAdapter", "[onVideoViewLayoutSwitched] title:" + j(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void g(e playParam, int times) {
        x.j("WSPlayerStatusListenerAdapter", "[onVideoReplayOnLoop] title:" + j(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void h(e playParam) {
        x.j("WSPlayerStatusListenerAdapter", "[onCompletion] title:" + j(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void i(e playParam) {
        x.j("WSPlayerStatusListenerAdapter", "[onVideoInitiate] title:" + j(playParam));
    }

    private final String j(e playParam) {
        l lVar;
        String str = (playParam == null || (lVar = playParam.f81127c) == null) ? null : lVar.f81175j;
        return str == null ? "" : str;
    }
}

package com.tencent.biz.pubaccount.weishi.player;

import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\b\u0016\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J,\u0010\u0018\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010\u001c\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\"\u0010\u001f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\u0012\u0010 \u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010#\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0006H\u0016\u00a8\u0006&"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/player/h;", "Lcom/tencent/biz/pubaccount/weishi/player/a;", "Lcom/tencent/biz/pubaccount/weishi/player/e;", "playParam", "", "a", "", "isShowLoadingImmediately", "", "l", "j", DomainData.DOMAIN_NAME, "f", "e", "d", "b", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "o", "", "model", "what", "errorMsg", "c", "", com.tencent.luggage.wxa.c8.c.G, "duration", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isPreOutputFirstFrame", "isFirstFrameDrawSuccess", "g", "k", "remainDuration", "isLoopPlay", "i", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public class h implements a {
    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void b(e playParam) {
        x.j("WSPlayerUIDelegateAdapter", "[onVideoRestart] title:" + a(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void c(e playParam, int model, int what, String errorMsg) {
        x.j("WSPlayerUIDelegateAdapter", "[onVideoError] title:" + a(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void d(e playParam) {
        x.j("WSPlayerUIDelegateAdapter", "[onVideoPause] title:" + a(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void e(e playParam) {
        x.j("WSPlayerUIDelegateAdapter", "[onVideoStart] title:" + a(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void f(e playParam) {
        x.j("WSPlayerUIDelegateAdapter", "[onVideoViewLayoutSwitched] title:" + a(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void g(e playParam, boolean isPreOutputFirstFrame, boolean isFirstFrameDrawSuccess) {
        x.j("WSPlayerUIDelegateAdapter", "[onPrePlayFinished] title:" + a(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void h(e playParam) {
        x.j("WSPlayerUIDelegateAdapter", "[onVideoStop] title:" + a(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void i(e playParam, int remainDuration, boolean isLoopPlay) {
        x.j("WSPlayerUIDelegateAdapter", "[onVideoEndSoon] title:" + a(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void j(e playParam) {
        x.j("WSPlayerUIDelegateAdapter", "[onPrePlayStart] title:" + a(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public boolean k(e playParam) {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void l(e playParam, boolean isShowLoadingImmediately) {
        x.j("WSPlayerUIDelegateAdapter", "[onVideoInitiate] title:" + a(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void n(e playParam) {
        x.j("WSPlayerUIDelegateAdapter", "[onVideoViewAttached] title:" + a(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void o(e playParam) {
        x.j("WSPlayerUIDelegateAdapter", "[onVideoCompletion] title:" + a(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void p(e playParam) {
        x.j("WSPlayerUIDelegateAdapter", "[onVideoBufferEnd] title:" + a(playParam));
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void q(e playParam) {
        x.j("WSPlayerUIDelegateAdapter", "[onVideoBufferStart] title:" + a(playParam));
    }

    private final String a(e playParam) {
        l lVar;
        String str = (playParam == null || (lVar = playParam.f81127c) == null) ? null : lVar.f81175j;
        return str == null ? "" : str;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.a
    public void m(e playParam, long pos, long duration) {
    }
}

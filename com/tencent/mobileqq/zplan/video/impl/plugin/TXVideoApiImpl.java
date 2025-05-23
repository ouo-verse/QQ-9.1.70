package com.tencent.mobileqq.zplan.video.impl.plugin;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.lua.ar;
import com.tencent.mobileqq.zplan.polling.PollingManager;
import com.tencent.mobileqq.zplan.video.api.bean.TXVideoInfo;
import com.tencent.mobileqq.zplan.video.api.bean.UpdateFrom;
import com.tencent.mobileqq.zplan.video.api.bean.VideoMediaInfo;
import com.tencent.mobileqq.zplan.video.api.bean.VideoParamInfo;
import com.tencent.mobileqq.zplan.video.api.bean.VideoPlayInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010 \u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/zplan/video/impl/plugin/TXVideoApiImpl;", "Lzk3/a;", "Lcom/tencent/mobileqq/zplan/video/api/bean/b;", QCircleScheme.AttrDetail.VIDEO_INFO, "", "X0", "Lcom/tencent/mobileqq/zplan/video/api/bean/e;", "playInfo", "I0", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "L", "Lcom/tencent/mobileqq/zplan/video/api/bean/UpdateFrom;", "from", "", "componentId", "Lcom/tencent/mobileqq/zplan/video/api/bean/c;", "mediaInfo", "B0", "D0", "Lzk3/b;", "J0", "b", "Lcom/tencent/mobileqq/zplan/video/api/bean/d;", "a0", "Lcom/tencent/mobileqq/zplan/video/impl/plugin/a;", "Lkotlin/Lazy;", "V0", "()Lcom/tencent/mobileqq/zplan/video/impl/plugin/a;", "videoInfoCache", "c", "W0", "()Lcom/tencent/mobileqq/zplan/video/api/bean/d;", "videoParamInfo", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class TXVideoApiImpl implements zk3.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy videoInfoCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy videoParamInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/video/impl/plugin/TXVideoApiImpl$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<Boolean> {
        b() {
        }

        public void a(boolean result) {
            QLog.i("ITXVideoApiImpl", 1, "closeStream :: onResultSuccess , result == " + result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ITXVideoApiImpl", 1, "leaveRoom :: onResultFailure , error == " + error + " , message == " + message);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public /* bridge */ /* synthetic */ void onResultSuccess(Boolean bool) {
            a(bool.booleanValue());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/video/impl/plugin/TXVideoApiImpl$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/zplan/video/api/bean/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<TXVideoInfo> {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(TXVideoInfo result) {
            Intrinsics.checkNotNullParameter(result, "result");
            TXVideoApiImpl.this.D0(result);
            QLog.i("ITXVideoApiImpl", 1, "enterRoom :: onResultSuccess , result == " + result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ITXVideoApiImpl", 1, "enterRoom :: onResultFailure , error == " + error + " , message == " + message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/video/impl/plugin/TXVideoApiImpl$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.e<Boolean> {
        d() {
        }

        public void a(boolean result) {
            QLog.i("ITXVideoApiImpl", 1, "leaveRoom :: onResultSuccess , result == " + result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ITXVideoApiImpl", 1, "leaveRoom :: onResultFailure , error == " + error + " , message == " + message);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public /* bridge */ /* synthetic */ void onResultSuccess(Boolean bool) {
            a(bool.booleanValue());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/video/impl/plugin/TXVideoApiImpl$e", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/zplan/video/api/bean/d;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.api.e<VideoParamInfo> {
        e() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(VideoParamInfo result) {
            Intrinsics.checkNotNullParameter(result, "result");
            TXVideoApiImpl.this.W0().f(result.getVidUrl());
            TXVideoApiImpl.this.W0().d(result.getCidUrl());
            TXVideoApiImpl.this.W0().e(result.getInterval());
            QLog.i("ITXVideoApiImpl", 1, "preloadWebUrl :: vidUrl update to " + TXVideoApiImpl.this.W0() + ".vidUrl , cide update to " + TXVideoApiImpl.this.W0() + ".cidUrl");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ITXVideoApiImpl", 1, "preloadWebUrl :: failed , error == " + error + " , message == " + message);
        }
    }

    public TXVideoApiImpl() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.zplan.video.impl.plugin.TXVideoApiImpl$videoInfoCache$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a();
            }
        });
        this.videoInfoCache = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<VideoParamInfo>() { // from class: com.tencent.mobileqq.zplan.video.impl.plugin.TXVideoApiImpl$videoParamInfo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final VideoParamInfo invoke() {
                return new VideoParamInfo("https://mweb.superqqshow.qq.com/app/wetv", "https://mweb.superqqshow.qq.com/app/wetv/detail", 5);
            }
        });
        this.videoParamInfo = lazy2;
    }

    private final a V0() {
        return (a) this.videoInfoCache.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoParamInfo W0() {
        return (VideoParamInfo) this.videoParamInfo.getValue();
    }

    private final void X0(TXVideoInfo videoInfo) {
        String g16 = videoInfo.g();
        QLog.i("ITXVideoApiImpl", 1, "updateMediaInfoToUe :: json == " + g16);
        ar.f328509a.a("N2L_OnMediaInfoUpdated", g16);
    }

    @Override // zk3.a
    public void A(VideoPlayInfo playInfo) {
        Intrinsics.checkNotNullParameter(playInfo, "playInfo");
        bl3.a.f28625a.e(playInfo, new d());
        if (Intrinsics.areEqual(playInfo.getHostOpenId(), playInfo.getOpenId())) {
            if (playInfo.getComponentId().length() == 0) {
                ((zk3.a) vb3.a.f441346a.a(zk3.a.class)).J0().f();
                return;
            }
        }
        ((zk3.a) vb3.a.f441346a.a(zk3.a.class)).J0().c(playInfo.getComponentId());
    }

    @Override // zk3.a
    public void B0(UpdateFrom from, String componentId, VideoMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        vb3.a aVar = vb3.a.f441346a;
        TXVideoInfo b16 = ((zk3.a) aVar.a(zk3.a.class)).J0().b(componentId, mediaInfo);
        if (b16 != null) {
            QLog.i("ITXVideoApiImpl", 1, "updateMediaInfo :: videoInfo changed , from == " + from + " , componentId == " + componentId);
            X0(b16);
            if (b16.getMediaInfo().getPlayType() == 0 || b16.getMediaInfo().getNeedLeave()) {
                ((zk3.a) aVar.a(zk3.a.class)).J0().c(componentId);
                QLog.i("ITXVideoApiImpl", 1, "updateMediaInfo :: remove cache , playType == " + b16.getMediaInfo().getPlayType() + " , needLeave == " + b16.getMediaInfo().getNeedLeave());
                return;
            }
            return;
        }
        QLog.i("ITXVideoApiImpl", 1, "updateMediaInfo :: has no videoInfo in cache , from == " + from + " , componentId == " + componentId);
    }

    @Override // zk3.a
    public void D0(TXVideoInfo videoInfo) {
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        X0(videoInfo);
        ((zk3.a) vb3.a.f441346a.a(zk3.a.class)).J0().d(videoInfo);
        PollingManager.c(PollingManager.INSTANCE.a(), new com.tencent.mobileqq.zplan.polling.task.b(videoInfo.getParamInfo().getInterval() * 1000), false, 2, null);
    }

    @Override // zk3.a
    public void I0(VideoPlayInfo playInfo) {
        Intrinsics.checkNotNullParameter(playInfo, "playInfo");
        bl3.a.f28625a.d(playInfo, new c());
    }

    @Override // zk3.a
    public zk3.b J0() {
        return V0();
    }

    @Override // zk3.a
    public void L(VideoPlayInfo playInfo) {
        Intrinsics.checkNotNullParameter(playInfo, "playInfo");
        bl3.a.f28625a.c(playInfo, new b());
        ((zk3.a) vb3.a.f441346a.a(zk3.a.class)).J0().c(playInfo.getComponentId());
    }

    @Override // zk3.a
    public VideoParamInfo a0() {
        return W0();
    }

    @Override // zk3.a
    public void b() {
        bl3.a.f28625a.g(new e());
    }
}

package com.tencent.hippykotlin.demo.pages.foundation.view;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public class QQVideoView extends DeclarativeBaseView<VideoViewAttr, VideoViewEvent> {
    public VideoState currentState;
    public long durationMs;
    public boolean isWaitingBufferEnd;

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class VideoViewAttr extends Attr {
        public VideoInfo videoInfo;

        public final void src(VideoInfo videoInfo) {
            this.videoInfo = videoInfo;
            e t16 = new e().v("url", videoInfo.url).u("startPosMs", videoInfo.startPosMs).v("feedPb", videoInfo.feedPb).u("durationMs", videoInfo.durationMs).v(QCircleSchemeAttr.Detail.COVER_PIC_URL, videoInfo.coverPicUrl).v("cover_layer_url", videoInfo.coverLayerUrl).t("feedIndex", videoInfo.index);
            e eVar = videoInfo.extDtReportParams;
            if (eVar == null) {
                eVar = new e();
            }
            with("src", t16.v("ext_dtreport_params", eVar).w("disable_append_host_after_ip", videoInfo.disableAppendHostAfterIP).w("adaptHeight", videoInfo.adaptHeight).v("vid", videoInfo.vid).w("useUrlAsId", videoInfo.useUrlAsId).toString());
        }
    }

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class VideoViewEvent extends Event {
        public Function1<? super Long, Unit> progressUpdateHandler;
        public Function1<? super VideoState, Unit> stateChangeHandler;
    }

    public QQVideoView() {
        hashCode();
        this.currentState = VideoState.IDLE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$onInfo(QQVideoView qQVideoView, e eVar) {
        qQVideoView.getClass();
        int j3 = eVar.j("infoType");
        if (j3 == (qQVideoView.getPager().getPageData().getIsIOS() ? 1 : 105)) {
            ((VideoViewEvent) qQVideoView.getEvent()).getClass();
            return;
        }
        if (j3 == (qQVideoView.getPager().getPageData().getIsIOS() ? 21 : 107)) {
            ((VideoViewEvent) qQVideoView.getEvent()).getClass();
            return;
        }
        if (j3 == (qQVideoView.getPager().getPageData().getIsIOS() ? 10 : 108)) {
            ((VideoViewEvent) qQVideoView.getEvent()).getClass();
            return;
        }
        if (j3 == (qQVideoView.getPager().getPageData().getIsIOS() ? 2 : 112)) {
            qQVideoView.isWaitingBufferEnd = true;
            Function1<? super VideoState, Unit> function1 = ((VideoViewEvent) qQVideoView.getEvent()).stateChangeHandler;
            if (function1 != null) {
                function1.invoke(VideoState.BUFFERING);
                return;
            }
            return;
        }
        if (j3 == (qQVideoView.getPager().getPageData().getIsIOS() ? 3 : 113)) {
            qQVideoView.isWaitingBufferEnd = false;
            Function1<? super VideoState, Unit> function12 = ((VideoViewEvent) qQVideoView.getEvent()).stateChangeHandler;
            if (function12 != null) {
                function12.invoke(qQVideoView.currentState);
                return;
            }
            return;
        }
        if (j3 == (qQVideoView.getPager().getPageData().getIsIOS() ? 5 : 1001)) {
            ((VideoViewEvent) qQVideoView.getEvent()).getClass();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$onProgressUpdate(QQVideoView qQVideoView, e eVar) {
        qQVideoView.getClass();
        long n3 = eVar.n("progressMs");
        Function1<? super Long, Unit> function1 = ((VideoViewEvent) qQVideoView.getEvent()).progressUpdateHandler;
        if (function1 != null) {
            function1.invoke(Long.valueOf(n3));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$onStateChange(QQVideoView qQVideoView, e eVar) {
        Function1<? super VideoState, Unit> function1;
        qQVideoView.getClass();
        VideoState access$toState = QQVideoViewKt.access$toState(eVar.j("state"));
        qQVideoView.currentState = access$toState;
        if (isBuffering$default(qQVideoView, null, 1, null) || (function1 = ((VideoViewEvent) qQVideoView.getEvent()).stateChangeHandler) == null) {
            return;
        }
        function1.invoke(access$toState);
    }

    public static boolean isBuffering$default(QQVideoView qQVideoView, VideoState videoState, int i3, Object obj) {
        VideoState videoState2 = qQVideoView.currentState;
        return qQVideoView.isWaitingBufferEnd && (videoState2 == VideoState.PLAYING || videoState2 == VideoState.PAUSED);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new VideoViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new VideoViewEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final void didInit() {
        super.didInit();
        ((VideoViewEvent) getEvent()).register("onInfo", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.view.QQVideoView$didInit$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                e eVar = obj instanceof e ? (e) obj : null;
                if (eVar != null) {
                    QQVideoView.access$onInfo(QQVideoView.this, eVar);
                }
                return Unit.INSTANCE;
            }
        });
        ((VideoViewEvent) getEvent()).register("onError", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.view.QQVideoView$didInit$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                e eVar = obj instanceof e ? (e) obj : null;
                if (eVar != null) {
                    QQVideoView.access$onError(QQVideoView.this, eVar);
                }
                return Unit.INSTANCE;
            }
        });
        ((VideoViewEvent) getEvent()).register("onComplete", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.view.QQVideoView$didInit$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                QQVideoView.access$onComplete(QQVideoView.this);
                return Unit.INSTANCE;
            }
        });
        ((VideoViewEvent) getEvent()).register("onStateChange", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.view.QQVideoView$didInit$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                e eVar = obj instanceof e ? (e) obj : null;
                if (eVar != null) {
                    QQVideoView.access$onStateChange(QQVideoView.this, eVar);
                }
                return Unit.INSTANCE;
            }
        });
        ((VideoViewEvent) getEvent()).register("onProgressUpdate", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.view.QQVideoView$didInit$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                e eVar = obj instanceof e ? (e) obj : null;
                if (eVar != null) {
                    QQVideoView.access$onProgressUpdate(QQVideoView.this, eVar);
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final void didSetProp(String str, Object obj) {
        super.didSetProp(str, obj);
        if (Intrinsics.areEqual(obj, "src")) {
            if (obj instanceof VideoInfo) {
            }
            this.isWaitingBufferEnd = false;
            this.durationMs = 0L;
        }
    }

    public final void play() {
        AbstractBaseView.callRenderViewMethod$default(this, "play", null, null, 6, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void predownload() {
        VideoInfo videoInfo = ((VideoViewAttr) getAttr()).videoInfo;
        if (videoInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException(QCircleScheme.AttrDetail.VIDEO_INFO);
            videoInfo = null;
        }
        if (videoInfo.feedPb.length() == 0) {
            return;
        }
        AbstractBaseView.callRenderViewMethod$default(this, "predownload", new e().v("pageId", "pg_xsj_game_tab_page").toString(), null, 4, null);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "HRVideoView";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$onComplete(QQVideoView qQVideoView) {
        qQVideoView.isWaitingBufferEnd = false;
        ((VideoViewEvent) qQVideoView.getEvent()).getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$onError(QQVideoView qQVideoView, e eVar) {
        qQVideoView.isWaitingBufferEnd = false;
        eVar.j("errorCode");
        ((VideoViewEvent) qQVideoView.getEvent()).getClass();
    }

    public final void stop() {
        this.isWaitingBufferEnd = false;
        AbstractBaseView.callRenderViewMethod$default(this, "stop", null, null, 6, null);
    }
}

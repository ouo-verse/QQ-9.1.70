package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.view.IOSLiveVideoView;
import com.tencent.hippykotlin.demo.pages.foundation.view.QQVideoView;
import com.tencent.hippykotlin.demo.pages.foundation.view.VideoInfo;
import com.tencent.hippykotlin.demo.pages.foundation.view.VideoState;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.exception.PagerNotFoundExceptionKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQCirVideoView extends ComposeView<QQCirVideoAttr, QQCirVideoEvent> {
    public aa<QQVideoView> videoRef;
    public VideoState videoState = VideoState.IDLE;
    public QVideoPlayState playState = QVideoPlayState.NONE;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QQCirVideoAttr access$getAttr(QQCirVideoView qQCirVideoView) {
        return (QQCirVideoAttr) qQCirVideoView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QQCirVideoEvent access$getEvent(QQCirVideoView qQCirVideoView) {
        return (QQCirVideoEvent) qQCirVideoView.getEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$logPlayControlDidChanged(QQCirVideoView qQCirVideoView, QVideoPlayControl qVideoPlayControl) {
        qQCirVideoView.getClass();
        Utils utils = Utils.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("playControlDidChanged:");
        m3.append(qVideoPlayControl.ordinal());
        m3.append(" curVideoState:");
        m3.append(qQCirVideoView.videoState.state);
        m3.append(" title: ");
        m3.append(((QQCirVideoAttr) qQCirVideoView.getAttr()).title);
        m3.append("  ");
        utils.logToNative(m3.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$logVideoStateDidChanged(QQCirVideoView qQCirVideoView, VideoState videoState) {
        qQCirVideoView.getClass();
        Utils utils = Utils.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("videoStateDidChanged:");
        m3.append(videoState.state);
        m3.append(" curPlayControl:");
        m3.append(((QQCirVideoAttr) qQCirVideoView.getAttr()).getPlayControl().ordinal());
        m3.append(" title: ");
        m3.append(((QQCirVideoAttr) qQCirVideoView.getAttr()).title);
        m3.append("  ");
        utils.logToNative(m3.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final w access$videoSize(QQCirVideoView qQCirVideoView) {
        if (((QQCirVideoAttr) qQCirVideoView.getAttr()).autoFillMaxSize == null) {
            return null;
        }
        if (((QQCirVideoAttr) qQCirVideoView.getAttr()).getVideo().width != 0 && ((QQCirVideoAttr) qQCirVideoView.getAttr()).getVideo().height != 0) {
            float f16 = ((QQCirVideoAttr) qQCirVideoView.getAttr()).getVideo().height / (((QQCirVideoAttr) qQCirVideoView.getAttr()).getVideo().width * 1.0f);
            if (f16 > 1.0f) {
                w wVar = ((QQCirVideoAttr) qQCirVideoView.getAttr()).autoFillMinSize;
                Intrinsics.checkNotNull(wVar);
                float width = wVar.getWidth();
                float f17 = f16 * width;
                w wVar2 = ((QQCirVideoAttr) qQCirVideoView.getAttr()).autoFillMaxSize;
                Intrinsics.checkNotNull(wVar2);
                if (f17 > wVar2.getHeight()) {
                    w wVar3 = ((QQCirVideoAttr) qQCirVideoView.getAttr()).autoFillMaxSize;
                    Intrinsics.checkNotNull(wVar3);
                    f17 = wVar3.getHeight();
                }
                return new w(width, f17);
            }
            w wVar4 = ((QQCirVideoAttr) qQCirVideoView.getAttr()).autoFillMaxSize;
            Intrinsics.checkNotNull(wVar4);
            float width2 = wVar4.getWidth();
            float f18 = f16 * width2;
            w wVar5 = ((QQCirVideoAttr) qQCirVideoView.getAttr()).autoFillMinSize;
            Intrinsics.checkNotNull(wVar5);
            if (f18 < wVar5.getHeight()) {
                w wVar6 = ((QQCirVideoAttr) qQCirVideoView.getAttr()).autoFillMinSize;
                Intrinsics.checkNotNull(wVar6);
                f18 = wVar6.getHeight();
            }
            return new w(width2, f18);
        }
        if (qQCirVideoView.getPagerData().u()) {
            PagerNotFoundExceptionKt.a("gcp attr.video.width == 0 || height == 0");
        }
        w wVar7 = ((QQCirVideoAttr) qQCirVideoView.getAttr()).autoFillMaxSize;
        Intrinsics.checkNotNull(wVar7);
        float width3 = wVar7.getWidth();
        w wVar8 = ((QQCirVideoAttr) qQCirVideoView.getAttr()).autoFillMinSize;
        Intrinsics.checkNotNull(wVar8);
        return new w(width3, wVar8.getHeight());
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.QQCirVideoView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                DeclarativeBaseView qQVideoView;
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final QQCirVideoView qQCirVideoView = QQCirVideoView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.QQCirVideoView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        w access$videoSize = QQCirVideoView.access$videoSize(QQCirVideoView.this);
                        if (access$videoSize != null) {
                            mVar2.size(access$videoSize.getWidth(), access$videoSize.getHeight());
                        }
                        mVar2.overflow(true);
                        return Unit.INSTANCE;
                    }
                });
                if (QQCirVideoView.access$getAttr(QQCirVideoView.this).isLiveVideo && viewContainer2.getPager().getPageData().getIsIOS()) {
                    qQVideoView = new IOSLiveVideoView();
                } else {
                    qQVideoView = new QQVideoView();
                }
                final QQCirVideoView qQCirVideoView2 = QQCirVideoView.this;
                viewContainer2.addChild(qQVideoView, new Function1<QQVideoView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.QQCirVideoView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QQVideoView qQVideoView2) {
                        QQVideoView qQVideoView3 = qQVideoView2;
                        final QQCirVideoView qQCirVideoView3 = QQCirVideoView.this;
                        qQVideoView3.ref(qQVideoView3, new Function1<aa<QQVideoView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.QQCirVideoView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<QQVideoView> aaVar) {
                                QQCirVideoView.this.videoRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final QQCirVideoView qQCirVideoView4 = QQCirVideoView.this;
                        qQVideoView3.attr(new Function1<QQVideoView.VideoViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.QQCirVideoView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QQVideoView.VideoViewAttr videoViewAttr) {
                                QQVideoView.VideoViewAttr videoViewAttr2 = videoViewAttr;
                                String str = QQCirVideoView.access$getAttr(QQCirVideoView.this).feedPbToken;
                                if (str != null) {
                                    QQCirVideoView qQCirVideoView5 = QQCirVideoView.this;
                                    VideoInfo videoInfo = new VideoInfo("", 0L, str, 0L, QQCirVideoView.access$getAttr(qQCirVideoView5).getCover().picUrl, QQCirVideoView.access$getAttr(qQCirVideoView5).getCover().layerPicUrl, QQCirVideoView.access$getAttr(qQCirVideoView5).index, QQCirVideoView.access$getAttr(qQCirVideoView5).adaptHeight, "", 512);
                                    videoInfo.extDtReportParams = QQCirVideoView.access$getAttr(qQCirVideoView5).extDtReportParams;
                                    videoViewAttr2.src(videoInfo);
                                }
                                String str2 = QQCirVideoView.access$getAttr(QQCirVideoView.this).playUrl;
                                if (str2 != null) {
                                    QQCirVideoView qQCirVideoView6 = QQCirVideoView.this;
                                    VideoInfo videoInfo2 = new VideoInfo(str2, 0L, "", 0L, QQCirVideoView.access$getAttr(qQCirVideoView6).getCover().picUrl, QQCirVideoView.access$getAttr(qQCirVideoView6).getCover().layerPicUrl, 0, QQCirVideoView.access$getAttr(qQCirVideoView6).adaptHeight, (String) null, 768);
                                    videoInfo2.extDtReportParams = QQCirVideoView.access$getAttr(qQCirVideoView6).extDtReportParams;
                                    videoInfo2.disableAppendHostAfterIP = QQCirVideoView.access$getAttr(qQCirVideoView6).disableAppendHostAfterIP;
                                    videoViewAttr2.src(videoInfo2);
                                }
                                if (QQCirVideoView.access$getAttr(QQCirVideoView.this).exactSize) {
                                    w access$videoSize = QQCirVideoView.access$videoSize(QQCirVideoView.this);
                                    if (access$videoSize != null) {
                                        videoViewAttr2.size(access$videoSize.getWidth(), access$videoSize.getHeight());
                                    }
                                } else {
                                    videoViewAttr2.m140flex(1.0f);
                                }
                                if (videoViewAttr2.getPager().getPageData().getIsIOS()) {
                                    videoViewAttr2.with("resize", 1);
                                } else {
                                    videoViewAttr2.with("resize", 2);
                                }
                                videoViewAttr2.with("loop", Boolean.valueOf(QQCirVideoView.access$getAttr(QQCirVideoView.this).loop));
                                QQCirVideoAttr access$getAttr = QQCirVideoView.access$getAttr(QQCirVideoView.this);
                                videoViewAttr2.with("mute", Boolean.valueOf(((Boolean) access$getAttr.muted$delegate.getValue(access$getAttr, QQCirVideoAttr.$$delegatedProperties[1])).booleanValue()));
                                return Unit.INSTANCE;
                            }
                        });
                        final QQCirVideoView qQCirVideoView5 = QQCirVideoView.this;
                        qQVideoView3.event(new Function1<QQVideoView.VideoViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.QQCirVideoView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QQVideoView.VideoViewEvent videoViewEvent) {
                                QQVideoView.VideoViewEvent videoViewEvent2 = videoViewEvent;
                                final Function1<? super Long, Unit> function1 = QQCirVideoView.access$getEvent(QQCirVideoView.this).onClickVideoHandlerFn;
                                if (function1 != null) {
                                    final QQCirVideoView qQCirVideoView6 = QQCirVideoView.this;
                                    videoViewEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.QQCirVideoView.body.1.2.3.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            QQVideoView b16;
                                            Function1<Long, Unit> function12 = function1;
                                            aa<QQVideoView> aaVar = qQCirVideoView6.videoRef;
                                            function12.invoke(Long.valueOf((aaVar == null || (b16 = aaVar.b()) == null) ? 0 : b16.getNativeRef()));
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                final QQCirVideoView qQCirVideoView7 = QQCirVideoView.this;
                                FrameEventKt.f(videoViewEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.QQCirVideoView.body.1.2.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        aa<QQVideoView> aaVar;
                                        QQVideoView b16;
                                        if (QQCirVideoView.access$getAttr(QQCirVideoView.this).preloadDownloadEnable && (aaVar = QQCirVideoView.this.videoRef) != null && (b16 = aaVar.b()) != null) {
                                            b16.predownload();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QQCirVideoView qQCirVideoView8 = QQCirVideoView.this;
                                videoViewEvent2.stateChangeHandler = new Function1<VideoState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.QQCirVideoView.body.1.2.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(VideoState videoState) {
                                        VideoState videoState2 = videoState;
                                        QQCirVideoView qQCirVideoView9 = QQCirVideoView.this;
                                        qQCirVideoView9.videoState = videoState2;
                                        QQCirVideoView.access$logVideoStateDidChanged(qQCirVideoView9, videoState2);
                                        if (QQCirVideoView.access$getAttr(QQCirVideoView.this).getPlayControl() != QVideoPlayControl.STOP) {
                                            if (videoState2 == VideoState.PLAYING) {
                                                QQCirVideoView.this.setPlayState(QVideoPlayState.PLAYING);
                                            } else if (videoState2 == VideoState.BUFFERING) {
                                                QQCirVideoView.this.setPlayState(QVideoPlayState.BUFFERING);
                                            } else if (videoState2 == VideoState.COMPLETE) {
                                                QQCirVideoView.this.setPlayState(QVideoPlayState.END);
                                            } else if (videoState2 == VideoState.PAUSED) {
                                                QQCirVideoView.this.setPlayState(QVideoPlayState.PAUSEING);
                                            } else if (videoState2 == VideoState.ERROR) {
                                                QQCirVideoView.this.setPlayState(QVideoPlayState.EORROR);
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                final QQCirVideoView qQCirVideoView9 = QQCirVideoView.this;
                                videoViewEvent2.progressUpdateHandler = new Function1<Long, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.QQCirVideoView.body.1.2.3.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Long l3) {
                                        final QQVideoView b16;
                                        final long longValue = l3.longValue();
                                        aa<QQVideoView> aaVar = QQCirVideoView.this.videoRef;
                                        if (aaVar != null && (b16 = aaVar.b()) != null) {
                                            final QQCirVideoView qQCirVideoView10 = QQCirVideoView.this;
                                            final Function1<Long, Unit> function12 = new Function1<Long, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.QQCirVideoView.body.1.2.3.4.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Long l16) {
                                                    long longValue2 = l16.longValue();
                                                    Function2<? super Float, ? super Float, Unit> function2 = QQCirVideoView.access$getEvent(QQCirVideoView.this).playTimeDidChangedHandler;
                                                    if (function2 != null) {
                                                        function2.invoke(Float.valueOf(((float) longValue) / 1000.0f), Float.valueOf(((float) longValue2) / 1000.0f));
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            long j3 = b16.durationMs;
                                            if (j3 > 0) {
                                                function12.invoke(Long.valueOf(j3));
                                            } else {
                                                AbstractBaseView.callRenderViewMethod$default(b16, "getDurationMs", null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.view.QQVideoView$getDurationMs$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(e eVar) {
                                                        e eVar2 = eVar;
                                                        if (eVar2 != null) {
                                                            QQVideoView qQVideoView4 = QQVideoView.this;
                                                            Function1<Long, Unit> function13 = function12;
                                                            long n3 = eVar2.n("duration");
                                                            qQVideoView4.durationMs = n3;
                                                            function13.invoke(Long.valueOf(n3));
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }, 2, null);
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QQCirVideoView qQCirVideoView3 = QQCirVideoView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.base.QQCirVideoView$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QQCirVideoView.access$getAttr(QQCirVideoView.this).getPlayControl();
                    }
                };
                final QQCirVideoView qQCirVideoView4 = QQCirVideoView.this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.QQCirVideoView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        QQVideoView b16;
                        QQVideoView b17;
                        QQVideoView b18;
                        QQVideoView b19;
                        QQVideoView b26;
                        if (QQCirVideoView.access$getAttr(QQCirVideoView.this).getPlayControl() != QVideoPlayControl.NONE) {
                            QQCirVideoView qQCirVideoView5 = QQCirVideoView.this;
                            QQCirVideoView.access$logPlayControlDidChanged(qQCirVideoView5, QQCirVideoView.access$getAttr(qQCirVideoView5).getPlayControl());
                        }
                        int ordinal = QQCirVideoView.access$getAttr(QQCirVideoView.this).getPlayControl().ordinal();
                        if (ordinal == 1) {
                            aa<QQVideoView> aaVar = QQCirVideoView.this.videoRef;
                            if (aaVar != null && (b16 = aaVar.b()) != null) {
                                AbstractBaseView.callRenderViewMethod$default(b16, "preplay", null, null, 6, null);
                            }
                        } else if (ordinal == 2) {
                            aa<QQVideoView> aaVar2 = QQCirVideoView.this.videoRef;
                            if (aaVar2 != null && (b17 = aaVar2.b()) != null) {
                                b17.play();
                            }
                            QQCirVideoView qQCirVideoView6 = QQCirVideoView.this;
                            if (qQCirVideoView6.playState != QVideoPlayState.PLAYING) {
                                qQCirVideoView6.setPlayState(QVideoPlayState.PREPARE);
                            }
                        } else if (ordinal == 3) {
                            aa<QQVideoView> aaVar3 = QQCirVideoView.this.videoRef;
                            if (aaVar3 != null && (b18 = aaVar3.b()) != null) {
                                AbstractBaseView.callRenderViewMethod$default(b18, "pause", null, null, 6, null);
                            }
                            QQCirVideoView.this.setPlayState(QVideoPlayState.PAUSEING);
                        } else if (ordinal == 4) {
                            aa<QQVideoView> aaVar4 = QQCirVideoView.this.videoRef;
                            if (aaVar4 != null && (b19 = aaVar4.b()) != null) {
                                AbstractBaseView.callRenderViewMethod$default(b19, "pause", null, null, 6, null);
                            }
                            QQCirVideoView.this.setPlayState(QVideoPlayState.PAUSEING);
                        } else if (ordinal == 5) {
                            aa<QQVideoView> aaVar5 = QQCirVideoView.this.videoRef;
                            if (aaVar5 != null && (b26 = aaVar5.b()) != null) {
                                b26.stop();
                                if (!b26.getPager().getPageData().getIsIOS()) {
                                    AbstractBaseView.callRenderViewMethod$default(b26, "release", null, null, 6, null);
                                }
                            }
                            QQCirVideoView.this.setPlayState(QVideoPlayState.NONE);
                            Function2<? super Float, ? super Float, Unit> function2 = QQCirVideoView.access$getEvent(QQCirVideoView.this).playTimeDidChangedHandler;
                            if (function2 != null) {
                                function2.invoke(Float.valueOf(0.0f), Float.valueOf(QQCirVideoView.access$getAttr(QQCirVideoView.this).getVideo().duration / 1000.0f));
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QQCirVideoAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QQCirVideoEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPlayState(QVideoPlayState qVideoPlayState) {
        if (this.playState != qVideoPlayState) {
            this.playState = qVideoPlayState;
            Function1<? super QVideoPlayState, Unit> function1 = ((QQCirVideoEvent) getEvent()).playStateDidChangedHandler;
            if (function1 != null) {
                function1.invoke(qVideoPlayState);
            }
        }
    }
}

package com.tencent.mobileqq.tvideo.floatingwindow;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFloatingWindowEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFloatingWindowPlayEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFloatingWindowStatusEvent;
import com.tencent.mobileqq.tvideo.event.TVideoMultiTabPageFinishEvent;
import com.tencent.mobileqq.tvideo.player.TVideoQFSVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.tvkplayer.view.TVKPlayerVideoView;
import com.tencent.superplayer.view.ISPlayerVideoView;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import tvideo.Video;
import uq3.k;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoFloatingWindowController {

    /* renamed from: a, reason: collision with root package name */
    private final TVideoQFSVideoView f304424a;

    /* renamed from: b, reason: collision with root package name */
    private ViewGroup f304425b;

    /* renamed from: c, reason: collision with root package name */
    private final View f304426c;

    /* renamed from: d, reason: collision with root package name */
    private final Consumer<Boolean> f304427d;

    /* renamed from: e, reason: collision with root package name */
    private final String f304428e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f304429f;

    public TVideoFloatingWindowController(@NonNull TVideoQFSVideoView tVideoQFSVideoView, @NonNull Consumer<Boolean> consumer, @NonNull Video video, @NonNull String str) {
        this.f304424a = tVideoQFSVideoView;
        this.f304427d = consumer;
        this.f304428e = str;
        if (tVideoQFSVideoView != null && tVideoQFSVideoView.getQCirclePlayer() != null) {
            this.f304425b = (ViewGroup) tVideoQFSVideoView.getParent();
            this.f304426c = tVideoQFSVideoView.getQCirclePlayer().getVideoView();
        } else {
            this.f304426c = null;
        }
        l(video);
    }

    private void c() {
        QLog.i("TVideoFloatingWindowController", 1, "enterFloatingWindow");
        Activity activity = (Activity) this.f304424a.getContext();
        if (!h.l().f(activity)) {
            QLog.i("TVideoFloatingWindowController", 1, "no floating permission");
            return;
        }
        m();
        i();
        boolean g16 = h.l().g(activity, this.f304424a);
        k();
        if (g16) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSTVideoFloatingWindowStatusEvent(0));
            QLog.i("TVideoFloatingWindowController", 1, "backToSplashActivity");
            j.b(activity);
            k.a().n("tvideo_floating_window_last_time_key", System.currentTimeMillis());
            if ("page_ugqqoa_sec_play".equals(this.f304428e)) {
                SimpleEventBus.getInstance().dispatchEvent(new TVideoMultiTabPageFinishEvent());
                return;
            }
            return;
        }
        QLog.i("TVideoFloatingWindowController", 1, "enterFloatingWindow fail");
        g();
    }

    private void g() {
        QLog.i("TVideoFloatingWindowController", 1, "quitFloatingWindow");
        ViewGroup viewGroup = this.f304425b;
        if (viewGroup != null && viewGroup.indexOfChild(this.f304424a) < 0) {
            m();
            i();
            QLog.i("TVideoFloatingWindowController", 1, "addView");
            this.f304425b.addView(this.f304424a, 0, new ViewGroup.LayoutParams(-1, -1));
            k();
        }
    }

    private void j() {
        VideoReport.reportEvent("imp_end", this.f304425b, new HashMap<String, String>() { // from class: com.tencent.mobileqq.tvideo.floatingwindow.TVideoFloatingWindowController.5
            {
                String str;
                if (TVideoFloatingWindowController.this.f304429f) {
                    str = "auto";
                } else {
                    str = QCircleDaTongConstant.ElementParamValue.MANUAL;
                }
                put("float_screen_type", str);
            }
        });
    }

    private void k() {
        KeyEvent.Callback callback = this.f304426c;
        if (callback instanceof ISPlayerVideoView) {
            ((ISPlayerVideoView) callback).enableViewCallback();
        } else if (callback instanceof TVKPlayerVideoView) {
            ((TVKPlayerVideoView) callback).resumeSurfaceTexture();
        }
    }

    private void l(Video video) {
        ViewGroup viewGroup = this.f304425b;
        if (viewGroup != null) {
            VideoReport.setElementId(viewGroup, "virtual_float_screen");
            VideoReport.setElementExposePolicy(this.f304425b, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(this.f304425b, ClickPolicy.REPORT_NONE);
            VideoReport.setElementParams(this.f304425b, gy2.c.i(video));
        }
    }

    private void m() {
        KeyEvent.Callback callback = this.f304426c;
        if (callback instanceof ISPlayerVideoView) {
            ((ISPlayerVideoView) callback).disableViewCallback();
        } else if (callback instanceof TVKPlayerVideoView) {
            ((TVKPlayerVideoView) callback).storeSurfaceTexture();
        }
    }

    public void b() {
        QLog.i("TVideoFloatingWindowController", 1, "handleDestroyEvent");
        j.j();
        h.l().u();
    }

    public void d(QFSTVideoFloatingWindowEvent qFSTVideoFloatingWindowEvent) {
        QLog.i("TVideoFloatingWindowController", 1, "handleFloatingWindowEvent:" + qFSTVideoFloatingWindowEvent.isEnterFloatingWindow());
        TVideoQFSVideoView tVideoQFSVideoView = this.f304424a;
        if (tVideoQFSVideoView != null && this.f304425b != null && tVideoQFSVideoView.getSuperPlayer() != null) {
            if (qFSTVideoFloatingWindowEvent.isEnterFloatingWindow()) {
                this.f304429f = qFSTVideoFloatingWindowEvent.isAuto();
                c();
            } else {
                g();
            }
        }
    }

    public void e(QFSTVideoFloatingWindowPlayEvent qFSTVideoFloatingWindowPlayEvent) {
        QLog.i("TVideoFloatingWindowController", 1, "handleFloatingWindowPlayEvent");
        if (this.f304427d == null) {
            return;
        }
        if (qFSTVideoFloatingWindowPlayEvent.isPlaying()) {
            QLog.i("TVideoFloatingWindowController", 1, "notify start play");
            this.f304427d.accept(Boolean.TRUE);
        } else {
            QLog.i("TVideoFloatingWindowController", 1, "notify pause play");
            this.f304427d.accept(Boolean.FALSE);
        }
    }

    public void f(QFSTVideoFloatingWindowStatusEvent qFSTVideoFloatingWindowStatusEvent) {
        int status = qFSTVideoFloatingWindowStatusEvent.getStatus();
        if (status != 0) {
            if (status != 1) {
                if (status != 2) {
                    if (status == 3) {
                        VideoReport.reportEvent("clck", this.f304425b, new HashMap<String, String>() { // from class: com.tencent.mobileqq.tvideo.floatingwindow.TVideoFloatingWindowController.4
                            {
                                String str;
                                put("button_type", "close");
                                if (TVideoFloatingWindowController.this.f304429f) {
                                    str = "auto";
                                } else {
                                    str = QCircleDaTongConstant.ElementParamValue.MANUAL;
                                }
                                put("float_screen_type", str);
                            }
                        });
                        j();
                        return;
                    }
                    return;
                }
                VideoReport.reportEvent("clck", this.f304425b, new HashMap<String, String>() { // from class: com.tencent.mobileqq.tvideo.floatingwindow.TVideoFloatingWindowController.3
                    {
                        String str;
                        put("button_type", "start");
                        if (TVideoFloatingWindowController.this.f304429f) {
                            str = "auto";
                        } else {
                            str = QCircleDaTongConstant.ElementParamValue.MANUAL;
                        }
                        put("float_screen_type", str);
                    }
                });
                return;
            }
            VideoReport.reportEvent("clck", this.f304425b, new HashMap<String, String>() { // from class: com.tencent.mobileqq.tvideo.floatingwindow.TVideoFloatingWindowController.2
                {
                    String str;
                    put("button_type", "go_back");
                    if (TVideoFloatingWindowController.this.f304429f) {
                        str = "auto";
                    } else {
                        str = QCircleDaTongConstant.ElementParamValue.MANUAL;
                    }
                    put("float_screen_type", str);
                }
            });
            j();
            return;
        }
        VideoReport.reportEvent("imp", this.f304425b, new HashMap<String, String>() { // from class: com.tencent.mobileqq.tvideo.floatingwindow.TVideoFloatingWindowController.1
            {
                String str;
                if (TVideoFloatingWindowController.this.f304429f) {
                    str = "auto";
                } else {
                    str = QCircleDaTongConstant.ElementParamValue.MANUAL;
                }
                put("float_screen_type", str);
            }
        });
    }

    public boolean h() {
        boolean r16 = h.l().r();
        QLog.i("TVideoFloatingWindowController", 1, "isInFloatingWindowMode:" + r16);
        return r16;
    }

    public void i() {
        TVideoQFSVideoView tVideoQFSVideoView = this.f304424a;
        if (tVideoQFSVideoView != null && tVideoQFSVideoView.getParent() != null) {
            QLog.i("TVideoFloatingWindowController", 1, "removePlayViewFromParent");
            ((ViewGroup) this.f304424a.getParent()).removeView(this.f304424a);
        }
    }
}

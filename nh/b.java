package nh;

import android.widget.SeekBar;
import com.qzone.reborn.feedx.video.QZonePlayer;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.Iterator;
import java.util.List;
import lh.d;
import lh.e;
import lh.f;
import lh.h;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {
    public static void a(com.qzone.reborn.feedx.video.c cVar, ISuperPlayer iSuperPlayer) {
        try {
            List<lh.a> i3 = cVar.b().i();
            if (i3 != null && i3.size() > 0) {
                Iterator<lh.a> it = i3.iterator();
                while (it.hasNext()) {
                    it.next().onCompletion(iSuperPlayer);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(cVar.s(), RFWLog.CLR, "dispatch onCompletion() error " + e16);
        }
    }

    public static void b(com.qzone.reborn.feedx.video.c cVar, QZonePlayer qZonePlayer) {
        try {
            List<e> m3 = cVar.b().m();
            if (m3 != null && m3.size() > 0) {
                Iterator<e> it = m3.iterator();
                while (it.hasNext()) {
                    it.next().b(qZonePlayer);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(cVar.s(), RFWLog.CLR, "dispatch onFirstFrameRendered() error " + e16);
        }
    }

    public static void c(com.qzone.reborn.feedx.video.c cVar, QZonePlayer qZonePlayer) {
        try {
            List<f> n3 = cVar.b().n();
            if (n3 != null && n3.size() > 0) {
                Iterator<f> it = n3.iterator();
                while (it.hasNext()) {
                    it.next().a(qZonePlayer);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(cVar.s(), RFWLog.CLR, "dispatch onInitSuccess() error " + e16);
        }
    }

    public static void d(com.qzone.reborn.feedx.video.c cVar, String str, int i3, int i16) {
        try {
            List<h> o16 = cVar.b().o();
            if (o16 != null && o16.size() > 0) {
                Iterator<h> it = o16.iterator();
                while (it.hasNext()) {
                    it.next().onProgress(str, i3, i16);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(cVar.s(), RFWLog.CLR, "dispatch onSeekBarProgressChanged() error " + e16);
        }
    }

    public static void e(com.qzone.reborn.feedx.video.c cVar, SeekBar seekBar, int i3, boolean z16) {
        try {
            List<h> o16 = cVar.b().o();
            if (o16 != null && o16.size() > 0) {
                Iterator<h> it = o16.iterator();
                while (it.hasNext()) {
                    it.next().onSeekBarProgressChanged(seekBar, i3, z16);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(cVar.s(), RFWLog.CLR, "dispatch onSeekBarProgressChanged() error " + e16);
        }
    }

    public static void f(com.qzone.reborn.feedx.video.c cVar, SeekBar seekBar) {
        try {
            List<h> o16 = cVar.b().o();
            if (o16 != null && o16.size() > 0) {
                Iterator<h> it = o16.iterator();
                while (it.hasNext()) {
                    it.next().onStartTrackingTouch(seekBar);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(cVar.s(), RFWLog.CLR, "dispatch onStartTrackingTouch() error " + e16);
        }
    }

    public static void g(com.qzone.reborn.feedx.video.c cVar, SeekBar seekBar) {
        try {
            List<h> o16 = cVar.b().o();
            if (o16 != null && o16.size() > 0) {
                Iterator<h> it = o16.iterator();
                while (it.hasNext()) {
                    it.next().onStopTrackingTouch(seekBar);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(cVar.s(), RFWLog.CLR, "dispatch onStopTrackingTouch() error " + e16);
        }
    }

    public static void h(com.qzone.reborn.feedx.video.c cVar) {
        try {
            List<lh.c> k3 = cVar.b().k();
            if (k3 != null && k3.size() > 0) {
                Iterator<lh.c> it = k3.iterator();
                while (it.hasNext()) {
                    it.next().onVideoLoopEnd();
                }
            }
        } catch (Exception e16) {
            RFWLog.e(cVar.s(), RFWLog.CLR, "dispatch onVideoLoopEnd() error " + e16);
        }
    }

    public static void i(com.qzone.reborn.feedx.video.c cVar) {
        try {
            List<lh.c> k3 = cVar.b().k();
            if (k3 != null && k3.size() > 0) {
                Iterator<lh.c> it = k3.iterator();
                while (it.hasNext()) {
                    it.next().onVideoLoopStart();
                }
            }
        } catch (Exception e16) {
            RFWLog.e(cVar.s(), RFWLog.CLR, "dispatch onVideoLoopStart() error " + e16);
        }
    }

    public static void j(com.qzone.reborn.feedx.video.c cVar, int i3, int i16, long j3, long j16, long j17) {
        try {
            List<d> l3 = cVar.b().l();
            if (l3 != null && l3.size() > 0) {
                Iterator<d> it = l3.iterator();
                while (it.hasNext()) {
                    it.next().onVideoPassivePause(i3, i16, j3, j16, j17);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(cVar.s(), RFWLog.CLR, "dispatch onVideoPassivePause() error " + e16);
        }
    }

    public static void k(com.qzone.reborn.feedx.video.c cVar, int i3, int i16, int i17, String str) {
        try {
            List<lh.b> j3 = cVar.b().j();
            if (j3 != null && j3.size() > 0) {
                Iterator<lh.b> it = j3.iterator();
                while (it.hasNext()) {
                    it.next().onVideoPlayError(i3, i16, i17, str);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(cVar.s(), RFWLog.CLR, "dispatch onVideoPlayError() error " + e16);
        }
    }

    public static void l(com.qzone.reborn.feedx.video.c cVar, QZonePlayer qZonePlayer) {
        try {
            List<e> m3 = cVar.b().m();
            if (m3 != null && m3.size() > 0) {
                Iterator<e> it = m3.iterator();
                while (it.hasNext()) {
                    it.next().a(qZonePlayer);
                }
            }
        } catch (Exception e16) {
            RFWLog.e(cVar.s(), RFWLog.CLR, "dispatch onVideoPrepared() error " + e16);
        }
    }
}

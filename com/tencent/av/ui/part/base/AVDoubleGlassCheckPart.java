package com.tencent.av.ui.part.base;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class AVDoubleGlassCheckPart extends nw.a {

    /* renamed from: e, reason: collision with root package name */
    private Timer f76192e = null;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<VideoAppInterface> f76193f;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<Context> f76194h;

    private void Q9() {
        if (this.f76193f == null) {
            return;
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.av.ui.part.base.AVDoubleGlassCheckPart.3
            @Override // java.lang.Runnable
            public void run() {
                if (AVDoubleGlassCheckPart.this.f76193f == null || r.h0() == null || n.e().f() == null) {
                    return;
                }
                String string = ea.V1(((VideoAppInterface) AVDoubleGlassCheckPart.this.f76193f.get()).getCurrentAccountUin()).getString(AppConstants.Preferences.AV_WEAK_NET_VIDEO_CONFIG_CONTENT, "");
                if (string.length() == 0) {
                    QLog.d(((nw.a) AVDoubleGlassCheckPart.this).f421444d, 1, "cannot Read avWeaknetConfig");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    if (jSONObject.has("ground_glass_switch_android")) {
                        if (jSONObject.getInt("ground_glass_switch_android") == 1) {
                            n.e().f().T1 = true;
                        }
                        if (jSONObject.has("ground_glass_default_interval")) {
                            n.e().f().V1 = jSONObject.getInt("ground_glass_default_interval");
                        }
                        if (jSONObject.has("ground_glass_default_timeout_rule")) {
                            n.e().f().W1 = jSONObject.getInt("ground_glass_default_timeout_rule");
                        }
                        if (QLog.isDevelopLevel()) {
                            QLog.d(((nw.a) AVDoubleGlassCheckPart.this).f421444d, 1, "AsyncReadDoubleGlassConfig mIsGlassCanUse=" + n.e().f().T1 + ", mCurrentVideoGlassWaitTime=" + n.e().f().V1 + ", mCurrentDefaultTimeOutRule=" + n.e().f().W1);
                        }
                        if (!n.e().f().T1 || n.e().f().V1 <= 0) {
                            return;
                        }
                        AVDoubleGlassCheckPart.this.S9(true);
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }, 16, null, false, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S9(boolean z16) {
        synchronized (this) {
            Timer timer = this.f76192e;
            if (timer != null) {
                timer.cancel();
                this.f76192e = null;
                QLog.w(this.f421444d, 1, "StartGlassCheck, cancel old Timer");
            }
            this.f76192e = new BaseTimer();
        }
        TimerTask timerTask = new TimerTask(z16) { // from class: com.tencent.av.ui.part.base.AVDoubleGlassCheckPart.2

            /* renamed from: d, reason: collision with root package name */
            boolean f76195d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f76196e;

            {
                this.f76196e = z16;
                this.f76195d = z16;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                SessionInfo f16;
                final long j3;
                VideoLayerUI videoLayerUI;
                try {
                } catch (Exception e16) {
                    QLog.e(((nw.a) AVDoubleGlassCheckPart.this).f421444d, 1, "StartGlassCheck exception " + e16);
                }
                if (AVDoubleGlassCheckPart.this.f76193f == null || r.h0() == null || (f16 = n.e().f()) == null) {
                    return;
                }
                if (f16.V1 <= 0) {
                    synchronized (this) {
                        if (AVDoubleGlassCheckPart.this.f76192e != null) {
                            AVDoubleGlassCheckPart.this.f76192e.cancel();
                            AVDoubleGlassCheckPart.this.f76192e = null;
                        }
                    }
                    QLog.w(((nw.a) AVDoubleGlassCheckPart.this).f421444d, 1, "StartGlassCheck, cancel cur Timer");
                    return;
                }
                try {
                    AVDoubleGlassCheckPart aVDoubleGlassCheckPart = AVDoubleGlassCheckPart.this;
                    AVActivity x95 = aVDoubleGlassCheckPart.x9(aVDoubleGlassCheckPart.f76194h);
                    j3 = (x95 == null || (videoLayerUI = x95.J0) == null) ? 0L : videoLayerUI.x0(n.e().f().f73091w);
                } catch (Exception e17) {
                    QLog.w(((nw.a) AVDoubleGlassCheckPart.this).f421444d, 1, "StartGlassCheck, Exception", e17);
                    j3 = 0;
                }
                final long currentTimeMillis = System.currentTimeMillis();
                if (j3 == 0) {
                    return;
                }
                long j16 = currentTimeMillis - j3;
                QLog.w(((nw.a) AVDoubleGlassCheckPart.this).f421444d, 1, "StartGlassCheck, interval[" + j16 + "], mCheck[" + this.f76195d + "], mCurrentDoubleVideoGlassSwitch[" + n.e().f().U1 + "]");
                if (j16 > n.e().f().V1 * 1000 && this.f76195d) {
                    ((VideoAppInterface) AVDoubleGlassCheckPart.this.f76193f.get()).runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.part.base.AVDoubleGlassCheckPart.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (r.h0() == null || n.e().f() == null) {
                                return;
                            }
                            SessionInfo f17 = n.e().f();
                            QLog.w(((nw.a) AVDoubleGlassCheckPart.this).f421444d, 1, "StartGlassCheck, lCurrent[" + currentTimeMillis + "], lLastTickFinal[" + j3 + "], VideoGlassWaitTime[" + f17.V1 + "], DefaultTimeOutRule[" + f17.W1 + "], GlassSwitch[" + f17.U1 + "]");
                            if (!AVDoubleGlassCheckPart.this.R9(f17.W1) || n.e().f().U1 == 0) {
                                return;
                            }
                            AVDoubleGlassCheckPart.this.S9(false);
                        }
                    });
                    return;
                } else {
                    if (n.e().f().U1 == 0 || j16 >= 1000) {
                        return;
                    }
                    ((VideoAppInterface) AVDoubleGlassCheckPart.this.f76193f.get()).runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.part.base.AVDoubleGlassCheckPart.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean R9 = AVDoubleGlassCheckPart.this.R9(0);
                            QLog.w(((nw.a) AVDoubleGlassCheckPart.this).f421444d, 1, "StartGlassCheck  \u53d6\u6d88, ret[" + R9 + "]");
                        }
                    });
                    return;
                }
                QLog.e(((nw.a) AVDoubleGlassCheckPart.this).f421444d, 1, "StartGlassCheck exception " + e16);
            }
        };
        if (QLog.isDevelopLevel()) {
            QLog.w(this.f421444d, 1, "StartGlassCheck, begin Timer, bCheck[" + z16 + "]");
        }
        synchronized (this) {
            Timer timer2 = this.f76192e;
            if (timer2 != null) {
                timer2.schedule(timerTask, z16 ? 1000L : 10000L);
            }
        }
    }

    public boolean R9(int i3) {
        SessionInfo f16;
        AVActivity aVActivity;
        VideoLayerUI videoLayerUI;
        if (this.f76193f == null || r.h0() == null || (f16 = n.e().f()) == null || !f16.T1) {
            return false;
        }
        if (!f16.O) {
            QLog.w(this.f421444d, 1, "setGlassSwitch, Remote not has video, GlassSwitch[" + i3 + "]");
            return false;
        }
        if (QLog.isDevelopLevel() || f16.U1 != i3) {
            QLog.w(this.f421444d, 1, "setGlassSwitch, GlassSwitch[" + f16.U1 + "->" + i3 + "]");
        }
        if (f16.U1 == i3) {
            return false;
        }
        f16.U1 = i3;
        WeakReference<Context> weakReference = this.f76194h;
        if (weakReference == null || weakReference.get() == null || (aVActivity = (AVActivity) this.f76194h.get()) == null || (videoLayerUI = aVActivity.J0) == null) {
            return false;
        }
        if (i3 != 0) {
            if (i3 == 1) {
                videoLayerUI.s0();
                cw.e.n(this.f76193f.get(), 3013);
            } else if (i3 != 2) {
                if (i3 == 3) {
                    videoLayerUI.s0();
                    cw.e.n(this.f76193f.get(), 1039);
                }
            }
            return true;
        }
        videoLayerUI.r0();
        cw.e.d(this.f76193f.get(), 3013);
        return true;
    }

    @Override // nw.a
    public void onDestroy() {
        super.onDestroy();
        synchronized (this) {
            Timer timer = this.f76192e;
            if (timer != null) {
                timer.cancel();
                this.f76192e = null;
            }
        }
    }

    @Override // nw.a, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        z9(getContext(), nw.b.b());
        super.onInitView(view);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        onDestroy();
    }

    public void onResume() {
        if (this.f76193f == null || r.h0() == null || r.h0() == null) {
            return;
        }
        SessionInfo f16 = n.e().f();
        if (f16 != null && f16.T1) {
            this.f76193f.get().M().postDelayed(new Runnable() { // from class: com.tencent.av.ui.part.base.AVDoubleGlassCheckPart.1
                @Override // java.lang.Runnable
                public void run() {
                    AVDoubleGlassCheckPart aVDoubleGlassCheckPart = AVDoubleGlassCheckPart.this;
                    AVActivity x95 = aVDoubleGlassCheckPart.x9(aVDoubleGlassCheckPart.f76194h);
                    if (x95 == null || x95.isDestroyed() || AVDoubleGlassCheckPart.this.f76193f == null) {
                        return;
                    }
                    int i3 = n.e().f().U1;
                    QLog.w(((nw.a) AVDoubleGlassCheckPart.this).f421444d, 1, "onResume, setGlass, nCurrentSwitch[" + i3 + "]");
                    ((VideoAppInterface) AVDoubleGlassCheckPart.this.f76193f.get()).k0(new Object[]{42, Integer.valueOf(i3)});
                    AVDoubleGlassCheckPart.this.S9(true);
                }
            }, 200L);
            return;
        }
        String str = this.f421444d;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onResume, AsyncReadDoubleGlassConfig, mVideoController[");
        sb5.append(r.h0() != null);
        sb5.append("]");
        QLog.w(str, 1, sb5.toString());
        Q9();
    }

    @Override // nw.a
    public void z9(Context context, AppInterface appInterface) {
        super.z9(context, appInterface);
        this.f76194h = new WeakReference<>(context);
        this.f76193f = new WeakReference<>((VideoAppInterface) appInterface);
    }
}

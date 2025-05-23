package com.tencent.mobileqq.kandian.base.video.plugin;

import android.os.Handler;
import android.os.Message;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.video.VideoDeviceInfoHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import t52.c;
import t52.d;
import t52.e;

/* loaded from: classes33.dex */
public class VideoPluginInstall implements v52.a {

    /* renamed from: e, reason: collision with root package name */
    private static boolean f239171e;

    /* renamed from: a, reason: collision with root package name */
    private boolean f239172a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mobileqq.kandian.base.video.plugin.a f239173b;

    /* renamed from: d, reason: collision with root package name */
    private Handler f239175d = new Handler(new a());

    /* renamed from: c, reason: collision with root package name */
    private d f239174c = e.INSTANCE.c();

    /* loaded from: classes33.dex */
    private static class SDKInstallListener implements c {

        /* renamed from: a, reason: collision with root package name */
        private Handler f239176a;

        public SDKInstallListener(Handler handler) {
            this.f239176a = handler;
        }

        private void c(final boolean z16, final int i3) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall.SDKInstallListener.1
                @Override // java.lang.Runnable
                public void run() {
                    String valueOf;
                    String str;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("version", AppSetting.f99551k);
                        if (!z16) {
                            jSONObject.put("error_code", i3);
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    if (z16) {
                        valueOf = "";
                    } else {
                        valueOf = String.valueOf(i3);
                    }
                    if (z16) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    String str2 = str;
                    PublicAccountReportUtils.l(null, null, "0X8009753", "0X8009753", 0, 0, str2, VideoDeviceInfoHelper.h(), valueOf, jSONObject.toString(), false);
                    if (z16) {
                        return;
                    }
                    PublicAccountReportUtils.l(null, null, "0X8009752", "0X8009752", 0, 0, str2, VideoDeviceInfoHelper.h(), valueOf, jSONObject.toString(), false);
                }
            }, 16, null, true);
        }

        @Override // t52.c
        public void a(int i3) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_READINJOY_VIDEO, 2, "onInstalledFailed: code=" + i3);
            }
            c(false, i3);
            Handler handler = this.f239176a;
            if (handler != null) {
                handler.sendEmptyMessage(1);
            }
        }

        @Override // t52.c
        public void b() {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TAG_READINJOY_VIDEO, 2, "onInstalledSuccessed: ");
            }
            c(true, 0);
            Handler handler = this.f239176a;
            if (handler != null) {
                handler.sendEmptyMessage(0);
            }
        }
    }

    /* loaded from: classes33.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 0) {
                VideoPluginInstall.this.f239172a = false;
                VideoPluginInstall.this.f239175d.removeMessages(0);
                if (VideoPluginInstall.this.f239173b != null) {
                    VideoPluginInstall.this.f239173b.a(true);
                }
            } else if (i3 == 1) {
                VideoPluginInstall.this.f239172a = false;
                VideoPluginInstall.this.f239175d.removeMessages(1);
                if (VideoPluginInstall.this.f239173b != null) {
                    VideoPluginInstall.this.f239173b.a(false);
                }
            } else if (i3 == 2) {
                VideoPluginInstall.this.f239172a = true;
            }
            return true;
        }
    }

    public VideoPluginInstall() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall.1
            @Override // java.lang.Runnable
            public void run() {
                VideoPluginInstall.this.h();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        synchronized (this) {
            if (!f239171e) {
                this.f239174c.a();
                f239171e = true;
            }
        }
    }

    public void i() {
        if (j() || this.f239172a) {
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall.2
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_READINJOY_VIDEO, 2, "start install video sdk in subThread");
                }
                if (!VideoPluginInstall.f239171e) {
                    VideoPluginInstall.this.h();
                }
                try {
                    VideoPluginInstall.this.f239174c.c(new SDKInstallListener(VideoPluginInstall.this.f239175d));
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(LogTag.TAG_READINJOY_VIDEO, 2, "VideoSDKMgr.installPlugin ERROR e=" + e16.getMessage());
                    }
                }
            }
        }, 8, null, true);
    }

    public boolean j() {
        return this.f239174c.b();
    }

    public void k(com.tencent.mobileqq.kandian.base.video.plugin.a aVar) {
        this.f239173b = aVar;
    }

    public void g() {
        this.f239173b = null;
        this.f239175d.removeCallbacksAndMessages(null);
    }
}

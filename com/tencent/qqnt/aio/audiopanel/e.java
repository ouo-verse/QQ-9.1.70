package com.tencent.qqnt.aio.audiopanel;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.audiopanel.e;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes34.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final int f349690a = com.tencent.mobileqq.utils.x.a(44.0f);

    /* renamed from: b, reason: collision with root package name */
    public static final int f349691b = Color.parseColor("#666666");

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public interface a {
        void onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void b(TextView textView) {
        if (SimpleUIUtil.isNowElderMode()) {
            textView.setTextColor(f349691b);
            textView.setTextSize(22.0f);
        }
    }

    private static boolean c() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_audio_panel_play_sound_before_9020_118106402", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(a aVar, MediaPlayer mediaPlayer) {
        if (QLog.isColorLevel()) {
            QLog.d("AudioPanelUtils", 2, "mediaPlayerStart with OnStartRecordListener onCompletion");
        }
        if (aVar != null) {
            aVar.onStart();
        }
    }

    public static void e(int i3, final a aVar) {
        if (!c()) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioPanelUtils", 2, "mediaPlayerStart with OnStartRecordListener return, play_before_switch is off");
            }
            if (aVar != null) {
                aVar.onStart();
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AudioPanelUtils", 2, "mediaPlayerStart with OnStartRecordListener resId = " + i3);
        }
        AudioUtil.q(i3, 1, new MediaPlayer.OnCompletionListener() { // from class: com.tencent.qqnt.aio.audiopanel.d
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                e.d(e.a.this, mediaPlayer);
            }
        }, new Handler(Looper.getMainLooper()));
    }

    public static void f(int i3, String str) {
        if (c()) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioPanelUtils", 2, "mediaPlayerStart with path return, play_before_switch is on");
            }
        } else {
            if (str == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AudioPanelUtils", 2, "mediaPlayerStart with path resId = " + i3);
            }
            AudioUtil.k(i3);
        }
    }

    public static void g(View view) {
        float f16 = FontSettingManager.systemMetrics.density / view.getContext().getResources().getDisplayMetrics().density;
        view.setScaleX(f16);
        view.setScaleY(f16);
    }

    public static void h() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_audio_panel_stop_media_player_manager_8985_116101849", false)) {
            if (QLog.isColorLevel()) {
                QLog.d("AudioPanelUtils", 2, "stopMediaPlayerManager return, switch is off");
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("AudioPanelUtils", 2, "stopMediaPlayerManager switch is on");
            }
            MediaPlayerManager mediaPlayerManager = (MediaPlayerManager) MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.MGR_MEDIA_PLAYER);
            if (mediaPlayerManager.t()) {
                ReportController.o(null, "dc00898", "", "", "0X800C391", "0X800C391", 4, 0, "", "", "", "");
            }
            mediaPlayerManager.D(true);
        }
    }
}

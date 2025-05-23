package com.tencent.mobileqq.listentogether.player;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* loaded from: classes15.dex */
public class QQMusicPlayReport {
    public static void a(final boolean z16, final int i3) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.listentogether.player.QQMusicPlayReport.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                HashMap<String, String> hashMap = new HashMap<>();
                if (z16) {
                    str = "1";
                } else {
                    str = "0";
                }
                hashMap.put("qqmusicplay_report_key_play_cache", str);
                hashMap.put("qqmusicplay_report_key_net_type", String.valueOf(i3));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "qqmusicplay_report_tag_play_cache", true, 0L, 0L, hashMap, "");
                QLog.isColorLevel();
            }
        }, 5, null, false);
    }

    public static void b(final boolean z16, final int i3) {
        final int networkType = NetworkUtil.getNetworkType(null);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.listentogether.player.QQMusicPlayReport.3
            @Override // java.lang.Runnable
            public void run() {
                String str;
                HashMap<String, String> hashMap = new HashMap<>();
                if (z16) {
                    str = "1";
                } else {
                    str = "0";
                }
                hashMap.put("qqmusicplay_report_key_play_cache", str);
                hashMap.put("qqmusicplay_report_key_net_type", String.valueOf(networkType));
                hashMap.put("qqmusicplay_report_key_seek_count_per_song", String.valueOf(i3));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "qqmusicplay_report_tag_seek_count_per_song", true, 0L, 0L, hashMap, "");
                QLog.isColorLevel();
            }
        }, 5, null, false);
    }

    public static void c(final int i3, final int i16) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.listentogether.player.QQMusicPlayReport.2
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("qqmusicplay_report_key_seek_delay", String.valueOf(i3));
                hashMap.put("qqmusicplay_report_key_net_type", String.valueOf(i16));
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "qqmusicplay_report_tag_seek_delay", true, 0L, 0L, hashMap, "");
                QLog.isColorLevel();
            }
        }, 5, null, false);
    }
}

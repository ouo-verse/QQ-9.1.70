package com.tencent.qqmini.miniapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsListener;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes23.dex */
public class WebProcessReceiver extends BroadcastReceiver {
    public static final String ACTION_DOWNLOAD_TBS = "action_download_tbs";
    public static final AtomicBoolean S_TBS_DOWNLOADING = new AtomicBoolean(false);
    public static final String TAG = "WebProcessReceiver";

    public void downloadTbs(Context context, boolean z16, boolean z17, boolean z18) {
        if (S_TBS_DOWNLOADING.compareAndSet(false, true)) {
            final long currentTimeMillis = System.currentTimeMillis();
            final SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 4);
            QbSdk.setTbsListener(new TbsListener() { // from class: com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.2
                @Override // com.tencent.smtt.sdk.TbsListener
                public void onDownloadFinish(int i3) {
                    QMLog.d("TBS_update", "tbs download finish result=" + i3);
                    if (i3 != 100 && i3 != 120 && i3 != 122) {
                        if (WebProcessReceiver.S_TBS_DOWNLOADING.compareAndSet(true, false)) {
                            QbSdk.setTbsListener(null);
                            int i16 = sharedPreferences.getInt("tbs_download_count", 0) + 1;
                            long j3 = sharedPreferences.getLong("tbs_download_cost", 0L) + (System.currentTimeMillis() - currentTimeMillis);
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putInt("tbs_download_count", i16);
                            edit.putLong("tbs_download_cost", j3);
                            edit.commit();
                            if (QMLog.isColorLevel()) {
                                QMLog.d("TBS_update", "tbs download aborted:" + i3);
                            }
                        }
                        SharedPreferences.Editor edit2 = sharedPreferences.edit();
                        edit2.putInt("tbs_download_complete", i3);
                        edit2.remove("tbs_downloading");
                        edit2.remove("tbs_download_progress");
                        edit2.commit();
                    }
                }

                @Override // com.tencent.smtt.sdk.TbsListener
                public void onDownloadProgress(int i3) {
                    if (QMLog.isColorLevel()) {
                        QMLog.d("TBS_update", "tbs download progress " + i3);
                    }
                }

                @Override // com.tencent.smtt.sdk.TbsListener
                public void onInstallFinish(int i3) {
                    QMLog.d("TBS_update", "tbs download install finish result=" + i3);
                    if (i3 != 200 && WebProcessReceiver.S_TBS_DOWNLOADING.compareAndSet(true, false)) {
                        QbSdk.setTbsListener(null);
                        if (i3 != 232 && i3 != 220) {
                            int i16 = sharedPreferences.getInt("tbs_download_count", 0) + 1;
                            long j3 = sharedPreferences.getLong("tbs_download_cost", 0L) + (System.currentTimeMillis() - currentTimeMillis);
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putInt("tbs_download_count", i16);
                            edit.putLong("tbs_download_cost", j3);
                            edit.commit();
                            QMLog.d("TBS_update", "tbs install error:" + i3);
                        } else {
                            sharedPreferences.getInt("tbs_download_count", 0);
                            sharedPreferences.getLong("tbs_download_cost", 0L);
                            System.currentTimeMillis();
                            SharedPreferences.Editor edit2 = sharedPreferences.edit();
                            edit2.remove("tbs_download_count");
                            edit2.remove("tbs_download_cost");
                            edit2.commit();
                            QMLog.d("TBS_update", "tbs install finished:" + i3);
                        }
                        SharedPreferences.Editor edit3 = sharedPreferences.edit();
                        edit3.putInt("tbs_download_complete", i3);
                        edit3.remove("tbs_downloading");
                        edit3.remove("tbs_download_progress");
                        edit3.commit();
                    }
                }
            });
            QMLog.d("TBS_update", "tbs start download");
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("tbs_downloading", true);
            edit.remove("tbs_download_complete");
            edit.remove("tbs_download_progress");
            edit.commit();
            TbsDownloader.startDownload(context, z17);
        }
        QMLog.d("TBS_update", "tbs has started downloading");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        String action;
        boolean z16;
        if (intent != null && (action = intent.getAction()) != null) {
            QMLog.d(TAG, "action=" + action);
            if (ACTION_DOWNLOAD_TBS.equals(action)) {
                if ("1|1".charAt(0) == '1') {
                    z16 = true;
                } else {
                    z16 = false;
                }
                final boolean booleanExtra = intent.getBooleanExtra("isDownloadForeground", false);
                final boolean booleanExtra2 = intent.getBooleanExtra("fromMiniApp", false);
                if (z16) {
                    ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (TbsDownloader.needDownload(context, booleanExtra)) {
                                WebProcessReceiver.this.downloadTbs(context, false, booleanExtra, !booleanExtra2);
                            }
                        }
                    });
                }
            }
        }
    }
}

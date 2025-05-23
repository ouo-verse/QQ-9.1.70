package com.qzone.preview.service;

import android.content.Intent;
import cooperation.qzone.util.QZLog;
import mqq.app.AppService;

/* loaded from: classes39.dex */
public class PictureProcessBootService extends AppService {
    private static final String TAG = "PictureProcessBootService";

    @Override // mqq.app.AppService, android.app.Service
    public final void onCreate() {
        super.onCreate();
        if (QZLog.isColorLevel()) {
            QZLog.i(TAG, 2, "qzone picture process onCreate");
        }
        PictureManager.getInstance();
    }

    @Override // android.app.Service
    @Deprecated
    public void onStart(Intent intent, int i3) {
        super.onStart(intent, i3);
        if (QZLog.isColorLevel()) {
            QZLog.i(TAG, 2, "qzone picture process onStart");
        }
    }
}

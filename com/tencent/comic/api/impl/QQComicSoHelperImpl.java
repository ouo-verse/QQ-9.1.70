package com.tencent.comic.api.impl;

import com.tencent.comic.api.IQQComicSoHelper;
import com.tencent.comic.i;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QQComicSoHelperImpl implements IQQComicSoHelper {
    public static final String TAG = "QQComicSoHelperImpl";

    @Override // com.tencent.comic.api.IQQComicSoHelper
    public String getComicPlayerSoPath() {
        return i.a() + "libqgplayer_841.so";
    }

    @Override // com.tencent.comic.api.IQQComicSoHelper
    public String getComicPlayerSoZipPath() {
        return i.a() + "libQGamePlayer.zip";
    }

    @Override // com.tencent.comic.api.IQQComicSoHelper
    public void onSoDownloadCompleted(AppRuntime appRuntime, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onSoDownloadCompleted: code=" + i3);
        }
        i.c(appRuntime, i3);
    }
}

package com.tencent.biz.common.offline;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Messenger;
import com.tencent.mobileqq.utils.NetworkUtil;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DownloadService extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    Messenger f78397a = null;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (NetworkUtil.isWifiEnabled(context)) {
            BidDownloader.n();
        }
    }
}

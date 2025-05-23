package com.qzone.reborn.feedx.part.detail;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;

/* compiled from: P */
/* loaded from: classes37.dex */
public class d extends aa {

    /* renamed from: m, reason: collision with root package name */
    private BroadcastReceiver f55167m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            d.this.Z9(intent);
        }
    }

    private void aa() {
        this.f55167m = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(QZoneJsConstants.BROADCAST_ACTION_BLOG_SHARE_DATA);
        QZLog.i("QZoneFeedxBlogDetailSharePanelPart", "registerReceiver");
        getActivity().registerReceiver(this.f55167m, intentFilter);
    }

    @Override // com.qzone.reborn.feedx.part.detail.aa, gf.f
    public boolean I1() {
        return true;
    }

    @Override // com.qzone.reborn.feedx.part.detail.aa, gf.f
    public TouchWebView getWebView() {
        Object broadcastGetMessage = broadcastGetMessage("BLOG_DETAIL_GET_WEBVIEW", null);
        if (broadcastGetMessage instanceof TouchWebView) {
            return (TouchWebView) broadcastGetMessage;
        }
        return null;
    }

    @Override // com.qzone.reborn.feedx.part.detail.aa, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        aa();
    }

    @Override // com.qzone.reborn.feedx.part.detail.aa, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        if (this.f55167m != null) {
            QZLog.i("QZoneFeedxBlogDetailSharePanelPart", "unregisterReceiver");
            getActivity().unregisterReceiver(this.f55167m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z9(Intent intent) {
        if (intent == null || !intent.getAction().equals(QZoneJsConstants.BROADCAST_ACTION_BLOG_SHARE_DATA) || this.f55148d == null) {
            return;
        }
        QZLog.i("QZoneFeedxBlogDetailSharePanelPart", "share_data:" + intent.getStringExtra(QZoneShareManager.KEY_SAHRE_DATA));
        this.f55148d.l0(intent.getStringExtra(QZoneShareManager.KEY_SAHRE_DATA));
    }
}

package com.tencent.smtt.sdk;

import android.content.Intent;
import android.net.Uri;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes23.dex */
public class b implements com.tencent.smtt.export.external.interfaces.DownloadListener {

    /* renamed from: a, reason: collision with root package name */
    private DownloadListener f369286a;

    /* renamed from: b, reason: collision with root package name */
    private WebView f369287b;

    public b(WebView webView, DownloadListener downloadListener, boolean z16) {
        this.f369286a = downloadListener;
        this.f369287b = webView;
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadStart(String str, String str2, byte[] bArr, String str3, String str4, String str5, long j3, String str6, String str7) {
        DownloadListener downloadListener = this.f369286a;
        if (downloadListener == null) {
            if (QbSdk.canOpenMimeFileType(this.f369287b.getContext(), str5)) {
                Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
                intent.setFlags(268435456);
                intent.putExtra("key_reader_sdk_url", str);
                intent.putExtra("key_reader_sdk_type", 1);
                intent.setData(Uri.parse(str));
                this.f369287b.getContext().startActivity(intent);
                return;
            }
            return;
        }
        downloadListener.onDownloadStart(str, str3, str4, str5, j3);
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j3) {
        onDownloadStart(str, null, null, str2, str3, str4, j3, null, null);
    }

    @Override // com.tencent.smtt.export.external.interfaces.DownloadListener
    public void onDownloadVideo(String str, long j3, int i3) {
    }
}

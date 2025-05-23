package com.qq.e.comm.pi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.ValueCallback;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface TGWebViewListener {
    void onLoadError(String str, int i3, String str2);

    void onLoadSuccess(String str);

    void onOverrideUrlLoading(String str);

    void onPageFinished(String str);

    void onPageStarted(String str, Bitmap bitmap);

    void onProgressChanged(int i3);

    void onReceivedError(int i3, String str, String str2);

    void onReceivedHttpError(int i3, String str);

    void onReceivedTitle(String str);

    boolean onShowFileChooser(ValueCallback<Uri[]> valueCallback, Intent intent);

    void onThirdAppLaunched();

    void openFileChooser(ValueCallback<Uri> valueCallback, Intent intent);
}

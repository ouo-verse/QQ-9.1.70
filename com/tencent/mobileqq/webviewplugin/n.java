package com.tencent.mobileqq.webviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.mobileqq.widget.QQProgressDialog;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface n extends y {
    void destroy();

    <T> T getShare();

    QQProgressDialog getSharePD();

    String getShareUrl();

    void reset();

    boolean setShareUrl(String str);

    boolean setSummary(String str, String str2, String str3, String str4, Bundle bundle);

    boolean shareStructMsgForH5(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
}

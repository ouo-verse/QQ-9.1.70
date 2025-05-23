package com.tencent.qcircle.shadow.core.runtime;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class ShadowWebViewLayoutInflater extends FixedContextLayoutInflater {
    private static final String AndroidWebView = "android.webkit.WebView";
    private static final String ShadowPackagePrefix = "com.tencent.shadow.core.runtime.";
    private static final String ShadowWebView = "ShadowWebView";

    public ShadowWebViewLayoutInflater(LayoutInflater layoutInflater, Context context) {
        super(layoutInflater, context);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.FixedContextLayoutInflater
    Pair<String, String> changeViewNameAndPrefix(String str, String str2) {
        if (AndroidWebView.equals(str + str2)) {
            str = ShadowPackagePrefix;
            str2 = ShadowWebView;
        }
        return new Pair<>(str2, str);
    }
}

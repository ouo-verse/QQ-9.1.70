package com.tencent.xweb;

import android.net.Uri;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface WebResourceRequest {
    String getMethod();

    Map<String, String> getRequestHeaders();

    Uri getUrl();

    boolean hasGesture();

    boolean isForMainFrame();

    boolean isRedirect();
}

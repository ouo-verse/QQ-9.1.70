package com.tencent.tdf.embed;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface EmbeddedView {
    public static final IPatchRedirector $redirector_ = null;

    void dispose();

    View getView();

    Bitmap makeSnapshot();

    void onAttached();

    void onDetached();

    void updateProps(Map<String, String> map);
}

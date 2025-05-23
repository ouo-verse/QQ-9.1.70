package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class b {
    static IPatchRedirector $redirector_ = null;
    public static final int ITEM_TYPE_AUDIO = 2;
    public static final int ITEM_TYPE_MUSIC = 3;
    public static final int ITEM_TYPE_NONE = 0;
    public static final int ITEM_TYPE_PIC = 1;
    public static final int ITEM_TYPE_VIDEO = 4;
    protected static final String TAG = "publish_mediaInfo";

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract String getJsonText();

    public abstract View getView(Context context, View.OnClickListener onClickListener);
}

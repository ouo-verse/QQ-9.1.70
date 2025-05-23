package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.shortcutbar.ShortcutBarInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g extends com.tencent.mobileqq.troop.adapter.base.c {
    static IPatchRedirector $redirector_;
    public TextView C;
    public ShortcutBarInfo D;

    /* renamed from: h, reason: collision with root package name */
    public LinearLayout f298757h;

    /* renamed from: i, reason: collision with root package name */
    public URLImageView f298758i;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f298759m;

    public g(Context context, View view) {
        super(context, view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) view);
        }
    }
}

package com.tencent.mobileqq.qqlive.widget.chat.util;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/util/c;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c extends RecyclerView.RecycledViewPool {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        setMaxRecycledViews(1, 20);
        setMaxRecycledViews(1, 20);
        setMaxRecycledViews(2, 20);
        setMaxRecycledViews(4, 5);
        setMaxRecycledViews(3, 10);
        setMaxRecycledViews(5, 20);
        setMaxRecycledViews(100, 20);
        setMaxRecycledViews(102, 5);
        setMaxRecycledViews(7, 20);
    }
}

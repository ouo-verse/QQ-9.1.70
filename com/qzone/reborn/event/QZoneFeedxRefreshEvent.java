package com.qzone.reborn.event;

import android.content.Context;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/event/QZoneFeedxRefreshEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "isScrollToTop", "", "()Z", "setScrollToTop", "(Z)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneFeedxRefreshEvent extends SimpleBaseEvent {
    private Context context;
    private boolean isScrollToTop;

    public final Context getContext() {
        return this.context;
    }

    /* renamed from: isScrollToTop, reason: from getter */
    public final boolean getIsScrollToTop() {
        return this.isScrollToTop;
    }

    public final void setContext(Context context) {
        this.context = context;
    }

    public final void setScrollToTop(boolean z16) {
        this.isScrollToTop = z16;
    }
}

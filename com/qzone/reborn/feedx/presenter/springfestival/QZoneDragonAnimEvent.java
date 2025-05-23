package com.qzone.reborn.feedx.presenter.springfestival;

import android.content.Context;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/springfestival/QZoneDragonAnimEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "feedUniKey", "", "isPraise", "", "context", "Landroid/content/Context;", "(Ljava/lang/String;ZLandroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getFeedUniKey", "()Ljava/lang/String;", "setFeedUniKey", "(Ljava/lang/String;)V", "()Z", "setPraise", "(Z)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneDragonAnimEvent extends SimpleBaseEvent {
    private Context context;
    private String feedUniKey;
    private boolean isPraise;

    public QZoneDragonAnimEvent(String str, boolean z16, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.feedUniKey = str;
        this.isPraise = z16;
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getFeedUniKey() {
        return this.feedUniKey;
    }

    /* renamed from: isPraise, reason: from getter */
    public final boolean getIsPraise() {
        return this.isPraise;
    }

    public final void setContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.context = context;
    }

    public final void setFeedUniKey(String str) {
        this.feedUniKey = str;
    }

    public final void setPraise(boolean z16) {
        this.isPraise = z16;
    }
}

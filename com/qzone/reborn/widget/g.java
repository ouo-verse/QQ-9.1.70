package com.qzone.reborn.widget;

import android.content.Context;
import android.view.View;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/widget/g;", "Lcom/tencent/mobileqq/widget/selectorview/a;", "", "timeMillis", "", "M", "K", "Landroid/view/View;", "L", "Landroid/content/Context;", "context", "", "title", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class g extends com.tencent.mobileqq.widget.selectorview.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, String title) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        k(title);
        F(1970);
    }

    public final long K() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(D(), B() - 1, A());
        return calendar.getTimeInMillis();
    }

    public final View L() {
        return this.f317413c;
    }

    public final void M(long timeMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMillis);
        E(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
    }
}

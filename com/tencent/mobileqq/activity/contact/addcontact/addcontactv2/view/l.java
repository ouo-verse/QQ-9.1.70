package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view;

import android.content.Context;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/k;", "data", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "a", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class l {
    @NotNull
    public static final QUIEmptyState a(@NotNull Context context, @NotNull k data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        QUIEmptyState.Builder builder = new QUIEmptyState.Builder(context);
        builder.setImageType(data.c());
        builder.setTitle(data.d());
        boolean z16 = true;
        builder.setHalfScreenState(true);
        builder.setBackgroundColorType(0);
        if (data.b().length() <= 0) {
            z16 = false;
        }
        if (z16) {
            builder.setDesc(data.b());
        }
        if (data.a() != null) {
            builder.setButton(data.a().b(), data.a().a());
        }
        return builder.build();
    }
}

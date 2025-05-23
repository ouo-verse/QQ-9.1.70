package com.tencent.mobileqq.zplan.aio.guidance;

import android.content.Context;
import android.util.TypedValue;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u00a8\u0006\u0004"}, d2 = {"Landroid/content/Context;", "", "value", "b", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final float b(Context context, float f16) {
        return TypedValue.applyDimension(1, f16, context.getResources().getDisplayMetrics());
    }
}

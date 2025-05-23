package com.tencent.mobileqq.troop.troopsetting.activity;

import android.app.Activity;
import com.tencent.mobileqq.app.QBaseActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u00a8\u0006\u0003"}, d2 = {"Landroid/app/Activity;", "", "a", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {
    public static final int a(@Nullable Activity activity) {
        QBaseActivity qBaseActivity;
        if (activity == null) {
            return 0;
        }
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity == null) {
            return 0;
        }
        return qBaseActivity.getTitleBarHeight();
    }
}

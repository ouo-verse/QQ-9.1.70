package com.tencent.mobileqq.aio.factory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"Landroid/content/Context;", "context", "", "a", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    public static final int a(@NotNull Context context) {
        Activity activity;
        boolean z16;
        Intent intent;
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null && (intent = activity.getIntent()) != null) {
            z16 = intent.getBooleanExtra("key_is_scale_chat", false);
        } else {
            z16 = false;
        }
        QLog.i("AIOFactory", 1, "getMsgListHeadPadding isScale: " + z16);
        return AIOUtil.f194084a.m(context, z16, false);
    }
}

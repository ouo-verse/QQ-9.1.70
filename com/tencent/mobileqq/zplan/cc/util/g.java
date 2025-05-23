package com.tencent.mobileqq.zplan.cc.util;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/util/g;", "", "Landroid/content/Context;", "context", "", "a", "Landroid/content/SharedPreferences;", "b", "Landroid/content/SharedPreferences;", "sp", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f332561a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static SharedPreferences sp;

    g() {
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (sp == null) {
            sp = context.getApplicationContext().getSharedPreferences("com_tencent_mobileqq_zplan_cc_camera", 4);
        }
    }
}
